package com.hive.protocol.chinaapi;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.chinaapi.ChinaApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChinaVerifyPhoneConfirm.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/chinaapi/ChinaVerifyPhoneConfirm;", "Lcom/hive/protocol/chinaapi/ChinaApi;", "<init>", "()V", "value", "Lcom/hive/protocol/chinaapi/ChinaVerifyPhoneConfirm$ChinaVerifyPhoneConfirmResponse;", "response", "getResponse", "()Lcom/hive/protocol/chinaapi/ChinaVerifyPhoneConfirm$ChinaVerifyPhoneConfirmResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "ChinaVerifyPhoneConfirmResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChinaVerifyPhoneConfirm extends ChinaApi {
    private ChinaVerifyPhoneConfirmResponse response;

    public ChinaVerifyPhoneConfirm() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_auth_code);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_phone_number);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_game_language);
    }

    public final ChinaVerifyPhoneConfirmResponse getResponse() {
        ChinaVerifyPhoneConfirmResponse chinaVerifyPhoneConfirmResponse = this.response;
        if (chinaVerifyPhoneConfirmResponse != null) {
            return chinaVerifyPhoneConfirmResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.chinaapi.ChinaApi, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.ChinaApi.INSTANCE.getChinaVerifyPhoneConfirm());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.chinaapi.ChinaApi, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new ChinaVerifyPhoneConfirmResponse(coreResponse);
    }

    /* JADX INFO: compiled from: ChinaVerifyPhoneConfirm.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/protocol/chinaapi/ChinaVerifyPhoneConfirm$ChinaVerifyPhoneConfirmResponse;", "Lcom/hive/protocol/chinaapi/ChinaApi$ChinaApiResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChinaVerifyPhoneConfirmResponse extends ChinaApi.ChinaApiResponse {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChinaVerifyPhoneConfirmResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        }
    }
}
