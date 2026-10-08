package com.hive.protocol.promotionv2.newsv2;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import com.hive.protocol.UrlManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Navigation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/promotionv2/newsv2/Navigation;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "value", "Lcom/hive/protocol/promotionv2/newsv2/Navigation$NavigationResponse;", "response", "getResponse", "()Lcom/hive/protocol/promotionv2/newsv2/Navigation$NavigationResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "NavigationResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Navigation extends ProtocolRequest {
    private NavigationResponse response;

    public Navigation() {
        JSONObject jsonBody = getJsonBody();
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_appid);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_game_language);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_language);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_hive_country);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_device_country);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_server_id);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_analytics_id);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_sdk_version);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_app_version);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_app_version_display);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_age_gate_u13);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_hive_theme);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_timezone);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_did);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_vid);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_vid_type);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_player_token);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_uid);
        CommonIdentifierKt.put(jsonBody, HiveKeys.KEY_additionalinfo);
    }

    public final NavigationResponse getResponse() {
        NavigationResponse navigationResponse = this.response;
        if (navigationResponse != null) {
            return navigationResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() throws JSONException {
        CommonIdentifierKt.putCI(getJsonBody());
        getCoreRequest().setUrl(UrlManager.PromotionV2.INSTANCE.getNavigation());
        Request coreRequest = getCoreRequest();
        String string = getJsonBody().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        coreRequest.setBody(bytes);
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new NavigationResponse(coreResponse);
    }

    /* JADX INFO: compiled from: Navigation.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/hive/protocol/promotionv2/newsv2/Navigation$NavigationResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "errors", "Lorg/json/JSONArray;", "getErrors", "()Lorg/json/JSONArray;", "setErrors", "(Lorg/json/JSONArray;)V", "resultObject", "Lorg/json/JSONObject;", "getResultObject", "()Lorg/json/JSONObject;", "setResultObject", "(Lorg/json/JSONObject;)V", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NavigationResponse extends ProtocolResponse {
        private JSONArray errors;
        private JSONObject resultObject;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigationResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            JSONArray jSONArrayOptJSONArray = getContentJSONObject().optJSONArray("errors");
            if (jSONArrayOptJSONArray != null) {
                this.errors = jSONArrayOptJSONArray;
            }
            JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("result");
            if (jSONObjectOptJSONObject != null) {
                this.resultObject = jSONObjectOptJSONObject;
            }
        }

        public final JSONArray getErrors() {
            return this.errors;
        }

        public final void setErrors(JSONArray jSONArray) {
            this.errors = jSONArray;
        }

        public final JSONObject getResultObject() {
            return this.resultObject;
        }

        public final void setResultObject(JSONObject jSONObject) {
            this.resultObject = jSONObject;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            JSONArray jSONArray = this.errors;
            return (jSONArray == null || jSONArray == null || jSONArray.length() != 0) ? false : true;
        }
    }
}
