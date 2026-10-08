package com.bykv.vk.openvk.preload.geckox;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.preload.a.d;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.falconx.a.a f792a;
    private Queue<String> b;
    private b c;
    private File d;

    private a(b bVar) {
        new ArrayList();
        this.f792a = new com.bykv.vk.openvk.preload.falconx.a.a();
        this.b = new LinkedBlockingQueue();
        this.c = bVar;
        File fileN = bVar.n();
        this.d = fileN;
        fileN.mkdirs();
        com.bykv.vk.openvk.preload.geckox.statistic.b.a(this, this.c);
    }

    public static a a(b bVar) {
        List<String> listE = bVar.e();
        if (listE == null || listE.isEmpty()) {
            throw new IllegalArgumentException("access key empty");
        }
        bVar.a();
        return new a(bVar);
    }

    private boolean b(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        if (map != null && !map.isEmpty()) {
            List<String> listE = this.c.e();
            for (Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> entry : map.entrySet()) {
                Iterator<String> it = listE.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next(), entry.getKey())) {
                        z = true;
                    }
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean a() {
        List<String> listD = this.c.d();
        List<String> listE = this.c.e();
        if (listD == null || listD.isEmpty() || listE == null || listE.isEmpty()) {
            return false;
        }
        for (String str : listE) {
            Iterator<String> it = listD.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (TextUtils.equals(str, it.next())) {
                    z = true;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final void a(Class<? extends d<?, ?>> cls, com.bykv.vk.openvk.preload.a.b.a aVar) {
        this.f792a.a(cls, aVar);
    }

    public final void a(final Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        final String str = "default";
        if (TextUtils.isEmpty("default")) {
            throw new IllegalArgumentException("groupType == null");
        }
        if (!a()) {
            throw new IllegalArgumentException("deployments keys not in local keys");
        }
        if (!b(map)) {
            throw new IllegalArgumentException("target keys not in deployments keys");
        }
        final com.bykv.vk.openvk.preload.geckox.d.a aVar = null;
        final Map map2 = null;
        b.h().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.a.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v6, types: [com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor] */
            /* JADX WARN: Type inference failed for: r2v15 */
            /* JADX WARN: Type inference failed for: r2v16, types: [org.json.JSONObject] */
            /* JADX WARN: Type inference failed for: r2v17, types: [org.json.JSONObject] */
            /* JADX WARN: Type inference failed for: r2v27 */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v30 */
            /* JADX WARN: Type inference failed for: r2v31 */
            /* JADX WARN: Type inference failed for: r2v4, types: [com.bykv.vk.openvk.preload.geckox.a.a.b] */
            @Override // java.lang.Runnable
            public final void run() {
                ?? r2;
                long jElapsedRealtime;
                long jS;
                if (a.this.c.b() != null) {
                    com.bykv.vk.openvk.preload.geckox.a.a.b bVarA = a.this.c.b().a();
                    bVarA.a(a.this.c.b(), a.this.c.n(), a.this.c.e());
                    r2 = bVarA;
                } else {
                    r2 = 0;
                }
                try {
                    try {
                        a.this.c.a(new JSONObject());
                        com.bykv.vk.openvk.preload.geckox.g.a.a(aVar, a.this.d, a.this.c, a.this.f792a, map2, map, str).a(str);
                        if (r2 != 0) {
                            r2.a();
                        }
                        JSONObject jSONObjectF = a.this.c.f();
                        JSONObject jSONObject = jSONObjectF;
                        if (jSONObjectF == null) {
                            jSONObject = new JSONObject();
                        }
                        jElapsedRealtime = SystemClock.elapsedRealtime();
                        jS = a.this.c.s();
                        r2 = jSONObject;
                    } catch (Exception e) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("success", false);
                            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, e.toString());
                            jSONObject2.put("code", 2);
                            a.this.c.a(jSONObject2);
                        } catch (Throwable unused) {
                        }
                        if (r2 != 0) {
                            r2.a();
                        }
                        JSONObject jSONObjectF2 = a.this.c.f();
                        JSONObject jSONObject3 = jSONObjectF2;
                        if (jSONObjectF2 == null) {
                            jSONObject3 = new JSONObject();
                        }
                        jElapsedRealtime = SystemClock.elapsedRealtime();
                        jS = a.this.c.s();
                        r2 = jSONObject3;
                    } catch (Throwable th) {
                        if (r2 != 0) {
                            r2.a();
                        }
                        JSONObject jSONObjectF3 = a.this.c.f();
                        if (jSONObjectF3 == null) {
                            jSONObjectF3 = new JSONObject();
                        }
                        try {
                            jSONObjectF3.put("download_duration", SystemClock.elapsedRealtime() - a.this.c.s());
                        } catch (Throwable unused2) {
                        }
                        a.this.c.q().upload("download_gecko_end", jSONObjectF3);
                        throw th;
                    }
                    r2.put("download_duration", jElapsedRealtime - jS);
                } catch (Throwable unused3) {
                }
                a.this.c.q().upload("download_gecko_end", r2);
                a.d(a.this);
            }
        });
    }

    static /* synthetic */ void d(a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.c.e());
        try {
            String strA = new com.bykv.vk.openvk.preload.geckox.a.a(arrayList).a();
            if (aVar.c.p() != null && aVar.c.p().a()) {
                aVar.c.p();
            } else if (aVar.b.size() < 10) {
                aVar.b.add(strA);
            }
        } catch (Throwable unused) {
        }
    }
}
