package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzky implements Application.ActivityLifecycleCallbacks, zzkw {
    final /* synthetic */ zzlj zza;

    zzky(zzlj zzljVar) {
        Objects.requireNonNull(zzljVar);
        this.zza = zzljVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(com.google.android.gms.internal.measurement.zzdd.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzb(com.google.android.gms.internal.measurement.zzdd.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzc(com.google.android.gms.internal.measurement.zzdd.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzd(com.google.android.gms.internal.measurement.zzdd.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zze(com.google.android.gms.internal.measurement.zzdd.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    @Override // com.google.android.gms.measurement.internal.zzkw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.measurement.zzdd r9, android.os.Bundle r10) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzlj r0 = r8.zza     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            com.google.android.gms.measurement.internal.zzic r1 = r0.zzu     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            com.google.android.gms.measurement.internal.zzgu r2 = r1.zzaW()     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            com.google.android.gms.measurement.internal.zzgs r2 = r2.zzk()     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            java.lang.String r3 = "onActivityCreated"
            r2.zza(r3)     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            android.content.Intent r2 = r9.zzc     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            if (r2 == 0) goto L70
            android.net.Uri r3 = r2.getData()     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            if (r3 == 0) goto L24
            boolean r4 = r3.isHierarchical()     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            if (r4 != 0) goto L22
            goto L24
        L22:
            r4 = r3
            goto L3c
        L24:
            android.os.Bundle r3 = r2.getExtras()     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            r4 = 0
            if (r3 == 0) goto L3c
            java.lang.String r5 = "com.android.vending.referral_url"
            java.lang.String r3 = r3.getString(r5)     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            if (r5 != 0) goto L3c
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            goto L22
        L3c:
            if (r4 == 0) goto L70
            boolean r3 = r4.isHierarchical()     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            if (r3 != 0) goto L45
            goto L70
        L45:
            com.google.android.gms.measurement.internal.zzpp r0 = r1.zzk()     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            boolean r0 = r0.zzj(r2)     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            if (r0 == 0) goto L52
            java.lang.String r0 = "gs"
            goto L54
        L52:
            java.lang.String r0 = "auto"
        L54:
            r5 = r0
            java.lang.String r0 = "referrer"
            java.lang.String r6 = r4.getQueryParameter(r0)     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            if (r10 != 0) goto L5f
            r0 = 1
            goto L60
        L5f:
            r0 = 0
        L60:
            r3 = r0
            com.google.android.gms.measurement.internal.zzhz r0 = r1.zzaX()     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            com.google.android.gms.measurement.internal.zzkx r7 = new com.google.android.gms.measurement.internal.zzkx     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            r1 = r7
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            r0.zzj(r7)     // Catch: java.lang.Throwable -> L7a java.lang.RuntimeException -> L7c
            goto L8e
        L70:
            com.google.android.gms.measurement.internal.zzic r0 = r0.zzu
        L72:
            com.google.android.gms.measurement.internal.zzmb r0 = r0.zzs()
            r0.zzn(r9, r10)
            return
        L7a:
            r0 = move-exception
            goto L93
        L7c:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzlj r1 = r8.zza     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.measurement.internal.zzic r1 = r1.zzu     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.measurement.internal.zzgu r1 = r1.zzaW()     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.measurement.internal.zzgs r1 = r1.zzb()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r2 = "Throwable caught in onActivityCreated"
            r1.zzb(r2, r0)     // Catch: java.lang.Throwable -> L7a
        L8e:
            com.google.android.gms.measurement.internal.zzlj r0 = r8.zza
            com.google.android.gms.measurement.internal.zzic r0 = r0.zzu
            goto L72
        L93:
            com.google.android.gms.measurement.internal.zzlj r1 = r8.zza
            com.google.android.gms.measurement.internal.zzic r1 = r1.zzu
            com.google.android.gms.measurement.internal.zzmb r1 = r1.zzs()
            r1.zzn(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzky.zza(com.google.android.gms.internal.measurement.zzdd, android.os.Bundle):void");
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void zzb(com.google.android.gms.internal.measurement.zzdd zzddVar) {
        this.zza.zzu.zzs().zzt(zzddVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void zzc(com.google.android.gms.internal.measurement.zzdd zzddVar) {
        zzic zzicVar = this.zza.zzu;
        zzicVar.zzs().zzq(zzddVar);
        zzoc zzocVarZzh = zzicVar.zzh();
        zzic zzicVar2 = zzocVarZzh.zzu;
        zzicVar2.zzaX().zzj(new zznv(zzocVarZzh, zzicVar2.zzba().elapsedRealtime()));
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void zzd(com.google.android.gms.internal.measurement.zzdd zzddVar) {
        zzic zzicVar = this.zza.zzu;
        zzoc zzocVarZzh = zzicVar.zzh();
        zzic zzicVar2 = zzocVarZzh.zzu;
        zzicVar2.zzaX().zzj(new zznu(zzocVarZzh, zzicVar2.zzba().elapsedRealtime()));
        zzicVar.zzs().zzp(zzddVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void zze(com.google.android.gms.internal.measurement.zzdd zzddVar, Bundle bundle) {
        this.zza.zzu.zzs().zzs(zzddVar, bundle);
    }
}
