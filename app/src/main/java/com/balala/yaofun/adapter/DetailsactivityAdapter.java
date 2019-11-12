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

import java.util.List;

public class DetailsactivityAdapter extends RecyclerView.Adapter {
    private Context context;
    private HomedetailsBean.DataBean list;

    public DetailsactivityAdapter(Context context, HomedetailsBean.DataBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == 0) {
            View inflate = inflater.inflate(R.layout.detailstextitems, null);
            return new ViewHolder1(inflate);
        } else if (viewType == 1) {
            View inflate = inflater.inflate(R.layout.detailspictureitems, null);
            return new ViewHolder2(inflate);
        }else {
            //换布局
            return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        List<String> content_array = list.getContent_array();
        if(viewType==0){
            ViewHolder1 holder1 = (ViewHolder1) holder;
            holder1.homedetails_text1.setText(content_array.get(position));
        }else if(viewType==1){
            ViewHolder2 holder2 = (ViewHolder2) holder;
            Glide.with(context).load(content_array.get(position)).into(holder2.homedetails_img1);
        }else {

        }

    }

    @Override
    public int getItemViewType(int position) {
        if("文本".equals(list.getType_array().get(position))){
            return 0;
        }else if("图片".equals(list.getType_array().get(position))){
            return 1;
        }else {
            return 2;
        }
    }

    @Override
    public int getItemCount() {
        return list.getType_array().size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView homedetails_text1;

        public ViewHolder1(View itemView) {
            super(itemView);
            homedetails_text1 = itemView.findViewById(R.id.homedetails_text1);

        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        private final ImageView homedetails_img1;

        public ViewHolder2(View itemView) {
            super(itemView);
            homedetails_img1 = itemView.findViewById(R.id.homedetails_img1);

        }
    }
}
