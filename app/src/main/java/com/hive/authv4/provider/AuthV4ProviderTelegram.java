package com.hive.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderTelegram;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderTelegram;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "providerTelegram", "Lcom/hive/module/interfaces/authv4/provider/ProviderTelegram;", "getProviderTelegram", "()Lcom/hive/module/interfaces/authv4/provider/ProviderTelegram;", "providerTelegram$delegate", "Lkotlin/Lazy;", "login", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "logoutListener", "bRemoveProviderAlso", "", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderTelegram extends AuthV4ProviderAdapter {
    public static final AuthV4ProviderTelegram INSTANCE = new AuthV4ProviderTelegram();

    /* JADX INFO: renamed from: providerTelegram$delegate, reason: from kotlin metadata */
    private static final Lazy providerTelegram = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderTelegram$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AuthV4ProviderTelegram.providerTelegram_delegate$lambda$0();
        }
    });

    private AuthV4ProviderTelegram() {
        super(AuthV4.ProviderType.TELEGRAM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$5(AuthV4ProviderAdapter.ProviderFriendsListener providerFriendsListener, String str) {
        providerFriendsListener.onProviderFriendsListener(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, str), null);
    }

    private final ProviderTelegram getProviderTelegram() {
        return (ProviderTelegram) providerTelegram.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$2$lambda$1(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, String str, String str2, String str3, String str4) {
        if (str == null || !(!StringsKt.isBlank(str)) || str3 == null || !(!StringsKt.isBlank(str3))) {
            LoggerImpl.INSTANCE.d("[AuthV4Telegram] Login, fail to receive data.");
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-6, ResultAPI.Code.AuthV4ProviderLoginCancel, str4), providerLoginListener);
        } else {
            LoggerImpl.INSTANCE.d("[AuthV4Telegram] Login success.\n    id: " + str + "\n    name: " + str2 + '\n');
            AuthV4ProviderTelegram authV4ProviderTelegram = INSTANCE;
            authV4ProviderTelegram.getMyProviderInfo().setProviderUserId(str);
            authV4ProviderTelegram.setUserName(str2);
            authV4ProviderTelegram.setUserToken(str3);
            authV4ProviderTelegram.setLogIn(true);
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLoginListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logout$lambda$4(AuthV4ProviderAdapter.ProviderLogoutListener providerLogoutListener) {
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[AuthV4Telegram] logout success.");
        AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLogoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderTelegram providerTelegram_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderTelegram.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderTelegram)) {
            hiveModule = null;
        }
        return (ProviderTelegram) (hiveModule instanceof ProviderTelegram ? hiveModule : null);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "[AuthV4Telegram] GetFriends - not supported provider.";
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[AuthV4Telegram] GetFriends - not supported provider.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderTelegram$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderTelegram.getFriends$lambda$5(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public boolean isProvisionalKey() {
        String telegramBotId;
        ProviderTelegram providerTelegram2 = getProviderTelegram();
        if (providerTelegram2 == null || (telegramBotId = providerTelegram2.getTelegramBotId()) == null) {
            return false;
        }
        return !StringsKt.isBlank(telegramBotId);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void login(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4Telegram] Telegram Login");
        if (getProviderTelegram() == null) {
            loggerImpl.w("[AuthV4Telegram] login - Telegram does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Telegram does not exist."));
        } else {
            if (!isProvisionalKey()) {
                loggerImpl.w("[AuthV4Telegram] login - Provisional key does not exist.");
                listener.onProviderLoginListener(new ResultAPI(-1, ResultAPI.Code.AuthV4ProviderMissingKey, "Provisional key does not exist"));
                return;
            }
            ProviderTelegram providerTelegram2 = getProviderTelegram();
            if (providerTelegram2 != null) {
                providerTelegram2.login(HiveActivity.INSTANCE.getRecentActivity(), new Function4() { // from class: com.hive.authv4.provider.AuthV4ProviderTelegram$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return AuthV4ProviderTelegram.login$lambda$2$lambda$1(listener, (String) obj, (String) obj2, (String) obj3, (String) obj4);
                    }
                });
            } else {
                listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Telegram does not exist."));
            }
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(final AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[AuthV4Telegram] Logout");
        setUserCode(null);
        getMyProviderInfo().setProviderUserId("");
        setUserName(null);
        setLogIn(false);
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderTelegram$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderTelegram.logout$lambda$4(listener);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener logoutListener, boolean bRemoveProviderAlso) {
        Intrinsics.checkNotNullParameter(logoutListener, "logoutListener");
        logout(logoutListener);
    }
}
