package com.google.android.recaptcha.internal;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgl {
    public static final /* synthetic */ int zza = 0;
    private static final String zzb = UUID.randomUUID().toString();

    public static final String zza() {
        return zzb;
    }

    public static final void zzb(zzwk zzwkVar, String str, zzwa zzwaVar) {
        int i = zzby.zza;
        Lazy lazy = LazyKt.lazy(zzgi.zza);
        Lazy lazy2 = LazyKt.lazy(zzgj.zza);
        if (zzwaVar != null) {
            zzwkVar.zzt(zzwaVar);
        }
        for (zzca zzcaVar : ((zzcc) LazyKt.lazy(zzgk.zza).getValue()).zza()) {
            zzwkVar.zzq(0);
        }
        if (zzwkVar.zzz()) {
            int i2 = zzco.zza;
            int iZze = zzwkVar.zze();
            zzco.zza(iZze + AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH, zzwkVar.zzf() * 1000);
        } else {
            int i3 = zzco.zza;
            int iZzD = zzwkVar.zzD();
            zzco.zza(zzwl.zza(iZzD) + 10000, zzwkVar.zzf() * 1000);
        }
        zzwkVar.zzv(((zzgh) lazy.getValue()).zza(str));
        zzzl zzzlVarZzi = zzzm.zzi();
        zzzlVarZzi.zze(zzwkVar);
        ((zzgs) lazy2.getValue()).zza((zzzm) zzzlVarZzi.zzk());
    }
}
