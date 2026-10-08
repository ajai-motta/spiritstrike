package com.hive.protocol.authv4;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.authv4.AuthV4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: AuthIdp.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/authv4/AuthIdp;", "Lcom/hive/protocol/authv4/AuthV4;", "<init>", "()V", "value", "Lcom/hive/protocol/authv4/AuthIdp$IdpResponse;", "response", "getResponse", "()Lcom/hive/protocol/authv4/AuthIdp$IdpResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "IdpResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthIdp extends AuthV4 {
    private IdpResponse response;

    public AuthIdp() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_sdk_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os_api_level);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_device_model);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_game_language);
    }

    public final IdpResponse getResponse() {
        IdpResponse idpResponse = this.response;
        if (idpResponse != null) {
            return idpResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.authv4.AuthV4, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.AuthCP.INSTANCE.getAuthIdp());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.authv4.AuthV4, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new IdpResponse(coreResponse);
    }

    /* JADX INFO: compiled from: AuthIdp.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/hive/protocol/authv4/AuthIdp$IdpResponse;", "Lcom/hive/protocol/authv4/AuthV4$AuthV4Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IdpResponse extends AuthV4.AuthV4Response {
        private JSONObject data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IdpResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            if (isSuccess()) {
                try {
                    this.data = getContentJSONObject().optJSONObject("data");
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setResultCode(-1);
                    setResultMsg("[Exception] " + e);
                }
            }
        }

        public final JSONObject getData() {
            return this.data;
        }

        public final void setData(JSONObject jSONObject) {
            this.data = jSONObject;
        }
    }
}
