package com.hive.protocol.socialapi;

import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.socialapi.SocialApi;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: GuestKey.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/socialapi/GuestKey;", "Lcom/hive/protocol/socialapi/SocialApi;", "<init>", "()V", "value", "Lcom/hive/protocol/socialapi/GuestKey$GuestKeyResponse;", "response", "getResponse", "()Lcom/hive/protocol/socialapi/GuestKey$GuestKeyResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "GuestKeyResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GuestKey extends SocialApi {
    private GuestKeyResponse response;

    public final GuestKeyResponse getResponse() {
        GuestKeyResponse guestKeyResponse = this.response;
        if (guestKeyResponse != null) {
            return guestKeyResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.socialapi.SocialApi, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.SocialApi.INSTANCE.getGuestKey());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.socialapi.SocialApi, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new GuestKeyResponse(coreResponse);
    }

    /* JADX INFO: compiled from: GuestKey.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/hive/protocol/socialapi/GuestKey$GuestKeyResponse;", "Lcom/hive/protocol/socialapi/SocialApi$SocialApiResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "jsonResponseData", "Lorg/json/JSONObject;", "getJsonResponseData", "()Lorg/json/JSONObject;", "setJsonResponseData", "(Lorg/json/JSONObject;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GuestKeyResponse extends SocialApi.SocialApiResponse {
        private JSONObject jsonResponseData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuestKeyResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.jsonResponseData = new JSONObject();
            if (getContentJSONObject().has("public_key") && getContentJSONObject().has(InAppPurchaseMetaData.KEY_SIGNATURE)) {
                try {
                    JSONObject contentJSONObject = getContentJSONObject();
                    this.jsonResponseData = contentJSONObject;
                    if (contentJSONObject != null) {
                        Boolean.valueOf(contentJSONObject.has("type"));
                    }
                    JSONObject jSONObject = this.jsonResponseData;
                    if (jSONObject != null) {
                        jSONObject.remove("type");
                    }
                    JSONObject jSONObject2 = this.jsonResponseData;
                    if (jSONObject2 != null) {
                        jSONObject2.put("type", "guest/create");
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setErrorCode(-1);
                    setErrorMsg("[Exception] " + e);
                }
            }
        }

        public final JSONObject getJsonResponseData() {
            return this.jsonResponseData;
        }

        public final void setJsonResponseData(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
            this.jsonResponseData = jSONObject;
        }
    }
}
