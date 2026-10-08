package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.InputEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgam implements zzfzj {
    private final zzfxt zza;
    private final zzgai zzb;
    private final zzgac zzc;
    private final ExecutorService zzd;
    private final zzgjd zze;
    private final AtomicReference zzf = new AtomicReference();

    zzgam(zzfxt zzfxtVar, zzgai zzgaiVar, zzgac zzgacVar, ExecutorService executorService, zzgjd zzgjdVar) {
        this.zza = zzfxtVar;
        this.zzb = zzgaiVar;
        this.zzc = zzgacVar;
        this.zzd = executorService;
        this.zze = zzgjdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    public final ListenableFuture zza() {
        zzgai zzgaiVar = this.zzb;
        zzfxt zzfxtVar = this.zza;
        zzgua zzguaVar = (zzgua) zzgui.zzk(zzgua.zzw(zzgaiVar.zzb(zzfxtVar.zzC(), zzfxtVar.zza())), new zzglu() { // from class: com.google.android.gms.internal.ads.zzgal
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                zzgab zzgabVar = (zzgab) obj;
                this.zza.zzf(zzgabVar);
                return zzgabVar;
            }
        }, zzguz.zza());
        zzgui.zzr(zzguaVar, new zzgak(this), this.zzd);
        return zzguaVar;
    }

    public final ListenableFuture zzb(Context context) {
        return ((zzgab) this.zzf.get()).zzc(context);
    }

    public final ListenableFuture zzc(Context context, String str, View view, Activity activity) {
        return ((zzgab) this.zzf.get()).zzd(context, null, view, activity);
    }

    public final ListenableFuture zzd(Context context, String str, View view, Activity activity) {
        return ((zzgab) this.zzf.get()).zze(context, str, view, null);
    }

    public final void zze(InputEvent inputEvent) {
        zzgab zzgabVar = (zzgab) this.zzf.get();
        if (zzgabVar == null) {
            this.zze.zzb(54);
        } else {
            zzgabVar.zzf(inputEvent);
        }
    }

    final /* synthetic */ zzgab zzf(zzgab zzgabVar) {
        this.zzf.set(zzgabVar);
        return zzgabVar;
    }

    final /* synthetic */ zzgac zzg() {
        return this.zzc;
    }

    public final int zzh() {
        zzgab zzgabVar = (zzgab) this.zzf.get();
        if (zzgabVar == null) {
            return 1;
        }
        return zzgabVar.zzg();
    }
}
