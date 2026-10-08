package com.hive.protocol.socialapi;

import com.facebook.internal.NativeProtocol;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.ProtocolResponse;
import com.hive.protocol.UrlManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: AcaDeleteCookies.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/socialapi/AcaDeleteCookies;", "Lcom/hive/protocol/socialapi/SocialApi;", "<init>", "()V", "value", "Lcom/hive/protocol/socialapi/AcaDeleteCookies$AcaDeleteCookiesResponse;", "response", "getResponse", "()Lcom/hive/protocol/socialapi/AcaDeleteCookies$AcaDeleteCookiesResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "AcaDeleteCookiesResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AcaDeleteCookies extends SocialApi {
    private AcaDeleteCookiesResponse response;

    public final AcaDeleteCookiesResponse getResponse() {
        AcaDeleteCookiesResponse acaDeleteCookiesResponse = this.response;
        if (acaDeleteCookiesResponse != null) {
            return acaDeleteCookiesResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.socialapi.SocialApi, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.SocialApi.INSTANCE.getAcaDeleteCookies());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.socialapi.SocialApi, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new AcaDeleteCookiesResponse(coreResponse);
    }

    /* JADX INFO: compiled from: AcaDeleteCookies.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u001bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/hive/protocol/socialapi/AcaDeleteCookies$AcaDeleteCookiesResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "resCode", "", "getResCode", "()I", "setResCode", "(I)V", "resMsg", "", "getResMsg", "()Ljava/lang/String;", "setResMsg", "(Ljava/lang/String;)V", "resDate", "getResDate", "setResDate", "resApi", "getResApi", "setResApi", "isSuccess", "", "getPeppermintResult", "Lorg/json/JSONObject;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AcaDeleteCookiesResponse extends ProtocolResponse {
        private String resApi;
        private int resCode;
        private String resDate;
        private String resMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AcaDeleteCookiesResponse(Response coreResponse) {
            Object objM7415constructorimpl;
            JSONObject jSONObjectOptJSONObject;
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.resCode = -1;
            this.resMsg = "";
            this.resDate = "";
            this.resApi = "";
            if (coreResponse.isSuccess()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    AcaDeleteCookiesResponse acaDeleteCookiesResponse = this;
                    this.resCode = getContentJSONObject().getInt("res_code");
                    String strOptString = getContentJSONObject().optString("res_msg");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.resMsg = strOptString;
                    if (isSuccess() && (jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("date")) != null) {
                        String strOptString2 = jSONObjectOptJSONObject.optString("date", "");
                        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                        this.resDate = strOptString2;
                        String strOptString3 = jSONObjectOptJSONObject.optString("req_api", "");
                        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                        this.resApi = strOptString3;
                    }
                    objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl != null) {
                    Logger.INSTANCE.protocolLog(thM7418exceptionOrNullimpl.toString(), Logger.LogType.Warning);
                    this.resCode = -1;
                    this.resMsg = "[Exception] " + thM7418exceptionOrNullimpl;
                }
            }
        }

        public final int getResCode() {
            return this.resCode;
        }

        public final void setResCode(int i) {
            this.resCode = i;
        }

        public final String getResMsg() {
            return this.resMsg;
        }

        public final void setResMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.resMsg = str;
        }

        public final String getResDate() {
            return this.resDate;
        }

        public final void setResDate(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.resDate = str;
        }

        public final String getResApi() {
            return this.resApi;
        }

        public final void setResApi(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.resApi = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.resCode == 200;
        }

        public final JSONObject getPeppermintResult() {
            Object objM7415constructorimpl;
            JSONObject contentJSONObject = getContentJSONObject();
            try {
                Result.Companion companion = Result.INSTANCE;
                AcaDeleteCookiesResponse acaDeleteCookiesResponse = this;
                if (isSuccess()) {
                    contentJSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                } else {
                    contentJSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, this.resCode);
                }
                contentJSONObject.put("error_msg", this.resMsg);
                objM7415constructorimpl = Result.m7415constructorimpl(contentJSONObject.put("type", "logout"));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                Logger.INSTANCE.protocolLog(thM7418exceptionOrNullimpl.toString(), Logger.LogType.Warning);
            }
            return contentJSONObject;
        }
    }
}
