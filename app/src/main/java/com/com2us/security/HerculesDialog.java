package com.com2us.security;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.unity3d.ads.adplayer.AndroidWebViewClient;

/* JADX INFO: loaded from: classes3.dex */
public class HerculesDialog extends Dialog {
    public static Activity mActivity;
    private static HerculesDialog mDialog;
    private static String mSession;
    private static String mURL;
    private static String mUserID;
    private static String mUserPW;
    private MyWebView mWebView;

    private HerculesDialog() {
        super(mActivity, Build.VERSION.SDK_INT < 30 ? R.style.Theme.Translucent.NoTitleBar : R.style.Theme.Translucent.NoTitleBar.Fullscreen);
        this.mWebView = null;
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT < 30 && getWindow() != null) {
            getWindow().setSoftInputMode(16);
        }
        this.mWebView = new MyWebView(mActivity);
        this.mWebView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addContentView(this.mWebView, new ViewGroup.LayoutParams(-1, -1));
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.addJavascriptInterface(mDialog, "AndroidWebKit");
        this.mWebView.setVerticalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setBackgroundColor(-14145501);
        final String str = loadProp("user-id") + "\n" + loadProp("session");
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.com2us.security.HerculesDialog.1
            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str2, String str3) {
                HerculesDialog.message("The connection to the server failed!\nPlease try again later.");
                HerculesDialog.this.mWebView.loadUrl(AndroidWebViewClient.BLANK_PAGE);
                new Handler().postDelayed(new Runnable() { // from class: com.com2us.security.HerculesDialog.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HerculesDialog.this.mWebView.postUrl(HerculesDialog.mURL + Hercules.mVersion, str.getBytes());
                    }
                }, 4000L);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }
        });
        this.mWebView.postUrl(mURL + Hercules.mVersion, str.getBytes());
    }

    @JavascriptInterface
    public static void setUserInfo(String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        mUserID = str;
        if (str2 == null) {
            str2 = "";
        }
        mUserPW = str2;
        if (str3 == null) {
            str3 = "";
        }
        mSession = str3;
    }

    public static void start(int i) {
        if (i < 1) {
            saveProp("user-id", "");
        }
        if (i < 2) {
            saveProp("session", "");
        }
        mActivity.runOnUiThread(new Runnable() { // from class: com.com2us.security.HerculesDialog.2
            @Override // java.lang.Runnable
            public void run() {
                HerculesDialog unused = HerculesDialog.mDialog = new HerculesDialog();
                HerculesDialog.mDialog.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void message(final String str) {
        mActivity.runOnUiThread(new Runnable() { // from class: com.com2us.security.HerculesDialog.3
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(HerculesDialog.mActivity, str, 0).show();
            }
        });
    }

    private static void close() {
        mActivity.runOnUiThread(new Runnable() { // from class: com.com2us.security.HerculesDialog.4
            @Override // java.lang.Runnable
            public void run() {
                if (HerculesDialog.mDialog != null) {
                    HerculesDialog.mDialog.dismiss();
                    HerculesDialog unused = HerculesDialog.mDialog = null;
                }
            }
        });
    }

    private static void saveProp(String str, String str2) {
        mActivity.getSharedPreferences("HerculesPreferences", 0).edit().putString(str, str2).apply();
    }

    private static String loadProp(String str) {
        String string = mActivity.getSharedPreferences("HerculesPreferences", 0).getString(str, "");
        return string != null ? string : "";
    }

    private static class MyWebView extends WebView {
        private boolean clicked;

        public MyWebView(Context context) {
            super(context);
            this.clicked = false;
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.clicked = true;
            } else if (action == 1 && this.clicked) {
                this.clicked = false;
                performClick();
            }
            return zOnTouchEvent;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return true;
        }
    }
}
