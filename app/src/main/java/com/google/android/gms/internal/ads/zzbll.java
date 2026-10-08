package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbll implements zzblx {
    zzbll() {
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgy zzcgyVar = (zzcgy) obj;
        if (map.containsKey(TtmlNode.START)) {
            zzcgyVar.zzas(true);
        }
        if (map.containsKey("stop")) {
            zzcgyVar.zzas(false);
        }
    }
}
