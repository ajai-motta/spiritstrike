package com.fyber.inneractive.sdk.config.global;

import com.facebook.internal.NativeProtocol;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f951a = new HashMap();

    public static l a(JSONObject jSONObject) throws JSONException {
        l lVar = new l();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("features");
        int i = 0;
        int i2 = 0;
        while (i2 < jSONArrayOptJSONArray.length()) {
            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
            q qVar = new q();
            qVar.b = jSONObject2.getString("id");
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
            if (jSONObjectOptJSONObject != null) {
                qVar.f953a = new o(jSONObjectOptJSONObject);
            } else {
                Object[] objArr = new Object[1];
                objArr[i] = qVar.b;
                IAlog.a("RemoteFeature fromJson. feature %s has no params!", objArr);
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("experiments");
            if (jSONArrayOptJSONArray2 != null) {
                int i3 = i;
                while (i3 < jSONArrayOptJSONArray2.length()) {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i3);
                    b bVar = new b();
                    bVar.f943a = jSONObject3.getString("id");
                    bVar.b = jSONObject3.optInt("perc", 10);
                    JSONArray jSONArray = jSONObject3.getJSONArray("variants");
                    for (int i4 = i; i4 < jSONArray.length(); i4++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i4);
                        k kVar = new k();
                        kVar.b = jSONObject4.getString("id");
                        kVar.c = jSONObject4.getInt("perc");
                        JSONObject jSONObjectOptJSONObject2 = jSONObject4.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
                        if (jSONObjectOptJSONObject2 != null) {
                            kVar.f953a = new o(jSONObjectOptJSONObject2);
                        }
                        bVar.c.add(kVar);
                    }
                    b.a(bVar, jSONObject3.optJSONObject("include"), true);
                    b.a(bVar, jSONObject3.optJSONObject("exclude"), false);
                    qVar.c.put(bVar.f943a, bVar);
                    i3++;
                    i = 0;
                }
            }
            lVar.f951a.put(qVar.b, qVar);
            i2++;
            i = i;
        }
        return lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        return this.f951a.equals(((l) obj).f951a);
    }

    public final int hashCode() {
        return this.f951a.hashCode();
    }

    public final String toString() {
        return String.format("remoteConfig - features: %s", this.f951a.values());
    }
}
