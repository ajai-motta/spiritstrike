package com.hive.protocol.promotionv2;

import androidx.core.provider.FontsContractCompat;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: PromotionV2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/protocol/promotionv2/PromotionV2;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "PromotionV2Response", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PromotionV2 extends ProtocolRequest {
    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        JSONObject jSONObjectPutCI;
        if (getJsonBody().has(HiveKeys.KEY_user.getValue())) {
            JSONObject jSONObjectOptJSONObject = getJsonBody().optJSONObject(HiveKeys.KEY_user.getValue());
            if (jSONObjectOptJSONObject != null && (jSONObjectPutCI = CommonIdentifierKt.putCI(jSONObjectOptJSONObject)) != null) {
                CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_user, jSONObjectPutCI);
            }
        } else {
            CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_user, CommonIdentifierKt.putCI(new JSONObject()));
        }
        Request coreRequest = getCoreRequest();
        String string = getJsonBody().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        coreRequest.setBody(bytes);
        return super.toCoreRequest$hive_protocol_release();
    }

    /* JADX INFO: compiled from: PromotionV2.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/hive/protocol/promotionv2/PromotionV2$PromotionV2Response;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "resultMessage", "", "getResultMessage", "()Ljava/lang/String;", "setResultMessage", "(Ljava/lang/String;)V", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class PromotionV2Response extends ProtocolResponse {
        private int resultCode;
        private String resultMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PromotionV2Response(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.resultCode = -1;
            this.resultMessage = "";
            try {
                if (coreResponse.isSuccess()) {
                    this.resultCode = getContentJSONObject().getInt(FontsContractCompat.Columns.RESULT_CODE);
                    String strOptString = getContentJSONObject().optString("result_message");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.resultMessage = strOptString;
                }
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                this.resultCode = -1;
                this.resultMessage = "[Exception] " + e;
            }
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        public final void setResultCode(int i) {
            this.resultCode = i;
        }

        public final String getResultMessage() {
            return this.resultMessage;
        }

        public final void setResultMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.resultMessage = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.resultCode == 200;
        }
    }
}
