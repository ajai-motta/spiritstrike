package com.hive.protocol.promotionv2;

import androidx.core.provider.FontsContractCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.common.net.HttpHeaders;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.promotionv2.PromotionV2;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: UaSenderInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000b\u001a\u00020\fH\u0010¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0010¢\u0006\u0002\b\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/hive/protocol/promotionv2/UaSenderInfo;", "Lcom/hive/protocol/promotionv2/PromotionV2;", "<init>", "()V", "_authorization", "", "value", "Lcom/hive/protocol/promotionv2/UaSenderInfo$UaSenderInfoResponse;", "response", "getResponse", "()Lcom/hive/protocol/promotionv2/UaSenderInfo$UaSenderInfoResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "UaSenderInfoResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UaSenderInfo extends PromotionV2 {
    private final String _authorization = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NDE1NzMyOTcsImp0aSI6ImhpdmVfc2RrX3Y0In0.XuIoImfnwarw-zKdyrsQriB-O8jEkb-ui1L0-tpAHU8";
    private UaSenderInfoResponse response;

    public final UaSenderInfoResponse getResponse() {
        UaSenderInfoResponse uaSenderInfoResponse = this.response;
        if (uaSenderInfoResponse != null) {
            return uaSenderInfoResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.promotionv2.PromotionV2, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setContentType(Request.ContentType.JSON);
        getCoreRequest().getHeader().put(HttpHeaders.AUTHORIZATION, this._authorization);
        getCoreRequest().setUrl(UrlManager.PromotionV2.INSTANCE.getUaSenderInfo());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.promotionv2.PromotionV2, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new UaSenderInfoResponse(coreResponse);
    }

    /* JADX INFO: compiled from: UaSenderInfo.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/hive/protocol/promotionv2/UaSenderInfo$UaSenderInfoResponse;", "Lcom/hive/protocol/promotionv2/PromotionV2$PromotionV2Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "isSuccess", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UaSenderInfoResponse extends PromotionV2.PromotionV2Response {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UaSenderInfoResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        }

        @Override // com.hive.protocol.promotionv2.PromotionV2.PromotionV2Response, com.hive.core.Response
        public boolean isSuccess() {
            return getResultCode() == 0;
        }

        @Override // com.hive.core.Response
        public String toString() {
            Object objM7415constructorimpl;
            JSONObject jSONObject = new JSONObject();
            try {
                Result.Companion companion = Result.INSTANCE;
                jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, getResultCode());
                objM7415constructorimpl = Result.m7415constructorimpl(jSONObject.put("result_message", getResultMessage()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                Logger.INSTANCE.w("[UaSenderInfo] Throwable : " + thM7418exceptionOrNullimpl.getMessage());
            }
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }
}
