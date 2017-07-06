package com.glidedemo.zhuxiao.glidedemo;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.glidedemo.zhuxiao.glidedemo.Bean.GiphyBean;
import com.glidedemo.zhuxiao.glidedemo.adapter.MasonryAdapter;
import com.glidedemo.zhuxiao.glidedemo.adapter.RvBtnAdapter;
import com.glidedemo.zhuxiao.glidedemo.fragment.FragmentTemplate;
import com.glidedemo.zhuxiao.glidedemo.handler.HandlerThreadExecutor;
import com.glidedemo.zhuxiao.glidedemo.net.RequestUtils;
import com.glidedemo.zhuxiao.glidedemo.utils.CommonUtils;
import com.glidedemo.zhuxiao.glidedemo.utils.Constants;
import com.glidedemo.zhuxiao.glidedemo.utils.FragmentFactory;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements FragmentTemplate.OnFragmentInteractionListener, RvBtnAdapter.onRvItemClickListener {
    private static final String TAG = "MainActivity";
    private static final boolean isDebug = Constants.DEBUG;
    private List<RvBtnAdapter.ItemBean> dataList = new ArrayList<>();
    private List<String> dataList2 = new ArrayList<>();
    @InjectView(R.id.rv_btn)
    RecyclerView mRvBtn;
    private RvBtnAdapter mRvBtnAdapter;
    private RecyclerView mRvGiphyPhotos;
    private MasonryAdapter mMasonryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        if (isDebug) {
            Log.e(TAG, "MainActivity onCreate");
        }
        intitView();
    }

    private void intitView() {
        initData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
        mRvBtn.setLayoutManager(linearLayoutManager);
        mRvBtnAdapter = new RvBtnAdapter(dataList);
        mRvBtnAdapter.setOnRvItemClickListener(this);
        mRvBtn.setAdapter(mRvBtnAdapter);
        mRvBtn.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        dataList.add(new RvBtnAdapter.ItemBean(R.layout.fragment_fragment_template, "FROM REMOTE NET LOAD"));
        dataList.add(new RvBtnAdapter.ItemBean(R.layout.fragment_fragment_template2, "FROM LOCAL RES LOAD"));
        dataList.add(new RvBtnAdapter.ItemBean(R.layout.fragment_fragment_template3, "FROM LOCAL FILE RES LOAD"));
        dataList.add(new RvBtnAdapter.ItemBean(R.layout.fragment_fragment_template4, "FROM LOCAL Uri LOAD"));
        dataList.add(new RvBtnAdapter.ItemBean(R.layout.fragment_fragment_template5, "LOAD GIF FROM Giphy"));
        dataList.add(new RvBtnAdapter.ItemBean(R.layout.fragment_fragment_template6, "GlidDemo6"));
        //initData2
        initData2();
    }

    private void initData2() {
        dataList2.add("http://i.imgur.com/DvpvklR.png");
        dataList2.add("http://pic.duowan.com/lol/1107/175605585726/175605656648.jpg");
        dataList2.add("http://pic.duowan.com/lol/1107/175605585726/175605649348.jpg");
        dataList2.add("http://pic.duowan.com/lol/1107/175605585726/175605637273.jpg");
        dataList2.add("http://img.sgamer.com/dota2_sgamer_com/images/20141219/120aebbf789a1e75c185123f40fd68fc.png");
        dataList2.add("http://himg2.huanqiu.com/attachment2010/2014/0124/20140124044206964.jpg");
    }


    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    /**
     * fragment initView
     *
     * @param layOutResId
     */
    @Override
    public void onInitViewAction(int layOutResId) {
        FragmentTemplate fragment = FragmentFactory.getInstance().findFragmentByLayoutId(layOutResId);
        View rootView = fragment.getView();
        String URL = dataList2.get( mRvBtnAdapter.currentPosition);
        switch (layOutResId) {
            case R.layout.fragment_fragment_template: {//url
                ImageView ivCase = (ImageView) rootView.findViewById(R.id.iv_case);
                Glide.with(fragment)
                        .load(URL)
                        .placeholder(R.mipmap.photo_load)
                        .into(ivCase);
                break;
            }
            case R.layout.fragment_fragment_template2:// resid
            {
                ImageView ivCase = (ImageView) rootView.findViewById(R.id.iv_case);
                Glide.with(fragment)
                        .load(R.mipmap.default_icon)
                        .into(ivCase);
                break;
            }
            case R.layout.fragment_fragment_template3://File
            {
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "default_icon.jpg");
                if(isDebug){
                    Log.d(TAG,"file:"+file.getAbsolutePath()+",isExist:"+file.isFile());
                }
                ImageView ivCase = (ImageView) rootView.findViewById(R.id.iv_case);
                Glide.with(fragment)
                        .load(file)
                        .into(ivCase);
                break;
            }
            case R.layout.fragment_fragment_template4://Uri
            {
                Uri uri = CommonUtils.resourceIdToUri(MainActivity.this,R.mipmap.api_giphy_header);
//                Uri.decode() //将八进制 解码 为特殊字符
                ImageView ivCase = (ImageView) rootView.findViewById(R.id.iv_case);
                Glide.with(fragment)
                        .load(uri)
                        .into(ivCase);
                break;
            }
            case R.layout.fragment_fragment_template5://Load Gif From Giphy Library
            {
                initFragment5(rootView);
                break;
            }
            case R.layout.fragment_fragment_template6://
            {
                ImageView ivCase = (ImageView) rootView.findViewById(R.id.iv_case);
                Glide.with(fragment)
                        .load(URL)
                        .placeholder(R.mipmap.photo_load)
                        .into(ivCase);
                break;
            }
        }
    }
    private List<GiphyBean.DataBean> data5 = new ArrayList<>();
    private void initFragment5(View rootView) {
        initData5();
        mRvGiphyPhotos = ButterKnife.findById(rootView, R.id.rv_giphy_photos);
        final EditText editText = ButterKnife.findById(rootView, R.id.et_content);
        Button btn_search = ButterKnife.findById(rootView, R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重置 分页参数
                query = editText.getEditableText().toString();
                offset=0;
                data5.clear();
                initData5();
            }
        });
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//解决错乱
        mRvGiphyPhotos.setLayoutManager(staggeredGridLayoutManager);
        mMasonryAdapter = new MasonryAdapter(data5, MainActivity.this);
        mRvGiphyPhotos.setAdapter(mMasonryAdapter);
        mRvGiphyPhotos.setItemAnimator(null);//
//        mRvGiphyPhotos.setHasFixedSize(true);

        //rv滚动监听
        mRvGiphyPhotos.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private boolean isSlideUp=false;
            /**
             * Callback method to be invoked when the RecyclerView has been scrolled. This will be
             * called after the scroll has completed.
             * <p/>
             * This callback will also be called if visible item range changes after a layout
             * calculation. In that case, dx and dy will be 0.
             *
             * @param recyclerView The RecyclerView which scrolled.
             * @param dx           The amount of horizontal scroll.
             * @param dy           The amount of vertical scroll.
             */
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                isSlideUp =  dy>0?true:false;
            }

            /**
             * Callback method to be invoked when RecyclerView's scroll state changes.
             *
             * @param recyclerView The RecyclerView whose scroll state has changed.
             * @param newState     The updated scroll state. One of
             */
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                StaggeredGridLayoutManager layoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                if(newState == RecyclerView.SCROLL_STATE_IDLE)//idle
                {
                    int[] arr = layoutManager.findLastCompletelyVisibleItemPositions(null);
                    int itemCount = layoutManager.getItemCount();
                    if((arr[0]==(itemCount-1) || arr[1]==(itemCount-1))&&isSlideUp){
                        //request next page
                        offset+=limit;
                        initData5();
                    }
                }
            }
        });
    }

    private String threadName="thread1";
    private final int minMsg=1;
    int maxMsg=10;
    long quitDelta=10000;
    int limit=15;
    int offset=0;
    String query="funny+cat";
    private String requestUrl5  = "http://api.giphy.com/v1/gifs/search?api_key=dc6zaTOxFJmzC";
//    private String requestUrl5  = "http://api.giphy.com/v1/gifs/search";
    HandlerThreadExecutor mhandler = new HandlerThreadExecutor(threadName,minMsg,maxMsg,quitDelta){
        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            switch (what){
                case minMsg:{
                    String url =requestUrl5;
                    if(query!=null)
                        url+="&q="+query;
                    if(limit>0)
                        url+="&limit="+limit;
                    if(offset>0)
                        url+="&offset="+offset;

                    final String result = new RequestUtils().requestStr(url, null, RequestUtils.GET_NAME);
                    if(isDebug){
                        Log.d(TAG,"result:"+result);
                    }
                    GiphyBean giphyBean = new Gson().fromJson(result, GiphyBean.class);
                    data5.addAll(giphyBean.getData());
                    MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mMasonryAdapter.notifyDataSetChanged();
                                }
                            });
                    break;
                }
            }
        }
    };

    private void initData5() {
        mhandler.sendEmptyMessage(minMsg);
    }

    @Override
    public void rvItemClick(View view, int pos) {
        RvBtnAdapter.ItemBean itemBean = dataList.get(pos);
        itemClick(itemBean.id);
    }

    private void itemClick(int id) {
        FragmentTemplate instance = FragmentFactory.getInstance().findFragmentByLayoutId(id);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.rl_content, instance);//相同的id替换不了
        transaction.commit();
    }
}
