package com.hive.module.hivemembership;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.authv4.webviewflow.AuthV4MembershipView;
import com.hive.base.Android;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.OauthToken;
import com.hive.core.Platform;
import com.hive.logger.LoggerImpl;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.authv4.provider.ProviderHiveMembership;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.UrlManager;
import com.hive.protocol.membership.GetSession;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: HiveModuleHiveMembership.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jw\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052Q\u0010\u001c\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00160\u001dH\u0016J\b\u0010 \u001a\u00020!H\u0016J]\u0010\"\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2K\u0010#\u001aG\u0012\u0013\u0012\u00110$¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00160\u001dH\u0016J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050&H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\f¨\u0006'"}, d2 = {"Lcom/hive/module/hivemembership/HiveModuleHiveMembership;", "Lcom/hive/module/interfaces/authv4/provider/ProviderHiveMembership;", "<init>", "()V", "HIVE_UID", "", "HIVE_SESSION", "HIVE_MEMBER_SESSION", "HIVE_PROFILE_NAME", "HIVE_PROFILE_IMG", "uid", "getUid", "()Ljava/lang/String;", "hiveSession", "getHiveSession", "memberSession", "getMemberSession", "profileName", "getProfileName", "profileImg", "getProfileImg", "login", "", "activity", "Landroid/app/Activity;", "playerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "did", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "logout", "", "getSession", "callback", "Lcom/hive/protocol/membership/GetSession;", "getVersionInfo", "", "hive-authv4-provider-hive-membership_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveModuleHiveMembership implements ProviderHiveMembership {
    private final String HIVE_UID = "authv4.hive_uid";
    private final String HIVE_SESSION = "authv4.hive_session";
    private final String HIVE_MEMBER_SESSION = "authv4.hive_member_session";
    private final String HIVE_PROFILE_NAME = "authv4.hive_profile_name";
    private final String HIVE_PROFILE_IMG = "authv4.hive_profile_img";

    @Override // com.hive.module.interfaces.authv4.provider.ProviderHiveMembership, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return ProviderHiveMembership.DefaultImpls.getHiveModuleName(this);
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderHiveMembership
    public String getUid() {
        return Property.INSTANCE.getINSTANCE().getValue(this.HIVE_UID);
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderHiveMembership
    public String getHiveSession() {
        return Property.INSTANCE.getINSTANCE().getValue(this.HIVE_SESSION);
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderHiveMembership
    public String getMemberSession() {
        return Property.INSTANCE.getINSTANCE().getValue(this.HIVE_MEMBER_SESSION);
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderHiveMembership
    public String getProfileName() {
        return Property.INSTANCE.getINSTANCE().getValue(this.HIVE_PROFILE_NAME);
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderHiveMembership
    public String getProfileImg() {
        return Property.INSTANCE.getINSTANCE().getValue(this.HIVE_PROFILE_IMG);
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderHiveMembership
    public void login(Activity activity, AuthV4.PlayerInfo playerInfo, String did, final Function3<? super String, ? super String, ? super String, Unit> listener) throws JSONException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.dL("[HiveModuleHiveMembership] login: " + playerInfo + ", did: " + did);
        LoggerImpl.INSTANCE.dR("[HiveModuleHiveMembership] login");
        String value = Property.INSTANCE.getINSTANCE().getValue(this.HIVE_MEMBER_SESSION);
        String str = value;
        if (str == null || StringsKt.isBlank(str)) {
            value = "init";
        }
        JSONObject jSONObjectPutCI = CommonIdentifierKt.putCI(new JSONObject());
        try {
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_did, did);
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_sdk_version, "4.26.2.0");
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_os_version, Android.INSTANCE.getOSVersion());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_os_api_level, String.valueOf(Android.INSTANCE.getOSVersionCode()));
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_device_model, Android.INSTANCE.getDeviceModel());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_country, Android.INSTANCE.getCountry());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_game_language, ConfigurationImpl.INSTANCE.getHiveLanguage());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_player_id, playerInfo != null ? Long.valueOf(playerInfo.getPlayerId()) : JSONObject.NULL);
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_member, value);
            LoggerImpl.INSTANCE.dL("[HiveModuleHiveMembership] Login, post data. \n\n" + jSONObjectPutCI.toString(4) + "\n\n");
            LoggerImpl.INSTANCE.dR("[HiveModuleHiveMembership] Login, post data.");
            final String string = jSONObjectPutCI.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            HiveUiActivity.INSTANCE.launch(activity, new Intent(), new OnActivityLifecycle() { // from class: com.hive.module.hivemembership.HiveModuleHiveMembership.login.1
                public AuthV4MembershipView authV4MembershipView;

                public final AuthV4MembershipView getAuthV4MembershipView() {
                    AuthV4MembershipView authV4MembershipView = this.authV4MembershipView;
                    if (authV4MembershipView != null) {
                        return authV4MembershipView;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("authV4MembershipView");
                    return null;
                }

                public final void setAuthV4MembershipView(AuthV4MembershipView authV4MembershipView) {
                    Intrinsics.checkNotNullParameter(authV4MembershipView, "<set-?>");
                    this.authV4MembershipView = authV4MembershipView;
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(final Activity activity2, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                    super.onCreate(activity2, savedInstanceState);
                    String login = UrlManager.Membership.INSTANCE.getLogin();
                    String str2 = string;
                    final HiveModuleHiveMembership hiveModuleHiveMembership = this;
                    final Function3<String, String, String, Unit> function3 = listener;
                    setAuthV4MembershipView(new AuthV4MembershipView(activity2, login, str2, "hive", new AuthV4MembershipView.HiveMembershipListener() { // from class: com.hive.module.hivemembership.HiveModuleHiveMembership$login$1$onCreate$1
                        @Override // com.hive.authv4.webviewflow.AuthV4MembershipView.HiveMembershipListener
                        public void onLogin(String uid, String sessionKey, String member, String name, String img) {
                            LoggerImpl.INSTANCE.d("[HiveModuleHiveMembership] onLogin");
                            Property.setValue$default(Property.INSTANCE.getINSTANCE(), hiveModuleHiveMembership.HIVE_UID, uid, null, 4, null);
                            Property.setValue$default(Property.INSTANCE.getINSTANCE(), hiveModuleHiveMembership.HIVE_SESSION, sessionKey, null, 4, null);
                            Property.setValue$default(Property.INSTANCE.getINSTANCE(), hiveModuleHiveMembership.HIVE_MEMBER_SESSION, member, null, 4, null);
                            Property.setValue$default(Property.INSTANCE.getINSTANCE(), hiveModuleHiveMembership.HIVE_PROFILE_NAME, name, null, 4, null);
                            Property.setValue$default(Property.INSTANCE.getINSTANCE(), hiveModuleHiveMembership.HIVE_PROFILE_IMG, img, null, 4, null);
                            Property.INSTANCE.getINSTANCE().writeProperties();
                        }

                        @Override // com.hive.authv4.webviewflow.AuthV4MembershipView.HiveMembershipListener
                        public void onLogout() {
                            LoggerImpl.INSTANCE.d("[HiveModuleHiveMembership] onLogout");
                            Property.setValue$default(Property.INSTANCE.getINSTANCE(), hiveModuleHiveMembership.HIVE_UID, "", null, 4, null);
                            Property.setValue$default(Property.INSTANCE.getINSTANCE(), hiveModuleHiveMembership.HIVE_SESSION, "", null, 4, null);
                            Property.setValue$default(Property.INSTANCE.getINSTANCE(), hiveModuleHiveMembership.HIVE_MEMBER_SESSION, "", null, 4, null);
                            Property.setValue$default(Property.INSTANCE.getINSTANCE(), hiveModuleHiveMembership.HIVE_PROFILE_NAME, "", null, 4, null);
                            Property.setValue$default(Property.INSTANCE.getINSTANCE(), hiveModuleHiveMembership.HIVE_PROFILE_IMG, "", null, 4, null);
                            Property.INSTANCE.getINSTANCE().writeProperties();
                        }

                        @Override // com.hive.authv4.webviewflow.AuthV4WebView.AuthV4WebViewListener
                        public void onWebViewFinish(String scheme) {
                            LoggerImpl.INSTANCE.dL("[HiveModuleHiveMembership] onWebViewFinish : " + scheme);
                            LoggerImpl.INSTANCE.dR("[HiveModuleHiveMembership] onWebViewFinish");
                            function3.invoke(Property.INSTANCE.getINSTANCE().getValue(hiveModuleHiveMembership.HIVE_UID), Property.INSTANCE.getINSTANCE().getValue(hiveModuleHiveMembership.HIVE_SESSION), Property.INSTANCE.getINSTANCE().getValue(hiveModuleHiveMembership.HIVE_MEMBER_SESSION));
                            activity2.finish();
                        }

                        @Override // com.hive.authv4.webviewflow.AuthV4WebView.AuthV4WebViewListener
                        public void onReceivedError(int errorCode, String description, String failingUrl) {
                            LoggerImpl.INSTANCE.w("[HiveModuleHiveMembership] onReceivedError : errorCode : " + errorCode + " description : " + description + " failingURL : " + failingUrl);
                            function3.invoke(null, null, null);
                            activity2.finish();
                        }
                    }));
                    getAuthV4MembershipView().show();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public boolean onBackPressed() {
                    return getAuthV4MembershipView().onBackPressed();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                    if (!getIsCalledFinish()) {
                        getAuthV4MembershipView().dismiss();
                    }
                    super.onDestroy(activity2);
                }
            });
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[HiveModuleHiveMembership] Login, invalid post data. " + e);
            listener.invoke(null, null, null);
        }
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderHiveMembership
    public boolean logout() {
        LoggerImpl.INSTANCE.dR("[HiveModuleHiveMembership] logout");
        Property.setValue$default(Property.INSTANCE.getINSTANCE(), this.HIVE_UID, "", null, 4, null);
        Property.setValue$default(Property.INSTANCE.getINSTANCE(), this.HIVE_SESSION, "", null, 4, null);
        Property.setValue$default(Property.INSTANCE.getINSTANCE(), this.HIVE_MEMBER_SESSION, "", null, 4, null);
        Property.setValue$default(Property.INSTANCE.getINSTANCE(), this.HIVE_PROFILE_NAME, "", null, 4, null);
        Property.setValue$default(Property.INSTANCE.getINSTANCE(), this.HIVE_PROFILE_IMG, "", null, 4, null);
        return Property.INSTANCE.getINSTANCE().writeProperties();
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderHiveMembership
    public void getSession(AuthV4.PlayerInfo playerInfo, final Function3<? super GetSession, ? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<GetSession>() { // from class: com.hive.module.hivemembership.HiveModuleHiveMembership$getSession$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.membership.GetSession] */
            @Override // kotlin.jvm.functions.Function0
            public final GetSession invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = GetSession.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
            protocol.setParam(HiveKeys.KEY_did, HiveLifecycle.INSTANCE.getDid());
            protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
            protocol.setParam(HiveKeys.KEY_os_version, Android.INSTANCE.getOSVersion());
            protocol.setParam(HiveKeys.KEY_os_api_level, Integer.valueOf(Android.INSTANCE.getOSVersionCode()));
            protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            protocol.setParam(HiveKeys.KEY_device_model, Android.INSTANCE.getDeviceModel());
            protocol.setParam(HiveKeys.KEY_country, Android.INSTANCE.getCountry());
            protocol.setParam(HiveKeys.KEY_player_id, Long.valueOf(playerInfo.getPlayerId()));
            protocol.setParam(HiveKeys.KEY_player_token, playerInfo.getPlayerToken());
            protocol.setHeader(HiveKeys.KEY_Authorization, playerInfo.getPlayerToken());
            OauthToken oauthToken = HiveLifecycle.INSTANCE.getAccount().getOauthToken();
            if (oauthToken != null) {
                protocol.setOauthToken(oauthToken);
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[HiveModuleHiveMembership] getSession Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.module.hivemembership.HiveModuleHiveMembership$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveModuleHiveMembership.getSession$lambda$1(this.f$0, callback, (GetSession) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSession$lambda$1(HiveModuleHiveMembership hiveModuleHiveMembership, Function3 function3, GetSession it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String hiveSession = it.getResponse().getHiveSession();
        String memberSession = it.getResponse().getMemberSession();
        if (!StringsKt.isBlank(hiveSession)) {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), hiveModuleHiveMembership.HIVE_SESSION, hiveSession, null, 4, null);
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), hiveModuleHiveMembership.HIVE_MEMBER_SESSION, memberSession, null, 4, null);
            Property.INSTANCE.getINSTANCE().writeProperties();
        }
        function3.invoke(it, hiveSession, memberSession);
        return Unit.INSTANCE;
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Authv4_Hive_Membership(), "26.2.0");
        return map;
    }
}
