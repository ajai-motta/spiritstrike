package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbuf implements View.OnClickListener {
    final /* synthetic */ zzbuh zza;

    zzbuf(zzbuh zzbuhVar) {
        Objects.requireNonNull(zzbuhVar);
        this.zza = zzbuhVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zzb(true);
    }
}
