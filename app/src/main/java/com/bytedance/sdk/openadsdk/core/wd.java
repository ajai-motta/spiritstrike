package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.component.utils.koa;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class wd extends View implements koa.qdl {
    private boolean exu;
    private boolean fs;
    private int jpc;
    private qdl lnr;
    private View mml;
    private List<View> mo;
    private List<View> mzz;
    private boolean qdl;
    private final Runnable rdp;
    private ViewTreeObserver.OnGlobalLayoutListener rq;
    private final AtomicBoolean to;
    private final Handler tvp;
    private boolean ud;
    private boolean wd;

    public interface qdl {
        void qdl();

        void qdl(View view);

        void qdl(boolean z);

        void ud();
    }

    public wd(Context context, View view, boolean z) {
        super(yt.qdl());
        this.tvp = new com.bytedance.sdk.component.utils.koa(rdp.ud().getLooper(), this);
        this.to = new AtomicBoolean(true);
        this.exu = false;
        this.rdp = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wd.3
            @Override // java.lang.Runnable
            public void run() {
                if (wd.this.lnr != null) {
                    wd.this.lnr.qdl(wd.this.mml);
                }
            }
        };
        this.fs = z;
        this.mml = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.rq = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.wd.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (wd.this.exu) {
                    return;
                }
                wd.this.mzz();
                wd.this.mml();
            }
        };
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        qdl qdlVar = this.lnr;
        if (qdlVar != null) {
            qdlVar.qdl(z);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.wd = false;
        ud();
        if (this.rq != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.rq);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        ud();
    }

    private void ud() {
        qdl qdlVar;
        if (!this.to.getAndSet(false) || (qdlVar = this.lnr) == null) {
            return;
        }
        qdlVar.qdl();
    }

    private void lnr() {
        qdl qdlVar;
        if (this.to.getAndSet(true) || (qdlVar = this.lnr) == null) {
            return;
        }
        qdlVar.ud();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mzz();
        this.wd = true;
        lnr();
        qdl(false);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        lnr();
    }

    public void setRefClickViews(List<View> list) {
        this.mzz = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.mo = list;
    }

    public void qdl() {
        qdl(this.mzz, (com.bytedance.sdk.openadsdk.core.lnr.lnr) null);
        qdl(this.mo, (com.bytedance.sdk.openadsdk.core.lnr.lnr) null);
    }

    public void qdl(List<View> list, com.bytedance.sdk.openadsdk.core.lnr.lnr lnrVar) {
        if (com.bytedance.sdk.component.utils.exu.ud(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(lnrVar);
                    view.setOnTouchListener(lnrVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mml() {
        if (!this.ud || this.qdl) {
            return;
        }
        this.qdl = true;
        this.tvp.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mzz() {
        if (this.qdl) {
            this.tvp.removeCallbacksAndMessages(null);
            this.qdl = false;
        }
    }

    public void setNeedCheckingShow(boolean z) {
        this.ud = z;
        if (!z && this.qdl) {
            mzz();
        } else {
            if (!z || this.qdl) {
                return;
            }
            mml();
        }
    }

    public void setCallback(qdl qdlVar) {
        this.lnr = qdlVar;
    }

    public void setAdType(int i) {
        this.jpc = i;
    }

    @Override // com.bytedance.sdk.component.utils.koa.qdl
    public void qdl(Message message) {
        if (message.what == 1 && this.qdl) {
            if (mo() && hzv.qdl(this.mml, 20, this.jpc, this.fs)) {
                mzz();
                this.exu = true;
                rdp.lnr().post(this.rdp);
                qdl(true);
                return;
            }
            this.tvp.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private boolean mo() {
        View view = this.mml;
        if (view instanceof com.bytedance.sdk.openadsdk.core.tvp.aaj) {
            return ((com.bytedance.sdk.openadsdk.core.tvp.aaj) view).ljh();
        }
        return true;
    }

    private void qdl(final boolean z) {
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        com.bytedance.sdk.component.utils.tvp.ud().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wd.2
            @Override // java.lang.Runnable
            public void run() {
                ViewTreeObserver viewTreeObserver2;
                if (wd.this.rq != null && (viewTreeObserver2 = viewTreeObserver) != null) {
                    try {
                        viewTreeObserver2.removeOnGlobalLayoutListener(wd.this.rq);
                    } catch (Exception unused) {
                    }
                }
                if (z) {
                    wd.this.rq = null;
                }
            }
        });
    }
}
