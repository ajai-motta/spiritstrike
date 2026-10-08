package com.tnkfactory.ad.pub;

import android.app.Activity;
import android.content.Context;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.RewardVideoAdItem;
import com.tnkfactory.ad.RewardVideoAdListener;

/* JADX INFO: loaded from: classes6.dex */
public final class h4 extends c1 {
    public final RewardVideoAdItem f;
    public c4 g;

    public h4(AdItem adItem, String str) {
        super(str);
        this.f = (RewardVideoAdItem) adItem;
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void a(Context context, boolean z) {
        if (!e()) {
            a(this.f, AdError.FAIL_NO_PLACEMENT_ID);
            return;
        }
        if (this.d != 0) {
            a(this.f, AdError.FAIL_DUP_LOAD);
            return;
        }
        if (!a(context)) {
            a(this.f, AdError.FAIL_CANCELED);
            return;
        }
        this.d = 1;
        m2 m2VarB = n2.b(context);
        f2 f2Var = new f2(context);
        String str = this.f3115a;
        int i = m2VarB.c;
        f2Var.a(str, i == 0 ? 0 : 1, z, new e4(this));
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void b() {
        this.g.e.sendEmptyMessage(0);
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void d(Context context) {
        try {
            int i = this.d;
            if (i == 3) {
                RewardVideoAdItem rewardVideoAdItem = this.f;
                AdError adError = AdError.FAIL_DUP_SHOW;
                AdListener adListener = this.b;
                if (adListener != null) {
                    if (adListener instanceof RewardVideoAdListener) {
                        ((RewardVideoAdListener) adListener).onShowFail(rewardVideoAdItem, adError);
                        return;
                    } else {
                        adListener.onError(rewardVideoAdItem, adError);
                        return;
                    }
                }
                return;
            }
            if (i != 0 && i != 1) {
                this.d = 3;
                t5 t5Var = new t5(context);
                c cVar = this.e;
                if (t5Var.a(cVar.f0, cVar.P) && !((Activity) context).isFinishing()) {
                    t5Var.post(new f4(this, t5Var));
                    return;
                }
                RewardVideoAdItem rewardVideoAdItem2 = this.f;
                AdError adError2 = AdError.FAIL_FINISHED_ACTIVITY;
                AdListener adListener2 = this.b;
                if (adListener2 != null) {
                    if (adListener2 instanceof RewardVideoAdListener) {
                        ((RewardVideoAdListener) adListener2).onShowFail(rewardVideoAdItem2, adError2);
                        return;
                    } else {
                        adListener2.onError(rewardVideoAdItem2, adError2);
                        return;
                    }
                }
                return;
            }
            RewardVideoAdItem rewardVideoAdItem3 = this.f;
            AdError adError3 = AdError.FAIL_SHOW_BEFORE_LOAD;
            AdListener adListener3 = this.b;
            if (adListener3 != null) {
                if (adListener3 instanceof RewardVideoAdListener) {
                    ((RewardVideoAdListener) adListener3).onShowFail(rewardVideoAdItem3, adError3);
                } else {
                    adListener3.onError(rewardVideoAdItem3, adError3);
                }
            }
        } catch (Exception e) {
            RewardVideoAdItem rewardVideoAdItem4 = this.f;
            AdError adError4 = AdError.FAIL_SYSTEM;
            AdListener adListener4 = this.b;
            if (adListener4 != null) {
                if (adListener4 instanceof RewardVideoAdListener) {
                    ((RewardVideoAdListener) adListener4).onShowFail(rewardVideoAdItem4, adError4);
                } else {
                    adListener4.onError(rewardVideoAdItem4, adError4);
                }
            }
            Logger.e(e.getMessage());
            e.printStackTrace();
        }
    }
}
