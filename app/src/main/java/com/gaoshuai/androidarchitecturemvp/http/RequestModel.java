package com.gaoshuai.androidarchitecturemvp.http;

import com.gaoshuai.androidarchitecturemvp.bean.BaseResponsePageBean;
import com.gaoshuai.androidarchitecturemvp.bean.CookBean;
import com.gaoshuai.androidarchitecturemvp.constant.HttpConstant;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;

/**
 * Created by gaoshuai on 2019/3/20.
 * Describe：同一base地址 请求类
 */
public class RequestModel extends BaseRequestModel {
    private static RequestModel requestModel;
    private final RetrofitInterface retrofitService;

    public RequestModel() {
        retrofitService = RetrofitWrapper
                .getInstance(HttpConstant.BASE_URL)
                .create(RetrofitInterface.class);
    }

    public static RequestModel getInstance() {
        if (requestModel == null) {
            requestModel = new RequestModel();
        }
        return requestModel;
    }

    public FlowableSubscriber queryCooks(Map<String, String> map, CustomSubscriber<BaseResponsePageBean<CookBean>> subscriber) {
        Flowable<BaseResponsePageBean<CookBean>> flowAble = retrofitService.queryCooks(map)
                .flatMap(new HttpResponseFunc<BaseResponsePageBean<CookBean>>());
        subscribe(flowAble, subscriber);
        return subscriber;
    }
}
