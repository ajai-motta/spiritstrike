package com.hive.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderSteam;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011H\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderSteam;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "steam", "Lcom/hive/module/interfaces/authv4/provider/ProviderSteam;", "getSteam", "()Lcom/hive/module/interfaces/authv4/provider/ProviderSteam;", "steam$delegate", "Lkotlin/Lazy;", "isLoginProgress", "", "login", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "logoutListener", "bRemoveProviderAlso", "getProfile", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderGetProfileListener;", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderSteam extends AuthV4ProviderAdapter {
    private static boolean isLoginProgress;
    public static final AuthV4ProviderSteam INSTANCE = new AuthV4ProviderSteam();

    /* JADX INFO: renamed from: steam$delegate, reason: from kotlin metadata */
    private static final Lazy steam = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderSteam$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AuthV4ProviderSteam.steam_delegate$lambda$0();
        }
    });

    private AuthV4ProviderSteam() {
        super(AuthV4.ProviderType.STEAM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$4(AuthV4ProviderAdapter.ProviderFriendsListener providerFriendsListener, String str) {
        providerFriendsListener.onProviderFriendsListener(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, str), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProfile$lambda$3(AuthV4ProviderAdapter.ProviderGetProfileListener providerGetProfileListener, String str) {
        if (providerGetProfileListener != null) {
            providerGetProfileListener.onProviderGetProfileListener(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, str));
        }
    }

    private final ProviderSteam getSteam() {
        return (ProviderSteam) steam.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$1(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, String str, String str2) {
        isLoginProgress = false;
        if (str == null || StringsKt.isBlank(str) || str2 == null || StringsKt.isBlank(str2)) {
            AuthV4ProviderSteam authV4ProviderSteam = INSTANCE;
            authV4ProviderSteam.getMyProviderInfo().setProviderUserId("");
            authV4ProviderSteam.setUserToken(null);
            authV4ProviderSteam.setLogIn(false);
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-6, ResultAPI.Code.AuthV4ProviderLoginCancel), providerLoginListener);
        } else {
            AuthV4ProviderSteam authV4ProviderSteam2 = INSTANCE;
            authV4ProviderSteam2.getMyProviderInfo().setProviderUserId(str2);
            authV4ProviderSteam2.setUserToken(str);
            authV4ProviderSteam2.setLogIn(true);
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLoginListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderSteam steam_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderSteam.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderSteam)) {
            hiveModule = null;
        }
        return (ProviderSteam) (hiveModule instanceof ProviderSteam ? hiveModule : null);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "[AuthV4ProviderSteam] getFriends() - not supported.";
        LoggerImpl.INSTANCE.w("[AuthV4ProviderSteam] getFriends() - not supported.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderSteam$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderSteam.getFriends$lambda$4(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getProfile(final AuthV4ProviderAdapter.ProviderGetProfileListener listener) {
        final String str = "[AuthV4ProviderSteam] getProfile() - not supported.";
        LoggerImpl.INSTANCE.w("[AuthV4ProviderSteam] getProfile() - not supported.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderSteam$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderSteam.getProfile$lambda$3(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public boolean isProvisionalKey() {
        return true;
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void login(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i("[AuthV4ProviderSteam] Steam Login");
        if (getSteam() == null) {
            loggerImpl.w("[AuthV4ProviderSteam] login - Steam does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Steam does not exist."));
            return;
        }
        if (!isProvisionalKey()) {
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-1, ResultAPI.Code.AuthV4ProviderMissingKey, "Provisional key does not exist"), listener);
            return;
        }
        if (isLoginProgress) {
            loggerImpl.w("[AuthV4ProviderSteam] login in progress");
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[AuthV4ProviderSteam] login in progress"), listener);
        } else {
            isLoginProgress = true;
            ProviderSteam steam2 = getSteam();
            if (steam2 != null) {
                steam2.login(HiveActivity.INSTANCE.getRecentActivity(), new Function2() { // from class: com.hive.authv4.provider.AuthV4ProviderSteam$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AuthV4ProviderSteam.login$lambda$1(listener, (String) obj, (String) obj2);
                    }
                });
            } else {
                listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Steam does not exist."));
            }
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[AuthV4ProviderSteam] Steam Logout");
        getMyProviderInfo().setProviderUserId("");
        setUserToken(null);
        setLogIn(false);
        AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), listener);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener logoutListener, boolean bRemoveProviderAlso) {
        Intrinsics.checkNotNullParameter(logoutListener, "logoutListener");
        logout(logoutListener);
    }
}
