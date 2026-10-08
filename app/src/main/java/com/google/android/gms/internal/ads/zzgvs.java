package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgvs implements zzgwf {
    private static final Charset zza = Charset.forName("UTF-8");
    private final InputStream zzb;

    private zzgvs(InputStream inputStream) {
        this.zzb = inputStream;
    }

    public static zzgvs zza(String str) {
        return new zzgvs(new ByteArrayInputStream(str.getBytes(zza)));
    }

    private static int zzc(zzhtg zzhtgVar) throws IOException {
        if (!(zzhtgVar instanceof zzhtk)) {
            throw new IOException("invalid key id: not a JSON primitive");
        }
        if (!zzhtgVar.zzg().zzc()) {
            throw new IOException("invalid key id: not a JSON number");
        }
        try {
            long jZzc = zzhdv.zzc(zzhtgVar.zzg().zzh());
            if (jZzc > 4294967295L || jZzc < -2147483648L) {
                throw new IOException("invalid key id");
            }
            return (int) jZzc;
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014d  */
    @Override // com.google.android.gms.internal.ads.zzgwf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzhlg zzb() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgvs.zzb():com.google.android.gms.internal.ads.zzhlg");
    }
}
