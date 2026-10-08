package com.hive.protocol.promotionv2;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.promotionv2.PromotionV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: MoreGames.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/promotionv2/MoreGames;", "Lcom/hive/protocol/promotionv2/PromotionV2;", "<init>", "()V", "value", "Lcom/hive/protocol/promotionv2/MoreGames$MoreGamesResponse;", "response", "getResponse", "()Lcom/hive/protocol/promotionv2/MoreGames$MoreGamesResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "MoreGamesResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreGames extends PromotionV2 {
    private MoreGamesResponse response;

    public final MoreGamesResponse getResponse() {
        MoreGamesResponse moreGamesResponse = this.response;
        if (moreGamesResponse != null) {
            return moreGamesResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.promotionv2.PromotionV2, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.PromotionV2.INSTANCE.getMoreGames());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.promotionv2.PromotionV2, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new MoreGamesResponse(coreResponse);
    }

    /* JADX INFO: compiled from: MoreGames.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/hive/protocol/promotionv2/MoreGames$MoreGamesResponse;", "Lcom/hive/protocol/promotionv2/PromotionV2$PromotionV2Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "keyMore", "", "getKeyMore", "()Ljava/lang/String;", "keyClose", "getKeyClose", "keyCancel", "getKeyCancel", "url", "getUrl", "setUrl", "(Ljava/lang/String;)V", "labelMsg", "getLabelMsg", "setLabelMsg", "labelMore", "getLabelMore", "setLabelMore", "labelClose", "getLabelClose", "setLabelClose", "labelCancel", "getLabelCancel", "setLabelCancel", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MoreGamesResponse extends PromotionV2.PromotionV2Response {
        private final String keyCancel;
        private final String keyClose;
        private final String keyMore;
        private String labelCancel;
        private String labelClose;
        private String labelMore;
        private String labelMsg;
        private String url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MoreGamesResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.keyMore = "more";
            this.keyClose = "close";
            this.keyCancel = "cancel";
            this.url = "";
            this.labelMsg = "";
            this.labelMore = "";
            this.labelClose = "";
            this.labelCancel = "";
            if (isSuccess()) {
                try {
                    String strOptString = getContentJSONObject().optString("url");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.url = strOptString;
                    JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject(Constants.ScionAnalytics.PARAM_LABEL);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString2 = jSONObjectOptJSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "Exit?");
                        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                        this.labelMsg = strOptString2;
                        String strOptString3 = jSONObjectOptJSONObject.optString("more", "more");
                        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                        this.labelMore = strOptString3;
                        String strOptString4 = jSONObjectOptJSONObject.optString("close", "close");
                        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                        this.labelClose = strOptString4;
                        String strOptString5 = jSONObjectOptJSONObject.optString("cancel", "cancel");
                        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                        this.labelCancel = strOptString5;
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setResultCode(-1);
                    setResultMessage("[Exception] " + e);
                }
            }
        }

        public final String getKeyMore() {
            return this.keyMore;
        }

        public final String getKeyClose() {
            return this.keyClose;
        }

        public final String getKeyCancel() {
            return this.keyCancel;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        public final String getLabelMsg() {
            return this.labelMsg;
        }

        public final void setLabelMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.labelMsg = str;
        }

        public final String getLabelMore() {
            return this.labelMore;
        }

        public final void setLabelMore(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.labelMore = str;
        }

        public final String getLabelClose() {
            return this.labelClose;
        }

        public final void setLabelClose(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.labelClose = str;
        }

        public final String getLabelCancel() {
            return this.labelCancel;
        }

        public final void setLabelCancel(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.labelCancel = str;
        }
    }
}
