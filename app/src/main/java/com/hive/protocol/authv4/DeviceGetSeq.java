package com.hive.protocol.authv4;

import com.hive.base.Android;
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

/* JADX INFO: compiled from: DeviceGetSeq.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/authv4/DeviceGetSeq;", "Lcom/hive/protocol/authv4/AuthV4;", "<init>", "()V", "value", "Lcom/hive/protocol/authv4/DeviceGetSeq$DeviceGetSeqResponse;", "response", "getResponse", "()Lcom/hive/protocol/authv4/DeviceGetSeq$DeviceGetSeqResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "DeviceGetSeqResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceGetSeq extends AuthV4 {
    private DeviceGetSeqResponse response;

    public DeviceGetSeq() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_player_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_device_key);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
    }

    public final DeviceGetSeqResponse getResponse() {
        DeviceGetSeqResponse deviceGetSeqResponse = this.response;
        if (deviceGetSeqResponse != null) {
            return deviceGetSeqResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.authv4.AuthV4, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.AuthV4.INSTANCE.getDeviceGetSeq());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.authv4.AuthV4, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new DeviceGetSeqResponse(coreResponse);
    }

    /* JADX INFO: compiled from: DeviceGetSeq.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/hive/protocol/authv4/DeviceGetSeq$DeviceGetSeqResponse;", "Lcom/hive/protocol/authv4/AuthV4$AuthV4Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "seq", "", "getSeq", "()Ljava/lang/String;", "setSeq", "(Ljava/lang/String;)V", "os", "getOs", "setOs", Android.HW_IDS_DEVICE_MODEL, "getDeviceModel", "setDeviceModel", "deviceName", "getDeviceName", "setDeviceName", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DeviceGetSeqResponse extends AuthV4.AuthV4Response {
        private JSONObject data;
        private String deviceModel;
        private String deviceName;
        private String os;
        private String seq;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceGetSeqResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.seq = "";
            this.os = "";
            this.deviceModel = "";
            this.deviceName = "";
            if (isSuccess()) {
                try {
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("seq");
                        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                        this.seq = strOptString;
                        String strOptString2 = jSONObjectOptJSONObject.optString("os");
                        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                        this.os = strOptString2;
                        String strOptString3 = jSONObjectOptJSONObject.optString("device_model");
                        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                        this.deviceModel = strOptString3;
                        String strOptString4 = jSONObjectOptJSONObject.optString("deivce_name");
                        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                        this.deviceName = strOptString4;
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

        public final String getSeq() {
            return this.seq;
        }

        public final void setSeq(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.seq = str;
        }

        public final String getOs() {
            return this.os;
        }

        public final void setOs(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.os = str;
        }

        public final String getDeviceModel() {
            return this.deviceModel;
        }

        public final void setDeviceModel(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.deviceModel = str;
        }

        public final String getDeviceName() {
            return this.deviceName;
        }

        public final void setDeviceName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.deviceName = str;
        }
    }
}
