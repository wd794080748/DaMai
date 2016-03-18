package com.wangdong.damai.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wangdong.damai.R;
import com.wangdong.damai.bean.HomeRecyclerView;

import java.util.List;

/**
 * Created by wd794 on 2016/3/18 0018.
 */
public class HomeRecyclerViewAdapter extends
        RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<HomeRecyclerView> recyclerViewList;
    private Context context;
    public HomeRecyclerViewAdapter(Context context,List<HomeRecyclerView> recyclerViewList) {
        this.inflater=LayoutInflater.from(context);
        this.recyclerViewList=recyclerViewList;
        this.context=context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_home_recyclerview,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String url=recyclerViewList.get(position).getUrl();
        Picasso.with(context).load(url).into(holder.imageView);
        holder.textView.setText(recyclerViewList.get(position).getTitle()+"");
    }

    @Override
    public int getItemCount() {
        return recyclerViewList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.tv_item_recyclerview);
            imageView=(ImageView)itemView.findViewById(R.id.iv_item_recyclerview);

        }
    }
}
