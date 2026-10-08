package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f377a;
    private final int b;
    private final int c;
    private final int d;
    private final boolean e;
    private final int f;
    private final int g;
    private final int h;
    private final float i;
    private final float j;

    public e8(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        kVar.O();
        if (com.applovin.impl.sdk.o.a()) {
            kVar.O().d("VideoButtonProperties", "Updating video button properties with JSON = " + JsonUtils.maybeConvertToIndentedString(jSONObject));
        }
        this.f377a = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 64);
        this.b = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 7);
        this.c = JsonUtils.getInt(jSONObject, "margin", 20);
        this.d = JsonUtils.getInt(jSONObject, "gravity", 85);
        this.e = JsonUtils.getBoolean(jSONObject, "tap_to_fade", Boolean.FALSE).booleanValue();
        this.f = JsonUtils.getInt(jSONObject, "tap_to_fade_duration_milliseconds", 500);
        this.g = JsonUtils.getInt(jSONObject, "fade_in_duration_milliseconds", 500);
        this.h = JsonUtils.getInt(jSONObject, "fade_out_duration_milliseconds", 500);
        this.i = JsonUtils.getFloat(jSONObject, "fade_in_delay_seconds", 1.0f);
        this.j = JsonUtils.getFloat(jSONObject, "fade_out_delay_seconds", 6.0f);
    }

    public float a() {
        return this.i;
    }

    public long b() {
        return this.g;
    }

    public float c() {
        return this.j;
    }

    public long d() {
        return this.h;
    }

    public int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e8 e8Var = (e8) obj;
        return this.f377a == e8Var.f377a && this.b == e8Var.b && this.c == e8Var.c && this.d == e8Var.d && this.e == e8Var.e && this.f == e8Var.f && this.g == e8Var.g && this.h == e8Var.h && Float.compare(e8Var.i, this.i) == 0 && Float.compare(e8Var.j, this.j) == 0;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.c;
    }

    public long h() {
        return this.f;
    }

    public int hashCode() {
        int i = ((((((((((((((this.f377a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + (this.e ? 1 : 0)) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31;
        float f = this.i;
        int iFloatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.j;
        return iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }

    public int i() {
        return this.f377a;
    }

    public boolean j() {
        return this.e;
    }

    public String toString() {
        return "VideoButtonProperties{widthPercentOfScreen=" + this.f377a + ", heightPercentOfScreen=" + this.b + ", margin=" + this.c + ", gravity=" + this.d + ", tapToFade=" + this.e + ", tapToFadeDurationMillis=" + this.f + ", fadeInDurationMillis=" + this.g + ", fadeOutDurationMillis=" + this.h + ", fadeInDelay=" + this.i + ", fadeOutDelay=" + this.j + AbstractJsonLexerKt.END_OBJ;
    }
}
