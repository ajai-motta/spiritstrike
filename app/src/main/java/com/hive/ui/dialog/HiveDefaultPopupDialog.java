package com.hive.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ui.Resource;
import com.hive.ui.dialog.HivePopupDialog;
import com.hive.ui.effect.TouchEffectKt;
import com.hive.ui.view.HiveAnimationButton;
import com.hive.ui.view.HiveTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveDefaultPopupDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/hive/ui/dialog/HiveDefaultPopupDialog;", "Lcom/hive/ui/dialog/HivePopupDialog;", "P", "Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams;", "<init>", "(Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams;)V", "hivePopupDialogLoadLayout", "", "hivePopupDialogButtonSetting", "Builder", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveDefaultPopupDialog extends HivePopupDialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveDefaultPopupDialog(HivePopupDialog.HivePopupDialogParams P) {
        super(P);
        Intrinsics.checkNotNullParameter(P, "P");
    }

    /* JADX INFO: compiled from: HiveDefaultPopupDialog.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/hive/ui/dialog/HiveDefaultPopupDialog$Builder;", "Lcom/hive/ui/dialog/HivePopupDialog$Builder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "create", "Lcom/hive/ui/dialog/HiveDefaultPopupDialog;", "setHtmlMessage", "message", "", "setCancelListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/DialogInterface$OnCancelListener;", "setDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder extends HivePopupDialog.Builder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // com.hive.ui.dialog.HivePopupDialog.Builder
        public HiveDefaultPopupDialog create() {
            HiveDefaultPopupDialog hiveDefaultPopupDialog = new HiveDefaultPopupDialog(getHivePopupDialogParams());
            hiveDefaultPopupDialog.hivePopupDialogLoadLayout(getHivePopupDialogParams());
            hiveDefaultPopupDialog.hivePopupDialogButtonSetting(getHivePopupDialogParams());
            return hiveDefaultPopupDialog;
        }

        public final Builder setHtmlMessage(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            if (Build.VERSION.SDK_INT < 24) {
                Spanned spannedFromHtml = Html.fromHtml(message);
                Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
                HivePopupDialog.Builder message2 = setMessage(spannedFromHtml);
                Intrinsics.checkNotNull(message2, "null cannot be cast to non-null type com.hive.ui.dialog.HiveDefaultPopupDialog.Builder");
                return (Builder) message2;
            }
            Spanned spannedFromHtml2 = Html.fromHtml(message, 0);
            Intrinsics.checkNotNullExpressionValue(spannedFromHtml2, "fromHtml(...)");
            HivePopupDialog.Builder message3 = setMessage(spannedFromHtml2);
            Intrinsics.checkNotNull(message3, "null cannot be cast to non-null type com.hive.ui.dialog.HiveDefaultPopupDialog.Builder");
            return (Builder) message3;
        }

        public final Builder setCancelListener(DialogInterface.OnCancelListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getHivePopupDialogParams().setCancelListener(listener);
            return this;
        }

        public final Builder setDismissListener(DialogInterface.OnDismissListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getHivePopupDialogParams().setDismissListener(listener);
            return this;
        }
    }

    @Override // com.hive.ui.dialog.HivePopupDialog
    public void hivePopupDialogLoadLayout(HivePopupDialog.HivePopupDialogParams P) {
        Intrinsics.checkNotNullParameter(P, "P");
        setContentView(Resource.INSTANCE.getLayoutId(P.getContext(), "hive_default_popup"));
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
        HiveTextView hiveTextView = viewFindViewById instanceof HiveTextView ? (HiveTextView) viewFindViewById : null;
        View viewFindViewById2 = findViewById(Resource.INSTANCE.getViewId(P.getContext(), "hive_default_popup_dialog_message"));
        TextView textView = viewFindViewById2 instanceof TextView ? (TextView) viewFindViewById2 : null;
        View viewFindViewById3 = findViewById(Resource.INSTANCE.getViewId(P.getContext(), "hive_default_popup_dialog_sub_button"));
        TextView textView2 = viewFindViewById3 instanceof TextView ? (TextView) viewFindViewById3 : null;
        View viewFindViewById4 = findViewById(Resource.INSTANCE.getViewId(P.getContext(), "hive_default_popup_dialog_main_button"));
        final TextView textView3 = viewFindViewById4 instanceof TextView ? (TextView) viewFindViewById4 : null;
        final HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) findViewById(Resource.INSTANCE.getViewId(P.getContext(), "hive_default_popup_dialog_close"));
        if (TextUtils.isEmpty(P.getTitle())) {
            if (hiveTextView != null) {
                hiveTextView.setVisibility(8);
            }
        } else if (hiveTextView != null) {
            hiveTextView.setText(P.getTitle());
        }
        if (TextUtils.isEmpty(P.getMessage())) {
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else if (textView != null) {
            textView.setText(P.getMessage());
        }
        if (!TextUtils.isEmpty(P.getSubButtonText()) && textView2 != null) {
            textView2.setText(P.getSubButtonText());
        }
        if (!TextUtils.isEmpty(P.getMainButtonText()) && textView3 != null) {
            textView3.setText(P.getMainButtonText());
        }
        if (P.getCloseButtonListener() == null && hiveAnimationButton != null) {
            hiveAnimationButton.setVisibility(8);
        }
        final TextView textView4 = textView2;
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.hive.ui.dialog.HiveDefaultPopupDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HiveDefaultPopupDialog.hivePopupDialogButtonSetting$lambda$1(textView4, P, textView3, hiveAnimationButton, this, view);
            }
        };
        if (textView2 != null) {
            TouchEffectKt.setTouchEffect(textView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : Color.argb(117, 255, 255, 255), (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.ui.dialog.HiveDefaultPopupDialog$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HiveDefaultPopupDialog.hivePopupDialogButtonSetting$lambda$2(onClickListener, (View) obj);
                }
            } : null);
        }
        if (textView3 != null) {
            TouchEffectKt.setTouchEffect(textView3, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.ui.dialog.HiveDefaultPopupDialog$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HiveDefaultPopupDialog.hivePopupDialogButtonSetting$lambda$3(onClickListener, (View) obj);
                }
            } : null);
        }
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.ui.dialog.HiveDefaultPopupDialog.hivePopupDialogButtonSetting.3
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
    public static final void hivePopupDialogButtonSetting$lambda$1(final TextView textView, final HivePopupDialog.HivePopupDialogParams hivePopupDialogParams, final TextView textView2, final HiveAnimationButton hiveAnimationButton, final HiveDefaultPopupDialog hiveDefaultPopupDialog, final View view) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.ui.dialog.HiveDefaultPopupDialog$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                HiveDefaultPopupDialog.hivePopupDialogButtonSetting$lambda$1$lambda$0(textView, view, hivePopupDialogParams, textView2, hiveAnimationButton, hiveDefaultPopupDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hivePopupDialogButtonSetting$lambda$1$lambda$0(TextView textView, View view, HivePopupDialog.HivePopupDialogParams hivePopupDialogParams, TextView textView2, HiveAnimationButton hiveAnimationButton, HiveDefaultPopupDialog hiveDefaultPopupDialog) {
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
        hiveDefaultPopupDialog.dismiss();
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
