package com.bytedance.sdk.openadsdk.component.reward.qdl;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.aaj.qdl.qdl;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: loaded from: classes3.dex */
public class wd extends tvp implements Handler.Callback {
    private final Handler aaj;
    private boolean bch;
    private boolean bqt;
    private boolean jyq;
    private int ljh;
    int lnr;
    int mml;
    boolean mo;
    int mzz;
    private int oth;
    boolean qdl;
    long ud;
    private int uw;
    protected int wd;
    private int xmv;

    public wd(qdl qdlVar) {
        super(qdlVar);
        this.aaj = new Handler(this);
        this.qdl = false;
        this.ud = 0L;
        this.lnr = 0;
        this.mml = 0;
        this.mzz = 0;
        this.mo = false;
        this.jyq = false;
        this.oth = 0;
        this.bch = false;
        this.uw = 0;
        this.xmv = 0;
        this.bqt = false;
        this.wd = vu.tvp(this.to);
        this.mml = this.to.icv();
        int iSxp = this.to.sxp();
        this.mzz = iSxp;
        this.uw = Math.max(0, this.mml - iSxp);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    public void qdl() {
        if (this.rdp && !this.exu) {
            super.qdl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    protected void qdl(boolean z) {
        if (this.yt != null) {
            try {
                this.jl = com.bytedance.sdk.openadsdk.aaj.qdl.mml.qdl().qdl(this.to, this.yt, ud());
                this.jl.qdl(this.fs.wc);
            } catch (Throwable th) {
                aaj.lnr("RVIVPlayableNewManager", "PreRender injection exception" + th.getMessage());
            }
            if (this.jl == null) {
                super.qdl(z);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    protected com.bytedance.sdk.openadsdk.fs.mo ud() {
        return new com.bytedance.sdk.openadsdk.fs.mo() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.wd.1
            @Override // com.bytedance.sdk.openadsdk.fs.mo
            public void qdl() {
                wd.this.yt();
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    public void lnr() {
        if (this.rdp) {
            this.jpc = true;
            boolean zJtx = jtx();
            if (zJtx) {
                this.jl.qdl(new qdl.InterfaceC0219qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.wd.2
                    @Override // com.bytedance.sdk.openadsdk.aaj.qdl.qdl.InterfaceC0219qdl
                    public void qdl(int i) {
                        if (wd.this.bqt) {
                            return;
                        }
                        wd.this.oth = i;
                        wd.this.jl.qdl((qdl.InterfaceC0219qdl) null);
                        wd.this.ud(i);
                    }
                });
            }
            this.jl.qdl();
            if (vu.jpc(this.to)) {
                this.fs.hkc.mo();
            }
            this.ud = System.currentTimeMillis();
            if (!zJtx) {
                ud(0);
            }
            this.fs.wc.yt();
            if (this.fs.gg != null) {
                this.fs.gg.qdl(this.mml);
            }
        }
    }

    private boolean jtx() {
        if (this.fs.ra) {
            return false;
        }
        int i = this.wd;
        return 1 == i || 2 == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(int i) {
        qdl(this.mzz);
        if (this.jyq) {
            return;
        }
        Handler handler = this.aaj;
        handler.sendMessage(handler.obtainMessage(900, this.mzz, i));
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    public void mml() {
        if (this.rdp) {
            super.mml();
            if (DeviceUtils.wd() == 0) {
                this.fs.gt = true;
            }
            if (this.fs.gt) {
                this.fs.fco.ud(true);
                lnr(true);
            }
            if ((this.fs.en == null || this.fs.en.exu == null || !this.fs.en.exu.isShowing()) && rq() && wd() > 0) {
                qdl(0L);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    public void mzz() {
        if (this.rdp) {
            super.mzz();
            tvp();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    public void mo() {
        if (this.rdp && !this.jtx) {
            super.mo();
            this.aaj.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    public int wd() {
        return this.lnr;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    public int jpc() {
        return this.ljh;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    public void qdl(int i) {
        this.lnr = i;
        this.ljh = i;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    public void tvp() {
        if (this.rdp) {
            this.jyq = true;
            this.aaj.removeMessages(900);
            this.aaj.removeMessages(600);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    public void qdl(long j) {
        if (this.rdp && this.jpc && !this.fs.rq.get() && this.jyq) {
            this.jyq = false;
            Message messageObtain = Message.obtain();
            messageObtain.what = 900;
            messageObtain.arg1 = wd();
            messageObtain.arg2 = this.oth;
            this.aaj.sendMessageDelayed(messageObtain, j);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 900 || !jl()) {
            return true;
        }
        int i = message.arg1;
        boolean z = false;
        if (this.bch) {
            int i2 = this.mzz;
            int i3 = this.xmv;
            int i4 = i2 + i3;
            int i5 = this.mml;
            if (i4 < i5) {
                this.xmv = i3 + 1;
                Message messageObtain = Message.obtain();
                messageObtain.what = 900;
                messageObtain.arg1 = 0;
                this.aaj.sendMessageDelayed(messageObtain, 1000L);
            } else {
                this.xmv = i5 - i2;
            }
        } else if (i > 0) {
            if (this.oth == 0 && 2 == this.wd) {
                z = true;
            }
            this.fs.fco.mml(true);
            if (!z) {
                this.fs.fco.qdl(String.valueOf(i), null);
            }
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 900;
            int i6 = i - 1;
            messageObtain2.arg1 = i6;
            this.aaj.sendMessageDelayed(messageObtain2, 1000L);
            this.lnr = i6;
            this.ljh = i;
        } else {
            this.mo = true;
            if (vu.jpc(this.to) && (!vu.aaj(this.to) || !this.jl.mzz())) {
                this.fs.fco.lnr();
                this.fs.fco.mzz(true);
            } else {
                this.fs.fco.mml(false);
                this.fs.exc.set(true);
                this.fs.en.bjy();
            }
            if (this.jl == null || this.jl.mzz()) {
                this.bjy = true;
            }
            if (this.uw > 0) {
                this.bch = true;
                this.xmv++;
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 900;
                messageObtain3.arg1 = 0;
                this.aaj.sendMessageDelayed(messageObtain3, 1000L);
            }
            this.ljh = 0;
        }
        yt();
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.tvp
    public boolean to() {
        return this.mo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt() {
        int i;
        if (!this.bch) {
            i = this.mzz - this.lnr;
        } else {
            i = this.mzz + this.xmv;
        }
        int i2 = com.bytedance.sdk.openadsdk.core.yt.mml().xmv(String.valueOf(this.fs.mo)).mo;
        int i3 = this.mml;
        boolean z = i3 <= 0 || (((float) i) / ((float) i3)) * 100.0f >= ((float) i2);
        int iQdl = com.bytedance.sdk.openadsdk.core.yt.mml().qdl(String.valueOf(this.fs.mo));
        if (iQdl == 0) {
            boolean zMo = this.jl != null ? this.jl.mo() : false;
            if (this.bjy) {
                zMo = true;
            }
            if (!z || !zMo) {
                return;
            }
        } else if (iQdl != 1 || !z) {
            return;
        }
        this.fs.wc.ud(true);
    }

    private boolean jl() {
        return this.jpc && vu.lnr(this.fs.ud) && !this.exc.get();
    }
}
