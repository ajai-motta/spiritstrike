package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzin extends SuspendLambda implements Function2 {
    final /* synthetic */ Exception zza;
    final /* synthetic */ zziz zzb;
    final /* synthetic */ zzip zzc;
    private /* synthetic */ Object zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzin(Exception exc, zziz zzizVar, zzip zzipVar, Continuation continuation) {
        super(2, continuation);
        this.zza = exc;
        this.zzb = zzizVar;
        this.zzc = zzipVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzin zzinVar = new zzin(this.zza, this.zzb, this.zzc, continuation);
        zzinVar.zzd = obj;
        return zzinVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzin) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzys zzysVarZza;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.zzd;
        Exception exc = this.zza;
        if (exc instanceof zzdm) {
            zzysVarZza = ((zzdm) exc).zza();
            zzysVarZza.zze(this.zzb.zza());
        } else {
            zziz zzizVar = this.zzb;
            zzys zzysVarZzf = zzyt.zzf();
            zzysVarZzf.zze(zzizVar.zza());
            zzysVarZzf.zzr(2);
            zzysVarZzf.zzq(2);
            zzysVarZza = zzysVarZzf;
        }
        zzyt zzytVar = (zzyt) zzysVarZza.zzk();
        zzytVar.zzl();
        zzytVar.zzk();
        Reflection.getOrCreateKotlinClass(exc.getClass()).getSimpleName();
        exc.getMessage();
        zziz zzizVar2 = this.zzb;
        zzcs zzcsVarZzb = zzizVar2.zzb();
        zzcs zzcsVar = zzizVar2.zza;
        if (zzcsVar == null) {
            zzcsVar = null;
        }
        zzww zzwwVarZza = zzhd.zza(zzcsVarZzb, zzcsVar);
        String strZzd = zzizVar2.zzd();
        if (strZzd.length() == 0) {
            strZzd = "recaptcha.m.Main.rge";
        }
        String str = strZzd;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            zzip zzipVar = this.zzc;
            zzpp zzppVarZzh = zzpp.zzh();
            byte[] bArrZzd = zzytVar.zzd();
            String strZzi = zzppVarZzh.zzi(bArrZzd, 0, bArrZzd.length);
            zzpp zzppVarZzh2 = zzpp.zzh();
            byte[] bArrZzd2 = zzwwVarZza.zzd();
            zzipVar.zzb.zzd().zzb(str, (String[]) Arrays.copyOf(new String[]{strZzi, zzppVarZzh2.zzi(bArrZzd2, 0, bArrZzd2.length)}, 2));
        }
        return Unit.INSTANCE;
    }
}
