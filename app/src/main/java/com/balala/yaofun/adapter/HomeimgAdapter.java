package com.balala.yaofun.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.balala.yaofun.R;
import com.balala.yaofun.bean.result.HomeBannerDean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeimgAdapter extends RecyclerView.Adapter<HomeimgAdapter.ViewHolder> {
    private final List<HomeBannerDean.DataBean.FirstBean> first;

    private Context context;
    private HomeAdapter.OnClickListener mListener;
    private HomeAdapter.OnClickListenerBanner mListenerBanner;

    public HomeimgAdapter(Context context, List<HomeBannerDean.DataBean.FirstBean> first) {
        this.first = first;
        this.context = context;
    }


    @NonNull
    @Override
    public HomeimgAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeimgAdapter.ViewHolder holder, int position) {
        Picasso.with(context).load(first.get(position).getCover()).into(holder.banners_item);
//        .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
        Log.i("dadada", "onBindViewHolder: " + first.get(position).getCover());
        holder.banners_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener!=null){
                    mListener.OnClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return first.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView banners_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banners_item = itemView.findViewById(R.id.banners_item);

        }
    }
    public interface OnClickListener {
        void OnClick(int position);
    }

    public void setOnClickListener(HomeAdapter.OnClickListener listener) {

        mListener = listener;
    }

    public interface OnClickListenerBanner {
        void OnClick(int position);

        void OnClick(View v, int position);
    }

    public void setOnClickListenerBanner(HomeAdapter.OnClickListenerBanner listener) {

        mListenerBanner = listener;
    }
}
