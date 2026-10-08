package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.EOFException;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i, com.fyber.inneractive.sdk.player.exoplayer2.extractor.q {
    public static final int p = z.a("qt  ");
    public int e;
    public int f;
    public long g;
    public int h;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.n i;
    public int j;
    public int k;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.j l;
    public o[] m;
    public long n;
    public boolean o;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(16);
    public final Stack d = new Stack();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n f1335a = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(com.fyber.inneractive.sdk.player.exoplayer2.util.l.f1470a);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(4);

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final boolean a() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long c() {
        return this.n;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        return r.a(bVar, false);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x07cf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(long r72) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        /*
            Method dump skipped, instruction units count: 2531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.p.c(long):void");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        this.l = jVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        int i;
        this.d.clear();
        this.h = 0;
        this.j = 0;
        this.k = 0;
        if (j == 0) {
            this.e = 0;
            this.h = 0;
            return;
        }
        o[] oVarArr = this.m;
        if (oVarArr != null) {
            for (o oVar : oVarArr) {
                v vVar = oVar.b;
                int iA = z.a(vVar.e, j2, false);
                while (true) {
                    i = -1;
                    if (iA < 0) {
                        iA = -1;
                        break;
                    } else if ((vVar.f[iA] & 1) != 0) {
                        break;
                    } else {
                        iA--;
                    }
                }
                if (iA != -1) {
                    i = iA;
                    break;
                    break;
                }
                iA = z.a(vVar.e, j2, true, false);
                while (iA < vVar.e.length) {
                    if ((vVar.f[iA] & 1) != 0) {
                        i = iA;
                        break;
                    }
                    iA++;
                }
                oVar.d = i;
            }
        }
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
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) throws InterruptedException, com.fyber.inneractive.sdk.player.exoplayer2.r, EOFException {
        o[] oVarArr;
        int i;
        boolean z;
        boolean z2;
        while (true) {
            int i2 = this.e;
            if (i2 == 0) {
                if (this.h == 0) {
                    if (!bVar.b(this.c.f1472a, 0, 8, true)) {
                        return -1;
                    }
                    this.h = 8;
                    this.c.e(0);
                    this.g = this.c.k();
                    this.f = this.c.b();
                }
                if (this.g == 1) {
                    bVar.b(this.c.f1472a, 8, 8, false);
                    this.h += 8;
                    this.g = this.c.n();
                }
                int i3 = this.f;
                if (i3 != c.C && i3 != c.E && i3 != c.F && i3 != c.G && i3 != c.H && i3 != c.Q) {
                    if (i3 != c.S && i3 != c.D && i3 != c.T && i3 != c.U && i3 != c.m0 && i3 != c.n0 && i3 != c.o0 && i3 != c.R && i3 != c.p0 && i3 != c.q0 && i3 != c.r0 && i3 != c.s0 && i3 != c.t0 && i3 != c.P && i3 != c.b && i3 != c.A0) {
                        this.i = null;
                        this.e = 1;
                    } else if (this.h == 8) {
                        long j = this.g;
                        if (j <= 2147483647L) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n((int) j);
                            this.i = nVar;
                            System.arraycopy(this.c.f1472a, 0, nVar.f1472a, 0, 8);
                            this.e = 1;
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    long j2 = (bVar.c + this.g) - ((long) this.h);
                    this.d.add(new a(this.f, j2));
                    if (this.g == this.h) {
                        c(j2);
                    } else {
                        this.e = 0;
                        this.h = 0;
                    }
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException();
                    }
                    long j3 = Long.MAX_VALUE;
                    int i4 = -1;
                    int i5 = 0;
                    while (true) {
                        oVarArr = this.m;
                        if (i5 >= oVarArr.length) {
                            break;
                        }
                        o oVar2 = oVarArr[i5];
                        int i6 = oVar2.d;
                        v vVar = oVar2.b;
                        if (i6 != vVar.f1340a) {
                            long j4 = vVar.b[i6];
                            if (j4 < j3) {
                                i4 = i5;
                                j3 = j4;
                            }
                        }
                        i5++;
                    }
                    if (i4 == -1) {
                        return -1;
                    }
                    o oVar3 = oVarArr[i4];
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = oVar3.c;
                    int i7 = oVar3.d;
                    v vVar2 = oVar3.b;
                    long j5 = vVar2.b[i7];
                    int i8 = vVar2.c[i7];
                    if (oVar3.f1334a.g == 1) {
                        j5 += 8;
                        i8 -= 8;
                    }
                    int i9 = i8;
                    long j6 = (j5 - bVar.c) + ((long) this.j);
                    if (j6 >= 0 && j6 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        bVar.a((int) j6);
                        int i10 = oVar3.f1334a.k;
                        if (i10 == 0) {
                            while (true) {
                                int i11 = this.j;
                                i = i9;
                                if (i11 >= i) {
                                    break;
                                }
                                int iA = rVar.a(bVar, i - i11, false);
                                this.j += iA;
                                this.k -= iA;
                                i9 = i;
                            }
                        } else {
                            byte[] bArr = this.b.f1472a;
                            boolean z3 = false;
                            bArr[0] = 0;
                            bArr[1] = 0;
                            bArr[2] = 0;
                            int i12 = 4 - i10;
                            i = i9;
                            while (this.j < i) {
                                int i13 = this.k;
                                if (i13 == 0) {
                                    bVar.b(this.b.f1472a, i12, i10, z3);
                                    this.b.e(z3 ? 1 : 0);
                                    this.k = this.b.m();
                                    this.f1335a.e(z3 ? 1 : 0);
                                    rVar.a(4, this.f1335a);
                                    this.j += 4;
                                    i += i12;
                                } else {
                                    int iA2 = rVar.a(bVar, i13, z3);
                                    this.j += iA2;
                                    this.k -= iA2;
                                    z3 = false;
                                }
                            }
                        }
                        v vVar3 = oVar3.b;
                        rVar.a(vVar3.e[i7], vVar3.f[i7], i, 0, null);
                        oVar3.d++;
                        this.j = 0;
                        this.k = 0;
                        return 0;
                    }
                    oVar.f1342a = j5;
                    return 1;
                }
                long j7 = this.g;
                int i14 = this.h;
                long j8 = j7 - ((long) i14);
                long j9 = bVar.c + j8;
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.i;
                if (nVar2 != null) {
                    bVar.b(nVar2.f1472a, i14, (int) j8, false);
                    if (this.f == c.b) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = this.i;
                        nVar3.e(8);
                        if (nVar3.b() != p) {
                            nVar3.e(nVar3.b + 4);
                            while (nVar3.c - nVar3.b > 0) {
                                if (nVar3.b() == p) {
                                    z2 = true;
                                    break;
                                }
                            }
                            z2 = false;
                            this.o = z2;
                        } else {
                            z2 = true;
                            this.o = z2;
                        }
                    } else if (!this.d.isEmpty()) {
                        ((a) this.d.peek()).Q0.add(new b(this.f, this.i));
                    }
                } else if (j8 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    bVar.a((int) j8);
                } else {
                    oVar.f1342a = j9;
                    z = true;
                    c(j9);
                    if (z && this.e != 2) {
                        return 1;
                    }
                }
                z = false;
                c(j9);
                if (z) {
                    continue;
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long a(long j) {
        int i;
        long j2 = Long.MAX_VALUE;
        for (o oVar : this.m) {
            v vVar = oVar.b;
            int iA = z.a(vVar.e, j, false);
            while (true) {
                i = -1;
                if (iA < 0) {
                    iA = -1;
                    break;
                }
                if ((vVar.f[iA] & 1) != 0) {
                    break;
                }
                iA--;
            }
            if (iA != -1) {
                i = iA;
                break;
            }
            iA = z.a(vVar.e, j, true, false);
            while (iA < vVar.e.length) {
                if ((vVar.f[iA] & 1) != 0) {
                    i = iA;
                    break;
                }
                iA++;
            }
            long j3 = vVar.b[i];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }
}
