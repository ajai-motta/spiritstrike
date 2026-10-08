package com.hive.authv4.identityverification.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.authv4.identityverification.R;
import com.hive.core.webview.HiveWebView;
import com.hive.ui.view.HiveAnimationButton;

/* JADX INFO: loaded from: classes6.dex */
public final class HiveAuthv4IdentityVerificationDialogBinding implements ViewBinding {
    public final HiveAnimationButton hiveIdentityVerificationCloseBtn;
    public final HiveAnimationButton hiveIdentityVerificationGobackBtn;
    public final HiveAnimationButton hiveIdentityVerificationGobackDeactiveBtn;
    public final HiveWebView hiveIdentityVerificationWebview;
    public final ContentLoadingProgressBar hiveIdentityVerificationWebviewSpinner;
    private final ConstraintLayout rootView;

    private HiveAuthv4IdentityVerificationDialogBinding(ConstraintLayout constraintLayout, HiveAnimationButton hiveAnimationButton, HiveAnimationButton hiveAnimationButton2, HiveAnimationButton hiveAnimationButton3, HiveWebView hiveWebView, ContentLoadingProgressBar contentLoadingProgressBar) {
        this.rootView = constraintLayout;
        this.hiveIdentityVerificationCloseBtn = hiveAnimationButton;
        this.hiveIdentityVerificationGobackBtn = hiveAnimationButton2;
        this.hiveIdentityVerificationGobackDeactiveBtn = hiveAnimationButton3;
        this.hiveIdentityVerificationWebview = hiveWebView;
        this.hiveIdentityVerificationWebviewSpinner = contentLoadingProgressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HiveAuthv4IdentityVerificationDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveAuthv4IdentityVerificationDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_authv4_identity_verification_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HiveAuthv4IdentityVerificationDialogBinding bind(View view) {
        int i = R.id.hive_identity_verification_close_btn;
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) ViewBindings.findChildViewById(view, i);
        if (hiveAnimationButton != null) {
            i = R.id.hive_identity_verification_goback_btn;
            HiveAnimationButton hiveAnimationButton2 = (HiveAnimationButton) ViewBindings.findChildViewById(view, i);
            if (hiveAnimationButton2 != null) {
                i = R.id.hive_identity_verification_goback_deactive_btn;
                HiveAnimationButton hiveAnimationButton3 = (HiveAnimationButton) ViewBindings.findChildViewById(view, i);
                if (hiveAnimationButton3 != null) {
                    i = R.id.hive_identity_verification_webview;
                    HiveWebView hiveWebView = (HiveWebView) ViewBindings.findChildViewById(view, i);
                    if (hiveWebView != null) {
                        i = R.id.hive_identity_verification_webview_spinner;
                        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) ViewBindings.findChildViewById(view, i);
                        if (contentLoadingProgressBar != null) {
                            return new HiveAuthv4IdentityVerificationDialogBinding((ConstraintLayout) view, hiveAnimationButton, hiveAnimationButton2, hiveAnimationButton3, hiveWebView, contentLoadingProgressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
