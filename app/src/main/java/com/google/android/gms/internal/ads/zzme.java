package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.internal.ads.zzaz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzme implements Handler.Callback, zzaz {
    private final zzbb zza;
    private final zzlz zzb;
    private final zzbd zzc = new zzbd();
    private final zzdm zzd;
    private final zzma zze;
    private final zzmb zzf;
    private final zzmc zzg;
    private final zzmd zzh;

    public zzme(zzbb zzbbVar, zzlz zzlzVar, zzdc zzdcVar, int i, int i2, int i3, int i4) {
        this.zza = zzbbVar;
        this.zzb = zzlzVar;
        this.zzd = zzdcVar.zzd(zzbbVar.zzd(), this);
        this.zze = new zzma(this, i);
        this.zzf = new zzmb(this, i2);
        this.zzg = new zzmc(this, i3);
        this.zzh = new zzmd(this, i4);
        zzbbVar.zze(this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.zze.zza();
            return true;
        }
        if (i == 2) {
            this.zzf.zza();
            return true;
        }
        if (i == 3) {
            this.zzg.zza();
            return true;
        }
        if (i != 4) {
            return false;
        }
        this.zzh.zza();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zza(zzbb zzbbVar, zzay zzayVar) {
        this.zze.zza();
        this.zzf.zza();
        this.zzg.zza();
        this.zzh.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzb(zzbf zzbfVar, int i) {
        zzaz.CC.$default$zzb(this, zzbfVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzc(zzak zzakVar, int i) {
        zzaz.CC.$default$zzc(this, zzakVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzd(zzbn zzbnVar) {
        zzaz.CC.$default$zzd(this, zzbnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zze(zzan zzanVar) {
        zzaz.CC.$default$zze(this, zzanVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzf(boolean z) {
        zzaz.CC.$default$zzf(this, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzg(zzax zzaxVar) {
        zzaz.CC.$default$zzg(this, zzaxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzh(boolean z, int i) {
        zzaz.CC.$default$zzh(this, z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzi(int i) {
        zzaz.CC.$default$zzi(this, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzj(boolean z, int i) {
        zzaz.CC.$default$zzj(this, z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzk(int i) {
        zzaz.CC.$default$zzk(this, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzl(boolean z) {
        zzaz.CC.$default$zzl(this, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzm(zzau zzauVar) {
        zzaz.CC.$default$zzm(this, zzauVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzn(zzau zzauVar) {
        zzaz.CC.$default$zzn(this, zzauVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzo(zzba zzbaVar, zzba zzbaVar2, int i) {
        zzaz.CC.$default$zzo(this, zzbaVar, zzbaVar2, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzp(zzav zzavVar) {
        zzaz.CC.$default$zzp(this, zzavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzq(int i) {
        zzaz.CC.$default$zzq(this, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzr(float f) {
        zzaz.CC.$default$zzr(this, f);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzs(boolean z) {
        zzaz.CC.$default$zzs(this, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzt(zzbv zzbvVar) {
        zzaz.CC.$default$zzt(this, zzbvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public /* synthetic */ void zzu(int i, int i2) {
        zzaz.CC.$default$zzu(this, i, i2);
    }

    public final void zzv() {
        this.zzd.zzl(null);
        this.zza.zzf(this);
    }

    final /* synthetic */ zzbb zzw() {
        return this.zza;
    }

    final /* synthetic */ zzlz zzx() {
        return this.zzb;
    }

    final /* synthetic */ zzbd zzy() {
        return this.zzc;
    }

    final /* synthetic */ zzdm zzz() {
        return this.zzd;
    }
}
