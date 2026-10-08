package com.applovin.impl;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x7 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f722a;
    private Uri b;
    private String c;

    public enum a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    private x7() {
    }

    static x7 a(q8 q8Var, x7 x7Var, com.applovin.impl.sdk.k kVar) {
        if (q8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (x7Var == null) {
            try {
                x7Var = new x7();
            } catch (Throwable th) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("VastNonVideoResource", "Error occurred while initializing", th);
                }
                kVar.D().a("VastNonVideoResource", th);
                return null;
            }
        }
        if (x7Var.b == null && !StringUtils.isValidString(x7Var.c)) {
            String strA = a(q8Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.D);
            if (URLUtil.isValidUrl(strA)) {
                x7Var.b = Uri.parse(strA);
                x7Var.f722a = a.STATIC;
                return x7Var;
            }
            String strA2 = a(q8Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.E);
            if (StringUtils.isValidString(strA2)) {
                x7Var.f722a = a.IFRAME;
                if (URLUtil.isValidUrl(strA2)) {
                    x7Var.b = Uri.parse(strA2);
                } else {
                    x7Var.c = strA2;
                }
                return x7Var;
            }
            String strA3 = a(q8Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.F);
            if (StringUtils.isValidString(strA3)) {
                x7Var.f722a = a.HTML;
                if (URLUtil.isValidUrl(strA3)) {
                    x7Var.b = Uri.parse(strA3);
                } else {
                    x7Var.c = strA3;
                }
            }
        }
        return x7Var;
    }

    public String b() {
        return this.c;
    }

    public Uri c() {
        return this.b;
    }

    public a d() {
        return this.f722a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x7)) {
            return false;
        }
        x7 x7Var = (x7) obj;
        if (this.f722a != x7Var.f722a) {
            return false;
        }
        Uri uri = this.b;
        if (uri == null ? x7Var.b != null : !uri.equals(x7Var.b)) {
            return false;
        }
        String str = this.c;
        String str2 = x7Var.c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        a aVar = this.f722a;
        int iHashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.b;
        int iHashCode2 = (iHashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.f722a + ", resourceUri=" + this.b + ", resourceContents='" + this.c + "'}";
    }

    private static String a(q8 q8Var, String str) {
        q8 q8VarC = q8Var.c(str);
        if (q8VarC != null) {
            return q8VarC.d();
        }
        return null;
    }

    public void a(Uri uri) {
        this.b = uri;
    }

    public void a(String str) {
        this.c = str;
    }

    public static x7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject, "type", null);
        a aVarValueOf = string == null ? null : a.valueOf(string);
        String string2 = JsonUtils.getString(jSONObject, "resource_uri", null);
        Uri uri = StringUtils.isValidString(string2) ? Uri.parse(string2) : null;
        x7 x7Var = new x7();
        x7Var.f722a = aVarValueOf;
        x7Var.b = uri;
        x7Var.c = JsonUtils.getString(jSONObject, "resource_contents", null);
        return x7Var;
    }

    @Override // com.applovin.impl.q4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        a aVar = this.f722a;
        JsonUtils.putString(jSONObject, "type", aVar == null ? null : aVar.toString());
        Uri uri = this.b;
        JsonUtils.putString(jSONObject, "resource_uri", uri != null ? uri.toString() : null);
        JsonUtils.putString(jSONObject, "resource_contents", this.c);
        return jSONObject;
    }
}
