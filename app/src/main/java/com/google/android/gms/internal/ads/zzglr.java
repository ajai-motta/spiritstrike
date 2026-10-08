package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzglr implements zzgme {
    protected zzglr() {
    }

    public static zzglr zzc(char c) {
        return new zzglo(c);
    }

    @Override // com.google.android.gms.internal.ads.zzgme
    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c);
}
