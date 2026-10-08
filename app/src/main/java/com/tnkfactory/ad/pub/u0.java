package com.tnkfactory.ad.pub;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.BannerAdView;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes6.dex */
public final class u0 implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3200a;
    public final /* synthetic */ b1 b;

    public u0(b1 b1Var, Context context) {
        this.b = b1Var;
        this.f3200a = context;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        y1 y1VarA;
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            this.b.a(this.f3200a, true);
            return true;
        }
        b1 b1Var = this.b;
        Context context = this.f3200a;
        BannerAdView bannerAdView = b1Var.f;
        if (bannerAdView == null) {
            b1Var.a(bannerAdView, AdError.FAIL_SYSTEM);
        } else if (b1Var.d != 2) {
            b1Var.a(bannerAdView, AdError.FAIL_SHOW_BEFORE_LOAD);
        } else if (b1Var.n == 0) {
            b1Var.a(bannerAdView, AdError.FAIL_BANNER_ON_PAUSE);
            Logger.d(h1.a("e4790f98ec43d163f26c24413bfc3bf09adb160a214186"));
        } else if (b1Var.u <= 0 || !b1Var.a(context)) {
            if (b1Var.f.getChildCount() > 0) {
                b1Var.f.removeAllViews();
            }
            b1Var.q = b1Var.e.S;
            a1 a1Var = b1Var.p;
            if (a1Var != null) {
                a1Var.b(1000L);
            }
            c cVar = b1Var.e;
            if (cVar != null && cVar.N >= 26) {
                b1Var.f.removeAllViews();
                float f = b1Var.e.N == 90 ? 100.0f : 50.0f;
                int iApplyDimension = (int) TypedValue.applyDimension(1, f, b1Var.f.getResources().getDisplayMetrics());
                float f2 = b1Var.m;
                g1 g1Var = null;
                if (f2 < iApplyDimension * 0.85f) {
                    if (f == 50.0f) {
                        b1Var.a(b1Var.f, AdError.FAIL_BANNER_HEIGHT_50DP);
                    } else {
                        b1Var.a(b1Var.f, AdError.FAIL_BANNER_HEIGHT_100DP);
                    }
                    b1Var.c();
                    y1VarA = null;
                } else {
                    c cVar2 = b1Var.e;
                    cVar2.b0 = (int) (((double) b1Var.l) + 0.5d);
                    cVar2.c0 = (int) (((double) f2) + 0.5d);
                    y1VarA = y1.a(context, cVar2);
                }
                if (y1VarA == null || !y1VarA.j) {
                    b1Var.a(b1Var.f, AdError.FAIL_AD_FRAME);
                } else {
                    y1VarA.c = new w0(b1Var);
                    c cVar3 = b1Var.e;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(cVar3.b0, cVar3.c0);
                    layoutParams.addRule(13);
                    b1Var.f.addView(y1VarA, layoutParams);
                    try {
                        if (b1Var.e.r0 == null || b1Var.f(context)) {
                            Log.d("BannerAdImpl", "ext_ad null");
                        } else {
                            c cVar4 = b1Var.e.r0;
                            m2 m2VarA = n2.a(context);
                            int i2 = m2VarA.f3159a;
                            int i3 = m2VarA.b;
                            if (i2 >= i3) {
                                i2 = (int) (i3 * 0.9f);
                            }
                            cVar4.b0 = (int) (((double) i2) + 0.5d);
                            cVar4.c0 = i2;
                            int i4 = g1.o;
                            try {
                                System.currentTimeMillis();
                                g1 g1Var2 = new g1(context, cVar4);
                                if (cVar4.M == 4) {
                                    g1Var2.e();
                                }
                                g1Var = g1Var2;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (g1Var != null && g1Var.j) {
                                g1Var.setTag("ext_ad");
                                ViewGroup viewGroup = b1Var.w;
                                if (viewGroup == null) {
                                    FrameLayout frameLayout = (FrameLayout) ((ViewGroup) ((Activity) context).getWindow().getDecorView()).findViewById(android.R.id.content);
                                    View viewFindViewWithTag = frameLayout.findViewWithTag("ext_ad");
                                    if (viewFindViewWithTag != null) {
                                        frameLayout.removeView(viewFindViewWithTag);
                                    }
                                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                                    if (b1Var.e.s0.equals("TOP")) {
                                        layoutParams2.gravity = 48;
                                    } else {
                                        layoutParams2.gravity = 80;
                                    }
                                    frameLayout.addView(g1Var, layoutParams2);
                                } else {
                                    viewGroup.findViewWithTag("ext_ad");
                                    ViewGroup viewGroup2 = b1Var.w;
                                    if (viewGroup2 != null) {
                                        viewGroup2.removeAllViews();
                                        b1Var.w.addView(g1Var);
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                    if (b1Var.e.X) {
                        y1VarA.k = new x0(b1Var, layoutParams);
                    }
                    m4.a(context).b(b1Var.f3115a);
                    b1Var.u = System.currentTimeMillis();
                }
            }
        } else {
            b1Var.a(context, true);
        }
        return true;
    }
}
