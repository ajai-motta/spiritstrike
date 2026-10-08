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
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: UpdateDid.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/activeuser/UpdateDid;", "Lcom/hive/protocol/activeuser/ActiveUser;", "<init>", "()V", "value", "Lcom/hive/protocol/activeuser/UpdateDid$UpdateDidResponse;", "response", "getResponse", "()Lcom/hive/protocol/activeuser/UpdateDid$UpdateDidResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "UpdateDidResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateDid extends ActiveUser {
    private UpdateDidResponse response;

    public UpdateDid() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_advertising_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_android_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_api);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appversion);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_app_version_display);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_device);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_did);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_emulator);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_game_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_hacking);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_hive_country);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_mdn);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_os_api_level);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_osversion);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_platform);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_server_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_timezone);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vendor_id);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_zone);
    }

    public final UpdateDidResponse getResponse() {
        UpdateDidResponse updateDidResponse = this.response;
        if (updateDidResponse != null) {
            return updateDidResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.activeuser.ActiveUser, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.ActiveUser.INSTANCE.getUpdateDid());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.activeuser.ActiveUser, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new UpdateDidResponse(coreResponse);
    }

    /* JADX INFO: compiled from: UpdateDid.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/hive/protocol/activeuser/UpdateDid$UpdateDidResponse;", "Lcom/hive/protocol/activeuser/ActiveUser$ActiveUserResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "did", "", "getDid", "()Ljava/lang/String;", "setDid", "(Ljava/lang/String;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UpdateDidResponse extends ActiveUser.ActiveUserResponse {
        private String did;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateDidResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            String str = "";
            this.did = "";
            if (isSuccess()) {
                try {
                    String strOptString = getContentJSONObject().optString("did");
                    if (!(!Intrinsics.areEqual(strOptString, AbstractJsonLexerKt.NULL))) {
                        strOptString = null;
                    }
                    if (strOptString != null) {
                        str = strOptString;
                    }
                    this.did = str;
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setErrno(-1);
                    setError("[JSONException] " + e);
                }
            }
        }

        public final String getDid() {
            return this.did;
        }

        public final void setDid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.did = str;
        }
    }
}
