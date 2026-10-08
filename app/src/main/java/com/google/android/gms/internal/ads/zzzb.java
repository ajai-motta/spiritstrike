package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzzb implements zzyv {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzyt[] zzd = new zzyt[100];

    public zzzb(boolean z, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final synchronized zzyt zza() {
        zzyt zzytVar;
        this.zzb++;
        int i = this.zzc;
        if (i > 0) {
            zzyt[] zzytVarArr = this.zzd;
            int i2 = i - 1;
            this.zzc = i2;
            zzytVar = zzytVarArr[i2];
            zzytVar.getClass();
            zzytVarArr[i2] = null;
        } else {
            zzytVar = new zzyt(new byte[65536], 0);
            int i3 = this.zzb;
            zzyt[] zzytVarArr2 = this.zzd;
            int length = zzytVarArr2.length;
            if (i3 > length) {
                this.zzd = (zzyt[]) Arrays.copyOf(zzytVarArr2, length + length);
                return zzytVar;
            }
        }
        return zzytVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final synchronized void zzb(zzyt zzytVar) {
        zzyt[] zzytVarArr = this.zzd;
        int i = this.zzc;
        this.zzc = i + 1;
        zzytVarArr[i] = zzytVar;
        this.zzb--;
        notifyAll();
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final synchronized void zzc(zzyu zzyuVar) {
        while (zzyuVar != null) {
            zzyt[] zzytVarArr = this.zzd;
            int i = this.zzc;
            this.zzc = i + 1;
            zzytVarArr[i] = zzyuVar.zzd();
            this.zzb--;
            zzyuVar = zzyuVar.zze();
        }
        notifyAll();
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final synchronized void zzd() {
        int i = this.zza;
        String str = zzep.zza;
        int iMax = Math.max(0, ((i + 65535) / 65536) - this.zzb);
        int i2 = this.zzc;
        if (iMax >= i2) {
            return;
        }
        Arrays.fill(this.zzd, iMax, i2, (Object) null);
        this.zzc = iMax;
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i) {
        int i2 = this.zza;
        this.zza = i;
        if (i < i2) {
            zzd();
        }
    }

    public final synchronized int zzg() {
        return this.zzb * 65536;
    }
}
