package com.hive.auth;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
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
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/hive/auth/AuthMaintenancePopupDialog;", "Lcom/hive/ui/dialog/HivePopupDialog;", "P", "Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams;", "<init>", "(Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams;)V", "timerTextView", "Landroid/widget/TextView;", "getTimerTextView", "()Landroid/widget/TextView;", "setTimerTextView", "(Landroid/widget/TextView;)V", "hivePopupDialogLoadLayout", "", "hivePopupDialogButtonSetting", "authMaintenanceTimerSetting", "setRemainingTime", "remainingTime", "", "calTime", "", "remain_time", "Builder", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthMaintenancePopupDialog extends HivePopupDialog {
    public TextView timerTextView;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/hive/auth/AuthMaintenancePopupDialog$Builder;", "Lcom/hive/ui/dialog/HivePopupDialog$Builder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "create", "Lcom/hive/auth/AuthMaintenancePopupDialog;", "setTimer", "remainingTime", "", "setCancelListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/DialogInterface$OnCancelListener;", "setDissmissListener", "Landroid/content/DialogInterface$OnDismissListener;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder extends HivePopupDialog.Builder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public final Builder setCancelListener(DialogInterface.OnCancelListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getHivePopupDialogParams().setCancelListener(listener);
            return this;
        }

        public final Builder setDissmissListener(DialogInterface.OnDismissListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getHivePopupDialogParams().setDismissListener(listener);
            return this;
        }

        public final Builder setTimer(int remainingTime) {
            getHivePopupDialogParams().setRemainingTime(remainingTime);
            return this;
        }

        @Override // com.hive.ui.dialog.HivePopupDialog.Builder
        public AuthMaintenancePopupDialog create() {
            AuthMaintenancePopupDialog authMaintenancePopupDialog = new AuthMaintenancePopupDialog(getHivePopupDialogParams());
            authMaintenancePopupDialog.hivePopupDialogLoadLayout(getHivePopupDialogParams());
            authMaintenancePopupDialog.hivePopupDialogButtonSetting(getHivePopupDialogParams());
            authMaintenancePopupDialog.authMaintenanceTimerSetting(getHivePopupDialogParams());
            return authMaintenancePopupDialog;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthMaintenancePopupDialog(HivePopupDialog.HivePopupDialogParams P) {
        super(P);
        Intrinsics.checkNotNullParameter(P, "P");
    }

    private final String calTime(int remain_time) {
        String str;
        String str2;
        int i = (remain_time / 60) / 60;
        int i2 = remain_time - (i * 3600);
        int i3 = i2 / 60;
        int i4 = i2 - (i3 * 60);
        if (i < 10) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO + i + AbstractJsonLexerKt.COLON;
        } else {
            str = "" + i + AbstractJsonLexerKt.COLON;
        }
        if (i3 < 10) {
            str2 = str + '0' + i3 + AbstractJsonLexerKt.COLON;
        } else {
            str2 = str + i3 + AbstractJsonLexerKt.COLON;
        }
        if (i4 >= 10) {
            return str2 + i4;
        }
        return str2 + '0' + i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hivePopupDialogButtonSetting$lambda$1(final TextView textView, final HivePopupDialog.HivePopupDialogParams hivePopupDialogParams, final TextView textView2, final HiveAnimationButton hiveAnimationButton, final AuthMaintenancePopupDialog authMaintenancePopupDialog, final View view) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthMaintenancePopupDialog$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AuthMaintenancePopupDialog.hivePopupDialogButtonSetting$lambda$1$lambda$0(textView, view, hivePopupDialogParams, textView2, hiveAnimationButton, authMaintenancePopupDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hivePopupDialogButtonSetting$lambda$1$lambda$0(TextView textView, View view, HivePopupDialog.HivePopupDialogParams hivePopupDialogParams, TextView textView2, HiveAnimationButton hiveAnimationButton, AuthMaintenancePopupDialog authMaintenancePopupDialog) {
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
        authMaintenancePopupDialog.dismiss();
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

    public final void authMaintenanceTimerSetting(HivePopupDialog.HivePopupDialogParams P) {
        Intrinsics.checkNotNullParameter(P, "P");
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(P.getContext(), "hive_default_popup_dialog_timer"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        setTimerTextView((TextView) viewFindViewById);
        if (P.getRemainingTime() <= 0) {
            getTimerTextView().setVisibility(8);
        } else {
            getTimerTextView().setText(calTime(P.getRemainingTime()));
            getTimerTextView().setVisibility(0);
        }
    }

    public final TextView getTimerTextView() {
        TextView textView = this.timerTextView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("timerTextView");
        return null;
    }

    @Override // com.hive.ui.dialog.HivePopupDialog
    public void hivePopupDialogButtonSetting(final HivePopupDialog.HivePopupDialogParams P) {
        Intrinsics.checkNotNullParameter(P, "P");
        Resource resource = Resource.INSTANCE;
        View viewFindViewById = findViewById(resource.getViewId(P.getContext(), "hive_default_popup_dialog_title"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.hive.ui.view.HiveTextView");
        HiveTextView hiveTextView = (HiveTextView) viewFindViewById;
        View viewFindViewById2 = findViewById(resource.getViewId(P.getContext(), "hive_default_popup_dialog_message"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(resource.getViewId(P.getContext(), "hive_default_popup_dialog_sub_button"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView2 = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(resource.getViewId(P.getContext(), "hive_default_popup_dialog_main_button"));
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView3 = (TextView) viewFindViewById4;
        final HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) findViewById(resource.getViewId(P.getContext(), "hive_default_popup_dialog_close"));
        CharSequence title = P.getTitle();
        if (title == null || StringsKt.isBlank(title)) {
            hiveTextView.setVisibility(8);
        } else {
            hiveTextView.setText(P.getTitle());
        }
        CharSequence message = P.getMessage();
        if (message == null || StringsKt.isBlank(message)) {
            textView.setVisibility(8);
        } else if (P.getDialogType() == HivePopupDialog.HivePopupDialogParams.NativeDialogType.BLACKLIST && StringsKt.contains$default((CharSequence) String.valueOf(P.getMessage()), (CharSequence) "</font>", false, 2, (Object) null)) {
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(String.valueOf(P.getMessage()), "face='hive-font-regular'", "face='sans-serif'", false, 4, (Object) null), "face='hive-font-medium'", "face='sans-serif-medium'", false, 4, (Object) null), "face='hive-font-light'", "face='sans-serif-light'", false, 4, (Object) null);
            if (Build.VERSION.SDK_INT >= 24) {
                textView.setText(Html.fromHtml(strReplace$default, 0));
            } else {
                textView.setText(Html.fromHtml(strReplace$default));
            }
            textView.setLineSpacing(TypedValue.applyDimension(2, 2.0f, P.getContext().getResources().getDisplayMetrics()), 1.0f);
        } else {
            textView.setText(P.getMessage());
        }
        if (P.getSubButtonText() != null && (!StringsKt.isBlank(r0))) {
            textView2.setText(P.getSubButtonText());
        }
        if (P.getMainButtonText() != null && (!StringsKt.isBlank(r0))) {
            textView3.setText(P.getMainButtonText());
        }
        if (P.getCloseButtonListener() == null) {
            hiveAnimationButton.setVisibility(8);
        }
        final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.hive.auth.AuthMaintenancePopupDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthMaintenancePopupDialog.hivePopupDialogButtonSetting$lambda$1(textView2, P, textView3, hiveAnimationButton, this, view);
            }
        };
        TouchEffectKt.setTouchEffect(textView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : Color.argb(117, 255, 255, 255), (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.auth.AuthMaintenancePopupDialog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthMaintenancePopupDialog.hivePopupDialogButtonSetting$lambda$2(onClickListener, (View) obj);
            }
        } : null);
        TouchEffectKt.setTouchEffect(textView3, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.auth.AuthMaintenancePopupDialog$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthMaintenancePopupDialog.hivePopupDialogButtonSetting$lambda$3(onClickListener, (View) obj);
            }
        } : null);
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.auth.AuthMaintenancePopupDialog.hivePopupDialogButtonSetting.3
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

    @Override // com.hive.ui.dialog.HivePopupDialog
    public void hivePopupDialogLoadLayout(HivePopupDialog.HivePopupDialogParams P) {
        Intrinsics.checkNotNullParameter(P, "P");
        Resource resource = Resource.INSTANCE;
        setContentView(resource.getLayoutId(P.getContext(), "hive_default_popup"));
        if (TextUtils.isEmpty(P.getSubButtonText())) {
            findViewById(resource.getViewId(P.getContext(), "hive_default_popup_dialog_sub_button")).setVisibility(8);
        }
        if (TextUtils.isEmpty(P.getMainButtonText())) {
            findViewById(resource.getViewId(P.getContext(), "hive_default_popup_dialog_main_button")).setVisibility(8);
        }
    }

    public final void setRemainingTime(int remainingTime) {
        if (this.timerTextView != null) {
            getTimerTextView().setText(calTime(remainingTime));
        }
    }

    public final void setTimerTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.timerTextView = textView;
    }
}
