package com.balala.yaofun.provider;

import android.content.Context;
import android.net.Uri;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.balala.yaofun.R;

import io.rong.imkit.model.ConversationProviderTag;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.widget.provider.PrivateConversationProvider;

//portraitPosition 用来控制头像的显示方式，它的值可以修改，它的值有：1：靠左显示， 2：靠右显示， 3：不显示。
@ConversationProviderTag(conversationType = "private", portraitPosition = 1)
public class CustomPrivateConversationProvider extends PrivateConversationProvider {

    @Override
    public View newView(Context context, ViewGroup viewGroup) {
        // 此处更换为自定义布局文件
        View result = LayoutInflater.from(context).inflate(R.layout.item_private_conversation_provider, (ViewGroup)null);
        // 使用自定义 ViewHolder
        ViewHolder holder = new ViewHolder();
        // ===> 此部分内容直接复制即可
        holder.title = (TextView)result.findViewById(io.rong.imkit.R.id.rc_conversation_title);
        holder.time = (TextView)result.findViewById(io.rong.imkit.R.id.rc_conversation_time);
        holder.content = (TextView)result.findViewById(io.rong.imkit.R.id.rc_conversation_content);
        holder.notificationBlockImage = (ImageView)result.findViewById(io.rong.imkit.R.id.rc_conversation_msg_block);
        holder.readStatus = (ImageView)result.findViewById(io.rong.imkit.R.id.rc_conversation_status);
        // <===|
        // 获取自定义 View
        holder.customView = result.findViewById(R.id.custom);
        result.setTag(holder);
        return result;
    }

    @Override
    public void bindView(View view, int position, UIConversation data) {
        super.bindView(view, position, data);
    }

    @Override
    public Spannable getSummary(UIConversation data) {
        return super.getSummary(data);
    }

    @Override
    public String getTitle(String userId) {
        return super.getTitle(userId);
    }

    @Override
    public Uri getPortraitUri(String userId) {
        return super.getPortraitUri(userId);
    }
    // 自定义 ViewHolder，可添加自定义布局控件
    class ViewHolder extends PrivateConversationProvider.ViewHolder {
        View customView;
    }
}
