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
public final class HiveConsentModeFormGroupItemBinding implements ViewBinding {
    public final AppCompatImageView hiveConsentModeFormGroupItemBtnCheck;
    public final AppCompatImageView hiveConsentModeFormGroupItemBtnMeatball;
    public final AppCompatTextView hiveConsentModeFormGroupItemTitle;
    private final ConstraintLayout rootView;

    private HiveConsentModeFormGroupItemBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.hiveConsentModeFormGroupItemBtnCheck = appCompatImageView;
        this.hiveConsentModeFormGroupItemBtnMeatball = appCompatImageView2;
        this.hiveConsentModeFormGroupItemTitle = appCompatTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HiveConsentModeFormGroupItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveConsentModeFormGroupItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_consent_mode_form_group_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HiveConsentModeFormGroupItemBinding bind(View view) {
        int i = R.id.hive_consent_mode_form_group_item_btn_check;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.hive_consent_mode_form_group_item_btn_meatball;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView2 != null) {
                i = R.id.hive_consent_mode_form_group_item_title;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatTextView != null) {
                    return new HiveConsentModeFormGroupItemBinding((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
