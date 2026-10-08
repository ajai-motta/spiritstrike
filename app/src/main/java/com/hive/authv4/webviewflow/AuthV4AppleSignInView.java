package com.hive.authv4.webviewflow;

import android.app.Activity;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.hive.authv4.webviewflow.AuthV4WebView;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.ui.Resource;
import com.hive.ui.view.HiveAnimationButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthV4AppleSignInView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0002¨\u0006\u0011"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4AppleSignInView;", "Lcom/hive/authv4/webviewflow/AuthV4WebView;", "activity", "Landroid/app/Activity;", "url", "", "scheme", "host", "onPostWebViewListener", "Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebViewListener;", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebViewListener;)V", "createWebView", "", "webViewClient", "Lcom/hive/core/webview/HiveWebViewClient;", "onApplyWindowInsets", "hive-authv4-provider-apple-signin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4AppleSignInView extends AuthV4WebView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthV4AppleSignInView(Activity activity, String url, String scheme, String host, AuthV4WebView.AuthV4WebViewListener onPostWebViewListener) {
        super(activity, url, "", scheme, host, AuthV4WebView.CloseButtonType.TYPE_SIGN_IN_APPLE, onPostWebViewListener);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(onPostWebViewListener, "onPostWebViewListener");
    }

    @Override // com.hive.authv4.webviewflow.AuthV4WebView
    public void createWebView(HiveWebViewClient webViewClient) {
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        getActivity().setContentView(Resource.INSTANCE.getLayoutId(getActivity(), "hive_authv4_applesignin_dialog"));
        setWebView((HiveWebView) getActivity().findViewById(Resource.INSTANCE.getViewId(getActivity(), "hive_authv4_webview")));
        getWebView().getRequestOptions().setSupportHiveTheme(false);
        setProgressBar((ProgressBar) getActivity().findViewById(Resource.INSTANCE.getViewId(getActivity(), "hive_authv4_webview_spinner")));
        ProgressBar progressBar = getProgressBar();
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) getActivity().findViewById(Resource.INSTANCE.getViewId(getActivity(), "hive_authv4_close_button"));
        AuthV4WebView.CloseButtonType closeButtonType = getCloseButtonType();
        Intrinsics.checkNotNull(hiveAnimationButton);
        setButtonType(closeButtonType, hiveAnimationButton);
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.authv4.webviewflow.AuthV4AppleSignInView.createWebView.1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                AuthV4AppleSignInView.this.dismiss();
            }
        });
        AuthV4WebView.setWebViewSettings$default(this, webViewClient, null, 2, null);
        onApplyWindowInsets();
    }

    private final void onApplyWindowInsets() {
        if (Build.VERSION.SDK_INT >= 28) {
            ((LinearLayout) getActivity().findViewById(Resource.INSTANCE.getViewId(getActivity(), "topCutoutLayout"))).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.hive.authv4.webviewflow.AuthV4AppleSignInView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return AuthV4AppleSignInView.onApplyWindowInsets$lambda$1(view, windowInsets);
                }
            });
            ((LinearLayout) getActivity().findViewById(Resource.INSTANCE.getViewId(getActivity(), "leftCutoutLayout"))).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.hive.authv4.webviewflow.AuthV4AppleSignInView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return AuthV4AppleSignInView.onApplyWindowInsets$lambda$3(view, windowInsets);
                }
            });
            ((LinearLayout) getActivity().findViewById(Resource.INSTANCE.getViewId(getActivity(), "rightCutoutLayout"))).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.hive.authv4.webviewflow.AuthV4AppleSignInView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return AuthV4AppleSignInView.onApplyWindowInsets$lambda$5(view, windowInsets);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets onApplyWindowInsets$lambda$1(View v, WindowInsets insets) {
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
    public static final WindowInsets onApplyWindowInsets$lambda$3(View v, WindowInsets insets) {
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
    public static final WindowInsets onApplyWindowInsets$lambda$5(View v, WindowInsets insets) {
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
