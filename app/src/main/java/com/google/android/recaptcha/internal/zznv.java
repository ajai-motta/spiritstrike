package com.google.android.recaptcha.internal;

import android.os.Build;
import dalvik.system.VMStack;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznv extends zznr {
    private static final boolean zza = zza.zza();
    private static final boolean zzb;
    private static final zznq zzc;

    /* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
    final class zza {
        zza() {
        }

        static boolean zza() {
            return zznv.zzt();
        }
    }

    static {
        boolean z = true;
        if (Build.FINGERPRINT != null && !"robolectric".equals(Build.FINGERPRINT)) {
            z = false;
        }
        zzb = z;
        zzc = new zznq() { // from class: com.google.android.recaptcha.internal.zznv.1
            @Override // com.google.android.recaptcha.internal.zznq
            public zzmw zza(Class<?> cls, int i) {
                return zzmw.zza;
            }

            @Override // com.google.android.recaptcha.internal.zznq
            public String zzb(Class cls) {
                StackTraceElement stackTraceElementZza;
                if (zznv.zza) {
                    try {
                        if (cls.equals(zznv.zzp())) {
                            return VMStack.getStackClass2().getName();
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!zznv.zzb || (stackTraceElementZza = zzos.zza(cls, 1)) == null) {
                    return null;
                }
                return stackTraceElementZza.getClassName();
            }
        };
    }

    static Class<?> zzp() {
        return VMStack.getStackClass2();
    }

    static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzt() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", new Class[0]);
            return zza.class.getName().equals(zzq());
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.google.android.recaptcha.internal.zznr
    protected zznb zze(String str) {
        return zznz.zzb(str);
    }

    @Override // com.google.android.recaptcha.internal.zznr
    protected zznq zzh() {
        return zzc;
    }

    @Override // com.google.android.recaptcha.internal.zznr
    protected zzof zzj() {
        return zzoa.zzb();
    }

    @Override // com.google.android.recaptcha.internal.zznr
    protected String zzm() {
        return "platform: Android";
    }
}
