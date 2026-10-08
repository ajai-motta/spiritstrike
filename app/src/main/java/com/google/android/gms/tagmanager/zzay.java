package com.google.android.gms.tagmanager;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzay {
    final String zza;
    final byte[] zzb;

    zzay(String str, byte[] bArr) {
        this.zza = str;
        this.zzb = bArr;
    }

    public final String toString() {
        return "KeyAndSerialized: key = " + this.zza + " serialized hash = " + Arrays.hashCode(this.zzb);
    }
}
