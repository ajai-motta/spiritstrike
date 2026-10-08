package com.hive.protocol.pushv4;

import com.google.common.net.HttpHeaders;
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

/* JADX INFO: compiled from: PushV4.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0007H\u0010¢\u0006\u0002\b\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0010¢\u0006\u0002\b\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/hive/protocol/pushv4/PushV4;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "_authorization", "", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "PushV4Response", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PushV4 extends ProtocolRequest {
    private final String _authorization = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NDE1NzMyOTcsImp0aSI6ImhpdmVfc2RrX3Y0In0.XuIoImfnwarw-zKdyrsQriB-O8jEkb-ui1L0-tpAHU8";

    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() throws JSONException {
        getCoreRequest().setContentType(Request.ContentType.JSON);
        getCoreRequest().getHeader().put(HttpHeaders.AUTHORIZATION, this._authorization);
        CommonIdentifierKt.putCI(getJsonBody());
        Request coreRequest = getCoreRequest();
        String string = getJsonBody().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        coreRequest.setBody(bytes);
        return super.toCoreRequest$hive_protocol_release();
    }

    /* JADX INFO: compiled from: PushV4.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/hive/protocol/pushv4/PushV4$PushV4Response;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "reason", "", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class PushV4Response extends ProtocolResponse {
        private String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PushV4Response(Response coreResponse) {
            JSONObject jSONObjectOptJSONObject;
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.reason = "";
            try {
                if (!coreResponse.isFailure() || (jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("error")) == null) {
                    return;
                }
                String strOptString = jSONObjectOptJSONObject.optString("reason");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                this.reason = strOptString;
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                this.reason = "[Exception] " + e;
            }
        }

        public final String getReason() {
            return this.reason;
        }

        public final void setReason(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.reason = str;
        }
    }
}
