package com.hive.protocol.socialfriendapi;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.socialfriendapi.SocialFriendApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageWrite.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/socialfriendapi/MessageWrite;", "Lcom/hive/protocol/socialfriendapi/SocialFriendApi;", "<init>", "()V", "value", "Lcom/hive/protocol/socialfriendapi/MessageWrite$MessageWriteResponse;", "response", "getResponse", "()Lcom/hive/protocol/socialfriendapi/MessageWrite$MessageWriteResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "MessageWriteResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageWrite extends SocialFriendApi {
    private MessageWriteResponse response;

    public MessageWrite() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_uid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_text);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_picture);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_thumbnail);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_push);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_invite);
    }

    public final MessageWriteResponse getResponse() {
        MessageWriteResponse messageWriteResponse = this.response;
        if (messageWriteResponse != null) {
            return messageWriteResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.socialfriendapi.SocialFriendApi, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.SocialFriendApi.INSTANCE.getMessageWrite());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.socialfriendapi.SocialFriendApi, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new MessageWriteResponse(coreResponse);
    }

    /* JADX INFO: compiled from: MessageWrite.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/hive/protocol/socialfriendapi/MessageWrite$MessageWriteResponse;", "Lcom/hive/protocol/socialfriendapi/SocialFriendApi$SocialFriendApiResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "uid", "", "getUid", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "fbid", "getFbid", "setFbid", "pushResult", "", "getPushResult", "()Z", "setPushResult", "(Z)V", "inviteResult", "getInviteResult", "setInviteResult", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MessageWriteResponse extends SocialFriendApi.SocialFriendApiResponse {
        private String fbid;
        private boolean inviteResult;
        private boolean pushResult;
        private String uid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageWriteResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.uid = "";
            this.fbid = "";
            if (isSuccess()) {
                try {
                    String strOptString = getContentJSONObject().optString("uid");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.uid = strOptString;
                    String strOptString2 = getContentJSONObject().optString("fbid");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    this.fbid = strOptString2;
                    this.pushResult = getContentJSONObject().optBoolean("push_result");
                    this.inviteResult = getContentJSONObject().optBoolean("invite_result");
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

        public final String getFbid() {
            return this.fbid;
        }

        public final void setFbid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.fbid = str;
        }

        public final boolean getPushResult() {
            return this.pushResult;
        }

        public final void setPushResult(boolean z) {
            this.pushResult = z;
        }

        public final boolean getInviteResult() {
            return this.inviteResult;
        }

        public final void setInviteResult(boolean z) {
            this.inviteResult = z;
        }
    }
}
