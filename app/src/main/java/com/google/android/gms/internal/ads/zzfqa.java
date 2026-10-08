package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfqa implements zzfpt {
    private static zzfqa zza;
    private float zzb = 0.0f;
    private zzfpo zzc;
    private zzfps zzd;

    public zzfqa(zzfpp zzfppVar, zzfpl zzfplVar) {
    }

    public static zzfqa zza() {
        if (zza == null) {
            zza = new zzfqa(new zzfpp(), new zzfpl());
        }
        return zza;
    }

    public final void zzb(Context context) {
        this.zzc = new zzfpo(new Handler(), context, new zzfpk(), this);
    }

    public final void zzc() {
        zzfpr.zza().zzg(this);
        zzfpr.zza().zze();
        zzfrc.zzb().zzc();
        this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzfpt
    public final void zzd(boolean z) {
        if (z) {
            zzfrc.zzb().zzc();
        } else {
            zzfrc.zzb().zze();
        }
    }

    public final void zze() {
        zzfrc.zzb().zzd();
        zzfpr.zza().zzf();
        this.zzc.zzb();
    }

    public final void zzf(float f) {
        this.zzb = f;
        if (this.zzd == null) {
            this.zzd = zzfps.zza();
        }
        Iterator it = this.zzd.zzf().iterator();
        while (it.hasNext()) {
            ((zzfoy) it.next()).zzg().zzo(f);
        }
    }

    public final float zzg() {
        return this.zzb;
    }
}
