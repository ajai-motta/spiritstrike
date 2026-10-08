package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.Container;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzt implements zzal {
    final /* synthetic */ Container zza;

    @Override // com.google.android.gms.tagmanager.zzal
    public final Object zza(String str, Map map) {
        Container.FunctionCallTagCallback functionCallTagCallbackZzb = this.zza.zzb(str);
        if (functionCallTagCallbackZzb != null) {
            functionCallTagCallbackZzb.execute(str, map);
        }
        return zzfp.zzl();
    }
}
