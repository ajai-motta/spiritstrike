package com.google.android.recaptcha.internal;

import android.os.Build;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzlz {
    public static final Map zza() {
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(-4, zzcd.zzo), TuplesKt.to(-12, zzcd.zzp), TuplesKt.to(-6, zzcd.zzk), TuplesKt.to(-11, zzcd.zzm), TuplesKt.to(-13, zzcd.zzq), TuplesKt.to(-14, zzcd.zzr), TuplesKt.to(-2, zzcd.zzl), TuplesKt.to(-7, zzcd.zzs), TuplesKt.to(-5, zzcd.zzt), TuplesKt.to(-9, zzcd.zzu), TuplesKt.to(-8, zzcd.zzE), TuplesKt.to(-15, zzcd.zzn), TuplesKt.to(-1, zzcd.zzv), TuplesKt.to(-3, zzcd.zzx), TuplesKt.to(-10, zzcd.zzy));
        if (Build.VERSION.SDK_INT >= 26) {
            mapMutableMapOf.put(-16, zzcd.zzw);
        }
        if (Build.VERSION.SDK_INT >= 27) {
            mapMutableMapOf.put(1, zzcd.zzA);
            mapMutableMapOf.put(2, zzcd.zzB);
            mapMutableMapOf.put(0, zzcd.zzC);
            mapMutableMapOf.put(3, zzcd.zzD);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            mapMutableMapOf.put(4, zzcd.zzz);
        }
        return mapMutableMapOf;
    }
}
