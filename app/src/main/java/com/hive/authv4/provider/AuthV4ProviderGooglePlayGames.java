package com.hive.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.authv4.AuthV4Network;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JW\u0010\n\u001a\u00020\u000b2O\u0010\f\u001aK\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\rJ\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016Ja\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00122O\u0010\f\u001aK\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\rH\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\""}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderGooglePlayGames;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "googlePlayGames", "Lcom/hive/module/interfaces/authv4/provider/ProviderGooglePlayGames;", "getGooglePlayGames", "()Lcom/hive/module/interfaces/authv4/provider/ProviderGooglePlayGames;", "googlePlayGames$delegate", "Lkotlin/Lazy;", "getPlayerId", "", "callback", "Lkotlin/Function3;", "Lcom/hive/ResultAPI;", "Lkotlin/ParameterName;", "name", "resultApi", "", "playerId", "token", "login", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "logoutListener", "bRemoveProviderAlso", "", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "signInSuccessful", "authCode", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderGooglePlayGames extends AuthV4ProviderAdapter {
    public static final AuthV4ProviderGooglePlayGames INSTANCE = new AuthV4ProviderGooglePlayGames();

    /* JADX INFO: renamed from: googlePlayGames$delegate, reason: from kotlin metadata */
    private static final Lazy googlePlayGames = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderGooglePlayGames$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AuthV4ProviderGooglePlayGames.googlePlayGames_delegate$lambda$0();
        }
    });

    private AuthV4ProviderGooglePlayGames() {
        super(AuthV4.ProviderType.GOOGLE_PLAY_GAMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$8(AuthV4ProviderAdapter.ProviderFriendsListener providerFriendsListener, String str) {
        providerFriendsListener.onProviderFriendsListener(new ResultAPI(-2, ResultAPI.Code.AuthV4ProviderNotSupportGetFriends, str), null);
    }

    private final ProviderGooglePlayGames getGooglePlayGames() {
        return (ProviderGooglePlayGames) googlePlayGames.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPlayerId$lambda$1(Function3 function3, String str, String str2) {
        if (str != null) {
            LoggerImpl.INSTANCE.d("[AuthV4GooglePlayGames] getPlayerId - Authenticated");
            INSTANCE.signInSuccessful(str, function3);
        } else {
            LoggerImpl.INSTANCE.w("[AuthV4GooglePlayGames] getPlayerId - Authenticated failed.\nfailReason = " + str2);
            function3.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailPGSGetPlayerId, str2), null, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderGooglePlayGames googlePlayGames_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderGooglePlayGames.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderGooglePlayGames)) {
            hiveModule = null;
        }
        return (ProviderGooglePlayGames) (hiveModule instanceof ProviderGooglePlayGames ? hiveModule : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$6(final AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, String str, String str2) {
        if (str != null) {
            LoggerImpl.INSTANCE.d("[AuthV4GooglePlayGames] login - Authenticated");
            INSTANCE.signInSuccessful(str, new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderGooglePlayGames$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthV4ProviderGooglePlayGames.login$lambda$6$lambda$3(providerLoginListener, (ResultAPI) obj, (String) obj2, (String) obj3);
                }
            });
        } else {
            ProviderGooglePlayGames googlePlayGames2 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames2 != null) {
                googlePlayGames2.signIn(new Function2() { // from class: com.hive.authv4.provider.AuthV4ProviderGooglePlayGames$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AuthV4ProviderGooglePlayGames.login$lambda$6$lambda$5(providerLoginListener, (String) obj, (String) obj2);
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$6$lambda$3(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, ResultAPI resultApi, String str, String str2) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        providerLoginListener.onProviderLoginListener(resultApi);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$6$lambda$5(final AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, String str, String str2) {
        if (str != null) {
            LoggerImpl.INSTANCE.d("[AuthV4GooglePlayGames] login - Sign-In successful.");
            INSTANCE.signInSuccessful(str, new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderGooglePlayGames$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthV4ProviderGooglePlayGames.login$lambda$6$lambda$5$lambda$4(providerLoginListener, (ResultAPI) obj, (String) obj2, (String) obj3);
                }
            });
        } else {
            LoggerImpl.INSTANCE.w("[AuthV4GooglePlayGames] login - Sign-In failed : " + str2);
            providerLoginListener.onProviderLoginListener(new ResultAPI(-8, ResultAPI.Code.AuthV4ProviderLoginError, str2));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$6$lambda$5$lambda$4(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, ResultAPI resultApi, String str, String str2) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        providerLoginListener.onProviderLoginListener(resultApi);
        return Unit.INSTANCE;
    }

    private final void signInSuccessful(String authCode, final Function3<? super ResultAPI, ? super String, ? super String, Unit> callback) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL("[AuthV4ProviderGooglePlayGames] signInSuccessful() - " + authCode);
        loggerImpl.dR("[AuthV4ProviderGooglePlayGames] signInSuccessful()");
        ProviderGooglePlayGames googlePlayGames2 = getGooglePlayGames();
        String playGamesRedirectUri = googlePlayGames2 != null ? googlePlayGames2.getPlayGamesRedirectUri() : null;
        if (StringsKt.isBlank(authCode) || playGamesRedirectUri == null || !(!StringsKt.isBlank(playGamesRedirectUri))) {
            callback.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4ProviderLoginError, "Auth Code is empty."), null, null);
        } else {
            AuthV4Network.INSTANCE.getAuthIdpToken(getIdpType(), authCode, playGamesRedirectUri, new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderGooglePlayGames$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthV4ProviderGooglePlayGames.signInSuccessful$lambda$9(callback, (ResultAPI) obj, (String) obj2, (String) obj3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signInSuccessful$lambda$9(Function3 function3, ResultAPI resultApi, String userId, String token) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(token, "token");
        if (!resultApi.isSuccess()) {
            LoggerImpl.INSTANCE.w("[AuthV4ProviderGooglePlayGames] getTokenWithAuthCode, fail to do getAuthIdpToken");
            resultApi = new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidResponseData, "getAuthIdpToken invalid response data");
        } else if (StringsKt.isBlank(userId) || StringsKt.isBlank(token)) {
            LoggerImpl.INSTANCE.w("[AuthV4ProviderGooglePlayGames] getTokenWithAuthCode, fail to get userId and token");
            resultApi = new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidResponseData, "getAuthIdpToken invalid response data(empty - token, userId");
        } else {
            LoggerImpl.INSTANCE.d("[AuthV4ProviderGooglePlayGames] getTokenWithAuthCode, get userId and token");
            AuthV4ProviderGooglePlayGames authV4ProviderGooglePlayGames = INSTANCE;
            authV4ProviderGooglePlayGames.getMyProviderInfo().setProviderUserId(userId);
            authV4ProviderGooglePlayGames.setUserToken(token);
            authV4ProviderGooglePlayGames.setLogIn(true);
        }
        AuthV4ProviderGooglePlayGames authV4ProviderGooglePlayGames2 = INSTANCE;
        function3.invoke(resultApi, authV4ProviderGooglePlayGames2.getMyProviderInfo().getProviderUserId(), authV4ProviderGooglePlayGames2.getUserToken());
        return Unit.INSTANCE;
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "[AuthV4GooglePlayGames] getFriends() - Google is not supported provider.";
        LoggerImpl.INSTANCE.w("[AuthV4GooglePlayGames] getFriends() - Google is not supported provider.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderGooglePlayGames$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderGooglePlayGames.getFriends$lambda$8(listener, str);
            }
        });
    }

    public final void getPlayerId(final Function3<? super ResultAPI, ? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ProviderGooglePlayGames googlePlayGames2 = getGooglePlayGames();
        if (googlePlayGames2 != null) {
            googlePlayGames2.isAuthenticated(new Function2() { // from class: com.hive.authv4.provider.AuthV4ProviderGooglePlayGames$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthV4ProviderGooglePlayGames.getPlayerId$lambda$1(callback, (String) obj, (String) obj2);
                }
            });
        } else {
            LoggerImpl.INSTANCE.w("[AuthV4GooglePlayGames] getPlayerId - Create the Google Api Client failed.");
            callback.invoke(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "GooglePlayGames does not exist."), null, null);
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public boolean isProvisionalKey() {
        String playGamesServerClientId;
        ProviderGooglePlayGames googlePlayGames2 = getGooglePlayGames();
        if (googlePlayGames2 == null || (playGamesServerClientId = googlePlayGames2.getPlayGamesServerClientId()) == null) {
            return false;
        }
        return !StringsKt.isBlank(playGamesServerClientId);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void login(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4GooglePlayGames] login()");
        if (getGooglePlayGames() == null) {
            loggerImpl.w("[AuthV4GooglePlayGames] login - GooglePlayGames does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "GooglePlayGames does not exist."));
        } else {
            if (!isProvisionalKey()) {
                loggerImpl.w("[AuthV4GooglePlayGames] login - Provisional key does not exist.");
                listener.onProviderLoginListener(new ResultAPI(-1, ResultAPI.Code.AuthV4ProviderMissingKey, "Provisional key does not exist"));
                return;
            }
            ProviderGooglePlayGames googlePlayGames2 = getGooglePlayGames();
            if (googlePlayGames2 != null) {
                googlePlayGames2.isAuthenticated(new Function2() { // from class: com.hive.authv4.provider.AuthV4ProviderGooglePlayGames$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AuthV4ProviderGooglePlayGames.login$lambda$6(listener, (String) obj, (String) obj2);
                    }
                });
            } else {
                loggerImpl.w("[AuthV4GooglePlayGames] login - Create the Google Api Client failed.");
                listener.onProviderLoginListener(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidProviderType, "Create the Google Api Client failed."));
            }
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[AuthV4GooglePlayGames] logout()");
        if (getIsLogIn()) {
            getMyProviderInfo().setProviderUserId("");
            getMyProviderInfo().setProviderAppId(null);
            setUserName(null);
            setUserProfileImage(null);
            setUserToken(null);
            setLogIn(false);
        }
        listener.onProviderLogoutListener(new ResultAPI());
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener logoutListener, boolean bRemoveProviderAlso) {
        Intrinsics.checkNotNullParameter(logoutListener, "logoutListener");
        logout(logoutListener);
    }
}
