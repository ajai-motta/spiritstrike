package com.hive.analytics.consentmode.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.analytics.consentmode.R;
import com.hive.ui.view.HiveAnimationButton;

/* JADX INFO: loaded from: classes5.dex */
public final class HiveConsentModeBinding implements ViewBinding {
    public final ConstraintLayout hiveConsentModeBottomLayout;
    public final HiveAnimationButton hiveConsentModeButtonClose;
    public final ConstraintLayout hiveConsentModeMain;
    public final AppCompatTextView hiveConsentModeMainButton;
    public final AppCompatTextView hiveConsentModePrivacyPolicy;
    public final RecyclerView hiveConsentModeRecyclerView;
    public final AppCompatTextView hiveConsentModeSubButton;
    public final AppCompatTextView hiveConsentModeTitle;
    public final NestedScrollView nestedScrollView;
    private final ConstraintLayout rootView;

    private HiveConsentModeBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, HiveAnimationButton hiveAnimationButton, ConstraintLayout constraintLayout3, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, RecyclerView recyclerView, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, NestedScrollView nestedScrollView) {
        this.rootView = constraintLayout;
        this.hiveConsentModeBottomLayout = constraintLayout2;
        this.hiveConsentModeButtonClose = hiveAnimationButton;
        this.hiveConsentModeMain = constraintLayout3;
        this.hiveConsentModeMainButton = appCompatTextView;
        this.hiveConsentModePrivacyPolicy = appCompatTextView2;
        this.hiveConsentModeRecyclerView = recyclerView;
        this.hiveConsentModeSubButton = appCompatTextView3;
        this.hiveConsentModeTitle = appCompatTextView4;
        this.nestedScrollView = nestedScrollView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HiveConsentModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveConsentModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_consent_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HiveConsentModeBinding bind(View view) {
        int i = R.id.hive_consent_mode_bottom_layout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.hive_consent_mode_button_close;
            HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) ViewBindings.findChildViewById(view, i);
            if (hiveAnimationButton != null) {
                i = R.id.hive_consent_mode_main;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.hive_consent_mode_main_button;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                    if (appCompatTextView != null) {
                        i = R.id.hive_consent_mode_privacy_policy;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                        if (appCompatTextView2 != null) {
                            i = R.id.hive_consent_mode_recycler_view;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                i = R.id.hive_consent_mode_sub_button;
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                if (appCompatTextView3 != null) {
                                    i = R.id.hive_consent_mode_title;
                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatTextView4 != null) {
                                        i = R.id.nestedScrollView;
                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                                        if (nestedScrollView != null) {
                                            return new HiveConsentModeBinding((ConstraintLayout) view, constraintLayout, hiveAnimationButton, constraintLayout2, appCompatTextView, appCompatTextView2, recyclerView, appCompatTextView3, appCompatTextView4, nestedScrollView);
                                        }
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
