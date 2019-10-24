package com.balala.yaofun.adapter;

import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.balala.yaofun.R;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.balala.yaofun.bean.result.HomeBannerDean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class HomeRecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<HomeAllBean.DataBean.RecommendBean> recommendBeans;
    private ArrayList<HomeBannerDean.DataBean.SecondBean> beanArrayList;

    public HomeRecommendAdapter(Context context, ArrayList<HomeAllBean.DataBean.RecommendBean> recommendBeans, ArrayList<HomeBannerDean.DataBean.SecondBean> beanArrayList) {
        this.context = context;
        this.recommendBeans = recommendBeans;
        this.beanArrayList = beanArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == 0) {
            View banner = inflater.inflate(R.layout.banner_item, null);
            holder = new BannerHolder(banner);

        } else {
            View inflate = inflater.inflate(R.layout.home_item1s, null);
            holder = new ViewHolder1(inflate);
        }

        return holder;
    }

    private int po;

    @Override
    public int getItemViewType(int position) {
        po = position;
        if (beanArrayList.size() > 0 && po == 0) {
            return 0;
        } else if (recommendBeans.size() > 0 && po == 1) {
            return 1;
        }
        return 1;
    }

    @Override
    public int getItemCount() {
        // 注意看这里
//        int a = 0;
        if (beanArrayList != null && beanArrayList.size() > 0) {
            beanArrayList.size();
        }
//        if (recommendBeans.size() > 0) {
//            a++;
//        }
//        if (beanArrayList != null && beanArrayList.size() > 0) {
//            a += beanArrayList.size();
//        }
//        return a;
        return recommendBeans.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            BannerHolder banq = (BannerHolder) holder;
            banq.banner_item.setImages(beanArrayList);
            banq.banner_item.setImageLoader(new MyLoder());
            banq.banner_item.start();
            banq.banner_item.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 10);
                }
            });

            banq.banner_item.setClipToOutline(true);
        } else if (itemViewType == 1) {
            ViewHolder1 holder1 = (ViewHolder1) holder;
            Log.i("热门解析", "热门解析: " + recommendBeans.toString());
            holder1.item1time.setText(recommendBeans.get(position).getStart_end_time());
            holder1.item1title.setText(recommendBeans.get(position).getTitle());
            holder1.item1site.setText(recommendBeans.get(position).getLocation_name());
            double costs = recommendBeans.get(position).getCost();
            String cost = String.valueOf(costs);
            ((ViewHolder1) holder).item1price.setText(cost);
//            holder1.item1price.setText((int) recommendBeans.get(position).getCost());
            Glide.with(context).load(recommendBeans.get(position).getCover()).apply(RequestOptions.bitmapTransform(new RoundedCorners(10))).into(holder1.iconcard1);

        }
    }

    class MyLoder extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            HomeBannerDean.DataBean.SecondBean da = (HomeBannerDean.DataBean.SecondBean) path;
            String imagePath = da.getCover();
            Glide.with(context).load(imagePath).into(imageView);
        }
    }


    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView iconcard1;
        private final TextView item1title;
        private final TextView item1time;
        private final TextView item1site;
        private final TextView item1price;

        public ViewHolder1(View itemView) {
            super(itemView);
            iconcard1 = itemView.findViewById(R.id.iconcard1);
            item1title = itemView.findViewById(R.id.item1title);
            item1time = itemView.findViewById(R.id.item1time);
            item1site = itemView.findViewById(R.id.item1site);
            item1price = itemView.findViewById(R.id.item1price);

        }
    }

    public class BannerHolder extends RecyclerView.ViewHolder {


        private final Banner banner_item;

        public BannerHolder(View itemView) {
            super(itemView);
            banner_item = itemView.findViewById(R.id.banners_item);
        }
    }
}
