package com.hive.protocol.activeuser;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.activeuser.ActiveUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: GetWhiteListDomainByActiveUser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/activeuser/GetWhiteListDomainByActiveUser;", "Lcom/hive/protocol/activeuser/ActiveUser;", "<init>", "()V", "value", "Lcom/hive/protocol/activeuser/GetWhiteListDomainByActiveUser$GetWhiteListDomainByActiveUserResponse;", "response", "getResponse", "()Lcom/hive/protocol/activeuser/GetWhiteListDomainByActiveUser$GetWhiteListDomainByActiveUserResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "GetWhiteListDomainByActiveUserResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetWhiteListDomainByActiveUser extends ActiveUser {
    private GetWhiteListDomainByActiveUserResponse response;

    public GetWhiteListDomainByActiveUser() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_api);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_app_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_app_version_display);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_device_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_sdk_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os_api_level);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_timestamp);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_timezone_offset);
    }

    public final GetWhiteListDomainByActiveUserResponse getResponse() {
        GetWhiteListDomainByActiveUserResponse getWhiteListDomainByActiveUserResponse = this.response;
        if (getWhiteListDomainByActiveUserResponse != null) {
            return getWhiteListDomainByActiveUserResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.activeuser.ActiveUser, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.ActiveUser.INSTANCE.getGetWhiteListDomainByActiveUser());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.activeuser.ActiveUser, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new GetWhiteListDomainByActiveUserResponse(coreResponse);
    }

    /* JADX INFO: compiled from: GetWhiteListDomainByActiveUser.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/hive/protocol/activeuser/GetWhiteListDomainByActiveUser$GetWhiteListDomainByActiveUserResponse;", "Lcom/hive/protocol/activeuser/ActiveUser$ActiveUserResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "whiteListJSONArray", "Lorg/json/JSONArray;", "getWhiteListJSONArray", "()Lorg/json/JSONArray;", "setWhiteListJSONArray", "(Lorg/json/JSONArray;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetWhiteListDomainByActiveUserResponse extends ActiveUser.ActiveUserResponse {
        private JSONArray whiteListJSONArray;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetWhiteListDomainByActiveUserResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            if (isSuccess()) {
                try {
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("white_list");
                        if (jSONArrayOptJSONArray != null) {
                            Configuration.INSTANCE.setWhiteListDomains(jSONArrayOptJSONArray.toString());
                        } else {
                            jSONArrayOptJSONArray = null;
                        }
                        this.whiteListJSONArray = jSONArrayOptJSONArray;
                    }
                    setErrno(getContentJSONObject().optInt("error"));
                    String strOptString = getContentJSONObject().optString("error");
                    if (strOptString != null) {
                        setError(strOptString);
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setErrno(-1);
                    setError("[Exception] " + e);
                }
            }
        }

        public final JSONArray getWhiteListJSONArray() {
            return this.whiteListJSONArray;
        }

        public final void setWhiteListJSONArray(JSONArray jSONArray) {
            this.whiteListJSONArray = jSONArray;
        }
    }
}
