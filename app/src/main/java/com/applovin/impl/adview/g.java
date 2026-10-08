package com.applovin.impl.adview;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.adview.e;

/* JADX INFO: loaded from: classes2.dex */
public class g extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f315a;
    private int b;

    public g(e.a aVar, Activity activity) {
        super(activity);
        setBackgroundColor(0);
        e eVarA = e.a(aVar, activity);
        this.f315a = eVarA;
        addView(eVarA);
    }

    public void a(e.a aVar) {
        if (aVar == null || aVar == this.f315a.getStyle()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f315a.getLayoutParams();
        removeView(this.f315a);
        e eVarA = e.a(aVar, getContext());
        this.f315a = eVarA;
        addView(eVarA);
        this.f315a.setLayoutParams(layoutParams);
        this.f315a.a(this.b);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.b = i;
        int i5 = i2 + i + i3;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i5;
            layoutParams.width = i5;
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(i5, i5));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i, i4);
        layoutParams2.setMargins(i3, i3, i3, 0);
        this.f315a.setLayoutParams(layoutParams2);
        this.f315a.a(i);
    }
}
