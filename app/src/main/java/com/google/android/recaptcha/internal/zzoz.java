package com.google.android.recaptcha.internal;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzoz implements zzpd {
    zzoz() {
    }

    @Override // com.google.android.recaptcha.internal.zzpd
    public final zzpc zza(CharSequence charSequence, Charset charset) {
        zzpe zzpeVarZzb = zzb();
        byte[] bytes = charSequence.toString().getBytes(charset);
        bytes.getClass();
        ((zzoy) zzpeVarZzb).zza(bytes, 0, bytes.length);
        return zzpeVarZzb.zzb();
    }
}
