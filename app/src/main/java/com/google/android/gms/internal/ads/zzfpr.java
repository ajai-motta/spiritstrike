package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfpr extends zzfpu {
    private static final zzfpr zzb = new zzfpr();

    private zzfpr() {
    }

    public static zzfpr zza() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfpu
    public final boolean zzb() {
        Iterator it = zzfps.zza().zzf().iterator();
        while (it.hasNext()) {
            View viewZzi = ((zzfoy) it.next()).zzi();
            if (viewZzi != null && viewZzi.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfpu
    public final void zzc(boolean z) {
        Iterator it = zzfps.zza().zze().iterator();
        while (it.hasNext()) {
            ((zzfoy) it.next()).zzg().zzf(z);
        }
    }
}
