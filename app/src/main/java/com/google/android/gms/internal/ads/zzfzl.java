package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfzl {
    private final zzifb zza;
    private final zzifb zzb;
    private final ExecutorService zzc;
    private final zzifb zzd;
    private ListenableFuture zze = null;

    zzfzl(zzifb zzifbVar, zzifb zzifbVar2, ExecutorService executorService, zzifb zzifbVar3) {
        this.zza = zzifbVar;
        this.zzb = zzifbVar2;
        this.zzc = executorService;
        this.zzd = zzifbVar3;
    }

    public final synchronized ListenableFuture zza() {
        ListenableFuture listenableFuture = this.zze;
        if (listenableFuture != null) {
            return listenableFuture;
        }
        Set set = (Set) this.zzb.zzb();
        ArrayList arrayList = new ArrayList(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzfzj) it.next()).zza());
        }
        zzgjd zzgjdVar = (zzgjd) this.zzd.zzb();
        ListenableFuture listenableFutureZzk = zzgui.zzk(zzgui.zzm(arrayList), zzfzk.zza, this.zzc);
        zzgjdVar.zze(2, listenableFutureZzk);
        this.zze = listenableFutureZzk;
        Iterator it2 = ((Set) this.zza.zzb()).iterator();
        while (it2.hasNext()) {
            ((zzfzj) it2.next()).zza();
        }
        ListenableFuture listenableFuture2 = this.zze;
        listenableFuture2.getClass();
        return listenableFuture2;
    }

    public final synchronized ListenableFuture zzb() {
        ListenableFuture listenableFuture;
        listenableFuture = this.zze;
        listenableFuture.getClass();
        return listenableFuture;
    }
}
