package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzd extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzg zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzxn zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzd(zzg zzgVar, long j, zzxn zzxnVar, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzgVar;
        this.zzc = j;
        this.zzd = zzxnVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzd zzdVar = new zzd(this.zzb, this.zzc, this.zzd, continuation);
        zzdVar.zze = obj;
        return zzdVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzd) create((zzgr) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (r10 != r0) goto L18;
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
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6c
        L12:
            java.lang.Object r0 = r9.zze
            com.google.android.recaptcha.internal.zzcg r0 = (com.google.android.recaptcha.internal.zzcg) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L80
        L1a:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L1e
            goto L49
        L1e:
            r10 = move-exception
            goto L5a
        L20:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.zze
            com.google.android.recaptcha.internal.zzgr r10 = (com.google.android.recaptcha.internal.zzgr) r10
            com.google.android.recaptcha.internal.zzg r1 = r9.zzb
            boolean r4 = r1.zzi()
            if (r4 == 0) goto L32
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L32:
            long r4 = r9.zzc     // Catch: java.lang.Exception -> L1e
            com.google.android.recaptcha.internal.zzc r6 = new com.google.android.recaptcha.internal.zzc     // Catch: java.lang.Exception -> L1e
            com.google.android.recaptcha.internal.zzxn r7 = r9.zzd     // Catch: java.lang.Exception -> L1e
            r8 = 0
            r6.<init>(r10, r1, r7, r8)     // Catch: java.lang.Exception -> L1e
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Exception -> L1e
            r10 = r9
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch: java.lang.Exception -> L1e
            r9.zza = r3     // Catch: java.lang.Exception -> L1e
            java.lang.Object r10 = kotlinx.coroutines.TimeoutKt.withTimeout(r4, r6, r10)     // Catch: java.lang.Exception -> L1e
            if (r10 == r0) goto L7e
        L49:
            kotlin.Result r10 = (kotlin.Result) r10     // Catch: java.lang.Exception -> L1e
            java.lang.Object r10 = r10.getValue()     // Catch: java.lang.Exception -> L1e
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L1e
            com.google.android.recaptcha.internal.zzg r10 = r9.zzb     // Catch: java.lang.Exception -> L1e
            com.google.android.recaptcha.internal.zzg.zzg(r10, r3)     // Catch: java.lang.Exception -> L1e
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L5a:
            com.google.android.recaptcha.internal.zzg r1 = r9.zzb
            r3 = 0
            com.google.android.recaptcha.internal.zzg.zzg(r1, r3)
            r3 = r9
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r9.zza = r2
            java.lang.Object r10 = r1.zzf(r10, r3)
            if (r10 != r0) goto L6c
            goto L7e
        L6c:
            com.google.android.recaptcha.internal.zzg r1 = r9.zzb
            com.google.android.recaptcha.internal.zzcg r10 = (com.google.android.recaptcha.internal.zzcg) r10
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r9.zze = r10
            r3 = 3
            r9.zza = r3
            java.lang.Object r1 = r1.zzc(r10, r2)
            if (r1 != r0) goto L7f
        L7e:
            return r0
        L7f:
            r0 = r10
        L80:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzd.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
