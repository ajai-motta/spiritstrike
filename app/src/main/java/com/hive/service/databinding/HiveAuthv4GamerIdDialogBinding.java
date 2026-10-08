package com.hive.service.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.core.webview.HiveWebView;
import com.hive.service.R;

/* JADX INFO: loaded from: classes6.dex */
public final class HiveAuthv4GamerIdDialogBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final HiveWebView webView;

    private HiveAuthv4GamerIdDialogBinding(ConstraintLayout constraintLayout, HiveWebView hiveWebView) {
        this.rootView = constraintLayout;
        this.webView = hiveWebView;
    }

    public static HiveAuthv4GamerIdDialogBinding bind(View view) {
        int i = R.id.webView;
        HiveWebView hiveWebView = (HiveWebView) ViewBindings.findChildViewById(view, i);
        if (hiveWebView != null) {
            return new HiveAuthv4GamerIdDialogBinding((ConstraintLayout) view, hiveWebView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static HiveAuthv4GamerIdDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveAuthv4GamerIdDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_authv4_gamer_id_dialog, viewGroup, false);
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
