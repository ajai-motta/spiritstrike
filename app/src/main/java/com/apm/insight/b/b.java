package com.apm.insight.b;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.adjust.sdk.Constants;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.Npth;
import com.apm.insight.entity.Header;
import com.apm.insight.entity.b;
import com.apm.insight.l.m;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.l;
import com.apm.insight.runtime.n;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static volatile boolean z = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f131a;
    private final Context b;
    private volatile boolean c;
    private JSONObject g;
    private JSONObject h;
    private JSONArray m;
    private JSONObject n;
    private JSONArray q;
    private JSONArray r;
    private JSONObject s;
    private boolean t;
    private volatile boolean v;
    private long d = -1;
    private File e = null;
    private boolean f = true;
    private String i = "unknown";
    private String j = "unknown";
    private String k = "unknown";
    private String l = "npth_inner_default";
    private int o = 0;
    private long p = -1;
    private final Object u = new Object();
    private long w = -1;
    private long x = 0;
    private final Runnable y = new Runnable() { // from class: com.apm.insight.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            try {
                b.this.g();
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
            }
        }
    };
    private int A = 0;
    private List<Pattern> B = null;
    private Pattern C = null;
    private File D = null;

    public b(Context context) {
        this.b = context;
    }

    public final void a() {
        if (this.c) {
            return;
        }
        this.f131a = new c(this);
        this.d = com.apm.insight.e.j();
        this.c = true;
    }

    public final void b() {
        if (this.c) {
            this.c = false;
            c cVar = this.f131a;
            if (cVar != null) {
                cVar.b();
            }
            this.f131a = null;
        }
    }

    public final void c() {
        c cVar = this.f131a;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void d() {
        synchronized (this.u) {
        }
        this.y.run();
    }

    public final void e() {
        if (NativeImpl.h()) {
            try {
                com.apm.insight.l.f.a(i(), String.valueOf(this.A + 1), false);
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
            }
        }
        this.w = SystemClock.uptimeMillis();
        this.v = true;
    }

    public final void f() {
        File fileI = i();
        try {
            int iIntValue = Integer.decode(com.apm.insight.l.f.a(fileI.getAbsolutePath(), "\n")).intValue();
            this.A = iIntValue;
            if (iIntValue >= 2) {
                NativeImpl.a(false);
            } else {
                NativeImpl.a(true);
            }
        } catch (IOException unused) {
            NativeImpl.a(true);
        } catch (Throwable unused2) {
            com.apm.insight.l.f.a(fileI);
        }
    }

    private boolean a(long j) {
        if (this.v) {
            this.v = false;
            b(j);
        }
        return false;
    }

    private static boolean h() {
        boolean z2 = !com.apm.insight.l.a.a();
        if (!z2 || com.apm.insight.runtime.a.b.d().e() > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return z2;
        }
        return false;
    }

    private void b(long j) {
        if (this.x != this.w) {
            try {
                this.p = System.currentTimeMillis();
                if (com.apm.insight.e.x()) {
                    this.r = f.b().b();
                    this.q = j.a(j);
                    this.h = f.b().a(j).a();
                }
                JSONObject jSONObject = new JSONObject();
                this.s = jSONObject;
                com.apm.insight.l.a.a(this.b, jSONObject);
                this.t = h();
                this.f = !Npth.hasCrash();
            } catch (Throwable unused) {
            }
            try {
                this.d = this.p;
                String strB = com.apm.insight.l.j.b();
                File file = new File(new File(com.apm.insight.l.j.f(this.b), strB), "trace_" + com.apm.insight.l.a.b().replace(AbstractJsonLexerKt.COLON, '_') + ".txt");
                file.getParentFile().mkdirs();
                com.apm.insight.l.f.a(file, com.apm.insight.l.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                n.a("anr_trace", strB);
                NativeImpl.i(file.getAbsolutePath());
                try {
                    JSONArray jSONArrayA = com.apm.insight.l.f.a(file.getAbsolutePath());
                    this.m = jSONArrayA;
                    a(jSONArrayA);
                } catch (IOException unused2) {
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                }
                if (this.g == null) {
                    this.g = d.a();
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
            }
            com.apm.insight.a.d();
        } else {
            try {
                this.d = this.p;
                String strB2 = com.apm.insight.l.j.b();
                File file2 = new File(new File(com.apm.insight.l.j.f(this.b), strB2), "trace" + com.apm.insight.l.a.b().replace(AbstractJsonLexerKt.COLON, '_') + ".txt");
                file2.getParentFile().mkdirs();
                com.apm.insight.l.f.a(file2, com.apm.insight.l.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                n.a("anr_trace", strB2);
                NativeImpl.i(file2.getAbsolutePath());
                try {
                    JSONArray jSONArrayA2 = com.apm.insight.l.f.a(file2.getAbsolutePath());
                    this.m = jSONArrayA2;
                    a(jSONArrayA2);
                } catch (IOException unused3) {
                } catch (Throwable th3) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th3, "NPTH_CATCH");
                }
                if (this.g == null) {
                    this.g = d.a();
                }
            } catch (Throwable th4) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th4, "NPTH_CATCH");
            }
        }
        long j2 = this.w;
        this.x = j2;
        this.w = -1L;
        if (j2 == -1) {
            this.x = (-1) - 1;
        }
    }

    private void a(JSONArray jSONArray) {
        int[] iArrB;
        int[] iArrB2;
        if (jSONArray == null) {
            return;
        }
        this.g = null;
        this.n = null;
        this.o = 0;
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        this.i = "unknown";
        this.j = "unknown";
        this.k = "unknown";
        int[] iArr = {0, 0, 0};
        JSONArray jSONArray5 = jSONArray4;
        String strTrim = null;
        boolean z2 = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i);
            if (TextUtils.isEmpty(strOptString)) {
                if (jSONArray5.length() > 0 && !TextUtils.isEmpty(strTrim)) {
                    if (this.g == null && "main".equals(strTrim)) {
                        this.g = c(jSONArray5);
                    } else {
                        jSONArray2.put(a(strTrim, jSONArray5));
                    }
                    try {
                        if (!"main".equals(strTrim)) {
                            strTrim = strTrim.substring(0, strTrim.indexOf(40)).trim();
                        }
                    } catch (Throwable unused) {
                    }
                    String str = strTrim;
                    if (!a(str)) {
                        try {
                            iArrB2 = b(jSONArray5);
                        } catch (IllegalArgumentException e) {
                            com.apm.insight.c.a();
                            com.apm.insight.runtime.j.a(e, "NPTH_CATCH");
                            iArrB2 = null;
                        } catch (Throwable unused2) {
                            iArrB2 = null;
                        }
                        if (iArrB2 != null) {
                            int i2 = iArrB2[0];
                            if (i2 > iArr[0]) {
                                iArr[0] = i2;
                                this.i = str;
                            }
                            int i3 = iArrB2[1];
                            if (i3 > iArr[1]) {
                                iArr[1] = i3;
                                this.j = str;
                            }
                            int i4 = iArrB2[2];
                            if (i4 > iArr[2]) {
                                iArr[2] = i4;
                                this.k = str;
                            }
                        }
                    }
                }
                if (jSONArray5.length() > 0) {
                    jSONArray5 = new JSONArray();
                }
                strTrim = null;
            } else if (!z2) {
                if (strOptString.startsWith("DALVIK THREADS") || strOptString.startsWith("suspend") || strOptString.startsWith("\"")) {
                    z2 = true;
                }
                jSONArray3.put(strOptString);
            } else if (z2) {
                if (strOptString.contains(" prio=")) {
                    if (jSONArray5.length() > 0 && !TextUtils.isEmpty(strTrim)) {
                        if (this.g == null && "main".equals(strTrim)) {
                            this.g = c(jSONArray5);
                        } else {
                            jSONArray2.put(a(strTrim, jSONArray5));
                        }
                        try {
                            if (!"main".equals(strTrim)) {
                                strTrim = strTrim.substring(0, strTrim.indexOf(40)).trim();
                            }
                        } catch (Throwable unused3) {
                        }
                        String str2 = strTrim;
                        if (!a(str2)) {
                            try {
                                iArrB = b(jSONArray5);
                            } catch (IllegalArgumentException e2) {
                                com.apm.insight.c.a();
                                com.apm.insight.runtime.j.a(e2, "NPTH_CATCH");
                                iArrB = null;
                            } catch (Throwable unused4) {
                                iArrB = null;
                            }
                            if (iArrB != null) {
                                int i5 = iArrB[0];
                                if (i5 > iArr[0]) {
                                    iArr[0] = i5;
                                    this.i = str2;
                                }
                                int i6 = iArrB[1];
                                if (i6 > iArr[1]) {
                                    iArr[1] = i6;
                                    this.j = str2;
                                }
                                int i7 = iArrB[2];
                                if (i7 > iArr[2]) {
                                    iArr[2] = i7;
                                    this.k = str2;
                                }
                            }
                        }
                    }
                    String strSubstring = strOptString.substring(1, strOptString.indexOf(34, 1));
                    strTrim = "main".equals(strSubstring) ? strSubstring : strSubstring + "  (" + strOptString.substring(strOptString.indexOf(34, 2) + 1) + " )";
                    if (jSONArray5.length() > 0) {
                        jSONArray5 = new JSONArray();
                    }
                    jSONArray5.put(strOptString);
                } else if (TextUtils.isEmpty(strTrim)) {
                    jSONArray3.put(strOptString);
                } else {
                    jSONArray5.put(strOptString);
                }
            }
        }
        if (jSONArray2.length() > 0) {
            this.m = jSONArray3;
            try {
                JSONObject jSONObject = new JSONObject();
                this.n = jSONObject;
                jSONObject.put("thread_all_count", jSONArray2.length());
                this.n.put("thread_stacks", jSONArray2);
            } catch (JSONException unused5) {
            }
        }
    }

    private boolean a(String str) {
        if (this.B == null) {
            JSONArray jSONArrayB = com.apm.insight.runtime.a.b();
            if (jSONArrayB != null) {
                this.B = new LinkedList();
                this.l = jSONArrayB.optString(0);
                for (int i = 1; i < jSONArrayB.length(); i++) {
                    try {
                        this.B.add(Pattern.compile(jSONArrayB.optString(i)));
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.B == null) {
                LinkedList linkedList = new LinkedList();
                this.B = linkedList;
                linkedList.add(Pattern.compile("^main$"));
                this.B.add(Pattern.compile("^default_npth_thread$"));
                this.B.add(Pattern.compile("^RenderThread$"));
                this.B.add(Pattern.compile("^Jit thread pool worker thread.*$"));
            }
        }
        Iterator<Pattern> it = this.B.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private int[] b(JSONArray jSONArray) throws IllegalArgumentException {
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i);
            int iIndexOf = (strOptString == null || strOptString.isEmpty()) ? -1 : strOptString.indexOf("utm=");
            if (iIndexOf > 0) {
                if (this.C == null) {
                    this.C = Pattern.compile("[^0-9]+");
                }
                String[] strArrSplit = this.C.split(strOptString.substring(iIndexOf));
                if (strArrSplit == null || strArrSplit.length < 2) {
                    return null;
                }
                int iIntValue = Integer.decode(strArrSplit[1]).intValue();
                int iIntValue2 = Integer.decode(strArrSplit[2]).intValue();
                return new int[]{iIntValue, iIntValue2, iIntValue + iIntValue2};
            }
        }
        return null;
    }

    private JSONObject c(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayB = com.apm.insight.a.b(jSONArray);
        if (jSONArrayB.length() != jSONArray.length()) {
            this.o++;
        }
        try {
            jSONObject.put("thread_number", 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jSONArrayB.length(); i++) {
                sb.append(jSONArrayB.getString(i));
                sb.append('\n');
            }
            jSONObject.put("mainStackFromTrace", sb.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private JSONObject a(String str, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayB = com.apm.insight.a.b(jSONArray);
        if (jSONArrayB.length() != jSONArray.length()) {
            this.o++;
        }
        try {
            jSONObject.put("thread_name", str);
            jSONObject.put("thread_stack", jSONArrayB);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private File i() {
        if (this.D == null) {
            this.D = new File(this.b.getFilesDir(), "has_anr_signal_" + com.apm.insight.l.a.b().replaceAll(":", "_"));
        }
        return this.D;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x01f6, code lost:
    
        if (r8 != 5) goto L135;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0230 A[PHI: r28
  0x0230: PHI (r28v3 char) = (r28v2 char), (r28v18 char) binds: [B:124:0x022a, B:114:0x01fc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x023e A[PHI: r28
  0x023e: PHI (r28v4 char) = (r28v3 char), (r28v19 char) binds: [B:127:0x0238, B:113:0x01f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0248 A[PHI: r28
  0x0248: PHI (r28v15 char) = (r28v4 char), (r28v20 char) binds: [B:130:0x0244, B:111:0x01f6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02b3 A[LOOP:2: B:98:0x01e0->B:154:0x02b3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03ec A[EDGE_INSN: B:237:0x03ec->B:206:0x03ec BREAK  A[LOOP:0: B:3:0x0038->B:204:0x03d5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x038a A[EDGE_INSN: B:241:0x038a->B:192:0x038a BREAK  A[LOOP:2: B:98:0x01e0->B:154:0x02b3], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r30, org.json.JSONObject r31) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1130
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.a(java.lang.String, org.json.JSONObject):void");
    }

    private static void a(HashMap<String, Float> map, JSONObject jSONObject, String str) throws JSONException {
        String strConcat = "npth_anr_".concat(String.valueOf(str));
        if (map.isEmpty()) {
            jSONObject.put(strConcat + "_total", "not found");
            return;
        }
        float fFloatValue = 0.0f;
        float fFloatValue2 = 0.0f;
        float fFloatValue3 = 0.0f;
        float fFloatValue4 = 0.0f;
        float fFloatValue5 = 0.0f;
        for (Map.Entry<String, Float> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.endsWith("user")) {
                fFloatValue += entry.getValue().floatValue();
            } else if (key.endsWith("kernel")) {
                fFloatValue2 += entry.getValue().floatValue();
            } else if (key.endsWith("iowait")) {
                fFloatValue3 += entry.getValue().floatValue();
            } else if (key.endsWith("irq")) {
                fFloatValue4 += entry.getValue().floatValue();
            } else if (key.endsWith("softirq")) {
                fFloatValue5 += entry.getValue().floatValue();
            }
        }
        float f = fFloatValue + fFloatValue2 + fFloatValue3 + fFloatValue4 + fFloatValue5;
        jSONObject.put(strConcat + "_total", b(f));
        jSONObject.put(strConcat + "_kernel_user_ratio", a(fFloatValue2, f));
        jSONObject.put(strConcat + "_iowait_user_ratio", a(fFloatValue3, f));
    }

    private static String a(float f, float f2) {
        if (f2 > 0.0f) {
            return a(f / f2);
        }
        return f > 0.0f ? "100%" : "0%";
    }

    private static String a(float f) {
        if (f <= 0.0f) {
            return "0%";
        }
        if (f <= 0.1f) {
            return "0% - 10%";
        }
        if (f <= 0.3f) {
            return "10% - 30%";
        }
        if (f <= 0.6f) {
            return "30% - 60%";
        }
        if (f <= 0.9f) {
            return "60% - 90%";
        }
        return "90% - 100%";
    }

    private static String b(float f) {
        return a(f / 100.0f);
    }

    private static void b(String str, JSONArray jSONArray) {
        for (ICrashCallback iCrashCallback : l.a().e()) {
            try {
                if (iCrashCallback instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) iCrashCallback).a(CrashType.ANR, str, (Thread) null, jSONArray);
                } else {
                    iCrashCallback.onCrash(CrashType.ANR, str, null);
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
            }
        }
    }

    final boolean g() {
        String str;
        String str2;
        JSONArray jSONArrayB;
        JSONArray jSONArrayA;
        JSONObject jSONObject;
        boolean z2;
        JSONObject jSONObjectA;
        boolean z3;
        String str3;
        String str4;
        JSONArray jSONArray;
        final long j;
        JSONObject jSONObjectA2;
        JSONObject jSONObject2;
        String str5;
        JSONObject jSONObject3;
        boolean zB = com.apm.insight.runtime.i.a().b();
        long jUptimeMillis = SystemClock.uptimeMillis();
        a(jUptimeMillis);
        String strA = d.a(this.b);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str6 = Constants.NORMAL;
        TextUtils.isEmpty(strA);
        if (TextUtils.isEmpty(strA)) {
            str = "unknown";
            str2 = "unknown";
            jSONArrayB = null;
            jSONArrayA = null;
            jSONObject = null;
            z2 = false;
            jSONObjectA = null;
            z3 = false;
            str3 = Constants.NORMAL;
            str4 = "unknown";
            jSONArray = null;
            j = jCurrentTimeMillis;
            jSONObjectA2 = null;
        } else {
            synchronized (this.u) {
            }
            if (this.g != null && System.currentTimeMillis() - this.d <= SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
                str6 = "trace_last";
            } else {
                if (this.v) {
                    this.v = false;
                    str6 = "trace_after";
                }
                b(jUptimeMillis);
            }
            JSONObject jSONObject4 = this.g;
            String str7 = this.i;
            String str8 = this.j;
            String str9 = this.k;
            JSONArray jSONArray2 = this.m;
            JSONArray jSONArray3 = this.r;
            JSONArray jSONArray4 = this.q;
            JSONObject jSONObject5 = this.s;
            JSONObject jSONObject6 = this.h;
            z3 = this.t;
            long j2 = this.p;
            this.g = null;
            this.m = null;
            this.q = null;
            this.h = null;
            this.r = null;
            this.i = "unknown";
            this.j = "unknown";
            this.k = "unknown";
            this.o = 0;
            jSONArrayA = jSONArray4;
            str2 = str9;
            str4 = str7;
            jSONArray = jSONArray2;
            jSONObjectA = jSONObject6;
            jSONObject = jSONObject5;
            jSONArrayB = jSONArray3;
            str = str8;
            str3 = str6;
            j = j2;
            jSONObjectA2 = jSONObject4;
            z2 = true;
        }
        if (TextUtils.isEmpty(strA)) {
            if (this.g != null && System.currentTimeMillis() - this.d > SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
                this.g = null;
                this.m = null;
                this.q = null;
                this.h = null;
                this.r = null;
                this.i = "unknown";
                this.j = "unknown";
                this.k = "unknown";
                this.o = 0;
                this.e = null;
                return false;
            }
            if (this.g == null || System.currentTimeMillis() - this.d <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS || !NativeImpl.h()) {
                return false;
            }
            com.apm.insight.l.f.a(i());
            return false;
        }
        if (jSONObjectA2 == null) {
            if (jSONArrayA == null) {
                try {
                    jSONArrayB = f.b().b();
                    jSONArrayA = j.a(jUptimeMillis);
                    jSONObject3 = jSONObjectA2;
                    try {
                        jSONObjectA = f.b().a(jUptimeMillis).a();
                        JSONObject jSONObject7 = new JSONObject();
                        try {
                            com.apm.insight.l.a.a(this.b, jSONObject7);
                            jSONObject = jSONObject7;
                        } catch (Throwable unused) {
                            jSONObject = jSONObject7;
                            jSONObjectA2 = jSONObject3;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    jSONObject3 = jSONObjectA2;
                }
            } else {
                jSONObject3 = jSONObjectA2;
            }
            jSONObjectA2 = d.a();
        }
        JSONObject jSONObject8 = jSONObjectA;
        if (jSONObjectA2 != null && jSONObjectA2.length() > 0) {
            try {
                jSONObjectA2.put(AnalyticsProviderAdjust.EventKeys.pid, Process.myPid());
                jSONObjectA2.put("package", this.b.getPackageName());
                jSONObjectA2.put("is_remote_process", 0);
                jSONObjectA2.put("is_new_stack", 10);
                com.apm.insight.entity.a aVar = new com.apm.insight.entity.a(new JSONObject());
                String str10 = str2;
                aVar.a("data", (Object) jSONObjectA2.toString());
                JSONObject jSONObject9 = jSONObjectA2;
                aVar.a("is_anr", (Object) 1);
                aVar.a("anrType", (Object) str3);
                if (com.apm.insight.e.x()) {
                    aVar.a("history_message", (Object) jSONArrayB);
                    aVar.a("current_message", jSONObject8);
                    aVar.a("pending_messages", (Object) jSONArrayA);
                }
                aVar.a("anr_time", Long.valueOf(System.currentTimeMillis()));
                aVar.a("crash_time", Long.valueOf(j));
                com.apm.insight.c.a.b();
                aVar.c(jSONObject);
                aVar.a("anr_info", (Object) strA);
                if (jSONArray != null) {
                    aVar.a("dump_trace", (Object) jSONArray);
                }
                JSONObject jSONObject10 = this.n;
                aVar.a("all_thread_stacks", (jSONObject10 == null || jSONObject10.length() == 0) ? m.b((String) null) : this.n);
                com.apm.insight.entity.a aVarA = com.apm.insight.runtime.a.f.a().a(CrashType.ANR, aVar);
                aVarA.a("is_background", Boolean.valueOf(z3));
                aVarA.a("logcat", (Object) com.apm.insight.runtime.h.a(com.apm.insight.e.f()));
                aVarA.a("has_dump", (Object) "true");
                aVarA.a("crash_uuid", (Object) com.apm.insight.e.a(j, CrashType.ANR, false, false));
                JSONObject jSONObjectOptJSONObject = aVarA.c().optJSONObject(ShareConstants.WEB_DIALOG_PARAM_FILTERS);
                com.apm.insight.entity.d.b(aVarA.c());
                if (jSONObjectOptJSONObject == null) {
                    try {
                        jSONObject2 = new JSONObject();
                    } catch (Throwable unused4) {
                        jSONObject2 = jSONObjectOptJSONObject;
                    }
                    try {
                        aVarA.a(ShareConstants.WEB_DIALOG_PARAM_FILTERS, jSONObject2);
                    } catch (Throwable unused5) {
                        jSONObjectOptJSONObject = jSONObject2;
                        jSONObject2 = jSONObjectOptJSONObject;
                    }
                } else {
                    jSONObject2 = jSONObjectOptJSONObject;
                }
                jSONObject2.put("anrType", str3);
                jSONObject2.put("max_utm_thread", str4);
                jSONObject2.put("max_stm_thread", str);
                jSONObject2.put("max_utm_stm_thread", str10);
                jSONObject2.put("max_utm_thread_version", this.l);
                long j3 = j - com.apm.insight.e.j();
                if (j3 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                    str5 = "0 - 30s";
                } else if (j3 < 60000) {
                    str5 = "30s - 1min";
                } else if (j3 < 120000) {
                    str5 = "1min - 2min";
                } else if (j3 < 300000) {
                    str5 = "2min - 5min";
                } else if (j3 < 600000) {
                    str5 = "5min - 10min";
                } else if (j3 < 1800000) {
                    str5 = "10min - 30min";
                } else if (j3 < 3600000) {
                    str5 = "30min - 1h";
                } else {
                    str5 = "1h - ";
                }
                jSONObject2.put("crash_length", str5);
                jSONObject2.put("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.c()));
                jSONObject2.put("npth_force_apm_crash", String.valueOf(com.apm.insight.c.a.b()));
                jSONObject2.put("sdk_version", "2.0.0.8");
                jSONObject2.put("has_logcat", String.valueOf(aVarA.a()));
                jSONObject2.put("memory_leak", String.valueOf(com.apm.insight.entity.a.a(com.apm.insight.e.f())));
                jSONObject2.put("fd_leak", String.valueOf(com.apm.insight.entity.a.b(com.apm.insight.e.f())));
                jSONObject2.put("threads_leak", String.valueOf(com.apm.insight.entity.a.c(com.apm.insight.e.f())));
                jSONObject2.put("is_64_devices", String.valueOf(Header.a()));
                jSONObject2.put("is_64_runtime", String.valueOf(NativeImpl.f()));
                jSONObject2.put("is_x86_devices", String.valueOf(Header.b()));
                jSONObject2.put("has_meminfo_file", String.valueOf(com.apm.insight.l.j.d(com.apm.insight.e.f()).exists()));
                jSONObject2.put("is_root", com.apm.insight.nativecrash.a.k() ? "true" : "false");
                jSONObject2.put("anr_normal_trace", String.valueOf(!this.v));
                jSONObject2.put("anr_no_run", String.valueOf(zB));
                jSONObject2.put("crash_after_crash", Npth.hasCrash() ? "true" : "false");
                jSONObject2.put("from_file", String.valueOf(d.b()));
                jSONObject2.put("has_dump", "true");
                jSONObject2.put("from_kill", "false");
                jSONObject2.put("last_resume_activity", com.apm.insight.runtime.a.b.d().h());
                int i = this.o;
                if (i > 0) {
                    jSONObject2.put("may_have_stack_overflow", String.valueOf(i));
                }
                try {
                    a(strA, jSONObject2);
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                }
                com.apm.insight.a.a.a();
                CrashType crashType = CrashType.ANR;
                com.apm.insight.e.e();
                try {
                    if (com.apm.insight.a.e().length() > 1024) {
                        aVarA.a("has_system_traces", "true");
                    }
                } catch (Throwable unused6) {
                }
                try {
                    JSONArray jSONArrayA2 = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.e(com.apm.insight.e.f()), com.apm.insight.l.j.f(com.apm.insight.e.f()));
                    jSONObject2.put("leak_threads_count", String.valueOf(jSONArrayA2.length()));
                    if (jSONArrayA2.length() > 0) {
                        com.apm.insight.l.f.a(com.apm.insight.l.j.g(com.apm.insight.e.f()), jSONArrayA2);
                    }
                } catch (Throwable unused7) {
                }
                String strOptString = jSONObject9.optString("mainStackFromTrace");
                JSONArray jSONArrayA3 = com.apm.insight.entity.b.a(strOptString);
                com.apm.insight.entity.b.a(aVarA.c(), jSONArrayA3, new b.a() { // from class: com.apm.insight.b.b.2
                    @Override // com.apm.insight.entity.b.a
                    public final void a(JSONObject jSONObject11) {
                        com.apm.insight.k.d.a().a(jSONObject11, j, b.this.f);
                    }
                });
                b(strOptString, jSONArrayA3);
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
            }
        }
        return z2;
    }
}
