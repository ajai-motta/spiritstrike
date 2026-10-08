package com.hive.protocol.push;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.push.Push;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AgreeV1Get.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/push/AgreeV1Get;", "Lcom/hive/protocol/push/Push;", "<init>", "()V", "value", "Lcom/hive/protocol/push/AgreeV1Get$AgreeV1GetResponse;", "response", "getResponse", "()Lcom/hive/protocol/push/AgreeV1Get$AgreeV1GetResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "AgreeV1GetResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AgreeV1Get extends Push {
    private AgreeV1GetResponse response;

    public AgreeV1Get() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid);
    }

    public final AgreeV1GetResponse getResponse() {
        AgreeV1GetResponse agreeV1GetResponse = this.response;
        if (agreeV1GetResponse != null) {
            return agreeV1GetResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.push.Push, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.Push.INSTANCE.getAgreeV1Get());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.push.Push, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new AgreeV1GetResponse(coreResponse);
    }

    /* JADX INFO: compiled from: AgreeV1Get.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/hive/protocol/push/AgreeV1Get$AgreeV1GetResponse;", "Lcom/hive/protocol/push/Push$PushResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "agreement", "", "getAgreement", "()I", "setAgreement", "(I)V", "adPush", "", "getAdPush", "()Z", "setAdPush", "(Z)V", "nightPush", "getNightPush", "setNightPush", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AgreeV1GetResponse extends Push.PushResponse {
        private boolean adPush;
        private int agreement;
        private boolean nightPush;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AgreeV1GetResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.agreement = -1;
            boolean z = true;
            this.adPush = true;
            if (isSuccess()) {
                try {
                    this.agreement = getContentJSONObject().getInt("agreement");
                    this.adPush = getContentJSONObject().getInt("ad_push") == 1;
                    if (getContentJSONObject().getInt("night_push") != 1) {
                        z = false;
                    }
                    this.nightPush = z;
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setErrno(-1);
                    setError("[Exception] " + e);
                }
            }
        }

        public final int getAgreement() {
            return this.agreement;
        }

        public final void setAgreement(int i) {
            this.agreement = i;
        }

        public final boolean getAdPush() {
            return this.adPush;
        }

        public final void setAdPush(boolean z) {
            this.adPush = z;
        }

        public final boolean getNightPush() {
            return this.nightPush;
        }

        public final void setNightPush(boolean z) {
            this.nightPush = z;
        }
    }
}
