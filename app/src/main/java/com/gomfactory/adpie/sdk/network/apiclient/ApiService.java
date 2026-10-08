package com.gomfactory.adpie.sdk.network.apiclient;

import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes3.dex */
interface ApiService {
    @GET
    Call<ResponseBody> get(@Url String str, @HeaderMap Map<String, String> map, @QueryMap Map<String, String> map2);

    @POST
    Call<ResponseBody> postBody(@Url String str, @HeaderMap Map<String, String> map, @Body RequestBody requestBody);

    @FormUrlEncoded
    @POST
    Call<ResponseBody> postForm(@Url String str, @HeaderMap Map<String, String> map, @FieldMap Map<String, String> map2);
}
