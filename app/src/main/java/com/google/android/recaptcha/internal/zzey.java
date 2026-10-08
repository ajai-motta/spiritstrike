package com.google.android.recaptcha.internal;

import android.app.Application;
import android.os.Build;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzey extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzfp zzb;
    final /* synthetic */ zzhk zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzey(zzfp zzfpVar, zzhk zzhkVar, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzfpVar;
        this.zzc = zzhkVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzey(this.zzb, this.zzc, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzey) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i == 0) {
            zzfp zzfpVar = this.zzb;
            String str = zzfpVar.zza;
            String packageName = zzfpVar.zzs().getPackageName();
            String strZza = this.zzc.zza().zza();
            zzci zzciVarZze = zzfp.zze(zzfpVar);
            zzda zzdaVarZzh = zzfp.zzh(zzfpVar);
            Application applicationZzs = zzfpVar.zzs();
            int i2 = Build.VERSION.SDK_INT;
            String strZza2 = zzciVarZze.zza();
            zzzc zzzcVarZzf = zzzd.zzf();
            zzzcVarZzf.zzw(str);
            zzzcVarZzf.zzt(packageName);
            zzzcVarZzf.zzx(zzdaVarZzh.zzd(applicationZzs));
            zzzcVarZzf.zzu("18.7.1");
            zzzcVarZzf.zzv(strZza);
            zzzcVarZzf.zzs(String.valueOf(i2));
            zzzcVarZzf.zzr(strZza2);
            zzzcVarZzf.zzf(zzdaVarZzh.zzb(applicationZzs));
            zzzcVarZzf.zzq(zzdaVarZzh.zzc(applicationZzs));
            zzzcVarZzf.zze(zzdaVarZzh.zza(applicationZzs));
            zzzd zzzdVar = (zzzd) zzzcVarZzf.zzk();
            zzzd zzzdVarZza = zzfp.zzb(zzfpVar).zza();
            zzzc zzzcVar = (zzzc) zzzdVar.zzr();
            zzzcVar.zzh(zzzdVarZza);
            zzzd zzzdVar2 = (zzzd) zzzcVar.zzk();
            this.zza = 1;
            obj = zzfp.zzi(zzfpVar).zzc(zzfp.zzg(zzfpVar).zzb(), zzzdVar2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
