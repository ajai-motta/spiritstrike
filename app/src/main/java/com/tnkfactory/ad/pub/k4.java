package com.tnkfactory.ad.pub;

import android.os.Build;
import com.tnkfactory.ad.Logger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes6.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k4 f3149a;

    public static k4 a() {
        if (f3149a == null) {
            f3149a = new k4();
        }
        return f3149a;
    }

    public static void a(ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final String str = (String) it.next();
            new Thread(new Runnable() { // from class: com.tnkfactory.ad.pub.k4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    k4.a(str);
                }
            }).start();
        }
    }

    public static /* synthetic */ void a(String str) {
        try {
            a(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str, int i) {
        HttpURLConnection httpURLConnection;
        if (str != null) {
            str = str.replace("[ERRORCODE]", "" + i);
        }
        String string = null;
        HttpURLConnection httpURLConnection2 = null;
        if (!str.startsWith("https")) {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    String str2 = Build.VERSION.SDK;
                    httpURLConnection.setConnectTimeout(3000);
                    httpURLConnection.setReadTimeout(3000);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("GET");
                    String str3 = "HTTP ResponseCode : " + httpURLConnection.getResponseCode();
                    httpURLConnection.disconnect();
                    string = str3;
                } catch (Exception e) {
                    e = e;
                    httpURLConnection2 = httpURLConnection;
                    e.toString();
                    HttpURLConnection httpURLConnection3 = httpURLConnection2;
                    string = e.toString();
                    httpURLConnection = httpURLConnection3;
                }
            } catch (Exception e2) {
                e = e2;
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            Logger.d("https invoke " + str + " : return code = " + string);
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setReadTimeout(3000);
        httpsURLConnection.setConnectTimeout(3000);
        httpsURLConnection.setDoOutput(false);
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.setSSLSocketFactory(new j4());
        string = "Https ResponseCode : " + httpsURLConnection.getResponseCode();
        httpsURLConnection.disconnect();
        Logger.d("https invoke " + str + " : return code = " + string);
    }
}
