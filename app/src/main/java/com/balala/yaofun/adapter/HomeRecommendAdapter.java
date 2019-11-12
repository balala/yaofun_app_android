package com.balala.yaofun.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.balala.yaofun.R;
import com.balala.yaofun.activity.SearchActivity;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.balala.yaofun.bean.result.HomeBannerDean;
import com.balala.yaofun.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import static com.umeng.commonsdk.stateless.UMSLEnvelopeBuild.mContext;

public class HomeRecommendAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    private Context context;
    private ArrayList<HomeBannerDean.DataBean.SecondBean> beanArrayList;
    private ArrayList<HomeAllBean.DataBean.RecommendBean> recommendBeans;
    private HomeAdapter.OnClickListener mListener;
    private HomeAdapter.OnClickListenerBanner mListenerBanner;
    private Object OnClickListenerBanner;
    private HomeAdapter.OnClickListenerBanner mListenerimg;

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
            View banner = inflater.inflate(R.layout.homeimgitem, null);
            return new BannerHolder(banner);

        } else if (viewType == 1) {
            View inflate2 = inflater.inflate(R.layout.home_item3s, null);
            return new ViewHolder2(inflate2);
        } else if (viewType == 2) {
            View inflate = inflater.inflate(R.layout.home_item1s, null);
            return new ViewHolder1(inflate);
        }

        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0 && beanArrayList != null) {
            BannerHolder banq = (BannerHolder) holder;
            Homesecondadapter adapter = new Homesecondadapter(context, beanArrayList);
            banq.recyclerview_item.setAdapter(adapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            banq.recyclerview_item.setLayoutManager(linearLayoutManager);

        } else if (itemViewType == 1) {
            ViewHolder2 holder2 = (ViewHolder2) holder;
            holder2.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListenerimg != null) {
                        mListenerimg.OnClick(position);
                    }
                }
            });
        } else if (itemViewType == 2) {
            ViewHolder1 holder1 = (ViewHolder1) holder;
            Log.i("热门解析", "热门解析: " + recommendBeans.toString());
            holder1.item1time.setText(recommendBeans.get(position).getStart_end_time());
            holder1.item1title.setText(recommendBeans.get(position).getTitle());
            holder1.item1site.setText(recommendBeans.get(position).getLocation_name());
            double costs = recommendBeans.get(position).getCost();
            String cost = String.valueOf(costs);
            if (cost.isEmpty() || cost.equals("0.0")) {
                ((ViewHolder1) holder).item1price.setText("FREE");
            } else {
                ((ViewHolder1) holder).item1priceyuan.setVisibility(View.VISIBLE);
                ((ViewHolder1) holder).item1price.setText(cost);
            }
            Picasso.with(context).load(recommendBeans.get(position).getCover())
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
//                    .transform(new CircleTransform(mContext))
//                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(10)))
                    .into(holder1.iconcard1);
            holder1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.OnClick(position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 4) {
            return 1;
        } else {
            return 2;
        }

    }

    @Override
    public int getItemCount() {
        Log.i("适配器长度", "getItemCount: " + recommendBeans.size());
        return recommendBeans.size();
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
        private final TextView item1priceyuan;

        public ViewHolder1(View itemView) {
            super(itemView);
            iconcard1 = itemView.findViewById(R.id.iconcard1);
            item1title = itemView.findViewById(R.id.item1title);
            item1time = itemView.findViewById(R.id.item1time);
            item1site = itemView.findViewById(R.id.item1site);
            item1price = itemView.findViewById(R.id.item1price);
            item1priceyuan = itemView.findViewById(R.id.item1priceyuan);

        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        private final ImageView home_search2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            home_search2 = itemView.findViewById(R.id.home_search2);
            // 为ItemView添加点击事件
//            home_search2.setOnClickListener(HomeRecommendAdapter.this);
        }
    }

    public class BannerHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerview_item;

        public BannerHolder(View itemView) {
            super(itemView);
            recyclerview_item = itemView.findViewById(R.id.recyclerview_item);
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

    public void setOnClickListenerimg(HomeAdapter.OnClickListenerBanner listener) {

        mListenerimg = listener;
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();      //getTag()获取数据
        if (mListenerBanner != null) {
            switch (v.getId()) {
                case R.id.home_search2:
                    mListenerBanner.OnClick(position);  //在这里实现
                    break;

            }
        }
    }
}
