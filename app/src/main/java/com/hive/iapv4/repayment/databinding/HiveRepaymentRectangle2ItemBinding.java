package com.hive.iapv4.repayment.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.iapv4.repayment.R;

/* JADX INFO: loaded from: classes6.dex */
public final class HiveRepaymentRectangle2ItemBinding implements ViewBinding {
    public final TextView hiveRepaymentRectangle2ItemButton;
    public final TextView hiveRepaymentRectangle2ItemRefundTime;
    public final TextView hiveRepaymentRectangle2ItemTitle;
    private final ConstraintLayout rootView;

    private HiveRepaymentRectangle2ItemBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.hiveRepaymentRectangle2ItemButton = textView;
        this.hiveRepaymentRectangle2ItemRefundTime = textView2;
        this.hiveRepaymentRectangle2ItemTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HiveRepaymentRectangle2ItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveRepaymentRectangle2ItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_repayment_rectangle_2_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HiveRepaymentRectangle2ItemBinding bind(View view) {
        int i = R.id.hive_repayment_rectangle_2_item_button;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.hive_repayment_rectangle_2_item_refund_time;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.hive_repayment_rectangle_2_item_title;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    return new HiveRepaymentRectangle2ItemBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
