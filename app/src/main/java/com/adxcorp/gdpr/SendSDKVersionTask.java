package com.adxcorp.gdpr;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.util.ADXAsyncTaskUtil;
import com.adxcorp.util.ADXLogUtil;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SendSDKVersionTask {
    private static final String TAG = "SendSDKVersionTask";
    private static final String TRACKING_SERVER_URL = "https://api.adxcorp.kr/v1/track?os=android";

    /* JADX INFO: Access modifiers changed from: private */
    public String readStream(InputStream inputStream) {
        byte[] bArr = new byte[1024];
        StringBuilder sb = new StringBuilder();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        while (true) {
            try {
                try {
                    int i = bufferedInputStream.read(bArr);
                    if (i != -1) {
                        sb.append(new String(bArr, 0, i));
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                        }
                    }
                } catch (IOException e2) {
                    Log.e(TAG, e2.getLocalizedMessage());
                    try {
                        bufferedInputStream.close();
                        return null;
                    } catch (IOException e3) {
                        Log.e(TAG, e3.getLocalizedMessage());
                        return null;
                    }
                }
            } finally {
                try {
                    bufferedInputStream.close();
                } catch (IOException e4) {
                    Log.e(TAG, e4.getLocalizedMessage());
                }
            }
        }
        return sb.toString();
    }

    public void execute(final Context context) {
        new ADXAsyncTaskUtil() { // from class: com.adxcorp.gdpr.SendSDKVersionTask.1
            @Override // com.adxcorp.util.ADXAsyncTaskUtil
            public void doInUiThread() {
            }

            @Override // com.adxcorp.util.ADXAsyncTaskUtil
            public void doInBackground() {
                try {
                    StringBuilder sb = new StringBuilder("https://api.adxcorp.kr/v1/track?os=android&packageName=");
                    sb.append(context.getPackageName());
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    boolean z = (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0;
                    sb.append("&appVersion=");
                    sb.append(packageInfo.versionName);
                    sb.append("&appVersionCode=");
                    sb.append(packageInfo.versionCode);
                    sb.append("&sdkVersion=");
                    sb.append(ADXGDPR.ADX_SDK_VERSION);
                    sb.append("&isDebug=");
                    sb.append(z);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                    if (httpURLConnection.getResponseCode() == 200) {
                        try {
                            if (new JSONObject(SendSDKVersionTask.this.readStream(httpURLConnection.getInputStream())).optBoolean("debuggable")) {
                                Log.d(SendSDKVersionTask.TAG, "Debug logging : true");
                                MediationSDK.getInstance().getConfiguration().setSdkLog(true);
                                ADXLogUtil.setLogEnable(true);
                                ADXLogUtil.setLogLevel(3);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        httpURLConnection.disconnect();
                    }
                } catch (Exception unused) {
                }
            }
        }.execute();
    }
}
