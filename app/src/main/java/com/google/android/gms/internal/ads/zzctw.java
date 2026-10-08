package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzctw implements zzekw {
    public final List zza;

    public zzctw(zzcto zzctoVar) {
        this.zza = Collections.singletonList(zzgui.zza(zzctoVar));
    }

    public zzctw(List list) {
        this.zza = list;
    }

    public static zzehk zza(zzejq zzejqVar) {
        return new zzehl(zzejqVar, zzctv.zza);
    }

    public static zzehk zzb(zzehk zzehkVar) {
        return new zzehl(zzehkVar, zzctu.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzekw
    public final void zzm() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzgui.zzr((ListenableFuture) it.next(), new zzctt(this), zzguz.zza());
        }
    }
}
