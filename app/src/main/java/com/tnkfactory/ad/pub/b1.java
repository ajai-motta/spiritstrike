package com.tnkfactory.ad.pub;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.BannerAdView;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.NativeViewBinder;

/* JADX INFO: loaded from: classes6.dex */
public final class b1 extends c1 {
    public final BannerAdView f;
    public final int g;
    public final int h;
    public final float i;
    public final float j;
    public final float k;
    public float l;
    public float m;
    public int n;
    public Handler o;
    public a1 p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public z0 v;
    public ViewGroup w;

    public b1(AdItem adItem, String str) {
        super(str);
        this.n = 1;
        this.o = null;
        this.p = null;
        this.q = 0L;
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.v = null;
        this.w = null;
        BannerAdView bannerAdView = (BannerAdView) adItem;
        this.f = bannerAdView;
        m2 m2VarB = n2.b(bannerAdView.getContext());
        this.g = m2VarB.f3159a;
        this.h = m2VarB.c;
        DisplayMetrics displayMetrics = bannerAdView.getResources().getDisplayMetrics();
        this.i = (int) TypedValue.applyDimension(1, 320.0f, displayMetrics);
        this.j = (int) TypedValue.applyDimension(1, 360.0f, displayMetrics);
        this.k = (int) TypedValue.applyDimension(1, 50.0f, displayMetrics);
        Context context = bannerAdView.getContext();
        this.d = 0;
        this.p = new a1(this, context);
        this.o = new Handler(new u0(this, context));
        this.p.start();
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final int[] a(int i, int i2) {
        float f;
        int i3;
        float f2 = this.k;
        float f3 = this.i;
        c cVar = this.e;
        if (cVar != null) {
            int i4 = cVar.N;
            if (i4 == 90) {
                f2 *= 2.0f;
            }
            int i5 = cVar.m;
            if (i5 > 0 && (i3 = cVar.n) > 0) {
                float f4 = i5 / i3;
                if ((i4 == 26 && f4 > 6.4f) || (i4 == 90 && f4 > 3.2f)) {
                    f3 = this.j;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            this.m = f2;
        } else {
            float f5 = size;
            this.m = Math.min(f5, f2);
            f2 = f5;
        }
        int mode2 = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i);
        if (mode2 == Integer.MIN_VALUE) {
            f = size2;
            this.l = f;
        } else if (mode2 == 0) {
            f = this.g;
            this.l = f;
        } else {
            f = size2;
            this.l = Math.min(f, f3);
        }
        if (this.h == 0) {
            this.l = Math.min(this.l, f3);
        }
        return new int[]{(int) f, (int) f2};
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void c() {
        ViewTreeObserver viewTreeObserver;
        z0 z0Var;
        this.n = 3;
        a1 a1Var = this.p;
        if (a1Var != null) {
            a1Var.quitSafely();
            this.p = null;
        }
        Handler handler = this.o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.o = null;
        }
        BannerAdView bannerAdView = this.f;
        if (bannerAdView == null || (viewTreeObserver = bannerAdView.getViewTreeObserver()) == null || (z0Var = this.v) == null) {
            return;
        }
        viewTreeObserver.removeOnPreDrawListener(z0Var);
        this.v = null;
    }

    public final synchronized boolean e(Context context) {
        boolean z;
        boolean z2 = false;
        try {
            if (((PowerManager) context.getSystemService("power")).isInteractive()) {
                if (this.f != null) {
                    try {
                        if (((ViewGroup) this.f.getParent()).getLocalVisibleRect(new Rect())) {
                            if (this.s <= 0 || System.currentTimeMillis() - this.s < this.t) {
                                z = true;
                            } else {
                                a1 a1Var = this.p;
                                if (a1Var != null) {
                                    a1Var.a();
                                }
                                z = false;
                            }
                            this.s = 0L;
                            z2 = z;
                        } else {
                            if (this.s == 0) {
                                this.s = System.currentTimeMillis();
                            }
                            a1 a1Var2 = this.p;
                            if (a1Var2 != null) {
                                a1Var2.b(1000L);
                            }
                        }
                    } catch (NullPointerException unused) {
                        if (this.n == 3) {
                            Logger.e(h1.a("e4790f98ec43d163f26c24413bfc3bf08edf100d2b57d18c1419"));
                        } else {
                            Logger.e(h1.a("e4790f98ec43d163f26c24413bfc3bf08edf100d364ad18c1417b86c5ff6a935305ccf59a28323f65f328c4abb"));
                        }
                    }
                }
                return z2;
            }
        } catch (Exception unused2) {
        }
        if (this.s == 0) {
            this.s = System.currentTimeMillis();
        }
        a1 a1Var3 = this.p;
        if (a1Var3 != null) {
            a1Var3.b(1000L);
        }
        return false;
    }

    public final boolean f(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String strValueOf = Build.VERSION.SDK_INT >= 29 ? String.valueOf(activityManager.getRunningAppProcesses().get(0).pid) : String.valueOf(activityManager.getRunningTasks(1).get(0).id);
        Log.d("BannerAdImpl", "taskId : " + strValueOf);
        String string = m4.a(this.f.getContext()).f3161a.getSharedPreferences("__tnk_pub__", 0).getString("__tnk_202301_", "");
        m4.a(this.f.getContext()).a(strValueOf);
        return strValueOf.equals(string);
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void h() {
        Handler handler;
        if (this.n != 1) {
            return;
        }
        this.n = 0;
        if (this.s == 0) {
            this.s = System.currentTimeMillis();
        }
        a1 a1Var = this.p;
        if (a1Var != null && (handler = a1Var.f3104a) != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.f.getChildAt(0) != null) {
            this.f.getChildAt(0).clearAnimation();
        }
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void i() {
        if (e() && this.n == 0) {
            this.n = 1;
            if (this.d != 2 || this.p == null) {
                return;
            }
            if (this.s <= 0 || System.currentTimeMillis() - this.s < this.t) {
                BannerAdView bannerAdView = this.f;
                if (bannerAdView != null) {
                    try {
                        if (!((ViewGroup) bannerAdView.getParent()).isShown()) {
                            throw new Exception();
                        }
                        this.p.b(300L);
                    } catch (Exception unused) {
                        ViewTreeObserver viewTreeObserver = this.f.getViewTreeObserver();
                        z0 z0Var = new z0(this, true);
                        this.v = z0Var;
                        viewTreeObserver.addOnPreDrawListener(z0Var);
                    }
                }
            } else {
                this.p.a();
            }
            this.s = 0L;
        }
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void a(Context context, boolean z) {
        Handler handler;
        if (!e()) {
            a(this.f, AdError.FAIL_NO_PLACEMENT_ID);
            return;
        }
        BannerAdView bannerAdView = this.f;
        if (bannerAdView == null) {
            a(bannerAdView, AdError.FAIL_SYSTEM);
            return;
        }
        if (this.n == 3) {
            a(bannerAdView, AdError.FAIL_INVALID_STATE);
            return;
        }
        if (this.d == 1) {
            a(bannerAdView, AdError.FAIL_DUP_LOAD);
            return;
        }
        if (this.r > 0 && !a(context)) {
            a1 a1Var = this.p;
            if (a1Var != null) {
                a1Var.a(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
            }
            a(this.f, AdError.FAIL_CANCELED);
            return;
        }
        this.d = 1;
        this.e = null;
        this.q = 0L;
        this.u = 0L;
        this.t = 1800000L;
        a1 a1Var2 = this.p;
        if (a1Var2 != null && (handler = a1Var2.f3104a) != null) {
            handler.removeCallbacksAndMessages(null);
        }
        new t0(context).a(this.f3115a, 4, z, new v0(this));
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void a(ViewGroup viewGroup, NativeViewBinder nativeViewBinder) {
        this.w = viewGroup;
    }

    public static RelativeLayout a(Context context, TextView textView) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundColor(Color.parseColor("#00000000"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        textView.setLayoutParams(layoutParams);
        textView.setPadding((int) TypedValue.applyDimension(1, 7.0f, context.getResources().getDisplayMetrics()), 0, (int) TypedValue.applyDimension(1, 7.0f, context.getResources().getDisplayMetrics()), 0);
        textView.setGravity(17);
        textView.setMaxEms(7);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setTextColor(n2.a("0xFFFFFFFF", "0xFF006B00"));
        textView.setTextSize(2, 15.0f);
        textView.setText(r2.a().d);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(n2.a("0xFF00BF00", "0xFF008F00"));
        textView.setBackground(gradientDrawable);
        textView.setVisibility(4);
        relativeLayout.addView(textView);
        if (textView.getVisibility() != 0) {
            Animation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setAnimationListener(new y0(textView));
            textView.setAnimation(translateAnimation);
            textView.setVisibility(0);
            relativeLayout.setOnClickListener(null);
        }
        return relativeLayout;
    }
}
