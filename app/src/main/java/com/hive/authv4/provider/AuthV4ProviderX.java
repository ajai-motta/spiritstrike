package com.hive.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderX;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderX;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "providerX", "Lcom/hive/module/interfaces/authv4/provider/ProviderX;", "getProviderX", "()Lcom/hive/module/interfaces/authv4/provider/ProviderX;", "providerX$delegate", "Lkotlin/Lazy;", "login", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "logoutListener", "bRemoveProviderAlso", "", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderX extends AuthV4ProviderAdapter {
    public static final AuthV4ProviderX INSTANCE = new AuthV4ProviderX();

    /* JADX INFO: renamed from: providerX$delegate, reason: from kotlin metadata */
    private static final Lazy providerX = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderX$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AuthV4ProviderX.providerX_delegate$lambda$0();
        }
    });

    private AuthV4ProviderX() {
        super(AuthV4.ProviderType.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$5(AuthV4ProviderAdapter.ProviderFriendsListener providerFriendsListener, String str) {
        providerFriendsListener.onProviderFriendsListener(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, str), null);
    }

    private final ProviderX getProviderX() {
        return (ProviderX) providerX.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$2$lambda$1(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, String str, String str2, String str3, String str4) {
        if (str == null || !(!StringsKt.isBlank(str)) || str3 == null || !(!StringsKt.isBlank(str3))) {
            LoggerImpl.INSTANCE.d("[Provider X] Login, fail to receive accessToken.");
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-6, ResultAPI.Code.AuthV4ProviderLoginCancel, str4), providerLoginListener);
        } else {
            LoggerImpl.INSTANCE.d("[AuthV4ProviderX] Login success.\n    id: " + str + "\n    name: " + str2 + '\n');
            AuthV4ProviderX authV4ProviderX = INSTANCE;
            authV4ProviderX.setUserToken(str3);
            authV4ProviderX.getMyProviderInfo().setProviderUserId(str);
            authV4ProviderX.setUserName(str2);
            authV4ProviderX.setLogIn(true);
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLoginListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logout$lambda$4(AuthV4ProviderAdapter.ProviderLogoutListener providerLogoutListener) {
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[Provider X] logout success.");
        AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLogoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderX providerX_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderX.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderX)) {
            hiveModule = null;
        }
        return (ProviderX) (hiveModule instanceof ProviderX ? hiveModule : null);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "[Provider X] GetFriends - not supported provider.";
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Provider X] GetFriends - not supported provider.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderX$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderX.getFriends$lambda$5(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public boolean isProvisionalKey() {
        String xClientId;
        ProviderX providerX2 = getProviderX();
        return (providerX2 == null || (xClientId = providerX2.getXClientId()) == null || !(StringsKt.isBlank(xClientId) ^ true)) ? false : true;
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void login(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4ProviderX] X Login");
        if (getProviderX() == null) {
            loggerImpl.w("[AuthV4ProviderX] login - X does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "X does not exist."));
        } else {
            if (!isProvisionalKey()) {
                loggerImpl.w("[AuthV4ProviderX] login - Provisional key does not exist.");
                listener.onProviderLoginListener(new ResultAPI(-1, ResultAPI.Code.AuthV4ProviderMissingKey, "Provisional key does not exist"));
                return;
            }
            ProviderX providerX2 = getProviderX();
            if (providerX2 != null) {
                providerX2.login(HiveActivity.INSTANCE.getRecentActivity(), new Function4() { // from class: com.hive.authv4.provider.AuthV4ProviderX$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return AuthV4ProviderX.login$lambda$2$lambda$1(listener, (String) obj, (String) obj2, (String) obj3, (String) obj4);
                    }
                });
            } else {
                listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "X does not exist."));
            }
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(final AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Provider X] Logout");
        setUserToken(null);
        getMyProviderInfo().setProviderUserId("");
        setUserName(null);
        setLogIn(false);
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderX$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderX.logout$lambda$4(listener);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener logoutListener, boolean bRemoveProviderAlso) {
        Intrinsics.checkNotNullParameter(logoutListener, "logoutListener");
        logout(logoutListener);
    }
}
