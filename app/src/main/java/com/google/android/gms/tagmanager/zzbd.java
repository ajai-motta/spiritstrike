package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbd extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.DEVICE_ID.toString();
    private final Context zzb;

    public zzbd(Context context) {
        super(zza, new String[0]);
        this.zzb = context;
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        String string = Settings.Secure.getString(this.zzb.getContentResolver(), "android_id");
        return string == null ? zzfp.zza() : zzfp.zzb(string);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
