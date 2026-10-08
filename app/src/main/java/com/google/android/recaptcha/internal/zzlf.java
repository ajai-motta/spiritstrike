package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlf extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzly zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzlf(zzly zzlyVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzlyVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzlf(this.zzc, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzlf) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0075, code lost:
    
        if (r7 == r0) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060 A[PHI: r7
  0x0060: PHI (r7v15 java.lang.Object) = (r7v11 java.lang.Object), (r7v0 java.lang.Object) binds: [B:16:0x005e, B:7:0x0014] A[DONT_GENERATE, DONT_INLINE]] */
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
            java.lang.String r2 = "RN"
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L23
            if (r1 == r5) goto L1f
            if (r1 == r4) goto L17
            kotlin.ResultKt.throwOnFailure(r7)
            if (r1 == r3) goto L60
            goto L78
        L17:
            java.lang.Object r1 = r6.zza
            com.google.android.recaptcha.internal.zzly r1 = (com.google.android.recaptcha.internal.zzly) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L47
        L1f:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L33
        L23:
            kotlin.ResultKt.throwOnFailure(r7)
            com.google.android.recaptcha.internal.zzly r7 = r6.zzc
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.zzb = r5
            java.lang.Object r7 = r7.zzv(r1)
            if (r7 == r0) goto L89
        L33:
            android.webkit.WebView r7 = (android.webkit.WebView) r7
            r7.removeJavascriptInterface(r2)
            com.google.android.recaptcha.internal.zzly r7 = r6.zzc
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.zza = r7
            r6.zzb = r4
            java.lang.Object r7 = r7.zzv(r1)
            if (r7 == r0) goto L89
        L47:
            android.webkit.WebView r7 = (android.webkit.WebView) r7
            android.webkit.WebSettings r7 = r7.getSettings()
            r7.setJavaScriptEnabled(r5)
            com.google.android.recaptcha.internal.zzly r7 = r6.zzc
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4 = 0
            r6.zza = r4
            r6.zzb = r3
            java.lang.Object r7 = r7.zzv(r1)
            if (r7 == r0) goto L89
        L60:
            com.google.android.recaptcha.internal.zzly r1 = r6.zzc
            android.webkit.WebView r7 = (android.webkit.WebView) r7
            com.google.android.recaptcha.internal.zzld r3 = r1.zzr()
            r7.addJavascriptInterface(r3, r2)
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r2 = 4
            r6.zzb = r2
            java.lang.Object r7 = r1.zzv(r7)
            if (r7 != r0) goto L78
            goto L89
        L78:
            com.google.android.recaptcha.internal.zzly r0 = r6.zzc
            android.webkit.WebView r7 = (android.webkit.WebView) r7
            com.google.android.recaptcha.internal.zzle r1 = new com.google.android.recaptcha.internal.zzle
            r1.<init>(r0)
            android.webkit.WebViewClient r1 = (android.webkit.WebViewClient) r1
            r7.setWebViewClient(r1)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L89:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzlf.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
