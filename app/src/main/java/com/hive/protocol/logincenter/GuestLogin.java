package com.hive.protocol.logincenter;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.logincenter.LoginCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GuestLogin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/logincenter/GuestLogin;", "Lcom/hive/protocol/logincenter/LoginCenter;", "<init>", "()V", "value", "Lcom/hive/protocol/logincenter/GuestLogin$GuestLoginResponse;", "response", "getResponse", "()Lcom/hive/protocol/logincenter/GuestLogin$GuestLoginResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "GuestLoginResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GuestLogin extends LoginCenter {
    private GuestLoginResponse response;

    public GuestLogin() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_sessionkey);
    }

    public final GuestLoginResponse getResponse() {
        GuestLoginResponse guestLoginResponse = this.response;
        if (guestLoginResponse != null) {
            return guestLoginResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.logincenter.LoginCenter, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.LoginCenter.INSTANCE.getGuestLogin());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.logincenter.LoginCenter, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new GuestLoginResponse(coreResponse);
    }

    /* JADX INFO: compiled from: GuestLogin.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/logincenter/GuestLogin$GuestLoginResponse;", "Lcom/hive/protocol/logincenter/LoginCenter$LoginCenterResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "guestVid", "", "getGuestVid", "()Ljava/lang/String;", "setGuestVid", "(Ljava/lang/String;)V", "guestSessionkey", "getGuestSessionkey", "setGuestSessionkey", "authorizationCode", "getAuthorizationCode", "setAuthorizationCode", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GuestLoginResponse extends LoginCenter.LoginCenterResponse {
        private String authorizationCode;
        private String guestSessionkey;
        private String guestVid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuestLoginResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.guestVid = "";
            this.guestSessionkey = "";
            this.authorizationCode = "";
            try {
                String strOptString = getContentJSONObject().optString("vid");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                this.guestVid = strOptString;
                String strOptString2 = getContentJSONObject().optString("sessionkey");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                this.guestSessionkey = strOptString2;
                String strOptString3 = getContentJSONObject().optString("authorization_code");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                this.authorizationCode = strOptString3;
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                setErrno(-1);
                setError("[Exception] " + e);
            }
        }

        public final String getGuestVid() {
            return this.guestVid;
        }

        public final void setGuestVid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.guestVid = str;
        }

        public final String getGuestSessionkey() {
            return this.guestSessionkey;
        }

        public final void setGuestSessionkey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.guestSessionkey = str;
        }

        public final String getAuthorizationCode() {
            return this.authorizationCode;
        }

        public final void setAuthorizationCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authorizationCode = str;
        }
    }
}
