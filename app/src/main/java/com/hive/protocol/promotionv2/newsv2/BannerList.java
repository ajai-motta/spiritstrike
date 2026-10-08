package com.hive.protocol.promotionv2.newsv2;

import androidx.core.provider.FontsContractCompat;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.ProtocolResponse;
import com.hive.protocol.UrlManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;

/* JADX INFO: compiled from: BannerList.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/promotionv2/newsv2/BannerList;", "Lcom/hive/protocol/ProtocolRequest;", "<init>", "()V", "value", "Lcom/hive/protocol/promotionv2/newsv2/BannerList$BannerListResponse;", "response", "getResponse", "()Lcom/hive/protocol/promotionv2/newsv2/BannerList$BannerListResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "BannerListResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BannerList extends ProtocolRequest {
    private BannerListResponse response;

    public final BannerListResponse getResponse() {
        BannerListResponse bannerListResponse = this.response;
        if (bannerListResponse != null) {
            return bannerListResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.PromotionV2.INSTANCE.getBannerList());
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
        this.response = new BannerListResponse(coreResponse);
    }

    /* JADX INFO: compiled from: BannerList.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/hive/protocol/promotionv2/newsv2/BannerList$BannerListResponse;", "Lcom/hive/protocol/ProtocolResponse;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "resultCode", "getResultCode", "setResultCode", "resultMessage", "", "getResultMessage", "()Ljava/lang/String;", "setResultMessage", "(Ljava/lang/String;)V", "bannerList", "Lorg/json/JSONArray;", "getBannerList", "()Lorg/json/JSONArray;", "setBannerList", "(Lorg/json/JSONArray;)V", "isSuccess", "", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BannerListResponse extends ProtocolResponse {
        private JSONArray bannerList;
        private int count;
        private int resultCode;
        private String resultMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerListResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.count = -1;
            this.resultCode = -1;
            this.resultMessage = "";
            try {
                if (coreResponse.isSuccess()) {
                    this.bannerList = getContentJSONObject().getJSONArray(ReportUtil.INVENTORY_TYPE_BANNER);
                    this.count = getContentJSONObject().getInt("count");
                    this.resultCode = getContentJSONObject().getInt(FontsContractCompat.Columns.RESULT_CODE);
                    String strOptString = getContentJSONObject().optString("result_message");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.resultMessage = strOptString;
                }
            } catch (Exception e) {
                Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                this.bannerList = null;
                this.count = -1;
                this.resultCode = -1;
                this.resultMessage = "[Exception] " + e;
            }
        }

        public final int getCount() {
            return this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        public final void setResultCode(int i) {
            this.resultCode = i;
        }

        public final String getResultMessage() {
            return this.resultMessage;
        }

        public final void setResultMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.resultMessage = str;
        }

        public final JSONArray getBannerList() {
            return this.bannerList;
        }

        public final void setBannerList(JSONArray jSONArray) {
            this.bannerList = jSONArray;
        }

        @Override // com.hive.core.Response
        public boolean isSuccess() {
            return this.resultCode == 200;
        }
    }
}
