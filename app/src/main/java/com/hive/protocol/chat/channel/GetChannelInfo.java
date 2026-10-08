package com.hive.protocol.chat.channel;

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

/* JADX INFO: compiled from: GetChannelInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0015\u001a\u00020\u0016H\u0010¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0010¢\u0006\u0002\b\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/hive/protocol/chat/channel/GetChannelInfo;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "gameIndex", "", "getGameIndex", "()I", "setGameIndex", "(I)V", "channelId", "", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "value", "Lcom/hive/protocol/chat/channel/GetChannelInfo$GetChannelInfoResponse;", "response", "getResponse", "()Lcom/hive/protocol/chat/channel/GetChannelInfo$GetChannelInfoResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "GetChannelInfoResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetChannelInfo extends ProtocolRequest {
    private GetChannelInfoResponse response;
    private int gameIndex = -1;
    private String channelId = "empty";

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

    public final GetChannelInfoResponse getResponse() {
        GetChannelInfoResponse getChannelInfoResponse = this.response;
        if (getChannelInfoResponse != null) {
            return getChannelInfoResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.HiveChat.INSTANCE.getChannel() + FileSystemKt.UnixPathSeparator + this.gameIndex + "/channels/" + this.channelId);
        getCoreRequest().setMethod(Request.MethodType.GET);
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new GetChannelInfoResponse(coreResponse);
    }

    /* JADX INFO: compiled from: GetChannelInfo.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/chat/channel/GetChannelInfo$GetChannelInfoResponse;", "Lcom/hive/protocol/chat/ChatResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "infoJsonObject", "Lorg/json/JSONObject;", "getInfoJsonObject", "()Lorg/json/JSONObject;", "setInfoJsonObject", "(Lorg/json/JSONObject;)V", "membersJsonArray", "Lorg/json/JSONArray;", "getMembersJsonArray", "()Lorg/json/JSONArray;", "setMembersJsonArray", "(Lorg/json/JSONArray;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetChannelInfoResponse extends ChatResponse {
        private JSONObject infoJsonObject;
        private JSONArray membersJsonArray;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetChannelInfoResponse(Response coreResponse) {
            JSONObject jSONObjectOptJSONObject;
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            try {
                if (!coreResponse.isSuccess() || (jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("data")) == null) {
                    return;
                }
                this.infoJsonObject = jSONObjectOptJSONObject.optJSONObject("info");
                this.membersJsonArray = jSONObjectOptJSONObject.optJSONArray("members");
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                setResultMessage("[Exception] " + e);
            }
        }

        public final JSONObject getInfoJsonObject() {
            return this.infoJsonObject;
        }

        public final void setInfoJsonObject(JSONObject jSONObject) {
            this.infoJsonObject = jSONObject;
        }

        public final JSONArray getMembersJsonArray() {
            return this.membersJsonArray;
        }

        public final void setMembersJsonArray(JSONArray jSONArray) {
            this.membersJsonArray = jSONArray;
        }
    }
}
