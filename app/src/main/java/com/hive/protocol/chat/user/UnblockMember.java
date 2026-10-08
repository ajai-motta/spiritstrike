package com.hive.protocol.chat.user;

import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.UrlManager;
import com.hive.protocol.chat.ChatResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UnblockMember.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0018\u001a\u00020\u0019H\u0010¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0010¢\u0006\u0002\b\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/hive/protocol/chat/user/UnblockMember;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "gameIndex", "", "getGameIndex", "()I", "setGameIndex", "(I)V", "playerId", "", "getPlayerId", "()Ljava/lang/String;", "setPlayerId", "(Ljava/lang/String;)V", "blockedPlayerId", "getBlockedPlayerId", "setBlockedPlayerId", "value", "Lcom/hive/protocol/chat/user/UnblockMember$UnblockMemberResponse;", "response", "getResponse", "()Lcom/hive/protocol/chat/user/UnblockMember$UnblockMemberResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "UnblockMemberResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnblockMember extends ProtocolRequest {
    private UnblockMemberResponse response;
    private int gameIndex = -1;
    private String playerId = "empty";
    private String blockedPlayerId = "empty";

    public final int getGameIndex() {
        return this.gameIndex;
    }

    public final void setGameIndex(int i) {
        this.gameIndex = i;
    }

    public final String getPlayerId() {
        return this.playerId;
    }

    public final void setPlayerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playerId = str;
    }

    public final String getBlockedPlayerId() {
        return this.blockedPlayerId;
    }

    public final void setBlockedPlayerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.blockedPlayerId = str;
    }

    public final UnblockMemberResponse getResponse() {
        UnblockMemberResponse unblockMemberResponse = this.response;
        if (unblockMemberResponse != null) {
            return unblockMemberResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.HiveChat.INSTANCE.getUser() + "/games/" + this.gameIndex + "/users/" + this.playerId + "/block/" + this.blockedPlayerId);
        getCoreRequest().setMethod(Request.MethodType.DELETE);
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new UnblockMemberResponse(coreResponse);
    }

    /* JADX INFO: compiled from: UnblockMember.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/protocol/chat/user/UnblockMember$UnblockMemberResponse;", "Lcom/hive/protocol/chat/ChatResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UnblockMemberResponse extends ChatResponse {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnblockMemberResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        }
    }
}
