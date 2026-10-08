package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ly, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2472ly extends AbstractC1321Jb {
    public static String[] A02 = {"WZkrugZ9k", "x4SWtznAL", "HpTT9hwXiF", "GejxPsVIqdMqn4uNSueU2CvK5QdcE", "kY6PJZpIMUpeuimCFjYxSQzMMPc04", "AyPx1MENxNPCbM7HZGi1kOnAmMtkHxm9", "mMmHuZ9NaaUgibHMJoRcA4q0AdWca5ys", "Hii3DdXYVzyt8ReiNrO7wglp0i"};
    public HJ A00;
    public C2473lz A01;

    private int A00(C09724v c09724v) {
        int i = (c09724v.A0l()[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            c09724v.A0g(4);
            String[] strArr = A02;
            String str = strArr[6];
            String str2 = strArr[5];
            int iCharAt = str.charAt(19);
            int blockSizeKey = str2.charAt(19);
            if (iCharAt == blockSizeKey) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "Cisj8wK8S";
            strArr2[0] = "koTyuZ08X";
            c09724v.A0S();
        }
        int result = HF.A00(c09724v, i);
        c09724v.A0f(0);
        return result;
    }

    public static boolean A01(C09724v c09724v) {
        return c09724v.A07() >= 5 && c09724v.A0I() == 127 && c09724v.A0Q() == 1179402563;
    }

    public static boolean A02(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1321Jb
    public final long A09(C09724v c09724v) {
        if (!A02(c09724v.A0l())) {
            return -1L;
        }
        return A00(c09724v);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1321Jb
    public final void A0B(boolean z) {
        super.A0B(z);
        if (z) {
            this.A00 = null;
            this.A01 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1321Jb
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean A0C(C09724v c09724v, long j, C1320Ja c1320Ja) {
        byte[] bArrA0l = c09724v.A0l();
        HJ hj = this.A00;
        if (hj == null) {
            HJ hj2 = new HJ(bArrA0l, 17);
            this.A00 = hj2;
            c1320Ja.A00 = hj2.A08(Arrays.copyOfRange(bArrA0l, 9, c09724v.A0A()), null);
            return true;
        }
        if ((bArrA0l[0] & 127) == 3) {
            HI hiA03 = HH.A03(c09724v);
            HJ streamMetadata = hj.A09(hiA03);
            this.A00 = streamMetadata;
            this.A01 = new C2473lz(streamMetadata, hiA03);
            return true;
        }
        if (!A02(bArrA0l)) {
            return true;
        }
        if (this.A01 != null) {
            this.A01.A00(j);
            c1320Ja.A01 = this.A01;
        }
        C2725qI c2725qI = c1320Ja.A00;
        String[] strArr = A02;
        if (strArr[4].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[3] = "zwTfeKiQLRobCpiZaAgtU0oyP8s29";
        strArr2[2] = "wrCWS6iAkk";
        AbstractC09493y.A01(c2725qI);
        return false;
    }
}
