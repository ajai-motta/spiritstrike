package com.hive.plugin;

import android.text.TextUtils;
import com.hive.DataStore;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class DataStore {
    private final ICallEngine callEngine;

    public DataStore(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String set(final String str, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        String strOptString = jSONObject.optString("key");
        String strOptString2 = jSONObject.optString("value");
        String strOptString3 = jSONObject.optString("data");
        if (TextUtils.isEmpty(strOptString3)) {
            com.hive.DataStore dataStore = com.hive.DataStore.INSTANCE;
            com.hive.DataStore.set(strOptString, strOptString2, new DataStore.DataStoreSetListener() { // from class: com.hive.plugin.DataStore.1
                @Override // com.hive.DataStore.DataStoreSetListener
                public void onDataStoreSet(ResultAPI resultAPI) {
                    DataStore.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
                }
            });
            return "";
        }
        try {
            jSONObject2 = new JSONObject(strOptString3);
        } catch (Exception unused) {
            jSONObject2 = new JSONObject();
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObject2.optString(next));
        }
        com.hive.DataStore dataStore2 = com.hive.DataStore.INSTANCE;
        com.hive.DataStore.set(map, new DataStore.DataStoreSetListener() { // from class: com.hive.plugin.DataStore.2
            @Override // com.hive.DataStore.DataStoreSetListener
            public void onDataStoreSet(ResultAPI resultAPI) {
                DataStore.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String get(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("key");
        com.hive.DataStore dataStore = com.hive.DataStore.INSTANCE;
        com.hive.DataStore.get(strOptString, new DataStore.DataStoreGetListener() { // from class: com.hive.plugin.DataStore.3
            @Override // com.hive.DataStore.DataStoreGetListener
            public void onDataStoreGet(ResultAPI resultAPI, String str2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                if (str2 != null) {
                    try {
                        jSONObjectCreateResponse.put("data", str2);
                    } catch (Exception unused) {
                    }
                }
                DataStore.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getMyData(final String str, final JSONObject jSONObject) {
        com.hive.DataStore dataStore = com.hive.DataStore.INSTANCE;
        com.hive.DataStore.getMyData(new DataStore.DataStoreMyDataListener() { // from class: com.hive.plugin.DataStore.4
            @Override // com.hive.DataStore.DataStoreMyDataListener
            public void onDataStoreMyData(ResultAPI resultAPI, Map<String, String> map) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    for (String str2 : map.keySet()) {
                        jSONObject2.put(str2, map.get(str2));
                    }
                    jSONObjectCreateResponse.put("myData", jSONObject2.toString());
                } catch (Exception unused) {
                }
                DataStore.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getUsersData(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("key");
        com.hive.DataStore dataStore = com.hive.DataStore.INSTANCE;
        com.hive.DataStore.getUsersData(strOptString, new DataStore.DataStoreUsersDataListener() { // from class: com.hive.plugin.DataStore.5
            @Override // com.hive.DataStore.DataStoreUsersDataListener
            public void onDataStoreUsersData(ResultAPI resultAPI, String str2, Map<Long, String> map) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObjectCreateResponse.put("key", str2);
                    for (Long l : map.keySet()) {
                        jSONObject2.put(l.toString(), map.get(l));
                    }
                    jSONObjectCreateResponse.put("usersData", jSONObject2.toString());
                } catch (Exception unused) {
                }
                DataStore.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
        HiveActivity hiveActivity = HiveActivity.INSTANCE;
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger logger = com.hive.Logger.INSTANCE;
            com.hive.Logger.e("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.DataStore.6
            @Override // java.lang.Runnable
            public void run() {
                if ("set".equals(str)) {
                    DataStore.this.set(str2, jSONObject);
                    return;
                }
                if ("get".equals(str)) {
                    DataStore.this.get(str2, jSONObject);
                } else if ("getMyData".equals(str)) {
                    DataStore.this.getMyData(str2, jSONObject);
                } else if ("getUsersData".equals(str)) {
                    DataStore.this.getUsersData(str2, jSONObject);
                }
            }
        });
        return "";
    }
}
