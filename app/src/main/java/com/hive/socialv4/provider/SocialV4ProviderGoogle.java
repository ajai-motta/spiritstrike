package com.hive.socialv4.provider;

import androidx.core.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.ResultAPI;
import com.hive.SocialHive;
import com.hive.SocialV4;
import com.hive.authv4.provider.AuthV4ProviderGoogle;
import com.hive.configuration.ConfigurationImpl;
import com.hive.logger.LoggerImpl;
import com.hive.module.GoogleSignInModule;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderGoogleCredentialSignIn;
import com.hive.module.interfaces.authv4.provider.ProviderGoogleSignIn;
import com.hive.social.SocialHiveImpl;
import com.hive.social.SocialKeys;
import com.hive.socialv4.provider.SocialV4ProviderAdapter;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020%H\u0016J\b\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006-"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderGoogle;", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter;", "<init>", "()V", "hasTriedSilentSignIn", "", "getServiceName", "", "googleSignIn", "Lcom/hive/module/interfaces/authv4/provider/ProviderGoogleSignIn;", "getGoogleSignIn", "()Lcom/hive/module/interfaces/authv4/provider/ProviderGoogleSignIn;", "googleSignIn$delegate", "Lkotlin/Lazy;", "googleCredentialSignIn", "Lcom/hive/module/interfaces/authv4/provider/ProviderGoogleCredentialSignIn;", "getGoogleCredentialSignIn", "()Lcom/hive/module/interfaces/authv4/provider/ProviderGoogleCredentialSignIn;", "googleCredentialSignIn$delegate", "getMyGoogleProfile", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4GoogleProfileListener;", "handleProfile", "", "account", "Lcom/hive/module/GoogleSignInModule$GoogleAccount;", "getMyGoogleProfileWithPlayServicesAuth", "useSilentSignIn", "getMyGoogleProfileWithGoogleCredential", "getGoogleFriends", "requestSocialConnect", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4RequestListener;", "isConnected", "isAuthorized", "disconnect", "handleSocialIsAuthorizedScheme", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialSchemeListener;", "handleSocialLogoutScheme", "handleSocialRequestUserTokenScheme", "handleSocialRequestUserProfileScheme", "handleSocialRequestFriendsScheme", "getUserDataFromGoogleSignInApi", "Lorg/json/JSONObject;", "resetGoogleLoginType", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialV4ProviderGoogle extends SocialV4ProviderAdapter {
    private static boolean hasTriedSilentSignIn;
    public static final SocialV4ProviderGoogle INSTANCE = new SocialV4ProviderGoogle();

    /* JADX INFO: renamed from: googleSignIn$delegate, reason: from kotlin metadata */
    private static final Lazy googleSignIn = LazyKt.lazy(new Function0() { // from class: com.hive.socialv4.provider.SocialV4ProviderGoogle$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SocialV4ProviderGoogle.googleSignIn_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: googleCredentialSignIn$delegate, reason: from kotlin metadata */
    private static final Lazy googleCredentialSignIn = LazyKt.lazy(new Function0() { // from class: com.hive.socialv4.provider.SocialV4ProviderGoogle$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SocialV4ProviderGoogle.googleCredentialSignIn_delegate$lambda$1();
        }
    });

    private SocialV4ProviderGoogle() {
        super(SocialV4.ProviderType.GOOGLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit disconnect$lambda$17(boolean z, String str) {
        LoggerImpl.INSTANCE.d("SocialV4ProviderGoogle disconnect: " + z + '(' + str + ')');
        return Unit.INSTANCE;
    }

    private final ProviderGoogleCredentialSignIn getGoogleCredentialSignIn() {
        return (ProviderGoogleCredentialSignIn) googleCredentialSignIn.getValue();
    }

    private final ProviderGoogleSignIn getGoogleSignIn() {
        return (ProviderGoogleSignIn) googleSignIn.getValue();
    }

    private final void getMyGoogleProfileWithGoogleCredential(final SocialV4ProviderAdapter.SocialV4GoogleProfileListener listener) {
        GoogleSignInModule.GoogleAccount currentAccount;
        ProviderGoogleCredentialSignIn googleCredentialSignIn2 = getGoogleCredentialSignIn();
        if (googleCredentialSignIn2 != null && (currentAccount = googleCredentialSignIn2.getCurrentAccount()) != null) {
            LoggerImpl.INSTANCE.d("[SocialV4ProviderGoogle] getMyGoogleProfileWithGoogleCredential, getCurrentAccount exist.");
            AuthV4ProviderGoogle.INSTANCE.saveLoginSuccessType(true);
            INSTANCE.handleProfile(listener, currentAccount);
        } else {
            if (hasTriedSilentSignIn) {
                ProviderGoogleCredentialSignIn googleCredentialSignIn3 = getGoogleCredentialSignIn();
                if (googleCredentialSignIn3 != null) {
                    googleCredentialSignIn3.signIn(new Function3() { // from class: com.hive.socialv4.provider.SocialV4ProviderGoogle$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return SocialV4ProviderGoogle.getMyGoogleProfileWithGoogleCredential$lambda$14$lambda$12(this.f$0, listener, ((Boolean) obj).booleanValue(), (String) obj2, (GoogleSignInModule.GoogleAccount) obj3);
                        }
                    });
                    return;
                }
                return;
            }
            hasTriedSilentSignIn = true;
            ProviderGoogleCredentialSignIn googleCredentialSignIn4 = getGoogleCredentialSignIn();
            if (googleCredentialSignIn4 != null) {
                googleCredentialSignIn4.silentSignIn(new Function3() { // from class: com.hive.socialv4.provider.SocialV4ProviderGoogle$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SocialV4ProviderGoogle.getMyGoogleProfileWithGoogleCredential$lambda$14$lambda$13(this.f$0, listener, ((Boolean) obj).booleanValue(), (String) obj2, (GoogleSignInModule.GoogleAccount) obj3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyGoogleProfileWithGoogleCredential$lambda$14$lambda$12(SocialV4ProviderGoogle socialV4ProviderGoogle, SocialV4ProviderAdapter.SocialV4GoogleProfileListener socialV4GoogleProfileListener, boolean z, String str, GoogleSignInModule.GoogleAccount googleAccount) {
        if (!z || googleAccount == null) {
            LoggerImpl.INSTANCE.w("[SocialV4ProviderGoogle] credential signIn failed. : " + str);
            AuthV4ProviderGoogle.INSTANCE.saveLoginSuccessType(false);
            socialV4ProviderGoogle.getMyGoogleProfileWithPlayServicesAuth(false, socialV4GoogleProfileListener);
        } else {
            LoggerImpl.INSTANCE.d("[SocialV4ProviderGoogle] credential signIn Success.");
            AuthV4ProviderGoogle.INSTANCE.saveLoginSuccessType(true);
            socialV4ProviderGoogle.handleProfile(socialV4GoogleProfileListener, googleAccount);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyGoogleProfileWithGoogleCredential$lambda$14$lambda$13(SocialV4ProviderGoogle socialV4ProviderGoogle, SocialV4ProviderAdapter.SocialV4GoogleProfileListener socialV4GoogleProfileListener, boolean z, String str, GoogleSignInModule.GoogleAccount googleAccount) {
        if (!z || googleAccount == null) {
            LoggerImpl.INSTANCE.w("[SocialV4ProviderGoogle] credential silentSignIn failed. : " + str + "\n Try signIn.");
            AuthV4ProviderGoogle.INSTANCE.saveLoginSuccessType(false);
            socialV4ProviderGoogle.getMyGoogleProfileWithPlayServicesAuth(false, socialV4GoogleProfileListener);
        } else {
            LoggerImpl.INSTANCE.d("[SocialV4ProviderGoogle] credential silentSignIn Success.");
            AuthV4ProviderGoogle.INSTANCE.saveLoginSuccessType(true);
            socialV4ProviderGoogle.handleProfile(socialV4GoogleProfileListener, googleAccount);
        }
        return Unit.INSTANCE;
    }

    private final void getMyGoogleProfileWithPlayServicesAuth(boolean useSilentSignIn, final SocialV4ProviderAdapter.SocialV4GoogleProfileListener listener) {
        GoogleSignInModule.GoogleAccount currentAccount;
        ProviderGoogleSignIn googleSignIn2 = getGoogleSignIn();
        if (googleSignIn2 != null && (currentAccount = googleSignIn2.getCurrentAccount()) != null) {
            LoggerImpl.INSTANCE.d("[SocialV4ProviderGoogle] getMyGoogleProfileWithPlayServicesAuth, getCurrentAccount exist.");
            INSTANCE.handleProfile(listener, currentAccount);
        } else {
            if (useSilentSignIn) {
                ProviderGoogleSignIn googleSignIn3 = getGoogleSignIn();
                if (googleSignIn3 != null) {
                    googleSignIn3.silentSignIn(new Function3() { // from class: com.hive.socialv4.provider.SocialV4ProviderGoogle$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return SocialV4ProviderGoogle.getMyGoogleProfileWithPlayServicesAuth$lambda$10$lambda$8(this.f$0, listener, ((Boolean) obj).booleanValue(), (String) obj2, (GoogleSignInModule.GoogleAccount) obj3);
                        }
                    });
                    return;
                }
                return;
            }
            ProviderGoogleSignIn googleSignIn4 = getGoogleSignIn();
            if (googleSignIn4 != null) {
                googleSignIn4.signIn(new Function3() { // from class: com.hive.socialv4.provider.SocialV4ProviderGoogle$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SocialV4ProviderGoogle.getMyGoogleProfileWithPlayServicesAuth$lambda$10$lambda$9(this.f$0, listener, ((Boolean) obj).booleanValue(), (String) obj2, (GoogleSignInModule.GoogleAccount) obj3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyGoogleProfileWithPlayServicesAuth$lambda$10$lambda$8(SocialV4ProviderGoogle socialV4ProviderGoogle, SocialV4ProviderAdapter.SocialV4GoogleProfileListener socialV4GoogleProfileListener, boolean z, String str, GoogleSignInModule.GoogleAccount googleAccount) {
        if (!z || googleAccount == null) {
            LoggerImpl.INSTANCE.d("[SocialV4ProviderGoogle] googleSilentSignIn signIn failed.");
            socialV4ProviderGoogle.getMyGoogleProfileWithPlayServicesAuth(false, socialV4GoogleProfileListener);
        } else {
            LoggerImpl.INSTANCE.d("[SocialV4ProviderGoogle] googleSilentSignIn signIn Success.");
            socialV4ProviderGoogle.handleProfile(socialV4GoogleProfileListener, googleAccount);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyGoogleProfileWithPlayServicesAuth$lambda$10$lambda$9(SocialV4ProviderGoogle socialV4ProviderGoogle, SocialV4ProviderAdapter.SocialV4GoogleProfileListener socialV4GoogleProfileListener, boolean z, String str, GoogleSignInModule.GoogleAccount googleAccount) {
        if (!z || googleAccount == null) {
            LoggerImpl.INSTANCE.w("[SocialV4ProviderGoogle] googleSignIn signIn failed. : " + str);
            socialV4GoogleProfileListener.onProfile(new ResultAPI(-8, ResultAPI.Code.SocialGoogleResponseFailConnect, str), new ArrayList<>());
        } else {
            LoggerImpl.INSTANCE.d("[SocialV4ProviderGoogle] googleSignIn signIn Success.");
            socialV4ProviderGoogle.handleProfile(socialV4GoogleProfileListener, googleAccount);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject getUserDataFromGoogleSignInApi() {
        Object objM7415constructorimpl;
        Object objM7415constructorimpl2;
        JSONObject jSONObject = new JSONObject();
        GoogleSignInModule loginSuccessObject = AuthV4ProviderGoogle.INSTANCE.getLoginSuccessObject();
        GoogleSignInModule.GoogleAccount currentAccount = loginSuccessObject != null ? loginSuccessObject.getCurrentAccount() : null;
        if (currentAccount != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                jSONObject.put("uid", currentAccount.getOpenId());
                jSONObject.put("email", currentAccount.getEmail());
                jSONObject.put(FirebaseAnalytics.Param.SCREEN_NAME, currentAccount.getDisplayName());
                objM7415constructorimpl = Result.m7415constructorimpl(jSONObject.put("picture", currentAccount.getPhotoUrl()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                LoggerImpl.INSTANCE.w("getUserDataFromGoogleSignInApi e:" + thM7418exceptionOrNullimpl.getMessage());
            }
        } else {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                jSONObject.put(NotificationCompat.CATEGORY_SERVICE, INSTANCE.getServiceName());
                jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_PROFILE);
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                objM7415constructorimpl2 = Result.m7415constructorimpl(jSONObject.put("error_msg", "Can not get current Person."));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM7415constructorimpl2 = Result.m7415constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable thM7418exceptionOrNullimpl2 = Result.m7418exceptionOrNullimpl(objM7415constructorimpl2);
            if (thM7418exceptionOrNullimpl2 != null) {
                LoggerImpl.INSTANCE.w("getUserDataFromGoogleSignInApi e:" + thM7418exceptionOrNullimpl2.getMessage());
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderGoogleCredentialSignIn googleCredentialSignIn_delegate$lambda$1() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderGoogleCredentialSignIn.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderGoogleCredentialSignIn)) {
            hiveModule = null;
        }
        return (ProviderGoogleCredentialSignIn) (hiveModule instanceof ProviderGoogleCredentialSignIn ? hiveModule : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderGoogleSignIn googleSignIn_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderGoogleSignIn.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderGoogleSignIn)) {
            hiveModule = null;
        }
        return (ProviderGoogleSignIn) (hiveModule instanceof ProviderGoogleSignIn ? hiveModule : null);
    }

    private final void handleProfile(SocialV4ProviderAdapter.SocialV4GoogleProfileListener listener, GoogleSignInModule.GoogleAccount account) {
        if (account != null) {
            LoggerImpl.INSTANCE.d("[SocialV4ProviderGoogle] handleProfile");
            ResultAPI resultAPI = new ResultAPI();
            ArrayList<SocialV4ProviderAdapter.SocialV4GoogleProfile> arrayList = new ArrayList<>();
            SocialV4ProviderAdapter.SocialV4GoogleProfile socialV4GoogleProfile = new SocialV4ProviderAdapter.SocialV4GoogleProfile();
            String openId = account.getOpenId();
            if (openId == null) {
                openId = "";
            }
            socialV4GoogleProfile.setUserId(openId);
            String openIdToken = account.getOpenIdToken();
            if (openIdToken == null) {
                openIdToken = "";
            }
            socialV4GoogleProfile.setUserToken(openIdToken);
            String email = account.getEmail();
            if (email == null) {
                email = "";
            }
            socialV4GoogleProfile.setEmail(email);
            String displayName = account.getDisplayName();
            if (displayName == null) {
                displayName = "";
            }
            socialV4GoogleProfile.setDisplayName(displayName);
            String photoUrl = account.getPhotoUrl();
            socialV4GoogleProfile.setProfileImageUrl(photoUrl != null ? photoUrl : "");
            arrayList.add(socialV4GoogleProfile);
            Unit unit = Unit.INSTANCE;
            listener.onProfile(resultAPI, arrayList);
        }
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void disconnect() {
        GoogleSignInModule loginSuccessObject = AuthV4ProviderGoogle.INSTANCE.getLoginSuccessObject();
        if (loginSuccessObject != null) {
            loginSuccessObject.signOut(new Function2() { // from class: com.hive.socialv4.provider.SocialV4ProviderGoogle$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialV4ProviderGoogle.disconnect$lambda$17(((Boolean) obj).booleanValue(), (String) obj2);
                }
            });
        }
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public int getGoogleFriends(SocialV4ProviderAdapter.SocialV4GoogleProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return getMyGoogleProfile(listener);
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public int getMyGoogleProfile(SocialV4ProviderAdapter.SocialV4GoogleProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!ConfigurationImpl.INSTANCE.getUseGoogleCredentialSignIn()) {
            getMyGoogleProfileWithPlayServicesAuth(true, listener);
            return -9;
        }
        GoogleSignInModule loginSuccessObject = AuthV4ProviderGoogle.INSTANCE.getLoginSuccessObject();
        if (loginSuccessObject == null) {
            listener.onProfile(new ResultAPI(-6, ResultAPI.Code.SocialGoogleCancelConnect, "Google Sign-In is not available"), new ArrayList<>());
            return -9;
        }
        if (loginSuccessObject instanceof ProviderGoogleCredentialSignIn) {
            INSTANCE.getMyGoogleProfileWithGoogleCredential(listener);
            return -9;
        }
        if (!(loginSuccessObject instanceof ProviderGoogleSignIn)) {
            return -9;
        }
        INSTANCE.getMyGoogleProfileWithPlayServicesAuth(false, listener);
        return -9;
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public String getServiceName() {
        return "googleplus";
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void handleSocialIsAuthorizedScheme(SocialV4ProviderAdapter.SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        JSONObject jSONObject = new JSONObject();
        try {
            SocialV4ProviderGoogle socialV4ProviderGoogle = INSTANCE;
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, socialV4ProviderGoogle.getServiceName());
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_IS_AUTHORIZED);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
            jSONObject.put("is_authorized", socialV4ProviderGoogle.isConnected() ? 1 : 0);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("handleSocialIsAuthorizedScheme e:" + e.getMessage());
        }
        listener.onResult(jSONObject);
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void handleSocialLogoutScheme(SocialV4ProviderAdapter.SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        JSONObject jSONObject = new JSONObject();
        try {
            SocialV4ProviderGoogle socialV4ProviderGoogle = INSTANCE;
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, socialV4ProviderGoogle.getServiceName());
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_LOGOUT);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
            if (socialV4ProviderGoogle.isConnected()) {
                socialV4ProviderGoogle.disconnect();
                jSONObject.put("result", 1);
            } else {
                jSONObject.put("result", 0);
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("handleSocialLogoutScheme e:" + e.getMessage());
        }
        listener.onResult(jSONObject);
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void handleSocialRequestFriendsScheme(SocialV4ProviderAdapter.SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, INSTANCE.getServiceName());
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_FRIENDS);
            jSONObject.put(NativeProtocol.AUDIENCE_FRIENDS, new JSONArray());
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("handleSocialRequestFriendsScheme e:" + e.getMessage());
        }
        listener.onResult(jSONObject);
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void handleSocialRequestUserProfileScheme(final SocialV4ProviderAdapter.SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getMyGoogleProfile(new SocialV4ProviderAdapter.SocialV4GoogleProfileListener() { // from class: com.hive.socialv4.provider.SocialV4ProviderGoogle.handleSocialRequestUserProfileScheme.1
            @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4GoogleProfileListener
            public void onProfile(ResultAPI resultAPI, ArrayList<SocialV4ProviderAdapter.SocialV4GoogleProfile> profileList) {
                Object objM7415constructorimpl;
                Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(NotificationCompat.CATEGORY_SERVICE, SocialV4ProviderGoogle.INSTANCE.getServiceName());
                    jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_PROFILE);
                    SocialV4ProviderAdapter.SocialV4GoogleProfile socialV4GoogleProfile = null;
                    if (profileList != null) {
                        if (profileList.isEmpty()) {
                            profileList = null;
                        }
                        if (profileList != null) {
                            socialV4GoogleProfile = profileList.get(0);
                        }
                    }
                    if (!resultAPI.isSuccess() || socialV4GoogleProfile == null) {
                        jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
                    } else {
                        jSONObject.put("uid", socialV4GoogleProfile.getUserId());
                        jSONObject.put("email", socialV4GoogleProfile.getEmail());
                        jSONObject.put("username", socialV4GoogleProfile.getDisplayName());
                        jSONObject.put("picture", socialV4GoogleProfile.getProfileImageUrl());
                        jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                    }
                    objM7415constructorimpl = Result.m7415constructorimpl(jSONObject);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                JSONObject jSONObject2 = new JSONObject();
                if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
                    objM7415constructorimpl = jSONObject2;
                }
                listener.onResult((JSONObject) objM7415constructorimpl);
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void handleSocialRequestUserTokenScheme(final SocialV4ProviderAdapter.SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getMyGoogleProfile(new SocialV4ProviderAdapter.SocialV4GoogleProfileListener() { // from class: com.hive.socialv4.provider.SocialV4ProviderGoogle.handleSocialRequestUserTokenScheme.1
            @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4GoogleProfileListener
            public void onProfile(ResultAPI resultAPI, ArrayList<SocialV4ProviderAdapter.SocialV4GoogleProfile> profileList) {
                Object objM7415constructorimpl;
                Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(NotificationCompat.CATEGORY_SERVICE, SocialV4ProviderGoogle.INSTANCE.getServiceName());
                    jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_TOKEN);
                    SocialV4ProviderAdapter.SocialV4GoogleProfile socialV4GoogleProfile = null;
                    if (profileList != null) {
                        if (profileList.isEmpty()) {
                            profileList = null;
                        }
                        if (profileList != null) {
                            socialV4GoogleProfile = profileList.get(0);
                        }
                    }
                    if (!resultAPI.isSuccess() || socialV4GoogleProfile == null) {
                        jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
                    } else {
                        jSONObject.put("uid", socialV4GoogleProfile.getUserId());
                        jSONObject.put("token", socialV4GoogleProfile.getUserToken());
                        jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                    }
                    objM7415constructorimpl = Result.m7415constructorimpl(jSONObject);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                JSONObject jSONObject2 = new JSONObject();
                if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
                    objM7415constructorimpl = jSONObject2;
                }
                listener.onResult((JSONObject) objM7415constructorimpl);
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public int isAuthorized(SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            SocialV4ProviderGoogle socialV4ProviderGoogle = INSTANCE;
            jSONObject.put("is_authorized", socialV4ProviderGoogle.isConnected() ? 1 : 0);
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, socialV4ProviderGoogle.getServiceName());
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_IS_AUTHORIZED);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
            objM7415constructorimpl = Result.m7415constructorimpl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        JSONObject jSONObject2 = new JSONObject();
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = jSONObject2;
        }
        ResultAPI resultAPI = new ResultAPI();
        String string = ((JSONObject) objM7415constructorimpl).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        listener.onComplete(resultAPI, string);
        return 0;
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public boolean isConnected() {
        GoogleSignInModule loginSuccessObject = AuthV4ProviderGoogle.INSTANCE.getLoginSuccessObject();
        return (loginSuccessObject != null ? loginSuccessObject.getCurrentAccount() : null) != null;
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public int requestSocialConnect(final SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return getMyGoogleProfile(new SocialV4ProviderAdapter.SocialV4GoogleProfileListener() { // from class: com.hive.socialv4.provider.SocialV4ProviderGoogle.requestSocialConnect.1
            @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4GoogleProfileListener
            public void onProfile(ResultAPI resultAPI, ArrayList<SocialV4ProviderAdapter.SocialV4GoogleProfile> profileList) {
                Object objM7415constructorimpl;
                Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                if (resultAPI.isFailure()) {
                    SocialV4ProviderAdapter.SocialV4RequestListener socialV4RequestListener = listener;
                    String string = new JSONObject().toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    socialV4RequestListener.onComplete(resultAPI, string);
                    return;
                }
                final SocialV4ProviderAdapter.SocialV4RequestListener socialV4RequestListener2 = listener;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    SocialV4ProviderGoogle socialV4ProviderGoogle = SocialV4ProviderGoogle.INSTANCE;
                    jSONObject.put("service_type", socialV4ProviderGoogle.getServiceName());
                    jSONObject.put("user_data", socialV4ProviderGoogle.getUserDataFromGoogleSignInApi());
                    objM7415constructorimpl = Result.m7415constructorimpl(Integer.valueOf(SocialHiveImpl.INSTANCE.asyncRequest(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_CONNECT, jSONObject, new SocialHive.AsyncRequestListener() { // from class: com.hive.socialv4.provider.SocialV4ProviderGoogle$requestSocialConnect$1$onProfile$1$1
                        @Override // com.hive.SocialHive.AsyncRequestListener
                        public void onComplete(ResultAPI result, JSONObject responseJsonData) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            SocialV4ProviderAdapter.SocialV4RequestListener socialV4RequestListener3 = socialV4RequestListener2;
                            if (responseJsonData == null) {
                                responseJsonData = new JSONObject();
                            }
                            String string2 = responseJsonData.toString();
                            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                            socialV4RequestListener3.onComplete(result, string2);
                        }
                    })));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Result.m7414boximpl(objM7415constructorimpl);
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void resetGoogleLoginType() {
        AuthV4ProviderGoogle.INSTANCE.removeLoginSuccessType();
    }
}
