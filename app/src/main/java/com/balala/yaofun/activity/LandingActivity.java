package com.balala.yaofun.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.balala.yaofun.R;
import com.balala.yaofun.base.BaseActivity;
import com.balala.yaofun.bean.AccountBean;
import com.balala.yaofun.bean.result.DefaultBean;
import com.balala.yaofun.mylandingmvp.LandingPresenter;
import com.balala.yaofun.mylandingmvp.LandingView;
import com.balala.yaofun.util.CustomEditText;
import com.balala.yaofun.util.TextWatcherUtil;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class LandingActivity extends BaseActivity<LandingPresenter, LandingView> implements LandingView {


    // AAppID：wx24009bcc9adc6318
    private static final String APP_ID = "wx24009bcc9adc6318";
    private static final String TAG = "xzq";

    // IWXAPI 是第三方app和微信通信的openApi接口
    private IWXAPI api;
    private ImageView mEdit;
    private RelativeLayout mRegister;
    private CustomEditText mEt1;
    private CustomEditText mEt2;
    private CheckBox mWatch;
    private TextView mFroget;
    private Button mActivityGo;
    private ImageView mWechat;
    private String phone;
    private String msg;
    private String password;

    @Override
    protected int getlayout() {
        return R.layout.activity_main;
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
        initviews();

    }

    // 点击事件
    private void initviews() {
        // 点击跳转到注册页面
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, RegisterActivity.class));

            }
        });
        // 点击立即注册 开始解析和进入首页
        mActivityGo.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
//                Toast.makeText(LandingActivity.this, "开始解析登陆接口", Toast.LENGTH_SHORT).show();
                // 设置跳转到首页
                phone = mEt1.getText().toString().replaceAll(" ", "");
                //重新拼接手机号
                password = mEt2.getText().toString();

                Log.e("xuzhiqi", "initData: " + password + "\n" + phone);
                basePresenter.getLandingData(phone, password);
                // 提示用户登陆成功

            }
        });

        // 点击忘记密码 跳入忘记密码的页面
        mFroget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, FrogetpasswardActivity.class));
            }
        });

        // 点击微信登陆
        mWechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LandingActivity.this, "微信登陆", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(LandingActivity.this, WXEntryActivity.class));
                // 微信登陆方法
                initWechat();
                // 微信登陆授权方法
                initSou();
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
                Toast.makeText(LandingActivity.this, "查看密码", Toast.LENGTH_SHORT).show();
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

    // 登陆成功方法
    @Override
    public void onSuccessLanding(DefaultBean bean) {
        msg = bean.getMsg();
        Toast.makeText(this, "登陆成功方法" + bean.getMsg(), Toast.LENGTH_SHORT).show();
        Log.i("xuzhiqidsdwd", "onSuccessLanding: " + bean.getMsg());
    }

    // 登陆失败方法
    @Override
    public void onErrorLanding(String error) {

        Log.i("xuzhiqifndkf", "onErrorLanding: " + error);
    }

    // baseActivity 里面的方法 用作解析传递
    @Override
    protected void initData() {
//        Log.i(TAG, "initData: " + phone);
//        basePresenter.getLandingData(phone, password);
        Log.i(TAG, "initData: "+phone);

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

    // 授权微信登陆
    private void initSou() {

        if (!api.isWXAppInstalled()) {
        } else {
            final SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "wechat_sdk_demo_test";
            api.sendReq(req);
        }

    }

    // 微信登陆
    private void initWechat() {

        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(this, APP_ID, true);

        // 将应用的appId注册到微信
        api.registerApp(APP_ID);

        //建议动态监听微信启动广播进行注册到微信
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // 将该app注册到微信
                api.registerApp(APP_ID);
            }
        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
        //初始化一个 WXTextObject 对象，填写分享的文本内容
        WXTextObject textObj = new WXTextObject();
        //        textObj.text = "";

        //用 WXTextObject 对象初始化一个 WXMediaMessage 对象
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = textObj;
        //        msg.description = text;

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());  //transaction字段用与唯一标示一个请求
        req.message = msg;

        //调用api接口，发送数据到微信
        api.sendReq(req);
    }


}
