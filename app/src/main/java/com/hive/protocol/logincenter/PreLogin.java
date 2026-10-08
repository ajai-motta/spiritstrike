package com.hive.protocol.logincenter;

import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.logincenter.LoginCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreLogin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/logincenter/PreLogin;", "Lcom/hive/protocol/logincenter/LoginCenter;", "<init>", "()V", "value", "Lcom/hive/protocol/logincenter/PreLogin$PreLoginResponse;", "response", "getResponse", "()Lcom/hive/protocol/logincenter/PreLogin$PreLoginResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "PreLoginResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreLogin extends LoginCenter {
    private PreLoginResponse response;

    public final PreLoginResponse getResponse() {
        PreLoginResponse preLoginResponse = this.response;
        if (preLoginResponse != null) {
            return preLoginResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.logincenter.LoginCenter, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.LoginCenter.INSTANCE.getPreLogin());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.logincenter.LoginCenter, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new PreLoginResponse(coreResponse);
    }

    /* JADX INFO: compiled from: PreLogin.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/logincenter/PreLogin$PreLoginResponse;", "Lcom/hive/protocol/logincenter/LoginCenter$LoginCenterResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "vid", "", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "platform", "getPlatform", "setPlatform", "uid", "getUid", "setUid", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PreLoginResponse extends LoginCenter.LoginCenterResponse {
        private String platform;
        private String uid;
        private String vid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreLoginResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.vid = "";
            this.platform = "";
            this.uid = "";
            if (isSuccess()) {
                try {
                    String strOptString = getContentJSONObject().optString("vid");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.vid = strOptString;
                    String strOptString2 = getContentJSONObject().optString("platform");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    this.platform = strOptString2;
                    String strOptString3 = getContentJSONObject().optString("uid");
                    Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                    this.uid = strOptString3;
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setErrno(-1);
                    setError("[Exception] " + e);
                }
            }
        }

        public final String getVid() {
            return this.vid;
        }

        public final void setVid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.vid = str;
        }

        public final String getPlatform() {
            return this.platform;
        }

        public final void setPlatform(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.platform = str;
        }

        public final String getUid() {
            return this.uid;
        }

        public final void setUid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }
    }
}
