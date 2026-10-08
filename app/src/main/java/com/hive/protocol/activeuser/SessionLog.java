package com.hive.protocol.activeuser;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.activeuser.ActiveUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: SessionLog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/activeuser/SessionLog;", "Lcom/hive/protocol/activeuser/ActiveUser;", "<init>", "()V", "value", "Lcom/hive/protocol/activeuser/SessionLog$SessionLogResponse;", "response", "getResponse", "()Lcom/hive/protocol/activeuser/SessionLog$SessionLogResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "SessionLogResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionLog extends ActiveUser {
    private SessionLogResponse response;

    public SessionLog() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_api);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_game_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_hive_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_server_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_sessions);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_timezone);
    }

    public final SessionLogResponse getResponse() {
        SessionLogResponse sessionLogResponse = this.response;
        if (sessionLogResponse != null) {
            return sessionLogResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.activeuser.ActiveUser, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.ActiveUser.INSTANCE.getSessionLog());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.activeuser.ActiveUser, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new SessionLogResponse(coreResponse);
    }

    /* JADX INFO: compiled from: SessionLog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/hive/protocol/activeuser/SessionLog$SessionLogResponse;", "Lcom/hive/protocol/activeuser/ActiveUser$ActiveUserResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "session_max_num", "", "getSession_max_num", "()I", "setSession_max_num", "(I)V", "session_max_time", "getSession_max_time", "setSession_max_time", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SessionLogResponse extends ActiveUser.ActiveUserResponse {
        private int session_max_num;
        private int session_max_time;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SessionLogResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.session_max_num = 1;
            if (isSuccess()) {
                try {
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("config");
                    if (jSONObjectOptJSONObject != null) {
                        this.session_max_num = jSONObjectOptJSONObject.optInt("session_max_num", 1);
                        this.session_max_time = jSONObjectOptJSONObject.optInt("session_max_time", 0);
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setErrno(-1);
                    setError("[Exception] " + e);
                }
            }
        }

        public final int getSession_max_num() {
            return this.session_max_num;
        }

        public final void setSession_max_num(int i) {
            this.session_max_num = i;
        }

        public final int getSession_max_time() {
            return this.session_max_time;
        }

        public final void setSession_max_time(int i) {
            this.session_max_time = i;
        }
    }
}
