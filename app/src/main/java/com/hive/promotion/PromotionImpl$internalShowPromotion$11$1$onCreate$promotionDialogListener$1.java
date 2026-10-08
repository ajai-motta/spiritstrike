package com.hive.promotion;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.hive.Promotion;
import com.hive.ResultAPI;
import com.hive.logger.LoggerImpl;
import com.hive.promotion.PromotionDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromotionImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/hive/promotion/PromotionImpl$internalShowPromotion$11$1$onCreate$promotionDialogListener$1", "Lcom/hive/promotion/PromotionDialog$PromotionDialogListener;", "needDialogClosed", "", "result", "Lcom/hive/ResultAPI;", "scheme", "", "onDialogShow", "onPlaybackStart", "onPlaybackFinish", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionImpl$internalShowPromotion$11$1$onCreate$promotionDialogListener$1 implements PromotionDialog.PromotionDialogListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $fApiName;
    final /* synthetic */ Promotion.PromotionViewListener $listener;
    final /* synthetic */ Promotion.PromotionWebviewType $promotionWebviewType;

    PromotionImpl$internalShowPromotion$11$1$onCreate$promotionDialogListener$1(Activity activity, String str, Promotion.PromotionWebviewType promotionWebviewType, Promotion.PromotionViewListener promotionViewListener) {
        this.$activity = activity;
        this.$fApiName = str;
        this.$promotionWebviewType = promotionWebviewType;
        this.$listener = promotionViewListener;
    }

    @Override // com.hive.promotion.PromotionDialog.PromotionDialogListener
    public void needDialogClosed(final ResultAPI result, String scheme) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Handler handler = new Handler(Looper.getMainLooper());
        final Activity activity = this.$activity;
        final String str = this.$fApiName;
        final Promotion.PromotionWebviewType promotionWebviewType = this.$promotionWebviewType;
        final Promotion.PromotionViewListener promotionViewListener = this.$listener;
        handler.postDelayed(new Runnable() { // from class: com.hive.promotion.PromotionImpl$internalShowPromotion$11$1$onCreate$promotionDialogListener$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PromotionImpl$internalShowPromotion$11$1$onCreate$promotionDialogListener$1.needDialogClosed$lambda$1(activity, str, result, promotionWebviewType, promotionViewListener);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void needDialogClosed$lambda$1(Activity activity, String str, ResultAPI resultAPI, Promotion.PromotionWebviewType promotionWebviewType, Promotion.PromotionViewListener promotionViewListener) {
        PromotionDialog promotionDialog = PromotionImpl.mPromotionDialog;
        if (promotionDialog != null) {
            promotionDialog.dismissMercury();
            PromotionImpl.INSTANCE.setMPromotionDialogListener(null);
            PromotionImpl.mShowingPromotion.set(false);
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI.toString());
            if (promotionWebviewType == Promotion.PromotionWebviewType.BANNER_DETAIL || promotionWebviewType == Promotion.PromotionWebviewType.BANNER) {
                if (promotionViewListener != null) {
                    promotionViewListener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.CLOSED);
                }
            } else if (promotionViewListener != null) {
                promotionViewListener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.GOBACK);
            }
        }
        PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
        PromotionImpl.mPromotionDialog = null;
        activity.finish();
    }

    @Override // com.hive.promotion.PromotionDialog.PromotionDialogListener
    public void needDialogClosed(final ResultAPI result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Handler handler = new Handler(Looper.getMainLooper());
        final Activity activity = this.$activity;
        final String str = this.$fApiName;
        final Promotion.PromotionViewListener promotionViewListener = this.$listener;
        handler.postDelayed(new Runnable() { // from class: com.hive.promotion.PromotionImpl$internalShowPromotion$11$1$onCreate$promotionDialogListener$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PromotionImpl$internalShowPromotion$11$1$onCreate$promotionDialogListener$1.needDialogClosed$lambda$3(activity, str, result, promotionViewListener);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void needDialogClosed$lambda$3(Activity activity, String str, ResultAPI resultAPI, Promotion.PromotionViewListener promotionViewListener) {
        PromotionDialog promotionDialog = PromotionImpl.mPromotionDialog;
        if (promotionDialog != null) {
            promotionDialog.dismissMercury();
            PromotionImpl.INSTANCE.setMPromotionDialogListener(null);
            PromotionImpl.mShowingPromotion.set(false);
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI.toString());
            if (promotionViewListener != null) {
                promotionViewListener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.CLOSED);
            }
        }
        PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
        PromotionImpl.mPromotionDialog = null;
        activity.finish();
    }

    @Override // com.hive.promotion.PromotionDialog.PromotionDialogListener
    public void onDialogShow() {
        ResultAPI resultAPI = new ResultAPI();
        LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), this.$fApiName, resultAPI.toString());
        Promotion.PromotionViewListener promotionViewListener = this.$listener;
        if (promotionViewListener != null) {
            promotionViewListener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.OPENED);
        }
    }

    @Override // com.hive.promotion.PromotionDialog.PromotionDialogListener
    public void onPlaybackStart(ResultAPI result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Promotion.PromotionViewListener promotionViewListener = this.$listener;
        if (promotionViewListener != null) {
            promotionViewListener.onPromotionView(result, Promotion.PromotionViewResultType.START_PLAYBACK);
        }
    }

    @Override // com.hive.promotion.PromotionDialog.PromotionDialogListener
    public void onPlaybackFinish(ResultAPI result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Promotion.PromotionViewListener promotionViewListener = this.$listener;
        if (promotionViewListener != null) {
            promotionViewListener.onPromotionView(result, Promotion.PromotionViewResultType.FINISH_PLAYBACK);
        }
        this.$activity.finish();
    }
}
