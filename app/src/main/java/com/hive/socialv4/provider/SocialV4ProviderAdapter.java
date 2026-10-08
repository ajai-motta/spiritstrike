package com.hive.socialv4.provider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.SocialV4;
import com.hive.base.DataModel;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.core.fid.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b&\u0018\u0000 b2\u00020\u0001:\rVWXYZ[\\]^_`abB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\"\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\tH&J\b\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\"H\u0016J\"\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020)H\u0016J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020)H\u0016J\u0010\u0010-\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020)H\u0016J\u0010\u0010.\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020)H\u0016J\b\u0010/\u001a\u00020\tH\u0016J\u0018\u00100\u001a\u00020\t2\u0006\u00101\u001a\u0002022\u0006\u0010\u001f\u001a\u00020)H\u0016J\b\u00103\u001a\u00020\u001dH\u0016J\u0010\u00104\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u000205H\u0016J\u0010\u00107\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u000205H\u0016J\u0010\u00108\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u00109\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010:\u001a\u00020\u001aH\u0016J\b\u0010;\u001a\u00020\tH\u0016J\u0010\u0010<\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020=H\u0016J\u0018\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010\u001f\u001a\u00020BH\u0016J\u0018\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020A2\u0006\u0010\u001f\u001a\u00020EH\u0016J\u0018\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010J\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010K\u001a\u00020\u00142\b\u0010L\u001a\u0004\u0018\u0001022\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010M\u001a\u00020\u001aH\u0016J\u001a\u0010N\u001a\u00020\t2\b\u0010O\u001a\u0004\u0018\u0001022\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010P\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010Q\u001a\u00020\u00142\b\u0010O\u001a\u0004\u0018\u0001022\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010R\u001a\u00020\u00142\b\u0010O\u001a\u0004\u0018\u0001022\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010S\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010T\u001a\u00020\u001aH\u0016J\u0010\u0010U\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006c"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter;", "", "providerType", "Lcom/hive/SocialV4$ProviderType;", "<init>", "(Lcom/hive/SocialV4$ProviderType;)V", "getProviderType", "()Lcom/hive/SocialV4$ProviderType;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onStart", "onResume", "onStop", "onDestroy", "onResult", "requestCode", "", "responseCode", "intent", "Landroid/content/Intent;", "onNewIntent", "isConnected", "", "disconnect", "getServiceName", "", "isAuthorized", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4RequestListener;", "sharePhoto", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SharePhotoListener;", "showCommunity", "viewType", "Lcom/hive/SocialV4$ViewType;", "url", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$ShowCommunityListener;", "handleSocialIsAuthorizedScheme", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialSchemeListener;", "handleSocialLogoutScheme", "handleSocialRequestUserTokenScheme", "handleSocialRequestUserProfileScheme", "handleSocialRequestFriendsScheme", "handleSocialRequestAppExitScheme", "handleSocialRequestUserAgree", "handleSocialRequestCheckRealName", "optionJsonObject", "Lorg/json/JSONObject;", "getPlayerName", "getGoogleUserToken", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4GoogleProfileListener;", "getMyGoogleProfile", "getGoogleFriends", "requestSocialConnect", "requestPlayerId", "isGamesV2", "resetGoogleLoginType", "getMyFacebookProfile", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4FacebookProfileListener;", "getFacebookFriends", "sendMessageFacebook", "messageContents", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4FacebookMessage;", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SendMessageFacebookListener;", "showInvitationDialog", "inviteContents", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$ShowInvitationDialogListener;", "postFacebookWithContentURL", "contentURL", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$PostFacebookListener;", "requestUserTokenWithResponseCallback", "requestInvitationList", "setFacebookPermissions", "jsonObject", "isRunningInCloud", "queryWithParams", NativeProtocol.WEB_DIALOG_PARAMS, "sendBusinessModel", "requestReceivedInvite", "requestUserProfileImage", "requestConnect", "isLogin", "logout", "SharePhotoListener", "ShowCommunityListener", "SocialSchemeListener", "SocialV4GoogleProfileListener", "SocialV4GoogleProfile", "SocialV4FacebookProfileListener", "SendMessageFacebookListener", "ShowInvitationDialogListener", "PostFacebookListener", "SocialV4RequestListener", "SocialV4FacebookProfile", "SocialV4FacebookMessage", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SocialV4ProviderAdapter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<SocialV4.ProviderType, SocialV4ProviderAdapter> providerMap = new HashMap<>();
    private final SocialV4.ProviderType providerType;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u0017\u001a\u00020\rJ \u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010\u001e\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\u001f\u001a\u00020\rR*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$Companion;", "", "<init>", "()V", "providerMap", "Ljava/util/HashMap;", "Lcom/hive/SocialV4$ProviderType;", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter;", "Lkotlin/collections/HashMap;", Constants.GET_INSTANCE, "providerType", "getAddedChinaProvider", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityResumed", "onActivityStopped", "onActivityDestroyed", "onActivityResult", "requestCode", "", "responseCode", "intent", "Landroid/content/Intent;", "onActivityNewIntent", "allDisconnect", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SocialV4.ProviderType.values().length];
                try {
                    iArr[SocialV4.ProviderType.HIVE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SocialV4.ProviderType.GOOGLE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SocialV4.ProviderType.GOOGLE_PLAY_GAMES.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[SocialV4.ProviderType.QQ.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[SocialV4.ProviderType.FACEBOOK.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[SocialV4.ProviderType.HUAWEI.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[SocialV4.ProviderType.OPPO.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[SocialV4.ProviderType.VIVO.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[SocialV4.ProviderType.XIAOMI.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void allDisconnect() {
            for (Object obj : SocialV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((SocialV4ProviderAdapter) obj).disconnect();
            }
        }

        public final SocialV4ProviderAdapter getAddedChinaProvider() {
            SocialV4ProviderAdapter socialV4ProviderAdapter = (SocialV4ProviderAdapter) SocialV4ProviderAdapter.providerMap.get(SocialV4.ProviderType.HUAWEI);
            if (socialV4ProviderAdapter != null) {
                return socialV4ProviderAdapter;
            }
            SocialV4ProviderAdapter socialV4ProviderAdapter2 = (SocialV4ProviderAdapter) SocialV4ProviderAdapter.providerMap.get(SocialV4.ProviderType.OPPO);
            if (socialV4ProviderAdapter2 != null) {
                return socialV4ProviderAdapter2;
            }
            SocialV4ProviderAdapter socialV4ProviderAdapter3 = (SocialV4ProviderAdapter) SocialV4ProviderAdapter.providerMap.get(SocialV4.ProviderType.VIVO);
            return socialV4ProviderAdapter3 == null ? (SocialV4ProviderAdapter) SocialV4ProviderAdapter.providerMap.get(SocialV4.ProviderType.XIAOMI) : socialV4ProviderAdapter3;
        }

        public final SocialV4ProviderAdapter getInstance(SocialV4.ProviderType providerType) {
            Intrinsics.checkNotNullParameter(providerType, "providerType");
            switch (WhenMappings.$EnumSwitchMapping$0[providerType.ordinal()]) {
                case 1:
                    return SocialV4ProviderHive.INSTANCE;
                case 2:
                    return SocialV4ProviderGoogle.INSTANCE;
                case 3:
                    return SocialV4ProviderGooglePlayGames.INSTANCE;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return (SocialV4ProviderAdapter) SocialV4ProviderAdapter.providerMap.get(providerType);
                default:
                    return null;
            }
        }

        public final void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            for (Object obj : SocialV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((SocialV4ProviderAdapter) obj).onCreate(savedInstanceState);
            }
        }

        public final void onActivityDestroyed() {
            for (Object obj : SocialV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((SocialV4ProviderAdapter) obj).onDestroy();
            }
        }

        public final void onActivityNewIntent(Intent intent) {
            for (Object obj : SocialV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((SocialV4ProviderAdapter) obj).onNewIntent(intent);
            }
        }

        public final void onActivityResult(int requestCode, int responseCode, Intent intent) {
            for (Object obj : SocialV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((SocialV4ProviderAdapter) obj).onResult(requestCode, responseCode, intent);
            }
        }

        public final void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            for (Object obj : SocialV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((SocialV4ProviderAdapter) obj).onResume();
            }
        }

        public final void onActivitySaveInstanceState(Bundle outState) {
            for (Object obj : SocialV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((SocialV4ProviderAdapter) obj).onSaveInstanceState(outState);
            }
        }

        public final void onActivityStarted() {
            for (Object obj : SocialV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((SocialV4ProviderAdapter) obj).onStart();
            }
        }

        public final void onActivityStopped() {
            for (Object obj : SocialV4ProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((SocialV4ProviderAdapter) obj).onStop();
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$PostFacebookListener;", "", "onPostFacebook", "", "resultAPI", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PostFacebookListener {
        void onPostFacebook(ResultAPI resultAPI);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SendMessageFacebookListener;", "", "onSendMessageFacebook", "", "resultAPI", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SendMessageFacebookListener {
        void onSendMessageFacebook(ResultAPI resultAPI);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SharePhotoListener;", "", "onShare", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SharePhotoListener {
        void onShare(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$ShowCommunityListener;", "", "onShowCommunity", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ShowCommunityListener {
        void onShowCommunity(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$ShowInvitationDialogListener;", "", "onShowInvitationDialog", "", "resultAPI", "Lcom/hive/ResultAPI;", "invitedUserList", "", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ShowInvitationDialogListener {
        void onShowInvitationDialog(ResultAPI resultAPI, List<String> invitedUserList);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialSchemeListener;", "", "onResult", "", "jsonObject", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SocialSchemeListener {
        void onResult(JSONObject jsonObject);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4FacebookProfileListener;", "", "onProfile", "", "resultAPI", "Lcom/hive/ResultAPI;", "profileList", "Ljava/util/ArrayList;", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4FacebookProfile;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SocialV4FacebookProfileListener {
        void onProfile(ResultAPI resultAPI, ArrayList<SocialV4FacebookProfile> profileList);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4GoogleProfileListener;", "", "onProfile", "", "resultAPI", "Lcom/hive/ResultAPI;", "profileList", "Ljava/util/ArrayList;", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4GoogleProfile;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SocialV4GoogleProfileListener {
        void onProfile(ResultAPI resultAPI, ArrayList<SocialV4GoogleProfile> profileList);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4RequestListener;", "", "onComplete", "", "resultAPI", "Lcom/hive/ResultAPI;", "responseData", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SocialV4RequestListener {
        void onComplete(ResultAPI resultAPI, String responseData);
    }

    public SocialV4ProviderAdapter(SocialV4.ProviderType providerType) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        this.providerType = providerType;
        providerMap.put(providerType, this);
    }

    public abstract void disconnect();

    public void getFacebookFriends(SocialV4FacebookProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public int getGoogleFriends(SocialV4GoogleProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return 0;
    }

    public int getGoogleUserToken(SocialV4GoogleProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return 0;
    }

    public void getMyFacebookProfile(SocialV4FacebookProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public int getMyGoogleProfile(SocialV4GoogleProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return 0;
    }

    public String getPlayerName() {
        return "";
    }

    public final SocialV4.ProviderType getProviderType() {
        return this.providerType;
    }

    public abstract String getServiceName();

    public void handleSocialIsAuthorizedScheme(SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void handleSocialLogoutScheme(SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void handleSocialRequestAppExitScheme(SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void handleSocialRequestCheckRealName(JSONObject optionJsonObject, SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(optionJsonObject, "optionJsonObject");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void handleSocialRequestFriendsScheme(SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void handleSocialRequestUserAgree() {
    }

    public void handleSocialRequestUserProfileScheme(SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void handleSocialRequestUserTokenScheme(SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public int isAuthorized(SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP;
    }

    public abstract boolean isConnected();

    public boolean isGamesV2() {
        return false;
    }

    public boolean isLogin() {
        return false;
    }

    public boolean isRunningInCloud() {
        return false;
    }

    public int logout(SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return 0;
    }

    public void onCreate(Bundle savedInstanceState) {
    }

    public void onDestroy() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onResult(int requestCode, int responseCode, Intent intent) {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle outState) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void postFacebookWithContentURL(String contentURL, PostFacebookListener listener) {
        Intrinsics.checkNotNullParameter(contentURL, "contentURL");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void queryWithParams(JSONObject params, SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public int requestConnect(SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return 0;
    }

    public void requestInvitationList(SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void requestPlayerId(SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public int requestReceivedInvite(JSONObject params, SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return 0;
    }

    public int requestSocialConnect(SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return 0;
    }

    public int requestUserProfileImage(JSONObject params, SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return 0;
    }

    public int requestUserTokenWithResponseCallback(SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return 0;
    }

    public void resetGoogleLoginType() {
    }

    public void sendBusinessModel(SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void sendMessageFacebook(SocialV4FacebookMessage messageContents, SendMessageFacebookListener listener) {
        Intrinsics.checkNotNullParameter(messageContents, "messageContents");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public int setFacebookPermissions(JSONObject jsonObject, SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return 0;
    }

    public void sharePhoto(SharePhotoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void showCommunity(SocialV4.ViewType viewType, String url, ShowCommunityListener listener) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void showInvitationDialog(SocialV4FacebookMessage inviteContents, ShowInvitationDialogListener listener) {
        Intrinsics.checkNotNullParameter(inviteContents, "inviteContents");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0002\u0010\nR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4FacebookMessage;", "Lcom/hive/base/DataModel;", "<init>", "()V", "recipients", "", "", "dialogTitle", "message", "data", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRecipients", "()[Ljava/lang/String;", "setRecipients", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getDialogTitle", "()Ljava/lang/String;", "setDialogTitle", "(Ljava/lang/String;)V", "getMessage", "setMessage", "getData", "setData", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SocialV4FacebookMessage extends DataModel {
        private String data;
        private String dialogTitle;
        private String message;
        private String[] recipients;

        public SocialV4FacebookMessage() {
            this.dialogTitle = "";
            this.message = "";
            this.data = "";
        }

        public final String getData() {
            return this.data;
        }

        public final String getDialogTitle() {
            return this.dialogTitle;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String[] getRecipients() {
            return this.recipients;
        }

        public final void setData(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.data = str;
        }

        public final void setDialogTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.dialogTitle = str;
        }

        public final void setMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.message = str;
        }

        public final void setRecipients(String[] strArr) {
            this.recipients = strArr;
        }

        public SocialV4FacebookMessage(String[] strArr, String dialogTitle, String message, String data) {
            Intrinsics.checkNotNullParameter(dialogTitle, "dialogTitle");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(data, "data");
            this.recipients = strArr;
            this.dialogTitle = dialogTitle;
            this.message = message;
            this.data = data;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4FacebookProfile;", "Lcom/hive/base/DataModel;", "<init>", "()V", "uid", "", "email", "username", "profileImageUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "getEmail", "setEmail", "getUsername", "setUsername", "getProfileImageUrl", "setProfileImageUrl", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SocialV4FacebookProfile extends DataModel {
        private String email;
        private String profileImageUrl;
        private String uid;
        private String username;

        public SocialV4FacebookProfile() {
            this.uid = "";
            this.email = "";
            this.username = "";
            this.profileImageUrl = "";
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getProfileImageUrl() {
            return this.profileImageUrl;
        }

        public final String getUid() {
            return this.uid;
        }

        public final String getUsername() {
            return this.username;
        }

        public final void setEmail(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.email = str;
        }

        public final void setProfileImageUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.profileImageUrl = str;
        }

        public final void setUid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }

        public final void setUsername(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.username = str;
        }

        public SocialV4FacebookProfile(String uid, String email, String username, String profileImageUrl) {
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(profileImageUrl, "profileImageUrl");
            this.uid = uid;
            this.email = email;
            this.username = username;
            this.profileImageUrl = profileImageUrl;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4GoogleProfile;", "Lcom/hive/base/DataModel;", "<init>", "()V", "userId", "", "userToken", "email", "displayName", "profileImageUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getUserToken", "setUserToken", "getEmail", "setEmail", "getDisplayName", "setDisplayName", "getProfileImageUrl", "setProfileImageUrl", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SocialV4GoogleProfile extends DataModel {
        private String displayName;
        private String email;
        private String profileImageUrl;
        private String userId;
        private String userToken;

        public SocialV4GoogleProfile() {
            this.userId = "";
            this.userToken = "";
            this.email = "";
            this.displayName = "";
            this.profileImageUrl = "";
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getProfileImageUrl() {
            return this.profileImageUrl;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final String getUserToken() {
            return this.userToken;
        }

        public final void setDisplayName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.displayName = str;
        }

        public final void setEmail(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.email = str;
        }

        public final void setProfileImageUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.profileImageUrl = str;
        }

        public final void setUserId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.userId = str;
        }

        public final void setUserToken(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.userToken = str;
        }

        public SocialV4GoogleProfile(String userId, String userToken, String email, String displayName, String profileImageUrl) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(userToken, "userToken");
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            Intrinsics.checkNotNullParameter(profileImageUrl, "profileImageUrl");
            this.userId = userId;
            this.userToken = userToken;
            this.email = email;
            this.displayName = displayName;
            this.profileImageUrl = profileImageUrl;
        }
    }
}
