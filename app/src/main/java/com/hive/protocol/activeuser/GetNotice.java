package com.hive.protocol.activeuser;

import com.facebook.internal.NativeProtocol;
import com.hive.core.CommonIdentifierKt;
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

/* JADX INFO: compiled from: GetNotice.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/activeuser/GetNotice;", "Lcom/hive/protocol/activeuser/ActiveUser;", "<init>", "()V", "value", "Lcom/hive/protocol/activeuser/GetNotice$GetNoticeResponse;", "response", "getResponse", "()Lcom/hive/protocol/activeuser/GetNotice$GetNoticeResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "GetNoticeResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetNotice extends ActiveUser {
    private GetNoticeResponse response;

    public GetNotice() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_agreement_sms);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_agreement_version);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_api);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appversion);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_app_version_display);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_game_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_hive_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_mdn);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_platform);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_server_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_timezone);
    }

    public final GetNoticeResponse getResponse() {
        GetNoticeResponse getNoticeResponse = this.response;
        if (getNoticeResponse != null) {
            return getNoticeResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.activeuser.ActiveUser, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.ActiveUser.INSTANCE.getGetNotice());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.activeuser.ActiveUser, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new GetNoticeResponse(coreResponse);
    }

    /* JADX INFO: compiled from: GetNotice.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010!\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/hive/protocol/activeuser/GetNotice$GetNoticeResponse;", "Lcom/hive/protocol/activeuser/ActiveUser$ActiveUserResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "notice_show", "", "getNotice_show", "()I", "setNotice_show", "(I)V", "notice_type", "getNotice_type", "setNotice_type", "notice_title", "", "getNotice_title", "()Ljava/lang/String;", "setNotice_title", "(Ljava/lang/String;)V", "notice_message", "getNotice_message", "setNotice_message", "notice_button", "getNotice_button", "setNotice_button", "notice_action", "getNotice_action", "setNotice_action", "notice_url", "getNotice_url", "setNotice_url", "remaining_time", "getRemaining_time", "setRemaining_time", "button_list", "Lorg/json/JSONArray;", "getButton_list", "()Lorg/json/JSONArray;", "setButton_list", "(Lorg/json/JSONArray;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetNoticeResponse extends ActiveUser.ActiveUserResponse {
        private JSONArray button_list;
        private int notice_action;
        private String notice_button;
        private String notice_message;
        private int notice_show;
        private String notice_title;
        private int notice_type;
        private String notice_url;
        private int remaining_time;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetNoticeResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.notice_show = -1;
            this.notice_title = "";
            this.notice_message = "";
            this.notice_button = "";
            this.notice_action = -1;
            this.notice_url = "";
            this.remaining_time = -1;
            if (isSuccess()) {
                try {
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("notice");
                    if (jSONObjectOptJSONObject == null) {
                        this.notice_show = 0;
                    } else {
                        this.notice_show = 1;
                        this.notice_type = jSONObjectOptJSONObject.optInt("type");
                        String strOptString = jSONObjectOptJSONObject.optString("title");
                        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                        this.notice_title = strOptString;
                        String strOptString2 = jSONObjectOptJSONObject.optString("message");
                        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                        this.notice_message = strOptString2;
                        String strOptString3 = jSONObjectOptJSONObject.optString("button");
                        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                        this.notice_button = strOptString3;
                        this.notice_action = jSONObjectOptJSONObject.optInt(NativeProtocol.WEB_DIALOG_ACTION);
                        String strOptString4 = jSONObjectOptJSONObject.optString("url");
                        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                        this.notice_url = strOptString4;
                        this.remaining_time = jSONObjectOptJSONObject.optInt("remaining_time");
                        this.button_list = jSONObjectOptJSONObject.optJSONArray("button_list");
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setErrno(-1);
                    setError("[Exception] " + e);
                }
            }
        }

        public final int getNotice_show() {
            return this.notice_show;
        }

        public final void setNotice_show(int i) {
            this.notice_show = i;
        }

        public final int getNotice_type() {
            return this.notice_type;
        }

        public final void setNotice_type(int i) {
            this.notice_type = i;
        }

        public final String getNotice_title() {
            return this.notice_title;
        }

        public final void setNotice_title(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.notice_title = str;
        }

        public final String getNotice_message() {
            return this.notice_message;
        }

        public final void setNotice_message(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.notice_message = str;
        }

        public final String getNotice_button() {
            return this.notice_button;
        }

        public final void setNotice_button(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.notice_button = str;
        }

        public final int getNotice_action() {
            return this.notice_action;
        }

        public final void setNotice_action(int i) {
            this.notice_action = i;
        }

        public final String getNotice_url() {
            return this.notice_url;
        }

        public final void setNotice_url(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.notice_url = str;
        }

        public final int getRemaining_time() {
            return this.remaining_time;
        }

        public final void setRemaining_time(int i) {
            this.remaining_time = i;
        }

        public final JSONArray getButton_list() {
            return this.button_list;
        }

        public final void setButton_list(JSONArray jSONArray) {
            this.button_list = jSONArray;
        }
    }
}
