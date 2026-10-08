package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.core.model.ljh;

/* JADX INFO: loaded from: classes3.dex */
public class to extends wd {
    private long qdl;
    private long ud;

    @Override // com.bytedance.sdk.openadsdk.core.widget.wd
    protected boolean qdl() {
        return false;
    }

    public to(Context context) {
        super(context);
        setVisibility(8);
        setClickable(true);
    }

    public void lnr() {
        setVisibility(8);
        if (this.qdl != 0) {
            this.ud = SystemClock.elapsedRealtime();
        }
    }

    public void ud(ljh ljhVar, int i) {
        if (isShown()) {
            return;
        }
        ud();
        setVisibility(0);
        this.qdl = SystemClock.elapsedRealtime();
        qdl(ljhVar, i);
    }

    public boolean mml() {
        return this.qdl > 0 && this.ud > 0;
    }

    public long getDisplayDuration() {
        if (this.qdl == 0) {
            return 0L;
        }
        if (this.ud == 0) {
            this.ud = SystemClock.elapsedRealtime();
        }
        return this.ud - this.qdl;
    }
}
