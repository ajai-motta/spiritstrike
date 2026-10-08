package com.hive.social.provider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginResult;
import com.facebook.share.Sharer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.SocialFacebook;
import com.hive.SocialV4;
import com.hive.base.HivePicture;
import com.hive.logger.LoggerImpl;
import com.hive.social.SocialFacebookImpl;
import com.hive.social.SocialKeys;
import com.hive.socialv4.provider.SocialV4ProviderAdapter;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: SocialV4ProviderFacebook.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u001a\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u001a\u0010 \u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u001a\u0010!\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\u0014\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020.H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020.H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020.H\u0016J\b\u00103\u001a\u00020$H\u0016¨\u00064"}, d2 = {"Lcom/hive/social/provider/SocialV4ProviderFacebook;", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter;", "<init>", "()V", "sharePhoto", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SharePhotoListener;", "getMyFacebookProfile", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4FacebookProfileListener;", "requestUserTokenWithResponseCallback", "", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4RequestListener;", "requestInvitationList", "setFacebookPermissions", "jsonObject", "Lorg/json/JSONObject;", "getFacebookFriends", "sendMessageFacebook", "messageContents", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4FacebookMessage;", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SendMessageFacebookListener;", "showInvitationDialog", "inviteContents", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$ShowInvitationDialogListener;", "postFacebookWithContentURL", "contentURL", "", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$PostFacebookListener;", "queryWithParams", NativeProtocol.WEB_DIALOG_PARAMS, "sendBusinessModel", "requestReceivedInvite", "requestUserProfileImage", "requestConnect", "isLogin", "", "logout", "isConnected", "isAuthorized", "disconnect", "getServiceName", "convertStringToBitmap", "Landroid/graphics/Bitmap;", "encodedString", "handleSocialIsAuthorizedScheme", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialSchemeListener;", "handleSocialLogoutScheme", "handleSocialRequestUserTokenScheme", "handleSocialRequestUserProfileScheme", "handleSocialRequestFriendsScheme", "isRunningInCloud", "hive-authv4-provider-facebook_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialV4ProviderFacebook extends SocialV4ProviderAdapter {
    public static final SocialV4ProviderFacebook INSTANCE = new SocialV4ProviderFacebook();

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public boolean isRunningInCloud() {
        return false;
    }

    private SocialV4ProviderFacebook() {
        super(SocialV4.ProviderType.FACEBOOK);
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void sharePhoto(final SocialV4ProviderAdapter.SharePhotoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!SocialFacebookImpl.getInstance().isConnected()) {
            LoggerImpl.INSTANCE.i("ProviderFacebook is not connected");
            SocialFacebookImpl.getInstance().connect(new FacebookCallback<LoginResult>() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.sharePhoto.1
                @Override // com.facebook.FacebookCallback
                public void onSuccess(LoginResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (result.getAccessToken() != null) {
                        SocialV4ProviderFacebook.INSTANCE.sharePhoto(listener);
                    } else {
                        LoggerImpl.INSTANCE.d("ProviderFacebook connect was successful, but the accessToken is null");
                        listener.onShare(new ResultAPI(-8, ResultAPI.Code.SocialResponseFailConnect, "ProviderFacebook connect was successful, but the accessToken is null"));
                    }
                }

                @Override // com.facebook.FacebookCallback
                public void onCancel() {
                    LoggerImpl.INSTANCE.d("ProviderFacebook connect is canceled");
                    listener.onShare(new ResultAPI(-6, ResultAPI.Code.SocialCancelConnect));
                }

                @Override // com.facebook.FacebookCallback
                public void onError(FacebookException error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    LoggerImpl.INSTANCE.d("ProviderFacebook connect is failed. error: " + error.getMessage());
                    listener.onShare(new ResultAPI(-6, ResultAPI.Code.SocialResponseFailConnect, error.getMessage()));
                }
            });
        } else {
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new AnonymousClass2(listener));
        }
    }

    /* JADX INFO: renamed from: com.hive.social.provider.SocialV4ProviderFacebook$sharePhoto$2, reason: invalid class name */
    /* JADX INFO: compiled from: SocialV4ProviderFacebook.kt */
    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J*\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u001b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"com/hive/social/provider/SocialV4ProviderFacebook$sharePhoto$2", "Lcom/hive/ui/OnActivityLifecycle;", "callbackManager", "Lcom/facebook/CallbackManager;", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "callbackManager$delegate", "Lkotlin/Lazy;", "isInProgress", "", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "hive-authv4-provider-facebook_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass2 extends OnActivityLifecycle {
        final /* synthetic */ SocialV4ProviderAdapter.SharePhotoListener $listener;

        /* JADX INFO: renamed from: callbackManager$delegate, reason: from kotlin metadata */
        private final Lazy callbackManager = LazyKt.lazy(new Function0() { // from class: com.hive.social.provider.SocialV4ProviderFacebook$sharePhoto$2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CallbackManager.Factory.create();
            }
        });
        private boolean isInProgress = true;

        AnonymousClass2(SocialV4ProviderAdapter.SharePhotoListener sharePhotoListener) {
            this.$listener = sharePhotoListener;
        }

        private final CallbackManager getCallbackManager() {
            return (CallbackManager) this.callbackManager.getValue();
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onCreate(final Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            final ShareDialog shareDialog = new ShareDialog(activity);
            final SocialV4ProviderAdapter.SharePhotoListener sharePhotoListener = this.$listener;
            shareDialog.registerCallback(getCallbackManager(), new FacebookCallback<Sharer.Result>() { // from class: com.hive.social.provider.SocialV4ProviderFacebook$sharePhoto$2$onCreate$shareDialog$1$1
                @Override // com.facebook.FacebookCallback
                public void onSuccess(Sharer.Result result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    LoggerImpl.INSTANCE.i("Success Facebook sharePhotoContent");
                    sharePhotoListener.onShare(new ResultAPI(0, ResultAPI.Code.Success));
                    activity.finish();
                }

                @Override // com.facebook.FacebookCallback
                public void onCancel() {
                    LoggerImpl.INSTANCE.i("Cancel Facebook sharePhotoContent");
                    sharePhotoListener.onShare(new ResultAPI(-6, ResultAPI.Code.SocialCancelSharePhoto));
                    activity.finish();
                }

                @Override // com.facebook.FacebookCallback
                public void onError(FacebookException error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    LoggerImpl.INSTANCE.i("Failed Facebook sharePhotoContent");
                    sharePhotoListener.onShare(new ResultAPI(-8, ResultAPI.Code.SocialResponseFailSharePhoto, error.getMessage()));
                    activity.finish();
                }
            });
            if (ShareDialog.INSTANCE.canShow(SharePhotoContent.class)) {
                HivePicture hivePicture = HivePicture.INSTANCE;
                final SocialV4ProviderAdapter.SharePhotoListener sharePhotoListener2 = this.$listener;
                hivePicture.getPictureFromPhotoPicker(2048, "PNG", 100, new HivePicture.HivePictureResultListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook$sharePhoto$2$onCreate$1
                    @Override // com.hive.base.HivePicture.HivePictureResultListener
                    public void onHivePictureResult(ResultAPI result, String base64encodeString) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        int errorCode = result.getErrorCode();
                        if (errorCode == -6) {
                            this.isInProgress = false;
                            LoggerImpl.INSTANCE.d("Canceled to get picture from gallery.");
                            sharePhotoListener2.onShare(new ResultAPI(-6, ResultAPI.Code.SocialCancelGetPictureFromGallery));
                            activity.finish();
                            return;
                        }
                        if (errorCode != 0) {
                            this.isInProgress = false;
                            LoggerImpl.INSTANCE.d("Failed to get picture from gallery.");
                            sharePhotoListener2.onShare(new ResultAPI(-8, ResultAPI.Code.SocialResponseFailGetPictureFromGallery));
                            activity.finish();
                            return;
                        }
                        shareDialog.show(new SharePhotoContent.Builder().addPhoto(new SharePhoto.Builder().setBitmap(SocialV4ProviderFacebook.INSTANCE.convertStringToBitmap(base64encodeString)).build()).build());
                    }
                });
            } else {
                this.isInProgress = false;
                LoggerImpl.INSTANCE.d("Failed Facebook sharePhotoContent. ShareDialog can not show");
                this.$listener.onShare(new ResultAPI(-8, ResultAPI.Code.SocialResponseFailSharePhoto));
                activity.finish();
            }
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onDestroy(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (this.isInProgress) {
                LoggerImpl.INSTANCE.d("ShareDialog's activity destroy");
                this.$listener.onShare(new ResultAPI(-8, ResultAPI.Code.SocialResponseFailSharePhoto, "ShareDialog's activity destroy"));
            }
            super.onDestroy(activity);
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onActivityResult(activity, requestCode, resultCode, data);
            this.isInProgress = false;
            getCallbackManager().onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void getMyFacebookProfile(final SocialV4ProviderAdapter.SocialV4FacebookProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialFacebookImpl.getInstance().getMyProfile(new SocialFacebook.ProfileListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.getMyFacebookProfile.1
            @Override // com.hive.SocialFacebook.ProfileListener
            public void onProfile(ResultAPI result, List<SocialFacebook.ProfileFacebook> profileList) {
                Intrinsics.checkNotNullParameter(result, "result");
                ArrayList<SocialV4ProviderAdapter.SocialV4FacebookProfile> arrayList = new ArrayList<>();
                SocialV4ProviderAdapter.SocialV4FacebookProfile socialV4FacebookProfile = new SocialV4ProviderAdapter.SocialV4FacebookProfile();
                if (profileList != null) {
                    for (SocialFacebook.ProfileFacebook profileFacebook : profileList) {
                        String uid = profileFacebook.uid;
                        Intrinsics.checkNotNullExpressionValue(uid, "uid");
                        socialV4FacebookProfile.setUid(uid);
                        String email = profileFacebook.email;
                        Intrinsics.checkNotNullExpressionValue(email, "email");
                        socialV4FacebookProfile.setEmail(email);
                        String username = profileFacebook.username;
                        Intrinsics.checkNotNullExpressionValue(username, "username");
                        socialV4FacebookProfile.setUsername(username);
                        String profileImageUrl = profileFacebook.profileImageUrl;
                        Intrinsics.checkNotNullExpressionValue(profileImageUrl, "profileImageUrl");
                        socialV4FacebookProfile.setProfileImageUrl(profileImageUrl);
                        arrayList.add(socialV4FacebookProfile);
                    }
                }
                listener.onProfile(result, arrayList);
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public int requestUserTokenWithResponseCallback(final SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return SocialFacebookImpl.getInstance().requestUserTokenWithResponseCallback(new SocialFacebook.SocialRequestListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.requestUserTokenWithResponseCallback.1
            @Override // com.hive.SocialFacebook.SocialRequestListener
            public void onComplete(ResultAPI result, String responseData) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = responseData;
                if (str == null || str.length() == 0) {
                    listener.onComplete(result, "");
                } else {
                    listener.onComplete(result, responseData);
                }
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void requestInvitationList(final SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialFacebookImpl.getInstance().requestInvitationList(new SocialFacebook.SocialRequestListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.requestInvitationList.1
            @Override // com.hive.SocialFacebook.SocialRequestListener
            public void onComplete(ResultAPI result, String responseData) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = responseData;
                if (str == null || str.length() == 0) {
                    listener.onComplete(result, "");
                } else {
                    listener.onComplete(result, responseData);
                }
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public int setFacebookPermissions(JSONObject jsonObject, final SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return SocialFacebookImpl.getInstance().setFacebookPermissions(jsonObject, new SocialFacebook.SocialRequestListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.setFacebookPermissions.1
            @Override // com.hive.SocialFacebook.SocialRequestListener
            public void onComplete(ResultAPI result, String responseData) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = responseData;
                if (str == null || str.length() == 0) {
                    listener.onComplete(result, "");
                } else {
                    listener.onComplete(result, responseData);
                }
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void getFacebookFriends(final SocialV4ProviderAdapter.SocialV4FacebookProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("ProviderFacebook getFacebookFriends");
        SocialFacebookImpl.getInstance().getFriends(new SocialFacebook.ProfileListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.getFacebookFriends.1
            @Override // com.hive.SocialFacebook.ProfileListener
            public void onProfile(ResultAPI result, List<SocialFacebook.ProfileFacebook> profileList) {
                Intrinsics.checkNotNullParameter(result, "result");
                LoggerImpl.INSTANCE.i("ProviderFacebook getFacebookFriends onProfile");
                ArrayList<SocialV4ProviderAdapter.SocialV4FacebookProfile> arrayList = new ArrayList<>();
                SocialV4ProviderAdapter.SocialV4FacebookProfile socialV4FacebookProfile = new SocialV4ProviderAdapter.SocialV4FacebookProfile();
                if (profileList != null) {
                    for (SocialFacebook.ProfileFacebook profileFacebook : profileList) {
                        String str = profileFacebook.uid;
                        String str2 = "";
                        if (str == null) {
                            str = "";
                        }
                        socialV4FacebookProfile.setUid(str);
                        String str3 = profileFacebook.email;
                        if (str3 == null) {
                            str3 = "";
                        }
                        socialV4FacebookProfile.setEmail(str3);
                        String str4 = profileFacebook.username;
                        if (str4 == null) {
                            str4 = "";
                        }
                        socialV4FacebookProfile.setUsername(str4);
                        String str5 = profileFacebook.profileImageUrl;
                        if (str5 != null) {
                            str2 = str5;
                        }
                        socialV4FacebookProfile.setProfileImageUrl(str2);
                        arrayList.add(socialV4FacebookProfile);
                    }
                }
                listener.onProfile(result, arrayList);
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void sendMessageFacebook(SocialV4ProviderAdapter.SocialV4FacebookMessage messageContents, final SocialV4ProviderAdapter.SendMessageFacebookListener listener) {
        Intrinsics.checkNotNullParameter(messageContents, "messageContents");
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialFacebook.SocialFacebookMessage socialFacebookMessage = new SocialFacebook.SocialFacebookMessage();
        socialFacebookMessage.recipients = messageContents.getRecipients();
        socialFacebookMessage.data = messageContents.getData();
        socialFacebookMessage.dialogTitle = messageContents.getDialogTitle();
        socialFacebookMessage.message = messageContents.getMessage();
        SocialFacebookImpl.getInstance().sendMessageFacebook(socialFacebookMessage, new SocialFacebook.SendMessageFacebookListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.sendMessageFacebook.1
            @Override // com.hive.SocialFacebook.SendMessageFacebookListener
            public void onSendMessageFacebook(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                listener.onSendMessageFacebook(result);
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void showInvitationDialog(SocialV4ProviderAdapter.SocialV4FacebookMessage inviteContents, final SocialV4ProviderAdapter.ShowInvitationDialogListener listener) {
        Intrinsics.checkNotNullParameter(inviteContents, "inviteContents");
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialFacebook.SocialFacebookMessage socialFacebookMessage = new SocialFacebook.SocialFacebookMessage();
        socialFacebookMessage.recipients = inviteContents.getRecipients();
        socialFacebookMessage.data = inviteContents.getData();
        socialFacebookMessage.dialogTitle = inviteContents.getDialogTitle();
        socialFacebookMessage.message = inviteContents.getMessage();
        SocialFacebookImpl.getInstance().showInvitationDialog(socialFacebookMessage, new SocialFacebook.ShowInvitationDialogListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.showInvitationDialog.1
            @Override // com.hive.SocialFacebook.ShowInvitationDialogListener
            public void onShowInvitationDialog(ResultAPI result, List<String> invitedUserList) {
                Intrinsics.checkNotNullParameter(result, "result");
                listener.onShowInvitationDialog(result, invitedUserList);
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void postFacebookWithContentURL(String contentURL, final SocialV4ProviderAdapter.PostFacebookListener listener) {
        Intrinsics.checkNotNullParameter(contentURL, "contentURL");
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialFacebookImpl.getInstance().postFacebook(contentURL, new SocialFacebook.PostFacebookListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.postFacebookWithContentURL.1
            @Override // com.hive.SocialFacebook.PostFacebookListener
            public void onPostFacebook(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                listener.onPostFacebook(result);
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void queryWithParams(JSONObject params, final SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialFacebookImpl.getInstance().queryWithParams(params, new SocialFacebook.SocialRequestListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.queryWithParams.1
            @Override // com.hive.SocialFacebook.SocialRequestListener
            public void onComplete(ResultAPI result, String responseData) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = responseData;
                if (str == null || str.length() == 0) {
                    listener.onComplete(result, "");
                } else {
                    listener.onComplete(result, responseData);
                }
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void sendBusinessModel(final SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialFacebookImpl.getInstance().sendBusinessModel(new SocialFacebook.SocialRequestListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.sendBusinessModel.1
            @Override // com.hive.SocialFacebook.SocialRequestListener
            public void onComplete(ResultAPI result, String responseData) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = responseData;
                if (str == null || str.length() == 0) {
                    listener.onComplete(result, "");
                } else {
                    listener.onComplete(result, responseData);
                }
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public int requestReceivedInvite(JSONObject params, final SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return SocialFacebookImpl.getInstance().requestReceivedInvite(params, new SocialFacebook.SocialRequestListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.requestReceivedInvite.1
            @Override // com.hive.SocialFacebook.SocialRequestListener
            public void onComplete(ResultAPI result, String responseData) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = responseData;
                if (str == null || str.length() == 0) {
                    listener.onComplete(result, "");
                } else {
                    listener.onComplete(result, responseData);
                }
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public int requestUserProfileImage(JSONObject params, final SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return SocialFacebookImpl.getInstance().requestUserProfileImage(params, new SocialFacebook.SocialRequestListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.requestUserProfileImage.1
            @Override // com.hive.SocialFacebook.SocialRequestListener
            public void onComplete(ResultAPI result, String responseData) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = responseData;
                if (str == null || str.length() == 0) {
                    listener.onComplete(result, "");
                } else {
                    listener.onComplete(result, responseData);
                }
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public int requestConnect(final SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return SocialFacebookImpl.getInstance().requestConnect(new SocialFacebook.SocialRequestListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.requestConnect.1
            @Override // com.hive.SocialFacebook.SocialRequestListener
            public void onComplete(ResultAPI result, String responseData) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = responseData;
                if (str == null || str.length() == 0) {
                    listener.onComplete(result, "");
                } else {
                    listener.onComplete(result, responseData);
                }
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public boolean isLogin() {
        return SocialFacebookImpl.isLogin();
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public int logout(final SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return SocialFacebookImpl.getInstance().logout(new SocialFacebook.SocialRequestListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.logout.1
            @Override // com.hive.SocialFacebook.SocialRequestListener
            public void onComplete(ResultAPI result, String responseData) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = responseData;
                if (str == null || str.length() == 0) {
                    listener.onComplete(result, "");
                } else {
                    listener.onComplete(result, responseData);
                }
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public boolean isConnected() {
        return SocialFacebookImpl.getInstance().isConnected();
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public int isAuthorized(final SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return SocialFacebookImpl.getInstance().isAuthorized(new SocialFacebook.SocialRequestListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook.isAuthorized.1
            @Override // com.hive.SocialFacebook.SocialRequestListener
            public void onComplete(ResultAPI result, String responseData) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = responseData;
                if (str == null || str.length() == 0) {
                    listener.onComplete(result, "");
                } else {
                    listener.onComplete(result, responseData);
                }
            }
        });
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void disconnect() {
        SocialFacebookImpl.getInstance().disconnect();
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public String getServiceName() {
        return "facebook";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap convertStringToBitmap(String encodedString) {
        try {
            byte[] bArrDecode = Base64.decode(encodedString, 2);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.d("Failed convertStringToBitmap(). \nerror: " + e.getMessage());
            return null;
        }
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void handleSocialIsAuthorizedScheme(SocialV4ProviderAdapter.SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        JSONObject jSONObject = new JSONObject();
        try {
            SocialV4ProviderFacebook socialV4ProviderFacebook = INSTANCE;
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, socialV4ProviderFacebook.getServiceName());
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_IS_AUTHORIZED);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
            jSONObject.put("is_authorized", socialV4ProviderFacebook.isConnected() ? 1 : 0);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("handleSocialIsAuthorizedScheme e:" + e.getMessage());
        }
        listener.onResult(jSONObject);
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void handleSocialLogoutScheme(SocialV4ProviderAdapter.SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        JSONObject jSONObject = new JSONObject();
        try {
            SocialV4ProviderFacebook socialV4ProviderFacebook = INSTANCE;
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, socialV4ProviderFacebook.getServiceName());
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_LOGOUT);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
            if (socialV4ProviderFacebook.isConnected()) {
                socialV4ProviderFacebook.disconnect();
                jSONObject.put("result", 1);
            } else {
                jSONObject.put("result", 0);
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("handleSocialLogoutScheme e:" + e.getMessage());
        }
        listener.onResult(jSONObject);
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void handleSocialRequestUserTokenScheme(final SocialV4ProviderAdapter.SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialFacebookImpl.getInstance().getMyProfile(new SocialFacebook.ProfileListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook$$ExternalSyntheticLambda1
            @Override // com.hive.SocialFacebook.ProfileListener
            public final void onProfile(ResultAPI resultAPI, List list) {
                SocialV4ProviderFacebook.handleSocialRequestUserTokenScheme$lambda$3(listener, resultAPI, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSocialRequestUserTokenScheme$lambda$3(SocialV4ProviderAdapter.SocialSchemeListener socialSchemeListener, ResultAPI resultAPI, List list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, INSTANCE.getServiceName());
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_TOKEN);
            if (resultAPI.isSuccess()) {
                jSONObject.put("token", SocialFacebookImpl.getInstance().getAccessToken());
                jSONObject.put(PangleConstants.APP_ID, SocialFacebookImpl.getInstance().getApplicationId());
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
            } else {
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -9);
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("handleSocialRequestUserTokenScheme e:" + e.getMessage());
        }
        socialSchemeListener.onResult(jSONObject);
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void handleSocialRequestUserProfileScheme(final SocialV4ProviderAdapter.SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialFacebookImpl.getInstance().getMyProfile(new SocialFacebook.ProfileListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook$$ExternalSyntheticLambda2
            @Override // com.hive.SocialFacebook.ProfileListener
            public final void onProfile(ResultAPI resultAPI, List list) {
                SocialV4ProviderFacebook.handleSocialRequestUserProfileScheme$lambda$5(listener, resultAPI, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSocialRequestUserProfileScheme$lambda$5(SocialV4ProviderAdapter.SocialSchemeListener socialSchemeListener, ResultAPI resultAPI, List list) {
        List list2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, INSTANCE.getServiceName());
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_PROFILE);
            if (resultAPI.isSuccess() && (list2 = list) != null && !list2.isEmpty() && list.size() == 1) {
                SocialFacebook.ProfileFacebook profileFacebook = (SocialFacebook.ProfileFacebook) list.get(0);
                jSONObject.put("uid", profileFacebook.uid);
                jSONObject.put("email", profileFacebook.email);
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
            } else {
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("handleSocialRequestUserProfileScheme e:" + e.getMessage());
        }
        socialSchemeListener.onResult(jSONObject);
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void handleSocialRequestFriendsScheme(final SocialV4ProviderAdapter.SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialFacebookImpl.getInstance().getFriends(new SocialFacebook.ProfileListener() { // from class: com.hive.social.provider.SocialV4ProviderFacebook$$ExternalSyntheticLambda0
            @Override // com.hive.SocialFacebook.ProfileListener
            public final void onProfile(ResultAPI resultAPI, List list) {
                SocialV4ProviderFacebook.handleSocialRequestFriendsScheme$lambda$7(listener, resultAPI, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSocialRequestFriendsScheme$lambda$7(SocialV4ProviderAdapter.SocialSchemeListener socialSchemeListener, ResultAPI resultAPI, List list) {
        List list2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, INSTANCE.getServiceName());
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_FRIENDS);
            if (resultAPI.isSuccess() && (list2 = list) != null && !list2.isEmpty() && list.size() == 1) {
                SocialFacebook.ProfileFacebook profileFacebook = (SocialFacebook.ProfileFacebook) list.get(0);
                jSONObject.put("uid", profileFacebook.uid);
                jSONObject.put("email", profileFacebook.email);
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
            } else {
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("handleSocialRequestFriendsScheme e:" + e.getMessage());
        }
        socialSchemeListener.onResult(jSONObject);
    }
}
