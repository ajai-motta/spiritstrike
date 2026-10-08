package com.apm.insight.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static o f263a;
    private File b;
    private File c;
    private File d;
    private Context e;
    private a f = null;

    public static o a() {
        if (f263a == null) {
            f263a = new o(com.apm.insight.e.g());
        }
        return f263a;
    }

    private o(Context context) {
        File fileC = com.apm.insight.l.j.c(context);
        if (!fileC.exists() || (!fileC.isDirectory() && fileC.delete())) {
            fileC.mkdirs();
            com.apm.insight.runtime.a.b.a();
        }
        this.b = fileC;
        this.c = new File(fileC, "did");
        this.d = new File(fileC, "device_uuid");
        this.e = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.util.Map<java.lang.String, java.lang.Object> r11, org.json.JSONArray r12) {
        /*
            r10 = this;
            android.content.Context r0 = r10.e
            com.apm.insight.entity.Header r0 = com.apm.insight.entity.Header.a(r0)
            org.json.JSONObject r6 = r0.a(r11)
            boolean r11 = com.apm.insight.entity.Header.c(r6)
            if (r11 == 0) goto L11
            return
        L11:
            long r8 = java.lang.System.currentTimeMillis()
            com.apm.insight.runtime.o$a r11 = r10.f
            if (r11 != 0) goto L1e
            java.lang.String r11 = ".ctx"
            r10.c(r11)
        L1e:
            com.apm.insight.runtime.o$a r11 = r10.f
            if (r11 != 0) goto L2a
            r1 = r10
            r2 = r8
            r4 = r8
            r7 = r12
            r1.a(r2, r4, r6, r7)
            return
        L2a:
            org.json.JSONObject r0 = com.apm.insight.runtime.o.a.a(r11)
            boolean r1 = com.apm.insight.entity.Header.c(r0)
            r2 = 1
            r3 = 2
            if (r1 != 0) goto L5e
            boolean r1 = com.apm.insight.entity.Header.c(r6)
            if (r1 == 0) goto L3e
            r0 = 0
            goto L5f
        L3e:
            java.lang.String r1 = "update_version_code"
            java.lang.Object r4 = r6.opt(r1)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.Object r1 = r0.opt(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L5e
            boolean r0 = com.apm.insight.entity.Header.d(r0)
            if (r0 == 0) goto L5e
            r0 = r2
            goto L5f
        L5e:
            r0 = r3
        L5f:
            if (r0 == r2) goto L6c
            if (r0 == r3) goto L64
            goto L7d
        L64:
            r1 = r10
            r2 = r8
            r4 = r8
            r7 = r12
            r1.a(r2, r4, r6, r7)
            goto L7d
        L6c:
            long r2 = com.apm.insight.runtime.o.a.b(r11)
            r1 = r10
            r4 = r8
            r7 = r12
            r1.a(r2, r4, r6, r7)
            java.io.File r11 = com.apm.insight.runtime.o.a.c(r11)
            com.apm.insight.l.f.a(r11)
        L7d:
            java.lang.String r11 = ""
            java.util.ArrayList r11 = r10.c(r11)     // Catch: java.lang.Throwable -> La6
            int r12 = r11.size()     // Catch: java.lang.Throwable -> La6
            r0 = 6
            if (r12 > r0) goto L8b
            return
        L8b:
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Throwable -> La6
        L8f:
            boolean r12 = r11.hasNext()     // Catch: java.lang.Throwable -> La6
            if (r12 == 0) goto La5
            java.lang.Object r12 = r11.next()     // Catch: java.lang.Throwable -> La6
            com.apm.insight.runtime.o$a r12 = (com.apm.insight.runtime.o.a) r12     // Catch: java.lang.Throwable -> La6
            boolean r0 = com.apm.insight.runtime.o.a.a(r12, r8)     // Catch: java.lang.Throwable -> La6
            if (r0 == 0) goto L8f
            com.apm.insight.runtime.o.a.d(r12)     // Catch: java.lang.Throwable -> La6
            goto L8f
        La5:
            return
        La6:
            r11 = move-exception
            com.apm.insight.c.a()
            java.lang.String r12 = "NPTH_CATCH"
            com.apm.insight.runtime.j.a(r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.o.a(java.util.Map, org.json.JSONArray):void");
    }

    private void a(long j, long j2, JSONObject jSONObject, JSONArray jSONArray) {
        File file = new File(this.b, j + "-" + j2 + ".ctx");
        File file2 = new File(this.b, j + "-" + j2 + ".allData");
        try {
            com.apm.insight.l.f.a(file, jSONObject);
            com.apm.insight.l.f.a(file2, jSONArray);
            this.f = new a(file, (byte) 0);
        } catch (IOException e) {
            com.apm.insight.c.a();
            j.a(e, "NPTH_CATCH");
        }
    }

    protected final String b() {
        try {
            return com.apm.insight.l.f.a(this.c.getAbsolutePath(), "\n");
        } catch (Throwable unused) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    public final String c() {
        try {
            return com.apm.insight.l.f.a(this.d.getAbsolutePath(), "\n");
        } catch (Throwable unused) {
            return null;
        }
    }

    protected final void a(String str) {
        try {
            com.apm.insight.l.f.a(this.c, str, false);
        } catch (Throwable unused) {
        }
    }

    public final void b(String str) {
        try {
            com.apm.insight.l.f.a(this.d, str, false);
        } catch (Throwable unused) {
        }
    }

    private ArrayList<a> c(final String str) {
        File[] fileArrListFiles = this.b.listFiles(new FilenameFilter() { // from class: com.apm.insight.runtime.o.1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                return str2.endsWith(str) && Pattern.compile("^\\d{1,13}-\\d{1,13}.*").matcher(str2).matches();
            }
        });
        ArrayList<a> arrayList = new ArrayList<>();
        if (fileArrListFiles == null) {
            return arrayList;
        }
        com.apm.insight.a.a((Object) ("foundRuntimeContextFiles " + fileArrListFiles.length));
        byte b = 0;
        a aVar = null;
        for (File file : fileArrListFiles) {
            try {
                a aVar2 = new a(file, b);
                arrayList.add(aVar2);
                if (this.f == null && ".ctx".equals(str) && (aVar == null || aVar2.b >= aVar.b)) {
                    aVar = aVar2;
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                j.a(th, "NPTH_CATCH");
            }
        }
        if (this.f == null && aVar != null) {
            this.f = aVar;
        }
        return arrayList;
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f265a;
        private long b;
        private File c;
        private JSONObject d;

        /* synthetic */ a(File file, byte b) {
            this(file);
        }

        private a(File file) {
            this.d = null;
            this.c = file;
            String[] strArrSplit = file.getName().split("-|\\.");
            if (strArrSplit.length >= 2) {
                this.f265a = Long.parseLong(strArrSplit[0]);
                this.b = Long.parseLong(strArrSplit[1]);
                return;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name) || name.length() < 13) {
                return;
            }
            String strSubstring = name.substring(0, 13);
            if (TextUtils.isDigitsOnly(strSubstring)) {
                long j = Long.parseLong(strSubstring);
                this.f265a = j;
                this.b = j;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject a() {
            if (this.d == null) {
                try {
                    this.d = new JSONObject(com.apm.insight.l.f.a(this.c.getAbsolutePath(), "\n"));
                } catch (Throwable unused) {
                }
                if (this.d == null) {
                    this.d = new JSONObject();
                }
            }
            return this.d;
        }

        static /* synthetic */ boolean a(a aVar, long j) {
            long j2 = aVar.f265a;
            if (j2 > j && j2 - j > 604800000) {
                return true;
            }
            long j3 = aVar.b;
            if (j3 >= j || j - j3 <= 604800000) {
                return aVar.c.lastModified() < j && j - aVar.c.lastModified() > 604800000;
            }
            return true;
        }

        static /* synthetic */ void d(a aVar) {
            aVar.c.delete();
        }
    }

    public final JSONObject a(long j) {
        JSONObject jSONObject;
        File file;
        boolean z;
        String strA;
        Iterator<a> it = c(".ctx").iterator();
        while (true) {
            jSONObject = null;
            if (!it.hasNext()) {
                file = null;
                break;
            }
            a next = it.next();
            if (j >= next.f265a && j <= next.b) {
                file = next.c;
                break;
            }
        }
        if (file == null) {
            a aVar = null;
            for (a aVar2 : c(".ctx")) {
                if (aVar == null || Math.abs(aVar.b - j) > Math.abs(aVar2.b - j)) {
                    aVar = aVar2;
                }
            }
            file = aVar == null ? null : aVar.c;
            z = true;
        } else {
            z = false;
        }
        if (file != null) {
            try {
                strA = com.apm.insight.l.f.a(file.getAbsolutePath(), "\n");
            } catch (Throwable th) {
                th = th;
                strA = null;
            }
            try {
                jSONObject = new JSONObject(strA);
            } catch (Throwable th2) {
                th = th2;
                com.apm.insight.c.a();
                j.a(new IOException("content :".concat(String.valueOf(strA)), th), "NPTH_CATCH");
            }
        }
        if (jSONObject != null && z) {
            try {
                jSONObject.put("unauthentic_version", 1);
            } catch (JSONException e) {
                com.apm.insight.c.a();
                j.a(e, "NPTH_CATCH");
            }
        }
        return jSONObject;
    }

    public final JSONArray b(long j) {
        File file;
        String strA;
        Iterator<a> it = c(".allData").iterator();
        while (true) {
            if (!it.hasNext()) {
                file = null;
                break;
            }
            a next = it.next();
            if (j >= next.f265a && j <= next.b) {
                file = next.c;
                break;
            }
        }
        if (file == null) {
            a aVar = null;
            for (a aVar2 : c(".allData")) {
                if (aVar == null || Math.abs(aVar.b - j) > Math.abs(aVar2.b - j)) {
                    aVar = aVar2;
                }
            }
            file = aVar == null ? null : aVar.c;
        }
        if (file == null) {
            return null;
        }
        try {
            strA = com.apm.insight.l.f.a(file.getAbsolutePath(), "\n");
        } catch (Throwable th) {
            th = th;
            strA = null;
        }
        try {
            return new JSONArray(strA);
        } catch (Throwable th2) {
            th = th2;
            com.apm.insight.c.a();
            j.a(new IOException("content :".concat(String.valueOf(strA)), th), "NPTH_CATCH");
            return null;
        }
    }
}
