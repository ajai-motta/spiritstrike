package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfc extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzhk zzc;
    final /* synthetic */ zzfp zzd;
    final /* synthetic */ zzxn zze;
    final /* synthetic */ long zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfc(zzhk zzhkVar, zzfp zzfpVar, zzxn zzxnVar, long j, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzhkVar;
        this.zzd = zzfpVar;
        this.zze = zzxnVar;
        this.zzf = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzfc(this.zzc, this.zzd, this.zze, this.zzf, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfc) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        if (((com.google.android.recaptcha.internal.zzhg) r10).zza(r1, r9) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.zzb
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 == r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r10)
            goto L4c
        Lf:
            java.lang.Object r1 = r9.zza
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L3a
        L17:
            kotlin.ResultKt.throwOnFailure(r10)
            com.google.android.recaptcha.internal.zzhk r1 = r9.zzc
            com.google.android.recaptcha.internal.zzfp r4 = r9.zzd
            com.google.android.recaptcha.internal.zzxn r5 = r9.zze
            long r6 = r9.zzf
            r10 = r9
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r9.zza = r1
            r9.zzb = r2
            com.google.android.recaptcha.internal.zzfb r10 = new com.google.android.recaptcha.internal.zzfb
            r8 = 0
            r3 = r10
            r3.<init>(r4, r5, r6, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            com.google.android.recaptcha.internal.zzhg r2 = new com.google.android.recaptcha.internal.zzhg
            r2.<init>(r10)
            if (r2 == r0) goto L4f
            r10 = r2
        L3a:
            com.google.android.recaptcha.internal.zzhg r10 = (com.google.android.recaptcha.internal.zzhg) r10
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 0
            r9.zza = r3
            r3 = 2
            r9.zzb = r3
            java.lang.Object r10 = r10.zza(r1, r2)
            if (r10 != r0) goto L4c
            goto L4f
        L4c:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzfc.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
