package com.hive.protocol.adultconfirm;

import androidx.core.provider.FontsContractCompat;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.adultconfirm.AdultConfirm;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiHash.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/adultconfirm/DiHash;", "Lcom/hive/protocol/adultconfirm/AdultConfirm;", "<init>", "()V", "value", "Lcom/hive/protocol/adultconfirm/DiHash$AdultCheckResponse;", "response", "getResponse", "()Lcom/hive/protocol/adultconfirm/DiHash$AdultCheckResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "AdultCheckResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiHash extends AdultConfirm {
    private AdultCheckResponse response;

    public DiHash() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid_type);
    }

    public final AdultCheckResponse getResponse() {
        AdultCheckResponse adultCheckResponse = this.response;
        if (adultCheckResponse != null) {
            return adultCheckResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.adultconfirm.AdultConfirm, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.AdultConfirm.INSTANCE.getDiHash());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.adultconfirm.AdultConfirm, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new AdultCheckResponse(coreResponse);
    }

    /* JADX INFO: compiled from: DiHash.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/hive/protocol/adultconfirm/DiHash$AdultCheckResponse;", "Lcom/hive/protocol/adultconfirm/AdultConfirm$AdultConfirmResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "resultMsg", "", "getResultMsg", "()Ljava/lang/String;", "setResultMsg", "(Ljava/lang/String;)V", "vid", "getVid", "setVid", "diHash", "getDiHash", "setDiHash", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AdultCheckResponse extends AdultConfirm.AdultConfirmResponse {
        private String diHash;
        private int resultCode;
        private String resultMsg;
        private String vid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdultCheckResponse(Response coreResponse) {
            Object objM7415constructorimpl;
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.resultCode = -1;
            try {
                Result.Companion companion = Result.INSTANCE;
                AdultCheckResponse adultCheckResponse = this;
                if (coreResponse.isSuccess()) {
                    this.resultCode = getContentJSONObject().getInt(FontsContractCompat.Columns.RESULT_CODE);
                    this.resultMsg = getContentJSONObject().optString("result_msg");
                    this.vid = getContentJSONObject().optString("vid");
                    this.diHash = getContentJSONObject().optString("di_hash");
                }
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                Logger.INSTANCE.protocolLog(thM7418exceptionOrNullimpl.toString(), Logger.LogType.Warning);
                this.vid = null;
                this.diHash = null;
                this.resultMsg = "[Exception] " + thM7418exceptionOrNullimpl;
            }
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        public final void setResultCode(int i) {
            this.resultCode = i;
        }

        public final String getResultMsg() {
            return this.resultMsg;
        }

        public final void setResultMsg(String str) {
            this.resultMsg = str;
        }

        public final String getVid() {
            return this.vid;
        }

        public final void setVid(String str) {
            this.vid = str;
        }

        public final String getDiHash() {
            return this.diHash;
        }

        public final void setDiHash(String str) {
            this.diHash = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.resultCode == 0;
        }
    }
}
