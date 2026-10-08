package com.bytedance.sdk.openadsdk.fs;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: loaded from: classes3.dex */
public class tvp {
    private final AudioManager qdl;
    private int ud = -1;
    private boolean lnr = false;

    public tvp(Context context) {
        this.qdl = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public int qdl() {
        return this.ud;
    }

    public void qdl(boolean z) {
        qdl(z, false);
    }

    public void qdl(boolean z, boolean z2) {
        if (this.qdl == null) {
            return;
        }
        int i = 0;
        if (z) {
            int iWd = DeviceUtils.wd();
            if (iWd != 0) {
                this.ud = iWd;
            } else if (!z2) {
                return;
            }
            qdl(3, 0, 0);
            this.lnr = true;
            return;
        }
        int iTvp = this.ud;
        if (iTvp == 0) {
            iTvp = DeviceUtils.tvp() / 15;
        } else {
            if (iTvp == -1) {
                if (!z2) {
                    return;
                } else {
                    iTvp = DeviceUtils.tvp() / 15;
                }
            }
            this.ud = -1;
            qdl(3, iTvp, i);
            this.lnr = true;
        }
        i = 1;
        this.ud = -1;
        qdl(3, iTvp, i);
        this.lnr = true;
    }

    private void qdl(int i, int i2, int i3) {
        try {
            this.qdl.setStreamVolume(i, i2, i3);
        } catch (Throwable unused) {
        }
    }
}
