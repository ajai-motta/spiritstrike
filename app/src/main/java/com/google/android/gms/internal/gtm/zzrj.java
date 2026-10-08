package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzrj {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList();
    private final List zzd = new ArrayList();
    private final List zze = new ArrayList();
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final List zzh = new ArrayList();
    private final List zzi = new ArrayList();
    private final List zzj = new ArrayList();

    private zzrj() {
    }

    public final zzri zza() {
        return new zzri(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, null);
    }

    public final zzrj zzb(zzre zzreVar) {
        this.zze.add(zzreVar);
        return this;
    }

    public final zzrj zzc(String str) {
        this.zzg.add(str);
        return this;
    }

    public final zzrj zzd(zzre zzreVar) {
        this.zzc.add(zzreVar);
        return this;
    }

    public final zzrj zze(String str) {
        this.zzi.add(str);
        return this;
    }

    public final zzrj zzf(zzre zzreVar) {
        this.zzb.add(zzreVar);
        return this;
    }

    public final zzrj zzg(zzre zzreVar) {
        this.zza.add(zzreVar);
        return this;
    }

    public final zzrj zzh(zzre zzreVar) {
        this.zzf.add(zzreVar);
        return this;
    }

    public final zzrj zzi(String str) {
        this.zzh.add(str);
        return this;
    }

    public final zzrj zzj(zzre zzreVar) {
        this.zzd.add(zzreVar);
        return this;
    }

    public final zzrj zzk(String str) {
        this.zzj.add(str);
        return this;
    }

    /* synthetic */ zzrj(zzrl zzrlVar) {
    }
}
