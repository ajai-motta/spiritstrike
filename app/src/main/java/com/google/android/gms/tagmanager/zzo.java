package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzo extends zzfn {
    static final String zza;
    private static final String zzb;
    private static final String zzc;
    private static final String zzd;
    private static final String zze;
    private static final Set zzf;
    private final zzn zzg;
    private final Context zzh;

    static {
        String string = com.google.android.gms.internal.gtm.zza.ARBITRARY_PIXEL.toString();
        zzb = string;
        zzc = com.google.android.gms.internal.gtm.zzb.URL.toString();
        zzd = com.google.android.gms.internal.gtm.zzb.ADDITIONAL_PARAMS.toString();
        zze = com.google.android.gms.internal.gtm.zzb.UNREPEATABLE.toString();
        zza = "gtm_" + string + "_unrepeatable";
        zzf = new HashSet();
    }

    public zzo(Context context) {
        zzm zzmVar = new zzm(context);
        super(zzb, zzc);
        this.zzg = zzmVar;
        this.zzh = context;
    }

    private final synchronized boolean zzd(String str) {
        Set set = zzf;
        if (set.contains(str)) {
            return true;
        }
        if (!this.zzh.getSharedPreferences(zza, 0).contains(str)) {
            return false;
        }
        set.add(str);
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzfn
    public final void zzc(Map map) {
        String str = zze;
        String strZzm = map.get(str) != null ? zzfp.zzm(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) map.get(str))) : null;
        if (strZzm == null || !zzd(strZzm)) {
            Uri.Builder builderBuildUpon = Uri.parse(zzfp.zzm(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) map.get(zzc)))).buildUpon();
            com.google.android.gms.internal.gtm.zzap zzapVar = (com.google.android.gms.internal.gtm.zzap) map.get(zzd);
            if (zzapVar != null) {
                Object objZzk = zzfp.zzk(zzapVar);
                if (!(objZzk instanceof List)) {
                    Log.e("GoogleTagManager", "ArbitraryPixel: additional params not a list: not sending partial hit: ".concat(String.valueOf(builderBuildUpon.build().toString())));
                    return;
                }
                for (Object obj : (List) objZzk) {
                    if (!(obj instanceof Map)) {
                        Log.e("GoogleTagManager", "ArbitraryPixel: additional params contains non-map: not sending partial hit: ".concat(String.valueOf(builderBuildUpon.build().toString())));
                        return;
                    }
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        builderBuildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            String string = builderBuildUpon.build().toString();
            zzbc.zzb(((zzm) this.zzg).zza).zza(string);
            zzdc.zzb.zzd("ArbitraryPixel: url = ".concat(String.valueOf(string)));
            if (strZzm != null) {
                synchronized (zzo.class) {
                    zzf.add(strZzm);
                    zzfb.zza(this.zzh, zza, strZzm, "true");
                }
            }
        }
    }
}
