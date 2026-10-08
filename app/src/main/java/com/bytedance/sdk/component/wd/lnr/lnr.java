package com.bytedance.sdk.component.wd.lnr;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    private qdl qdl;
    private ud ud;

    public enum qdl {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    public interface ud {
    }

    private lnr() {
        this.qdl = qdl.OFF;
        this.ud = new com.bytedance.sdk.component.wd.lnr.ud();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.wd.lnr.lnr$lnr, reason: collision with other inner class name */
    private static class C0216lnr {
        private static final lnr qdl = new lnr();
    }

    public static void qdl(qdl qdlVar) {
        synchronized (lnr.class) {
            C0216lnr.qdl.qdl = qdlVar;
        }
    }
}
