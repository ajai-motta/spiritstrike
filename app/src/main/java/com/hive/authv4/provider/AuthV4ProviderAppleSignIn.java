package com.hive.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.authv4.AuthV4Network;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderAppleSignIn;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016JC\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u000b0\u001fH\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006$"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderAppleSignIn;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "signInApple", "Lcom/hive/module/interfaces/authv4/provider/ProviderAppleSignIn;", "getSignInApple", "()Lcom/hive/module/interfaces/authv4/provider/ProviderAppleSignIn;", "signInApple$delegate", "Lkotlin/Lazy;", "login", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "logoutListener", "bRemoveProviderAlso", "", "getProfile", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderGetProfileListener;", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "getTokenWithAuthCode", "idpType", "Lcom/hive/AuthV4$ProviderType;", "code", "", "redirectUri", "callback", "Lkotlin/Function1;", "Lcom/hive/ResultAPI;", "Lkotlin/ParameterName;", "name", "resultApi", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderAppleSignIn extends AuthV4ProviderAdapter {
    public static final AuthV4ProviderAppleSignIn INSTANCE = new AuthV4ProviderAppleSignIn();

    /* JADX INFO: renamed from: signInApple$delegate, reason: from kotlin metadata */
    private static final Lazy signInApple = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderAppleSignIn$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AuthV4ProviderAppleSignIn.signInApple_delegate$lambda$0();
        }
    });

    private AuthV4ProviderAppleSignIn() {
        super(AuthV4.ProviderType.SIGNIN_APPLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$8(AuthV4ProviderAdapter.ProviderFriendsListener providerFriendsListener, String str) {
        providerFriendsListener.onProviderFriendsListener(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, str), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProfile$lambda$7(AuthV4ProviderAdapter.ProviderGetProfileListener providerGetProfileListener, String str) {
        if (providerGetProfileListener != null) {
            providerGetProfileListener.onProviderGetProfileListener(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, str));
        }
    }

    private final ProviderAppleSignIn getSignInApple() {
        return (ProviderAppleSignIn) signInApple.getValue();
    }

    private final void getTokenWithAuthCode(AuthV4.ProviderType idpType, final String code, String redirectUri, final Function1<? super ResultAPI, Unit> callback) {
        LoggerImpl.INSTANCE.d("[AuthV4ProviderSignInApple] getTokenWithAuthCode");
        AuthV4Network.INSTANCE.getAuthIdpToken(idpType, code, redirectUri, new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderAppleSignIn$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AuthV4ProviderAppleSignIn.getTokenWithAuthCode$lambda$9(code, callback, (ResultAPI) obj, (String) obj2, (String) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTokenWithAuthCode$lambda$9(String str, Function1 function1, ResultAPI resultApi, String userId, String token) {
        ResultAPI resultAPI;
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(token, "token");
        if (!resultApi.isSuccess()) {
            LoggerImpl.INSTANCE.d("[AuthV4ProviderSignInApple] getTokenWithAuthCode, fail to do getAuthIdpToken");
            resultAPI = new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidResponseData, "getAuthIdpToken invalid response data");
        } else if (StringsKt.isBlank(userId) || StringsKt.isBlank(token)) {
            LoggerImpl.INSTANCE.d("[AuthV4ProviderSignInApple] getTokenWithAuthCode, fail to get userId and token");
            resultAPI = new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidResponseData, "getAuthIdpToken invalid response data(empty - token, userId");
        } else {
            LoggerImpl.INSTANCE.d("[AuthV4ProviderSignInApple] getTokenWithAuthCode, get userId and token");
            AuthV4ProviderAppleSignIn authV4ProviderAppleSignIn = INSTANCE;
            authV4ProviderAppleSignIn.getMyProviderInfo().setProviderUserId(userId);
            authV4ProviderAppleSignIn.setUserToken(token);
            authV4ProviderAppleSignIn.setUserCode(str);
            authV4ProviderAppleSignIn.setLogIn(true);
            resultAPI = new ResultAPI(0, ResultAPI.Code.Success, "");
        }
        function1.invoke(resultAPI);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$4$lambda$3(ProviderAppleSignIn providerAppleSignIn, final AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, String str, String str2) {
        if (str == null || !(!StringsKt.isBlank(str))) {
            LoggerImpl.INSTANCE.d("[Provider SignInApple] Login, fail to receive auth code");
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-6, ResultAPI.Code.AuthV4AppleCancel, str2), providerLoginListener);
        } else {
            AuthV4ProviderAppleSignIn authV4ProviderAppleSignIn = INSTANCE;
            authV4ProviderAppleSignIn.getTokenWithAuthCode(authV4ProviderAppleSignIn.getIdpType(), str, providerAppleSignIn.getAppleSignInUrlDefinedRedirectUri(), new Function1() { // from class: com.hive.authv4.provider.AuthV4ProviderAppleSignIn$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4ProviderAppleSignIn.login$lambda$4$lambda$3$lambda$2(providerLoginListener, (ResultAPI) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$4$lambda$3$lambda$2(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, ResultAPI resultApi) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        LoggerImpl.INSTANCE.d("[Provider SignInApple] Login, receive auth code");
        AuthV4ProviderAdapter.INSTANCE.toMainThread(resultApi, providerLoginListener);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logout$lambda$6(AuthV4ProviderAdapter.ProviderLogoutListener providerLogoutListener) {
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[Provider SignInApple] logout success.");
        AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLogoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderAppleSignIn signInApple_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderAppleSignIn.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderAppleSignIn)) {
            hiveModule = null;
        }
        return (ProviderAppleSignIn) (hiveModule instanceof ProviderAppleSignIn ? hiveModule : null);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "[Provider SignInApple] GetFriends - not supported provider.";
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Provider SignInApple] GetFriends - not supported provider.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderAppleSignIn$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderAppleSignIn.getFriends$lambda$8(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getProfile() {
        getProfile(null);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public boolean isProvisionalKey() {
        String appleSignInServiceId;
        ProviderAppleSignIn signInApple2 = getSignInApple();
        if (signInApple2 == null || (appleSignInServiceId = signInApple2.getAppleSignInServiceId()) == null) {
            return false;
        }
        return !StringsKt.isBlank(appleSignInServiceId);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void login(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4ProviderSignInApple] SignInApple Login");
        if (getSignInApple() == null) {
            loggerImpl.w("[AuthV4ProviderSignInApple] login - SignInApple does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "SignInApple does not exist."));
            return;
        }
        if (!isProvisionalKey()) {
            loggerImpl.w("[AuthV4ProviderSignInApple] login - Provisional key does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-1, ResultAPI.Code.AuthV4ProviderMissingKey, "Provisional key does not exist"));
            return;
        }
        String userToken = getUserToken();
        if (userToken != null && INSTANCE.getIsLogIn() && !StringsKt.isBlank(userToken)) {
            loggerImpl.d("[AuthV4ProviderSignInApple] login userToken exist.");
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), listener);
            return;
        }
        final ProviderAppleSignIn signInApple2 = getSignInApple();
        if (signInApple2 != null) {
            signInApple2.login(HiveActivity.INSTANCE.getRecentActivity(), new Function2() { // from class: com.hive.authv4.provider.AuthV4ProviderAppleSignIn$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthV4ProviderAppleSignIn.login$lambda$4$lambda$3(signInApple2, listener, (String) obj, (String) obj2);
                }
            });
        } else {
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "SignInApple does not exist."));
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(final AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Provider SignInApple] Logout");
        setUserToken(null);
        getMyProviderInfo().setProviderUserId("");
        setLogIn(false);
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderAppleSignIn$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderAppleSignIn.logout$lambda$6(listener);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getProfile(final AuthV4ProviderAdapter.ProviderGetProfileListener listener) {
        final String str = "[Provider SignInApple] GetProfile - not supported provider.";
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Provider SignInApple] GetProfile - not supported provider.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderAppleSignIn$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderAppleSignIn.getProfile$lambda$7(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener logoutListener, boolean bRemoveProviderAlso) {
        Intrinsics.checkNotNullParameter(logoutListener, "logoutListener");
        logout(logoutListener);
    }
}
