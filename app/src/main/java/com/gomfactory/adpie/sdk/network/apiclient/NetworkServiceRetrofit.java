package com.gomfactory.adpie.sdk.network.apiclient;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import java.nio.charset.Charset;
import java.util.Collections;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkServiceRetrofit {
    public static final String TAG = "NetworkServiceRetrofit";

    public void get(final String str, final Handler handler) {
        try {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "[GET]<<start>>" + str);
            }
            if (TextUtils.isEmpty(str)) {
                notifyFailure(handler);
            } else {
                RetrofitClient.api().get(str, Collections.emptyMap(), Collections.emptyMap()).enqueue(new Callback<ResponseBody>() { // from class: com.gomfactory.adpie.sdk.network.apiclient.NetworkServiceRetrofit.1
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String strString;
                        try {
                            if (response.code() == 200) {
                                if (response.body() == null) {
                                    strString = "";
                                } else {
                                    strString = ((ResponseBody) response.body()).string();
                                }
                                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                    AdPieLog.d(NetworkServiceRetrofit.TAG, "[GET]<<finish>>" + str + "<<response>>" + response);
                                }
                                NetworkServiceRetrofit.this.notifySuccess(handler, strString);
                                return;
                            }
                            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.d(NetworkServiceRetrofit.TAG, "[GET]<<finish>>" + str + "<<code>>" + response.code());
                            }
                            NetworkServiceRetrofit.this.notifyFailure(handler);
                        } catch (Exception e) {
                            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.e(NetworkServiceRetrofit.TAG, e);
                            }
                            NetworkServiceRetrofit.this.notifyFailure(handler);
                        }
                    }

                    public void onFailure(Call<ResponseBody> call, Throwable th) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.e(NetworkServiceRetrofit.TAG, "[GET]<<finish>>" + str + " -> error", th);
                        }
                        NetworkServiceRetrofit.this.notifyFailure(handler);
                    }
                });
            }
        } catch (Error e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, "[GET]" + str + " -> Error", e);
            }
            notifyFailure(handler);
        } catch (Exception e2) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, "[GET]" + str + " -> Exception", e2);
            }
            notifyFailure(handler);
        }
    }

    public void post(final String str, final String str2, final Handler handler) {
        try {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "[POST]<<start>>" + str);
            }
            if (TextUtils.isEmpty(str)) {
                notifyFailure(handler);
                return;
            }
            if (str2 == null) {
                str2 = "";
            }
            RetrofitClient.api().postBody(str, Collections.emptyMap(), requestBody(str2.getBytes(Charset.forName("UTF-8")), mediaType("application/x-www-form-urlencoded; charset=utf-8"))).enqueue(new Callback<ResponseBody>() { // from class: com.gomfactory.adpie.sdk.network.apiclient.NetworkServiceRetrofit.2
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        if (response.code() == 200) {
                            String strString = response.body() != null ? ((ResponseBody) response.body()).string() : "";
                            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.d(NetworkServiceRetrofit.TAG, "[POST]<<finish>>" + str + "<<param>>" + str2 + "<<response>>" + strString);
                            }
                            NetworkServiceRetrofit.this.notifySuccess(handler, strString);
                            return;
                        }
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(NetworkServiceRetrofit.TAG, "[POST]<<finish>>" + str + "<<param>>" + str2 + "<<code>>" + response.code());
                        }
                        NetworkServiceRetrofit.this.notifyFailure(handler);
                    } catch (Exception e) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.e(NetworkServiceRetrofit.TAG, e);
                        }
                        NetworkServiceRetrofit.this.notifyFailure(handler);
                    }
                }

                public void onFailure(Call<ResponseBody> call, Throwable th) {
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(NetworkServiceRetrofit.TAG, "[POST]<<finish>>" + str + "<<param>>" + str2 + " -> error", th);
                    }
                    NetworkServiceRetrofit.this.notifyFailure(handler);
                }
            });
        } catch (Error e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, "[POST]" + str + "<<param>>" + str2 + " -> Error", e);
            }
            notifyFailure(handler);
        } catch (Exception e2) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, "[POST]" + str + "<<param>>" + str2 + " -> Exception", e2);
            }
            notifyFailure(handler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySuccess(Handler handler, String str) {
        if (handler == null) {
            return;
        }
        handler.sendMessage(Message.obtain(handler, 200, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailure(Handler handler) {
        if (handler == null) {
            return;
        }
        handler.sendMessage(Message.obtain(handler, -1));
    }

    private MediaType mediaType(String str) {
        try {
            try {
                return (MediaType) MediaType.class.getMethod("get", String.class).invoke(null, str);
            } catch (NoSuchMethodException unused) {
                return (MediaType) MediaType.class.getMethod("parse", String.class).invoke(null, str);
            } catch (Exception e) {
                throw new IllegalStateException("Failed to create MediaType reflectively", e);
            }
        } catch (Exception e2) {
            throw new IllegalStateException("No MediaType.get/parse available in this OkHttp", e2);
        }
    }

    private RequestBody requestBody(byte[] bArr, MediaType mediaType) {
        try {
            try {
                return (RequestBody) RequestBody.class.getMethod("create", MediaType.class, byte[].class).invoke(null, mediaType, bArr);
            } catch (NoSuchMethodException unused) {
                return (RequestBody) RequestBody.class.getMethod("create", byte[].class, MediaType.class).invoke(null, bArr, mediaType);
            } catch (Exception e) {
                throw new IllegalStateException("Failed to invoke RequestBody.create reflectively", e);
            }
        } catch (Exception e2) {
            throw new IllegalStateException("No compatible RequestBody.create(...) found", e2);
        }
    }
}
