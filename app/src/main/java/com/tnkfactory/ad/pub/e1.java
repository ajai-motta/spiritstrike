package com.tnkfactory.ad.pub;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ToggleButton;

/* JADX INFO: loaded from: classes6.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f3124a;
    public final Bitmap b;

    public e1(Context context, String str) {
        this.f3124a = null;
        this.b = null;
        if (str == null || str.length() == 0) {
            return;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length > 0) {
            this.f3124a = e2.b(context, strArrSplit[0].replace("http:", "https:"));
        }
        if (strArrSplit.length > 1) {
            this.b = e2.b(context, strArrSplit[1].replace("http:", "https:"));
        }
    }

    public final void a(View view) {
        if (view == null) {
            return;
        }
        Resources resources = view.getContext().getResources();
        if (this.f3124a == null) {
            view.setBackground(null);
            return;
        }
        if (this.b == null) {
            view.setBackground(new BitmapDrawable(resources, this.f3124a));
            return;
        }
        if (view instanceof ToggleButton) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_checked}, new BitmapDrawable(resources, this.b));
            stateListDrawable.addState(new int[0], new BitmapDrawable(resources, this.f3124a));
            view.setBackground(stateListDrawable);
            return;
        }
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        stateListDrawable2.addState(new int[]{android.R.attr.state_pressed}, new BitmapDrawable(resources, this.b));
        stateListDrawable2.addState(new int[0], new BitmapDrawable(resources, this.f3124a));
        view.setBackground(stateListDrawable2);
    }

    public e1(Bitmap bitmap) {
        this.b = null;
        this.f3124a = bitmap;
    }
}
