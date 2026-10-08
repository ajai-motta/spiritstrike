package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfzi {
    private final ExecutorService zza;

    public zzfzi(ExecutorService executorService) {
        this.zza = executorService;
    }

    public final zzfyz zza(File file, zzhxz zzhxzVar, Function function) {
        return new zzfzh(file, this.zza, new zzfzf(zzhxzVar), function);
    }

    public final zzfyz zzb(File file, byte[] bArr, Function function) {
        return new zzfzh(file, this.zza, new zzfzb(bArr), function);
    }
}
