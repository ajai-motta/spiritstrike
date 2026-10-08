package com.bytedance.sdk.openadsdk.component.reward.view;

import android.graphics.Color;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.jtx;

/* JADX INFO: loaded from: classes3.dex */
public class rq extends fs {
    @Override // com.bytedance.sdk.openadsdk.component.reward.view.fs
    protected boolean qdl() {
        return false;
    }

    public rq(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar) {
        super(qdlVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.view.fs
    public void qdl(int i, int i2) {
        super.qdl(i, i2);
        if (ljh.mzz(this.mml) && this.mml.fzn() == 3 && this.mml.gg() == 0) {
            try {
                FrameLayout frameLayout = (FrameLayout) this.lnr.ax.findViewById(jtx.to);
                frameLayout.setBackgroundColor(Color.parseColor("#000000"));
                if (this.mml.jb() == 1) {
                    int iUd = ax.ud(yt.qdl(), 90.0f);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                    layoutParams.bottomMargin = iUd;
                    frameLayout.setLayoutParams(layoutParams);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
