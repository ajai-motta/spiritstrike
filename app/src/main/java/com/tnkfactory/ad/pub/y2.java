package com.tnkfactory.ad.pub;

import android.view.View;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.NativeAdItem;

/* JADX INFO: loaded from: classes6.dex */
public final class y2 extends l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i3 f3224a;

    public y2(i3 i3Var) {
        this.f3224a = i3Var;
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Object obj) {
        i3 i3Var = this.f3224a;
        c cVar = (c) obj;
        i3Var.e = cVar;
        if (cVar == null || cVar.f3114a) {
            i3Var.d = 0;
            AdError adErrorA = cVar == null ? AdError.FAIL_NO_AD : cVar.a();
            i3 i3Var2 = this.f3224a;
            i3Var2.a(i3Var2.f, adErrorA);
            return;
        }
        i3Var.d = 2;
        NativeAdItem nativeAdItem = i3Var.f;
        AdListener adListener = i3Var.b;
        if (adListener != null) {
            adListener.onLoad(nativeAdItem);
        }
        i3 i3Var3 = this.f3224a;
        if (i3Var3.k == null || !i3Var3.l()) {
            return;
        }
        if (n2.a((View) this.f3224a.k, false)) {
            this.f3224a.m();
        } else {
            this.f3224a.k();
        }
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Throwable th) {
        this.f3224a.d = 0;
        Logger.e("error #2201 : " + th.toString());
        i3 i3Var = this.f3224a;
        i3Var.a(i3Var.f, AdError.FAIL_SYSTEM);
    }
}
