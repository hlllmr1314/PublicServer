package com.haley.appserver.controller.net.request;

import com.haley.appserver.controller.net.convert.AppServerConverterFactory;
import com.haley.appserver.controller.net.convert.StringConverter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by huanglei on 8/2/16.
 */
public class GetIdCardRequest {

    public static final String rootUrl = "http://115.29.167.204:8888/";

    public static void requestIdCard(String number, final RequestCallBack back) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(rootUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        AppServerService service = retrofit.create(AppServerService.class);

        service.getIdCard(number).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String appCategoryEntities = response.body();
                    if (back != null)
                        back.back(true, appCategoryEntities);
                } else {
                    if (back != null)
                        back.back(false, null);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if (back != null)
                    back.back(false, null);
            }
        });
    }

}
