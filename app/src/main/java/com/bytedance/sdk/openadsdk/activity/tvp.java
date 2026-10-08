package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.ud;
import com.bytedance.sdk.openadsdk.core.model.aaj;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.rdp.rq;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.rdp;
import com.bytedance.sdk.openadsdk.utils.tvp;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class tvp extends lnr {
    private mzz bjy;
    private ud.AbstractC0222ud exu;
    private com.bytedance.sdk.openadsdk.core.mo.jpc fs;
    private boolean jl;
    private com.bytedance.sdk.openadsdk.component.reward.top.lnr jpc;
    private jpc jtx;
    public rdp mo;
    private int rdp;
    private com.bytedance.sdk.openadsdk.core.mo.lnr rq;
    private com.bytedance.sdk.openadsdk.core.mo.lnr to;
    private rq tvp;
    private final List<jpc> wd;
    private int yt;

    public tvp(Activity activity, ljh ljhVar, ud udVar) {
        super(activity, ljhVar, udVar);
        this.wd = new ArrayList();
        this.jl = false;
        this.to = new com.bytedance.sdk.openadsdk.core.mo.lnr(activity);
        if (Build.VERSION.SDK_INT >= 35) {
            this.to.setFitsSystemWindows(true);
        }
        activity.setContentView(this.to);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl() {
        super.qdl();
        jyq();
    }

    private void jyq() {
        boolean zRdp = com.bytedance.sdk.openadsdk.core.settings.rq.lnr().rdp(String.valueOf(this.ud.fz()));
        int iUd = this.mml.mzz() ? ud(0, zRdp) : 0;
        if (this.wd.isEmpty() && !vu.lnr(this.ud)) {
            int i = iUd + 1;
            this.wd.add(qdl(this.mml, this.ud, iUd, i, true));
            iUd = i;
        }
        qdl(iUd, zRdp);
    }

    private static jpc qdl(ud udVar, ljh ljhVar, int i, int i2, boolean z) {
        boolean zMq = ljhVar.mq();
        AdSlot adSlotJi = ljhVar.ji();
        if (adSlotJi == null ? zMq : adSlotJi.getDurationSlotType() == 7) {
            return new wd(udVar, ljhVar, i, i2, z);
        }
        return new mo(udVar, ljhVar, i, i2, z);
    }

    private void qdl(int i, boolean z) {
        if (rdp() == null && this.mml.mzz()) {
            oth();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0164 A[PHI: r11
  0x0164: PHI (r11v5 int) = (r11v4 int), (r11v6 int), (r11v4 int), (r11v4 int) binds: [B:26:0x00ef, B:40:0x014a, B:30:0x00ff, B:31:0x0101] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int ud(int r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.tvp.ud(int, boolean):int");
    }

    private void oth() {
        this.mo = com.bytedance.sdk.openadsdk.utils.tvp.qdl(this.qdl, new tvp.qdl() { // from class: com.bytedance.sdk.openadsdk.activity.tvp.1
            @Override // com.bytedance.sdk.openadsdk.utils.tvp.qdl
            public View qdl() {
                if (tvp.this.jpc != null) {
                    return tvp.this.jpc.getCloseButton();
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.utils.tvp.qdl
            public void ud() {
                if (tvp.this.jpc != null) {
                    tvp.this.jpc.setSkipInvisiable();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(Bundle bundle) {
        super.qdl(bundle);
        this.rq = new com.bytedance.sdk.openadsdk.core.mo.lnr(this.qdl);
        this.to.addView(this.rq, new FrameLayout.LayoutParams(-1, -1));
        this.tvp = new rq(this.qdl);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ax.ud(this.qdl, 2.0f));
        layoutParams.gravity = 80;
        this.to.addView(this.tvp, layoutParams);
        com.bytedance.sdk.openadsdk.core.mo.jpc jpcVar = new com.bytedance.sdk.openadsdk.core.mo.jpc(this.qdl);
        this.fs = jpcVar;
        jpcVar.setTextColor(-1);
        this.fs.setTextSize(15.0f);
        this.fs.setShadowLayer(1.0f, 0.0f, 1.0f, -16777216);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = ax.ud(this.qdl, 60.0f);
        layoutParams2.rightMargin = ax.ud(this.qdl, 16.0f);
        layoutParams2.gravity = BadgeDrawable.TOP_END;
        this.to.addView(this.fs, layoutParams2);
        com.bytedance.sdk.openadsdk.component.reward.top.lnr lnrVar = new com.bytedance.sdk.openadsdk.component.reward.top.lnr(this.qdl);
        this.jpc = lnrVar;
        this.to.addView(lnrVar, new FrameLayout.LayoutParams(-1, -2));
        this.jpc.qdl(this.ud);
        this.jpc.setShowDislike(true);
        qdl(null, null, new ud.mzz(1, null));
    }

    public int aaj() {
        jpc jpcVar = this.jtx;
        if (jpcVar != null) {
            return jpcVar.to;
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(jpc jpcVar, jpc jpcVar2, ud.mzz mzzVar) {
        jpc jpcVar3 = this.jtx;
        if ((jpcVar3 == null || jpcVar3 == jpcVar) && !com.bytedance.sdk.component.utils.ud.qdl(this.qdl)) {
            aaj();
            if (jpcVar2 == null) {
                jpc jpcVar4 = this.jtx;
                int i = jpcVar4 != null ? jpcVar4.to + 1 : 0;
                if (i < this.wd.size()) {
                    jpcVar2 = this.wd.get(i);
                }
                if (jpcVar2 == null) {
                    this.mml.mo();
                    return;
                }
            }
            jpc jpcVar5 = this.jtx;
            if (jpcVar5 != null) {
                if (jpcVar5 == jpcVar2) {
                    return;
                }
                jpcVar5.rdp();
                this.jtx.mml();
                com.bytedance.sdk.openadsdk.component.reward.view.tvp tvpVarQdl = this.jtx.qdl();
                if (tvpVarQdl != null) {
                    this.rq.removeView(tvpVarQdl);
                }
                this.jtx.aaj();
                this.jtx.fs = false;
                if (this.mml.mml()) {
                    jpc jpcVar6 = this.jtx;
                    if (jpcVar6 instanceof qdl) {
                        int i2 = jpcVar6.to + 1;
                        jpc jpcVar7 = i2 < this.wd.size() ? this.wd.get(i2) : null;
                        if ((jpcVar7 instanceof mzz) && jpcVar7 != jpcVar2) {
                            com.bytedance.sdk.openadsdk.component.reward.view.tvp tvpVarQdl2 = jpcVar7.qdl();
                            if (tvpVarQdl2 != null && tvpVarQdl2.getParent() != null && (tvpVarQdl2.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) tvpVarQdl2.getParent()).removeView(tvpVarQdl2);
                            }
                            jpcVar7.aaj();
                        }
                    }
                }
            }
            if (com.bytedance.sdk.component.utils.ud.qdl(this.qdl)) {
                return;
            }
            jpcVar2.fs = true;
            jpc jpcVar8 = this.jtx;
            this.jtx = jpcVar2;
            ud(jpcVar8, jpcVar2, mzzVar);
            jpcVar2.ud(this.qdl, mzzVar);
            com.bytedance.sdk.openadsdk.component.reward.view.tvp tvpVarQdl3 = jpcVar2.qdl();
            if (tvpVarQdl3 != null) {
                ViewParent parent = tvpVarQdl3.getParent();
                if (parent != null) {
                    if (parent == this.rq) {
                        tvpVarQdl3.setVisibility(0);
                    } else if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(tvpVarQdl3);
                    }
                }
                if (tvpVarQdl3.getParent() == null) {
                    this.rq.addView(tvpVarQdl3, new ViewGroup.LayoutParams(-1, -1));
                }
            }
            for (int i3 = jpcVar8 != null ? jpcVar8.to : 0; i3 < this.wd.size(); i3++) {
                this.wd.get(i3).qdl(jpcVar8, this.jtx, mzzVar);
            }
            this.mml.ud(this.jtx);
        }
    }

    private void ud(jpc jpcVar, jpc jpcVar2, ud.mzz mzzVar) {
        if (this.exu == null) {
            if (jpcVar2 instanceof mo) {
                this.exu = new ud.qdl(this.mml, this.ud, this.jpc);
            } else {
                this.exu = new ud.mml(this.mml, this.ud, this.jpc);
            }
        }
        this.exu.ud();
        int iUd = ud(jpcVar2);
        boolean z = jpcVar2 instanceof mzz;
        if (z && !((mzz) jpcVar2).qdl && !jpcVar2.jtx && jpcVar2.mo != null && jpcVar2.mo.jc()) {
            this.exu.mml();
        } else {
            this.exu.qdl(iUd, jpcVar2.mo);
            if (z && ((mzz) jpcVar2).qdl) {
                mml(jpcVar);
            } else if (jpcVar2.mo.vg()) {
                boolean z2 = false;
                boolean z3 = (jpcVar2 instanceof qdl) && aaj.mzz(jpcVar2.mo);
                if (z && (jpcVar2.jtx || aaj.mo(jpcVar2.mo))) {
                    z2 = true;
                }
                if (z3 || z2) {
                    this.exu.qdl(jpcVar2);
                }
            } else if (jpcVar2.jtx) {
                this.exu.qdl(jpcVar2.mo, jpcVar2.yt);
            } else if (z) {
                this.exu.lnr(jpcVar2.mo.raf().mml());
            }
        }
        rdp rdpVar = this.mo;
        if (rdpVar != null && jpcVar == null) {
            rdpVar.qdl(iUd * 1000);
        }
        if (jpcVar2 instanceof qdl) {
            this.yt++;
            qdl(0.0f);
            if (aaj.mzz(jpcVar2.mo)) {
                this.fs.setVisibility(8);
                return;
            } else {
                lnr(jpcVar2);
                return;
            }
        }
        if (z) {
            if (((mzz) jpcVar2).qdl) {
                this.fs.setVisibility(8);
                return;
            }
            if (jpcVar2.jtx && vu.lnr(jpcVar2.mo)) {
                this.yt++;
            }
            if (jpcVar2.jtx || aaj.mo(jpcVar2.mo)) {
                this.fs.setVisibility(8);
            } else {
                lnr(jpcVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int ud(com.bytedance.sdk.openadsdk.activity.jpc r9) {
        /*
            r8 = this;
            int r9 = r9.to
            r0 = 0
        L3:
            java.util.List<com.bytedance.sdk.openadsdk.activity.jpc> r1 = r8.wd
            int r1 = r1.size()
            if (r9 >= r1) goto L9b
            java.util.List<com.bytedance.sdk.openadsdk.activity.jpc> r1 = r8.wd
            java.lang.Object r1 = r1.get(r9)
            com.bytedance.sdk.openadsdk.activity.jpc r1 = (com.bytedance.sdk.openadsdk.activity.jpc) r1
            boolean r2 = r1 instanceof com.bytedance.sdk.openadsdk.activity.mzz
            if (r2 == 0) goto L1e
            r3 = r1
            com.bytedance.sdk.openadsdk.activity.mzz r3 = (com.bytedance.sdk.openadsdk.activity.mzz) r3
            boolean r3 = r3.qdl
            if (r3 != 0) goto L9b
        L1e:
            boolean r3 = r1.jtx
            com.bytedance.sdk.openadsdk.core.model.ljh r4 = r1.mo
            boolean r4 = com.bytedance.sdk.openadsdk.core.model.aaj.mo(r4)
            com.bytedance.sdk.openadsdk.core.model.ljh r5 = r1.mo
            boolean r5 = com.bytedance.sdk.openadsdk.core.model.aaj.mzz(r5)
            com.bytedance.sdk.openadsdk.core.model.ljh r6 = r1.mo
            com.bytedance.sdk.openadsdk.core.model.bch r6 = r6.qdl()
            if (r6 == 0) goto L39
            int r6 = r6.lnr()
            goto L3b
        L39:
            r6 = 10
        L3b:
            boolean r7 = r1 instanceof com.bytedance.sdk.openadsdk.activity.qdl
            if (r7 == 0) goto L59
            if (r5 == 0) goto L43
        L41:
            int r0 = r0 + r6
            goto L97
        L43:
            com.bytedance.sdk.openadsdk.core.model.ljh r1 = r1.mo
            com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud r1 = r1.tdy()
            if (r1 == 0) goto L53
            double r2 = (double) r0
            double r0 = r1.mo()
            double r2 = r2 + r0
            int r0 = (int) r2
            goto L97
        L53:
            long r0 = (long) r0
            r2 = 10
            long r0 = r0 + r2
            int r0 = (int) r0
            goto L97
        L59:
            if (r2 == 0) goto L97
            if (r4 == 0) goto L5e
            goto L41
        L5e:
            if (r3 == 0) goto L78
            com.bytedance.sdk.openadsdk.core.model.ljh r2 = r1.mo
            boolean r2 = r2.vg()
            if (r2 == 0) goto L69
            goto L41
        L69:
            com.bytedance.sdk.openadsdk.core.model.ljh r2 = r1.mo
            int r2 = com.bytedance.sdk.openadsdk.core.model.vu.jyq(r2)
            com.bytedance.sdk.openadsdk.core.model.ljh r1 = r1.mo
            int r1 = com.bytedance.sdk.openadsdk.core.model.vu.uw(r1)
            int r2 = r2 + r1
            int r0 = r0 + r2
            goto L97
        L78:
            com.bytedance.sdk.openadsdk.activity.ud r2 = r8.mml
            boolean r2 = r2.mml()
            if (r2 == 0) goto L97
            com.bytedance.sdk.openadsdk.core.model.ljh r2 = r1.mo
            if (r2 == 0) goto L97
            com.bytedance.sdk.openadsdk.core.model.ljh r2 = r1.mo
            boolean r2 = r2.jc()
            if (r2 != 0) goto L97
            com.bytedance.sdk.openadsdk.core.model.ljh r1 = r1.mo
            com.bytedance.sdk.openadsdk.core.model.xmv r1 = r1.raf()
            int r1 = r1.mml()
            int r0 = r0 + r1
        L97:
            int r9 = r9 + 1
            goto L3
        L9b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.tvp.ud(com.bytedance.sdk.openadsdk.activity.jpc):int");
    }

    private void lnr(jpc jpcVar) {
        try {
            this.fs.setText(this.qdl.getString(com.bytedance.sdk.component.utils.ljh.ud(yt.qdl(), "tt_multiple_ad_indicator"), new Object[]{Integer.valueOf(jpcVar.rq + 1), Integer.valueOf(this.rdp)}));
            this.fs.setVisibility(0);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.qdl("SeqSwitchLayoutManager", "updateCurrentAdIndex: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(int i, int i2) {
        super.qdl(i, i2);
        if (i >= 0) {
            if (TextUtils.isEmpty(this.lnr)) {
                this.fs.setText(this.qdl.getString(com.bytedance.sdk.component.utils.ljh.ud(yt.qdl(), "tt_multiple_playable_wait_tips"), new Object[]{Integer.valueOf(i)}));
            } else {
                this.fs.setText(String.format(this.lnr, Integer.valueOf(i)));
            }
            this.fs.setVisibility(0);
            return;
        }
        this.fs.setVisibility(8);
    }

    private void mml(jpc jpcVar) {
        rq rqVar = this.tvp;
        if (rqVar != null) {
            ax.wd(rqVar);
            this.tvp = null;
        }
        com.bytedance.sdk.openadsdk.component.reward.top.lnr lnrVar = this.jpc;
        if (lnrVar != null) {
            ax.wd(lnrVar);
            ax.wd(this.jpc.getITopLayout());
            this.jpc = null;
        }
        ud.AbstractC0222ud abstractC0222ud = this.exu;
        if (abstractC0222ud != null) {
            abstractC0222ud.lnr();
        }
        if (jpcVar instanceof wd) {
            ((wd) jpcVar).xi();
        }
        rdp rdpVar = this.mo;
        if (rdpVar != null) {
            rdpVar.lnr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void ud() {
        super.ud();
        jpc jpcVar = this.jtx;
        if (jpcVar != null) {
            jpcVar.lnr();
        }
        ud.AbstractC0222ud abstractC0222ud = this.exu;
        if (abstractC0222ud != null) {
            abstractC0222ud.ud(-1);
        }
        rdp rdpVar = this.mo;
        if (rdpVar != null) {
            rdpVar.qdl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void lnr() {
        super.lnr();
        jpc jpcVar = this.jtx;
        if (jpcVar != null) {
            jpcVar.rdp();
        }
        ud.AbstractC0222ud abstractC0222ud = this.exu;
        if (abstractC0222ud != null) {
            abstractC0222ud.qdl(-1);
        }
        rdp rdpVar = this.mo;
        if (rdpVar != null) {
            rdpVar.ud();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(Activity activity) {
        super.qdl(activity);
        jpc jpcVar = this.jtx;
        if (jpcVar != null) {
            jpcVar.ud(activity);
        }
        int iAaj = aaj();
        for (jpc jpcVar2 : this.wd) {
            if (jpcVar2.to >= iAaj) {
                jpcVar2.aaj();
            }
        }
        ud.AbstractC0222ud abstractC0222ud = this.exu;
        if (abstractC0222ud != null) {
            abstractC0222ud.lnr();
        }
        rdp rdpVar = this.mo;
        if (rdpVar != null) {
            rdpVar.lnr();
        }
        jpc jpcVar3 = this.jtx;
        if (jpcVar3 != null && !jpcVar3.ljh() && !this.ud.ilu()) {
            com.bytedance.sdk.openadsdk.core.rdp.ud().post(new ud.lnr(this.ud));
        }
        this.jtx = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public mzz rdp() {
        mzz mzzVar = this.bjy;
        if (mzzVar != null) {
            return mzzVar;
        }
        jpc jpcVar = this.jtx;
        int i = jpcVar != null ? jpcVar.to : -1;
        int size = this.wd.size() - 1;
        while (true) {
            if (size <= i) {
                break;
            }
            jpc jpcVar2 = this.wd.get(size);
            if (jpcVar2 instanceof mzz) {
                mzz mzzVar2 = (mzz) jpcVar2;
                if (mzzVar2.qdl) {
                    this.bjy = mzzVar2;
                    break;
                }
            }
            size--;
        }
        return this.bjy;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public jpc exu() {
        jpc jpcVar = this.jtx;
        if (jpcVar == null) {
            return null;
        }
        int i = jpcVar.to;
        while (true) {
            i++;
            if (i >= this.wd.size()) {
                return null;
            }
            jpc jpcVar2 = this.wd.get(i);
            if (jpcVar2 instanceof qdl) {
                return jpcVar2;
            }
            if ((jpcVar2 instanceof mzz) && vu.lnr(jpcVar2.mo) && jpcVar2.jtx) {
                return jpcVar2;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(float f) {
        rq rqVar = this.tvp;
        if (rqVar == null) {
            return;
        }
        rqVar.setProgress(f);
        if (f == 0.0f && this.tvp.getVisibility() == 0) {
            this.tvp.setVisibility(4);
        } else {
            if (f <= 0.0f || this.tvp.getVisibility() == 0) {
                return;
            }
            this.tvp.setVisibility(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public com.bytedance.sdk.openadsdk.component.reward.top.lnr fs() {
        return this.jpc;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public int jpc() {
        ud.AbstractC0222ud abstractC0222ud = this.exu;
        if (abstractC0222ud != null) {
            return abstractC0222ud.qdl();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(int i) {
        ud.AbstractC0222ud abstractC0222ud = this.exu;
        if (abstractC0222ud != null) {
            if (i == 2) {
                abstractC0222ud.qdl(2);
            } else if (i == 1) {
                abstractC0222ud.ud(1);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void ud(jpc jpcVar, int i) {
        ud.AbstractC0222ud abstractC0222ud = this.exu;
        if (abstractC0222ud == null) {
            return;
        }
        if (i == 2) {
            abstractC0222ud.qdl(i);
            rdp rdpVar = this.mo;
            if (rdpVar != null) {
                rdpVar.ud();
                return;
            }
            return;
        }
        if (i == 1) {
            abstractC0222ud.ud(i);
            rdp rdpVar2 = this.mo;
            if (rdpVar2 != null) {
                rdpVar2.qdl();
                return;
            }
            return;
        }
        if (i == 3 || i == 4) {
            try {
                this.jtx.xmv().bch.rc();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.aaj.lnr("SeqSwitchLayoutManager", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(jpc jpcVar, ud.mzz mzzVar) {
        jpc jpcVar2 = this.jtx;
        if (jpcVar2 == null || jpcVar2 == jpcVar) {
            if (jpcVar2 != null && (jpcVar2 instanceof qdl)) {
                final long jExu = (jpcVar2.xmv() == null || this.jtx.xmv().bch == null) ? 0L : this.jtx.xmv().bch.exu();
                final int i = this.jtx.rq + 1;
                com.bytedance.sdk.openadsdk.mml.lnr.qdl(System.currentTimeMillis(), this.jtx.mo, this.jtx.b_(), "dislike_skip", new com.bytedance.sdk.openadsdk.bjy.lnr.qdl() { // from class: com.bytedance.sdk.openadsdk.activity.tvp.2
                    @Override // com.bytedance.sdk.openadsdk.bjy.lnr.qdl, com.bytedance.sdk.openadsdk.bjy.lnr.ud
                    public JSONObject ud() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(TypedValues.TransitionType.S_DURATION, jExu);
                        } catch (Throwable unused) {
                        }
                        return jSONObject;
                    }

                    @Override // com.bytedance.sdk.openadsdk.bjy.lnr.qdl, com.bytedance.sdk.openadsdk.bjy.lnr.ud
                    public JSONObject qdl() {
                        return com.bytedance.sdk.openadsdk.mml.lnr.qdl(i);
                    }
                });
            }
            jpc jpcVarExu = exu();
            if (jpcVarExu == null) {
                jpcVarExu = rdp();
            }
            qdl(this.jtx, jpcVarExu, mzzVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(jpc jpcVar, boolean z, boolean z2, boolean z3, int i) {
        mzz mzzVarRdp;
        jpc jpcVar2 = this.jtx;
        if ((jpcVar2 == null || jpcVar2 == jpcVar) && (mzzVarRdp = rdp()) != null) {
            ud.mzz mzzVar = new ud.mzz(i, jpcVar != null ? jpcVar.xmv() : null);
            mzzVar.qdl.putBoolean("isSkip", z);
            mzzVar.qdl.putBoolean("force", z2);
            mzzVar.qdl.putBoolean("isFromLandingPage", z3);
            qdl(this.jtx, mzzVarRdp, mzzVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public boolean mml() {
        if (this.wd.isEmpty()) {
            return false;
        }
        List<jpc> list = this.wd;
        jpc jpcVar = list.get(list.size() - 1);
        return (jpcVar instanceof mzz) && ((mzz) jpcVar).qdl;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(qdl qdlVar, boolean z) {
        ud.AbstractC0222ud abstractC0222ud;
        super.qdl(qdlVar, z);
        if (qdlVar == null || qdlVar != this.jtx || (abstractC0222ud = this.exu) == null) {
            return;
        }
        abstractC0222ud.ud(z);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(jpc jpcVar) {
        ud.AbstractC0222ud abstractC0222ud;
        super.qdl(jpcVar);
        if (jpcVar == null) {
            return;
        }
        com.bytedance.sdk.component.utils.aaj.qdl("SeqSwitchLayoutManager", "onPlayableLoadingDismiss [scene=]" + jpcVar + ",isActive=" + jpcVar.fs);
        if (jpcVar.fs && (abstractC0222ud = this.exu) != null) {
            abstractC0222ud.mo();
        }
        jpc jpcVarExu = exu();
        if (jpcVarExu instanceof qdl) {
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVarXmv = jpcVarExu.xmv();
            if (qdlVarXmv == null || !aaj.mzz(qdlVarXmv.ud)) {
                ((qdl) jpcVarExu).oth();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(jpc jpcVar, boolean z) {
        ud.AbstractC0222ud abstractC0222ud;
        super.qdl(jpcVar, z);
        if (jpcVar == null) {
            return;
        }
        com.bytedance.sdk.component.utils.aaj.qdl("SeqSwitchLayoutManager", "setIsHappenInteraction [scene=]" + jpcVar + ",isActive=" + jpcVar.fs + ",isHappenInteraction=" + z);
        if (!jpcVar.fs || (abstractC0222ud = this.exu) == null) {
            return;
        }
        abstractC0222ud.qdl(z);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(View view) {
        super.qdl(view);
        if (view.getParent() != null) {
            return;
        }
        view.setVisibility(4);
        this.rq.addView(view, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(View view, boolean z) {
        super.qdl(view, z);
        if (view.getParent() == null && this.rq != null) {
            view.setVisibility(4);
            int childCount = this.rq.getChildCount();
            if (z) {
                this.rq.addView(view, 0);
            } else {
                this.rq.addView(view, childCount - 1);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public boolean qdl(jpc jpcVar, int i) {
        return i == this.wd.size() - 1 && this.wd.get(i) != null && (this.wd.get(i) instanceof mzz);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void mo() {
        super.mo();
        jpc jpcVar = this.jtx;
        if (jpcVar != null) {
            jpcVar.exu();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void qdl(boolean z) {
        super.qdl(z);
        jpc jpcVar = this.jtx;
        if (jpcVar != null) {
            jpcVar.lnr(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void wd() {
        super.wd();
        jpc jpcVar = this.jtx;
        if (jpcVar != null) {
            jpcVar.mml();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void ud(Activity activity) {
        super.ud(activity);
        jpc jpcVar = this.jtx;
        if (jpcVar != null) {
            jpcVar.qdl(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void tvp() {
        super.tvp();
        jpc jpcVar = this.jtx;
        if (jpcVar != null) {
            jpcVar.jyq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public int to() {
        return this.yt;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public jpc rq() {
        return this.jtx;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public List<ljh> bjy() {
        return this.ud.gxp();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void jl() {
        ud.AbstractC0222ud abstractC0222ud = this.exu;
        if (abstractC0222ud != null) {
            abstractC0222ud.jpc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.lnr
    public void exc() {
        ud.AbstractC0222ud abstractC0222ud = this.exu;
        if (abstractC0222ud != null) {
            abstractC0222ud.tvp();
        }
    }
}
