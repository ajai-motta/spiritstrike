package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfll {
    public static boolean zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjH), str);
    }

    public static void zzb(ListenableFuture listenableFuture, zzflc zzflcVar) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            zzgui.zzr(zzgua.zzw(listenableFuture), new zzflh(zzflcVar), zzcbv.zzg);
        }
    }

    public static zzfjx zzc(final zzflc zzflcVar) {
        return new zzfjx() { // from class: com.google.android.gms.internal.ads.zzflk
            @Override // com.google.android.gms.internal.ads.zzfjx
            public final /* synthetic */ Object zza(Object obj) {
                if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
                    zzflcVar.zza();
                }
                return obj;
            }
        };
    }

    public static void zzd(ListenableFuture listenableFuture, zzflm zzflmVar, zzflc zzflcVar) {
        zzh(listenableFuture, zzflmVar, zzflcVar, false);
    }

    public static void zze(ListenableFuture listenableFuture, zzflm zzflmVar, zzflc zzflcVar) {
        zzh(listenableFuture, zzflmVar, zzflcVar, true);
    }

    public static void zzf(ListenableFuture listenableFuture, zzflm zzflmVar, zzflc zzflcVar) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            zzgui.zzr(zzgua.zzw(listenableFuture), new zzflj(zzflmVar, zzflcVar), zzcbv.zzg);
        }
    }

    public static int zzg(zzfgn zzfgnVar) {
        int iZzg = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzg(zzfgnVar) - 1;
        return (iZzg == 0 || iZzg == 1) ? 7 : 23;
    }

    private static void zzh(ListenableFuture listenableFuture, zzflm zzflmVar, zzflc zzflcVar, boolean z) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            zzgui.zzr(zzgua.zzw(listenableFuture), new zzfli(zzflmVar, zzflcVar, z), zzcbv.zzg);
        }
    }
}
