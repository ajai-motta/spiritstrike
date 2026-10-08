package com.apm.insight.k;

import android.util.Log;
import com.apm.insight.runtime.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Runnable f186a = new Runnable() { // from class: com.apm.insight.k.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (com.apm.insight.l.k.b(com.apm.insight.e.g())) {
                a.i();
            }
            if (a.b > 0) {
                if (com.apm.insight.l.a.b(com.apm.insight.e.g())) {
                    m.a().a(a.f186a, 15000L);
                } else {
                    m.a().a(a.f186a, 60000L);
                }
            }
        }
    };
    private static int b = 0;

    public static boolean c() {
        return false;
    }

    public static void d() {
    }

    public static void a() {
        b = 40;
        m.a().a(f186a);
    }

    public static void b() {
        if (!j.b()) {
            j.c();
        }
        if (com.apm.insight.l.k.b(com.apm.insight.e.g()) && j.g()) {
            i();
        }
    }

    private static byte[] h() {
        try {
            return e.a(com.apm.insight.e.i().getConfigUrl(), com.apm.insight.entity.b.a().toString().getBytes());
        } catch (Throwable th) {
            com.apm.insight.a.a(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void i() {
        int i = b;
        if (i > 0) {
            b = i - 1;
        }
        com.apm.insight.a.a((Object) "try fetchApmConfig");
        if (com.apm.insight.l.a.b(com.apm.insight.e.g())) {
            JSONArray jSONArrayOptJSONArray = null;
            try {
                byte[] bArrH = h();
                if (bArrH != null) {
                    jSONArrayOptJSONArray = new JSONObject(new String(bArrH)).optJSONArray("data");
                }
            } catch (Throwable th) {
                if (com.apm.insight.e.i().isDebugMode()) {
                    Log.e("npth", "npth NPTH Catch Error", th);
                }
            }
            com.apm.insight.a.a((Object) "after fetchApmConfig net ".concat(String.valueOf(jSONArrayOptJSONArray)));
            if (jSONArrayOptJSONArray != null) {
                com.apm.insight.runtime.a.a(jSONArrayOptJSONArray, true);
                b = 0;
                return;
            } else {
                b -= 10;
                return;
            }
        }
        j.c();
        if (j.a()) {
            b = 0;
        }
    }
}
