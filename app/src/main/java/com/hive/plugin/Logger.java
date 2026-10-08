package com.hive.plugin;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.hive.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Logger {
    private ICallEngine callEngine;

    public Logger(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String log(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString(ViewHierarchyConstants.TAG_KEY);
        String strOptString2 = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
        com.hive.Logger logger = com.hive.Logger.INSTANCE;
        com.hive.Logger.v(strOptString, strOptString2);
        Log.v(strOptString, strOptString2);
        return "";
    }

    public String d(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString(ViewHierarchyConstants.TAG_KEY);
        String strOptString2 = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
        com.hive.Logger logger = com.hive.Logger.INSTANCE;
        com.hive.Logger.d(strOptString, strOptString2);
        Log.d(strOptString, strOptString2);
        return "";
    }

    public String i(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString(ViewHierarchyConstants.TAG_KEY);
        String strOptString2 = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
        com.hive.Logger logger = com.hive.Logger.INSTANCE;
        com.hive.Logger.i(strOptString, strOptString2);
        Log.i(strOptString, strOptString2);
        return "";
    }

    public String w(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString(ViewHierarchyConstants.TAG_KEY);
        String strOptString2 = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
        com.hive.Logger logger = com.hive.Logger.INSTANCE;
        com.hive.Logger.w(strOptString, strOptString2);
        Log.w(strOptString, strOptString2);
        return "";
    }

    public String e(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString(ViewHierarchyConstants.TAG_KEY);
        String strOptString2 = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
        com.hive.Logger logger = com.hive.Logger.INSTANCE;
        com.hive.Logger.e(strOptString, strOptString2);
        Log.e(strOptString, strOptString2);
        return "";
    }

    public String setLogFilter(String str, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("logFilter");
        if (jSONObjectOptJSONObject != null) {
            try {
                Logger.LogType logTypeValueOf = Logger.LogType.valueOf(jSONObjectOptJSONObject.getString("coreLog"));
                Logger.LogType logTypeValueOf2 = Logger.LogType.valueOf(jSONObjectOptJSONObject.getString("serviceLog"));
                Logger.LogFilter logFilter = new Logger.LogFilter();
                logFilter.setCoreLog(logTypeValueOf);
                logFilter.setServiceLog(logTypeValueOf2);
                com.hive.Logger.setLogFilter(logFilter);
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }

    public String getLogFilter(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        com.hive.Logger logger = com.hive.Logger.INSTANCE;
        Logger.LogFilter logFilter = com.hive.Logger.getLogFilter();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("coreLog", logFilter.getCoreLog().name());
            jSONObject2.put("serviceLog", logFilter.getServiceLog().name());
            jSONObjectCreateResponse.put("logFilter", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }
}
