package com.hive.iapv4.repayment.ui.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepaymentItem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003Jc\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/hive/iapv4/repayment/ui/model/RepaymentItem;", "", "refundIndex", "", "marketId", "marketName", "", "marketPid", "title", "displayPrice", "refundTime", "quantity", "state", "Lcom/hive/iapv4/repayment/ui/model/RepaymentState;", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/hive/iapv4/repayment/ui/model/RepaymentState;)V", "getRefundIndex", "()I", "getMarketId", "getMarketName", "()Ljava/lang/String;", "getMarketPid", "getTitle", "getDisplayPrice", "getRefundTime", "getQuantity", "getState", "()Lcom/hive/iapv4/repayment/ui/model/RepaymentState;", "setState", "(Lcom/hive/iapv4/repayment/ui/model/RepaymentState;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "hive-iapv4-repayment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RepaymentItem {
    private final String displayPrice;
    private final int marketId;
    private final String marketName;
    private final String marketPid;
    private final int quantity;
    private final int refundIndex;
    private final String refundTime;
    private RepaymentState state;
    private final String title;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRefundIndex() {
        return this.refundIndex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMarketId() {
        return this.marketId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMarketName() {
        return this.marketName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMarketPid() {
        return this.marketPid;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDisplayPrice() {
        return this.displayPrice;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRefundTime() {
        return this.refundTime;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final RepaymentState getState() {
        return this.state;
    }

    public final RepaymentItem copy(int refundIndex, int marketId, String marketName, String marketPid, String title, String displayPrice, String refundTime, int quantity, RepaymentState state) {
        Intrinsics.checkNotNullParameter(marketName, "marketName");
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(displayPrice, "displayPrice");
        Intrinsics.checkNotNullParameter(refundTime, "refundTime");
        Intrinsics.checkNotNullParameter(state, "state");
        return new RepaymentItem(refundIndex, marketId, marketName, marketPid, title, displayPrice, refundTime, quantity, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RepaymentItem)) {
            return false;
        }
        RepaymentItem repaymentItem = (RepaymentItem) other;
        return this.refundIndex == repaymentItem.refundIndex && this.marketId == repaymentItem.marketId && Intrinsics.areEqual(this.marketName, repaymentItem.marketName) && Intrinsics.areEqual(this.marketPid, repaymentItem.marketPid) && Intrinsics.areEqual(this.title, repaymentItem.title) && Intrinsics.areEqual(this.displayPrice, repaymentItem.displayPrice) && Intrinsics.areEqual(this.refundTime, repaymentItem.refundTime) && this.quantity == repaymentItem.quantity && this.state == repaymentItem.state;
    }

    public int hashCode() {
        return (((((((((((((((this.refundIndex * 31) + this.marketId) * 31) + this.marketName.hashCode()) * 31) + this.marketPid.hashCode()) * 31) + this.title.hashCode()) * 31) + this.displayPrice.hashCode()) * 31) + this.refundTime.hashCode()) * 31) + this.quantity) * 31) + this.state.hashCode();
    }

    public String toString() {
        return "RepaymentItem(refundIndex=" + this.refundIndex + ", marketId=" + this.marketId + ", marketName=" + this.marketName + ", marketPid=" + this.marketPid + ", title=" + this.title + ", displayPrice=" + this.displayPrice + ", refundTime=" + this.refundTime + ", quantity=" + this.quantity + ", state=" + this.state + ')';
    }

    public RepaymentItem(int i, int i2, String marketName, String marketPid, String title, String displayPrice, String refundTime, int i3, RepaymentState state) {
        Intrinsics.checkNotNullParameter(marketName, "marketName");
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(displayPrice, "displayPrice");
        Intrinsics.checkNotNullParameter(refundTime, "refundTime");
        Intrinsics.checkNotNullParameter(state, "state");
        this.refundIndex = i;
        this.marketId = i2;
        this.marketName = marketName;
        this.marketPid = marketPid;
        this.title = title;
        this.displayPrice = displayPrice;
        this.refundTime = refundTime;
        this.quantity = i3;
        this.state = state;
    }

    public final int getRefundIndex() {
        return this.refundIndex;
    }

    public final int getMarketId() {
        return this.marketId;
    }

    public final String getMarketName() {
        return this.marketName;
    }

    public final String getMarketPid() {
        return this.marketPid;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDisplayPrice() {
        return this.displayPrice;
    }

    public final String getRefundTime() {
        return this.refundTime;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final RepaymentState getState() {
        return this.state;
    }

    public final void setState(RepaymentState repaymentState) {
        Intrinsics.checkNotNullParameter(repaymentState, "<set-?>");
        this.state = repaymentState;
    }
}
