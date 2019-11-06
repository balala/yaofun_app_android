package com.balala.yaofun.activity;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.balala.yaofun.R;
import com.balala.yaofun.base.BaseActivity;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.fragment.HomeFragment;
import com.balala.yaofun.httpUtils.ToastUtil;
import com.balala.yaofun.presenter.LandingPresenter;
import com.balala.yaofun.util.ForLog;
import com.balala.yaofun.util.ToastUtils;
import com.balala.yaofun.view.LandingView;
import com.balala.yaofun.util.TextWatcherUtil;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;

import static com.balala.yaofun.httpUtils.MyApp.goLogin;


public class LandingActivity extends BaseActivity<LandingPresenter, LandingView> implements LandingView {


    private static final String TAG = "xzq";

    private LinearLayout mEdit;
    private RelativeLayout mRegister;
    private com.balala.yaofun.util.CustomEditText mEt1;
    private EditText mEt2;
    private CheckBox mWatch;
    private TextView mFroget;
    private Button mActivityGo;
    private ImageView mWechat;
    private String phone;
    private String msg;
    private String password;
    private View landing_clear;
    private View decorView;
    private FragmentManager fragmentManager;
    private HomeFragment mFragment;

    //    private List<UserEvent> mdata;;
    @Override
    protected int getlayout() {
        return R.layout.activity_landing;
    }

    @Override
    protected void initView() {
        mEdit = findViewById(R.id.edit);
        mRegister = findViewById(R.id.register);
        mEt1 = findViewById(R.id.et1);
        mEt2 = findViewById(R.id.et2);
        mWatch = findViewById(R.id.watch);
        mFroget = findViewById(R.id.froget);
        mActivityGo = findViewById(R.id.activity_go);
        mWechat = findViewById(R.id.wechat);
        landing_clear = findViewById(R.id.landing_clear);
        initviews();

    }

    // 点击事件
    private void initviews() {

        mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                           finish();
                startActivity(new Intent(LandingActivity.this, GeneralActivity.class));
            }
        });

        //输入的点击事件
        mEt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count < 0) {
                    landing_clear.setVisibility(View.GONE);
                } else {
                    landing_clear.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    landing_clear.setVisibility(View.GONE);
                }
            }

        });
        // 清除的点击事件
        landing_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEt2.setText("");
                landing_clear.setVisibility(View.GONE);
            }
        });
        // 点击跳转到注册页面
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, RegisterActivity.class));
                finish();

            }
        });

        // 点击登陆 开始解析和进入首页
        mActivityGo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 设置跳转到首页
                phone = mEt1.getText().toString().replaceAll(" ", "");
                //重新拼接手机号
                password = mEt2.getText().toString();
                Log.e("xuzhiqi", "initData: " + password + "\n" + phone);
                if (password.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(LandingActivity.this, "请输入正确输入", Toast.LENGTH_SHORT).show();
                } else {
                    Map<String,String> map=new HashMap<>();
                    map.put("phone",phone);
                    map.put("password",password);
                    basePresenter.phonePwdLogin(map);
                }
                // 提示用户登陆成功
//                startActivity(new Intent(LandingActivity.this, GeneralActivity.class));

            }
        });

        // 点击忘记密码 跳入忘记密码的页面
        mFroget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, FrogetpasswardActivity.class));
                finish();
            }
        });

        // 点击微信登陆
        mWechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wechatLogin();
            }
        });

        //点击查看密码

        mWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mWatch.isClickable();
                if (mWatch.isClickable()) {
                    mWatch.setClickable(true);
                }
//                ToastUtil.showLong("查看密码");
            }

        });


        // 把手机号码用空格隔开
        TextWatcherUtil.addPhoneNumberTextWatcher(mEt1, new TextWatcherUtil.Callback() {
            @Override
            public void callback() {
                //todo edittext changed后回调

            }
        });


        // 点击眼睛查看或隐藏密码
        mWatch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Drawable drawable = LandingActivity.this.getResources().getDrawable(R.drawable.opean_eye);
                    drawable.setBounds(0, 0, 50, 50);
                    mWatch.setButtonDrawable(drawable);
                    mEt2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示密码
                } else {
                    Drawable drawable = LandingActivity.this.getResources().getDrawable(R.drawable.colse_eye);
                    drawable.setBounds(0, 0, 50, 50);
                    mWatch.setButtonDrawable(drawable);
                    mEt2.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏密码
                }
                mEt2.setSelection(TextUtils.isEmpty(mEt2.getText()) ? 0 : mEt2.length());//光标挪到最后
            }
        });
    }


    @Override
    public void phonePwdLoginSuccess(BaseBean<UserBean> bean) {
        //账户秘密登陆成功
        loginSuccess(bean);
        ForLog.e("手机号秘密登陆成功"+bean);
    }

    @Override
    public void phonePwdLoginFail(String msg) {
        ForLog.e("打印错误信息："+msg);
        ToastUtil.showShort(msg);
    }

    @Override
    public void wxLoginOrRegistSuccess(BaseBean<UserBean> bean) {
        //微信登陆成功
        loginSuccess(bean);
    }

    @Override
    public void wxLoginOrRegistFail(String msg) {
        ToastUtil.showShort(msg);
    }
    private void loginSuccess(BaseBean<UserBean> bean){
        goLogin(bean.getData());
        this.finish();
    }

    // baseActivity 里面的方法 用作解析传递
    @Override
    protected void initData() {
        Log.i(TAG, "initData: " + phone);
    }

    @Override
    protected void initData2() {


    }


    // P层桥梁
    @Override
    protected LandingPresenter initPresenter() {
        return new LandingPresenter();
    }


    //判断点击输入框区域，则需要显示键盘，同时显示光标，反之，需要隐藏键盘、光标
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
                    mEt1.clearFocus();
                    mEt2.clearFocus();
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

    // 获取文本框点击事件
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

    private void wechatLogin(){
        UMShareAPI.get(this).getPlatformInfo(LandingActivity.this,
                SHARE_MEDIA.WEIXIN, umAuthListener);
    }
    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
            ForLog.e(platform.toString());
        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            ForLog.e(data.toString());
            basePresenter.wxLoginOrRegist(data);
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            ForLog.e(t.getMessage());
            ToastUtil.showShort("授权失败，请重试");
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            ForLog.e(action+"");
            ToastUtils.showShort("取消了授权");
        }
    };


}
