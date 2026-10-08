package com.hive.protocol.chat.channel;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.UrlManager;
import com.hive.protocol.chat.ChatResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.io.files.FileSystemKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: CreateChannel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0010¢\u0006\u0002\b\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/hive/protocol/chat/channel/CreateChannel;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "gameIndex", "", "getGameIndex", "()I", "setGameIndex", "(I)V", "value", "Lcom/hive/protocol/chat/channel/CreateChannel$CreateChannelResponse;", "response", "getResponse", "()Lcom/hive/protocol/chat/channel/CreateChannel$CreateChannelResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "CreateChannelResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateChannel extends ProtocolRequest {
    private int gameIndex = -1;
    private CreateChannelResponse response;

    public CreateChannel() {
        JSONObject jsonBody = getJsonBody();
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_channelId);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_playerId);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_password);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_channelName);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_maxMemberCount);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_type);
    }

    public final int getGameIndex() {
        return this.gameIndex;
    }

    public final void setGameIndex(int i) {
        this.gameIndex = i;
    }

    public final CreateChannelResponse getResponse() {
        CreateChannelResponse createChannelResponse = this.response;
        if (createChannelResponse != null) {
            return createChannelResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.HiveChat.INSTANCE.getChannel() + FileSystemKt.UnixPathSeparator + this.gameIndex + "/channel");
        getCoreRequest().setMethod(Request.MethodType.POST);
        getCoreRequest().setContentType(Request.ContentType.JSON);
        Request coreRequest = getCoreRequest();
        String string = getJsonBody().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        coreRequest.setBody(bytes);
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new CreateChannelResponse(coreResponse);
    }

    /* JADX INFO: compiled from: CreateChannel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/protocol/chat/channel/CreateChannel$CreateChannelResponse;", "Lcom/hive/protocol/chat/ChatResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CreateChannelResponse extends ChatResponse {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CreateChannelResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        }
    }
}
