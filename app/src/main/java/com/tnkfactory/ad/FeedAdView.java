package com.tnkfactory.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tnkfactory.ad.pub.R;
import com.tnkfactory.ad.pub.c1;
import com.tnkfactory.ad.pub.l;

/* JADX INFO: loaded from: classes6.dex */
public class FeedAdView extends RelativeLayout implements AdItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1 f3097a;

    public FeedAdView(Context context, String str) {
        super(context);
        this.f3097a = l.a(this).a(str);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void close() {
    }

    @Override // com.tnkfactory.ad.AdItem
    public String getPlacementId() {
        c1 c1Var = this.f3097a;
        if (c1Var != null) {
            return c1Var.f3115a;
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public String getTransactionId() {
        c1 c1Var = this.f3097a;
        if (c1Var != null) {
            return c1Var.d();
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public Object getValue(String str) {
        c1 c1Var = this.f3097a;
        if (c1Var != null) {
            return c1Var.c.get(str);
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isEmpty() {
        c1 c1Var = this.f3097a;
        return c1Var == null || c1Var.d == 0;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isInvalidated() {
        c1 c1Var = this.f3097a;
        if (c1Var != null) {
            return c1Var.f();
        }
        return true;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isLoaded() {
        c1 c1Var = this.f3097a;
        if (c1Var != null) {
            return c1Var.g();
        }
        return false;
    }

    @Override // com.tnkfactory.ad.AdItem
    public void load() {
        c1 c1Var = this.f3097a;
        if (c1Var != null) {
            c1Var.a(getContext(), true);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        c1 c1Var = this.f3097a;
        if (c1Var != null) {
            int[] iArrA = c1Var.a(i, i2);
            setMeasuredDimension(iArrA[0], iArrA[1]);
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setListener(AdListener adListener) {
        c1 c1Var = this.f3097a;
        if (c1Var != null) {
            c1Var.b = adListener;
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setValue(String str, Object obj) {
        c1 c1Var = this.f3097a;
        if (c1Var != null) {
            c1Var.c.put(str, obj);
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show() {
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show(Context context) {
    }

    public FeedAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3097a = l.a(this).a(context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AdView, 0, 0).getString(R.styleable.AdView_placement_id));
    }
}
