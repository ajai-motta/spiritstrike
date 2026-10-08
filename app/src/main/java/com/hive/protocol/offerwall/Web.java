package com.hive.protocol.offerwall;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.offerwall.Offerwall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Web.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/offerwall/Web;", "Lcom/hive/protocol/offerwall/Offerwall;", "<init>", "()V", "value", "Lcom/hive/protocol/offerwall/Web$WebResponse;", "response", "getResponse", "()Lcom/hive/protocol/offerwall/Web$WebResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "WebResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Web extends Offerwall {
    private WebResponse response;

    public Web() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_uid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_vid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_mac);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_devicetype);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_lan);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_con);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_osver);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_libver);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_appver);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_appvercode);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_addionalInfo);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_path);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_mcc);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_mnc);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_eventID);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_assetcode);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_assetamount);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_oq_result);
    }

    public final WebResponse getResponse() {
        WebResponse webResponse = this.response;
        if (webResponse != null) {
            return webResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.offerwall.Offerwall, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.Offerwall.INSTANCE.getWeb());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.offerwall.Offerwall, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new WebResponse(coreResponse);
    }

    /* JADX INFO: compiled from: Web.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/protocol/offerwall/Web$WebResponse;", "Lcom/hive/protocol/offerwall/Offerwall$OfferwallResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WebResponse extends Offerwall.OfferwallResponse {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        }
    }
}
