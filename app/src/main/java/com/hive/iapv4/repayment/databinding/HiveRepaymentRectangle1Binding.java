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
public final class HiveRepaymentRectangle1Binding implements ViewBinding {
    public final TextView hiveRepaymentRectangle1Content;
    public final TextView hiveRepaymentRectangle1Title;
    private final ConstraintLayout rootView;

    private HiveRepaymentRectangle1Binding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.hiveRepaymentRectangle1Content = textView;
        this.hiveRepaymentRectangle1Title = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HiveRepaymentRectangle1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HiveRepaymentRectangle1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_repayment_rectangle_1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HiveRepaymentRectangle1Binding bind(View view) {
        int i = R.id.hive_repayment_rectangle_1_content;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.hive_repayment_rectangle_1_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                return new HiveRepaymentRectangle1Binding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
