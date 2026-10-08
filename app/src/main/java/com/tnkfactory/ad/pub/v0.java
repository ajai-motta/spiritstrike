package com.tnkfactory.ad.pub;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.BannerAdView;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes6.dex */
public final class v0 extends l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f3206a;

    public v0(b1 b1Var) {
        this.f3206a = b1Var;
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Object obj) {
        BannerAdView bannerAdView;
        b1 b1Var = this.f3206a;
        if (b1Var.n == 3) {
            return;
        }
        c cVar = (c) obj;
        b1Var.e = cVar;
        if (cVar == null || cVar.f3114a) {
            b1Var.d = 0;
            long jCurrentTimeMillis = System.currentTimeMillis();
            b1 b1Var2 = this.f3206a;
            if (jCurrentTimeMillis - b1Var2.r >= b1Var2.t && (bannerAdView = b1Var2.f) != null && bannerAdView.getChildCount() > 0) {
                this.f3206a.f.removeAllViews();
                this.f3206a.f.invalidate();
            }
            a1 a1Var = this.f3206a.p;
            if (a1Var != null) {
                a1Var.a(1800000L);
            }
            c cVar2 = this.f3206a.e;
            AdError adErrorA = cVar2 == null ? AdError.FAIL_NO_AD : cVar2.a();
            b1 b1Var3 = this.f3206a;
            b1Var3.a(b1Var3.f, adErrorA);
            return;
        }
        b1Var.r = System.currentTimeMillis();
        b1 b1Var4 = this.f3206a;
        b1Var4.t = 1800000L;
        long j = b1Var4.e.S;
        if (j > 0) {
            b1Var4.t = j * 1000;
        }
        b1Var4.d = 2;
        BannerAdView bannerAdView2 = b1Var4.f;
        AdListener adListener = b1Var4.b;
        if (adListener != null) {
            adListener.onLoad(bannerAdView2);
        }
        BannerAdView bannerAdView3 = this.f3206a.f;
        if (bannerAdView3 != null) {
            try {
            } catch (Exception unused) {
                b1 b1Var5 = this.f3206a;
                ViewTreeObserver viewTreeObserver = b1Var5.f.getViewTreeObserver();
                z0 z0Var = new z0(b1Var5, false);
                b1Var5.v = z0Var;
                viewTreeObserver.addOnPreDrawListener(z0Var);
            }
            if (!((ViewGroup) bannerAdView3.getParent()).isShown()) {
                throw new Exception();
            }
            a1 a1Var2 = this.f3206a.p;
            if (a1Var2 != null) {
                a1Var2.b();
            }
            this.f3206a.f.requestLayout();
        }
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Throwable th) {
        BannerAdView bannerAdView;
        Logger.e(th.getMessage() == null ? th.toString() : th.getMessage());
        b1 b1Var = this.f3206a;
        if (b1Var.n == 3) {
            return;
        }
        b1Var.d = 0;
        long jCurrentTimeMillis = System.currentTimeMillis();
        b1 b1Var2 = this.f3206a;
        if (jCurrentTimeMillis - b1Var2.r >= b1Var2.t && (bannerAdView = b1Var2.f) != null && bannerAdView.getChildCount() > 0) {
            this.f3206a.f.removeAllViews();
            this.f3206a.f.invalidate();
        }
        a1 a1Var = this.f3206a.p;
        if (a1Var != null) {
            a1Var.a(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
        }
        b1 b1Var3 = this.f3206a;
        b1Var3.a(b1Var3.f, AdError.FAIL_SYSTEM);
    }
}
