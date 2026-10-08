package com.hive.analytics.consentmode.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.analytics.consentmode.R;

/* JADX INFO: loaded from: classes5.dex */
public final class HiveConsentModeFormBinding implements ViewBinding {
    public final AppCompatImageView hiveConsentModeFormDataUsageBtnCheck;
    public final AppCompatImageView hiveConsentModeFormDataUsageBtnMeatball;
    public final ConstraintLayout hiveConsentModeFormDataUsageLayout;
    public final AppCompatTextView hiveConsentModeFormDataUsageTitle;
    public final ConstraintLayout hiveConsentModeFormRoot;
    private final ConstraintLayout rootView;

    private HiveConsentModeFormBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.hiveConsentModeFormDataUsageBtnCheck = appCompatImageView;
        this.hiveConsentModeFormDataUsageBtnMeatball = appCompatImageView2;
        this.hiveConsentModeFormDataUsageLayout = constraintLayout2;
        this.hiveConsentModeFormDataUsageTitle = appCompatTextView;
        this.hiveConsentModeFormRoot = constraintLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HiveConsentModeFormBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveConsentModeFormBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_consent_mode_form, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HiveConsentModeFormBinding bind(View view) {
        int i = R.id.hive_consent_mode_form_data_usage_btn_check;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.hive_consent_mode_form_data_usage_btn_meatball;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView2 != null) {
                i = R.id.hive_consent_mode_form_data_usage_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.hive_consent_mode_form_data_usage_title;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                    if (appCompatTextView != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                        return new HiveConsentModeFormBinding(constraintLayout2, appCompatImageView, appCompatImageView2, constraintLayout, appCompatTextView, constraintLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
