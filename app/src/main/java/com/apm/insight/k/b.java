package com.apm.insight.k;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.entity.Header;
import com.apm.insight.entity.b;
import com.apm.insight.k.c;
import com.apm.insight.l.n;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.o;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.RequestConfiguration;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static volatile b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f187a;
    private C0139b f;
    private HashMap<String, C0139b> g;
    private List<File> c = new ArrayList();
    private List<File> d = new ArrayList();
    private int e = -1;
    private volatile boolean h = false;
    private Runnable i = new Runnable() { // from class: com.apm.insight.k.b.1
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            b.this.f();
        }
    };
    private Runnable j = new Runnable() { // from class: com.apm.insight.k.b.2
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            b.this.d();
        }
    };

    private b(Context context) {
        this.f187a = context;
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(com.apm.insight.e.g());
                }
            }
        }
        return b;
    }

    /* JADX INFO: renamed from: com.apm.insight.k.b$b, reason: collision with other inner class name */
    static class C0139b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f193a;
        a d;
        a e;
        List<a> b = new ArrayList();
        List<a> c = new ArrayList();
        boolean f = false;
        int g = 0;

        C0139b(String str) {
            this.f193a = str;
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        File f192a;
        long b;
        long c;
        CrashType d;
        String e;

        a(File file, CrashType crashType) {
            this.b = -1L;
            this.c = -1L;
            this.f192a = file;
            this.d = crashType;
            this.e = file.getName();
        }

        a(File file, long j, CrashType crashType) {
            this.c = -1L;
            this.f192a = file;
            this.b = j;
            this.d = crashType;
            this.e = file.getName();
        }
    }

    public final void a(boolean z) throws Throwable {
        if (!Npth.isStopUpload() && z) {
            if (this.f == null) {
                this.f = new C0139b("old_uuid");
                HashMap<String, C0139b> map = new HashMap<>();
                this.g = map;
                a(map);
                a(this.g, this.f);
                com.apm.insight.l.f.a(com.apm.insight.l.j.b(this.f187a));
                b(this.g);
                b(this.f, true, null);
                a(this.f, true, null);
                this.f = null;
                if (this.g.isEmpty()) {
                    e();
                } else {
                    f();
                }
            }
            g();
            com.apm.insight.a.c();
        }
    }

    public final void b() {
        try {
            if (!this.h && com.apm.insight.l.a.b(com.apm.insight.e.g())) {
                m.a().a(this.j);
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean c() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() throws Throwable {
        if (this.h || this.g == null) {
            return;
        }
        if (!com.apm.insight.l.k.b(this.f187a)) {
            e();
        }
        if (this.e == -1) {
            if (com.apm.insight.runtime.a.a() && com.apm.insight.runtime.a.f()) {
                this.e = 1;
            } else {
                this.e = 0;
            }
        }
        boolean z = this.e == 1;
        com.apm.insight.runtime.f fVar = new com.apm.insight.runtime.f(this.f187a);
        Iterator<C0139b> it = this.g.values().iterator();
        while (it.hasNext()) {
            b(it.next(), z, fVar);
        }
        Iterator<C0139b> it2 = this.g.values().iterator();
        while (it2.hasNext()) {
            a(it2.next(), z, fVar);
        }
        Iterator<C0139b> it3 = this.g.values().iterator();
        while (it3.hasNext()) {
            com.apm.insight.l.f.a(com.apm.insight.l.j.a(this.f187a, it3.next().f193a));
        }
        fVar.a();
        com.apm.insight.runtime.b.a();
        e();
    }

    private void e() {
        this.h = true;
        this.g = null;
        NativeImpl.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() throws Throwable {
        if (this.h) {
            return;
        }
        if (com.apm.insight.l.k.b(this.f187a) && (System.currentTimeMillis() - com.apm.insight.e.j() > 5000 || !com.apm.insight.e.i().isApmExists() || Npth.hasCrash())) {
            d();
        } else {
            m.a().a(this.i, 5000L);
        }
    }

    private void a(HashMap<String, C0139b> map) {
        File[] fileArrListFiles = com.apm.insight.l.j.f(this.f187a).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (int i = 0; i < fileArrListFiles.length && i < 5; i++) {
            File file = fileArrListFiles[i];
            try {
                if (!file.isDirectory()) {
                    com.apm.insight.l.f.a(file);
                } else if (file.getName().endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                    String name = file.getName();
                    C0139b c0139b = map.get(name);
                    if (c0139b == null) {
                        c0139b = new C0139b(name);
                        map.put(name, c0139b);
                    }
                    JSONArray jSONArrayA = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.l(file), com.apm.insight.l.j.m(file));
                    c0139b.g = jSONArrayA.length();
                    if (c0139b.g > 0) {
                        try {
                            com.apm.insight.l.f.a(com.apm.insight.l.j.n(file), jSONArrayA);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    com.apm.insight.l.f.a(file);
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                com.apm.insight.l.f.a(file);
            }
        }
    }

    private void b(HashMap<String, C0139b> map) {
        File[] fileArrListFiles = com.apm.insight.l.j.d(this.f187a).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (int i = 0; i < fileArrListFiles.length && i < 5; i++) {
            File file = fileArrListFiles[i];
            try {
                if (!file.isDirectory()) {
                    com.apm.insight.l.f.a(file);
                } else if (file.getName().endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                    String name = file.getName();
                    C0139b c0139b = map.get(name);
                    if (c0139b == null) {
                        c0139b = new C0139b(name);
                        map.put(name, c0139b);
                    }
                    c0139b.c.add(new a(file, CrashType.NATIVE));
                } else {
                    com.apm.insight.l.f.a(file);
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                com.apm.insight.l.f.a(file);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d2 A[Catch: all -> 0x0134, TryCatch #0 {all -> 0x0134, blocks: (B:9:0x0023, B:11:0x0031, B:12:0x0036, B:15:0x003e, B:18:0x004e, B:20:0x0054, B:21:0x0059, B:23:0x0065, B:25:0x0070, B:29:0x008a, B:55:0x00d4, B:57:0x00dc, B:58:0x00e4, B:60:0x00ef, B:68:0x0109, B:63:0x00fb, B:65:0x00ff, B:67:0x0107, B:52:0x00cc, B:53:0x00cf, B:54:0x00d2, B:36:0x00a3, B:39:0x00ad, B:42:0x00b7, B:69:0x010f, B:70:0x0130, B:27:0x007c), top: B:76:0x0023, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dc A[Catch: all -> 0x0134, TryCatch #0 {all -> 0x0134, blocks: (B:9:0x0023, B:11:0x0031, B:12:0x0036, B:15:0x003e, B:18:0x004e, B:20:0x0054, B:21:0x0059, B:23:0x0065, B:25:0x0070, B:29:0x008a, B:55:0x00d4, B:57:0x00dc, B:58:0x00e4, B:60:0x00ef, B:68:0x0109, B:63:0x00fb, B:65:0x00ff, B:67:0x0107, B:52:0x00cc, B:53:0x00cf, B:54:0x00d2, B:36:0x00a3, B:39:0x00ad, B:42:0x00b7, B:69:0x010f, B:70:0x0130, B:27:0x007c), top: B:76:0x0023, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ef A[Catch: all -> 0x0134, TryCatch #0 {all -> 0x0134, blocks: (B:9:0x0023, B:11:0x0031, B:12:0x0036, B:15:0x003e, B:18:0x004e, B:20:0x0054, B:21:0x0059, B:23:0x0065, B:25:0x0070, B:29:0x008a, B:55:0x00d4, B:57:0x00dc, B:58:0x00e4, B:60:0x00ef, B:68:0x0109, B:63:0x00fb, B:65:0x00ff, B:67:0x0107, B:52:0x00cc, B:53:0x00cf, B:54:0x00d2, B:36:0x00a3, B:39:0x00ad, B:42:0x00b7, B:69:0x010f, B:70:0x0130, B:27:0x007c), top: B:76:0x0023, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f9 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.HashMap<java.lang.String, com.apm.insight.k.b.C0139b> r17, com.apm.insight.k.b.C0139b r18) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.b.a(java.util.HashMap, com.apm.insight.k.b$b):void");
    }

    private static JSONObject a(com.apm.insight.nativecrash.a aVar) {
        JSONObject jSONObjectB = aVar.b();
        if (jSONObjectB != null && jSONObjectB.length() != 0) {
            return jSONObjectB;
        }
        if (com.apm.insight.e.d()) {
            aVar.j();
        }
        if (!aVar.a()) {
            aVar.i();
            return null;
        }
        if (!aVar.d()) {
            aVar.i();
            return null;
        }
        if (aVar.e()) {
            aVar.i();
            return null;
        }
        aVar.c();
        return aVar.h();
    }

    private void a(final C0139b c0139b, boolean z, com.apm.insight.runtime.f fVar) {
        Iterator<a> it;
        File file;
        CrashType crashType;
        final File file2;
        CrashType crashType2;
        if (c0139b.b.isEmpty()) {
            return;
        }
        if (c0139b.e == null) {
            c0139b.e = c0139b.d;
        }
        for (Iterator<a> it2 = c0139b.b.iterator(); it2.hasNext(); it2 = it) {
            a next = it2.next();
            try {
                file = next.f192a;
                crashType = next.d;
                it = it2;
            } catch (Throwable th) {
                th = th;
                it = it2;
            }
            try {
                final com.apm.insight.f.b bVarA = a(file, crashType, c0139b.f193a, next.b, next.c);
                if (bVarA == null) {
                    com.apm.insight.l.f.a(file);
                } else {
                    JSONObject jSONObjectB = bVarA.b();
                    if (jSONObjectB == null) {
                        com.apm.insight.l.f.a(file);
                    } else {
                        JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject("header");
                        if (jSONObjectOptJSONObject == null) {
                            com.apm.insight.l.f.a(file);
                        } else {
                            if (crashType == null) {
                                file2 = file;
                                if (new File(file2, file.getName()).exists() || file2.getName().split("_").length < 5) {
                                    if (e.b(bVarA.a(), jSONObjectB.toString()).a()) {
                                        com.apm.insight.l.f.a(file2);
                                    }
                                }
                            } else {
                                file2 = file;
                            }
                            File fileA = com.apm.insight.entity.b.a(file2);
                            if (!fileA.exists()) {
                                com.apm.insight.l.f.a(file2);
                            } else {
                                try {
                                    JSONArray jSONArray = new JSONArray(com.apm.insight.l.f.a(fileA, "\n"));
                                    JSONObject jSONObjectOptJSONObject2 = crashType == CrashType.LAUNCH ? ((JSONArray) jSONObjectB.opt("data")).optJSONObject(0) : jSONObjectB;
                                    if ((!z && c0139b.e != next) || next.e.contains("ignore")) {
                                        try {
                                            com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "aid", String.valueOf(String.valueOf(jSONObjectOptJSONObject.opt("aid"))));
                                            crashType2 = crashType;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            crashType2 = crashType;
                                        }
                                        try {
                                            com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "has_ignore", String.valueOf(next.e.contains("ignore")));
                                            jSONObjectOptJSONObject.put("aid", 2010);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            com.apm.insight.c.a();
                                            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                                        }
                                    } else {
                                        crashType2 = crashType;
                                        if (fVar != null && !fVar.a(jSONObjectOptJSONObject2.optString("crash_md5", "default"))) {
                                            com.apm.insight.l.f.a(next.f192a);
                                        }
                                    }
                                    com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "start_uuid", c0139b.f193a);
                                    com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "leak_threads_count", String.valueOf(c0139b.g));
                                    com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "crash_thread_name", jSONObjectOptJSONObject2.optString("crash_thread_name", "unknown"));
                                    try {
                                        com.apm.insight.entity.b.a(jSONObjectB, jSONArray, new b.a() { // from class: com.apm.insight.k.b.3
                                            @Override // com.apm.insight.entity.b.a
                                            public final void a(JSONObject jSONObject) {
                                                e.a(bVarA.a(), jSONObject.toString(), new File(file2, "logZip"), com.apm.insight.l.j.a(b.this.f187a, c0139b.f193a));
                                            }
                                        });
                                        if (!com.apm.insight.l.f.a(file2)) {
                                            com.apm.insight.e.a.a().a(com.apm.insight.d.a.b(file2.getAbsolutePath()));
                                        }
                                        c.a(crashType2, jSONObjectB);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        com.apm.insight.c.a();
                                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                                        com.apm.insight.l.f.a(next.f192a);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                com.apm.insight.l.f.a(next.f192a);
            }
        }
    }

    private void b(final C0139b c0139b, boolean z, com.apm.insight.runtime.f fVar) {
        boolean z2;
        JSONObject jSONObjectA;
        if (c0139b.c.size() <= 1 && c0139b.c.isEmpty()) {
            c0139b.e = c0139b.d;
            return;
        }
        boolean zB = com.apm.insight.l.k.b(this.f187a);
        c0139b.e = c0139b.d;
        com.apm.insight.nativecrash.a aVar = new com.apm.insight.nativecrash.a(this.f187a);
        for (a aVar2 : c0139b.c) {
            final File file = aVar2.f192a;
            try {
                aVar.a(file);
                jSONObjectA = a(aVar);
            } catch (Throwable th) {
                th = th;
                z2 = zB;
            }
            if (jSONObjectA == null || jSONObjectA.length() == 0) {
                z2 = zB;
                aVar.i();
            } else if (jSONObjectA.length() != 0) {
                if (!z) {
                    long jOptLong = jSONObjectA.optLong("crash_time");
                    try {
                        if (c0139b.e == null) {
                            c0139b.e = aVar2;
                            c0139b.f = true;
                            if (fVar == null || fVar.a("default")) {
                                z2 = zB;
                            } else {
                                aVar.i();
                            }
                        } else {
                            if (c0139b.f) {
                                z2 = zB;
                            } else {
                                z2 = zB;
                                try {
                                    if (jOptLong < c0139b.e.b) {
                                        c0139b.e = aVar2;
                                        if (fVar != null && !fVar.a("default")) {
                                            aVar.i();
                                            zB = z2;
                                        } else {
                                            a(file);
                                            c0139b.f = true;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    com.apm.insight.c.a();
                                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                                    com.apm.insight.l.f.a(file);
                                    zB = z2;
                                }
                            }
                            com.apm.insight.entity.a.a(jSONObjectA, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "aid", String.valueOf(jSONObjectA.optJSONObject("header").opt("aid")));
                            jSONObjectA.optJSONObject("header").put("aid", 2010);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z2 = zB;
                    }
                } else {
                    z2 = zB;
                    if (fVar != null && !fVar.a("default")) {
                        aVar.i();
                    }
                }
                com.apm.insight.entity.a.a(jSONObjectA, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "start_uuid", c0139b.f193a);
                com.apm.insight.entity.a.a(jSONObjectA, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "crash_thread_name", jSONObjectA.optString("crash_thread_name", "unknown"));
                if (z2) {
                    try {
                        c.a aVar3 = new c.a(jSONObjectA, CrashType.NATIVE);
                        com.apm.insight.entity.b.a(jSONObjectA, com.apm.insight.entity.b.a(aVar3.c(), aVar3.a(), o.a().b(aVar3.b() == -1 ? System.currentTimeMillis() : aVar3.b())), new b.a() { // from class: com.apm.insight.k.b.4
                            @Override // com.apm.insight.entity.b.a
                            public final void a(JSONObject jSONObject) {
                                d.a();
                                d.a(jSONObject, file, com.apm.insight.l.j.a(b.this.f187a, c0139b.f193a));
                            }
                        });
                        if (!aVar.i()) {
                            aVar.f();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                        com.apm.insight.l.f.a(file);
                    }
                }
                c.a(CrashType.NATIVE, jSONObjectA);
            } else {
                z2 = zB;
            }
            zB = z2;
        }
    }

    private static boolean a(File file) {
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && str.endsWith("")) {
                return true;
            }
        }
        return false;
    }

    private com.apm.insight.f.b a(File file, CrashType crashType, String str, long j, long j2) {
        com.apm.insight.f.b bVar;
        JSONObject jSONObjectB;
        try {
            try {
                if (file.isFile()) {
                    com.apm.insight.l.f.a(file);
                    return null;
                }
                boolean z = crashType == CrashType.LAUNCH;
                if (crashType == null) {
                    try {
                        return com.apm.insight.l.f.b(new File(file, file.getName()).getAbsolutePath());
                    } catch (Throwable th) {
                        th = th;
                        bVar = null;
                        com.apm.insight.l.f.a(file);
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                        return bVar;
                    }
                }
                com.apm.insight.f.b bVarA = com.apm.insight.l.f.a(file, crashType);
                try {
                    jSONObjectB = bVarA.b();
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    if (bVarA.b() != null) {
                        if (crashType == CrashType.ANR) {
                            return bVarA;
                        }
                        jSONObjectB.put("crash_time", j);
                        jSONObjectB.put("app_start_time", j2);
                        JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject("header");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = Header.a(j).f();
                        } else if (z) {
                            jSONObjectB.remove("header");
                        }
                        String strOptString = jSONObjectOptJSONObject.optString("sdk_version_name", null);
                        if (strOptString == null) {
                            strOptString = "2.0.0.8";
                        }
                        com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "sdk_version", strOptString);
                        JSONArray jSONArrayOptJSONArray = jSONObjectB.optJSONArray("logcat");
                        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                            jSONObjectB.put("logcat", com.apm.insight.runtime.h.a(str));
                        }
                        com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "has_dump", "true");
                        com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "has_logcat", String.valueOf(!com.apm.insight.a.a(jSONObjectB, "logcat")));
                        com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "memory_leak", String.valueOf(com.apm.insight.entity.a.a(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "fd_leak", String.valueOf(com.apm.insight.entity.a.b(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "threads_leak", String.valueOf(com.apm.insight.entity.a.c(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "is_64_devices", String.valueOf(Header.a()));
                        com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "is_64_runtime", String.valueOf(NativeImpl.f()));
                        com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "is_x86_devices", String.valueOf(Header.b()));
                        com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "has_meminfo_file", String.valueOf(com.apm.insight.l.j.d(str).exists()));
                        com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "is_root", String.valueOf(com.apm.insight.nativecrash.a.k()));
                        jSONObjectB.put("launch_did", com.apm.insight.i.a.a(this.f187a));
                        jSONObjectB.put("crash_uuid", file.getName());
                        try {
                            long j3 = Long.parseLong(com.apm.insight.runtime.b.a(j, str));
                            com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "lastAliveTime", Math.abs(j3 - j) < 60000 ? "< 60s" : "> 60s");
                            jSONObjectB.put("lastAliveTime", String.valueOf(j3));
                        } catch (Throwable unused) {
                            jSONObjectB.put("lastAliveTime", "unknown");
                            com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "lastAliveTime", "unknown");
                        }
                        jSONObjectB.put("has_dump", "true");
                        if (jSONObjectB.opt("storage") == null) {
                            com.apm.insight.e.g();
                            com.apm.insight.entity.a.a(jSONObjectB, n.a());
                        }
                        if (Header.b(jSONObjectOptJSONObject)) {
                            com.apm.insight.entity.a.a(jSONObjectB, ShareConstants.WEB_DIALOG_PARAM_FILTERS, "unauthentic_version", "unauthentic_version");
                        }
                        com.apm.insight.entity.d.b(jSONObjectB);
                        bVarA.b().put("upload_scene", "launch_scan");
                        if (z) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObjectB.put("event_type", "start_crash");
                            jSONObjectB.put("stack", jSONObjectB.remove("data"));
                            jSONObject.put("data", new JSONArray().put(jSONObjectB));
                            jSONObject.put("header", jSONObjectOptJSONObject);
                            bVarA.a(jSONObject);
                        } else {
                            jSONObjectB.put("isJava", 1);
                        }
                    } else {
                        com.apm.insight.l.f.a(file);
                    }
                    return bVarA;
                } catch (Throwable th3) {
                    th = th3;
                    bVar = bVarA;
                    com.apm.insight.l.f.a(file);
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                    return bVar;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            bVar = null;
        }
        com.apm.insight.l.f.a(file);
        com.apm.insight.c.a();
        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
        return bVar;
    }

    private void g() {
        File[] fileArrListFiles = com.apm.insight.l.j.i(this.f187a).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (int i = 0; i < fileArrListFiles.length && i < 5; i++) {
            File file = fileArrListFiles[i];
            if (file.getName().endsWith(".atmp")) {
                com.apm.insight.a.a.a();
                file.getAbsolutePath();
            } else {
                try {
                    com.apm.insight.f.b bVarC = com.apm.insight.l.f.c(file.getAbsolutePath());
                    if (bVarC != null) {
                        if (bVarC.b() != null) {
                            bVarC.b().put("upload_scene", "launch_scan");
                        }
                        if (e.a(e.d(), bVarC.e(), bVarC.d(), bVarC.f(), bVarC.g())) {
                            com.apm.insight.l.f.a(file);
                            String strC = bVarC.c();
                            if (!TextUtils.isEmpty(strC)) {
                                com.apm.insight.l.f.a(new File(strC));
                            }
                        }
                    } else {
                        com.apm.insight.l.f.a(file);
                    }
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                }
            }
        }
    }
}
