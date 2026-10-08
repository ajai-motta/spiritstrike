package com.hive.promotion.ui.customreview;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomReview.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jc\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006)"}, d2 = {"Lcom/hive/promotion/ui/customreview/CustomReview;", "", "title", "", NotificationCompat.CATEGORY_MESSAGE, "portImage", "landImage", "imageAlignmentRight", "", "customButtonMsg", "customButtonUrl", "reviewButtonMsg", "reviewButtonUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getMsg", "getPortImage", "getLandImage", "getImageAlignmentRight", "()Z", "getCustomButtonMsg", "getCustomButtonUrl", "getReviewButtonMsg", "getReviewButtonUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CustomReview {
    private final String customButtonMsg;
    private final String customButtonUrl;
    private final boolean imageAlignmentRight;
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
    public final boolean getImageAlignmentRight() {
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
    public final String getReviewButtonMsg() {
        return this.reviewButtonMsg;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getReviewButtonUrl() {
        return this.reviewButtonUrl;
    }

    public final CustomReview copy(String title, String msg, String portImage, String landImage, boolean imageAlignmentRight, String customButtonMsg, String customButtonUrl, String reviewButtonMsg, String reviewButtonUrl) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(portImage, "portImage");
        Intrinsics.checkNotNullParameter(landImage, "landImage");
        Intrinsics.checkNotNullParameter(customButtonMsg, "customButtonMsg");
        Intrinsics.checkNotNullParameter(customButtonUrl, "customButtonUrl");
        Intrinsics.checkNotNullParameter(reviewButtonMsg, "reviewButtonMsg");
        Intrinsics.checkNotNullParameter(reviewButtonUrl, "reviewButtonUrl");
        return new CustomReview(title, msg, portImage, landImage, imageAlignmentRight, customButtonMsg, customButtonUrl, reviewButtonMsg, reviewButtonUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomReview)) {
            return false;
        }
        CustomReview customReview = (CustomReview) other;
        return Intrinsics.areEqual(this.title, customReview.title) && Intrinsics.areEqual(this.msg, customReview.msg) && Intrinsics.areEqual(this.portImage, customReview.portImage) && Intrinsics.areEqual(this.landImage, customReview.landImage) && this.imageAlignmentRight == customReview.imageAlignmentRight && Intrinsics.areEqual(this.customButtonMsg, customReview.customButtonMsg) && Intrinsics.areEqual(this.customButtonUrl, customReview.customButtonUrl) && Intrinsics.areEqual(this.reviewButtonMsg, customReview.reviewButtonMsg) && Intrinsics.areEqual(this.reviewButtonUrl, customReview.reviewButtonUrl);
    }

    public int hashCode() {
        return (((((((((((((((this.title.hashCode() * 31) + this.msg.hashCode()) * 31) + this.portImage.hashCode()) * 31) + this.landImage.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.imageAlignmentRight)) * 31) + this.customButtonMsg.hashCode()) * 31) + this.customButtonUrl.hashCode()) * 31) + this.reviewButtonMsg.hashCode()) * 31) + this.reviewButtonUrl.hashCode();
    }

    public String toString() {
        return "CustomReview(title=" + this.title + ", msg=" + this.msg + ", portImage=" + this.portImage + ", landImage=" + this.landImage + ", imageAlignmentRight=" + this.imageAlignmentRight + ", customButtonMsg=" + this.customButtonMsg + ", customButtonUrl=" + this.customButtonUrl + ", reviewButtonMsg=" + this.reviewButtonMsg + ", reviewButtonUrl=" + this.reviewButtonUrl + ')';
    }

    public CustomReview(String title, String msg, String portImage, String landImage, boolean z, String customButtonMsg, String customButtonUrl, String reviewButtonMsg, String reviewButtonUrl) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(portImage, "portImage");
        Intrinsics.checkNotNullParameter(landImage, "landImage");
        Intrinsics.checkNotNullParameter(customButtonMsg, "customButtonMsg");
        Intrinsics.checkNotNullParameter(customButtonUrl, "customButtonUrl");
        Intrinsics.checkNotNullParameter(reviewButtonMsg, "reviewButtonMsg");
        Intrinsics.checkNotNullParameter(reviewButtonUrl, "reviewButtonUrl");
        this.title = title;
        this.msg = msg;
        this.portImage = portImage;
        this.landImage = landImage;
        this.imageAlignmentRight = z;
        this.customButtonMsg = customButtonMsg;
        this.customButtonUrl = customButtonUrl;
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

    public final boolean getImageAlignmentRight() {
        return this.imageAlignmentRight;
    }

    public final String getCustomButtonMsg() {
        return this.customButtonMsg;
    }

    public final String getCustomButtonUrl() {
        return this.customButtonUrl;
    }

    public final String getReviewButtonMsg() {
        return this.reviewButtonMsg;
    }

    public final String getReviewButtonUrl() {
        return this.reviewButtonUrl;
    }
}
