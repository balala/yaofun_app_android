package com.balala.yaofun.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.balala.yaofun.R;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.balala.yaofun.bean.result.HomeBannerDean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {
    private final List<HomeBannerDean.DataBean.FirstBean> ban;
    private Context context;
    private ArrayList<HomeAllBean.DataBean.HotBean> homeAllBeans;
    private OnClickListener mListener;
    private OnClickListenerBanner mListenerBanner;


    public HomeAdapter(Context context, ArrayList<HomeAllBean.DataBean.HotBean> homeAllBeans, List<HomeBannerDean.DataBean.FirstBean> first) {
        this.context = context;
        this.homeAllBeans = homeAllBeans;
        this.ban = first;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == 3) {
            View banner = inflater.inflate(R.layout.banner_item, null);
            holder = new BannerHolder(banner);
        } else {
            View inflate = inflater.inflate(R.layout.home_item1s, null);
            holder = new ViewHolder(inflate);
        }
        return (ViewHolder) holder;
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 3) {
            BannerHolder banq = (HomeAdapter.BannerHolder) holder;
            banq.banner_item.setImages(ban);
            banq.banner_item.setImageLoader(new MyLoder());
            banq.banner_item.start();
            Banner banner = ((BannerHolder) holder).banner_item.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    if (mListenerBanner != null) {
                        mListenerBanner.OnClick(position);
                    }
                }
            });
//            Log.i("banner", "onBindViewHolder: "+banner);
            banq.banner_item.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 10);
                }
            });

            banq.banner_item.setClipToOutline(true);
        } else {

            if (homeAllBeans != null && !homeAllBeans.isEmpty()) {
                int pos = (position - 3) < 0 ? 0 : (position - 3);
                ViewHolder holder1 = (ViewHolder) holder;
                Log.i("热门解析", "热门解析: " + homeAllBeans.toString());
                holder1.item1time.setText(homeAllBeans.get(pos).getStart_end_time());
                holder1.item1title.setText(homeAllBeans.get(pos).getTitle());
                double costs = homeAllBeans.get(pos).getCost();
                String cost = String.valueOf(costs);
                holder1.item1price.setText(cost);
                holder1.item1site.setText(homeAllBeans.get(pos).getLocation_name());
                Glide.with(context).load(homeAllBeans.get(pos).getCover()).apply(RequestOptions.bitmapTransform(new RoundedCorners(10))).into(holder1.iconcard1);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.OnClick(position);
                    }
                }
            });
        }
    }

    class MyLoder extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            HomeBannerDean.DataBean.FirstBean da = (HomeBannerDean.DataBean.FirstBean) path;
            String imagePath = da.getCover();
            Glide.with(context).load(imagePath).into(imageView);
        }
    }

    @Override
    public int getItemCount() {
        return homeAllBeans.size();
    }


    public class BannerHolder extends RecyclerView.ViewHolder {
        private final Banner banner_item;

        public BannerHolder(View itemView) {
            super(itemView);
            banner_item = itemView.findViewById(R.id.banners_item);

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iconcard1;
        private final TextView item1title;
        private final TextView item1time;
        private final TextView item1site;
        private final TextView item1price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconcard1 = itemView.findViewById(R.id.iconcard1);
            item1title = itemView.findViewById(R.id.item1title);
            item1time = itemView.findViewById(R.id.item1time);
            item1site = itemView.findViewById(R.id.item1site);
            item1price = itemView.findViewById(R.id.item1price);

        }
    }

    public interface OnClickListener {
        void OnClick(int position);
    }

    public void setOnClickListener(OnClickListener listener) {

        mListener = listener;
    }

    public interface OnClickListenerBanner {
        void OnClick(int position);
    }

    public void setOnClickListenerBanner(OnClickListenerBanner listener) {

        mListenerBanner = listener;
    }

}
