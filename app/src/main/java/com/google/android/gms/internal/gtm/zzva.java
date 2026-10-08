package com.google.android.gms.internal.gtm;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzva {
    private static final zzvc zza = zzb(zzvc.zzd);

    private static zzvc zzb(String[] strArr) {
        zzvg zzvgVar;
        try {
            zzvgVar = zzvh.zza;
        } catch (NoClassDefFoundError unused) {
            zzvgVar = null;
        }
        if (zzvgVar != null) {
            return zzvgVar;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzvc) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable th) {
                th = th;
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
