package com.bytedance.sdk.component.tvp;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.utils.aaj;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mml extends lnr {
    private float jpc;
    private final long lnr;
    private final Context mml;
    private View.OnTouchListener mo;
    private final mo mzz;
    private final View.OnTouchListener qdl;
    private String to;
    private float tvp;
    private final int ud;
    private long wd = -1;

    public mml(Context context, View.OnTouchListener onTouchListener, int i, long j, mo moVar) {
        this.mml = context;
        this.qdl = onTouchListener;
        this.ud = i;
        this.lnr = j;
        this.mzz = moVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        Integer.valueOf(action);
        Float.valueOf(motionEvent.getX());
        Float.valueOf(motionEvent.getY());
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.jpc = x;
            this.tvp = y;
        } else if (action == 1 && qdl(x, y, this.jpc, this.tvp, this.mml)) {
            if (qdl(SystemClock.elapsedRealtime())) {
                motionEvent.setAction(3);
                qdl(1, x, y);
            } else {
                qdl(0, x, y);
            }
        }
        View.OnTouchListener onTouchListener = this.qdl;
        if (onTouchListener != null) {
            onTouchListener.onTouch(view, motionEvent);
        }
        View.OnTouchListener onTouchListener2 = this.mo;
        if (onTouchListener2 != null) {
            onTouchListener2.onTouch(view, motionEvent);
        }
        return false;
    }

    private boolean qdl(long j) {
        long j2 = this.wd;
        if (j2 == -1) {
            this.wd = j;
            return false;
        }
        int i = this.ud;
        if (i == 1) {
            if (j - j2 <= this.lnr) {
                return true;
            }
            this.wd = j;
            return false;
        }
        if (i == 2) {
            if (j - j2 <= this.lnr) {
                this.wd = j;
                return true;
            }
            this.wd = j;
        }
        return false;
    }

    private void qdl(int i, float f, float f2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("is_interceptor", i);
            jSONObject2.put("click_x", f);
            jSONObject2.put("click_y", f2);
            jSONObject.put("lp_click_type", this.ud);
            jSONObject.put("lp_click_interval", this.lnr);
        } catch (Throwable th) {
            aaj.qdl("LpClickIntervalTouchListener", "sendLpClickInterceptEvent", th);
        }
        if (com.bytedance.sdk.component.tvp.qdl.qdl.qdl().ud() != null) {
            com.bytedance.sdk.component.tvp.qdl.ud udVarUd = com.bytedance.sdk.component.tvp.qdl.qdl.qdl().ud();
            mo moVar = this.mzz;
            udVarUd.qdl(moVar != null ? moVar.getMaterialMeta() : null, this.to, "click_interval_intercept", jSONObject, jSONObject2);
        }
    }

    public void qdl(String str) {
        this.to = str;
    }

    @Override // com.bytedance.sdk.component.tvp.lnr
    public void qdl(View.OnTouchListener onTouchListener) {
        this.mo = onTouchListener;
    }
}
