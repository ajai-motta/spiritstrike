package com.hive.plugin;

import com.hive.Analytics;
import com.hive.ResultAPI;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.hive.analytics.provider.attributes.AnalyticsAttributes;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.Currency;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Analytics {
    private ICallEngine callEngine;

    public Analytics(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String sendAnalyticsLog(String str, JSONObject jSONObject) {
        boolean zSendAnalyticsLog = com.hive.Analytics.sendAnalyticsLog(jSONObject.optJSONObject("logData"));
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("sendAnalyticsLog", zSendAnalyticsLog);
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setEnableTracker(String str, JSONObject jSONObject) {
        com.hive.Analytics.setEnableTracker(Analytics.TrackingType.valueOf(jSONObject.optString("trackingType")), jSONObject.optBoolean("isEnable"));
        return "";
    }

    public String setEnableTrackerWithName(String str, JSONObject jSONObject) {
        com.hive.Analytics.setEnableTrackerWithName(jSONObject.optString("name"), jSONObject.optBoolean("isEnable"));
        return "";
    }

    public String sendEvent(String str, JSONObject jSONObject) {
        com.hive.Analytics.sendEvent(jSONObject.optString("eventName"));
        return "";
    }

    public String sendEventWithAttributes(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("eventName");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("attributes");
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObjectOptJSONObject != null) {
            try {
                jSONObject2 = jSONObjectOptJSONObject.getJSONObject("moduleSpecificAttributes");
            } catch (JSONException unused) {
            }
            try {
                jSONObject3 = jSONObjectOptJSONObject.getJSONObject("customAttributes");
            } catch (JSONException unused2) {
            }
        }
        com.hive.Analytics.sendEventWithAttributes(strOptString, new AnalyticsAttributes(jSONObject2, jSONObject3));
        return "";
    }

    public String sendAdRevenueEvent(String str, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("analyticsAdRevenue");
        double dOptDouble = jSONObjectOptJSONObject.optDouble(AnalyticsProviderAdjust.EventKeys.revenue, 0.0d);
        String strOptString = jSONObjectOptJSONObject.optString("adPlatform");
        String strOptString2 = jSONObjectOptJSONObject.optString(HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID);
        String strOptString3 = jSONObjectOptJSONObject.optString("adType");
        String strOptString4 = jSONObjectOptJSONObject.optString("adPlacement");
        String strOptString5 = jSONObjectOptJSONObject.optString("currency", "USD");
        Analytics.AnalyticsAdRevenue analyticsAdRevenue = new Analytics.AnalyticsAdRevenue();
        analyticsAdRevenue.setRevenue(dOptDouble);
        analyticsAdRevenue.setAdPlatform(strOptString);
        analyticsAdRevenue.setAdUnitId(strOptString2);
        analyticsAdRevenue.setAdType(strOptString3);
        analyticsAdRevenue.setAdPlacement(strOptString4);
        Currency currency = Currency.getInstance(Locale.US);
        try {
            currency = Currency.getInstance(strOptString5);
        } catch (Exception unused) {
        }
        analyticsAdRevenue.setCurrency(currency.getCurrencyCode());
        com.hive.Analytics.sendAdRevenueEvent(analyticsAdRevenue);
        return "";
    }

    public String getRemainAnalyticsLogCount(String str, JSONObject jSONObject) {
        int remainAnalyticsLogCount = com.hive.Analytics.getRemainAnalyticsLogCount();
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getRemainAnalyticsLogCount", remainAnalyticsLogCount);
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String sendUserEntryFunnelsLogs(String str, JSONObject jSONObject) {
        com.hive.Analytics.sendUserEntryFunnelsLogs(jSONObject.optString("funnelTrack"), jSONObject.optString("optionTag"));
        return "";
    }

    public String setConsent(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String strOptString = jSONObject.optString("providerName");
        try {
            jSONObject2 = new JSONObject(jSONObject.optString("settings"));
        } catch (Exception unused) {
            jSONObject2 = new JSONObject();
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObject2.optString(next));
        }
        com.hive.Analytics.setConsent(strOptString, map);
        return "";
    }

    public String getConsent(String str, JSONObject jSONObject) {
        Map<String, String> consent = com.hive.Analytics.getConsent(jSONObject.optString("providerName"));
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        try {
            for (String str2 : consent.keySet()) {
                jSONObject2.put(str2, consent.get(str2));
            }
            jSONObjectCreateResponse.put("settings", jSONObject2.toString());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String showConsentModeIfRequire(final String str, final JSONObject jSONObject) {
        com.hive.Analytics.showConsentModeIfRequire(jSONObject.optBoolean("checkCmp"), Analytics.ConsentMode.INSTANCE.fromJson(jSONObject.optJSONObject("consentMode")), new Analytics.ConsentModeListener() { // from class: com.hive.plugin.Analytics.1
            @Override // com.hive.Analytics.ConsentModeListener
            public void onConsentModeDismissed(ResultAPI resultAPI, List<Analytics.ConsentMode.ConsentStatus> list) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                try {
                    Iterator<Analytics.ConsentMode.ConsentStatus> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJson());
                    }
                    jSONObjectCreateResponse.put("statusList", jSONArray);
                } catch (Exception unused) {
                }
                Analytics.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String showConsentMode(final String str, final JSONObject jSONObject) {
        com.hive.Analytics.showConsentMode(Analytics.ConsentMode.INSTANCE.fromJson(jSONObject.optJSONObject("consentMode")), new Analytics.ConsentModeListener() { // from class: com.hive.plugin.Analytics.2
            @Override // com.hive.Analytics.ConsentModeListener
            public void onConsentModeDismissed(ResultAPI resultAPI, List<Analytics.ConsentMode.ConsentStatus> list) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                try {
                    Iterator<Analytics.ConsentMode.ConsentStatus> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJson());
                    }
                    jSONObjectCreateResponse.put("statusList", jSONArray);
                } catch (Exception unused) {
                }
                Analytics.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }
}
