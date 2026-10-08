package com.adxcorp.ads.mediation.network.apiclient;

import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes2.dex */
final class RetrofitClient {
    private static final Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.adxcorp.kr").client(buildOkHttpClient()).build();

    RetrofitClient() {
    }

    private static OkHttpClient buildOkHttpClient() {
        OkHttpClient.Builder builderAddInterceptor = new OkHttpClient.Builder().connectTimeout(2L, TimeUnit.SECONDS).readTimeout(4L, TimeUnit.SECONDS).writeTimeout(4L, TimeUnit.SECONDS).addInterceptor(new Interceptor() { // from class: com.adxcorp.ads.mediation.network.apiclient.RetrofitClient$$ExternalSyntheticLambda0
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return chain.proceed(chain.request());
            }
        });
        try {
            Class.forName("okhttp3.logging.HttpLoggingInterceptor");
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builderAddInterceptor.addInterceptor(httpLoggingInterceptor);
        } catch (ClassNotFoundException unused) {
        }
        return builderAddInterceptor.build();
    }

    static ApiService api() {
        return (ApiService) retrofit.create(ApiService.class);
    }
}
