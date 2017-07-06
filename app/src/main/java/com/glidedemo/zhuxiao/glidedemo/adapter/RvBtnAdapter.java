package com.glidedemo.zhuxiao.glidedemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.glidedemo.zhuxiao.glidedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuxiao on 2016/5/10.
 */
public class RvBtnAdapter extends RecyclerView.Adapter {
    private List<ItemBean> dataList = new ArrayList<ItemBean>();
    private onRvItemClickListener onRvItemClickListener;
    public int currentPosition = 0;
    public RvBtnAdapter( List<ItemBean> dataList) {
        this.dataList = dataList;
    }

    public static class ViewHolder1 extends RecyclerView.ViewHolder{
        public TextView tvTitle;
        public ViewHolder1(View view){
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
        }
    }
    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_btn, null);
        return  new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder1 holder1= (ViewHolder1) holder;
        ItemBean itemBean = dataList.get(position);
        holder1.tvTitle.setText(""+itemBean.title);
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = position;
                if(onRvItemClickListener!=null){onRvItemClickListener.rvItemClick(v,position);}
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnRvItemClickListener(RvBtnAdapter.onRvItemClickListener onRvItemClickListener) {
        this.onRvItemClickListener = onRvItemClickListener;
    }

    public interface onRvItemClickListener{
        void rvItemClick(View view,int pos);
    }

    public static class ItemBean{
        public int id;
        public String title;

        public ItemBean(int id, String title) {
            this.id = id;
            this.title = title;
        }
    }
}
