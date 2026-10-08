package com.pgl.ssdk.ces;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.pgl.ssdk.a5;
import com.pgl.ssdk.aa;
import com.pgl.ssdk.ab;
import com.pgl.ssdk.ac;
import com.pgl.ssdk.ad;
import com.pgl.ssdk.ae;
import com.pgl.ssdk.af;
import com.pgl.ssdk.ag;
import com.pgl.ssdk.ah;
import com.pgl.ssdk.aj;
import com.pgl.ssdk.ak;
import com.pgl.ssdk.al;
import com.pgl.ssdk.an;
import com.pgl.ssdk.ao;
import com.pgl.ssdk.ar;
import com.pgl.ssdk.aw;
import com.pgl.ssdk.ax;
import com.pgl.ssdk.ay;
import com.pgl.ssdk.az;
import com.pgl.ssdk.ces.out.PglSSManager;
import com.pgl.ssdk.f;
import com.pgl.ssdk.u;
import com.pgl.ssdk.v;
import com.pgl.ssdk.w;
import com.pgl.ssdk.x;
import com.pgl.ssdk.y;
import com.pgl.ssdk.z;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f3075a = null;
    private static boolean b = false;
    private static Map<String, Object> c = null;
    private static int d = 1;
    private static aw.a e;
    public Context g;
    private String h;
    private int i;
    private String j;
    private String n;
    public boolean f = false;
    private String k = null;
    private String l = null;
    private boolean m = false;
    private boolean o = false;
    public int p = 1;
    public int q = 0;
    public boolean r = true;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.c();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.pgl.ssdk.ces.b$b, reason: collision with other inner class name */
    class RunnableC0529b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3077a;

        RunnableC0529b(String str) {
            this.f3077a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.f3077a) && this.f3077a.equals(PglSSManager.REPORT_SCENE_ADSHOW)) {
                ab.b(b.this.g);
            }
            al.a(b.this.g).a();
            aa.b(b.this.g);
        }
    }

    private b(Context context, String str) {
        this.g = context;
        this.h = str;
    }

    public static b a(Context context, String str, int i, int i2, String str2) {
        if (f3075a == null) {
            synchronized (b.class) {
                if (f3075a == null) {
                    if (context == null) {
                        context = ab.a().getApplicationContext();
                    }
                    if (context == null) {
                        d = 4;
                        return null;
                    }
                    a(i);
                    aw.a aVarB = aw.b(context, "nms");
                    if (aVarB != null) {
                        d = aVarB.f3073a;
                        e = aVarB;
                        return null;
                    }
                    b bVar = new b(context, str);
                    f3075a = bVar;
                    bVar.i = i2;
                    f3075a.j = str2;
                    f3075a.b(context);
                    f3075a.e(a(context));
                    z.a(context);
                    d = 0;
                }
            }
        }
        return f3075a;
    }

    public static String b() {
        if (e() != null) {
            return e().k;
        }
        return null;
    }

    public static String c() {
        b bVarE = e();
        if (bVarE == null || !bVarE.m || TextUtils.isEmpty(bVarE.l)) {
            return null;
        }
        return bVarE.l;
    }

    public static int d() {
        return d;
    }

    public static b e() {
        return f3075a;
    }

    public static aw.a f() {
        return e;
    }

    public String g() {
        return a5.a();
    }

    public void h() {
        this.o = true;
        a5.a(this.g, this.h);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (az.a(ax.a(this.g, "pgl_init_report", 0L), jCurrentTimeMillis)) {
            int i = f3075a.q;
            if ((i > 0 && i < 100 && Math.random() * 100.0d < i) || i == 100) {
                a("Start", (Map<String, Object>) null);
            }
        } else {
            a("Start", (Map<String, Object>) null);
            ax.b(this.g, "pgl_init_report", jCurrentTimeMillis);
        }
        a("Start");
        if (this.r) {
            ar.a(new a(), SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
        }
    }

    private void b(Context context) {
        if (context == null || b) {
            return;
        }
        try {
            com.pgl.ssdk.ces.a.meta(101, null, "1");
            com.pgl.ssdk.ces.a.meta(102, null, this.h);
            com.pgl.ssdk.ces.a.meta(114, null, Integer.valueOf(this.i));
            StringBuilder sb = new StringBuilder();
            sb.append(ab.h(context));
            com.pgl.ssdk.ces.a.meta(105, null, sb.toString());
            com.pgl.ssdk.ces.a.meta(152, null, ab.i(context));
            com.pgl.ssdk.ces.a.meta(153, null, ab.d(context));
            com.pgl.ssdk.ces.a.meta(106, null, ab.f(context));
            com.pgl.ssdk.ces.a.meta(107, null, ab.e(context));
            com.pgl.ssdk.ces.a.meta(108, null, ab.c(context));
            com.pgl.ssdk.ces.a.meta(109, null, ab.d());
            com.pgl.ssdk.ces.a.meta(110, null, ab.c());
            com.pgl.ssdk.ces.a.meta(115, null, this.j);
            b = true;
        } catch (Throwable unused) {
        }
    }

    private void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.n = str;
        com.pgl.ssdk.ces.a.meta(104, null, str);
    }

    public synchronized void d(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.l)) {
            com.pgl.ssdk.ces.a.meta(111, null, str);
            this.l = str;
            a5.b();
        }
    }

    public synchronized void c(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.k)) {
            this.k = str;
            com.pgl.ssdk.ces.a.meta(103, null, str);
            a5.b();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.ces.b.b(java.lang.String):void");
    }

    private static String a(Context context) {
        String strA = ax.a(context, "iid");
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String string = UUID.randomUUID().toString();
        ax.b(context, "iid", string);
        return string;
    }

    public static void a(int i) {
        an.a(i);
    }

    public static String a() {
        if (e() != null) {
            return e().h;
        }
        return null;
    }

    public void a(String str, String str2, String str3, String str4) {
        c(str2);
        d(str4);
        try {
            h();
        } catch (Throwable unused) {
        }
    }

    public Map<String, String> a(String str, byte[] bArr) {
        HashMap map = new HashMap();
        Object[] objArr = new Object[2];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        if (bArr == null) {
            bArr = new byte[0];
        }
        objArr[1] = bArr;
        String str2 = (String) com.pgl.ssdk.ces.a.meta(224, this.g, objArr);
        if (!TextUtils.isEmpty(str2)) {
            map.put("X-Armors", str2);
        }
        return map;
    }

    public void a(String str, Map<String, Object> map) {
        try {
            ar.a(new ao(this.g, 222, new Object[]{str, map}), "Start".equals(str) ? 10000L : 0L);
        } catch (Throwable unused) {
        }
    }

    public Object a(int i, Object obj) {
        Object objB;
        if (i == 123) {
            objB = af.a(this.g);
        } else if (i == 121) {
            objB = ad.a();
        } else if (i == 122) {
            objB = ad.b();
        } else if (i == 126) {
            objB = ad.b(this.g);
        } else if (i == 128) {
            objB = ad.c(this.g);
        } else if (i == 120) {
            objB = ac.c();
        } else if (i == 124) {
            objB = ag.c(this.g);
        } else if (i == 130) {
            objB = ag.a(this.g);
        } else if (i == 145) {
            objB = ah.c(this.g);
        } else if (i == 125) {
            objB = ag.b(this.g);
        } else if (i == 129) {
            objB = ae.f(this.g);
        } else if (i == 141) {
            objB = ae.e(this.g);
        } else if (i == 134) {
            objB = ak.a(this.g).b();
        } else if (i == 140) {
            objB = al.a(this.g).e();
        } else if (i == 144) {
            objB = al.a(this.g).d();
        } else if (i == 133) {
            objB = a(obj);
        } else {
            if (i == 135) {
                return v.e();
            }
            if (i == 201) {
                objB = ad.a(this.g);
            } else if (i == 202) {
                objB = ad.c();
            } else {
                if (i == 236) {
                    return ay.a((String) obj);
                }
                if (i == 142) {
                    objB = ab.g(this.g);
                } else if (i == 143) {
                    objB = ah.a(this.g);
                } else {
                    if (i == 146) {
                        try {
                            return v.b();
                        } catch (Throwable unused) {
                            return null;
                        }
                    }
                    if (i == 147) {
                        objB = Boolean.valueOf(ab.j(this.g));
                    } else if (i == 148) {
                        objB = u.b(this.g);
                    } else if (i == 149) {
                        objB = w.a(this.g);
                    } else if (i == 150) {
                        objB = Integer.valueOf(x.a());
                    } else if (i == 151) {
                        objB = w.c();
                    } else if (i == 161) {
                        objB = Boolean.valueOf(v.f());
                    } else if (i == 163) {
                        objB = aj.a();
                    } else if (i == 169) {
                        objB = Boolean.valueOf(aa.a(this.g));
                    } else if (i == 170) {
                        objB = Integer.valueOf(y.b((String) obj));
                    } else if (i == 203) {
                        objB = ab.b();
                    } else if (i == 205) {
                        objB = Integer.valueOf(ab.k(this.g));
                    } else if (i == 204) {
                        objB = Integer.valueOf(ae.a(this.g));
                    } else {
                        if (i != 206) {
                            return null;
                        }
                        objB = ah.b(this.g);
                    }
                }
            }
        }
        return objB;
    }

    public void a(MotionEvent motionEvent) {
        y.a(motionEvent, this.g);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(java.util.Map<java.lang.String, java.lang.Object> r10) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.ces.b.a(java.util.Map):void");
    }

    private String a(Object obj) {
        Map<String, Object> map;
        if (!(obj instanceof String) || !"Start".equals((String) obj) || (map = c) == null || map.isEmpty()) {
            return JsonUtils.EMPTY_JSON;
        }
        try {
            return new JSONObject(c).toString();
        } catch (Exception unused) {
            return JsonUtils.EMPTY_JSON;
        }
    }

    public void a(String str) {
        ar.b(new RunnableC0529b(str));
    }
}
