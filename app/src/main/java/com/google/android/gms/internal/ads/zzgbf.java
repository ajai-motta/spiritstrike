package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgbf {
    private final zzgus zza;
    private final zzgbk zzb;
    private final Set zzc;
    private final String zzd;
    private final zzauc zze;
    private final zzgcd zzf;
    private final zzgjd zzg;

    zzgbf(zzgus zzgusVar, zzgbk zzgbkVar, zzgcd zzgcdVar, zzfyq zzfyqVar, String str, zzauc zzaucVar, zzifw zzifwVar, zzifw zzifwVar2, zzifw zzifwVar3, zzgjd zzgjdVar) {
        this.zza = zzgusVar;
        this.zzb = zzgbkVar;
        this.zzd = str;
        this.zzf = zzgcdVar;
        this.zze = zzaucVar;
        this.zzg = zzgjdVar;
        int iOrdinal = zzfyqVar.ordinal();
        if (iOrdinal == 0) {
            this.zzc = ((zzift) zzifwVar).zzb();
        } else if (iOrdinal == 1) {
            this.zzc = ((zzift) zzifwVar2).zzb();
        } else {
            if (iOrdinal != 2) {
                throw new IllegalStateException();
            }
            this.zzc = ((zzift) zzifwVar3).zzb();
        }
    }

    final ListenableFuture zza() {
        if (!this.zzb.zzc()) {
            return zzgui.zza(Integer.toString(7));
        }
        if (!this.zzf.zzb()) {
            return zzgui.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzgbe
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzb();
                }
            }, this.zza);
        }
        Set set = this.zzc;
        ArrayList arrayList = new ArrayList(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(this.zza.zzc((zzgdg) it.next()));
        }
        return zzgui.zzn(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzgbc
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        }, zzguz.zza());
    }

    final /* synthetic */ String zzb() {
        return this.zzb.zzg(16384, this.zzd);
    }

    final /* synthetic */ String zzc() {
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzgbd
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzd();
            }
        };
        zzgjb zzgjbVarZza = this.zzg.zza(101);
        try {
            zzgjbVarZza.zza();
            Object objCall = callable.call();
            zzgjbVarZza.zzc();
            return (String) objCall;
        } finally {
        }
    }

    final /* synthetic */ String zzd() {
        zzauz zzauzVar = (zzauz) this.zze.zzbu();
        String str = this.zzd;
        zzgbk zzgbkVar = this.zzb;
        try {
            return Base64.encodeToString(((zzavq) zzgbkVar.zzf(zzauzVar.zzaN(), str).zzbu()).zzaN(), 11);
        } catch (IllegalArgumentException unused) {
            return zzgbkVar.zzg(4096, str);
        }
    }
}
