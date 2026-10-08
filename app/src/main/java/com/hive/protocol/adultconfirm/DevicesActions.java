package com.hive.protocol.adultconfirm;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.adultconfirm.AdultConfirm;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DevicesActions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/adultconfirm/DevicesActions;", "Lcom/hive/protocol/adultconfirm/AdultConfirm;", "<init>", "()V", "value", "Lcom/hive/protocol/adultconfirm/DevicesActions$DevicesActionsResponse;", "response", "getResponse", "()Lcom/hive/protocol/adultconfirm/DevicesActions$DevicesActionsResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "DevicesActionsResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DevicesActions extends AdultConfirm {
    private DevicesActionsResponse response;

    public DevicesActions() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid_sessionkey);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid_type);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_phone_code);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_phone_number);
    }

    public final DevicesActionsResponse getResponse() {
        DevicesActionsResponse devicesActionsResponse = this.response;
        if (devicesActionsResponse != null) {
            return devicesActionsResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.adultconfirm.AdultConfirm, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.AdultConfirm.INSTANCE.getDevicesActions());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.adultconfirm.AdultConfirm, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new DevicesActionsResponse(coreResponse);
    }

    /* JADX INFO: compiled from: DevicesActions.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/hive/protocol/adultconfirm/DevicesActions$DevicesActionsResponse;", "Lcom/hive/protocol/adultconfirm/AdultConfirm$AdultConfirmResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "devicesActionsResult", "", "getDevicesActionsResult", "()I", "setDevicesActionsResult", "(I)V", "devicesActionsResultMsg", "", "getDevicesActionsResultMsg", "()Ljava/lang/String;", "setDevicesActionsResultMsg", "(Ljava/lang/String;)V", InAppPurchaseMetaData.KEY_SIGNATURE, "getSignature", "setSignature", "signatureResultCode", "getSignatureResultCode", "setSignatureResultCode", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DevicesActionsResponse extends AdultConfirm.AdultConfirmResponse {
        private int devicesActionsResult;
        private String devicesActionsResultMsg;
        private String signature;
        private String signatureResultCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DevicesActionsResponse(Response coreResponse) {
            Object objM7415constructorimpl;
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.devicesActionsResult = -1;
            try {
                Result.Companion companion = Result.INSTANCE;
                DevicesActionsResponse devicesActionsResponse = this;
                if (coreResponse.isSuccess()) {
                    this.devicesActionsResult = getContentJSONObject().getInt("result");
                    this.devicesActionsResultMsg = getContentJSONObject().optString("result_msg");
                    this.signature = getContentJSONObject().optString(InAppPurchaseMetaData.KEY_SIGNATURE);
                    this.signatureResultCode = getContentJSONObject().optString("signature_result_code");
                }
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                Logger.INSTANCE.protocolLog(thM7418exceptionOrNullimpl.toString(), Logger.LogType.Warning);
                this.devicesActionsResult = -1;
                this.devicesActionsResultMsg = "[Exception] " + thM7418exceptionOrNullimpl;
            }
        }

        public final int getDevicesActionsResult() {
            return this.devicesActionsResult;
        }

        public final void setDevicesActionsResult(int i) {
            this.devicesActionsResult = i;
        }

        public final String getDevicesActionsResultMsg() {
            return this.devicesActionsResultMsg;
        }

        public final void setDevicesActionsResultMsg(String str) {
            this.devicesActionsResultMsg = str;
        }

        public final String getSignature() {
            return this.signature;
        }

        public final void setSignature(String str) {
            this.signature = str;
        }

        public final String getSignatureResultCode() {
            return this.signatureResultCode;
        }

        public final void setSignatureResultCode(String str) {
            this.signatureResultCode = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.devicesActionsResult == 200;
        }
    }
}
