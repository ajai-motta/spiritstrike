package com.tnkfactory.ad.pub;

import android.content.Context;
import android.view.ViewParent;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes6.dex */
public final class g1 extends v {
    public static final /* synthetic */ int o = 0;

    public g1(Context context, c cVar) {
        super(context, cVar.b0, cVar.c0, cVar, false);
    }

    @Override // com.tnkfactory.ad.pub.v
    public final void a(int i, boolean z) {
        try {
            q0.a(3);
            Animation[] animationArrA = this.d.s0.equals("TOP") ? q0.a(4) : q0.a(3);
            this.f3205a = animationArrA[0];
            this.b = animationArrA[1];
            setVisibility(8);
            postDelayed(new f1(this, i), this.b.getDuration());
            startAnimation(this.b);
        } catch (Exception unused) {
        }
    }

    public static t5 a(ViewParent viewParent) {
        if (viewParent == null) {
            return null;
        }
        if (viewParent instanceof t5) {
            return (t5) viewParent;
        }
        return a(viewParent.getParent());
    }
}
