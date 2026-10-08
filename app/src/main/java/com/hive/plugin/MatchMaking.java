package com.hive.plugin;

import com.hive.HiveActivity;
import com.hive.MatchMaking;
import com.hive.ResultAPI;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class MatchMaking {
    private final ICallEngine callEngine;

    public MatchMaking(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String requestMatchMaking(final String str, final JSONObject jSONObject) {
        com.hive.MatchMaking.requestMatchMaking(jSONObject.optInt("matchId", 0), jSONObject.optInt("point", 0), jSONObject.optString("extraData"), new MatchMaking.MatchMakingDataListener() { // from class: com.hive.plugin.MatchMaking.1
            @Override // com.hive.MatchMaking.MatchMakingDataListener
            public void onMatchMakingData(ResultAPI resultAPI, MatchMaking.MatchMakingData matchMakingData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("matchMakingData", matchMakingData.toJson());
                } catch (Exception unused) {
                }
                MatchMaking.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getRequestingStatus(final String str, final JSONObject jSONObject) {
        com.hive.MatchMaking.getRequestingStatus(jSONObject.optInt("matchId", 0), new MatchMaking.MatchMakingDataListener() { // from class: com.hive.plugin.MatchMaking.2
            @Override // com.hive.MatchMaking.MatchMakingDataListener
            public void onMatchMakingData(ResultAPI resultAPI, MatchMaking.MatchMakingData matchMakingData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("matchMakingData", matchMakingData.toJson());
                } catch (Exception unused) {
                }
                MatchMaking.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String deleteRequesting(final String str, final JSONObject jSONObject) {
        com.hive.MatchMaking.deleteRequesting(jSONObject.optInt("matchId", 0), new MatchMaking.MatchMakingResultListener() { // from class: com.hive.plugin.MatchMaking.3
            @Override // com.hive.MatchMaking.MatchMakingResultListener
            public void onMatchMakingResult(ResultAPI resultAPI) {
                MatchMaking.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String createGroup(final String str, final JSONObject jSONObject) {
        com.hive.MatchMaking.createGroup(jSONObject.optInt("matchId", 0), jSONObject.optInt("point", 0), jSONObject.optString("extraData"), new MatchMaking.MatchMakingGroupDataListener() { // from class: com.hive.plugin.MatchMaking.4
            @Override // com.hive.MatchMaking.MatchMakingGroupDataListener
            public void onMatchMakingGroupData(ResultAPI resultAPI, MatchMaking.MatchMakingGroupData matchMakingGroupData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("matchMakingGroupData", matchMakingGroupData.toJson());
                } catch (Exception unused) {
                }
                MatchMaking.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String joinGroup(final String str, final JSONObject jSONObject) {
        com.hive.MatchMaking.joinGroup(jSONObject.optInt("matchId", 0), jSONObject.optString("groupCode"), jSONObject.optInt("point", 0), jSONObject.optString("extraData"), new MatchMaking.MatchMakingGroupDataListener() { // from class: com.hive.plugin.MatchMaking.5
            @Override // com.hive.MatchMaking.MatchMakingGroupDataListener
            public void onMatchMakingGroupData(ResultAPI resultAPI, MatchMaking.MatchMakingGroupData matchMakingGroupData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("matchMakingGroupData", matchMakingGroupData.toJson());
                } catch (Exception unused) {
                }
                MatchMaking.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String leaveGroup(final String str, final JSONObject jSONObject) {
        com.hive.MatchMaking.leaveGroup(jSONObject.optInt("matchId", 0), new MatchMaking.MatchMakingResultListener() { // from class: com.hive.plugin.MatchMaking.6
            @Override // com.hive.MatchMaking.MatchMakingResultListener
            public void onMatchMakingResult(ResultAPI resultAPI) {
                MatchMaking.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String kickGroupUser(final String str, final JSONObject jSONObject) {
        com.hive.MatchMaking.kickGroupUser(jSONObject.optInt("matchId", 0), jSONObject.optLong("targetPlayerId"), new MatchMaking.MatchMakingGroupDataListener() { // from class: com.hive.plugin.MatchMaking.7
            @Override // com.hive.MatchMaking.MatchMakingGroupDataListener
            public void onMatchMakingGroupData(ResultAPI resultAPI, MatchMaking.MatchMakingGroupData matchMakingGroupData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("matchMakingGroupData", matchMakingGroupData.toJson());
                } catch (Exception unused) {
                }
                MatchMaking.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getGroupInfoByUser(final String str, final JSONObject jSONObject) {
        com.hive.MatchMaking.getGroupInfoByUser(jSONObject.optInt("matchId", 0), new MatchMaking.MatchMakingGroupDataListener() { // from class: com.hive.plugin.MatchMaking.8
            @Override // com.hive.MatchMaking.MatchMakingGroupDataListener
            public void onMatchMakingGroupData(ResultAPI resultAPI, MatchMaking.MatchMakingGroupData matchMakingGroupData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("matchMakingGroupData", matchMakingGroupData.toJson());
                } catch (Exception unused) {
                }
                MatchMaking.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getGroupInfoByGroupCode(final String str, final JSONObject jSONObject) {
        com.hive.MatchMaking.getGroupInfoByGroupCode(jSONObject.optString("groupCode"), new MatchMaking.MatchMakingGroupDataListener() { // from class: com.hive.plugin.MatchMaking.9
            @Override // com.hive.MatchMaking.MatchMakingGroupDataListener
            public void onMatchMakingGroupData(ResultAPI resultAPI, MatchMaking.MatchMakingGroupData matchMakingGroupData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("matchMakingGroupData", matchMakingGroupData.toJson());
                } catch (Exception unused) {
                }
                MatchMaking.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String updateGroupUser(final String str, final JSONObject jSONObject) {
        com.hive.MatchMaking.updateGroupUser(jSONObject.optInt("matchId", 0), jSONObject.optBoolean("ready"), jSONObject.optInt("point", 0), jSONObject.optString("extraData"), new MatchMaking.MatchMakingGroupDataListener() { // from class: com.hive.plugin.MatchMaking.10
            @Override // com.hive.MatchMaking.MatchMakingGroupDataListener
            public void onMatchMakingGroupData(ResultAPI resultAPI, MatchMaking.MatchMakingGroupData matchMakingGroupData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("matchMakingGroupData", matchMakingGroupData.toJson());
                } catch (Exception unused) {
                }
                MatchMaking.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String requestGroupMatching(final String str, final JSONObject jSONObject) {
        com.hive.MatchMaking.requestGroupMatching(jSONObject.optInt("matchId", 0), new MatchMaking.MatchMakingGroupDataListener() { // from class: com.hive.plugin.MatchMaking.11
            @Override // com.hive.MatchMaking.MatchMakingGroupDataListener
            public void onMatchMakingGroupData(ResultAPI resultAPI, MatchMaking.MatchMakingGroupData matchMakingGroupData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("matchMakingGroupData", matchMakingGroupData.toJson());
                } catch (Exception unused) {
                }
                MatchMaking.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String deleteGroupMatching(final String str, final JSONObject jSONObject) {
        com.hive.MatchMaking.deleteGroupMatching(jSONObject.optInt("matchId", 0), new MatchMaking.MatchMakingGroupDataListener() { // from class: com.hive.plugin.MatchMaking.12
            @Override // com.hive.MatchMaking.MatchMakingGroupDataListener
            public void onMatchMakingGroupData(ResultAPI resultAPI, MatchMaking.MatchMakingGroupData matchMakingGroupData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("matchMakingGroupData", matchMakingGroupData.toJson());
                } catch (Exception unused) {
                }
                MatchMaking.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger logger = com.hive.Logger.INSTANCE;
            com.hive.Logger.e("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.MatchMaking.13
            @Override // java.lang.Runnable
            public void run() {
                if ("requestMatchMaking".equals(str)) {
                    MatchMaking.this.requestMatchMaking(str2, jSONObject);
                    return;
                }
                if ("getRequestingStatus".equals(str)) {
                    MatchMaking.this.getRequestingStatus(str2, jSONObject);
                    return;
                }
                if ("deleteRequesting".equals(str)) {
                    MatchMaking.this.deleteRequesting(str2, jSONObject);
                    return;
                }
                if ("createGroup".equals(str)) {
                    MatchMaking.this.createGroup(str2, jSONObject);
                    return;
                }
                if ("joinGroup".equals(str)) {
                    MatchMaking.this.joinGroup(str2, jSONObject);
                    return;
                }
                if ("leaveGroup".equals(str)) {
                    MatchMaking.this.leaveGroup(str2, jSONObject);
                    return;
                }
                if ("kickGroupUser".equals(str)) {
                    MatchMaking.this.kickGroupUser(str2, jSONObject);
                    return;
                }
                if ("getGroupInfoByUser".equals(str)) {
                    MatchMaking.this.getGroupInfoByUser(str2, jSONObject);
                    return;
                }
                if ("getGroupInfoByGroupCode".equals(str)) {
                    MatchMaking.this.getGroupInfoByGroupCode(str2, jSONObject);
                    return;
                }
                if ("updateGroupUser".equals(str)) {
                    MatchMaking.this.updateGroupUser(str2, jSONObject);
                } else if ("requestGroupMatching".equals(str)) {
                    MatchMaking.this.requestGroupMatching(str2, jSONObject);
                } else if ("deleteGroupMatching".equals(str)) {
                    MatchMaking.this.deleteGroupMatching(str2, jSONObject);
                }
            }
        });
        return "";
    }
}
