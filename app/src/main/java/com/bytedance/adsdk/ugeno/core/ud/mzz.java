package com.bytedance.adsdk.ugeno.core.ud;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bytedance.adsdk.ugeno.core.bjy;
import com.bytedance.adsdk.ugeno.core.exu;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class mzz {
    private qdl exu;
    private boolean fs;
    private exu jpc;
    private boolean rq;
    private Context to;
    private String tvp;
    private exu wd;
    private float qdl = Float.MIN_VALUE;
    private float ud = Float.MIN_VALUE;
    private int lnr = 0;
    private int mml = Integer.MAX_VALUE;
    private int mzz = Integer.MAX_VALUE;
    private AtomicBoolean mo = new AtomicBoolean(true);

    public mzz(Context context, exu exuVar, boolean z, boolean z2) {
        this.to = context;
        this.wd = exuVar;
        this.rq = z;
        this.fs = z2;
        lnr();
    }

    public mzz(Context context, exu exuVar, exu exuVar2, boolean z, boolean z2) {
        this.to = context;
        this.wd = exuVar;
        this.jpc = exuVar2;
        this.rq = z;
        this.fs = z2;
        lnr();
    }

    private void lnr() {
        if (this.fs) {
            this.exu = new qdl();
        }
        exu exuVar = this.wd;
        if (exuVar == null) {
            return;
        }
        this.lnr = exuVar.lnr().optInt("slideThreshold");
        this.tvp = this.wd.lnr().optString("slideDirection");
        this.mml = this.wd.lnr().optInt("frequency", Integer.MAX_VALUE);
        this.mzz = this.wd.lnr().optInt("effectiveDuration", Integer.MAX_VALUE);
        Log.d("GesThrough_UGSREvent", "mFrequency: " + this.mml + ", mEffectiveDuration: " + this.mzz + ", inEffectiveDuation: " + this.mo.get());
    }

    public void qdl() {
        if (this.mzz == Integer.MAX_VALUE) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.core.ud.mzz.1
            @Override // java.lang.Runnable
            public void run() {
                mzz.this.mo.set(false);
                Log.d("GesThrough_UGSREvent", "inEffectiveDuation -> false");
            }
        }, this.mzz);
    }

    public void ud() {
        this.qdl = Float.MIN_VALUE;
        this.ud = Float.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean qdl(com.bytedance.adsdk.ugeno.core.bjy r8, com.bytedance.adsdk.ugeno.ud.lnr r9, android.view.MotionEvent r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.core.ud.mzz.qdl(com.bytedance.adsdk.ugeno.core.bjy, com.bytedance.adsdk.ugeno.ud.lnr, android.view.MotionEvent, boolean):boolean");
    }

    private void qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar) {
        if (this.exu != null) {
            Log.d("GesThrough_UGSREvent", "need gesture through, replayGestureMotions");
            this.exu.qdl(lnrVar);
        }
    }

    private void qdl(bjy bjyVar, exu exuVar, com.bytedance.adsdk.ugeno.ud.lnr lnrVar) {
        if (this.mml <= 0) {
            Log.d("GesThrough_UGSREvent", "frequency <= 0, no trigger slide");
            qdl(lnrVar);
        } else {
            if (!this.mo.get()) {
                Log.d("GesThrough_UGSREvent", "not in effective duration, no trigger slide");
                qdl(lnrVar);
                return;
            }
            bjyVar.qdl(exuVar, lnrVar, lnrVar);
            int i = this.mml;
            if (i != Integer.MAX_VALUE) {
                this.mml = i - 1;
            }
        }
    }
}
