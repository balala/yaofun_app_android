package com.balala.yaofun.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.balala.yaofun.R;
import com.balala.yaofun.util.CustomEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateFunActivity extends AppCompatActivity {

    @BindView(R.id.createfunback)
    LinearLayout mCreatefunback;
    @BindView(R.id.createfunwhy)
    LinearLayout mCreatefunwhy;
    @BindView(R.id.createfunrv)
    RecyclerView mCreatefunrv;
    @BindView(R.id.createfunimg)
    ImageView mCreatefunimg;
    @BindView(R.id.createfuntext)
    TextView mCreatefuntext;
    @BindView(R.id.createfunaddimg)
    RelativeLayout mCreatefunaddimg;
    @BindView(R.id.createfun_name)
    CustomEditText mCreatefunName;
    @BindView(R.id.createfun_resume)
    CustomEditText mCreatefunResume;
    @BindView(R.id.createfun_dotext)
    CustomEditText mCreatefunDotext;
    @BindView(R.id.createfun_doback)
    ImageView mCreatefunDoback;
    @BindView(R.id.createfun_jointext)
    CustomEditText mCreatefunJointext;
    @BindView(R.id.createfuninterestback)
    ImageView mCreatefuninterestback;
    @BindView(R.id.createfun_interesttext)
    CustomEditText mCreatefunInteresttext;
    @BindView(R.id.createfun_interestback)
    ImageView mCreatefunInterestback;
    @BindView(R.id.createfun_choose)
    CheckBox mCreatefunChoose;
    @BindView(R.id.immediately)
    Button mImmediately;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createfun);
        ButterKnife.bind(this);
        // 点击眼睛查看或隐藏密码
        mCreatefunChoose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Drawable drawable = CreateFunActivity.this.getResources().getDrawable(R.drawable.createfunopenoff);
//                    drawable.setBounds(0, 0, 10, 10);
                    mCreatefunChoose.setButtonDrawable(drawable);
//                    mEt2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示密码
                } else {
                    Drawable drawable = CreateFunActivity.this.getResources().getDrawable(R.drawable.createfunopencolse);
//                    drawable.setBounds(0, 0, 10, 10);
                    mCreatefunChoose.setButtonDrawable(drawable);
//                    mEt2.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏密码
                }
//                mEt2.setSelection(TextUtils.isEmpty(mEt2.getText()) ? 0 : mEt2.length());//光标挪到最后
            }
        });
    }

    @OnClick({R.id.createfunback, R.id.createfunwhy, R.id.createfunrv, R.id.createfunimg, R.id.createfuntext, R.id.createfunaddimg, R.id.createfun_name, R.id.createfun_resume, R.id.createfun_dotext, R.id.createfun_doback, R.id.createfun_jointext, R.id.createfuninterestback, R.id.createfun_interesttext, R.id.createfun_interestback, R.id.createfun_choose, R.id.immediately})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.createfunback:
                finish();
                break;
            case R.id.createfunwhy:

                break;
            case R.id.createfunrv:
                break;
            case R.id.createfunimg:
                break;
            case R.id.createfuntext:
                break;
            case R.id.createfunaddimg:
                break;
            case R.id.createfun_name:
                break;
            case R.id.createfun_resume:
                break;
            case R.id.createfun_dotext:
                break;
            case R.id.createfun_doback:
                break;
            case R.id.createfun_jointext:
                break;
            case R.id.createfuninterestback:
                break;
            case R.id.createfun_interesttext:
                break;
            case R.id.createfun_interestback:
                break;
            case R.id.createfun_choose:

                if (mCreatefunChoose.isClickable()) {
                    mCreatefunChoose.setClickable(true);
                }
                break;
            case R.id.immediately:
                break;

        }
    }

}
