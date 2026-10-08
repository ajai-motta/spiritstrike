package com.hive.protocol.matchmaking;

import androidx.core.app.NotificationCompat;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MatchMaking.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\n\u001a\u00020\u000bH\u0010¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/hive/protocol/matchmaking/MatchMaking;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "matchId", "", "getMatchId", "()I", "setMatchId", "(I)V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "MatchMakingResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MatchMaking extends ProtocolRequest {
    private int matchId;

    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    public final int getMatchId() {
        return this.matchId;
    }

    public final void setMatchId(int i) {
        this.matchId = i;
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() throws JSONException {
        getCoreRequest().setContentType(Request.ContentType.JSON);
        CommonIdentifierKt.putCI(getJsonBody());
        Request coreRequest = getCoreRequest();
        String string = getJsonBody().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        coreRequest.setBody(bytes);
        return super.toCoreRequest$hive_protocol_release();
    }

    /* JADX INFO: compiled from: MatchMaking.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/hive/protocol/matchmaking/MatchMaking$MatchMakingResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "msgCode", "", "getMsgCode", "()I", "setMsgCode", "(I)V", NotificationCompat.CATEGORY_MESSAGE, "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class MatchMakingResponse extends ProtocolResponse {
        private JSONObject data;
        private String msg;
        private int msgCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MatchMakingResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.msgCode = -1;
            this.msg = "";
            try {
                if (coreResponse.isSuccess()) {
                    this.msgCode = 0;
                    this.msg = "success";
                    this.data = getContentJSONObject();
                } else {
                    this.msgCode = getContentJSONObject().optInt("code", -1);
                    String strOptString = getContentJSONObject().optString("reason", "failed");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.msg = strOptString;
                }
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                this.msgCode = -1;
                this.msg = "[Exception] " + e;
            }
        }

        public final int getMsgCode() {
            return this.msgCode;
        }

        public final void setMsgCode(int i) {
            this.msgCode = i;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final void setMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.msg = str;
        }

        public final JSONObject getData() {
            return this.data;
        }

        public final void setData(JSONObject jSONObject) {
            this.data = jSONObject;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.msgCode == 0;
        }
    }
}
