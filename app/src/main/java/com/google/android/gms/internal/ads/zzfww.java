package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
class zzfww {
    static final String zza = new UUID(0, 0).toString();
    final zzfwv zzb;
    final zzfwu zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;

    zzfww(Context context, String str, String str2, String str3) {
        this.zzb = zzfwv.zza(context);
        this.zzc = zzfwu.zza(context);
        this.zzd = str;
        this.zze = str.concat("_3p");
        this.zzf = str2;
        this.zzg = str2.concat("_3p");
        this.zzh = str3;
    }

    private final String zzh(String str, String str2, String str3) {
        if (str2 != null && str3 != null) {
            StringBuilder sb = new StringBuilder(str.length() + str2.length() + str3.length());
            sb.append(str);
            sb.append(str2);
            sb.append(str3);
            return UUID.nameUUIDFromBytes(sb.toString().getBytes(StandardCharsets.UTF_8)).toString();
        }
        String str4 = this.zzh;
        int length = str4.length();
        String str5 = AbstractJsonLexerKt.NULL;
        String str6 = str2 == null ? AbstractJsonLexerKt.NULL : "not null";
        int length2 = length + 88 + str6.length();
        if (str3 != null) {
            str5 = "not null";
        }
        StringBuilder sb2 = new StringBuilder(length2 + 13 + str5.length());
        sb2.append(str4);
        sb2.append(": Invalid argument to generate PAIDv1 on 3p traffic, Ad ID is not null, package name is ");
        sb2.append(str6);
        sb2.append(", hashKey is ");
        sb2.append(str5);
        throw new IllegalArgumentException(sb2.toString());
    }

    final zzfwt zza(String str, String str2, long j, boolean z) throws IOException {
        if (str != null) {
            try {
                UUID.fromString(str);
                if (!str.equals(zza)) {
                    String strZze = zze(true);
                    String strZzc = this.zzb.zzc("paid_3p_hash_key", null);
                    if (strZze != null && strZzc != null && !strZze.equals(zzh(str, str2, strZzc))) {
                        return zzb(str, str2);
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            return new zzfwt();
        }
        boolean z2 = str != null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            throw new IllegalStateException(this.zzh.concat(": Invalid negative current timestamp. Updating PAID failed"));
        }
        long jZzd = zzd(z2);
        if (jZzd != -1) {
            if (jCurrentTimeMillis < jZzd) {
                this.zzb.zzb(z2 ? this.zzg : this.zzf, Long.valueOf(jCurrentTimeMillis));
            } else if (jCurrentTimeMillis >= jZzd + j) {
                return zzb(str, str2);
            }
        }
        String strZze2 = zze(z2);
        return (strZze2 != null || z) ? new zzfwt(strZze2, zzd(z2)) : zzb(str, str2);
    }

    final zzfwt zzb(String str, String str2) throws IOException {
        if (str == null) {
            return zzf(UUID.randomUUID().toString(), false);
        }
        String string = UUID.randomUUID().toString();
        this.zzb.zzb("paid_3p_hash_key", string);
        return zzf(zzh(str, str2, string), true);
    }

    final void zzc(boolean z) throws IOException {
        String str = z ? this.zzg : this.zzf;
        zzfwv zzfwvVar = this.zzb;
        zzfwvVar.zzf(str);
        zzfwvVar.zzf(z ? this.zze : this.zzd);
    }

    final long zzd(boolean z) {
        return this.zzb.zzd(z ? this.zzg : this.zzf, -1L);
    }

    final String zze(boolean z) {
        return this.zzb.zzc(z ? this.zze : this.zzd, null);
    }

    final zzfwt zzf(String str, boolean z) throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            throw new IllegalStateException(this.zzh.concat(": Invalid negative current timestamp. Updating PAID failed"));
        }
        zzfwv zzfwvVar = this.zzb;
        zzfwvVar.zzb(z ? this.zzg : this.zzf, Long.valueOf(jCurrentTimeMillis));
        zzfwvVar.zzb(z ? this.zze : this.zzd, str);
        return new zzfwt(str, jCurrentTimeMillis);
    }

    final boolean zzg(boolean z) {
        return this.zzb.zzg(this.zzd);
    }
}
