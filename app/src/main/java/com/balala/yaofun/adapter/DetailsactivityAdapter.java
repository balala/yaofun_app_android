package com.balala.yaofun.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.balala.yaofun.R;
import com.balala.yaofun.bean.result.HomedetailsBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailsactivityAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomedetailsBean.DataBean> list;
    private String[] str = new String[]{""};

    public DetailsactivityAdapter(Context context, ArrayList<HomedetailsBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == 0) {
//            View banner = inflater.inflate(R.layout.banner_item, null);
//            return new HomeRecommendAdapter.BannerHolder(banner);
            View inflate = inflater.inflate(R.layout.detailstextitems, null);
            return new ViewHolder1(inflate);
        } else if (viewType == 1) {
//            View inflate2 = inflater.inflate(R.layout.home_item3s, null);
//            return new ViewHolder2(inflate2);
            View inflate = inflater.inflate(R.layout.detailspictureitems, null);
            return new ViewHolder2(inflate);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        List<String> type_array = list.get(position).getType_array();
        List<List<String>> lists = Arrays.asList(type_array);
        List<String> content_array = list.get(position).getContent_array();

        // TYPE判断条件
//        List<String> strings = Arrays.asList(str);

        if (lists.contains("文本") && !lists.contains("图片")) {
            ViewHolder1 holder1 = (ViewHolder1) holder;
            holder1.homedetails_text1.setText(content_array.get(position));
        } else if (!lists.contains("文本") && lists.contains("图片")) {
            ViewHolder2 holder2 = (ViewHolder2) holder;
//            holder2.homedetails_img1.
            Glide.with(context).load(content_array.get(position)).into((ImageView) ((ViewHolder2) holder).homedetails_img1);
        }

//        else if (lists.contains("文本") && lists.contains("图片")) {
//
//        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView homedetails_text1;

        public ViewHolder1(View itemView) {
            super(itemView);
            homedetails_text1 = itemView.findViewById(R.id.homedetails_text1);

        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        private final View homedetails_img1;

        public ViewHolder2(View itemView) {
            super(itemView);
            homedetails_img1 = itemView.findViewById(R.id.homedetails_img1);

        }
    }
}
