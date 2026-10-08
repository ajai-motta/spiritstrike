package com.tnkfactory.ad.pub;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: classes6.dex */
public final class u3 extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3203a;
    public final Scroller b;
    public final Runnable c;
    public i4 d;
    public final HorizontalScrollView e;
    public final ScrollView f;
    public final LinearLayout g;
    public o3 h;
    public float i;
    public float j;
    public int k;
    public int l;
    public int m;
    public int n;
    public long o;
    public long p;
    public p3 q;

    public u3(Context context, int i, int i2) {
        super(context);
        this.f3203a = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = -1.0f;
        this.j = -1.0f;
        this.k = 0;
        this.l = 50;
        this.m = 800;
        this.n = 1100;
        this.o = 0L;
        this.p = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        this.q = null;
        if (i == 1) {
            this.f3203a = 1;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            ScrollView scrollView = new ScrollView(context);
            this.f = scrollView;
            scrollView.setLayoutParams(layoutParams);
            scrollView.setVerticalScrollBarEnabled(false);
            scrollView.setHorizontalScrollBarEnabled(false);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            if (i2 == 1) {
                layoutParams2.gravity = 51;
            } else if (i2 != 2) {
                layoutParams2.gravity = 49;
            } else {
                layoutParams2.gravity = 53;
            }
            LinearLayout linearLayout = new LinearLayout(context);
            this.g = linearLayout;
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setOrientation(1);
            scrollView.addView(linearLayout);
            addView(scrollView);
            this.b = new Scroller(scrollView.getContext(), new DecelerateInterpolator(2.0f));
            this.c = new s3(this);
            scrollView.setOnTouchListener(new t3(this));
            return;
        }
        this.f3203a = 0;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        this.e = horizontalScrollView;
        horizontalScrollView.setLayoutParams(layoutParams3);
        horizontalScrollView.setVerticalScrollBarEnabled(false);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        if (i2 == 1) {
            layoutParams4.gravity = 51;
        } else if (i2 != 2) {
            layoutParams4.gravity = 19;
        } else {
            layoutParams4.gravity = 83;
        }
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.g = linearLayout2;
        linearLayout2.setLayoutParams(layoutParams4);
        linearLayout2.setOrientation(0);
        horizontalScrollView.addView(linearLayout2);
        addView(horizontalScrollView);
        this.b = new Scroller(horizontalScrollView.getContext(), new DecelerateInterpolator(2.0f));
        this.c = new q3(this);
        horizontalScrollView.setOnTouchListener(new r3(this));
    }

    private int getCurrentScrollPosition() {
        return this.f3203a == 1 ? this.f.getScrollY() : this.e.getScrollX();
    }

    public final void a(View view) {
        if (this.f3203a == 1) {
            this.m = view.getLayoutParams().height;
        } else {
            this.m = view.getLayoutParams().width;
        }
        i4 i4Var = this.d;
        if (i4Var != null) {
            view.setOutlineProvider(i4Var);
        }
        this.g.addView(view);
    }

    public int getCurrentPage() {
        return this.k;
    }

    public int getPageCount() {
        LinearLayout linearLayout = this.g;
        if (linearLayout == null) {
            return 0;
        }
        return linearLayout.getChildCount();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        long j = this.o;
        if (j > 0) {
            p3 p3Var = new p3(this);
            this.q = p3Var;
            postDelayed(p3Var, j);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p3 p3Var = this.q;
        if (p3Var != null) {
            removeCallbacks(p3Var);
        }
    }

    public void setPageIndicator(o3 o3Var) {
        o3 o3Var2 = this.h;
        if (o3Var2 != null) {
            removeView(o3Var2);
        }
        this.h = o3Var;
        if (o3Var != null) {
            o3Var.setCount(getPageCount());
            addView(this.h);
        }
    }

    public void setPageMargin(int i) {
        this.l = i;
        if (this.f3203a == 1) {
            this.n = getLayoutParams().height;
        } else {
            this.n = getLayoutParams().width;
        }
    }

    public void setPageClipRound(int i) {
        this.d = new i4(i);
    }

    public final boolean a(MotionEvent motionEvent) {
        float x;
        float f;
        float x2;
        int action = motionEvent.getAction();
        if (action == 0) {
            p3 p3Var = this.q;
            if (p3Var != null) {
                removeCallbacks(p3Var);
            }
            if (!this.b.isFinished()) {
                this.b.abortAnimation();
                removeCallbacks(this.c);
            }
            this.i = -1.0f;
            this.j = -1.0f;
            if (this.f3203a == 1) {
                x = motionEvent.getY();
            } else {
                x = motionEvent.getX();
            }
            this.i = x;
            this.j = x;
            return false;
        }
        if (action != 1) {
            if (action == 2) {
                if (this.f3203a == 1) {
                    x2 = motionEvent.getY();
                } else {
                    x2 = motionEvent.getX();
                }
                this.j = x2;
                return false;
            }
            if (action != 3) {
                return false;
            }
            if (!this.b.isFinished()) {
                this.b.abortAnimation();
                removeCallbacks(this.c);
            }
            this.i = -1.0f;
            this.j = -1.0f;
            return false;
        }
        float f2 = this.i - this.j;
        float currentScrollPosition = getCurrentScrollPosition();
        if (f2 > 0.0f) {
            f = (currentScrollPosition + this.m) / (r5 + this.l);
        } else {
            f = ((currentScrollPosition - this.m) / (r5 + this.l)) + 1.0f;
        }
        int i = (int) f;
        this.k = i;
        a(i);
        o3 o3Var = this.h;
        if (o3Var != null) {
            o3Var.g = this.k;
            o3Var.invalidate();
        }
        return true;
    }

    public final void a(int i) {
        if (getPageCount() == 0) {
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= getPageCount()) {
            i = getPageCount() - 1;
        }
        int currentScrollPosition = ((this.m + this.l) * i) - getCurrentScrollPosition();
        float fAbs = Math.abs(currentScrollPosition);
        int i2 = (int) ((fAbs / (this.n + fAbs)) * 1000.0f);
        if (this.f3203a == 1) {
            this.b.startScroll(0, getCurrentScrollPosition(), 0, currentScrollPosition, i2);
        } else {
            this.b.startScroll(getCurrentScrollPosition(), 0, currentScrollPosition, 0, i2);
        }
        post(this.c);
    }
}
