package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlg extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzly zzc;
    final /* synthetic */ zzhk zzd;
    final /* synthetic */ String zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzlg(zzly zzlyVar, zzhk zzhkVar, String str, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzlyVar;
        this.zzd = zzhkVar;
        this.zze = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzlg(this.zzc, this.zzd, this.zze, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzlg) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005f, code lost:
    
        if (com.google.android.recaptcha.internal.zzhj.zzb(r1, (com.google.android.recaptcha.internal.zzhf) r7, r6) != r0) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.zzb
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L1f
            if (r1 == r4) goto L1b
            if (r1 == r2) goto L13
            kotlin.ResultKt.throwOnFailure(r7)
            goto L62
        L13:
            java.lang.Object r1 = r6.zza
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L51
        L1b:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L2f
        L1f:
            kotlin.ResultKt.throwOnFailure(r7)
            com.google.android.recaptcha.internal.zzly r7 = r6.zzc
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.zzb = r4
            java.lang.Object r7 = r7.zzv(r1)
            if (r7 == r0) goto L65
        L2f:
            android.webkit.WebView r7 = (android.webkit.WebView) r7
            r7.clearCache(r4)
            com.google.android.recaptcha.internal.zzhk r1 = r6.zzd
            com.google.android.recaptcha.internal.zzly r7 = r6.zzc
            java.lang.String r4 = r6.zze
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.zza = r1
            r6.zzb = r2
            com.google.android.recaptcha.internal.zzli r2 = new com.google.android.recaptcha.internal.zzli
            r2.<init>(r7, r4, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            com.google.android.recaptcha.internal.zzhf r7 = new com.google.android.recaptcha.internal.zzhf
            r4 = 26
            r7.<init>(r4, r2, r3)
            if (r7 == r0) goto L65
        L51:
            com.google.android.recaptcha.internal.zzhf r7 = (com.google.android.recaptcha.internal.zzhf) r7
            r2 = r6
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r6.zza = r3
            r3 = 3
            r6.zzb = r3
            java.lang.Object r7 = com.google.android.recaptcha.internal.zzhj.zzb(r1, r7, r2)
            if (r7 != r0) goto L62
            goto L65
        L62:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzlg.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
