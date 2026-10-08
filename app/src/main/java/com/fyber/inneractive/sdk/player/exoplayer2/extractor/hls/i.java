package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.os.Handler;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.source.r;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.source.v;
import com.fyber.inneractive.sdk.player.exoplayer2.source.y;
import com.fyber.inneractive.sdk.player.exoplayer2.source.z;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k f1297a;
    public final b b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.f d;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.b e;
    public final long i;
    public r j;
    public int k;
    public boolean l;
    public z m;
    public n[] n;
    public n[] o;
    public com.fyber.inneractive.sdk.player.exoplayer2.source.h p;
    public final int c = 3;
    public final IdentityHashMap f = new IdentityHashMap();
    public final o g = new o();
    public final Handler h = new Handler();

    public i(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k kVar, b bVar, com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar2, long j) {
        this.f1297a = kVar;
        this.b = bVar;
        this.d = fVar;
        this.e = bVar2;
        this.i = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final void a(r rVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar;
        this.f1297a.g.add(this);
        this.j = rVar;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar = this.f1297a.j;
        ArrayList arrayList = new ArrayList(bVar.b);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        char c = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a) arrayList.get(i);
            com.fyber.inneractive.sdk.player.exoplayer2.o oVar = aVar.b;
            if (oVar.k > 0) {
                arrayList2.add(aVar);
                break;
                break;
            }
            String str = oVar.c;
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split("(\\s*,\\s*)|(\\s*$)")) {
                    if (str2.startsWith("avc")) {
                        arrayList2.add(aVar);
                        break;
                    }
                }
            }
            String str3 = aVar.b.c;
            if (!TextUtils.isEmpty(str3)) {
                String[] strArrSplit = str3.split("(\\s*,\\s*)|(\\s*$)");
                int length = strArrSplit.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (strArrSplit[i2].startsWith("mp4a")) {
                        arrayList3.add(aVar);
                        break;
                    }
                    i2++;
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        } else if (arrayList3.size() < arrayList.size()) {
            arrayList.removeAll(arrayList3);
        }
        List list = bVar.c;
        List list2 = bVar.d;
        int size = list2.size() + list.size() + 1;
        this.n = new n[size];
        this.k = size;
        if (!(!arrayList.isEmpty())) {
            throw new IllegalArgumentException();
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a[] aVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 = bVar.e;
        f fVar = new f(this.f1297a, aVarArr, this.b, this.g, bVar.f);
        n nVar = new n(0, this, fVar, this.e, this.i, oVar2, this.c, this.d);
        this.n[0] = nVar;
        fVar.h = true;
        if (!nVar.o) {
            nVar.b(nVar.w);
        }
        int i3 = 0;
        int i4 = 1;
        while (i3 < list.size()) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a[] aVarArr2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a[1];
            aVarArr2[c] = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a) list.get(i3);
            n nVar2 = new n(1, this, new f(this.f1297a, aVarArr2, this.b, this.g, Collections.emptyList()), this.e, this.i, null, this.c, this.d);
            int i5 = i4 + 1;
            this.n[i4] = nVar2;
            if (!nVar2.o) {
                nVar2.b(nVar2.w);
            }
            i3++;
            i4 = i5;
            c = 0;
        }
        int i6 = 0;
        while (i6 < list2.size()) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a) list2.get(i6);
            f fVar2 = new f(this.f1297a, new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a[]{aVar2}, this.b, this.g, Collections.emptyList());
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar2 = this.e;
            List list3 = list2;
            n nVar3 = new n(3, this, fVar2, bVar2, this.i, null, this.c, this.d);
            com.fyber.inneractive.sdk.player.exoplayer2.o oVar3 = aVar2.b;
            if (nVar3.j.indexOfKey(0) >= 0) {
                gVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) nVar3.j.get(0);
            } else {
                gVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.g(bVar2);
                gVar.n = nVar3;
                gVar.c.r = nVar3.r;
                nVar3.j.put(0, gVar);
            }
            gVar.a(oVar3);
            nVar3.n = true;
            nVar3.h();
            this.n[i4] = nVar3;
            i6++;
            i4++;
            list2 = list3;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    public final boolean b(long j) {
        return this.p.b(j);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:506)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:509)
        */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final long c() {
        /*
            r16 = this;
            r0 = r16
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.n[] r1 = r0.o
            int r2 = r1.length
            r6 = 0
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        Lb:
            r9 = -9223372036854775808
            if (r6 >= r2) goto L7a
            r11 = r1[r6]
            boolean r12 = r11.y
            if (r12 == 0) goto L17
            r12 = r9
            goto L6f
        L17:
            long r12 = r11.x
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 == 0) goto L23
            goto L6f
        L23:
            long r12 = r11.w
            java.util.LinkedList r14 = r11.k
            java.lang.Object r14 = r14.getLast()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.h r14 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.h) r14
            boolean r15 = r14.F
            if (r15 == 0) goto L32
            goto L4b
        L32:
            java.util.LinkedList r14 = r11.k
            int r14 = r14.size()
            r15 = 1
            if (r14 <= r15) goto L4a
            java.util.LinkedList r14 = r11.k
            int r15 = r14.size()
            int r15 = r15 + (-2)
            java.lang.Object r14 = r14.get(r15)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.h r14 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.h) r14
            goto L4b
        L4a:
            r14 = 0
        L4b:
            if (r14 == 0) goto L53
            long r14 = r14.g
            long r12 = java.lang.Math.max(r12, r14)
        L53:
            android.util.SparseArray r14 = r11.j
            int r14 = r14.size()
            r15 = 0
        L5a:
            if (r15 >= r14) goto L6f
            android.util.SparseArray r5 = r11.j
            java.lang.Object r5 = r5.valueAt(r15)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.g r5 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r5
            long r3 = r5.d()
            long r12 = java.lang.Math.max(r12, r3)
            int r15 = r15 + 1
            goto L5a
        L6f:
            int r3 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r3 == 0) goto L77
            long r7 = java.lang.Math.min(r7, r12)
        L77:
            int r6 = r6 + 1
            goto Lb
        L7a:
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 != 0) goto L84
            r7 = r9
        L84:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.i.c():long");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final void d() throws IOException {
        n[] nVarArr = this.n;
        if (nVarArr != null) {
            for (n nVar : nVarArr) {
                nVar.g.b();
                f fVar = nVar.c;
                com.fyber.inneractive.sdk.player.exoplayer2.source.g gVar = fVar.j;
                if (gVar != null) {
                    throw gVar;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar = fVar.k;
                if (aVar != null) {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h hVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h) fVar.e.d.get(aVar);
                    hVar.b.b();
                    IOException iOException = hVar.j;
                    if (iOException != null) {
                        throw iOException;
                    }
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    public final long f() {
        return this.p.f();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final long g() {
        return C.TIME_UNSET;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final z a() {
        return this.m;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, v[] vVarArr, boolean[] zArr2, long j) {
        long j2;
        ArrayList arrayList;
        int i;
        int i2;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b[] bVarArr2;
        ArrayList arrayList2;
        v[] vVarArr2 = vVarArr;
        int[] iArr = new int[bVarArr.length];
        int[] iArr2 = new int[bVarArr.length];
        for (int i3 = 0; i3 < bVarArr.length; i3++) {
            v vVar = vVarArr2[i3];
            iArr[i3] = vVar == null ? -1 : ((Integer) this.f.get(vVar)).intValue();
            iArr2[i3] = -1;
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = bVarArr[i3];
            if (bVar != null) {
                y yVar = bVar.f1429a;
                int i4 = 0;
                while (true) {
                    n[] nVarArr = this.n;
                    if (i4 < nVarArr.length) {
                        z zVar = nVarArr[i4].t;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= zVar.f1425a) {
                                break;
                            }
                            if (zVar.b[i5] == yVar) {
                                if (i5 != -1) {
                                    iArr2[i3] = i4;
                                    break;
                                }
                            } else {
                                i5++;
                            }
                        }
                        i4++;
                    }
                }
            }
        }
        this.f.clear();
        int length = bVarArr.length;
        v[] vVarArr3 = new v[length];
        v[] vVarArr4 = new v[bVarArr.length];
        int length2 = bVarArr.length;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b[] bVarArr3 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b[length2];
        ArrayList arrayList3 = new ArrayList(this.n.length);
        int i6 = 0;
        boolean z = false;
        while (i6 < this.n.length) {
            for (int i7 = 0; i7 < bVarArr.length; i7++) {
                vVarArr4[i7] = iArr[i7] == i6 ? vVarArr2[i7] : null;
                bVarArr3[i7] = iArr2[i7] == i6 ? bVarArr[i7] : null;
            }
            n nVar = this.n[i6];
            boolean z2 = !this.l;
            if (nVar.o) {
                for (int i8 = 0; i8 < length2; i8++) {
                    v vVar2 = vVarArr4[i8];
                    if (vVar2 != null && (bVarArr3[i8] == null || !zArr[i8])) {
                        int i9 = ((k) vVar2).f1299a;
                        boolean[] zArr3 = nVar.v;
                        if (zArr3[i9]) {
                            zArr3[i9] = false;
                            nVar.p--;
                            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) nVar.j.valueAt(i9)).b();
                            vVarArr4[i8] = null;
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                }
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar2 = null;
                int i10 = 0;
                boolean z3 = false;
                while (i10 < length2) {
                    if (vVarArr4[i10] == null) {
                        i2 = length2;
                        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar3 = bVarArr3[i10];
                        if (bVar3 != null) {
                            z zVar2 = nVar.t;
                            bVarArr2 = bVarArr3;
                            y yVar2 = bVar3.f1429a;
                            i = length;
                            arrayList2 = arrayList3;
                            int i11 = 0;
                            while (true) {
                                if (i11 >= zVar2.f1425a) {
                                    i11 = -1;
                                    break;
                                }
                                if (zVar2.b[i11] == yVar2) {
                                    break;
                                }
                                i11++;
                            }
                            boolean[] zArr4 = nVar.v;
                            if (!zArr4[i11]) {
                                zArr4[i11] = true;
                                nVar.p++;
                                if (i11 == nVar.u) {
                                    nVar.c.p = bVar3;
                                    bVar2 = bVar3;
                                }
                                vVarArr4[i10] = new k(nVar, i11);
                                zArr2[i10] = true;
                                z3 = true;
                                i10++;
                                length2 = i2;
                                bVarArr3 = bVarArr2;
                                length = i;
                                arrayList3 = arrayList2;
                            } else {
                                throw new IllegalStateException();
                            }
                        } else {
                            i = length;
                        }
                    } else {
                        i = length;
                        i2 = length2;
                    }
                    bVarArr2 = bVarArr3;
                    arrayList2 = arrayList3;
                    i10++;
                    length2 = i2;
                    bVarArr3 = bVarArr2;
                    length = i;
                    arrayList3 = arrayList2;
                }
                int i12 = length;
                int i13 = length2;
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b[] bVarArr4 = bVarArr3;
                ArrayList arrayList4 = arrayList3;
                if (z2) {
                    int size = nVar.j.size();
                    for (int i14 = 0; i14 < size; i14++) {
                        if (!nVar.v[i14]) {
                            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) nVar.j.valueAt(i14)).b();
                        }
                    }
                    if (bVar2 != null && !nVar.k.isEmpty()) {
                        bVar2.d();
                        if (bVar2.c[bVar2.a()] != nVar.c.f.a(((h) nVar.k.getLast()).c)) {
                            nVar.c(nVar.w);
                        }
                    }
                }
                if (nVar.p == 0) {
                    nVar.c.j = null;
                    nVar.q = null;
                    nVar.k.clear();
                    if (nVar.g.a()) {
                        nVar.g.b.a(false);
                    }
                }
                z |= z3;
                boolean z4 = false;
                for (int i15 = 0; i15 < bVarArr.length; i15++) {
                    if (iArr2[i15] == i6) {
                        v vVar3 = vVarArr4[i15];
                        if (vVar3 != null) {
                            vVarArr3[i15] = vVar3;
                            this.f.put(vVarArr4[i15], Integer.valueOf(i6));
                            z4 = true;
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (iArr[i15] == i6 && vVarArr4[i15] != null) {
                        throw new IllegalStateException();
                    }
                }
                if (z4) {
                    arrayList = arrayList4;
                    arrayList.add(this.n[i6]);
                } else {
                    arrayList = arrayList4;
                }
                i6++;
                vVarArr2 = vVarArr;
                arrayList3 = arrayList;
                length2 = i13;
                bVarArr3 = bVarArr4;
                length = i12;
            } else {
                throw new IllegalStateException();
            }
        }
        ArrayList arrayList5 = arrayList3;
        System.arraycopy(vVarArr3, 0, vVarArr2, 0, length);
        n[] nVarArr2 = new n[arrayList5.size()];
        this.o = nVarArr2;
        arrayList5.toArray(nVarArr2);
        n[] nVarArr3 = this.o;
        if (nVarArr3.length > 0) {
            nVarArr3[0].c.h = true;
            int i16 = 1;
            while (true) {
                n[] nVarArr4 = this.o;
                if (i16 >= nVarArr4.length) {
                    break;
                }
                nVarArr4[i16].c.h = false;
                i16++;
            }
        }
        this.p = new com.fyber.inneractive.sdk.player.exoplayer2.source.h(this.o);
        if (this.l && z) {
            j2 = j;
            a(j2);
            for (int i17 = 0; i17 < bVarArr.length; i17++) {
                if (vVarArr2[i17] != null) {
                    zArr2[i17] = true;
                }
            }
        } else {
            j2 = j;
        }
        this.l = true;
        return j2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final long a(long j) {
        this.g.f1302a.clear();
        for (n nVar : this.o) {
            nVar.c(j);
        }
        return j;
    }
}
