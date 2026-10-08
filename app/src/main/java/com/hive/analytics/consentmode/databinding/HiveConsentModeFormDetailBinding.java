package com.hive.analytics.consentmode.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.analytics.consentmode.R;
import com.hive.ui.view.HiveAnimationButton;

/* JADX INFO: loaded from: classes5.dex */
public final class HiveConsentModeFormDetailBinding implements ViewBinding {
    public final HiveAnimationButton hiveConsentModeButtonBack;
    public final AppCompatTextView hiveConsentModeFormDetailContents;
    public final NestedScrollView hiveConsentModeFormDetailScroll;
    public final AppCompatTextView hiveConsentModeFormDetailTitle;
    public final ConstraintLayout hiveConsentModeMain;
    private final ConstraintLayout rootView;

    private HiveConsentModeFormDetailBinding(ConstraintLayout constraintLayout, HiveAnimationButton hiveAnimationButton, AppCompatTextView appCompatTextView, NestedScrollView nestedScrollView, AppCompatTextView appCompatTextView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.hiveConsentModeButtonBack = hiveAnimationButton;
        this.hiveConsentModeFormDetailContents = appCompatTextView;
        this.hiveConsentModeFormDetailScroll = nestedScrollView;
        this.hiveConsentModeFormDetailTitle = appCompatTextView2;
        this.hiveConsentModeMain = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HiveConsentModeFormDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveConsentModeFormDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_consent_mode_form_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HiveConsentModeFormDetailBinding bind(View view) {
        int i = R.id.hive_consent_mode_button_back;
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) ViewBindings.findChildViewById(view, i);
        if (hiveAnimationButton != null) {
            i = R.id.hive_consent_mode_form_detail_contents;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
            if (appCompatTextView != null) {
                i = R.id.hive_consent_mode_form_detail_scroll;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                if (nestedScrollView != null) {
                    i = R.id.hive_consent_mode_form_detail_title;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                    if (appCompatTextView2 != null) {
                        i = R.id.hive_consent_mode_main;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            return new HiveConsentModeFormDetailBinding((ConstraintLayout) view, hiveAnimationButton, appCompatTextView, nestedScrollView, appCompatTextView2, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
