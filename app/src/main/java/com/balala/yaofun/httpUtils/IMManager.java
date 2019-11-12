package com.balala.yaofun.httpUtils;

import android.net.Uri;

import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.util.ForLog;

import java.util.List;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;

import static com.balala.yaofun.MyApp.signOut;

public class IMManager {

    public static void connectRongIM(String token){
        ForLog.e("RongIM---token:"+token);
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                ForLog.e("RongIM---Token 错误");
//                ApiModel.getRCToken(null, new ResultCallBack<BaseBean<String>>() {
//                    @Override
//                    public void onSuccess(BaseBean<String> bean) {
//                        ForLog.e("请求成功" + bean);
//                        connectRongIM(bean.getData());
//                    }
//
//                    @Override
//                    public void onFail(String msg) {
//                        ForLog.e("RongIM---请求获取token失败:"+msg);
//                    }
//                });
            }
            @Override
            public void onSuccess(String userid) {
                ForLog.e("RongIM---onSuccess:"+userid);
                //融云链接成功之后，监听状态
                initConnectStateChangeListener();
                initConversationList();
            }
            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                ForLog.e("RongIM---onError:"+errorCode);
            }
        });
    }

    public static void initConversationList() {
        RongIMClient.getInstance().getConversationList(new RongIMClient.ResultCallback<List<Conversation>>() {
            @Override
            public void onSuccess(List<Conversation> conversations) {
                ForLog.e("聊天列表 成功");
                for(Conversation conversation:conversations){
                    ForLog.e("聊天列表"+conversation.getTargetId()+"---"+conversation.getSenderUserId()+conversation.getSenderUserName());
                    ApiModel.getUserDetail(conversation.getTargetId(), null,new ResultCallBack<BaseBean<UserBean>>() {
                        @Override
                        public void onSuccess(BaseBean<UserBean> bean) {
                            ForLog.e("融云用户信息" + bean);
                                    RongIM.getInstance().setCurrentUserInfo(new UserInfo(conversation.getTargetId(),
                                            bean.getData().getNick_name(),
                                            Uri.parse(bean.getData().getImages())));

                        }

                        @Override
                        public void onFail(String msg) {
                            ForLog.e("RongIM---请求获取token失败:"+msg);
                        }
                    });
                }
//                ThreadManager.getInstance().runOnWorkThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        convertConversationAndSetValue(conversations);
//                    }
//                });
            }
            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                ForLog.e("聊天列表 失败"+errorCode);
            }
        });
    }

    /**
     * 初始化连接状态监听
     */
    public static void initConnectStateChangeListener() {
        RongIM.setConnectionStatusListener(new RongIMClient.ConnectionStatusListener() {
            @Override
            public void onChanged(ConnectionStatus connectionStatus) {
                ForLog.e("连接状态"+connectionStatus);
                if (connectionStatus.equals(ConnectionStatus.KICKED_OFFLINE_BY_OTHER_CLIENT)) {
                    //被其他提出时，需要返回登录界面
                    ToastUtil.showShort("该账号已经在其他设备登录");
                    signOut();
                } else if (connectionStatus == ConnectionStatus.TOKEN_INCORRECT) {
                    //TODO token 错误时，重新登录
                }
            }
        });
    }



    /**
     * 退出
     */
    public static void IMLogout() {
        try{
            RongIM.getInstance().logout();
        }catch (Exception e){
            ForLog.e("退出融云出现了错误："+e);
        }
    }
}


