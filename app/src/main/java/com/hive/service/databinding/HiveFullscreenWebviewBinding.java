package com.hive.service.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.core.webview.HiveWebView;
import com.hive.service.R;
import com.hive.ui.view.HiveAnimationButton;

/* JADX INFO: loaded from: classes6.dex */
public final class HiveFullscreenWebviewBinding implements ViewBinding {
    public final HiveAnimationButton hiveCloseButton;
    public final HiveWebView hiveWebview;
    private final LinearLayout rootView;

    private HiveFullscreenWebviewBinding(LinearLayout linearLayout, HiveAnimationButton hiveAnimationButton, HiveWebView hiveWebView) {
        this.rootView = linearLayout;
        this.hiveCloseButton = hiveAnimationButton;
        this.hiveWebview = hiveWebView;
    }

    public static HiveFullscreenWebviewBinding bind(View view) {
        int i = R.id.hive_close_button;
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) ViewBindings.findChildViewById(view, i);
        if (hiveAnimationButton != null) {
            i = R.id.hive_webview;
            HiveWebView hiveWebView = (HiveWebView) ViewBindings.findChildViewById(view, i);
            if (hiveWebView != null) {
                return new HiveFullscreenWebviewBinding((LinearLayout) view, hiveAnimationButton, hiveWebView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static HiveFullscreenWebviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveFullscreenWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_fullscreen_webview, viewGroup, false);
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
