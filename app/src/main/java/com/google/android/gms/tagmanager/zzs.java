package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.Container;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzs implements zzal {
    final /* synthetic */ Container zza;

    @Override // com.google.android.gms.tagmanager.zzal
    public final Object zza(String str, Map map) {
        Container.FunctionCallMacroCallback functionCallMacroCallbackZza = this.zza.zza(str);
        if (functionCallMacroCallbackZza == null) {
            return null;
        }
        return functionCallMacroCallbackZza.getValue(str, map);
    }
}
