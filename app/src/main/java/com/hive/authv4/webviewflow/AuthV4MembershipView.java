package com.hive.authv4.webviewflow;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.share.internal.ShareConstants;
import com.hive.AuthV4;
import com.hive.authv4.webviewflow.AuthV4WebView;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.logger.LoggerImpl;
import com.hive.ui.Resource;
import com.hive.ui.view.HiveAnimationButton;
import com.hive.webview.HiveSchemeHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthV4MembershipView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\r\u0018\u00002\u00020\u0001:\u0003\u0018\u0019\u001aB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4MembershipView;", "Lcom/hive/authv4/webviewflow/AuthV4WebView;", "activity", "Landroid/app/Activity;", "url", "", "postData", "scheme", "onPostWebViewListener", "Lcom/hive/authv4/webviewflow/AuthV4MembershipView$HiveMembershipListener;", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/authv4/webviewflow/AuthV4MembershipView$HiveMembershipListener;)V", "schemeHandler", "com/hive/authv4/webviewflow/AuthV4MembershipView$schemeHandler$1", "Lcom/hive/authv4/webviewflow/AuthV4MembershipView$schemeHandler$1;", "createWebView", "", "webViewClient", "Lcom/hive/core/webview/HiveWebViewClient;", "handleHiveScheme", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "onApplyWindowInsets", "HiveMembershipListener", "HiveMembershipSchemeHandler", "HiveMembershipWebViewCallback", "hive-authv4-provider-hive-membership_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4MembershipView extends AuthV4WebView {
    private final HiveMembershipListener onPostWebViewListener;
    private final AuthV4MembershipView$schemeHandler$1 schemeHandler;

    /* JADX INFO: compiled from: AuthV4MembershipView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4MembershipView$HiveMembershipListener;", "Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebViewListener;", "onLogin", "", "uid", "", "sessionKey", "member", "name", "img", "onLogout", "hive-authv4-provider-hive-membership_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface HiveMembershipListener extends AuthV4WebView.AuthV4WebViewListener {
        void onLogin(String uid, String sessionKey, String member, String name, String img);

        void onLogout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.hive.authv4.webviewflow.AuthV4MembershipView$schemeHandler$1] */
    public AuthV4MembershipView(Activity activity, String url, String postData, String str, HiveMembershipListener onPostWebViewListener) {
        super(activity, url, postData, str, "", AuthV4WebView.CloseButtonType.TYPE_THEME, onPostWebViewListener);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(onPostWebViewListener, "onPostWebViewListener");
        this.onPostWebViewListener = onPostWebViewListener;
        this.schemeHandler = new HiveSchemeHandler() { // from class: com.hive.authv4.webviewflow.AuthV4MembershipView$schemeHandler$1
            @Override // com.hive.webview.HiveSchemeHandler
            public boolean schemeEvent(WebView view, Scheme scheme) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                LoggerImpl.INSTANCE.iL(AuthV4.getTAG(), "[AuthV4MembershipView] \nschemeEvent: " + scheme + '\n');
                LoggerImpl.INSTANCE.iR(AuthV4.getTAG(), "[AuthV4MembershipView] \nschemeEvent");
                try {
                    String scheme2 = scheme.getScheme();
                    if (Intrinsics.areEqual(scheme2, "hive") || Intrinsics.areEqual(scheme2, "c2shub") || Intrinsics.areEqual(scheme2, this.this$0.getScheme())) {
                        AuthV4MembershipView authV4MembershipView = this.this$0;
                        Uri uri = Uri.parse(scheme.getUrl());
                        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                        return authV4MembershipView.handleHiveScheme(uri);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return super.schemeEvent(view, scheme);
            }
        };
    }

    /* JADX INFO: compiled from: AuthV4MembershipView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4MembershipView$HiveMembershipSchemeHandler;", "Lcom/hive/webview/HiveSchemeHandler;", "<init>", "(Lcom/hive/authv4/webviewflow/AuthV4MembershipView;)V", "schemeEvent", "", "view", "Landroid/webkit/WebView;", "scheme", "Lcom/hive/core/Scheme;", "hive-authv4-provider-hive-membership_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class HiveMembershipSchemeHandler extends HiveSchemeHandler {
        public HiveMembershipSchemeHandler() {
        }

        @Override // com.hive.webview.HiveSchemeHandler
        public boolean schemeEvent(WebView view, Scheme scheme) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[AuthV4MembershipView] \nschemeEvent: " + scheme + '\n');
            try {
                String scheme2 = scheme.getScheme();
                if (Intrinsics.areEqual(scheme2, "hive") || Intrinsics.areEqual(scheme2, "c2shub") || Intrinsics.areEqual(scheme2, AuthV4MembershipView.this.getScheme())) {
                    AuthV4MembershipView authV4MembershipView = AuthV4MembershipView.this;
                    Uri uri = Uri.parse(scheme.getUrl());
                    Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                    return authV4MembershipView.handleHiveScheme(uri);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.schemeEvent(view, scheme);
        }
    }

    /* JADX INFO: compiled from: AuthV4MembershipView.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4MembershipView$HiveMembershipWebViewCallback;", "Lcom/hive/authv4/webviewflow/AuthV4WebView$WebViewCallBack;", "Lcom/hive/authv4/webviewflow/AuthV4WebView;", "<init>", "(Lcom/hive/authv4/webviewflow/AuthV4MembershipView;)V", "hive-authv4-provider-hive-membership_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class HiveMembershipWebViewCallback extends AuthV4WebView.WebViewCallBack {
        public HiveMembershipWebViewCallback() {
            super(AuthV4MembershipView.this, AuthV4MembershipView.this.new HiveMembershipSchemeHandler());
        }
    }

    @Override // com.hive.authv4.webviewflow.AuthV4WebView
    public void createWebView(HiveWebViewClient webViewClient) {
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        getActivity().setContentView(Resource.INSTANCE.getLayoutId(getActivity(), "hive_authv4_membership_dialog"));
        View viewFindViewById = getActivity().findViewById(Resource.INSTANCE.getViewId(getActivity(), "hive_authv4_webview"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.hive.core.webview.HiveWebView");
        setWebView((HiveWebView) viewFindViewById);
        getWebView().setBackgroundColor(0);
        View viewFindViewById2 = getActivity().findViewById(Resource.INSTANCE.getViewId(getActivity(), "hive_authv4_webview_spinner"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ProgressBar");
        setProgressBar((ProgressBar) viewFindViewById2);
        ProgressBar progressBar = getProgressBar();
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) getActivity().findViewById(Resource.INSTANCE.getViewId(getActivity(), "hive_authv4_close_button"));
        AuthV4WebView.CloseButtonType closeButtonType = getCloseButtonType();
        Intrinsics.checkNotNull(hiveAnimationButton);
        setButtonType(closeButtonType, hiveAnimationButton);
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.authv4.webviewflow.AuthV4MembershipView.createWebView.1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                AuthV4MembershipView.this.dismiss();
            }
        });
        AuthV4WebView.setWebViewSettings$default(this, new HiveMembershipWebViewCallback(), null, 2, null);
        onApplyWindowInsets();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f6  */
    @Override // com.hive.authv4.webviewflow.AuthV4WebView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleHiveScheme(android.net.Uri r14) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.webviewflow.AuthV4MembershipView.handleHiveScheme(android.net.Uri):boolean");
    }

    private final void onApplyWindowInsets() {
        if (Build.VERSION.SDK_INT >= 28) {
            ((LinearLayout) getActivity().findViewById(Resource.INSTANCE.getViewId(getActivity(), "topCutoutLayout"))).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.hive.authv4.webviewflow.AuthV4MembershipView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return AuthV4MembershipView.onApplyWindowInsets$lambda$2(view, windowInsets);
                }
            });
            ((LinearLayout) getActivity().findViewById(Resource.INSTANCE.getViewId(getActivity(), "leftCutoutLayout"))).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.hive.authv4.webviewflow.AuthV4MembershipView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return AuthV4MembershipView.onApplyWindowInsets$lambda$4(view, windowInsets);
                }
            });
            ((LinearLayout) getActivity().findViewById(Resource.INSTANCE.getViewId(getActivity(), "rightCutoutLayout"))).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.hive.authv4.webviewflow.AuthV4MembershipView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return AuthV4MembershipView.onApplyWindowInsets$lambda$6(view, windowInsets);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets onApplyWindowInsets$lambda$2(View v, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        DisplayCutout displayCutout = insets.getDisplayCutout();
        if (displayCutout != null) {
            ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
            layoutParams.height = displayCutout.getSafeInsetTop();
            v.setLayoutParams(layoutParams);
        }
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets onApplyWindowInsets$lambda$4(View v, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        DisplayCutout displayCutout = insets.getDisplayCutout();
        if (displayCutout != null) {
            ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
            layoutParams.width = displayCutout.getSafeInsetLeft();
            v.setLayoutParams(layoutParams);
        }
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets onApplyWindowInsets$lambda$6(View v, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        DisplayCutout displayCutout = insets.getDisplayCutout();
        if (displayCutout != null) {
            ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
            layoutParams.width = displayCutout.getSafeInsetRight();
            v.setLayoutParams(layoutParams);
        }
        return insets;
    }
}
