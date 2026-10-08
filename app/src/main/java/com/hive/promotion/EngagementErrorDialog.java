package com.hive.promotion;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ui.Resource;
import com.hive.ui.dialog.HiveDefaultPopupDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EngagementErrorDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/hive/promotion/EngagementErrorDialog;", "", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/promotion/EngagementErrorDialog$EngagementErrorDialogListener;", "<init>", "(Landroid/app/Activity;Lcom/hive/promotion/EngagementErrorDialog$EngagementErrorDialogListener;)V", "engagementErrorDialog", "Lcom/hive/ui/dialog/HiveDefaultPopupDialog;", "textMessage", "", "closeMessage", "createDialog", "show", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "dismiss", "EngagementErrorDialogListener", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EngagementErrorDialog {
    private String closeMessage;
    private HiveDefaultPopupDialog engagementErrorDialog;
    private final EngagementErrorDialogListener listener;
    private String textMessage;

    /* JADX INFO: compiled from: EngagementErrorDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/hive/promotion/EngagementErrorDialog$EngagementErrorDialogListener;", "", "onClose", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface EngagementErrorDialogListener {
        void onClose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$1(View view) {
    }

    public EngagementErrorDialog(Activity activity, EngagementErrorDialogListener engagementErrorDialogListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.listener = engagementErrorDialogListener;
        String string = Resource.INSTANCE.getString("hive_promotion_ue_errordialog_message");
        this.textMessage = string == null ? "" : string;
        String string2 = Resource.INSTANCE.getString("hive_permission_ok");
        this.closeMessage = string2 != null ? string2 : "";
        this.engagementErrorDialog = createDialog(activity);
    }

    private final HiveDefaultPopupDialog createDialog(Activity activity) {
        HiveDefaultPopupDialog.Builder builder = new HiveDefaultPopupDialog.Builder(activity);
        builder.setMessage(this.textMessage);
        builder.setCloseButton("", new View.OnClickListener() { // from class: com.hive.promotion.EngagementErrorDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EngagementErrorDialog.createDialog$lambda$0(view);
            }
        });
        builder.setMainButton(this.closeMessage, new View.OnClickListener() { // from class: com.hive.promotion.EngagementErrorDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EngagementErrorDialog.createDialog$lambda$1(view);
            }
        });
        builder.setDismissListener(new DialogInterface.OnDismissListener() { // from class: com.hive.promotion.EngagementErrorDialog$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                EngagementErrorDialog.createDialog$lambda$2(this.f$0, dialogInterface);
            }
        });
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$2(EngagementErrorDialog engagementErrorDialog, DialogInterface dialogInterface) {
        EngagementErrorDialogListener engagementErrorDialogListener = engagementErrorDialog.listener;
        if (engagementErrorDialogListener != null) {
            engagementErrorDialogListener.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$3(EngagementErrorDialog engagementErrorDialog) {
        engagementErrorDialog.engagementErrorDialog.show();
    }

    public final boolean show() {
        return new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.EngagementErrorDialog$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                EngagementErrorDialog.show$lambda$3(this.f$0);
            }
        });
    }

    public final void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.engagementErrorDialog.setOnDismissListener(null);
        this.engagementErrorDialog.dismiss();
        HiveDefaultPopupDialog hiveDefaultPopupDialogCreateDialog = createDialog(activity);
        this.engagementErrorDialog = hiveDefaultPopupDialogCreateDialog;
        hiveDefaultPopupDialogCreateDialog.show();
    }

    public final void dismiss() {
        this.engagementErrorDialog.dismiss();
    }
}
