package com.hive.service.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.core.webview.HiveWebView;
import com.hive.service.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SocialDialogBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView socialBackToGame;
    public final AppCompatImageView socialBackToGameArrow;
    public final RelativeLayout socialDialogBottomWebview;
    public final LinearLayout socialDialogRoot;
    public final RelativeLayout socialDialogTopBar;
    public final ProgressBar socialHiveSpinner;
    public final HiveWebView socialHiveWebview;

    private SocialDialogBinding(LinearLayout linearLayout, TextView textView, AppCompatImageView appCompatImageView, RelativeLayout relativeLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout2, ProgressBar progressBar, HiveWebView hiveWebView) {
        this.rootView = linearLayout;
        this.socialBackToGame = textView;
        this.socialBackToGameArrow = appCompatImageView;
        this.socialDialogBottomWebview = relativeLayout;
        this.socialDialogRoot = linearLayout2;
        this.socialDialogTopBar = relativeLayout2;
        this.socialHiveSpinner = progressBar;
        this.socialHiveWebview = hiveWebView;
    }

    public static SocialDialogBinding bind(View view) {
        int i = R.id.social_BackToGame;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.social_BackToGameArrow;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.social_DialogBottomWebview;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i = R.id.social_DialogTopBar;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = R.id.social_HiveSpinner;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            i = R.id.social_HiveWebview;
                            HiveWebView hiveWebView = (HiveWebView) ViewBindings.findChildViewById(view, i);
                            if (hiveWebView != null) {
                                return new SocialDialogBinding(linearLayout, textView, appCompatImageView, relativeLayout, linearLayout, relativeLayout2, progressBar, hiveWebView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static SocialDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SocialDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.social_dialog, viewGroup, false);
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
