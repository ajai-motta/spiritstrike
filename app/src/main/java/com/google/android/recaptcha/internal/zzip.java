package com.google.android.recaptcha.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzip implements zzik {
    private final CoroutineScope zza;
    private final zzjb zzb;
    private final zzkt zzc;
    private final Map zzd;

    public zzip(CoroutineScope coroutineScope, zzjb zzjbVar, zzkt zzktVar, Map map) {
        this.zza = coroutineScope;
        this.zzb = zzjbVar;
        this.zzc = zzktVar;
        this.zzd = map;
    }

    public static final /* synthetic */ void zzf(zzip zzipVar, zzzu zzzuVar, zziz zzizVar) throws zzdm {
        zzmf zzmfVarZzb = zzmf.zzb();
        int iZza = zzizVar.zza();
        zzjt zzjtVar = (zzjt) zzipVar.zzd.get(Integer.valueOf(zzzuVar.zzf()));
        if (zzjtVar == null) {
            throw new zzdm(5, 2, null);
        }
        int iZzg = zzzuVar.zzg();
        zzzt[] zzztVarArr = (zzzt[]) zzzuVar.zzj().toArray(new zzzt[0]);
        zzjtVar.zza(iZzg, zzizVar, (zzzt[]) Arrays.copyOf(zzztVarArr, zzztVarArr.length));
        if (iZza == zzizVar.zza()) {
            zzizVar.zzg(zzizVar.zza() + 1);
        }
        zzmfVarZzb.zzf();
        long jZza = zzmfVarZzb.zza(TimeUnit.MICROSECONDS);
        int i = zzco.zza;
        int iZzk = zzzuVar.zzk();
        if (iZzk == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzco.zza(iZzk - 2, jZza);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzg(List list, zziz zzizVar, Continuation continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new zzim(zzizVar, list, this, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzh(Exception exc, zziz zzizVar, Continuation continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new zzin(exc, zzizVar, this, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    @Override // com.google.android.recaptcha.internal.zzik
    public final void zza(String str) {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzio(new zziz(this.zzb), this, str, null), 3, null);
    }
}
