package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgsf extends zzgsa {
    private final File zza;
    private final zzgpo zzb;

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        String strValueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(length + 19 + String.valueOf(strValueOf).length() + 1);
        sb.append("Files.asByteSink(");
        sb.append(string);
        sb.append(", ");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgsa
    public final /* bridge */ /* synthetic */ OutputStream zza() throws IOException {
        return new FileOutputStream(this.zza, this.zzb.contains(zzgse.APPEND));
    }

    /* synthetic */ zzgsf(File file, zzgse[] zzgseVarArr, byte[] bArr) {
        file.getClass();
        this.zza = file;
        this.zzb = zzgpo.zzp(zzgseVarArr);
    }
}
