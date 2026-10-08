package com.hive;

import com.hive.SocialV4;
import com.hive.base.DataModel;
import com.hive.logger.LoggerImpl;
import com.hive.socialv4.provider.SocialV4ProviderAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SocialFacebook {
    public static final String TAG = "SocialFacebook";

    public interface PostFacebookListener {
        void onPostFacebook(ResultAPI resultAPI);
    }

    public static class ProfileFacebook extends DataModel {
        public String uid = "";
        public String email = "";
        public String username = "";
        public String profileImageUrl = "";
    }

    public interface ProfileListener {
        void onProfile(ResultAPI resultAPI, List<ProfileFacebook> list);
    }

    public interface SendMessageFacebookListener {
        void onSendMessageFacebook(ResultAPI resultAPI);
    }

    public interface ShowInvitationDialogListener {
        void onShowInvitationDialog(ResultAPI resultAPI, List<String> list);
    }

    public static class SocialFacebookMessage extends DataModel {
        public String data;
        public String dialogTitle;
        public String message;
        public String[] recipients;
    }

    public interface SocialRequestListener {
        void onComplete(ResultAPI resultAPI, String str);
    }

    public static void getFriends(final ProfileListener profileListener) {
        String str = String.format("listener = %s", profileListener);
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialV4ProviderAdapter.INSTANCE.getInstance(SocialV4.ProviderType.FACEBOOK).getFacebookFriends(new SocialV4ProviderAdapter.SocialV4FacebookProfileListener() { // from class: com.hive.SocialFacebook.2
            @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4FacebookProfileListener
            public void onProfile(ResultAPI resultAPI, ArrayList<SocialV4ProviderAdapter.SocialV4FacebookProfile> arrayList) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < arrayList.size(); i++) {
                    ProfileFacebook profileFacebook = new ProfileFacebook();
                    profileFacebook.uid = arrayList.get(i).getUid();
                    profileFacebook.profileImageUrl = arrayList.get(i).getProfileImageUrl();
                    profileFacebook.email = arrayList.get(i).getEmail();
                    profileFacebook.username = arrayList.get(i).getUsername();
                    arrayList2.add(profileFacebook);
                }
                profileListener.onProfile(resultAPI, arrayList2);
            }
        });
        loggerImpl.apiReturnLog(str2, "");
    }

    public static void getMyProfile(final ProfileListener profileListener) {
        String str = String.format("listener = %s", profileListener);
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialV4ProviderAdapter.INSTANCE.getInstance(SocialV4.ProviderType.FACEBOOK).getMyFacebookProfile(new SocialV4ProviderAdapter.SocialV4FacebookProfileListener() { // from class: com.hive.SocialFacebook.1
            @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4FacebookProfileListener
            public void onProfile(ResultAPI resultAPI, ArrayList<SocialV4ProviderAdapter.SocialV4FacebookProfile> arrayList) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < arrayList.size(); i++) {
                    ProfileFacebook profileFacebook = new ProfileFacebook();
                    profileFacebook.uid = arrayList.get(i).getUid();
                    profileFacebook.profileImageUrl = arrayList.get(i).getProfileImageUrl();
                    profileFacebook.email = arrayList.get(i).getEmail();
                    profileFacebook.username = arrayList.get(i).getUsername();
                    arrayList2.add(profileFacebook);
                }
                profileListener.onProfile(resultAPI, arrayList2);
            }
        });
        loggerImpl.apiReturnLog(str2, "");
    }

    public static boolean isLogin() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        SocialV4ProviderAdapter companion = SocialV4ProviderAdapter.INSTANCE.getInstance(SocialV4.ProviderType.FACEBOOK);
        boolean zIsLogin = companion != null ? companion.isLogin() : false;
        loggerImpl.apiReturnLog(str, "" + zIsLogin);
        return zIsLogin;
    }

    public static void postFacebookWithContentURL(String str, final PostFacebookListener postFacebookListener) {
        String str2 = String.format("listener = %s", postFacebookListener);
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str3 = TAG;
        loggerImpl.apiCalledLog(str3, str2);
        SocialV4ProviderAdapter.INSTANCE.getInstance(SocialV4.ProviderType.FACEBOOK).postFacebookWithContentURL(str, new SocialV4ProviderAdapter.PostFacebookListener() { // from class: com.hive.SocialFacebook.5
            @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.PostFacebookListener
            public void onPostFacebook(ResultAPI resultAPI) {
                postFacebookListener.onPostFacebook(resultAPI);
            }
        });
        loggerImpl.apiReturnLog(str3, "");
    }

    public static void sendMessageFacebook(SocialFacebookMessage socialFacebookMessage, final SendMessageFacebookListener sendMessageFacebookListener) {
        String str = String.format("listener = %s", sendMessageFacebookListener);
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialV4ProviderAdapter.INSTANCE.getInstance(SocialV4.ProviderType.FACEBOOK).sendMessageFacebook(new SocialV4ProviderAdapter.SocialV4FacebookMessage(socialFacebookMessage.recipients, socialFacebookMessage.dialogTitle, socialFacebookMessage.message, socialFacebookMessage.data), new SocialV4ProviderAdapter.SendMessageFacebookListener() { // from class: com.hive.SocialFacebook.3
            @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SendMessageFacebookListener
            public void onSendMessageFacebook(ResultAPI resultAPI) {
                sendMessageFacebookListener.onSendMessageFacebook(resultAPI);
            }
        });
        loggerImpl.apiReturnLog(str2, "");
    }

    public static void showInvitationDialog(SocialFacebookMessage socialFacebookMessage, final ShowInvitationDialogListener showInvitationDialogListener) {
        String str = String.format("listener = %s", showInvitationDialogListener);
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialV4ProviderAdapter.INSTANCE.getInstance(SocialV4.ProviderType.FACEBOOK).showInvitationDialog(new SocialV4ProviderAdapter.SocialV4FacebookMessage(socialFacebookMessage.recipients, socialFacebookMessage.dialogTitle, socialFacebookMessage.message, socialFacebookMessage.data), new SocialV4ProviderAdapter.ShowInvitationDialogListener() { // from class: com.hive.SocialFacebook.4
            @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.ShowInvitationDialogListener
            public void onShowInvitationDialog(ResultAPI resultAPI, List<String> list) {
                showInvitationDialogListener.onShowInvitationDialog(resultAPI, list);
            }
        });
        loggerImpl.apiReturnLog(str2, "");
    }
}
