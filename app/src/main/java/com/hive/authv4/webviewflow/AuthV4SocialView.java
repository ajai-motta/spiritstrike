package com.hive.authv4.webviewflow;

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
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
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
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0004$%&'B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\fJ\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0003J\b\u0010\u001b\u001a\u00020\u0019H\u0003J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010!\u001a\u00020\u0019J\u0006\u0010\"\u001a\u00020#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4SocialView;", "", "activity", "Landroid/app/Activity;", "type", "Lcom/hive/authv4/webviewflow/AuthV4SocialView$DialogType;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/webviewflow/AuthV4SocialView$DismissListener;", "<init>", "(Landroid/app/Activity;Lcom/hive/authv4/webviewflow/AuthV4SocialView$DialogType;Lcom/hive/authv4/webviewflow/AuthV4SocialView$DismissListener;)V", "additionalInfo", "", "(Landroid/app/Activity;Lcom/hive/authv4/webviewflow/AuthV4SocialView$DialogType;Ljava/lang/String;Lcom/hive/authv4/webviewflow/AuthV4SocialView$DismissListener;)V", "TAG", "kotlin.jvm.PlatformType", "webView", "Lcom/hive/core/webview/HiveWebView;", "closeButton", "Lcom/hive/ui/view/HiveAnimationButton;", "progressBar", "Landroidx/core/widget/ContentLoadingProgressBar;", "originOrientation", "", "chatbotJsonString", "show", "", "onCreateView", "onCreateWebView", "loadUrlCI", "url", "loadUrl", "showToast", "message", "dismiss", "onBackPressed", "", "DismissListener", "AuthV4SocialSchemeHandler", "AuthV4SocialWebViewClient", "DialogType", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4SocialView {
    private final String TAG;
    private final Activity activity;
    private String chatbotJsonString;
    private HiveAnimationButton closeButton;
    private final DismissListener listener;
    private int originOrientation;
    private ContentLoadingProgressBar progressBar;
    private final DialogType type;
    private HiveWebView webView;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4SocialView$AuthV4SocialSchemeHandler;", "Lcom/hive/webview/HiveSchemeHandler;", "<init>", "(Lcom/hive/authv4/webviewflow/AuthV4SocialView;)V", "schemeEvent", "", "view", "Landroid/webkit/WebView;", "scheme", "Lcom/hive/core/Scheme;", "handleGetPictureScheme", "", NativeProtocol.WEB_DIALOG_PARAMS, "Lorg/json/JSONObject;", "handleOpenBrowserScheme", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AuthV4SocialSchemeHandler extends HiveSchemeHandler {
        public AuthV4SocialSchemeHandler() {
        }

        private final void handleGetPictureScheme(JSONObject params) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL(AuthV4SocialView.this.TAG, "handleGetPictureScheme [" + params + AbstractJsonLexerKt.END_LIST);
            loggerImpl.dR(AuthV4SocialView.this.TAG, "handleGetPictureScheme");
            String strOptString = params.optString("type", "gallery");
            int iOptInt = params.optInt("maxLongSize", 500);
            String strOptString2 = params.optString("outputFileType", "JPEG");
            int iOptInt2 = params.optInt("quality", 100);
            if (Intrinsics.areEqual(strOptString, "camera")) {
                HivePicture hivePicture = HivePicture.INSTANCE;
                Intrinsics.checkNotNull(strOptString2);
                final AuthV4SocialView authV4SocialView = AuthV4SocialView.this;
                hivePicture.getPictureFromCamera(iOptInt, strOptString2, iOptInt2, new HivePicture.HivePictureResultListener() { // from class: com.hive.authv4.webviewflow.AuthV4SocialView$AuthV4SocialSchemeHandler$handleGetPictureScheme$1
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
                            com.hive.authv4.webviewflow.AuthV4SocialView r0 = r1
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
                            com.hive.authv4.webviewflow.AuthV4SocialView.access$loadUrl(r0, r4)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.webviewflow.AuthV4SocialView$AuthV4SocialSchemeHandler$handleGetPictureScheme$1.onHivePictureResult(com.hive.ResultAPI, java.lang.String):void");
                    }
                });
                return;
            }
            if (Intrinsics.areEqual(strOptString, "gallery")) {
                HivePicture hivePicture2 = HivePicture.INSTANCE;
                Intrinsics.checkNotNull(strOptString2);
                final AuthV4SocialView authV4SocialView2 = AuthV4SocialView.this;
                hivePicture2.getPictureFromPhotoPicker(iOptInt, strOptString2, iOptInt2, new HivePicture.HivePictureResultListener() { // from class: com.hive.authv4.webviewflow.AuthV4SocialView$AuthV4SocialSchemeHandler$handleGetPictureScheme$2
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
                            com.hive.authv4.webviewflow.AuthV4SocialView r0 = r1
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
                            com.hive.authv4.webviewflow.AuthV4SocialView.access$loadUrl(r0, r4)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.webviewflow.AuthV4SocialView$AuthV4SocialSchemeHandler$handleGetPictureScheme$2.onHivePictureResult(com.hive.ResultAPI, java.lang.String):void");
                    }
                });
            }
        }

        private final void handleOpenBrowserScheme(JSONObject params) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL(AuthV4SocialView.this.TAG, "handleOpenBrowserScheme [" + params + AbstractJsonLexerKt.END_LIST);
            loggerImpl.dR(AuthV4SocialView.this.TAG, "handleOpenBrowserScheme");
            String strOptString = params.optString("url");
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(strOptString));
                AuthV4SocialView.this.activity.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                AuthV4SocialView.this.showToast("Browser does not exist.");
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00a6 A[Catch: Exception -> 0x015d, TryCatch #0 {Exception -> 0x015d, blocks: (B:3:0x000f, B:5:0x0059, B:7:0x0060, B:9:0x0071, B:10:0x0079, B:12:0x007f, B:15:0x008c, B:17:0x009a, B:19:0x00a6, B:21:0x00bf, B:22:0x00c6, B:16:0x0096, B:24:0x00cb, B:31:0x00df, B:34:0x00e8, B:38:0x00f2, B:41:0x00fb, B:44:0x0107, B:46:0x012d, B:48:0x0131, B:50:0x0139, B:52:0x013d, B:55:0x0152), top: B:58:0x000f, inners: #1 }] */
        @Override // com.hive.webview.HiveSchemeHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean schemeEvent(android.webkit.WebView r10, com.hive.core.Scheme r11) {
            /*
                Method dump skipped, instruction units count: 350
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.webviewflow.AuthV4SocialView.AuthV4SocialSchemeHandler.schemeEvent(android.webkit.WebView, com.hive.core.Scheme):boolean");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J,\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u0013"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4SocialView$AuthV4SocialWebViewClient;", "Lcom/hive/core/webview/HiveWebViewClient;", "<init>", "(Lcom/hive/authv4/webviewflow/AuthV4SocialView;)V", "onPageStarted", "", "view", "Landroid/webkit/WebView;", "url", "", "favicon", "Landroid/graphics/Bitmap;", "onPageFinished", "receivedErrorEvent", "errorCode", "", "description", "failingUrl", "getUrlWithoutParameters", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AuthV4SocialWebViewClient extends HiveWebViewClient {
        public AuthV4SocialWebViewClient() {
            super(AuthV4SocialView.this.new AuthV4SocialSchemeHandler());
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
            LoggerImpl.INSTANCE.d(AuthV4SocialView.this.TAG, "AuthV4SocialWebViewClient onPageFinished url = " + url);
            ContentLoadingProgressBar contentLoadingProgressBar = AuthV4SocialView.this.progressBar;
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
            LoggerImpl.INSTANCE.d(AuthV4SocialView.this.TAG, "AuthV4SocialWebViewClient onPageStarted url = " + url);
            ContentLoadingProgressBar contentLoadingProgressBar = AuthV4SocialView.this.progressBar;
            if (contentLoadingProgressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                contentLoadingProgressBar = null;
            }
            contentLoadingProgressBar.show();
            if (StringsKt.contains$default((CharSequence) getUrlWithoutParameters(url), (CharSequence) UrlManager.Chatbot.INSTANCE.getChat(), false, 2, (Object) null)) {
                AuthV4SocialView.this.activity.setRequestedOrientation(1);
            } else if (AuthV4SocialView.this.activity.getRequestedOrientation() == 1) {
                AuthV4SocialView.this.activity.setRequestedOrientation(AuthV4SocialView.this.originOrientation);
            }
        }

        @Override // com.hive.core.webview.HiveWebViewClient
        public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            LoggerImpl.INSTANCE.d(AuthV4SocialView.this.TAG, "AuthV4SocialWebViewClient receivedErrorEvent error(" + errorCode + "):" + description + AbstractJsonLexerKt.END_OBJ);
            AuthV4SocialView authV4SocialView = AuthV4SocialView.this;
            StringBuilder sb = new StringBuilder("Error : ");
            sb.append(description);
            authV4SocialView.showToast(sb.toString());
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4SocialView$DialogType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INQUIRY", "MYINQUIRY", "CHATBOT", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DialogType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DialogType[] $VALUES;
        private final String value;
        public static final DialogType INQUIRY = new DialogType("INQUIRY", 0, "inquiry");
        public static final DialogType MYINQUIRY = new DialogType("MYINQUIRY", 1, "myinquiry");
        public static final DialogType CHATBOT = new DialogType("CHATBOT", 2, "chatbot");

        private static final /* synthetic */ DialogType[] $values() {
            return new DialogType[]{INQUIRY, MYINQUIRY, CHATBOT};
        }

        static {
            DialogType[] dialogTypeArr$values = $values();
            $VALUES = dialogTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(dialogTypeArr$values);
        }

        private DialogType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<DialogType> getEntries() {
            return $ENTRIES;
        }

        public static DialogType valueOf(String str) {
            return (DialogType) Enum.valueOf(DialogType.class, str);
        }

        public static DialogType[] values() {
            return (DialogType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4SocialView$DismissListener;", "", "onDismiss", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DismissListener {
        void onDismiss(ResultAPI result);
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DialogType.values().length];
            try {
                iArr[DialogType.INQUIRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DialogType.MYINQUIRY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DialogType.CHATBOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AuthV4SocialView(Activity activity, DialogType type, DismissListener dismissListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(type, "type");
        this.activity = activity;
        this.type = type;
        this.listener = dismissListener;
        this.TAG = "AuthV4SocialView";
        this.originOrientation = 4;
        activity.setContentView(R.layout.hive_authv4_social_dialog);
        this.originOrientation = activity.getRequestedOrientation();
        onCreateView();
        onCreateWebView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$5(AuthV4SocialView authV4SocialView) {
        DismissListener dismissListener = authV4SocialView.listener;
        if (dismissListener != null) {
            dismissListener.onDismiss(new ResultAPI(-6, ResultAPI.Code.SocialHIVESocialDialogClosed, "User Cancel"));
        }
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
        hiveWebView2.post(new Runnable() { // from class: com.hive.authv4.webviewflow.AuthV4SocialView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4SocialView.loadUrl$lambda$3(this.f$0, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadUrl$lambda$3(AuthV4SocialView authV4SocialView, String str) {
        HiveWebView hiveWebView = authV4SocialView.webView;
        if (hiveWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView = null;
        }
        hiveWebView.loadUrl(str);
    }

    private final void loadUrlCI(final String url) {
        LoggerImpl.INSTANCE.d(this.TAG, "loadUrlCI() url = " + url);
        HiveWebView hiveWebView = this.webView;
        if (hiveWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView = null;
        }
        hiveWebView.post(new Runnable() { // from class: com.hive.authv4.webviewflow.AuthV4SocialView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4SocialView.loadUrlCI$lambda$2(this.f$0, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadUrlCI$lambda$2(AuthV4SocialView authV4SocialView, String str) {
        JSONObject jSONObject = new JSONObject();
        HiveKeys hiveKeys = HiveKeys.KEY_vid;
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        CommonIdentifierKt.put(jSONObject, hiveKeys, hiveLifecycle.getAccount().getVid());
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_vid_type, hiveLifecycle.getAccount().getVidType());
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_cookies, new JSONObject(HiveGraph.INSTANCE.getDefaultData()));
        HiveKeys hiveKeys2 = HiveKeys.KEY_game_language;
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        CommonIdentifierKt.put(jSONObject, hiveKeys2, configurationImpl.getHiveLanguage());
        HiveKeys hiveKeys3 = HiveKeys.KEY_hive_theme;
        String value = configurationImpl.getHiveTheme().getValue();
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = value.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        CommonIdentifierKt.put(jSONObject, hiveKeys3, lowerCase);
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_is_gpg_emulator, Boolean.valueOf(Android.INSTANCE.isGPGEmulator()));
        if (authV4SocialView.type == DialogType.MYINQUIRY) {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_anchor, "INQUIRIES");
        }
        HiveWebView hiveWebView = null;
        if (authV4SocialView.chatbotJsonString != null) {
            JSONObject jSONObject2 = new JSONObject();
            CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_action, "click_chatbot");
            String str2 = authV4SocialView.chatbotJsonString;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatbotJsonString");
                str2 = null;
            }
            if (str2.length() == 0) {
                HiveKeys hiveKeys4 = HiveKeys.KEY_param;
                String str3 = authV4SocialView.chatbotJsonString;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatbotJsonString");
                    str3 = null;
                }
                CommonIdentifierKt.put(jSONObject2, hiveKeys4, str3);
            } else {
                HiveKeys hiveKeys5 = HiveKeys.KEY_param;
                String str4 = authV4SocialView.chatbotJsonString;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatbotJsonString");
                    str4 = null;
                }
                CommonIdentifierKt.put(jSONObject2, hiveKeys5, new JSONObject(str4));
            }
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_chatbot, jSONObject2.toString());
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
        HiveWebView hiveWebView2 = authV4SocialView.webView;
        if (hiveWebView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView2 = null;
        }
        hiveWebView2.setOauthToken(hiveLifecycle.getAccount().getOauthToken());
        HiveWebView hiveWebView3 = authV4SocialView.webView;
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
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.authv4.webviewflow.AuthV4SocialView.onCreateView.1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                AuthV4SocialView.this.dismiss();
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
        hiveWebView.setWebViewClient(new AuthV4SocialWebViewClient());
        HiveWebView hiveWebView3 = this.webView;
        if (hiveWebView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView3 = null;
        }
        hiveWebView3.setWebChromeClient(new WebChromeClient() { // from class: com.hive.authv4.webviewflow.AuthV4SocialView.onCreateWebView.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                super.onConsoleMessage(consoleMessage);
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                String str = AuthV4SocialView.this.TAG;
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
        this.activity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.webviewflow.AuthV4SocialView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4SocialView.showToast$lambda$4(this.f$0, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$4(AuthV4SocialView authV4SocialView, String str) {
        Toast.makeText(authV4SocialView.activity, str, 0).show();
    }

    public final void dismiss() {
        LoggerImpl.INSTANCE.d(this.TAG, "dismiss()");
        HiveWebView hiveWebView = this.webView;
        if (hiveWebView != null) {
            if (hiveWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                hiveWebView = null;
            }
            hiveWebView.stopLoading();
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.webviewflow.AuthV4SocialView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4SocialView.dismiss$lambda$5(this.f$0);
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
        int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        loadUrlCI(UrlManager.CustomerCenter.INSTANCE.getInquiry());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthV4SocialView(Activity activity, DialogType type, String additionalInfo, DismissListener dismissListener) {
        this(activity, type, dismissListener);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        if (type == DialogType.CHATBOT) {
            this.chatbotJsonString = additionalInfo;
        }
    }
}
