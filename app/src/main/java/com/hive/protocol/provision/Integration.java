package com.hive.protocol.provision;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.provision.Provision;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Integration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/provision/Integration;", "Lcom/hive/protocol/provision/Provision;", "<init>", "()V", "value", "Lcom/hive/protocol/provision/Integration$IntegrationResponse;", "response", "getResponse", "()Lcom/hive/protocol/provision/Integration$IntegrationResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "IntegrationResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Integration extends Provision {
    private IntegrationResponse response;

    public Integration() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_app_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_app_version_display);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_device_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_hive_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_game_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_sdk_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os_api_level);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_device_model);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_advertising_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_android_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_mdn);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_timezone_offset);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_agreement);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_download);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_hive_certification_key);
    }

    public final IntegrationResponse getResponse() {
        IntegrationResponse integrationResponse = this.response;
        if (integrationResponse != null) {
            return integrationResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.provision.Provision, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.Provision.INSTANCE.getIntegration());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.provision.Provision, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new IntegrationResponse(coreResponse);
    }

    /* JADX INFO: compiled from: Integration.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/hive/protocol/provision/Integration$IntegrationResponse;", "Lcom/hive/protocol/provision/Provision$ProvisionResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "dataJSONObject", "Lorg/json/JSONObject;", "getDataJSONObject", "()Lorg/json/JSONObject;", "setDataJSONObject", "(Lorg/json/JSONObject;)V", "did", "", "getDid", "()Ljava/lang/String;", "setDid", "(Ljava/lang/String;)V", "maintenanceInfoJSONArray", "Lorg/json/JSONArray;", "getMaintenanceInfoJSONArray", "()Lorg/json/JSONArray;", "setMaintenanceInfoJSONArray", "(Lorg/json/JSONArray;)V", "mirrorDomainJSONObject", "getMirrorDomainJSONObject", "setMirrorDomainJSONObject", "setData", "", "data", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IntegrationResponse extends Provision.ProvisionResponse {
        private JSONObject dataJSONObject;
        private String did;
        private JSONArray maintenanceInfoJSONArray;
        private JSONObject mirrorDomainJSONObject;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntegrationResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.did = "";
            if (isSuccess()) {
                try {
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        setData(jSONObjectOptJSONObject);
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setResultCode(-1);
                    setResultMsg("[Exception] " + e);
                }
            }
        }

        public final JSONObject getDataJSONObject() {
            return this.dataJSONObject;
        }

        public final void setDataJSONObject(JSONObject jSONObject) {
            this.dataJSONObject = jSONObject;
        }

        public final String getDid() {
            return this.did;
        }

        public final void setDid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.did = str;
        }

        public final JSONArray getMaintenanceInfoJSONArray() {
            return this.maintenanceInfoJSONArray;
        }

        public final void setMaintenanceInfoJSONArray(JSONArray jSONArray) {
            this.maintenanceInfoJSONArray = jSONArray;
        }

        public final JSONObject getMirrorDomainJSONObject() {
            return this.mirrorDomainJSONObject;
        }

        public final void setMirrorDomainJSONObject(JSONObject jSONObject) {
            this.mirrorDomainJSONObject = jSONObject;
        }

        public final void setData(JSONObject data) throws Exception {
            Intrinsics.checkNotNullParameter(data, "data");
            this.dataJSONObject = data;
            String strOptString = data.optString("did");
            if (!(!Intrinsics.areEqual(strOptString, AbstractJsonLexerKt.NULL))) {
                strOptString = null;
            }
            if (strOptString == null) {
                strOptString = "";
            }
            this.did = strOptString;
            this.maintenanceInfoJSONArray = data.optJSONArray("maintenance");
            this.mirrorDomainJSONObject = data.optJSONObject("mirror");
        }
    }
}
