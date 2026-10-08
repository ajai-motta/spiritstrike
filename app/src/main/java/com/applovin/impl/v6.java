package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v6 extends w6 {
    private final c3 g;

    public v6(c3 c3Var, com.applovin.impl.sdk.k kVar) {
        super("TaskValidateMaxReward", kVar);
        this.g = c3Var;
    }

    @Override // com.applovin.impl.r6
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, this.g.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.g.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.g.e());
        JsonUtils.putString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, this.g.getFormat().getLabel());
        String strL0 = this.g.l0();
        if (!StringUtils.isValidString(strL0)) {
            strL0 = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", strL0);
        String strB = this.g.B();
        if (!StringUtils.isValidString(strB)) {
            strB = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", strB);
    }

    @Override // com.applovin.impl.r6
    protected String f() {
        return "2.0/mvr";
    }

    @Override // com.applovin.impl.w6
    protected boolean h() {
        return this.g.p0();
    }

    @Override // com.applovin.impl.w6
    protected void a(o4 o4Var) {
        this.g.a(o4Var);
    }

    @Override // com.applovin.impl.r6
    protected void a(int i) {
        String str;
        super.a(i);
        if (i >= 400 && i < 500) {
            str = "rejected";
        } else {
            str = "network_timeout";
        }
        this.g.a(o4.a(str));
        this.f428a.P().a(d2.u0, this.g, CollectionUtils.hashMap(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str));
    }
}
