package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zztj extends zztf {
    private final zztl zza;

    zztj(zztl zztlVar, int i) {
        super(zztlVar.size(), i);
        this.zza = zztlVar;
    }

    @Override // com.google.android.gms.internal.gtm.zztf
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
