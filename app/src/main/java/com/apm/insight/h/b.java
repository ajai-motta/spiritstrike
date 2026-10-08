package com.apm.insight.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.apm.insight.e;
import com.apm.insight.l.f;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.j;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.n;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f178a;
    private Map<String, String> b;

    public static String a(String str) {
        return e.g().getFilesDir() + "/apminsight/selflib/lib" + str + ".so";
    }

    public static String a() {
        return e.g().getFilesDir() + "/apminsight/selflib/";
    }

    public static void b(final String str) {
        m.a().a(new Runnable() { // from class: com.apm.insight.h.b.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f179a = false;

            @Override // java.lang.Runnable
            public final void run() {
                String strA;
                b.b();
                if (b.c(str)) {
                    return;
                }
                n.a("updateSo", str);
                File file = new File(b.a(str));
                file.getParentFile().mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                String str2 = "doUnpackLibrary: " + str;
                if (e.i().isDebugMode()) {
                    Log.w("npth", str2);
                }
                try {
                    strA = c.a(e.g(), str, file);
                } catch (Throwable th) {
                    n.a("updateSoError", str);
                    com.apm.insight.c.a();
                    j.a(th, "NPTH_CATCH");
                    strA = null;
                }
                if (strA == null) {
                    b.f178a.put(file.getName(), "2.0.0.8");
                    try {
                        f.a(new File(e.g().getFilesDir() + "/apminsight/selflib/" + str + ".ver"), "2.0.0.8", false);
                    } catch (Throwable unused) {
                    }
                    n.a("updateSoSuccess", str);
                    return;
                }
                if (!this.f179a) {
                    this.f179a = true;
                    n.a("updateSoPostRetry", str);
                    m.a().a(this, 3000L);
                    return;
                }
                n.a("updateSoFailed", str);
            }
        });
    }

    static /* synthetic */ void b() {
        if (f178a == null) {
            f178a = new HashMap<>();
            File file = new File(e.g().getFilesDir(), "/apminsight/selflib/");
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    if (str.endsWith(".ver")) {
                        try {
                            f178a.put(str.substring(0, str.length() - 4), f.a(file.getAbsolutePath() + DomExceptionUtils.SEPARATOR + str, "\n"));
                        } catch (Throwable th) {
                            com.apm.insight.c.a();
                            j.a(th, "NPTH_CATCH");
                        }
                    } else if (!str.endsWith(".so")) {
                        f.a(new File(file, str));
                    }
                }
            }
        }
    }

    static /* synthetic */ boolean c(String str) {
        return "2.0.0.8".equals(f178a.get(str)) && new File(a(str)).exists();
    }

    public b(File file) {
        String strA;
        File fileC = com.apm.insight.l.j.c(file);
        if (!fileC.exists() || fileC.length() == 0 || (strA = NativeImpl.a(fileC.getAbsolutePath())) == null) {
            return;
        }
        String[] strArrSplit = strA.split("\n");
        this.b = new HashMap();
        for (String str : strArrSplit) {
            String[] strArrSplit2 = str.split("=");
            if (strArrSplit2.length == 2) {
                this.b.put(strArrSplit2[0], strArrSplit2[1]);
            }
        }
    }

    public final boolean d() {
        Map<String, String> map = this.b;
        return (map == null || map.isEmpty() || TextUtils.isEmpty(this.b.get("process_name")) || TextUtils.isEmpty(this.b.get("crash_thread_name")) || TextUtils.isEmpty(this.b.get(AnalyticsProviderAdjust.EventKeys.pid)) || TextUtils.isEmpty(this.b.get(ScarConstants.TOKEN_ID_KEY)) || TextUtils.isEmpty(this.b.get("start_time")) || TextUtils.isEmpty(this.b.get("crash_time")) || TextUtils.isEmpty(this.b.get("signal_line"))) ? false : true;
    }

    public final String e() {
        return this.b.get("signal_line");
    }

    public final Map<String, String> f() {
        return this.b;
    }
}
