package com.google.android.recaptcha.internal;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzae extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzhk zzc;
    final /* synthetic */ zzar zzd;
    final /* synthetic */ String zze;
    final /* synthetic */ List zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzae(zzhk zzhkVar, zzar zzarVar, String str, List list, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzhkVar;
        this.zzd = zzarVar;
        this.zze = str;
        this.zzf = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzae(this.zzc, this.zzd, this.zze, this.zzf, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzae) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
    
        if (r6 == r0) goto L14;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.zzb
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 == r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3f
        Lf:
            java.lang.Object r1 = r5.zza
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L2d
        L17:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.recaptcha.internal.zzhk r1 = r5.zzc
            com.google.android.recaptcha.internal.zzar r6 = r5.zzd
            java.lang.String r3 = r5.zze
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.zza = r1
            r5.zzb = r2
            java.lang.Object r6 = r6.zzc(r3, r4)
            if (r6 == r0) goto L49
        L2d:
            com.google.android.recaptcha.internal.zzhg r6 = (com.google.android.recaptcha.internal.zzhg) r6
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 0
            r5.zza = r3
            r3 = 2
            r5.zzb = r3
            java.lang.Object r6 = r6.zza(r1, r2)
            if (r6 != r0) goto L3f
            goto L49
        L3f:
            java.util.List r0 = r5.zzf
            com.google.android.recaptcha.internal.zzat r6 = (com.google.android.recaptcha.internal.zzat) r6
            r0.add(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L49:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzae.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
