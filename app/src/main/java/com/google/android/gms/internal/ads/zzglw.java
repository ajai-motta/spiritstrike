package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzglw extends zzglt implements Serializable {
    private final Pattern zza;

    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzglt
    public final zzgls zza(CharSequence charSequence) {
        return new zzglv(this.zza.matcher(charSequence));
    }

    zzglw(Pattern pattern) {
        pattern.getClass();
        this.zza = pattern;
    }
}
