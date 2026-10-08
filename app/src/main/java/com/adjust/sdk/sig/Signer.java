package com.adjust.sdk.sig;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Signer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f122a = false;
    public d b;
    public a c;
    public c d;

    public static String getVersion() {
        return "3.47.0";
    }

    public final synchronized void a() {
        if (this.f122a) {
            return;
        }
        this.b = new d();
        this.d = new c(Build.VERSION.SDK_INT);
        this.c = new NativeLibHelper();
        this.f122a = true;
    }

    public synchronized void onResume() {
        a();
        d dVar = this.b;
        a aVar = this.c;
        dVar.getClass();
        if (!d.f124a) {
            ((NativeLibHelper) aVar).a();
        }
    }

    public synchronized void sign(Context context, Map<String, String> map, String str, String str2) {
        a();
        d dVar = this.b;
        c cVar = this.d;
        a aVar = this.c;
        dVar.getClass();
        d.a(context, cVar, aVar, map, str, str2);
    }

    public synchronized void sign(Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        a();
        d dVar = this.b;
        c cVar = this.d;
        a aVar = this.c;
        dVar.getClass();
        if (map == null || map.size() == 0 || map2 == null || map3 == null) {
            Log.e("SignerInstance", "sign: One or more parameters are null");
        } else {
            HashMap map4 = new HashMap();
            d.a(map.keySet(), map, map4);
            String str = map2.get("activity_kind");
            String str2 = map2.get("client_sdk");
            if ("b".equals(map2.get("a"))) {
                d.a(map.keySet(), map, map3);
                d.a(new HashSet(Arrays.asList("network_payload", "endpoint")), map2, map3);
            } else {
                d.a(context, cVar, aVar, map4, str, str2);
                if (map4.containsKey(InAppPurchaseMetaData.KEY_SIGNATURE) && map4.containsKey("adj_signing_id") && map4.containsKey("headers_id") && map4.containsKey("algorithm") && map4.containsKey("native_version")) {
                    String str3 = (String) map4.get("adj_signing_id");
                    String str4 = (String) map4.get("headers_id");
                    String str5 = (String) map4.get(InAppPurchaseMetaData.KEY_SIGNATURE);
                    String str6 = (String) map4.get("algorithm");
                    String str7 = (String) map4.get("native_version");
                    Locale locale = Locale.US;
                    String str8 = "algorithm=\"" + str6 + "\"";
                    map3.put("authorization", "Signature " + ("signature=\"" + str5 + "\"") + "," + ("adj_signing_id=\"" + str3 + "\"") + "," + str8 + "," + ("headers_id=\"" + str4 + "\"") + "," + ("native_version=\"" + str7 + "\""));
                    d.a(map.keySet(), map, map3);
                    d.a(new HashSet(Arrays.asList("network_payload", "endpoint")), map2, map3);
                }
                Log.e("SignerInstance", "sign: Signature generation failed. Exiting...");
            }
        }
    }
}
