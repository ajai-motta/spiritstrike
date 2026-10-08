package com.tnkfactory.ad.pub;

import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.InterstitialAdItem;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes6.dex */
public final class g2 extends l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j2 f3132a;

    public g2(j2 j2Var) {
        this.f3132a = j2Var;
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Object obj) {
        j2 j2Var = this.f3132a;
        c cVar = (c) obj;
        j2Var.e = cVar;
        if (cVar == null || cVar.f3114a) {
            j2Var.d = 0;
            AdError adErrorA = cVar == null ? AdError.FAIL_NO_AD : cVar.a();
            j2 j2Var2 = this.f3132a;
            j2Var2.a(j2Var2.f, adErrorA);
            return;
        }
        j2Var.d = 2;
        InterstitialAdItem interstitialAdItem = j2Var.f;
        AdListener adListener = j2Var.b;
        if (adListener != null) {
            adListener.onLoad(interstitialAdItem);
        }
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Throwable th) {
        this.f3132a.d = 0;
        Logger.e("error #2102 : " + th.toString());
        j2 j2Var = this.f3132a;
        j2Var.a(j2Var.f, AdError.FAIL_SYSTEM);
    }
}
