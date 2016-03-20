package com.wangdong.damai.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wangdong.damai.R;
import com.wangdong.damai.bean.HomeLocalListViewObj1;

import java.util.List;

/**
 * Created by wd794 on 2016/3/19 0019.
 */
public class HomeLocalListViewAdapter extends BaseAdapter {
    private List<HomeLocalListViewObj1.ListEntity> entityList;
    private LayoutInflater inflater;
    private Context context;

    public HomeLocalListViewAdapter(List<HomeLocalListViewObj1.ListEntity> entityList
            , Context context) {
        this.entityList = entityList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return entityList == null ? 0 : entityList.size();
    }

    @Override
    public Object getItem(int position) {
        return entityList == null ? null : entityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("wangdong28", "getView: " + entityList.toString());
        Log.i("wangdong25", "getView: " + position);
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item__home_local_listview, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_home_local_item);
            viewHolder.ivZuo = (ImageView) convertView.findViewById(R.id.iv_local_listview_zuo);
            viewHolder.tvPalce = (TextView) convertView.findViewById(R.id.tv_local_listview_place);
            viewHolder.tvSaleZuo = (TextView) convertView.findViewById(R.id.tv_local_listview_zuostate);
            viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tv_local_listview_time);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_local_listview_title);
            viewHolder.tvPrice = (TextView) convertView.findViewById(R.id.tv_local_listview_price);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvPalce.setText("场馆：" + entityList.get(position).getVenName());
        viewHolder.tvTitle.setText(entityList.get(position).getName());
        viewHolder.tvTime.setText("时间：" + entityList.get(position).getShowTime());
        if (entityList.get(position).getIsXuanZuo() == 0) {
            viewHolder.ivZuo.setVisibility(View.GONE);
        }
        viewHolder.tvPrice.setText("票价：" + entityList.get(position).getPriceName());
        Log.i("wangdong26", "getView: "+entityList.get(position).getSiteStatus());
        if (entityList.get(position).getSiteStatus() == 8) {
            viewHolder.tvSaleZuo.setText("预售中");
            viewHolder.tvSaleZuo.setBackgroundResource(R.drawable.shoupiao2shaper);

        }else {
            viewHolder.tvSaleZuo.setText("售票中");
            viewHolder.tvSaleZuo.setBackgroundResource(R.drawable.shoupiaoshaper);
        }
        int p2 = entityList.get(position).getProjectID();
        int p1 = p2 / 100;
        String url = "http://pimg.damai.cn/perform/project/" + p1 + "/" + p2 + "_n.jpg";
        Picasso.with(context).load(url).into(viewHolder.imageView);
        return convertView;
    }

    class ViewHolder {
        TextView tvTitle;
        TextView tvSaleZuo;
        TextView tvTime;
        TextView tvPalce;
        TextView tvPrice;
        ImageView imageView;
        ImageView ivZuo;
    }
}
