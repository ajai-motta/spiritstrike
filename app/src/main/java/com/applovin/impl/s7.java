package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s7 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f596a;
    private int b;
    private Uri c;
    private x7 d;
    private final Set e = new HashSet();
    private final Map f = new HashMap();

    private s7() {
    }

    public static s7 a(q8 q8Var, s7 s7Var, t7 t7Var, com.applovin.impl.sdk.k kVar) {
        q8 q8VarC;
        if (q8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (s7Var == null) {
            try {
                s7Var = new s7();
            } catch (Throwable th) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("VastCompanionAd", "Error occurred while initializing", th);
                }
                kVar.D().a("VastCompanionAd", th);
                return null;
            }
        }
        if (s7Var.f596a == 0 && s7Var.b == 0) {
            int i = StringUtils.parseInt((String) q8Var.a().get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
            int i2 = StringUtils.parseInt((String) q8Var.a().get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
            if (i > 0 && i2 > 0) {
                s7Var.f596a = i;
                s7Var.b = i2;
            }
        }
        s7Var.d = x7.a(q8Var, s7Var.d, kVar);
        if (s7Var.c == null && (q8VarC = q8Var.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.N)) != null) {
            String strD = q8VarC.d();
            if (StringUtils.isValidString(strD)) {
                s7Var.c = Uri.parse(strD);
            }
        }
        b8.a(q8Var.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.O), s7Var.e, t7Var, kVar);
        b8.a(q8Var, s7Var.f, t7Var, kVar);
        return s7Var;
    }

    public Set b() {
        return this.e;
    }

    public Uri c() {
        return this.c;
    }

    public Map d() {
        return this.f;
    }

    public x7 e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s7)) {
            return false;
        }
        s7 s7Var = (s7) obj;
        if (this.f596a != s7Var.f596a || this.b != s7Var.b) {
            return false;
        }
        Uri uri = this.c;
        if (uri == null ? s7Var.c != null : !uri.equals(s7Var.c)) {
            return false;
        }
        x7 x7Var = this.d;
        if (x7Var == null ? s7Var.d != null : !x7Var.equals(s7Var.d)) {
            return false;
        }
        Set set = this.e;
        if (set == null ? s7Var.e != null : !set.equals(s7Var.e)) {
            return false;
        }
        Map map = this.f;
        Map map2 = s7Var.f;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        int i = ((this.f596a * 31) + this.b) * 31;
        Uri uri = this.c;
        int iHashCode = (i + (uri != null ? uri.hashCode() : 0)) * 31;
        x7 x7Var = this.d;
        int iHashCode2 = (iHashCode + (x7Var != null ? x7Var.hashCode() : 0)) * 31;
        Set set = this.e;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map map = this.f;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.f596a + ", height=" + this.b + ", destinationUri=" + this.c + ", nonVideoResource=" + this.d + ", clickTrackers=" + this.e + ", eventTrackers=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }

    public static s7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        int i = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0);
        int i2 = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0);
        String string = JsonUtils.getString(jSONObject, "destination_uri", null);
        Uri uri = StringUtils.isValidString(string) ? Uri.parse(string) : null;
        x7 x7VarA = x7.a(JsonUtils.getJSONObject(jSONObject, "non_video_resource", (JSONObject) null), kVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            z7 z7VarA = z7.a(JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null), kVar);
            if (z7VarA != null) {
                hashSet.add(z7VarA);
            }
        }
        s7 s7Var = new s7();
        s7Var.f596a = i;
        s7Var.b = i2;
        s7Var.c = uri;
        s7Var.d = x7VarA;
        s7Var.e.addAll(hashSet);
        return s7Var;
    }

    @Override // com.applovin.impl.q4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f596a);
        JsonUtils.putInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.b);
        Uri uri = this.c;
        JsonUtils.putString(jSONObject, "destination_uri", uri == null ? null : uri.toString());
        x7 x7Var = this.d;
        JsonUtils.putJSONObject(jSONObject, "non_video_resource", x7Var != null ? x7Var.a() : null);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            jSONArray.put(((z7) it.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray);
        return jSONObject;
    }
}
