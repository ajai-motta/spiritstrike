package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzarw implements zzaru {
    private int zza;
    private final byte[] zzb;
    private final zzary zzc;

    public zzarw(zzary zzaryVar) {
        int[] iArr = {1539942439, 2070175971, 1100945533, -1166483302, -2145608135, 164110942, 67728125, 1143565421, 981914693};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        iArr[0] = 991039875;
        iArr[1] = 475472926;
        iArr[2] = 1225689584;
        iArr[3] = 357672014;
        iArr[4] = 1805818736;
        iArr[5] = -1153961639;
        iArr[6] = 102782241;
        iArr[7] = 1671581032;
        iArr[8] = 1337434154;
        this.zza = (i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6)) ^ (i8 % 981914693);
        this.zzb = new byte[(((((~991039875) & 475472926) | 1225689584) + ((991039875 & 357672014) | 1805818736)) - (-1256743880)) ^ (1671581032 % 1337434154)];
        this.zzc = zzaryVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final byte zza(zzasg zzasgVar, int i) {
        int[] iArr = {143154913, 992498304, 439467622, 1627930754, 1212551295, -122082883, 1967905751, 2033018190, 70061690};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        iArr[0] = 1264448664;
        iArr[1] = 231739608;
        iArr[2] = 1128901767;
        iArr[3] = 479203675;
        iArr[4] = 860794247;
        iArr[5] = 1929373616;
        iArr[6] = 106041240;
        iArr[7] = 1761855727;
        iArr[8] = 1384724137;
        int i10 = (((231739608 & (~1264448664)) | 1128901767) + ((1264448664 & 479203675) | 860794247)) - 1823332376;
        int i11 = 1761855727 % 1384724137;
        iArr[0] = 1661299468;
        iArr[1] = 613450408;
        iArr[2] = 2017391535;
        iArr[3] = 109051904;
        iArr[4] = 2071555381;
        iArr[5] = -395510193;
        iArr[6] = 45882350;
        iArr[7] = 1694830070;
        int i12 = (i8 + ((((i3 & (~i2)) | i4) + ((i2 & i5) | i6)) - i7)) ^ (i9 % 70061690);
        iArr[8] = 1383960411;
        int i13 = ((((~1661299468) & 613450408) | 2017391535) + ((1661299468 & 109051904) | 2071555381)) - (-441392543);
        int i14 = 1694830070 % 1383960411;
        int i15 = i >>> i12;
        if (i15 != this.zza) {
            this.zzc.zza(i15, this.zzb);
            this.zza = i15;
        }
        int i16 = i13 ^ i14;
        return (byte) (((this.zzb[i % (i10 ^ i11)] ^ zzasgVar.zzb(i)) << i16) >> i16);
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final zzasg zzb(zzasg zzasgVar, int i, int i2) {
        if (i < 0 || i > i2 || i2 > zzasgVar.zza.length) {
            throw new IndexOutOfBoundsException();
        }
        byte[] bArr = new byte[i2 - i];
        int i3 = 0;
        while (i < i2) {
            bArr[i3] = zza(zzasgVar, i);
            i++;
            i3++;
        }
        return zzasg.zze(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final /* bridge */ /* synthetic */ zzaru zzc() {
        return new zzarw(this.zzc);
    }
}
