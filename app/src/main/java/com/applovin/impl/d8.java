package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d8 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f356a;
    private Uri b;
    private a c;
    private String d;
    private int e;
    private int f;
    private long g;

    public enum a {
        Progressive,
        Streaming
    }

    private d8() {
    }

    public static d8 a(q8 q8Var, com.applovin.impl.sdk.k kVar) {
        if (q8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            String strD = q8Var.d();
            if (!URLUtil.isValidUrl(strD)) {
                kVar.O();
                if (!com.applovin.impl.sdk.o.a()) {
                    return null;
                }
                kVar.O().b("VastVideoFile", "Unable to create video file. Could not find URL.");
                return null;
            }
            Uri uri = Uri.parse(strD);
            d8 d8Var = new d8();
            d8Var.f356a = uri;
            d8Var.b = uri;
            d8Var.g = a(q8Var);
            d8Var.c = a((String) q8Var.a().get("delivery"));
            d8Var.f = StringUtils.parseInt((String) q8Var.a().get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
            d8Var.e = StringUtils.parseInt((String) q8Var.a().get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
            d8Var.d = ((String) q8Var.a().get("type")).toLowerCase(Locale.ENGLISH);
            return d8Var;
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("VastVideoFile", "Error occurred while initializing", th);
            }
            kVar.D().a("VastVideoFile", th);
            return null;
        }
    }

    public long b() {
        return this.g;
    }

    public String c() {
        return this.d;
    }

    public Uri d() {
        return this.f356a;
    }

    public Uri e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d8)) {
            return false;
        }
        d8 d8Var = (d8) obj;
        if (this.e != d8Var.e || this.f != d8Var.f || this.g != d8Var.g) {
            return false;
        }
        Uri uri = this.f356a;
        if (uri == null ? d8Var.f356a != null : !uri.equals(d8Var.f356a)) {
            return false;
        }
        Uri uri2 = this.b;
        if (uri2 == null ? d8Var.b != null : !uri2.equals(d8Var.b)) {
            return false;
        }
        if (this.c != d8Var.c) {
            return false;
        }
        String str = this.d;
        String str2 = d8Var.d;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        Uri uri = this.f356a;
        int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.b;
        int iHashCode2 = (iHashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        a aVar = this.c;
        int iHashCode3 = (iHashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.d;
        return ((((((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.e) * 31) + this.f) * 31) + Long.valueOf(this.g).hashCode();
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.f356a + ", videoUri=" + this.b + ", deliveryType=" + this.c + ", fileType='" + this.d + "', width=" + this.e + ", height=" + this.f + ", bitrate=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }

    private static a a(String str) {
        if (StringUtils.isValidString(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return a.Streaming;
            }
        }
        return a.Progressive;
    }

    private static long a(q8 q8Var) {
        Map mapA = q8Var.a();
        long j = StringUtils.parseLong((String) mapA.get("bitrate"), 0L);
        return j != 0 ? j : (StringUtils.parseLong((String) mapA.get("minBitrate"), 0L) + StringUtils.parseLong((String) mapA.get("maxBitrate"), 0L)) / 2;
    }

    public void a(Uri uri) {
        this.b = uri;
    }

    public static d8 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject, "source_video_uri", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        Uri uri = Uri.parse(string);
        if (TextUtils.isEmpty(JsonUtils.getString(jSONObject, "video_uri", null))) {
            return null;
        }
        Uri uri2 = Uri.parse(string);
        String string2 = JsonUtils.getString(jSONObject, "file_type", null);
        if (TextUtils.isEmpty(string2)) {
            return null;
        }
        a aVarValueOf = a.valueOf(JsonUtils.getString(jSONObject, "delivery_type", a.Progressive.toString()));
        int i = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0);
        int i2 = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0);
        int i3 = JsonUtils.getInt(jSONObject, "bitrate", 0);
        d8 d8Var = new d8();
        d8Var.f356a = uri;
        d8Var.b = uri2;
        d8Var.c = aVarValueOf;
        d8Var.d = string2;
        d8Var.e = i;
        d8Var.f = i2;
        d8Var.g = i3;
        return d8Var;
    }

    @Override // com.applovin.impl.q4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        Uri uri = this.f356a;
        if (uri != null) {
            JsonUtils.putString(jSONObject, "source_video_uri", uri.toString());
        }
        Uri uri2 = this.b;
        if (uri2 != null) {
            JsonUtils.putString(jSONObject, "video_uri", uri2.toString());
        }
        a aVar = this.c;
        JsonUtils.putString(jSONObject, "delivery_type", aVar == null ? null : aVar.toString());
        JsonUtils.putString(jSONObject, "file_type", this.d);
        JsonUtils.putInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.e);
        JsonUtils.putInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f);
        JsonUtils.putLong(jSONObject, "bitrate", this.g);
        return jSONObject;
    }
}
