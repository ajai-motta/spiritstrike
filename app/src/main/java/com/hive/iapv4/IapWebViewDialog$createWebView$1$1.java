package com.hive.iapv4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IapWebViewDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/hive/iapv4/IapWebViewDialog$createWebView$1$1", "Landroid/webkit/WebChromeClient;", "onJsAlert", "", "view", "Landroid/webkit/WebView;", "url", "", "message", "result", "Landroid/webkit/JsResult;", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IapWebViewDialog$createWebView$1$1 extends WebChromeClient {
    final /* synthetic */ IapWebViewDialog this$0;

    IapWebViewDialog$createWebView$1$1(IapWebViewDialog iapWebViewDialog) {
        this.this$0 = iapWebViewDialog;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(result, "result");
        new AlertDialog.Builder(this.this$0.getActivity()).setTitle("AlertDialog").setMessage(message).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.hive.iapv4.IapWebViewDialog$createWebView$1$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                IapWebViewDialog$createWebView$1$1.onJsAlert$lambda$0(result, dialogInterface, i);
            }
        }).setCancelable(false).create().show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onJsAlert$lambda$0(JsResult jsResult, DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        jsResult.confirm();
    }
}
