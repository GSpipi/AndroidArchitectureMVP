package com.gaoshuai.androidarchitecturemvp.http;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.gaoshuai.androidarchitecturemvp.App;

import org.reactivestreams.Subscription;

import io.reactivex.FlowableSubscriber;


/**
 * Created by gaoshuai on 2019/3/22.
 * Describe：
 */
public class CustomSubscriber<T> implements FlowableSubscriber<T> {
    private Context context;
    private Subscription subscription;

    public CustomSubscriber(Context context) {
        this.context = context;
    }

    @Override
    public void onError(Throwable throwable) {
        try {
            if (throwable instanceof CustomException) {
                CustomException exception = (CustomException) throwable;
                unifiedHandling(exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onNext(T bean) {

    }

    @Override
    public void onSubscribe(Subscription s) {
        subscription = s;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    /**
     * 错误码统一拦截处理
     *
     * @param exception
     */
    private void unifiedHandling(CustomException exception) {
        if (exception == null || exception.getErrCode() == 0) {
            Toast.makeText(context, "错误码为空！！！", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(context, "错误码：" + exception.getErrCode() + "---错误信息：" + exception.getErrMsg(), Toast.LENGTH_SHORT).show();
    }
}
