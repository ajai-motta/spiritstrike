package com.hive.plugin;

import android.text.TextUtils;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.SocialHive;
import com.hive.base.Android;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SocialHive {
    private ICallEngine callEngine;

    public SocialHive(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String getMyProfile(final String str, final JSONObject jSONObject) {
        com.hive.SocialHive.INSTANCE.getMyProfile(new SocialHive.ProfileListener() { // from class: com.hive.plugin.SocialHive.1
            @Override // com.hive.SocialHive.ProfileListener
            public void onProfile(ResultAPI resultAPI, ArrayList<SocialHive.ProfileHive> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                if (arrayList != null) {
                    Iterator<SocialHive.ProfileHive> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJSON());
                    }
                }
                try {
                    jSONObjectCreateResponse.put("profileList", jSONArray);
                } catch (JSONException unused) {
                }
                SocialHive.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String setMyProfile(final String str, final JSONObject jSONObject) {
        com.hive.SocialHive.INSTANCE.setMyProfile(jSONObject.optString("comment"), new SocialHive.ProfileListener() { // from class: com.hive.plugin.SocialHive.2
            @Override // com.hive.SocialHive.ProfileListener
            public void onProfile(ResultAPI resultAPI, ArrayList<SocialHive.ProfileHive> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                if (arrayList != null) {
                    Iterator<SocialHive.ProfileHive> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJSON());
                    }
                }
                try {
                    jSONObjectCreateResponse.put("profileList", jSONArray);
                } catch (JSONException unused) {
                }
                SocialHive.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getProfiles(final String str, final JSONObject jSONObject) {
        new JSONArray();
        String[] strArr = null;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("vidList");
            strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
            }
        } catch (JSONException unused) {
        }
        com.hive.SocialHive.INSTANCE.getProfiles(strArr, new SocialHive.ProfileListener() { // from class: com.hive.plugin.SocialHive.3
            @Override // com.hive.SocialHive.ProfileListener
            public void onProfile(ResultAPI resultAPI, ArrayList<SocialHive.ProfileHive> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray2 = new JSONArray();
                if (arrayList != null) {
                    Iterator<SocialHive.ProfileHive> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next().toJSON());
                    }
                }
                try {
                    jSONObjectCreateResponse.put("profileList", jSONArray2);
                } catch (JSONException unused2) {
                }
                SocialHive.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getFriends(final String str, final JSONObject jSONObject) {
        com.hive.SocialHive.INSTANCE.getFriends(SocialHive.FriendType.valueOf(jSONObject.optString("friendType").toUpperCase(Locale.US)), new SocialHive.ProfileListener() { // from class: com.hive.plugin.SocialHive.4
            @Override // com.hive.SocialHive.ProfileListener
            public void onProfile(ResultAPI resultAPI, ArrayList<SocialHive.ProfileHive> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                if (arrayList != null) {
                    Iterator<SocialHive.ProfileHive> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJSON());
                    }
                }
                try {
                    jSONObjectCreateResponse.put("profileList", jSONArray);
                } catch (JSONException unused) {
                }
                SocialHive.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String sendMessage(final String str, final JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("messageContent");
        com.hive.SocialHive.INSTANCE.sendMessage(jSONObjectOptJSONObject != null ? (SocialHive.MessageContent) Android.INSTANCE.fromJSON(jSONObjectOptJSONObject, SocialHive.MessageContent.class) : null, new SocialHive.SendMessageListener() { // from class: com.hive.plugin.SocialHive.5
            @Override // com.hive.SocialHive.SendMessageListener
            public void onSendMessage(ResultAPI resultAPI) {
                SocialHive.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String sendInvitationMessage(final String str, final JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("inviteContents");
        com.hive.SocialHive.INSTANCE.sendInvitationMessage(jSONObjectOptJSONObject != null ? (SocialHive.MessageContent) Android.INSTANCE.fromJSON(jSONObjectOptJSONObject, SocialHive.MessageContent.class) : null, new SocialHive.SendMessageListener() { // from class: com.hive.plugin.SocialHive.6
            @Override // com.hive.SocialHive.SendMessageListener
            public void onSendMessage(ResultAPI resultAPI) {
                SocialHive.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String showHiveDialog(final String str, final JSONObject jSONObject) {
        SocialHive.HiveDialogType hiveDialogTypeValueOf = SocialHive.HiveDialogType.valueOf(jSONObject.optString("hiveDialogType").toUpperCase(Locale.US));
        String strOptString = jSONObject.optString("vid");
        String strOptString2 = jSONObject.optString("additionalInfo");
        SocialHive.ShowHiveDialogListener showHiveDialogListener = new SocialHive.ShowHiveDialogListener() { // from class: com.hive.plugin.SocialHive.7
            @Override // com.hive.SocialHive.ShowHiveDialogListener
            public void onShowHiveDialog(ResultAPI resultAPI) {
                SocialHive.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        };
        if (TextUtils.isEmpty(strOptString2)) {
            com.hive.SocialHive.INSTANCE.showHiveDialog(hiveDialogTypeValueOf, strOptString, showHiveDialogListener);
            return "";
        }
        com.hive.SocialHive.INSTANCE.showHiveDialog(hiveDialogTypeValueOf, strOptString, strOptString2, showHiveDialogListener);
        return "";
    }

    public String getBadgeInfo(final String str, final JSONObject jSONObject) {
        com.hive.SocialHive.INSTANCE.getBadgeInfo(new SocialHive.SocialBadgeListener() { // from class: com.hive.plugin.SocialHive.8
            @Override // com.hive.SocialHive.SocialBadgeListener
            public void onSocialBadge(ResultAPI resultAPI, SocialHive.SocialBadge socialBadge) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                if (socialBadge != null) {
                    try {
                        jSONObjectCreateResponse.put("socialBadge", socialBadge.toJSON());
                    } catch (JSONException unused) {
                    }
                }
                SocialHive.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
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
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.SocialHive.9
            @Override // java.lang.Runnable
            public void run() {
                if ("getMyProfile".equals(str)) {
                    SocialHive.this.getMyProfile(str2, jSONObject);
                    return;
                }
                if ("setMyProfile".equals(str)) {
                    SocialHive.this.setMyProfile(str2, jSONObject);
                    return;
                }
                if ("getProfiles".equals(str)) {
                    SocialHive.this.getProfiles(str2, jSONObject);
                    return;
                }
                if ("getFriends".equals(str)) {
                    SocialHive.this.getFriends(str2, jSONObject);
                    return;
                }
                if ("sendMessage".equals(str)) {
                    SocialHive.this.sendMessage(str2, jSONObject);
                    return;
                }
                if ("sendInvitationMessage".equals(str)) {
                    SocialHive.this.sendInvitationMessage(str2, jSONObject);
                } else if ("showHiveDialog".equals(str)) {
                    SocialHive.this.showHiveDialog(str2, jSONObject);
                } else if ("getBadgeInfo".equals(str)) {
                    SocialHive.this.getBadgeInfo(str2, jSONObject);
                }
            }
        });
        return "";
    }
}
