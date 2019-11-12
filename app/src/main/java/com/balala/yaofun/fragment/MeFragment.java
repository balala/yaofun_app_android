package com.balala.yaofun.fragment;


import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.balala.yaofun.R;
import com.balala.yaofun.activity.MyAlbumActivity;
import com.balala.yaofun.activity.SettingActivity;
import com.balala.yaofun.base.BaseFragment;
import com.balala.yaofun.util.ForLog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;

import static com.balala.yaofun.httpUtils.MyApp.user;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseFragment {
    @BindView(R.id.iv_img)
    ImageView iv_img;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.ll_call_our)
    LinearLayout ll_call_our;
    @BindView(R.id.ll_my_album)
    LinearLayout ll_my_album;
    @BindView(R.id.ll_setting)
    LinearLayout ll_setting;


    @Override
    protected void initView() {

        ForLog.e("我的页面调用了initView");
        ImmersionBar.with(this).statusBarColor(R.color.black).init();
        Glide.with(this).load(user.getImages())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(iv_img);
        tv_name.setText(user.getNick_name());
        ll_call_our.setOnClickListener((v->{
            Intent intent = new Intent(Intent.ACTION_DIAL);
            Uri data = Uri.parse("tel:(010)8622 7830");
            intent.setData(data);
            startActivity(intent);
        }));
        ll_my_album.setOnClickListener((v->{
            Intent intent=new Intent(getContext(), MyAlbumActivity.class);
            startActivity(intent);
        }));
        ll_setting.setOnClickListener(v->{
            Intent intent=new Intent(getContext(), SettingActivity.class);
            startActivity(intent);
        });
    }


    @Override
    protected int getlayoutId() {
        return R.layout.fragment_me;
    }

}
