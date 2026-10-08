package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l3 extends r0 {
    private static final String[] e = {"ads", "settings", "auto_init_adapters", "test_mode_idfas", "test_mode_auto_init_adapters", "ad_unit_signal_providers"};
    private static final String[] f = {"ads", "settings", "signal_providers", "ad_unit_signal_providers"};

    public static String a(com.applovin.impl.sdk.k kVar) {
        return r0.a((String) kVar.a(r3.v7), "1.0/mediate", kVar);
    }

    public static String b(com.applovin.impl.sdk.k kVar) {
        return r0.a((String) kVar.a(r3.u7), "1.0/mediate", kVar);
    }

    public static void d(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (JsonUtils.valueExists(jSONObject, "ad_unit_signal_providers")) {
            q5.a(jSONObject, kVar);
        }
    }

    public static void e(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject.length() == 0) {
            return;
        }
        if (!JsonUtils.valueExists(jSONObject, "auto_init_adapters") && !JsonUtils.valueExists(jSONObject, "test_mode_auto_init_adapters")) {
            kVar.c(a5.G);
            return;
        }
        JSONObject jSONObjectShallowCopy = JsonUtils.shallowCopy(jSONObject);
        JsonUtils.removeObjectsForKeys(jSONObjectShallowCopy, f);
        kVar.b(a5.G, jSONObjectShallowCopy.toString());
    }

    public static void f(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (JsonUtils.valueExists(jSONObject, "signal_providers")) {
            JSONObject jSONObjectShallowCopy = JsonUtils.shallowCopy(jSONObject);
            JsonUtils.removeObjectsForKeys(jSONObjectShallowCopy, e);
            kVar.b(a5.F, jSONObjectShallowCopy.toString());
            q5.a(jSONObjectShallowCopy);
        }
    }

    public static void g(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (JsonUtils.valueExists(jSONObject, "ad_unit_signal_providers") && JsonUtils.valueExists(jSONObject, "signal_providers")) {
            try {
                HashSet hashSet = new HashSet();
                JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
                for (int i = 0; i < jSONArray.length(); i++) {
                    hashSet.add(JsonUtils.getString(jSONArray.getJSONObject(i), "name", null));
                }
                HashSet hashSet2 = new HashSet();
                JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "ad_unit_signal_providers", (JSONObject) null);
                Iterator it = JsonUtils.toList(jSONObject2.names()).iterator();
                while (it.hasNext()) {
                    hashSet2.addAll(JsonUtils.getList(jSONObject2, (String) it.next(), null));
                }
                if (hashSet.equals(hashSet2)) {
                    return;
                }
                Set differenceSet = CollectionUtils.getDifferenceSet(hashSet, hashSet2);
                com.applovin.impl.sdk.o.h("MediationConnectionUtils", "\"signal_providers\" contains extra network(s): " + differenceSet);
                Set differenceSet2 = CollectionUtils.getDifferenceSet(hashSet2, hashSet);
                com.applovin.impl.sdk.o.h("MediationConnectionUtils", "\"ad_unit_signal_providers\" contains extra network(s): " + differenceSet2);
                kVar.D().a(d2.a1, "signalProvidersMismatch", CollectionUtils.hashMap("details", "extraSignalProviderNetworks=" + differenceSet + ",extraAdUnitSignalProviderNetworks=" + differenceSet2));
                l1.a("Networks within \"signal_providers\" and \"ad_unit_signal_providers\" do not match.", new Object[0]);
            } catch (JSONException e2) {
                com.applovin.impl.sdk.o.c("MediationConnectionUtils", "Failed to parse JSON", e2);
                kVar.D().a("MediationConnectionUtils", "verifyBidderNetworksMatchFromJson", e2);
                l1.a((Throwable) e2, "Failed to parse JSON in verifyBidderNetworksMatchFromJson", new Object[0]);
            }
        }
    }

    public static String h(com.applovin.impl.sdk.k kVar) {
        y4 y4Var = r3.H8;
        return r0.a((String) kVar.a(((Boolean) kVar.a(y4Var)).booleanValue() ? r3.G8 : r3.v7), ((Boolean) kVar.a(y4Var)).booleanValue() ? "2.0/mediate_debug" : "1.0/mediate_debug", kVar);
    }

    public static String i(com.applovin.impl.sdk.k kVar) {
        y4 y4Var = r3.H8;
        return r0.a((String) kVar.a(((Boolean) kVar.a(y4Var)).booleanValue() ? r3.F8 : r3.u7), ((Boolean) kVar.a(y4Var)).booleanValue() ? "2.0/mediate_debug" : "1.0/mediate_debug", kVar);
    }
}
