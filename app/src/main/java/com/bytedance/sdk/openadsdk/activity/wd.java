package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.activity.ud;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.core.widget.ud;
import com.bytedance.sdk.openadsdk.core.yt;
import com.facebook.AccessToken;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class wd extends qdl {
    private static String aaj;
    private static String bch;
    private static String jyq;
    private static String ljh;
    private static String oth;
    private int uw;

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    protected boolean a_() {
        return true;
    }

    public wd(ud udVar, ljh ljhVar, int i, int i2, boolean z) {
        super(udVar, ljhVar, i, i2, z);
        this.uw = -1;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.qdl, com.bytedance.sdk.openadsdk.activity.jpc
    public void qdl(Activity activity, ud.mzz mzzVar) {
        super.qdl(activity, mzzVar);
        if (com.bytedance.sdk.component.utils.ud.qdl(activity)) {
            return;
        }
        Intent intent = activity.getIntent();
        this.bjy = intent.getStringExtra("media_extra");
        this.rdp = intent.getStringExtra(AccessToken.USER_ID_KEY);
        try {
            if (ljh == null) {
                ljh = com.bytedance.sdk.component.utils.ljh.qdl(this.tvp.om, "tt_reward_msg");
                aaj = com.bytedance.sdk.component.utils.ljh.qdl(this.tvp.om, "tt_msgPlayable");
                oth = com.bytedance.sdk.component.utils.ljh.qdl(this.tvp.om, "tt_negtiveBtnBtnText");
                bch = com.bytedance.sdk.component.utils.ljh.qdl(this.tvp.om, "tt_postiveBtnText");
                jyq = com.bytedance.sdk.component.utils.ljh.qdl(this.tvp.om, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            aaj.lnr("TTAD.RewardAdScene", th.getMessage());
        }
        if (this.tvp == null || this.wd == null) {
            return;
        }
        this.tvp.gg = this.wd.qdl;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public String b_() {
        return "rewarded_video";
    }

    @Override // com.bytedance.sdk.openadsdk.activity.qdl
    protected void ud() {
        this.tvp.fco.qdl(null, TTAdDislikeToast.getSkipText());
        this.tvp.fco.mzz(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.qdl
    protected void mzz() {
        final View view = this.tvp.gy.to();
        if (view != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.wd.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (wd.this.tvp.hkc.aaj() && wd.this.tvp.to.get()) {
                        boolean zExu = wd.this.tvp.hzv.exu();
                        wd.this.tvp.hkc.mo(zExu);
                        wd.this.tvp.gy.mo(8);
                        wd.this.tvp.cx.sendEmptyMessageDelayed(600, 5000L);
                        if (!ljh.lnr(wd.this.tvp.ud)) {
                            return;
                        }
                        if (ljh.lnr(wd.this.tvp.ud) && zExu) {
                            return;
                        }
                    }
                    wd.this.tvp.hkc.jyq();
                    wd.this.tvp.hzv.rq();
                    wd.this.tvp.vu.mo();
                    if (vu.mml(wd.this.tvp.ud)) {
                        wd.this.qdl(true, true, (Runnable) null);
                    } else {
                        wd.this.wak();
                    }
                }
            };
            view.setOnClickListener(onClickListener);
            view.setTag(view.getId(), onClickListener);
        }
        this.tvp.fco.qdl(new com.bytedance.sdk.openadsdk.component.reward.top.ud() { // from class: com.bytedance.sdk.openadsdk.activity.wd.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void qdl(View view2) {
                wd wdVar = wd.this;
                wdVar.qdl(vu.lnr(wdVar.tvp.ud), false, (Runnable) null);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void qdl(View view2, String str) {
                wd.this.qdl(str);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void ud(View view2) {
                wd.this.c_();
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void lnr(View view2) {
                View view3 = view;
                if (view3 != null) {
                    view3.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void mml(View view2) {
                wd wdVar = wd.this;
                wdVar.qdl(wdVar.tvp);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void c_() {
        this.tvp.kdv.qdl(this.ud);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void qdl(String str) {
        com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm;
        com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
        if (this.ud != null && this.ud.mml() != null) {
            this.ud.mml().qdl(this.tvp.gt);
        }
        this.tvp.gt = !this.tvp.gt;
        if (this.tvp.bqt != null && this.tvp.bqt.qdl() != null) {
            this.tvp.bqt.qdl().setSoundMute(this.tvp.gt);
        }
        StringBuilder sb = new StringBuilder("will set is Mute ");
        sb.append(this.tvp.gt);
        sb.append(" mLastVolume=");
        sb.append(this.tvp.ekw.qdl());
        this.tvp.bch.qdl(this.tvp.gt, str);
        this.tvp.hkc.mzz(this.tvp.gt);
        if (this.tvp.ud == null || (mmlVarZm = this.tvp.ud.zm()) == null || (mmlVarQdl = mmlVarZm.qdl()) == null) {
            return;
        }
        if (this.tvp.gt) {
            mmlVarQdl.jpc(this.tvp.bch.fs());
        } else {
            mmlVarQdl.tvp(this.tvp.bch.fs());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public boolean d_() {
        return this.tvp.gt;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc, com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void ud(int i) {
        if (i == 10000) {
            xi();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.qdl
    public FrameLayout jpc() {
        if (this.mo.mo()) {
            if (this.tvp == null || this.tvp.bqt == null) {
                return null;
            }
            return this.tvp.bqt.ud();
        }
        if (this.tvp == null || this.tvp.gy == null) {
            return null;
        }
        return this.tvp.gy.mo();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.qdl, com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void jl() {
        xi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qdl(final boolean z, boolean z2, final Runnable runnable) {
        if (!z2 && this.wd.rq().getBoolean("user_has_give_up_reward", false) && runnable != null) {
            return false;
        }
        if (!yt.mml().jpc(String.valueOf(this.tvp.mo))) {
            if (runnable == null) {
                if (z) {
                    wak();
                    return false;
                }
                dk();
            }
            return false;
        }
        if (this.wd.rq().getBoolean("reward_verify", false)) {
            if (runnable == null) {
                if (z) {
                    wak();
                    return false;
                }
                dk();
            }
            return false;
        }
        this.tvp.aaj.set(true);
        this.tvp.bch.jyq();
        if (z) {
            this.tvp.xmv.mo();
        }
        final com.bytedance.sdk.openadsdk.core.widget.ud udVar = new com.bytedance.sdk.openadsdk.core.widget.ud(yh());
        this.ud.exu = udVar;
        if (z) {
            this.ud.exu.qdl(aaj).ud(jyq).lnr(oth);
        } else {
            this.ud.exu.qdl(ljh).ud(bch).lnr(oth);
        }
        this.ud.exu.qdl(new ud.InterfaceC0259ud() { // from class: com.bytedance.sdk.openadsdk.activity.wd.3
            @Override // com.bytedance.sdk.openadsdk.core.widget.ud.InterfaceC0259ud
            public void qdl() {
                wd.this.tvp.bch.aaj();
                if (z) {
                    wd.this.tvp.xmv.qdl(1000);
                }
                udVar.dismiss();
                wd.this.tvp.aaj.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ud.InterfaceC0259ud
            public void ud() {
                udVar.dismiss();
                wd.this.wd.rq().putBoolean("user_has_give_up_reward", true);
                wd.this.tvp.aaj.set(false);
                wd.this.tvp.xmv.ud(Integer.MAX_VALUE);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                } else if (!z) {
                    wd.this.dk();
                } else {
                    wd.this.tvp.vu.mo();
                    wd.this.wak();
                }
            }
        }).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void dk() {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r0 = r3.tvp
            com.bytedance.sdk.openadsdk.component.reward.qdl.bjy r0 = r0.bch
            r0.rc()
            com.bytedance.sdk.openadsdk.mml.mzz.ud.bjy$qdl r0 = new com.bytedance.sdk.openadsdk.mml.mzz.ud.bjy$qdl
            r0.<init>()
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r1 = r3.tvp
            com.bytedance.sdk.openadsdk.component.reward.qdl.bjy r1 = r1.bch
            long r1 = r1.fs()
            r0.ud(r1)
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r1 = r3.tvp
            com.bytedance.sdk.openadsdk.component.reward.qdl.bjy r1 = r1.bch
            long r1 = r1.uw()
            r0.mml(r1)
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r1 = r3.tvp
            com.bytedance.sdk.openadsdk.component.reward.qdl.bjy r1 = r1.bch
            long r1 = r1.jtx()
            r0.lnr(r1)
            r1 = 3
            r0.lnr(r1)
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r1 = r3.tvp
            com.bytedance.sdk.openadsdk.component.reward.qdl.bjy r1 = r1.bch
            int r1 = r1.bch()
            r0.mml(r1)
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r1 = r3.tvp
            com.bytedance.sdk.openadsdk.component.reward.qdl.bjy r1 = r1.bch
            long r1 = r1.ud()
            r0.qdl(r1)
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r1 = r3.tvp
            com.bytedance.sdk.openadsdk.component.reward.qdl.bjy r1 = r1.bch
            com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl r1 = r1.jpc()
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r2 = r3.tvp
            com.bytedance.sdk.openadsdk.component.reward.qdl.bjy r2 = r2.bch
            com.bytedance.sdk.openadsdk.mml.wd r2 = r2.mzz()
            com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.qdl(r1, r0, r2)
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r0 = r3.tvp
            int r0 = r0.mo
            com.bytedance.sdk.openadsdk.core.bqt.lnr(r0)
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r0 = r3.tvp
            com.bytedance.sdk.openadsdk.component.reward.qdl.bjy r0 = r0.bch
            java.lang.String r1 = "skip"
            r2 = 0
            r0.qdl(r1, r2)
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r0 = r3.tvp
            boolean r0 = r0.lnr
            if (r0 == 0) goto L8a
            r0 = 1
            r1 = 4
            r3.qdl(r0, r1)
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r0 = r3.tvp
            com.bytedance.sdk.openadsdk.core.model.ljh r0 = r0.ud
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.aaj.qdl(r0)
            if (r0 == 0) goto L8d
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r0 = r3.tvp
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.jtx
            boolean r0 = r0.get()
            if (r0 != 0) goto L8d
        L8a:
            r3.wak()
        L8d:
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r0 = r3.tvp
            com.bytedance.sdk.openadsdk.core.model.ljh r0 = r0.ud
            com.bytedance.sdk.openadsdk.core.model.mml r0 = r0.zm()
            if (r0 == 0) goto Lab
            com.bytedance.sdk.openadsdk.core.fs.mml r0 = r0.qdl()
            if (r0 == 0) goto Lab
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r1 = r3.tvp
            com.bytedance.sdk.openadsdk.component.reward.qdl.bjy r1 = r1.bch
            long r1 = r1.fs()
            r0.mo(r1)
            r0.mzz(r1)
        Lab:
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r0 = r3.tvp
            com.bytedance.sdk.openadsdk.core.model.ljh r0 = r0.ud
            r1 = 5
            com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.wd.dk():void");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.qdl, com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void qdl(final String str, final JSONObject jSONObject) {
        if ("skipToNextAd".equals(str) && this.tvp.lq != null && this.wd.ljh() == null && qdl(vu.lnr(this.tvp.ud), false, new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.wd.4
            @Override // java.lang.Runnable
            public void run() {
                wd.super.qdl(str, jSONObject);
            }
        })) {
            return;
        }
        super.qdl(str, jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void ax() {
        super.ax();
        this.mzz = false;
        this.tvp.bqt.ud(false);
        this.tvp.bch.wc();
    }
}
