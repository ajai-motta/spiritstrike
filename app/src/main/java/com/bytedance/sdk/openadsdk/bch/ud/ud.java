package com.bytedance.sdk.openadsdk.bch.ud;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.sdk.openadsdk.bch.ud.mzz;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ud {
    private final Integer jpc;
    protected final AtomicBoolean lnr;
    private final AtomicLong mml;
    private final mzz.qdl mo;
    private final AtomicBoolean mzz;
    protected WeakReference<View> qdl;
    private volatile boolean tvp = false;
    protected ljh ud;
    private final int wd;

    protected abstract boolean lnr();

    public abstract int mo();

    protected abstract void ud(int i);

    public static ud qdl(boolean z, Integer num, View view, ljh ljhVar, mzz.qdl qdlVar) {
        return z ? new jpc(num, view, ljhVar, qdlVar) : new lnr(num, view, ljhVar, qdlVar);
    }

    public ud(Integer num, View view, ljh ljhVar, int i, mzz.qdl qdlVar) {
        this.jpc = num;
        this.wd = i;
        this.ud = ljhVar;
        this.mo = qdlVar;
        qdl(view);
        this.lnr = new AtomicBoolean(false);
        this.mml = new AtomicLong(-1L);
        this.mzz = new AtomicBoolean(false);
    }

    public void qdl() {
        if (this.lnr.compareAndSet(false, true)) {
            wd.qdl(this);
        }
    }

    public int ud() {
        if (tvp()) {
            return 1;
        }
        WeakReference<View> weakReference = this.qdl;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null || this.tvp) {
            return 3;
        }
        if (rq().equals(view.getTag(InputDeviceCompat.SOURCE_HDMI))) {
            return (rq().equals(view.getTag(InputDeviceCompat.SOURCE_HDMI)) && lnr()) ? 1 : 2;
        }
        to();
        mzz.ud(rq());
        return 3;
    }

    protected void mml() {
        if (this.mzz.compareAndSet(false, true)) {
            mml.qdl(this.ud, mzz(), this.mo);
        }
    }

    protected qdl mzz() {
        WeakReference<View> weakReference = this.qdl;
        if (weakReference == null) {
            return new qdl(-1, -1, -1.0f);
        }
        View view = weakReference.get();
        if (view == null) {
            return new qdl(0, 0, 0.0f);
        }
        return new qdl(view.getWidth(), view.getHeight(), view.getAlpha());
    }

    public void wd() {
        if (tvp()) {
            return;
        }
        if (!this.lnr.get()) {
            jpc();
        } else if (!this.mml.compareAndSet(-1L, System.currentTimeMillis()) && System.currentTimeMillis() - this.mml.get() >= this.wd) {
            mml();
        }
    }

    public void jpc() {
        this.mml.set(-1L);
    }

    public boolean tvp() {
        return this.mzz.get();
    }

    public void to() {
        this.tvp = true;
        wd.ud(this);
    }

    public void qdl(int i) {
        if (i == 4) {
            qdl();
            return;
        }
        if (i == 8) {
            exu();
        } else if (i == 9) {
            mml();
        } else {
            ud(i);
        }
    }

    public Integer rq() {
        return this.jpc;
    }

    public boolean fs() {
        return this.lnr.get();
    }

    public void exu() {
        this.lnr.set(false);
        jpc();
    }

    public void qdl(View view) {
        if (view != null) {
            view.setTag(InputDeviceCompat.SOURCE_HDMI, rq());
        }
        this.qdl = new WeakReference<>(view);
    }
}
