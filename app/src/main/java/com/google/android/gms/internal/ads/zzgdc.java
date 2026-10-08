package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgdc extends zzgdh {
    private final Context zza;
    private final Map zzb;

    zzgdc(zzauc zzaucVar, zzgcd zzgcdVar, Map map, Context context, zzgjd zzgjdVar) {
        super("yl2V2fIFd/+gtM2i3wtw7rRydnC7INCVtpRFdnYEC9BkEYS1KI4o6evRDqm9gjRN", "/ngo8an629JW3IpM1KyGjEthGKpic0JTOThCbrYq6ZE=", zzaucVar, zzgcdVar, zzgjdVar.zza(120));
        this.zza = context;
        this.zzb = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgdh
    protected final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        Long lValueOf = -1L;
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                Long l = (Long) method.invoke("", this.zza);
                l.getClass();
                lValueOf = l;
            } else {
                ListenableFuture listenableFuture = (ListenableFuture) this.zzb.get("gs");
                if (listenableFuture != null && listenableFuture.isDone()) {
                    lValueOf = Long.valueOf(((zzauz) listenableFuture.get()).zze());
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
        synchronized (zzaucVar) {
            zzaucVar.zzR(lValueOf.longValue());
        }
    }
}
