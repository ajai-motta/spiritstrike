package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzf extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzg zzc;
    final /* synthetic */ String zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzf(long j, zzg zzgVar, String str, Continuation continuation) {
        super(2, continuation);
        this.zzb = j;
        this.zzc = zzgVar;
        this.zzd = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzf zzfVar = new zzf(this.zzb, this.zzc, this.zzd, continuation);
        zzfVar.zze = obj;
        return zzfVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzf) create((zzgr) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                zzgr zzgrVar = (zzgr) this.zze;
                this.zza = 1;
                obj = TimeoutKt.withTimeout(this.zzb, new zze(zzgrVar, this.zzc, this.zzd, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    zzcg zzcgVar = (zzcg) this.zze;
                    ResultKt.throwOnFailure(obj);
                    throw zzcgVar;
                }
                ResultKt.throwOnFailure(obj);
            }
            Object value = ((Result) obj).getValue();
            ResultKt.throwOnFailure(value);
            return (zzxx) value;
        } catch (Exception e) {
            zzcg zzcgVarZza = zzh.zza(e, new zzcg(zzce.zzb, zzcd.zzaa, e.getMessage(), null, 8, null));
            this.zze = zzcgVarZza;
            this.zza = 2;
            if (this.zzc.zze(this.zzd, this.zzb, e, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw zzcgVarZza;
        }
    }
}
