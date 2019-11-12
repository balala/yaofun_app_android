package com.balala.yaofun.adapter;

import android.content.Context;
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

import java.util.ArrayList;

public class Homesecondadapter extends RecyclerView.Adapter<Homesecondadapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeBannerDean.DataBean.SecondBean> beanArrayList;
    private HomeAdapter.OnClickListener mListener;
    private HomeAdapter.OnClickListenerBanner mListenerBanner;

    public Homesecondadapter(Context context, ArrayList<HomeBannerDean.DataBean.SecondBean> beanArrayList) {
        this.context = context;
        this.beanArrayList = beanArrayList;
    }

    @NonNull
    @Override
    public Homesecondadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Homesecondadapter.ViewHolder holder, int position) {
        Glide.with(context).load(beanArrayList.get(position).getCover())
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.banners_item);
    }

    @Override
    public int getItemCount() {
        return beanArrayList.size();
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
