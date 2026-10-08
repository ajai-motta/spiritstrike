package com.bytedance.sdk.openadsdk.core.tvp;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.fs;
import com.bytedance.sdk.openadsdk.utils.ax;

/* JADX INFO: loaded from: classes3.dex */
public class ljh extends GestureDetector {
    private final qdl qdl;
    private final com.bytedance.sdk.openadsdk.core.lnr.mo ud;

    public ljh(Context context) {
        this(context, new qdl());
    }

    public ljh(Context context, qdl qdlVar) {
        super(context, qdlVar);
        this.qdl = qdlVar;
        this.ud = new com.bytedance.sdk.openadsdk.core.lnr.mo();
        setIsLongpressEnabled(false);
    }

    void qdl() {
        this.qdl.qdl();
    }

    public boolean ud() {
        return this.qdl.ud();
    }

    public com.bytedance.sdk.openadsdk.core.model.fs qdl(Context context, View view) {
        if (this.ud == null) {
            return new fs.qdl().qdl();
        }
        return new fs.qdl().mo(this.ud.qdl).mzz(this.ud.ud).mml(this.ud.lnr).lnr(this.ud.mml).ud(this.ud.mzz).qdl(this.ud.mo).qdl(ax.qdl(view)).ud(ax.lnr(view)).mml(this.ud.wd).mzz(this.ud.jpc).mo(this.ud.tvp).qdl(this.ud.fs).ud(com.bytedance.sdk.openadsdk.core.tvp.ud().qdl() ? 1 : 2).qdl("vessel").qdl(ax.jpc(context)).lnr(ax.to(context)).ud(ax.tvp(context)).qdl();
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.ud.qdl(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    static class qdl extends GestureDetector.SimpleOnGestureListener {
        boolean qdl = false;

        qdl() {
        }

        void qdl() {
            this.qdl = false;
        }

        boolean ud() {
            return this.qdl;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.qdl = true;
            return super.onSingleTapUp(motionEvent);
        }
    }
}
