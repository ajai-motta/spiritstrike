package com.hive.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderFuntapAppraisal;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011H\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderFuntap;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "providerFuntap", "Lcom/hive/module/interfaces/authv4/provider/ProviderFuntapAppraisal;", "getProviderFuntap", "()Lcom/hive/module/interfaces/authv4/provider/ProviderFuntapAppraisal;", "providerFuntap$delegate", "Lkotlin/Lazy;", "isLoginProgress", "", "login", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "logoutListener", "bRemoveProviderAlso", "getProfile", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderGetProfileListener;", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderFuntap extends AuthV4ProviderAdapter {
    private static boolean isLoginProgress;
    public static final AuthV4ProviderFuntap INSTANCE = new AuthV4ProviderFuntap();

    /* JADX INFO: renamed from: providerFuntap$delegate, reason: from kotlin metadata */
    private static final Lazy providerFuntap = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderFuntap$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AuthV4ProviderFuntap.providerFuntap_delegate$lambda$0();
        }
    });

    private AuthV4ProviderFuntap() {
        super(AuthV4.ProviderType.FUNTAP);
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

    private final ProviderFuntapAppraisal getProviderFuntap() {
        return (ProviderFuntapAppraisal) providerFuntap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$1(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, ProviderFuntapAppraisal.LoginResult result, String str, String str2) {
        Intrinsics.checkNotNullParameter(result, "result");
        isLoginProgress = false;
        if (result != ProviderFuntapAppraisal.LoginResult.Success || str == null || StringsKt.isBlank(str) || str2 == null || StringsKt.isBlank(str2)) {
            LoggerImpl.INSTANCE.i("[AuthV4ProviderFuntap] Funtap Login Fail");
            AuthV4ProviderFuntap authV4ProviderFuntap = INSTANCE;
            authV4ProviderFuntap.setUserToken(null);
            authV4ProviderFuntap.getMyProviderInfo().setProviderUserId("");
            authV4ProviderFuntap.setLogIn(false);
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-6, ResultAPI.Code.AuthV4ProviderLoginCancel), providerLoginListener);
        } else {
            LoggerImpl.INSTANCE.i("[AuthV4ProviderFuntap] Funtap Login Success");
            AuthV4ProviderFuntap authV4ProviderFuntap2 = INSTANCE;
            authV4ProviderFuntap2.setUserToken(str2);
            authV4ProviderFuntap2.getMyProviderInfo().setProviderUserId(str);
            authV4ProviderFuntap2.setLogIn(true);
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLoginListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderFuntapAppraisal providerFuntap_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderFuntapAppraisal.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderFuntapAppraisal)) {
            hiveModule = null;
        }
        return (ProviderFuntapAppraisal) (hiveModule instanceof ProviderFuntapAppraisal ? hiveModule : null);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "[AuthV4ProviderFuntap] getFriends() - not supported.";
        LoggerImpl.INSTANCE.w("[AuthV4ProviderFuntap] getFriends() - not supported.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderFuntap$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderFuntap.getFriends$lambda$4(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getProfile(final AuthV4ProviderAdapter.ProviderGetProfileListener listener) {
        final String str = "[AuthV4ProviderFuntap] getProfile() - not supported.";
        LoggerImpl.INSTANCE.w("[AuthV4ProviderFuntap] getProfile() - not supported.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderFuntap$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderFuntap.getProfile$lambda$3(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public boolean isProvisionalKey() {
        String appKey;
        ProviderFuntapAppraisal providerFuntap2 = getProviderFuntap();
        if (providerFuntap2 == null || (appKey = providerFuntap2.getAppKey()) == null) {
            return false;
        }
        return !StringsKt.isBlank(appKey);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void login(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i("[AuthV4ProviderFuntap] Funtap Login");
        if (getProviderFuntap() == null) {
            loggerImpl.w("[AuthV4ProviderFuntap] login - Funtap does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Funtap does not exist."));
            return;
        }
        if (!isProvisionalKey()) {
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-1, ResultAPI.Code.AuthV4ProviderMissingKey, "Provisional key does not exist"), listener);
            return;
        }
        if (isLoginProgress) {
            loggerImpl.w("[AuthV4ProviderFuntap] login in progress");
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[AuthV4ProviderFuntap] login in progress"), listener);
        } else {
            isLoginProgress = true;
            ProviderFuntapAppraisal providerFuntap2 = getProviderFuntap();
            if (providerFuntap2 != null) {
                providerFuntap2.login(HiveActivity.INSTANCE.getRecentActivity(), new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderFuntap$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AuthV4ProviderFuntap.login$lambda$1(listener, (ProviderFuntapAppraisal.LoginResult) obj, (String) obj2, (String) obj3);
                    }
                });
            } else {
                listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Funtap does not exist."));
            }
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[AuthV4ProviderFuntap] Funtap Logout");
        ProviderFuntapAppraisal providerFuntap2 = getProviderFuntap();
        if (providerFuntap2 != null) {
            providerFuntap2.logout();
        }
        setUserToken(null);
        getMyProviderInfo().setProviderUserId("");
        setLogIn(false);
        AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), listener);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener logoutListener, boolean bRemoveProviderAlso) {
        Intrinsics.checkNotNullParameter(logoutListener, "logoutListener");
        logout(logoutListener);
    }
}
