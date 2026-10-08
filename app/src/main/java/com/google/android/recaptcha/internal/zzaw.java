package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaw extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzhk zzc;
    final /* synthetic */ zzba zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaw(zzhk zzhkVar, zzba zzbaVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzhkVar;
        this.zzd = zzbaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzaw(this.zzc, this.zzd, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzaw) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzhk zzhkVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zzb;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                zzhkVar = this.zzc;
                zzba zzbaVar = this.zzd;
                zzbo zzboVar = zzbaVar.zza;
                String str = zzbaVar.zzd;
                zzaw zzawVar = this;
                this.zza = zzhkVar;
                this.zzb = 1;
                obj = new zzhg(new zzbb(zzboVar, str, null));
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    ResultKt.throwOnFailure(obj);
                    zzba zzbaVar2 = this.zzd;
                    zzyu zzyuVarZzf = zzyx.zzf();
                    zzyv zzyvVarZzf = zzyw.zzf();
                    zzyvVarZzf.zzw((String) obj);
                    zzyuVarZzf.zzf((zzyw) zzyvVarZzf.zzk());
                    return zzas.zzb(zzbaVar2, (zzyx) zzyuVarZzf.zzk());
                }
                zzhkVar = (zzhk) this.zza;
                ResultKt.throwOnFailure(obj);
            }
            this.zza = null;
            this.zzb = 2;
            obj = ((zzhg) obj).zza(zzhkVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            zzba zzbaVar22 = this.zzd;
            zzyu zzyuVarZzf2 = zzyx.zzf();
            zzyv zzyvVarZzf2 = zzyw.zzf();
            zzyvVarZzf2.zzw((String) obj);
            zzyuVarZzf2.zzf((zzyw) zzyvVarZzf2.zzk());
            return zzas.zzb(zzbaVar22, (zzyx) zzyuVarZzf2.zzk());
        } catch (Exception e) {
            throw new zzcg(zzce.zzb, zzcd.zzaa, e.getMessage(), e);
        }
    }
}
