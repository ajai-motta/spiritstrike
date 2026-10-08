package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbud implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbue zza;

    zzbud(zzbue zzbueVar) {
        Objects.requireNonNull(zzbueVar);
        this.zza = zzbueVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzg("Operation denied by user.");
    }
}
