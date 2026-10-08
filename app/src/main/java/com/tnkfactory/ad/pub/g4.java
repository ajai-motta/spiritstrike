package com.tnkfactory.ad.pub;

import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.RewardVideoAdItem;

/* JADX INFO: loaded from: classes6.dex */
public final class g4 implements k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h4 f3134a;

    public g4(h4 h4Var) {
        this.f3134a = h4Var;
    }

    @Override // com.tnkfactory.ad.pub.k2
    public final void a(int i) {
        this.f3134a.a();
        h4 h4Var = this.f3134a;
        RewardVideoAdItem rewardVideoAdItem = h4Var.f;
        AdListener adListener = h4Var.b;
        if (adListener != null) {
            adListener.onClose(rewardVideoAdItem, i);
        }
    }

    @Override // com.tnkfactory.ad.pub.k2
    public final void b() {
        h4 h4Var = this.f3134a;
        RewardVideoAdItem rewardVideoAdItem = h4Var.f;
        AdListener adListener = h4Var.b;
        if (adListener != null) {
            adListener.onShow(rewardVideoAdItem);
        }
    }

    @Override // com.tnkfactory.ad.pub.k2
    public final void b(int i) {
        h4 h4Var = this.f3134a;
        RewardVideoAdItem rewardVideoAdItem = h4Var.f;
        AdListener adListener = h4Var.b;
        if (adListener != null) {
            adListener.onVideoCompletion(rewardVideoAdItem, i);
        }
    }

    @Override // com.tnkfactory.ad.pub.k2
    public final void a() {
        h4 h4Var = this.f3134a;
        RewardVideoAdItem rewardVideoAdItem = h4Var.f;
        AdListener adListener = h4Var.b;
        if (adListener != null) {
            adListener.onClick(rewardVideoAdItem);
        }
    }
}
