package com.applovin.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.d2;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e2 {
    private static volatile ExecutorService g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.k f363a;
    protected final com.applovin.impl.sdk.o b;
    private final d2.b c;
    private final Map d = Collections.synchronizedMap(new HashMap());
    private final Set e = Collections.synchronizedSet(new HashSet());
    private static final int f = (int) TimeUnit.SECONDS.toMillis(30);
    private static final Object h = new Object();

    class a implements ThreadFactory {

        /* JADX INFO: renamed from: com.applovin.impl.e2$a$a, reason: collision with other inner class name */
        class C0147a implements Thread.UncaughtExceptionHandler {
            C0147a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                e2.this.f363a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    e2.this.f363a.O().a("HealthEventsReporter", "Caught unhandled exception", th);
                }
            }
        }

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:health_events_reporter");
            thread.setDaemon(true);
            thread.setPriority(((Integer) e2.this.f363a.a(y4.S)).intValue());
            thread.setUncaughtExceptionHandler(new C0147a());
            return thread;
        }
    }

    public e2(com.applovin.impl.sdk.k kVar, d2.b bVar) {
        this.f363a = kVar;
        this.b = kVar.O();
        this.c = bVar;
        a();
    }

    private void a() {
        if (g != null) {
            return;
        }
        synchronized (h) {
            if (g != null) {
                return;
            }
            g = Executors.newFixedThreadPool(1, new a());
        }
    }

    private void c(d2 d2Var, List list) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        if (d2Var.a() == d2.b.AD || d2Var.a() == d2.b.MEDIATED_AD || d2Var.a() == d2.b.USER_SESSION || !o7.a(((Integer) this.f363a.a(y4.B)).intValue())) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            try {
                httpURLConnection = (HttpURLConnection) a(d2Var, map).openConnection();
            } catch (Throwable th2) {
                httpURLConnection = null;
                th = th2;
            }
            try {
                int i = f;
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
                httpURLConnection.setDefaultUseCaches(false);
                httpURLConnection.setAllowUserInteraction(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("AppLovin-Event-Type", d2Var.b());
                int responseCode = httpURLConnection.getResponseCode();
                if (com.applovin.impl.sdk.o.a()) {
                    this.b.a("HealthEventsReporter", d2Var.b() + " reported with code " + responseCode + " and extra parameters " + map);
                }
                this.d.put(d2Var, Long.valueOf(System.currentTimeMillis()));
            } catch (Throwable th3) {
                th = th3;
                try {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.b.d("HealthEventsReporter", "Failed to report " + d2Var.b() + " with extra parameters " + map, th);
                    }
                    o7.a(httpURLConnection, this.f363a);
                } finally {
                    o7.a(httpURLConnection, this.f363a);
                }
            }
        }
    }

    public void d(d2 d2Var, Map map) {
        a(d2Var, map, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(String str, d2 d2Var, JSONObject jSONObject) {
        byte[] bytes;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            URL url = new URL(str);
            bytes = jSONObject.toString().getBytes("UTF-8");
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } catch (Throwable th) {
            th = th;
        }
        try {
            int i = f;
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("AppLovin-Event-Type", d2Var.b());
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bytes);
            outputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (com.applovin.impl.sdk.o.a()) {
                this.b.a("HealthEventsReporter", d2Var.b() + " reported with code " + responseCode);
            }
            this.d.put(d2Var, Long.valueOf(System.currentTimeMillis()));
            o7.a(httpURLConnection, this.f363a);
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            try {
                if (com.applovin.impl.sdk.o.a()) {
                    this.b.d("HealthEventsReporter", "Failed to report " + d2Var.b(), th);
                }
            } finally {
                o7.a(httpURLConnection2, this.f363a);
            }
        }
    }

    private void d(final d2 d2Var, List list) {
        final String str = (String) this.f363a.a(y4.C);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        double dA = d2Var.a(this.f363a);
        if (o7.a(dA)) {
            if (((Boolean) this.f363a.a(y4.I)).booleanValue()) {
                a(str, d2Var, a(d2Var, dA, list));
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final JSONObject jSONObjectA = a(d2Var, dA, Collections.singletonList((Map) it.next()));
                g.execute(new Runnable() { // from class: com.applovin.impl.e2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(str, d2Var, jSONObjectA);
                    }
                });
            }
        }
    }

    public void a(d2 d2Var, String str) {
        a(d2Var, str, new HashMap());
    }

    public void a(d2 d2Var, String str, Map map) {
        map.put("source", str);
        d(d2Var, map);
    }

    public void a(d2 d2Var, String str, Map map, String str2) {
        if (!StringUtils.isValidString(str2) || this.e.add(str2)) {
            map.put("source", str);
            a(d2Var, str, map);
        }
    }

    public void a(d2 d2Var, Map map, long j) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        a(d2Var, arrayList, j);
    }

    private Map b(d2 d2Var, Map map) {
        HashMap map2 = new HashMap();
        map2.put("type", d2Var.b());
        if (d2Var == d2.L0 || d2Var == d2.K0 || d2Var == d2.b1 || d2Var == d2.Z0) {
            if (((Boolean) this.f363a.a(y4.s4)).booleanValue()) {
                CollectionUtils.putStringIfValid("wvvc", String.valueOf(o8.d()), map2);
                CollectionUtils.putStringIfValid("wvv", o8.c(), map2);
                CollectionUtils.putStringIfValid("wvpn", o8.b(), map2);
            }
            CollectionUtils.putStringIfValid("oglv", this.f363a.A().J(), map2);
        }
        Map mapM = this.f363a.A().M();
        map2.put("platform", String.valueOf(mapM.get("platform")));
        map2.put("country_code", String.valueOf(mapM.get("country_code")));
        map2.put("cc", this.f363a.v().getCountryCode());
        map2.put("applovin_random_token", this.f363a.i0());
        map2.put("compass_random_token", this.f363a.u());
        map2.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        map2.put("brand", Build.MANUFACTURER);
        map2.put("brand_name", Build.BRAND);
        map2.put("hardware", Build.HARDWARE);
        map2.put("revision", Build.DEVICE);
        map2.put("os", Build.VERSION.RELEASE);
        map2.put("api_level", String.valueOf(Build.VERSION.SDK_INT));
        map2.put("sdk_version", String.valueOf(AppLovinSdk.VERSION));
        CollectionUtils.putStringIfValid("ad_review_sdk_version", j.b(), map2);
        map2.put("md", (String) this.f363a.a(y4.t));
        b(map2);
        a(map2);
        if (map != null) {
            map2.putAll(c(d2Var, map));
        }
        return map2;
    }

    private Map c(d2 d2Var, Map map) {
        HashMap map2 = new HashMap(map);
        if (d2Var == d2.P0) {
            map2.remove("details");
        }
        return map2;
    }

    public void a(final d2 d2Var, final List list, long j) {
        if (a(d2Var, j)) {
            return;
        }
        try {
            if (o7.h()) {
                g.execute(new Runnable() { // from class: com.applovin.impl.e2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(d2Var, list);
                    }
                });
            } else {
                b(d2Var, list);
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.d("HealthEventsReporter", "Failed to report " + d2Var.b() + " with extra parameters collection " + list, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(d2 d2Var, List list) {
        if (AppLovinSdkUtils.isEmulator()) {
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("HealthEventsReporter", "Reporting " + d2Var.b() + " with extra parameters collection " + list);
        }
        if (this.c != d2Var.a()) {
            l1.a("Health event " + d2Var.b() + " category: " + d2Var.a() + " does not match the reporter category: " + this.c, new Object[0]);
        }
        c(d2Var, list);
        d(d2Var, list);
    }

    private URL a(d2 d2Var, Map map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder("https://ms.applovin.com/1.0/sdk/error?");
        Iterator it = b(d2Var, map).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strEncode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
            String strEncode2 = URLEncoder.encode((String) entry.getValue(), "UTF-8");
            sb.append(strEncode);
            sb.append("=");
            sb.append(strEncode2);
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return new URL(sb.toString());
    }

    private void b(Map map) {
        String packageName;
        PackageInfo packageInfo;
        String str = "";
        try {
            PackageManager packageManager = com.applovin.impl.sdk.k.o().getPackageManager();
            packageName = com.applovin.impl.sdk.k.o().getPackageName();
            try {
                packageInfo = packageManager.getPackageInfo(packageName, 0);
            } catch (Throwable unused) {
                packageInfo = null;
            }
        } catch (Throwable unused2) {
            packageName = "";
        }
        map.put("package_name", packageName);
        if (packageInfo != null) {
            str = packageInfo.versionName;
        }
        map.put("app_version", str);
        map.put("app_version_code", String.valueOf(packageInfo != null ? packageInfo.versionCode : 0));
    }

    private JSONObject a(d2 d2Var, double d, List list) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putLong(jSONObject, "ts_ms", System.currentTimeMillis());
        if (d2Var == d2.L0 || d2Var == d2.K0 || d2Var == d2.b1 || d2Var == d2.Z0) {
            if (((Boolean) this.f363a.a(y4.s4)).booleanValue()) {
                JsonUtils.putStringIfValid(jSONObject, "wvvc", String.valueOf(o8.d()));
                JsonUtils.putStringIfValid(jSONObject, "wvv", o8.c());
                JsonUtils.putStringIfValid(jSONObject, "wvpn", o8.b());
            }
            JsonUtils.putStringIfValid(jSONObject, "oglv", this.f363a.A().J());
        }
        JSONObject jSONObject2 = new JSONObject();
        Map mapM = this.f363a.A().M();
        JsonUtils.putObject(jSONObject2, "platform", mapM.get("platform"));
        JsonUtils.putObject(jSONObject2, "os", mapM.get("os"));
        JsonUtils.putObject(jSONObject2, "api_level", String.valueOf(mapM.get("api_level")));
        JsonUtils.putObject(jSONObject2, "brand", mapM.get("brand"));
        JsonUtils.putObject(jSONObject2, DeviceRequestsHelper.DEVICE_INFO_MODEL, mapM.get(DeviceRequestsHelper.DEVICE_INFO_MODEL));
        JsonUtils.putObject(jSONObject2, "revision", mapM.get("revision"));
        JsonUtils.putObject(jSONObject2, "country_code", mapM.get("country_code"));
        JsonUtils.putObject(jSONObject2, "cc", this.f363a.v().getCountryCode());
        JsonUtils.putObject(jSONObject2, "applovin_random_token", this.f363a.i0());
        JsonUtils.putObject(jSONObject2, "ad_review_sdk_version", StringUtils.emptyIfNull(j.b()));
        Map mapF = this.f363a.A().F();
        JsonUtils.putObject(jSONObject2, "sdk_version", mapF.get("sdk_version"));
        JsonUtils.putObject(jSONObject2, "plugin_version", this.f363a.a(y4.Q3));
        JsonUtils.putObject(jSONObject2, "app_version", mapF.get("app_version"));
        JsonUtils.putObject(jSONObject2, "package_name", mapF.get("package_name"));
        JsonUtils.putObject(jSONObject2, "first_install", Boolean.toString(Boolean.TRUE.equals((Boolean) mapF.get("first_install_v2"))));
        JsonUtils.putObject(jSONObject2, "md", this.f363a.a(y4.t));
        JsonUtils.putObject(jSONObject2, "mediation_provider", this.f363a.V());
        SessionTracker sessionTrackerN0 = this.f363a.n0();
        JsonUtils.putObject(jSONObject2, "app_state", sessionTrackerN0.getCurrentApplicationState().b());
        JsonUtils.putObject(jSONObject2, "app_state_duration_ms", Long.valueOf(sessionTrackerN0.getCurrentApplicationStateDurationMillis()));
        JsonUtils.putObject(jSONObject2, "session_id", sessionTrackerN0.getSessionId());
        JsonUtils.putObject(jSONObject2, "session_duration_ms", Long.valueOf(System.currentTimeMillis() - com.applovin.impl.sdk.k.n()));
        JsonUtils.putObject(jSONObject, "shared_fields", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.putDouble(jSONObject3, "ts_ms", System.currentTimeMillis());
            JsonUtils.putString(jSONObject3, "type", d2Var.b());
            JsonUtils.putDouble(jSONObject3, "weight", d);
            JsonUtils.putString(jSONObject3, "level", "DEBUG");
            a(map);
            JsonUtils.putAll(jSONObject3, (Map<String, ?>) map);
            jSONArray.put(jSONObject3);
        }
        JsonUtils.putObject(jSONObject, "events", jSONArray);
        return jSONObject;
    }

    private void a(Map map) {
        if (map == null) {
            return;
        }
        Object objA = this.f363a.H().a();
        if (objA instanceof com.applovin.impl.sdk.ad.b) {
            map.put("fs_ad_network", ADXLogUtil.PLATFORM_APPLOVIN);
            map.put("fs_ad_creative_id", Long.toString(((com.applovin.impl.sdk.ad.b) objA).getAdIdNumber()));
        } else if (objA instanceof y2) {
            y2 y2Var = (y2) objA;
            map.put("fs_ad_network", y2Var.getNetworkName());
            map.put("fs_ad_creative_id", y2Var.getCreativeId());
        } else {
            map.put("fs_ad_network", "None");
            map.put("fs_ad_creative_id", "None");
        }
    }

    private boolean a(d2 d2Var, long j) {
        Long l = (Long) this.d.get(d2Var);
        return System.currentTimeMillis() - (l != null ? l.longValue() : -1L) < j;
    }
}
