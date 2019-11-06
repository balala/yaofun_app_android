package com.balala.yaofun.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.balala.yaofun.R;
import com.balala.yaofun.httpUtils.ToastUtil;
import com.balala.yaofun.util.CustomEditText;
import com.balala.yaofun.util.TextWatcherUtil;

public class AuthenticationActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout mAuthenticationback;
    private CustomEditText mPhoneEt;
    /**
     * 请输入你的验证码
     */
    private EditText mCoodeEt;
    private ImageView mAuthenticationClear;
    /**
     * 获取验证码
     */
    private TextView mGiveCode;
    /**
     * 提交
     */
    private Button mUp;

    private String phoneNum;
    private String phone;
    private TimeCount time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        initView();
    }

    private void initView() {
        mAuthenticationback = (RelativeLayout) findViewById(R.id.authenticationback);
        mPhoneEt = (CustomEditText) findViewById(R.id.phone_et);
        mCoodeEt = (EditText) findViewById(R.id.coode_et);
        mAuthenticationClear = (ImageView) findViewById(R.id.authentication_clear);
        mGiveCode = (TextView) findViewById(R.id.give_code);
        mUp = (Button) findViewById(R.id.up);
        time = new TimeCount(60000, 1000);
        mUp.setOnClickListener(this);
        mAuthenticationback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // 清除的点击事件
        mAuthenticationClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCoodeEt.setText("");
                mAuthenticationClear.setVisibility(View.GONE);
            }
        });
        //输入的点击事件
        mGiveCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count < 0) {
                    mAuthenticationClear.setVisibility(View.GONE);
                } else {
                    mAuthenticationClear.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    mAuthenticationClear.setVisibility(View.GONE);
                }
            }

        });
        //点击 获取验证码 进行以下操作
        mGiveCode.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //比较手机号是否符合规则 符合规则弹出"获取验证码"并且验证码开始倒计时，红色文字隐藏
                phoneNum = mPhoneEt.getText().toString().trim();
                // 判断手机号为空或者小于11位时 也可以点击
                if (phoneNum.length() <= 0 || phoneNum.length() <= 11) {

//                    Toast.makeText(RegisterActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                    ToastUtil.showLong("请输入正确的手机号码");
//                    mRedSpeak.setVisibility(View.VISIBLE);
                } else {
                    // 这个方法是用来判断手机验证码相关的
                    initCode();
                }
            }

        });
        // 把手机号码用空格隔开
        TextWatcherUtil.addPhoneNumberTextWatcher(mPhoneEt, new TextWatcherUtil.Callback() {
            @Override
            public void callback() {
                //todo edittext changed后回调


            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.up:
                break;
        }
    }

    private void initCode() {
        //切割字符串将空格清除
        String[] split = phoneNum.split(" ");
        //重新拼接手机号
        phone = split[0] + split[1] + split[2];
        // 判断输入的手机号 是否符合手机号规范
        if (phone.matches("^13[0-9]{1}[0-9]{8}$|15[0125689]{1}[0-9]{8}$|18[0-3,5-9]{1}[0-9]{8}$|17[0-3,5-9]{1}[0-9]{8}$|19[0-3,5-9]{1}[0-9]{8}$|16[0-3,5-9]{1}[0-9]{8}$")) {
            Toast.makeText(AuthenticationActivity.this, "获取验证码", Toast.LENGTH_SHORT).show();
            // 开始执行倒计时的方法
            time.start();
//            mRedSpeak.setVisibility(View.GONE);
            // 获取手机号码 返回后台进行解析
//            initData();
            // 如果手机号码不符合规则 提示用户正确输入手机号 红色文字显示 字体变成"请输入正确的手机号码"
        } else {
            ToastUtil.showLong("请输入正确的手机号码");

//            mRedSpeak.setVisibility(View.VISIBLE);
//
//            mRedSpeak.setText("请输入正确的手机号码");

        }

    }
    // 倒计时 验证码

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
//            mGetCode.setBackgroundColor(Color.parseColor("#ffffff"));
            mGiveCode.setClickable(false);
            mGiveCode.setText( millisUntilFinished / 1000 + "s" );
        }

        @Override
        public void onFinish() {
            mGiveCode.setText("重新发送");
            mGiveCode.setClickable(true);
        }
    }

    //当isShouldHideInput(v, ev)为true时，表示的是点击输入框区域，则需要显示键盘，同时显示光标，反之，需要隐藏键盘、光标

    //
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    //处理Editext的光标隐藏、显示逻辑
                    mPhoneEt.clearFocus();
                    mCoodeEt.clearFocus();

                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }


    // 点击的是输入框区域，保留点击EditText的事件
    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();

            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
