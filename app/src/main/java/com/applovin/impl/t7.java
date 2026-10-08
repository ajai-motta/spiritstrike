package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t7 {
    private static final List f = Arrays.asList(MimeTypes.VIDEO_MP4, "video/webm", MimeTypes.VIDEO_H263, MimeTypes.VIDEO_MATROSKA);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f680a;
    private final JSONObject c;
    private final JSONObject d;
    protected List b = new ArrayList();
    private final long e = System.currentTimeMillis();

    public t7(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.k kVar) {
        this.f680a = kVar;
        this.c = jSONObject;
        this.d = jSONObject2;
    }

    public List a() {
        return this.b;
    }

    public JSONObject b() {
        return this.c;
    }

    public long c() {
        return this.e;
    }

    public int d() {
        return this.b.size();
    }

    public JSONObject e() {
        return this.d;
    }

    public List f() {
        List<String> listExplode = CollectionUtils.explode(JsonUtils.getString(this.c, "vast_preferred_video_types", null));
        return !listExplode.isEmpty() ? listExplode : f;
    }

    public int g() {
        return o7.c(JsonUtils.getInt(this.c, "video_completion_percent", -1));
    }
}
