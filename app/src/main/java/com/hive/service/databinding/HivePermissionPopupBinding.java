package com.hive.service.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hive.service.R;
import com.hive.ui.view.MaxHeightScrollView;

/* JADX INFO: loaded from: classes6.dex */
public final class HivePermissionPopupBinding implements ViewBinding {
    public final TextView hivePermissionDialogMainButton;
    public final TextView hivePermissionDialogMessage;
    public final TextView hivePermissionDialogTitle;
    public final LinearLayout hivePermissionScrollContentLinear;
    public final MaxHeightScrollView hivePermissionScrollView;
    public final Space hivePermissionTopMargin;
    public final RelativeLayout popupButtonAreaLayout;
    public final FrameLayout popupButtonMainButton;
    private final RelativeLayout rootView;

    private HivePermissionPopupBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, MaxHeightScrollView maxHeightScrollView, Space space, RelativeLayout relativeLayout2, FrameLayout frameLayout) {
        this.rootView = relativeLayout;
        this.hivePermissionDialogMainButton = textView;
        this.hivePermissionDialogMessage = textView2;
        this.hivePermissionDialogTitle = textView3;
        this.hivePermissionScrollContentLinear = linearLayout;
        this.hivePermissionScrollView = maxHeightScrollView;
        this.hivePermissionTopMargin = space;
        this.popupButtonAreaLayout = relativeLayout2;
        this.popupButtonMainButton = frameLayout;
    }

    public static HivePermissionPopupBinding bind(View view) {
        int i = R.id.hive_permission_dialog_main_button;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.hive_permission_dialog_message;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.hive_permission_dialog_title;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.hive_permission_scroll_content_linear;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.hive_permission_scroll_view;
                        MaxHeightScrollView maxHeightScrollView = (MaxHeightScrollView) ViewBindings.findChildViewById(view, i);
                        if (maxHeightScrollView != null) {
                            i = R.id.hive_permission_top_margin;
                            Space space = (Space) ViewBindings.findChildViewById(view, i);
                            if (space != null) {
                                i = R.id.popup_button_area_layout;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout != null) {
                                    i = R.id.popup_button_main_button;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                    if (frameLayout != null) {
                                        return new HivePermissionPopupBinding((RelativeLayout) view, textView, textView2, textView3, linearLayout, maxHeightScrollView, space, relativeLayout, frameLayout);
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

    public static HivePermissionPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HivePermissionPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hive_permission_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
