package com.google.android.recaptcha.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzif {
    private final Lazy zza;

    public zzif() {
        int i = zzby.zza;
        this.zza = LazyKt.lazy(zzie.zza);
    }

    public static final /* synthetic */ zzhm zza(zzif zzifVar) {
        return (zzhm) zzifVar.zza.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object zzc(com.google.android.recaptcha.internal.zzif r4, com.google.android.recaptcha.internal.zzcy r5, com.google.android.recaptcha.internal.zzye r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzic
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzic r0 = (com.google.android.recaptcha.internal.zzic) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzic r0 = new com.google.android.recaptcha.internal.zzic
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            com.google.android.recaptcha.internal.zzid r7 = new com.google.android.recaptcha.internal.zzid
            r2 = 0
            r7.<init>(r4, r5, r6, r2)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r0.zzc = r3
            java.lang.Object r7 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r7, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzif.zzc(com.google.android.recaptcha.internal.zzif, com.google.android.recaptcha.internal.zzcy, com.google.android.recaptcha.internal.zzye, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object zzb(zzcy zzcyVar, zzye zzyeVar, Continuation continuation) {
        return zzc(this, zzcyVar, zzyeVar, continuation);
    }
}
