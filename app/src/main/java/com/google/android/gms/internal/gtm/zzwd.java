package com.google.android.gms.internal.gtm;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzwd {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzwh zzb;

    static {
        zzwh zzwiVar;
        int i = 0;
        while (true) {
            if (i >= 2) {
                zzwiVar = new zzwi();
                break;
            }
            try {
                zzwiVar = (zzwh) Class.forName(zza[i]).asSubclass(zzwh.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused) {
                zzwiVar = null;
            }
            if (zzwiVar != null) {
                break;
            } else {
                i++;
            }
        }
        zzb = zzwiVar;
    }

    public static StackTraceElement zza(Class cls, int i) {
        zzwe.zza(cls, TypedValues.AttributesType.S_TARGET);
        return zzb.zza(cls, 2);
    }
}
