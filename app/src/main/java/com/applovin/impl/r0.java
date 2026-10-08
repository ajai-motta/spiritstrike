package com.applovin.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import com.applovin.impl.q0;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f583a = {7, 4, 2, 1, 11};
    private static final int[] b = {5, 6, 12, 10, 3, 9, 8, 14};
    private static final int[] c = {15, 13};
    private static final int[] d = {20};

    public static String a(String str, com.applovin.impl.sdk.k kVar) {
        return a((String) kVar.a(y4.t0), str, kVar);
    }

    public static boolean a(int i) {
        return i < 200 || i >= 300;
    }

    public static String b(String str, com.applovin.impl.sdk.k kVar) {
        return a((String) kVar.a(y4.s0), str, kVar);
    }

    public static Map c(com.applovin.impl.sdk.k kVar) {
        HashMap map = new HashMap();
        String str = (String) kVar.a(y4.j);
        if (StringUtils.isValidString(str)) {
            map.put("device_token", str);
        } else if (!((Boolean) kVar.a(y4.l5)).booleanValue()) {
            map.put("api_key", kVar.j0());
        }
        map.putAll(o7.a(kVar.A().e()));
        return map;
    }

    public static String d(com.applovin.impl.sdk.k kVar) {
        return a((String) kVar.a(y4.r0), "4.0/ad", kVar);
    }

    public static String e(com.applovin.impl.sdk.k kVar) {
        return a((String) kVar.a(y4.q0), "4.0/ad", kVar);
    }

    public static Long f(com.applovin.impl.sdk.k kVar) {
        q0.d dVarA = kVar.w().a();
        if (dVarA == null) {
            return null;
        }
        double dC = o7.c(dVarA.b());
        double d2 = o7.d(dVarA.a());
        if (d2 == 0.0d) {
            return null;
        }
        return Long.valueOf((long) (dC / d2));
    }

    public static String g(com.applovin.impl.sdk.k kVar) {
        NetworkInfo networkInfoB = b(com.applovin.impl.sdk.k.o());
        if (networkInfoB == null) {
            return "unknown";
        }
        int type = networkInfoB.getType();
        int subtype = networkInfoB.getSubtype();
        return type == 1 ? "wifi" : type == 0 ? a(subtype, f583a) ? "2g" : a(subtype, b) ? "3g" : a(subtype, c) ? "4g" : a(subtype, d) ? "5g" : "mobile" : "unknown";
    }

    public static void a(JSONObject jSONObject, boolean z, com.applovin.impl.sdk.k kVar) {
        kVar.t().a(jSONObject, z);
    }

    public static void b(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        String string = JsonUtils.getString(jSONObject, "persisted_data", null);
        if (StringUtils.isValidString(string)) {
            kVar.b(a5.H, string);
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().d("ConnectionUtils", "Updated persisted data");
            }
        }
    }

    public static void a(int i, com.applovin.impl.sdk.k kVar) {
        if (i == 401) {
            com.applovin.impl.sdk.o.h("AppLovinSdk", "SDK key \"" + kVar.j0() + "\" is rejected by AppLovin. Please make sure the SDK key is correct.");
            return;
        }
        if (i == 418) {
            kVar.p0().a(y4.e, Boolean.TRUE);
            kVar.p0().e();
        } else if (i >= 400 && i < 500) {
            if (((Boolean) kVar.a(y4.g)).booleanValue()) {
                kVar.V0();
            }
        } else if (i == -1 && ((Boolean) kVar.a(y4.g)).booleanValue()) {
            kVar.V0();
        }
    }

    private static NetworkInfo b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static String b(com.applovin.impl.sdk.k kVar) {
        return a((String) kVar.a(y4.q0), ((Boolean) kVar.a(y4.m3)).booleanValue() ? "5.0/ad" : "4.0/ad", kVar);
    }

    public static void c(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (kVar != null) {
            try {
                if (jSONObject.has("settings")) {
                    z4 z4VarP0 = kVar.p0();
                    if (jSONObject.isNull("settings")) {
                        return;
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject("settings");
                    z4VarP0.a(jSONObject2);
                    z4VarP0.e();
                    String strB = y4.K6.b();
                    if (JsonUtils.valueExists(jSONObject2, strB)) {
                        b5.b(a5.J, JsonUtils.getBoolean(jSONObject2, strB, Boolean.FALSE), com.applovin.impl.sdk.k.o());
                        return;
                    }
                    return;
                }
                return;
            } catch (JSONException e) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("ConnectionUtils", "Unable to parse settings out of API response", e);
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public static String a(String str, String str2, com.applovin.impl.sdk.k kVar) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        }
        if (kVar != null) {
            return str + str2;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public static void a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "filesystem_values", (JSONObject) null);
        if (jSONObject2 != null) {
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(com.applovin.impl.sdk.k.o()).edit();
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object object = JsonUtils.getObject(jSONObject2, next, null);
                if (object != null) {
                    b5.a(next, object, (SharedPreferences) null, editorEdit);
                }
            }
            if (((Boolean) kVar.a(y4.G6)).booleanValue()) {
                b5.a(editorEdit);
            } else {
                editorEdit.apply();
            }
        }
    }

    public static byte[] a(InputStream inputStream, com.applovin.impl.sdk.k kVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[((Integer) kVar.a(y4.f3)).intValue()];
        while (true) {
            int i = inputStream.read(bArr);
            if (i > 0) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static boolean a(Context context) {
        if (context.getSystemService("connectivity") == null) {
            return true;
        }
        NetworkInfo networkInfoB = b(context);
        if (networkInfoB != null) {
            return networkInfoB.isConnected();
        }
        return false;
    }

    private static boolean a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static String a(com.applovin.impl.sdk.k kVar) {
        return a((String) kVar.a(y4.r0), ((Boolean) kVar.a(y4.m3)).booleanValue() ? "5.0/ad" : "4.0/ad", kVar);
    }
}
