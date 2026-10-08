package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaClient;
import com.google.android.recaptcha.RecaptchaTasksClient;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeq implements RecaptchaClient, RecaptchaTasksClient {
    private static final Regex zza = new Regex("^[a-zA-Z0-9/_]{1,100}$");
    private final zzdw zzb;
    private final String zzc;
    private final zzhh zzd;
    private final Lazy zze;

    public zzeq(zzdw zzdwVar, String str, zzhh zzhhVar) {
        this.zzb = zzdwVar;
        this.zzc = str;
        this.zzd = zzhhVar;
        int i = zzby.zza;
        this.zze = LazyKt.lazy(zzep.zza);
    }

    public static final /* synthetic */ void zzd(zzeq zzeqVar, long j, RecaptchaAction recaptchaAction) throws zzcg {
        zzcg zzcgVar = !zza.matches(recaptchaAction.getAction()) ? new zzcg(zzce.zzg, zzcd.zzh, null, null, 12, null) : null;
        if (j < 5000) {
            zzcgVar = new zzcg(zzce.zzb, zzcd.zzI, null, null, 12, null);
        }
        if (zzcgVar != null) {
            throw zzcgVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zze(com.google.android.recaptcha.RecaptchaAction r11, long r12, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.google.android.recaptcha.internal.zzek
            if (r0 == 0) goto L13
            r0 = r14
            com.google.android.recaptcha.internal.zzek r0 = (com.google.android.recaptcha.internal.zzek) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzek r0 = new com.google.android.recaptcha.internal.zzek
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r14)
            goto L4b
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            kotlin.ResultKt.throwOnFailure(r14)
            com.google.android.recaptcha.internal.zzhh r14 = r10.zzd
            com.google.android.recaptcha.internal.zzem r2 = new com.google.android.recaptcha.internal.zzem
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r12
            r8 = r11
            r4.<init>(r5, r6, r8, r9)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.zzc = r3
            java.lang.Object r14 = r2.invoke(r14, r0)
            if (r14 != r1) goto L4b
            return r1
        L4b:
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r11 = r14.getValue()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzeq.zze(com.google.android.recaptcha.RecaptchaAction, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.recaptcha.RecaptchaClient
    /* JADX INFO: renamed from: execute-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo5051execute0E7RQCE(com.google.android.recaptcha.RecaptchaAction r5, long r6, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.google.android.recaptcha.internal.zzei
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.recaptcha.internal.zzei r0 = (com.google.android.recaptcha.internal.zzei) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzei r0 = new com.google.android.recaptcha.internal.zzei
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r5 = r8.getValue()
            goto L43
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.zzc = r3
            java.lang.Object r5 = r4.zze(r5, r6, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzeq.mo5051execute0E7RQCE(com.google.android.recaptcha.RecaptchaAction, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.recaptcha.RecaptchaClient
    /* JADX INFO: renamed from: execute-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo5052executegIAlus(com.google.android.recaptcha.RecaptchaAction r5, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.google.android.recaptcha.internal.zzej
            if (r0 == 0) goto L13
            r0 = r6
            com.google.android.recaptcha.internal.zzej r0 = (com.google.android.recaptcha.internal.zzej) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzej r0 = new com.google.android.recaptcha.internal.zzej
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.zzc = r3
            r2 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r5 = r4.mo5051execute0E7RQCE(r5, r2, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzeq.mo5052executegIAlus(com.google.android.recaptcha.RecaptchaAction, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.google.android.recaptcha.RecaptchaTasksClient
    public final Task<String> executeTask(RecaptchaAction recaptchaAction) {
        return zzbv.zza(BuildersKt__Builders_commonKt.async$default(((zzcr) this.zze.getValue()).zzb(), null, null, new zzen(this, recaptchaAction, 10000L, null), 3, null));
    }

    public final String zzc() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.RecaptchaTasksClient
    public final Task<String> executeTask(RecaptchaAction recaptchaAction, long j) {
        return zzbv.zza(BuildersKt__Builders_commonKt.async$default(((zzcr) this.zze.getValue()).zzb(), null, null, new zzen(this, recaptchaAction, j, null), 3, null));
    }
}
