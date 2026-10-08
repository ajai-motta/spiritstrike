package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f715a;

    public enum a {
        NEUTRAL,
        POSITIVE,
        NEGATIVE
    }

    private x0(JSONObject jSONObject) {
        this.f715a = jSONObject;
    }

    public static x0 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        String string = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "title", (JSONObject) null), "key", null);
        if ("TOS".equalsIgnoreCase(string) && kVar.x().h() == null) {
            return null;
        }
        if ("PP".equalsIgnoreCase(string) && kVar.x().f() == null) {
            return null;
        }
        return new x0(jSONObject);
    }

    public String b() {
        return JsonUtils.getString(this.f715a, "event", null);
    }

    public a c() {
        String string = JsonUtils.getString(this.f715a, "style", null);
        return "default".equalsIgnoreCase(string) ? a.POSITIVE : ("destructive".equalsIgnoreCase(string) || "cancel".equalsIgnoreCase(string)) ? a.NEGATIVE : a.NEUTRAL;
    }

    public String d() {
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f715a, "title", (JSONObject) null);
        return com.applovin.impl.sdk.k.a(JsonUtils.getString(jSONObject, "key", ""), JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "replacements", null), null));
    }

    public String toString() {
        return "ConsentFlowStateAlertAction{title=" + d() + ", destinationStateId=" + a() + ", event=" + b() + "}";
    }

    public int a() {
        return JsonUtils.getInt(this.f715a, "destination_state_id", -1);
    }
}
