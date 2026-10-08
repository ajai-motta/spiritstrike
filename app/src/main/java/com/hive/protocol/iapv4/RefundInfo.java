package com.hive.protocol.iapv4;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.iapv4.IapV4;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RefundInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/iapv4/RefundInfo;", "Lcom/hive/protocol/iapv4/IapV4;", "<init>", "()V", "value", "Lcom/hive/protocol/iapv4/RefundInfo$RefundInfoResponse;", "response", "getResponse", "()Lcom/hive/protocol/iapv4/RefundInfo$RefundInfoResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "RefundInfoResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RefundInfo extends IapV4 {
    private RefundInfoResponse response;

    public RefundInfo() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_appid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid_type);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_uid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_vid);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_game_language);
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_language);
    }

    public final RefundInfoResponse getResponse() {
        RefundInfoResponse refundInfoResponse = this.response;
        if (refundInfoResponse != null) {
            return refundInfoResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.iapv4.IapV4, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.IapV4.INSTANCE.getRefundInfo());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.iapv4.IapV4, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new RefundInfoResponse(coreResponse);
    }

    /* JADX INFO: compiled from: RefundInfo.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/hive/protocol/iapv4/RefundInfo$RefundInfoResponse;", "Lcom/hive/protocol/iapv4/IapV4$IapV4Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "guideTitle", "", "getGuideTitle", "()Ljava/lang/String;", "setGuideTitle", "(Ljava/lang/String;)V", "guideContent", "getGuideContent", "setGuideContent", "customerSite", "getCustomerSite", "setCustomerSite", "refundList", "Lorg/json/JSONArray;", "getRefundList", "()Lorg/json/JSONArray;", "setRefundList", "(Lorg/json/JSONArray;)V", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RefundInfoResponse extends IapV4.IapV4Response {
        private String customerSite;
        private String guideContent;
        private String guideTitle;
        private JSONArray refundList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RefundInfoResponse(Response coreResponse) {
            Object objM7415constructorimpl;
            String strOptString;
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            String str = "";
            this.guideTitle = "";
            this.guideContent = "";
            this.customerSite = "";
            if (isSuccess()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    String strOptString2 = getContentJSONObject().optString("guide_title");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    this.guideTitle = strOptString2;
                    String strOptString3 = getContentJSONObject().optString("guide_content");
                    Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                    this.guideContent = strOptString3;
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject("customer_site");
                    if (jSONObjectOptJSONObject != null && (strOptString = jSONObjectOptJSONObject.optString("mobile")) != null) {
                        str = strOptString;
                    }
                    this.customerSite = str;
                    this.refundList = getContentJSONObject().optJSONArray("refund_list");
                    objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl != null) {
                    Logger.INSTANCE.protocolLog(thM7418exceptionOrNullimpl.toString(), Logger.LogType.Warning);
                    setIapV4Result(-1);
                    setIapV4ResultMsg("[Exception] " + thM7418exceptionOrNullimpl);
                }
            }
        }

        public final String getGuideTitle() {
            return this.guideTitle;
        }

        public final void setGuideTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.guideTitle = str;
        }

        public final String getGuideContent() {
            return this.guideContent;
        }

        public final void setGuideContent(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.guideContent = str;
        }

        public final String getCustomerSite() {
            return this.customerSite;
        }

        public final void setCustomerSite(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.customerSite = str;
        }

        public final JSONArray getRefundList() {
            return this.refundList;
        }

        public final void setRefundList(JSONArray jSONArray) {
            this.refundList = jSONArray;
        }
    }
}
