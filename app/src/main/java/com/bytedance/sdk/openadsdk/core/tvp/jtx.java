package com.bytedance.sdk.openadsdk.core.tvp;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ax;

/* JADX INFO: loaded from: classes3.dex */
public class jtx extends com.bytedance.sdk.openadsdk.core.exu.ud.mo implements View.OnClickListener {
    private boolean yt;

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mo
    protected void qdl(boolean z) {
    }

    public jtx(Context context, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, String str, com.bytedance.sdk.openadsdk.mml.wd wdVar, boolean z) {
        super(context, ljhVar, false, str, false, false, wdVar);
        this.yt = false;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
        setNeedSelfManagerVideo(!z);
    }

    public void qdl(int i, int i2) {
        if (this.ud != null) {
            this.ud.ud(i, i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mo
    protected void ud() {
        if (!this.mzz || !bch.ud(this.fs)) {
            this.mml = false;
        }
        super.ud();
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mo
    protected void lnr() {
        if (this.yt) {
            super.lnr();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.yt = z;
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.ud != null) {
            this.ud.mzz(z);
        }
    }

    public void mml() {
        if (this.to != null) {
            ax.qdl((View) this.to, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mo, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (this.tvp != null && this.tvp.getVisibility() == 0) {
            exc();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mo, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.tvp != null && this.tvp.getVisibility() == 0) {
            exc();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void jl() {
        ax.qdl((View) this.wd, 0);
        ax.qdl((View) this.jpc, 0);
        ax.qdl((View) this.to, 8);
    }

    private void exc() {
        wd();
        if (this.wd != null) {
            if (this.wd.getVisibility() == 0) {
                return;
            } else {
                com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.qdl.tdy().to(), this.qdl.tdy().lnr(), this.qdl.tdy().ud(), this.jpc, this.qdl);
            }
        }
        jl();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.tvp != null && this.tvp.getVisibility() == 0) {
            ax.mzz(this.wd);
        }
        lnr();
    }

    public void setShowAdInteractionView(boolean z) {
        com.bytedance.sdk.openadsdk.core.exu.ud.mzz mzzVarJyq;
        if (this.ud == null || (mzzVarJyq = this.ud.fs()) == null) {
            return;
        }
        mzzVarJyq.qdl(z);
    }

    protected void mzz() {
        wd();
        ax.qdl((View) this.wd, 0);
    }
}
