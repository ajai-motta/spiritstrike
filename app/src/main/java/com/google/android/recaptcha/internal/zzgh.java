package com.google.android.recaptcha.internal;

import android.app.Application;
import java.util.Locale;
import java.util.MissingResourceException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgh {
    private zzvu zza;
    private final Lazy zzb;

    public zzgh() {
        int i = zzby.zza;
        this.zzb = LazyKt.lazy(zzgg.zza);
    }

    private final Application zzb() {
        return (Application) this.zzb.getValue();
    }

    private static final String zzc() {
        try {
            String iSO3Country = Locale.getDefault().getISO3Country();
            Intrinsics.checkNotNull(iSO3Country);
            return iSO3Country;
        } catch (MissingResourceException unused) {
            return "";
        }
    }

    private static final String zzd() {
        try {
            String iSO3Language = Locale.getDefault().getISO3Language();
            Intrinsics.checkNotNull(iSO3Language);
            return iSO3Language;
        } catch (MissingResourceException unused) {
            return "";
        }
    }

    /* JADX WARN: Path cross not found for [B:8:0x0032, B:12:0x005a], limit reached: 36 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0095 A[Catch: NameNotFoundException -> 0x00f6, TryCatch #0 {NameNotFoundException -> 0x00f6, blocks: (B:19:0x0091, B:21:0x0095, B:22:0x00b8, B:24:0x00bf, B:25:0x00dc), top: B:32:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b8 A[Catch: NameNotFoundException -> 0x00f6, TryCatch #0 {NameNotFoundException -> 0x00f6, blocks: (B:19:0x0091, B:21:0x0095, B:22:0x00b8, B:24:0x00bf, B:25:0x00dc), top: B:32:0x0091 }] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x007e
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.recaptcha.internal.zzwz zza(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzgh.zza(java.lang.String):com.google.android.recaptcha.internal.zzwz");
    }
}
