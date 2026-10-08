package com.bytedance.adsdk.ugeno.tvp.lnr;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.tvp.mml.lnr;

/* JADX INFO: loaded from: classes2.dex */
public abstract class qdl extends lnr {
    private int kr;

    public abstract String rdp(String str);

    public qdl(Context context) {
        super(context);
        this.kr = -16777216;
    }

    @Override // com.bytedance.adsdk.ugeno.tvp.mml.lnr, com.bytedance.adsdk.ugeno.ud.lnr
    public void ud() {
        this.qdl = jtx(this.qdl);
        super.ud();
        ((com.bytedance.adsdk.ugeno.tvp.mml.qdl) this.mzz).setColorFilter(this.kr);
        ((com.bytedance.adsdk.ugeno.tvp.mml.qdl) this.mzz).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private String jtx(String str) {
        String strRdp = rdp(str);
        if (TextUtils.isEmpty(strRdp)) {
            return "";
        }
        return "local://".concat(String.valueOf(strRdp));
    }

    @Override // com.bytedance.adsdk.ugeno.tvp.mml.lnr, com.bytedance.adsdk.ugeno.ud.lnr
    public void qdl(String str, String str2) {
        super.qdl(str, str2);
        str.hashCode();
        if (str.equals("textColor")) {
            this.kr = com.bytedance.adsdk.ugeno.wd.qdl.qdl(str2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.tvp.mml.lnr
    protected String lnr() {
        return "drawable";
    }
}
