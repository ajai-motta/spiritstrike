package com.bytedance.sdk.openadsdk.aaj;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    private int mml;
    private qdl mzz;
    private jpc ud;
    private ScheduledExecutorService qdl = null;
    private long lnr = 0;

    public interface qdl {
    }

    public ud(jpc jpcVar, int i) {
        this.ud = jpcVar;
        this.mml = i;
    }

    public void qdl(long j) {
        this.lnr = j;
    }

    public void qdl(int i) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.qdl = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aaj.ud.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                long unused = ud.this.lnr;
                if (System.currentTimeMillis() - ud.this.lnr > ud.this.mml) {
                    ud.this.qdl.shutdown();
                    if (ud.this.ud != null) {
                        ud.this.ud.ud(0, "Automatic detection of stuck");
                    }
                    if (ud.this.mzz != null) {
                        qdl unused2 = ud.this.mzz;
                    }
                }
            }
        }, 0L, i, TimeUnit.MILLISECONDS);
    }

    public void qdl() {
        ScheduledExecutorService scheduledExecutorService = this.qdl;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    public boolean ud() {
        ScheduledExecutorService scheduledExecutorService = this.qdl;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }
}
