package com.hive.promotion.ui.customreview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.TextViewCompat;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.core.ExtentionsKt;
import com.hive.core.Logger;
import com.hive.promotion.R;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.Util;
import com.hive.ui.effect.TouchEffectKt;
import com.hive.ui.view.HiveTextView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PromotionCustomReview.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/hive/promotion/ui/customreview/PromotionCustomReview;", "Lcom/hive/ui/OnActivityLifecycle;", "parentActivity", "Landroid/app/Activity;", "customReview", "Lcom/hive/promotion/ui/customreview/CustomReview;", "<init>", "(Landroid/app/Activity;Lcom/hive/promotion/ui/customreview/CustomReview;)V", "TAG", "", "kotlin.jvm.PlatformType", "value", "", "isShowing", "()Z", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/promotion/ui/customreview/PromotionCustomReviewListener;", "show", "", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBackPressed", "onDestroy", "convertPxToDp", "", "context", "Landroid/content/Context;", "px", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionCustomReview extends OnActivityLifecycle {
    private final String TAG;
    private final CustomReview customReview;
    private boolean isShowing;
    private PromotionCustomReviewListener listener;
    private final Activity parentActivity;

    public PromotionCustomReview(Activity parentActivity, CustomReview customReview) {
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        Intrinsics.checkNotNullParameter(customReview, "customReview");
        this.parentActivity = parentActivity;
        this.customReview = customReview;
        this.TAG = "PromotionCustomReview";
    }

    /* JADX INFO: renamed from: isShowing, reason: from getter */
    public final boolean getIsShowing() {
        return this.isShowing;
    }

    public final void show(PromotionCustomReviewListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logger.INSTANCE.d(this.TAG, "[PromotionCustomReview] show");
        this.listener = listener;
        if (this.isShowing) {
            Logger.INSTANCE.d(this.TAG, "[PromotionCustomReview] isShowing");
            return;
        }
        Intent intentPutExtra = new Intent().putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "Promotion");
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        HiveUiActivity.INSTANCE.launch(this.parentActivity, intentPutExtra, this);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onCreate(final Activity activity, Bundle savedInstanceState) {
        Object objM7415constructorimpl;
        Object objM7415constructorimpl2;
        PromotionCustomReviewListener promotionCustomReviewListener;
        String landImage;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.INSTANCE.d(this.TAG, "onCreate()");
        this.isShowing = true;
        activity.setContentView(R.layout.hive_promotion_custom_review);
        HiveTextView hiveTextView = (HiveTextView) activity.findViewById(R.id.titleTextView);
        if (hiveTextView != null) {
            hiveTextView.setText(this.customReview.getTitle());
        }
        HiveTextView hiveTextView2 = (HiveTextView) activity.findViewById(R.id.bodyTextView);
        if (hiveTextView2 != null) {
            hiveTextView2.setText(this.customReview.getMsg());
        }
        HiveTextView hiveTextView3 = (HiveTextView) activity.findViewById(R.id.leftButton);
        if (hiveTextView3 != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                float fConvertPxToDp = convertPxToDp(activity, hiveTextView3.getTextSize());
                TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(hiveTextView3, MathKt.roundToInt(((double) fConvertPxToDp) * 0.7d), MathKt.roundToInt(fConvertPxToDp), 1, 2);
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7418exceptionOrNullimpl(objM7415constructorimpl) != null) {
                Logger.INSTANCE.w("TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration() onFailure");
            }
            hiveTextView3.setText(this.customReview.getCustomButtonMsg());
            TouchEffectKt.setTouchEffect(hiveTextView3, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.customreview.PromotionCustomReview$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionCustomReview.onCreate$lambda$5$lambda$4(this.f$0, activity, (View) obj);
                }
            } : null);
        }
        HiveTextView hiveTextView4 = (HiveTextView) activity.findViewById(R.id.rightButton);
        if (hiveTextView4 != null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                float fConvertPxToDp2 = convertPxToDp(activity, hiveTextView4.getTextSize());
                TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(hiveTextView4, MathKt.roundToInt(((double) fConvertPxToDp2) * 0.7d), MathKt.roundToInt(fConvertPxToDp2), 1, 2);
                objM7415constructorimpl2 = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM7415constructorimpl2 = Result.m7415constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m7418exceptionOrNullimpl(objM7415constructorimpl2) != null) {
                Logger.INSTANCE.w("TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration() onFailure");
            }
            hiveTextView4.setText(this.customReview.getReviewButtonMsg());
            TouchEffectKt.setTouchEffect(hiveTextView4, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.customreview.PromotionCustomReview$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionCustomReview.onCreate$lambda$10$lambda$9(this.f$0, activity, (View) obj);
                }
            } : null);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) activity.findViewById(R.id.close_imageView);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.hive.promotion.ui.customreview.PromotionCustomReview$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PromotionCustomReview.onCreate$lambda$12$lambda$11(this.f$0, activity, view);
                }
            });
        }
        boolean imageAlignmentRight = this.customReview.getImageAlignmentRight();
        boolean zIsTable = Util.INSTANCE.isTable(activity);
        boolean z = !zIsTable && Util.INSTANCE.isLandscape(activity);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) activity.findViewById(R.id.imageView);
        if (appCompatImageView2 != null) {
            if (z || zIsTable) {
                landImage = this.customReview.getLandImage();
            } else {
                landImage = this.customReview.getPortImage();
            }
            if (!StringsKt.isBlank(landImage)) {
                Intrinsics.checkNotNull(Glide.with(activity).load(landImage).into(appCompatImageView2));
            } else {
                Logger.INSTANCE.w(this.TAG, "ImageUrl is Blank.");
            }
        }
        if ((z || zIsTable) && imageAlignmentRight) {
            try {
                ((LinearLayout) activity.findViewById(R.id.linearLayout)).setLayoutDirection(1);
            } catch (Exception e) {
                Logger.INSTANCE.w(this.TAG, "onCreate() Exception : " + e.getMessage());
            }
        }
        if (getIsRecreated() || (promotionCustomReviewListener = this.listener) == null) {
            return;
        }
        promotionCustomReviewListener.onDialogShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$5$lambda$4(PromotionCustomReview promotionCustomReview, Activity activity, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PromotionCustomReviewListener promotionCustomReviewListener = promotionCustomReview.listener;
        if (promotionCustomReviewListener != null) {
            promotionCustomReviewListener.onCustom();
        }
        activity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$lambda$9(PromotionCustomReview promotionCustomReview, Activity activity, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!StringsKt.isBlank(promotionCustomReview.customReview.getReviewButtonUrl())) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(promotionCustomReview.customReview.getReviewButtonUrl()));
            intent.setFlags(268435456);
            ExtentionsKt.startActivityCatching(activity, intent, new Function1() { // from class: com.hive.promotion.ui.customreview.PromotionCustomReview$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionCustomReview.onCreate$lambda$10$lambda$9$lambda$8((Throwable) obj);
                }
            });
        }
        PromotionCustomReviewListener promotionCustomReviewListener = promotionCustomReview.listener;
        if (promotionCustomReviewListener != null) {
            promotionCustomReviewListener.onReview();
        }
        activity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$lambda$9$lambda$8(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        Logger.INSTANCE.w("[PromotionCustomReview] onCreate()\ne: " + t.getMessage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$12$lambda$11(PromotionCustomReview promotionCustomReview, Activity activity, View view) {
        PromotionCustomReviewListener promotionCustomReviewListener = promotionCustomReview.listener;
        if (promotionCustomReviewListener != null) {
            promotionCustomReviewListener.onCancel();
        }
        activity.finish();
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        Logger.INSTANCE.d(this.TAG, "onConfigurationChanged()");
        activity.recreate();
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public boolean onBackPressed() {
        Logger.INSTANCE.d(this.TAG, "onBackPressed()");
        PromotionCustomReviewListener promotionCustomReviewListener = this.listener;
        if (promotionCustomReviewListener == null) {
            return false;
        }
        promotionCustomReviewListener.onNext();
        return false;
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.INSTANCE.d(this.TAG, "onDestroy()");
        if (getIsCalledFinish() || getIsRecreated()) {
            return;
        }
        Logger.INSTANCE.d(this.TAG, "unexpected onDestroy()");
        PromotionCustomReviewListener promotionCustomReviewListener = this.listener;
        if (promotionCustomReviewListener != null) {
            promotionCustomReviewListener.onNext();
        }
    }

    private final float convertPxToDp(Context context, float px) {
        return px / (context.getResources().getDisplayMetrics().densityDpi / 160);
    }
}
