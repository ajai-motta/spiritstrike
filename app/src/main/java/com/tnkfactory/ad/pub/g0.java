package com.tnkfactory.ad.pub;

import android.app.AlertDialog;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

/* JADX INFO: loaded from: classes6.dex */
public final class g0 extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Context context = webView.getContext();
        d0 d0Var = new d0(jsResult);
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, android.R.style.Theme.Holo.Light.Dialog.NoActionBar));
            builder.setTitle((CharSequence) null);
            builder.setMessage(str2);
            builder.setPositiveButton(r2.a().f3186a, d0Var);
            builder.setCancelable(false);
            builder.show();
        } catch (Throwable unused) {
            Toast.makeText(context, str2, 1).show();
            d0Var.f3120a.confirm();
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        Context context = webView.getContext();
        e0 e0Var = new e0(jsResult);
        f0 f0Var = new f0(jsResult);
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, android.R.style.Theme.Holo.Light.Dialog.NoActionBar));
            builder.setTitle((CharSequence) null);
            builder.setMessage(str2);
            String str3 = r2.a().f3186a;
            String str4 = r2.a().b;
            builder.setPositiveButton(str3, e0Var);
            builder.setNegativeButton(str4, f0Var);
            builder.setCancelable(false);
            builder.show();
        } catch (Throwable unused) {
            Toast.makeText(context, str2, 1).show();
            e0Var.f3123a.confirm();
        }
        return true;
    }
}
