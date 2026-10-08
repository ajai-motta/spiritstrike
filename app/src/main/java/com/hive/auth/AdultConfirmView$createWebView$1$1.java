package com.hive.auth;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/hive/auth/AdultConfirmView$createWebView$1$1", "Landroid/webkit/WebChromeClient;", "onJsAlert", "", "view", "Landroid/webkit/WebView;", "url", "", "message", "result", "Landroid/webkit/JsResult;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdultConfirmView$createWebView$1$1 extends WebChromeClient {
    final /* synthetic */ Activity $activity;

    public AdultConfirmView$createWebView$1$1(Activity activity) {
        this.$activity = activity;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(result, "result");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL(null, "[AdultConfirm] onJsAlert: " + message);
        loggerImpl.dR(null, "[AdultConfirm] onJsAlert");
        new AlertDialog.Builder(this.$activity).setMessage(message).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.hive.auth.AdultConfirmView$createWebView$1$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                result.confirm();
            }
        }).setCancelable(false).create().show();
        return true;
    }
}
