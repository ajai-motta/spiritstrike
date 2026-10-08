package com.tnkfactory.ad.pub;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public final class y1 extends v {
    public y1(Context context, c cVar) {
        super(context, cVar.b0, cVar.c0, cVar, false);
    }

    @Override // com.tnkfactory.ad.pub.v
    public final void a(int i, boolean z) {
    }

    public static y1 a(Context context, c cVar) {
        try {
            System.currentTimeMillis();
            y1 y1Var = new y1(context, cVar);
            if (cVar.M == 4) {
                y1Var.e();
            }
            return y1Var;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
