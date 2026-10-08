package com.hive.protocol.socialapi;

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

/* JADX INFO: compiled from: AcaGetAuthToken.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/socialapi/AcaGetAuthToken;", "Lcom/hive/protocol/socialapi/SocialApi;", "<init>", "()V", "value", "Lcom/hive/protocol/socialapi/AcaGetAuthToken$AcaGetAuthTokenResponse;", "response", "getResponse", "()Lcom/hive/protocol/socialapi/AcaGetAuthToken$AcaGetAuthTokenResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "AcaGetAuthTokenResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AcaGetAuthToken extends SocialApi {
    private AcaGetAuthTokenResponse response;

    public final AcaGetAuthTokenResponse getResponse() {
        AcaGetAuthTokenResponse acaGetAuthTokenResponse = this.response;
        if (acaGetAuthTokenResponse != null) {
            return acaGetAuthTokenResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.socialapi.SocialApi, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.SocialApi.INSTANCE.getAcaGetAuthToken());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.socialapi.SocialApi, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new AcaGetAuthTokenResponse(coreResponse);
    }

    /* JADX INFO: compiled from: AcaGetAuthToken.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/hive/protocol/socialapi/AcaGetAuthToken$AcaGetAuthTokenResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "resCode", "", "getResCode", "()I", "setResCode", "(I)V", "resMsg", "", "getResMsg", "()Ljava/lang/String;", "setResMsg", "(Ljava/lang/String;)V", "accessToken", "getAccessToken", "setAccessToken", "refreshToken", "getRefreshToken", "setRefreshToken", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AcaGetAuthTokenResponse extends ProtocolResponse {
        private String accessToken;
        private String refreshToken;
        private int resCode;
        private String resMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AcaGetAuthTokenResponse(Response coreResponse) {
            Object objM7415constructorimpl;
            JSONObject jSONObjectOptJSONObject;
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.resCode = -1;
            this.resMsg = "";
            this.accessToken = "";
            this.refreshToken = "";
            if (coreResponse.isSuccess()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    this.resCode = getContentJSONObject().getInt("res_code");
                    String strOptString = getContentJSONObject().optString("res_msg");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.resMsg = strOptString;
                    if (isSuccess() && (jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("res_data")) != null) {
                        String string = jSONObjectOptJSONObject.getString("access_token");
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        this.accessToken = string;
                        String string2 = jSONObjectOptJSONObject.getString("refresh_token");
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        this.refreshToken = string2;
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

        public final String getAccessToken() {
            return this.accessToken;
        }

        public final void setAccessToken(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.accessToken = str;
        }

        public final String getRefreshToken() {
            return this.refreshToken;
        }

        public final void setRefreshToken(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.refreshToken = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.resCode == 200;
        }
    }
}
