package com.google.android.recaptcha.internal;

import java.util.TimerTask;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgu extends TimerTask {
    final /* synthetic */ zzgz zza;

    public zzgu(zzgz zzgzVar) {
        this.zza = zzgzVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        try {
            int i = zzby.zza;
            BuildersKt__Builders_commonKt.launch$default(((zzcr) LazyKt.lazy(zzgw.zza).getValue()).zza(), null, null, new zzgv(this.zza, null), 3, null);
        } catch (Exception unused) {
        }
    }
}
