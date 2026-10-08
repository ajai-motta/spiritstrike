package com.hive.social;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.AccessToken;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.WebDialog;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.Sharer;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.GameRequestDialog;
import com.facebook.share.widget.ShareDialog;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.SocialFacebook;
import com.hive.SocialHive;
import com.hive.auth.AuthImpl;
import com.hive.base.Android;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Configuration;
import com.hive.logger.LoggerImpl;
import com.hive.social.SocialKeys;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SocialFacebookImpl {
    public static final String SERVICE_NAME = "facebook";
    private static final String TAG = "SocialFacebookImpl";
    private static final SocialFacebookImpl socialFacebookImpl = new SocialFacebookImpl();
    private CallbackManager callbackManager;
    private AccessToken currentAccessToken;

    public static SocialFacebookImpl getInstance() {
        return socialFacebookImpl;
    }

    private SocialFacebookImpl() {
        facebookSdkInitialize();
    }

    public List<String> getPermissions() {
        JSONArray jSONArray;
        ArrayList arrayList = new ArrayList(Arrays.asList("public_profile", "email"));
        if (getFacebookPermissions() != null && !getFacebookPermissions().isEmpty()) {
            arrayList.addAll(getFacebookPermissions());
        }
        try {
            JSONObject jSONObjectOptJSONObject = ConfigurationImpl.INSTANCE.getProviderFromHiveConfig("facebook").optJSONObject("permissions");
            if (jSONObjectOptJSONObject != null) {
                if (jSONObjectOptJSONObject.optJSONArray("permission") != null) {
                    jSONArray = jSONObjectOptJSONObject.optJSONArray("permission");
                } else if (jSONObjectOptJSONObject.optJSONObject("permission") != null) {
                    jSONArray = new JSONArray().put(jSONObjectOptJSONObject.optJSONObject("permission"));
                } else {
                    jSONArray = new JSONArray();
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList2.add(jSONArray.getJSONObject(i).optString("@name"));
                    }
                    arrayList.addAll(arrayList2);
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public void setPermissions(List<String> list) {
        Configuration.INSTANCE.setFacebookPermissionList(list);
    }

    private List<String> getFacebookPermissions() {
        return Configuration.INSTANCE.getFacebookPermissionList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasPermission(List<String> list, String str) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int getMyProfile(final SocialFacebook.ProfileListener profileListener) {
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            LoggerImpl.INSTANCE.i("SocialFacebookImpl getMyProfile, not initialized");
            if (profileListener == null) {
                return -9;
            }
            profileListener.onProfile(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""), null);
            return -9;
        }
        if (isConnected()) {
            LoggerImpl.INSTANCE.i("SocialFacebookImpl getMyProfile, isConnected true");
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id,email,name,picture{url}");
            final GraphRequest graphRequest = new GraphRequest(this.currentAccessToken, "/me", bundle, HttpMethod.GET, new GraphRequest.Callback() { // from class: com.hive.social.SocialFacebookImpl.1
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    ResultAPI resultAPI;
                    ArrayList arrayList;
                    if (graphResponse.getError() == null) {
                        SocialFacebook.ProfileFacebook profileFacebook = new SocialFacebook.ProfileFacebook();
                        JSONObject graphObject = graphResponse.getGraphObject();
                        profileFacebook.uid = graphObject.optString("id");
                        profileFacebook.email = graphObject.optString("email");
                        profileFacebook.username = graphObject.optString("name");
                        try {
                            profileFacebook.profileImageUrl = graphObject.getJSONObject("picture").getJSONObject("data").getString("url");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            profileFacebook.profileImageUrl = "";
                        }
                        arrayList = new ArrayList();
                        arrayList.add(profileFacebook);
                        resultAPI = new ResultAPI();
                    } else {
                        FacebookException exception = graphResponse.getError().getException();
                        if (exception != null) {
                            resultAPI = SocialFacebookImpl.this.exceptionToResultAPI(exception);
                        } else {
                            resultAPI = new ResultAPI(-1, ResultAPI.Code.AuthV4FacebookInvalidResponseData, graphResponse.getRawResponse());
                        }
                        arrayList = null;
                    }
                    profileListener.onProfile(resultAPI, arrayList);
                }
            });
            Android.INSTANCE.runOnMainThread(new Runnable() { // from class: com.hive.social.SocialFacebookImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    graphRequest.executeAsync();
                }
            });
            return 0;
        }
        LoggerImpl.INSTANCE.i("SocialFacebookImpl getMyProfile, isConnected false");
        connect(new FacebookCallback<LoginResult>() { // from class: com.hive.social.SocialFacebookImpl.3
            @Override // com.facebook.FacebookCallback
            public void onSuccess(LoginResult loginResult) {
                LoggerImpl.INSTANCE.i("Facebook getMyProfile(LoginResult)-onSuccess(result:" + loginResult + ")");
                loginResult.getAccessToken();
                SocialFacebookImpl.this.getMyProfile(profileListener);
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                LoggerImpl.INSTANCE.i("Facebook getMyProfile(LoginResult)-onCancel");
                profileListener.onProfile(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelGetProfile, "Login is canceled!"), null);
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                LoggerImpl.INSTANCE.i("Facebook getMyProfile(LoginResult)-onError(FacebookException:" + facebookException + ")");
                profileListener.onProfile(new ResultAPI(-99, ResultAPI.Code.SocialFacebookResponseFailGetProfile, "Login failed! : " + facebookException.getMessage()), null);
            }
        });
        return 0;
    }

    public int requestUserTokenWithResponseCallback(final SocialFacebook.SocialRequestListener socialRequestListener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            getMyProfile(new SocialFacebook.ProfileListener() { // from class: com.hive.social.SocialFacebookImpl.4
                @Override // com.hive.SocialFacebook.ProfileListener
                public void onProfile(ResultAPI resultAPI, List<SocialFacebook.ProfileFacebook> list) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                        jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_TOKEN);
                        if (resultAPI.isSuccess()) {
                            jSONObject.put("token", SocialFacebookImpl.this.getAccessToken());
                            jSONObject.put(PangleConstants.APP_ID, SocialFacebookImpl.this.getApplicationId());
                            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                        } else {
                            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    socialRequestListener.onComplete(new ResultAPI(0, ResultAPI.Code.Success, ""), jSONObject.toString());
                }
            });
            return 0;
        }
        if (socialRequestListener == null) {
            return -9;
        }
        socialRequestListener.onComplete(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""), null);
        return -9;
    }

    public void requestInvitationList(final SocialFacebook.SocialRequestListener socialRequestListener) {
        Android.INSTANCE.runOnMainThread(new Runnable() { // from class: com.hive.social.SocialFacebookImpl.5
            @Override // java.lang.Runnable
            public void run() {
                new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/invitable_friends", null, HttpMethod.GET, new GraphRequest.Callback() { // from class: com.hive.social.SocialFacebookImpl.5.1
                    @Override // com.facebook.GraphRequest.Callback
                    public void onCompleted(GraphResponse graphResponse) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (graphResponse.getError() != null) {
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                                jSONObject.put("error_msg", graphResponse.getError().getErrorMessage());
                            } else {
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                                jSONObject.put("users", SocialFacebookImpl.this.usersFromResponse(graphResponse));
                            }
                            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_INVITATION_LIST);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        socialRequestListener.onComplete(new ResultAPI(0, ResultAPI.Code.Success, ""), jSONObject.toString());
                    }
                });
            }
        });
    }

    public int setFacebookPermissions(JSONObject jSONObject, SocialFacebook.SocialRequestListener socialRequestListener) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                if (jSONObject.has("permissions")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("permissions");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (!TextUtils.isEmpty(jSONArray.getString(i))) {
                            arrayList.add(jSONArray.getString(i));
                        }
                    }
                    if (arrayList.size() > 0) {
                        LoggerImpl.INSTANCE.i("SocialFacebookImpl setFacebookPermissions, set permissions (" + arrayList.toString() + ")");
                        AuthImpl.INSTANCE.setFacebookPermission(arrayList);
                        jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                    } else {
                        LoggerImpl.INSTANCE.i("SocialFacebookImpl setFacebookPermissions, permissionsList is empty");
                        jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_INVALID_JSON);
                        jSONObject2.put("error_msg", "invalid data");
                    }
                } else {
                    LoggerImpl.INSTANCE.i("SocialFacebookImpl setFacebookPermissions, invalid json input");
                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_INVALID_JSON);
                    jSONObject2.put("error_msg", "invalid data");
                }
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("SocialFacebookImpl setFacebookPermissions, exception_1 : " + e.toString());
            }
        } else {
            try {
                LoggerImpl.INSTANCE.i("SocialFacebookImpl setFacebookPermissions, json input is null");
                jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_INVALID_JSON);
                jSONObject2.put("error_msg", "invalid data");
            } catch (Exception e2) {
                LoggerImpl.INSTANCE.w("SocialFacebookImpl setFacebookPermissions, exception_2 : " + e2.toString());
            }
        }
        socialRequestListener.onComplete(new ResultAPI(0, ResultAPI.Code.Success, ""), jSONObject2.toString());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray usersFromResponse(GraphResponse graphResponse) {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        try {
            JSONArray jSONArray = graphResponse.getGraphObject().getJSONArray("data");
            int length = jSONArray.length();
            arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                try {
                    arrayList.add(userFromResult(jSONArray.getJSONObject(i)));
                } catch (JSONException e) {
                    e = e;
                    arrayList2 = arrayList;
                    e.printStackTrace();
                    arrayList = arrayList2;
                    return new JSONArray((Collection) arrayList);
                }
            }
        } catch (JSONException e2) {
            e = e2;
        }
        return new JSONArray((Collection) arrayList);
    }

    private JSONObject userFromResult(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("uid", jSONObject.get("uid"));
            jSONObject2.put("id", jSONObject.get("id"));
            jSONObject2.put("name", jSONObject.get("name"));
            jSONObject2.put("picture", jSONObject.getJSONObject("picture").getJSONObject("data").getString("url"));
            jSONObject2.put(UserDataStore.COUNTRY, JSONObject.NULL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject2;
    }

    public int getFriends(final SocialFacebook.ProfileListener profileListener) {
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            if (profileListener == null) {
                return -9;
            }
            profileListener.onProfile(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""), null);
            return -9;
        }
        if (isConnected()) {
            if (!AccessToken.getCurrentAccessToken().getPermissions().contains(AuthenticationTokenClaims.JSON_KEY_USER_FRIENDS)) {
                LoggerImpl.INSTANCE.i("SocialFacebookImpl getFriends, not included user_friends permission");
                profileListener.onProfile(new ResultAPI(-6, ResultAPI.Code.SocialFacebookResponseFailGetFriends, ""), new ArrayList());
                return 0;
            }
            LoggerImpl.INSTANCE.i("SocialFacebookImpl getFriends, included user_friends permission");
            final GraphRequest graphRequestNewMyFriendsRequest = GraphRequest.newMyFriendsRequest(this.currentAccessToken, new GraphRequest.GraphJSONArrayCallback() { // from class: com.hive.social.SocialFacebookImpl.6
                @Override // com.facebook.GraphRequest.GraphJSONArrayCallback
                public void onCompleted(JSONArray jSONArray, GraphResponse graphResponse) {
                    ArrayList arrayList;
                    ResultAPI resultAPI;
                    if (graphResponse.getError() == null) {
                        arrayList = new ArrayList();
                        while (true) {
                            int length = jSONArray.length();
                            for (int i = 0; i < length; i++) {
                                SocialFacebook.ProfileFacebook profileFacebook = new SocialFacebook.ProfileFacebook();
                                profileFacebook.uid = jSONArray.optJSONObject(i).optString("id");
                                arrayList.add(profileFacebook);
                            }
                            GraphRequest requestForPagedResults = graphResponse.getRequestForPagedResults(GraphResponse.PagingDirection.NEXT);
                            if (requestForPagedResults == null) {
                                break;
                            } else {
                                requestForPagedResults.executeAndWait();
                            }
                        }
                        resultAPI = new ResultAPI();
                    } else {
                        FacebookException exception = graphResponse.getError().getException();
                        arrayList = null;
                        if (exception != null) {
                            resultAPI = SocialFacebookImpl.this.exceptionToResultAPI(exception);
                        } else {
                            resultAPI = new ResultAPI(-1, ResultAPI.Code.SocialFacebookResponseFailGetFriends, graphResponse.getRawResponse());
                        }
                    }
                    profileListener.onProfile(resultAPI, arrayList);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id");
            bundle.putString("limit", "5000");
            graphRequestNewMyFriendsRequest.setParameters(bundle);
            Android.INSTANCE.runOnMainThread(new Runnable() { // from class: com.hive.social.SocialFacebookImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    graphRequestNewMyFriendsRequest.executeAsync();
                }
            });
        } else {
            connect(new FacebookCallback<LoginResult>() { // from class: com.hive.social.SocialFacebookImpl.8
                @Override // com.facebook.FacebookCallback
                public void onSuccess(LoginResult loginResult) {
                    LoggerImpl.INSTANCE.i("Facebook getFriends(LoginResult)-onSuccess(result:" + loginResult + ")");
                    if (loginResult.getAccessToken() != null) {
                        SocialFacebookImpl.this.getFriends(profileListener);
                    }
                }

                @Override // com.facebook.FacebookCallback
                public void onCancel() {
                    LoggerImpl.INSTANCE.i("Facebook getFriends(LoginResult)-onCancel");
                    profileListener.onProfile(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelGetFriends, "Login is canceled!"), null);
                }

                @Override // com.facebook.FacebookCallback
                public void onError(FacebookException facebookException) {
                    LoggerImpl.INSTANCE.i("Facebook getFriends(LoginResult)-onError(FacebookException:" + facebookException + ")");
                    profileListener.onProfile(new ResultAPI(-99, ResultAPI.Code.SocialFacebookResponseFailGetFriends, "Login failed! : " + facebookException.getMessage()), null);
                }
            });
        }
        return 0;
    }

    public void sendMessageFacebook(final SocialFacebook.SocialFacebookMessage socialFacebookMessage, final SocialFacebook.SendMessageFacebookListener sendMessageFacebookListener) {
        if (!AuthImpl.INSTANCE.isInitialize()) {
            if (sendMessageFacebookListener != null) {
                sendMessageFacebookListener.onSendMessageFacebook(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""));
            }
        } else if (isConnected()) {
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.social.SocialFacebookImpl.9
                private boolean isInProgress = true;
                private GameRequestDialog requestDialog;

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(final Activity activity, Bundle bundle) {
                    super.onCreate(activity, bundle);
                    this.requestDialog = new GameRequestDialog(activity);
                    GameRequestContent.Filters filters = GameRequestContent.Filters.APP_USERS;
                    GameRequestContent.Builder data = new GameRequestContent.Builder().setMessage(socialFacebookMessage.message).setTitle(socialFacebookMessage.dialogTitle).setData(socialFacebookMessage.data);
                    if (socialFacebookMessage.recipients != null && socialFacebookMessage.recipients.length > 0) {
                        data.setRecipients(Arrays.asList(socialFacebookMessage.recipients));
                    } else {
                        data.setFilters(filters);
                    }
                    GameRequestContent gameRequestContentBuild = data.build();
                    this.requestDialog.registerCallback(SocialFacebookImpl.this.callbackManager, new FacebookCallback<GameRequestDialog.Result>() { // from class: com.hive.social.SocialFacebookImpl.9.1
                        @Override // com.facebook.FacebookCallback
                        public void onSuccess(GameRequestDialog.Result result) {
                            result.getRequestId();
                            result.getRequestRecipients();
                            sendMessageFacebookListener.onSendMessageFacebook(new ResultAPI(0, ResultAPI.Code.Success, ""));
                            activity.finish();
                        }

                        @Override // com.facebook.FacebookCallback
                        public void onCancel() {
                            sendMessageFacebookListener.onSendMessageFacebook(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelSendMessage, "user canceled"));
                            activity.finish();
                        }

                        @Override // com.facebook.FacebookCallback
                        public void onError(FacebookException facebookException) {
                            sendMessageFacebookListener.onSendMessageFacebook(SocialFacebookImpl.this.exceptionToResultAPI(facebookException));
                            activity.finish();
                        }
                    });
                    this.requestDialog.show(gameRequestContentBuild);
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    if (this.isInProgress && this.requestDialog != null) {
                        SocialFacebookImpl.this.callbackManager.onActivityResult(this.requestDialog.getRequestCodeField(), 0, null);
                    }
                    super.onDestroy(activity);
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                    this.isInProgress = false;
                    SocialFacebookImpl.this.callbackManager.onActivityResult(i, i2, intent);
                    activity.finish();
                }
            });
        } else {
            connect(new FacebookCallback<LoginResult>() { // from class: com.hive.social.SocialFacebookImpl.10
                @Override // com.facebook.FacebookCallback
                public void onSuccess(LoginResult loginResult) {
                    LoggerImpl.INSTANCE.i("Facebook sendMessageFacebook(LoginResult)-onSuccess(result:" + loginResult + ")");
                    if (loginResult.getAccessToken() != null) {
                        SocialFacebookImpl.this.sendMessageFacebook(socialFacebookMessage, sendMessageFacebookListener);
                    }
                }

                @Override // com.facebook.FacebookCallback
                public void onCancel() {
                    LoggerImpl.INSTANCE.i("Facebook sendMessageFacebook(LoginResult)-onCancel");
                    sendMessageFacebookListener.onSendMessageFacebook(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelSendMessage, "Login is canceled!"));
                }

                @Override // com.facebook.FacebookCallback
                public void onError(FacebookException facebookException) {
                    LoggerImpl.INSTANCE.i("Facebook sendMessageFacebook(LoginResult)-onError(FacebookException:" + facebookException + ")");
                    sendMessageFacebookListener.onSendMessageFacebook(new ResultAPI(-99, ResultAPI.Code.SocialFacebookResponseFailSendMessage, "Login failed! : " + facebookException.getMessage()));
                }
            });
        }
    }

    public void sendAppInvitation(final JSONObject jSONObject, final SocialFacebook.SocialRequestListener socialRequestListener) {
        if (!AuthImpl.INSTANCE.isInitialize()) {
            if (socialRequestListener != null) {
                socialRequestListener.onComplete(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""), null);
            }
        } else if (isConnected()) {
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.social.SocialFacebookImpl.11
                private boolean isInProgress = true;
                private GameRequestDialog requestDialog;

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(final Activity activity, Bundle bundle) {
                    GameRequestContent.Builder builder;
                    JSONException e;
                    super.onCreate(activity, bundle);
                    FacebookCallback<GameRequestDialog.Result> facebookCallback = new FacebookCallback<GameRequestDialog.Result>() { // from class: com.hive.social.SocialFacebookImpl.11.1
                        @Override // com.facebook.FacebookCallback
                        public void onSuccess(GameRequestDialog.Result result) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                                jSONObject2.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_SEND_APP_INVITATION);
                                jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                                List<String> requestRecipients = result.getRequestRecipients();
                                JSONArray jSONArray = new JSONArray();
                                if (requestRecipients != null) {
                                    Iterator<String> it = requestRecipients.iterator();
                                    while (it.hasNext()) {
                                        jSONArray.put(it.next());
                                    }
                                }
                                jSONObject2.put("receivers", jSONArray);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            socialRequestListener.onComplete(new ResultAPI(0, ResultAPI.Code.Success, ""), jSONObject2.toString());
                            activity.finish();
                        }

                        @Override // com.facebook.FacebookCallback
                        public void onCancel() {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                                jSONObject2.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_SEND_APP_INVITATION);
                                jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2001);
                                jSONObject2.put("error_msg", "user cancelled");
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            socialRequestListener.onComplete(new ResultAPI(-6, ResultAPI.Code.Success, ""), jSONObject2.toString());
                            activity.finish();
                        }

                        @Override // com.facebook.FacebookCallback
                        public void onError(FacebookException facebookException) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                                jSONObject2.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_SEND_APP_INVITATION);
                                jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                                jSONObject2.put("error_msg", facebookException.toString());
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            socialRequestListener.onComplete(new ResultAPI(-6, ResultAPI.Code.Success, ""), jSONObject2.toString());
                            activity.finish();
                        }
                    };
                    this.requestDialog = new GameRequestDialog(activity);
                    try {
                        builder = new GameRequestContent.Builder();
                    } catch (JSONException e2) {
                        builder = null;
                        e = e2;
                    }
                    try {
                        if (jSONObject.getString("message") != null) {
                            builder.setMessage(jSONObject.getString("message"));
                        }
                        if (jSONObject.getString("title") != null) {
                            builder.setTitle(jSONObject.getString("title"));
                        }
                        if (jSONObject.getString("data") != null) {
                            builder.setData(jSONObject.getString("data"));
                        }
                        builder.setFilters(GameRequestContent.Filters.APP_NON_USERS).build();
                    } catch (JSONException e3) {
                        e = e3;
                        e.printStackTrace();
                    }
                    GameRequestContent gameRequestContentBuild = builder.build();
                    this.requestDialog.registerCallback(SocialFacebookImpl.this.callbackManager, facebookCallback);
                    this.requestDialog.show(gameRequestContentBuild);
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    if (this.isInProgress && this.requestDialog != null) {
                        SocialFacebookImpl.this.callbackManager.onActivityResult(this.requestDialog.getRequestCodeField(), 0, null);
                    }
                    super.onDestroy(activity);
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                    this.isInProgress = false;
                    SocialFacebookImpl.this.callbackManager.onActivityResult(i, i2, intent);
                    activity.finish();
                }
            });
        } else {
            connect(new FacebookCallback<LoginResult>() { // from class: com.hive.social.SocialFacebookImpl.12
                @Override // com.facebook.FacebookCallback
                public void onSuccess(LoginResult loginResult) {
                    LoggerImpl.INSTANCE.i("Facebook sendAppInvitation(LoginResult)-onSuccess(result:" + loginResult + ")");
                    if (loginResult.getAccessToken() != null) {
                        SocialFacebookImpl.this.sendAppInvitation(jSONObject, socialRequestListener);
                    }
                }

                @Override // com.facebook.FacebookCallback
                public void onCancel() {
                    LoggerImpl.INSTANCE.i("Facebook sendAppInvitation(LoginResult)-onCancel");
                    socialRequestListener.onComplete(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelSendMessage, "Login is canceled!"), null);
                }

                @Override // com.facebook.FacebookCallback
                public void onError(FacebookException facebookException) {
                    LoggerImpl.INSTANCE.i("Facebook sendAppInvitation(LoginResult)-onError(FacebookException:" + facebookException + ")");
                    socialRequestListener.onComplete(new ResultAPI(-99, ResultAPI.Code.SocialFacebookResponseFailSendMessage, "Login failed! : " + facebookException.getMessage()), null);
                }
            });
        }
    }

    public void queryWithParams(final JSONObject jSONObject, final SocialFacebook.SocialRequestListener socialRequestListener) {
        getPermissions();
        if (!AuthImpl.INSTANCE.isInitialize()) {
            if (socialRequestListener != null) {
                socialRequestListener.onComplete(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""), null);
            }
        } else if (!isPublishQuery(jSONObject)) {
            if (socialRequestListener != null) {
                socialRequestListener.onComplete(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""), null);
            }
        } else {
            if (hasPermission(getPermissions(), "publish_actions")) {
                runQueryWithParams(jSONObject, socialRequestListener);
                return;
            }
            final List listAsList = Arrays.asList("publish_actions");
            if (isConnected()) {
                HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.social.SocialFacebookImpl.13
                    private boolean isInProgress = true;

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onCreate(final Activity activity, Bundle bundle) {
                        super.onCreate(activity, bundle);
                        LoginManager.getInstance().registerCallback(SocialFacebookImpl.this.callbackManager, new FacebookCallback<LoginResult>() { // from class: com.hive.social.SocialFacebookImpl.13.1
                            @Override // com.facebook.FacebookCallback
                            public void onSuccess(LoginResult loginResult) {
                                if (SocialFacebookImpl.this.hasPermission(SocialFacebookImpl.this.getPermissions(), "publish_actions")) {
                                    SocialFacebookImpl.this.runQueryWithParams(jSONObject, socialRequestListener);
                                } else {
                                    JSONObject jSONObject2 = new JSONObject();
                                    try {
                                        jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                                        jSONObject2.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_QUERY);
                                        jSONObject2.put(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject);
                                        jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                                        jSONObject2.put("error_msg", "Permission denied.");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    socialRequestListener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVESocialRequestError, ""), jSONObject2.toString());
                                }
                                activity.finish();
                            }

                            @Override // com.facebook.FacebookCallback
                            public void onCancel() {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                                    jSONObject2.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_QUERY);
                                    jSONObject2.put(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject);
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                                    jSONObject2.put("error_msg", "user cancelled");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                socialRequestListener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVESocialRequestError, ""), jSONObject2.toString());
                                activity.finish();
                            }

                            @Override // com.facebook.FacebookCallback
                            public void onError(FacebookException facebookException) {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                                    jSONObject2.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_QUERY);
                                    jSONObject2.put(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject);
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                                    jSONObject2.put("error_msg", facebookException.toString());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                socialRequestListener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVESocialRequestError, ""), jSONObject2.toString());
                                activity.finish();
                            }
                        });
                        LoginManager.getInstance().logInWithReadPermissions(activity, listAsList);
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onDestroy(Activity activity) {
                        this.isInProgress = false;
                        activity.finish();
                        super.onDestroy(activity);
                    }
                });
            } else {
                connect(new FacebookCallback<LoginResult>() { // from class: com.hive.social.SocialFacebookImpl.14
                    @Override // com.facebook.FacebookCallback
                    public void onSuccess(LoginResult loginResult) {
                        LoggerImpl.INSTANCE.i("Facebook queryWithParams(LoginResult)-onSuccess(result:" + loginResult + ")");
                        if (loginResult.getAccessToken() != null) {
                            SocialFacebookImpl.this.queryWithParams(jSONObject, socialRequestListener);
                        }
                    }

                    @Override // com.facebook.FacebookCallback
                    public void onCancel() {
                        LoggerImpl.INSTANCE.i("Facebook queryWithParams(LoginResult)-onCancel");
                        socialRequestListener.onComplete(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelSendMessage, "Login is canceled!"), null);
                    }

                    @Override // com.facebook.FacebookCallback
                    public void onError(FacebookException facebookException) {
                        LoggerImpl.INSTANCE.i("Facebook queryWithParams(LoginResult)-onError(FacebookException:" + facebookException + ")");
                        socialRequestListener.onComplete(new ResultAPI(-99, ResultAPI.Code.SocialFacebookResponseFailSendMessage, "Login failed! : " + facebookException.getMessage()), null);
                    }
                });
            }
        }
    }

    private boolean isPublishQuery(JSONObject jSONObject) {
        String str;
        String upperCase;
        str = "";
        if (jSONObject == null) {
            return false;
        }
        try {
            str = jSONObject.has(FirebaseAnalytics.Param.METHOD) ? (String) jSONObject.get(FirebaseAnalytics.Param.METHOD) : "";
            upperCase = str.toUpperCase(Locale.getDefault());
        } catch (JSONException e) {
            e.printStackTrace();
            upperCase = str;
        }
        return upperCase.equals("POST");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runQueryWithParams(JSONObject jSONObject, final SocialFacebook.SocialRequestListener socialRequestListener) {
        String str;
        String str2;
        String str3;
        HttpMethod httpMethod;
        String str4;
        str = "";
        Bundle bundle = new Bundle();
        final JSONObject jSONObject2 = null;
        try {
            str4 = jSONObject.has("query") ? (String) jSONObject.get("query") : "";
        } catch (JSONException e) {
            e = e;
            str2 = "";
        }
        try {
            str = jSONObject.has(FirebaseAnalytics.Param.METHOD) ? (String) jSONObject.get(FirebaseAnalytics.Param.METHOD) : "";
            if (jSONObject.has(NativeProtocol.WEB_DIALOG_PARAMS)) {
                jSONObject2 = jSONObject.getJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle.putString(next, jSONObject2.get(next).toString());
                }
            }
            str3 = str4;
        } catch (JSONException e2) {
            e = e2;
            str2 = str;
            str = str4;
            e.printStackTrace();
            str3 = str;
            str = str2;
        }
        if (str.equalsIgnoreCase("get")) {
            httpMethod = HttpMethod.GET;
        } else if (str.equalsIgnoreCase("post")) {
            httpMethod = HttpMethod.POST;
        } else if (str.equalsIgnoreCase("delete")) {
            httpMethod = HttpMethod.DELETE;
        } else {
            httpMethod = HttpMethod.GET;
        }
        httpMethod.equals(HttpMethod.POST);
        final GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(), str3, bundle, HttpMethod.GET, new GraphRequest.Callback() { // from class: com.hive.social.SocialFacebookImpl.15
            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                    jSONObject3.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_QUERY);
                    jSONObject3.put(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject2);
                    if (graphResponse.getError() != null) {
                        jSONObject3.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                        jSONObject3.put("error_msg", graphResponse.getError().toString());
                    } else {
                        jSONObject3.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                        jSONObject3.put("result", graphResponse.getGraphObject());
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                socialRequestListener.onComplete(new ResultAPI(0, ResultAPI.Code.Success, ""), jSONObject3.toString());
            }
        });
        Android.INSTANCE.runOnMainThread(new Runnable() { // from class: com.hive.social.SocialFacebookImpl.16
            @Override // java.lang.Runnable
            public void run() {
                graphRequest.executeAsync();
            }
        });
    }

    public void sendBusinessModel(final SocialFacebook.SocialRequestListener socialRequestListener) {
        if (!AuthImpl.INSTANCE.isInitialize()) {
            if (socialRequestListener != null) {
                socialRequestListener.onComplete(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""), null);
            }
        } else if (isConnected()) {
            final GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/ids_for_business", null, HttpMethod.GET, new GraphRequest.Callback() { // from class: com.hive.social.SocialFacebookImpl.17
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    ResultAPI resultAPI = new ResultAPI();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                        jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_BUSINESS_MODEL);
                        if (graphResponse.getError() == null) {
                            JSONArray jSONArray = graphResponse.getGraphObject().getJSONArray("data");
                            jSONObject.put("error_cdoe", 0);
                            jSONObject.put("data", jSONArray);
                            FacebookException exception = graphResponse.getError().getException();
                            if (exception != null) {
                                resultAPI = SocialFacebookImpl.this.exceptionToResultAPI(exception);
                            } else {
                                resultAPI = new ResultAPI(-1, ResultAPI.Code.AuthV4FacebookInvalidResponseData, graphResponse.getRawResponse());
                            }
                        } else {
                            jSONObject.put("error_cdoe", 2003);
                            jSONObject.put("error_msg", graphResponse.getError().toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    socialRequestListener.onComplete(resultAPI, jSONObject.toString());
                }
            });
            Android.INSTANCE.runOnMainThread(new Runnable() { // from class: com.hive.social.SocialFacebookImpl.18
                @Override // java.lang.Runnable
                public void run() {
                    graphRequest.executeAsync();
                }
            });
        } else {
            connect(new FacebookCallback<LoginResult>() { // from class: com.hive.social.SocialFacebookImpl.19
                @Override // com.facebook.FacebookCallback
                public void onSuccess(LoginResult loginResult) {
                    LoggerImpl.INSTANCE.i("Facebook sendBusinessModel(LoginResult)-onSuccess(result:" + loginResult + ")");
                    if (loginResult.getAccessToken() != null) {
                        SocialFacebookImpl.this.sendBusinessModel(socialRequestListener);
                    }
                }

                @Override // com.facebook.FacebookCallback
                public void onCancel() {
                    LoggerImpl.INSTANCE.i("Facebook sendBusinessModel(LoginResult)-onCancel");
                    socialRequestListener.onComplete(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelSendMessage, "Login is canceled!"), null);
                }

                @Override // com.facebook.FacebookCallback
                public void onError(FacebookException facebookException) {
                    LoggerImpl.INSTANCE.i("Facebook sendBusinessModel(LoginResult)-onError(FacebookException:" + facebookException + ")");
                    socialRequestListener.onComplete(new ResultAPI(-99, ResultAPI.Code.SocialFacebookResponseFailSendMessage, "Login failed! : " + facebookException.getMessage()), null);
                }
            });
        }
    }

    public int requestReceivedInvite(final JSONObject jSONObject, final SocialFacebook.SocialRequestListener socialRequestListener) throws JSONException {
        if (!AuthImpl.INSTANCE.isInitialize()) {
            if (socialRequestListener == null) {
                return -9;
            }
            socialRequestListener.onComplete(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""), null);
            return -9;
        }
        if (isConnected()) {
            int i = 1;
            if (jSONObject != null) {
                try {
                    if (jSONObject.has("limit") && jSONObject.getInt("limit") > 1) {
                        i = jSONObject.getInt("limit");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Bundle bundle = new Bundle();
            bundle.putInt("limit", i);
            final GraphRequest graphRequest = new GraphRequest(this.currentAccessToken, "me/apprequests", bundle, HttpMethod.GET, new GraphRequest.Callback() { // from class: com.hive.social.SocialFacebookImpl.20
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    if (socialRequestListener == null || graphResponse == null) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                        jSONObject2.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_RECEIVED_INVITE);
                        if (graphResponse.getError() != null) {
                            jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                            jSONObject2.put("error_msg", graphResponse.getError().getErrorMessage());
                        } else {
                            jSONObject2.put("data", graphResponse.getGraphObject().getJSONArray("data"));
                            jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                        }
                        socialRequestListener.onComplete(new ResultAPI(0, ResultAPI.Code.Success, ""), jSONObject2.toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            Android.INSTANCE.runOnMainThread(new Runnable() { // from class: com.hive.social.SocialFacebookImpl.21
                @Override // java.lang.Runnable
                public void run() {
                    graphRequest.executeAsync();
                }
            });
            return 0;
        }
        connect(new FacebookCallback<LoginResult>() { // from class: com.hive.social.SocialFacebookImpl.22
            @Override // com.facebook.FacebookCallback
            public void onSuccess(LoginResult loginResult) throws JSONException {
                LoggerImpl.INSTANCE.i("Facebook requestReceivedInvite(LoginResult)-onSuccess(result:" + loginResult + ")");
                if (loginResult.getAccessToken() != null) {
                    SocialFacebookImpl.this.requestReceivedInvite(jSONObject, socialRequestListener);
                }
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                LoggerImpl.INSTANCE.i("Facebook requestReceivedInvite(LoginResult)-onCancel");
                socialRequestListener.onComplete(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelSendMessage, "Login is canceled!"), null);
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                LoggerImpl.INSTANCE.i("Facebook requestReceivedInvite(LoginResult)-onError(FacebookException:" + facebookException + ")");
                socialRequestListener.onComplete(new ResultAPI(-99, ResultAPI.Code.SocialFacebookResponseFailSendMessage, "Login failed! : " + facebookException.getMessage()), null);
            }
        });
        return 0;
    }

    public int requestUserProfileImage(final JSONObject jSONObject, final SocialFacebook.SocialRequestListener socialRequestListener) {
        String string = null;
        if (!AuthImpl.INSTANCE.isInitialize()) {
            if (socialRequestListener == null) {
                return -9;
            }
            socialRequestListener.onComplete(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""), null);
            return -9;
        }
        try {
            string = jSONObject.has(AccessToken.USER_ID_KEY) ? jSONObject.getString(AccessToken.USER_ID_KEY) : "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isConnected()) {
            try {
                if (string.equalsIgnoreCase("") || string == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                    jSONObject2.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_PROFILE_IMAGE);
                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                    jSONObject2.put("error_msg", "'user_id' field is null");
                    socialRequestListener.onComplete(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""), jSONObject2.toString());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("redirect", false);
            final GraphRequest graphRequest = new GraphRequest(this.currentAccessToken, DomExceptionUtils.SEPARATOR + string + "/picture", bundle, HttpMethod.GET, new GraphRequest.Callback() { // from class: com.hive.social.SocialFacebookImpl.23
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    if (socialRequestListener == null || graphResponse == null) {
                        return;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        if (graphResponse.getError() != null) {
                            jSONObject3.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                            jSONObject3.put("error_msg", graphResponse.getError().getErrorMessage());
                        } else {
                            jSONObject3.put("data", graphResponse.getGraphObject().getJSONObject("data"));
                            jSONObject3.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                        }
                        jSONObject3.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                        jSONObject3.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_PROFILE_IMAGE);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    socialRequestListener.onComplete(new ResultAPI(0, ResultAPI.Code.Success, ""), jSONObject3.toString());
                }
            });
            Android.INSTANCE.runOnMainThread(new Runnable() { // from class: com.hive.social.SocialFacebookImpl.24
                @Override // java.lang.Runnable
                public void run() {
                    graphRequest.executeAsync();
                }
            });
        } else {
            connect(new FacebookCallback<LoginResult>() { // from class: com.hive.social.SocialFacebookImpl.25
                @Override // com.facebook.FacebookCallback
                public void onSuccess(LoginResult loginResult) {
                    LoggerImpl.INSTANCE.i("Facebook requestUserProfileImage(LoginResult)-onSuccess(result:" + loginResult + ")");
                    if (loginResult.getAccessToken() != null) {
                        SocialFacebookImpl.this.requestUserProfileImage(jSONObject, socialRequestListener);
                    }
                }

                @Override // com.facebook.FacebookCallback
                public void onCancel() {
                    LoggerImpl.INSTANCE.i("Facebook requestUserProfileImage(LoginResult)-onCancel");
                    socialRequestListener.onComplete(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelSendMessage, "Login is canceled!"), null);
                }

                @Override // com.facebook.FacebookCallback
                public void onError(FacebookException facebookException) {
                    LoggerImpl.INSTANCE.i("Facebook requestUserProfileImage(LoginResult)-onError(FacebookException:" + facebookException + ")");
                    socialRequestListener.onComplete(new ResultAPI(-99, ResultAPI.Code.SocialFacebookResponseFailSendMessage, "Login failed! : " + facebookException.getMessage()), null);
                }
            });
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a A[Catch: Exception -> 0x0018, TryCatch #0 {Exception -> 0x0018, blocks: (B:4:0x000e, B:6:0x0014, B:10:0x001e, B:9:0x001a), top: B:15:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int isAuthorized(com.hive.SocialFacebook.SocialRequestListener r6) {
        /*
            r5 = this;
            com.facebook.AccessToken r0 = com.facebook.AccessToken.getCurrentAccessToken()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "is_authorized"
            r3 = 0
            if (r0 != 0) goto L1a
            boolean r0 = r5.isConnected()     // Catch: java.lang.Exception -> L18
            if (r0 != 0) goto L1a
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L18
            goto L1e
        L18:
            r0 = move-exception
            goto L32
        L1a:
            r0 = 1
            r1.put(r2, r0)     // Catch: java.lang.Exception -> L18
        L1e:
            java.lang.String r0 = "service"
            java.lang.String r2 = "facebook"
            r1.put(r0, r2)     // Catch: java.lang.Exception -> L18
            java.lang.String r0 = "type"
            java.lang.String r2 = "social/is_authorized"
            r1.put(r0, r2)     // Catch: java.lang.Exception -> L18
            java.lang.String r0 = "error_code"
            r1.put(r0, r3)     // Catch: java.lang.Exception -> L18
            goto L35
        L32:
            r0.printStackTrace()
        L35:
            com.hive.ResultAPI r0 = new com.hive.ResultAPI
            com.hive.ResultAPI$Code r2 = com.hive.ResultAPI.Code.Success
            java.lang.String r4 = ""
            r0.<init>(r3, r2, r4)
            java.lang.String r1 = r1.toString()
            r6.onComplete(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.social.SocialFacebookImpl.isAuthorized(com.hive.SocialFacebook$SocialRequestListener):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018 A[Catch: Exception -> 0x0033, TryCatch #0 {Exception -> 0x0033, blocks: (B:4:0x000e, B:6:0x0014, B:8:0x001f, B:7:0x0018), top: B:14:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int logout(com.hive.SocialFacebook.SocialRequestListener r6) {
        /*
            r5 = this;
            com.facebook.AccessToken r0 = com.facebook.AccessToken.getCurrentAccessToken()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "result"
            r3 = 0
            if (r0 != 0) goto L18
            boolean r0 = r5.isConnected()     // Catch: java.lang.Exception -> L33
            if (r0 != 0) goto L18
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L33
            goto L1f
        L18:
            r5.disconnect()     // Catch: java.lang.Exception -> L33
            r0 = 1
            r1.put(r2, r0)     // Catch: java.lang.Exception -> L33
        L1f:
            java.lang.String r0 = "service"
            java.lang.String r2 = "facebook"
            r1.put(r0, r2)     // Catch: java.lang.Exception -> L33
            java.lang.String r0 = "type"
            java.lang.String r2 = "social/logout"
            r1.put(r0, r2)     // Catch: java.lang.Exception -> L33
            java.lang.String r0 = "error_code"
            r1.put(r0, r3)     // Catch: java.lang.Exception -> L33
            goto L37
        L33:
            r0 = move-exception
            r0.printStackTrace()
        L37:
            com.hive.ResultAPI r0 = new com.hive.ResultAPI
            com.hive.ResultAPI$Code r2 = com.hive.ResultAPI.Code.Success
            java.lang.String r4 = ""
            r0.<init>(r3, r2, r4)
            java.lang.String r1 = r1.toString()
            r6.onComplete(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.social.SocialFacebookImpl.logout(com.hive.SocialFacebook$SocialRequestListener):int");
    }

    public int requestConnect(final SocialFacebook.SocialRequestListener socialRequestListener) {
        if (!AuthImpl.INSTANCE.isInitialize()) {
            if (socialRequestListener != null) {
                socialRequestListener.onComplete(new ResultAPI(-7, ResultAPI.Code.AuthNotInitialized, ""), null);
            }
            return -9;
        }
        if (isConnected()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("service_type", "facebook");
                jSONObject.put("token", getAccessToken());
                jSONObject.put(PangleConstants.APP_ID, getApplicationId());
                SocialHiveImpl.INSTANCE.asyncRequest(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_CONNECT, jSONObject, new SocialHive.AsyncRequestListener() { // from class: com.hive.social.SocialFacebookImpl.26
                    @Override // com.hive.SocialHive.AsyncRequestListener
                    public void onComplete(ResultAPI resultAPI, JSONObject jSONObject2) {
                        try {
                            if (jSONObject2 != null) {
                                jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                                socialRequestListener.onComplete(resultAPI, jSONObject2.toString());
                            } else {
                                socialRequestListener.onComplete(resultAPI, null);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
                return -9;
            }
        }
        connect(new FacebookCallback<LoginResult>() { // from class: com.hive.social.SocialFacebookImpl.27
            @Override // com.facebook.FacebookCallback
            public void onSuccess(LoginResult loginResult) {
                SocialFacebookImpl.this.requestConnect(socialRequestListener);
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                socialRequestListener.onComplete(new ResultAPI(-6, ResultAPI.Code.AuthCanceled), null);
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                socialRequestListener.onComplete(new ResultAPI(-99, ResultAPI.Code.AuthCanceled), null);
            }
        });
        return 0;
    }

    public int showInvitationDialog(final SocialFacebook.SocialFacebookMessage socialFacebookMessage, final SocialFacebook.ShowInvitationDialogListener showInvitationDialogListener) {
        if (!AuthImpl.INSTANCE.isInitialize()) {
            if (showInvitationDialogListener == null) {
                return -9;
            }
            showInvitationDialogListener.onShowInvitationDialog(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""), null);
            return -9;
        }
        if (isConnected()) {
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.social.SocialFacebookImpl.28
                private boolean isInProgress = true;
                private GameRequestDialog requestDialog;

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(final Activity activity, Bundle bundle) {
                    super.onCreate(activity, bundle);
                    this.requestDialog = new GameRequestDialog(activity);
                    GameRequestContent gameRequestContentBuild = new GameRequestContent.Builder().setMessage(socialFacebookMessage.message).setTitle(socialFacebookMessage.dialogTitle).setData(socialFacebookMessage.data).setFilters(GameRequestContent.Filters.APP_NON_USERS).build();
                    this.requestDialog.registerCallback(SocialFacebookImpl.this.callbackManager, new FacebookCallback<GameRequestDialog.Result>() { // from class: com.hive.social.SocialFacebookImpl.28.1
                        @Override // com.facebook.FacebookCallback
                        public void onSuccess(GameRequestDialog.Result result) {
                            List<String> requestRecipients = result.getRequestRecipients();
                            showInvitationDialogListener.onShowInvitationDialog(new ResultAPI(0, ResultAPI.Code.Success, ""), requestRecipients);
                            activity.finish();
                        }

                        @Override // com.facebook.FacebookCallback
                        public void onCancel() {
                            showInvitationDialogListener.onShowInvitationDialog(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelShowInvitation, "user canceled"), null);
                            activity.finish();
                        }

                        @Override // com.facebook.FacebookCallback
                        public void onError(FacebookException facebookException) {
                            showInvitationDialogListener.onShowInvitationDialog(SocialFacebookImpl.this.exceptionToResultAPI(facebookException), null);
                            activity.finish();
                        }
                    });
                    this.requestDialog.show(gameRequestContentBuild);
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    if (this.isInProgress && this.requestDialog != null) {
                        SocialFacebookImpl.this.callbackManager.onActivityResult(this.requestDialog.getRequestCodeField(), 0, null);
                    }
                    super.onDestroy(activity);
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                    this.isInProgress = false;
                    SocialFacebookImpl.this.callbackManager.onActivityResult(i, i2, intent);
                    activity.finish();
                }
            });
            return 0;
        }
        connect(new FacebookCallback<LoginResult>() { // from class: com.hive.social.SocialFacebookImpl.29
            @Override // com.facebook.FacebookCallback
            public void onSuccess(LoginResult loginResult) {
                LoggerImpl.INSTANCE.i("Facebook showInvitationDialog(LoginResult)-onSuccess(result:" + loginResult + ")");
                if (loginResult.getAccessToken() != null) {
                    SocialFacebookImpl.this.showInvitationDialog(socialFacebookMessage, showInvitationDialogListener);
                }
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                LoggerImpl.INSTANCE.i("Facebook showInvitationDialog(LoginResult)-onCancel");
                showInvitationDialogListener.onShowInvitationDialog(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelShowInvitation, "Login is canceled!"), null);
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                LoggerImpl.INSTANCE.i("Facebook showInvitationDialog(LoginResult)-onError(FacebookException:" + facebookException + ")");
                showInvitationDialogListener.onShowInvitationDialog(new ResultAPI(-99, ResultAPI.Code.SocialFacebookResponseFailShowInvitation, "Login failed! : " + facebookException.getMessage()), null);
            }
        });
        return 0;
    }

    public int postFacebook(final String str, final SocialFacebook.PostFacebookListener postFacebookListener) {
        if (!AuthImpl.INSTANCE.isInitialize()) {
            if (postFacebookListener != null) {
                postFacebookListener.onPostFacebook(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, ""));
            }
            return -9;
        }
        if (isConnected()) {
            if (str.isEmpty()) {
                postFacebookListener.onPostFacebook(new ResultAPI(-1, ResultAPI.Code.SocialFacebookInvalidParamPost, "contentURL is empty"));
                return -9;
            }
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.social.SocialFacebookImpl.30
                private boolean isInProgress = true;
                private ShareDialog shareDialog;

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(final Activity activity, Bundle bundle) {
                    super.onCreate(activity, bundle);
                    ShareLinkContent shareLinkContentBuild = new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).build();
                    if (ShareDialog.canShow((Class<? extends ShareContent<?, ?>>) shareLinkContentBuild.getClass())) {
                        ShareDialog shareDialog = new ShareDialog(activity);
                        this.shareDialog = shareDialog;
                        shareDialog.registerCallback(SocialFacebookImpl.this.callbackManager, new FacebookCallback<Sharer.Result>() { // from class: com.hive.social.SocialFacebookImpl.30.1
                            @Override // com.facebook.FacebookCallback
                            public void onSuccess(Sharer.Result result) {
                                ResultAPI resultAPI;
                                String postId = result.getPostId();
                                if (AccessToken.getCurrentAccessToken().getPermissions().contains("publish_actions") && postId == null) {
                                    resultAPI = new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelPost, "user canceled");
                                } else {
                                    resultAPI = new ResultAPI(0, ResultAPI.Code.Success, postId);
                                }
                                postFacebookListener.onPostFacebook(resultAPI);
                                activity.finish();
                            }

                            @Override // com.facebook.FacebookCallback
                            public void onCancel() {
                                postFacebookListener.onPostFacebook(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelPost, "user canceled"));
                                activity.finish();
                            }

                            @Override // com.facebook.FacebookCallback
                            public void onError(FacebookException facebookException) {
                                postFacebookListener.onPostFacebook(SocialFacebookImpl.this.exceptionToResultAPI(facebookException));
                                activity.finish();
                            }
                        });
                        this.shareDialog.show(shareLinkContentBuild);
                        return;
                    }
                    this.isInProgress = false;
                    postFacebookListener.onPostFacebook(new ResultAPI(-2, ResultAPI.Code.SocialFacebookResponseFailPost, "client not supported"));
                    activity.finish();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    if (this.isInProgress) {
                        postFacebookListener.onPostFacebook(new ResultAPI(-99, ResultAPI.Code.SocialFacebookResponseFailPost, "ShareDialog destroy"));
                    }
                    super.onDestroy(activity);
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                    this.isInProgress = false;
                    SocialFacebookImpl.this.callbackManager.onActivityResult(i, i2, intent);
                    activity.finish();
                }
            });
            return 0;
        }
        connect(new FacebookCallback<LoginResult>() { // from class: com.hive.social.SocialFacebookImpl.31
            @Override // com.facebook.FacebookCallback
            public void onSuccess(LoginResult loginResult) {
                LoggerImpl.INSTANCE.i("Facebook postFacebook(LoginResult)-onSuccess(result:" + loginResult + ")");
                if (loginResult.getAccessToken() != null) {
                    SocialFacebookImpl.this.postFacebook(str, postFacebookListener);
                }
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                LoggerImpl.INSTANCE.i("Facebook postFacebook(LoginResult)-onCancel");
                postFacebookListener.onPostFacebook(new ResultAPI(-6, ResultAPI.Code.SocialFacebookCancelPost, "Login is canceled!"));
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                LoggerImpl.INSTANCE.i("Facebook postFacebook(LoginResult)-onError(FacebookException:" + facebookException + ")");
                postFacebookListener.onPostFacebook(new ResultAPI(-99, ResultAPI.Code.SocialFacebookResponseFailPost, "Login failed! : " + facebookException.getMessage()));
            }
        });
        return 0;
    }

    public static boolean isLogin() {
        return AccessToken.getCurrentAccessToken() != null;
    }

    public boolean isConnected() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        this.currentAccessToken = currentAccessToken;
        return (currentAccessToken == null || currentAccessToken.isExpired() || this.currentAccessToken.isDataAccessExpired()) ? false : true;
    }

    public void connect(final FacebookCallback<LoginResult> facebookCallback) {
        if (isConnected()) {
            AccessToken.refreshCurrentAccessTokenAsync();
            LoggerImpl.INSTANCE.i("Facebook session is already opened!");
        } else {
            final int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            HiveUiActivity.INSTANCE.launchForResult(HiveActivity.INSTANCE.getRecentActivity(), null, requestCode, new OnActivityLifecycle() { // from class: com.hive.social.SocialFacebookImpl.32
                private boolean isInProgress = true;

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(Activity activity, Bundle bundle) {
                    super.onCreate(activity, bundle);
                    List<String> permissions = SocialFacebookImpl.getInstance().getPermissions();
                    LoginManager.getInstance().registerCallback(SocialFacebookImpl.this.callbackManager, facebookCallback);
                    LoginManager.getInstance().logInWithReadPermissions(activity, permissions);
                    LoggerImpl.INSTANCE.i("socialFacebookImpl-conncet-openForRead()");
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    if (this.isInProgress) {
                        SocialFacebookImpl.this.callbackManager.onActivityResult(requestCode, 0, null);
                    }
                    super.onDestroy(activity);
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                    if (i != requestCode) {
                        super.onActivityResult(activity, i, i2, intent);
                        return;
                    }
                    this.isInProgress = false;
                    SocialFacebookImpl.this.callbackManager.onActivityResult(i, i2, intent);
                    activity.finish();
                }
            });
        }
    }

    public void disconnect() {
        try {
            LoginManager.getInstance().logOut();
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("Facebook disconnect exception : " + e.toString());
        } catch (NoClassDefFoundError e2) {
            LoggerImpl.INSTANCE.w("Facebook disconnect error : " + e2.toString());
        }
    }

    public String getAccessToken() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        this.currentAccessToken = currentAccessToken;
        if (currentAccessToken != null) {
            return currentAccessToken.getToken();
        }
        return null;
    }

    public String getApplicationId() {
        return FacebookSdk.getApplicationId();
    }

    private void facebookSdkInitialize() {
        LoggerImpl.INSTANCE.i("SocialFacebookImpl facebookSdkInitialize");
        if (!FacebookSdk.getAutoInitEnabled()) {
            FacebookSdk.setAutoInitEnabled(true);
            FacebookSdk.fullyInitialize();
        }
        if (!FacebookSdk.getAutoLogAppEventsEnabled()) {
            FacebookSdk.setAutoLogAppEventsEnabled(true);
        }
        if (!FacebookSdk.getAdvertiserIDCollectionEnabled()) {
            FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        }
        if (!FacebookSdk.isInitialized()) {
            LoggerImpl.INSTANCE.i("SocialFacebookImpl facebookSdkInitialize start");
            WebDialog.setWebDialogTheme(R.style.Theme.Black.NoTitleBar);
            com.hive.Configuration configuration = com.hive.Configuration.INSTANCE;
            FacebookSdk.sdkInitialize(com.hive.Configuration.getContext(), new FacebookSdk.InitializeCallback() { // from class: com.hive.social.SocialFacebookImpl.33
                @Override // com.facebook.FacebookSdk.InitializeCallback
                public void onInitialized() {
                    LoggerImpl.INSTANCE.i("FacebookSdk-onInitialized!");
                }
            });
        }
        if (this.callbackManager == null) {
            this.callbackManager = CallbackManager.Factory.create();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResultAPI exceptionToResultAPI(FacebookException facebookException) {
        if (facebookException instanceof FacebookOperationCanceledException) {
            return new ResultAPI(-6, ResultAPI.Code.SocialFacebookOperationException, "user canceled");
        }
        if (facebookException instanceof FacebookServiceException) {
            return new ResultAPI(-1, ResultAPI.Code.SocialFacebookServiceException, ((FacebookServiceException) facebookException).getRequestError().getErrorMessage());
        }
        return new ResultAPI(-6, ResultAPI.Code.SocialFacebookException, facebookException.getLocalizedMessage());
    }
}
