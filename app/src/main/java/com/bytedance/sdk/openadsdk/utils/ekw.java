package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* JADX INFO: loaded from: classes3.dex */
public class ekw implements Thread.UncaughtExceptionHandler {
    public static volatile boolean qdl;
    private String lnr;
    private final Thread.UncaughtExceptionHandler ud = Thread.getDefaultUncaughtExceptionHandler();

    public static ekw qdl() {
        return new ekw();
    }

    private ekw() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        ud();
    }

    private void ud() {
        Context contextQdl = com.bytedance.sdk.openadsdk.core.yt.qdl();
        if (contextQdl == null) {
            return;
        }
        try {
            File file = new File(contextQdl.getFilesDir(), "TTCache");
            file.mkdirs();
            this.lnr = file.getPath();
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        qdl = true;
        com.bytedance.sdk.component.jpc.tvp.sCrashHappened = true;
        com.bytedance.sdk.component.jpc.lnr.mml.lnr = true;
        com.bytedance.sdk.component.jpc.mo.qdl(false);
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            if (string != null) {
                if (string.contains(AdSlot.class.getPackage().getName())) {
                    qdl(thread, th);
                }
            }
        } catch (Throwable unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.ud;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(java.lang.Thread r12, java.lang.Throwable r13) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.ekw.qdl(java.lang.Thread, java.lang.Throwable):void");
    }

    private void lnr() {
        try {
            com.bytedance.sdk.openadsdk.component.wd.qdl.qdl(com.bytedance.sdk.openadsdk.core.yt.qdl());
        } catch (Throwable unused) {
        }
        try {
            com.bytedance.sdk.openadsdk.component.reward.exu.qdl(com.bytedance.sdk.openadsdk.core.yt.qdl()).qdl();
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.component.reward.mzz.qdl(com.bytedance.sdk.openadsdk.core.yt.qdl()).qdl();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.settings.rq.lnr().qdl();
        } catch (Throwable unused4) {
        }
        try {
            com.bytedance.sdk.component.adexpress.qdl.ud.ud.ud();
        } catch (Throwable unused5) {
        }
    }
}
