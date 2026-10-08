package com.hive.promotion.ui.customreview;

import kotlin.Metadata;

/* JADX INFO: compiled from: PromotionCustomReviewListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/hive/promotion/ui/customreview/PromotionCustomReviewListener;", "", "onDialogShow", "", "onNext", "onCancel", "onReview", "onCustom", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface PromotionCustomReviewListener {
    void onCancel();

    void onCustom();

    void onDialogShow();

    void onNext();

    void onReview();
}
