package com.hive.plugin;

import com.adjust.sdk.Constants;
import com.hive.Configuration;
import com.hive.Permission;
import com.hive.ResultAPI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Configuration {
    private final ICallEngine callEngine;

    public Configuration(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String getConfiguration(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                Map<String, Object> configuration = com.hive.Configuration.getConfiguration();
                jSONObject3.put("hiveSDKVersion", com.hive.Configuration.getHiveSDKVersion());
                jSONObject3.put("appId", configuration.get("appId"));
                jSONObject3.put("serverId", configuration.get("serverId"));
                jSONObject3.put("zone", configuration.get("zone"));
                jSONObject3.put("useLog", configuration.get("useLog"));
                jSONObject3.put("useAgeGateU13", configuration.get("useAgeGateU13"));
                jSONObject3.put("gameLanguage", configuration.get("gameLanguage"));
                jSONObject3.put("permissions", configuration.get("permissions"));
                jSONObject3.put("company", configuration.get("company"));
                jSONObject3.put("channel", configuration.get("channel"));
                jSONObject3.put("market", configuration.get("market"));
                jSONObject3.put("httpConnectTimeout", configuration.get("httpConnectTimeout"));
                jSONObject3.put("httpReadTimeout", configuration.get("httpReadTimeout"));
                jSONObject3.put("maxGameLogSize", configuration.get("maxGameLogSize"));
                jSONObject3.put(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH, configuration.get(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH));
                jSONObject3.put("systemUI", configuration.get("systemUI"));
                jSONObject2 = jSONObjectCreateResponse;
                try {
                    jSONObject2.put("getConfiguration", jSONObject3);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                jSONObject2 = jSONObjectCreateResponse;
            }
        } catch (Exception unused3) {
            jSONObject2 = jSONObjectCreateResponse;
        }
        return jSONObject2.toString();
    }

    public String getHiveSDKVersion(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getHiveSDKVersion", com.hive.Configuration.getHiveSDKVersion());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getReferenceSDKVersion(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getReferenceSDKVersion", com.hive.Configuration.getReferenceSDKVersion());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getAppId(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getAppId", com.hive.Configuration.getAppId());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setAppId(String str, JSONObject jSONObject) {
        com.hive.Configuration.setAppId(jSONObject.optString("setAppId"));
        return "";
    }

    public String getZone(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getZone", com.hive.Configuration.getZone().name());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setZone(String str, JSONObject jSONObject) {
        com.hive.Configuration.setZone(Configuration.ZoneType.valueOf(jSONObject.optString("setZone").toUpperCase(Locale.US)));
        return "";
    }

    public String getServerId(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getServerId", com.hive.Configuration.getServerId());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setServerId(String str, JSONObject jSONObject) {
        com.hive.Configuration.setServerId(jSONObject.optString("setServerId"));
        return "";
    }

    public String updateServerId(String str, JSONObject jSONObject) {
        com.hive.Configuration.updateServerId(jSONObject.optString("updateServerId"));
        return "";
    }

    public String getGameLanguage(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getGameLanguage", com.hive.Configuration.getGameLanguage());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setGameLanguage(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("setGameLanguage");
        JSONObject jSONObject2 = new JSONObject();
        try {
            com.hive.Configuration.setGameLanguage(strOptString);
            jSONObject2.put("setGameLanguage", strOptString);
        } catch (Exception unused) {
        }
        return jSONObject2.toString();
    }

    public String updateGameLanguage(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("updateGameLanguage");
        JSONObject jSONObject2 = new JSONObject();
        try {
            com.hive.Configuration.updateGameLanguage(strOptString);
            jSONObject2.put("updateGameLanguage", strOptString);
        } catch (Exception unused) {
        }
        return jSONObject2.toString();
    }

    public String getUseLog(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getUseLog", Boolean.valueOf(com.hive.Configuration.getUseLog()));
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setUseLog(String str, JSONObject jSONObject) {
        com.hive.Configuration.setUseLog(jSONObject.optBoolean("setUseLog"));
        return "";
    }

    public String getAgeGateU13(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getAgeGateU13", Boolean.valueOf(com.hive.Configuration.getAgeGateU13()));
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setAgeGateU13(String str, JSONObject jSONObject) {
        com.hive.Configuration.setAgeGateU13(jSONObject.optBoolean("setAgeGateU13"));
        return "";
    }

    public String getAgeGateU16Agree(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getAgeGateU16Agree", Boolean.valueOf(com.hive.Configuration.getAgeGateU16Agree()));
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getLegalGuardianConsentAgree(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getLegalGuardianConsentAgree", Boolean.valueOf(com.hive.Configuration.getLegalGuardianConsentAgree()));
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getPermissions(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            Map<Configuration.HIVEPermissionType, Object> permissions = com.hive.Configuration.getPermissions();
            JSONObject jSONObject2 = new JSONObject();
            for (Configuration.HIVEPermissionType hIVEPermissionType : permissions.keySet()) {
                jSONObject2.put(hIVEPermissionType.toString(), (Boolean) permissions.get(hIVEPermissionType));
            }
            jSONObjectCreateResponse.put("getPermissions", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setPermissions(String str, JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("setPermissions"));
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(Configuration.HIVEPermissionType.valueOf(next), Boolean.valueOf(jSONObject2.getBoolean(next)));
            }
        } catch (JSONException unused) {
        }
        com.hive.Configuration.setPermissions(map);
        return "";
    }

    public String getCompany(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getCompany", com.hive.Configuration.getCompany());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setCompany(String str, JSONObject jSONObject) {
        com.hive.Configuration.setCompany(jSONObject.optString("setCompany"));
        return "";
    }

    public String getHttpConnectTimeout(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getHttpConnectTimeout", com.hive.Configuration.getHttpConnectTimeout());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setHttpConnectTimeout(String str, JSONObject jSONObject) {
        com.hive.Configuration.setHttpConnectTimeout(jSONObject.optInt("setHttpConnectTimeout"));
        return "";
    }

    public String getHttpReadTimeout(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getHttpReadTimeout", com.hive.Configuration.getHttpReadTimeout());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setHttpReadTimeout(String str, JSONObject jSONObject) {
        com.hive.Configuration.setHttpReadTimeout(jSONObject.optInt("setHttpReadTimeout"));
        return "";
    }

    public String getMaxGameLogSize(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getMaxGameLogSize", com.hive.Configuration.getMaxGameLogSize());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setMaxGameLogSize(String str, JSONObject jSONObject) {
        com.hive.Configuration.setMaxGameLogSize(jSONObject.optInt("setMaxGameLogSize"));
        return "";
    }

    public String getHiveCountry(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getHiveCountry", com.hive.Configuration.getHiveCountry());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getChannel(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getChannel", com.hive.Configuration.getChannel());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setChannel(String str, JSONObject jSONObject) {
        com.hive.Configuration.setChannel(jSONObject.optString("setChannel"));
        return "";
    }

    public String getMarket(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getMarket", com.hive.Configuration.getMarket());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setMarket(String str, JSONObject jSONObject) {
        com.hive.Configuration.setMarket(jSONObject.optString("setMarket"));
        return "";
    }

    public String getHiveTimeZone(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getHiveTimeZone", com.hive.Configuration.getHiveTimeZone());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getQQAppId(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getQQAppId", com.hive.Configuration.getQqAppId());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getSystemUI(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getSystemUI", com.hive.Configuration.getSystemUI());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setSystemUI(String str, JSONObject jSONObject) {
        com.hive.Configuration.setSystemUI(jSONObject.optInt("setSystemUI"));
        return "";
    }

    public String getAnalyticsSendLimit(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getAnalyticsSendLimit", com.hive.Configuration.getAnalyticsSendLimit());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setAnalyticsSendLimit(String str, JSONObject jSONObject) {
        com.hive.Configuration.setAnalyticsSendLimit(jSONObject.optInt("setAnalyticsSendLimit"));
        return "";
    }

    public String getAnalyticsQueueLimit(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getAnalyticsQueueLimit", com.hive.Configuration.getAnalyticsQueueLimit());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setAnalyticsQueueLimit(String str, JSONObject jSONObject) {
        com.hive.Configuration.setAnalyticsQueueLimit(jSONObject.optInt("setAnalyticsQueueLimit"));
        return "";
    }

    public String getAnalyticsSendCycleSeconds(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getAnalyticsSendCycleSeconds", com.hive.Configuration.getAnalyticsSendCycleSeconds());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setAnalyticsSendCycleSeconds(String str, JSONObject jSONObject) {
        com.hive.Configuration.setAnalyticsSendCycleSeconds((float) jSONObject.optDouble("setAnalyticsSendCycleSeconds", 0.0d));
        return "";
    }

    public String setHivePermissionViewOn(String str, JSONObject jSONObject) {
        com.hive.Configuration.setHivePermissionViewOn(jSONObject.optBoolean("isOn"));
        return "";
    }

    public String getPermissionViewData(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        String strOptString = jSONObject.optString("language", "failed");
        Configuration.HiveLanguage hiveLanguage = Configuration.HiveLanguage.LanguageEN;
        Configuration.HiveLanguage[] hiveLanguageArrValues = Configuration.HiveLanguage.values();
        int length = hiveLanguageArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Configuration.HiveLanguage hiveLanguage2 = hiveLanguageArrValues[i];
            if (hiveLanguage2.getValue().equals(strOptString)) {
                hiveLanguage = hiveLanguage2;
                break;
            }
            if (strOptString.equals("id")) {
                hiveLanguage = Configuration.HiveLanguage.LanguageIN;
                break;
            }
            i++;
        }
        Permission.PermissionViewData permissionViewData = com.hive.Configuration.getPermissionViewData(hiveLanguage);
        JSONObject jSONObject2 = new JSONObject();
        if (permissionViewData != null) {
            try {
                jSONObject2.put("contents", permissionViewData.getContents());
                JSONArray jSONArray = new JSONArray();
                for (Permission.PermissionViewUnitData permissionViewUnitData : permissionViewData.getPermissions()) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("contents", permissionViewUnitData.getContents());
                    jSONObject3.put("nativePermissionName", permissionViewUnitData.getNativePermissionName());
                    jSONObject3.put("permissionCategory", permissionViewUnitData.getPermissionCategory().getId());
                    jSONObject3.put("title", permissionViewUnitData.getTitle());
                    jSONArray.put(jSONObject3);
                }
                jSONObject2.put("permissions", jSONArray);
                JSONArray jSONArray2 = new JSONArray();
                for (Permission.PermissionViewUnitData permissionViewUnitData2 : permissionViewData.getCommons()) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("contents", permissionViewUnitData2.getContents());
                    jSONObject4.put("nativePermissionName", permissionViewUnitData2.getNativePermissionName());
                    jSONObject4.put("permissionCategory", permissionViewUnitData2.getPermissionCategory().getId());
                    jSONObject4.put("title", permissionViewUnitData2.getTitle());
                    jSONArray2.put(jSONObject4);
                }
                jSONObject2.put("commons", jSONArray2);
                jSONObjectCreateResponse.put("data", jSONObject2);
            } catch (Exception unused) {
            }
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getHiveCertificationKey(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getHiveCertificationKey", com.hive.Configuration.getHiveCertificationKey());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setHiveCertificationKey(String str, JSONObject jSONObject) {
        com.hive.Configuration.setHiveCertificationKey(jSONObject.optString("appKey"));
        return "";
    }

    public String setHiveTheme(String str, JSONObject jSONObject) {
        com.hive.Configuration.setHiveTheme(Configuration.HiveTheme.INSTANCE.getEnum(jSONObject.optString("hiveThemeType")));
        return "";
    }

    public String getHiveTheme(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("hiveThemeType", com.hive.Configuration.getHiveTheme().name());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setCrossPromotionBannerShowing(String str, JSONObject jSONObject) {
        com.hive.Configuration.setCrossPromotionBannerShowing(jSONObject.optBoolean("setCrossPromotionBannerShowing"));
        return "";
    }

    public String getCrossPromotionBannerShowing(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getCrossPromotionBannerShowing", Boolean.valueOf(com.hive.Configuration.getCrossPromotionBannerShowing()));
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setConfigurations(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("configType");
        try {
            com.hive.Configuration.setConfigurations(Configuration.HiveConfigType.valueOf(strOptString), jSONObject.optString("value"));
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String setHiveOrientation(String str, JSONObject jSONObject) {
        com.hive.Configuration.setHiveOrientation(jSONObject.optString("hiveOrientation"));
        return "";
    }

    public String getMetaData(final String str, final JSONObject jSONObject) {
        com.hive.Configuration.getMetaData(jSONObject.optString("key"), jSONObject.optBoolean("forceReload", false), new Configuration.GetMetaDataListener() { // from class: com.hive.plugin.Configuration.1
            @Override // com.hive.Configuration.GetMetaDataListener
            public void onGetMetaData(ResultAPI resultAPI, String str2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("value", str2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Configuration.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String setHiveCommunityUrl(String str, JSONObject jSONObject) {
        com.hive.Configuration.setHiveCommunityUrl(jSONObject.optString("hiveCommunityUrl"));
        return "";
    }

    public String setUseHercules(String str, JSONObject jSONObject) {
        boolean zOptBoolean = jSONObject.optBoolean("enable", true);
        Boolean.valueOf(zOptBoolean).getClass();
        com.hive.Configuration.setUseHercules(zOptBoolean);
        return "";
    }

    public String getChatConnectionTimeout(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getChatConnectionTimeout", com.hive.Configuration.getChatConnectionTimeout());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setChatConnectionTimeout(String str, JSONObject jSONObject) {
        com.hive.Configuration.setChatConnectionTimeout(jSONObject.optInt("setChatConnectionTimeout"));
        return "";
    }

    public String setUseGoogleCredentialSignIn(String str, JSONObject jSONObject) {
        com.hive.Configuration.setUseGoogleCredentialSignIn(jSONObject.optBoolean("useGoogleCredentialSignIn"));
        return "";
    }

    public String getUseGoogleCredentialSignIn(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("useGoogleCredentialSignIn", Boolean.valueOf(com.hive.Configuration.getUseGoogleCredentialSignIn()));
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String setTestZone(String str, JSONObject jSONObject) {
        com.hive.Configuration.setTestZone();
        return "";
    }

    public String isTestZone(String str, JSONObject jSONObject) {
        boolean zIsTestZone = com.hive.Configuration.isTestZone();
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("isTestZone", zIsTestZone);
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }
}
