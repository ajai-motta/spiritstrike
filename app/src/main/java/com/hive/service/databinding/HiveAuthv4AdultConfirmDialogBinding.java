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
public final class HiveAuthv4AdultConfirmDialogBinding implements ViewBinding {
    public final HiveAnimationButton hiveAdultConfirmCloseBtn;
    public final HiveAnimationButton hiveAdultConfirmGobackBtn;
    public final HiveAnimationButton hiveAdultConfirmGobackDeactiveBtn;
    public final HiveWebView hiveAdultConfirmWebview;
    public final ContentLoadingProgressBar hiveAdultConfirmWebviewSpinner;
    private final ConstraintLayout rootView;

    private HiveAuthv4AdultConfirmDialogBinding(ConstraintLayout constraintLayout, HiveAnimationButton hiveAnimationButton, HiveAnimationButton hiveAnimationButton2, HiveAnimationButton hiveAnimationButton3, HiveWebView hiveWebView, ContentLoadingProgressBar contentLoadingProgressBar) {
        this.rootView = constraintLayout;
        this.hiveAdultConfirmCloseBtn = hiveAnimationButton;
        this.hiveAdultConfirmGobackBtn = hiveAnimationButton2;
        this.hiveAdultConfirmGobackDeactiveBtn = hiveAnimationButton3;
        this.hiveAdultConfirmWebview = hiveWebView;
        this.hiveAdultConfirmWebviewSpinner = contentLoadingProgressBar;
    }

    public static HiveAuthv4AdultConfirmDialogBinding bind(View view) {
        int i = R.id.hive_adult_confirm_close_btn;
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) ViewBindings.findChildViewById(view, i);
        if (hiveAnimationButton != null) {
            i = R.id.hive_adult_confirm_goback_btn;
            HiveAnimationButton hiveAnimationButton2 = (HiveAnimationButton) ViewBindings.findChildViewById(view, i);
            if (hiveAnimationButton2 != null) {
                i = R.id.hive_adult_confirm_goback_deactive_btn;
                HiveAnimationButton hiveAnimationButton3 = (HiveAnimationButton) ViewBindings.findChildViewById(view, i);
                if (hiveAnimationButton3 != null) {
                    i = R.id.hive_adult_confirm_webview;
                    HiveWebView hiveWebView = (HiveWebView) ViewBindings.findChildViewById(view, i);
                    if (hiveWebView != null) {
                        i = R.id.hive_adult_confirm_webview_spinner;
                        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) ViewBindings.findChildViewById(view, i);
                        if (contentLoadingProgressBar != null) {
                            return new HiveAuthv4AdultConfirmDialogBinding((ConstraintLayout) view, hiveAnimationButton, hiveAnimationButton2, hiveAnimationButton3, hiveWebView, contentLoadingProgressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static HiveAuthv4AdultConfirmDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveAuthv4AdultConfirmDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_authv4_adult_confirm_dialog, viewGroup, false);
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
