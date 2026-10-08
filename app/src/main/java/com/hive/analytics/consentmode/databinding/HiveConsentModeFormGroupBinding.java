package com.hive.analytics.consentmode.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.analytics.consentmode.R;

/* JADX INFO: loaded from: classes5.dex */
public final class HiveConsentModeFormGroupBinding implements ViewBinding {
    public final AppCompatImageView hiveConsentModeFormGroupBtnCheck;
    public final AppCompatImageView hiveConsentModeFormGroupBtnMeatball;
    public final AppCompatImageView hiveConsentModeFormGroupDivider;
    public final ConstraintLayout hiveConsentModeFormGroupLayout;
    public final RecyclerView hiveConsentModeFormGroupRecyclerview;
    public final ConstraintLayout hiveConsentModeFormGroupRoot;
    public final AppCompatTextView hiveConsentModeFormGroupTitle;
    private final ConstraintLayout rootView;

    private HiveConsentModeFormGroupBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout2, RecyclerView recyclerView, ConstraintLayout constraintLayout3, AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.hiveConsentModeFormGroupBtnCheck = appCompatImageView;
        this.hiveConsentModeFormGroupBtnMeatball = appCompatImageView2;
        this.hiveConsentModeFormGroupDivider = appCompatImageView3;
        this.hiveConsentModeFormGroupLayout = constraintLayout2;
        this.hiveConsentModeFormGroupRecyclerview = recyclerView;
        this.hiveConsentModeFormGroupRoot = constraintLayout3;
        this.hiveConsentModeFormGroupTitle = appCompatTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HiveConsentModeFormGroupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveConsentModeFormGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_consent_mode_form_group, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HiveConsentModeFormGroupBinding bind(View view) {
        int i = R.id.hive_consent_mode_form_group_btn_check;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.hive_consent_mode_form_group_btn_meatball;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView2 != null) {
                i = R.id.hive_consent_mode_form_group_divider;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView3 != null) {
                    i = R.id.hive_consent_mode_form_group_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.hive_consent_mode_form_group_recyclerview;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                            i = R.id.hive_consent_mode_form_group_title;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                            if (appCompatTextView != null) {
                                return new HiveConsentModeFormGroupBinding(constraintLayout2, appCompatImageView, appCompatImageView2, appCompatImageView3, constraintLayout, recyclerView, constraintLayout2, appCompatTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
