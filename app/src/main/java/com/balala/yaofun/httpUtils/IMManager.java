package com.balala.yaofun.httpUtils;

import com.balala.yaofun.util.ForLog;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

import static com.balala.yaofun.httpUtils.MyApp.signOut;

public class IMManager {
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
        RongIM.getInstance().logout();
    }
}


