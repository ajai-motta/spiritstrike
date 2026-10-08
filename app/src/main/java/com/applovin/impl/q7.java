package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q7 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f580a;
    private final List b;
    private final String c;
    private final Set d;

    private q7(String str, List list, String str2, Set set) {
        this.f580a = str;
        this.b = list;
        this.c = str2;
        this.d = set;
    }

    public static q7 a(q8 q8Var, t7 t7Var, com.applovin.impl.sdk.k kVar) {
        try {
            String str = (String) q8Var.a().get("vendor");
            q8 q8VarB = q8Var.b("VerificationParameters");
            String strD = q8VarB != null ? q8VarB.d() : null;
            List listA = q8Var.a("JavaScriptResource");
            ArrayList arrayList = new ArrayList(listA.size());
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                w7 w7VarA = w7.a((q8) it.next(), kVar);
                if (w7VarA != null) {
                    arrayList.add(w7VarA);
                }
            }
            HashMap map = new HashMap();
            b8.a(q8Var, map, t7Var, kVar);
            return new q7(str, arrayList, strD, (Set) map.get("verificationNotExecuted"));
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("VastAdVerification", "Error occurred while initializing", th);
            }
            kVar.D().a("VastAdVerification", th);
            return null;
        }
    }

    public Set b() {
        return this.d;
    }

    public List c() {
        return this.b;
    }

    public String d() {
        return this.f580a;
    }

    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q7 q7Var = (q7) obj;
        String str = this.f580a;
        if (str == null ? q7Var.f580a != null : !str.equals(q7Var.f580a)) {
            return false;
        }
        List list = this.b;
        if (list == null ? q7Var.b != null : !list.equals(q7Var.b)) {
            return false;
        }
        String str2 = this.c;
        if (str2 == null ? q7Var.c != null : !str2.equals(q7Var.c)) {
            return false;
        }
        Set set = this.d;
        Set set2 = q7Var.d;
        return set != null ? set.equals(set2) : set2 == null;
    }

    public int hashCode() {
        String str = this.f580a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List list = this.b;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set set = this.d;
        return iHashCode3 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "VastAdVerification{vendorId='" + this.f580a + "'javascriptResources='" + this.b + "'verificationParameters='" + this.c + "'errorEventTrackers='" + this.d + "'}";
    }

    public static q7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject, "vendor_id", null);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "javascript_resources", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            w7 w7VarA = w7.a(JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), kVar);
            if (w7VarA != null) {
                arrayList.add(w7VarA);
            }
        }
        String string2 = JsonUtils.getString(jSONObject, "verification_parameters", null);
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "error_event_trackers", new JSONArray());
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            z7 z7VarA = z7.a(JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null), kVar);
            if (z7VarA != null) {
                hashSet.add(z7VarA);
            }
        }
        return new q7(string, arrayList, string2, hashSet);
    }

    @Override // com.applovin.impl.q4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "vendor_id", this.f580a);
        if (this.b != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                jSONArray.put(((w7) it.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "javascript_resources", jSONArray);
        }
        JsonUtils.putString(jSONObject, "verification_parameters", this.c);
        if (this.d != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = this.d.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(((z7) it2.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "error_event_trackers", jSONArray2);
        }
        return jSONObject;
    }
}
