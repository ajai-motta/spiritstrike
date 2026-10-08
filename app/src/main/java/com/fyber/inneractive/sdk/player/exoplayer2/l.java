package com.fyber.inneractive.sdk.player.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Handler.Callback, com.fyber.inneractive.sdk.player.exoplayer2.source.r, com.fyber.inneractive.sdk.player.exoplayer2.source.t {
    public h A;
    public h B;
    public x C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a[] f1394a;
    public final a[] b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.trackselection.i c;
    public final c d;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.u e;
    public final Handler f;
    public final HandlerThread g;
    public final Handler h;
    public final w i;
    public final v j;
    public i k;
    public s l;
    public a m;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.h n;
    public com.fyber.inneractive.sdk.player.exoplayer2.source.u o;
    public a[] p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u = 1;
    public long v;
    public int w;
    public j x;
    public long y;
    public h z;

    public l(a[] aVarArr, com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d dVar, c cVar, boolean z, f fVar, i iVar, g gVar) {
        this.f1394a = aVarArr;
        this.c = dVar;
        this.d = cVar;
        this.r = z;
        this.h = fVar;
        this.k = iVar;
        this.b = new a[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            a aVar = aVarArr[i];
            aVar.getClass();
            this.b[i] = aVar;
        }
        this.e = new com.fyber.inneractive.sdk.player.exoplayer2.util.u();
        this.p = new a[0];
        this.i = new w();
        this.j = new v();
        this.l = s.d;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.g = handlerThread;
        handlerThread.start();
        this.f = new Handler(handlerThread.getLooper(), this);
    }

    public static void a(a aVar) {
        int i = aVar.c;
        if (i == 2) {
            if (i != 2) {
                throw new IllegalStateException();
            }
            aVar.c = 1;
            aVar.j();
        }
    }

    public final void b(boolean z) {
        if (this.t != z) {
            this.t = z;
            this.h.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    public final void c(boolean z) {
        this.s = false;
        this.r = z;
        if (!z) {
            g();
            h();
            a(false);
            return;
        }
        int i = this.u;
        if (i != 3) {
            if (i == 2) {
                this.f.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.s = false;
        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
        if (!uVar.f1477a) {
            uVar.c = SystemClock.elapsedRealtime();
            uVar.f1477a = true;
        }
        for (a aVar : this.p) {
            if (aVar.c != 1) {
                throw new IllegalStateException();
            }
            aVar.c = 2;
            aVar.i();
        }
        this.f.sendEmptyMessage(2);
    }

    public final synchronized void d() {
        if (this.q) {
            return;
        }
        this.f.sendEmptyMessage(6);
        while (!this.q) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.g.quit();
    }

    public final void e() {
        a(true);
        this.d.a(true);
        a(1);
        synchronized (this) {
            this.q = true;
            notifyAll();
        }
    }

    public final void f() throws d {
        h hVar = this.B;
        if (hVar == null) {
            return;
        }
        boolean z = true;
        while (hVar != null && hVar.i) {
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVarA = hVar.p.a(hVar.o, hVar.f1390a.a());
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar = hVar.s;
            if (jVar != null) {
                for (int i = 0; i < jVarA.b.f1431a; i++) {
                    if (jVarA.a(jVar, i)) {
                    }
                }
                if (hVar == this.A) {
                    z = false;
                }
                hVar = hVar.k;
            }
            hVar.m = jVarA;
            if (z) {
                h hVar2 = this.A;
                h hVar3 = this.B;
                boolean z2 = hVar2 != hVar3;
                for (h hVar4 = hVar3.k; hVar4 != null; hVar4 = hVar4.k) {
                    hVar4.a();
                }
                h hVar5 = this.B;
                hVar5.k = null;
                this.z = hVar5;
                this.A = hVar5;
                boolean[] zArr = new boolean[this.f1394a.length];
                long jA = hVar5.a(this.k.c, z2, zArr);
                if (jA != this.k.c) {
                    this.k.c = jA;
                    a(jA);
                }
                boolean[] zArr2 = new boolean[this.f1394a.length];
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    a[] aVarArr = this.f1394a;
                    if (i2 >= aVarArr.length) {
                        break;
                    }
                    a aVar = aVarArr[i2];
                    boolean z3 = aVar.c != 0;
                    zArr2[i2] = z3;
                    com.fyber.inneractive.sdk.player.exoplayer2.source.v vVar = this.B.c[i2];
                    if (vVar != null) {
                        i3++;
                    }
                    if (z3) {
                        if (vVar != aVar.d) {
                            if (aVar == this.m) {
                                if (vVar == null) {
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar6 = this.n;
                                    uVar.getClass();
                                    uVar.a(hVar6.b());
                                    uVar.d = hVar6.a();
                                }
                                this.n = null;
                                this.m = null;
                            }
                            a(aVar);
                            aVar.c();
                        } else if (zArr[i2]) {
                            long j = this.y;
                            aVar.g = false;
                            aVar.f = false;
                            aVar.a(false, j);
                        }
                    }
                    i2++;
                }
                this.h.obtainMessage(3, hVar.m).sendToTarget();
                a(zArr2, i3);
            } else {
                this.z = hVar;
                for (h hVar7 = hVar.k; hVar7 != null; hVar7 = hVar7.k) {
                    hVar7.a();
                }
                h hVar8 = this.z;
                hVar8.k = null;
                if (hVar8.i) {
                    long j2 = hVar8.g;
                    long jMax = Math.max(j2, Math.abs(this.y - (hVar8.e - j2)));
                    h hVar9 = this.z;
                    hVar9.a(jMax, false, new boolean[hVar9.n.length]);
                }
            }
            b();
            h();
            this.f.sendEmptyMessage(2);
            return;
        }
    }

    public final void g() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
        if (uVar.f1477a) {
            uVar.a(uVar.b());
            uVar.f1477a = false;
        }
        for (a aVar : this.p) {
            a(aVar);
        }
    }

    public final void h() {
        h hVar = this.B;
        if (hVar == null) {
            return;
        }
        long jG = hVar.f1390a.g();
        if (jG != C.TIME_UNSET) {
            a(jG);
        } else {
            a aVar = this.m;
            if (aVar == null || aVar.e()) {
                this.y = this.e.b();
            } else {
                long jB = this.n.b();
                this.y = jB;
                this.e.a(jB);
            }
            h hVar2 = this.B;
            jG = Math.abs(this.y - (hVar2.e - hVar2.g));
        }
        this.k.c = jG;
        this.v = SystemClock.elapsedRealtime() * 1000;
        long jC = this.p.length == 0 ? Long.MIN_VALUE : this.B.f1390a.c();
        i iVar = this.k;
        if (jC == Long.MIN_VALUE) {
            long j = this.C.a(this.B.f, this.j, false).d;
        }
        iVar.getClass();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    a((com.fyber.inneractive.sdk.player.exoplayer2.source.u) message.obj, message.arg1 != 0);
                    return true;
                case 1:
                    c(message.arg1 != 0);
                    return true;
                case 2:
                    a();
                    return true;
                case 3:
                    b((j) message.obj);
                    return true;
                case 4:
                    a((s) message.obj);
                    return true;
                case 5:
                    a(true);
                    this.d.a(true);
                    a(1);
                    return true;
                case 6:
                    e();
                    return true;
                case 7:
                    a((Pair) message.obj);
                    return true;
                case 8:
                    a((com.fyber.inneractive.sdk.player.exoplayer2.source.s) message.obj);
                    return true;
                case 9:
                    com.fyber.inneractive.sdk.player.exoplayer2.source.s sVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.s) message.obj;
                    h hVar = this.z;
                    if (hVar != null && hVar.f1390a == sVar) {
                        b();
                    }
                    return true;
                case 10:
                    f();
                    return true;
                case 11:
                    a((e[]) message.obj);
                    return true;
                default:
                    return false;
            }
        } catch (d e) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e);
            this.h.obtainMessage(8, e).sendToTarget();
            a(true);
            this.d.a(true);
            a(1);
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.h.obtainMessage(8, new d(e2)).sendToTarget();
            a(true);
            this.d.a(true);
            a(1);
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.h.obtainMessage(8, new d(e3)).sendToTarget();
            a(true);
            this.d.a(true);
            a(1);
            return true;
        }
    }

    public final void b(j jVar) {
        if (this.C == null) {
            this.w++;
            this.x = jVar;
            return;
        }
        Pair pairA = a(jVar);
        if (pairA == null) {
            i iVar = new i(0, 0L);
            this.k = iVar;
            this.h.obtainMessage(4, 1, 0, iVar).sendToTarget();
            this.k = new i(0, C.TIME_UNSET);
            a(4);
            a(false);
            return;
        }
        int i = jVar.c == C.TIME_UNSET ? 1 : 0;
        int iIntValue = ((Integer) pairA.first).intValue();
        long jLongValue = ((Long) pairA.second).longValue();
        try {
            i iVar2 = this.k;
            if (iIntValue == iVar2.f1391a && jLongValue / 1000 == iVar2.c / 1000) {
                return;
            }
            long jA = a(iIntValue, jLongValue);
            int i2 = i | (jLongValue == jA ? 0 : 1);
            i iVar3 = new i(iIntValue, jA);
            this.k = iVar3;
            this.h.obtainMessage(4, i2, 0, iVar3).sendToTarget();
        } finally {
            i iVar4 = new i(iIntValue, jLongValue);
            this.k = iVar4;
            this.h.obtainMessage(4, i, 0, iVar4).sendToTarget();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.t
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.x xVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.g gVar) {
        this.f.obtainMessage(7, Pair.create(xVar, gVar)).sendToTarget();
    }

    public final void a(int i) {
        if (this.u != i) {
            this.u = i;
            this.h.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.u uVar, boolean z) {
        this.h.sendEmptyMessage(0);
        a(true);
        this.d.a(false);
        if (z) {
            this.k = new i(0, C.TIME_UNSET);
        }
        this.o = uVar;
        uVar.a(this);
        a(2);
        this.f.sendEmptyMessage(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0181 A[LOOP:3: B:71:0x0181->B:75:0x0191, LOOP_START] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        /*
            Method dump skipped, instruction units count: 1132
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.l.a():void");
    }

    public final void c() {
        h hVar = this.z;
        if (hVar == null || hVar.i) {
            return;
        }
        h hVar2 = this.A;
        if (hVar2 == null || hVar2.k == hVar) {
            for (a aVar : this.p) {
                if (!aVar.f) {
                    return;
                }
            }
            this.z.f1390a.d();
        }
    }

    public final void b() {
        int i;
        h hVar = this.z;
        long jF = !hVar.i ? 0L : hVar.f1390a.f();
        if (jF == Long.MIN_VALUE) {
            b(false);
            return;
        }
        h hVar2 = this.z;
        long jAbs = Math.abs(this.y - (hVar2.e - hVar2.g));
        long j = jF - jAbs;
        c cVar = this.d;
        char c = j > cVar.c ? (char) 0 : j < cVar.b ? (char) 2 : (char) 1;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.l lVar = cVar.f1278a;
        synchronized (lVar) {
            i = lVar.c * 65536;
        }
        boolean z = c == 2 || (c == 1 && cVar.g && !(i >= cVar.f));
        cVar.g = z;
        b(z);
        if (z) {
            h hVar3 = this.z;
            hVar3.l = false;
            hVar3.f1390a.b(jAbs);
            return;
        }
        this.z.l = true;
    }

    public final void a(long j, long j2) {
        this.f.removeMessages(2);
        long jElapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (jElapsedRealtime <= 0) {
            this.f.sendEmptyMessage(2);
        } else {
            this.f.sendEmptyMessageDelayed(2, jElapsedRealtime);
        }
    }

    public final long a(int i, long j) throws d {
        h hVar;
        g();
        this.s = false;
        a(2);
        h hVar2 = this.B;
        if (hVar2 == null) {
            h hVar3 = this.z;
            if (hVar3 != null) {
                hVar3.a();
            }
            hVar = null;
        } else {
            hVar = null;
            while (hVar2 != null) {
                if (hVar2.f == i && hVar2.i) {
                    hVar = hVar2;
                } else {
                    hVar2.a();
                }
                hVar2 = hVar2.k;
            }
        }
        h hVar4 = this.B;
        if (hVar4 != hVar || hVar4 != this.A) {
            for (a aVar : this.p) {
                aVar.c();
            }
            this.p = new a[0];
            this.n = null;
            this.m = null;
            this.B = null;
        }
        if (hVar != null) {
            hVar.k = null;
            this.z = hVar;
            this.A = hVar;
            a(hVar);
            h hVar5 = this.B;
            if (hVar5.j) {
                j = hVar5.f1390a.a(j);
            }
            a(j);
            b();
        } else {
            this.z = null;
            this.A = null;
            this.B = null;
            a(j);
        }
        this.f.sendEmptyMessage(2);
        return j;
    }

    public final void a(long j) {
        h hVar = this.B;
        long j2 = hVar == null ? j + 60000000 : j + (hVar.e - hVar.g);
        this.y = j2;
        this.e.a(j2);
        for (a aVar : this.p) {
            long j3 = this.y;
            aVar.g = false;
            aVar.f = false;
            aVar.a(false, j3);
        }
    }

    public final void a(s sVar) {
        s sVarA;
        com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar = this.n;
        if (hVar != null) {
            sVarA = hVar.a(sVar);
        } else {
            sVarA = this.e.a(sVar);
        }
        this.l = sVarA;
        this.h.obtainMessage(7, sVarA).sendToTarget();
    }

    public final void a(boolean z) {
        this.f.removeMessages(2);
        this.s = false;
        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
        if (uVar.f1477a) {
            uVar.a(uVar.b());
            uVar.f1477a = false;
        }
        this.n = null;
        this.m = null;
        this.y = 60000000L;
        for (a aVar : this.p) {
            try {
                a(aVar);
                aVar.c();
            } catch (d | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.p = new a[0];
        h hVar = this.B;
        if (hVar == null) {
            hVar = this.z;
        }
        while (hVar != null) {
            hVar.a();
            hVar = hVar.k;
        }
        this.z = null;
        this.A = null;
        this.B = null;
        b(false);
        if (z) {
            com.fyber.inneractive.sdk.player.exoplayer2.source.u uVar2 = this.o;
            if (uVar2 != null) {
                uVar2.b();
                this.o = null;
            }
            this.C = null;
        }
    }

    public final void a(e[] eVarArr) {
        try {
            for (e eVar : eVarArr) {
                eVar.f1284a.a(eVar.b, eVar.c);
            }
            if (this.o != null) {
                this.f.sendEmptyMessage(2);
            }
            synchronized (this) {
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                notifyAll();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00cc  */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.fyber.inneractive.sdk.player.exoplayer2.x] */
    /* JADX WARN: Type inference failed for: r12v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.fyber.inneractive.sdk.player.exoplayer2.l] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.fyber.inneractive.sdk.player.exoplayer2.x] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.util.Pair r17) {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.l.a(android.util.Pair):void");
    }

    public final Pair a(j jVar) {
        x xVar = jVar.f1392a;
        if (xVar.c()) {
            xVar = this.C;
        }
        try {
            Pair pairA = a(xVar, jVar.b, jVar.c, 0L);
            x xVar2 = this.C;
            if (xVar2 == xVar) {
                return pairA;
            }
            int iA = xVar2.a(xVar.a(((Integer) pairA.first).intValue(), this.j, true).b);
            if (iA != -1) {
                return Pair.create(Integer.valueOf(iA), (Long) pairA.second);
            }
            int iIntValue = ((Integer) pairA.first).intValue();
            x xVar3 = this.C;
            int iA2 = -1;
            while (iA2 == -1 && iIntValue < xVar.a() - 1) {
                iIntValue++;
                iA2 = xVar3.a(xVar.a(iIntValue, this.j, true).b);
            }
            if (iA2 == -1) {
                return null;
            }
            int i = this.C.a(iA2, this.j, false).c;
            return a(this.C, 0, C.TIME_UNSET, 0L);
        } catch (IndexOutOfBoundsException unused) {
            throw new q();
        }
    }

    public final Pair a(x xVar, int i, long j, long j2) {
        int iB = xVar.b();
        if (i >= 0 && i < iB) {
            xVar.a(i, this.i, j2);
            if (j == C.TIME_UNSET) {
                j = this.i.e;
                if (j == C.TIME_UNSET) {
                    return null;
                }
            }
            w wVar = this.i;
            int i2 = wVar.c;
            long j3 = wVar.g + j;
            long j4 = xVar.a(i2, this.j, false).d;
            while (j4 != C.TIME_UNSET && j3 >= j4 && i2 < this.i.d) {
                j3 -= j4;
                i2++;
                j4 = xVar.a(i2, this.j, false).d;
            }
            return Pair.create(Integer.valueOf(i2), Long.valueOf(j3));
        }
        throw new IndexOutOfBoundsException();
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.s sVar) throws d {
        com.fyber.inneractive.sdk.player.exoplayer2.source.s sVar2;
        h hVar = this.z;
        if (hVar == null || (sVar2 = hVar.f1390a) != sVar) {
            return;
        }
        hVar.i = true;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVarA = hVar.p.a(hVar.o, sVar2.a());
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar = hVar.s;
        if (jVar != null) {
            for (int i = 0; i < jVarA.b.f1431a; i++) {
                if (!jVarA.a(jVar, i)) {
                    hVar.m = jVarA;
                    break;
                }
            }
        } else {
            hVar.m = jVarA;
            break;
        }
        hVar.g = hVar.a(hVar.g, false, new boolean[hVar.n.length]);
        if (this.B == null) {
            h hVar2 = this.z;
            this.A = hVar2;
            a(hVar2.g);
            a(this.A);
        }
        b();
    }

    public final void a(h hVar) throws d {
        if (this.B == hVar) {
            return;
        }
        boolean[] zArr = new boolean[this.f1394a.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            a[] aVarArr = this.f1394a;
            if (i < aVarArr.length) {
                a aVar = aVarArr[i];
                boolean z = aVar.c != 0;
                zArr[i] = z;
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = hVar.m.b.b[i];
                if (bVar != null) {
                    i2++;
                }
                if (z && (bVar == null || (aVar.g && aVar.d == this.B.c[i]))) {
                    if (aVar == this.m) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
                        com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar2 = this.n;
                        uVar.getClass();
                        uVar.a(hVar2.b());
                        uVar.d = hVar2.a();
                        this.n = null;
                        this.m = null;
                    }
                    a(aVar);
                    aVar.c();
                }
                i++;
            } else {
                this.B = hVar;
                this.h.obtainMessage(3, hVar.m).sendToTarget();
                a(zArr, i2);
                return;
            }
        }
    }

    public final void a(boolean[] zArr, int i) throws d {
        int i2;
        this.p = new a[i];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            a[] aVarArr = this.f1394a;
            if (i3 >= aVarArr.length) {
                return;
            }
            a aVar = aVarArr[i3];
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar = this.B.m;
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = jVar.b.b[i3];
            if (bVar != null) {
                int i5 = i4 + 1;
                this.p[i4] = aVar;
                if (aVar.c == 0) {
                    t tVar = jVar.d[i3];
                    boolean z = this.r && this.u == 3;
                    boolean z2 = !zArr[i3] && z;
                    int length = bVar.c.length;
                    o[] oVarArr = new o[length];
                    for (int i6 = 0; i6 < length; i6++) {
                        oVarArr[i6] = bVar.d[i6];
                    }
                    h hVar = this.B;
                    com.fyber.inneractive.sdk.player.exoplayer2.source.v vVar = hVar.c[i3];
                    long j = this.y;
                    i2 = i3;
                    long j2 = hVar.e - hVar.g;
                    if (aVar.c == 0) {
                        aVar.b = tVar;
                        aVar.c = 1;
                        aVar.h();
                        if (!aVar.g) {
                            aVar.d = vVar;
                            aVar.f = false;
                            aVar.e = j2;
                            aVar.a(oVarArr);
                            aVar.a(z2, j);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.h hVarD = aVar.d();
                            if (hVarD != null) {
                                if (this.n == null) {
                                    this.n = hVarD;
                                    this.m = aVar;
                                    ((MediaCodecAudioRenderer) hVarD).Q.a(this.l);
                                } else {
                                    throw new d(new IllegalStateException("Multiple renderer media clocks enabled."));
                                }
                            }
                            if (z) {
                                if (aVar.c == 1) {
                                    aVar.c = 2;
                                    aVar.i();
                                } else {
                                    throw new IllegalStateException();
                                }
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    i2 = i3;
                }
                i4 = i5;
            } else {
                i2 = i3;
            }
            i3 = i2 + 1;
        }
    }
}
