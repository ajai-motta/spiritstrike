package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f451a;
    private final String b;
    private final List c;

    public l8(JSONObject jSONObject) {
        this.f451a = JsonUtils.getString(jSONObject, "user_type", TtmlNode.COMBINE_ALL);
        this.b = JsonUtils.getString(jSONObject, "device_type", TtmlNode.COMBINE_ALL);
        this.c = JsonUtils.getStringList(jSONObject, "segments", null);
    }

    public String a() {
        return this.f451a;
    }

    public String b() {
        return this.b;
    }

    public List c() {
        return this.c;
    }
}
