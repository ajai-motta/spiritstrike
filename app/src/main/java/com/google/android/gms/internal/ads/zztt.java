package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzuw;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zztt implements zzuw {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zzve zzc = new zzve();
    private final zzru zzd = new zzru();
    private Looper zze;
    private zzbf zzf;
    private zzpc zzg;

    @Override // com.google.android.gms.internal.ads.zzuw
    public /* synthetic */ void zzA(zzak zzakVar) {
        zzuw.CC.$default$zzA(this, zzakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public /* synthetic */ zzbf zzH() {
        return zzuw.CC.$default$zzH(this);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public /* synthetic */ boolean zzI() {
        return zzuw.CC.$default$zzI(this);
    }

    protected void zzM() {
    }

    protected abstract void zza(zzgz zzgzVar);

    protected void zzc() {
    }

    protected abstract void zzd();

    protected final void zze(zzbf zzbfVar) {
        this.zzf = zzbfVar;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzuv) arrayList.get(i)).zza(this, zzbfVar);
        }
    }

    protected final zzve zzf(zzuu zzuuVar) {
        return this.zzc.zza(0, zzuuVar);
    }

    protected final zzve zzg(int i, zzuu zzuuVar) {
        return this.zzc.zza(0, zzuuVar);
    }

    protected final zzru zzh(zzuu zzuuVar) {
        return this.zzd.zza(0, zzuuVar);
    }

    protected final zzru zzi(int i, zzuu zzuuVar) {
        return this.zzd.zza(0, zzuuVar);
    }

    protected final boolean zzj() {
        return !this.zzb.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzl(Handler handler, zzvf zzvfVar) {
        this.zzc.zzb(handler, zzvfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzm(zzvf zzvfVar) {
        this.zzc.zzc(zzvfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzn(Handler handler, zzrv zzrvVar) {
        this.zzd.zzb(handler, zzrvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzo(zzrv zzrvVar) {
        this.zzd.zzc(zzrvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzp(zzuv zzuvVar, zzgz zzgzVar, zzpc zzpcVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z = true;
        if (looper != null && looper != looperMyLooper) {
            z = false;
        }
        zzgmd.zza(z);
        this.zzg = zzpcVar;
        zzbf zzbfVar = this.zzf;
        this.zza.add(zzuvVar);
        if (this.zze == null) {
            this.zze = looperMyLooper;
            this.zzb.add(zzuvVar);
            zza(zzgzVar);
        } else if (zzbfVar != null) {
            zzq(zzuvVar);
            zzuvVar.zza(this, zzbfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzq(zzuv zzuvVar) {
        this.zze.getClass();
        HashSet hashSet = this.zzb;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.add(zzuvVar);
        if (zIsEmpty) {
            zzM();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzr(zzuv zzuvVar) {
        HashSet hashSet = this.zzb;
        boolean z = !hashSet.isEmpty();
        hashSet.remove(zzuvVar);
        if (z && hashSet.isEmpty()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzs(zzuv zzuvVar) {
        ArrayList arrayList = this.zza;
        arrayList.remove(zzuvVar);
        if (!arrayList.isEmpty()) {
            zzr(zzuvVar);
            return;
        }
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
        this.zzb.clear();
        zzd();
    }

    protected final zzpc zzk() {
        zzpc zzpcVar = this.zzg;
        zzpcVar.getClass();
        return zzpcVar;
    }
}
