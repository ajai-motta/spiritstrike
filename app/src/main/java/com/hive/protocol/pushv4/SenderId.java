package com.hive.protocol.pushv4;

import com.google.ads.mediation.pangle.PangleConstants;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.pushv4.PushV4;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: compiled from: SenderId.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/pushv4/SenderId;", "Lcom/hive/protocol/pushv4/PushV4;", "<init>", "()V", "value", "Lcom/hive/protocol/pushv4/SenderId$SenderIdResponse;", "response", "getResponse", "()Lcom/hive/protocol/pushv4/SenderId$SenderIdResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "SenderIdResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SenderId extends PushV4 {
    private SenderIdResponse response;

    public SenderId() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
    }

    public final SenderIdResponse getResponse() {
        SenderIdResponse senderIdResponse = this.response;
        if (senderIdResponse != null) {
            return senderIdResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.pushv4.PushV4, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.PushV4.INSTANCE.getSenderId());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.pushv4.PushV4, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new SenderIdResponse(coreResponse);
    }

    /* JADX INFO: compiled from: SenderId.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/hive/protocol/pushv4/SenderId$SenderIdResponse;", "Lcom/hive/protocol/pushv4/PushV4$PushV4Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", PangleConstants.APP_ID, "", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "senderIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSenderIds", "()Ljava/util/ArrayList;", "setSenderIds", "(Ljava/util/ArrayList;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SenderIdResponse extends PushV4.PushV4Response {
        private String appid;
        private ArrayList<String> senderIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SenderIdResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.appid = "";
            this.senderIds = new ArrayList<>();
            if (isSuccess()) {
                try {
                    String strOptString = getContentJSONObject().optString(PangleConstants.APP_ID);
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.appid = strOptString;
                    JSONArray jSONArrayOptJSONArray = getContentJSONObject().optJSONArray("senderIds");
                    if (jSONArrayOptJSONArray != null) {
                        int length = jSONArrayOptJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String strOptString2 = jSONArrayOptJSONArray.optString(i);
                            Intrinsics.checkNotNull(strOptString2);
                            if (!StringsKt.isBlank(strOptString2)) {
                                this.senderIds.add(strOptString2);
                            }
                        }
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setReason("[Exception] " + e);
                }
            }
        }

        public final String getAppid() {
            return this.appid;
        }

        public final void setAppid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appid = str;
        }

        public final ArrayList<String> getSenderIds() {
            return this.senderIds;
        }

        public final void setSenderIds(ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.senderIds = arrayList;
        }
    }
}
