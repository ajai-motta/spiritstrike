package com.hive.protocol.authv4;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.authv4.AuthV4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SignInPlayer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/authv4/SignInPlayer;", "Lcom/hive/protocol/authv4/AuthV4;", "<init>", "()V", "value", "Lcom/hive/protocol/authv4/SignInPlayer$SignInPlayerResponse;", "response", "getResponse", "()Lcom/hive/protocol/authv4/SignInPlayer$SignInPlayerResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "SignInPlayerResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignInPlayer extends AuthV4 {
    private SignInPlayerResponse response;

    public SignInPlayer() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_sdk_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os_api_level);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_device_model);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_game_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_agreement);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_player_id);
    }

    public final SignInPlayerResponse getResponse() {
        SignInPlayerResponse signInPlayerResponse = this.response;
        if (signInPlayerResponse != null) {
            return signInPlayerResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.authv4.AuthV4, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.AuthV4.INSTANCE.getSignInPlayer());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.authv4.AuthV4, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new SignInPlayerResponse(coreResponse);
    }

    /* JADX INFO: compiled from: SignInPlayer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/hive/protocol/authv4/SignInPlayer$SignInPlayerResponse;", "Lcom/hive/protocol/authv4/AuthV4$AuthV4Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "data", "Lorg/json/JSONArray;", "getData", "()Lorg/json/JSONArray;", "setData", "(Lorg/json/JSONArray;)V", "ageGateU13", "", "getAgeGateU13", "()Z", "setAgeGateU13", "(Z)V", "authorizationCode", "", "getAuthorizationCode", "()Ljava/lang/String;", "setAuthorizationCode", "(Ljava/lang/String;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SignInPlayerResponse extends AuthV4.AuthV4Response {
        private boolean ageGateU13;
        private String authorizationCode;
        private JSONArray data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignInPlayerResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.authorizationCode = "";
            if (isSuccess()) {
                try {
                    this.data = getContentJSONObject().optJSONArray("data");
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("policy");
                    this.ageGateU13 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optBoolean("age_gate_u13", false) : false;
                    Configuration.INSTANCE.setAgeGateU13(this.ageGateU13);
                    String strOptString = getContentJSONObject().optString("authorization_code");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.authorizationCode = strOptString;
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setResultCode(-1);
                    setResultMsg("[Exception] " + e);
                }
            }
        }

        public final JSONArray getData() {
            return this.data;
        }

        public final void setData(JSONArray jSONArray) {
            this.data = jSONArray;
        }

        public final boolean getAgeGateU13() {
            return this.ageGateU13;
        }

        public final void setAgeGateU13(boolean z) {
            this.ageGateU13 = z;
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
