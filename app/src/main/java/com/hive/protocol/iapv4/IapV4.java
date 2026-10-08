package com.hive.protocol.iapv4;

import com.hive.base.Android;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IapV4.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/protocol/iapv4/IapV4;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "IapV4Response", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IapV4 extends ProtocolRequest {
    @Override // com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
    }

    public IapV4() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_api);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_market_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appversion);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_hive_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_game_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_uid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid_sessionkey);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_uid_sessionkey);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_server_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_device_model);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os_api_level);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_sdk_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid_type);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_api_ver);
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() throws JSONException {
        CommonIdentifierKt.putCI(getJsonBody());
        Request coreRequest = getCoreRequest();
        String string = getJsonBody().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        coreRequest.setBody(bytes);
        return super.toCoreRequest$hive_protocol_release();
    }

    /* JADX INFO: compiled from: IapV4.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010,\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001a\u0010\u001d\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001a\u0010 \u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u001a\u0010#\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010\u0011R\u001a\u0010&\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010\u000bR\u001a\u0010)\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010\u0011¨\u0006-"}, d2 = {"Lcom/hive/protocol/iapv4/IapV4$IapV4Response;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "iapV4Result", "", "getIapV4Result", "()I", "setIapV4Result", "(I)V", "iapV4ResultMsg", "", "getIapV4ResultMsg", "()Ljava/lang/String;", "setIapV4ResultMsg", "(Ljava/lang/String;)V", "isShowDialog", "", "()Z", "setShowDialog", "(Z)V", "title", "getTitle", "setTitle", "message", "getMessage", "setMessage", "email", "getEmail", "setEmail", Android.HW_IDS_MDN, "getMdn", "setMdn", "button", "getButton", "setButton", "buttonAction", "getButtonAction", "setButtonAction", "buttonUrl", "getButtonUrl", "setButtonUrl", "isSuccess", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class IapV4Response extends ProtocolResponse {
        private String button;
        private int buttonAction;
        private String buttonUrl;
        private String email;
        private int iapV4Result;
        private String iapV4ResultMsg;
        private boolean isShowDialog;
        private String mdn;
        private String message;
        private String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IapV4Response(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.iapV4Result = -1;
            this.iapV4ResultMsg = "";
            this.title = "";
            this.message = "";
            this.email = "";
            this.mdn = "";
            this.button = "";
            this.buttonUrl = "";
            try {
                if (coreResponse.isSuccess()) {
                    this.iapV4Result = getContentJSONObject().getInt("result");
                    String strOptString = getContentJSONObject().optString("result_msg");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.iapV4ResultMsg = strOptString;
                    try {
                        JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("notice_msg_info");
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString2 = jSONObjectOptJSONObject.optString("title");
                            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                            this.title = strOptString2;
                            String strOptString3 = jSONObjectOptJSONObject.optString("message");
                            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                            this.message = strOptString3;
                            String strOptString4 = jSONObjectOptJSONObject.optString("email");
                            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                            this.email = strOptString4;
                            String strOptString5 = jSONObjectOptJSONObject.optString("phone_number");
                            Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                            this.mdn = strOptString5;
                            String strOptString6 = jSONObjectOptJSONObject.optString("btn_text");
                            Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                            this.button = strOptString6;
                            this.buttonAction = jSONObjectOptJSONObject.optInt("btn_action", 3);
                            String strOptString7 = jSONObjectOptJSONObject.optString("btn_redirect_url");
                            Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                            this.buttonUrl = strOptString7;
                            this.isShowDialog = true;
                        } else {
                            this.isShowDialog = false;
                        }
                    } catch (Exception e) {
                        Logger.INSTANCE.protocolLog("create Response Popup-data Exception: " + e + ", \noriginal: \n" + getContentJSONObject(), Logger.LogType.Warning);
                        this.isShowDialog = false;
                    }
                }
            } catch (Exception e2) {
                Logger.INSTANCE.protocolLog(e2.toString(), Logger.LogType.Warning);
                this.iapV4Result = -1;
                this.iapV4ResultMsg = "[Exception] " + e2;
            }
        }

        public final int getIapV4Result() {
            return this.iapV4Result;
        }

        public final void setIapV4Result(int i) {
            this.iapV4Result = i;
        }

        public final String getIapV4ResultMsg() {
            return this.iapV4ResultMsg;
        }

        public final void setIapV4ResultMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.iapV4ResultMsg = str;
        }

        /* JADX INFO: renamed from: isShowDialog, reason: from getter */
        public final boolean getIsShowDialog() {
            return this.isShowDialog;
        }

        public final void setShowDialog(boolean z) {
            this.isShowDialog = z;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.message = str;
        }

        public final String getEmail() {
            return this.email;
        }

        public final void setEmail(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.email = str;
        }

        public final String getMdn() {
            return this.mdn;
        }

        public final void setMdn(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mdn = str;
        }

        public final String getButton() {
            return this.button;
        }

        public final void setButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.button = str;
        }

        public final int getButtonAction() {
            return this.buttonAction;
        }

        public final void setButtonAction(int i) {
            this.buttonAction = i;
        }

        public final String getButtonUrl() {
            return this.buttonUrl;
        }

        public final void setButtonUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.buttonUrl = str;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.iapV4Result == 0;
        }
    }
}
