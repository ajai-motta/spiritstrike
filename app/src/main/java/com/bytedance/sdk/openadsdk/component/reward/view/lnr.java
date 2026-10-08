package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.jl;
import com.bytedance.sdk.openadsdk.core.model.jtx;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.yt;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.gy;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class lnr extends com.bytedance.sdk.openadsdk.core.tvp.qdl {
    private com.bytedance.sdk.openadsdk.core.lnr.mzz aaj;
    private int bjy;
    private FrameLayout exc;
    private boolean exu;
    private View jl;
    private int jtx;
    private float qdl;
    private int rdp;
    private View yt;

    public View getInteractionStyleRootView() {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.tvp.qdl
    protected void qdl(View view, int i, jtx jtxVar) {
    }

    public lnr(Context context, String str) {
        super(context, str);
        this.jtx = 1;
        this.ud = context;
    }

    public void qdl(ljh ljhVar, float f, int i, int i2, int i3) {
        this.qdl = f;
        this.jtx = i;
        this.lnr = ljhVar;
        this.mo = "fullscreen_interstitial_ad";
        this.rdp = i2;
        this.bjy = i3;
        qdl(this.tvp);
        ud();
    }

    private void ud() {
        this.wd = ax.ud(this.ud, this.rdp);
        this.jpc = ax.ud(this.ud, this.bjy);
        int i = (int) (this.qdl * 1000.0f);
        if (this.jtx == 1) {
            if (i == 666) {
                mzz();
                return;
            }
            if (i == 1000) {
                lnr();
                return;
            }
            if (i == 1500) {
                rq();
                return;
            } else if (i == 1777) {
                exu();
                return;
            } else {
                qdl(0.562f);
                fs();
                return;
            }
        }
        if (i == 562) {
            tvp();
            return;
        }
        if (i == 666) {
            wd();
            return;
        }
        if (i == 1000) {
            lnr();
        } else if (i == 1500) {
            jpc();
        } else {
            qdl(1.777f);
            to();
        }
    }

    private void lnr() {
        com.bytedance.sdk.openadsdk.rdp.qdl qdlVar = new com.bytedance.sdk.openadsdk.rdp.qdl(this.ud);
        this.yt = qdlVar;
        ud(qdlVar);
        mml();
        mo();
    }

    private void ud(View view) {
        if (view.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            view.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            addView(view);
        }
    }

    private void mml() {
        this.exc = (FrameLayout) this.yt.findViewById(com.bytedance.sdk.openadsdk.utils.jtx.lme);
        ImageView imageView = (ImageView) this.yt.findViewById(com.bytedance.sdk.openadsdk.utils.jtx.iw);
        yt ytVar = (yt) this.yt.findViewById(com.bytedance.sdk.openadsdk.utils.jtx.bx);
        TextView textView = (TextView) this.yt.findViewById(com.bytedance.sdk.openadsdk.utils.jtx.xdk);
        TextView textView2 = (TextView) this.yt.findViewById(com.bytedance.sdk.openadsdk.utils.jtx.jut);
        View viewFindViewById = this.yt.findViewById(520093739);
        if (!TextUtils.isEmpty(this.lnr.uvi())) {
            textView2.setText(this.lnr.uvi());
        }
        qdl(this.exc, imageView);
        if (this.lnr.hcs() != null && !TextUtils.isEmpty(this.lnr.hcs().qdl())) {
            com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.lnr.hcs().qdl(), this.lnr.hcs().ud(), this.lnr.hcs().lnr(), ytVar, this.lnr);
        }
        textView.setText(getTitle());
        lnr(this.exc);
        lnr(imageView);
        lnr(ytVar);
        lnr(textView);
        lnr(textView2);
        if (viewFindViewById instanceof PAGLogoView) {
            ((PAGLogoView) viewFindViewById).initData(this.lnr);
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.lnr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.qdl(lnr.this.ud, lnr.this.lnr, lnr.this.mo);
                } catch (Throwable th) {
                    aaj.lnr("FullInteractionStyleView", th.getMessage());
                }
            }
        });
    }

    private void mzz() {
        com.bytedance.sdk.openadsdk.rdp.lnr lnrVar = new com.bytedance.sdk.openadsdk.rdp.lnr(this.ud);
        this.yt = lnrVar;
        ud(lnrVar);
        mml();
        mo();
    }

    private void mo() {
        TextView textView = (TextView) this.yt.findViewById(com.bytedance.sdk.openadsdk.utils.jtx.dps);
        if (textView != null) {
            textView.setText(getDescription());
            lnr(textView);
        }
    }

    private void wd() {
        com.bytedance.sdk.openadsdk.rdp.ud udVar = new com.bytedance.sdk.openadsdk.rdp.ud(this.ud);
        this.yt = udVar;
        ud(udVar);
        mml();
        mo();
    }

    private void jpc() {
        com.bytedance.sdk.openadsdk.rdp.mml mmlVar = new com.bytedance.sdk.openadsdk.rdp.mml(this.ud);
        this.yt = mmlVar;
        ud(mmlVar);
        mml();
    }

    private void tvp() {
        com.bytedance.sdk.openadsdk.rdp.mo moVar = new com.bytedance.sdk.openadsdk.rdp.mo(this.ud);
        this.yt = moVar;
        ud(moVar);
        mml();
        mo();
    }

    private void to() {
        com.bytedance.sdk.openadsdk.rdp.jpc jpcVar = new com.bytedance.sdk.openadsdk.rdp.jpc(this.ud);
        this.yt = jpcVar;
        ud(jpcVar);
        mml();
    }

    private void rq() {
        View mzzVar = new com.bytedance.sdk.openadsdk.rdp.mzz(this.ud);
        this.yt = mzzVar;
        ud(mzzVar);
        this.exc = (FrameLayout) this.yt.findViewById(com.bytedance.sdk.openadsdk.utils.jtx.lme);
        ImageView imageView = (ImageView) this.yt.findViewById(com.bytedance.sdk.openadsdk.utils.jtx.kr);
        TextView textView = (TextView) this.yt.findViewById(com.bytedance.sdk.openadsdk.utils.jtx.xx);
        View viewFindViewById = this.yt.findViewById(520093739);
        qdl(this.exc, imageView);
        textView.setText(getDescription());
        lnr(this.exc);
        lnr(imageView);
        lnr(textView);
        if (viewFindViewById instanceof PAGLogoView) {
            ((PAGLogoView) viewFindViewById).initData(this.lnr);
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.lnr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.qdl(lnr.this.ud, lnr.this.lnr, lnr.this.mo);
                } catch (Throwable th) {
                    aaj.lnr("FullInteractionStyleView", th.getMessage());
                }
            }
        });
    }

    private void qdl(FrameLayout frameLayout, ImageView imageView) {
        if (this.lnr == null) {
            return;
        }
        boolean zMzz = ljh.mzz(this.lnr);
        if (this.lnr.tdy() != null && zMzz) {
            ax.qdl((View) imageView, 8);
            ax.qdl((View) frameLayout, 0);
        } else {
            qdl(imageView);
            ax.qdl((View) imageView, 0);
            ax.qdl((View) frameLayout, 8);
        }
    }

    private void qdl(ImageView imageView) {
        List<jl> listVm;
        jl jlVar;
        if (this.lnr == null || (listVm = this.lnr.vm()) == null || listVm.size() <= 0 || (jlVar = listVm.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.tvp.mml.qdl(jlVar).lnr(1).qdl(com.bytedance.sdk.openadsdk.tvp.lnr.qdl(this.lnr, jlVar.qdl(), imageView));
    }

    private void fs() {
        com.bytedance.sdk.openadsdk.rdp.wd wdVar = new com.bytedance.sdk.openadsdk.rdp.wd(this.ud);
        this.yt = wdVar;
        ud(wdVar);
        mml();
    }

    private void exu() {
        com.bytedance.sdk.openadsdk.rdp.tvp tvpVar = new com.bytedance.sdk.openadsdk.rdp.tvp(this.ud);
        this.yt = tvpVar;
        ud(tvpVar);
        mml();
        mo();
    }

    private void lnr(View view) {
        if (view == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.lnr.qdl qdlVar = this.aaj;
        if (qdlVar == null) {
            qdlVar = new com.bytedance.sdk.openadsdk.core.lnr.qdl(this.ud, this.lnr, this.mo, gy.qdl(this.mo));
            qdlVar.qdl(qdl(this.lnr, this.ud));
        }
        view.setOnTouchListener(qdlVar);
        view.setOnClickListener(qdlVar);
    }

    private com.bytedance.sdk.openadsdk.exc.qdl.qdl.mo qdl(ljh ljhVar, Context context) {
        if (ljhVar != null && ljhVar.ygv() == 4) {
            return new com.bytedance.sdk.openadsdk.exc.qdl.qdl.mml(context, this.mo);
        }
        return null;
    }

    public void setIsMute(boolean z) {
        this.exu = z;
        View view = this.jl;
        if (view != null && (view instanceof com.bytedance.sdk.openadsdk.core.exu.ud.mo)) {
            ((com.bytedance.sdk.openadsdk.core.exu.ud.mo) view).qdl(z, "interactionStyle");
        }
    }

    public FrameLayout getVideoContainer() {
        return this.exc;
    }

    public void setDownloadListener(com.bytedance.sdk.openadsdk.core.lnr.mzz mzzVar) {
        this.aaj = mzzVar;
    }

    private float getHeightDp() {
        return ax.lnr(this.ud, ax.fs(this.ud));
    }

    private float getWidthDp() {
        return ax.lnr(this.ud, ax.exu(this.ud));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(float r10) {
        /*
            r9 = this;
            float r0 = r9.getHeightDp()
            float r1 = r9.getWidthDp()
            int r2 = r9.jtx
            r3 = 2
            if (r2 != r3) goto L16
            float r2 = java.lang.Math.max(r0, r1)
            float r0 = java.lang.Math.min(r0, r1)
            goto L1e
        L16:
            float r2 = java.lang.Math.min(r0, r1)
            float r0 = java.lang.Math.max(r0, r1)
        L1e:
            int r1 = r9.jtx
            if (r1 == r3) goto L38
            android.content.Context r1 = r9.ud
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r1 = com.bytedance.sdk.openadsdk.utils.ax.lnr(r1)
            if (r1 == 0) goto L38
            android.content.Context r1 = r9.ud
            float r4 = com.bytedance.sdk.openadsdk.utils.ax.qdl()
            int r1 = com.bytedance.sdk.openadsdk.utils.ax.lnr(r1, r4)
            float r1 = (float) r1
            float r0 = r0 - r1
        L38:
            int r1 = r9.jtx
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1120403456(0x42c80000, float:100.0)
            r6 = 1101004800(0x41a00000, float:20.0)
            r7 = 20
            r8 = 0
            if (r1 == r3) goto L5b
            int r1 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r1 == 0) goto L71
            int r1 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r1 == 0) goto L71
            float r2 = r2 - r6
            float r2 = r2 - r6
            float r2 = r2 / r10
            float r0 = r0 - r2
            float r0 = r0 / r4
            float r10 = java.lang.Math.max(r0, r8)
            int r10 = (int) r10
            r0 = r7
            r1 = r0
            r7 = r10
            goto L75
        L5b:
            int r1 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r1 == 0) goto L71
            int r1 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r1 == 0) goto L71
            float r0 = r0 - r6
            float r0 = r0 - r6
            float r0 = r0 * r10
            float r2 = r2 - r0
            float r2 = r2 / r4
            float r10 = java.lang.Math.max(r2, r8)
            int r10 = (int) r10
            r0 = r10
            r1 = r0
            r10 = r7
            goto L75
        L71:
            r7 = 0
            r10 = r7
            r0 = r10
            r1 = r0
        L75:
            android.content.Context r2 = r9.ud
            float r3 = (float) r7
            int r2 = com.bytedance.sdk.openadsdk.utils.ax.ud(r2, r3)
            android.content.Context r3 = r9.ud
            float r10 = (float) r10
            int r10 = com.bytedance.sdk.openadsdk.utils.ax.ud(r3, r10)
            android.content.Context r3 = r9.ud
            float r0 = (float) r0
            int r0 = com.bytedance.sdk.openadsdk.utils.ax.ud(r3, r0)
            android.content.Context r3 = r9.ud
            float r1 = (float) r1
            int r1 = com.bytedance.sdk.openadsdk.utils.ax.ud(r3, r1)
            android.content.Context r3 = r9.ud
            android.app.Activity r3 = (android.app.Activity) r3
            android.view.Window r3 = r3.getWindow()
            android.view.View r3 = r3.getDecorView()
            r3.setPadding(r0, r2, r1, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.view.lnr.qdl(float):void");
    }
}
