package com.fyber.inneractive.sdk.config.global;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f954a = "";
    public final HashMap b;
    public JSONArray c;

    public r() {
        HashMap map = new HashMap();
        map.put(u.class, new u());
        map.put(com.fyber.inneractive.sdk.config.global.features.d.class, new com.fyber.inneractive.sdk.config.global.features.d());
        map.put(com.fyber.inneractive.sdk.config.global.features.l.class, new com.fyber.inneractive.sdk.config.global.features.l());
        map.put(com.fyber.inneractive.sdk.config.global.features.f.class, new com.fyber.inneractive.sdk.config.global.features.f());
        map.put(com.fyber.inneractive.sdk.config.global.features.k.class, new com.fyber.inneractive.sdk.config.global.features.k());
        map.put(com.fyber.inneractive.sdk.config.global.features.e.class, new com.fyber.inneractive.sdk.config.global.features.e());
        map.put(com.fyber.inneractive.sdk.config.global.features.r.class, new com.fyber.inneractive.sdk.config.global.features.r());
        map.put(com.fyber.inneractive.sdk.config.global.features.i.class, new com.fyber.inneractive.sdk.config.global.features.i());
        map.put(com.fyber.inneractive.sdk.config.global.features.q.class, new com.fyber.inneractive.sdk.config.global.features.q());
        map.put(com.fyber.inneractive.sdk.config.global.features.n.class, new com.fyber.inneractive.sdk.config.global.features.n());
        map.put(com.fyber.inneractive.sdk.config.global.features.c.class, new com.fyber.inneractive.sdk.config.global.features.c());
        map.put(com.fyber.inneractive.sdk.config.global.features.m.class, new com.fyber.inneractive.sdk.config.global.features.m());
        map.put(com.fyber.inneractive.sdk.config.global.features.b.class, new com.fyber.inneractive.sdk.config.global.features.b());
        map.put(com.fyber.inneractive.sdk.config.global.features.g.class, new com.fyber.inneractive.sdk.config.global.features.g());
        map.put(com.fyber.inneractive.sdk.config.global.features.j.class, new com.fyber.inneractive.sdk.config.global.features.j());
        this.b = map;
        this.c = null;
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            map2.put((Class) entry.getKey(), ((com.fyber.inneractive.sdk.config.global.features.h) entry.getValue()).b());
        }
        this.b = map2;
        IAlog.a("%s: created. Supported features: %s", "SupportedFeaturesProvider", map2);
    }

    public static r a() {
        int i = com.fyber.inneractive.sdk.config.k.f959a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.featuresConfig");
        boolean z = false;
        if (!TextUtils.isEmpty(property)) {
            try {
                IAConfigManager.O.z.f942a = l.a(new JSONObject(property));
                z = true;
            } catch (Exception unused) {
                IAlog.a("failed parsing local features json", new Object[0]);
            }
        }
        r rVar = new r();
        if (z) {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            iAConfigManager.M.a(true, "");
            iAConfigManager.E.a(iAConfigManager.M);
        }
        return rVar;
    }

    public final JSONArray b() {
        JSONArray jSONArray = this.c;
        if (jSONArray == null || jSONArray.length() == 0) {
            JSONArray jSONArrayA = g.a(this.b, false);
            this.c = jSONArrayA;
            IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", jSONArrayA);
        }
        return this.c;
    }

    public final void a(e eVar) {
        for (com.fyber.inneractive.sdk.config.global.features.h hVar : this.b.values()) {
            hVar.getClass();
            ArrayList arrayList = new ArrayList(hVar.c.values());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                b bVar = (b) arrayList.get(size);
                ArrayList arrayList2 = bVar.d;
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d dVar = (d) it.next();
                        if (dVar.a(eVar)) {
                            hVar.c.remove(bVar.f943a);
                            hVar.d.remove(bVar.f943a);
                            this.c = null;
                            IAlog.a("%s: Experiment %s filtered! after response %s", "SupportedFeaturesProvider", bVar.f943a, dVar);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final com.fyber.inneractive.sdk.config.global.features.h a(Class cls) {
        if (this.b.containsKey(cls)) {
            com.fyber.inneractive.sdk.config.global.features.h hVar = (com.fyber.inneractive.sdk.config.global.features.h) this.b.get(cls);
            if (cls.isInstance(hVar)) {
                return hVar;
            }
        }
        try {
            return (com.fyber.inneractive.sdk.config.global.features.h) cls.getConstructor(null).newInstance(null);
        } catch (Exception e) {
            IAlog.a("Couldn't create a feature for %s", e, cls.getName());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01b6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(boolean r19, java.lang.String r20) {
        /*
            Method dump skipped, instruction units count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.config.global.r.a(boolean, java.lang.String):void");
    }
}
