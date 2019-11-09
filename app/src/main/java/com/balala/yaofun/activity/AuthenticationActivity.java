package com.balala.yaofun.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.balala.yaofun.R;
import com.balala.yaofun.base.BaseActivity;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.CodeBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.httpUtils.ToastUtil;
import com.balala.yaofun.presenter.AuthenticationPresenter;
import com.balala.yaofun.presenter.RegisterPresenter;
import com.balala.yaofun.util.CustomEditText;
import com.balala.yaofun.util.TextWatcherUtil;
import com.balala.yaofun.util.Utils;
import com.balala.yaofun.view.AuthenticationView;
import com.balala.yaofun.view.RegisterView;
import com.balala.yaofun.webview.AboutyaofunActivity;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationActivity extends BaseActivity<AuthenticationPresenter, AuthenticationView> implements AuthenticationView {

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
    private TimeCount time;
    private String phone;
    private CheckBox mBox;
    private TextView mSpeak;
    /**
     * 《要FUN用户协议》
     */
    private TextView mAbout;
    private String code1;
    private String code;
    private String key;
    private String verificationCodes;


    protected void initView() {
        // 渲染系统toolbar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        mAuthenticationback = (RelativeLayout) findViewById(R.id.authenticationback);
        mPhoneEt = (CustomEditText) findViewById(R.id.phone_et);
        mCoodeEt = (EditText) findViewById(R.id.coode_et);
        mAuthenticationClear = (ImageView) findViewById(R.id.authentication_clear);
        mGiveCode = (TextView) findViewById(R.id.give_code);
        mUp = (Button) findViewById(R.id.up);
        mBox = (CheckBox) findViewById(R.id.box);
        mSpeak = (TextView) findViewById(R.id.speak);
        mAbout = (TextView) findViewById(R.id.about);
        time = new TimeCount(60000, 1000);

        //文本框输入的手机号和验证码
        phoneNum = mPhoneEt.getText().toString().trim();
        code = mCoodeEt.getText().toString();
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
                    mSpeak.setVisibility(View.VISIBLE);
                    mSpeak.setText("请输入正确的手机号码");
                } else {
                    // 这个方法是用来判断手机验证码相关的
                    initCode();
                }
            }

        });
        mUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (mCoodeEt.getText().toString().matches(verificationCodes)) {
//                    mUp.setBackgroundColor(R.color.colorred);
                    mSpeak.setText("验证码正确");

                } else {
//                    Toast.makeText(AuthenticationActivity.this, "错误", Toast.LENGTH_SHORT).show();
                    mSpeak.setText("验证码错误");
                    mSpeak.setVisibility(View.VISIBLE);
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
        mAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AuthenticationActivity.this, AboutyaofunActivity.class));
            }
        });
    }

    private void initCode() {

        //切割字符串将空格清除
        String[] split = phoneNum.split(" ");
        //重新拼接手机号
        phone = split[0] + split[1] + split[2];
        Log.i("验证验证码", "initCode: " + phone);
        // 判断输入的手机号 是否符合手机号规范
        if (phone.matches("^13[0-9]{1}[0-9]{8}$|15[0125689]{1}[0-9]{8}$|18[0-3,5-9]{1}[0-9]{8}$|17[0-3,5-9]{1}[0-9]{8}$|19[0-3,5-9]{1}[0-9]{8}$|16[0-3,5-9]{1}[0-9]{8}$")) {
            // 开始执行倒计时的方法
            time.start();
            Map<String, String> map = new HashMap<>();
            map.put("phone", phone);
            map.put("code", code);
//            map.put("key", key);
            //注册、找回密码、绑定手机号、实名认证、提现
            map.put("purpose", "实名认证");
            //请求时间
            String time = Utils.getNowDate();
            map.put("request_start_time", time);
            //sign2=md5(请求时间+手机号+IOS密钥)
            map.put("sign2", Utils.md5(time + phone + Utils.Signs));
            basePresenter.getVerificationCode(map);
            Log.i("验证验证码", "initData: " + map.toString());
        } else {

            // 如果手机号码不符合规则 提示用户正确输入手机号 红色文字显示 字体变成"请输入正确的手机号码"
            mSpeak.setVisibility(View.VISIBLE);
            mSpeak.setText("请输入正确的手机号码");

        }
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        //注册、找回密码、绑定手机号、实名认证、提现
        map.put("purpose", "实名认证");
        //请求时间
        String time = Utils.getNowDate();
        map.put("request_start_time", time);
        //sign2=md5(请求时间+手机号+IOS密钥)
        map.put("sign2", Utils.md5(time + phone + Utils.Signs));
        basePresenter.getVerifyCode(map);
    }

    @Override
    protected void initData2() {


    }

    @Override
    protected int getlayout() {
        return R.layout.activity_authentication;
    }

    @Override
    protected AuthenticationPresenter initPresenter() {
        return new AuthenticationPresenter();
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void getVerificationCodesSuccess(BaseBean<CodeBean> bean) {
        verificationCodes = bean.getData().getCode();
        key = bean.getData().getKey();
        Log.e("验证验证码", "initData3: " + code1 + "\n" + phone + "\n" + key);
        Log.i("实名验证验证码", "getVerificationCodesFail: " + bean.getData().toString());

    }

    @Override
    public void getVerificationCodesFail(String msg) {
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.i("实名验证", "getVerificationCodesFail: " + msg);
        mSpeak.setVisibility(View.VISIBLE);
        mSpeak.setText(msg);

    }

    @Override
    public void goVerifySuccess(BaseBean<CodeBean> bean) {
        // 验证验证码成功方法 成功后跳入实名身份证页面
        CodeBean data = bean.getData();
        Log.i("实名认证验证", "goVerifyFail: " + data.toString());
        Toast.makeText(this, "验证成功 ", Toast.LENGTH_SHORT).show();
        //跳转到实名验证页面
        startActivity(new Intent(AuthenticationActivity.this, AutonymActivity.class));
    }

    @Override
    public void goVerifyFail(String msg) {
        Log.i("实名认证验证", "goVerifyFail: " + msg);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO:OnCreate Method has been created, run FindViewById again to generate code
        setContentView(R.layout.activity_authentication);
        initView();
    }
    // 倒计时 验证码

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mGiveCode.setClickable(false);
            mGiveCode.setText(millisUntilFinished / 1000 + "s");
        }

        @Override
        public void onFinish() {
            mGiveCode.setText("重新发送");
            mGiveCode.setClickable(true);
            if (mGiveCode.equals("重新发送")) {
                mAuthenticationClear.setVisibility(View.GONE);
            }
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
