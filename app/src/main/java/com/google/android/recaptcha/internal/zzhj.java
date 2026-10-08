package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhj {
    public static final Object zza(zzhh zzhhVar, Function2 function2, Continuation continuation) {
        return function2.invoke(new zzhk(zzhhVar), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object zzb(com.google.android.recaptcha.internal.zzhk r4, com.google.android.recaptcha.internal.zzhf r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.google.android.recaptcha.internal.zzhi
            if (r0 == 0) goto L13
            r0 = r6
            com.google.android.recaptcha.internal.zzhi r0 = (com.google.android.recaptcha.internal.zzhi) r0
            int r1 = r0.zzb
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzb = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzhi r0 = new com.google.android.recaptcha.internal.zzhi
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzb
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L40
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.zzb = r3     // Catch: java.lang.Exception -> L40
            java.lang.Object r4 = r5.zza(r4, r0)     // Catch: java.lang.Exception -> L40
            if (r4 != r1) goto L3d
            return r1
        L3d:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L40:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzhj.zzb(com.google.android.recaptcha.internal.zzhk, com.google.android.recaptcha.internal.zzhf, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object zzc(zzgr zzgrVar, zzhg zzhgVar, Continuation continuation) {
        Object objZza = zzhgVar.zza(zzgrVar.zza(), continuation);
        return objZza == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objZza : Unit.INSTANCE;
    }

    public static final Object zzd(int i, int i2, Function2 function2, Continuation continuation) {
        return new zzhf(i, function2, Boxing.boxInt(i2));
    }

    public static final Object zze(zzhk zzhkVar, int i, Function2 function2, Continuation continuation) {
        return new zzhf(i, function2, null).zza(zzhkVar, continuation);
    }
}
