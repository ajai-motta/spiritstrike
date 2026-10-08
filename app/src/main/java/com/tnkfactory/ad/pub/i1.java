package com.tnkfactory.ad.pub;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes6.dex */
public final class i1 extends GradientDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f3140a = null;

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f3140a != null;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f3140a;
        if (colorStateList == null) {
            return false;
        }
        setColor(colorStateList.getColorForState(iArr, 0));
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable
    public final void setColor(ColorStateList colorStateList) {
        this.f3140a = colorStateList;
        if (colorStateList == null) {
            setColor(0);
        } else {
            setColor(this.f3140a.getColorForState(getState(), 0));
        }
    }
}
