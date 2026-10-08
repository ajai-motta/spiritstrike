package com.tnkfactory.ad.pub;

import android.os.Build;
import com.tnkfactory.ad.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes6.dex */
public final class o4 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3172a;

    public o4(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        this.f3172a = arrayList2;
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        for (String str : this.f3172a) {
            if (str != null) {
                try {
                    try {
                        URL url = new URL(str);
                        if (str.startsWith("http://")) {
                            try {
                                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                String str2 = Build.VERSION.SDK;
                                httpURLConnection.setConnectTimeout(5000);
                                httpURLConnection.setReadTimeout(5000);
                                httpURLConnection.setUseCaches(false);
                                httpURLConnection.setDoOutput(false);
                                httpURLConnection.setRequestMethod("GET");
                                Logger.d("http invoke " + str + " : return code = " + httpURLConnection.getResponseCode());
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (ProtocolException e2) {
                                e2.printStackTrace();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        } else {
                            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                            httpsURLConnection.setReadTimeout(5000);
                            httpsURLConnection.setConnectTimeout(5000);
                            httpsURLConnection.setDoOutput(false);
                            httpsURLConnection.setUseCaches(false);
                            httpsURLConnection.setRequestMethod("GET");
                            httpsURLConnection.setSSLSocketFactory(new j4());
                            Logger.d("https invoke " + str + " : return code = " + httpsURLConnection.getResponseCode());
                            httpsURLConnection.disconnect();
                        }
                    } catch (MalformedURLException e4) {
                        e4.printStackTrace();
                    } catch (ProtocolException e5) {
                        e5.printStackTrace();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                } catch (KeyManagementException e7) {
                    e7.printStackTrace();
                } catch (NoSuchAlgorithmException e8) {
                    e8.printStackTrace();
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            }
        }
    }
}
