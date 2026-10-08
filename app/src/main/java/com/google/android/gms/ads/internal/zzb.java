package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbwr;
import com.google.android.gms.internal.ads.zzbzt;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzbzt zzc;
    private final zzbwr zzd = new zzbwr(false, Collections.emptyList());

    public zzb(Context context, zzbzt zzbztVar, zzbwr zzbwrVar) {
        this.zza = context;
        this.zzc = zzbztVar;
    }

    private final boolean zzd() {
        zzbzt zzbztVar = this.zzc;
        return (zzbztVar != null && zzbztVar.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final boolean zzb() {
        return !zzd() || this.zzb;
    }

    public final void zzc(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzbzt zzbztVar = this.zzc;
            if (zzbztVar != null) {
                zzbztVar.zze(str, null, 3);
                return;
            }
            zzbwr zzbwrVar = this.zzd;
            if (!zzbwrVar.zza || (list = zzbwrVar.zzb) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String strReplace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    Context context = this.zza;
                    zzt.zzc();
                    com.google.android.gms.ads.internal.util.zzs.zzP(context, "", strReplace);
                }
            }
        }
    }
}
