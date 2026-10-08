package com.google.android.gms.internal.ads;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzglz {
    private final String zza;
    private final zzgly zzb;
    private zzgly zzc;

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzgly zzglyVar = this.zzb.zzb;
        String str = "";
        while (zzglyVar != null) {
            Object obj = zzglyVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r3.length() - 1);
            }
            zzglyVar = zzglyVar.zzb;
            str = ", ";
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public final zzglz zza(Object obj) {
        zzgly zzglyVar = new zzgly();
        this.zzc.zzb = zzglyVar;
        this.zzc = zzglyVar;
        zzglyVar.zza = obj;
        return this;
    }

    /* synthetic */ zzglz(String str, byte[] bArr) {
        zzgly zzglyVar = new zzgly();
        this.zzb = zzglyVar;
        this.zzc = zzglyVar;
        str.getClass();
        this.zza = str;
    }
}
