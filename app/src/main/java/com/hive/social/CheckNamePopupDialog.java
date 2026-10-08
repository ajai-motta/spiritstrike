package com.hive.social;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ui.Resource;
import com.hive.ui.dialog.HiveDefaultPopupDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/hive/social/CheckNamePopupDialog;", "", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/social/CheckNamePopupDialog$CheckNameListener;", "<init>", "(Landroid/content/Context;Lcom/hive/social/CheckNamePopupDialog$CheckNameListener;)V", "checkNamePopupDialog", "Lcom/hive/ui/dialog/HiveDefaultPopupDialog;", "message", "", "yesButtonMessage", "noButtonMessage", "show", "", "cancel", "dismiss", "CheckNameListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckNamePopupDialog {
    private final HiveDefaultPopupDialog checkNamePopupDialog;
    private final String message;
    private final String noButtonMessage;
    private final String yesButtonMessage;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/hive/social/CheckNamePopupDialog$CheckNameListener;", "", "onExit", "", "onRetry", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface CheckNameListener {
        void onExit();

        void onRetry();
    }

    public CheckNamePopupDialog(Context context, final CheckNameListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Resource resource = Resource.INSTANCE;
        String string = resource.getString("hive_social_check_name_dialog_message");
        string = string == null ? "" : string;
        this.message = string;
        String string2 = resource.getString("hive_social_check_name_dialog_yes_btn_message");
        string2 = string2 == null ? "" : string2;
        this.yesButtonMessage = string2;
        String string3 = resource.getString("hive_social_check_name_dialog_no_btn_message");
        String str = string3 != null ? string3 : "";
        this.noButtonMessage = str;
        HiveDefaultPopupDialog.Builder builder = new HiveDefaultPopupDialog.Builder(context);
        builder.setMessage(string);
        builder.setMainButton(string2, new View.OnClickListener() { // from class: com.hive.social.CheckNamePopupDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                listener.onRetry();
            }
        });
        builder.setSubButton(str, new View.OnClickListener() { // from class: com.hive.social.CheckNamePopupDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                listener.onExit();
            }
        });
        builder.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.hive.social.CheckNamePopupDialog$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                listener.onRetry();
            }
        });
        this.checkNamePopupDialog = builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancel$lambda$5(CheckNamePopupDialog checkNamePopupDialog) {
        checkNamePopupDialog.checkNamePopupDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$6(CheckNamePopupDialog checkNamePopupDialog) {
        checkNamePopupDialog.checkNamePopupDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$4(CheckNamePopupDialog checkNamePopupDialog) {
        checkNamePopupDialog.checkNamePopupDialog.show();
    }

    public final boolean cancel() {
        return new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.social.CheckNamePopupDialog$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                CheckNamePopupDialog.cancel$lambda$5(this.f$0);
            }
        });
    }

    public final boolean dismiss() {
        return new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.social.CheckNamePopupDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CheckNamePopupDialog.dismiss$lambda$6(this.f$0);
            }
        });
    }

    public final boolean show() {
        return new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.social.CheckNamePopupDialog$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                CheckNamePopupDialog.show$lambda$4(this.f$0);
            }
        });
    }
}
