package com.tnkfactory.ad.pub;

import android.app.Activity;
import android.content.Context;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.InterstitialAdItem;

/* JADX INFO: loaded from: classes6.dex */
public final class j2 extends c1 {
    public final InterstitialAdItem f;
    public c4 g;

    public j2(AdItem adItem, String str) {
        super(str);
        this.f = (InterstitialAdItem) adItem;
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
        f2Var.a(str, i == 0 ? 0 : 1, z, new g2(this));
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void b() {
        this.g.e.sendEmptyMessage(0);
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void d(Context context) {
        int i = this.d;
        if (i == 3) {
            a(this.f, AdError.FAIL_DUP_SHOW);
            return;
        }
        if (i == 0 || i == 1) {
            a(this.f, AdError.FAIL_SHOW_BEFORE_LOAD);
            return;
        }
        this.d = 3;
        t5 t5Var = new t5(context);
        c cVar = this.e;
        if (!t5Var.a(cVar.f0, cVar.P) || ((Activity) context).isFinishing()) {
            a(this.f, AdError.FAIL_FINISHED_ACTIVITY);
        } else {
            t5Var.post(new h2(this, t5Var));
        }
    }
}
