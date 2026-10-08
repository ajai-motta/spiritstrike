package com.google.android.gms.internal.measurement;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcf {
    private static final Method zza;
    private static final Method zzb;

    static {
        Method declaredMethod;
        Method declaredMethod2 = null;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                declaredMethod = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
                }
                declaredMethod = null;
            }
        } else {
            declaredMethod = null;
        }
        zza = declaredMethod;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                declaredMethod2 = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
            } catch (NoSuchMethodException unused2) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No myUserId method available");
                }
            }
        }
        zzb = declaredMethod2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zza(android.content.Context r5, android.app.job.JobInfo r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r7 = "jobscheduler"
            java.lang.Object r7 = r5.getSystemService(r7)
            android.app.job.JobScheduler r7 = (android.app.job.JobScheduler) r7
            java.lang.Object r7 = com.google.common.base.Preconditions.checkNotNull(r7)
            android.app.job.JobScheduler r7 = (android.app.job.JobScheduler) r7
            java.lang.reflect.Method r8 = com.google.android.gms.internal.measurement.zzcf.zza
            if (r8 == 0) goto L76
            java.lang.String r8 = "android.permission.UPDATE_DEVICE_STATS"
            int r5 = r5.checkSelfPermission(r8)
            if (r5 != 0) goto L76
            java.lang.reflect.Method r5 = com.google.android.gms.internal.measurement.zzcf.zzb
            r8 = 0
            if (r5 == 0) goto L41
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch: java.lang.reflect.InvocationTargetException -> L30 java.lang.IllegalAccessException -> L32
            java.lang.Object r5 = r5.invoke(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L30 java.lang.IllegalAccessException -> L32
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.reflect.InvocationTargetException -> L30 java.lang.IllegalAccessException -> L32
            if (r5 == 0) goto L41
            int r5 = r5.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L30 java.lang.IllegalAccessException -> L32
            goto L42
        L30:
            r5 = move-exception
            goto L33
        L32:
            r5 = move-exception
        L33:
            r0 = 6
            java.lang.String r1 = "JobSchedulerCompat"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L41
            java.lang.String r0 = "myUserId invocation illegal"
            android.util.Log.e(r1, r0, r5)
        L41:
            r5 = r8
        L42:
            java.lang.String r0 = "UploadAlarm"
            java.lang.String r1 = "com.google.android.gms"
            java.lang.reflect.Method r2 = com.google.android.gms.internal.measurement.zzcf.zza
            if (r2 == 0) goto L71
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            r3[r8] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            r4 = 1
            r3[r4] = r1     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            r1 = 2
            r3[r1] = r5     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            r5 = 3
            r3[r5] = r0     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            java.lang.Object r5 = r2.invoke(r7, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            if (r5 == 0) goto L75
            int r8 = r5.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L69 java.lang.IllegalAccessException -> L6b
            goto L75
        L69:
            r5 = move-exception
            goto L6c
        L6b:
            r5 = move-exception
        L6c:
            java.lang.String r8 = "error calling scheduleAsPackage"
            android.util.Log.e(r0, r8, r5)
        L71:
            int r8 = r7.schedule(r6)
        L75:
            return r8
        L76:
            int r5 = r7.schedule(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcf.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
