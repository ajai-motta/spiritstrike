package com.google.android.gms.internal.gtm;

import android.os.Build;
import dalvik.system.VMStack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzvg extends zzvc {
    private static final boolean zza = zza.zza();
    private static final boolean zzb;
    private static final zzvb zzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
    final class zza {
        zza() {
        }

        static boolean zza() {
            return zzvg.zzt();
        }
    }

    static {
        boolean z = true;
        if (Build.FINGERPRINT != null && !"robolectric".equals(Build.FINGERPRINT)) {
            z = false;
        }
        zzb = z;
        zzc = new zzvb() { // from class: com.google.android.gms.internal.gtm.zzvg.1
            @Override // com.google.android.gms.internal.gtm.zzvb
            public zzuh zza(Class<?> cls, int i) {
                return zzuh.zza;
            }

            @Override // com.google.android.gms.internal.gtm.zzvb
            public String zzb(Class cls) {
                StackTraceElement stackTraceElementZza;
                if (zzvg.zza) {
                    try {
                        if (cls.equals(zzvg.zzp())) {
                            return VMStack.getStackClass2().getName();
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!zzvg.zzb || (stackTraceElementZza = zzwd.zza(cls, 1)) == null) {
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

    @Override // com.google.android.gms.internal.gtm.zzvc
    protected zzum zze(String str) {
        return zzvk.zzb(str);
    }

    @Override // com.google.android.gms.internal.gtm.zzvc
    protected zzvb zzh() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzvc
    protected zzvq zzj() {
        return zzvl.zzb();
    }

    @Override // com.google.android.gms.internal.gtm.zzvc
    protected String zzm() {
        return "platform: Android";
    }
}
