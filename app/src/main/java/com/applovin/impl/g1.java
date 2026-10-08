package com.applovin.impl;

import com.adjust.sdk.Constants;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f393a;

    public g1(JSONObject jSONObject) {
        this.f393a = jSONObject;
    }

    protected Integer a() {
        return JsonUtils.getInteger(this.f393a, "dark_mode_toolbar_color", null);
    }

    protected String b() {
        return JsonUtils.getString(this.f393a, "digital_asset_link_url", null);
    }

    protected Boolean c() {
        return JsonUtils.getBoolean(this.f393a, "instant_apps_enabled", null);
    }

    protected String d() {
        return JsonUtils.getString(this.f393a, Constants.REFERRER, null);
    }

    protected Integer e() {
        return JsonUtils.getInteger(this.f393a, "session_url_relation", null);
    }

    protected Integer f() {
        return JsonUtils.getInteger(this.f393a, "share_state", null);
    }

    protected Boolean g() {
        return JsonUtils.getBoolean(this.f393a, "should_show_title", null);
    }

    protected Integer h() {
        return JsonUtils.getInteger(this.f393a, "toolbar_color", null);
    }

    protected Boolean i() {
        return JsonUtils.getBoolean(this.f393a, "url_bar_hiding_enabled", null);
    }
}
