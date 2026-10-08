package com.hive.iapv4.repayment.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.iapv4.repayment.R;

/* JADX INFO: loaded from: classes6.dex */
public final class HiveRepaymentRectangle2Binding implements ViewBinding {
    public final ConstraintLayout hiveRepaymentButtonLayout;
    public final TextView hiveRepaymentRectangle2CsCode;
    public final TextView hiveRepaymentRectangle2InquireButton;
    public final RecyclerView hiveRepaymentRectangle2RecyclerView;
    public final AppCompatImageView hiveRepaymentRectangle2Refresh;
    public final TextView hiveRepaymentRectangle2StartGameButton;
    public final TextView hiveRepaymentRectangle2Title;
    private final ConstraintLayout rootView;

    private HiveRepaymentRectangle2Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, RecyclerView recyclerView, AppCompatImageView appCompatImageView, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.hiveRepaymentButtonLayout = constraintLayout2;
        this.hiveRepaymentRectangle2CsCode = textView;
        this.hiveRepaymentRectangle2InquireButton = textView2;
        this.hiveRepaymentRectangle2RecyclerView = recyclerView;
        this.hiveRepaymentRectangle2Refresh = appCompatImageView;
        this.hiveRepaymentRectangle2StartGameButton = textView3;
        this.hiveRepaymentRectangle2Title = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HiveRepaymentRectangle2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveRepaymentRectangle2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_repayment_rectangle_2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HiveRepaymentRectangle2Binding bind(View view) {
        int i = R.id.hive_repayment_button_layout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.hive_repayment_rectangle_2_cs_code;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.hive_repayment_rectangle_2_inquire_button;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.hive_repayment_rectangle_2_recycler_view;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.hive_repayment_rectangle_2_refresh;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView != null) {
                            i = R.id.hive_repayment_rectangle_2_start_game_button;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.hive_repayment_rectangle_2_title;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    return new HiveRepaymentRectangle2Binding((ConstraintLayout) view, constraintLayout, textView, textView2, recyclerView, appCompatImageView, textView3, textView4);
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
