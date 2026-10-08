package com.hive.service.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.core.webview.HiveWebView;
import com.hive.service.R;
import com.hive.ui.view.HiveAnimationButton;

/* JADX INFO: loaded from: classes6.dex */
public final class HiveAuthv4SocialDialogBinding implements ViewBinding {
    public final HiveAnimationButton closeButton;
    public final ContentLoadingProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final HiveWebView webView;

    private HiveAuthv4SocialDialogBinding(ConstraintLayout constraintLayout, HiveAnimationButton hiveAnimationButton, ContentLoadingProgressBar contentLoadingProgressBar, HiveWebView hiveWebView) {
        this.rootView = constraintLayout;
        this.closeButton = hiveAnimationButton;
        this.progressBar = contentLoadingProgressBar;
        this.webView = hiveWebView;
    }

    public static HiveAuthv4SocialDialogBinding bind(View view) {
        int i = R.id.closeButton;
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) ViewBindings.findChildViewById(view, i);
        if (hiveAnimationButton != null) {
            i = R.id.progressBar;
            ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) ViewBindings.findChildViewById(view, i);
            if (contentLoadingProgressBar != null) {
                i = R.id.webView;
                HiveWebView hiveWebView = (HiveWebView) ViewBindings.findChildViewById(view, i);
                if (hiveWebView != null) {
                    return new HiveAuthv4SocialDialogBinding((ConstraintLayout) view, hiveAnimationButton, contentLoadingProgressBar, hiveWebView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static HiveAuthv4SocialDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveAuthv4SocialDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_authv4_social_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
