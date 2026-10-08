package com.hive.promotion;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.core.Configuration;
import com.hive.core.ExtentionsKt;
import com.hive.promotion.ui.PromotionPopupDialog;
import com.hive.protocol.promotionv2.MoreGames;
import com.hive.ui.Resource;
import com.hive.ui.view.HiveTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PromotionExitDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/hive/promotion/PromotionExitDialog;", "", "activity", "Landroid/app/Activity;", "responseApiMoreGames", "Lcom/hive/protocol/promotionv2/MoreGames$MoreGamesResponse;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/promotion/PromotionExitDialog$PromotionExitDialogListener;", "<init>", "(Landroid/app/Activity;Lcom/hive/protocol/promotionv2/MoreGames$MoreGamesResponse;Lcom/hive/promotion/PromotionExitDialog$PromotionExitDialogListener;)V", "exitDialog", "Lcom/hive/promotion/ui/PromotionPopupDialog;", "createDialog", "show", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "cancel", "dismiss", "PromotionExitDialogListener", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionExitDialog {
    private PromotionPopupDialog exitDialog;
    private final PromotionExitDialogListener listener;
    private final MoreGames.MoreGamesResponse responseApiMoreGames;

    /* JADX INFO: compiled from: PromotionExitDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/hive/promotion/PromotionExitDialog$PromotionExitDialogListener;", "", "onDialogShow", "", "onExit", "onCancel", "onMoreGames", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PromotionExitDialogListener {
        void onCancel();

        void onDialogShow();

        void onExit();

        void onMoreGames();
    }

    public PromotionExitDialog(Activity activity, MoreGames.MoreGamesResponse responseApiMoreGames, PromotionExitDialogListener promotionExitDialogListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(responseApiMoreGames, "responseApiMoreGames");
        this.responseApiMoreGames = responseApiMoreGames;
        this.listener = promotionExitDialogListener;
        this.exitDialog = createDialog(activity);
    }

    private final PromotionPopupDialog createDialog(final Activity activity) {
        Activity activity2 = activity;
        PromotionPopupDialog.Builder builder = new PromotionPopupDialog.Builder(activity2);
        builder.setTitle(this.responseApiMoreGames.getLabelMsg());
        builder.setCloseButton(this.responseApiMoreGames.getLabelCancel(), new View.OnClickListener() { // from class: com.hive.promotion.PromotionExitDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromotionExitDialog.createDialog$lambda$0(this.f$0, view);
            }
        });
        if (!Configuration.INSTANCE.getAgeGateU13()) {
            builder.setSubButton(this.responseApiMoreGames.getLabelClose(), new View.OnClickListener() { // from class: com.hive.promotion.PromotionExitDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PromotionExitDialog.createDialog$lambda$1(this.f$0, view);
                }
            });
            builder.setMainButton(this.responseApiMoreGames.getLabelMore(), new View.OnClickListener() { // from class: com.hive.promotion.PromotionExitDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PromotionExitDialog.createDialog$lambda$3(this.f$0, activity, view);
                }
            });
        } else {
            builder.setMainButton(this.responseApiMoreGames.getLabelClose(), new View.OnClickListener() { // from class: com.hive.promotion.PromotionExitDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PromotionExitDialog.createDialog$lambda$4(this.f$0, view);
                }
            });
        }
        PromotionPopupDialog promotionPopupDialogCreate = builder.create();
        promotionPopupDialogCreate.setCancelable(true);
        promotionPopupDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.hive.promotion.PromotionExitDialog$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                PromotionExitDialog.createDialog$lambda$5(this.f$0, dialogInterface);
            }
        });
        promotionPopupDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.hive.promotion.PromotionExitDialog$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                PromotionExitDialog.createDialog$lambda$6(this.f$0, dialogInterface);
            }
        });
        View viewFindViewById = promotionPopupDialogCreate.findViewById(Resource.INSTANCE.getViewId(activity2, "hive_default_popup_dialog_title"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.hive.ui.view.HiveTextView");
        HiveTextView hiveTextView = (HiveTextView) viewFindViewById;
        hiveTextView.setMaxLines(3);
        hiveTextView.setGravity(17);
        hiveTextView.setForceLineBreak(true);
        ViewGroup.LayoutParams layoutParams = hiveTextView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(0);
        return promotionPopupDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$0(PromotionExitDialog promotionExitDialog, View view) {
        PromotionExitDialogListener promotionExitDialogListener = promotionExitDialog.listener;
        if (promotionExitDialogListener != null) {
            promotionExitDialogListener.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$1(PromotionExitDialog promotionExitDialog, View view) {
        PromotionExitDialogListener promotionExitDialogListener = promotionExitDialog.listener;
        if (promotionExitDialogListener != null) {
            promotionExitDialogListener.onExit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$3(PromotionExitDialog promotionExitDialog, Activity activity, View view) {
        if (!StringsKt.isBlank(promotionExitDialog.responseApiMoreGames.getUrl())) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(promotionExitDialog.responseApiMoreGames.getUrl()));
            intent.setFlags(268435456);
            ExtentionsKt.startActivityCatching(activity, intent, new Function1() { // from class: com.hive.promotion.PromotionExitDialog$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionExitDialog.createDialog$lambda$3$lambda$2((Throwable) obj);
                }
            });
        }
        PromotionExitDialogListener promotionExitDialogListener = promotionExitDialog.listener;
        if (promotionExitDialogListener != null) {
            promotionExitDialogListener.onMoreGames();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDialog$lambda$3$lambda$2(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.printStackTrace();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$4(PromotionExitDialog promotionExitDialog, View view) {
        PromotionExitDialogListener promotionExitDialogListener = promotionExitDialog.listener;
        if (promotionExitDialogListener != null) {
            promotionExitDialogListener.onExit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$5(PromotionExitDialog promotionExitDialog, DialogInterface dialogInterface) {
        PromotionExitDialogListener promotionExitDialogListener = promotionExitDialog.listener;
        if (promotionExitDialogListener != null) {
            promotionExitDialogListener.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$6(PromotionExitDialog promotionExitDialog, DialogInterface dialogInterface) {
        PromotionExitDialogListener promotionExitDialogListener = promotionExitDialog.listener;
        if (promotionExitDialogListener != null) {
            promotionExitDialogListener.onDialogShow();
        }
    }

    public final void show() {
        if (this.exitDialog.isShowing()) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.PromotionExitDialog$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                PromotionExitDialog.show$lambda$7(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$7(PromotionExitDialog promotionExitDialog) {
        promotionExitDialog.exitDialog.show();
    }

    public final void onConfigurationChanged(Activity activity, android.content.res.Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.exitDialog.dismiss();
        PromotionPopupDialog promotionPopupDialogCreateDialog = createDialog(activity);
        this.exitDialog = promotionPopupDialogCreateDialog;
        promotionPopupDialogCreateDialog.setOnShowListener(null);
        show();
    }

    public final void cancel() {
        this.exitDialog.cancel();
    }

    public final void dismiss() {
        this.exitDialog.dismiss();
    }
}
