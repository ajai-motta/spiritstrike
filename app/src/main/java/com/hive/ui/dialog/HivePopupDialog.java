package com.hive.ui.dialog;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ui.Util;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HivePopupDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002\f\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/hive/ui/dialog/HivePopupDialog;", "Landroid/app/Dialog;", "P", "Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams;", "<init>", "(Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams;)V", "hivePopupDialogLoadLayout", "", "hivePopupDialogButtonSetting", "onWindowFocusChanged", "hasFocus", "", "HivePopupDialogParams", "Builder", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class HivePopupDialog extends Dialog {
    public abstract void hivePopupDialogButtonSetting(HivePopupDialogParams P);

    public abstract void hivePopupDialogLoadLayout(HivePopupDialogParams P);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HivePopupDialog(HivePopupDialogParams P) {
        super(P.getContext(), R.style.Theme.Translucent.NoTitleBar.Fullscreen);
        Intrinsics.checkNotNullParameter(P, "P");
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.addFlags(2);
        }
        Window window3 = getWindow();
        WindowManager.LayoutParams attributes = window3 != null ? window3.getAttributes() : null;
        if (attributes != null) {
            attributes.dimAmount = 0.8f;
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.setAttributes(attributes);
        }
    }

    /* JADX INFO: compiled from: HivePopupDialog.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001?B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001c\u0010*\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "title", "", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "message", "getMessage", "setMessage", "remainingTime", "", "getRemainingTime", "()I", "setRemainingTime", "(I)V", "subButtonText", "getSubButtonText", "setSubButtonText", "mainButtonText", "getMainButtonText", "setMainButtonText", "button3Text", "getButton3Text", "setButton3Text", "subButtonListener", "Landroid/view/View$OnClickListener;", "getSubButtonListener", "()Landroid/view/View$OnClickListener;", "setSubButtonListener", "(Landroid/view/View$OnClickListener;)V", "mainButtonListener", "getMainButtonListener", "setMainButtonListener", "closeButtonListener", "getCloseButtonListener", "setCloseButtonListener", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "dialogType", "Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams$NativeDialogType;", "getDialogType", "()Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams$NativeDialogType;", "setDialogType", "(Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams$NativeDialogType;)V", "NativeDialogType", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HivePopupDialogParams {
        private CharSequence button3Text;
        private DialogInterface.OnCancelListener cancelListener;
        private View.OnClickListener closeButtonListener;
        private Context context;
        private NativeDialogType dialogType;
        private DialogInterface.OnDismissListener dismissListener;
        private View.OnClickListener mainButtonListener;
        private CharSequence mainButtonText;
        private CharSequence message;
        private int remainingTime;
        private View.OnClickListener subButtonListener;
        private CharSequence subButtonText;
        private CharSequence title;

        public HivePopupDialogParams(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.remainingTime = -1;
            this.dialogType = NativeDialogType.DEFAULT;
        }

        public final Context getContext() {
            return this.context;
        }

        public final void setContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.context = context;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final void setTitle(CharSequence charSequence) {
            this.title = charSequence;
        }

        public final CharSequence getMessage() {
            return this.message;
        }

        public final void setMessage(CharSequence charSequence) {
            this.message = charSequence;
        }

        public final int getRemainingTime() {
            return this.remainingTime;
        }

        public final void setRemainingTime(int i) {
            this.remainingTime = i;
        }

        public final CharSequence getSubButtonText() {
            return this.subButtonText;
        }

        public final void setSubButtonText(CharSequence charSequence) {
            this.subButtonText = charSequence;
        }

        public final CharSequence getMainButtonText() {
            return this.mainButtonText;
        }

        public final void setMainButtonText(CharSequence charSequence) {
            this.mainButtonText = charSequence;
        }

        public final CharSequence getButton3Text() {
            return this.button3Text;
        }

        public final void setButton3Text(CharSequence charSequence) {
            this.button3Text = charSequence;
        }

        public final View.OnClickListener getSubButtonListener() {
            return this.subButtonListener;
        }

        public final void setSubButtonListener(View.OnClickListener onClickListener) {
            this.subButtonListener = onClickListener;
        }

        public final View.OnClickListener getMainButtonListener() {
            return this.mainButtonListener;
        }

        public final void setMainButtonListener(View.OnClickListener onClickListener) {
            this.mainButtonListener = onClickListener;
        }

        public final View.OnClickListener getCloseButtonListener() {
            return this.closeButtonListener;
        }

        public final void setCloseButtonListener(View.OnClickListener onClickListener) {
            this.closeButtonListener = onClickListener;
        }

        public final DialogInterface.OnCancelListener getCancelListener() {
            return this.cancelListener;
        }

        public final void setCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.cancelListener = onCancelListener;
        }

        public final DialogInterface.OnDismissListener getDismissListener() {
            return this.dismissListener;
        }

        public final void setDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.dismissListener = onDismissListener;
        }

        public final NativeDialogType getDialogType() {
            return this.dialogType;
        }

        public final void setDialogType(NativeDialogType nativeDialogType) {
            Intrinsics.checkNotNullParameter(nativeDialogType, "<set-?>");
            this.dialogType = nativeDialogType;
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: HivePopupDialog.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0011"}, d2 = {"Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams$NativeDialogType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "DEFAULT", "BLACKLIST", "PROMOTION_REVIEW", "stringValue", "", "getStringValue", "()Ljava/lang/String;", k.M, "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class NativeDialogType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ NativeDialogType[] $VALUES;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE;
            private final int value;
            public static final NativeDialogType UNDEFINED = new NativeDialogType("UNDEFINED", 0, -1);
            public static final NativeDialogType DEFAULT = new NativeDialogType("DEFAULT", 1, 0);
            public static final NativeDialogType BLACKLIST = new NativeDialogType("BLACKLIST", 2, 1);
            public static final NativeDialogType PROMOTION_REVIEW = new NativeDialogType("PROMOTION_REVIEW", 3, 2);

            private static final /* synthetic */ NativeDialogType[] $values() {
                return new NativeDialogType[]{UNDEFINED, DEFAULT, BLACKLIST, PROMOTION_REVIEW};
            }

            public static EnumEntries<NativeDialogType> getEntries() {
                return $ENTRIES;
            }

            private NativeDialogType(String str, int i, int i2) {
                this.value = i2;
            }

            public final int getValue() {
                return this.value;
            }

            static {
                NativeDialogType[] nativeDialogTypeArr$values = $values();
                $VALUES = nativeDialogTypeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(nativeDialogTypeArr$values);
                INSTANCE = new Companion(null);
            }

            public final String getStringValue() {
                return String.valueOf(this.value);
            }

            /* JADX INFO: compiled from: HivePopupDialog.kt */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams$NativeDialogType$Companion;", "", "<init>", "()V", "findValue", "Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams$NativeDialogType;", "value", "", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final NativeDialogType findValue(int value) {
                    if (value == 0) {
                        return NativeDialogType.DEFAULT;
                    }
                    if (value != 1) {
                        return null;
                    }
                    return NativeDialogType.BLACKLIST;
                }
            }

            public static NativeDialogType valueOf(String str) {
                return (NativeDialogType) Enum.valueOf(NativeDialogType.class, str);
            }

            public static NativeDialogType[] values() {
                return (NativeDialogType[]) $VALUES.clone();
            }
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Util.INSTANCE.hideSystemUI(getWindow());
        }
    }

    /* JADX INFO: compiled from: HivePopupDialog.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H&R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/hive/ui/dialog/HivePopupDialog$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "hivePopupDialogParams", "Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams;", "getHivePopupDialogParams", "()Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams;", "setTitle", "title", "", "setMessage", "message", "setSubButton", "buttonText", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setMainButton", "setCloseButton", "setDialogType", "dialogType", "Lcom/hive/ui/dialog/HivePopupDialog$HivePopupDialogParams$NativeDialogType;", "create", "Lcom/hive/ui/dialog/HivePopupDialog;", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class Builder {
        private final HivePopupDialogParams hivePopupDialogParams;

        public abstract HivePopupDialog create();

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.hivePopupDialogParams = new HivePopupDialogParams(context);
        }

        public final HivePopupDialogParams getHivePopupDialogParams() {
            return this.hivePopupDialogParams;
        }

        public final Builder setTitle(CharSequence title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.hivePopupDialogParams.setTitle(title);
            return this;
        }

        public final Builder setMessage(CharSequence message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.hivePopupDialogParams.setMessage(message);
            return this;
        }

        public final Builder setSubButton(CharSequence buttonText, View.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(buttonText, "buttonText");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.hivePopupDialogParams.setSubButtonText(buttonText);
            this.hivePopupDialogParams.setSubButtonListener(listener);
            return this;
        }

        public final Builder setMainButton(CharSequence buttonText, View.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(buttonText, "buttonText");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.hivePopupDialogParams.setMainButtonText(buttonText);
            this.hivePopupDialogParams.setMainButtonListener(listener);
            return this;
        }

        public final Builder setCloseButton(CharSequence buttonText, View.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(buttonText, "buttonText");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.hivePopupDialogParams.setButton3Text(buttonText);
            this.hivePopupDialogParams.setCloseButtonListener(listener);
            return this;
        }

        public final Builder setDialogType(HivePopupDialogParams.NativeDialogType dialogType) {
            Intrinsics.checkNotNullParameter(dialogType, "dialogType");
            this.hivePopupDialogParams.setDialogType(dialogType);
            return this;
        }
    }
}
