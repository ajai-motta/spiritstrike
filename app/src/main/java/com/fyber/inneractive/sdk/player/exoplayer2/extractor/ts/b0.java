package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i {
    public static final long l = com.fyber.inneractive.sdk.player.exoplayer2.util.z.a("AC-3");
    public static final long m = com.fyber.inneractive.sdk.player.exoplayer2.util.z.a("EAC3");
    public static final long n = com.fyber.inneractive.sdk.player.exoplayer2.util.z.a("HEVC");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1359a;
    public final List b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c;
    public final SparseIntArray d;
    public final e e;
    public final SparseArray f;
    public final SparseBooleanArray g;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.j h;
    public int i;
    public boolean j;
    public f0 k;

    public b0(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar, e eVar) {
        this.e = eVar;
        this.f1359a = i;
        if (i == 1 || i == 2) {
            this.b = Collections.singletonList(vVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(vVar);
        }
        this.c = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(940);
        this.g = new SparseBooleanArray();
        this.f = new SparseArray();
        this.d = new SparseIntArray();
        a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        r1 = r1 + 1;
     */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r7) throws java.lang.InterruptedException, java.io.EOFException {
        /*
            r6 = this;
            com.fyber.inneractive.sdk.player.exoplayer2.util.n r0 = r6.c
            byte[] r0 = r0.f1472a
            r1 = 940(0x3ac, float:1.317E-42)
            r2 = 0
            r7.a(r0, r2, r1, r2)
            r1 = r2
        Lb:
            r3 = 188(0xbc, float:2.63E-43)
            if (r1 >= r3) goto L27
            r3 = r2
        L10:
            r4 = 5
            if (r3 != r4) goto L18
            r7.a(r1)
            r7 = 1
            return r7
        L18:
            int r4 = r3 * 188
            int r4 = r4 + r1
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L24
            int r1 = r1 + 1
            goto Lb
        L24:
            int r3 = r3 + 1
            goto L10
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.b0.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b):boolean");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        this.h = jVar;
        jVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.p(C.TIME_UNSET));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.util.v) this.b.get(i)).c = C.TIME_UNSET;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.c;
        nVar.b = 0;
        nVar.c = 0;
        this.d.clear();
        a();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) throws InterruptedException, EOFException {
        f0 f0Var;
        int iMin;
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.c;
        byte[] bArr = nVar.f1472a;
        int i = nVar.b;
        if (940 - i < 188) {
            int i2 = nVar.c - i;
            if (i2 > 0) {
                System.arraycopy(bArr, i, bArr, 0, i2);
            }
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.c;
            nVar2.f1472a = bArr;
            nVar2.c = i2;
            nVar2.b = 0;
        }
        while (true) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = this.c;
            int i3 = nVar3.c;
            int i4 = nVar3.b;
            if (i3 - i4 < 188) {
                int i5 = 940 - i3;
                int i6 = bVar.f;
                if (i6 == 0) {
                    iMin = 0;
                } else {
                    iMin = Math.min(i6, i5);
                    System.arraycopy(bVar.d, 0, bArr, i3, iMin);
                    bVar.b(iMin);
                }
                if (iMin == 0) {
                    iMin = bVar.a(bArr, i3, i5, 0, true);
                }
                if (iMin != -1) {
                    bVar.c += (long) iMin;
                }
                if (iMin == -1) {
                    return -1;
                }
                this.c.d(i3 + iMin);
            } else {
                while (i4 < i3 && bArr[i4] != 71) {
                    i4++;
                }
                this.c.e(i4);
                int i7 = i4 + TsExtractor.TS_PACKET_SIZE;
                if (i7 > i3) {
                    return 0;
                }
                int iB = this.c.b();
                if ((8388608 & iB) != 0) {
                    this.c.e(i7);
                    return 0;
                }
                boolean z = true;
                boolean z2 = (4194304 & iB) != 0;
                int i8 = (2096896 & iB) >> 8;
                boolean z3 = (iB & 32) != 0;
                boolean z4 = (iB & 16) != 0;
                if (this.f1359a != 2) {
                    int i9 = iB & 15;
                    int i10 = this.d.get(i8, i9 - 1);
                    this.d.put(i8, i9);
                    if (i10 == i9) {
                        if (z4) {
                            this.c.e(i7);
                            return 0;
                        }
                    } else if (i9 == ((i10 + 1) & 15)) {
                    }
                    z = false;
                } else {
                    z = false;
                }
                if (z3) {
                    int iJ = this.c.j();
                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar4 = this.c;
                    nVar4.e(nVar4.b + iJ);
                }
                if (z4 && (f0Var = (f0) this.f.get(i8)) != null) {
                    if (z) {
                        f0Var.a();
                    }
                    this.c.d(i7);
                    f0Var.a(this.c, z2);
                    this.c.d(i3);
                }
                this.c.e(i7);
                return 0;
            }
        }
    }

    public final void a() {
        this.g.clear();
        this.f.clear();
        this.e.getClass();
        SparseArray sparseArray = new SparseArray();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            this.f.put(sparseArray.keyAt(i), (f0) sparseArray.valueAt(i));
        }
        this.f.put(0, new w(new z(this)));
        this.k = null;
    }
}
