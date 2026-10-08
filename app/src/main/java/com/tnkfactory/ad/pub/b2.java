package com.tnkfactory.ad.pub;

import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.FeedAdView;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes6.dex */
public final class b2 extends l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d2 f3110a;

    public b2(d2 d2Var) {
        this.f3110a = d2Var;
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Object obj) {
        d2 d2Var = this.f3110a;
        c cVar = (c) obj;
        d2Var.e = cVar;
        if (cVar == null || cVar.f3114a) {
            d2Var.d = 0;
            AdError adErrorA = cVar == null ? AdError.FAIL_NO_AD : cVar.a();
            d2 d2Var2 = this.f3110a;
            d2Var2.a(d2Var2.f, adErrorA);
            return;
        }
        d2Var.d = 2;
        FeedAdView feedAdView = d2Var.f;
        AdListener adListener = d2Var.b;
        if (adListener != null) {
            adListener.onLoad(feedAdView);
        }
        d2 d2Var3 = this.f3110a;
        d2Var3.f.post(new c2(d2Var3));
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Throwable th) {
        this.f3110a.d = 0;
        Logger.e("error #2102 : " + th.toString());
        d2 d2Var = this.f3110a;
        d2Var.a(d2Var.f, AdError.FAIL_SYSTEM);
    }
}
