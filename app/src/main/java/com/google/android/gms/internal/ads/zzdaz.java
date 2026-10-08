package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdaz extends zzdem implements com.google.android.gms.ads.internal.overlay.zzr {
    public zzdaz(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdA() {
        zzs(zzdas.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdB() {
        zzs(zzdat.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdC() {
        zzs(zzdau.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdD() {
        zzs(zzdav.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdE() {
        zzs(zzdaw.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdX() {
        zzs(zzdar.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdY(final int i) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzday
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((com.google.android.gms.ads.internal.overlay.zzr) obj).zzdY(i);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdt() {
        zzs(zzdao.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdu() {
        zzs(zzdap.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
        zzs(zzdaq.zza);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzh() {
        zzs(zzdax.zza);
    }
}
