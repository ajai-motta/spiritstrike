package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractC3225x {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.app.Activity r4) {
        /*
            if (r4 == 0) goto L51
            android.view.Window r0 = r4.getWindow()
            if (r0 == 0) goto L51
            boolean r0 = com.unity3d.player.PlatformSupport.PIE_SUPPORT
            if (r0 == 0) goto L51
            boolean r0 = com.unity3d.player.PlatformSupport.VANILLA_ICE_CREAM_SUPPORT
            if (r0 == 0) goto L11
            goto L2f
        L11:
            boolean r0 = com.unity3d.player.PlatformSupport.RED_VELVET_CAKE_SUPPORT
            java.lang.String r1 = "unity.render-outside-safearea"
            r2 = 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L31
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch: java.lang.Exception -> L46
            java.lang.String r3 = r4.getPackageName()     // Catch: java.lang.Exception -> L46
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r3, r2)     // Catch: java.lang.Exception -> L46
            if (r0 == 0) goto L46
            android.os.Bundle r0 = r0.metaData     // Catch: java.lang.Exception -> L46
            boolean r0 = r0.getBoolean(r1)     // Catch: java.lang.Exception -> L46
            if (r0 == 0) goto L46
        L2f:
            r0 = 3
            goto L47
        L31:
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch: java.lang.Exception -> L46
            java.lang.String r3 = r4.getPackageName()     // Catch: java.lang.Exception -> L46
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r3, r2)     // Catch: java.lang.Exception -> L46
            if (r0 == 0) goto L46
            android.os.Bundle r0 = r0.metaData     // Catch: java.lang.Exception -> L46
            boolean r0 = r0.getBoolean(r1)     // Catch: java.lang.Exception -> L46
            goto L47
        L46:
            r0 = 0
        L47:
            android.view.Window r4 = r4.getWindow()
            android.view.WindowManager$LayoutParams r4 = r4.getAttributes()
            r4.layoutInDisplayCutoutMode = r0
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.AbstractC3225x.a(android.app.Activity):void");
    }
}
