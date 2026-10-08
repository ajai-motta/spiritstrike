package com.hive.service.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.service.R;

/* JADX INFO: loaded from: classes6.dex */
public final class HiveAuthv4AgegateDialogBinding implements ViewBinding {
    public final AppCompatTextView hiveAgegateActiveButton;
    public final AppCompatTextView hiveAgegateBirthDateFirst;
    public final AppCompatTextView hiveAgegateBirthDateSecond;
    public final AppCompatTextView hiveAgegateBirthDateThird;
    public final ConstraintLayout hiveAgegateMain;
    public final AppCompatTextView hiveAgegateTitle;
    public final AppCompatTextView hiveAgegateV2ActiveButton;
    public final AppCompatTextView hiveAgegateV2CancelButton;
    private final ConstraintLayout rootView;

    private HiveAuthv4AgegateDialogBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7) {
        this.rootView = constraintLayout;
        this.hiveAgegateActiveButton = appCompatTextView;
        this.hiveAgegateBirthDateFirst = appCompatTextView2;
        this.hiveAgegateBirthDateSecond = appCompatTextView3;
        this.hiveAgegateBirthDateThird = appCompatTextView4;
        this.hiveAgegateMain = constraintLayout2;
        this.hiveAgegateTitle = appCompatTextView5;
        this.hiveAgegateV2ActiveButton = appCompatTextView6;
        this.hiveAgegateV2CancelButton = appCompatTextView7;
    }

    public static HiveAuthv4AgegateDialogBinding bind(View view) {
        int i = R.id.hive_agegate_active_button;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
        if (appCompatTextView != null) {
            i = R.id.hive_agegate_birth_date_first;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
            if (appCompatTextView2 != null) {
                i = R.id.hive_agegate_birth_date_second;
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatTextView3 != null) {
                    i = R.id.hive_agegate_birth_date_third;
                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                    if (appCompatTextView4 != null) {
                        i = R.id.hive_agegate_main;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.hive_agegate_title;
                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                            if (appCompatTextView5 != null) {
                                i = R.id.hive_agegate_v2_active_button;
                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                if (appCompatTextView6 != null) {
                                    i = R.id.hive_agegate_v2_cancel_button;
                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatTextView7 != null) {
                                        return new HiveAuthv4AgegateDialogBinding((ConstraintLayout) view, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, constraintLayout, appCompatTextView5, appCompatTextView6, appCompatTextView7);
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

    public static HiveAuthv4AgegateDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveAuthv4AgegateDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_authv4_agegate_dialog, viewGroup, false);
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
