package com.hive.protocol.mercury;

import androidx.core.provider.FontsContractCompat;
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

/* JADX INFO: compiled from: Mercury.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lcom/hive/protocol/mercury/Mercury;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "MercuryResponse", "PromotionV1Response", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Mercury extends ProtocolRequest {
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

    /* JADX INFO: compiled from: Mercury.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/hive/protocol/mercury/Mercury$MercuryResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "error", "", "getError", "()I", "setError", "(I)V", "errormsg", "", "getErrormsg", "()Ljava/lang/String;", "setErrormsg", "(Ljava/lang/String;)V", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class MercuryResponse extends ProtocolResponse {
        private int error;
        private String errormsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MercuryResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.error = -1;
            try {
                if (coreResponse.isSuccess()) {
                    this.error = getContentJSONObject().getInt("error");
                    this.errormsg = getContentJSONObject().optString("errormsg");
                }
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                this.error = -1;
                this.errormsg = "[Exception] " + e.getMessage();
            }
        }

        public final int getError() {
            return this.error;
        }

        public final void setError(int i) {
            this.error = i;
        }

        public final String getErrormsg() {
            return this.errormsg;
        }

        public final void setErrormsg(String str) {
            this.errormsg = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.error == 0;
        }
    }

    /* JADX INFO: compiled from: Mercury.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/hive/protocol/mercury/Mercury$PromotionV1Response;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", FontsContractCompat.Columns.RESULT_CODE, "", "getResult_code", "()I", "setResult_code", "(I)V", "result_message", "", "getResult_message", "()Ljava/lang/String;", "setResult_message", "(Ljava/lang/String;)V", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class PromotionV1Response extends ProtocolResponse {
        private int result_code;
        private String result_message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PromotionV1Response(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.result_code = -1;
            try {
                if (coreResponse.isSuccess()) {
                    this.result_code = getContentJSONObject().getInt(FontsContractCompat.Columns.RESULT_CODE);
                    this.result_message = getContentJSONObject().optString("result_message");
                }
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                this.result_code = -1;
                this.result_message = "[Exception] " + e.getMessage();
            }
        }

        public final int getResult_code() {
            return this.result_code;
        }

        public final void setResult_code(int i) {
            this.result_code = i;
        }

        public final String getResult_message() {
            return this.result_message;
        }

        public final void setResult_message(String str) {
            this.result_message = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.result_code == 200;
        }
    }
}
