package com.balala.yaofun.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.balala.yaofun.R;
import com.balala.yaofun.base.BaseActivity;
import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.presenter.ConversationPresenter;
import com.balala.yaofun.view.ConversationView;
import com.gyf.immersionbar.ImmersionBar;

import java.util.Locale;

import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.model.Conversation;

// 会话页面
public class ConversationActivity extends BaseActivity<ConversationPresenter, ConversationView> implements ConversationView{
    /**
     * 对方id
     */
    private String targetId;
    /**
     * 会话类型
     */
    private Conversation.ConversationType conversationType;
    private String title;
    @Override
    protected int getlayout() {
        return R.layout.activity_conversation;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this)
                .statusBarColor(R.color.black) //导航栏背景色
//                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
//                .flymeOSStatusBarFontColor(R.color.colorAccent)
                .init();

        findViewById(R.id.back).setOnClickListener(v->{
            finish();
        });
        // 没有intent 的则直接返回
        Intent intent = getIntent();
        if (intent == null || intent.getData() == null) {
            finish();
            return;
        }
        targetId = intent.getData().getQueryParameter("targetId");
        conversationType = Conversation.ConversationType.valueOf(intent.getData()
                .getLastPathSegment().toUpperCase(Locale.US));
        title = intent.getData().getQueryParameter("title");

        FragmentManager fragmentManage = getSupportFragmentManager();
        ConversationFragment fragement = (ConversationFragment) fragmentManage.findFragmentById(R.id.conversation);
        Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                .appendPath("conversation").appendPath(conversationType.getName().toLowerCase())
                .appendQueryParameter("targetId", targetId).build();

        fragement.setUri(uri);
        ((TextView)findViewById(R.id.title)).setText(title);

    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initData2() {

    }


    @Override
    protected ConversationPresenter initPresenter() {
        return new ConversationPresenter();
    }
}
