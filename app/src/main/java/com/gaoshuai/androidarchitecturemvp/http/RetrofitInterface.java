package com.gaoshuai.androidarchitecturemvp.http;

import com.gaoshuai.androidarchitecturemvp.bean.BaseResponseBean;
import com.gaoshuai.androidarchitecturemvp.bean.BaseResponsePageBean;
import com.gaoshuai.androidarchitecturemvp.bean.CookBean;
import com.gaoshuai.androidarchitecturemvp.constant.HttpConstant;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by gaoshuai on 2019/3/20.
 * Describe：统一请求接口类
 */
public interface RetrofitInterface {
    @FormUrlEncoded
    @POST(HttpConstant.QUERY_COOK)
    Flowable<Response<BaseResponseBean<BaseResponsePageBean<CookBean>>>> queryCooks(@FieldMap Map<String, String> map);

}
