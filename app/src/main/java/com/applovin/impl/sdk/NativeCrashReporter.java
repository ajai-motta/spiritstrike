package com.applovin.impl.sdk;

import com.applovin.impl.o7;
import com.applovin.impl.sdk.g;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.y4;
import com.applovin.mediation.AppLovinUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeCrashReporter implements g.d {
    private static boolean b;
    private static boolean c;
    private static final NativeCrashReporter d = new NativeCrashReporter();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap f608a = new HashMap();

    private NativeCrashReporter() {
    }

    public static void a(k kVar) {
        if (kVar == null) {
            return;
        }
        if (!((Boolean) kVar.a(y4.v4)).booleanValue() && !o7.k(k.o())) {
            if (c) {
                try {
                    g gVarL = kVar.l();
                    NativeCrashReporter nativeCrashReporter = d;
                    gVarL.a(nativeCrashReporter);
                    nativeCrashReporter.disable();
                    return;
                } catch (Throwable th) {
                    kVar.O();
                    if (o.a()) {
                        kVar.O().a("NativeCrashReporter", "Failed to disable native crash reporter", th);
                    }
                    kVar.D().a("NativeCrashReporter", "disableInstance", th);
                    return;
                }
            }
            return;
        }
        if (a()) {
            List listC = kVar.c(y4.w4);
            int[] iArr = new int[listC.size()];
            for (int i = 0; i < listC.size(); i++) {
                try {
                    iArr[i] = Integer.parseInt((String) listC.get(i));
                } catch (NumberFormatException unused) {
                }
            }
            File file = new File(k.o().getCacheDir(), "al-reports");
            if (file.exists()) {
                a(file, kVar);
            } else if (!file.mkdir()) {
                kVar.O();
                if (o.a()) {
                    kVar.O().b("NativeCrashReporter", "Failed to create reports directory");
                    return;
                }
                return;
            }
            try {
                NativeCrashReporter nativeCrashReporter2 = d;
                nativeCrashReporter2.enable(file.getAbsolutePath(), iArr, ((Boolean) kVar.a(y4.x4)).booleanValue());
                if (((Boolean) kVar.a(y4.y4)).booleanValue()) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(g.c.LOADING);
                    hashSet.add(g.c.LOAD);
                    hashSet.add(g.c.SHOW);
                    hashSet.add(g.c.CLICK);
                    hashSet.add(g.c.SHOW_ERROR);
                    hashSet.add(g.c.DESTROY);
                    kVar.l().a(nativeCrashReporter2, hashSet);
                }
            } catch (Throwable th2) {
                kVar.O();
                if (o.a()) {
                    kVar.O().a("NativeCrashReporter", "Failed to enable native crash reporter", th2);
                }
                kVar.D().a("NativeCrashReporter", "enableInstance", th2);
            }
        }
    }

    private native void disable();

    private native void enable(String str, int[] iArr, boolean z);

    private native void updateAdInfo(String str);

    private static boolean a() {
        if (!b) {
            b = true;
            try {
                System.loadLibrary("applovin-native-crash-reporter");
                c = true;
            } catch (Throwable th) {
                o.b("NativeCrashReporter", "Failed to load native crash reporter library", th);
            }
        }
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.io.File r16, com.applovin.impl.sdk.k r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.NativeCrashReporter.a(java.io.File, com.applovin.impl.sdk.k):void");
    }

    @Override // com.applovin.impl.sdk.g.d
    public void a(g.b bVar) {
        String strH = bVar.h();
        if (bVar.i() == g.c.DESTROY) {
            this.f608a.remove(strH);
        } else if (this.f608a.containsKey(strH)) {
            JsonUtils.putString((JSONObject) this.f608a.get(strH), "operation", bVar.i().toString());
        } else {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putString(jSONObject, AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, bVar.a());
            JsonUtils.putString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, bVar.g());
            JsonUtils.putString(jSONObject, "network_name", bVar.c());
            JsonUtils.putString(jSONObject, "adapter_class", bVar.b());
            JsonUtils.putString(jSONObject, "adapter_version", bVar.d());
            JsonUtils.putString(jSONObject, "bcode", bVar.e());
            JsonUtils.putString(jSONObject, "creative_id", bVar.f());
            JsonUtils.putString(jSONObject, "operation", bVar.i().toString());
            this.f608a.put(strH, jSONObject);
        }
        try {
            updateAdInfo(new JSONArray(this.f608a.values()).toString());
        } catch (Throwable unused) {
        }
    }
}
