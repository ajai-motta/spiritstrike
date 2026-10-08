package com.hive.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderVk;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderVk;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "providerVk", "Lcom/hive/module/interfaces/authv4/provider/ProviderVk;", "getProviderVk", "()Lcom/hive/module/interfaces/authv4/provider/ProviderVk;", "providerVk$delegate", "Lkotlin/Lazy;", "login", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "logoutListener", "bRemoveProviderAlso", "", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderVk extends AuthV4ProviderAdapter {
    public static final AuthV4ProviderVk INSTANCE = new AuthV4ProviderVk();

    /* JADX INFO: renamed from: providerVk$delegate, reason: from kotlin metadata */
    private static final Lazy providerVk = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderVk$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AuthV4ProviderVk.providerVk_delegate$lambda$0();
        }
    });

    private AuthV4ProviderVk() {
        super(AuthV4.ProviderType.VK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$5(AuthV4ProviderAdapter.ProviderFriendsListener providerFriendsListener, String str) {
        providerFriendsListener.onProviderFriendsListener(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, str), null);
    }

    private final ProviderVk getProviderVk() {
        return (ProviderVk) providerVk.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$2$lambda$1(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, ProviderVk.VkUser vkUser, String str) {
        if (vkUser != null) {
            LoggerImpl.INSTANCE.d("[AuthV4ProviderVk] Login success.\n    " + vkUser + '\n');
            AuthV4ProviderVk authV4ProviderVk = INSTANCE;
            authV4ProviderVk.setUserToken(vkUser.getIdToken());
            AuthV4.ProviderInfo myProviderInfo = authV4ProviderVk.getMyProviderInfo();
            ProviderVk providerVk2 = authV4ProviderVk.getProviderVk();
            myProviderInfo.setProviderAppId(providerVk2 != null ? providerVk2.getVkClientId() : null);
            authV4ProviderVk.getMyProviderInfo().setProviderUserId(vkUser.getId());
            authV4ProviderVk.setUserName(vkUser.getName());
            authV4ProviderVk.setUserProfileImage(vkUser.getAvatar());
            authV4ProviderVk.setLogIn(true);
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLoginListener);
        } else {
            LoggerImpl.INSTANCE.d("[Provider VK] Login, fail to receive accessToken.");
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-6, ResultAPI.Code.AuthV4ProviderLoginCancel, str), providerLoginListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logout$lambda$4(AuthV4ProviderAdapter.ProviderLogoutListener providerLogoutListener) {
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[Provider VK] logout success.");
        AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLogoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderVk providerVk_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderVk.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderVk)) {
            hiveModule = null;
        }
        return (ProviderVk) (hiveModule instanceof ProviderVk ? hiveModule : null);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "[Provider VK] GetFriends - not supported provider.";
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Provider VK] GetFriends - not supported provider.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderVk$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderVk.getFriends$lambda$5(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public boolean isProvisionalKey() {
        String vkClientId;
        ProviderVk providerVk2 = getProviderVk();
        return (providerVk2 == null || (vkClientId = providerVk2.getVkClientId()) == null || !(StringsKt.isBlank(vkClientId) ^ true)) ? false : true;
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void login(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4ProviderVk] VK Login");
        if (getProviderVk() == null) {
            loggerImpl.w("[AuthV4ProviderVk] login - VK does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "VK does not exist."));
        } else {
            if (!isProvisionalKey()) {
                loggerImpl.w("[AuthV4ProviderVk] login - Provisional key does not exist.");
                listener.onProviderLoginListener(new ResultAPI(-1, ResultAPI.Code.AuthV4ProviderMissingKey, "Provisional key does not exist"));
                return;
            }
            ProviderVk providerVk2 = getProviderVk();
            if (providerVk2 != null) {
                providerVk2.login(HiveActivity.INSTANCE.getRecentActivity(), new Function2() { // from class: com.hive.authv4.provider.AuthV4ProviderVk$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AuthV4ProviderVk.login$lambda$2$lambda$1(listener, (ProviderVk.VkUser) obj, (String) obj2);
                    }
                });
            } else {
                listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "VK does not exist."));
            }
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(final AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Provider VK] Logout");
        setUserToken(null);
        getMyProviderInfo().setProviderUserId("");
        setUserName(null);
        setLogIn(false);
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderVk$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderVk.logout$lambda$4(listener);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener logoutListener, boolean bRemoveProviderAlso) {
        Intrinsics.checkNotNullParameter(logoutListener, "logoutListener");
        logout(logoutListener);
    }
}
