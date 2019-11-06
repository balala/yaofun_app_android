package com.balala.yaofun.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.balala.yaofun.R;
import com.balala.yaofun.adapter.DetailsactivityAdapter;
import com.balala.yaofun.base.BaseActivity;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.result.HomedetailsBean;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.presenter.HomedetailsPersenter;
import com.balala.yaofun.util.FlowLayout;
import com.balala.yaofun.util.SwZoomDragImageView;
import com.balala.yaofun.view.HomedetailsView;
import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomedetailsActivity extends BaseActivity<HomedetailsPersenter, ApiModel> implements HomedetailsView {

    @BindView(R.id.homedetailsimg)
    ImageView mHomedetailsimg;
    @BindView(R.id.homedetails_back)
    ImageView mHomedetailsBack;
    @BindView(R.id.homedetails_menu)
    ImageView mHomedetailsMenu;
    //    @BindView(R.id.homedetails_toolbar)
//    Toolbar mHomedetailsToolbar;
    @BindView(R.id.homedetails_title)
    TextView mHomedetailsTitle;
    @BindView(R.id.homedetails_xiahua)
    ImageView mHomedetailsXiahua;
    @BindView(R.id.homedetails_peoplename)
    TextView mHomedetailsPeoplename;
    @BindView(R.id.homedetails_label1)
    TextView mHomedetailsLabel1;
    //    @BindView(R.id.homedetails_label2)
//    TextView mHomedetailsLabel2;
    @BindView(R.id.homedetails_signature)
    TextView mHomedetailsSignature;
    @BindView(R.id.homedetails_peoplecount)
    TextView mHomedetailsPeoplecount;
    @BindView(R.id.homedetails_peoplerv)
    RecyclerView mHomedetailsPeoplerv;
    @BindView(R.id.allrv)
    RecyclerView allrv;
    @BindView(R.id.homedetails_peopleback)
    ImageView mHomedetailsPeopleback;
    @BindView(R.id.homedetails_time)
    TextView mHomedetailsTime;
    @BindView(R.id.homedetails_site)
    TextView mHomedetailsSite;
    @BindView(R.id.homedetails_navigation)
    ImageView mHomedetailsNavigation;
    @BindView(R.id.homedetails_ticket)
    TextView mHomedetailsTicket;
    @BindView(R.id.homedetails_img6)
    ImageView mHomedetailsImg6;
    @BindView(R.id.homedetails_funtitle)
    TextView mHomedetailsFuntitle;
    @BindView(R.id.tvv)
    TextView tvv;
    @BindView(R.id.homedetails_funimg)
    ImageView mHomedetailsFunimg;
    @BindView(R.id.homedetails_funmessage)
    TextView mHomedetailsFunmessage;
    @BindView(R.id.homedetails_personcount)
    TextView homedetails_personcount;
    @BindView(R.id.homedetails_wirte)
    ImageView mHomedetailsWirte;
    @BindView(R.id.homedetailsicon)
    ImageView homedetailsicon;
    @BindView(R.id.homedetails_rv2)
    RecyclerView mHomedetailsRv2;
    @BindView(R.id.homedetails_message)
    ImageView mHomedetailsMessage;
    @BindView(R.id.homedetailsgo)
    Button mHomedetailsgo;
    @BindView(R.id.llt)
    LinearLayout mLlt;
    @BindView(R.id.labelll)
    LinearLayout labelll;
    @BindView(R.id.homedetails_people)
    ImageView mHomedetailsPeople;
    @BindView(R.id.flow)
    FlowLayout flow;
    //    @BindView(R.id.homedetails_fab)
//    FloatingActionButton mHomedetailsFab;
    @BindView(R.id.sll)
    RelativeLayout sll;
    private PopupMenu mMenu;
    private LinearLayout popitem1;
    private LinearLayout popitem2;
    private LinearLayout popitem3;
    private LinearLayout popitem4;
    private String address;
    private HomedetailsBean.DataBean data;
    private SwZoomDragImageView img;


    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        HashMap<String, String> map = new HashMap<>();
        basePresenter.getHomedetailsdata(id, map);

    }

    @Override
    protected void initData2() {

    }

    @Override
    protected int getlayout() {
        return R.layout.activity_homedetails;
    }

    @Override
    protected HomedetailsPersenter initPresenter() {
        return new HomedetailsPersenter();
    }

    //    R.id.homedetails_fab   , R.id.homedetails_label2
    @OnClick({R.id.homedetailsimg, R.id.homedetails_back, R.id.homedetails_menu, R.id.homedetails_title, R.id.homedetails_xiahua, R.id.homedetails_peoplename, R.id.homedetails_label1, R.id.homedetails_signature, R.id.homedetails_peoplecount, R.id.homedetails_peoplerv, R.id.homedetails_peopleback, R.id.homedetails_time, R.id.homedetails_site, R.id.homedetails_navigation, R.id.homedetails_ticket, R.id.homedetails_img6, R.id.homedetails_funtitle, R.id.homedetails_funimg, R.id.homedetails_funmessage, R.id.homedetails_wirte, R.id.homedetails_rv2, R.id.homedetails_message, R.id.homedetailsgo, R.id.llt, R.id.homedetails_people})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;

            case R.id.homedetailsimg:
                initDialogData();

                break;
            case R.id.homedetails_back:
                finish();
                break;
            case R.id.homedetails_menu:
                // 在这弹出menu选项
                showPopupMenu();
                break;
            case R.id.homedetails_title:
                break;
            case R.id.homedetails_xiahua:
                break;
            case R.id.homedetails_peoplename:
                break;
            case R.id.homedetails_label1:
                break;
//            case R.id.homedetails_label2:
//                break;
            case R.id.homedetails_signature:
                break;
            case R.id.homedetails_peoplecount:
                break;
            case R.id.homedetails_peoplerv:
                break;
            case R.id.homedetails_peopleback:
                break;
            case R.id.homedetails_time:
                break;
            case R.id.homedetails_site:
                break;
            case R.id.homedetails_navigation:
                Intent intent = new Intent(HomedetailsActivity.this, AmapRouteActivity.class);
                intent.putExtra("address", address);
                startActivity(intent);
                break;
            case R.id.homedetails_ticket:
                break;
            case R.id.homedetails_img6:
                break;
            case R.id.homedetails_funtitle:
                break;
            case R.id.homedetails_funimg:
                break;
            case R.id.homedetails_funmessage:
                break;
            case R.id.homedetails_wirte:
                break;
            case R.id.homedetails_rv2:
                break;
            case R.id.homedetails_message:
                break;
            case R.id.homedetailsgo:
                break;
            case R.id.llt:
                break;
            case R.id.homedetails_people:

                break;
//            case R.id.homedetails_fab:
//                break;
        }
    }

    private void initDialogData() {
        sll.setVisibility(View.GONE);
//        Toast.makeText(this, "alalla", Toast.LENGTH_SHORT).show();
//        View mPopView = getLayoutInflater().inflate(R.layout.homedetailspop, null);
//        img = mPopView.findViewById(R.id.homedetailsimgpop);
//        Glide.with(this).load(data.getCover()).into(img);
//        img.enable();
        PopupWindow popup = new PopupWindow();
        View mPopView = getLayoutInflater().inflate(R.layout.homedetailspop, null);
        img = mPopView.findViewById(R.id.homedetailsimgpop);
        Glide.with(this).load(data.getCover()).into(img);
        popup.setContentView(mPopView);
        popup.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popup.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        popup.setOutsideTouchable(true);
        popup.showAsDropDown(mHomedetailsBack);

        popup.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popup.dismiss();
                sll.setVisibility(View.VISIBLE);
                return false;
            }
        });
        // 点击大图关闭dialog
//        imgEntryView.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View paramView) {
//                dialog.cancel();
//            }
//        });
    }

    private void showPopupMenu() {
        View mPopView = getLayoutInflater().inflate(R.layout.popitem, null);
        PopupWindow popupWindow = new PopupWindow();
        popupWindow.setContentView(mPopView);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(mHomedetailsMenu);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onSuccessHomedetails(BaseBean<HomedetailsBean.DataBean> funhomeData) {
        homedetailsicon.setVisibility(View.GONE);
        sll.setVisibility(View.VISIBLE);

        data = funhomeData.getData();
        address = data.getPlace_text().getAddress();
        // 标签的个数
        DetailsactivityAdapter adapter = new DetailsactivityAdapter(this, data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        allrv.setLayoutManager(linearLayoutManager);
        allrv.setAdapter(adapter);

        Log.i("首页详情解析", "onSuccessHomedetails: " + funhomeData);
        //详情页图片 放大缩小
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        mHomedetailsimg.initImageView(dm.widthPixels, dm.heightPixels - 80);
        //加载详情页图片
        Glide.with(this).load(data.getCover()).into(mHomedetailsimg);


        mHomedetailsTitle.setText(data.getTitle());
        List<String> user_label = data.getUser_label();
        if (user_label.isEmpty()) {
            flow.setVisibility(View.GONE);
            labelll.setVisibility(View.VISIBLE);
        } else {
            flow.setVisibility(View.VISIBLE);
            labelll.setVisibility(View.GONE);
            for (int i = 0; i < user_label.size(); i++) {
                TextView textView = new TextView(this);
                textView.setText("#" + user_label.get(i));
                textView.setTextColor(Color.WHITE);
                textView.setTextSize(15);
                flow.addView(textView);
            }
        }
        mHomedetailsPeoplename.setText(data.getUser_nick_name());
        mHomedetailsTime.setText(data.getStart_end_time());
        mHomedetailsPeoplecount.setText(data.getLimit_number());
        mHomedetailsSite.setText(data.getPlace_text().getAddress());
        mHomedetailsFuntitle.setText(data.getLocation_name());
//        mHomedetailsFunmessage.setText(data); 副标题
        Glide.with(this).load(data.getUser_images()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(mHomedetailsPeople);

        homedetails_personcount.setText(data.getMy_status());
        mHomedetailsTicket.setText(data.getCost());
        Log.i("My_status", "onSuccessHomedetails: " + data.getMy_status() + data.getCost());

    }

    @Override
    public void onFailHomedetails(String msg) {
        Log.i("首页详情解析", "onFailHomedetails: " + msg);
    }


}
