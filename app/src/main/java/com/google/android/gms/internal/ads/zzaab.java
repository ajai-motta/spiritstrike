package com.google.android.gms.internal.ads;

import android.view.Surface;
import com.google.android.exoplayer2.C;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaab implements zzabx {
    private final zzaba zza;
    private final zzabb zzb;
    private final zzabg zzc;
    private final Queue zzd;
    private Surface zze;
    private zzv zzf;
    private long zzg;
    private zzabu zzh;
    private Executor zzi;
    private zzaax zzj;

    public zzaab(zzaba zzabaVar, zzabb zzabbVar, zzdc zzdcVar) {
        this.zza = zzabaVar;
        this.zzb = zzabbVar;
        zzabaVar.zzg(zzdcVar);
        this.zzc = new zzabg(new zzaaa(this, null), zzabaVar, zzabbVar);
        this.zzd = new ArrayDeque();
        this.zzf = new zzt().zzM();
        this.zzg = C.TIME_UNSET;
        this.zzh = zzabu.zzb;
        this.zzi = zzzw.zza;
        this.zzj = zzzu.zza;
    }

    final /* synthetic */ Surface zzA() {
        return this.zze;
    }

    final /* synthetic */ zzabu zzB() {
        return this.zzh;
    }

    final /* synthetic */ Executor zzC() {
        return this.zzi;
    }

    final /* synthetic */ zzaax zzD() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zza() {
        this.zzb.zzd();
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzb() {
        this.zzb.zzd();
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzc(zzabu zzabuVar, Executor executor) {
        this.zzh = zzabuVar;
        this.zzi = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzd(zzv zzvVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzf() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzg(boolean z) {
        if (z) {
            this.zza.zzl();
        }
        this.zzb.zzd();
        this.zzc.zza();
        this.zzd.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzh(boolean z) {
        return this.zza.zzi(z);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzi() {
        this.zzc.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzj() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzl(zzaax zzaaxVar) {
        this.zzj = zzaaxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzm(float f) {
        this.zza.zzn(f);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzn(List list) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzo(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzp(Surface surface, zzeh zzehVar) {
        this.zze = surface;
        this.zza.zzd(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzq() {
        this.zze = null;
        this.zza.zzd(null);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzr(int i) {
        this.zza.zzm(i);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzs(int i, zzv zzvVar, long j, int i2, List list) {
        zzgmd.zzh(list.isEmpty());
        int i3 = zzvVar.zzv;
        zzv zzvVar2 = this.zzf;
        if (i3 != zzvVar2.zzv || zzvVar.zzw != zzvVar2.zzw) {
            this.zzc.zzc(i3, zzvVar.zzw);
        }
        float f = zzvVar.zzz;
        if (f != this.zzf.zzz) {
            this.zza.zze(f);
        }
        this.zzf = zzvVar;
        if (j != this.zzg) {
            this.zzc.zzd(i2, j);
            this.zzg = j;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzt() {
        this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzu(long j, zzabv zzabvVar) {
        this.zzd.add(zzabvVar);
        this.zzc.zze(j);
        this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzv
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzy();
            }
        });
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzw(boolean z) {
        this.zza.zzj(z);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzx() {
    }

    final /* synthetic */ void zzy() {
        this.zzh.zza();
    }

    final /* synthetic */ Queue zzz() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final Surface zzk() {
        Surface surface = this.zze;
        surface.getClass();
        return surface;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzv(long j, long j2) throws zzabw {
        try {
            this.zzc.zzb(j, j2);
        } catch (zzib e) {
            throw new zzabw(e, this.zzf);
        }
    }
}
