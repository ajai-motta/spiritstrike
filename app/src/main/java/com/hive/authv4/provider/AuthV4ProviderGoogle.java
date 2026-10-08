package com.hive.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.logger.LoggerImpl;
import com.hive.module.GoogleSignInModule;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderGoogleCredentialSignIn;
import com.hive.module.interfaces.authv4.provider.ProviderGoogleSignIn;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001c\u0010\u001e\u001a\u00020\u00162\n\u0010\u001f\u001a\u00060 j\u0002`!2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J \u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020'H\u0016J\u0018\u0010&\u001a\u00020\u00162\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0010H\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020,H\u0016J\u000e\u0010-\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0010J\u0006\u0010.\u001a\u00020\u0016J\b\u0010/\u001a\u0004\u0018\u000100R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderGoogle;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "googleSignIn", "Lcom/hive/module/interfaces/authv4/provider/ProviderGoogleSignIn;", "getGoogleSignIn", "()Lcom/hive/module/interfaces/authv4/provider/ProviderGoogleSignIn;", "googleSignIn$delegate", "Lkotlin/Lazy;", "googleCredentialSignIn", "Lcom/hive/module/interfaces/authv4/provider/ProviderGoogleCredentialSignIn;", "getGoogleCredentialSignIn", "()Lcom/hive/module/interfaces/authv4/provider/ProviderGoogleCredentialSignIn;", "googleCredentialSignIn$delegate", "hasSilentSignInRun", "", "LOGIN_SUCCESS_TYPE", "", "LOGIN_TYPE_CREDENTIAL_SIGN_IN", "LOGIN_TYPE_PLAY_SERVICES_AUTH_SIGN_IN", "login", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "signInWithCredentialManagerFirst", "signInWithPlayServicesAuthOnly", "processCredentialSilentSignIn", "processCredentialSignIn", "processPlayServicesAuthSilentSignIn", "processPlayServicesAuthSignIn", "beforeFailReason", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "signInSuccessful", "isCredential", "account", "Lcom/hive/module/GoogleSignInModule$GoogleAccount;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "logoutListener", "bRemoveProviderAlso", "isProvisionalKey", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "saveLoginSuccessType", "removeLoginSuccessType", "getLoginSuccessObject", "Lcom/hive/module/GoogleSignInModule;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderGoogle extends AuthV4ProviderAdapter {
    public static final String LOGIN_SUCCESS_TYPE = "loginSuccessType";
    public static final String LOGIN_TYPE_CREDENTIAL_SIGN_IN = "credential";
    public static final String LOGIN_TYPE_PLAY_SERVICES_AUTH_SIGN_IN = "playServicesAuth";
    private static boolean hasSilentSignInRun;
    public static final AuthV4ProviderGoogle INSTANCE = new AuthV4ProviderGoogle();

    /* JADX INFO: renamed from: googleSignIn$delegate, reason: from kotlin metadata */
    private static final Lazy googleSignIn = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderGoogle$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AuthV4ProviderGoogle.googleSignIn_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: googleCredentialSignIn$delegate, reason: from kotlin metadata */
    private static final Lazy googleCredentialSignIn = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderGoogle$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AuthV4ProviderGoogle.googleCredentialSignIn_delegate$lambda$1();
        }
    });

    private AuthV4ProviderGoogle() {
        super(AuthV4.ProviderType.GOOGLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$11(AuthV4ProviderAdapter.ProviderFriendsListener providerFriendsListener, String str) {
        providerFriendsListener.onProviderFriendsListener(new ResultAPI(-2, ResultAPI.Code.AuthV4ProviderNotSupportGetFriends, str), null);
    }

    private final ProviderGoogleCredentialSignIn getGoogleCredentialSignIn() {
        return (ProviderGoogleCredentialSignIn) googleCredentialSignIn.getValue();
    }

    private final ProviderGoogleSignIn getGoogleSignIn() {
        return (ProviderGoogleSignIn) googleSignIn.getValue();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit logout$lambda$9(AuthV4ProviderAdapter.ProviderLogoutListener providerLogoutListener, boolean z, String str) {
        if (z) {
            LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] signOut Success.");
            AuthV4ProviderGoogle authV4ProviderGoogle = INSTANCE;
            authV4ProviderGoogle.getMyProviderInfo().setProviderUserId("");
            authV4ProviderGoogle.setUserToken(null);
            authV4ProviderGoogle.setUserName(null);
            authV4ProviderGoogle.setUserProfileImage(null);
            authV4ProviderGoogle.getMyProviderInfo().setProviderAppId(null);
            authV4ProviderGoogle.setLogIn(false);
            providerLogoutListener.onProviderLogoutListener(new ResultAPI(0, ResultAPI.Code.Success));
            authV4ProviderGoogle.removeLoginSuccessType();
        } else {
            LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] signOut failed.");
            providerLogoutListener.onProviderLogoutListener(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailLogout, str));
        }
        return Unit.INSTANCE;
    }

    private final void processCredentialSignIn(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] processCredentialSignIn");
        ProviderGoogleCredentialSignIn googleCredentialSignIn2 = getGoogleCredentialSignIn();
        if (googleCredentialSignIn2 != null) {
            googleCredentialSignIn2.signIn(new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderGoogle$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthV4ProviderGoogle.processCredentialSignIn$lambda$3(listener, ((Boolean) obj).booleanValue(), (String) obj2, (GoogleSignInModule.GoogleAccount) obj3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processCredentialSignIn$lambda$3(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, boolean z, String str, GoogleSignInModule.GoogleAccount googleAccount) {
        if (!z || googleAccount == null) {
            LoggerImpl.INSTANCE.w("[AuthV4GoogleSignIn] googleCredentialSignIn signIn failed. : " + str);
            StringBuilder sb = new StringBuilder();
            sb.append("-googleCredentialSignIn signIn failed : " + str);
            sb.append('\n');
            INSTANCE.processPlayServicesAuthSignIn(sb, providerLoginListener);
        } else {
            LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] googleCredentialSignIn signIn Success.");
            INSTANCE.signInSuccessful(true, googleAccount, providerLoginListener);
        }
        return Unit.INSTANCE;
    }

    private final void processCredentialSilentSignIn(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] processCredentialSilentSignIn");
        ProviderGoogleCredentialSignIn googleCredentialSignIn2 = getGoogleCredentialSignIn();
        if (googleCredentialSignIn2 != null) {
            googleCredentialSignIn2.silentSignIn(new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderGoogle$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthV4ProviderGoogle.processCredentialSilentSignIn$lambda$2(listener, ((Boolean) obj).booleanValue(), (String) obj2, (GoogleSignInModule.GoogleAccount) obj3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processCredentialSilentSignIn$lambda$2(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, boolean z, String str, GoogleSignInModule.GoogleAccount googleAccount) {
        if (!z || googleAccount == null) {
            LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] processCredentialSilentSignIn failed.");
            StringBuilder sb = new StringBuilder();
            sb.append("-processCredentialSilentSignIn failed : " + str);
            sb.append('\n');
            INSTANCE.processPlayServicesAuthSignIn(sb, providerLoginListener);
        } else {
            LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] processCredentialSilentSignIn Success.");
            INSTANCE.signInSuccessful(true, googleAccount, providerLoginListener);
        }
        return Unit.INSTANCE;
    }

    private final void processPlayServicesAuthSignIn(final StringBuilder beforeFailReason, final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] processPlayServicesAuthSignIn");
        saveLoginSuccessType(false);
        ProviderGoogleSignIn googleSignIn2 = getGoogleSignIn();
        if (googleSignIn2 != null) {
            googleSignIn2.signIn(new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderGoogle$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthV4ProviderGoogle.processPlayServicesAuthSignIn$lambda$7$lambda$6(listener, beforeFailReason, ((Boolean) obj).booleanValue(), (String) obj2, (GoogleSignInModule.GoogleAccount) obj3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processPlayServicesAuthSignIn$lambda$7$lambda$6(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, StringBuilder sb, boolean z, String str, GoogleSignInModule.GoogleAccount googleAccount) {
        if (!z || googleAccount == null) {
            LoggerImpl.INSTANCE.w("[AuthV4GoogleSignIn] processPlayServicesAuthSignIn failed. : " + str);
            sb.append("-processPlayServicesAuthSignIn failed : " + str);
            sb.append('\n');
            ResultAPI.Code code = ResultAPI.Code.AuthV4GoogleResponseFailLogin;
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            providerLoginListener.onProviderLoginListener(new ResultAPI(-8, code, StringsKt.trim((CharSequence) string).toString()));
        } else {
            LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] processPlayServicesAuthSignIn Success.");
            INSTANCE.signInSuccessful(false, googleAccount, providerLoginListener);
        }
        return Unit.INSTANCE;
    }

    private final void processPlayServicesAuthSilentSignIn(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] processPlayServicesAuthSilentSignIn");
        ProviderGoogleSignIn googleSignIn2 = getGoogleSignIn();
        if (googleSignIn2 != null) {
            googleSignIn2.silentSignIn(new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderGoogle$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthV4ProviderGoogle.processPlayServicesAuthSilentSignIn$lambda$5$lambda$4(listener, ((Boolean) obj).booleanValue(), (String) obj2, (GoogleSignInModule.GoogleAccount) obj3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processPlayServicesAuthSilentSignIn$lambda$5$lambda$4(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, boolean z, String str, GoogleSignInModule.GoogleAccount googleAccount) {
        if (!z || googleAccount == null) {
            LoggerImpl.INSTANCE.w("[AuthV4GoogleSignIn]: processPlayServicesAuthSilentSignIn failed. : " + str + "\n Try signIn.");
            StringBuilder sb = new StringBuilder();
            sb.append("-googleCredentialSignIn signIn failed : " + str);
            sb.append('\n');
            INSTANCE.processPlayServicesAuthSignIn(sb, providerLoginListener);
        } else {
            LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] processPlayServicesAuthSilentSignIn Success.");
            AuthV4ProviderGoogle authV4ProviderGoogle = INSTANCE;
            authV4ProviderGoogle.signInSuccessful(false, googleAccount, providerLoginListener);
            authV4ProviderGoogle.saveLoginSuccessType(false);
        }
        return Unit.INSTANCE;
    }

    private final void signInSuccessful(boolean isCredential, GoogleSignInModule.GoogleAccount account, AuthV4ProviderAdapter.ProviderLoginListener listener) {
        AuthV4.ProviderInfo myProviderInfo = getMyProviderInfo();
        String openId = account.getOpenId();
        if (openId == null) {
            openId = "";
        }
        myProviderInfo.setProviderUserId(openId);
        setUserToken(account.getOpenIdToken());
        setUserName(account.getDisplayName());
        setUserProfileImage(account.getPhotoUrl());
        AuthV4.ProviderInfo myProviderInfo2 = getMyProviderInfo();
        ProviderGoogleSignIn googleSignIn2 = getGoogleSignIn();
        myProviderInfo2.setProviderAppId(googleSignIn2 != null ? googleSignIn2.getGoogleAppId() : null);
        setLogIn(true);
        listener.onProviderLoginListener(new ResultAPI(0, ResultAPI.Code.Success));
        Unit unit = Unit.INSTANCE;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        StringBuilder sb = new StringBuilder("[AuthV4GoogleSignIn] signInSuccessful: ");
        AuthV4ProviderGoogle authV4ProviderGoogle = INSTANCE;
        sb.append(authV4ProviderGoogle.getMyProviderInfo());
        loggerImpl.d(sb.toString());
        authV4ProviderGoogle.saveLoginSuccessType(isCredential);
    }

    private final void signInWithCredentialManagerFirst(AuthV4ProviderAdapter.ProviderLoginListener listener) {
        if (Intrinsics.areEqual(Property.INSTANCE.getINSTANCE().getValue(LOGIN_SUCCESS_TYPE), LOGIN_TYPE_PLAY_SERVICES_AUTH_SIGN_IN)) {
            processPlayServicesAuthSignIn(new StringBuilder(), listener);
            return;
        }
        LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] googleCredentialSignIn silentSignIn start.");
        if (hasSilentSignInRun) {
            processCredentialSignIn(listener);
        } else {
            processCredentialSilentSignIn(listener);
            hasSilentSignInRun = true;
        }
    }

    private final void signInWithPlayServicesAuthOnly(AuthV4ProviderAdapter.ProviderLoginListener listener) {
        processPlayServicesAuthSilentSignIn(listener);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "[AuthV4GoogleSignIn] getFriends() - Google is not supported provider.";
        LoggerImpl.INSTANCE.w("[AuthV4GoogleSignIn] getFriends() - Google is not supported provider.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderGoogle$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderGoogle.getFriends$lambda$11(listener, str);
            }
        });
    }

    public final GoogleSignInModule getLoginSuccessObject() {
        if (!ConfigurationImpl.INSTANCE.getUseGoogleCredentialSignIn()) {
            return getGoogleSignIn();
        }
        String value = Property.INSTANCE.getINSTANCE().getValue(LOGIN_SUCCESS_TYPE, "");
        return (Intrinsics.areEqual(value, LOGIN_TYPE_CREDENTIAL_SIGN_IN) || Intrinsics.areEqual(value, "")) ? getGoogleCredentialSignIn() : getGoogleSignIn();
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public boolean isProvisionalKey() {
        String googleServerClientId;
        ProviderGoogleSignIn googleSignIn2 = getGoogleSignIn();
        if (googleSignIn2 == null || (googleServerClientId = googleSignIn2.getGoogleServerClientId()) == null) {
            return false;
        }
        return !StringsKt.isBlank(googleServerClientId);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void login(AuthV4ProviderAdapter.ProviderLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4GoogleSignIn] login()");
        if (getGoogleSignIn() == null) {
            loggerImpl.w("[AuthV4GoogleSignIn] login - GoogleSignIn does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "GoogleSignIn does not exist."));
            return;
        }
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        if (configurationImpl.getUseGoogleCredentialSignIn() && getGoogleCredentialSignIn() == null) {
            loggerImpl.w("[AuthV4GoogleSignIn] login - GoogleCredentialSignIn does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "GoogleCredentialSignIn does not exist."));
        } else if (!isProvisionalKey()) {
            listener.onProviderLoginListener(new ResultAPI(-1, ResultAPI.Code.AuthV4ProviderMissingKey, "Provisional key does not exist"));
        } else if (configurationImpl.getUseGoogleCredentialSignIn()) {
            signInWithCredentialManagerFirst(listener);
        } else {
            signInWithPlayServicesAuthOnly(listener);
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(final AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[AuthV4GoogleSignIn] logout()");
        GoogleSignInModule googleCredentialSignIn2 = (Intrinsics.areEqual(Property.INSTANCE.getINSTANCE().getValue(LOGIN_SUCCESS_TYPE), LOGIN_TYPE_CREDENTIAL_SIGN_IN) && ConfigurationImpl.INSTANCE.getUseGoogleCredentialSignIn()) ? getGoogleCredentialSignIn() : getGoogleSignIn();
        if (googleCredentialSignIn2 != null) {
            googleCredentialSignIn2.signOut(new Function2() { // from class: com.hive.authv4.provider.AuthV4ProviderGoogle$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthV4ProviderGoogle.logout$lambda$9(listener, ((Boolean) obj).booleanValue(), (String) obj2);
                }
            });
        } else {
            listener.onProviderLogoutListener(new ResultAPI(-1, ResultAPI.Code.AuthV4GoogleNotSupported, "Create the Google Api Client failed."));
        }
    }

    public final void removeLoginSuccessType() {
        Property.Companion companion = Property.INSTANCE;
        companion.getINSTANCE().removeValue(LOGIN_SUCCESS_TYPE);
        companion.getINSTANCE().writeProperties();
    }

    public final void saveLoginSuccessType(boolean isCredential) {
        if (isCredential) {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), LOGIN_SUCCESS_TYPE, LOGIN_TYPE_CREDENTIAL_SIGN_IN, null, 4, null);
        } else {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), LOGIN_SUCCESS_TYPE, LOGIN_TYPE_PLAY_SERVICES_AUTH_SIGN_IN, null, 4, null);
        }
        Property.INSTANCE.getINSTANCE().writeProperties();
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener logoutListener, boolean bRemoveProviderAlso) {
        Intrinsics.checkNotNullParameter(logoutListener, "logoutListener");
        logout(logoutListener);
    }
}
