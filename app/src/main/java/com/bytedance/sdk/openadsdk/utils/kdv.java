package com.bytedance.sdk.openadsdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.exu.mml.qdl;

/* JADX INFO: loaded from: classes3.dex */
public class kdv implements Handler.Callback, qdl.InterfaceC0231qdl {
    private int fs;
    private boolean jpc;
    private final com.bytedance.sdk.openadsdk.core.model.ljh mml;
    private boolean mo;
    private final com.bytedance.sdk.openadsdk.component.reward.qdl.qdl mzz;
    private int to;
    private boolean tvp;
    private boolean wd;
    private float qdl = 1.0f;
    private int ud = 1000;
    private final Handler lnr = new Handler(Looper.getMainLooper(), this);
    private int rq = 0;

    public boolean qdl() {
        return this.mo;
    }

    public void qdl(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0d);
        if (this.wd && !this.jpc) {
            this.rq = iCeil;
            lnr();
        } else {
            if (this.mo || this.jpc) {
                return;
            }
            this.rq = iCeil;
            this.mo = true;
            ud();
        }
    }

    public kdv(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        this.to = 0;
        this.fs = 0;
        this.mzz = qdlVar;
        this.mml = ljhVar;
        if (ljhVar.mq()) {
            if (ljhVar.qg() >= 0) {
                this.fs = ljhVar.qg();
            } else {
                this.fs = com.bytedance.sdk.openadsdk.core.yt.mml().to(String.valueOf(ljhVar.fz()));
            }
        } else if (ljhVar.nni()) {
            if (ljhVar.ws() >= 0) {
                this.fs = ljhVar.ws();
            } else {
                this.fs = com.bytedance.sdk.openadsdk.core.yt.mml().exc(String.valueOf(ljhVar.fz()));
            }
        }
        this.to = (int) qdlVar.bch.fco();
        com.bytedance.sdk.component.utils.aaj.qdl("TTAD.TopLayoutHelper", "totalTime: " + this.to + ", skipTime=" + this.fs);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1024) {
            int i = this.to - this.rq;
            this.mzz.bch.qdl(((long) this.rq) * 1000);
            com.bytedance.sdk.component.utils.aaj.qdl("TTAD.TopLayoutHelper", "handleMessage: currentTime= " + this.rq + ", mRemainTimeInSeconds=" + i);
            if (i > 0) {
                if (this.mzz.ag instanceof TTRewardVideoActivity) {
                    ((TTRewardVideoActivity) this.mzz.ag).lnr(((long) this.rq) * 1000, this.to);
                }
                boolean z = false;
                if (this.mzz.bqt != null && this.mzz.bqt.qdl() != null) {
                    this.mzz.bqt.qdl().setTime(String.valueOf(i), this.rq, 0, false);
                }
                if (this.mml.mq()) {
                    if (this.mzz.bqt != null) {
                        if (this.mzz.bqt.tvp() && this.fs > 0) {
                            z = true;
                        }
                        this.tvp = z;
                    }
                    if (this.tvp && this.rq >= this.fs && this.mzz.ud.taz() != 5 && this.mzz.ud.taz() != 33) {
                        this.mzz.qdl(true);
                        this.mzz.fco.qdl(String.valueOf(i), TTAdDislikeToast.getSkipText());
                        this.mzz.fco.mzz(true);
                    } else {
                        this.mzz.fco.qdl(String.valueOf(i), null);
                    }
                } else if (this.mml.nni() && (this.mzz.bqt.tvp() || this.mzz.ud.au())) {
                    if (this.mzz.ag instanceof TTFullScreenVideoActivity) {
                        ((TTFullScreenVideoActivity) this.mzz.ag).lnr(this.rq);
                    }
                    this.mzz.fco.mml(true);
                    this.mzz.fco.qdl(String.valueOf(i), null);
                }
                this.rq++;
                if (this.mzz.bch.lnr()) {
                    com.bytedance.sdk.openadsdk.core.model.rc rcVarEu = this.mzz.ud.eu();
                    if (rcVarEu != null) {
                        float fQdl = rcVarEu.qdl();
                        this.qdl = fQdl;
                        if (fQdl <= 0.0f) {
                            this.qdl = 1.0f;
                        }
                    }
                } else {
                    this.qdl = 1.0f;
                }
                int i2 = (int) (1000.0f / this.qdl);
                com.bytedance.sdk.component.utils.aaj.qdl("TTAD.TopLayoutHelper", "handleMessage: next msg intervalInMillis = ".concat(String.valueOf(i2)));
                this.lnr.sendEmptyMessageDelayed(message.what, i2);
            }
        }
        return true;
    }

    public void ud() {
        this.lnr.sendEmptyMessage(1024);
        this.wd = false;
    }

    public void lnr() {
        if (this.mo) {
            this.lnr.removeMessages(1024);
            this.lnr.sendEmptyMessage(1024);
            this.wd = false;
        }
    }

    public void mml() {
        if (!this.mo || this.wd) {
            return;
        }
        this.lnr.removeMessages(1024);
        this.wd = true;
    }

    public void mzz() {
        this.lnr.removeMessages(1024);
        this.mo = false;
        this.jpc = true;
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = this.mzz;
        if (qdlVar != null) {
            qdlVar.bch.rc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.qdl.InterfaceC0231qdl
    public void qdl(int i) {
        com.bytedance.sdk.component.utils.aaj.qdl("TTAD.TopLayoutHelper", "onPlayerStateChanged: ".concat(String.valueOf(i)));
        if (i == 1) {
            lnr();
            return;
        }
        if (i == 2) {
            mml();
        } else if (i == 3 || i == 4) {
            mzz();
        }
    }
}
