package com.balala.yaofun.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.balala.yaofun.R;
import com.balala.yaofun.fragment.FunFragment;
import com.balala.yaofun.fragment.HomeFragment;
import com.balala.yaofun.fragment.MeFragment;
import com.balala.yaofun.fragment.MessageFragment;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.balala.yaofun.httpUtils.MyApp.hasLogin;


public class GeneralActivity extends AppCompatActivity {


    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.bottom_home)
    RadioButton bottom_home;
    @BindView(R.id.bottom_fun)
    RadioButton bottom_fun;
    @BindView(R.id.bottom_message)
    RadioButton bottom_message;
    @BindView(R.id.bottom_me)
    RadioButton bottom_me;
    @BindView(R.id.rg)
    RadioGroup rg;
    private ArrayList<Fragment> mFragments;
    private FragmentManager mFragmentManager;
    private int lastFragment;

    public static final int TYPE_HEARD = 0;
    private static final int TYPE_KONWLOGE = 1;
    private static final int TYPE_WX = 2;
    private static final int TYPE_NOTACTION = 3;
    private int selectPage=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        ButterKnife.bind(this);
        initFragments();
        initListener();
    }

    public void initFragments() {
        mFragments = new ArrayList<Fragment>();
        mFragments.add(new HomeFragment());
        mFragments.add(new FunFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new MeFragment());
        ShowFragmentone();
        // 隐藏下方虚拟键
        hideBottomUIMenu();
    }

    public void initListener() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                switch (checkedId) {
                    case R.id.bottom_home:
                        switchFragment(TYPE_HEARD);
                        selectPage=1;
                        break;
                    case R.id.bottom_fun:
                        switchFragment(TYPE_KONWLOGE);
                        selectPage=2;
                        break;
                    case R.id.bottom_message:
                        if(hasLogin()){
                            switchFragment(TYPE_WX);
                            selectPage=3;
                        }else{
                            doCheckedChangedFail();
                            startActivity(new Intent(GeneralActivity.this, LandingActivity.class));
                        }
                        break;
                    case R.id.bottom_me:
                        if(hasLogin()){
                            switchFragment(TYPE_NOTACTION);
                            selectPage=4;
                        }else{
                            startActivity(new Intent(GeneralActivity.this, LandingActivity.class));
                            doCheckedChangedFail();
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }
    private void doCheckedChangedFail(){
        switch (selectPage){
            case 2:
                bottom_fun.setChecked(true);
                break;
            case 3:
                bottom_message.setChecked(true);
                break;
            case 4:
                bottom_me.setChecked(true);
                break;
            default:
                bottom_home.setChecked(true);
                break;
        }
    }

    private void ShowFragmentone() {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.fl, mFragments.get(0));
        transaction.commit();
        bottom_home.setChecked(true);
    }

    private void switchFragment(int type) {
        Fragment fragment = mFragments.get(type);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        Fragment hideFragment = mFragments.get(lastFragment);
        if (!fragment.isAdded()) {
            transaction.add(R.id.fl, fragment);
        }
        transaction.hide(hideFragment);
        transaction.show(fragment);
        transaction.commit();
        lastFragment = type;
    }


    /**
     * 隐藏虚拟按键，并且全屏
     */
    protected void hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE;
        window.setAttributes(params);
    }

}
