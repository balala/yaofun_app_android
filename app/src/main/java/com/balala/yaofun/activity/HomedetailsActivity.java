package com.balala.yaofun.activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.balala.yaofun.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomedetailsActivity extends AppCompatActivity {

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
    @BindView(R.id.homedetails_label2)
    TextView mHomedetailsLabel2;
    @BindView(R.id.homedetails_signature)
    TextView mHomedetailsSignature;
    @BindView(R.id.homedetails_peoplecount)
    TextView mHomedetailsPeoplecount;
    @BindView(R.id.homedetails_peoplerv)
    RecyclerView mHomedetailsPeoplerv;
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
    @BindView(R.id.homedetails_img1)
    ImageView mHomedetailsImg1;
    @BindView(R.id.homedetails_text1)
    TextView mHomedetailsText1;
    @BindView(R.id.homedetails_img2)
    ImageView mHomedetailsImg2;
    @BindView(R.id.homedetails_text2)
    TextView mHomedetailsText2;
    @BindView(R.id.homedetails_img3)
    ImageView mHomedetailsImg3;
    @BindView(R.id.homedetails_text3)
    TextView mHomedetailsText3;
    @BindView(R.id.homedetails_img4)
    ImageView mHomedetailsImg4;
    @BindView(R.id.homedetails_text4)
    TextView mHomedetailsText4;
    @BindView(R.id.homedetails_textback)
    ImageView mHomedetailsTextback;
    @BindView(R.id.homedetails_img5)
    ImageView mHomedetailsImg5;
    @BindView(R.id.homedetails_text5)
    TextView mHomedetailsText5;
    @BindView(R.id.homedetails_img6)
    ImageView mHomedetailsImg6;
    @BindView(R.id.homedetails_funtitle)
    TextView mHomedetailsFuntitle;
    @BindView(R.id.homedetails_funimg)
    ImageView mHomedetailsFunimg;
    @BindView(R.id.homedetails_funmessage)
    TextView mHomedetailsFunmessage;
    @BindView(R.id.homedetails_wirte)
    ImageView mHomedetailsWirte;
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
    @BindView(R.id.homedetails_fab)
    FloatingActionButton mHomedetailsFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 渲染系统toolbar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_homedetails);
        ButterKnife.bind(this);
    }
//    R.id.homedetails_toolbar,
    @OnClick({R.id.homedetailsimg, R.id.homedetails_back, R.id.homedetails_menu,  R.id.homedetails_title, R.id.homedetails_xiahua, R.id.homedetails_peoplename, R.id.homedetails_label1, R.id.homedetails_label2, R.id.homedetails_signature, R.id.homedetails_peoplecount, R.id.homedetails_peoplerv, R.id.homedetails_peopleback, R.id.homedetails_time, R.id.homedetails_site, R.id.homedetails_navigation, R.id.homedetails_ticket, R.id.homedetails_img1, R.id.homedetails_text1, R.id.homedetails_img2, R.id.homedetails_text2, R.id.homedetails_img3, R.id.homedetails_text3, R.id.homedetails_img4, R.id.homedetails_text4, R.id.homedetails_textback, R.id.homedetails_img5, R.id.homedetails_text5, R.id.homedetails_img6, R.id.homedetails_funtitle, R.id.homedetails_funimg, R.id.homedetails_funmessage, R.id.homedetails_wirte, R.id.homedetails_rv2, R.id.homedetails_message, R.id.homedetailsgo, R.id.llt, R.id.homedetails_people, R.id.homedetails_fab})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.homedetailsimg:
                break;
            case R.id.homedetails_back:
                finish();
                break;
            case R.id.homedetails_menu:
                // 在这弹出menu选项

                break;
//            case R.id.homedetails_toolbar:
//                break;
            case R.id.homedetails_title:
                break;
            case R.id.homedetails_xiahua:
                break;
            case R.id.homedetails_peoplename:
                break;
            case R.id.homedetails_label1:
                break;
            case R.id.homedetails_label2:
                break;
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
            case R.id.homedetails_img1:
                break;
            case R.id.homedetails_text1:
                break;
            case R.id.homedetails_img2:
                break;
            case R.id.homedetails_text2:
                break;
            case R.id.homedetails_img3:
                break;
            case R.id.homedetails_text3:
                break;
            case R.id.homedetails_img4:
                break;
            case R.id.homedetails_text4:
                break;
            case R.id.homedetails_textback:
                break;
            case R.id.homedetails_img5:
                break;
            case R.id.homedetails_text5:
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
            case R.id.homedetails_fab:
                break;
        }
    }
}
