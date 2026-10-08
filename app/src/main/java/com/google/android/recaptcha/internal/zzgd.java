package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgd extends SuspendLambda implements Function2 {
    Object zza;
    double zzb;
    int zzc;
    final /* synthetic */ zzge zzd;
    final /* synthetic */ long zze;
    private /* synthetic */ Object zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgd(zzge zzgeVar, long j, Continuation continuation) {
        super(2, continuation);
        this.zzd = zzgeVar;
        this.zze = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzgd zzgdVar = new zzgd(this.zzd, this.zze, continuation);
        zzgdVar.zzf = obj;
        return zzgdVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzgd) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2 A[Catch: zzcg -> 0x0017, PHI: r1 r14
  0x00c2: PHI (r1v8 com.google.android.recaptcha.internal.zzhk) = (r1v7 com.google.android.recaptcha.internal.zzhk), (r1v14 com.google.android.recaptcha.internal.zzhk) binds: [B:33:0x00c0, B:12:0x001e] A[DONT_GENERATE, DONT_INLINE]
  0x00c2: PHI (r14v13 java.lang.Object) = (r14v12 java.lang.Object), (r14v0 java.lang.Object) binds: [B:33:0x00c0, B:12:0x001e] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {zzcg -> 0x0017, blocks: (B:7:0x0012, B:37:0x00d3, B:12:0x001e, B:34:0x00c2, B:15:0x0029, B:32:0x00a9, B:18:0x0038, B:29:0x0094, B:26:0x006d), top: B:45:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzgd.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
