package com.hive.promotion.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.core.ExtentionsKt;
import com.hive.core.Logger;
import com.hive.promotion.ui.PromotionPopupDialog;
import com.hive.promotion.ui.model.Review;
import com.hive.ui.dialog.HivePopupDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PromotionReviewDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/hive/promotion/ui/PromotionReviewDialog;", "", "activity", "Landroid/app/Activity;", "review", "Lcom/hive/promotion/ui/model/Review;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/promotion/ui/PromotionReviewDialog$PromotionReviewDialogListener;", "<init>", "(Landroid/app/Activity;Lcom/hive/promotion/ui/model/Review;Lcom/hive/promotion/ui/PromotionReviewDialog$PromotionReviewDialogListener;)V", "reviewDialog", "Lcom/hive/promotion/ui/PromotionPopupDialog;", "createDialog", "show", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "cancel", "dismiss", "PromotionReviewDialogListener", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionReviewDialog {
    private final PromotionReviewDialogListener listener;
    private final Review review;
    private PromotionPopupDialog reviewDialog;

    /* JADX INFO: compiled from: PromotionReviewDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/hive/promotion/ui/PromotionReviewDialog$PromotionReviewDialogListener;", "", "onDialogShow", "", "onNext", "onCancel", "onReview", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PromotionReviewDialogListener {
        void onCancel();

        void onDialogShow();

        void onNext();

        void onReview();
    }

    public PromotionReviewDialog(Activity activity, Review review, PromotionReviewDialogListener promotionReviewDialogListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(review, "review");
        this.review = review;
        this.listener = promotionReviewDialogListener;
        this.reviewDialog = createDialog(activity);
    }

    private final PromotionPopupDialog createDialog(final Activity activity) {
        PromotionPopupDialog.Builder builder = new PromotionPopupDialog.Builder(activity);
        builder.setTitle(this.review.getTitle());
        builder.setMessage(this.review.getMsg());
        builder.setCloseButton(this.review.getNo(), new View.OnClickListener() { // from class: com.hive.promotion.ui.PromotionReviewDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromotionReviewDialog.createDialog$lambda$0(this.f$0, view);
            }
        });
        builder.setSubButton(this.review.getNext(), new View.OnClickListener() { // from class: com.hive.promotion.ui.PromotionReviewDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromotionReviewDialog.createDialog$lambda$1(this.f$0, view);
            }
        });
        builder.setMainButton(this.review.getOk(), new View.OnClickListener() { // from class: com.hive.promotion.ui.PromotionReviewDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromotionReviewDialog.createDialog$lambda$3(this.f$0, activity, view);
            }
        });
        builder.setDialogType(HivePopupDialog.HivePopupDialogParams.NativeDialogType.PROMOTION_REVIEW);
        PromotionPopupDialog promotionPopupDialogCreate = builder.create();
        promotionPopupDialogCreate.setCancelable(true);
        promotionPopupDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.hive.promotion.ui.PromotionReviewDialog$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                PromotionReviewDialog.createDialog$lambda$4(this.f$0, dialogInterface);
            }
        });
        promotionPopupDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.hive.promotion.ui.PromotionReviewDialog$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                PromotionReviewDialog.createDialog$lambda$5(this.f$0, dialogInterface);
            }
        });
        return promotionPopupDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$0(PromotionReviewDialog promotionReviewDialog, View view) {
        PromotionReviewDialogListener promotionReviewDialogListener = promotionReviewDialog.listener;
        if (promotionReviewDialogListener != null) {
            promotionReviewDialogListener.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$1(PromotionReviewDialog promotionReviewDialog, View view) {
        PromotionReviewDialogListener promotionReviewDialogListener = promotionReviewDialog.listener;
        if (promotionReviewDialogListener != null) {
            promotionReviewDialogListener.onNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$3(PromotionReviewDialog promotionReviewDialog, Activity activity, View view) {
        if (!StringsKt.isBlank(promotionReviewDialog.review.getUrl())) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(promotionReviewDialog.review.getUrl()));
            intent.setFlags(268435456);
            ExtentionsKt.startActivityCatching(activity, intent, new Function1() { // from class: com.hive.promotion.ui.PromotionReviewDialog$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionReviewDialog.createDialog$lambda$3$lambda$2((Throwable) obj);
                }
            });
        }
        PromotionReviewDialogListener promotionReviewDialogListener = promotionReviewDialog.listener;
        if (promotionReviewDialogListener != null) {
            promotionReviewDialogListener.onReview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDialog$lambda$3$lambda$2(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.w("[PromotionReviewDialog] init\ne: " + it.getMessage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$4(PromotionReviewDialog promotionReviewDialog, DialogInterface dialogInterface) {
        PromotionReviewDialogListener promotionReviewDialogListener = promotionReviewDialog.listener;
        if (promotionReviewDialogListener != null) {
            promotionReviewDialogListener.onNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$5(PromotionReviewDialog promotionReviewDialog, DialogInterface dialogInterface) {
        PromotionReviewDialogListener promotionReviewDialogListener = promotionReviewDialog.listener;
        if (promotionReviewDialogListener != null) {
            promotionReviewDialogListener.onDialogShow();
        }
    }

    public final void show() {
        if (this.reviewDialog.isShowing()) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.ui.PromotionReviewDialog$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                PromotionReviewDialog.show$lambda$6(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$6(PromotionReviewDialog promotionReviewDialog) {
        promotionReviewDialog.reviewDialog.show();
    }

    public final void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.reviewDialog.dismiss();
        PromotionPopupDialog promotionPopupDialogCreateDialog = createDialog(activity);
        this.reviewDialog = promotionPopupDialogCreateDialog;
        promotionPopupDialogCreateDialog.setOnShowListener(null);
        show();
    }

    public final void cancel() {
        this.reviewDialog.cancel();
    }

    public final void dismiss() {
        this.reviewDialog.dismiss();
    }
}
