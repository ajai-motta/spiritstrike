package com.gomfactory.adpie.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.webkit.ProxyConfig;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.DisplayUtil;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes3.dex */
public class InAppBrowser extends Activity {
    private static final String TAG = "InAppBrowser";
    private ImageButton mBackButton;
    private ImageButton mCloseButton;
    private ImageButton mForwardButton;
    private ImageButton mRefreshButton;
    private WebView mWebView;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 27) {
            setShowWhenLocked(true);
        } else {
            getWindow().addFlags(524288);
        }
        setContentView(getLayout());
        initButton();
        changeButtonColor();
        settingWebView();
        this.mWebView.loadUrl(getIntent().getStringExtra("url"));
    }

    private View getLayout() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setWeightSum(10.0f);
        linearLayout.setOrientation(1);
        this.mWebView = new WebView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 10.0f;
        this.mWebView.setLayoutParams(layoutParams);
        linearLayout.addView(this.mWebView);
        View view = new View(this);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, DisplayUtil.dpToPx(this, 1)));
        view.setBackgroundColor(-12303292);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setId(DisplayUtil.generateViewId());
        linearLayout2.setWeightSum(3.0f);
        int iDpToPx = DisplayUtil.dpToPx(this, 5);
        int iDpToPx2 = DisplayUtil.dpToPx(this, 20);
        linearLayout2.setPadding(iDpToPx2, iDpToPx, iDpToPx2, iDpToPx);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtil.dpToPx(this, 42)));
        linearLayout2.setBackgroundColor(Color.parseColor("#f7f7f7"));
        linearLayout.addView(linearLayout2);
        this.mBackButton = getImageButton("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAQAAAD9CzEMAAAAYUlEQVRYw+2RSQqAMBAE+1FRv+ZBGPHBxh+4nHKOUCGErr5XwYxkjKkltLP6+93B6r9trP7SYr311ltf9H8G63sI4Cdq8OQxEzOdyC0SkxPdJBKdOPnEKpGJEEiwemPG5AF4BwlIS7wyAgAAAABJRU5ErkJggg==");
        this.mForwardButton = getImageButton("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAQAAAD9CzEMAAAAa0lEQVRYw+2WsQ2AMBDEbqgQVqP7jYENnoYBQMghgfP3dhNFJxlj7hIKVp9KLrEoz4MSRSuf2OjE5EQ3idoisdOJ+a+JfHBBBy4lug7EcO9obH2l9ehnN1n/mr7Qenh44dMRH78N5rsx3+QAyRMJKNqTa7MAAAAASUVORK5CYII=");
        this.mRefreshButton = getImageButton("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAQAAAD9CzEMAAABmElEQVRYw+2XsU4CQRRFj8hCA8bECMZYUBgqv8JoYdAvsLDR0k9AYmsjIlv4DVpR2lAY7CyMHY0IgcKoiWBMrNbCYVx1Yd8sUJjsnWaTvXPvzOyb995CiBAhZIixjk2VOj161KlSZg3Lg1kwF1/ApovjMV45JfVL3jETj3PIm6d4f3Q5IOaSd8zWfj1UvD+umNfyBgYrNF0iTWxyLJMgQZZNzui43jaw9bMQaR70lDa7TP9hWOzz5LEf4dnX9IQKyYG8OarBDAqaXiIylGlxa26Q0mFZ8ZF3L8XAoKTPPmksLzCI8qKoewHkBQaritjyiBx/eYFBURHLgeQFBpeKuBFIXmBwp4jZSaXmZ2WQ/LcGEz8iyUceCbIwHQHSi/Yz5bXl+5anim/sqBmPRMeb7L4wq6tbUbYek3QNEc4Vu0daumV5wZnS+3XIm7QrspI5w4Wrt7BMYsm/6EfZ1rHj0GHRNFwHtS1xMuQ4cok7NILde2njdcNS0Evn3zp+kJfFfpDmt8sxmfG37+/cU+OELRLhf02IEDJ8ApJOgej0XVvVAAAAAElFTkSuQmCC");
        this.mCloseButton = getImageButton("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAQAAAD9CzEMAAAAl0lEQVRYw+2WSw6AIAwFX+IZuSIJZ2RRF67EX0FmoemsYV4AbSsFQfBfFmUl9+qkrKVPX2SqzoikKlPpicgymTNi05tMWR1Hrs4I/8qhjcN63+ZX+mfBa/29ZIr+WjRNfy6bqj8Kp+vbCEC/j0D0bQSgxwPgK4IfGf5M4R8NLhVwsYPLNdxw4JaJN318bMEHL3x0DILgW6zbiArszHKr4QAAAABJRU5ErkJggg==");
        linearLayout2.addView(getButtonViewGroup(this.mBackButton));
        linearLayout2.addView(getPaddingView());
        linearLayout2.addView(getButtonViewGroup(this.mForwardButton));
        linearLayout2.addView(getPaddingView());
        linearLayout2.addView(getButtonViewGroup(this.mRefreshButton));
        linearLayout2.addView(getPaddingView());
        linearLayout2.addView(getButtonViewGroup(this.mCloseButton));
        return linearLayout;
    }

    public ImageButton getImageButton(String str) {
        ImageButton imageButton = new ImageButton(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtil.dpToPx(this, 32), DisplayUtil.dpToPx(this, 32));
        layoutParams.gravity = 16;
        imageButton.setLayoutParams(layoutParams);
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            imageButton.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
        }
        return imageButton;
    }

    @Override // android.app.Activity
    protected void onPause() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onResume();
        }
    }

    public ViewGroup getButtonViewGroup(ImageButton imageButton) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(imageButton);
        return relativeLayout;
    }

    public View getPaddingView() {
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dpToPx(this, 1));
        layoutParams.weight = 1.0f;
        view.setLayoutParams(layoutParams);
        return view;
    }

    public void initButton() {
        this.mBackButton.setBackgroundColor(0);
        this.mBackButton.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.InAppBrowser.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (InAppBrowser.this.mWebView == null || !InAppBrowser.this.mWebView.canGoBack()) {
                    return;
                }
                InAppBrowser.this.mWebView.goBack();
            }
        });
        this.mForwardButton.setBackgroundColor(0);
        this.mForwardButton.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.InAppBrowser.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (InAppBrowser.this.mWebView == null || !InAppBrowser.this.mWebView.canGoForward()) {
                    return;
                }
                InAppBrowser.this.mWebView.goForward();
            }
        });
        this.mRefreshButton.setBackgroundColor(0);
        this.mRefreshButton.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.InAppBrowser.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (InAppBrowser.this.mWebView != null) {
                    InAppBrowser.this.mWebView.reload();
                }
            }
        });
        this.mCloseButton.setBackgroundColor(0);
        this.mCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.InAppBrowser.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InAppBrowser.this.finish();
            }
        });
    }

    public void changeButtonColor() {
        try {
            WebView webView = this.mWebView;
            if (webView != null && webView.canGoBack()) {
                this.mBackButton.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
            } else {
                this.mBackButton.getDrawable().setColorFilter(-3355444, PorterDuff.Mode.SRC_IN);
            }
            WebView webView2 = this.mWebView;
            if (webView2 != null && webView2.canGoForward()) {
                this.mForwardButton.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
            } else {
                this.mForwardButton.getDrawable().setColorFilter(-3355444, PorterDuff.Mode.SRC_IN);
            }
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
        }
    }

    public void settingWebView() {
        try {
            WebView webView = this.mWebView;
            if (webView != null) {
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setBuiltInZoomControls(true);
                settings.setSupportZoom(true);
                settings.setLoadWithOverviewMode(true);
                settings.setUseWideViewPort(true);
                settings.setDomStorageEnabled(true);
                settings.setMixedContentMode(0);
                settings.setCacheMode(1);
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    WebView.setWebContentsDebuggingEnabled(true);
                }
                this.mWebView.setWebViewClient(new WebViewClientClass());
            }
        } catch (Exception unused) {
        }
    }

    private class WebViewClientClass extends WebViewClient {
        private WebViewClientClass() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            try {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(InAppBrowser.TAG, "WebViewClient - onReceivedError : " + str2 + ", errorCode : " + i);
                }
            } catch (Exception unused) {
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            try {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(InAppBrowser.TAG, "WebViewClient - onReceivedError : " + webResourceRequest.getUrl().toString() + ", errorCode : " + webResourceError.getErrorCode());
                }
            } catch (Exception unused) {
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(InAppBrowser.TAG, "WebViewClient - onPageFinished : " + str);
            }
            InAppBrowser.this.changeButtonColor();
            CookieManager.getInstance().flush();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(InAppBrowser.TAG, "WebViewClient - shouldOverrideUrlLoading : " + str);
            }
            return checkDeepLink(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String string = webResourceRequest.getUrl().toString();
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(InAppBrowser.TAG, "WebViewClient - shouldOverrideUrlLoading[N] : " + string);
            }
            return checkDeepLink(webView, string);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(InAppBrowser.TAG, "WebViewClient - onRenderProcessGone");
            }
            super.onRenderProcessGone(webView, renderProcessGoneDetail);
            if (webView == null) {
                return true;
            }
            try {
                if (webView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                }
                webView.onPause();
                webView.destroy();
                return true;
            } catch (Exception unused) {
                return true;
            }
        }

        public boolean checkDeepLink(WebView webView, String str) {
            String scheme;
            Uri uri;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                scheme = Uri.parse(str).getScheme();
                uri = Uri.parse(str);
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(InAppBrowser.TAG, "url : " + str + ", scheme : " + scheme);
                }
            } catch (Exception e) {
                AdPieLog.e(InAppBrowser.TAG, e);
            }
            if (!scheme.equalsIgnoreCase(ProxyConfig.MATCH_HTTP) && !scheme.equalsIgnoreCase("https")) {
                if (uri.getScheme().equalsIgnoreCase("intent")) {
                    String stringExtra = null;
                    try {
                        Intent uri2 = Intent.parseUri(str, 1);
                        stringExtra = uri2.getStringExtra("browser_fallback_url");
                        InAppBrowser.this.startActivity(uri2);
                        InAppBrowser.this.finish();
                        return true;
                    } catch (ActivityNotFoundException e2) {
                        AdPieLog.e(InAppBrowser.TAG, e2);
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(InAppBrowser.TAG, "fallbackUrl : " + stringExtra);
                        }
                        if (!TextUtils.isEmpty(stringExtra)) {
                            webView.loadUrl(stringExtra);
                            return true;
                        }
                    } catch (URISyntaxException e3) {
                        Log.e(InAppBrowser.TAG, "Can't resolve intent://", e3);
                        AdPieLog.e(InAppBrowser.TAG, e3);
                    }
                } else {
                    if (!scheme.equalsIgnoreCase("market")) {
                        try {
                            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.d(InAppBrowser.TAG, ":::checkDeepLink:::Start intent. " + str);
                            }
                            InAppBrowser.this.startActivity(Intent.parseUri(str, 1));
                            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.d(InAppBrowser.TAG, ":::checkDeepLink:::You have successfully started intent. " + str);
                            }
                            InAppBrowser.this.finish();
                            return true;
                        } catch (ActivityNotFoundException e4) {
                            AdPieLog.e(InAppBrowser.TAG, e4);
                            return true;
                        }
                    }
                    try {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(InAppBrowser.TAG, ":::checkDeepLink:::Open Google Play Store. " + str);
                        }
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        intent.setPackage("com.android.vending");
                        InAppBrowser.this.startActivity(intent);
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(InAppBrowser.TAG, ":::checkDeepLink:::You have successfully opened Google Play Store. " + str);
                        }
                        InAppBrowser.this.finish();
                        return true;
                    } catch (ActivityNotFoundException e5) {
                        AdPieLog.e(InAppBrowser.TAG, e5);
                        try {
                            String str2 = String.format("https://play.google.com/store/apps/details?%s", uri.getQuery());
                            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.d(InAppBrowser.TAG, ":::checkDeepLink:::Open Google Play Store. " + str2);
                            }
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.setData(Uri.parse(str2));
                            intent2.setPackage("com.android.vending");
                            InAppBrowser.this.startActivity(intent2);
                            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                                AdPieLog.d(InAppBrowser.TAG, ":::checkDeepLink:::You have successfully opened Google Play Store. " + str2);
                            }
                            InAppBrowser.this.finish();
                            return true;
                        } catch (ActivityNotFoundException e6) {
                            AdPieLog.e(InAppBrowser.TAG, e6);
                        } catch (Exception e7) {
                            AdPieLog.e(InAppBrowser.TAG, e7);
                        }
                    }
                    AdPieLog.e(InAppBrowser.TAG, e);
                }
                return false;
            }
            return false;
        }
    }
}
