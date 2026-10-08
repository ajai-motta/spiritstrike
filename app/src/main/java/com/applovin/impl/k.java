package com.applovin.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f435a;
    private final String b;

    public enum a {
        UNSPECIFIED("UNSPECIFIED"),
        REGULAR("REGULAR"),
        AD_RESPONSE_JSON("AD_RESPONSE_JSON");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f436a;

        a(String str) {
            this.f436a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f436a;
        }
    }

    public k(String str, com.applovin.impl.sdk.k kVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.b = str;
        this.f435a = kVar;
    }

    public JSONObject a() {
        if (c() != a.AD_RESPONSE_JSON) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.b.substring(d().length()), 0), "UTF-8"));
                this.f435a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f435a.O().a("AdToken", "Decoded token into ad response: " + jSONObject);
                }
                return jSONObject;
            } catch (JSONException e) {
                this.f435a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f435a.O().a("AdToken", "Unable to decode token '" + this.b + "' into JSON", e);
                }
                this.f435a.D().a("AdToken", "decodeFullAdResponseStr", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            this.f435a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f435a.O().a("AdToken", "Unable to process ad response from token '" + this.b + "'", e2);
            }
            this.f435a.D().a("AdToken", "decodeFullAdResponse", e2);
            return null;
        }
    }

    public String b() {
        return this.b;
    }

    public a c() {
        return a(y4.C0) != null ? a.REGULAR : a(y4.D0) != null ? a.AD_RESPONSE_JSON : a.UNSPECIFIED;
    }

    public String d() {
        String strA = a(y4.C0);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String strA2 = a(y4.D0);
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        return strA2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        String str = this.b;
        String str2 = ((k) obj).b;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AdToken{id=" + StringUtils.prefixToIndex(32, this.b) + ", type=" + c() + AbstractJsonLexerKt.END_OBJ;
    }

    private String a(y4 y4Var) {
        for (String str : this.f435a.c(y4Var)) {
            if (this.b.startsWith(str)) {
                return str;
            }
        }
        return null;
    }
}
