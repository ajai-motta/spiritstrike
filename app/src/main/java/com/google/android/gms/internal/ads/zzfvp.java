package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfvp implements zzifh {
    private final zzifq zza;

    private zzfvp(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzfvp zza(zzifq zzifqVar) {
        return new zzfvp(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = ((zzcjt) this.zza).zza();
        Intrinsics.checkNotNullParameter(context, "context");
        DataStore dataStoreCreate$default = DataStoreFactory.create$default(DataStoreFactory.INSTANCE, zzfvn.zza, null, null, null, new Function0() { // from class: com.google.android.gms.internal.ads.zzfvo
            @Override // kotlin.jvm.functions.Function0
            public final /* synthetic */ Object invoke() {
                return DataStoreFile.dataStoreFile(context, "ad_quality_data.pb");
            }
        }, 14, null);
        zzifp.zzb(dataStoreCreate$default);
        return dataStoreCreate$default;
    }
}
