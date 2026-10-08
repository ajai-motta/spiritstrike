package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zztw implements zzvn {
    private final zzadg zza;
    private zzada zzb;
    private zzadb zzc;

    public zztw(zzadg zzadgVar) {
        this.zza = zzadgVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    @Override // com.google.android.gms.internal.ads.zzvn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.ads.zzj r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, com.google.android.gms.internal.ads.zzadd r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztw.zza(com.google.android.gms.internal.ads.zzj, android.net.Uri, java.util.Map, long, long, com.google.android.gms.internal.ads.zzadd):void");
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zzb() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zzc() {
        zzada zzadaVar = this.zzb;
        if (zzadaVar != null && (zzadaVar instanceof zzahs)) {
            ((zzahs) zzadaVar).zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final long zzd() {
        zzadb zzadbVar = this.zzc;
        if (zzadbVar != null) {
            return zzadbVar.zzn();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zze(long j, long j2) {
        zzada zzadaVar = this.zzb;
        zzadaVar.getClass();
        zzadaVar.zze(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final int zzf(zzaea zzaeaVar) throws IOException {
        zzadb zzadbVar;
        zzada zzadaVar = this.zzb;
        if (zzadaVar == null || (zzadbVar = this.zzc) == null) {
            throw null;
        }
        return zzadaVar.zzd(zzadbVar, zzaeaVar);
    }
}
