package com.balala.yaofun.httpUtils;

import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.util.ForLog;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

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
        ForLog.i("网络请求数据response:"+response);
        try {
            BaseBean result = gson.fromJson(response, BaseBean.class);
            boolean code = result.isSuccess();
            if (code) {
                return gson.fromJson(response, type);
//                try {
//                    return gson.fromJson(response, type);
//                }catch (Exception e){
//                    if(type.toString().equals("com.balala.yaofun.bean.BaseBean<com.balala.yaofun.bean.UserBean>")){
//                        JSONObject jsonObject=new JSONObject(response);
//                        String data=  jsonObject.get("data");
//                        Object autograph= (JSONObject) data.get("autograph");
//                        ForLog.e("获取到签名"+autograph);
//                        ForLog.e("获取到签名2:"+autograph.getClass());
//                        ForLog.e("获取到签名3:"+(autograph instanceof String));
//                        if(autograph  instanceof String){
//
//                        }else{
//                            data.put("autograph",((JsonArray) autograph).get(0));
//                            ForLog.e("修改列表为字符串"+data.toString(4));
//                            jsonObject.put("data",data);
//                        }
//                        ForLog.e("报错的数据：=>"+jsonObject.toString()+"<-");
//                        return gson.fromJson(jsonObject.toString(), type);
//                    }else{
//                        throw e;
//                    }
//                }
            } else {
                ResultException errResponse = gson.fromJson(response, ResultException.class);
                ForLog.e("请求失败的逻辑"+errResponse);
                throw errResponse;
            }
        } catch (Exception e){
            ResultException errResponse = gson.fromJson(response, ResultException.class);
            ForLog.e("请求失败的逻辑2:"+errResponse);
            throw errResponse;
        }
        finally {
            value.close();
        }
    }
}