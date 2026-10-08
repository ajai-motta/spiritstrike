package com.tnkfactory.ad;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class NativeViewBinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3101a = false;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public int s = 0;
    public int t = 0;
    public int u = 0;
    public int v = 0;
    public int w = -8704;
    public int x = -5789785;
    public int y = -1;
    public int z = 5;
    public float A = 0.0f;
    public float B = 5.0f;
    public final ArrayList C = new ArrayList();

    public NativeViewBinder(int i) {
        a(4, i);
    }

    public final void a(int i, int i2) {
        if (i == 100) {
            this.C.add(Integer.valueOf(i2));
        }
        switch (i) {
            case 1:
                this.l = i2;
                this.f3101a = true;
                break;
            case 2:
                this.m = i2;
                this.b = true;
                break;
            case 3:
                this.n = i2;
                this.c = true;
                break;
            case 4:
                this.o = i2;
                this.d = true;
                break;
            case 5:
                this.p = i2;
                this.e = true;
                break;
            case 6:
                this.q = i2;
                this.f = true;
                break;
            case 7:
                this.r = i2;
                this.g = true;
                break;
            case 8:
                this.s = i2;
                this.h = true;
                break;
            case 9:
                this.t = i2;
                this.i = true;
                break;
            case 10:
                this.u = i2;
                this.j = true;
                break;
            case 11:
                this.v = i2;
                this.k = true;
                break;
        }
    }

    public NativeViewBinder addClickView(int i) {
        a(100, i);
        return this;
    }

    public NativeViewBinder advertiserLogoId(int i) {
        a(6, i);
        return this;
    }

    public NativeViewBinder advertiserNameId(int i) {
        a(5, i);
        return this;
    }

    public NativeViewBinder callToActionId(int i) {
        a(7, i);
        return this;
    }

    public NativeViewBinder contentId(int i) {
        a(4, i);
        return this;
    }

    public NativeViewBinder downloadCountId(int i) {
        a(9, i);
        return this;
    }

    public NativeViewBinder iconId(int i) {
        a(3, i);
        return this;
    }

    public NativeViewBinder numberRatingId(int i) {
        a(11, i);
        return this;
    }

    public NativeViewBinder starRatingColors(int i, int i2, int i3) {
        this.w = i;
        this.x = i2;
        this.y = i3;
        return this;
    }

    public NativeViewBinder starRatingId(int i) {
        a(10, i);
        return this;
    }

    public NativeViewBinder starRatingProperties(int i, float f, float f2, int i2, int i3, int i4) {
        this.z = i;
        this.B = f;
        this.A = f2;
        this.w = i2;
        this.x = i3;
        this.y = i4;
        return this;
    }

    public NativeViewBinder textId(int i) {
        a(2, i);
        return this;
    }

    public NativeViewBinder titleId(int i) {
        a(1, i);
        return this;
    }

    public NativeViewBinder watermarkIconId(int i) {
        a(8, i);
        return this;
    }

    public NativeViewBinder starRatingProperties(int i, float f, float f2) {
        this.z = i;
        this.B = f;
        this.A = f2;
        return this;
    }
}
