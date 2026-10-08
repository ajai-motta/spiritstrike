package com.hive.protocol.promotionv2;

import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.promotionv2.PromotionV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeferredMatch.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/promotionv2/DeferredMatch;", "Lcom/hive/protocol/promotionv2/PromotionV2;", "<init>", "()V", "value", "Lcom/hive/protocol/promotionv2/DeferredMatch$DeferredMatchResponse;", "response", "getResponse", "()Lcom/hive/protocol/promotionv2/DeferredMatch$DeferredMatchResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "DeferredMatchResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeferredMatch extends PromotionV2 {
    private DeferredMatchResponse response;

    public final DeferredMatchResponse getResponse() {
        DeferredMatchResponse deferredMatchResponse = this.response;
        if (deferredMatchResponse != null) {
            return deferredMatchResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.promotionv2.PromotionV2, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.PromotionV2.INSTANCE.getDeferredMatch());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.promotionv2.PromotionV2, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new DeferredMatchResponse(coreResponse);
    }

    /* JADX INFO: compiled from: DeferredMatch.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/hive/protocol/promotionv2/DeferredMatch$DeferredMatchResponse;", "Lcom/hive/protocol/promotionv2/PromotionV2$PromotionV2Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "deeplinkUrl", "", "getDeeplinkUrl", "()Ljava/lang/String;", "setDeeplinkUrl", "(Ljava/lang/String;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DeferredMatchResponse extends PromotionV2.PromotionV2Response {
        private String deeplinkUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeferredMatchResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            if (isSuccess()) {
                try {
                    this.deeplinkUrl = getContentJSONObject().optJSONObject("result").optString("deeplink_url");
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setResultCode(-1);
                    setResultMessage("[Exception] " + e);
                }
            }
        }

        public final String getDeeplinkUrl() {
            return this.deeplinkUrl;
        }

        public final void setDeeplinkUrl(String str) {
            this.deeplinkUrl = str;
        }
    }
}
