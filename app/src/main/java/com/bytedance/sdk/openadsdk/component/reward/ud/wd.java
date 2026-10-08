package com.bytedance.sdk.openadsdk.component.reward.ud;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.component.reward.view.tvp;
import com.bytedance.sdk.openadsdk.core.model.jl;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.utils.jtx;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class wd extends ud {
    private final int bjy;
    private String jl;
    private ViewGroup jtx;
    private com.bytedance.sdk.openadsdk.component.reward.view.wd yt;

    public wd(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar) {
        super(qdlVar);
        this.jl = "fullscreen_interstitial_ad";
        this.bjy = this.ud.vxg();
    }

    private void vu() {
        FrameLayout.LayoutParams layoutParams;
        FrameLayout frameLayout = new FrameLayout(this.qdl.ag);
        this.jtx = frameLayout;
        frameLayout.setId(jtx.guw);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.jtx.setLayoutParams(layoutParams2);
        View viewRq = this.qdl.gy.rq();
        if (viewRq != null) {
            layoutParams2.bottomMargin = viewRq.getHeight();
        }
        com.bytedance.sdk.openadsdk.component.reward.view.wd wdVar = new com.bytedance.sdk.openadsdk.component.reward.view.wd(this.qdl.ag);
        this.yt = wdVar;
        wdVar.setId(jtx.jnw);
        if (this.qdl.ud.jb() == 1) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -1);
        }
        layoutParams.gravity = 17;
        this.yt.setLayoutParams(layoutParams);
        this.jtx.addView(this.yt);
        rc();
    }

    private void rc() {
        if (this.jtx == null) {
            return;
        }
        qdl((View) this.yt);
    }

    private void ud(ljh ljhVar) {
        if (ljhVar == null || this.yt == null) {
            return;
        }
        kdv();
        qdl((ImageView) this.yt);
    }

    private void kdv() {
        jl jlVar;
        List<jl> listVm = this.ud.vm();
        if (listVm == null || listVm.size() <= 0 || (jlVar = listVm.get(0)) == null) {
            return;
        }
        try {
            int iUd = jlVar.ud();
            int iLnr = jlVar.lnr();
            if (iUd != 0 && iLnr != 0) {
                this.yt.setRatio(iUd / iLnr);
                return;
            }
            int i = this.bjy;
            if (i == 33) {
                this.yt.setRatio(1.0f);
            } else if (i == 3) {
                this.yt.setRatio(1.91f);
            } else {
                this.yt.setRatio(0.56f);
            }
        } catch (Exception e) {
            aaj.lnr("TTAD.RFTI", e.getMessage());
        }
    }

    private void qdl(ImageView imageView) {
        List<jl> listVm;
        jl jlVar;
        if (this.ud == null || (listVm = this.ud.vm()) == null || listVm.size() <= 0 || (jlVar = listVm.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.tvp.mml.qdl(listVm.get(0)).lnr(1).qdl(com.bytedance.sdk.openadsdk.tvp.lnr.qdl(this.ud, jlVar.qdl(), imageView));
    }

    protected void qdl(View view) {
        com.bytedance.sdk.openadsdk.core.lnr.ud qdlVar;
        if (view == null || this.qdl.ag == null || this.ud == null) {
            return;
        }
        if (this.fs == null) {
            Activity activity = this.qdl.ag;
            ljh ljhVar = this.ud;
            String str = this.jl;
            qdlVar = new com.bytedance.sdk.openadsdk.core.lnr.qdl(activity, ljhVar, str, gy.qdl(str));
            qdlVar.qdl(lnr(this.ud));
            HashMap map = new HashMap();
            map.put("click_scence", 1);
            qdlVar.qdl(map);
        } else {
            qdlVar = this.fs;
        }
        if (this.qdl.ag != null) {
            qdlVar.qdl(this.qdl.ag);
        }
        view.setOnTouchListener(qdlVar);
        view.setOnClickListener(qdlVar);
    }

    private com.bytedance.sdk.openadsdk.exc.qdl.qdl.mo lnr(ljh ljhVar) {
        if (ljhVar.ygv() == 4) {
            return new com.bytedance.sdk.openadsdk.exc.qdl.qdl.mml(yt.qdl(), this.jl);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.ud.ud
    public void qdl(FrameLayout frameLayout) {
        try {
            vu();
            ud(this.ud);
            frameLayout.addView(this.jtx);
        } catch (Exception e) {
            Log.e("TTAD.RFTI", "bindAd: ", e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.ud.ud
    public void qdl(tvp tvpVar) {
        if (com.bytedance.sdk.openadsdk.core.model.aaj.ud(this.ud)) {
            mml.qdl(tvpVar, this.ud);
            this.qdl.kab.qdl((long) (this.qdl.bch.fco() * 1000.0d));
        } else {
            if (com.bytedance.sdk.openadsdk.core.model.aaj.mml(this.ud) || com.bytedance.sdk.openadsdk.core.model.aaj.wd(this.ud)) {
                mml.ud(tvpVar, this.ud);
                if (this.qdl.ra) {
                    return;
                }
                this.qdl.kab.qdl((long) (this.qdl.bch.fco() * 1000.0d));
                return;
            }
            super.qdl(tvpVar);
        }
    }

    public static boolean qdl(ljh ljhVar) {
        return !ljh.mzz(ljhVar) && ljhVar.nv() == 100.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.ud.ud
    public boolean mzz() {
        return ekw();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.ud.ud
    public boolean mo() {
        return ekw();
    }

    private boolean ekw() {
        return this.ud != null && this.ud.dk() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.ud.ud
    public void wd() {
        if (com.bytedance.sdk.openadsdk.core.model.aaj.ud(this.ud)) {
            this.mo.ud(8);
        }
        this.jpc.lnr(false);
        this.jpc.mml(false);
        if (this.ud.dk() == 2) {
            this.jpc.qdl(false);
            this.mo.mo(8);
            return;
        }
        this.jpc.qdl(this.ud.tvf());
        if (this.qdl.nz) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 900;
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = this.qdl;
            int iFco = (int) (this.qdl.bch.fco() * 1000.0d);
            qdlVar.tvp = iFco;
            messageObtain.arg1 = iFco;
            this.qdl.cx.sendMessage(messageObtain);
        }
    }
}
