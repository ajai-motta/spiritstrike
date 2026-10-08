package com.applovin.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v7 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f699a = new HashSet();
    public final Set b = new HashSet();
    private Uri c;
    private Uri d;
    private int e;
    private int f;

    public static v7 a(q8 q8Var, com.applovin.impl.sdk.k kVar) {
        if (q8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        q8 q8VarC = q8Var.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.D);
        if (q8VarC == null || !URLUtil.isValidUrl(q8VarC.d())) {
            kVar.O();
            if (!com.applovin.impl.sdk.o.a()) {
                return null;
            }
            kVar.O().b("VastIndustryIcon", "Unable to create industry icon.  No valid image URL found.");
            return null;
        }
        v7 v7Var = new v7();
        v7Var.c = Uri.parse(q8VarC.d());
        q8 q8VarB = q8Var.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.H);
        if (q8VarB != null && URLUtil.isValidUrl(q8VarB.d())) {
            v7Var.d = Uri.parse(q8VarB.d());
        }
        String str = (String) q8Var.a().get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        int i = 0;
        int i2 = (str == null || Integer.parseInt(str) <= 0) ? 0 : Integer.parseInt(str);
        String str2 = (String) q8Var.a().get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        if (str2 != null && Integer.parseInt(str2) > 0) {
            i = Integer.parseInt(str2);
        }
        int iIntValue = ((Integer) kVar.a(y4.X4)).intValue();
        if (i2 <= 0 || i <= 0) {
            v7Var.f = iIntValue;
            v7Var.e = iIntValue;
        } else {
            double d = i2 / i;
            int iMin = Math.min(Math.max(i2, i), iIntValue);
            if (i2 >= i) {
                v7Var.e = iMin;
                v7Var.f = (int) (((double) iMin) / d);
            } else {
                v7Var.f = iMin;
                v7Var.e = (int) (((double) iMin) * d);
            }
        }
        return v7Var;
    }

    public Set b() {
        return this.f699a;
    }

    public Uri c() {
        return this.d;
    }

    public int d() {
        return this.f;
    }

    public Uri e() {
        return this.c;
    }

    public Set f() {
        return this.b;
    }

    public int g() {
        return this.e;
    }

    public String toString() {
        return "VastIndustryIcon{imageUri='" + e() + "', clickUri='" + c() + "', width=" + g() + ", height=" + d() + "}";
    }

    public static ImageView a(Uri uri, Context context, com.applovin.impl.sdk.k kVar) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        imageView.setVisibility(8);
        ImageViewUtils.setImageUri(imageView, uri, kVar);
        return imageView;
    }

    public static v7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        z7 z7VarA;
        z7 z7VarA2;
        if (jSONObject == null) {
            return null;
        }
        v7 v7Var = new v7();
        String string = JsonUtils.getString(jSONObject, "image_uri", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        v7Var.c = Uri.parse(string);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null && (z7VarA2 = z7.a(jSONObject2, kVar)) != null) {
                v7Var.f699a.add(z7VarA2);
            }
        }
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "view_trackers", new JSONArray());
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null);
            if (jSONObject3 != null && (z7VarA = z7.a(jSONObject3, kVar)) != null) {
                v7Var.b.add(z7VarA);
            }
        }
        String string2 = JsonUtils.getString(jSONObject, "click_uri", null);
        v7Var.d = StringUtils.isValidString(string2) ? Uri.parse(string2) : null;
        v7Var.e = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0);
        v7Var.f = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0);
        return v7Var;
    }

    @Override // com.applovin.impl.q4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f699a.iterator();
        while (it.hasNext()) {
            jSONArray.put(((z7) it.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            jSONArray.put(((z7) it2.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "view_trackers", jSONArray2);
        Uri uri = this.c;
        JsonUtils.putString(jSONObject, "image_uri", uri == null ? null : uri.toString());
        Uri uri2 = this.d;
        JsonUtils.putString(jSONObject, "click_uri", uri2 != null ? uri2.toString() : null);
        JsonUtils.putInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.e);
        JsonUtils.putInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f);
        return jSONObject;
    }
}
