package com.bytedance.sdk.openadsdk.core.mml;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.component.utils.koa;
import com.bytedance.sdk.openadsdk.core.hzv;
import com.bytedance.sdk.openadsdk.core.rdp;
import com.bytedance.sdk.openadsdk.utils.fco;

/* JADX INFO: loaded from: classes3.dex */
public class mo extends com.bytedance.adsdk.ugeno.mo.qdl<View> implements koa.qdl {
    private ud jpc;
    private final Handler mml;
    private boolean mo;
    private long mzz;
    private final ViewTreeObserver.OnScrollChangedListener rq;
    private final Runnable to;
    private qdl tvp;
    private boolean wd;

    public interface qdl {
        void qdl(boolean z);
    }

    public interface ud {
        void qdl(boolean z);
    }

    @Override // com.bytedance.sdk.component.utils.koa.qdl
    public void qdl(Message message) {
        if (message.what == 1) {
            wd();
        }
    }

    private void wd() {
        boolean zQdl = hzv.qdl(this, 50, -1, false);
        this.wd = zQdl;
        if (zQdl == this.mo) {
            return;
        }
        this.mo = zQdl;
        fco.qdl(this.to);
    }

    public mo(Context context) {
        super(context);
        this.mml = new koa(rdp.ud().getLooper(), this);
        this.mo = true;
        this.wd = true;
        this.to = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.mml.mo.1
            @Override // java.lang.Runnable
            public void run() {
                if (mo.this.tvp != null) {
                    mo.this.tvp.qdl(mo.this.wd);
                }
            }
        };
        this.rq = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.mml.mo.2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (jElapsedRealtime - mo.this.mzz > 500) {
                    mo.this.mzz = jElapsedRealtime;
                    mo.this.mml.sendEmptyMessageDelayed(1, 500L);
                }
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.rq);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.rq);
        }
    }

    public void setSwiperWindowFocusChangedListener(ud udVar) {
        this.jpc = udVar;
    }

    public void setSwiperVisibleChangeListener(qdl qdlVar) {
        this.tvp = qdlVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ud udVar = this.jpc;
        if (udVar != null) {
            udVar.qdl(z);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.mo.qdl
    public View to(int i) {
        return (View) this.qdl.get(i);
    }
}
