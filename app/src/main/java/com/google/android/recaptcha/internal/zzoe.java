package com.google.android.recaptcha.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzoe extends zzns {
    public static final /* synthetic */ int zza = 0;
    private static final Set zzb;
    private static final zznl zzc;
    private static final zzob zzd;

    static {
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzmu.zza, zzmz.zza, zzna.zza)));
        zzb = setUnmodifiableSet;
        zzc = zzno.zza(setUnmodifiableSet).zza();
        zzd = new zzob();
    }

    /* synthetic */ zzoe(String str, String str2, boolean z, int i, Level level, Set set, zznl zznlVar, zzod zzodVar) {
        super(str2);
        if (str2.length() > 23) {
            int i2 = -1;
            for (int length = str2.length() - 1; length >= 0; length--) {
                char cCharAt = str2.charAt(length);
                if (cCharAt == '.' || cCharAt == '$') {
                    i2 = length;
                    break;
                }
            }
            str2 = str2.substring(i2 + 1);
        }
        String strConcat = "".concat(String.valueOf(str2));
        strConcat.substring(0, Math.min(strConcat.length(), 23));
    }

    public static zzob zzc() {
        return zzd;
    }
}
