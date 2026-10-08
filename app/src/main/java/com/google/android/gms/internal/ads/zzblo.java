package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzblo implements zzglu {
    static final /* synthetic */ zzblo zza = new zzblo();

    private /* synthetic */ zzblo() {
    }

    @Override // com.google.android.gms.internal.ads.zzglu
    public final /* synthetic */ Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        zzblx zzblxVar = zzblw.zza;
        if (!((Boolean) zzbgt.zzi.zze()).booleanValue()) {
            return "failure_click_attok";
        }
        com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "prepareClickUrl.attestation1");
        return "failure_click_attok";
    }
}
