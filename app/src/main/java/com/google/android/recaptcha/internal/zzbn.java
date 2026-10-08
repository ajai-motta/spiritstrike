package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbn extends SuspendLambda implements Function2 {
    Object zza;
    Object zzb;
    int zzc;
    final /* synthetic */ zzbo zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbn(zzbo zzboVar, Continuation continuation) {
        super(2, continuation);
        this.zzd = zzboVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzbn zzbnVar = new zzbn(this.zzd, continuation);
        zzbnVar.zze = obj;
        return zzbnVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbn) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b1, code lost:
    
        if (((com.google.android.recaptcha.internal.zzhg) r13).zza(r1, r12) != r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.zzc
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L2e
            if (r1 == r3) goto L1d
            if (r1 == r2) goto L14
            kotlin.ResultKt.throwOnFailure(r13)
            goto Lb4
        L14:
            java.lang.Object r1 = r12.zze
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto La3
        L1d:
            java.lang.Object r1 = r12.zzb
            com.google.android.recaptcha.internal.zzbo r1 = (com.google.android.recaptcha.internal.zzbo) r1
            java.lang.Object r5 = r12.zza
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r6 = r12.zze
            com.google.android.recaptcha.internal.zzhk r6 = (com.google.android.recaptcha.internal.zzhk) r6
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r6
            goto L4c
        L2e:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.zze
            com.google.android.recaptcha.internal.zzhk r13 = (com.google.android.recaptcha.internal.zzhk) r13
            com.google.android.recaptcha.internal.zzbo r1 = r12.zzd
            kotlinx.coroutines.sync.Mutex r5 = com.google.android.recaptcha.internal.zzbo.zzg(r1)
            r6 = r12
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r12.zze = r13
            r12.zza = r5
            r12.zzb = r1
            r12.zzc = r3
            java.lang.Object r6 = r5.lock(r4, r6)
            if (r6 == r0) goto Lbc
        L4c:
            com.google.android.recaptcha.internal.zzbp r6 = com.google.android.recaptcha.internal.zzbo.zza(r1)     // Catch: java.lang.Throwable -> Lb7
            com.google.android.recaptcha.internal.zzbp r7 = com.google.android.recaptcha.internal.zzbp.zza     // Catch: java.lang.Throwable -> Lb7
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)     // Catch: java.lang.Throwable -> Lb7
            if (r6 != 0) goto L5e
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lb7
            r5.unlock(r4)
            return r13
        L5e:
            com.google.android.recaptcha.internal.zzbp r6 = com.google.android.recaptcha.internal.zzbp.zzb     // Catch: java.lang.Throwable -> Lb7
            com.google.android.recaptcha.internal.zzbo.zzi(r1, r6)     // Catch: java.lang.Throwable -> Lb7
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lb7
            r5.unlock(r4)
            com.google.android.recaptcha.internal.zzbo r1 = r12.zzd
            kotlinx.coroutines.CompletableDeferred r3 = kotlinx.coroutines.CompletableDeferredKt.CompletableDeferred$default(r4, r3, r4)
            r1.zza = r3
            com.google.android.recaptcha.internal.zzcr r3 = com.google.android.recaptcha.internal.zzbo.zzb(r1)
            kotlinx.coroutines.CoroutineScope r5 = r3.zzc()
            com.google.android.recaptcha.internal.zzbm r3 = new com.google.android.recaptcha.internal.zzbm
            r3.<init>(r13, r1, r4)
            r8 = r3
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r7, r8, r9, r10)
            r3 = r12
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r12.zze = r13
            r12.zza = r4
            r12.zzb = r4
            r12.zzc = r2
            com.google.android.recaptcha.internal.zzbj r2 = new com.google.android.recaptcha.internal.zzbj
            r2.<init>(r1, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            com.google.android.recaptcha.internal.zzhg r1 = new com.google.android.recaptcha.internal.zzhg
            r1.<init>(r2)
            if (r1 == r0) goto Lbc
            r11 = r1
            r1 = r13
            r13 = r11
        La3:
            com.google.android.recaptcha.internal.zzhg r13 = (com.google.android.recaptcha.internal.zzhg) r13
            r2 = r12
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r12.zze = r4
            r3 = 3
            r12.zzc = r3
            java.lang.Object r13 = r13.zza(r1, r2)
            if (r13 != r0) goto Lb4
            goto Lbc
        Lb4:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        Lb7:
            r13 = move-exception
            r5.unlock(r4)
            throw r13
        Lbc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbn.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
