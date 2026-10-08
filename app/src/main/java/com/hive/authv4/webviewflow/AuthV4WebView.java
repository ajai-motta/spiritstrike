package com.hive.authv4.webviewflow;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.facebook.share.internal.ShareConstants;
import com.hive.AuthV4;
import com.hive.Configuration;
import com.hive.Logger;
import com.hive.ResultAPI;
import com.hive.authv4.webviewflow.AuthV4WebView;
import com.hive.base.Android;
import com.hive.base.HivePicture;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.core.webview.SchemeHandler;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.UrlManager;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.ExtensionsKt;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.R;
import com.hive.ui.Resource;
import com.hive.ui.view.HiveAnimationButton;
import com.hive.webview.HiveSchemeHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0004YZ[\\B\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005BO\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u0004\u0010\u000fJ\b\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020HH\u0002J\b\u0010J\u001a\u00020HH\u0016J\u0012\u0010K\u001a\u00020H2\b\b\u0002\u0010L\u001a\u00020MH\u0016J\u0018\u0010N\u001a\u00020H2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010O\u001a\u00020PH\u0004J\u001c\u0010Q\u001a\u00020H2\u0006\u0010L\u001a\u00020M2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010SH\u0005J\r\u0010T\u001a\u00020FH\u0010¢\u0006\u0002\bUJ\u0010\u0010V\u001a\u00020F2\u0006\u0010W\u001a\u00020XH\u0016R\u001a\u0010\u0010\u001a\u00020\u0011X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010 \"\u0004\b5\u0010\"R\u001c\u00106\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R\u001a\u00109\u001a\u00020:X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010 \"\u0004\bA\u0010\"R\u001c\u0010B\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010 \"\u0004\bD\u0010\"¨\u0006]"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4WebView;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "url", "", "postData", "scheme", "host", "buttonType", "Lcom/hive/authv4/webviewflow/AuthV4WebView$CloseButtonType;", "onPostWebViewListener", "Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebViewListener;", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/authv4/webviewflow/AuthV4WebView$CloseButtonType;Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebViewListener;)V", "webView", "Lcom/hive/core/webview/HiveWebView;", "getWebView", "()Lcom/hive/core/webview/HiveWebView;", "setWebView", "(Lcom/hive/core/webview/HiveWebView;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getPostData", "setPostData", "getScheme", "setScheme", "getHost", "setHost", "closeButtonType", "getCloseButtonType", "()Lcom/hive/authv4/webviewflow/AuthV4WebView$CloseButtonType;", "setCloseButtonType", "(Lcom/hive/authv4/webviewflow/AuthV4WebView$CloseButtonType;)V", "authV4WebViewDialogListener", "getAuthV4WebViewDialogListener", "()Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebViewListener;", "setAuthV4WebViewDialogListener", "(Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebViewListener;)V", "loadingText", "getLoadingText$hive_service_release", "setLoadingText$hive_service_release", "select", "getSelect", "setSelect", "webViewErrorCode", "", "getWebViewErrorCode$hive_service_release", "()I", "setWebViewErrorCode$hive_service_release", "(I)V", "webViewDescription", "getWebViewDescription$hive_service_release", "setWebViewDescription$hive_service_release", "webViewFailingUrl", "getWebViewFailingUrl$hive_service_release", "setWebViewFailingUrl$hive_service_release", "onBackPressed", "", "dismiss", "", "loadWebView", "show", "createWebView", "webViewClient", "Lcom/hive/core/webview/HiveWebViewClient;", "setButtonType", "button", "Lcom/hive/ui/view/HiveAnimationButton;", "setWebViewSettings", "chromeClient", "Landroid/webkit/WebChromeClient;", "internalBackPressed", "internalBackPressed$hive_service_release", "handleHiveScheme", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "AuthV4WebViewListener", "CloseButtonType", "AuthV4WebSchemeHandler", "WebViewCallBack", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AuthV4WebView {
    private Activity activity;
    private AuthV4WebViewListener authV4WebViewDialogListener;
    private CloseButtonType closeButtonType;
    private String host;
    private String loadingText;
    private String postData;
    private ProgressBar progressBar;
    private String scheme;
    private String select;
    private String url;
    protected HiveWebView webView;
    private String webViewDescription;
    private int webViewErrorCode;
    private String webViewFailingUrl;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebSchemeHandler;", "Lcom/hive/webview/HiveSchemeHandler;", "<init>", "(Lcom/hive/authv4/webviewflow/AuthV4WebView;)V", "schemeEvent", "", "view", "Landroid/webkit/WebView;", "scheme", "Lcom/hive/core/Scheme;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AuthV4WebSchemeHandler extends HiveSchemeHandler {
        public AuthV4WebSchemeHandler() {
        }

        @Override // com.hive.webview.HiveSchemeHandler
        public boolean schemeEvent(WebView view, Scheme scheme) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.iL(AuthV4.getTAG(), "[AuthV4WebViewDialog] \nschemeEvent: " + scheme + '\n');
            loggerImpl.iR(AuthV4.getTAG(), "[AuthV4WebViewDialog] \nschemeEvent");
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (Intrinsics.areEqual(AuthV4WebView.this.getScheme(), scheme.getScheme()) && Intrinsics.areEqual(AuthV4WebView.this.getHost(), scheme.getHost())) {
                AuthV4WebView.this.setSelect(scheme.getUrl());
                AuthV4WebView.this.dismiss();
                return true;
            }
            String scheme2 = scheme.getScheme();
            if (Intrinsics.areEqual(scheme2, "hive") || Intrinsics.areEqual(scheme2, "c2shub") || Intrinsics.areEqual(scheme2, AuthV4WebView.this.getScheme())) {
                AuthV4WebView authV4WebView = AuthV4WebView.this;
                Uri uri = Uri.parse(scheme.getUrl());
                Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                return authV4WebView.handleHiveScheme(uri);
            }
            return super.schemeEvent(view, scheme);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebViewListener;", "", "onWebViewFinish", "", "scheme", "", "onReceivedError", "errorCode", "", "description", "failingUrl", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4WebViewListener {
        void onReceivedError(int errorCode, String description, String failingUrl);

        void onWebViewFinish(String scheme);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4WebView$CloseButtonType;", "", "<init>", "(Ljava/lang/String;I)V", "TYPE_NONE", "TYPE_NORMAL", "TYPE_THEME", "TYPE_SIGN_IN_APPLE", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CloseButtonType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CloseButtonType[] $VALUES;
        public static final CloseButtonType TYPE_NONE = new CloseButtonType("TYPE_NONE", 0);
        public static final CloseButtonType TYPE_NORMAL = new CloseButtonType("TYPE_NORMAL", 1);
        public static final CloseButtonType TYPE_THEME = new CloseButtonType("TYPE_THEME", 2);
        public static final CloseButtonType TYPE_SIGN_IN_APPLE = new CloseButtonType("TYPE_SIGN_IN_APPLE", 3);

        private static final /* synthetic */ CloseButtonType[] $values() {
            return new CloseButtonType[]{TYPE_NONE, TYPE_NORMAL, TYPE_THEME, TYPE_SIGN_IN_APPLE};
        }

        static {
            CloseButtonType[] closeButtonTypeArr$values = $values();
            $VALUES = closeButtonTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(closeButtonTypeArr$values);
        }

        private CloseButtonType(String str, int i) {
        }

        public static EnumEntries<CloseButtonType> getEntries() {
            return $ENTRIES;
        }

        public static CloseButtonType valueOf(String str) {
            return (CloseButtonType) Enum.valueOf(CloseButtonType.class, str);
        }

        public static CloseButtonType[] values() {
            return (CloseButtonType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0011\b\u0094\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J,\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00192\b\u0010!\u001a\u0004\u0018\u00010\u0019H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\""}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4WebView$WebViewCallBack;", "Lcom/hive/core/webview/HiveWebViewClient;", "schemeHandler", "Lcom/hive/core/webview/SchemeHandler;", "<init>", "(Lcom/hive/authv4/webviewflow/AuthV4WebView;Lcom/hive/core/webview/SchemeHandler;)V", "reLoadFlag", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getReLoadFlag", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "webViewTimeoutFlag", "", "getWebViewTimeoutFlag", "()Z", "setWebViewTimeoutFlag", "(Z)V", "timeoutHandler", "com/hive/authv4/webviewflow/AuthV4WebView$WebViewCallBack$timeoutHandler$1", "Lcom/hive/authv4/webviewflow/AuthV4WebView$WebViewCallBack$timeoutHandler$1;", "reloadMirrorUrl", "onPageStarted", "", "view", "Landroid/webkit/WebView;", "url", "", "favicon", "Landroid/graphics/Bitmap;", "onPageFinished", "receivedErrorEvent", "errorCode", "", "description", "failingUrl", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public class WebViewCallBack extends HiveWebViewClient {
        private final AtomicBoolean reLoadFlag;
        final /* synthetic */ AuthV4WebView this$0;
        private final AuthV4WebView$WebViewCallBack$timeoutHandler$1 timeoutHandler;
        private boolean webViewTimeoutFlag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.hive.authv4.webviewflow.AuthV4WebView$WebViewCallBack$timeoutHandler$1] */
        public WebViewCallBack(final AuthV4WebView authV4WebView, SchemeHandler schemeHandler) {
            super(schemeHandler);
            Intrinsics.checkNotNullParameter(schemeHandler, "schemeHandler");
            this.this$0 = authV4WebView;
            this.reLoadFlag = new AtomicBoolean(true);
            this.webViewTimeoutFlag = true;
            final Looper mainLooper = Looper.getMainLooper();
            this.timeoutHandler = new Handler(mainLooper) { // from class: com.hive.authv4.webviewflow.AuthV4WebView$WebViewCallBack$timeoutHandler$1
                @Override // android.os.Handler
                public void handleMessage(Message msg) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    if (msg.what == 0 && this.this$0.getWebViewTimeoutFlag()) {
                        this.this$0.setWebViewTimeoutFlag(false);
                        ProgressBar progressBar = authV4WebView.getProgressBar();
                        if (progressBar != null) {
                            progressBar.setVisibility(8);
                        }
                        this.this$0.reloadMirrorUrl();
                    }
                    super.handleMessage(msg);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean reloadMirrorUrl() {
            final String mirrorUrl;
            if (!this.reLoadFlag.getAndSet(false) || (mirrorUrl = UrlManager.INSTANCE.getMirrorUrl(this.this$0.getUrl())) == null) {
                return false;
            }
            AuthV4WebView authV4WebView = this.this$0;
            authV4WebView.setUrl(mirrorUrl);
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.eL("\n[AuthV4WebView] Mirror Url: " + mirrorUrl);
            loggerImpl.eR("\n[AuthV4WebView] Mirror Url enable");
            if (Configuration.getUseLog()) {
                Android.INSTANCE.runOnMainThread(new Runnable() { // from class: com.hive.authv4.webviewflow.AuthV4WebView$WebViewCallBack$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AuthV4WebView.WebViewCallBack.reloadMirrorUrl$lambda$1$lambda$0(mirrorUrl);
                    }
                });
            }
            authV4WebView.loadWebView();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void reloadMirrorUrl$lambda$1$lambda$0(String str) {
            Toast.makeText(Configuration.getContext(), "[AuthV4WebView] Mirror Url: " + str, 1).show();
        }

        public final AtomicBoolean getReLoadFlag() {
            return this.reLoadFlag;
        }

        public final boolean getWebViewTimeoutFlag() {
            return this.webViewTimeoutFlag;
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[AuthV4WebViewDialog] \nonPageFinished: " + url + '\n');
            this.webViewTimeoutFlag = false;
            ProgressBar progressBar = this.this$0.getProgressBar();
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            super.onPageFinished(view, url);
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[AuthV4WebViewDialog] \nonPageStarted: " + url + '\n');
            this.webViewTimeoutFlag = true;
            ProgressBar progressBar = this.this$0.getProgressBar();
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            removeCallbacksAndMessages(null);
            sendEmptyMessageDelayed(0, ((long) ConfigurationImpl.INSTANCE.getHttpConnectTimeout()) * 1000);
            super.onPageStarted(view, url, favicon);
        }

        @Override // com.hive.core.webview.HiveWebViewClient
        public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[AuthV4WebViewDialog] \nreceivedErrorEvent: " + errorCode + description + '\n');
            if (reloadMirrorUrl()) {
                return;
            }
            this.this$0.setWebViewErrorCode$hive_service_release(errorCode);
            this.this$0.setWebViewDescription$hive_service_release(description);
            this.this$0.setWebViewFailingUrl$hive_service_release(failingUrl);
            this.webViewTimeoutFlag = false;
            ProgressBar progressBar = this.this$0.getProgressBar();
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            this.this$0.dismiss();
        }

        public final void setWebViewTimeoutFlag(boolean z) {
            this.webViewTimeoutFlag = z;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CloseButtonType.values().length];
            try {
                iArr[CloseButtonType.TYPE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CloseButtonType.TYPE_NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CloseButtonType.TYPE_SIGN_IN_APPLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AuthV4WebView(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.url = "";
        this.closeButtonType = CloseButtonType.TYPE_NORMAL;
        this.loadingText = "Loading...";
        this.activity = activity;
        this.loadingText = Resource.INSTANCE.getString("hive_useragree_dialog_loading");
    }

    public static /* synthetic */ void createWebView$default(AuthV4WebView authV4WebView, HiveWebViewClient hiveWebViewClient, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createWebView");
        }
        if ((i & 1) != 0) {
            hiveWebViewClient = new WebViewCallBack(authV4WebView, authV4WebView.new AuthV4WebSchemeHandler());
        }
        authV4WebView.createWebView(hiveWebViewClient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$0(AuthV4WebView authV4WebView) {
        if (authV4WebView.authV4WebViewDialogListener != null) {
            LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[AuthV4WebViewDialog] Code check :::: " + authV4WebView.webViewErrorCode + '\n');
            int i = authV4WebView.webViewErrorCode;
            if (i == 0) {
                AuthV4WebViewListener authV4WebViewListener = authV4WebView.authV4WebViewDialogListener;
                if (authV4WebViewListener != null) {
                    authV4WebViewListener.onWebViewFinish(authV4WebView.select);
                }
            } else {
                AuthV4WebViewListener authV4WebViewListener2 = authV4WebView.authV4WebViewDialogListener;
                if (authV4WebViewListener2 != null) {
                    authV4WebViewListener2.onReceivedError(i, authV4WebView.webViewDescription, authV4WebView.webViewFailingUrl);
                }
            }
            authV4WebView.authV4WebViewDialogListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadWebView() {
        Object objM7415constructorimpl;
        byte[] bytes;
        getWebView().setOauthToken(HiveLifecycle.INSTANCE.getAccount().getOauthToken());
        String str = this.postData;
        if (str == null || StringsKt.isBlank(str)) {
            getWebView().loadUrl(this.url);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            HiveWebView webView = getWebView();
            String str2 = this.url;
            String str3 = this.postData;
            if (str3 != null) {
                bytes = str3.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            } else {
                bytes = null;
            }
            webView.postUrlCI(str2, bytes);
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.w("[AuthV4WebViewDialog] loadWebView catching: " + thM7418exceptionOrNullimpl);
        }
        Result.m7414boximpl(objM7415constructorimpl);
    }

    public static /* synthetic */ void setWebViewSettings$default(AuthV4WebView authV4WebView, HiveWebViewClient hiveWebViewClient, WebChromeClient webChromeClient, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWebViewSettings");
        }
        if ((i & 2) != 0) {
            webChromeClient = null;
        }
        authV4WebView.setWebViewSettings(hiveWebViewClient, webChromeClient);
    }

    public void createWebView(HiveWebViewClient webViewClient) {
        View decorView;
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        Activity activity = this.activity;
        Resource resource = Resource.INSTANCE;
        activity.setContentView(resource.getLayoutId(activity, "hive_authv4_dialog"));
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        colorDrawable.setAlpha(204);
        Window window = this.activity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setBackground(colorDrawable);
        }
        Activity activity2 = this.activity;
        setWebView((HiveWebView) activity2.findViewById(resource.getViewId(activity2, "hive_authv4_webview")));
        getWebView().setBackgroundColor(0);
        Activity activity3 = this.activity;
        ProgressBar progressBar = (ProgressBar) activity3.findViewById(resource.getViewId(activity3, "hive_authv4_webview_spinner"));
        this.progressBar = progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        Activity activity4 = this.activity;
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) activity4.findViewById(resource.getViewId(activity4, "hive_authv4_close_button"));
        Activity activity5 = this.activity;
        if (activity5 instanceof HiveUiActivity) {
            Intrinsics.checkNotNull(activity5, "null cannot be cast to non-null type com.hive.ui.HiveUiActivity");
            if (!((HiveUiActivity) activity5).getHasCutoutLetterbox()) {
                Intrinsics.checkNotNull(hiveAnimationButton);
                ExtensionsKt.applyDisplayCutoutMargin(hiveAnimationButton);
            }
        }
        CloseButtonType closeButtonType = this.closeButtonType;
        Intrinsics.checkNotNull(hiveAnimationButton);
        setButtonType(closeButtonType, hiveAnimationButton);
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.authv4.webviewflow.AuthV4WebView.createWebView.1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                AuthV4WebView.this.dismiss();
            }
        });
        setWebViewSettings$default(this, webViewClient, null, 2, null);
    }

    public void dismiss() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (this.webView != null && getWebView().isShown()) {
            getWebView().stopLoading();
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.webviewflow.AuthV4WebView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4WebView.dismiss$lambda$0(this.f$0);
            }
        });
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final AuthV4WebViewListener getAuthV4WebViewDialogListener() {
        return this.authV4WebViewDialogListener;
    }

    public final CloseButtonType getCloseButtonType() {
        return this.closeButtonType;
    }

    public final String getHost() {
        return this.host;
    }

    /* JADX INFO: renamed from: getLoadingText$hive_service_release, reason: from getter */
    public final String getLoadingText() {
        return this.loadingText;
    }

    public final String getPostData() {
        return this.postData;
    }

    public final ProgressBar getProgressBar() {
        return this.progressBar;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final String getSelect() {
        return this.select;
    }

    public final String getUrl() {
        return this.url;
    }

    public final HiveWebView getWebView() {
        HiveWebView hiveWebView = this.webView;
        if (hiveWebView != null) {
            return hiveWebView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webView");
        return null;
    }

    /* JADX INFO: renamed from: getWebViewDescription$hive_service_release, reason: from getter */
    public final String getWebViewDescription() {
        return this.webViewDescription;
    }

    /* JADX INFO: renamed from: getWebViewErrorCode$hive_service_release, reason: from getter */
    public final int getWebViewErrorCode() {
        return this.webViewErrorCode;
    }

    /* JADX INFO: renamed from: getWebViewFailingUrl$hive_service_release, reason: from getter */
    public final String getWebViewFailingUrl() {
        return this.webViewFailingUrl;
    }

    public boolean handleHiveScheme(Uri uri) {
        String queryParameter;
        int i;
        int i2;
        String str = "JPEG";
        Intrinsics.checkNotNullParameter(uri, "uri");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL(AuthV4.getTAG(), "[AuthV4WebViewDialog] \nhandleHiveScheme: " + uri + '\n');
        loggerImpl.dR(AuthV4.getTAG(), "[AuthV4WebViewDialog] \nhandleHiveScheme: " + uri.toString().length() + '\n');
        String host = uri.getHost();
        if (host != null) {
            int iHashCode = host.hashCode();
            if (iHashCode != -1710539362) {
                if (iHashCode != -1205534488) {
                    if (iHashCode == 94756344) {
                        host.equals("close");
                    }
                } else if (host.equals("getpicture")) {
                    try {
                        queryParameter = uri.getQueryParameter("type");
                    } catch (Exception e) {
                        e.printStackTrace();
                        queryParameter = "gallery";
                    }
                    try {
                        String queryParameter2 = uri.getQueryParameter("maxLongSize");
                        if (queryParameter2 == null) {
                            queryParameter2 = "500";
                        }
                        i = Integer.parseInt(queryParameter2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        i = 500;
                    }
                    try {
                        String queryParameter3 = uri.getQueryParameter("outputFileType");
                        if (queryParameter3 != null) {
                            str = queryParameter3;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    try {
                        String queryParameter4 = uri.getQueryParameter("quality");
                        if (queryParameter4 == null) {
                            queryParameter4 = StatisticData.ERROR_CODE_NOT_FOUND;
                        }
                        i2 = Integer.parseInt(queryParameter4);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        i2 = 100;
                    }
                    if (Intrinsics.areEqual(queryParameter, "camera")) {
                        HivePicture.INSTANCE.getPictureFromCamera(i, str, i2, new HivePicture.HivePictureResultListener() { // from class: com.hive.authv4.webviewflow.AuthV4WebView.handleHiveScheme.1
                            @Override // com.hive.base.HivePicture.HivePictureResultListener
                            public void onHivePictureResult(ResultAPI result, String base64encodeString) {
                                Intrinsics.checkNotNullParameter(result, "result");
                                HiveWebView webView = AuthV4WebView.this.getWebView();
                                StringBuilder sb = new StringBuilder("javascript:window['native'].getPictureCallback('");
                                if (!result.isSuccess()) {
                                    base64encodeString = null;
                                }
                                if (base64encodeString == null) {
                                    base64encodeString = "";
                                }
                                sb.append(base64encodeString);
                                sb.append("')");
                                webView.loadUrl(sb.toString());
                            }
                        });
                        return true;
                    }
                    if (!Intrinsics.areEqual(queryParameter, "gallery")) {
                        return true;
                    }
                    HivePicture.INSTANCE.getPictureFromPhotoPicker(i, str, i2, new HivePicture.HivePictureResultListener() { // from class: com.hive.authv4.webviewflow.AuthV4WebView.handleHiveScheme.2
                        @Override // com.hive.base.HivePicture.HivePictureResultListener
                        public void onHivePictureResult(ResultAPI result, String base64encodeString) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            HiveWebView webView = AuthV4WebView.this.getWebView();
                            StringBuilder sb = new StringBuilder("javascript:window['native'].getPictureCallback('");
                            if (!result.isSuccess()) {
                                base64encodeString = null;
                            }
                            if (base64encodeString == null) {
                                base64encodeString = "";
                            }
                            sb.append(base64encodeString);
                            sb.append("')");
                            webView.loadUrl(sb.toString());
                        }
                    });
                    return true;
                }
            } else if (host.equals("openbrowser")) {
                try {
                    boolean booleanQueryParameter = uri.getBooleanQueryParameter("close", false);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(uri.getQueryParameter("url")));
                    this.activity.startActivity(intent);
                    if (!booleanQueryParameter) {
                        return true;
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
        this.select = uri.toString();
        dismiss();
        return true;
    }

    public boolean internalBackPressed$hive_service_release() {
        WebHistoryItem currentItem = getWebView().copyBackForwardList().getCurrentItem();
        if (!Intrinsics.areEqual(currentItem != null ? currentItem.getUrl() : null, this.url) && getWebView().canGoBack()) {
            getWebView().goBack();
            return true;
        }
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (getWebView().isShown()) {
            getWebView().stopLoading();
        }
        dismiss();
        return true;
    }

    public boolean onBackPressed() {
        return internalBackPressed$hive_service_release();
    }

    public final void setActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.activity = activity;
    }

    public final void setAuthV4WebViewDialogListener(AuthV4WebViewListener authV4WebViewListener) {
        this.authV4WebViewDialogListener = authV4WebViewListener;
    }

    public final void setButtonType(CloseButtonType buttonType, HiveAnimationButton button) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        Intrinsics.checkNotNullParameter(button, "button");
        int i = WhenMappings.$EnumSwitchMapping$0[buttonType.ordinal()];
        if (i == 1) {
            button.setVisibility(8);
            return;
        }
        if (i == 2) {
            button.setImageResource(R.drawable.hive_default_popup_btn_close_up_dark);
            button.setOffAnimationResourcesId(R.drawable.hive_default_popup_btn_close_down_dark);
            button.setOnAnimationResourcesId(R.drawable.hive_default_popup_btn_close_up_dark);
        } else {
            if (i != 3) {
                return;
            }
            button.setImageResource(R.drawable.hive_default_popup_btn_close_up);
            button.setOffAnimationResourcesId(R.drawable.hive_default_popup_btn_close_down);
            button.setOnAnimationResourcesId(R.drawable.hive_default_popup_btn_close_up);
        }
    }

    public final void setCloseButtonType(CloseButtonType closeButtonType) {
        Intrinsics.checkNotNullParameter(closeButtonType, "<set-?>");
        this.closeButtonType = closeButtonType;
    }

    public final void setHost(String str) {
        this.host = str;
    }

    public final void setLoadingText$hive_service_release(String str) {
        this.loadingText = str;
    }

    public final void setPostData(String str) {
        this.postData = str;
    }

    public final void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public final void setScheme(String str) {
        this.scheme = str;
    }

    public final void setSelect(String str) {
        this.select = str;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final void setWebView(HiveWebView hiveWebView) {
        Intrinsics.checkNotNullParameter(hiveWebView, "<set-?>");
        this.webView = hiveWebView;
    }

    public final void setWebViewDescription$hive_service_release(String str) {
        this.webViewDescription = str;
    }

    public final void setWebViewErrorCode$hive_service_release(int i) {
        this.webViewErrorCode = i;
    }

    public final void setWebViewFailingUrl$hive_service_release(String str) {
        this.webViewFailingUrl = str;
    }

    public final void setWebViewSettings(HiveWebViewClient webViewClient, WebChromeClient chromeClient) {
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        getWebView().getSettings().setBuiltInZoomControls(true);
        getWebView().getSettings().setUseWideViewPort(true);
        getWebView().getSettings().setDefaultTextEncodingName("UTF-8");
        getWebView().getSettings().setDomStorageEnabled(true);
        getWebView().setPadding(0, 0, 0, 0);
        getWebView().setWebViewClient(webViewClient);
        if (chromeClient != null) {
            getWebView().setWebChromeClient(chromeClient);
        }
        getWebView().getSettings().setJavaScriptEnabled(true);
        getWebView().getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getWebView().getSettings().setCacheMode(2);
    }

    public void show() {
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[AuthV4WebViewDialog] show");
        if (this.webView == null) {
            createWebView$default(this, null, 1, null);
        }
        loadWebView();
    }

    public /* synthetic */ AuthV4WebView(Activity activity, String str, String str2, String str3, String str4, CloseButtonType closeButtonType, AuthV4WebViewListener authV4WebViewListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? CloseButtonType.TYPE_NORMAL : closeButtonType, authV4WebViewListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthV4WebView(Activity activity, String url, String str, String str2, String str3, CloseButtonType buttonType, AuthV4WebViewListener onPostWebViewListener) {
        this(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        Intrinsics.checkNotNullParameter(onPostWebViewListener, "onPostWebViewListener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL(AuthV4.getTAG(), "[AuthV4WebViewDialog] \nurl : " + url + "\npostData : " + str);
        String tag = AuthV4.getTAG();
        StringBuilder sb = new StringBuilder("[AuthV4WebViewDialog] \nurl : ");
        sb.append(url);
        loggerImpl.dR(tag, sb.toString());
        this.url = url;
        this.postData = (str == null || StringsKt.isBlank(str)) ? "" : str;
        this.scheme = str2;
        this.host = str3;
        this.closeButtonType = buttonType;
        this.authV4WebViewDialogListener = onPostWebViewListener;
        createWebView$default(this, null, 1, null);
    }
}
