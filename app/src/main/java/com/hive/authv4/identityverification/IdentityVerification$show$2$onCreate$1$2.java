package com.hive.authv4.identityverification;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IdentityVerification.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/hive/authv4/identityverification/IdentityVerification$show$2$onCreate$1$2", "Landroid/webkit/WebChromeClient;", "onJsAlert", "", "view", "Landroid/webkit/WebView;", "url", "", "message", "result", "Landroid/webkit/JsResult;", "hive-authv4-identity-verification_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IdentityVerification$show$2$onCreate$1$2 extends WebChromeClient {
    final /* synthetic */ Activity $activity;

    IdentityVerification$show$2$onCreate$1$2(Activity activity) {
        this.$activity = activity;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(result, "result");
        LoggerImpl.INSTANCE.dL("[IdentityVerification] onJsAlert: " + message);
        LoggerImpl.INSTANCE.dR("[IdentityVerification] onJsAlert");
        new AlertDialog.Builder(this.$activity).setMessage(message).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.hive.authv4.identityverification.IdentityVerification$show$2$onCreate$1$2$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                result.confirm();
            }
        }).setCancelable(false).create().show();
        return true;
    }
}
