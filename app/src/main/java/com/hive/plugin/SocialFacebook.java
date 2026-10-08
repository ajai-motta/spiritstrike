package com.hive.plugin;

import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.SocialFacebook;
import com.hive.base.Android;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SocialFacebook {
    private ICallEngine callEngine;

    public SocialFacebook(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String getMyProfile(final String str, final JSONObject jSONObject) {
        com.hive.SocialFacebook.getMyProfile(new SocialFacebook.ProfileListener() { // from class: com.hive.plugin.SocialFacebook.1
            @Override // com.hive.SocialFacebook.ProfileListener
            public void onProfile(ResultAPI resultAPI, List<SocialFacebook.ProfileFacebook> list) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                if (list != null) {
                    Iterator<SocialFacebook.ProfileFacebook> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJSON());
                    }
                }
                try {
                    jSONObjectCreateResponse.put("profileList", jSONArray);
                } catch (JSONException unused) {
                }
                SocialFacebook.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getFriends(final String str, final JSONObject jSONObject) {
        com.hive.SocialFacebook.getFriends(new SocialFacebook.ProfileListener() { // from class: com.hive.plugin.SocialFacebook.2
            @Override // com.hive.SocialFacebook.ProfileListener
            public void onProfile(ResultAPI resultAPI, List<SocialFacebook.ProfileFacebook> list) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                if (list != null) {
                    Iterator<SocialFacebook.ProfileFacebook> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJSON());
                    }
                }
                try {
                    jSONObjectCreateResponse.put("profileList", jSONArray);
                } catch (JSONException unused) {
                }
                SocialFacebook.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String sendMessageFacebook(final String str, final JSONObject jSONObject) {
        com.hive.SocialFacebook.sendMessageFacebook((SocialFacebook.SocialFacebookMessage) Android.INSTANCE.fromJSON(jSONObject.optJSONObject("messageContents"), SocialFacebook.SocialFacebookMessage.class), new SocialFacebook.SendMessageFacebookListener() { // from class: com.hive.plugin.SocialFacebook.3
            @Override // com.hive.SocialFacebook.SendMessageFacebookListener
            public void onSendMessageFacebook(ResultAPI resultAPI) {
                SocialFacebook.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String showInvitationDialog(final String str, final JSONObject jSONObject) {
        com.hive.SocialFacebook.showInvitationDialog((SocialFacebook.SocialFacebookMessage) Android.INSTANCE.fromJSON(jSONObject.optJSONObject("inviteContents"), SocialFacebook.SocialFacebookMessage.class), new SocialFacebook.ShowInvitationDialogListener() { // from class: com.hive.plugin.SocialFacebook.4
            @Override // com.hive.SocialFacebook.ShowInvitationDialogListener
            public void onShowInvitationDialog(ResultAPI resultAPI, List<String> list) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                }
                try {
                    jSONObjectCreateResponse.put("invitedUserList", jSONArray);
                } catch (JSONException unused) {
                }
                SocialFacebook.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String postFacebookWithContentURL(final String str, final JSONObject jSONObject) {
        com.hive.SocialFacebook.postFacebookWithContentURL(jSONObject.optString("contentURL"), new SocialFacebook.PostFacebookListener() { // from class: com.hive.plugin.SocialFacebook.5
            @Override // com.hive.SocialFacebook.PostFacebookListener
            public void onPostFacebook(ResultAPI resultAPI) {
                SocialFacebook.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String isLogin(String str, JSONObject jSONObject) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("isLogin", com.hive.SocialFacebook.isLogin());
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
        if ("isLogin".equals(str)) {
            return isLogin(str2, jSONObject);
        }
        HiveActivity hiveActivity = HiveActivity.INSTANCE;
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger logger = com.hive.Logger.INSTANCE;
            com.hive.Logger.d("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.SocialFacebook.6
            @Override // java.lang.Runnable
            public void run() {
                if ("getMyProfile".equals(str)) {
                    SocialFacebook.this.getMyProfile(str2, jSONObject);
                    return;
                }
                if ("getFriends".equals(str)) {
                    SocialFacebook.this.getFriends(str2, jSONObject);
                    return;
                }
                if ("sendMessageFacebook".equals(str)) {
                    SocialFacebook.this.sendMessageFacebook(str2, jSONObject);
                } else if ("showInvitationDialog".equals(str)) {
                    SocialFacebook.this.showInvitationDialog(str2, jSONObject);
                } else if ("postFacebookWithContentURL".equals(str)) {
                    SocialFacebook.this.postFacebookWithContentURL(str2, jSONObject);
                }
            }
        });
        return "";
    }
}
