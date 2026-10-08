package com.hive.plugin;

import com.hive.HiveActivity;
import com.hive.PlatformHelper;
import com.hive.ResultAPI;
import com.hive.platformhelper.PlatformShare;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class PlatformHelper {
    private ICallEngine callEngine;

    public PlatformHelper(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String share(final String str, final JSONObject jSONObject) {
        String[] strArr;
        int iOptInt = jSONObject.optInt(PlatformShare.SHARE_TYPE);
        String strOptString = jSONObject.optString(PlatformShare.DATA_SUBJECT);
        String strOptString2 = jSONObject.optString(PlatformShare.DATA_TEXT);
        new JSONArray();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(PlatformShare.DATA_MEDIA);
            strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
            }
        } catch (JSONException unused) {
            strArr = new String[0];
        }
        PlatformShare platformShare = new PlatformShare();
        platformShare.setShareType(iOptInt);
        platformShare.setSubject(strOptString);
        platformShare.setText(strOptString2);
        platformShare.setMedia(strArr);
        com.hive.PlatformHelper platformHelper = com.hive.PlatformHelper.INSTANCE;
        com.hive.PlatformHelper.share(platformShare, new PlatformHelper.PlatformHelperListener() { // from class: com.hive.plugin.PlatformHelper.1
            @Override // com.hive.PlatformHelper.PlatformHelperListener
            public void onShare(Boolean bool) {
                ResultAPI resultAPI;
                if (bool.booleanValue()) {
                    resultAPI = new ResultAPI();
                } else {
                    resultAPI = new ResultAPI(-99, ResultAPI.Code.CommonUnknown, "");
                }
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("isSuccess", bool);
                } catch (Exception unused2) {
                }
                PlatformHelper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String requestUserPermissions(final String str, final JSONObject jSONObject) {
        new JSONArray();
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("requests");
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        } catch (Exception unused) {
        }
        com.hive.PlatformHelper platformHelper = com.hive.PlatformHelper.INSTANCE;
        com.hive.PlatformHelper.requestUserPermissions(arrayList, new PlatformHelper.RequestUserPermissionsListener() { // from class: com.hive.plugin.PlatformHelper.2
            @Override // com.hive.PlatformHelper.RequestUserPermissionsListener
            public void onRequestUserPermissions(ResultAPI resultAPI, List<String> list, List<String> list2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next());
                    }
                    jSONObjectCreateResponse.put(com.hive.Analytics.CONSENT_GRANTED, jSONArray2);
                    JSONArray jSONArray3 = new JSONArray();
                    Iterator<String> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        jSONArray3.put(it2.next());
                    }
                    jSONObjectCreateResponse.put(com.hive.Analytics.CONSENT_DENIED, jSONArray3);
                } catch (Exception unused2) {
                }
                PlatformHelper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public void completeUpdate(String str, JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("completeState");
        com.hive.PlatformHelper platformHelper = com.hive.PlatformHelper.INSTANCE;
        com.hive.PlatformHelper.completeUpdate(iOptInt);
    }

    public String showInAppBrowser(final String str, final JSONObject jSONObject) {
        PlatformHelper.InAppBrowserParam inAppBrowserParamCreateFromJson = PlatformHelper.InAppBrowserParam.INSTANCE.createFromJson(jSONObject.optString("param"));
        if (inAppBrowserParamCreateFromJson != null) {
            com.hive.PlatformHelper.showInAppBrowser(inAppBrowserParamCreateFromJson, new PlatformHelper.InAppBrowserListener() { // from class: com.hive.plugin.PlatformHelper$$ExternalSyntheticLambda1
                @Override // com.hive.PlatformHelper.InAppBrowserListener
                public final void onInAppBrowser(ResultAPI resultAPI) {
                    this.f$0.m5565lambda$showInAppBrowser$0$comhivepluginPlatformHelper(jSONObject, str, resultAPI);
                }
            });
            return "";
        }
        return "";
    }

    /* JADX INFO: renamed from: lambda$showInAppBrowser$0$com-hive-plugin-PlatformHelper, reason: not valid java name */
    /* synthetic */ void m5565lambda$showInAppBrowser$0$comhivepluginPlatformHelper(JSONObject jSONObject, String str, ResultAPI resultAPI) {
        this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
    }

    public String showInAppWebView(final String str, final JSONObject jSONObject) {
        PlatformHelper.InAppWebViewParam inAppWebViewParamCreateFromJson = PlatformHelper.InAppWebViewParam.INSTANCE.createFromJson(jSONObject.optString("param"));
        if (inAppWebViewParamCreateFromJson != null) {
            com.hive.PlatformHelper.showInAppWebView(inAppWebViewParamCreateFromJson, new PlatformHelper.InAppWebViewListener() { // from class: com.hive.plugin.PlatformHelper$$ExternalSyntheticLambda2
                @Override // com.hive.PlatformHelper.InAppWebViewListener
                public final void onInAppWebView(ResultAPI resultAPI) {
                    this.f$0.m5566lambda$showInAppWebView$1$comhivepluginPlatformHelper(jSONObject, str, resultAPI);
                }
            });
            return "";
        }
        return "";
    }

    /* JADX INFO: renamed from: lambda$showInAppWebView$1$com-hive-plugin-PlatformHelper, reason: not valid java name */
    /* synthetic */ void m5566lambda$showInAppWebView$1$comhivepluginPlatformHelper(JSONObject jSONObject, String str, ResultAPI resultAPI) {
        this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
    }

    public String getLaunchParameters(final String str, final JSONObject jSONObject) {
        com.hive.PlatformHelper.getLaunchParameters(new PlatformHelper.PlatformHelperParametersListener() { // from class: com.hive.plugin.PlatformHelper$$ExternalSyntheticLambda0
            @Override // com.hive.PlatformHelper.PlatformHelperParametersListener
            public final void onParameters(ResultAPI resultAPI, String str2) {
                this.f$0.m5564lambda$getLaunchParameters$2$comhivepluginPlatformHelper(jSONObject, str, resultAPI, str2);
            }
        });
        return "";
    }

    /* JADX INFO: renamed from: lambda$getLaunchParameters$2$com-hive-plugin-PlatformHelper, reason: not valid java name */
    /* synthetic */ void m5564lambda$getLaunchParameters$2$comhivepluginPlatformHelper(JSONObject jSONObject, String str, ResultAPI resultAPI, String str2) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
        try {
            jSONObjectCreateResponse.put("parameters", str2);
        } catch (Exception unused) {
        }
        this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
    }

    public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
        HiveActivity hiveActivity = HiveActivity.INSTANCE;
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger logger = com.hive.Logger.INSTANCE;
            com.hive.Logger.e("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.PlatformHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if ("share".equals(str)) {
                    PlatformHelper.this.share(str2, jSONObject);
                    return;
                }
                if ("requestUserPermissions".equals(str)) {
                    PlatformHelper.this.requestUserPermissions(str2, jSONObject);
                    return;
                }
                if ("completeUpdate".equals(str)) {
                    PlatformHelper.this.completeUpdate(str2, jSONObject);
                    return;
                }
                if ("showInAppBrowser".equals(str)) {
                    PlatformHelper.this.showInAppBrowser(str2, jSONObject);
                } else if ("showInAppWebView".equals(str)) {
                    PlatformHelper.this.showInAppWebView(str2, jSONObject);
                } else if ("getLaunchParameters".equals(str)) {
                    PlatformHelper.this.getLaunchParameters(str2, jSONObject);
                }
            }
        });
        return "";
    }
}
