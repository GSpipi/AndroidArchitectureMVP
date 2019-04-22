package com.gaoshuai.androidarchitecturemvp.http;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by gaoshuai on 2019/3/23.
 * Describe：同一请求接口类  基类
 */
public class BaseRequestModel {
    public <T> void subscribe(Flowable<T> flowAble, FlowableSubscriber<T> subscriber) {
        flowAble.subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
