package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgey implements zzftm {
    private final Context zza;
    private final zzghy zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;

    zzgey(Context context, zzfxt zzfxtVar, zzghy zzghyVar) {
        this.zza = context;
        this.zzc = zzfxtVar.zzb();
        this.zzd = zzfxtVar.zzj();
        this.zze = zzfxtVar.zzk();
        this.zzb = zzghyVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zza(Map map) {
        ListenableFuture listenableFuture;
        zzauz zzauzVar;
        map.put("v", this.zzc);
        map.put("t", new Throwable());
        try {
            listenableFuture = (ListenableFuture) map.get("gs");
        } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException unused) {
        }
        String strZzb = (listenableFuture == null || (Build.VERSION.SDK_INT >= 31 && !listenableFuture.isDone()) || (zzauzVar = (zzauz) listenableFuture.get(this.zzd, TimeUnit.MILLISECONDS)) == null || zzauzVar.zzb().length() <= 1) ? ExifInterface.LONGITUDE_EAST : zzauzVar.zzb();
        if (strZzb.equals(ExifInterface.LONGITUDE_EAST)) {
            try {
                ListenableFuture listenableFuture2 = (ListenableFuture) map.get("ai");
                if (listenableFuture2 != null) {
                    String str = (String) listenableFuture2.get(this.zze, TimeUnit.MILLISECONDS);
                    if (!zzgmu.zzc(str)) {
                        strZzb = str;
                    }
                }
            } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException unused2) {
            }
        }
        map.put("int", strZzb);
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    public final Map zzb() {
        Map mapZzb = this.zzb.zzb();
        zza(mapZzb);
        return mapZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    public final Map zzc() {
        Map mapZzc = this.zzb.zzc(this.zza, null);
        zza(mapZzc);
        return mapZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    public final Map zzd() {
        Map mapZzd = this.zzb.zzd();
        zza(mapZzd);
        return mapZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    public final Map zze() {
        HashMap map = new HashMap();
        map.put("t", new Throwable());
        return map;
    }
}
