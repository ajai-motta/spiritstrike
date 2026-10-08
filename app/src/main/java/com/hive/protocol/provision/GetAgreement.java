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
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: GetAgreement.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/provision/GetAgreement;", "Lcom/hive/protocol/provision/Provision;", "<init>", "()V", "value", "Lcom/hive/protocol/provision/GetAgreement$GetAgreementResponse;", "response", "getResponse", "()Lcom/hive/protocol/provision/GetAgreement$GetAgreementResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "GetAgreementResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAgreement extends Provision {
    private GetAgreementResponse response;

    public GetAgreement() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_is_exist_mdn);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_mdn);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_agreement);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_hive_certification_key);
    }

    public final GetAgreementResponse getResponse() {
        GetAgreementResponse getAgreementResponse = this.response;
        if (getAgreementResponse != null) {
            return getAgreementResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.provision.Provision, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.Provision.INSTANCE.getGetAgreement());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.provision.Provision, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new GetAgreementResponse(coreResponse);
    }

    /* JADX INFO: compiled from: GetAgreement.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/hive/protocol/provision/GetAgreement$GetAgreementResponse;", "Lcom/hive/protocol/provision/Provision$ProvisionResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "hiveCountry", "", "getHiveCountry", "()Ljava/lang/String;", "setHiveCountry", "(Ljava/lang/String;)V", "reviewUrl", "getReviewUrl", "setReviewUrl", "agreementJsonArray", "Lorg/json/JSONArray;", "getAgreementJsonArray", "()Lorg/json/JSONArray;", "setAgreementJsonArray", "(Lorg/json/JSONArray;)V", "maintenanceInfoJsonArray", "getMaintenanceInfoJsonArray", "setMaintenanceInfoJsonArray", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class GetAgreementResponse extends Provision.ProvisionResponse {
        private JSONArray agreementJsonArray;
        private String hiveCountry;
        private JSONArray maintenanceInfoJsonArray;
        private String reviewUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAgreementResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.hiveCountry = "";
            this.reviewUrl = "";
            if (isSuccess()) {
                try {
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("hive_country");
                        Intrinsics.checkNotNull(strOptString);
                        this.hiveCountry = strOptString;
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("agreement");
                        if (jSONArrayOptJSONArray != null) {
                            this.agreementJsonArray = jSONArrayOptJSONArray;
                            int length = jSONArrayOptJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                                if (jSONObjectOptJSONObject2 != null) {
                                    String strOptString2 = jSONObjectOptJSONObject2.optString("type");
                                    String strOptString3 = jSONObjectOptJSONObject2.optString("review_url");
                                    if (Intrinsics.areEqual(strOptString2, "terms")) {
                                        Intrinsics.checkNotNull(strOptString3);
                                        if (!StringsKt.isBlank(strOptString3)) {
                                            this.reviewUrl = strOptString3;
                                        }
                                    }
                                }
                            }
                        }
                        this.maintenanceInfoJsonArray = jSONObjectOptJSONObject.optJSONArray("maintenance");
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setResultCode(-1);
                    setResultMsg("[Exception] " + e);
                }
            }
        }

        public final String getHiveCountry() {
            return this.hiveCountry;
        }

        public final void setHiveCountry(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.hiveCountry = str;
        }

        public final String getReviewUrl() {
            return this.reviewUrl;
        }

        public final void setReviewUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.reviewUrl = str;
        }

        public final JSONArray getAgreementJsonArray() {
            return this.agreementJsonArray;
        }

        public final void setAgreementJsonArray(JSONArray jSONArray) {
            this.agreementJsonArray = jSONArray;
        }

        public final JSONArray getMaintenanceInfoJsonArray() {
            return this.maintenanceInfoJsonArray;
        }

        public final void setMaintenanceInfoJsonArray(JSONArray jSONArray) {
            this.maintenanceInfoJsonArray = jSONArray;
        }
    }
}
