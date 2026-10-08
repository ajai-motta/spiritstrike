package com.moloco.sdk.internal.publisher.nativead.parser;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.moloco.sdk.internal.publisher.nativead.model.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2224a = 0;

    public final Object a(String nativeOrtbString) {
        Intrinsics.checkNotNullParameter(nativeOrtbString, "nativeOrtbString");
        try {
            JSONObject jSONObject = new JSONObject(nativeOrtbString);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("native");
            if (jSONObjectOptJSONObject != null) {
                jSONObject = jSONObjectOptJSONObject;
            }
            Result.Companion companion = Result.INSTANCE;
            return Result.m7415constructorimpl(new com.moloco.sdk.internal.publisher.nativead.model.b(jSONObject.has("ver") ? jSONObject.getString("ver") : null, a(jSONObject.optJSONArray("assets")), a(jSONObject.optJSONObject("link")), c(jSONObject.optJSONArray("imptrackers")), b(jSONObject.optJSONArray("eventtrackers")), jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_PRIVACY) ? jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_PRIVACY) : null));
        } catch (Exception e) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7415constructorimpl(ResultKt.createFailure(e));
        }
    }

    public final b.a.C0400b b(JSONObject jSONObject, int i, boolean z) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        Integer numValueOf = jSONObject.has("type") ? Integer.valueOf(jSONObject.getInt("type")) : null;
        String string = jSONObject.getString("url");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new b.a.C0400b(i, z, numValueOf, string, jSONObject.has("w") ? Integer.valueOf(jSONObject.getInt("w")) : null, jSONObject.has("h") ? Integer.valueOf(jSONObject.getInt("h")) : null);
    }

    public final b.a.c c(JSONObject jSONObject, int i, boolean z) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("text");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new b.a.c(i, z, string, jSONObject.has("len") ? Integer.valueOf(jSONObject.getInt("len")) : null);
    }

    public final b.a.d d(JSONObject jSONObject, int i, boolean z) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("vasttag");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new b.a.d(i, z, string);
    }

    public final List<String> c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public final List<b.C0401b> b(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(new b.C0401b(jSONObject.getInt("event"), jSONObject.getInt(FirebaseAnalytics.Param.METHOD), jSONObject.has("url") ? jSONObject.getString("url") : null));
        }
        return arrayList;
    }

    public final List<b.a> a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.has("id")) {
                int i2 = jSONObject.getInt("id");
                boolean z = jSONObject.optInt("required", 0) == 1;
                Object objC = c(jSONObject.optJSONObject("title"), i2, z);
                if (objC == null && (objC = b(jSONObject.optJSONObject("img"), i2, z)) == null && (objC = d(jSONObject.optJSONObject("video"), i2, z)) == null) {
                    objC = a(jSONObject.optJSONObject("data"), i2, z);
                }
                if (objC != null) {
                    arrayList.add(objC);
                }
            }
        }
        return arrayList;
    }

    public final b.a.C0399a a(JSONObject jSONObject, int i, boolean z) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        Integer numValueOf = jSONObject.has("type") ? Integer.valueOf(jSONObject.getInt("type")) : null;
        Integer numValueOf2 = jSONObject.has("len") ? Integer.valueOf(jSONObject.getInt("len")) : null;
        String string = jSONObject.getString("value");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new b.a.C0399a(i, z, numValueOf, numValueOf2, string);
    }

    public final b.c a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("url");
        String string2 = jSONObject.has("fallback") ? jSONObject.getString("fallback") : null;
        List<String> listC = c(jSONObject.optJSONArray("clicktrackers"));
        Intrinsics.checkNotNull(string);
        return new b.c(string, listC, string2);
    }
}
