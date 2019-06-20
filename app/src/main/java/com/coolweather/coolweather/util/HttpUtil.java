package com.coolweather.coolweather.util;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
    public static void sendOkHttpRequest(final String address, okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);

    }

    /**
     *测试方法
     */
    public static void ss(final String address){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder()
                            .url(address)
                            .build();
                    Response response=client.newCall(request).execute();
                    Log.d("ddd",response.body().string());
                }catch (Exception e){

                }
            }
        }).start();
    }
}
