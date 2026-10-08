package com.hive.auth;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hive.auth.LoginCenterSelectDialog;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.logger.LoggerImpl;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.Resource;
import com.hive.ui.effect.ColorAnimation;
import com.hive.webview.HiveSchemeHandler;
import io.ktor.http.ContentDisposition;
import java.io.UnsupportedEncodingException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0003234B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\rJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0003J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020 H\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J \u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0003J\r\u00100\u001a\u00020\u001cH\u0000¢\u0006\u0002\b1R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/hive/auth/LoginCenterSelectDialog;", "", "activity", "Landroid/app/Activity;", "url", "", "postData", "onPostWebViewListener", "Lcom/hive/auth/LoginCenterSelectDialog$AuthLoginCenterSelectDialogListener;", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/hive/auth/LoginCenterSelectDialog$AuthLoginCenterSelectDialogListener;)V", "scheme", "host", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/auth/LoginCenterSelectDialog$AuthLoginCenterSelectDialogListener;)V", "webViewDialog", "Landroid/app/Dialog;", "topLayout", "Landroid/widget/RelativeLayout;", "closeButtonText", "Landroid/widget/TextView;", "closeButton", "Landroid/widget/ImageView;", "closeButtonTextAnimation", "Lcom/hive/ui/effect/ColorAnimation;", "closeButtonAnimation", "authLoginCenterSelectDialogListener", "select", "show", "", "onCreateWebViewDialog", "strURL", "onCloseButtonTouch", "", "event", "Landroid/view/MotionEvent;", "delayMillis", "", "setTopBarSize", "", ContentDisposition.Parameters.Size, "isText", "updateNativeTopBar", "createWebView", "Landroid/view/View;", "webView", "Lcom/hive/core/webview/HiveWebView;", "isShowing", "()Z", "dismiss", "dismiss$hive_service_release", "AuthLoginCenterSelectDialogListener", "LoginCenterSchemeHandler", "WebViewCallBack", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginCenterSelectDialog {
    private final Activity activity;
    private AuthLoginCenterSelectDialogListener authLoginCenterSelectDialogListener;
    private ImageView closeButton;
    private ColorAnimation closeButtonAnimation;
    private TextView closeButtonText;
    private ColorAnimation closeButtonTextAnimation;
    private String host;
    private final boolean isShowing;
    private String scheme;
    private String select;
    private RelativeLayout topLayout;
    private Dialog webViewDialog;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/auth/LoginCenterSelectDialog$AuthLoginCenterSelectDialogListener;", "", "onWebViewFinish", "", "select", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthLoginCenterSelectDialogListener {
        void onWebViewFinish(String select);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/hive/auth/LoginCenterSelectDialog$LoginCenterSchemeHandler;", "Lcom/hive/webview/HiveSchemeHandler;", "<init>", "(Lcom/hive/auth/LoginCenterSelectDialog;)V", "isProgressingScheme", "", "()Z", "setProgressingScheme", "(Z)V", "schemeEvent", "view", "Landroid/webkit/WebView;", "scheme", "Lcom/hive/core/Scheme;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class LoginCenterSchemeHandler extends HiveSchemeHandler {
        private boolean isProgressingScheme;

        public LoginCenterSchemeHandler() {
        }

        /* JADX INFO: renamed from: isProgressingScheme, reason: from getter */
        public final boolean getIsProgressingScheme() {
            return this.isProgressingScheme;
        }

        @Override // com.hive.webview.HiveSchemeHandler
        public boolean schemeEvent(WebView view, Scheme scheme) {
            Dialog dialog;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL(AuthDataInterface.getTAG(), "[LoginCenterSelectDialog] schemeEvent: " + scheme);
            loggerImpl.dR(AuthDataInterface.getTAG(), "[LoginCenterSelectDialog] schemeEvent");
            try {
                dialog = null;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[LoginCenterSelectDialog] schemeEvent Exception : " + e);
            }
            if (TextUtils.equals(LoginCenterSelectDialog.this.scheme, scheme.getScheme()) && TextUtils.equals(LoginCenterSelectDialog.this.host, scheme.getHost()) && !this.isProgressingScheme) {
                this.isProgressingScheme = true;
                LoginCenterSelectDialog.this.select = scheme.getUrl();
                Dialog dialog2 = LoginCenterSelectDialog.this.webViewDialog;
                if (dialog2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webViewDialog");
                } else {
                    dialog = dialog2;
                }
                dialog.dismiss();
                return true;
            }
            if (TextUtils.equals("c2s", scheme.getScheme()) && TextUtils.equals("logincenter", scheme.getHost()) && !this.isProgressingScheme) {
                this.isProgressingScheme = true;
                LoginCenterSelectDialog.this.select = scheme.getParameter().get("vid");
                Dialog dialog3 = LoginCenterSelectDialog.this.webViewDialog;
                if (dialog3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webViewDialog");
                } else {
                    dialog = dialog3;
                }
                dialog.dismiss();
                return true;
            }
            return super.schemeEvent(view, scheme);
        }

        public final void setProgressingScheme(boolean z) {
            this.isProgressingScheme = z;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/hive/auth/LoginCenterSelectDialog$WebViewCallBack;", "Lcom/hive/core/webview/HiveWebViewClient;", "<init>", "(Lcom/hive/auth/LoginCenterSelectDialog;)V", "webProgressDialog", "Landroid/app/ProgressDialog;", "getWebProgressDialog$hive_service_release", "()Landroid/app/ProgressDialog;", "webProgressDialog$delegate", "Lkotlin/Lazy;", "onPageStarted", "", "view", "Landroid/webkit/WebView;", "url", "", "favicon", "Landroid/graphics/Bitmap;", "onPageFinished", "setLoadingText", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class WebViewCallBack extends HiveWebViewClient {

        /* JADX INFO: renamed from: webProgressDialog$delegate, reason: from kotlin metadata */
        private final Lazy webProgressDialog;

        public WebViewCallBack() {
            super(LoginCenterSelectDialog.this.new LoginCenterSchemeHandler());
            this.webProgressDialog = LazyKt.lazy(new Function0() { // from class: com.hive.auth.LoginCenterSelectDialog$WebViewCallBack$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LoginCenterSelectDialog.WebViewCallBack.webProgressDialog_delegate$lambda$1(loginCenterSelectDialog, this);
                }
            });
        }

        private final String setLoadingText() {
            String string = Resource.INSTANCE.getString("hive_logincenter_select_dialog_loading");
            return string == null ? "Loading..." : string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ProgressDialog webProgressDialog_delegate$lambda$1(LoginCenterSelectDialog loginCenterSelectDialog, WebViewCallBack webViewCallBack) {
            ProgressDialog progressDialog = new ProgressDialog(loginCenterSelectDialog.activity);
            progressDialog.setMessage(webViewCallBack.setLoadingText());
            progressDialog.setCancelable(true);
            return progressDialog;
        }

        public final ProgressDialog getWebProgressDialog$hive_service_release() {
            return (ProgressDialog) this.webProgressDialog.getValue();
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[LoginCenterSelectDialog] onPageFinished url: " + url);
            super.onPageFinished(view, url);
            if (getWebProgressDialog$hive_service_release().isShowing()) {
                getWebProgressDialog$hive_service_release().dismiss();
            }
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageStarted(view, url, favicon);
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[LoginCenterSelectDialog] onPageStarted url: " + url);
            getWebProgressDialog$hive_service_release().show();
        }
    }

    public LoginCenterSelectDialog(Activity activity, String url, String postData, AuthLoginCenterSelectDialogListener authLoginCenterSelectDialogListener) {
        boolean zIsShowing;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Dialog dialog = this.webViewDialog;
        if (dialog != null) {
            if (dialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewDialog");
                dialog = null;
            }
            zIsShowing = dialog.isShowing();
        } else {
            zIsShowing = false;
        }
        this.isShowing = zIsShowing;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL(AuthDataInterface.getTAG(), "[AuthLoginCenterSelectDialog] url : " + url + " , postData : " + postData);
        String tag = AuthDataInterface.getTAG();
        StringBuilder sb = new StringBuilder("[AuthLoginCenterSelectDialog] url : ");
        sb.append(url);
        loggerImpl.dR(tag, sb.toString());
        this.activity = activity;
        this.authLoginCenterSelectDialogListener = authLoginCenterSelectDialogListener;
        this.webViewDialog = onCreateWebViewDialog(url, postData);
    }

    private final View createWebView(HiveWebView webView, String strURL, String postData) {
        if (TextUtils.isEmpty(postData)) {
            postData = "";
        }
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setPadding(0, 0, 0, 0);
        webView.setWebViewClient(new WebViewCallBack());
        webView.getSettings().setJavaScriptEnabled(true);
        try {
            webView.setOauthToken(HiveLifecycle.INSTANCE.getAccount().getOauthToken());
            byte[] bytes = postData.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            webView.postUrlCI(strURL, bytes);
            return webView;
        } catch (UnsupportedEncodingException e) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[LoginCenterSelectDialog] createWebView Exception : " + e);
            return webView;
        }
    }

    private final boolean onCloseButtonTouch(MotionEvent event, long delayMillis) {
        TextView textView = this.closeButtonText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButtonText");
            textView = null;
        }
        int left = textView.getLeft();
        TextView textView2 = this.closeButtonText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButtonText");
            textView2 = null;
        }
        int top = textView2.getTop();
        ImageView imageView = this.closeButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            imageView = null;
        }
        int right = imageView.getRight();
        ImageView imageView2 = this.closeButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            imageView2 = null;
        }
        Rect rect = new Rect(left, top, right, imageView2.getBottom());
        int action = event.getAction();
        if (action == 0) {
            ColorAnimation colorAnimation = this.closeButtonTextAnimation;
            if (colorAnimation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeButtonTextAnimation");
                colorAnimation = null;
            }
            ColorAnimation.startChangeAnimation$default(colorAnimation, null, null, 3, null);
            ColorAnimation colorAnimation2 = this.closeButtonAnimation;
            if (colorAnimation2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeButtonAnimation");
                colorAnimation2 = null;
            }
            ColorAnimation.startChangeAnimation$default(colorAnimation2, null, null, 3, null);
        } else if (action != 1) {
            if (action != 2) {
                return false;
            }
            if (rect.contains(rect.left + ((int) event.getX()), rect.top + ((int) event.getY()))) {
                ColorAnimation colorAnimation3 = this.closeButtonTextAnimation;
                if (colorAnimation3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("closeButtonTextAnimation");
                    colorAnimation3 = null;
                }
                ColorAnimation.startChangeAnimation$default(colorAnimation3, null, null, 3, null);
                ColorAnimation colorAnimation4 = this.closeButtonAnimation;
                if (colorAnimation4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("closeButtonAnimation");
                    colorAnimation4 = null;
                }
                ColorAnimation.startChangeAnimation$default(colorAnimation4, null, null, 3, null);
            } else {
                ColorAnimation colorAnimation5 = this.closeButtonTextAnimation;
                if (colorAnimation5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("closeButtonTextAnimation");
                    colorAnimation5 = null;
                }
                ColorAnimation.startReverseAnimation$default(colorAnimation5, null, null, 3, null);
                ColorAnimation colorAnimation6 = this.closeButtonAnimation;
                if (colorAnimation6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("closeButtonAnimation");
                    colorAnimation6 = null;
                }
                ColorAnimation.startReverseAnimation$default(colorAnimation6, null, null, 3, null);
            }
        } else if (rect.contains(rect.left + ((int) event.getX()), rect.top + ((int) event.getY()))) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.hive.auth.LoginCenterSelectDialog$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.dismiss$hive_service_release();
                }
            }, delayMillis);
        } else {
            ColorAnimation colorAnimation7 = this.closeButtonTextAnimation;
            if (colorAnimation7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeButtonTextAnimation");
                colorAnimation7 = null;
            }
            ColorAnimation.startReverseAnimation$default(colorAnimation7, null, null, 3, null);
            ColorAnimation colorAnimation8 = this.closeButtonAnimation;
            if (colorAnimation8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeButtonAnimation");
                colorAnimation8 = null;
            }
            ColorAnimation.startReverseAnimation$default(colorAnimation8, null, null, 3, null);
        }
        return true;
    }

    private final Dialog onCreateWebViewDialog(String strURL, String postData) {
        TextView textView;
        ImageView imageView;
        Dialog dialog = new Dialog(this.activity, R.style.Theme.DeviceDefault.NoActionBar.Fullscreen);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.hive.auth.LoginCenterSelectDialog$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                LoginCenterSelectDialog.onCreateWebViewDialog$lambda$1(this.f$0, dialogInterface);
            }
        });
        Resource resource = Resource.INSTANCE;
        dialog.setContentView(resource.getLayoutId(this.activity, "social_dialog"));
        View viewFindViewById = dialog.findViewById(resource.getViewId(this.activity, "social_DialogTopBar"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.topLayout = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = dialog.findViewById(resource.getViewId(this.activity, "social_HiveWebview"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type com.hive.core.webview.HiveWebView");
        HiveWebView hiveWebView = (HiveWebView) viewFindViewById2;
        View viewFindViewById3 = dialog.findViewById(resource.getViewId(this.activity, "social_HiveSpinner"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ProgressBar");
        View viewFindViewById4 = dialog.findViewById(resource.getViewId(this.activity, "social_BackToGameArrow"));
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        this.closeButton = (ImageView) viewFindViewById4;
        View viewFindViewById5 = dialog.findViewById(resource.getViewId(this.activity, "social_BackToGame"));
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.closeButtonText = (TextView) viewFindViewById5;
        updateNativeTopBar();
        ((ProgressBar) viewFindViewById3).setVisibility(8);
        int iArgb = Color.argb(117, 255, 255, 255);
        int iArgb2 = Color.argb(117, 0, 0, 0);
        TextView textView2 = this.closeButtonText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButtonText");
            textView = null;
        } else {
            textView = textView2;
        }
        final long j = 150;
        this.closeButtonTextAnimation = new ColorAnimation(textView, -1, iArgb, 150L, null, 16, null);
        ImageView imageView2 = this.closeButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            imageView = null;
        } else {
            imageView = imageView2;
        }
        this.closeButtonAnimation = new ColorAnimation(imageView, 0, iArgb2, 150L, null, 16, null);
        TextView textView3 = this.closeButtonText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButtonText");
            textView3 = null;
        }
        textView3.setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.auth.LoginCenterSelectDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return LoginCenterSelectDialog.onCreateWebViewDialog$lambda$2(this.f$0, j, view, motionEvent);
            }
        });
        ImageView imageView3 = this.closeButton;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            imageView3 = null;
        }
        imageView3.setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.auth.LoginCenterSelectDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return LoginCenterSelectDialog.onCreateWebViewDialog$lambda$3(this.f$0, j, view, motionEvent);
            }
        });
        createWebView(hiveWebView, strURL, postData);
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateWebViewDialog$lambda$1(LoginCenterSelectDialog loginCenterSelectDialog, DialogInterface dialogInterface) {
        AuthLoginCenterSelectDialogListener authLoginCenterSelectDialogListener = loginCenterSelectDialog.authLoginCenterSelectDialogListener;
        if (authLoginCenterSelectDialogListener != null) {
            authLoginCenterSelectDialogListener.onWebViewFinish(loginCenterSelectDialog.select);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateWebViewDialog$lambda$2(LoginCenterSelectDialog loginCenterSelectDialog, long j, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(motionEvent);
        return loginCenterSelectDialog.onCloseButtonTouch(motionEvent, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateWebViewDialog$lambda$3(LoginCenterSelectDialog loginCenterSelectDialog, long j, View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        ImageView imageView = loginCenterSelectDialog.closeButton;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            imageView = null;
        }
        int left = imageView.getLeft();
        TextView textView2 = loginCenterSelectDialog.closeButtonText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButtonText");
        } else {
            textView = textView2;
        }
        motionEvent.setLocation(x + (left - textView.getLeft()), motionEvent.getY());
        Intrinsics.checkNotNull(motionEvent);
        return loginCenterSelectDialog.onCloseButtonTouch(motionEvent, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int setTopBarSize(int r5, boolean r6) {
        /*
            r4 = this;
            android.app.Activity r0 = r4.activity
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r1 < r2) goto L21
            android.app.Activity r1 = r4.activity
            boolean r1 = r1.isInMultiWindowMode()
            if (r1 == 0) goto L21
            com.hive.base.Android r1 = com.hive.base.Android.INSTANCE
            android.app.Activity r2 = r4.activity
            android.graphics.Point r1 = r1.getDisplaySize(r2)
            goto L29
        L21:
            com.hive.base.Android r1 = com.hive.base.Android.INSTANCE
            android.app.Activity r2 = r4.activity
            android.graphics.Point r1 = r1.getRealDisplaySize(r2)
        L29:
            int r2 = r1.x
            float r2 = (float) r2
            float r3 = r0.density
            float r2 = r2 / r3
            int r1 = r1.y
            float r1 = (float) r1
            float r1 = r1 / r3
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            r3 = 1142947840(0x44200000, float:640.0)
            if (r1 <= 0) goto L68
            r1 = 1149239296(0x44800000, float:1024.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L40
            goto L6c
        L40:
            r1 = 1145044992(0x44400000, float:768.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L4a
            float r5 = (float) r5
            r1 = 1067450368(0x3fa00000, float:1.25)
            goto L6f
        L4a:
            r1 = 1144520704(0x44380000, float:736.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L55
            float r5 = (float) r5
            r1 = 1067906271(0x3fa6f4df, float:1.3043479)
            goto L6f
        L55:
            int r1 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r1 < 0) goto L5d
            float r5 = (float) r5
            r1 = 1069547520(0x3fc00000, float:1.5)
            goto L6f
        L5d:
            r1 = 1141768192(0x440e0000, float:568.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L9d
            float r5 = (float) r5
            r1 = 1071142537(0x3fd85689, float:1.6901408)
            goto L6f
        L68:
            int r1 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r1 < 0) goto L71
        L6c:
            float r5 = (float) r5
            r1 = 1065353216(0x3f800000, float:1.0)
        L6f:
            float r5 = r5 / r1
            goto La1
        L71:
            r1 = 1142292480(0x44160000, float:600.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L7c
            float r5 = (float) r5
            r1 = 1065912457(0x3f888889, float:1.0666667)
            goto L6f
        L7c:
            r1 = 1139802112(0x43f00000, float:480.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L87
            float r5 = (float) r5
            r1 = 1068149419(0x3faaaaab, float:1.3333334)
            goto L6f
        L87:
            r1 = 1137639424(0x43cf0000, float:414.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L92
            float r5 = (float) r5
            r1 = 1069932504(0x3fc5dfd8, float:1.5458937)
            goto L6f
        L92:
            r1 = 1135869952(0x43b40000, float:360.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L9d
            float r5 = (float) r5
            r1 = 1071877689(0x3fe38e39, float:1.7777778)
            goto L6f
        L9d:
            float r5 = (float) r5
            r1 = 1073741824(0x40000000, float:2.0)
            goto L6f
        La1:
            if (r6 != 0) goto Laf
            double r5 = (double) r5
            double r5 = java.lang.Math.floor(r5)
            int r5 = (int) r5
            float r5 = (float) r5
            r6 = 1
            float r5 = android.util.TypedValue.applyDimension(r6, r5, r0)
        Laf:
            int r5 = java.lang.Math.round(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.LoginCenterSelectDialog.setTopBarSize(int, boolean):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0(LoginCenterSelectDialog loginCenterSelectDialog) {
        Dialog dialog = loginCenterSelectDialog.webViewDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webViewDialog");
            dialog = null;
        }
        dialog.show();
    }

    private final void updateNativeTopBar() {
        RelativeLayout relativeLayout = this.topLayout;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topLayout");
            relativeLayout = null;
        }
        relativeLayout.getLayoutParams().height = setTopBarSize(68, false);
        ImageView imageView = this.closeButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.width = setTopBarSize(16, false);
        layoutParams2.height = setTopBarSize(26, false);
        layoutParams2.rightMargin = setTopBarSize(20, false);
        TextView textView = this.closeButtonText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButtonText");
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams3).rightMargin = setTopBarSize(10, false);
        TextView textView2 = this.closeButtonText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButtonText");
            textView2 = null;
        }
        textView2.setTextSize(setTopBarSize(28, true));
        RelativeLayout relativeLayout3 = this.topLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topLayout");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        relativeLayout2.invalidate();
    }

    public final void dismiss$hive_service_release() {
        Dialog dialog = this.webViewDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webViewDialog");
            dialog = null;
        }
        dialog.dismiss();
    }

    /* JADX INFO: renamed from: isShowing, reason: from getter */
    public final boolean getIsShowing() {
        return this.isShowing;
    }

    public final void show() {
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "[AuthLoginCenterSelectDialog] show");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.LoginCenterSelectDialog$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LoginCenterSelectDialog.show$lambda$0(this.f$0);
            }
        });
    }

    public LoginCenterSelectDialog(Activity activity, String url, String postData, String scheme, String host, AuthLoginCenterSelectDialogListener authLoginCenterSelectDialogListener) {
        boolean zIsShowing;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(host, "host");
        Dialog dialog = this.webViewDialog;
        if (dialog != null) {
            if (dialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webViewDialog");
                dialog = null;
            }
            zIsShowing = dialog.isShowing();
        } else {
            zIsShowing = false;
        }
        this.isShowing = zIsShowing;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL(AuthDataInterface.getTAG(), "[AuthLoginCenterSelectDialog] url : " + url + " , postData : " + postData);
        String tag = AuthDataInterface.getTAG();
        StringBuilder sb = new StringBuilder("[AuthLoginCenterSelectDialog] url : ");
        sb.append(url);
        loggerImpl.dR(tag, sb.toString());
        this.activity = activity;
        this.scheme = scheme;
        this.host = host;
        this.authLoginCenterSelectDialogListener = authLoginCenterSelectDialogListener;
        this.webViewDialog = onCreateWebViewDialog(url, postData);
    }
}
