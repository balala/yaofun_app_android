package com.balala.yaofun.activity;

import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.balala.yaofun.R;
import com.balala.yaofun.adapter.DetailsactivityAdapter;
import com.balala.yaofun.base.BaseActivity;
import com.balala.yaofun.bean.result.HomedetailsBean;
import com.balala.yaofun.fragment.HomeFragment;
import com.balala.yaofun.model.HomedetailsModel;
import com.balala.yaofun.presenter.HomedetailsPersenter;
import com.balala.yaofun.view.HomedetailsView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomedetailsActivity extends BaseActivity<HomedetailsPersenter, HomedetailsModel> implements HomedetailsView {

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
    @BindView(R.id.homedetails_people)
    ImageView mHomedetailsPeople;
    //    @BindView(R.id.homedetails_fab)
//    FloatingActionButton mHomedetailsFab;
    @BindView(R.id.sll)
    RelativeLayout sll;
    private PopupMenu mMenu;
    private LinearLayout popitem1;
    private LinearLayout popitem2;
    private LinearLayout popitem3;
    private LinearLayout popitem4;
//    private String[] str = new String[]{""};


    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        basePresenter.getHomedetailsdata(id);

        // TYPE判断条件
//        List<String> strings = Arrays.asList(str);
//        if(strings.contains("文本")&&!strings.contains("图片")){
//
//        }else if(!strings.contains("文本")&&strings.contains("图片")){
//
//        }else if(strings.contains("文本")&&strings.contains("图片")){
//
//        }
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
//
            case R.id.homedetailsimg:

                break;
            case R.id.homedetails_back:
                finish();
                break;
            case R.id.homedetails_menu:
                // 在这弹出menu选项
                //为按钮绑定上下文菜单（注意不是绑定监听器）
                showPopupMenu();
//                mMenu = new PopupMenu(this, mHomedetailsMenu);
//                mMenu.getMenuInflater().inflate(R.menu.homedetailsmenu, mMenu.getMenu());
//                mMenu.show();
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

    private void showPopupMenu() {
        Toast.makeText(this, "点击弹出", Toast.LENGTH_SHORT).show();
//        popupWindow.showAtLocation(mHomedetailsMenu, Gravity.BOTTOM, 0, 0);
        View mPopView = getLayoutInflater().inflate(R.layout.popitem, null);
        PopupWindow popupWindow = new PopupWindow(mPopView);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(mHomedetailsMenu);

    }

    @Override
    public void onSuccessHomedetails(HomedetailsBean funhomeData) {
        homedetailsicon.setVisibility(View.GONE);
        sll.setVisibility(View.VISIBLE);
        HomedetailsBean.DataBean data = funhomeData.getData();
//        /        DetailsactivityAdapter    allrv

        // 标签的个数
        DetailsactivityAdapter adapter = new DetailsactivityAdapter(this, data);
//        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        allrv.setLayoutManager(linearLayoutManager);
        allrv.setAdapter(adapter);

        Log.i("首页详情解析", "onSuccessHomedetails: " + funhomeData);
        Glide.with(this).load(data.getCover()).into(mHomedetailsimg);
        mHomedetailsTitle.setText(data.getTitle());

//        List<String> user_label = data.getUser_label();
//        for (int i = 0; i < user_label.size(); i++) {
//            mHomedetailsLabel1.setText(data.getUser_label().get(i));
//        }
//        mHomedetailsLabel2.setText(data.getUser_label().get(size));
        mHomedetailsPeoplename.setText(data.getUser_nick_name());
        mHomedetailsTime.setText(data.getStart_end_time());
        mHomedetailsPeoplecount.setText(data.getLimit_number());
        mHomedetailsSite.setText(data.getPlace_text().getAddress());
        mHomedetailsFuntitle.setText(data.getLocation_name());
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
