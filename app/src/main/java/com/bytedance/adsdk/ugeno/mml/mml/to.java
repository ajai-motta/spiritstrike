package com.bytedance.adsdk.ugeno.mml.mml;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.adsdk.ugeno.wd.tvp;

/* JADX INFO: loaded from: classes2.dex */
public class to extends lnr implements tvp.qdl {
    private Handler exu;
    private int fs;
    private int rdp;
    private int rq;

    public to(Context context) {
        super(context);
        this.fs = 0;
        this.exu = new com.bytedance.adsdk.ugeno.wd.tvp(Looper.getMainLooper(), this);
        this.rdp = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.mml.mml.lnr
    public boolean qdl(Object... objArr) {
        if (this.mzz != null) {
            int iQdl = com.bytedance.adsdk.ugeno.wd.lnr.qdl(this.mzz.get("loop"), 0);
            this.rq = iQdl;
            if (iQdl <= 0) {
                this.rdp = -1;
            } else {
                this.rdp = iQdl;
            }
            this.fs = com.bytedance.adsdk.ugeno.wd.lnr.qdl(this.mzz.get(TypedValues.TransitionType.S_DURATION), 0);
        }
        this.exu.sendEmptyMessageDelayed(1001, this.fs);
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.wd.tvp.qdl
    public void qdl(Message message) {
        int i;
        int i2;
        if (message.what != 1001) {
            return;
        }
        Log.d("UGBaseEventMonitor", "handleMsg: execute timer event" + this.rdp);
        this.qdl.qdl(this.ud, this.mo, this.lnr.ud());
        int i3 = this.rdp + (-1);
        this.rdp = i3;
        if (i3 < 0 && (i2 = this.fs) != 0) {
            this.exu.sendEmptyMessageDelayed(1001, i2);
        } else if (i3 > 0 && (i = this.fs) != 0) {
            this.exu.sendEmptyMessageDelayed(1001, i);
        } else {
            this.exu.removeMessages(1001);
        }
    }
}
