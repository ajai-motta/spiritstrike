package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.internal.ads.zzada;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaml implements zzada {
    private final zzamm zza;
    private final zzeg zzb;
    private final zzeg zzc;
    private final zzef zzd;
    private zzadd zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private boolean zzi;

    static {
        int i = zzamk.zza;
    }

    public zzaml() {
        throw null;
    }

    public zzaml(int i) {
        this.zza = new zzamm(true, null, 0, MimeTypes.AUDIO_AAC);
        this.zzb = new zzeg(2048);
        this.zzg = -1L;
        zzeg zzegVar = new zzeg(10);
        this.zzc = zzegVar;
        byte[] bArrZzi = zzegVar.zzi();
        this.zzd = new zzef(bArrZzi, bArrZzi.length);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        zzeg zzegVar;
        zzacr zzacrVar;
        int i = 0;
        while (true) {
            zzegVar = this.zzc;
            zzacrVar = (zzacr) zzadbVar;
            zzacrVar.zzh(zzegVar.zzi(), 0, 10, false);
            zzegVar.zzh(0);
            if (zzegVar.zzx() != 4801587) {
                break;
            }
            zzegVar.zzk(3);
            int iZzG = zzegVar.zzG();
            i += iZzG + 10;
            zzacrVar.zzj(iZzG, false);
        }
        zzadbVar.zzl();
        zzacrVar.zzj(i, false);
        if (this.zzg == -1) {
            this.zzg = i;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        do {
            zzacrVar.zzh(zzegVar.zzi(), 0, 2, false);
            zzegVar.zzh(0);
            if (zzamm.zzf(zzegVar.zzt())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                zzacrVar.zzh(zzegVar.zzi(), 0, 4, false);
                zzef zzefVar = this.zzd;
                zzefVar.zzf(14);
                int iZzj = zzefVar.zzj(13);
                if (iZzj <= 6) {
                    i4++;
                    zzadbVar.zzl();
                    zzacrVar.zzj(i4, false);
                } else {
                    zzacrVar.zzj(iZzj - 6, false);
                    i3 += iZzj;
                }
            } else {
                i4++;
                zzadbVar.zzl();
                zzacrVar.zzj(i4, false);
            }
            i2 = 0;
            i3 = 0;
        } while (i4 - i < 8192);
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ List zzb() {
        return zzgpe.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zze = zzaddVar;
        this.zza.zzb(zzaddVar, new zzaoe(Integer.MIN_VALUE, 0, 1));
        zzaddVar.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        this.zze.getClass();
        zzeg zzegVar = this.zzb;
        int iZza = zzadbVar.zza(zzegVar.zzi(), 0, 2048);
        if (!this.zzi) {
            this.zze.zzw(new zzaec(C.TIME_UNSET, 0L));
            this.zzi = true;
        }
        if (iZza == -1) {
            return -1;
        }
        zzegVar.zzh(0);
        zzegVar.zzf(iZza);
        if (!this.zzh) {
            this.zza.zzc(this.zzf, 4);
            this.zzh = true;
        }
        this.zza.zzd(zzegVar);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        this.zzh = false;
        this.zza.zza();
        this.zzf = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ zzada zzf() {
        return zzada.CC.$default$zzf(this);
    }
}
