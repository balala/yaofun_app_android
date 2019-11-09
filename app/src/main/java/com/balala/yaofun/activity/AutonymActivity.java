package com.balala.yaofun.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.balala.yaofun.R;
import com.balala.yaofun.util.CustomEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AutonymActivity extends AppCompatActivity {

    @BindView(R.id.autonymback)
    ImageView mAutonymback;
    @BindView(R.id.authentication_back)
    RelativeLayout mAuthenticationBack;
    @BindView(R.id.authentication_name)
    CustomEditText mAuthenticationName;
    @BindView(R.id.authentication_text)
    TextView mAuthenticationText;
    @BindView(R.id.authentication_xiala)
    RelativeLayout mAuthenticationXiala;
    @BindView(R.id.passportbutton)
    LinearLayout mPassportbutton;
    @BindView(R.id.headbutton)
    LinearLayout mHeadbutton;
    @BindView(R.id.lltt)
    LinearLayout mLltt;
    @BindView(R.id.headimg)
    ImageView mHeadimg;
    @BindView(R.id.passportimg)
    ImageView mPassportimg;
    @BindView(R.id.autonymup)
    Button mAutonymup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonym);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.autonymback, R.id.authentication_back, R.id.authentication_name, R.id.authentication_text, R.id.authentication_xiala, R.id.passportbutton, R.id.headbutton, R.id.lltt, R.id.headimg, R.id.passportimg, R.id.autonymup})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.autonymback:
                finish();
                break;
            case R.id.authentication_back:
                break;
            case R.id.authentication_name:
                break;
            case R.id.authentication_text:
                break;
            case R.id.authentication_xiala:
                break;
            case R.id.passportbutton:
                break;
            case R.id.headbutton:
                break;
            case R.id.lltt:
                break;
            case R.id.headimg:
                break;
            case R.id.passportimg:
                break;
            case R.id.autonymup:
                break;
        }
    }
}
