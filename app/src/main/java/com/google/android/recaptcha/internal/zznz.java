package com.google.android.recaptcha.internal;

import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zznz extends zzns {
    static final boolean zza;
    static final boolean zzb;
    static final boolean zzc;
    private static final AtomicReference zzd;
    private static final AtomicLong zze;
    private static final ConcurrentLinkedQueue zzf;
    private volatile zznb zzg;

    static {
        zza = Build.FINGERPRINT == null || "robolectric".equals(Build.FINGERPRINT);
        zzb = "goldfish".equals(Build.HARDWARE) || "ranchu".equals(Build.HARDWARE);
        zzc = "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE);
        zzd = new AtomicReference();
        zze = new AtomicLong();
        zzf = new ConcurrentLinkedQueue();
    }

    private zznz(String str) {
        super(str);
        if (zza || zzb) {
            this.zzg = new zznt().zza(zza());
        } else if (zzc) {
            this.zzg = zzoe.zzc().zzb(false).zza(zza());
        } else {
            this.zzg = null;
        }
    }

    public static zznb zzb(String str) {
        AtomicReference atomicReference = zzd;
        if (atomicReference.get() != null) {
            return ((zznu) atomicReference.get()).zza(str);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                char cCharAt = str.charAt(length);
                if (cCharAt != '$') {
                    if (cCharAt == '.') {
                        break;
                    }
                } else {
                    str = str.replace(Typography.dollar, '.');
                    break;
                }
            } else {
                break;
            }
        }
        zznz zznzVar = new zznz(str);
        ConcurrentLinkedQueue concurrentLinkedQueue = zznx.zza;
        concurrentLinkedQueue.offer(zznzVar);
        if (atomicReference.get() != null) {
            while (true) {
                zznz zznzVar2 = (zznz) concurrentLinkedQueue.poll();
                if (zznzVar2 == null) {
                    break;
                }
                zznzVar2.zzg = ((zznu) atomicReference.get()).zza(zznzVar2.zza());
            }
            if (((zzny) zzf.poll()) != null) {
                zze.getAndDecrement();
                throw null;
            }
        }
        return zznzVar;
    }
}
