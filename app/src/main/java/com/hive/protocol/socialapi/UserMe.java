package com.hive.protocol.socialapi;

import com.facebook.appevents.UserDataStore;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.socialapi.SocialApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserMe.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/socialapi/UserMe;", "Lcom/hive/protocol/socialapi/SocialApi;", "<init>", "()V", "value", "Lcom/hive/protocol/socialapi/UserMe$UserMeResponse;", "response", "getResponse", "()Lcom/hive/protocol/socialapi/UserMe$UserMeResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "UserMeResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserMe extends SocialApi {
    private UserMeResponse response;

    public final UserMeResponse getResponse() {
        UserMeResponse userMeResponse = this.response;
        if (userMeResponse != null) {
            return userMeResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.socialapi.SocialApi, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.SocialApi.INSTANCE.getUserMe());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.socialapi.SocialApi, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new UserMeResponse(coreResponse);
    }

    /* JADX INFO: compiled from: UserMe.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+¨\u0006/"}, d2 = {"Lcom/hive/protocol/socialapi/UserMe$UserMeResponse;", "Lcom/hive/protocol/socialapi/SocialApi$SocialApiResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "uid", "", "getUid", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "id", "getId", "setId", "name", "getName", "setName", "email", "getEmail", "setEmail", "fbid", "getFbid", "setFbid", "picture", "getPicture", "setPicture", UserDataStore.COUNTRY, "getCountry", "setCountry", "birthday", "getBirthday", "setBirthday", "gender", "getGender", "setGender", "comment", "getComment", "setComment", "isTestAccount", "", "()Z", "setTestAccount", "(Z)V", "cached", "getCached", "setCached", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserMeResponse extends SocialApi.SocialApiResponse {
        private String birthday;
        private boolean cached;
        private String comment;
        private String country;
        private String email;
        private String fbid;
        private String gender;
        private String id;
        private boolean isTestAccount;
        private String name;
        private String picture;
        private String uid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserMeResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.uid = "";
            this.id = "";
            this.name = "";
            this.email = "";
            this.fbid = "";
            this.picture = "";
            this.country = "";
            this.birthday = "";
            this.gender = "";
            this.comment = "";
            if (isSuccess()) {
                try {
                    String strOptString = getContentJSONObject().optString("");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.uid = strOptString;
                    String strOptString2 = getContentJSONObject().optString("");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    this.id = strOptString2;
                    String strOptString3 = getContentJSONObject().optString("");
                    Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                    this.name = strOptString3;
                    String strOptString4 = getContentJSONObject().optString("");
                    Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                    this.email = strOptString4;
                    String strOptString5 = getContentJSONObject().optString("");
                    Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                    this.fbid = strOptString5;
                    String strOptString6 = getContentJSONObject().optString("");
                    Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                    this.picture = strOptString6;
                    String strOptString7 = getContentJSONObject().optString("");
                    Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                    this.country = strOptString7;
                    String strOptString8 = getContentJSONObject().optString("");
                    Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                    this.birthday = strOptString8;
                    String strOptString9 = getContentJSONObject().optString("");
                    Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
                    this.gender = strOptString9;
                    String strOptString10 = getContentJSONObject().optString("");
                    Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
                    this.comment = strOptString10;
                    this.isTestAccount = getContentJSONObject().optInt("") != 0;
                    this.cached = getContentJSONObject().optBoolean("");
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setErrorCode(-1);
                    setErrorMsg("[Exception] " + e);
                }
            }
        }

        public final String getUid() {
            return this.uid;
        }

        public final void setUid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.id = str;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getEmail() {
            return this.email;
        }

        public final void setEmail(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.email = str;
        }

        public final String getFbid() {
            return this.fbid;
        }

        public final void setFbid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.fbid = str;
        }

        public final String getPicture() {
            return this.picture;
        }

        public final void setPicture(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.picture = str;
        }

        public final String getCountry() {
            return this.country;
        }

        public final void setCountry(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.country = str;
        }

        public final String getBirthday() {
            return this.birthday;
        }

        public final void setBirthday(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.birthday = str;
        }

        public final String getGender() {
            return this.gender;
        }

        public final void setGender(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.gender = str;
        }

        public final String getComment() {
            return this.comment;
        }

        public final void setComment(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.comment = str;
        }

        /* JADX INFO: renamed from: isTestAccount, reason: from getter */
        public final boolean getIsTestAccount() {
            return this.isTestAccount;
        }

        public final void setTestAccount(boolean z) {
            this.isTestAccount = z;
        }

        public final boolean getCached() {
            return this.cached;
        }

        public final void setCached(boolean z) {
            this.cached = z;
        }
    }
}
