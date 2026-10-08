package com.hive.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderXiaomi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderXiaomi;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "providerXiaomi", "Lcom/hive/module/interfaces/authv4/provider/ProviderXiaomi;", "getProviderXiaomi", "()Lcom/hive/module/interfaces/authv4/provider/ProviderXiaomi;", "providerXiaomi$delegate", "Lkotlin/Lazy;", "login", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "logoutListener", "bRemoveProviderAlso", "", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderXiaomi extends AuthV4ProviderAdapter {
    public static final AuthV4ProviderXiaomi INSTANCE = new AuthV4ProviderXiaomi();

    /* JADX INFO: renamed from: providerXiaomi$delegate, reason: from kotlin metadata */
    private static final Lazy providerXiaomi = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderXiaomi$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AuthV4ProviderXiaomi.providerXiaomi_delegate$lambda$0();
        }
    });

    private AuthV4ProviderXiaomi() {
        super(AuthV4.ProviderType.XIAOMI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$6(AuthV4ProviderAdapter.ProviderFriendsListener providerFriendsListener, String str) {
        providerFriendsListener.onProviderFriendsListener(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, str), null);
    }

    private final ProviderXiaomi getProviderXiaomi() {
        return (ProviderXiaomi) providerXiaomi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$2$lambda$1(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, boolean z, int i, String msg, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (z && str != null && (!StringsKt.isBlank(str)) && str3 != null && (!StringsKt.isBlank(str3))) {
            LoggerImpl.INSTANCE.d("[AuthV4ProviderXiaomi] Login success.\n    userId: " + str + "\n    nickname: " + str2 + '\n');
            AuthV4ProviderXiaomi authV4ProviderXiaomi = INSTANCE;
            authV4ProviderXiaomi.setUserToken(str3);
            authV4ProviderXiaomi.getMyProviderInfo().setProviderUserId(str);
            authV4ProviderXiaomi.setUserName(str2);
            authV4ProviderXiaomi.setLogIn(true);
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLoginListener);
        } else {
            LoggerImpl.INSTANCE.d("[AuthV4ProviderXiaomi] Login failed to receive accessToken.(" + msg + AbstractJsonLexerKt.BEGIN_LIST + i + "])");
            AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-6, ResultAPI.Code.AuthV4ProviderLoginCancel, msg + '(' + i + ')'), providerLoginListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit logout$lambda$5(final AuthV4ProviderAdapter.ProviderLogoutListener providerLogoutListener, final boolean z, final int i, final String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        AuthV4ProviderXiaomi authV4ProviderXiaomi = INSTANCE;
        authV4ProviderXiaomi.setUserToken(null);
        authV4ProviderXiaomi.getMyProviderInfo().setProviderUserId("");
        authV4ProviderXiaomi.setUserName(null);
        authV4ProviderXiaomi.setLogIn(false);
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderXiaomi$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderXiaomi.logout$lambda$5$lambda$4(z, msg, i, providerLogoutListener);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logout$lambda$5$lambda$4(boolean z, String str, int i, AuthV4ProviderAdapter.ProviderLogoutListener providerLogoutListener) {
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[AuthV4ProviderXiaomi] logout " + z + ". " + str + '(' + i + ')');
        AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLogoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderXiaomi providerXiaomi_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderXiaomi.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderXiaomi)) {
            hiveModule = null;
        }
        return (ProviderXiaomi) (hiveModule instanceof ProviderXiaomi ? hiveModule : null);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "[AuthV4ProviderXiaomi] GetFriends - not supported provider.";
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[AuthV4ProviderXiaomi] GetFriends - not supported provider.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderXiaomi$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderXiaomi.getFriends$lambda$6(listener, str);
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
        loggerImpl.d("[AuthV4ProviderXiaomi] Xiaomi Login");
        if (getProviderXiaomi() == null) {
            loggerImpl.w("[AuthV4ProviderXiaomi] login - Xiaomi does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Xiaomi does not exist."));
        } else {
            if (!isProvisionalKey()) {
                loggerImpl.w("[AuthV4ProviderXiaomi] login - Provisional key does not exist.");
                listener.onProviderLoginListener(new ResultAPI(-1, ResultAPI.Code.AuthV4ProviderMissingKey, "Provisional key does not exist"));
                return;
            }
            ProviderXiaomi providerXiaomi2 = getProviderXiaomi();
            if (providerXiaomi2 != null) {
                providerXiaomi2.login(HiveActivity.INSTANCE.getRecentActivity(), new Function6() { // from class: com.hive.authv4.provider.AuthV4ProviderXiaomi$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function6
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                        return AuthV4ProviderXiaomi.login$lambda$2$lambda$1(listener, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue(), (String) obj3, (String) obj4, (String) obj5, (String) obj6);
                    }
                });
            } else {
                listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "ProviderXiaomi does not exist."));
            }
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(final AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[AuthV4ProviderXiaomi] Logout");
        ProviderXiaomi providerXiaomi2 = getProviderXiaomi();
        if (providerXiaomi2 != null) {
            providerXiaomi2.logout(HiveActivity.INSTANCE.getRecentActivity(), new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderXiaomi$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthV4ProviderXiaomi.logout$lambda$5(listener, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue(), (String) obj3);
                }
            });
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener logoutListener, boolean bRemoveProviderAlso) {
        Intrinsics.checkNotNullParameter(logoutListener, "logoutListener");
        logout(logoutListener);
    }
}
