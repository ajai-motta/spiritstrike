package com.fyber.inneractive.sdk.network;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.common.net.HttpHeaders;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends i implements h {
    @Override // com.fyber.inneractive.sdk.network.h
    public final l a(t0 t0Var, String str, String str2) throws b, q1, t1 {
        l lVarA;
        IAlog.a("%s hurl network stack is in use", "HttpExecutorImpl");
        URL url = new URL(t0Var.r());
        ArrayList arrayList = new ArrayList();
        arrayList.add(t0Var.r());
        Pair pairA = a(t0Var, arrayList, url, str, str2);
        HttpURLConnection httpURLConnection = (HttpURLConnection) pairA.second;
        List list = (List) pairA.first;
        if (httpURLConnection == null) {
            try {
                if (list.size() <= 0) {
                    throw new q1();
                }
            } catch (SocketTimeoutException e) {
                throw new t1(e);
            } catch (IOException e2) {
                IAlog.a("failed reading network response", e2, new Object[0]);
                throw new q1(e2);
            }
        }
        FilterInputStream filterInputStreamA = null;
        if (httpURLConnection == null) {
            lVarA = i.a(null, 200, "", null, null);
        } else {
            try {
                filterInputStreamA = i.a(httpURLConnection.getInputStream(), TextUtils.equals("gzip", httpURLConnection.getContentEncoding()));
            } catch (Exception unused) {
            }
            lVarA = i.a(filterInputStreamA, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), httpURLConnection.getHeaderFields(), httpURLConnection.getHeaderField(HttpHeaders.LAST_MODIFIED));
        }
        j jVar = new j(httpURLConnection, lVarA.f1205a, (FilterInputStream) lVarA.c, lVarA.d, lVarA.e);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jVar.f.add((String) it.next());
        }
        return jVar;
    }

    public static Pair a(t0 t0Var, ArrayList arrayList, URL url, String str, String str2) throws b {
        String headerField;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            t0Var.getClass();
            if (!(!(t0Var instanceof h1))) {
                httpURLConnection.setInstanceFollowRedirects(false);
            }
            l1 l1VarP = t0Var.p();
            httpURLConnection.setConnectTimeout(l1VarP.f1207a);
            httpURLConnection.setReadTimeout(l1VarP.b);
            a(httpURLConnection, HttpHeaders.USER_AGENT, str);
            a(httpURLConnection, HttpHeaders.IF_MODIFIED_SINCE, str2);
            a(httpURLConnection, HttpHeaders.ACCEPT_ENCODING, "gzip");
            com.fyber.inneractive.sdk.config.s sVar = IAConfigManager.O.u;
            if (sVar != null && sVar.b.a("add_accept", 1, 0) == 1) {
                a(httpURLConnection, HttpHeaders.ACCEPT, "*/*");
            }
            Map mapL = t0Var.l();
            if (mapL != null) {
                for (String str3 : mapL.keySet()) {
                    a(httpURLConnection, str3, (String) mapL.get(str3));
                }
            }
            t0Var.c(System.currentTimeMillis());
            if (t0Var.m() != m0.POST && t0Var.m() != m0.PUT) {
                httpURLConnection.connect();
            } else {
                a(httpURLConnection, t0Var);
            }
            int responseCode = httpURLConnection.getResponseCode();
            t0Var.a(System.currentTimeMillis());
            IAlog.a("%s (%s) response code - %d", t0Var.toString(), url, Integer.valueOf(responseCode));
            if (!(!(t0Var instanceof h1)) && (((responseCode > 300 && responseCode < 304) || responseCode == 307 || responseCode == 308) && (headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION)) != null)) {
                if (!headerField.startsWith(ProxyConfig.MATCH_HTTP) && !headerField.contains("://") && arrayList.size() > 0) {
                    Uri uri = Uri.parse((String) arrayList.get(arrayList.size() - 1));
                    headerField = String.format(headerField.startsWith(DomExceptionUtils.SEPARATOR) ? "%s://%s%s" : "%s://%s/%s", uri.getScheme(), uri.getHost(), headerField);
                }
                arrayList.add(headerField);
                if (arrayList.size() <= 20) {
                    if (headerField.startsWith(ProxyConfig.MATCH_HTTP)) {
                        return a(t0Var, arrayList, new URL(headerField), str, str2);
                    }
                    return Pair.create(arrayList, null);
                }
                throw new b("Url chain too big for us");
            }
            return new Pair(arrayList, httpURLConnection);
        } catch (Exception e) {
            t0Var.a(System.currentTimeMillis());
            IAlog.a("failed executing network request", e, new Object[0]);
            throw new b(e);
        }
    }

    public static void a(HttpURLConnection httpURLConnection, t0 t0Var) throws IOException {
        httpURLConnection.setRequestMethod(t0Var.m().key);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        byte[] bArrF = t0Var.f();
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, "" + (bArrF != null ? bArrF.length : 0));
        httpURLConnection.setRequestProperty("Content-Type", t0Var.n());
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArrF);
        try {
            outputStream.close();
        } catch (Throwable unused) {
        }
    }

    public static void a(HttpURLConnection httpURLConnection, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        IAlog.d("%s %s : %s", "REQUEST_HEADER", str, str2);
        httpURLConnection.addRequestProperty(str, str2);
    }
}
