package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzan implements zzdo {
    private final zzdr zza;

    public zzan(zzdr zzdrVar) {
        this.zza = zzdrVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdt, com.google.android.gms.internal.consent_sdk.zzds
    public final /* bridge */ /* synthetic */ Object zza() {
        return new zzam((Application) this.zza.zza());
    }
}
