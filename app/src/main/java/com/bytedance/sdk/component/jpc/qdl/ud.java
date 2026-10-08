package com.bytedance.sdk.component.jpc.qdl;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.koa;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class ud extends koa implements lnr {
    private final HandlerThread ud;

    ud(HandlerThread handlerThread, koa.qdl qdlVar) {
        super(handlerThread.getLooper(), qdlVar);
        this.ud = handlerThread;
    }

    @Override // com.bytedance.sdk.component.jpc.qdl.lnr
    public void qdl() {
        removeCallbacksAndMessages(null);
        if (this.qdl != null) {
            this.qdl.clear();
            this.qdl = null;
        }
    }

    public void qdl(koa.qdl qdlVar) {
        this.qdl = new WeakReference<>(qdlVar);
    }

    public void ud() {
        HandlerThread handlerThread = this.ud;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }
}
