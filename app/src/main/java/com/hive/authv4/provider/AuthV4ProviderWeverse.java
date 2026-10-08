package com.hive.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderWeverse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011H\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderWeverse;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "weverse", "Lcom/hive/module/interfaces/authv4/provider/ProviderWeverse;", "getWeverse", "()Lcom/hive/module/interfaces/authv4/provider/ProviderWeverse;", "weverse$delegate", "Lkotlin/Lazy;", "isLoginProgress", "", "login", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "logoutListener", "bRemoveProviderAlso", "getProfile", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderGetProfileListener;", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderWeverse extends AuthV4ProviderAdapter {
    private static boolean isLoginProgress;
    public static final AuthV4ProviderWeverse INSTANCE = new AuthV4ProviderWeverse();

    /* JADX INFO: renamed from: weverse$delegate, reason: from kotlin metadata */
    private static final Lazy weverse = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderWeverse$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AuthV4ProviderWeverse.weverse_delegate$lambda$0();
        }
    });

    private AuthV4ProviderWeverse() {
        super(AuthV4.ProviderType.WEVERSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$4(AuthV4ProviderAdapter.ProviderFriendsListener providerFriendsListener, String str) {
        providerFriendsListener.onProviderFriendsListener(new ResultAPI(-2, ResultAPI.Code.AuthV4WeverseNotSupported, str), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProfile$lambda$3(AuthV4ProviderAdapter.ProviderGetProfileListener providerGetProfileListener, String str) {
        if (providerGetProfileListener != null) {
            providerGetProfileListener.onProviderGetProfileListener(new ResultAPI(-2, ResultAPI.Code.AuthV4WeverseNotSupported, str));
        }
    }

    private final ProviderWeverse getWeverse() {
        return (ProviderWeverse) weverse.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$1(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, String str, String str2, String str3) {
        isLoginProgress = false;
        if (str == null || StringsKt.isBlank(str) || str2 == null || StringsKt.isBlank(str2)) {
            AuthV4ProviderWeverse authV4ProviderWeverse = INSTANCE;
            authV4ProviderWeverse.getMyProviderInfo().setProviderUserId("");
            authV4ProviderWeverse.setUserToken(null);
            authV4ProviderWeverse.setLogIn(false);
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-6, ResultAPI.Code.AuthV4WeverseLoginCancel, str3), providerLoginListener);
        } else {
            AuthV4ProviderWeverse authV4ProviderWeverse2 = INSTANCE;
            authV4ProviderWeverse2.getMyProviderInfo().setProviderUserId(str);
            authV4ProviderWeverse2.setUserToken(str2);
            authV4ProviderWeverse2.setLogIn(true);
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLoginListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderWeverse weverse_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderWeverse.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderWeverse)) {
            hiveModule = null;
        }
        return (ProviderWeverse) (hiveModule instanceof ProviderWeverse ? hiveModule : null);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "[AuthV4ProviderWeverse] getFriends() - not supported.";
        LoggerImpl.INSTANCE.w("[AuthV4ProviderWeverse] getFriends() - not supported.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderWeverse$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderWeverse.getFriends$lambda$4(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getProfile(final AuthV4ProviderAdapter.ProviderGetProfileListener listener) {
        final String str = "[AuthV4ProviderWeverse] getProfile() - not supported.";
        LoggerImpl.INSTANCE.w("[AuthV4ProviderWeverse] getProfile() - not supported.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderWeverse$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderWeverse.getProfile$lambda$3(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public boolean isProvisionalKey() {
        String weverseClientId;
        ProviderWeverse weverse2 = getWeverse();
        return (weverse2 == null || (weverseClientId = weverse2.getWeverseClientId()) == null || !(StringsKt.isBlank(weverseClientId) ^ true)) ? false : true;
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void login(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i("[AuthV4ProviderWeverse] Weverse Login");
        if (getWeverse() == null) {
            loggerImpl.w("[AuthV4ProviderWeverse] login - Weverse does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Weverse does not exist."));
            return;
        }
        if (!isProvisionalKey()) {
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-1, ResultAPI.Code.AuthV4ProviderMissingKey, "Provisional key does not exist"), listener);
            return;
        }
        if (isLoginProgress) {
            loggerImpl.w("[AuthV4ProviderWeverse] login in progress");
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-3, ResultAPI.Code.AuthV4WeverseInProgressLoginLogout, "[AuthV4ProviderWeverse] login in progress"), listener);
        } else {
            isLoginProgress = true;
            ProviderWeverse weverse2 = getWeverse();
            if (weverse2 != null) {
                weverse2.login(HiveActivity.INSTANCE.getRecentActivity(), new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderWeverse$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AuthV4ProviderWeverse.login$lambda$1(listener, (String) obj, (String) obj2, (String) obj3);
                    }
                });
            } else {
                listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Weverse does not exist."));
            }
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[AuthV4ProviderWeverse] Weverse Logout");
        ProviderWeverse weverse2 = getWeverse();
        if (weverse2 != null) {
            weverse2.logout();
        }
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
