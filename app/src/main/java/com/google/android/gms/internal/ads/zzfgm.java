package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfgm {
    private com.google.android.gms.ads.internal.client.zzm zza;
    private com.google.android.gms.ads.internal.client.zzr zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzga zzd;
    private boolean zze;
    private ArrayList zzf;
    private ArrayList zzg;
    private zzbhx zzh;
    private com.google.android.gms.ads.internal.client.zzx zzi;
    private AdManagerAdViewOptions zzj;
    private PublisherAdViewOptions zzk;
    private com.google.android.gms.ads.internal.client.zzco zzl;
    private zzboi zzn;
    private zzeot zzr;
    private Bundle zzt;
    private com.google.android.gms.ads.internal.client.zzcs zzv;
    private int zzm = 1;
    private final zzfga zzo = new zzfga();
    private boolean zzp = false;
    private boolean zzq = false;
    private boolean zzs = false;
    private final AtomicLong zzu = new AtomicLong();

    public final boolean zzA() {
        return this.zzp;
    }

    public final boolean zzB() {
        return this.zzq;
    }

    final /* synthetic */ com.google.android.gms.ads.internal.client.zzm zzC() {
        return this.zza;
    }

    final /* synthetic */ com.google.android.gms.ads.internal.client.zzr zzD() {
        return this.zzb;
    }

    final /* synthetic */ String zzE() {
        return this.zzc;
    }

    final /* synthetic */ com.google.android.gms.ads.internal.client.zzga zzF() {
        return this.zzd;
    }

    final /* synthetic */ boolean zzG() {
        return this.zze;
    }

    final /* synthetic */ ArrayList zzH() {
        return this.zzf;
    }

    final /* synthetic */ ArrayList zzI() {
        return this.zzg;
    }

    final /* synthetic */ zzbhx zzJ() {
        return this.zzh;
    }

    final /* synthetic */ com.google.android.gms.ads.internal.client.zzx zzK() {
        return this.zzi;
    }

    final /* synthetic */ AdManagerAdViewOptions zzL() {
        return this.zzj;
    }

    final /* synthetic */ PublisherAdViewOptions zzM() {
        return this.zzk;
    }

    final /* synthetic */ com.google.android.gms.ads.internal.client.zzco zzN() {
        return this.zzl;
    }

    final /* synthetic */ int zzO() {
        return this.zzm;
    }

    final /* synthetic */ zzboi zzP() {
        return this.zzn;
    }

    final /* synthetic */ zzfga zzQ() {
        return this.zzo;
    }

    final /* synthetic */ boolean zzR() {
        return this.zzp;
    }

    final /* synthetic */ boolean zzS() {
        return this.zzq;
    }

    final /* synthetic */ zzeot zzT() {
        return this.zzr;
    }

    final /* synthetic */ boolean zzU() {
        return this.zzs;
    }

    final /* synthetic */ Bundle zzV() {
        return this.zzt;
    }

    final /* synthetic */ AtomicLong zzW() {
        return this.zzu;
    }

    public final zzfgm zzX(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        this.zzv = zzcsVar;
        return this;
    }

    final /* synthetic */ com.google.android.gms.ads.internal.client.zzcs zzY() {
        return this.zzv;
    }

    public final zzfgm zza(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zza = zzmVar;
        return this;
    }

    public final com.google.android.gms.ads.internal.client.zzm zzb() {
        return this.zza;
    }

    public final zzfgm zzc(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzb = zzrVar;
        return this;
    }

    public final zzfgm zzd(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzfgm zze(boolean z) {
        this.zzq = z;
        return this;
    }

    public final com.google.android.gms.ads.internal.client.zzr zzf() {
        return this.zzb;
    }

    public final zzfgm zzg(String str) {
        this.zzc = str;
        return this;
    }

    public final String zzh() {
        return this.zzc;
    }

    public final zzfgm zzi(com.google.android.gms.ads.internal.client.zzga zzgaVar) {
        this.zzd = zzgaVar;
        return this;
    }

    public final zzfga zzj() {
        return this.zzo;
    }

    public final zzfgm zzk(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzfgm zzl(int i) {
        this.zzm = i;
        return this;
    }

    public final zzfgm zzm(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzfgm zzn(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzfgm zzo(zzbhx zzbhxVar) {
        this.zzh = zzbhxVar;
        return this;
    }

    public final zzfgm zzp(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzi = zzxVar;
        return this;
    }

    public final zzfgm zzq(zzboi zzboiVar) {
        this.zzn = zzboiVar;
        this.zzd = new com.google.android.gms.ads.internal.client.zzga(false, true, false);
        return this;
    }

    public final zzfgm zzr(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zza();
            this.zzl = publisherAdViewOptions.zzb();
        }
        return this;
    }

    public final zzfgm zzs(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzfgm zzt(zzeot zzeotVar) {
        this.zzr = zzeotVar;
        return this;
    }

    public final zzfgm zzu(boolean z) {
        this.zzs = true;
        return this;
    }

    public final zzfgm zzv(Bundle bundle) {
        this.zzt = bundle;
        return this;
    }

    public final long zzw() {
        return this.zzu.get();
    }

    public final zzfgm zzx(long j) {
        this.zzu.set(j);
        return this;
    }

    public final zzfgm zzy(zzfgn zzfgnVar) {
        this.zzo.zza(zzfgnVar.zzp.zza);
        this.zza = zzfgnVar.zzd;
        this.zzb = zzfgnVar.zzf;
        this.zzv = zzfgnVar.zzv;
        this.zzc = zzfgnVar.zzg;
        this.zzd = zzfgnVar.zza;
        this.zzf = zzfgnVar.zzh;
        this.zzg = zzfgnVar.zzi;
        this.zzh = zzfgnVar.zzj;
        this.zzi = zzfgnVar.zzk;
        zzs(zzfgnVar.zzm);
        zzr(zzfgnVar.zzn);
        this.zzp = zzfgnVar.zzq;
        this.zzq = zzfgnVar.zzr;
        this.zzr = zzfgnVar.zzc;
        this.zzs = zzfgnVar.zzs;
        this.zzt = zzfgnVar.zzt;
        this.zzu.set(zzfgnVar.zzu.get());
        return this;
    }

    public final zzfgn zzz() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzfgn(this, null);
    }
}
