package com.tnkfactory.ad.pub;

import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.RewardVideoAdItem;

/* JADX INFO: loaded from: classes6.dex */
public final class e4 extends l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h4 f3126a;

    public e4(h4 h4Var) {
        this.f3126a = h4Var;
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Object obj) {
        h4 h4Var = this.f3126a;
        c cVar = (c) obj;
        h4Var.e = cVar;
        if (cVar == null || cVar.f3114a) {
            h4Var.d = 0;
            AdError adErrorA = cVar == null ? AdError.FAIL_NO_AD : cVar.a();
            h4 h4Var2 = this.f3126a;
            h4Var2.a(h4Var2.f, adErrorA);
            return;
        }
        if (cVar.Z != 1) {
            h4Var.a(h4Var.f, AdError.FAIL_AD_TYPE_INCORRECT);
            return;
        }
        h4Var.d = 2;
        RewardVideoAdItem rewardVideoAdItem = h4Var.f;
        AdListener adListener = h4Var.b;
        if (adListener != null) {
            adListener.onLoad(rewardVideoAdItem);
        }
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Throwable th) {
        this.f3126a.d = 0;
        Logger.e("error #2102 : " + th.toString());
        h4 h4Var = this.f3126a;
        h4Var.a(h4Var.f, AdError.FAIL_SYSTEM);
    }
}
