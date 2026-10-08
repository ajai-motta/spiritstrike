package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzden {
    private final Set zza = new HashSet();
    private final Set zzb = new HashSet();
    private final Set zzc = new HashSet();
    private final Set zzd = new HashSet();
    private final Set zze = new HashSet();
    private final Set zzf = new HashSet();
    private final Set zzg = new HashSet();
    private final Set zzh = new HashSet();
    private final Set zzi = new HashSet();
    private final Set zzj = new HashSet();
    private final Set zzk = new HashSet();
    private final Set zzl = new HashSet();
    private final Set zzm = new HashSet();
    private final Set zzn = new HashSet();
    private zzfdj zzo;

    final /* synthetic */ Set zzA() {
        return this.zzm;
    }

    final /* synthetic */ Set zzB() {
        return this.zzn;
    }

    final /* synthetic */ zzfdj zzC() {
        return this.zzo;
    }

    public final zzden zza(zzcyo zzcyoVar, Executor executor) {
        this.zze.add(new zzdgn(zzcyoVar, executor));
        return this;
    }

    public final zzden zzb(zzdac zzdacVar, Executor executor) {
        this.zzh.add(new zzdgn(zzdacVar, executor));
        return this;
    }

    public final zzden zzc(zzcyr zzcyrVar, Executor executor) {
        this.zzi.add(new zzdgn(zzcyrVar, executor));
        return this;
    }

    public final zzden zzd(zzcze zzczeVar, Executor executor) {
        this.zzl.add(new zzdgn(zzczeVar, executor));
        return this;
    }

    public final zzden zze(AppEventListener appEventListener, Executor executor) {
        this.zzk.add(new zzdgn(appEventListener, executor));
        return this;
    }

    public final zzden zzf(com.google.android.gms.ads.internal.client.zza zzaVar, Executor executor) {
        this.zzc.add(new zzdgn(zzaVar, executor));
        return this;
    }

    public final zzden zzg(zzdgv zzdgvVar, Executor executor) {
        this.zzd.add(new zzdgn(zzdgvVar, executor));
        return this;
    }

    public final zzden zzh(zzczi zzcziVar, Executor executor) {
        this.zzf.add(new zzdgn(zzcziVar, executor));
        return this;
    }

    public final zzden zzi(zzdan zzdanVar, Executor executor) {
        this.zzg.add(new zzdgn(zzdanVar, executor));
        return this;
    }

    public final zzden zzj(com.google.android.gms.ads.internal.overlay.zzr zzrVar, Executor executor) {
        this.zzn.add(new zzdgn(zzrVar, executor));
        return this;
    }

    public final zzden zzk(zzdbf zzdbfVar, Executor executor) {
        this.zzm.add(new zzdgn(zzdbfVar, executor));
        return this;
    }

    public final zzden zzl(zzfdj zzfdjVar) {
        this.zzo = zzfdjVar;
        return this;
    }

    public final zzden zzm(zzdbu zzdbuVar, Executor executor) {
        this.zzb.add(new zzdgn(zzdbuVar, executor));
        return this;
    }

    public final zzdeo zzn() {
        return new zzdeo(this, null);
    }

    final /* synthetic */ Set zzo() {
        return this.zza;
    }

    final /* synthetic */ Set zzp() {
        return this.zzb;
    }

    final /* synthetic */ Set zzq() {
        return this.zzc;
    }

    final /* synthetic */ Set zzr() {
        return this.zzd;
    }

    final /* synthetic */ Set zzs() {
        return this.zze;
    }

    final /* synthetic */ Set zzt() {
        return this.zzf;
    }

    final /* synthetic */ Set zzu() {
        return this.zzg;
    }

    final /* synthetic */ Set zzv() {
        return this.zzh;
    }

    final /* synthetic */ Set zzw() {
        return this.zzi;
    }

    final /* synthetic */ Set zzx() {
        return this.zzj;
    }

    final /* synthetic */ Set zzy() {
        return this.zzk;
    }

    final /* synthetic */ Set zzz() {
        return this.zzl;
    }
}
