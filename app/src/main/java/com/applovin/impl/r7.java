package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r7 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f588a;

    private r7(List list) {
        this.f588a = list;
    }

    public static r7 a(q8 q8Var, r7 r7Var, t7 t7Var, com.applovin.impl.sdk.k kVar) {
        try {
            List listB = r7Var != null ? r7Var.b() : new ArrayList();
            Iterator it = q8Var.a("Verification").iterator();
            while (it.hasNext()) {
                q7 q7VarA = q7.a((q8) it.next(), t7Var, kVar);
                if (q7VarA != null) {
                    listB.add(q7VarA);
                }
            }
            return new r7(listB);
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("VastAdVerifications", "Error occurred while initializing", th);
            }
            kVar.D().a("VastAdVerifications", th);
            return null;
        }
    }

    public List b() {
        return this.f588a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r7) {
            return this.f588a.equals(((r7) obj).f588a);
        }
        return false;
    }

    public int hashCode() {
        return this.f588a.hashCode();
    }

    public String toString() {
        return "VastAdVerification{verifications='" + this.f588a + "'}";
    }

    static r7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "verifications", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            q7 q7VarA = q7.a(JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), kVar);
            if (q7VarA != null) {
                arrayList.add(q7VarA);
            }
        }
        return new r7(arrayList);
    }

    @Override // com.applovin.impl.q4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        if (this.f588a != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f588a.iterator();
            while (it.hasNext()) {
                jSONArray.put(((q7) it.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "verifications", jSONArray);
        }
        return jSONObject;
    }
}
