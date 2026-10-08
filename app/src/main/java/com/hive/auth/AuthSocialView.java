package com.hive.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.core.widget.ContentLoadingProgressBar;
import com.facebook.internal.NativeProtocol;
import com.hive.ResultAPI;
import com.hive.SocialHive;
import com.hive.base.Android;
import com.hive.base.HivePicture;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HiveUserEngagement;
import com.hive.protocol.UrlManager;
import com.hive.service.R;
import com.hive.social.HiveGraph;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.view.HiveAnimationButton;
import com.hive.webview.HiveSchemeHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002&'B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u000bJ\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001cH\u0003J\b\u0010\u001e\u001a\u00020\u001cH\u0003J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/hive/auth/AuthSocialView;", "", "activity", "Landroid/app/Activity;", "subPath", "", "closeHandler", "Lcom/hive/SocialHive$ShowHiveDialogDataListener;", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Lcom/hive/SocialHive$ShowHiveDialogDataListener;)V", "additionalInfo", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/hive/SocialHive$ShowHiveDialogDataListener;)V", "TAG", "kotlin.jvm.PlatformType", "url", "type", "Lcom/hive/SocialHive$HiveDialogType;", "closeParam", "Lorg/json/JSONObject;", "webView", "Lcom/hive/core/webview/HiveWebView;", "closeButton", "Lcom/hive/ui/view/HiveAnimationButton;", "progressBar", "Landroidx/core/widget/ContentLoadingProgressBar;", "originOrientation", "", "show", "", "onCreateView", "onCreateWebView", "loadUrlCI", "loadUrl", "showToast", "message", "dismiss", "onBackPressed", "", "AuthSocialSchemeHandler", "AuthSocialWebViewClient", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthSocialView {
    private final String TAG;
    private final Activity activity;
    private String additionalInfo;
    private HiveAnimationButton closeButton;
    private final SocialHive.ShowHiveDialogDataListener closeHandler;
    private JSONObject closeParam;
    private int originOrientation;
    private ContentLoadingProgressBar progressBar;
    private final String subPath;
    private SocialHive.HiveDialogType type;
    private String url;
    private HiveWebView webView;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lcom/hive/auth/AuthSocialView$AuthSocialSchemeHandler;", "Lcom/hive/webview/HiveSchemeHandler;", "<init>", "(Lcom/hive/auth/AuthSocialView;)V", "schemeEvent", "", "view", "Landroid/webkit/WebView;", "scheme", "Lcom/hive/core/Scheme;", "handleGetPictureScheme", "", NativeProtocol.WEB_DIALOG_PARAMS, "Lorg/json/JSONObject;", "handleOpenBrowserScheme", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AuthSocialSchemeHandler extends HiveSchemeHandler {
        public AuthSocialSchemeHandler() {
        }

        private final void handleGetPictureScheme(JSONObject params) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL(AuthSocialView.this.TAG, "handleGetPictureScheme [" + params + AbstractJsonLexerKt.END_LIST);
            loggerImpl.dR(AuthSocialView.this.TAG, "handleGetPictureScheme");
            String strOptString = params.optString("type", "gallery");
            int iOptInt = params.optInt("maxLongSize", 500);
            String strOptString2 = params.optString("outputFileType", "JPEG");
            int iOptInt2 = params.optInt("quality", 100);
            if (Intrinsics.areEqual(strOptString, "camera")) {
                HivePicture hivePicture = HivePicture.INSTANCE;
                Intrinsics.checkNotNull(strOptString2);
                final AuthSocialView authSocialView = AuthSocialView.this;
                hivePicture.getPictureFromCamera(iOptInt, strOptString2, iOptInt2, new HivePicture.HivePictureResultListener() { // from class: com.hive.auth.AuthSocialView$AuthSocialSchemeHandler$handleGetPictureScheme$1
                    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
                    @Override // com.hive.base.HivePicture.HivePictureResultListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void onHivePictureResult(com.hive.ResultAPI r4, java.lang.String r5) {
                        /*
                            r3 = this;
                            java.lang.String r0 = "result"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            com.hive.auth.AuthSocialView r0 = r1
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            java.lang.String r2 = "javascript:window['native'].getPictureCallback('"
                            r1.<init>(r2)
                            if (r5 == 0) goto L1a
                            boolean r4 = r4.isSuccess()
                            if (r4 == 0) goto L17
                            goto L18
                        L17:
                            r5 = 0
                        L18:
                            if (r5 != 0) goto L1c
                        L1a:
                            java.lang.String r5 = ""
                        L1c:
                            r1.append(r5)
                            java.lang.String r4 = "')"
                            r1.append(r4)
                            java.lang.String r4 = r1.toString()
                            com.hive.auth.AuthSocialView.access$loadUrl(r0, r4)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthSocialView$AuthSocialSchemeHandler$handleGetPictureScheme$1.onHivePictureResult(com.hive.ResultAPI, java.lang.String):void");
                    }
                });
                return;
            }
            if (Intrinsics.areEqual(strOptString, "gallery")) {
                HivePicture hivePicture2 = HivePicture.INSTANCE;
                Intrinsics.checkNotNull(strOptString2);
                final AuthSocialView authSocialView2 = AuthSocialView.this;
                hivePicture2.getPictureFromPhotoPicker(iOptInt, strOptString2, iOptInt2, new HivePicture.HivePictureResultListener() { // from class: com.hive.auth.AuthSocialView$AuthSocialSchemeHandler$handleGetPictureScheme$2
                    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
                    @Override // com.hive.base.HivePicture.HivePictureResultListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void onHivePictureResult(com.hive.ResultAPI r4, java.lang.String r5) {
                        /*
                            r3 = this;
                            java.lang.String r0 = "result"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            com.hive.auth.AuthSocialView r0 = r1
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            java.lang.String r2 = "javascript:window['native'].getPictureCallback('"
                            r1.<init>(r2)
                            if (r5 == 0) goto L1a
                            boolean r4 = r4.isSuccess()
                            if (r4 == 0) goto L17
                            goto L18
                        L17:
                            r5 = 0
                        L18:
                            if (r5 != 0) goto L1c
                        L1a:
                            java.lang.String r5 = ""
                        L1c:
                            r1.append(r5)
                            java.lang.String r4 = "')"
                            r1.append(r4)
                            java.lang.String r4 = r1.toString()
                            com.hive.auth.AuthSocialView.access$loadUrl(r0, r4)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthSocialView$AuthSocialSchemeHandler$handleGetPictureScheme$2.onHivePictureResult(com.hive.ResultAPI, java.lang.String):void");
                    }
                });
            }
        }

        private final void handleOpenBrowserScheme(JSONObject params) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL(AuthSocialView.this.TAG, "handleOpenBrowserScheme [" + params + AbstractJsonLexerKt.END_LIST);
            loggerImpl.dR(AuthSocialView.this.TAG, "handleOpenBrowserScheme");
            String strOptString = params.optString("url");
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(strOptString));
                AuthSocialView.this.activity.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                AuthSocialView.this.showToast("Browser does not exist.");
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00a7 A[Catch: Exception -> 0x015e, TryCatch #0 {Exception -> 0x015e, blocks: (B:3:0x0010, B:5:0x005a, B:7:0x0061, B:9:0x0072, B:10:0x007a, B:12:0x0080, B:15:0x008d, B:17:0x009b, B:19:0x00a7, B:21:0x00c0, B:22:0x00c7, B:16:0x0097, B:24:0x00cc, B:31:0x00e0, B:34:0x00e9, B:38:0x00f3, B:41:0x00fc, B:44:0x0108, B:46:0x012e, B:48:0x0132, B:50:0x013a, B:52:0x013e, B:55:0x0153), top: B:58:0x0010, inners: #1 }] */
        @Override // com.hive.webview.HiveSchemeHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean schemeEvent(android.webkit.WebView r10, com.hive.core.Scheme r11) {
            /*
                Method dump skipped, instruction units count: 351
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthSocialView.AuthSocialSchemeHandler.schemeEvent(android.webkit.WebView, com.hive.core.Scheme):boolean");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J,\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u0013"}, d2 = {"Lcom/hive/auth/AuthSocialView$AuthSocialWebViewClient;", "Lcom/hive/core/webview/HiveWebViewClient;", "<init>", "(Lcom/hive/auth/AuthSocialView;)V", "onPageStarted", "", "view", "Landroid/webkit/WebView;", "url", "", "favicon", "Landroid/graphics/Bitmap;", "onPageFinished", "receivedErrorEvent", "errorCode", "", "description", "failingUrl", "getUrlWithoutParameters", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AuthSocialWebViewClient extends HiveWebViewClient {
        public AuthSocialWebViewClient() {
            super(AuthSocialView.this.new AuthSocialSchemeHandler());
        }

        private final String getUrlWithoutParameters(String url) {
            Uri uri = Uri.parse(url);
            String string = new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).path(uri.getPath()).build().toString();
            Intrinsics.checkNotNullExpressionValue(string, "run(...)");
            return string;
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            LoggerImpl.INSTANCE.d(AuthSocialView.this.TAG, "AuthSocialWebViewClient onPageFinished url = " + url);
            ContentLoadingProgressBar contentLoadingProgressBar = AuthSocialView.this.progressBar;
            if (contentLoadingProgressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                contentLoadingProgressBar = null;
            }
            contentLoadingProgressBar.hide();
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageStarted(view, url, favicon);
            LoggerImpl.INSTANCE.d(AuthSocialView.this.TAG, "AuthSocialWebViewClient onPageStarted url = " + url);
            ContentLoadingProgressBar contentLoadingProgressBar = AuthSocialView.this.progressBar;
            if (contentLoadingProgressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                contentLoadingProgressBar = null;
            }
            contentLoadingProgressBar.show();
            if (StringsKt.contains$default((CharSequence) getUrlWithoutParameters(url), (CharSequence) UrlManager.Chatbot.INSTANCE.getChat(), false, 2, (Object) null)) {
                AuthSocialView.this.activity.setRequestedOrientation(1);
            } else if (AuthSocialView.this.activity.getRequestedOrientation() == 1) {
                AuthSocialView.this.activity.setRequestedOrientation(AuthSocialView.this.originOrientation);
            }
        }

        @Override // com.hive.core.webview.HiveWebViewClient
        public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            LoggerImpl.INSTANCE.d(AuthSocialView.this.TAG, "AuthSocialWebViewClient receivedErrorEvent error(" + errorCode + "):" + description + AbstractJsonLexerKt.END_OBJ);
            AuthSocialView authSocialView = AuthSocialView.this;
            StringBuilder sb = new StringBuilder("Error : ");
            sb.append(description);
            authSocialView.showToast(sb.toString());
        }
    }

    public AuthSocialView(Activity activity, String subPath, SocialHive.ShowHiveDialogDataListener closeHandler) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(subPath, "subPath");
        Intrinsics.checkNotNullParameter(closeHandler, "closeHandler");
        this.activity = activity;
        this.subPath = subPath;
        this.closeHandler = closeHandler;
        this.TAG = "AuthSocialView";
        this.originOrientation = 4;
        activity.setContentView(R.layout.hive_authv4_social_dialog);
        this.originOrientation = activity.getRequestedOrientation();
        onCreateView();
        onCreateWebView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$6(AuthSocialView authSocialView) {
        authSocialView.closeHandler.onShowHiveDialogWithData(new ResultAPI(-6, ResultAPI.Code.SocialHIVESocialDialogClosed, "User Cancel"), authSocialView.closeParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadUrl(final String url) {
        LoggerImpl.INSTANCE.d(this.TAG, "loadUrl() url = " + url);
        HiveWebView hiveWebView = this.webView;
        HiveWebView hiveWebView2 = null;
        if (hiveWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView = null;
        }
        hiveWebView.setOauthToken(HiveLifecycle.INSTANCE.getAccount().getOauthToken());
        HiveWebView hiveWebView3 = this.webView;
        if (hiveWebView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            hiveWebView2 = hiveWebView3;
        }
        hiveWebView2.post(new Runnable() { // from class: com.hive.auth.AuthSocialView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AuthSocialView.loadUrl$lambda$4(this.f$0, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadUrl$lambda$4(AuthSocialView authSocialView, String str) {
        HiveWebView hiveWebView = authSocialView.webView;
        if (hiveWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView = null;
        }
        hiveWebView.loadUrl(str);
    }

    private final void loadUrlCI(final String url) {
        HiveWebView hiveWebView = this.webView;
        if (hiveWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView = null;
        }
        hiveWebView.post(new Runnable() { // from class: com.hive.auth.AuthSocialView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthSocialView.loadUrlCI$lambda$3(this.f$0, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadUrlCI$lambda$3(AuthSocialView authSocialView, String str) {
        JSONObject jSONObject = new JSONObject();
        HiveKeys hiveKeys = HiveKeys.KEY_vid;
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        CommonIdentifierKt.put(jSONObject, hiveKeys, hiveLifecycle.getAccount().getVid());
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_vid_type, hiveLifecycle.getAccount().getVidType());
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_cookies, new JSONObject(HiveGraph.INSTANCE.getDefaultData()));
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_game_language, ConfigurationImpl.INSTANCE.getHiveLanguage());
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_is_gpg_emulator, Boolean.valueOf(Android.INSTANCE.isGPGEmulator()));
        SocialHive.HiveDialogType hiveDialogType = authSocialView.type;
        HiveWebView hiveWebView = null;
        if (hiveDialogType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            hiveDialogType = null;
        }
        if (hiveDialogType == SocialHive.HiveDialogType.MYINQUIRY) {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_anchor, "INQUIRIES");
        }
        String str2 = authSocialView.additionalInfo;
        if (str2 != null) {
            if (Intrinsics.areEqual(authSocialView.subPath, SocialHive.HiveDialogType.CHATBOT.getValue())) {
                JSONObject jSONObject2 = new JSONObject();
                CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_action, "click_chatbot");
                if (str2.length() == 0) {
                    CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_param, str2);
                } else {
                    CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_param, new JSONObject(str2));
                }
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_chatbot, jSONObject2.toString());
            } else if (str2.length() > 0) {
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_additionalInfo, str2);
            }
        }
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HiveUserEngagement.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HiveUserEngagement)) {
            hiveModule = null;
        }
        if (!(hiveModule instanceof HiveUserEngagement)) {
            hiveModule = null;
        }
        HiveUserEngagement hiveUserEngagement = (HiveUserEngagement) hiveModule;
        if (hiveUserEngagement != null) {
            hiveUserEngagement.appendEventQueryParameters(jSONObject);
        }
        HiveWebView hiveWebView2 = authSocialView.webView;
        if (hiveWebView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView2 = null;
        }
        hiveWebView2.setOauthToken(hiveLifecycle.getAccount().getOauthToken());
        HiveWebView hiveWebView3 = authSocialView.webView;
        if (hiveWebView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            hiveWebView = hiveWebView3;
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        hiveWebView.postUrlCI(str, bytes);
    }

    private final void onCreateView() {
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) this.activity.findViewById(R.id.closeButton);
        this.closeButton = hiveAnimationButton;
        ContentLoadingProgressBar contentLoadingProgressBar = null;
        if (hiveAnimationButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            hiveAnimationButton = null;
        }
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.auth.AuthSocialView.onCreateView.1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                AuthSocialView.this.dismiss();
            }
        });
        ContentLoadingProgressBar contentLoadingProgressBar2 = (ContentLoadingProgressBar) this.activity.findViewById(R.id.progressBar);
        this.progressBar = contentLoadingProgressBar2;
        if (contentLoadingProgressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        } else {
            contentLoadingProgressBar = contentLoadingProgressBar2;
        }
        contentLoadingProgressBar.hide();
    }

    private final void onCreateWebView() {
        HiveWebView hiveWebView = (HiveWebView) this.activity.findViewById(R.id.webView);
        this.webView = hiveWebView;
        HiveWebView hiveWebView2 = null;
        if (hiveWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView = null;
        }
        hiveWebView.setWebViewClient(new AuthSocialWebViewClient());
        HiveWebView hiveWebView3 = this.webView;
        if (hiveWebView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView3 = null;
        }
        hiveWebView3.setWebChromeClient(new WebChromeClient() { // from class: com.hive.auth.AuthSocialView.onCreateWebView.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                super.onConsoleMessage(consoleMessage);
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                String str = AuthSocialView.this.TAG;
                StringBuilder sb = new StringBuilder("ConsoleMessage message = ");
                sb.append(consoleMessage != null ? consoleMessage.message() : null);
                sb.append(", line = ");
                sb.append(consoleMessage != null ? Integer.valueOf(consoleMessage.lineNumber()) : null);
                loggerImpl.d(str, sb.toString());
                return true;
            }
        });
        HiveWebView hiveWebView4 = this.webView;
        if (hiveWebView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            hiveWebView2 = hiveWebView4;
        }
        WebSettings settings = hiveWebView2.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setCacheMode(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(final String message) {
        if (message == null || !(!StringsKt.isBlank(message))) {
            return;
        }
        this.activity.runOnUiThread(new Runnable() { // from class: com.hive.auth.AuthSocialView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthSocialView.showToast$lambda$5(this.f$0, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$5(AuthSocialView authSocialView, String str) {
        Toast.makeText(authSocialView.activity, str, 0).show();
    }

    public final void dismiss() {
        HiveWebView hiveWebView = this.webView;
        if (hiveWebView != null) {
            if (hiveWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                hiveWebView = null;
            }
            hiveWebView.stopLoading();
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthSocialView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AuthSocialView.dismiss$lambda$6(this.f$0);
            }
        });
    }

    public final boolean onBackPressed() {
        HiveWebView hiveWebView = this.webView;
        HiveWebView hiveWebView2 = null;
        if (hiveWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView = null;
        }
        if (!hiveWebView.canGoBackOrForward(-1)) {
            dismiss();
            return true;
        }
        HiveWebView hiveWebView3 = this.webView;
        if (hiveWebView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            hiveWebView2 = hiveWebView3;
        }
        hiveWebView2.goBackOrForward(-1);
        return true;
    }

    public final void show() {
        this.url = UrlManager.SocialWeb.INSTANCE.getUndefinedRequest() + this.subPath;
        SocialHive.HiveDialogType hiveDialogType = SocialHive.HiveDialogType.INQUIRY;
        this.type = hiveDialogType;
        String str = this.subPath;
        SocialHive.HiveDialogType hiveDialogType2 = SocialHive.HiveDialogType.MYINQUIRY;
        if (Intrinsics.areEqual(str, hiveDialogType2.getValue())) {
            this.type = hiveDialogType2;
            this.url = UrlManager.CustomerCenter.INSTANCE.getInquiry();
        } else if (Intrinsics.areEqual(str, hiveDialogType.getValue())) {
            this.url = UrlManager.CustomerCenter.INSTANCE.getInquiry();
        }
        String str2 = this.url;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
            str2 = null;
        }
        loadUrlCI(str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthSocialView(Activity activity, String subPath, String str, SocialHive.ShowHiveDialogDataListener closeHandler) {
        this(activity, subPath, closeHandler);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(subPath, "subPath");
        Intrinsics.checkNotNullParameter(closeHandler, "closeHandler");
        this.additionalInfo = str;
    }
}
