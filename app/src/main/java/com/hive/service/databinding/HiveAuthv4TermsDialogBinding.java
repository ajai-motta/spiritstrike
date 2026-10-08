package com.hive.service.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.core.webview.HiveWebView;
import com.hive.service.R;
import com.hive.ui.view.HiveAnimationButton;

/* JADX INFO: loaded from: classes6.dex */
public final class HiveAuthv4TermsDialogBinding implements ViewBinding {
    public final HiveAnimationButton hiveAuthv4CloseButton;
    public final HiveWebView hiveAuthv4Webview;
    public final ProgressBar hiveAuthv4WebviewSpinner;
    private final LinearLayout rootView;

    private HiveAuthv4TermsDialogBinding(LinearLayout linearLayout, HiveAnimationButton hiveAnimationButton, HiveWebView hiveWebView, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.hiveAuthv4CloseButton = hiveAnimationButton;
        this.hiveAuthv4Webview = hiveWebView;
        this.hiveAuthv4WebviewSpinner = progressBar;
    }

    public static HiveAuthv4TermsDialogBinding bind(View view) {
        int i = R.id.hive_authv4_close_button;
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) ViewBindings.findChildViewById(view, i);
        if (hiveAnimationButton != null) {
            i = R.id.hive_authv4_webview;
            HiveWebView hiveWebView = (HiveWebView) ViewBindings.findChildViewById(view, i);
            if (hiveWebView != null) {
                i = R.id.hive_authv4_webview_spinner;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    return new HiveAuthv4TermsDialogBinding((LinearLayout) view, hiveAnimationButton, hiveWebView, progressBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static HiveAuthv4TermsDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveAuthv4TermsDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_authv4_terms_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
