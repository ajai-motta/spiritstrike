package com.hive.protocol.promotionv2;

import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.promotionv2.PromotionV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: compiled from: Init.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/promotionv2/Init;", "Lcom/hive/protocol/promotionv2/PromotionV2;", "<init>", "()V", "value", "Lcom/hive/protocol/promotionv2/Init$InitResponse;", "response", "getResponse", "()Lcom/hive/protocol/promotionv2/Init$InitResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "InitResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Init extends PromotionV2 {
    private InitResponse response;

    public Init() {
        CommonIdentifierKt.put(getJsonBody(), HiveKeys.KEY_deeplink);
    }

    public final InitResponse getResponse() {
        InitResponse initResponse = this.response;
        if (initResponse != null) {
            return initResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.promotionv2.PromotionV2, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.PromotionV2.INSTANCE.getInit());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.promotionv2.PromotionV2, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new InitResponse(coreResponse);
    }

    /* JADX INFO: compiled from: Init.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000b¨\u0006!"}, d2 = {"Lcom/hive/protocol/promotionv2/Init$InitResponse;", "Lcom/hive/protocol/promotionv2/PromotionV2$PromotionV2Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "useCutout", "", "getUseCutout", "()Z", "setUseCutout", "(Z)V", "webViewInfoJsonArray", "Lorg/json/JSONArray;", "getWebViewInfoJsonArray", "()Lorg/json/JSONArray;", "setWebViewInfoJsonArray", "(Lorg/json/JSONArray;)V", "imageList", "getImageList", "setImageList", "activateCrossPidList", "getActivateCrossPidList", "setActivateCrossPidList", "dontShowAgainPeriod", "getDontShowAgainPeriod", "setDontShowAgainPeriod", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InitResponse extends PromotionV2.PromotionV2Response {
        private JSONArray activateCrossPidList;
        private int count;
        private int dontShowAgainPeriod;
        private JSONArray imageList;
        private boolean useCutout;
        private JSONArray webViewInfoJsonArray;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.count = -1;
            this.useCutout = true;
            this.dontShowAgainPeriod = -1;
            if (isSuccess()) {
                try {
                    this.count = getContentJSONObject().getInt("count");
                    this.useCutout = getContentJSONObject().optBoolean("use_cutout");
                    this.webViewInfoJsonArray = getContentJSONObject().optJSONArray("webview");
                    this.imageList = getContentJSONObject().optJSONArray("image_list");
                    this.activateCrossPidList = getContentJSONObject().optJSONArray("activate_cross_pid_list");
                    this.dontShowAgainPeriod = getContentJSONObject().optInt("dont_show_again_period", -1);
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setResultCode(-1);
                    setResultMessage("[Exception] " + e);
                }
            }
        }

        public final int getCount() {
            return this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final boolean getUseCutout() {
            return this.useCutout;
        }

        public final void setUseCutout(boolean z) {
            this.useCutout = z;
        }

        public final JSONArray getWebViewInfoJsonArray() {
            return this.webViewInfoJsonArray;
        }

        public final void setWebViewInfoJsonArray(JSONArray jSONArray) {
            this.webViewInfoJsonArray = jSONArray;
        }

        public final JSONArray getImageList() {
            return this.imageList;
        }

        public final void setImageList(JSONArray jSONArray) {
            this.imageList = jSONArray;
        }

        public final JSONArray getActivateCrossPidList() {
            return this.activateCrossPidList;
        }

        public final void setActivateCrossPidList(JSONArray jSONArray) {
            this.activateCrossPidList = jSONArray;
        }

        public final int getDontShowAgainPeriod() {
            return this.dontShowAgainPeriod;
        }

        public final void setDontShowAgainPeriod(int i) {
            this.dontShowAgainPeriod = i;
        }
    }
}
