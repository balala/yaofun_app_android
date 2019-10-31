package com.balala.yaofun.httpUtils;

import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.util.ForLog;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class GsonResponseBodyConverter < T > implements Converter<ResponseBody,
        T > {
    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    /**
     * 针对数据返回成功、错误不同类型字段处理
     */
    @Override public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        try {
            // 这里的type实际类型是 LoginUserEntity<User>  User就是user字段的对象。
            BaseBean result = gson.fromJson(response, BaseBean.class);
            boolean code = result.isSuccess();
            if (code) {
                return gson.fromJson(response, type);
            } else {
                ResultException errResponse = gson.fromJson(response, ResultException.class);
                ForLog.e("请求失败的逻辑"+errResponse);
                throw errResponse;
            }
        } finally {
            value.close();
        }
    }
}