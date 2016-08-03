package com.haley.appserver.controller.net.request;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by huanglei on 8/2/16.
 */
public interface AppServerService {

    /**
     * 获取身份证基本信息
     *
     * @return
     */
    @Multipart
    @POST("getIdCard")
    Call<String> getIdCard(@Part("number") String number);

}
