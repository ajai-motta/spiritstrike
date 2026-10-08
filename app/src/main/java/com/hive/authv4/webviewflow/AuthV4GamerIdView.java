package com.hive.authv4.webviewflow;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.core.provider.FontsContractCompat;
import com.hive.ResultAPI;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.logger.LoggerImpl;
import com.hive.service.R;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.Util;
import com.hive.webview.HiveSchemeHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001'B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020!J\u0006\u0010%\u001a\u00020&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4GamerIdView;", "", "activity", "Landroid/app/Activity;", "url", "", "basePostData", "Lorg/json/JSONObject;", "dismissListener", "Lcom/hive/authv4/webviewflow/AuthV4GamerIdView$DismissListener;", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Lorg/json/JSONObject;Lcom/hive/authv4/webviewflow/AuthV4GamerIdView$DismissListener;)V", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "webView", "Lcom/hive/core/webview/HiveWebView;", "getWebView", "()Lcom/hive/core/webview/HiveWebView;", "setWebView", "(Lcom/hive/core/webview/HiveWebView;)V", "returnResultAPI", "Lcom/hive/ResultAPI;", "getReturnResultAPI", "()Lcom/hive/ResultAPI;", "setReturnResultAPI", "(Lcom/hive/ResultAPI;)V", "player", "getPlayer", "setPlayer", "(Ljava/lang/String;)V", "show", "", "onCreateWebView", "loadUrl", "dismiss", "onBackPressed", "", "DismissListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4GamerIdView {
    private final String TAG;
    private final Activity activity;
    private final JSONObject basePostData;
    private DismissListener dismissListener;
    private String player;
    private ResultAPI returnResultAPI;
    private final String url;
    public HiveWebView webView;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4GamerIdView$DismissListener;", "", "onDismiss", "", "resultAPI", "Lcom/hive/ResultAPI;", "player", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DismissListener {
        void onDismiss(ResultAPI resultAPI, String player);
    }

    public AuthV4GamerIdView(Activity activity, String url, JSONObject jSONObject, DismissListener dismissListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(dismissListener, "dismissListener");
        this.activity = activity;
        this.url = url;
        this.basePostData = jSONObject;
        this.dismissListener = dismissListener;
        this.TAG = "AuthV4GamerIdView";
        this.player = "";
        activity.setContentView(R.layout.hive_authv4_gamer_id_dialog);
        Util.INSTANCE.hideSystemUI(activity.getWindow());
        onCreateWebView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$2(AuthV4GamerIdView authV4GamerIdView) {
        ResultAPI resultAPI = authV4GamerIdView.returnResultAPI;
        if (resultAPI != null) {
            authV4GamerIdView.dismissListener.onDismiss(resultAPI, authV4GamerIdView.player);
        } else {
            authV4GamerIdView.dismissListener.onDismiss(new ResultAPI(-98, ResultAPI.Code.CommonUnknown, "AuthV4GamerIdGamerIdDialog resultAPI not set"), authV4GamerIdView.player);
        }
    }

    private final void loadUrl() {
        getWebView().setOauthToken(HiveLifecycle.INSTANCE.getAccount().getOauthToken());
        JSONObject jSONObject = this.basePostData;
        if (jSONObject == null) {
            getWebView().loadUrl(this.url);
            return;
        }
        HiveWebView webView = getWebView();
        String str = this.url;
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        webView.postUrl(str, bytes);
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.hive.authv4.webviewflow.AuthV4GamerIdView$onCreateWebView$schemeHandler$1] */
    private final void onCreateWebView() {
        setWebView((HiveWebView) this.activity.findViewById(R.id.webView));
        getWebView().getSettings().setJavaScriptEnabled(true);
        getWebView().getSettings().setLoadWithOverviewMode(true);
        getWebView().getSettings().setUseWideViewPort(true);
        getWebView().getSettings().setCacheMode(-1);
        getWebView().getSettings().setDefaultTextEncodingName("UTF-8");
        getWebView().setWebChromeClient(new WebChromeClient() { // from class: com.hive.authv4.webviewflow.AuthV4GamerIdView.onCreateWebView.1
        });
        getWebView().setWebViewClient(new HiveWebViewClient(new HiveSchemeHandler() { // from class: com.hive.authv4.webviewflow.AuthV4GamerIdView$onCreateWebView$schemeHandler$1
            @Override // com.hive.webview.HiveSchemeHandler
            public boolean schemeEvent(WebView view, Scheme scheme) {
                ResultAPI resultAPI;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                loggerImpl.dL(this.this$0.getTAG(), "[AuthV4GamerIdDialog] schemeEvent \n " + scheme);
                loggerImpl.dR(this.this$0.getTAG(), "[AuthV4GamerIdDialog] schemeEvent");
                if (!Intrinsics.areEqual(scheme.getScheme(), "hive") || !Intrinsics.areEqual(scheme.getHost(), "gamerid")) {
                    return false;
                }
                Map<String, String> parameter = scheme.getParameter();
                String str = parameter.get(FontsContractCompat.Columns.RESULT_CODE);
                int i = str != null ? Integer.parseInt(str) : 0;
                String str2 = parameter.get("result_msg");
                if (str2 == null) {
                    str2 = "";
                }
                AuthV4GamerIdView authV4GamerIdView = this.this$0;
                String str3 = parameter.get("player");
                authV4GamerIdView.setPlayer(str3 != null ? str3 : "");
                AuthV4GamerIdView authV4GamerIdView2 = this.this$0;
                if (i != 0) {
                    loggerImpl.w(authV4GamerIdView2.getTAG(), "[AuthV4GamerIdDialog] schemeEvent() InvalidResponseData resultCode: " + i + ", resultMsg: " + str2);
                    resultAPI = new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidResponseData);
                } else if (StringsKt.isBlank(authV4GamerIdView2.getPlayer())) {
                    loggerImpl.d(this.this$0.getTAG(), "[AuthV4GamerIdDialog] schemeEvent() player is empty");
                    resultAPI = new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidResponseData);
                } else {
                    resultAPI = new ResultAPI();
                }
                authV4GamerIdView2.setReturnResultAPI(resultAPI);
                this.this$0.dismiss();
                return true;
            }
        }) { // from class: com.hive.authv4.webviewflow.AuthV4GamerIdView.onCreateWebView.2
            @Override // com.hive.core.webview.HiveWebViewClient
            public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
                Intrinsics.checkNotNullParameter(view, "view");
                LoggerImpl.INSTANCE.d(this.getTAG(), StringsKt.trimIndent("\n                    \n                    receivedErrorEvent()\n                    errorCode: " + errorCode + "\n                    description: " + description + "\n                    failingUrl: " + failingUrl + "\n                    \n                "));
                this.setReturnResultAPI(new ResultAPI(-5, ResultAPI.Code.AuthV4NetworkError));
                this.dismiss();
            }
        });
    }

    public final void dismiss() {
        if (this.webView != null && getWebView().isShown()) {
            getWebView().stopLoading();
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.webviewflow.AuthV4GamerIdView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4GamerIdView.dismiss$lambda$2(this.f$0);
            }
        });
    }

    public final String getPlayer() {
        return this.player;
    }

    public final ResultAPI getReturnResultAPI() {
        return this.returnResultAPI;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final HiveWebView getWebView() {
        HiveWebView hiveWebView = this.webView;
        if (hiveWebView != null) {
            return hiveWebView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webView");
        return null;
    }

    public final boolean onBackPressed() {
        this.returnResultAPI = new ResultAPI(-6, ResultAPI.Code.AuthV4CancelDialog);
        dismiss();
        return true;
    }

    public final void setPlayer(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.player = str;
    }

    public final void setReturnResultAPI(ResultAPI resultAPI) {
        this.returnResultAPI = resultAPI;
    }

    public final void setWebView(HiveWebView hiveWebView) {
        Intrinsics.checkNotNullParameter(hiveWebView, "<set-?>");
        this.webView = hiveWebView;
    }

    public final void show() {
        loadUrl();
    }
}
