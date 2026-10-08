package com.hive.protocol.timezone;

import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.timezone.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: GetCountryCodeByIp.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/timezone/GetCountryCodeByIp;", "Lcom/hive/protocol/timezone/TimeZone;", "<init>", "()V", "value", "Lcom/hive/protocol/timezone/GetCountryCodeByIp$GetCountryCodeByIpResponse;", "response", "getResponse", "()Lcom/hive/protocol/timezone/GetCountryCodeByIp$GetCountryCodeByIpResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "GetCountryCodeByIpResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetCountryCodeByIp extends TimeZone {
    private GetCountryCodeByIpResponse response;

    public final GetCountryCodeByIpResponse getResponse() {
        GetCountryCodeByIpResponse getCountryCodeByIpResponse = this.response;
        if (getCountryCodeByIpResponse != null) {
            return getCountryCodeByIpResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.timezone.TimeZone, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.TimeZone.INSTANCE.getGetCountryCodeByIp());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.timezone.TimeZone, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new GetCountryCodeByIpResponse(coreResponse);
    }

    /* JADX INFO: compiled from: GetCountryCodeByIp.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/hive/protocol/timezone/GetCountryCodeByIp$GetCountryCodeByIpResponse;", "Lcom/hive/protocol/timezone/TimeZone$ProvisionResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "hiveCountry", "", "getHiveCountry", "()Ljava/lang/String;", "setHiveCountry", "(Ljava/lang/String;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetCountryCodeByIpResponse extends TimeZone.ProvisionResponse {
        private String hiveCountry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCountryCodeByIpResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.hiveCountry = "";
            if (isSuccess()) {
                try {
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("timezone");
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("country_code");
                        Intrinsics.checkNotNull(strOptString);
                        this.hiveCountry = strOptString;
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setResultCode(-1);
                    setResultMessge("[Exception] " + e);
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
    }
}
