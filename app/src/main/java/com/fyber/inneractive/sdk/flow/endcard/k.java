package com.fyber.inneractive.sdk.flow.endcard;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.flow.x0;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x0 f1049a;
    public final m b;
    public final boolean c;
    public final com.fyber.inneractive.sdk.flow.endcard.loaders.b d;
    public final h e;
    public final int f;

    public k(Context context, t0 t0Var) {
        x0 x0Var = new x0(context, t0Var);
        m mVar = new m();
        this.b = mVar;
        this.f1049a = x0Var;
        this.c = !TextUtils.equals(x0Var.d.E, "1");
        h hVar = new h();
        this.e = hVar;
        this.f = hVar.b;
        this.d = new com.fyber.inneractive.sdk.flow.endcard.loaders.b(x0Var, mVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        if (r0.c >= 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fyber.inneractive.sdk.flow.endcard.b a() {
        /*
            r7 = this;
            com.fyber.inneractive.sdk.flow.endcard.m r0 = r7.b
            java.util.ArrayList r1 = r0.f1058a
            int r1 = r1.size()
            int r2 = r0.c
        La:
            int r2 = r2 + 1
            if (r2 >= r1) goto L7a
            java.util.ArrayList r3 = r0.f1058a
            java.lang.Object r3 = r3.get(r2)
            com.fyber.inneractive.sdk.flow.endcard.b r3 = (com.fyber.inneractive.sdk.flow.endcard.b) r3
            boolean r4 = r3.l()
            if (r4 == 0) goto La
            com.fyber.inneractive.sdk.model.vast.i r1 = r3.i()
            com.fyber.inneractive.sdk.model.vast.i r4 = com.fyber.inneractive.sdk.model.vast.i.Default_End_Card
            if (r1 != r4) goto L43
            java.util.ArrayList r1 = r0.b
            int r1 = r1.size()
            int r1 = r1 + (-1)
        L2c:
            if (r1 < 0) goto L3e
            java.util.ArrayList r4 = r0.b
            java.lang.Object r4 = r4.get(r1)
            com.fyber.inneractive.sdk.flow.endcard.b r4 = (com.fyber.inneractive.sdk.flow.endcard.b) r4
            boolean r4 = r4 instanceof com.fyber.inneractive.sdk.flow.endcard.o
            if (r4 == 0) goto L3b
            goto L7a
        L3b:
            int r1 = r1 + (-1)
            goto L2c
        L3e:
            int r1 = r0.c
            if (r1 < 0) goto L6a
            goto L7a
        L43:
            boolean r1 = r3 instanceof com.fyber.inneractive.sdk.flow.endcard.c
            if (r1 == 0) goto L6a
            int r1 = r2 + 1
            java.util.ArrayList r4 = r0.f1058a
            int r4 = r4.size()
            int r4 = r4 + (-1)
        L51:
            if (r4 < r1) goto L6a
            java.util.ArrayList r5 = r0.f1058a
            java.lang.Object r5 = r5.get(r4)
            com.fyber.inneractive.sdk.flow.endcard.b r5 = (com.fyber.inneractive.sdk.flow.endcard.b) r5
            boolean r6 = r5 instanceof com.fyber.inneractive.sdk.flow.endcard.c
            if (r6 == 0) goto L67
            r5.destroy()
            java.util.ArrayList r5 = r0.f1058a
            r5.remove(r4)
        L67:
            int r4 = r4 + (-1)
            goto L51
        L6a:
            r0.c = r2
            java.util.ArrayList r1 = r0.b
            r1.add(r3)
            java.util.ArrayList r0 = r0.b
            int r0 = r0.size()
            r3.e = r0
            goto L7b
        L7a:
            r3 = 0
        L7b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.endcard.k.a():com.fyber.inneractive.sdk.flow.endcard.b");
    }
}
