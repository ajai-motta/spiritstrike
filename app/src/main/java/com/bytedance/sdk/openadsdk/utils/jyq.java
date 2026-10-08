package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class jyq {
    public static final String[] lnr = {"api16-access-ttp.tiktokpangle.us", "api16-access-ttp-b.tiktokpangle.us", "api16-access-ttp.tiktokpangle-b.us", "api16-access-ttp-b.tiktokpangle-b.us"};
    public static int qdl = Integer.MIN_VALUE;
    public static int ud = Integer.MIN_VALUE;

    public static String qdl() {
        if (qdl == Integer.MIN_VALUE) {
            qdl = com.bytedance.sdk.openadsdk.core.tvp.mzz();
        }
        if (qdl < 0) {
            qdl = 0;
        }
        String[] strArr = lnr;
        try {
            return strArr[qdl % strArr.length];
        } catch (Throwable unused) {
            return strArr[0];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0016, code lost:
    
        r2 = com.bytedance.sdk.openadsdk.utils.jyq.qdl + 1;
        com.bytedance.sdk.openadsdk.utils.jyq.qdl = r2;
        com.bytedance.sdk.openadsdk.core.tvp.qdl(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void qdl(java.lang.String r5) {
        /*
            java.lang.Class<com.bytedance.sdk.openadsdk.utils.jyq> r0 = com.bytedance.sdk.openadsdk.utils.jyq.class
            monitor-enter(r0)
            if (r5 != 0) goto L7
            monitor-exit(r0)
            return
        L7:
            r1 = 0
            r2 = r1
        L9:
            java.lang.String[] r3 = com.bytedance.sdk.openadsdk.utils.jyq.lnr     // Catch: java.lang.Throwable -> L23
            int r4 = r3.length     // Catch: java.lang.Throwable -> L23
            if (r2 >= r4) goto L27
            r3 = r3[r2]     // Catch: java.lang.Throwable -> L23
            boolean r3 = r5.contains(r3)     // Catch: java.lang.Throwable -> L23
            if (r3 == 0) goto L20
            int r2 = com.bytedance.sdk.openadsdk.utils.jyq.qdl     // Catch: java.lang.Throwable -> L23
            int r2 = r2 + 1
            com.bytedance.sdk.openadsdk.utils.jyq.qdl = r2     // Catch: java.lang.Throwable -> L23
            com.bytedance.sdk.openadsdk.core.tvp.qdl(r2)     // Catch: java.lang.Throwable -> L23
            goto L27
        L20:
            int r2 = r2 + 1
            goto L9
        L23:
            r2 = move-exception
            r2.getMessage()     // Catch: java.lang.Throwable -> L73
        L27:
            java.lang.String r2 = "/api/ad/union/sdk/settings/"
            boolean r2 = r5.contains(r2)     // Catch: java.lang.Throwable -> L73
            if (r2 != 0) goto L37
            java.lang.String r2 = "/api/ad/union/sdk/strategies/adn"
            boolean r5 = r5.contains(r2)     // Catch: java.lang.Throwable -> L73
            if (r5 == 0) goto L71
        L37:
            int r5 = com.bytedance.sdk.openadsdk.utils.jyq.ud     // Catch: java.lang.Throwable -> L73
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 != r2) goto L43
            int r5 = com.bytedance.sdk.openadsdk.core.tvp.mo()     // Catch: java.lang.Throwable -> L73
            com.bytedance.sdk.openadsdk.utils.jyq.ud = r5     // Catch: java.lang.Throwable -> L73
        L43:
            int r5 = com.bytedance.sdk.openadsdk.utils.jyq.ud     // Catch: java.lang.Throwable -> L73
            int r5 = r5 + 1
            com.bytedance.sdk.openadsdk.utils.jyq.ud = r5     // Catch: java.lang.Throwable -> L73
            r2 = 3
            if (r5 < r2) goto L6c
            com.bytedance.sdk.openadsdk.core.settings.rq r5 = com.bytedance.sdk.openadsdk.core.settings.rq.lnr()     // Catch: java.lang.Throwable -> L73
            java.lang.String r5 = r5.wc()     // Catch: java.lang.Throwable -> L73
            int r2 = com.bytedance.sdk.openadsdk.utils.jyq.ud     // Catch: java.lang.Throwable -> L73
            com.bytedance.sdk.openadsdk.core.settings.rq r3 = com.bytedance.sdk.openadsdk.core.settings.rq.lnr()     // Catch: java.lang.Throwable -> L73
            r3.xx()     // Catch: java.lang.Throwable -> L73
            com.bytedance.sdk.openadsdk.utils.jyq.ud = r1     // Catch: java.lang.Throwable -> L73
            com.bytedance.sdk.openadsdk.bjy.lnr.qdl()     // Catch: java.lang.Throwable -> L73
            java.lang.String r3 = "clear_domain"
            com.bytedance.sdk.openadsdk.utils.jyq$1 r4 = new com.bytedance.sdk.openadsdk.utils.jyq$1     // Catch: java.lang.Throwable -> L73
            r4.<init>()     // Catch: java.lang.Throwable -> L73
            com.bytedance.sdk.openadsdk.bjy.lnr.qdl(r3, r1, r4)     // Catch: java.lang.Throwable -> L73
        L6c:
            int r5 = com.bytedance.sdk.openadsdk.utils.jyq.ud     // Catch: java.lang.Throwable -> L73
            com.bytedance.sdk.openadsdk.core.tvp.ud(r5)     // Catch: java.lang.Throwable -> L73
        L71:
            monitor-exit(r0)
            return
        L73:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.jyq.qdl(java.lang.String):void");
    }

    public static synchronized void ud() {
        if (ud == 0) {
            return;
        }
        ud = 0;
        com.bytedance.sdk.openadsdk.core.tvp.ud(0);
    }

    public static void qdl(com.bytedance.sdk.component.tvp.mo moVar, String str) {
        HashMap map = new HashMap();
        map.put(HttpHeaders.REFERER, TTAdConstant.REQUEST_HEAD_REFERER);
        moVar.qdl(str, map);
    }
}
