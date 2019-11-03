package com.balala.yaofun.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import android.widget.TextView;
import android.widget.Toast;

import com.balala.yaofun.R;
import com.balala.yaofun.base.BaseActivity;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.CodeBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.VerificationCode;
import com.balala.yaofun.httpUtils.ToastUtil;
import com.balala.yaofun.presenter.FrogetpasswardPresenter;
import com.balala.yaofun.util.ToastUtils;
import com.balala.yaofun.view.FrogetpasswardView;
import com.balala.yaofun.util.TextWatcherUtil;

import java.util.HashMap;
import java.util.Map;


public class FrogetpasswardActivity extends BaseActivity<FrogetpasswardPresenter, FrogetpasswardView> implements FrogetpasswardView {


    private static final String TAG = "xuzhiqiaa";
    private LinearLayout mFrogetEdits;
    private EditText mEphone;
    private TextView mGotCode;
    private EditText mECode;
    private EditText mEtpassword;
    private Button mFrogetYes;
    private TimeCount time;
    private String phoneNum;
    private String phone;
    private String code;
    private String key;
    private CheckBox mFrogeteyes;
    private String password;
    private ImageView mFrogetclear;
    private ImageView froget_clear2;
    private int code1;


    @Override
    protected int getlayout() {
        return R.layout.activity_frogetpassward;
    }

    @Override
    protected void initView() {
        mFrogetEdits = findViewById(R.id.froget_edits);
        mEphone = findViewById(R.id.et6);
        mGotCode = findViewById(R.id.got_code);
        mECode = findViewById(R.id.et7);
        mEtpassword = findViewById(R.id.et8);
        mFrogetYes = findViewById(R.id.froget_yes);
        mFrogeteyes = findViewById(R.id.froget_eyes);
        mFrogetclear = findViewById(R.id.froget_clear);
        froget_clear2 = findViewById(R.id.froget_clear2);
//        froget_eyes
        // 点击事件
        initviews();
        // 验证码倒计时
        time = new TimeCount(60000, 1000);

    }

    private void initviews() {

        // 点击返回登陆页面
        mFrogetEdits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FrogetpasswardActivity.this, GeneralActivity.class));
            }
        });

        //账号输入的点击事件
        mEphone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count < 0) {
                    mFrogetclear.setVisibility(View.GONE);
                } else {
                    mFrogetclear.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    mFrogetclear.setVisibility(View.GONE);
                }
            }

        });
        // 清除的点击事件
        mFrogetclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEphone.setText("");
                mFrogetclear.setVisibility(View.GONE);
            }
        });
        //密码输入的点击事件
        mEtpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count < 0) {
                    froget_clear2.setVisibility(View.GONE);
                } else {
                    froget_clear2.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    froget_clear2.setVisibility(View.GONE);
                }
            }

        });
        // 清除的点击事件
        froget_clear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtpassword.setText("");
                froget_clear2.setVisibility(View.GONE);
            }
        });

        //获取验证码
        mGotCode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ToastUtil.showLong("获取验证码");
                //比较手机号是否符合规则 符合规则弹出"获取验证码"并且验证码开始倒计时，红色文字隐藏
                phoneNum = mEphone.getText().toString().trim();
                // 判断手机号为空或者小于11位时 也可以点击
                if (phoneNum.length() <= 0 || phoneNum.length() <= 11) {

                    ToastUtil.showLong("请输入正确的手机号码");

                } else {
                    // 这个方法是用来判断手机验证码相关的
                    initCode();

                }
            }

        });

        // 确定更改密码点击事件
        mFrogetYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "开始更改密码 ");
                phone = mEphone.getText().toString();
                code = mECode.getText().toString();
                password = mEtpassword.getText().toString();
                if (phone.isEmpty() || code.isEmpty() || password.isEmpty()) {
                    Toast.makeText(FrogetpasswardActivity.this, "不能为空", Toast.LENGTH_SHORT).show();

                } else {
                    initData3();
                }


            }


        });

        // 把手机号码用空格隔开
        TextWatcherUtil.addPhoneNumberTextWatcher(mEphone, new TextWatcherUtil.Callback() {
            @Override
            public void callback() {
                //todo edittext changed后回调


            }
        });
        // 点击眼睛查看或隐藏密码
        mFrogeteyes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Drawable drawable = FrogetpasswardActivity.this.getResources().getDrawable(R.drawable.opean_eye);
                    drawable.setBounds(0, 0, 50, 50);
                    mFrogeteyes.setButtonDrawable(drawable);
                    mEtpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示密码
                } else {
                    Drawable drawable = FrogetpasswardActivity.this.getResources().getDrawable(R.drawable.colse_eye);
                    drawable.setBounds(0, 0, 50, 50);
                    mFrogeteyes.setButtonDrawable(drawable);
                    mEtpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏密码
                }
                mEtpassword.setSelection(TextUtils.isEmpty(mEtpassword.getText()) ? 0 : mEtpassword.length());//光标挪到最后
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
            Toast.makeText(FrogetpasswardActivity.this, "获取验证码", Toast.LENGTH_SHORT).show();
            // 开始执行倒计时的方法
            time.start();
//            mRedSpeak.setVisibility(View.GONE);
            Log.i(TAG, "手机号码 " + phone);
            // 获取手机号码 返回后台进行解析
            initData();
            // 如果手机号码不符合规则 提示用户正确输入手机号 红色文字显示 字体变成"请输入正确的手机号码"
        } else {
//            Toast.makeText(FrogetpasswardActivity.this, " 请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            ToastUtil.showLong("请输入正确的手机号码");
//
//            mRedSpeak.setVisibility(View.VISIBLE);
//            mRedSpeak.setText("请输入正确的手机号码");
        }
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        basePresenter.getVerificationCode(map);
        Log.i(TAG, "initData: " + phone);

    }

    @Override
    protected void initData2() {
        Log.e("xuzhiqi", "initData3: " + code);
        Log.e("xuzhiqi", "initData3: " + phone);
        Log.e("xuzhiqi", "initData3: " + key);
        if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(code) && !TextUtils.isEmpty(key)) {
            Map<String, String> map = new HashMap<>();
            map.put("phone", phone);
            map.put("code", code);
            map.put("key", key);
//            basePresenter.getVerificationData(phone, code, key);
            basePresenter.getVerificationCode(map);
        }
    }

    private void initData3() {

        Log.i("确定更改密码点击事件", "onSuccessAlterpassward: " + phone + "\n" + code + "\n" + password + "\n" + key + "\n");
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("code", code);
        map.put("key", key);
        map.put("password", password);
        basePresenter.goChangePassword(map);

    }

    @Override
    protected FrogetpasswardPresenter initPresenter() {
        return new FrogetpasswardPresenter();
    }


    @Override
    public void getVerificationCodesSuccess(BaseBean<CodeBean> bean) {

    }

    @Override
    public void getVerificationCodesFail(String msg) {
        Log.i(TAG, "onFail: " + msg);
    }

    @Override
    public void goChangePasswordSuccess(BaseBean<UserBean> bean) {
        ToastUtil.showLong("更改密码成功");
        startActivity(new Intent(FrogetpasswardActivity.this, GeneralActivity.class));
//        finish();
    }

    @Override
    public void goChangePasswordFail(String msg) {
        Log.i(TAG, "onFail: " + msg);
    }


    // 倒计时 验证码

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
//            mGotCode.setBackgroundColor(Color.parseColor("#ffffff"));
            mGotCode.setClickable(false);
            mGotCode.setText("(" + millisUntilFinished / 1000 + "s" + ")重新获取");
        }

        @Override
        public void onFinish() {
            mGotCode.setText("重新发送");
            mGotCode.setClickable(true);
//            mGotCode.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            //当isShouldHideInput(v, ev)为true时，表示的是点击输入框区域，则需要显示键盘，同时显示光标，反之，需要隐藏键盘、光标
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    //处理Editext的光标隐藏、显示逻辑
                    mEphone.clearFocus();
                    mECode.clearFocus();
                    mEtpassword.clearFocus();
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
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
