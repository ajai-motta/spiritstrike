package com.hive.protocol.logincenter;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.logincenter.LoginCenter;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OauthToken.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/logincenter/OauthToken;", "Lcom/hive/protocol/logincenter/LoginCenter;", "<init>", "()V", "value", "Lcom/hive/protocol/logincenter/OauthToken$OauthTokenResponse;", "response", "getResponse", "()Lcom/hive/protocol/logincenter/OauthToken$OauthTokenResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "OauthTokenResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OauthToken extends LoginCenter {
    private OauthTokenResponse response;

    public OauthToken() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_grant_type);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_client_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_authorization_code);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_code_verifier);
    }

    public final OauthTokenResponse getResponse() {
        OauthTokenResponse oauthTokenResponse = this.response;
        if (oauthTokenResponse != null) {
            return oauthTokenResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.logincenter.LoginCenter, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.LoginCenter.INSTANCE.getOauthToken());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.logincenter.LoginCenter, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new OauthTokenResponse(coreResponse);
    }

    /* JADX INFO: compiled from: OauthToken.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/hive/protocol/logincenter/OauthToken$OauthTokenResponse;", "Lcom/hive/protocol/logincenter/LoginCenter$LoginCenterResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "accessToken", "", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "refreshToken", "getRefreshToken", "setRefreshToken", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OauthTokenResponse extends LoginCenter.LoginCenterResponse {
        private String accessToken;
        private String refreshToken;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OauthTokenResponse(Response coreResponse) {
            Object objM7415constructorimpl;
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.accessToken = "";
            this.refreshToken = "";
            if (isSuccess()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    String strOptString = getContentJSONObject().optString("access_token");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.accessToken = strOptString;
                    String strOptString2 = getContentJSONObject().optString("refresh_token");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    this.refreshToken = strOptString2;
                    objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl != null) {
                    Logger.INSTANCE.protocolLog(thM7418exceptionOrNullimpl.toString(), Logger.LogType.Warning);
                    setErrno(-1);
                    setError("[Exception] " + thM7418exceptionOrNullimpl);
                }
            }
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
    }
}
