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

public class ReportActivity extends AppCompatActivity {

    @BindView(R.id.reportback)
    RelativeLayout mReportback;
    @BindView(R.id.rubbish)
    LinearLayout mRubbish;
    @BindView(R.id.qun)
    LinearLayout mQun;
    @BindView(R.id.pian)
    LinearLayout mPian;
    @BindView(R.id.gongji)
    LinearLayout mGongji;
    @BindView(R.id.se)
    LinearLayout mSe;
    @BindView(R.id.hai)
    LinearLayout mHai;
    @BindView(R.id.say)
    LinearLayout mSay;
    @BindView(R.id.editText)
    CustomEditText mEditText;
    @BindView(R.id.takephoto)
    ImageView mTakephoto;
    @BindView(R.id.size)
    TextView mSize;
    @BindView(R.id.upgo)
    Button mUpgo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.reportback, R.id.rubbish, R.id.qun, R.id.pian, R.id.gongji, R.id.se, R.id.hai, R.id.say, R.id.editText, R.id.takephoto, R.id.size, R.id.upgo})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.reportback:
                break;
            case R.id.rubbish:
                break;
            case R.id.qun:
                break;
            case R.id.pian:
                break;
            case R.id.gongji:
                break;
            case R.id.se:
                break;
            case R.id.hai:
                break;
            case R.id.say:
                break;
            case R.id.editText:
                break;
            case R.id.takephoto:
                break;
            case R.id.size:
                break;
            case R.id.upgo:
                break;
        }
    }
}
