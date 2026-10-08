package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzayq extends zzazr {
    private static final zzazs zzh = new zzazs();
    private final Context zzi;

    public zzayq(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i, int i2, Context context) {
        super(zzaydVar, "yCCrg1bENISzqqs7fgrfIgqRoB89Hc58RpoZe38mDWknXggRGBdzPAEdsprm/nAh", "ygsxUks9qSJOiPMXEo9qlLCVVsFNNRfyc6WjXaB0M8U=", zzaucVar, i, 29);
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzp(ExifInterface.LONGITUDE_EAST);
        Context context = this.zzi;
        AtomicReference atomicReferenceZza = zzh.zza(context.getPackageName());
        if (atomicReferenceZza.get() == null) {
            synchronized (atomicReferenceZza) {
                if (atomicReferenceZza.get() == null) {
                    atomicReferenceZza.set((String) this.zze.invoke(null, context));
                }
            }
        }
        String str = (String) atomicReferenceZza.get();
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            zzaucVar.zzp(zzavt.zza(str.getBytes(), true));
        }
    }
}
