package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzll extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzxn zzb;
    final /* synthetic */ zzly zzc;
    private /* synthetic */ Object zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzll(zzxn zzxnVar, zzly zzlyVar, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzxnVar;
        this.zzc = zzlyVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzll zzllVar = new zzll(this.zzb, this.zzc, continuation);
        zzllVar.zzd = obj;
        return zzllVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzll) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        if (((com.google.android.recaptcha.internal.zzhg) r8).zza(r1, r7) != r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0079, code lost:
    
        if (r7.zzc.zzn().zzc(com.google.android.recaptcha.internal.zzmc.zzd, r7) != r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.zza
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 == r2) goto L12
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5f
        L12:
            java.lang.Object r1 = r7.zzd
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4d
        L1a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7b
        L1e:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.zzd
            r1 = r8
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            com.google.android.recaptcha.internal.zzxn r8 = r7.zzb
            boolean r4 = r8.zzV()
            if (r4 == 0) goto L68
            boolean r4 = r8.zzT()
            if (r4 == 0) goto L68
            boolean r4 = r8.zzS()
            if (r4 != 0) goto L3b
            goto L68
        L3b:
            com.google.android.recaptcha.internal.zzly r3 = r7.zzc
            com.google.android.recaptcha.internal.zzly.zzA(r3, r8)
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.zzd = r1
            r7.zza = r2
            java.lang.Object r8 = com.google.android.recaptcha.internal.zzly.zzu(r3, r8)
            if (r8 == r0) goto L9b
        L4d:
            com.google.android.recaptcha.internal.zzhg r8 = (com.google.android.recaptcha.internal.zzhg) r8
            r2 = r7
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 0
            r7.zzd = r3
            r3 = 3
            r7.zza = r3
            java.lang.Object r8 = r8.zza(r1, r2)
            if (r8 != r0) goto L5f
            goto L9b
        L5f:
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            java.lang.Object r8 = kotlin.Result.m7415constructorimpl(r8)
            goto L96
        L68:
            com.google.android.recaptcha.internal.zzly r8 = r7.zzc
            com.google.android.recaptcha.internal.zzdj r8 = r8.zzn()
            com.google.android.recaptcha.internal.zzmc r1 = com.google.android.recaptcha.internal.zzmc.zzd
            r2 = r7
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r7.zza = r3
            java.lang.Object r8 = r8.zzc(r1, r2)
            if (r8 == r0) goto L9b
        L7b:
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE
            com.google.android.recaptcha.internal.zzcg r8 = new com.google.android.recaptcha.internal.zzcg
            com.google.android.recaptcha.internal.zzce r1 = com.google.android.recaptcha.internal.zzce.zzb
            com.google.android.recaptcha.internal.zzcd r2 = com.google.android.recaptcha.internal.zzcd.zzay
            r5 = 12
            r6 = 0
            r3 = 0
            r4 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m7415constructorimpl(r8)
        L96:
            kotlin.Result r8 = kotlin.Result.m7414boximpl(r8)
            return r8
        L9b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzll.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
