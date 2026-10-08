package com.bytedance.sdk.openadsdk.bch.ud;

import android.view.View;
import com.bytedance.sdk.openadsdk.bch.ud.mzz;
import com.bytedance.sdk.openadsdk.core.model.ljh;

/* JADX INFO: loaded from: classes3.dex */
public class jpc extends ud {
    private int mml;

    @Override // com.bytedance.sdk.openadsdk.bch.ud.ud
    public int mo() {
        return 200;
    }

    public jpc(Integer num, View view, ljh ljhVar, mzz.qdl qdlVar) {
        super(num, view, ljhVar, 2000, qdlVar);
        this.mml = 0;
    }

    @Override // com.bytedance.sdk.openadsdk.bch.ud.ud
    protected boolean lnr() {
        return mo.qdl(this.qdl.get(), this.ud.ok()) && this.mml == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.bch.ud.ud
    protected void mml() {
        super.mml();
    }

    @Override // com.bytedance.sdk.openadsdk.bch.ud.ud
    public void qdl() {
        if (this.mml != 1) {
            return;
        }
        super.qdl();
    }

    @Override // com.bytedance.sdk.openadsdk.bch.ud.ud
    protected void ud(int i) {
        if (tvp()) {
            return;
        }
        if (i == 6 || i == 5) {
            this.mml = 0;
            jpc();
        }
        if (i == 3 || i == 2) {
            this.mml = 2;
            jpc();
        }
        if (this.mml == 1 || i != 0) {
            return;
        }
        this.mml = 1;
        qdl();
    }

    @Override // com.bytedance.sdk.openadsdk.bch.ud.ud
    public boolean fs() {
        int i = this.mml;
        boolean z = i == 2 || i == 0;
        if (z) {
            this.lnr.set(false);
        }
        return !z || super.fs();
    }
}
