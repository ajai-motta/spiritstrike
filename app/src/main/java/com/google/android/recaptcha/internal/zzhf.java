package com.google.android.recaptcha.internal;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhf {
    private final Function2 zza;
    private final Integer zzb;
    private final int zzc;

    public zzhf(int i, Function2 function2, Integer num) {
        this.zzc = i;
        this.zza = function2;
        this.zzb = num;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zza(com.google.android.recaptcha.internal.zzhk r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzhe
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzhe r0 = (com.google.android.recaptcha.internal.zzhe) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzhe r0 = new com.google.android.recaptcha.internal.zzhe
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            com.google.android.recaptcha.internal.zzgr r6 = r0.zzd
            r0 = r6
            com.google.android.recaptcha.internal.zzgr r0 = (com.google.android.recaptcha.internal.zzgr) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: com.google.android.recaptcha.internal.zzcg -> L2e
            goto L51
        L2e:
            r7 = move-exception
            goto L59
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.ResultKt.throwOnFailure(r7)
            int r7 = r5.zzc
            java.lang.Integer r2 = r5.zzb
            com.google.android.recaptcha.internal.zzgr r4 = new com.google.android.recaptcha.internal.zzgr
            r4.<init>(r6, r7, r2)
            kotlin.jvm.functions.Function2 r6 = r5.zza     // Catch: com.google.android.recaptcha.internal.zzcg -> L56
            r0.zzd = r4     // Catch: com.google.android.recaptcha.internal.zzcg -> L56
            r0.zzc = r3     // Catch: com.google.android.recaptcha.internal.zzcg -> L56
            java.lang.Object r7 = r6.invoke(r4, r0)     // Catch: com.google.android.recaptcha.internal.zzcg -> L56
            if (r7 == r1) goto L55
            r6 = r4
        L51:
            r6.zzb()     // Catch: com.google.android.recaptcha.internal.zzcg -> L2e
            return r7
        L55:
            return r1
        L56:
            r6 = move-exception
            r7 = r6
            r6 = r4
        L59:
            r6.zzc(r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzhf.zza(com.google.android.recaptcha.internal.zzhk, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
