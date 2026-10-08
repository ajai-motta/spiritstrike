package com.hive.plugin;

import com.hive.HiveActivity;
import com.hive.Push;
import com.hive.ResultAPI;
import com.hive.base.Android;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Push {
    private ICallEngine callEngine;

    public Push(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String registerLocalPush(final String str, final JSONObject jSONObject) {
        Push.LocalPush localPush = new Push.LocalPush();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("localPush");
        if (jSONObjectOptJSONObject != null) {
            try {
                localPush.setData(jSONObjectOptJSONObject);
            } catch (Exception unused) {
            }
        }
        com.hive.Push push = com.hive.Push.INSTANCE;
        com.hive.Push.registerLocalPush(localPush, new Push.LocalPushListener() { // from class: com.hive.plugin.Push.1
            @Override // com.hive.Push.LocalPushListener
            public void onRegisterLocalPush(ResultAPI resultAPI, Push.LocalPush localPush2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                if (localPush2 != null) {
                    try {
                        jSONObjectCreateResponse.put("localPush", localPush2.toJSON());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Push.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String unregisterLocalPush(String str, JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("noticeID");
        Integer numValueOf = Integer.valueOf(iOptInt);
        com.hive.Push push = com.hive.Push.INSTANCE;
        numValueOf.getClass();
        com.hive.Push.unregisterLocalPush(iOptInt);
        return "";
    }

    public String unregisterLocalPushes(String str, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("noticeIDs");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
            }
        }
        com.hive.Push push = com.hive.Push.INSTANCE;
        com.hive.Push.unregisterLocalPushes(arrayList);
        return "";
    }

    public String unregisterAllLocalPushes(String str, JSONObject jSONObject) {
        com.hive.Push push = com.hive.Push.INSTANCE;
        com.hive.Push.unregisterAllLocalPushes();
        return "";
    }

    public String requestPushPermission(String str, JSONObject jSONObject) {
        com.hive.Push push = com.hive.Push.INSTANCE;
        com.hive.Push.requestPushPermission();
        return "";
    }

    public String getRemotePush(final String str, final JSONObject jSONObject) {
        com.hive.Push push = com.hive.Push.INSTANCE;
        com.hive.Push.getRemotePush(new Push.RemotePushListener() { // from class: com.hive.plugin.Push.2
            @Override // com.hive.Push.RemotePushListener
            public void onPushToken(ResultAPI resultAPI, Push.RemotePush remotePush) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                if (remotePush != null) {
                    try {
                        jSONObjectCreateResponse.put("remotePush", remotePush.toJSON());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Push.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String setRemotePush(final String str, final JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("remotePush");
        Push.RemotePush remotePush = jSONObjectOptJSONObject != null ? (Push.RemotePush) Android.INSTANCE.fromJSON(jSONObjectOptJSONObject, Push.RemotePush.class) : null;
        com.hive.Push push = com.hive.Push.INSTANCE;
        com.hive.Push.setRemotePush(remotePush, new Push.RemotePushListener() { // from class: com.hive.plugin.Push.3
            @Override // com.hive.Push.RemotePushListener
            public void onPushToken(ResultAPI resultAPI, Push.RemotePush remotePush2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                if (remotePush2 != null) {
                    try {
                        jSONObjectCreateResponse.put("remotePush", remotePush2.toJSON());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Push.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String setForegroundPush(final String str, final JSONObject jSONObject) {
        Push.PushSetting pushSetting;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("pushSetting");
        if (jSONObjectOptJSONObject != null) {
            try {
                pushSetting = new Push.PushSetting(jSONObjectOptJSONObject.getBoolean("useForegroundRemotePush"), jSONObjectOptJSONObject.getBoolean("useForegroundLocalPush"));
            } catch (JSONException e) {
                e.printStackTrace();
                pushSetting = null;
            }
        } else {
            pushSetting = null;
        }
        com.hive.Push push = com.hive.Push.INSTANCE;
        com.hive.Push.setForegroundPush(pushSetting, new Push.PushSettingListener() { // from class: com.hive.plugin.Push.4
            @Override // com.hive.Push.PushSettingListener
            public void onPushSetting(ResultAPI resultAPI, Push.PushSetting pushSetting2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                if (pushSetting2 != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("useForegroundRemotePush", pushSetting2.getIsRemotePushEnabledWhileRunning());
                        jSONObject2.put("useForegroundLocalPush", pushSetting2.getIsLocalPushEnabledWhileRunning());
                        jSONObjectCreateResponse.put("pushSetting", jSONObject2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                Push.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getForegroundPush(final String str, final JSONObject jSONObject) {
        com.hive.Push push = com.hive.Push.INSTANCE;
        com.hive.Push.getForegroundPush(new Push.PushSettingListener() { // from class: com.hive.plugin.Push.5
            @Override // com.hive.Push.PushSettingListener
            public void onPushSetting(ResultAPI resultAPI, Push.PushSetting pushSetting) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                if (pushSetting != null) {
                    try {
                        jSONObject2.put("useForegroundRemotePush", pushSetting.getIsRemotePushEnabledWhileRunning());
                        jSONObject2.put("useForegroundLocalPush", pushSetting.getIsLocalPushEnabledWhileRunning());
                        jSONObjectCreateResponse.put("pushSetting", jSONObject2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Push.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
        HiveActivity hiveActivity = HiveActivity.INSTANCE;
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger logger = com.hive.Logger.INSTANCE;
            com.hive.Logger.d("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.Push.6
            @Override // java.lang.Runnable
            public void run() {
                if ("registerLocalPush".equals(str)) {
                    Push.this.registerLocalPush(str2, jSONObject);
                    return;
                }
                if ("unregisterLocalPush".equals(str)) {
                    Push.this.unregisterLocalPush(str2, jSONObject);
                    return;
                }
                if ("unregisterLocalPushes".equals(str)) {
                    Push.this.unregisterLocalPushes(str2, jSONObject);
                    return;
                }
                if ("unregisterAllLocalPushes".equals(str)) {
                    Push.this.unregisterAllLocalPushes(str2, jSONObject);
                    return;
                }
                if ("requestPushPermission".equals(str)) {
                    Push.this.requestPushPermission(str2, jSONObject);
                    return;
                }
                if ("getRemotePush".equals(str)) {
                    Push.this.getRemotePush(str2, jSONObject);
                    return;
                }
                if ("setRemotePush".equals(str)) {
                    Push.this.setRemotePush(str2, jSONObject);
                } else if ("setForegroundPush".equals(str)) {
                    Push.this.setForegroundPush(str2, jSONObject);
                } else if ("getForegroundPush".equals(str)) {
                    Push.this.getForegroundPush(str2, jSONObject);
                }
            }
        });
        return "";
    }
}
