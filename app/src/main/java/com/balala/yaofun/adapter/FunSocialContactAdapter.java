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
import com.balala.yaofun.bean.FunhomeData;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FunSocialContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<FunhomeData.SocialBean> sociallist;


    public FunSocialContactAdapter(Context context, ArrayList<FunhomeData.SocialBean> sociallist) {
        this.context = context;
        this.sociallist = sociallist;
    }

    public void setList(ArrayList<FunhomeData.SocialBean> sociallist) {
        this.sociallist = sociallist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.funhome_item1, null);
            viewHolder = new FunSocialContactAdapter.ViewHolderA(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.funhome_item2, null);
            viewHolder = new FunSocialContactAdapter.ViewHolderB(inflate);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FunSocialContactAdapter.ViewHolderA) {
            FunSocialContactAdapter.ViewHolderA viewHolderA = (FunSocialContactAdapter.ViewHolderA) holder;
//            FunhomeData.SocialBean funhomeData = list.get(position);
            Glide.with(context).load(sociallist.get(position).getUser_images()).into(viewHolderA.img_a);
            viewHolderA.tv_a1.setText(sociallist.get(position).getGroup_name());
            viewHolderA.tv_a2.setText(sociallist.get(position).getAutograph());

        } else if (holder instanceof FunSocialContactAdapter.ViewHolderB) {
            FunSocialContactAdapter.ViewHolderB viewHolderB = (FunSocialContactAdapter.ViewHolderB) holder;
            Glide.with(context).load(sociallist.get(position).getUser_images()).into(viewHolderB.img_b);
            viewHolderB.tv_b1.setText(sociallist.get(position).getGroup_name());
            viewHolderB.tv_b2.setText(sociallist.get(position).getAutograph());
        }

    }

    @Override
    public int getItemCount() {
        return sociallist.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    class ViewHolderA extends RecyclerView.ViewHolder {

        private ImageView img_a;
        private TextView tv_a1;
        private TextView tv_a2;

        public ViewHolderA(@NonNull View itemView) {
            super(itemView);
            img_a = itemView.findViewById(R.id.img1);
            tv_a1 = itemView.findViewById(R.id.tv1);
            tv_a2 = itemView.findViewById(R.id.tv2);
        }
    }

    class ViewHolderB extends RecyclerView.ViewHolder {
        private ImageView img_b;
        private TextView tv_b1;
        private TextView tv_b2;

        public ViewHolderB(@NonNull View itemView) {
            super(itemView);
            img_b = itemView.findViewById(R.id.img2);
            tv_b1 = itemView.findViewById(R.id.tv11);
            tv_b2 = itemView.findViewById(R.id.tv22);
        }
    }
}
