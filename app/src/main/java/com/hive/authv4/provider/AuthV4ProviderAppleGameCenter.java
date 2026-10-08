package com.hive.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderAppleGameCenter;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "login", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "bRemoveProviderAlso", "", "getProfile", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderGetProfileListener;", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderAppleGameCenter extends AuthV4ProviderAdapter {
    public static final AuthV4ProviderAppleGameCenter INSTANCE = new AuthV4ProviderAppleGameCenter();

    private AuthV4ProviderAppleGameCenter() {
        super(AuthV4.ProviderType.APPLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$1(AuthV4ProviderAdapter.ProviderFriendsListener providerFriendsListener, String str) {
        providerFriendsListener.onProviderFriendsListener(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, str), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProfile$lambda$0(AuthV4ProviderAdapter.ProviderGetProfileListener providerGetProfileListener, String str) {
        if (providerGetProfileListener != null) {
            providerGetProfileListener.onProviderGetProfileListener(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, str));
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "[getFriends] Apple is not supported provider.";
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[getFriends] Apple is not supported provider.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderAppleGameCenter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderAppleGameCenter.getFriends$lambda$1(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getProfile() {
        getProfile(null);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public boolean isProvisionalKey() {
        return true;
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void login(AuthV4ProviderAdapter.ProviderLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Login] Apple is not supported provider.");
        AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, "[Login] Apple is not supported provider."), listener);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener listener, boolean bRemoveProviderAlso) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getProfile(final AuthV4ProviderAdapter.ProviderGetProfileListener listener) {
        final String str = "[getProfile] Apple is not supported provider.";
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[getProfile] Apple is not supported provider.");
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderAppleGameCenter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4ProviderAppleGameCenter.getProfile$lambda$0(listener, str);
            }
        });
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Logout] Apple is not supported provider.");
        AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, "[Logout] Apple is not supported provider."), listener);
    }
}
