package com.hive.protocol.adultconfirm;

import androidx.core.provider.FontsContractCompat;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.adultconfirm.AdultConfirm;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdultCheck.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/adultconfirm/AdultCheck;", "Lcom/hive/protocol/adultconfirm/AdultConfirm;", "<init>", "()V", "value", "Lcom/hive/protocol/adultconfirm/AdultCheck$AdultCheckResponse;", "response", "getResponse", "()Lcom/hive/protocol/adultconfirm/AdultCheck$AdultCheckResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "AdultCheckResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdultCheck extends AdultConfirm {
    private AdultCheckResponse response;

    public AdultCheck() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_api);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appversion);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_app_version_display);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_game_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_market_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_uid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_uid_sessionkey);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid_sessionkey);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid_type);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_world);
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
        getCoreRequest().setUrl(UrlManager.AdultConfirm.INSTANCE.getAdultCheck());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.adultconfirm.AdultConfirm, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new AdultCheckResponse(coreResponse);
    }

    /* JADX INFO: compiled from: AdultCheck.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000b¨\u0006!"}, d2 = {"Lcom/hive/protocol/adultconfirm/AdultCheck$AdultCheckResponse;", "Lcom/hive/protocol/adultconfirm/AdultConfirm$AdultConfirmResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "adultCheckResult", "", "getAdultCheckResult", "()Ljava/lang/String;", "setAdultCheckResult", "(Ljava/lang/String;)V", "adultCheckResultCode", "", "getAdultCheckResultCode", "()I", "setAdultCheckResultCode", "(I)V", "adultCheckResultMsg", "getAdultCheckResultMsg", "setAdultCheckResultMsg", "authUrl", "getAuthUrl", "setAuthUrl", InAppPurchaseMetaData.KEY_SIGNATURE, "getSignature", "setSignature", "signatureResultCode", "getSignatureResultCode", "setSignatureResultCode", "isSuccess", "", "isSuccessYN", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AdultCheckResponse extends AdultConfirm.AdultConfirmResponse {
        private String adultCheckResult;
        private int adultCheckResultCode;
        private String adultCheckResultMsg;
        private String authUrl;
        private String signature;
        private String signatureResultCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdultCheckResponse(Response coreResponse) {
            Object objM7415constructorimpl;
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.adultCheckResultCode = -1;
            try {
                Result.Companion companion = Result.INSTANCE;
                AdultCheckResponse adultCheckResponse = this;
                if (coreResponse.isSuccess()) {
                    this.adultCheckResult = getContentJSONObject().optString("result");
                    this.adultCheckResultCode = getContentJSONObject().optInt(FontsContractCompat.Columns.RESULT_CODE, -1);
                    this.adultCheckResultMsg = getContentJSONObject().optString("result_msg");
                    this.authUrl = getContentJSONObject().optString("auth_url");
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
                this.adultCheckResult = null;
                this.adultCheckResultCode = -1;
                this.adultCheckResultMsg = "[Exception] " + thM7418exceptionOrNullimpl;
            }
        }

        public final String getAdultCheckResult() {
            return this.adultCheckResult;
        }

        public final void setAdultCheckResult(String str) {
            this.adultCheckResult = str;
        }

        public final int getAdultCheckResultCode() {
            return this.adultCheckResultCode;
        }

        public final void setAdultCheckResultCode(int i) {
            this.adultCheckResultCode = i;
        }

        public final String getAdultCheckResultMsg() {
            return this.adultCheckResultMsg;
        }

        public final void setAdultCheckResultMsg(String str) {
            this.adultCheckResultMsg = str;
        }

        public final String getAuthUrl() {
            return this.authUrl;
        }

        public final void setAuthUrl(String str) {
            this.authUrl = str;
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
            return this.adultCheckResultCode != -1;
        }

        public final boolean isSuccessYN() {
            String str = this.adultCheckResult;
            if (str == null) {
                return false;
            }
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = str.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (!Intrinsics.areEqual("Y", upperCase)) {
                Locale US2 = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US2, "US");
                String upperCase2 = str.toUpperCase(US2);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                if (!Intrinsics.areEqual("N", upperCase2)) {
                    return false;
                }
            }
            return true;
        }
    }
}
