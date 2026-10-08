package com.bytedance.sdk.openadsdk.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class to {
    public static int qdl() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 0);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.utils.to$1, reason: invalid class name */
    static class AnonymousClass1 implements FilenameFilter {
        private final Pattern qdl = Pattern.compile("^cpu[0-9]+$");

        AnonymousClass1() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.qdl.matcher(str).matches();
        }
    }

    public static int ud() {
        return com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("cpu_count", 0);
    }

    public static int lnr() {
        return com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("cpu_max_frequency", 0);
    }

    public static int mml() {
        return com.bytedance.sdk.openadsdk.core.lnr.qdl().ud("cpu_min_frequency", 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005d A[Catch: Exception -> 0x0060, DONT_GENERATE, TRY_LEAVE, TryCatch #0 {Exception -> 0x0060, blocks: (B:22:0x0058, B:24:0x005d), top: B:36:0x0058 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int qdl(int r7) {
        /*
            r0 = 0
            r1 = 0
            r2 = r1
        L3:
            int r7 = r7 + (-1)
            if (r7 < 0) goto L6e
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L49
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L49
            r4.append(r7)     // Catch: java.lang.Throwable -> L49
            java.lang.String r5 = "/cpufreq/cpuinfo_max_freq"
            r4.append(r5)     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L49
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L49
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L43
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L3e
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L3e
            if (r4 != 0) goto L35
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L3e
            if (r2 <= r0) goto L35
            r0 = r2
        L35:
            r1.close()     // Catch: java.lang.Exception -> L3b
            r3.close()     // Catch: java.lang.Exception -> L3b
        L3b:
            r2 = r1
            r1 = r3
            goto L3
        L3e:
            r2 = move-exception
            r6 = r3
            r3 = r1
            r1 = r6
            goto L4d
        L43:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r3
            r3 = r6
            goto L4d
        L49:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L4d:
            java.lang.String r4 = "CpuUtils"
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L62
            com.bytedance.sdk.component.utils.aaj.lnr(r4, r2)     // Catch: java.lang.Throwable -> L62
            if (r3 == 0) goto L5b
            r3.close()     // Catch: java.lang.Exception -> L60
        L5b:
            if (r1 == 0) goto L60
            r1.close()     // Catch: java.lang.Exception -> L60
        L60:
            r2 = r3
            goto L3
        L62:
            r7 = move-exception
            if (r3 == 0) goto L68
            r3.close()     // Catch: java.lang.Exception -> L6d
        L68:
            if (r1 == 0) goto L6d
            r1.close()     // Catch: java.lang.Exception -> L6d
        L6d:
            throw r7
        L6e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.to.qdl(int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060 A[Catch: Exception -> 0x0063, DONT_GENERATE, TRY_LEAVE, TryCatch #6 {Exception -> 0x0063, blocks: (B:24:0x005b, B:26:0x0060), top: B:50:0x005b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int ud(int r7) {
        /*
            r0 = 0
            r1 = 0
            r2 = r1
        L3:
            int r7 = r7 + (-1)
            if (r7 < 0) goto L71
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L4c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L4c
            r4.append(r7)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r5 = "/cpufreq/cpuinfo_min_freq"
            r4.append(r5)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L4c
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L4c
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L46
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L46
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L41
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L41
            if (r4 != 0) goto L38
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L41
            if (r2 >= r0) goto L35
            goto L37
        L35:
            if (r0 != 0) goto L38
        L37:
            r0 = r2
        L38:
            r1.close()     // Catch: java.lang.Exception -> L3e
            r3.close()     // Catch: java.lang.Exception -> L3e
        L3e:
            r2 = r1
            r1 = r3
            goto L3
        L41:
            r2 = move-exception
            r6 = r3
            r3 = r1
            r1 = r6
            goto L50
        L46:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r3
            r3 = r6
            goto L50
        L4c:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L50:
            java.lang.String r4 = "CpuUtils"
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L65
            com.bytedance.sdk.component.utils.aaj.lnr(r4, r2)     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L5e
            r3.close()     // Catch: java.lang.Exception -> L63
        L5e:
            if (r1 == 0) goto L63
            r1.close()     // Catch: java.lang.Exception -> L63
        L63:
            r2 = r3
            goto L3
        L65:
            r7 = move-exception
            if (r3 == 0) goto L6b
            r3.close()     // Catch: java.lang.Exception -> L70
        L6b:
            if (r1 == 0) goto L70
            r1.close()     // Catch: java.lang.Exception -> L70
        L70:
            throw r7
        L71:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.to.ud(int):int");
    }
}
