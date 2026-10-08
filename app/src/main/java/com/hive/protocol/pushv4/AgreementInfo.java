package com.hive.protocol.pushv4;

import com.google.ads.mediation.pangle.PangleConstants;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.pushv4.PushV4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: AgreementInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/pushv4/AgreementInfo;", "Lcom/hive/protocol/pushv4/PushV4;", "<init>", "()V", "value", "Lcom/hive/protocol/pushv4/AgreementInfo$AgreementInfoResponse;", "response", "getResponse", "()Lcom/hive/protocol/pushv4/AgreementInfo$AgreementInfoResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "AgreementInfoResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AgreementInfo extends PushV4 {
    private AgreementInfoResponse response;

    public AgreementInfo() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_identifier);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_app);
    }

    public final AgreementInfoResponse getResponse() {
        AgreementInfoResponse agreementInfoResponse = this.response;
        if (agreementInfoResponse != null) {
            return agreementInfoResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.pushv4.PushV4, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.PushV4.INSTANCE.getAgreementInfo());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.pushv4.PushV4, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new AgreementInfoResponse(coreResponse);
    }

    /* JADX INFO: compiled from: AgreementInfo.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011¨\u0006-"}, d2 = {"Lcom/hive/protocol/pushv4/AgreementInfo$AgreementInfoResponse;", "Lcom/hive/protocol/pushv4/PushV4$PushV4Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "playerId", "", "getPlayerId", "()J", "setPlayerId", "(J)V", "vid", "", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "uid", "getUid", "setUid", "did", "getDid", "setDid", PangleConstants.APP_ID, "getAppid", "setAppid", "agreementNotice", "", "getAgreementNotice", "()I", "setAgreementNotice", "(I)V", "agreementNight", "getAgreementNight", "setAgreementNight", "default", "", "getDefault", "()Z", "setDefault", "(Z)V", "message", "getMessage", "setMessage", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AgreementInfoResponse extends PushV4.PushV4Response {
        private int agreementNight;
        private int agreementNotice;
        private String appid;
        private boolean default;
        private String did;
        private String message;
        private long playerId;
        private String uid;
        private String vid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AgreementInfoResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            String strValueOf = "";
            this.vid = "";
            this.uid = "";
            this.did = "";
            this.appid = "";
            this.message = "";
            if (isSuccess()) {
                try {
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("identifier");
                    if (jSONObjectOptJSONObject != null) {
                        this.playerId = jSONObjectOptJSONObject.optLong("playerId");
                        long jOptLong = jSONObjectOptJSONObject.optLong("vid");
                        this.vid = jOptLong == 0 ? "" : String.valueOf(jOptLong);
                        long jOptLong2 = jSONObjectOptJSONObject.optLong("uid");
                        this.uid = jOptLong2 == 0 ? "" : String.valueOf(jOptLong2);
                        long jOptLong3 = jSONObjectOptJSONObject.optLong("did");
                        if (jOptLong3 != 0) {
                            strValueOf = String.valueOf(jOptLong3);
                        }
                        this.did = strValueOf;
                    }
                    JSONObject jSONObjectOptJSONObject2 = getContentJSONObject().optJSONObject("app");
                    if (jSONObjectOptJSONObject2 != null) {
                        String strOptString = jSONObjectOptJSONObject2.optString(PangleConstants.APP_ID);
                        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                        this.appid = strOptString;
                    }
                    JSONObject jSONObjectOptJSONObject3 = getContentJSONObject().optJSONObject("agreement");
                    if (jSONObjectOptJSONObject3 != null) {
                        this.agreementNotice = jSONObjectOptJSONObject3.optInt("notice");
                        this.agreementNight = jSONObjectOptJSONObject3.optInt("night");
                    }
                    JSONObject jSONObjectOptJSONObject4 = getContentJSONObject().optJSONObject("addition");
                    if (jSONObjectOptJSONObject4 != null) {
                        this.default = jSONObjectOptJSONObject4.optBoolean("default");
                        String strOptString2 = jSONObjectOptJSONObject4.optString("message");
                        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                        this.message = strOptString2;
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setReason("[Exception] " + e);
                }
            }
        }

        public final long getPlayerId() {
            return this.playerId;
        }

        public final void setPlayerId(long j) {
            this.playerId = j;
        }

        public final String getVid() {
            return this.vid;
        }

        public final void setVid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.vid = str;
        }

        public final String getUid() {
            return this.uid;
        }

        public final void setUid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }

        public final String getDid() {
            return this.did;
        }

        public final void setDid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.did = str;
        }

        public final String getAppid() {
            return this.appid;
        }

        public final void setAppid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appid = str;
        }

        public final int getAgreementNotice() {
            return this.agreementNotice;
        }

        public final void setAgreementNotice(int i) {
            this.agreementNotice = i;
        }

        public final int getAgreementNight() {
            return this.agreementNight;
        }

        public final void setAgreementNight(int i) {
            this.agreementNight = i;
        }

        public final boolean getDefault() {
            return this.default;
        }

        public final void setDefault(boolean z) {
            this.default = z;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.message = str;
        }
    }
}
