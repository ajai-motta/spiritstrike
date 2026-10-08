package com.hive.plugin;

import android.text.TextUtils;
import android.util.Base64;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.HiveActivity;
import com.hive.ProviderGoogle;
import com.hive.ResultAPI;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ProviderGoogle {
    private ICallEngine callEngine;

    public ProviderGoogle(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String achievementsReveal(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("achievementId");
        if (TextUtils.isEmpty(jSONObject.optString("handler"))) {
            com.hive.ProviderGoogle providerGoogle = com.hive.ProviderGoogle.INSTANCE;
            com.hive.ProviderGoogle.achievementsReveal(strOptString);
            return "";
        }
        com.hive.ProviderGoogle providerGoogle2 = com.hive.ProviderGoogle.INSTANCE;
        com.hive.ProviderGoogle.achievementsReveal(strOptString, new ProviderGoogle.GoogleAchievementsListener() { // from class: com.hive.plugin.ProviderGoogle.1
            @Override // com.hive.ProviderGoogle.GoogleAchievementsListener
            public void onAchievementsResult(ResultAPI resultAPI) {
                ProviderGoogle.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String achievementsUnlock(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("achievementId");
        if (TextUtils.isEmpty(jSONObject.optString("handler"))) {
            com.hive.ProviderGoogle providerGoogle = com.hive.ProviderGoogle.INSTANCE;
            com.hive.ProviderGoogle.achievementsUnlock(strOptString);
            return "";
        }
        com.hive.ProviderGoogle providerGoogle2 = com.hive.ProviderGoogle.INSTANCE;
        com.hive.ProviderGoogle.achievementsUnlock(strOptString, new ProviderGoogle.GoogleAchievementsListener() { // from class: com.hive.plugin.ProviderGoogle.2
            @Override // com.hive.ProviderGoogle.GoogleAchievementsListener
            public void onAchievementsResult(ResultAPI resultAPI) {
                ProviderGoogle.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String achievementsIncrement(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("incrementalAchievementId");
        int iOptInt = jSONObject.optInt("value");
        if (TextUtils.isEmpty(jSONObject.optString("handler"))) {
            com.hive.ProviderGoogle providerGoogle = com.hive.ProviderGoogle.INSTANCE;
            com.hive.ProviderGoogle.achievementsIncrement(strOptString, iOptInt);
            return "";
        }
        com.hive.ProviderGoogle providerGoogle2 = com.hive.ProviderGoogle.INSTANCE;
        com.hive.ProviderGoogle.achievementsIncrement(strOptString, iOptInt, new ProviderGoogle.GoogleAchievementsListener() { // from class: com.hive.plugin.ProviderGoogle.3
            @Override // com.hive.ProviderGoogle.GoogleAchievementsListener
            public void onAchievementsResult(ResultAPI resultAPI) {
                ProviderGoogle.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String showAchievements(final String str, final JSONObject jSONObject) {
        com.hive.ProviderGoogle providerGoogle = com.hive.ProviderGoogle.INSTANCE;
        com.hive.ProviderGoogle.showAchievements(new ProviderGoogle.GoogleAchievementsListener() { // from class: com.hive.plugin.ProviderGoogle.4
            @Override // com.hive.ProviderGoogle.GoogleAchievementsListener
            public void onAchievementsResult(ResultAPI resultAPI) {
                ProviderGoogle.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String leaderboardsSubmitScore(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("leaderboardId");
        long jOptLong = jSONObject.optLong(FirebaseAnalytics.Param.SCORE);
        Long lValueOf = Long.valueOf(jOptLong);
        if (TextUtils.isEmpty(jSONObject.optString("handler"))) {
            com.hive.ProviderGoogle providerGoogle = com.hive.ProviderGoogle.INSTANCE;
            lValueOf.getClass();
            com.hive.ProviderGoogle.leaderboardsSubmitScore(strOptString, jOptLong);
            return "";
        }
        com.hive.ProviderGoogle providerGoogle2 = com.hive.ProviderGoogle.INSTANCE;
        lValueOf.getClass();
        com.hive.ProviderGoogle.leaderboardsSubmitScore(strOptString, jOptLong, new ProviderGoogle.GoogleLeaderboardsListener() { // from class: com.hive.plugin.ProviderGoogle.5
            @Override // com.hive.ProviderGoogle.GoogleLeaderboardsListener
            public void onLeaderboardsResult(ResultAPI resultAPI) {
                ProviderGoogle.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String showLeaderboards(final String str, final JSONObject jSONObject) {
        com.hive.ProviderGoogle providerGoogle = com.hive.ProviderGoogle.INSTANCE;
        com.hive.ProviderGoogle.showLeaderboards(new ProviderGoogle.GoogleLeaderboardsListener() { // from class: com.hive.plugin.ProviderGoogle.6
            @Override // com.hive.ProviderGoogle.GoogleLeaderboardsListener
            public void onLeaderboardsResult(ResultAPI resultAPI) {
                ProviderGoogle.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String getGooglePlayerId(final String str, final JSONObject jSONObject) {
        try {
            com.hive.ProviderGoogle providerGoogle = com.hive.ProviderGoogle.INSTANCE;
            com.hive.ProviderGoogle.getGooglePlayerId(new ProviderGoogle.GooglePlayerIdListener() { // from class: com.hive.plugin.ProviderGoogle.7
                @Override // com.hive.ProviderGoogle.GooglePlayerIdListener
                public void onPlayerIdResult(ResultAPI resultAPI, String str2, String str3) {
                    JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                    try {
                        jSONObjectCreateResponse.put("googlePlayerId", ProviderGoogle.this.getBase64encode(str2));
                        jSONObjectCreateResponse.put("authCode", ProviderGoogle.this.getBase64encode(str3));
                    } catch (Exception unused) {
                    }
                    ProviderGoogle.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                }
            });
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getBase64encode(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (Exception unused) {
            return "";
        }
    }

    public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
        if ("achievementsReveal".equals(str)) {
            return achievementsReveal(str2, jSONObject);
        }
        if ("achievementsUnlock".equals(str)) {
            return achievementsUnlock(str2, jSONObject);
        }
        if ("achievementsIncrement".equals(str)) {
            return achievementsIncrement(str2, jSONObject);
        }
        if ("leaderboardsSubmitScore".equals(str)) {
            return leaderboardsSubmitScore(str2, jSONObject);
        }
        HiveActivity hiveActivity = HiveActivity.INSTANCE;
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger logger = com.hive.Logger.INSTANCE;
            com.hive.Logger.e("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.ProviderGoogle.8
            @Override // java.lang.Runnable
            public void run() {
                if ("showAchievements".equals(str)) {
                    ProviderGoogle.this.showAchievements(str2, jSONObject);
                } else if ("showLeaderboards".equals(str)) {
                    ProviderGoogle.this.showLeaderboards(str2, jSONObject);
                } else if ("getGooglePlayerId".equals(str)) {
                    ProviderGoogle.this.getGooglePlayerId(str2, jSONObject);
                }
            }
        });
        return "";
    }
}
