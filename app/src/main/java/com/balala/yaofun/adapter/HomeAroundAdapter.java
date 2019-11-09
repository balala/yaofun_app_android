package com.balala.yaofun.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.balala.yaofun.R;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class HomeAroundAdapter extends RecyclerView.Adapter<HomeAroundAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeAllBean.DataBean.AroundBean> aroundBeans;
    private HomeAdapter.OnClickListener mListener;
    private HomeAdapter.OnClickListenerBanner mListenerBanner;

    public HomeAroundAdapter(Context context, ArrayList<HomeAllBean.DataBean.AroundBean> aroundBeans) {
        this.context = context;
        this.aroundBeans = aroundBeans;
    }

    @NonNull
    @Override
    public HomeAroundAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_item2s, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAroundAdapter.ViewHolder holder, int position) {
        holder.homeitem2_distance.setText(aroundBeans.get(position).getLocation());
        holder.homeitem2_title.setText(aroundBeans.get(position).getTitle());
        holder.homeitem2_time.setText(aroundBeans.get(position).getStart_end_time());
        holder.homeitem2_site.setText(aroundBeans.get(position).getLocation_name());
        holder.homeitem2_distance.setText(aroundBeans.get(position).getLocation());
        String location = aroundBeans.get(position).getLocation();
        // 位置多少米
        Log.i("xuzhiqilocation", "onBindViewHolder: " + location);
        double costs = aroundBeans.get(position).getCost();
        String cost = String.valueOf(costs);
        if (cost.equals("0.0") || cost.isEmpty()) {
            holder.homeitem2_price.setText("FREE");
        } else {
            holder.homeitem2_priceyuan.setVisibility(View.VISIBLE);
            holder.homeitem2_price.setText(cost);
        }

        if (location.equals("")) {
            holder.homeitem2_distance.setText("无距离");
        }
        Glide.with(context).load(aroundBeans.get(position).getCover()).apply(RequestOptions.bitmapTransform(new RoundedCorners(10))).into(holder.homeitem2_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.OnClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i("适配器长度", "getItemCount: "+aroundBeans.size());

        return aroundBeans.size();


    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView homeitem2_img;
        private final TextView homeitem2_title;
        private final TextView homeitem2_time;
        private final TextView homeitem2_price;
        private final TextView homeitem2_site;
        private final TextView homeitem2_distance;
        private final TextView homeitem2_priceyuan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            homeitem2_img = itemView.findViewById(R.id.homeitem2_img);
            homeitem2_title = itemView.findViewById(R.id.homeitem2_title);
            homeitem2_time = itemView.findViewById(R.id.homeitem2_time);
            homeitem2_site = itemView.findViewById(R.id.homeitem2_site);
            homeitem2_price = itemView.findViewById(R.id.homeitem2_price);
            homeitem2_priceyuan = itemView.findViewById(R.id.homeitem2_priceyuan);
            homeitem2_distance = itemView.findViewById(R.id.homeitem2_distance);

        }
    }

    public interface OnClickListener {
        void OnClick(int position);
    }

    public void setOnClickListener(HomeAdapter.OnClickListener listener) {

        mListener = listener;
    }

//    public interface OnClickListenerBanner {
//        void OnClick(int position);
//    }
//
//    public void setOnClickListenerBanner(HomeAdapter.OnClickListenerBanner listener) {
//
//        mListenerBanner = listener;
//    }
}
