package com.bytedance.sdk.component.mo.qdl;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.jyq;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class mml {
    public static final mml qdl = new mml();

    public void qdl(qdl qdlVar, Context context) {
        ud(qdlVar, context);
        jpc.wd().qdl(context);
        jpc.wd().qdl(qdlVar.to());
        jpc.wd().ud(qdlVar.wd());
        jpc.wd().lnr(qdlVar.jpc());
        jpc.wd().qdl(qdlVar.ud());
        jpc.wd().mml(qdlVar.tvp());
        jpc.wd().mzz(qdlVar.mo());
        jpc.wd().qdl(qdlVar.qdl() == null ? com.bytedance.sdk.component.mo.qdl.qdl.qdl.mzz.qdl : qdlVar.qdl());
        jpc.wd().ud(qdlVar.rq());
        jpc.wd().qdl(qdlVar.mml());
        jpc.wd().qdl(qdlVar.lnr());
        jpc.wd().qdl(qdlVar.mzz());
        com.bytedance.sdk.component.mo.qdl.ud.lnr.lnr.qdl(qdlVar.exu());
        com.bytedance.sdk.component.mo.qdl.ud.lnr.lnr.ud(qdlVar.fs());
        qdl(qdlVar);
    }

    private void qdl(qdl qdlVar) {
        Executor executorMzz;
        if (Looper.myLooper() != Looper.getMainLooper() && com.bytedance.sdk.component.mo.qdl.lnr.qdl.ud()) {
            com.bytedance.sdk.component.mo.qdl.lnr.qdl.qdl();
            return;
        }
        mzz mzzVarMml = qdlVar.mml();
        if (mzzVarMml == null || !com.bytedance.sdk.component.mo.qdl.lnr.qdl.ud() || (executorMzz = mzzVarMml.mzz()) == null) {
            return;
        }
        executorMzz.execute(new Runnable() { // from class: com.bytedance.sdk.component.mo.qdl.mml.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.mo.qdl.lnr.qdl.qdl();
            }
        });
    }

    public void qdl(boolean z) {
        jpc.wd().qdl(z);
    }

    private void ud(qdl qdlVar, Context context) {
        lnr.qdl(context, "context == null");
        lnr.qdl(qdlVar, "AdLogConfig == null");
        lnr.qdl(qdlVar.mml(), "AdLogDepend ==null");
    }

    private boolean qdl(Context context, mzz mzzVar) {
        if (context == null || mzzVar == null) {
            return false;
        }
        if (mzzVar.mo() == 2) {
            return true;
        }
        if (mzzVar.mo() == 1) {
            return mzzVar.exu();
        }
        try {
            return jyq.qdl(context);
        } catch (Throwable th) {
            th.getMessage();
            return true;
        }
    }

    public void qdl() {
        final mzz mzzVarJtx = jpc.wd().jtx();
        if (mzzVarJtx == null || jpc.wd().mo() == null || mzzVarJtx.mml() == null) {
            return;
        }
        if (jpc.wd().ud()) {
            if (qdl(jpc.wd().mo(), mzzVarJtx)) {
                jpc.wd().tvp();
                return;
            } else if (lnr()) {
                mzzVarJtx.mml().execute(new com.bytedance.sdk.component.mo.qdl.mzz.mzz(TtmlNode.START) { // from class: com.bytedance.sdk.component.mo.qdl.mml.2
                    @Override // java.lang.Runnable
                    public void run() {
                        mml.this.qdl(mzzVarJtx.mo());
                    }
                });
                return;
            } else {
                qdl(mzzVarJtx.mo());
                return;
            }
        }
        jpc.wd().tvp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(int i) {
        if (i == 0) {
            com.bytedance.sdk.component.mo.qdl.ud.ud.qdl.qdl();
        } else if (i == 1) {
            com.bytedance.sdk.component.mo.qdl.ud.ud.ud.qdl();
        }
    }

    public void ud() {
        final mzz mzzVarJtx = jpc.wd().jtx();
        if (mzzVarJtx == null || jpc.wd().mo() == null || mzzVarJtx.mml() == null) {
            return;
        }
        if (jpc.wd().ud()) {
            if (qdl(jpc.wd().mo(), mzzVarJtx)) {
                jpc.wd().rq();
                return;
            } else if (lnr()) {
                mzzVarJtx.mml().execute(new com.bytedance.sdk.component.mo.qdl.mzz.mzz("stop") { // from class: com.bytedance.sdk.component.mo.qdl.mml.3
                    @Override // java.lang.Runnable
                    public void run() {
                        mml.this.ud(mzzVarJtx.mo());
                    }
                });
                return;
            } else {
                ud(mzzVarJtx.mo());
                return;
            }
        }
        jpc.wd().rq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(int i) {
        if (i == 0) {
            com.bytedance.sdk.component.mo.qdl.ud.ud.qdl.ud();
        } else if (i == 1) {
            com.bytedance.sdk.component.mo.qdl.ud.ud.ud.ud();
        }
    }

    public void qdl(com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar) {
        ud(qdlVar);
    }

    private boolean lnr() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void ud(final com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar) {
        final mzz mzzVarJtx = jpc.wd().jtx();
        if (qdlVar == null || mzzVarJtx == null || jpc.wd().mo() == null || mzzVarJtx.mml() == null) {
            return;
        }
        if (jpc.wd().ud()) {
            if (qdl(jpc.wd().mo(), mzzVarJtx)) {
                jpc.wd().qdl(qdlVar);
                return;
            }
            lnr();
            if (lnr()) {
                mzzVarJtx.mml().execute(new com.bytedance.sdk.component.mo.qdl.mzz.mzz("dispatchEvent") { // from class: com.bytedance.sdk.component.mo.qdl.mml.4
                    @Override // java.lang.Runnable
                    public void run() {
                        mml.this.qdl(qdlVar, mzzVarJtx.mo());
                    }
                });
                return;
            } else {
                qdl(qdlVar, mzzVarJtx.mo());
                return;
            }
        }
        jpc.wd().qdl(qdlVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar, int i) {
        if (i == 0) {
            com.bytedance.sdk.component.mo.qdl.ud.ud.qdl.qdl(qdlVar);
        } else if (i == 1) {
            com.bytedance.sdk.component.mo.qdl.ud.ud.ud.qdl(qdlVar);
        }
    }

    public void qdl(final String str, final List<String> list, final boolean z, Map<String, String> map, final int i, final String str2) {
        final mzz mzzVarJtx = jpc.wd().jtx();
        if (mzzVarJtx == null || jpc.wd().mo() == null || mzzVarJtx.mml() == null) {
            return;
        }
        if (mzzVarJtx.jpc()) {
            if (mzzVarJtx.mo() == 1) {
                if (list == null || list.isEmpty()) {
                    return;
                }
            } else if (mzzVarJtx.mo() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
                return;
            }
            if (jpc.wd().ud() && !qdl(jpc.wd().mo(), mzzVarJtx)) {
                if (lnr()) {
                    mzzVarJtx.mml().execute(new com.bytedance.sdk.component.mo.qdl.mzz.mzz("trackFailed") { // from class: com.bytedance.sdk.component.mo.qdl.mml.5
                        @Override // java.lang.Runnable
                        public void run() {
                            mml.this.qdl(str, (List<String>) list, z, mzzVarJtx.mo(), i, str2);
                        }
                    });
                    return;
                } else {
                    qdl(str, list, z, mzzVarJtx.mo(), i, str2);
                    return;
                }
            }
            jpc.wd().qdl(str, list, z, map, i, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(String str, List<String> list, boolean z, int i, int i2, String str2) {
        if (i == 0) {
            com.bytedance.sdk.component.mo.qdl.ud.ud.qdl.qdl(str, list, z);
        } else if (i == 1) {
            com.bytedance.sdk.component.mo.qdl.ud.ud.ud.qdl(str, list, z, i2, str2);
        }
    }

    public void qdl(final String str, final boolean z) {
        final mzz mzzVarJtx = jpc.wd().jtx();
        if (mzzVarJtx == null || jpc.wd().mo() == null || mzzVarJtx.mml() == null || !mzzVarJtx.jpc()) {
            return;
        }
        if (mzzVarJtx.mo() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (!jpc.wd().ud() || qdl(jpc.wd().mo(), mzzVarJtx)) {
            jpc.wd().qdl(str, z);
        } else if (lnr()) {
            mzzVarJtx.mml().execute(new com.bytedance.sdk.component.mo.qdl.mzz.mzz("trackFailed") { // from class: com.bytedance.sdk.component.mo.qdl.mml.6
                @Override // java.lang.Runnable
                public void run() {
                    mml.this.qdl(str, mzzVarJtx.mo(), z);
                }
            });
        } else {
            qdl(str, mzzVarJtx.mo(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(String str, int i, boolean z) {
        if (i == 0) {
            com.bytedance.sdk.component.mo.qdl.ud.ud.qdl.qdl(str);
        } else if (i == 1) {
            com.bytedance.sdk.component.mo.qdl.ud.ud.ud.qdl(str, z);
        }
    }
}
