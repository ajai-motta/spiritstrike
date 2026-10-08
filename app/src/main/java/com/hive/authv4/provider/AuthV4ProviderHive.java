package com.hive.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.authv4.AuthV4Account;
import com.hive.authv4.AuthV4Network;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderHiveMembership;
import com.hive.protocol.membership.GetSession;
import com.hive.standalone.HiveLifecycle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0018H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0012\u0010\u001c\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J1\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00140$R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R*\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8V@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006)"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderHive;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "hiveMembership", "Lcom/hive/module/interfaces/authv4/provider/ProviderHiveMembership;", "getHiveMembership", "()Lcom/hive/module/interfaces/authv4/provider/ProviderHiveMembership;", "hiveMembership$delegate", "Lkotlin/Lazy;", "value", "", "userToken", "getUserToken", "()Ljava/lang/String;", "setUserToken", "(Ljava/lang/String;)V", "membershipSession", "getMembershipSession", "login", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "logoutListener", "bRemoveProviderAlso", "", "getProfile", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderGetProfileListener;", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "getMembershipSessionFromPlayerInfo", "playerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "Lkotlin/Function1;", "Lcom/hive/ResultAPI;", "Lkotlin/ParameterName;", "name", "resultApi", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderHive extends AuthV4ProviderAdapter {
    public static final AuthV4ProviderHive INSTANCE = new AuthV4ProviderHive();

    /* JADX INFO: renamed from: hiveMembership$delegate, reason: from kotlin metadata */
    private static final Lazy hiveMembership = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.AuthV4ProviderHive$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AuthV4ProviderHive.hiveMembership_delegate$lambda$0();
        }
    });
    private static String userToken;

    private AuthV4ProviderHive() {
        super(AuthV4.ProviderType.HIVE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$4(AuthV4ProviderAdapter.ProviderFriendsListener providerFriendsListener, String str) {
        providerFriendsListener.onProviderFriendsListener(new ResultAPI(-2, ResultAPI.Code.AuthV4ProviderNotSupportGetFriends, str), null);
    }

    private final ProviderHiveMembership getHiveMembership() {
        return (ProviderHiveMembership) hiveMembership.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMembershipSessionFromPlayerInfo$lambda$5(Function1 function1, GetSession getSession, String hiveSession, String memberSession) {
        Intrinsics.checkNotNullParameter(getSession, "getSession");
        Intrinsics.checkNotNullParameter(hiveSession, "hiveSession");
        Intrinsics.checkNotNullParameter(memberSession, "memberSession");
        function1.invoke(AuthV4Network.INSTANCE.toResultAPI$hive_service_release(getSession.getResponse()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderHiveMembership hiveMembership_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderHiveMembership.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderHiveMembership)) {
            hiveModule = null;
        }
        return (ProviderHiveMembership) (hiveModule instanceof ProviderHiveMembership ? hiveModule : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$1(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, String str, String str2, String str3) {
        ResultAPI resultAPI;
        if (str == null || !(!StringsKt.isBlank(str)) || str2 == null || !(!StringsKt.isBlank(str2)) || str3 == null || !(!StringsKt.isBlank(str3))) {
            resultAPI = new ResultAPI(-6, ResultAPI.Code.AuthV4HIVECancel, "Canceled.");
        } else {
            AuthV4ProviderHive authV4ProviderHive = INSTANCE;
            authV4ProviderHive.getMyProviderInfo().setProviderUserId(str);
            authV4ProviderHive.setLogIn(true);
            resultAPI = new ResultAPI();
        }
        AuthV4ProviderAdapter.INSTANCE.toMainThread(resultAPI, providerLoginListener);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logout$lambda$3(AuthV4ProviderAdapter.ProviderLogoutListener providerLogoutListener) {
        LoggerImpl.INSTANCE.d("[Provider Hive] logout success.");
        AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), providerLogoutListener);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "[Provider " + getIdpType() + "] [getFriends] Hive is not supported provider.";
        LoggerImpl.INSTANCE.w(str);
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderHive$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderHive.getFriends$lambda$4(listener, str);
            }
        });
    }

    public final String getMembershipSession() {
        ProviderHiveMembership hiveMembership2 = getHiveMembership();
        if (hiveMembership2 != null) {
            return hiveMembership2.getMemberSession();
        }
        return null;
    }

    public final void getMembershipSessionFromPlayerInfo(AuthV4.PlayerInfo playerInfo, final Function1<? super ResultAPI, Unit> listener) {
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ProviderHiveMembership hiveMembership2 = getHiveMembership();
        if (hiveMembership2 != null) {
            hiveMembership2.getSession(playerInfo, new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderHive$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthV4ProviderHive.getMembershipSessionFromPlayerInfo$lambda$5(listener, (GetSession) obj, (String) obj2, (String) obj3);
                }
            });
        } else {
            listener.invoke(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveMembership does not exist."));
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getProfile() {
        getProfile(null);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public String getUserToken() {
        ProviderHiveMembership hiveMembership2 = getHiveMembership();
        if (hiveMembership2 != null) {
            return hiveMembership2.getHiveSession();
        }
        return null;
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public boolean isProvisionalKey() {
        return true;
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void login(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[Provider Hive] Login");
        if (getHiveMembership() == null) {
            loggerImpl.w("[Provider Hive] login - HiveMembership does not exist.");
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveMembership does not exist."));
            return;
        }
        String did = HiveLifecycle.INSTANCE.getDid();
        ProviderHiveMembership hiveMembership2 = getHiveMembership();
        if (hiveMembership2 != null) {
            hiveMembership2.login(HiveActivity.INSTANCE.getRecentActivity(), AuthV4Account.INSTANCE.getPlayerInfo(), did, new Function3() { // from class: com.hive.authv4.provider.AuthV4ProviderHive$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthV4ProviderHive.login$lambda$1(listener, (String) obj, (String) obj2, (String) obj3);
                }
            });
        } else {
            listener.onProviderLoginListener(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveMembership does not exist."));
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(final AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[Provider Hive] logout");
        ProviderHiveMembership hiveMembership2 = getHiveMembership();
        if (hiveMembership2 != null) {
            hiveMembership2.logout();
        }
        getMyProviderInfo().setProviderUserId("");
        setLogIn(false);
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderHive$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderHive.logout$lambda$3(listener);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void setUserToken(String str) {
        userToken = str;
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getProfile(AuthV4ProviderAdapter.ProviderGetProfileListener listener) {
        String profileImg;
        String profileName;
        LoggerImpl.INSTANCE.i("[Provider " + getIdpType() + "] getProfile.");
        ProviderHiveMembership hiveMembership2 = getHiveMembership();
        String str = "";
        if (hiveMembership2 == null || (profileImg = hiveMembership2.getProfileImg()) == null) {
            profileImg = "";
        }
        setUserProfileImage(profileImg);
        ProviderHiveMembership hiveMembership3 = getHiveMembership();
        if (hiveMembership3 != null && (profileName = hiveMembership3.getProfileName()) != null) {
            str = profileName;
        }
        setUserName(str);
        super.getProfile(listener);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener logoutListener, boolean bRemoveProviderAlso) {
        Intrinsics.checkNotNullParameter(logoutListener, "logoutListener");
        logout(logoutListener);
    }
}
