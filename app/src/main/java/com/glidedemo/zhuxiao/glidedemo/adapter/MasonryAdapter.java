package com.glidedemo.zhuxiao.glidedemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.Target;
import com.glidedemo.zhuxiao.glidedemo.Bean.GiphyBean;
import com.glidedemo.zhuxiao.glidedemo.R;
import com.glidedemo.zhuxiao.glidedemo.Threadlib.ProgressBarRunnable;
import com.glidedemo.zhuxiao.glidedemo.utils.Constants;
import com.glidedemo.zhuxiao.glidedemo.utils.ThreadPoolUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView> {
    private List<GiphyBean.DataBean> products;
    private Context mCtx;

    public MasonryAdapter(List<GiphyBean.DataBean> list, Context ctx) {
        products = list;
        mCtx = ctx;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo, viewGroup, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, final int position) {
//        GiphyBean.DataBean.ImagesBean.FixedWidthSmallStillBean bean = products.get(position).getImages().getFixed_width_small_still();
        GiphyBean.DataBean.ImagesBean.FixedWidthSmallBean bean = products.get(position).getImages().getFixed_width_small();
        mIvWidth = bean.getWidth();
        mIvHeight = bean.getHeight();
        url = bean.getUrl();
        GiphyBean.DataBean.ImagesBean.FixedWidthSmallBean fixed_width_small = products.get(position).getImages().getFixed_width_small();
        /**
         * Glide加载缩略图 两种方式：一种是直接.thumbnail( 0.1f ) 设置缩略图是原图的0.1倍， 第二种是获取缩略图设置上去
         */
        DrawableRequestBuilder<String> builder = Glide.with(mCtx)
                .load(fixed_width_small.getUrl())
                .override(Integer.parseInt(fixed_width_small.getWidth()), Integer.parseInt(fixed_width_small.getHeight()));
        Target<GlideDrawable> target = Glide.with(mCtx)
                .load(url)
                .thumbnail(builder)
                .crossFade()
                .override(Integer.parseInt(mIvWidth), Integer.parseInt(mIvHeight))
                .into(masonryView.imageView);
        String[] nameArr = bean.getUrl().split("/");
        mIvName = nameArr[nameArr.length - 1];
        masonryView.textView.setText("UN" + position + ":" + products.get(position).getUsername() + position);

        masonryView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //根据不同的position 获取不同的model
                GiphyBean.DataBean.ImagesBean.DownsizedBean bean = products.get(position).getImages().getDownsized();
                url = bean.getUrl();
                mIvWidth = bean.getWidth();
                mIvHeight = bean.getHeight();
                String[] nameArr = bean.getUrl().split("/");
                mIvName = nameArr[nameArr.length - 1];
                File fileDectory = new File(PHOTO_URL + File.separator);
                fileDectory.mkdirs();
                saveUrlFile = new File(fileDectory, position + mIvName);
                if (Constants.DEBUG) {
                    Log.d("SaveFile:", "savePath:" + saveUrlFile);
                    Log.d("SaveFile:", "url:" + url);
                    Log.d("SaveFile:", "position2:" + position);
                }
                if (saveUrlFile.exists()) {
                    Toast.makeText(mCtx, "this photo exist", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(mCtx, "Photo copy to:" + saveUrlFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                ThreadPoolUtil.getInstance().executeTaskBySingleThreadPool(new ProgressBarRunnable() {
                    @Override
                    public void pRun() {
                        //获取file 复制到 gallery
                        FutureTarget<File> fileFutureTarget = Glide
                                .with(mCtx)
                                .load(url)
                                .downloadOnly(Integer.parseInt(mIvWidth), Integer.parseInt(mIvHeight));
                        InputStream is = null;
                        OutputStream os = null;
                        try {
                            File file = fileFutureTarget.get();
                            is = new FileInputStream(file);
                            os = new FileOutputStream(saveUrlFile);
                            //写入
                            byte[] buffer = new byte[1024];
                            int len = 0;
                            while ((len = is.read(buffer)) > 0) {
                                os.write(buffer, 0, len);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (is != null) {
                                try {
                                    is.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (os != null) {
                                try {
                                    os.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class MasonryView extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_logo);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public interface onRvItemClickListener {
        void onRvItemClick(int pos);
    }

//    private onRvItemClickListener onRvItemClickListener;
//
//    public void setOnRvItemClickListener(MasonryAdapter.onRvItemClickListener onRvItemClickListener) {
//        this.onRvItemClickListener = onRvItemClickListener;
//    }

    String mIvWidth;
    String mIvHeight;
    String mIvName;
    String url;
    File saveUrlFile;
//    private final String PHOTO_URL = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
    private final String PHOTO_URL ="/storage/emulated/0/GildeDemo";
}