package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhrz {
    public static final zzhrz zza = new zzhrz(new zzhsa());
    public static final zzhrz zzb = new zzhrz(new zzhse());
    public static final zzhrz zzc = new zzhrz(new zzhsg());
    public static final zzhrz zzd = new zzhrz(new zzhsf());
    public static final zzhrz zze;
    public static final zzhrz zzf;
    private final zzhry zzg;

    static {
        new zzhrz(new zzhsb());
        zze = new zzhrz(new zzhsd());
        zzf = new zzhrz(new zzhsc());
    }

    public zzhrz(zzhsh zzhshVar) {
        this.zzg = !zzhcz.zza() ? "The Android Project".equals(System.getProperty("java.vendor")) ? new zzhrv(zzhshVar, null) : new zzhrw(zzhshVar, null) : new zzhrx(zzhshVar, null);
    }

    public static List zza(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public final Object zzb(String str) throws GeneralSecurityException {
        return this.zzg.zza(str);
    }
}
