package com.balala.yaofun.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.balala.yaofun.adapter.ConversationListAdapterEx;
import com.balala.yaofun.util.ForLog;

import java.util.List;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imkit.fragment.IHistoryDataResultCallback;
import io.rong.imkit.widget.adapter.ConversationListAdapter;
import io.rong.imlib.model.Conversation;

//查看 ConversationListFragment 类，选择您需要重写的方法。
public class SubConversationListFragment extends ConversationListFragment {

    private ConversationListAdapterEx mAdapter;

    public void setAdapter(ConversationListAdapterEx adapter) {
        ForLog.e("融云消息重写：setAdapter");
        mAdapter = adapter;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ForLog.e("融云消息重写：onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        ForLog.e("融云消息重写：onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    //重写此方法，设置自己的adapter
    @Override
    public ConversationListAdapter onResolveAdapter(Context context) {
        ForLog.e("融云消息重写：ConversationListAdapter");
        if (mAdapter == null) {
            mAdapter = new ConversationListAdapterEx(context);
        }
        return mAdapter;
    }

    //重写此方法，来填充自定义数据到会话列表界面。
    @Override
    public void getConversationList(Conversation.ConversationType[] conversationTypes,
                                    IHistoryDataResultCallback<List<Conversation>> callback, boolean isLoadMore) {
        ForLog.e("融云消息重写：getConversationList");
        super.getConversationList(conversationTypes, callback,isLoadMore);
    }
    //重写此方法，来填充头部布局。无会话时不显示，需要在布局中添加填充的头部布局。
    @Override
    protected List<View> onAddHeaderView() {
        ForLog.e("融云消息重写：onAddHeaderView");
        List<View> headerViews = super.onAddHeaderView();
        TextView textView = new TextView(this.getActivity());
        textView.setGravity(Gravity.CENTER);
        textView.setText("这是添加的头部布局");
        headerViews.add(textView);
        return headerViews;
    }
}
