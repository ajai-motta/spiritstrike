package com.hive;

import com.hive.base.DataModel;

/* JADX INFO: loaded from: classes3.dex */
public class SocialGoogle {
    public static final String TAG = "SocialGoogle";

    public static class ProfileGoogle extends DataModel {
        public String displayName;
        public String email;
        public String profileImageUrl;
        public String userId;

        public ProfileGoogle() {
        }

        public ProfileGoogle(String str, String str2, String str3, String str4) {
            this.userId = str;
            this.email = str2;
            this.displayName = str3;
            this.profileImageUrl = str4;
        }
    }

    public interface SocialRequestListener {
        void onComplete(ResultAPI resultAPI, String str);
    }
}
