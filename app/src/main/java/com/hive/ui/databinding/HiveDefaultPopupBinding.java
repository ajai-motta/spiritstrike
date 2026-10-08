package com.hive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.ui.R;
import com.hive.ui.view.HiveAnimationButton;
import com.hive.ui.view.HiveTextView;

/* JADX INFO: loaded from: classes6.dex */
public final class HiveDefaultPopupBinding implements ViewBinding {
    public final HiveAnimationButton hiveDefaultPopupDialogClose;
    public final AppCompatTextView hiveDefaultPopupDialogMainButton;
    public final AppCompatTextView hiveDefaultPopupDialogMessage;
    public final AppCompatTextView hiveDefaultPopupDialogSubButton;
    public final AppCompatTextView hiveDefaultPopupDialogTimer;
    public final HiveTextView hiveDefaultPopupDialogTitle;
    public final NestedScrollView hiveDefaultPopupScrollView;
    public final ConstraintLayout popupLayout;
    private final ConstraintLayout rootView;

    private HiveDefaultPopupBinding(ConstraintLayout constraintLayout, HiveAnimationButton hiveAnimationButton, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, HiveTextView hiveTextView, NestedScrollView nestedScrollView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.hiveDefaultPopupDialogClose = hiveAnimationButton;
        this.hiveDefaultPopupDialogMainButton = appCompatTextView;
        this.hiveDefaultPopupDialogMessage = appCompatTextView2;
        this.hiveDefaultPopupDialogSubButton = appCompatTextView3;
        this.hiveDefaultPopupDialogTimer = appCompatTextView4;
        this.hiveDefaultPopupDialogTitle = hiveTextView;
        this.hiveDefaultPopupScrollView = nestedScrollView;
        this.popupLayout = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HiveDefaultPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveDefaultPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_default_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HiveDefaultPopupBinding bind(View view) {
        int i = R.id.hive_default_popup_dialog_close;
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) ViewBindings.findChildViewById(view, i);
        if (hiveAnimationButton != null) {
            i = R.id.hive_default_popup_dialog_main_button;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
            if (appCompatTextView != null) {
                i = R.id.hive_default_popup_dialog_message;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatTextView2 != null) {
                    i = R.id.hive_default_popup_dialog_sub_button;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                    if (appCompatTextView3 != null) {
                        i = R.id.hive_default_popup_dialog_timer;
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                        if (appCompatTextView4 != null) {
                            i = R.id.hive_default_popup_dialog_title;
                            HiveTextView hiveTextView = (HiveTextView) ViewBindings.findChildViewById(view, i);
                            if (hiveTextView != null) {
                                i = R.id.hive_default_popup_scroll_view;
                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                                if (nestedScrollView != null) {
                                    i = R.id.popupLayout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout != null) {
                                        return new HiveDefaultPopupBinding((ConstraintLayout) view, hiveAnimationButton, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, hiveTextView, nestedScrollView, constraintLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
