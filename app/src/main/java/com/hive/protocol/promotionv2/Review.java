package com.hive.protocol.promotionv2;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.messaging.Constants;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.protocol.promotionv2.PromotionV2;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: Review.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/hive/protocol/promotionv2/Review;", "Lcom/hive/protocol/promotionv2/PromotionV2;", "<init>", "()V", "value", "Lcom/hive/protocol/promotionv2/Review$ReviewResponse;", "response", "getResponse", "()Lcom/hive/protocol/promotionv2/Review$ReviewResponse;", "toCoreRequest", "Lcom/hive/core/Request;", "toCoreRequest$hive_protocol_release", "toResponse", "", "coreResponse", "Lcom/hive/core/Response;", "toResponse$hive_protocol_release", "ReviewResponse", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Review extends PromotionV2 {
    private ReviewResponse response;

    public final ReviewResponse getResponse() {
        ReviewResponse reviewResponse = this.response;
        if (reviewResponse != null) {
            return reviewResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    @Override // com.hive.protocol.promotionv2.PromotionV2, com.hive.protocol.ProtocolRequest
    public Request toCoreRequest$hive_protocol_release() {
        getCoreRequest().setUrl(UrlManager.PromotionV2.INSTANCE.getReview());
        return super.toCoreRequest$hive_protocol_release();
    }

    @Override // com.hive.protocol.promotionv2.PromotionV2, com.hive.protocol.ProtocolRequest
    public void toResponse$hive_protocol_release(Response coreResponse) {
        Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
        super.toResponse$hive_protocol_release(coreResponse);
        this.response = new ReviewResponse(coreResponse);
    }

    /* JADX INFO: compiled from: Review.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00013B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u0017R\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u0017R\u001a\u0010*\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010\u0013R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/hive/protocol/promotionv2/Review$ReviewResponse;", "Lcom/hive/protocol/promotionv2/PromotionV2$PromotionV2Response;", "coreResponse", "Lcom/hive/core/Response;", "<init>", "(Lcom/hive/core/Response;)V", "keyOk", "", "getKeyOk", "()Ljava/lang/String;", "keyNo", "getKeyNo", "keyNext", "getKeyNext", "state", "", "getState", "()I", "setState", "(I)V", "url", "getUrl", "setUrl", "(Ljava/lang/String;)V", "labelTitle", "getLabelTitle", "setLabelTitle", "labelMsg", "getLabelMsg", "setLabelMsg", "labelOk", "getLabelOk", "setLabelOk", "labelNo", "getLabelNo", "setLabelNo", "labelNext", "getLabelNext", "setLabelNext", "market", "getMarket", "setMarket", "useCustomReview", "getUseCustomReview", "setUseCustomReview", "customReview", "Lcom/hive/protocol/promotionv2/Review$ReviewResponse$CustomReview;", "getCustomReview", "()Lcom/hive/protocol/promotionv2/Review$ReviewResponse$CustomReview;", "setCustomReview", "(Lcom/hive/protocol/promotionv2/Review$ReviewResponse$CustomReview;)V", "CustomReview", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReviewResponse extends PromotionV2.PromotionV2Response {
        private CustomReview customReview;
        private final String keyNext;
        private final String keyNo;
        private final String keyOk;
        private String labelMsg;
        private String labelNext;
        private String labelNo;
        private String labelOk;
        private String labelTitle;
        private String market;
        private int state;
        private String url;
        private int useCustomReview;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReviewResponse(Response coreResponse) {
            super(coreResponse);
            Intrinsics.checkNotNullParameter(coreResponse, "coreResponse");
            this.keyOk = "ok";
            this.keyNo = "no";
            this.keyNext = LinkHeader.Rel.Next;
            this.state = -1;
            this.url = "";
            this.labelTitle = "";
            this.labelMsg = "";
            this.labelOk = "";
            this.labelNo = "";
            this.labelNext = "";
            this.market = "";
            if (isSuccess()) {
                try {
                    this.state = getContentJSONObject().optInt("state");
                    String strOptString = getContentJSONObject().optString("market");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.market = strOptString;
                    this.useCustomReview = getContentJSONObject().optInt("use_custom_review", 0);
                    if (this.state == 1) {
                        String strOptString2 = getContentJSONObject().optString("url");
                        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                        this.url = strOptString2;
                        JSONObject jSONObjectOptJSONObject = getContentJSONObject().optJSONObject(Constants.ScionAnalytics.PARAM_LABEL);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString3 = jSONObjectOptJSONObject.optString("title");
                            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                            this.labelTitle = strOptString3;
                            String strOptString4 = jSONObjectOptJSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                            this.labelMsg = strOptString4;
                            String strOptString5 = jSONObjectOptJSONObject.optString("ok", "ok");
                            Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                            this.labelOk = strOptString5;
                            String strOptString6 = jSONObjectOptJSONObject.optString("no", "no");
                            Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                            this.labelNo = strOptString6;
                            String strOptString7 = jSONObjectOptJSONObject.optString(LinkHeader.Rel.Next, LinkHeader.Rel.Next);
                            Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                            this.labelNext = strOptString7;
                        }
                        JSONObject jSONObjectOptJSONObject2 = getContentJSONObject().optJSONObject("custom_label");
                        if (jSONObjectOptJSONObject2 != null) {
                            String strOptString8 = jSONObjectOptJSONObject2.optString("title");
                            Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                            String strOptString9 = jSONObjectOptJSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE);
                            Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
                            String strOptString10 = jSONObjectOptJSONObject2.optString("port_image");
                            Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
                            String strOptString11 = jSONObjectOptJSONObject2.optString("land_image");
                            Intrinsics.checkNotNullExpressionValue(strOptString11, "optString(...)");
                            int iOptInt = jSONObjectOptJSONObject2.optInt("image_alignment_right", 0);
                            String strOptString12 = jSONObjectOptJSONObject2.optString("custom_button_msg");
                            Intrinsics.checkNotNullExpressionValue(strOptString12, "optString(...)");
                            String strOptString13 = jSONObjectOptJSONObject2.optString("custom_button_url");
                            Intrinsics.checkNotNullExpressionValue(strOptString13, "optString(...)");
                            String strOptString14 = jSONObjectOptJSONObject2.optString("custom_button_type");
                            Intrinsics.checkNotNullExpressionValue(strOptString14, "optString(...)");
                            String strOptString15 = jSONObjectOptJSONObject2.optString("review_button_msg");
                            Intrinsics.checkNotNullExpressionValue(strOptString15, "optString(...)");
                            String strOptString16 = jSONObjectOptJSONObject2.optString("review_button_url");
                            Intrinsics.checkNotNullExpressionValue(strOptString16, "optString(...)");
                            this.customReview = new CustomReview(strOptString8, strOptString9, strOptString10, strOptString11, iOptInt, strOptString12, strOptString13, strOptString14, strOptString15, strOptString16);
                        }
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.protocolLog(e.toString(), Logger.LogType.Warning);
                    setResultCode(-1);
                    setResultMessage("[Exception] " + e);
                }
            }
        }

        public final String getKeyOk() {
            return this.keyOk;
        }

        public final String getKeyNo() {
            return this.keyNo;
        }

        public final String getKeyNext() {
            return this.keyNext;
        }

        public final int getState() {
            return this.state;
        }

        public final void setState(int i) {
            this.state = i;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        public final String getLabelTitle() {
            return this.labelTitle;
        }

        public final void setLabelTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.labelTitle = str;
        }

        public final String getLabelMsg() {
            return this.labelMsg;
        }

        public final void setLabelMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.labelMsg = str;
        }

        public final String getLabelOk() {
            return this.labelOk;
        }

        public final void setLabelOk(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.labelOk = str;
        }

        public final String getLabelNo() {
            return this.labelNo;
        }

        public final void setLabelNo(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.labelNo = str;
        }

        public final String getLabelNext() {
            return this.labelNext;
        }

        public final void setLabelNext(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.labelNext = str;
        }

        public final String getMarket() {
            return this.market;
        }

        public final void setMarket(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.market = str;
        }

        public final int getUseCustomReview() {
            return this.useCustomReview;
        }

        public final void setUseCustomReview(int i) {
            this.useCustomReview = i;
        }

        public final CustomReview getCustomReview() {
            return this.customReview;
        }

        public final void setCustomReview(CustomReview customReview) {
            this.customReview = customReview;
        }

        /* JADX INFO: compiled from: Review.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jm\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006,"}, d2 = {"Lcom/hive/protocol/promotionv2/Review$ReviewResponse$CustomReview;", "", "title", "", NotificationCompat.CATEGORY_MESSAGE, "portImage", "landImage", "imageAlignmentRight", "", "customButtonMsg", "customButtonUrl", "customButtonType", "reviewButtonMsg", "reviewButtonUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getMsg", "getPortImage", "getLandImage", "getImageAlignmentRight", "()I", "getCustomButtonMsg", "getCustomButtonUrl", "getCustomButtonType", "getReviewButtonMsg", "getReviewButtonUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class CustomReview {
            private final String customButtonMsg;
            private final String customButtonType;
            private final String customButtonUrl;
            private final int imageAlignmentRight;
            private final String landImage;
            private final String msg;
            private final String portImage;
            private final String reviewButtonMsg;
            private final String reviewButtonUrl;
            private final String title;

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final String getReviewButtonUrl() {
                return this.reviewButtonUrl;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getMsg() {
                return this.msg;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getPortImage() {
                return this.portImage;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getLandImage() {
                return this.landImage;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final int getImageAlignmentRight() {
                return this.imageAlignmentRight;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final String getCustomButtonMsg() {
                return this.customButtonMsg;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final String getCustomButtonUrl() {
                return this.customButtonUrl;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final String getCustomButtonType() {
                return this.customButtonType;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final String getReviewButtonMsg() {
                return this.reviewButtonMsg;
            }

            public final CustomReview copy(String title, String msg, String portImage, String landImage, int imageAlignmentRight, String customButtonMsg, String customButtonUrl, String customButtonType, String reviewButtonMsg, String reviewButtonUrl) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(portImage, "portImage");
                Intrinsics.checkNotNullParameter(landImage, "landImage");
                Intrinsics.checkNotNullParameter(customButtonMsg, "customButtonMsg");
                Intrinsics.checkNotNullParameter(customButtonUrl, "customButtonUrl");
                Intrinsics.checkNotNullParameter(customButtonType, "customButtonType");
                Intrinsics.checkNotNullParameter(reviewButtonMsg, "reviewButtonMsg");
                Intrinsics.checkNotNullParameter(reviewButtonUrl, "reviewButtonUrl");
                return new CustomReview(title, msg, portImage, landImage, imageAlignmentRight, customButtonMsg, customButtonUrl, customButtonType, reviewButtonMsg, reviewButtonUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CustomReview)) {
                    return false;
                }
                CustomReview customReview = (CustomReview) other;
                return Intrinsics.areEqual(this.title, customReview.title) && Intrinsics.areEqual(this.msg, customReview.msg) && Intrinsics.areEqual(this.portImage, customReview.portImage) && Intrinsics.areEqual(this.landImage, customReview.landImage) && this.imageAlignmentRight == customReview.imageAlignmentRight && Intrinsics.areEqual(this.customButtonMsg, customReview.customButtonMsg) && Intrinsics.areEqual(this.customButtonUrl, customReview.customButtonUrl) && Intrinsics.areEqual(this.customButtonType, customReview.customButtonType) && Intrinsics.areEqual(this.reviewButtonMsg, customReview.reviewButtonMsg) && Intrinsics.areEqual(this.reviewButtonUrl, customReview.reviewButtonUrl);
            }

            public int hashCode() {
                return (((((((((((((((((this.title.hashCode() * 31) + this.msg.hashCode()) * 31) + this.portImage.hashCode()) * 31) + this.landImage.hashCode()) * 31) + this.imageAlignmentRight) * 31) + this.customButtonMsg.hashCode()) * 31) + this.customButtonUrl.hashCode()) * 31) + this.customButtonType.hashCode()) * 31) + this.reviewButtonMsg.hashCode()) * 31) + this.reviewButtonUrl.hashCode();
            }

            public String toString() {
                return "CustomReview(title=" + this.title + ", msg=" + this.msg + ", portImage=" + this.portImage + ", landImage=" + this.landImage + ", imageAlignmentRight=" + this.imageAlignmentRight + ", customButtonMsg=" + this.customButtonMsg + ", customButtonUrl=" + this.customButtonUrl + ", customButtonType=" + this.customButtonType + ", reviewButtonMsg=" + this.reviewButtonMsg + ", reviewButtonUrl=" + this.reviewButtonUrl + ')';
            }

            public CustomReview(String title, String msg, String portImage, String landImage, int i, String customButtonMsg, String customButtonUrl, String customButtonType, String reviewButtonMsg, String reviewButtonUrl) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(portImage, "portImage");
                Intrinsics.checkNotNullParameter(landImage, "landImage");
                Intrinsics.checkNotNullParameter(customButtonMsg, "customButtonMsg");
                Intrinsics.checkNotNullParameter(customButtonUrl, "customButtonUrl");
                Intrinsics.checkNotNullParameter(customButtonType, "customButtonType");
                Intrinsics.checkNotNullParameter(reviewButtonMsg, "reviewButtonMsg");
                Intrinsics.checkNotNullParameter(reviewButtonUrl, "reviewButtonUrl");
                this.title = title;
                this.msg = msg;
                this.portImage = portImage;
                this.landImage = landImage;
                this.imageAlignmentRight = i;
                this.customButtonMsg = customButtonMsg;
                this.customButtonUrl = customButtonUrl;
                this.customButtonType = customButtonType;
                this.reviewButtonMsg = reviewButtonMsg;
                this.reviewButtonUrl = reviewButtonUrl;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getMsg() {
                return this.msg;
            }

            public final String getPortImage() {
                return this.portImage;
            }

            public final String getLandImage() {
                return this.landImage;
            }

            public final int getImageAlignmentRight() {
                return this.imageAlignmentRight;
            }

            public final String getCustomButtonMsg() {
                return this.customButtonMsg;
            }

            public final String getCustomButtonUrl() {
                return this.customButtonUrl;
            }

            public final String getCustomButtonType() {
                return this.customButtonType;
            }

            public final String getReviewButtonMsg() {
                return this.reviewButtonMsg;
            }

            public final String getReviewButtonUrl() {
                return this.reviewButtonUrl;
            }
        }
    }
}
