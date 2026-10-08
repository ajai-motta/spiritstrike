package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
class zzqk extends zzqj {
    protected final byte[] zza;

    zzqk(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.recaptcha.internal.zzqm
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzqm) || zzd() != ((zzqm) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzqk)) {
            return obj.equals(this);
        }
        zzqk zzqkVar = (zzqk) obj;
        int iZzk = zzk();
        int iZzk2 = zzqkVar.zzk();
        if (iZzk != 0 && iZzk2 != 0 && iZzk != iZzk2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzqkVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzqkVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzqkVar.zzd());
        }
        if (!(zzqkVar instanceof zzqk)) {
            return zzqkVar.zzg(0, iZzd).equals(zzg(0, iZzd));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzqkVar.zza;
        zzqkVar.zzc();
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

    @Override // com.google.android.recaptcha.internal.zzqm
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.recaptcha.internal.zzqm
    byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.recaptcha.internal.zzqm
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.recaptcha.internal.zzqm
    protected void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    @Override // com.google.android.recaptcha.internal.zzqm
    protected final int zzf(int i, int i2, int i3) {
        return zzsv.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.recaptcha.internal.zzqm
    public final zzqm zzg(int i, int i2) {
        int iZzj = zzj(0, i2, zzd());
        return iZzj == 0 ? zzqm.zzb : new zzqh(this.zza, 0, iZzj);
    }

    @Override // com.google.android.recaptcha.internal.zzqm
    protected final String zzh(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.recaptcha.internal.zzqm
    final void zzi(zzqe zzqeVar) throws IOException {
        ((zzqs) zzqeVar).zzc(this.zza, 0, zzd());
    }
}
