package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhgh extends RuntimeException {
    public zzhgh(String str) {
        super(str);
    }

    public static Object zza(zzhgg zzhggVar) {
        try {
            return zzhggVar.zza();
        } catch (Exception e) {
            throw new zzhgh(e);
        }
    }

    public zzhgh(String str, Throwable th) {
        super(str, th);
    }

    public zzhgh(Throwable th) {
        super(th);
    }
}
