package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i {
    public static final int A = z.a("seig");
    public static final byte[] B = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.v f;
    public int l;
    public long m;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.n o;
    public long p;
    public int q;
    public l t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.j y;
    public boolean z;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n g = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(16);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(com.fyber.inneractive.sdk.player.exoplayer2.util.l.f1470a);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(5);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n d = new com.fyber.inneractive.sdk.player.exoplayer2.util.n();
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n e = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(1);
    public final byte[] h = new byte[16];
    public final Stack i = new Stack();
    public final LinkedList j = new LinkedList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f1332a = new SparseArray();
    public long r = C.TIME_UNSET;
    public long s = C.TIME_UNSET;
    public int k = 0;
    public int n = 0;

    public m(com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar) {
        this.f = vVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        return r.a(bVar, true);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        this.y = jVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        int size = this.f1332a.size();
        for (int i = 0; i < size; i++) {
            ((l) this.f1332a.valueAt(i)).a();
        }
        this.j.clear();
        this.q = 0;
        this.i.clear();
        this.k = 0;
        this.n = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        r2 = r27.t;
        r4 = r2.f1331a;
        r8 = r4.h;
        r9 = r2.e;
        r27.u = r8[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:
    
        if (r4.l == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008a, code lost:
    
        r8 = r4.p;
        r10 = r4.f1339a.f1329a;
        r11 = r4.n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0092, code lost:
    
        if (r11 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0095, code lost:
    
        r11 = r2.c.h[r10];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009b, code lost:
    
        r10 = r11.f1338a;
        r4 = r4.m[r9];
        r9 = r27.e;
        r11 = r9.f1472a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a5, code lost:
    
        if (r4 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a7, code lost:
    
        r12 = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00aa, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ab, code lost:
    
        r11[0] = (byte) (r12 | r10);
        r9.e(0);
        r2 = r2.b;
        r2.a(1, r27.e);
        r2.a(r10, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bc, code lost:
    
        if (r4 != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00be, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c0, code lost:
    
        r4 = r8.o();
        r8.e(r8.b - 2);
        r4 = (r4 * 6) + 2;
        r2.a(r4, r8);
        r10 = (r10 + 1) + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d3, code lost:
    
        r27.v = r10;
        r27.u += r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00db, code lost:
    
        r27.v = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e3, code lost:
    
        if (r27.t.c.g != 1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e5, code lost:
    
        r27.u -= 8;
        r1.a(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ed, code lost:
    
        r27.k = 4;
        r27.w = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f2, code lost:
    
        r2 = r27.t;
        r4 = r2.f1331a;
        r5 = r2.c;
        r8 = r2.b;
        r2 = r2.e;
        r9 = r5.k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0100, code lost:
    
        if (r9 == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0102, code lost:
    
        r12 = r27.c.f1472a;
        r12[0] = 0;
        r12[1] = 0;
        r12[2] = 0;
        r3 = r9 + 1;
        r9 = 4 - r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0115, code lost:
    
        if (r27.v >= r27.u) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0117, code lost:
    
        r13 = r27.w;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0119, code lost:
    
        if (r13 != 0) goto L308;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x011b, code lost:
    
        r1.b(r12, r9, r3, r7);
        r27.c.e(r7 ? 1 : 0);
        r27.w = r27.c.m() - r6;
        r27.b.e(r7 ? 1 : 0);
        r8.a(4, r27.b);
        r8.a(r6, r27.c);
        r27.x = r7;
        r27.v += 5;
        r27.u += r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014c, code lost:
    
        if (r27.x == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x014e, code lost:
    
        r27.d.c(r13);
        r1.b(r27.d.f1472a, r7 ? 1 : 0, r27.w, r7);
        r8.a(r27.w, r27.d);
        r13 = r27.w;
        r14 = r27.d;
        r14 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(r14.c, r14.f1472a);
        r27.d.e("video/hevc".equals(r5.f.f) ? 1 : 0);
        r27.d.d(r14);
        com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a((r4.j[r2] + ((long) r4.i[r2])) * 1000, r27.d, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0196, code lost:
    
        r13 = r8.a(r1, r13, r7 ? 1 : 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x019b, code lost:
    
        r27.v += r13;
        r27.w -= r13;
        r6 = 1;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01a9, code lost:
    
        r3 = r27.v;
        r6 = r27.u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01ad, code lost:
    
        if (r3 >= r6) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01af, code lost:
    
        r27.v += r8.a(r1, r6 - r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01bb, code lost:
    
        r6 = (r4.j[r2] + ((long) r4.i[r2])) * 1000;
        r1 = r4.l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01c8, code lost:
    
        if (r1 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01ca, code lost:
    
        r3 = 1073741824;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01cd, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01ce, code lost:
    
        r11 = r3 | (r4.k[r2] ? 1 : 0);
        r2 = r4.f1339a.f1329a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01d8, code lost:
    
        if (r1 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01da, code lost:
    
        r1 = r4.n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01dc, code lost:
    
        if (r1 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01de, code lost:
    
        r1 = r1.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01e1, code lost:
    
        r1 = r5.h[r2].b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01e7, code lost:
    
        r14 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01e9, code lost:
    
        r14 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ea, code lost:
    
        r1 = r27.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ec, code lost:
    
        if (r1 == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ee, code lost:
    
        r9 = r1.a(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01f4, code lost:
    
        r9 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01f5, code lost:
    
        r8.a(r9, r11, r27.u, 0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0201, code lost:
    
        if (r27.j.isEmpty() == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0203, code lost:
    
        r1 = r27.t;
        r1.e++;
        r2 = r1.f + 1;
        r1.f = r2;
        r4 = r4.g;
        r5 = r1.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0216, code lost:
    
        if (r2 != r4[r5]) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0218, code lost:
    
        r1.g = r5 + 1;
        r2 = 0;
        r1.f = 0;
        r27.t = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0222, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0223, code lost:
    
        r27.k = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0226, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0227, code lost:
    
        r1 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.k) r27.j.removeFirst();
        r27.q -= r1.b;
        r1 = r1.f1330a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0239, code lost:
    
        throw null;
     */
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
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r28, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o r29) throws java.lang.InterruptedException, com.fyber.inneractive.sdk.player.exoplayer2.r, java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 1321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.m.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:267:0x06ce, code lost:
    
        r2 = r0;
        r2.k = 0;
        r2.n = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x06d4, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:141:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x05cb  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0605  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r52) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        /*
            Method dump skipped, instruction units count: 1749
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.m.a(long):void");
    }

    public static void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, u uVar) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        nVar.e(i + 8);
        int iB = nVar.b();
        int i2 = c.b;
        if ((iB & 1) == 0) {
            boolean z = (iB & 2) != 0;
            int iM = nVar.m();
            if (iM == uVar.e) {
                Arrays.fill(uVar.m, 0, iM, z);
                int i3 = nVar.c - nVar.b;
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = uVar.p;
                if (nVar2 == null || nVar2.c < i3) {
                    uVar.p = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(i3);
                }
                uVar.o = i3;
                uVar.l = true;
                uVar.q = true;
                nVar.a(uVar.p.f1472a, 0, i3);
                uVar.p.e(0);
                uVar.q = false;
                return;
            }
            StringBuilder sbA = com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Length mismatch: ", iM, ", ");
            sbA.append(uVar.e);
            throw new com.fyber.inneractive.sdk.player.exoplayer2.r(sbA.toString());
        }
        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.drm.d a(ArrayList arrayList) {
        int size = arrayList.size();
        ArrayList arrayList2 = null;
        for (int i = 0; i < size; i++) {
            b bVar = (b) arrayList.get(i);
            if (bVar.f1323a == c.V) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] bArr = bVar.P0.f1472a;
                UUID uuidA = q.a(bArr);
                if (uuidA == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList2.add(new com.fyber.inneractive.sdk.player.exoplayer2.drm.c(uuidA, MimeTypes.VIDEO_MP4, bArr));
                }
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        return new com.fyber.inneractive.sdk.player.exoplayer2.drm.d(false, (com.fyber.inneractive.sdk.player.exoplayer2.drm.c[]) arrayList2.toArray(new com.fyber.inneractive.sdk.player.exoplayer2.drm.c[arrayList2.size()]));
    }
}
