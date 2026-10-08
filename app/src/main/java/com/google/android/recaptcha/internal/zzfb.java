package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfb extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzfp zzb;
    final /* synthetic */ zzxn zzc;
    final /* synthetic */ long zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfb(zzfp zzfpVar, zzxn zzxnVar, long j, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzfpVar;
        this.zzc = zzxnVar;
        this.zzd = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzfb zzfbVar = new zzfb(this.zzb, this.zzc, this.zzd, continuation);
        zzfbVar.zze = obj;
        return zzfbVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfb) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (((com.google.android.recaptcha.internal.zzhf) r10).zza(r1, r9) == r0) goto L24;
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
            int r1 = r9.zza
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L26
            if (r1 == r4) goto L1e
            if (r1 != r2) goto L15
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            goto L5c
        L13:
            r10 = move-exception
            goto L5f
        L15:
            java.lang.Object r0 = r9.zze
            com.google.android.recaptcha.internal.zzcg r0 = (com.google.android.recaptcha.internal.zzcg) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L9a
        L1e:
            java.lang.Object r1 = r9.zze
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            goto L4c
        L26:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.zze
            r1 = r10
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            com.google.android.recaptcha.internal.zzfp r10 = r9.zzb
            com.google.android.recaptcha.internal.zzxn r5 = r9.zzc
            java.lang.String r6 = r5.zzP()
            com.google.android.recaptcha.internal.zzfp.zzr(r10, r6)
            com.google.android.recaptcha.internal.zzq r10 = com.google.android.recaptcha.internal.zzfp.zzb(r10)     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            long r6 = r9.zzd     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            r8 = r9
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            r9.zze = r1     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            r9.zza = r4     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            java.lang.Object r10 = r10.zzc(r6, r5, r8)     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            if (r10 == r0) goto L98
        L4c:
            com.google.android.recaptcha.internal.zzhf r10 = (com.google.android.recaptcha.internal.zzhf) r10     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            r9.zze = r3     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            r9.zza = r2     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            java.lang.Object r10 = r10.zza(r1, r5)     // Catch: com.google.android.recaptcha.internal.zzcg -> L13
            if (r10 != r0) goto L5c
            goto L98
        L5c:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L5f:
            com.google.android.recaptcha.internal.zzfp r1 = r9.zzb
            com.google.android.recaptcha.internal.zzcr r2 = com.google.android.recaptcha.internal.zzfp.zzf(r1)
            kotlinx.coroutines.CoroutineScope r2 = r2.zzd()
            kotlin.coroutines.CoroutineContext r2 = r2.getCoroutineContext()
            kotlinx.coroutines.JobKt.cancelChildren$default(r2, r3, r4, r3)
            com.google.android.recaptcha.internal.zzcr r1 = com.google.android.recaptcha.internal.zzfp.zzf(r1)
            kotlinx.coroutines.CoroutineScope r1 = r1.zzd()
            kotlin.coroutines.CoroutineContext r1 = r1.getCoroutineContext()
            kotlinx.coroutines.Job r1 = kotlinx.coroutines.JobKt.getJob(r1)
            kotlin.sequences.Sequence r1 = r1.getChildren()
            java.util.List r1 = kotlin.sequences.SequencesKt.toList(r1)
            java.util.Collection r1 = (java.util.Collection) r1
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r9.zze = r10
            r3 = 3
            r9.zza = r3
            java.lang.Object r1 = kotlinx.coroutines.AwaitKt.joinAll(r1, r2)
            if (r1 != r0) goto L99
        L98:
            return r0
        L99:
            r0 = r10
        L9a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzfb.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
