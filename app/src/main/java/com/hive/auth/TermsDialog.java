package com.hive.auth;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.adjust.sdk.Constants;
import com.hive.auth.TermsDialog;
import com.hive.base.Android;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.logger.LoggerImpl;
import com.hive.ui.Resource;
import com.hive.ui.Util;
import com.hive.ui.effect.TouchEffectKt;
import com.hive.webview.HiveSchemeHandler;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 ,2\u00020\u0001:\u0003,-.B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\r\u0010\u0017\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0011H\u0016J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/hive/auth/TermsDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "mSpinner", "Landroid/app/ProgressDialog;", "webView", "Lcom/hive/core/webview/HiveWebView;", "mainLayout", "Landroid/widget/LinearLayout;", "url", "", "scale", "", "destroyed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setUrl", "destroy", "destroy$hive_service_release", "loadBitmap", "Landroid/graphics/Bitmap;", "filePath", "createTitle", "createWebViewForKindle", "createWebView", "onBackPressed", "onKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onWindowFocusChanged", "hasFocus", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setContentTermsView", k.M, "WebViewType", "UserAgreeWebViewClient", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TermsDialog extends Dialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float[] DIMENSIONS_DIFF_LANDSCAPE = {50.0f, 50.0f};
    private static final float[] DIMENSIONS_DIFF_PORTRAIT = {50.0f, 50.0f};
    public static final String THIRD_PARTY_LOGO_NAME = "auth_terms_logo";
    private volatile boolean destroyed;
    private ProgressDialog mSpinner;
    private LinearLayout mainLayout;
    private float scale;
    private String url;
    private HiveWebView webView;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/hive/auth/TermsDialog$Companion;", "", "<init>", "()V", "DIMENSIONS_DIFF_LANDSCAPE", "", "getDIMENSIONS_DIFF_LANDSCAPE$hive_service_release", "()[F", "DIMENSIONS_DIFF_PORTRAIT", "getDIMENSIONS_DIFF_PORTRAIT$hive_service_release", "THIRD_PARTY_LOGO_NAME", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float[] getDIMENSIONS_DIFF_LANDSCAPE$hive_service_release() {
            return TermsDialog.DIMENSIONS_DIFF_LANDSCAPE;
        }

        public final float[] getDIMENSIONS_DIFF_PORTRAIT$hive_service_release() {
            return TermsDialog.DIMENSIONS_DIFF_PORTRAIT;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0013"}, d2 = {"Lcom/hive/auth/TermsDialog$UserAgreeWebViewClient;", "Lcom/hive/core/webview/HiveWebViewClient;", "<init>", "(Lcom/hive/auth/TermsDialog;)V", "onReceivedHttpError", "", "view", "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onPageStarted", "url", "", "favicon", "Landroid/graphics/Bitmap;", "onPageFinished", "onLoadResource", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class UserAgreeWebViewClient extends HiveWebViewClient {
        public UserAgreeWebViewClient() {
            super(new HiveSchemeHandler());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPageStarted$lambda$0(TermsDialog termsDialog) {
            ProgressDialog progressDialog = termsDialog.mSpinner;
            if (progressDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpinner");
                progressDialog = null;
            }
            progressDialog.show();
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[UserAgreeDialog][onLoadResource]" + url);
            super.onLoadResource(view, url);
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[UserAgreeDialog][UserAgreeWebViewClient][onPageFinished]" + url);
            ProgressDialog progressDialog = TermsDialog.this.mSpinner;
            ProgressDialog progressDialog2 = null;
            if (progressDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpinner");
                progressDialog = null;
            }
            if (progressDialog.isShowing()) {
                ProgressDialog progressDialog3 = TermsDialog.this.mSpinner;
                if (progressDialog3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSpinner");
                } else {
                    progressDialog2 = progressDialog3;
                }
                progressDialog2.dismiss();
            }
            view.clearCache(true);
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[UserAgreeDialog][UserAgreeWebViewClient][onPageStarted]" + url);
            super.onPageStarted(view, url, favicon);
            ProgressDialog progressDialog = TermsDialog.this.mSpinner;
            if (progressDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpinner");
                progressDialog = null;
            }
            if (progressDialog.isShowing() || TermsDialog.this.destroyed) {
                return;
            }
            Android android2 = Android.INSTANCE;
            final TermsDialog termsDialog = TermsDialog.this;
            android2.runOnMainThread(new Runnable() { // from class: com.hive.auth.TermsDialog$UserAgreeWebViewClient$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TermsDialog.UserAgreeWebViewClient.onPageStarted$lambda$0(termsDialog);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            Intrinsics.checkNotNullParameter(view, "view");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String tag = AuthDataInterface.getTAG();
            StringBuilder sb = new StringBuilder("[UserAgreeDialog][UserAgreeWebViewClient][onReceivedHttpError] url : ");
            sb.append(request != null ? request.getUrl() : null);
            loggerImpl.d(tag, sb.toString());
            String tag2 = AuthDataInterface.getTAG();
            StringBuilder sb2 = new StringBuilder("[UserAgreeDialog][UserAgreeWebViewClient][onReceivedHttpError] statusCode : ");
            sb2.append(errorResponse != null ? Integer.valueOf(errorResponse.getStatusCode()) : null);
            loggerImpl.d(tag2, sb2.toString());
            super.onReceivedHttpError(view, request, errorResponse);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/auth/TermsDialog$WebViewType;", "", "<init>", "(Ljava/lang/String;I)V", "Kindle", "Other", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WebViewType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ WebViewType[] $VALUES;
        public static final WebViewType Kindle = new WebViewType("Kindle", 0);
        public static final WebViewType Other = new WebViewType("Other", 1);

        private static final /* synthetic */ WebViewType[] $values() {
            return new WebViewType[]{Kindle, Other};
        }

        static {
            WebViewType[] webViewTypeArr$values = $values();
            $VALUES = webViewTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(webViewTypeArr$values);
        }

        private WebViewType(String str, int i) {
        }

        public static EnumEntries<WebViewType> getEntries() {
            return $ENTRIES;
        }

        public static WebViewType valueOf(String str) {
            return (WebViewType) Enum.valueOf(WebViewType.class, str);
        }

        public static WebViewType[] values() {
            return (WebViewType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TermsDialog(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    private final void createTitle() {
        this.scale = getContext().getResources().getDisplayMetrics().density;
        requestWindowFeature(1);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        String appId = configurationImpl.getAppId();
        if (StringsKt.endsWith(appId, "huawei", true) || StringsKt.endsWith(appId, "gamecenter", true) || StringsKt.endsWith(appId, Constants.REFERRER_API_VIVO, true) || StringsKt.endsWith(appId, "mi", true)) {
            LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "Remove CI for china module");
        } else {
            AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
            int companyIndex = configurationImpl.getCompanyIndex();
            String str = companyIndex != 1 ? companyIndex != 2 ? THIRD_PARTY_LOGO_NAME : "auth_terms_logo_com2us_holdings" : "auth_terms_logo_com2us";
            Resource resource = Resource.INSTANCE;
            Context context = appCompatImageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int drawableId = resource.getDrawableId(context, str);
            if (drawableId == 0) {
                LoggerImpl.INSTANCE.d("[TermsDialog] Can't find logo resource.");
            } else if ((!StringsKt.equals(configurationImpl.getHiveCountry(), "cn", true) && !StringsKt.equals(configurationImpl.getHiveCountry(), "vn", true)) || !StringsKt.startsWith(appId, "com.com2us.smon", true)) {
                appCompatImageView.setImageResource(drawableId);
            }
            appCompatImageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(9);
            layoutParams.addRule(13);
            layoutParams.leftMargin = (int) (13 * this.scale);
            relativeLayout.addView(appCompatImageView, layoutParams);
        }
        AppCompatImageView appCompatImageView2 = new AppCompatImageView(getContext());
        Resource resource2 = Resource.INSTANCE;
        Context context2 = appCompatImageView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        appCompatImageView2.setImageResource(resource2.getDrawableId(context2, "auth_terms_btn_x"));
        appCompatImageView2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        TouchEffectKt.setTouchEffect(appCompatImageView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.auth.TermsDialog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TermsDialog.createTitle$lambda$7$lambda$6(this.f$0, (View) obj);
            }
        } : null);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        relativeLayout.addView(appCompatImageView2, layoutParams2);
        relativeLayout.setBackgroundColor(Color.rgb(167, 169, 171));
        LinearLayout linearLayout = this.mainLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainLayout");
            linearLayout = null;
        }
        linearLayout.addView(relativeLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createTitle$lambda$7$lambda$6(TermsDialog termsDialog, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        termsDialog.destroy$hive_service_release();
        return Unit.INSTANCE;
    }

    private final void createWebView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        HiveWebView hiveWebView = new HiveWebView(context);
        this.webView = hiveWebView;
        hiveWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        HiveWebView hiveWebView2 = this.webView;
        LinearLayout linearLayout2 = null;
        if (hiveWebView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView2 = null;
        }
        hiveWebView2.setWebViewClient(new UserAgreeWebViewClient());
        HiveWebView hiveWebView3 = this.webView;
        if (hiveWebView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView3 = null;
        }
        hiveWebView3.getSettings().setJavaScriptEnabled(true);
        String str = this.url;
        if (str != null) {
            HiveWebView hiveWebView4 = this.webView;
            if (hiveWebView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                hiveWebView4 = null;
            }
            hiveWebView4.loadUrl(str);
        }
        HiveWebView hiveWebView5 = this.webView;
        if (hiveWebView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView5 = null;
        }
        linearLayout.addView(hiveWebView5);
        LinearLayout linearLayout3 = this.mainLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainLayout");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.addView(linearLayout);
    }

    private final void createWebViewForKindle() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setLayoutParams(layoutParams);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        HiveWebView hiveWebView = new HiveWebView(context);
        this.webView = hiveWebView;
        hiveWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        HiveWebView hiveWebView2 = this.webView;
        LinearLayout linearLayout2 = null;
        if (hiveWebView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView2 = null;
        }
        hiveWebView2.setWebViewClient(new UserAgreeWebViewClient());
        HiveWebView hiveWebView3 = this.webView;
        if (hiveWebView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView3 = null;
        }
        hiveWebView3.getSettings().setJavaScriptEnabled(true);
        String str = this.url;
        if (str != null) {
            HiveWebView hiveWebView4 = this.webView;
            if (hiveWebView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                hiveWebView4 = null;
            }
            hiveWebView4.loadUrl(str);
        }
        HiveWebView hiveWebView5 = this.webView;
        if (hiveWebView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView5 = null;
        }
        linearLayout.addView(hiveWebView5);
        LinearLayout linearLayout3 = this.mainLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainLayout");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.addView(linearLayout, layoutParams);
    }

    private final Bitmap loadBitmap(String filePath) {
        try {
            return BitmapFactory.decodeStream(getContext().getAssets().open(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$1$lambda$0(TermsDialog termsDialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 4) {
            termsDialog.destroy$hive_service_release();
        }
        return true;
    }

    private final void setContentTermsView() {
        WindowManager windowManager;
        Window window = getWindow();
        LinearLayout linearLayout = null;
        Display defaultDisplay = (window == null || (windowManager = window.getWindowManager()) == null) ? null : windowManager.getDefaultDisplay();
        this.scale = getContext().getResources().getDisplayMetrics().density;
        float[] fArr = getContext().getResources().getConfiguration().orientation == 2 ? DIMENSIONS_DIFF_LANDSCAPE : DIMENSIONS_DIFF_PORTRAIT;
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        int length = MODEL.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) MODEL.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        if (StringsKt.startsWith$default(MODEL.subSequence(i, length + 1).toString(), "Kindle Fire", false, 2, (Object) null)) {
            createWebViewForKindle();
            LinearLayout linearLayout2 = this.mainLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainLayout");
            } else {
                linearLayout = linearLayout2;
            }
            setContentView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        createWebView();
        Point point = new Point();
        if (defaultDisplay != null) {
            try {
                defaultDisplay.getSize(point);
            } catch (NoSuchMethodError unused) {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
        }
        LinearLayout linearLayout3 = this.mainLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainLayout");
        } else {
            linearLayout = linearLayout3;
        }
        int i2 = point.x;
        float f = fArr[0];
        float f2 = this.scale;
        setContentView(linearLayout, new LinearLayout.LayoutParams(i2 - ((int) ((f * f2) + 0.5f)), point.y - ((int) ((fArr[1] * f2) + 0.5f))));
    }

    public final void destroy$hive_service_release() {
        this.destroyed = true;
        HiveWebView hiveWebView = this.webView;
        ProgressDialog progressDialog = null;
        if (hiveWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            hiveWebView = null;
        }
        if (hiveWebView.isShown()) {
            HiveWebView hiveWebView2 = this.webView;
            if (hiveWebView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                hiveWebView2 = null;
            }
            hiveWebView2.stopLoading();
        }
        ProgressDialog progressDialog2 = this.mSpinner;
        if (progressDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpinner");
            progressDialog2 = null;
        }
        if (progressDialog2.isShowing()) {
            ProgressDialog progressDialog3 = this.mSpinner;
            if (progressDialog3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpinner");
            } else {
                progressDialog = progressDialog3;
            }
            progressDialog.dismiss();
        }
        dismiss();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        destroy$hive_service_release();
    }

    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[UserAgreeDialog] onConfigurationChanged called..");
        setContentTermsView();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(1024, 1024);
        }
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.requestWindowFeature(1);
        progressDialog.setMessage("Loading...");
        progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.hive.auth.TermsDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return TermsDialog.onCreate$lambda$1$lambda$0(this.f$0, dialogInterface, i, keyEvent);
            }
        });
        progressDialog.setCanceledOnTouchOutside(false);
        this.mSpinner = progressDialog;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        this.mainLayout = linearLayout;
        createTitle();
        setCanceledOnTouchOutside(false);
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        int length = MODEL.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) MODEL.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        if (StringsKt.startsWith$default(MODEL.subSequence(i, length + 1).toString(), "Kindle Fire", false, 2, (Object) null)) {
            createWebViewForKindle();
        } else {
            createWebView();
        }
        setContentTermsView();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onKeyDown(keyCode, event);
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onKeyUp(keyCode, event);
        return true;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Util.INSTANCE.hideSystemUI(getWindow());
        }
    }

    public final void setUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }
}
