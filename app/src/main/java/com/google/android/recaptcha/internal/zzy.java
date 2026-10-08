package com.google.android.recaptcha.internal;

import android.os.Build;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzy extends SuspendLambda implements Function2 {
    final /* synthetic */ zzz zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzy(zzz zzzVar, Continuation continuation) {
        super(2, continuation);
        this.zza = zzzVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzy(this.zza, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzy) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzyu zzyuVarZzf = zzyx.zzf();
        zzz zzzVar = this.zza;
        zzyw zzywVarZzb = zzz.zzb(zzzVar, Build.MANUFACTURER);
        zzyw zzywVarZzb2 = zzz.zzb(zzzVar, Build.MODEL);
        zzyw zzywVarZzb3 = zzz.zzb(zzzVar, Build.DEVICE);
        zzyw zzywVarZzb4 = zzz.zzb(zzzVar, Build.HARDWARE);
        zzyw zzywVarZzb5 = zzz.zzb(zzzVar, Build.FINGERPRINT);
        zzyw zzywVarZzb6 = zzz.zzb(zzzVar, Build.PRODUCT);
        zzyw zzywVarZzb7 = zzz.zzb(zzzVar, Build.BOARD);
        zzyw zzywVarZzb8 = zzz.zzb(zzzVar, Build.BRAND);
        zzyw zzywVarZzb9 = zzz.zzb(zzzVar, ArraysKt.joinToString$default(Build.SUPPORTED_ABIS, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null));
        long j = Build.TIME;
        zzyv zzyvVarZzf = zzyw.zzf();
        zzyvVarZzf.zzv(j);
        zzyuVarZzf.zze(CollectionsKt.listOf((Object[]) new zzyw[]{zzywVarZzb, zzywVarZzb2, zzywVarZzb3, zzywVarZzb4, zzywVarZzb5, zzywVarZzb6, zzywVarZzb7, zzywVarZzb8, zzywVarZzb9, (zzyw) zzyvVarZzf.zzk(), zzz.zzb(zzzVar, Build.ID), zzz.zzb(zzzVar, Build.BOOTLOADER), zzz.zzb(zzzVar, Build.DISPLAY), zzz.zzb(zzzVar, Build.TYPE), zzz.zzb(zzzVar, Build.TAGS)}));
        return zzas.zzb(zzzVar, (zzyx) zzyuVarZzf.zzk());
    }
}
