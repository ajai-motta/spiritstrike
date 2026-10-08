package com.bykv.vk.openvk.qdl.qdl.ud.qdl.ud;

import android.content.Context;
import com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl;
import com.bytedance.sdk.component.ud.qdl.fs;
import com.bytedance.sdk.component.ud.qdl.rq;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ud {
    private File mml;
    private File mzz;
    private Context qdl;
    private com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr ud;
    private volatile boolean lnr = false;
    private final List<qdl.InterfaceC0176qdl> mo = new ArrayList();
    private volatile boolean wd = false;

    public ud(Context context, com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar) {
        this.mml = null;
        this.mzz = null;
        this.qdl = context;
        this.ud = lnrVar;
        this.mml = com.bykv.vk.openvk.qdl.qdl.ud.mml.ud.ud(lnrVar.mzz(), lnrVar.yt());
        this.mzz = com.bykv.vk.openvk.qdl.qdl.ud.mml.ud.lnr(lnrVar.mzz(), lnrVar.yt());
    }

    public void qdl(qdl.InterfaceC0176qdl interfaceC0176qdl) {
        if (this.wd) {
            synchronized (qdl.InterfaceC0176qdl.class) {
                this.mo.add(interfaceC0176qdl);
            }
            return;
        }
        this.mo.add(interfaceC0176qdl);
        if (ud()) {
            this.ud.jpc(1);
            qdl(this.ud, 200);
            lnr.qdl(this.ud);
        } else {
            this.wd = true;
            this.ud.jpc(0);
            lnr();
        }
    }

    private boolean ud() {
        if (this.mzz.exists()) {
            return true;
        }
        if (!this.ud.exu()) {
            if (this.mml.length() >= this.ud.mo()) {
                return true;
            }
            if (this.ud.mml() > 0 && this.mml.length() >= this.ud.mml()) {
                return true;
            }
        }
        return false;
    }

    private void lnr() {
        rq.qdl qdlVar;
        if (com.bykv.vk.openvk.qdl.qdl.qdl.lnr.mml() != null) {
            qdlVar = com.bykv.vk.openvk.qdl.qdl.qdl.lnr.mml().ud();
        } else {
            qdlVar = new rq.qdl("v_preload");
        }
        qdlVar.qdl(this.ud.exc(), TimeUnit.MILLISECONDS).ud(this.ud.aaj(), TimeUnit.MILLISECONDS).lnr(this.ud.jyq(), TimeUnit.MILLISECONDS);
        rq rqVarQdl = qdlVar.qdl();
        fs.qdl qdlVar2 = new fs.qdl();
        final long length = this.mml.length();
        int iMo = this.ud.mo();
        boolean zExu = this.ud.exu();
        int iMml = this.ud.mml();
        if (iMml > 0) {
            if (iMml >= this.ud.fs()) {
                zExu = true;
            } else {
                iMo = iMml;
            }
        }
        qdlVar2.qdl("videoPreload").qdl(6);
        if (zExu) {
            qdlVar2.qdl("RANGE", "bytes=" + length + "-").ud(this.ud.jtx()).qdl().ud();
        } else {
            qdlVar2.qdl("RANGE", "bytes=" + length + "-" + iMo).ud(this.ud.jtx()).qdl().ud();
        }
        rqVarQdl.qdl(qdlVar2.ud()).qdl(new com.bytedance.sdk.component.ud.qdl.lnr() { // from class: com.bykv.vk.openvk.qdl.qdl.ud.qdl.ud.ud.1
            @Override // com.bytedance.sdk.component.ud.qdl.lnr
            public void qdl(com.bytedance.sdk.component.ud.qdl.ud udVar, IOException iOException) {
                ud udVar2 = ud.this;
                udVar2.qdl(udVar2.ud, 601, iOException.getMessage());
                lnr.qdl(ud.this.ud);
            }

            /* JADX WARN: Removed duplicated region for block: B:66:0x015b A[Catch: all -> 0x0172, TryCatch #1 {all -> 0x0172, blocks: (B:64:0x014e, B:66:0x015b, B:67:0x015f), top: B:73:0x014e }] */
            @Override // com.bytedance.sdk.component.ud.qdl.lnr
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void qdl(com.bytedance.sdk.component.ud.qdl.ud r18, com.bytedance.sdk.component.ud.qdl.rdp r19) throws java.io.IOException {
                /*
                    Method dump skipped, instruction units count: 423
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.qdl.qdl.ud.qdl.ud.ud.AnonymousClass1.qdl(com.bytedance.sdk.component.ud.qdl.ud, com.bytedance.sdk.component.ud.qdl.rdp):void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr qdl() {
        return this.ud;
    }

    public void qdl(boolean z) {
        this.lnr = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i) {
        synchronized (qdl.InterfaceC0176qdl.class) {
            for (qdl.InterfaceC0176qdl interfaceC0176qdl : this.mo) {
                if (interfaceC0176qdl != null) {
                    interfaceC0176qdl.qdl(lnrVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i, String str) {
        synchronized (qdl.InterfaceC0176qdl.class) {
            for (qdl.InterfaceC0176qdl interfaceC0176qdl : this.mo) {
                if (interfaceC0176qdl != null) {
                    interfaceC0176qdl.qdl(lnrVar, i, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i) {
        synchronized (qdl.InterfaceC0176qdl.class) {
            for (qdl.InterfaceC0176qdl interfaceC0176qdl : this.mo) {
                if (interfaceC0176qdl != null) {
                    interfaceC0176qdl.ud(lnrVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mml() {
        try {
            this.mzz.delete();
            this.mml.delete();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mzz() {
        try {
            if (this.mml.renameTo(this.mzz)) {
                return;
            }
            throw new IOException("Error renaming file " + this.mml + " to " + this.mzz + " for completion!");
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
