package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
class zzyv extends zzyu {
    protected final byte[] zza;

    zzyv(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.gtm.zzyx
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzyx) || zzd() != ((zzyx) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzyv)) {
            return obj.equals(this);
        }
        zzyv zzyvVar = (zzyv) obj;
        int iZzi = zzi();
        int iZzi2 = zzyvVar.zzi();
        if (iZzi != 0 && iZzi2 != 0 && iZzi != iZzi2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzyvVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzyvVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzyvVar.zzd());
        }
        if (!(zzyvVar instanceof zzyv)) {
            return zzyvVar.zzf(0, iZzd).equals(zzf(0, iZzd));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzyvVar.zza;
        zzyvVar.zzc();
        int i = 0;
        int i2 = 0;
        while (i < iZzd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzyx
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.gtm.zzyx
    byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzyx
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.gtm.zzyx
    protected final int zze(int i, int i2, int i3) {
        return zzaco.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.gtm.zzyx
    public final zzyx zzf(int i, int i2) {
        int iZzh = zzh(0, i2, zzd());
        return iZzh == 0 ? zzyx.zzb : new zzys(this.zza, 0, iZzh);
    }

    @Override // com.google.android.gms.internal.gtm.zzyx
    final void zzg(zzyp zzypVar) throws IOException {
        zzypVar.zza(this.zza, 0, zzd());
    }
}
