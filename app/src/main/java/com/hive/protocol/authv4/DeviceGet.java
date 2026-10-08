package com.hive.protocol.authv4;

import androidx.autofill.HintConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.hive.core.CommonIdentifierKt;
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

/* JADX INFO: compiled from: DeviceGet.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/authv4/DeviceGet;", "Lcom/hive/protocol/authv4/AuthV4;", "<init>", "()V", "value", "Lcom/hive/protocol/authv4/DeviceGet$DeviceGetResponse;", "response", "getResponse", "()Lcom/hive/protocol/authv4/DeviceGet$DeviceGetResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "DeviceGetResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceGet extends AuthV4 {
    private DeviceGetResponse response;

    public DeviceGet() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_player_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
    }

    public final DeviceGetResponse getResponse() {
        DeviceGetResponse deviceGetResponse = this.response;
        if (deviceGetResponse != null) {
            return deviceGetResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.authv4.AuthV4, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.AuthV4.INSTANCE.getDeviceGet());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.authv4.AuthV4, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new DeviceGetResponse(coreResponse);
    }

    /* JADX INFO: compiled from: DeviceGet.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/hive/protocol/authv4/DeviceGet$DeviceGetResponse;", "Lcom/hive/protocol/authv4/AuthV4$AuthV4Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "playerId", "", "getPlayerId", "()J", "setPlayerId", "(J)V", "phoneCode", "", "getPhoneCode", "()Ljava/lang/String;", "setPhoneCode", "(Ljava/lang/String;)V", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "getPhoneNumber", "setPhoneNumber", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Lorg/json/JSONArray;", "getDevice", "()Lorg/json/JSONArray;", "setDevice", "(Lorg/json/JSONArray;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DeviceGetResponse extends AuthV4.AuthV4Response {
        private JSONObject data;
        private JSONArray device;
        private String phoneCode;
        private String phoneNumber;
        private long playerId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceGetResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.phoneCode = "";
            this.phoneNumber = "";
            if (isSuccess()) {
                try {
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        this.playerId = jSONObjectOptJSONObject.optLong("player_id");
                        String strOptString = jSONObjectOptJSONObject.optString("phone_code");
                        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                        this.phoneCode = strOptString;
                        String strOptString2 = jSONObjectOptJSONObject.optString("phone_number");
                        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                        this.phoneNumber = strOptString2;
                        this.device = jSONObjectOptJSONObject.optJSONArray(DeviceRequestsHelper.DEVICE_INFO_DEVICE);
                    } else {
                        jSONObjectOptJSONObject = null;
                    }
                    this.data = jSONObjectOptJSONObject;
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

        public final long getPlayerId() {
            return this.playerId;
        }

        public final void setPlayerId(long j) {
            this.playerId = j;
        }

        public final String getPhoneCode() {
            return this.phoneCode;
        }

        public final void setPhoneCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.phoneCode = str;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final void setPhoneNumber(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.phoneNumber = str;
        }

        public final JSONArray getDevice() {
            return this.device;
        }

        public final void setDevice(JSONArray jSONArray) {
            this.device = jSONArray;
        }
    }
}
