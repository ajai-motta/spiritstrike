package com.bytedance.adsdk.ugeno.mml.mml;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class mzz extends lnr {
    private int bjy;
    private int exu;
    private float fs;
    private String jl;
    private AtomicBoolean jtx;
    private int rdp;
    private float rq;
    private int yt;

    public mzz(Context context) {
        super(context);
        this.exu = 0;
        this.rdp = Integer.MAX_VALUE;
        this.bjy = Integer.MAX_VALUE;
        this.jtx = new AtomicBoolean(true);
        this.yt = 0;
        this.jl = "up";
    }

    @Override // com.bytedance.adsdk.ugeno.mml.mml.lnr
    public boolean qdl(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        if (this.mzz != null) {
            this.jl = TextUtils.isEmpty(this.mzz.get("direction")) ? TtmlNode.COMBINE_ALL : this.mzz.get("direction");
            this.exu = com.bytedance.adsdk.ugeno.wd.lnr.qdl(this.mzz.get("distance"), 0);
            if (this.rdp == Integer.MAX_VALUE) {
                this.rdp = com.bytedance.adsdk.ugeno.wd.lnr.qdl(this.mzz.get("frequency"), Integer.MAX_VALUE);
            }
            if (this.bjy == Integer.MAX_VALUE) {
                this.bjy = com.bytedance.adsdk.ugeno.wd.lnr.qdl(this.mzz.get("effectiveDuration"), Integer.MAX_VALUE);
            }
            this.yt = com.bytedance.adsdk.ugeno.wd.lnr.qdl(this.mzz.get("inView"), 0);
            Log.d("GesThrough_UGSlideEvent", "mFrequency: " + this.rdp + ", mEffectiveDuration: " + this.bjy + ", inEffectiveDuation: " + this.jtx.get());
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        qdl();
        return qdl(this.ud, motionEvent);
    }

    private void qdl() {
        if (this.bjy == Integer.MAX_VALUE || this.ud == null || System.currentTimeMillis() - this.ud.uw() < this.bjy) {
            return;
        }
        this.jtx.set(false);
        Log.d("GesThrough_UGSlideEvent", "inEffectiveDuation -> false");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean qdl(com.bytedance.adsdk.ugeno.ud.lnr r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.mml.mml.mzz.qdl(com.bytedance.adsdk.ugeno.ud.lnr, android.view.MotionEvent):boolean");
    }

    private boolean qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar, float f, float f2) {
        if (this.rdp <= 0) {
            Log.d("GesThrough_UGSlideEvent", "frequency <= 0, no trigger slide");
            return false;
        }
        if (!this.jtx.get()) {
            Log.d("GesThrough_UGSlideEvent", "not in effective duration, no trigger slide");
            return false;
        }
        if (this.yt == 1 && !qdl(lnrVar.rq(), f, f2)) {
            Log.d("GesThrough_UGSlideEvent", "not in view, no trigger slide");
            return false;
        }
        Log.d("GesThrough_UGSlideEvent", "Slide event, direct handling");
        this.qdl.qdl(lnrVar, this.mo, this.lnr.ud());
        int i = this.rdp;
        if (i != Integer.MAX_VALUE) {
            this.rdp = i - 1;
        }
        return true;
    }

    private boolean qdl(View view, float f, float f2) {
        return f >= 0.0f && f < ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
    }
}
