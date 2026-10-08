package com.bytedance.sdk.component.adexpress.qdl.ud;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.qdl.lnr.qdl;
import com.bytedance.sdk.component.utils.jyq;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class mzz extends lnr {
    private static File qdl;
    private static volatile mzz ud;
    private AtomicBoolean lnr = new AtomicBoolean(true);
    private AtomicBoolean mml = new AtomicBoolean(false);
    private boolean mzz = false;
    private AtomicBoolean mo = new AtomicBoolean(false);
    private AtomicInteger wd = new AtomicInteger(0);
    private AtomicLong jpc = new AtomicLong();

    public static mzz ud() {
        if (ud == null) {
            synchronized (mzz.class) {
                if (ud == null) {
                    ud = new mzz();
                }
            }
        }
        return ud;
    }

    private mzz() {
        to();
    }

    public void lnr() {
        to();
    }

    private void to() {
        com.bytedance.sdk.component.adexpress.mml.mml.ud(new com.bytedance.sdk.component.jpc.jpc("init") { // from class: com.bytedance.sdk.component.adexpress.qdl.ud.mzz.1
            @Override // java.lang.Runnable
            public void run() {
                jpc.qdl();
                mzz.this.lnr.set(false);
                mzz.this.mml();
                mzz.this.wd();
                if (com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr() == null || !jyq.qdl(com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr().ud()) || com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr() == null) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr().mml();
            }
        }, 10);
    }

    public void mml() {
        com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVarUd = jpc.ud();
        if (qdlVarUd == null || !qdlVarUd.jpc()) {
            return;
        }
        boolean zQdl = qdl(qdlVarUd);
        if (!zQdl) {
            jpc.mml();
        }
        this.mzz = zQdl;
    }

    public boolean qdl(com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar) {
        if (qdlVar == null) {
            return false;
        }
        return qdl(qdlVar.qdl()) || qdl(qdlVar.mzz()) || qdl(qdlVar.mo());
    }

    public boolean mzz() {
        return this.mzz;
    }

    public com.bytedance.sdk.component.adexpress.qdl.lnr.qdl mo() {
        return jpc.ud();
    }

    @Override // com.bytedance.sdk.component.adexpress.qdl.ud.lnr
    public File qdl() {
        return jpc();
    }

    public void wd() {
        qdl(false);
    }

    public void qdl(boolean z) {
        List<qdl.C0201qdl> listQdl;
        boolean z2;
        if (this.lnr.get()) {
            return;
        }
        try {
            if (this.mml.get()) {
                if (z) {
                    this.wd.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z3 = true;
            this.mml.set(true);
            com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVarMzz = com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr().mzz();
            com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVarUd = jpc.ud();
            if (qdlVarMzz != null && qdlVarMzz.jpc()) {
                if (!jpc.ud(qdlVarMzz)) {
                    this.mml.set(false);
                    this.jpc.set(System.currentTimeMillis());
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr() != null) {
                    com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr().lnr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.qdl.ud.mzz.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.mzz.mzz.qdl().ud();
                        }
                    });
                }
                jpc.qdl(qdlVarMzz);
                boolean zQdl = (qdlVarMzz.mzz() == null || TextUtils.isEmpty(qdlVarMzz.mzz().qdl())) ? false : qdl(qdlVarMzz.mzz().qdl());
                if (qdlVarMzz.qdl().size() != 0) {
                    listQdl = qdl(qdlVarMzz, qdlVarUd);
                    z2 = listQdl != null;
                } else {
                    listQdl = null;
                    z2 = zQdl;
                }
                if (!zQdl) {
                    List<qdl.C0201qdl> listUd = ud(qdlVarMzz, qdlVarUd);
                    if (listQdl == null || listUd == null) {
                        listQdl = listUd;
                    } else {
                        listQdl.addAll(listUd);
                    }
                    if (listUd == null) {
                        z3 = false;
                    }
                    if (listUd == null) {
                        this.mml.set(false);
                    }
                    z2 = z3;
                }
                if (z2 && qdl(qdlVarMzz)) {
                    jpc.qdl(qdlVarMzz);
                    jpc.lnr();
                    ud(listQdl);
                }
                mml();
                this.mml.set(false);
                this.jpc.set(System.currentTimeMillis());
                rq();
                return;
            }
            this.mml.set(false);
            qdl(109);
        } catch (Throwable unused) {
        }
    }

    private void rq() {
        if (this.wd.getAndSet(0) <= 0 || System.currentTimeMillis() - this.jpc.get() <= 600000) {
            return;
        }
        wd();
    }

    public static File jpc() {
        if (qdl == null) {
            try {
                File file = new File(new File(mml.qdl(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                qdl = file;
            } catch (Throwable unused) {
            }
        }
        return qdl;
    }

    public void ud(boolean z) {
        this.mo.set(z);
    }

    public void tvp() {
        this.mo.set(true);
        this.mzz = false;
        this.mml.set(false);
    }
}
