package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzwb implements zzut {
    private final zzga zza;
    private final zzvm zzb;
    private int zzc;
    private final zzze zzd;

    public zzwb(zzga zzgaVar, final zzadg zzadgVar) {
        zzvm zzvmVar = new zzvm() { // from class: com.google.android.gms.internal.ads.zzwa
            @Override // com.google.android.gms.internal.ads.zzvm
            public final /* synthetic */ zzvn zza(zzpc zzpcVar) {
                return new zztw(zzadgVar);
            }
        };
        zzze zzzeVar = new zzze(-1);
        this.zza = zzgaVar;
        this.zzb = zzvmVar;
        this.zzd = zzzeVar;
        this.zzc = 1048576;
    }

    public final zzwb zza(int i) {
        this.zzc = i;
        return this;
    }

    public final zzwc zzb(zzak zzakVar) {
        zzakVar.zzb.getClass();
        return new zzwc(zzakVar, this.zza, this.zzb, zzrz.zza, this.zzd, this.zzc, 0, null, null, null);
    }
}
