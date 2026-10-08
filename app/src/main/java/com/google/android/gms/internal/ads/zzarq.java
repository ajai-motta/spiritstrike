package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzarq {
    public static byte[] zza() {
        int[] iArr = {1529195746, 118097808, 3345166, 656934035, 821390159, 1125361885, 184839124, 1037127828, 1034949299};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        iArr[0] = 1070575321;
        iArr[1] = 53864535;
        iArr[2] = 741512112;
        iArr[3] = 1665624655;
        iArr[4] = 1758594712;
        iArr[5] = 1453217468;
        iArr[6] = 94560416;
        iArr[7] = 1555319301;
        iArr[8] = 382697713;
        int i9 = (((((~1070575321) & 53864535) | 741512112) + ((1070575321 & 1665624655) | 1758594712)) - 1358657052) ^ (1555319301 % 382697713);
        int i10 = (i7 + (((((~i) & i2) | i3) + ((i & i4) | i5)) - i6)) ^ (i8 % 1034949299);
        int[] iArr2 = {350322227, 1077471394, 1759186290, 18931840, 769005128, 1847857001, 24413078, 1982275856, 1275373743};
        int i11 = iArr2[0];
        int i12 = iArr2[1];
        int i13 = iArr2[2];
        int i14 = iArr2[3];
        int i15 = iArr2[4];
        int i16 = iArr2[5];
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((iArr2[6] + ((((i12 & (~i11)) | i13) + ((i11 & i14) | i15)) - i16)) ^ (iArr2[7] % 1275373743));
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putShort((short) i10);
        byteBufferAllocate.putInt(i9);
        return byteBufferAllocate.array();
    }
}
