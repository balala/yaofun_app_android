package com.balala.yaofun.httpUtils;


import java.io.IOException;

/**
 * @author xts
 *         Created by asus on 2019/4/2.
 */

public interface ResultCallBack<T> {
    void onSuccess(T bean) throws IOException;
    void onFail(String msg);
}
