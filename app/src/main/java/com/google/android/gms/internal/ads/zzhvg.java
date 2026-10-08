package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
class zzhvg extends zzhvf {
    protected final byte[] zza;

    zzhvg(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhvi) || zzc() != ((zzhvi) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzhvg)) {
            return obj.equals(this);
        }
        zzhvg zzhvgVar = (zzhvg) obj;
        int iZzy = zzy();
        int iZzy2 = zzhvgVar.zzy();
        if (iZzy == 0 || iZzy2 == 0 || iZzy == iZzy2) {
            return zzh(zzhvgVar, 0, zzc());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public int zzc() {
        return this.zza.length;
    }

    protected int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    protected void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhvf
    final boolean zzh(zzhvi zzhviVar, int i, int i2) {
        if (i2 > zzhviVar.zzc()) {
            int iZzc = zzc();
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 18 + String.valueOf(iZzc).length());
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(iZzc);
            throw new IllegalArgumentException(sb.toString());
        }
        int i3 = i + i2;
        if (i3 > zzhviVar.zzc()) {
            int iZzc2 = zzhviVar.zzc();
            int length = String.valueOf(i).length();
            StringBuilder sb2 = new StringBuilder(length + 24 + String.valueOf(i2).length() + 2 + String.valueOf(iZzc2).length());
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(iZzc2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!(zzhviVar instanceof zzhvg)) {
            return zzhviVar.zzi(i, i3).equals(zzi(0, i2));
        }
        zzhvg zzhvgVar = (zzhvg) zzhviVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzhvgVar.zza;
        int iZzd = zzd() + i2;
        int iZzd2 = zzd();
        int iZzd3 = zzhvgVar.zzd() + i;
        while (iZzd2 < iZzd) {
            if (bArr[iZzd2] != bArr2[iZzd3]) {
                return false;
            }
            iZzd2++;
            iZzd3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final zzhvi zzi(int i, int i2) {
        int iZzA = zzA(i, i2, zzc());
        return iZzA == 0 ? zzhvi.zzb : new zzhvc(this.zza, zzd() + i, iZzA);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final ByteBuffer zzj() {
        return ByteBuffer.wrap(this.zza, zzd(), zzc()).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    final void zzk(zzhuz zzhuzVar) throws IOException {
        zzhuzVar.zza(this.zza, zzd(), zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    protected final String zzl(Charset charset) {
        return new String(this.zza, zzd(), zzc(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final boolean zzm() {
        int iZzd = zzd();
        return zzhzo.zza(this.zza, iZzd, zzc() + iZzd);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    protected final int zzn(int i, int i2, int i3) {
        int iZzd = zzd() + i2;
        return zzhzo.zzb(i, this.zza, iZzd, i3 + iZzd);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    protected final int zzo(int i, int i2, int i3) {
        return zzhxb.zzc(i, this.zza, zzd() + i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final zzhvn zzp() {
        return zzhvn.zzG(this.zza, zzd(), zzc(), true);
    }
}
