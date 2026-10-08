package com.hive.protocol.userengagement;

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

/* JADX INFO: compiled from: UserEngagement.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/protocol/userengagement/UserEngagement;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "UserEngagementResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UserEngagement extends ProtocolRequest {
    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() throws JSONException {
        CommonIdentifierKt.putCI(getJsonBody());
        Request coreRequest = getCoreRequest();
        String string = getJsonBody().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        coreRequest.setBody(bytes);
        return super.toCoreRequest$hive_protocol_release();
    }

    /* JADX INFO: compiled from: UserEngagement.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/hive/protocol/userengagement/UserEngagement$UserEngagementResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "code", "", "getCode", "()I", "setCode", "(I)V", NotificationCompat.CATEGORY_MESSAGE, "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class UserEngagementResponse extends ProtocolResponse {
        private int code;
        private String msg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserEngagementResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.code = 501;
            this.msg = "";
            try {
                if (coreResponse.isSuccess()) {
                    this.code = getContentJSONObject().getInt("code");
                    String strOptString = getContentJSONObject().optString(NotificationCompat.CATEGORY_MESSAGE);
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.msg = strOptString;
                }
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                this.code = 501;
                this.msg = "[Exception] " + e;
            }
        }

        public final int getCode() {
            return this.code;
        }

        public final void setCode(int i) {
            this.code = i;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final void setMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.msg = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.code == 100;
        }
    }
}
