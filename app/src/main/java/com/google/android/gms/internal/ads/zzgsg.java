package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgsg {
    public static void zza(byte[] bArr, File file) throws IOException {
        zzgsf zzgsfVar = new zzgsf(file, new zzgse[0], null);
        bArr.getClass();
        OutputStream outputStreamZza = zzgsfVar.zza();
        try {
            outputStreamZza.write(bArr);
            outputStreamZza.close();
        } catch (Throwable th) {
            try {
                outputStreamZza.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void zzb(File file) throws IOException {
        file.getClass();
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException("Unable to create parent directories of ".concat(file.toString()));
        }
    }
}
