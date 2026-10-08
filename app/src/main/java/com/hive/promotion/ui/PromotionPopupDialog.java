package com.hive.promotion.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.hive.ui.Resource;
import com.hive.ui.dialog.HivePopupDialog;
import com.hive.ui.effect.TouchEffectKt;
import com.hive.ui.view.HiveAnimationButton;
import com.hive.ui.view.HiveTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromotionPopupDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/hive/promotion/ui/PromotionPopupDialog;", "Lcom/hive/ui/dialog/HivePopupDialog;", "P", "Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams;", "<init>", "(Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams;)V", "hivePopupDialogLoadLayout", "", "hivePopupDialogButtonSetting", "Builder", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionPopupDialog extends HivePopupDialog {

    /* JADX INFO: compiled from: PromotionPopupDialog.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HivePopupDialog.HivePopupDialogParams.NativeDialogType.values().length];
            try {
                iArr[HivePopupDialog.HivePopupDialogParams.NativeDialogType.PROMOTION_REVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionPopupDialog(HivePopupDialog.HivePopupDialogParams P) {
        super(P);
        Intrinsics.checkNotNullParameter(P, "P");
    }

    /* JADX INFO: compiled from: PromotionPopupDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/hive/promotion/ui/PromotionPopupDialog$Builder;", "Lcom/hive/ui/dialog/HivePopupDialog$Builder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "create", "Lcom/hive/promotion/ui/PromotionPopupDialog;", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder extends HivePopupDialog.Builder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // com.hive.ui.dialog.HivePopupDialog.Builder
        public PromotionPopupDialog create() {
            PromotionPopupDialog promotionPopupDialog = new PromotionPopupDialog(getHivePopupDialogParams());
            promotionPopupDialog.hivePopupDialogLoadLayout(getHivePopupDialogParams());
            promotionPopupDialog.hivePopupDialogButtonSetting(getHivePopupDialogParams());
            return promotionPopupDialog;
        }
    }

    @Override // com.hive.ui.dialog.HivePopupDialog
    public void hivePopupDialogLoadLayout(HivePopupDialog.HivePopupDialogParams P) {
        Intrinsics.checkNotNullParameter(P, "P");
        if (WhenMappings.$EnumSwitchMapping$0[P.getDialogType().ordinal()] == 1) {
            setContentView(Resource.INSTANCE.getLayoutId(P.getContext(), "hive_promotion_review_popup"));
        } else {
            setContentView(Resource.INSTANCE.getLayoutId(P.getContext(), "hive_default_popup"));
        }
        if (TextUtils.isEmpty(P.getSubButtonText())) {
            findViewById(Resource.INSTANCE.getViewId(P.getContext(), "hive_default_popup_dialog_sub_button")).setVisibility(8);
        }
        if (TextUtils.isEmpty(P.getMainButtonText())) {
            findViewById(Resource.INSTANCE.getViewId(P.getContext(), "hive_default_popup_dialog_main_button")).setVisibility(8);
        }
    }

    @Override // com.hive.ui.dialog.HivePopupDialog
    public void hivePopupDialogButtonSetting(final HivePopupDialog.HivePopupDialogParams P) {
        Intrinsics.checkNotNullParameter(P, "P");
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(P.getContext(), "hive_default_popup_dialog_title"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.hive.ui.view.HiveTextView");
        HiveTextView hiveTextView = (HiveTextView) viewFindViewById;
        View viewFindViewById2 = findViewById(Resource.INSTANCE.getViewId(P.getContext(), "hive_default_popup_dialog_message"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(Resource.INSTANCE.getViewId(P.getContext(), "hive_default_popup_dialog_sub_button"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView2 = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(Resource.INSTANCE.getViewId(P.getContext(), "hive_default_popup_dialog_main_button"));
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView3 = (TextView) viewFindViewById4;
        final HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) findViewById(Resource.INSTANCE.getViewId(P.getContext(), "hive_default_popup_dialog_close"));
        if (TextUtils.isEmpty(P.getTitle())) {
            hiveTextView.setVisibility(8);
        } else {
            hiveTextView.setText(P.getTitle());
        }
        if (TextUtils.isEmpty(P.getMessage())) {
            textView.setVisibility(8);
        } else {
            textView.setText(P.getMessage());
        }
        if (!TextUtils.isEmpty(P.getSubButtonText())) {
            textView2.setText(P.getSubButtonText());
        }
        if (!TextUtils.isEmpty(P.getMainButtonText())) {
            textView3.setText(P.getMainButtonText());
        }
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.hive.promotion.ui.PromotionPopupDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromotionPopupDialog.hivePopupDialogButtonSetting$lambda$1(textView2, P, textView3, hiveAnimationButton, this, view);
            }
        };
        TouchEffectKt.setTouchEffect(textView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : Color.argb(117, 255, 255, 255), (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.PromotionPopupDialog$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionPopupDialog.hivePopupDialogButtonSetting$lambda$2(onClickListener, (View) obj);
            }
        } : null);
        TouchEffectKt.setTouchEffect(textView3, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.PromotionPopupDialog$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionPopupDialog.hivePopupDialogButtonSetting$lambda$3(onClickListener, (View) obj);
            }
        } : null);
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.promotion.ui.PromotionPopupDialog.hivePopupDialogButtonSetting.3
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                onClickListener.onClick(hiveAnimationButton);
            }
        });
        if (P.getCancelListener() != null) {
            setOnCancelListener(P.getCancelListener());
        }
        if (P.getDismissListener() != null) {
            setOnDismissListener(P.getDismissListener());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hivePopupDialogButtonSetting$lambda$1(final TextView textView, final HivePopupDialog.HivePopupDialogParams hivePopupDialogParams, final TextView textView2, final HiveAnimationButton hiveAnimationButton, final PromotionPopupDialog promotionPopupDialog, final View view) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.ui.PromotionPopupDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PromotionPopupDialog.hivePopupDialogButtonSetting$lambda$1$lambda$0(textView, view, hivePopupDialogParams, textView2, hiveAnimationButton, promotionPopupDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hivePopupDialogButtonSetting$lambda$1$lambda$0(TextView textView, View view, HivePopupDialog.HivePopupDialogParams hivePopupDialogParams, TextView textView2, HiveAnimationButton hiveAnimationButton, PromotionPopupDialog promotionPopupDialog) {
        View.OnClickListener closeButtonListener;
        if (textView != null && view.getId() == textView.getId()) {
            View.OnClickListener subButtonListener = hivePopupDialogParams.getSubButtonListener();
            if (subButtonListener != null) {
                subButtonListener.onClick(view);
            }
        } else if (textView2 != null && view.getId() == textView2.getId()) {
            View.OnClickListener mainButtonListener = hivePopupDialogParams.getMainButtonListener();
            if (mainButtonListener != null) {
                mainButtonListener.onClick(view);
            }
        } else if (hiveAnimationButton != null && view.getId() == hiveAnimationButton.getId() && (closeButtonListener = hivePopupDialogParams.getCloseButtonListener()) != null) {
            closeButtonListener.onClick(view);
        }
        promotionPopupDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit hivePopupDialogButtonSetting$lambda$2(View.OnClickListener onClickListener, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        onClickListener.onClick(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit hivePopupDialogButtonSetting$lambda$3(View.OnClickListener onClickListener, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        onClickListener.onClick(it);
        return Unit.INSTANCE;
    }
}
