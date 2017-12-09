package com.core.base

import com.core.base.module.LogUtil
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by waikeytsang on 2017/7/10.
 * Retrofit Client
 */
class RetrofitClient private constructor() {

    object RegisterRetrofit {
        private val loggingInterceptor = HttpLoggingInterceptor()
        private val okHttpClient = OkHttpClient
                .Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(loggingInterceptor.setLevel(if (LogUtil.isDebug())
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE))
                .build()!!
        var retrofit = Retrofit.Builder()
                .baseUrl("服务器域名")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    companion object {
        private val retrofit: Retrofit by lazy { RegisterRetrofit.retrofit }

        fun <T> createService(clz: Class<T>): T = retrofit.create(clz)
    }

}

