package com.hive.service.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.service.R;

/* JADX INFO: loaded from: classes6.dex */
public final class HiveAuthv4HelperConflictViewBinding implements ViewBinding {
    public final AppCompatTextView hiveHelperConflictDialogMainButton;
    public final AppCompatTextView hiveHelperConflictDialogSubButton;
    public final AppCompatTextView hiveHelperConflictDialogTitle;
    public final NestedScrollView hiveHelperConflictScrollView;
    private final ConstraintLayout rootView;

    private HiveAuthv4HelperConflictViewBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, NestedScrollView nestedScrollView) {
        this.rootView = constraintLayout;
        this.hiveHelperConflictDialogMainButton = appCompatTextView;
        this.hiveHelperConflictDialogSubButton = appCompatTextView2;
        this.hiveHelperConflictDialogTitle = appCompatTextView3;
        this.hiveHelperConflictScrollView = nestedScrollView;
    }

    public static HiveAuthv4HelperConflictViewBinding bind(View view) {
        int i = R.id.hive_helper_conflict_dialog_main_button;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
        if (appCompatTextView != null) {
            i = R.id.hive_helper_conflict_dialog_sub_button;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
            if (appCompatTextView2 != null) {
                i = R.id.hive_helper_conflict_dialog_title;
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatTextView3 != null) {
                    i = R.id.hive_helper_conflict_scroll_view;
                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                    if (nestedScrollView != null) {
                        return new HiveAuthv4HelperConflictViewBinding((ConstraintLayout) view, appCompatTextView, appCompatTextView2, appCompatTextView3, nestedScrollView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static HiveAuthv4HelperConflictViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveAuthv4HelperConflictViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_authv4_helper_conflict_view, viewGroup, false);
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
