package com.google.android.recaptcha.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzos {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzow zzb;

    static {
        zzow zzoxVar;
        int i = 0;
        while (true) {
            if (i >= 2) {
                zzoxVar = new zzox();
                break;
            }
            try {
                zzoxVar = (zzow) Class.forName(zza[i]).asSubclass(zzow.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused) {
                zzoxVar = null;
            }
            if (zzoxVar != null) {
                break;
            } else {
                i++;
            }
        }
        zzb = zzoxVar;
    }

    public static StackTraceElement zza(Class cls, int i) {
        zzot.zza(cls, TypedValues.AttributesType.S_TARGET);
        return zzb.zza(cls, 2);
    }
}
