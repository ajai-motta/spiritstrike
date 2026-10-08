package com.applovin.impl;

import com.applovin.impl.sdk.l;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f396a;
    private boolean b;
    private List c;

    public g7(com.applovin.impl.sdk.k kVar) {
        this.f396a = kVar;
        a5 a5Var = a5.I;
        this.b = ((Boolean) kVar.a(a5Var, Boolean.FALSE)).booleanValue() || y.a(com.applovin.impl.sdk.k.o()).a("applovin.sdk.is_test_environment") || AppLovinSdkUtils.isEmulator() || kVar.A().T();
        kVar.c(a5Var);
    }

    private void e() {
        com.applovin.impl.sdk.j jVarT = this.f396a.t();
        if (this.b) {
            jVarT.b(this.c);
        } else {
            jVarT.a(this.c);
        }
    }

    public void a(String str) {
        if (StringUtils.isValidString(str)) {
            a(Collections.singletonList(str));
        } else {
            a((List) null);
        }
    }

    public List b() {
        return this.c;
    }

    public boolean c() {
        return this.b;
    }

    public boolean d() {
        List list = this.c;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void a(List list) {
        if (list == null && this.c == null) {
            return;
        }
        if (list == null || !list.equals(this.c)) {
            this.c = list;
            e();
        }
    }

    public void a() {
        this.f396a.b(a5.I, Boolean.TRUE);
    }

    public void a(JSONObject jSONObject) {
        if (this.b) {
            return;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "test_mode_idfas", new JSONArray());
        com.applovin.impl.sdk.l lVarA = this.f396a.A();
        boolean zT = lVarA.T();
        String strA = lVarA.f().a();
        l.b bVarG = lVarA.G();
        this.b = zT || JsonUtils.containsCaseInsensitiveString(strA, jSONArray) || JsonUtils.containsCaseInsensitiveString(bVarG != null ? bVarG.f644a : null, jSONArray);
    }
}
