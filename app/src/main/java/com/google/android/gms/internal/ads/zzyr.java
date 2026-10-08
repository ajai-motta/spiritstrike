package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzyr {
    private zzyq zza;
    private zzza zzb;

    public void zzb() {
        this.zza = null;
        this.zzb = null;
    }

    public boolean zzd() {
        throw null;
    }

    public void zze(zzd zzdVar) {
        throw null;
    }

    public zzlo zzg() {
        throw null;
    }

    public abstract void zzp(Object obj);

    public abstract zzys zzq(zzlp[] zzlpVarArr, zzwv zzwvVar, zzuu zzuuVar, zzbf zzbfVar) throws zzib;

    public final void zzr(zzyq zzyqVar, zzza zzzaVar) {
        zzgmd.zzh(this.zza == null);
        this.zza = zzyqVar;
        this.zzb = zzzaVar;
    }

    protected final void zzs() {
        zzyq zzyqVar = this.zza;
        if (zzyqVar != null) {
            zzyqVar.zzq();
        }
    }

    protected final zzza zzt() {
        zzza zzzaVar = this.zzb;
        zzzaVar.getClass();
        return zzzaVar;
    }
}
