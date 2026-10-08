package com.hive.authv4.provider;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.SocialFacebook;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.logger.LoggerImpl;
import com.hive.social.SocialFacebookImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthV4ProviderFacebook.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0017H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\f8V@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/hive/authv4/provider/AuthV4ProviderFacebook;", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "<init>", "()V", "profileFacebook", "Lcom/hive/SocialFacebook$ProfileFacebook;", "value", "", "isLogIn", "()Z", "setLogIn", "(Z)V", "", "userToken", "getUserToken", "()Ljava/lang/String;", "setUserToken", "(Ljava/lang/String;)V", "login", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "logout", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "bRemoveProviderAlso", "getProfile", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderGetProfileListener;", "getFriends", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderFriendsListener;", "isProvisionalKey", "hive-authv4-provider-facebook_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4ProviderFacebook extends AuthV4ProviderAdapter {
    public static final AuthV4ProviderFacebook INSTANCE = new AuthV4ProviderFacebook();
    private static boolean isLogIn;
    private static SocialFacebook.ProfileFacebook profileFacebook;
    private static String userToken;

    /* JADX INFO: compiled from: AuthV4ProviderFacebook.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResultAPI.Code.values().length];
            try {
                iArr[ResultAPI.Code.SocialFacebookCancelGetProfile.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResultAPI.Code.SocialFacebookResponseFailGetProfile.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public boolean isProvisionalKey() {
        return true;
    }

    private AuthV4ProviderFacebook() {
        super(AuthV4.ProviderType.FACEBOOK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void setLogIn(boolean z) {
        isLogIn = z;
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    /* JADX INFO: renamed from: isLogIn */
    public boolean getIsLogIn() {
        boolean zIsConnected = SocialFacebookImpl.getInstance().isConnected();
        isLogIn = zIsConnected;
        return zIsConnected;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void setUserToken(String str) {
        userToken = str;
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public String getUserToken() {
        String accessToken = SocialFacebookImpl.getInstance().getAccessToken();
        userToken = accessToken;
        return accessToken;
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void login(final AuthV4ProviderAdapter.ProviderLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[Provider Facebook] Login");
        SocialFacebookImpl.getInstance().getMyProfile(new SocialFacebook.ProfileListener() { // from class: com.hive.authv4.provider.AuthV4ProviderFacebook$$ExternalSyntheticLambda2
            @Override // com.hive.SocialFacebook.ProfileListener
            public final void onProfile(ResultAPI resultAPI, List list) {
                AuthV4ProviderFacebook.login$lambda$1(listener, resultAPI, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void login$lambda$1(AuthV4ProviderAdapter.ProviderLoginListener providerLoginListener, ResultAPI resultAPI, List list) {
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[Provider Facebook] Login" + resultAPI);
        if (resultAPI.isSuccess() && list != null) {
            if ((!list.isEmpty()) && list.size() == 1) {
                AuthV4ProviderFacebook authV4ProviderFacebook = INSTANCE;
                SocialFacebook.ProfileFacebook profileFacebook2 = (SocialFacebook.ProfileFacebook) list.get(0);
                AuthV4.ProviderInfo myProviderInfo = authV4ProviderFacebook.getMyProviderInfo();
                String uid = profileFacebook2.uid;
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                myProviderInfo.setProviderUserId(uid);
                authV4ProviderFacebook.setLogIn(true);
                profileFacebook = profileFacebook2;
            }
            if (TextUtils.isEmpty(INSTANCE.getMyProviderInfo().getProviderUserId())) {
                resultAPI = new ResultAPI(-8, ResultAPI.Code.AuthV4FacebookInvalidResponseData, "facebook profile uid is empty.");
            }
        } else {
            int i = WhenMappings.$EnumSwitchMapping$0[resultAPI.getCode().ordinal()];
            if (i == 1) {
                resultAPI = new ResultAPI(-6, ResultAPI.Code.AuthV4FacebookCancel, "Login is canceled!");
            } else if (i == 2) {
                resultAPI = new ResultAPI(-8, ResultAPI.Code.AuthV4FacebookResponseError, resultAPI.getErrorMessage());
            }
        }
        LoggerImpl.INSTANCE.dL(AuthV4.getTAG(), "[Provider Facebook] providerInfo: " + INSTANCE.getMyProviderInfo());
        LoggerImpl.INSTANCE.dR(AuthV4.getTAG(), "[Provider Facebook] providerInfo");
        AuthV4ProviderAdapter.Companion companion = AuthV4ProviderAdapter.INSTANCE;
        Intrinsics.checkNotNull(resultAPI);
        companion.toMainThread(resultAPI, providerLoginListener);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[Provider Facebook] Logout");
        SocialFacebookImpl.getInstance().disconnect();
        getMyProviderInfo().setProviderUserId("");
        setLogIn(false);
        AuthV4ProviderAdapter.INSTANCE.toMainThread(new ResultAPI(), listener);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void logout(AuthV4ProviderAdapter.ProviderLogoutListener listener, boolean bRemoveProviderAlso) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (bRemoveProviderAlso) {
            SocialFacebookImpl.getInstance().disconnect();
        } else {
            logout(listener);
        }
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getProfile() {
        getProfile(null);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getProfile(AuthV4ProviderAdapter.ProviderGetProfileListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Provider " + getIdpType() + "] getProfile.");
        SocialFacebook.ProfileFacebook profileFacebook2 = profileFacebook;
        setUserProfileImage(profileFacebook2 != null ? profileFacebook2.profileImageUrl : null);
        SocialFacebook.ProfileFacebook profileFacebook3 = profileFacebook;
        setUserName(profileFacebook3 != null ? profileFacebook3.username : null);
        super.getProfile(listener);
    }

    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter
    public void getFriends(final AuthV4ProviderAdapter.ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[Provider Facebook] getFriends");
        SocialFacebookImpl.getInstance().getFriends(new SocialFacebook.ProfileListener() { // from class: com.hive.authv4.provider.AuthV4ProviderFacebook$$ExternalSyntheticLambda0
            @Override // com.hive.SocialFacebook.ProfileListener
            public final void onProfile(ResultAPI resultAPI, List list) {
                AuthV4ProviderFacebook.getFriends$lambda$3(listener, resultAPI, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$3(final AuthV4ProviderAdapter.ProviderFriendsListener providerFriendsListener, ResultAPI resultAPI, List list) {
        final ResultAPI resultAPI2;
        final ArrayList arrayList;
        if (resultAPI.isSuccess()) {
            arrayList = new ArrayList();
            List list2 = list;
            if (list2 != null && !list2.isEmpty() && list.size() > 0) {
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(((SocialFacebook.ProfileFacebook) list.get(i)).uid);
                }
                resultAPI2 = new ResultAPI();
            } else {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Provider Facebook] getFriends Friend : 0.");
                resultAPI2 = new ResultAPI(0, ResultAPI.Code.Success, "[Provider Facebook] getFriends Friend : 0.");
            }
        } else {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Provider Facebook] getFriends Fail.");
            resultAPI2 = new ResultAPI(-8, ResultAPI.Code.AuthV4FacebookResponseFailGetFriends, "[Provider Facebook] getFriends Fail.");
            arrayList = null;
        }
        AuthV4ProviderAdapter.INSTANCE.getMainThreadHandler().post(new Runnable() { // from class: com.hive.authv4.provider.AuthV4ProviderFacebook$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                providerFriendsListener.onProviderFriendsListener(resultAPI2, arrayList);
            }
        });
    }
}
