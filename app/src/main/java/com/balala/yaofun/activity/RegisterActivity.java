package com.balala.yaofun.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.balala.yaofun.R;
import com.balala.yaofun.base.BaseActivity;
import com.balala.yaofun.bean.VerificationBean;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.VerificationCode;
import com.balala.yaofun.myregistermvp.MyPresenter;
import com.balala.yaofun.myregistermvp.MyView;
import com.balala.yaofun.util.CustomEditText;
import com.balala.yaofun.util.TextWatcherUtil;
import com.balala.yaofun.webview.AboutyaofunActivity;

import okhttp3.logging.HttpLoggingInterceptor;

//
public class RegisterActivity extends BaseActivity<MyPresenter, MyView> implements MyView {

    private static final String TAG = "xzq";

    private String phone;
    private String phoneNum;
    private String code;
    private VerificationBean verificationBean;

    // 从发送验证码的接口里面解析出来的 key 和 code
    private String key;
    private LinearLayout mFrogetEdits;
    private RelativeLayout mRegister;
    private CustomEditText mEtPhone;
    private TextView mGetCode;
    private ImageView mClear2;
    private EditText mEtIdentifiing;
    private EditText mEtPassword;
    private CheckBox mEyes;
    private CheckBox mBox;
    private TextView mAbout;
    private TextView mRedSpeak;
    private Button mFrogetYes;
    private TimeCount time;


    @Override
    protected int getlayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        mFrogetEdits = findViewById(R.id.froget_edits);
        mRegister = findViewById(R.id.register);
        mEtPhone = findViewById(R.id.et_phone);
        mGetCode = findViewById(R.id.get_code);
        mEtIdentifiing = findViewById(R.id.et_identifiing);
        mEtPassword = findViewById(R.id.et_password);
        mEyes = findViewById(R.id.eyes);
        mBox = findViewById(R.id.box);
        mAbout = findViewById(R.id.about);
        mRedSpeak = findViewById(R.id.red_speak);
        mFrogetYes = findViewById(R.id.froget_yes);
        initOtherView();
        time = new TimeCount(60000, 1000);

    }

    //  点击事件
    private void initOtherView() {

        //点击 获取验证码 进行以下操作
        mGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //比较手机号是否符合规则 符合规则弹出"获取验证码"并且验证码开始倒计时，红色文字隐藏
                phoneNum = mEtPhone.getText().toString().trim();
                // 判断手机号为空或者小于11位时 也可以点击
                if (phoneNum.length() <= 0 || phoneNum.length() <= 11) {

                    Toast.makeText(RegisterActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();

                } else {
                    // 这个方法是用来判断手机验证码相关的
                    initCode();
                }
            }

        });

        //跳转登陆页面
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LandingActivity.class));

            }
        });


        //取消（返回登陆页面）
        mFrogetEdits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LandingActivity.class));
            }
        });


        //跳转到关于要FUN页面
        mAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, AboutyaofunActivity.class));
            }
        });
        // 点击立即注册以后进行判断验证码正确
        mFrogetYes.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "开始验证验证码", Toast.LENGTH_SHORT).show();
                // 验证验证码
                code = mEtIdentifiing.getText().toString().trim();
                Log.e("xuzhiqi", "initData3: " + code);
                Log.e("xuzhiqi", "initData3: " + phone);
                Log.e("xuzhiqi", "initData3: " + key);
                initData2();
            }
        });
        // 验证手机号码
        TextWatcherUtil.addPhoneNumberTextWatcher(mEtPhone, new TextWatcherUtil.Callback() {
            @Override
            public void callback() {
                //todo edittext changed后回调

            }
        });

        // 点击眼睛查看或隐藏密码
        mEyes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Drawable drawable = RegisterActivity.this.getResources().getDrawable(R.drawable.colse_eye);
                    drawable.setBounds(0, 0, 50, 50);
                    mEyes.setButtonDrawable(drawable);
                    mEtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示密码
                } else {
                    Drawable drawable = RegisterActivity.this.getResources().getDrawable(R.drawable.opean_eye);
                    drawable.setBounds(0, 0, 50, 50);
                    mEyes.setButtonDrawable(drawable);
                    mEtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏密码
                }
                mEtPassword.setSelection(TextUtils.isEmpty(mEtPassword.getText()) ? 0 : mEtPassword.length());//光标挪到最后
            }
        });

        // 把手机号码用空格隔开
        TextWatcherUtil.addPhoneNumberTextWatcher(mEtPhone, new TextWatcherUtil.Callback() {
            @Override
            public void callback() {
                //todo edittext changed后回调


            }
        });

    }


    private void initCode() {
        //切割字符串将空格清除
        String[] split = phoneNum.split(" ");
        //重新拼接手机号
        phone = split[0] + split[1] + split[2];
        Log.e("手机号码：", phone);
        // 判断输入的手机号 是否符合手机号规范
        if (phone.matches("^13[0-9]{1}[0-9]{8}$|15[0125689]{1}[0-9]{8}$|18[0-3,5-9]{1}[0-9]{8}$|17[0-3,5-9]{1}[0-9]{8}$|19[0-3,5-9]{1}[0-9]{8}$")) {
            Toast.makeText(RegisterActivity.this, "获取验证码", Toast.LENGTH_SHORT).show();
            // 开始执行倒计时的方法
            time.start();
            mRedSpeak.setVisibility(View.GONE);
            Log.i(TAG, "手机号码 " + phone);
            // 获取手机号码 返回后台进行解析

            initData();
            // 如果手机号码不符合规则 提示用户正确输入手机号 红色文字显示 字体变成"请输入正确的手机号码"
        } else {
            Toast.makeText(RegisterActivity.this, " 请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            mRedSpeak.setVisibility(View.VISIBLE);
            mRedSpeak.setText("请输入正确的手机号码");
        }

    }

    @Override
    protected void initData() {
        Log.i(TAG, "initData: " + phone);
        basePresenter.getData(phone);
    }

    @Override
    protected void initData2() {
        Toast.makeText(this, "跳过来了", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "跳过来了", Toast.LENGTH_SHORT).show();
        code = mEtIdentifiing.getText().toString().trim();
        Log.e("liangxq", "initData3: " + code);
        Log.e("liangxq", "initData3: " + phone);
        Log.e("liangxq", "initData3: " + key);
        if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(code) && !TextUtils.isEmpty(key)) {
            basePresenter.getData2(phone, code, key);
        }
    }


    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    public void onSS(VerificationResult verificationResult) {
        Log.i(TAG, "onSS: " + verificationResult.toString());
        key = verificationResult.getData().getKey();
        Log.e("xuzhiqi4", "onSSSS: " + key);

    }

    @Override
    public void onFail(String msg) {
        Log.i(TAG, "onFail: " + msg);
    }

    @Override
    public void onSuccessyanzheng(VerificationCode verificationBean) {
        Log.e("xuzhiqi4", "onSuccessyanzheng: " + verificationBean.toString());
        code = mEtIdentifiing.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        if (verificationBean.isSuccess() & !TextUtils.isEmpty(code) & !TextUtils.isEmpty(password)) {
            basePresenter.getData3(phone, code, key, password);
        }
        Toast.makeText(this, verificationBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFails(String msg) {

        Log.i(TAG, "onFails: " + msg);
    }

    @Override
    public void onSuccessRegister(String sucess) {

        Log.e("xuzhiqiaa", "onSuccessRegister: " + sucess.toString());
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }


    // 倒计时 验证码

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mGetCode.setBackgroundColor(Color.parseColor("#ffffff"));
            mGetCode.setClickable(false);
            mGetCode.setText("(" + millisUntilFinished / 1000 + "s" + ")重新获取");
        }

        @Override
        public void onFinish() {
            mGetCode.setText("重新发送");
            mGetCode.setClickable(true);
            mGetCode.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    //当isShouldHideInput(v, ev)为true时，表示的是点击输入框区域，则需要显示键盘，同时显示光标，反之，需要隐藏键盘、光标
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    //处理Editext的光标隐藏、显示逻辑
                    mEtPhone.clearFocus();
                    mEtPassword.clearFocus();
                    mEtIdentifiing.clearFocus();
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

    // 用于支持微信解析
    public static class HttpLogger implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            //
            Log.e("HttpLogger解析出来的", message);

        }

    }
}