package com.fyber.inneractive.sdk.flow.nativead;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1078a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ com.fyber.inneractive.sdk.util.g c;
    public final /* synthetic */ p d;

    public m(p pVar, i iVar, boolean z, com.fyber.inneractive.sdk.util.g gVar) {
        this.d = pVar;
        this.f1078a = iVar;
        this.b = z;
        this.c = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r7 = this;
            com.fyber.inneractive.sdk.flow.nativead.p r0 = r7.d
            com.fyber.inneractive.sdk.flow.nativead.i r1 = r7.f1078a
            boolean r2 = r7.b
            com.fyber.inneractive.sdk.util.g r3 = r7.c
            r0.getClass()
            java.lang.String r4 = r1.f1076a
            java.lang.String r5 = r1.b
            boolean r6 = com.fyber.inneractive.sdk.util.v.a(r4)
            if (r6 == 0) goto L1b
            com.fyber.inneractive.sdk.flow.nativead.n r6 = new com.fyber.inneractive.sdk.flow.nativead.n
            r6.<init>(r0, r1, r5, r3)
            goto L27
        L1b:
            boolean r4 = com.fyber.inneractive.sdk.util.v.a(r5)
            if (r4 == 0) goto L33
            com.fyber.inneractive.sdk.flow.nativead.o r6 = new com.fyber.inneractive.sdk.flow.nativead.o
            r6.<init>(r0, r1, r3)
            r4 = r5
        L27:
            com.fyber.inneractive.sdk.flow.nativead.l r0 = r0.f1083a
            com.fyber.inneractive.sdk.flow.nativead.j r0 = (com.fyber.inneractive.sdk.flow.nativead.j) r0
            com.fyber.inneractive.sdk.flow.nativead.k r0 = r0.b
            if (r0 == 0) goto L64
            r0.a(r4, r2, r3, r6)
            goto L64
        L33:
            com.fyber.inneractive.sdk.flow.nativead.l r0 = r0.f1083a
            com.fyber.inneractive.sdk.flow.nativead.j r0 = (com.fyber.inneractive.sdk.flow.nativead.j) r0
            com.fyber.inneractive.sdk.flow.nativead.i r2 = r0.f1077a
            r4 = 1
            if (r2 == 0) goto L55
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L43
            goto L55
        L43:
            com.fyber.inneractive.sdk.flow.nativead.p r1 = r0.c
            com.fyber.inneractive.sdk.flow.nativead.i r0 = r0.f1077a
            r1.getClass()
            java.util.concurrent.ThreadPoolExecutor r2 = com.fyber.inneractive.sdk.util.r.f1668a
            com.fyber.inneractive.sdk.flow.nativead.m r5 = new com.fyber.inneractive.sdk.flow.nativead.m
            r5.<init>(r1, r0, r4, r3)
            r2.execute(r5)
            goto L64
        L55:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = com.fyber.inneractive.sdk.flow.nativead.j.d
            r2 = 0
            r0[r2] = r1
            r0[r4] = r3
            java.lang.String r1 = "%s : No valid link object, origin: %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r0)
        L64:
            com.fyber.inneractive.sdk.flow.nativead.p r0 = r7.d
            com.fyber.inneractive.sdk.flow.nativead.i r1 = r7.f1078a
            r0.getClass()
            java.util.ArrayList r0 = r1.c
            java.util.Iterator r0 = r0.iterator()
        L71:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L87
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            com.fyber.inneractive.sdk.network.z0.b(r1)
            goto L71
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.nativead.m.run():void");
    }
}
