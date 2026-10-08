package com.hive.protocol.iapv2;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.iapv2.IapV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PurchaseCheck.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/iapv2/PurchaseCheck;", "Lcom/hive/protocol/iapv2/IapV2;", "<init>", "()V", "value", "Lcom/hive/protocol/iapv2/PurchaseCheck$PurchaseCheckResponse;", "response", "getResponse", "()Lcom/hive/protocol/iapv2/PurchaseCheck$PurchaseCheckResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "PurchaseCheckResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PurchaseCheck extends IapV2 {
    private PurchaseCheckResponse response;

    public PurchaseCheck() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_pid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_price);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_currency);
    }

    public final PurchaseCheckResponse getResponse() {
        PurchaseCheckResponse purchaseCheckResponse = this.response;
        if (purchaseCheckResponse != null) {
            return purchaseCheckResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.iapv2.IapV2, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.IapV2.INSTANCE.getPurchaseCheck());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.iapv2.IapV2, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new PurchaseCheckResponse(coreResponse);
    }

    /* JADX INFO: compiled from: PurchaseCheck.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/protocol/iapv2/PurchaseCheck$PurchaseCheckResponse;", "Lcom/hive/protocol/iapv2/IapV2$IapV2Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PurchaseCheckResponse extends IapV2.IapV2Response {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PurchaseCheckResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        }
    }
}
