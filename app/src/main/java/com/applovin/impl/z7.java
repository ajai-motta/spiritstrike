package com.applovin.impl;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z7 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f747a;
    private String b;
    private String c;
    private boolean d;
    private long e = -1;
    private int f = -1;

    private z7() {
    }

    public static z7 a(q8 q8Var, t7 t7Var, com.applovin.impl.sdk.k kVar) {
        List<String> listExplode;
        int size;
        long seconds;
        if (q8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            String strD = q8Var.d();
            if (TextUtils.isEmpty(strD)) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().b("VastTracker", "Unable to create tracker. Could not find URL.");
                }
                return null;
            }
            z7 z7Var = new z7();
            z7Var.c = strD;
            z7Var.f747a = (String) q8Var.a().get("id");
            z7Var.b = (String) q8Var.a().get("event");
            z7Var.d = ((Boolean) kVar.a(y4.k5)).booleanValue();
            if (t7Var != null) {
                z7Var.d = JsonUtils.getBoolean(t7Var.b(), "vast_fire_trackers_from_webview", Boolean.valueOf(z7Var.d)).booleanValue();
            }
            z7Var.f = a(z7Var.b(), t7Var);
            String str = (String) q8Var.a().get(TypedValues.CycleType.S_WAVE_OFFSET);
            if (StringUtils.isValidString(str)) {
                String strTrim = str.trim();
                if (strTrim.contains("%")) {
                    z7Var.f = StringUtils.parseInt(strTrim.substring(0, strTrim.length() - 1));
                } else if (strTrim.contains(":") && (size = (listExplode = CollectionUtils.explode(strTrim, ":")).size()) > 0) {
                    int i = size - 1;
                    long j = 0;
                    for (int i2 = i; i2 >= 0; i2--) {
                        String str2 = listExplode.get(i2);
                        if (StringUtils.isNumeric(str2)) {
                            int i3 = Integer.parseInt(str2);
                            if (i2 == i) {
                                seconds = i3;
                            } else if (i2 == size - 2) {
                                seconds = TimeUnit.MINUTES.toSeconds(i3);
                            } else if (i2 == size - 3) {
                                seconds = TimeUnit.HOURS.toSeconds(i3);
                            }
                            j += seconds;
                        }
                    }
                    z7Var.e = j;
                    z7Var.f = -1;
                }
            }
            return z7Var;
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("VastTracker", "Error occurred while initializing", th);
            }
            kVar.D().a("VastTracker", th);
            return null;
        }
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z7)) {
            return false;
        }
        z7 z7Var = (z7) obj;
        if (this.e != z7Var.e || this.f != z7Var.f) {
            return false;
        }
        String str = this.f747a;
        if (str == null ? z7Var.f747a != null : !str.equals(z7Var.f747a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? z7Var.b == null : str2.equals(z7Var.b)) {
            return this.c.equals(z7Var.c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f747a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c.hashCode()) * 31;
        long j = this.e;
        return ((iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31) + this.f;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.f747a + "', event='" + this.b + "', uriString='" + this.c + "', offsetSeconds=" + this.e + ", offsetPercent=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean a(long j, int i) {
        long j2 = this.e;
        boolean z = j2 >= 0;
        boolean z2 = j >= j2;
        int i2 = this.f;
        boolean z3 = i2 >= 0;
        boolean z4 = i >= i2;
        if (z && z2) {
            return true;
        }
        return z3 && z4;
    }

    private static int a(String str, t7 t7Var) {
        if (TtmlNode.START.equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if ("midpoint".equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if (!"complete".equalsIgnoreCase(str)) {
            return -1;
        }
        if (t7Var != null) {
            return t7Var.g();
        }
        return 95;
    }

    public static z7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        z7 z7Var = new z7();
        String string = JsonUtils.getString(jSONObject, "uri_string", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        z7Var.c = string;
        z7Var.f747a = JsonUtils.getString(jSONObject, "identifier", "");
        z7Var.b = JsonUtils.getString(jSONObject, "event", "");
        z7Var.e = JsonUtils.getLong(jSONObject, "offset_seconds", -1L);
        z7Var.f = JsonUtils.getInt(jSONObject, "offset_percent", -1);
        return z7Var;
    }

    @Override // com.applovin.impl.q4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "identifier", this.f747a);
        JsonUtils.putString(jSONObject, "event", this.b);
        JsonUtils.putString(jSONObject, "uri_string", this.c);
        JsonUtils.putLong(jSONObject, "offset_seconds", this.e);
        JsonUtils.putInt(jSONObject, "offset_percent", this.f);
        return jSONObject;
    }
}
