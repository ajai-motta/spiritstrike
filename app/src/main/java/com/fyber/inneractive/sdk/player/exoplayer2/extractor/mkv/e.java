package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv;

import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.i;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements i {
    public static final byte[] Z = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] a0 = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    public static final UUID b0 = new UUID(72057594037932032L, -9223371306706625679L);
    public long A;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.g B;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.g C;
    public boolean D;
    public int E;
    public long F;
    public long G;
    public int H;
    public int I;
    public int[] J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public byte S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public j Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1316a;
    public final g b;
    public final SparseArray c;
    public final boolean d;
    public final n e;
    public final n f;
    public final n g;
    public final n h;
    public final n i;
    public final n j;
    public final n k;
    public final n l;
    public final n m;
    public ByteBuffer n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public d t;
    public boolean u;
    public int v;
    public long w;
    public boolean x;
    public long y;
    public long z;

    public e() {
        b bVar = new b();
        this.p = -1L;
        this.q = C.TIME_UNSET;
        this.r = C.TIME_UNSET;
        this.s = C.TIME_UNSET;
        this.y = -1L;
        this.z = -1L;
        this.A = C.TIME_UNSET;
        this.f1316a = bVar;
        bVar.d = new c(this);
        this.d = true;
        this.b = new g();
        this.c = new SparseArray();
        this.g = new n(4);
        this.h = new n(ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new n(4);
        this.e = new n(l.f1470a);
        this.f = new n(4);
        this.j = new n();
        this.k = new n();
        this.l = new n(8);
        this.m = new n();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) throws InterruptedException, EOFException {
        f fVar = new f();
        long j = bVar.b;
        long j2 = 1024;
        if (j != -1 && j <= 1024) {
            j2 = j;
        }
        int i = (int) j2;
        bVar.a(fVar.f1317a.f1472a, 0, 4, false);
        fVar.b = 4;
        for (long jK = fVar.f1317a.k(); jK != 440786851; jK = ((jK << 8) & (-256)) | ((long) (fVar.f1317a.f1472a[0] & 255))) {
            int i2 = fVar.b + 1;
            fVar.b = i2;
            if (i2 == i) {
                return false;
            }
            bVar.a(fVar.f1317a.f1472a, 0, 1, false);
        }
        long jA = fVar.a(bVar);
        long j3 = fVar.b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (j != -1 && j3 + jA >= j) {
            return false;
        }
        while (true) {
            long j4 = fVar.b;
            long j5 = j3 + jA;
            if (j4 >= j5) {
                return j4 == j5;
            }
            if (fVar.a(bVar) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = fVar.a(bVar);
            if (jA2 < 0 || jA2 > 2147483647L) {
                return false;
            }
            if (jA2 != 0) {
                bVar.a((int) jA2, false);
                fVar.b = (int) (((long) fVar.b) + jA2);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(j jVar) {
        this.Y = jVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.A = C.TIME_UNSET;
        this.E = 0;
        b bVar = this.f1316a;
        bVar.e = 0;
        bVar.b.clear();
        g gVar = bVar.c;
        gVar.b = 0;
        gVar.c = 0;
        g gVar2 = this.b;
        gVar2.b = 0;
        gVar2.c = 0;
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = (byte) 0;
        this.Q = false;
        n nVar = this.j;
        nVar.b = 0;
        nVar.c = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:343:0x0662, code lost:
    
        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("EBML lacing sample size out of range.");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x0817  */
    /* JADX WARN: Type inference failed for: r4v132 */
    /* JADX WARN: Type inference failed for: r4v89, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v93 */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r27, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o r28) throws java.lang.InterruptedException, com.fyber.inneractive.sdk.player.exoplayer2.r, java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 3258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.e.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o):int");
    }

    public final void a(d dVar, long j) {
        byte[] bArrB;
        if ("S_TEXT/UTF8".equals(dVar.f1315a)) {
            byte[] bArr = this.k.f1472a;
            long j2 = this.G;
            if (j2 == C.TIME_UNSET) {
                bArrB = a0;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                bArrB = z.b(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (1000000 * i3))) / 1000))));
            }
            System.arraycopy(bArrB, 0, bArr, 19, 12);
            r rVar = dVar.O;
            n nVar = this.k;
            rVar.a(nVar.c, nVar);
            this.V += this.k.c;
        }
        dVar.O.a(j, this.M, this.V, 0, dVar.g);
        this.W = true;
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = (byte) 0;
        this.Q = false;
        n nVar2 = this.j;
        nVar2.b = 0;
        nVar2.c = 0;
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, int i) throws InterruptedException, EOFException {
        n nVar = this.g;
        if (nVar.c >= i) {
            return;
        }
        if (nVar.a() < i) {
            n nVar2 = this.g;
            byte[] bArr = nVar2.f1472a;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, Math.max(bArr.length * 2, i));
            int i2 = this.g.c;
            nVar2.f1472a = bArrCopyOf;
            nVar2.c = i2;
            nVar2.b = 0;
        }
        n nVar3 = this.g;
        byte[] bArr2 = nVar3.f1472a;
        int i3 = nVar3.c;
        bVar.b(bArr2, i3, i - i3, false);
        this.g.d(i);
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, d dVar, int i) throws InterruptedException, com.fyber.inneractive.sdk.player.exoplayer2.r, EOFException {
        int iA;
        int iA2;
        int i2;
        if ("S_TEXT/UTF8".equals(dVar.f1315a)) {
            byte[] bArr = Z;
            int i3 = i + 32;
            if (this.k.a() < i3) {
                this.k.f1472a = Arrays.copyOf(bArr, i3 + i);
            }
            bVar.b(this.k.f1472a, 32, i, false);
            this.k.e(0);
            this.k.d(i3);
            return;
        }
        r rVar = dVar.O;
        if (!this.O) {
            if (dVar.e) {
                this.M &= -1073741825;
                if (!this.P) {
                    bVar.b(this.g.f1472a, 0, 1, false);
                    this.N++;
                    byte b = this.g.f1472a[0];
                    if ((b & 128) != 128) {
                        this.S = b;
                        this.P = true;
                    } else {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Extension bit is set in signal byte");
                    }
                }
                byte b2 = this.S;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.M |= 1073741824;
                    if (!this.Q) {
                        bVar.b(this.l.f1472a, 0, 8, false);
                        this.N += 8;
                        this.Q = true;
                        n nVar = this.g;
                        nVar.f1472a[0] = (byte) ((z ? 128 : 0) | 8);
                        nVar.e(0);
                        rVar.a(1, this.g);
                        this.V++;
                        this.l.e(0);
                        rVar.a(8, this.l);
                        this.V += 8;
                    }
                    if (z) {
                        if (!this.R) {
                            bVar.b(this.g.f1472a, 0, 1, false);
                            this.N++;
                            this.g.e(0);
                            this.T = this.g.j();
                            this.R = true;
                        }
                        int i4 = this.T * 4;
                        this.g.c(i4);
                        bVar.b(this.g.f1472a, 0, i4, false);
                        this.N += i4;
                        short s = (short) ((this.T / 2) + 1);
                        int i5 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.n;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.n = ByteBuffer.allocate(i5);
                        }
                        this.n.position(0);
                        this.n.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i2 = this.T;
                            if (i6 >= i2) {
                                break;
                            }
                            int iM = this.g.m();
                            if (i6 % 2 == 0) {
                                this.n.putShort((short) (iM - i7));
                            } else {
                                this.n.putInt(iM - i7);
                            }
                            i6++;
                            i7 = iM;
                        }
                        int i8 = (i - this.N) - i7;
                        if (i2 % 2 == 1) {
                            this.n.putInt(i8);
                        } else {
                            this.n.putShort((short) i8);
                            this.n.putInt(0);
                        }
                        n nVar2 = this.m;
                        nVar2.f1472a = this.n.array();
                        nVar2.c = i5;
                        nVar2.b = 0;
                        rVar.a(i5, this.m);
                        this.V += i5;
                    }
                }
            } else {
                byte[] bArr2 = dVar.f;
                if (bArr2 != null) {
                    n nVar3 = this.j;
                    int length = bArr2.length;
                    nVar3.f1472a = bArr2;
                    nVar3.c = length;
                    nVar3.b = 0;
                }
            }
            this.O = true;
        }
        int i9 = i + this.j.c;
        if (!"V_MPEG4/ISO/AVC".equals(dVar.f1315a) && !"V_MPEGH/ISO/HEVC".equals(dVar.f1315a)) {
            while (true) {
                int i10 = this.N;
                if (i10 >= i9) {
                    break;
                }
                int i11 = i9 - i10;
                n nVar4 = this.j;
                int i12 = nVar4.c - nVar4.b;
                if (i12 > 0) {
                    iA2 = Math.min(i11, i12);
                    rVar.a(iA2, this.j);
                } else {
                    iA2 = rVar.a(bVar, i11, false);
                }
                this.N += iA2;
                this.V += iA2;
            }
        } else {
            byte[] bArr3 = this.f.f1472a;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i13 = dVar.P;
            int i14 = 4 - i13;
            while (this.N < i9) {
                int i15 = this.U;
                if (i15 == 0) {
                    n nVar5 = this.j;
                    int iMin = Math.min(i13, nVar5.c - nVar5.b);
                    bVar.b(bArr3, i14 + iMin, i13 - iMin, false);
                    if (iMin > 0) {
                        this.j.a(bArr3, i14, iMin);
                    }
                    this.N += i13;
                    this.f.e(0);
                    this.U = this.f.m();
                    this.e.e(0);
                    rVar.a(4, this.e);
                    this.V += 4;
                } else {
                    n nVar6 = this.j;
                    int i16 = nVar6.c - nVar6.b;
                    if (i16 > 0) {
                        iA = Math.min(i15, i16);
                        rVar.a(iA, this.j);
                    } else {
                        iA = rVar.a(bVar, i15, false);
                    }
                    this.N += iA;
                    this.V += iA;
                    this.U = i15 - iA;
                }
            }
        }
        if ("A_VORBIS".equals(dVar.f1315a)) {
            this.h.e(0);
            rVar.a(4, this.h);
            this.V += 4;
        }
    }

    public final long a(long j) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        long j2 = this.q;
        if (j2 != C.TIME_UNSET) {
            return z.a(j, j2, 1000L);
        }
        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Can't scale timecode prior to timecodeScale being set.");
    }
}
