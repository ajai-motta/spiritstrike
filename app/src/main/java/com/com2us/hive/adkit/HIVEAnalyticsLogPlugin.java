package com.com2us.hive.adkit;

import android.util.Log;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.util.ADXLogUtil;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class HIVEAnalyticsLogPlugin {
    static JSONObject additionalInfo;

    public static void SetAdditionalInfoJSON(JSONObject jSONObject) {
        additionalInfo = jSONObject;
    }

    public static void SetAdditionalInfo(String str) {
        Log.w("adkit", "deserializeableJsonObjectString = " + str.toString());
        try {
            JSONObject jSONObject = new JSONObject(str);
            Log.w("adkit", "jsonObject = " + jSONObject.toString());
            additionalInfo = jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void AdLog(String str, String str2, String str3, String str4, String str5, String str6, double d) throws IllegalAccessException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", "hive_ad_watch_log");
            jSONObject.put("eventType", str);
            jSONObject.put(HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID, str2);
            jSONObject.put("adNetwork", str4);
            jSONObject.put("uniqueSessionKey", str3);
            jSONObject.put("adPlacement", str5);
            if (str.equals(ReportUtil.EVENT_TYPE_REWARD)) {
                jSONObject.put("rewardType", (Object) null);
                jSONObject.put("rewardAmount", (Object) null);
            }
            jSONObject.put("adSource", ADXLogUtil.PLATFORM_ADX);
            JSONObject jSONObject2 = additionalInfo;
            if (jSONObject2 != null) {
                jSONObject.put("extraLogBody", jSONObject2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sendAnalyticsLog(jSONObject);
    }

    public static void PaidEventLog(String str, String str2, String str3, String str4, double d) throws IllegalAccessException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", "hive_ad_watch_log");
            jSONObject.put("eventType", str);
            jSONObject.put(HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID, str2);
            jSONObject.put("adNetwork", str4);
            jSONObject.put("uniqueSessionKey", str3);
            jSONObject.put("ecpm", d);
            jSONObject.put("adSource", ADXLogUtil.PLATFORM_ADX);
            JSONObject jSONObject2 = additionalInfo;
            if (jSONObject2 != null) {
                jSONObject.put("extraLogBody", jSONObject2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sendAnalyticsLog(jSONObject);
    }

    public static void AdRevenueEventLog(String str, String str2, double d, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adPlatform", ADXLogUtil.PLATFORM_ADX);
            jSONObject.put(HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID, str);
            jSONObject.put("adPlacement", str3);
            jSONObject.put("adType", str4);
            jSONObject.put(AnalyticsProviderAdjust.EventKeys.revenue, d / 1000.0d);
            jSONObject.put("currency", "USD");
        } catch (Exception e) {
            e.printStackTrace();
        }
        sendAdRevenueEvent(jSONObject);
    }

    public static String CreateUniqueSessionKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private static void sendAnalyticsLog(JSONObject jSONObject) throws IllegalAccessException {
        Class<?> cls;
        try {
            try {
                cls = Class.forName("com.hive.v1.Analytics");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("com.hive.Analytics");
            }
            Method method = cls.getMethod("sendAnalyticsLog", JSONObject.class);
            Object obj = null;
            try {
                Field field = cls.getField("INSTANCE");
                if (field != null) {
                    obj = field.get(null);
                }
            } catch (Throwable unused2) {
            }
            method.invoke(obj, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void sendAdRevenueEvent(JSONObject jSONObject) {
        Class<?> cls;
        Class<?> cls2;
        try {
            try {
                cls = Class.forName("com.hive.Analytics");
                try {
                    cls2 = Class.forName("com.hive.Analytics$AnalyticsAdRevenue");
                } catch (Exception e) {
                    e = e;
                    Log.w("AdKit", "Find Analytics class exception : " + e.toString());
                    cls2 = null;
                }
            } catch (Throwable th) {
                Log.w("AdKit", "sendAdRevenueEvent exception : " + th.toString());
                return;
            }
        } catch (Exception e2) {
            e = e2;
            cls = null;
        }
        if (cls == null || cls2 == null) {
            return;
        }
        try {
            Field field = cls.getField("INSTANCE");
            cls.getMethod("sendAdRevenueEvent", cls2).invoke(field != null ? field.get(null) : null, cls2.getDeclaredConstructor(Double.TYPE, String.class, String.class, String.class, String.class, String.class).newInstance(Double.valueOf(jSONObject.optDouble(AnalyticsProviderAdjust.EventKeys.revenue, 0.0d)), jSONObject.optString("adPlatform"), jSONObject.optString(HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID), jSONObject.optString("adType"), jSONObject.optString("adPlacement"), jSONObject.optString("currency", "USD")));
        } catch (Throwable th2) {
            Log.w("AdKit", "Method call exception : " + th2.toString());
        }
    }
}
