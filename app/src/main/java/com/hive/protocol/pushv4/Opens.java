package com.hive.protocol.pushv4;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.pushv4.PushV4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Opens.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/pushv4/Opens;", "Lcom/hive/protocol/pushv4/PushV4;", "<init>", "()V", "value", "Lcom/hive/protocol/pushv4/Opens$OpensResponse;", "response", "getResponse", "()Lcom/hive/protocol/pushv4/Opens$OpensResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "OpensResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Opens extends PushV4 {
    private OpensResponse response;

    public Opens() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_type);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_uuid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_summary);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_device);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_identifier);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_app);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_timestamp);
    }

    public final OpensResponse getResponse() {
        OpensResponse opensResponse = this.response;
        if (opensResponse != null) {
            return opensResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.pushv4.PushV4, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.PushV4.INSTANCE.getOpens());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.pushv4.PushV4, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new OpensResponse(coreResponse);
    }

    /* JADX INFO: compiled from: Opens.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/protocol/pushv4/Opens$OpensResponse;", "Lcom/hive/protocol/pushv4/PushV4$PushV4Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OpensResponse extends PushV4.PushV4Response {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpensResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        }
    }
}
