package com.fyber.inneractive.sdk.network;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.common.net.HttpHeaders;
import java.io.FilterInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class p1 extends i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OkHttpClient f1212a = new OkHttpClient().newBuilder().build();

    public static HashMap b(Response response) {
        HashMap map = new HashMap();
        if (response != null) {
            Headers headers = response.headers();
            for (int i = 0; i < headers.size(); i++) {
                String strName = headers.name(i);
                map.put(strName, Collections.singletonList(headers.get(strName)));
            }
        }
        return map;
    }

    @Override // com.fyber.inneractive.sdk.network.h
    public final l a(t0 t0Var, String str, String str2) throws Exception {
        IAlog.a("%s okhttp network stack is in use", "OkHttpExecutorImpl");
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(t0Var.r());
            Pair pairA = a(t0Var.r(), t0Var, arrayList, str, str2);
            Object obj = pairA.second;
            String strMessage = obj != null ? ((Response) obj).message() : "";
            FilterInputStream filterInputStreamA = a((Response) pairA.second);
            Object obj2 = pairA.second;
            int iCode = obj2 == null ? -1 : ((Response) obj2).code();
            HashMap mapB = b((Response) pairA.second);
            Response response = (Response) pairA.second;
            o1 o1Var = new o1(i.a(filterInputStreamA, iCode, strMessage, mapB, response != null ? response.headers().get(HttpHeaders.LAST_MODIFIED) : null), (Response) pairA.second);
            Iterator it = ((List) pairA.first).iterator();
            while (it.hasNext()) {
                o1Var.f.add((String) it.next());
            }
            return o1Var;
        } catch (b e) {
            IAlog.b("%s cannot connect exception: %s", "OkHttpExecutorImpl", e.getMessage());
            throw e;
        } catch (Exception e2) {
            IAlog.b("%s exception: %s", "OkHttpExecutorImpl", e2.getMessage());
            throw e2;
        }
    }

    public final Pair a(String str, t0 t0Var, ArrayList arrayList, String str2, String str3) throws Exception {
        String strHeader;
        l1 l1VarP = t0Var.p();
        Request.Builder builder = new Request.Builder();
        a(builder, HttpHeaders.ACCEPT_ENCODING, "gzip");
        a(builder, HttpHeaders.USER_AGENT, str2);
        a(builder, HttpHeaders.IF_MODIFIED_SINCE, str3);
        Map mapL = t0Var.l();
        if (mapL != null) {
            for (String str4 : mapL.keySet()) {
                a(builder, str4, (String) mapL.get(str4));
            }
        }
        builder.url(str);
        if (t0Var.m() == m0.POST || t0Var.m() == m0.PUT) {
            byte[] bArrF = t0Var.f();
            if (bArrF != null) {
                builder.post(RequestBody.create(bArrF, MediaType.parse(t0Var.n())));
            } else {
                throw new Exception("Could not create ok http request. post payload is null");
            }
        }
        Request requestBuild = builder.build();
        boolean z = !(t0Var instanceof h1);
        OkHttpClient.Builder builderFollowSslRedirects = this.f1212a.newBuilder().followRedirects(z).followSslRedirects(z);
        long j = l1VarP.f1207a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient okHttpClientBuild = builderFollowSslRedirects.connectTimeout(j, timeUnit).readTimeout(l1VarP.b, timeUnit).build();
        t0Var.c(System.currentTimeMillis());
        IAlog.a("OkHttpExecutorImpl: start connection timestamp: %s", t0Var.g);
        try {
            try {
                Response responseExecute = okHttpClientBuild.newCall(requestBuild).execute();
                if (!(!(t0Var instanceof h1)) && (((responseExecute.code() > 300 && responseExecute.code() < 304) || responseExecute.code() == 307 || responseExecute.code() == 308) && (strHeader = responseExecute.header(HttpHeaders.LOCATION, "")) != null)) {
                    if (!strHeader.startsWith(ProxyConfig.MATCH_HTTP) && !strHeader.contains("://") && arrayList.size() > 0) {
                        Uri uri = Uri.parse((String) arrayList.get(arrayList.size() - 1));
                        strHeader = String.format(strHeader.startsWith(DomExceptionUtils.SEPARATOR) ? "%s://%s%s" : "%s://%s/%s", uri.getScheme(), uri.getHost(), strHeader);
                    }
                    arrayList.add(strHeader);
                    if (arrayList.size() <= 5) {
                        Pair pairA = a(strHeader, t0Var, arrayList, str2, str3);
                        t0Var.a(System.currentTimeMillis());
                        IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", t0Var.g);
                        return pairA;
                    }
                    throw new b("Url chain too big for us");
                }
                Pair pair = new Pair(arrayList, responseExecute);
                t0Var.a(System.currentTimeMillis());
                IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", t0Var.g);
                return pair;
            } catch (Exception e) {
                throw new b(e);
            }
        } catch (Throwable th) {
            t0Var.a(System.currentTimeMillis());
            IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", t0Var.g);
            throw th;
        }
    }

    public static FilterInputStream a(Response response) {
        if (response == null) {
            return null;
        }
        try {
            if (response.body() == null) {
                return null;
            }
            return i.a(response.body().byteStream(), TextUtils.equals("gzip", response.headers().get("content-encoding")));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Request.Builder builder, String str, String str2) {
        IAlog.d("%s %s : %s", "REQUEST_HEADER", str, str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.addHeader(str, str2);
    }
}
