package com.tnkfactory.ad.pub;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tnkfactory.ad.AdError;

/* JADX INFO: loaded from: classes6.dex */
public final class c2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d2 f3116a;

    public c2(d2 d2Var) {
        this.f3116a = d2Var;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        d2 d2Var = this.f3116a;
        d2Var.f.getWidth();
        d2Var.f.getHeight();
        Context context = d2Var.f.getContext();
        c cVar = d2Var.e;
        int i = cVar.N;
        cVar.b0 = (int) d2Var.j;
        float f = d2Var.k;
        cVar.c0 = (int) f;
        y1 y1Var = null;
        if (f < d2Var.g) {
            d2Var.a(d2Var.f, AdError.FAIL_BANNER_HEIGHT_100DP);
        } else {
            y1 y1VarA = y1.a(context, cVar);
            if (y1VarA == null || !y1VarA.j) {
                d2Var.a(d2Var.f, AdError.FAIL_AD_FRAME);
            } else {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) d2Var.j, (int) d2Var.k);
                layoutParams.addRule(13);
                y1VarA.setLayoutParams(layoutParams);
                y1Var = y1VarA;
            }
        }
        if (y1Var != null) {
            d2Var.f.addView(y1Var);
        }
    }
}
