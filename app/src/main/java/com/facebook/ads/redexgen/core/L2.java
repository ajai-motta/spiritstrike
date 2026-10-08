package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class L2 {
    public static String[] A0I = {"PiFB59Vxde45j8XGh3VNLS0bXquL", "eCGnEp7n3q", "QH0EN4bfbiXOmvaYxmEgWcgYRTVGFgtW", "ynU2FJVvbbIz4lLWIxM7HwzaaEzIs2yM", "B", "nKAZbJPu58l8", "2xLWRKjlXe7o2y", "tMbtJGMRwKJD523"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final InterfaceC1272Hd A0F;
    public final boolean A0G;
    public final boolean A0H;
    public final SparseArray<HR> A0D = new SparseArray<>();
    public final SparseArray<HQ> A0C = new SparseArray<>();
    public L1 A06 = new L1();
    public L1 A07 = new L1();
    public byte[] A0B = new byte[128];
    public final HU A0E = new HU(this.A0B, 0, 0);

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 26 out of bounds for length 26
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x021e A[PHI: r18 r20
  0x021e: PHI (r18v1 int) = (r18v0 int), (r18v0 int), (r18v0 int), (r18v0 int), (r18v3 int), (r18v3 int) binds: [B:92:0x01fa, B:94:0x01fe, B:99:0x0211, B:100:0x0213, B:82:0x01c6, B:83:0x01c8] A[DONT_GENERATE, DONT_INLINE]
  0x021e: PHI (r20v2 int) = (r20v0 int), (r20v0 int), (r20v1 int), (r20v1 int), (r20v0 int), (r20v0 int) binds: [B:92:0x01fa, B:94:0x01fe, B:99:0x0211, B:100:0x0213, B:82:0x01c6, B:83:0x01c8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05(byte[] r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.L2.A05(byte[], int, int):void");
    }

    public L2(InterfaceC1272Hd interfaceC1272Hd, boolean z, boolean z2) {
        this.A0F = interfaceC1272Hd;
        this.A0G = z;
        this.A0H = z2;
        A01();
    }

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
    private void A00(int i) {
        if (this.A05 == C.TIME_UNSET) {
            return;
        }
        boolean z = this.A0A;
        this.A0F.AIu(this.A05, z ? 1 : 0, (int) (this.A02 - this.A04), i, null);
    }

    public final void A01() {
        this.A08 = false;
        this.A09 = false;
        this.A07.A02();
    }

    public final void A02(long j, int i, long j2) {
        this.A01 = i;
        this.A03 = j2;
        this.A02 = j;
        if (!this.A0G || this.A01 != 1) {
            if (!this.A0H) {
                return;
            }
            if (this.A01 != 5 && this.A01 != 1 && this.A01 != 2) {
                return;
            }
        }
        L1 l1 = this.A06;
        L1 l12 = this.A07;
        if (A0I[1].length() != 10) {
            throw new RuntimeException();
        }
        A0I[6] = "uj74NyijhUvg4q";
        this.A06 = l12;
        this.A07 = l1;
        L1 newSliceHeader = this.A07;
        newSliceHeader.A02();
        this.A00 = 0;
        this.A08 = true;
    }

    public final void A03(HQ hq) {
        this.A0C.append(hq.A00, hq);
    }

    public final void A04(HR hr) {
        this.A0D.append(hr.A09, hr);
    }

    public final boolean A06() {
        return this.A0H;
    }

    public final boolean A07(long j, int i, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.A01 == 9 || (this.A0H && this.A07.A00(this.A06))) {
            if (z && this.A09) {
                A00(i + ((int) (j - this.A02)));
            }
            this.A04 = this.A02;
            this.A05 = this.A03;
            this.A0A = false;
            this.A09 = true;
        }
        if (this.A0G) {
            z2 = this.A07.A05();
        }
        boolean z4 = this.A0A;
        if (this.A01 == 5 || (z2 && this.A01 == 1)) {
            z3 = true;
        }
        this.A0A = z4 | z3;
        boolean treatIFrameAsKeyframe = this.A0A;
        return treatIFrameAsKeyframe;
    }
}
