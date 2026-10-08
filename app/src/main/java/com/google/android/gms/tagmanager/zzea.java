package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzea extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.RESOLUTION.toString();
    private final Context zzb;

    public zzea(Context context) {
        super(zza, new String[0]);
        this.zzb = context;
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.zzb.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return zzfp.zzb(displayMetrics.widthPixels + "x" + displayMetrics.heightPixels);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
