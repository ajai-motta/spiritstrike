package com.tnkfactory.ad.pub;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class n4 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3167a;
    public int b;
    public int c;
    public int d;
    public float e;
    public float f;

    public n4(Context context) {
        super(context);
        this.f3167a = -8704;
        this.b = -5789785;
        this.c = -1;
        this.d = 5;
        this.e = 0.0f;
        this.f = 5.0f;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.c = i;
    }

    public void setGrayColor(int i) {
        this.b = i;
    }

    public void setMaxRating(float f) {
        if (f > 0.0f) {
            this.f = f;
        }
    }

    public void setNumStars(int i) {
        if (i > 0) {
            this.d = i;
        }
    }

    public void setRating(float f) {
        float f2 = this.f;
        float f3 = this.e;
        float f4 = f / f2;
        if (f3 > 0.0f) {
            f4 = ((int) (f4 / r1)) * (f3 / f2);
        }
        setBackground(new ShapeDrawable(new j1(f4, this.d, this.f3167a, this.b, this.c)));
    }

    public void setStepSize(float f) {
        if (f > 0.0f) {
            this.e = f;
        }
    }

    public void setTintColor(int i) {
        this.f3167a = i;
    }
}
