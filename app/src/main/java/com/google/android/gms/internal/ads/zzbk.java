package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.HashSet;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzbk {
    private int zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private zzgpe zzi;
    private zzgpe zzj;
    private zzgpe zzk;
    private zzgpe zzl;
    private zzgpe zzm;
    private int zzn;
    private int zzo;
    private zzgpe zzp;
    private zzbj zzq;
    private zzgpe zzr;
    private boolean zzs;
    private zzgpe zzt;
    private HashMap zzu;
    private HashSet zzv;

    public zzbk() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = Integer.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = true;
        this.zzh = true;
        this.zzi = zzgpe.zzi();
        this.zzj = zzgpe.zzi();
        this.zzk = zzgpe.zzi();
        this.zzl = zzgpe.zzi();
        this.zzm = zzgpe.zzi();
        this.zzn = Integer.MAX_VALUE;
        this.zzo = Integer.MAX_VALUE;
        this.zzp = zzgpe.zzi();
        this.zzq = zzbj.zza;
        this.zzr = zzgpe.zzi();
        this.zzs = true;
        this.zzt = zzgpe.zzi();
        this.zzu = new HashMap();
        this.zzv = new HashSet();
    }

    @EnsuresNonNull({"preferredVideoMimeTypes", "preferredVideoLanguages", "preferredAudioLanguages", "preferredAudioMimeTypes", "audioOffloadPreferences", "preferredTextLanguages", "overrides", "disabledTrackTypes", "preferredVideoLabels", "preferredAudioLabels", "preferredTextLabels"})
    private final void zzx(zzbl zzblVar) {
        this.zza = zzblVar.zza;
        this.zzb = zzblVar.zzb;
        this.zzc = zzblVar.zzc;
        this.zzd = zzblVar.zzd;
        int i = zzblVar.zze;
        int i2 = zzblVar.zzf;
        int i3 = zzblVar.zzg;
        int i4 = zzblVar.zzh;
        this.zze = zzblVar.zzi;
        this.zzf = zzblVar.zzj;
        this.zzg = zzblVar.zzk;
        this.zzh = zzblVar.zzl;
        this.zzj = zzblVar.zzn;
        this.zzi = zzblVar.zzm;
        this.zzk = zzblVar.zzo;
        int i5 = zzblVar.zzp;
        this.zzl = zzblVar.zzq;
        int i6 = zzblVar.zzs;
        this.zzm = zzblVar.zzr;
        this.zzn = zzblVar.zzt;
        this.zzo = zzblVar.zzu;
        this.zzp = zzblVar.zzv;
        this.zzq = zzblVar.zzw;
        boolean z = zzblVar.zzx;
        this.zzr = zzblVar.zzy;
        int i7 = zzblVar.zzA;
        this.zzs = zzblVar.zzB;
        this.zzt = zzblVar.zzz;
        int i8 = zzblVar.zzC;
        boolean z2 = zzblVar.zzD;
        boolean z3 = zzblVar.zzE;
        boolean z4 = zzblVar.zzF;
        boolean z5 = zzblVar.zzG;
        this.zzv = new HashSet(zzblVar.zzI);
        this.zzu = new HashMap(zzblVar.zzH);
    }

    protected final zzbk zza(zzbl zzblVar) {
        zzx(zzblVar);
        return this;
    }

    final /* synthetic */ int zzb() {
        return this.zza;
    }

    final /* synthetic */ int zzc() {
        return this.zzb;
    }

    final /* synthetic */ int zzd() {
        return this.zzc;
    }

    final /* synthetic */ int zze() {
        return this.zzd;
    }

    final /* synthetic */ int zzf() {
        return this.zze;
    }

    final /* synthetic */ int zzg() {
        return this.zzf;
    }

    final /* synthetic */ boolean zzh() {
        return this.zzg;
    }

    final /* synthetic */ boolean zzi() {
        return this.zzh;
    }

    final /* synthetic */ zzgpe zzj() {
        return this.zzi;
    }

    final /* synthetic */ zzgpe zzk() {
        return this.zzj;
    }

    final /* synthetic */ zzgpe zzl() {
        return this.zzk;
    }

    final /* synthetic */ zzgpe zzm() {
        return this.zzl;
    }

    final /* synthetic */ zzgpe zzn() {
        return this.zzm;
    }

    final /* synthetic */ int zzo() {
        return this.zzn;
    }

    final /* synthetic */ int zzp() {
        return this.zzo;
    }

    final /* synthetic */ zzgpe zzq() {
        return this.zzp;
    }

    final /* synthetic */ zzbj zzr() {
        return this.zzq;
    }

    final /* synthetic */ zzgpe zzs() {
        return this.zzr;
    }

    final /* synthetic */ boolean zzt() {
        return this.zzs;
    }

    final /* synthetic */ zzgpe zzu() {
        return this.zzt;
    }

    final /* synthetic */ HashMap zzv() {
        return this.zzu;
    }

    final /* synthetic */ HashSet zzw() {
        return this.zzv;
    }

    protected zzbk(zzbl zzblVar) {
        zzx(zzblVar);
    }
}
