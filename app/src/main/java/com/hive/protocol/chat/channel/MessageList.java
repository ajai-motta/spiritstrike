package com.hive.protocol.chat.channel;

import com.hive.core.ExtentionsKt;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.UrlManager;
import com.hive.protocol.chat.ChatResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.FileSystemKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MessageList.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0018\u001a\u00020\u0019H\u0010¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0010¢\u0006\u0002\b\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/hive/protocol/chat/channel/MessageList;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "gameIndex", "", "getGameIndex", "()I", "setGameIndex", "(I)V", "channelId", "", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "queryString", "getQueryString", "setQueryString", "value", "Lcom/hive/protocol/chat/channel/MessageList$MessageListResponse;", "response", "getResponse", "()Lcom/hive/protocol/chat/channel/MessageList$MessageListResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "MessageListResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageList extends ProtocolRequest {
    private MessageListResponse response;
    private int gameIndex = -1;
    private String channelId = "empty";
    private String queryString = "";

    public final int getGameIndex() {
        return this.gameIndex;
    }

    public final void setGameIndex(int i) {
        this.gameIndex = i;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    public final String getQueryString() {
        return this.queryString;
    }

    public final void setQueryString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.queryString = str;
    }

    public final MessageListResponse getResponse() {
        MessageListResponse messageListResponse = this.response;
        if (messageListResponse != null) {
            return messageListResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.HiveChat.INSTANCE.getChannelV2() + FileSystemKt.UnixPathSeparator + this.gameIndex + "/channels/" + this.channelId + "/messages");
        if (this.queryString.length() > 0) {
            Request coreRequest = getCoreRequest();
            coreRequest.setUrl(coreRequest.getUrl() + '?' + this.queryString);
        }
        getCoreRequest().setMethod(Request.MethodType.GET);
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new MessageListResponse(coreResponse);
    }

    /* JADX INFO: compiled from: MessageList.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/hive/protocol/chat/channel/MessageList$MessageListResponse;", "Lcom/hive/protocol/chat/ChatResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "hasNext", "", "getHasNext", "()Z", "setHasNext", "(Z)V", "nextMessageId", "", "getNextMessageId", "()Ljava/lang/String;", "setNextMessageId", "(Ljava/lang/String;)V", "hasPrev", "getHasPrev", "setHasPrev", "prevMessageId", "getPrevMessageId", "setPrevMessageId", "contentJsonArray", "Lorg/json/JSONArray;", "getContentJsonArray", "()Lorg/json/JSONArray;", "setContentJsonArray", "(Lorg/json/JSONArray;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MessageListResponse extends ChatResponse {
        private JSONArray contentJsonArray;
        private boolean hasNext;
        private boolean hasPrev;
        private String nextMessageId;
        private String prevMessageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageListResponse(Response coreResponse) {
            JSONObject jSONObjectOptJSONObject;
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            String str = "";
            this.nextMessageId = "";
            this.prevMessageId = "";
            try {
                if (!coreResponse.isSuccess() || (jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("data")) == null) {
                    return;
                }
                this.hasNext = jSONObjectOptJSONObject.optBoolean("hasNext");
                String strOptStringOrNull = ExtentionsKt.optStringOrNull(jSONObjectOptJSONObject, "nextMessageId");
                this.nextMessageId = strOptStringOrNull == null ? "" : strOptStringOrNull;
                this.hasPrev = jSONObjectOptJSONObject.optBoolean("hasPrev");
                String strOptStringOrNull2 = ExtentionsKt.optStringOrNull(jSONObjectOptJSONObject, "prevMessageId");
                if (strOptStringOrNull2 != null) {
                    str = strOptStringOrNull2;
                }
                this.prevMessageId = str;
                this.contentJsonArray = jSONObjectOptJSONObject.optJSONArray("content");
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                setResultMessage("[Exception] " + e);
            }
        }

        public final boolean getHasNext() {
            return this.hasNext;
        }

        public final void setHasNext(boolean z) {
            this.hasNext = z;
        }

        public final String getNextMessageId() {
            return this.nextMessageId;
        }

        public final void setNextMessageId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.nextMessageId = str;
        }

        public final boolean getHasPrev() {
            return this.hasPrev;
        }

        public final void setHasPrev(boolean z) {
            this.hasPrev = z;
        }

        public final String getPrevMessageId() {
            return this.prevMessageId;
        }

        public final void setPrevMessageId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.prevMessageId = str;
        }

        public final JSONArray getContentJsonArray() {
            return this.contentJsonArray;
        }

        public final void setContentJsonArray(JSONArray jSONArray) {
            this.contentJsonArray = jSONArray;
        }
    }
}
