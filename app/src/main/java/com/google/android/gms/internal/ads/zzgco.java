package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgco extends zzgdh {
    private final Map zza;
    private final Context zzb;
    private final zzfyq zzc;
    private final long zzd;
    private final long zze;

    zzgco(zzauc zzaucVar, zzgcd zzgcdVar, Map map, Context context, zzfyq zzfyqVar, zzfxt zzfxtVar, zzgjd zzgjdVar) {
        super("zRITP136LTX4rFLknKK5s+BdzyKXJ24gjaP1ECV594x04Hyj3q+IVU95/J2vSCm1", "E6K+C1ogZN29OFWU2j1wUPRhMI7Lv3qBcqHzi1vCWW4=", zzaucVar, zzgcdVar, zzgjdVar.zza(113));
        this.zzb = context;
        this.zza = map;
        this.zzc = zzfyqVar;
        this.zzd = zzfxtVar.zzj();
        this.zze = zzfxtVar.zzk();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgdh
    protected final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        zzauz zzauzVar;
        Object[] objArr = (Object[]) method.invoke("", this.zzb, Integer.valueOf(this.zzc.ordinal()));
        objArr.getClass();
        Object[] objArr2 = objArr;
        String strZzb = ExifInterface.LONGITUDE_EAST;
        try {
            ListenableFuture listenableFuture = (ListenableFuture) this.zza.get("gs");
            if (listenableFuture != null && ((Build.VERSION.SDK_INT < 31 || listenableFuture.isDone()) && (zzauzVar = (zzauz) listenableFuture.get(this.zzd, TimeUnit.MILLISECONDS)) != null && zzauzVar.zzb().length() > 1)) {
                strZzb = zzauzVar.zzb();
            }
        } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException unused) {
        }
        if (strZzb.equals(ExifInterface.LONGITUDE_EAST)) {
            try {
                ListenableFuture listenableFuture2 = (ListenableFuture) this.zza.get("ai");
                if (listenableFuture2 != null) {
                    String str = (String) listenableFuture2.get(this.zze, TimeUnit.MILLISECONDS);
                    if (!zzgmu.zzc(str)) {
                        strZzb = str;
                    }
                }
            } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException unused2) {
            }
        }
        Boolean bool = (Boolean) objArr2[5];
        synchronized (zzaucVar) {
            zzaucVar.zzu(((Long) objArr2[0]).longValue());
            zzaucVar.zzt((String) objArr2[1]);
            zzaucVar.zzD((String) objArr2[2]);
            zzaucVar.zzE((String) objArr2[3]);
            zzgrz zzgrzVarZzi = zzgrz.zzn().zzi();
            byte[] bArr = (byte[]) objArr2[4];
            zzaucVar.zzp(zzgrzVarZzi.zzj(bArr, 0, bArr.length));
            zzaucVar.zzo(strZzb);
            if (bool != null) {
                zzaucVar.zzai(true != bool.booleanValue() ? 1 : 2);
            }
        }
    }
}
