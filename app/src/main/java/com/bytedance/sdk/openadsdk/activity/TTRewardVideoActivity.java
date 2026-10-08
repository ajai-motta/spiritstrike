package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.jl;
import com.bytedance.sdk.component.utils.ljh;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.rq;
import com.bytedance.sdk.openadsdk.core.koa;
import com.bytedance.sdk.openadsdk.core.ljh;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.core.oth;
import com.bytedance.sdk.openadsdk.core.widget.ud;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.utils.uw;
import com.facebook.AccessToken;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static String aaj;
    private static String exc;
    private static String jl;
    private static String jyq;
    private static String oth;
    private static com.bytedance.sdk.openadsdk.qdl.mzz.qdl uw;
    private String bch;
    protected int bjy;
    protected int jtx;
    private boolean koa;
    private String ljh;
    protected com.bytedance.sdk.openadsdk.qdl.mzz.qdl yt;
    private final AtomicBoolean xmv = new AtomicBoolean(false);
    private int bqt = -1;

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean aaj() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean jyq() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void qdl(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!this.exu) {
            uw = this.yt;
        }
        if (this.xmv.get() && this.ud != null) {
            this.ud.ud.hzv();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (jl == null) {
                jl = ljh.qdl(this, "tt_reward_msg");
                exc = ljh.qdl(this, "tt_msgPlayable");
                aaj = ljh.qdl(this, "tt_negtiveBtnBtnText");
                jyq = ljh.qdl(this, "tt_postiveBtnText");
                oth = ljh.qdl(this, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            aaj.lnr("TTAD.RVA", th.getMessage());
        }
        if (bundle == null || this.ud == null || this.ud.ud == null || !this.ud.ud.fco()) {
            return;
        }
        this.xmv.set(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void lnr() {
        super.lnr();
        if (this.xmv.get() || this.ud == null) {
            return;
        }
        this.ud.gg = new rq(new rq.qdl() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.component.reward.rq.qdl
            public void qdl() {
                if (TTRewardVideoActivity.this.xmv.get() || TTRewardVideoActivity.this.koa) {
                    return;
                }
                TTRewardVideoActivity.this.lnr(1);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.ud == null || this.ud.gg == null) {
            return;
        }
        this.ud.gg.ud();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void to() {
        com.bytedance.sdk.openadsdk.component.reward.view.mml mmlVarQdl;
        super.to();
        if (this.ud == null || (mmlVarQdl = this.ud.bqt.qdl()) == null) {
            return;
        }
        mmlVarQdl.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.mzz() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.mzz
            public void qdl() {
                TTRewardVideoActivity.this.kdv();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.ud == null || this.ud.gg == null) {
            return;
        }
        this.ud.gg.qdl();
    }

    protected void qdl(String str) {
        qdl(str, false, 0, "", 0, "");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.exu) {
            return;
        }
        uw = null;
    }

    private void qdl(final String str, final boolean z, final int i, final String str2, final int i2, final String str3) {
        fco.lnr(new com.bytedance.sdk.component.jpc.jpc("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTRewardVideoActivity.this.qdl(0).executeRewardVideoCallback(TTRewardVideoActivity.this.ud.wak, str, z, i, str2, i2, str3);
                } catch (Throwable th) {
                    aaj.lnr("TTAD.RVA", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void qdl(Bundle bundle) {
        if (this.exu) {
            super.qdl(bundle);
            this.yt = (com.bytedance.sdk.openadsdk.qdl.mzz.qdl) koa.qdl().qdl(this.tvp, com.bytedance.sdk.openadsdk.qdl.mzz.qdl.class);
        } else {
            if (!com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                this.yt = koa.qdl().ud();
            }
            if (this.yt == null && bundle != null) {
                this.yt = uw;
                uw = null;
            }
        }
        Log.e("TTAD.RVA", "initListener: listenerKey = " + this.tvp + ",mRewardAdInteractionListener = " + this.yt + ",savedInstanceState = " + bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void mml() {
        this.ud.fco.qdl(null, TTAdDislikeToast.getSkipText());
        this.ud.fco.mzz(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void exc() {
        final View view = this.ud.gy.to();
        if (view != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TTRewardVideoActivity.this.ud.hkc.aaj() && TTRewardVideoActivity.this.ud.to.get()) {
                        boolean zExu = TTRewardVideoActivity.this.ud.hzv.exu();
                        TTRewardVideoActivity.this.ud.hkc.mo(zExu);
                        TTRewardVideoActivity.this.ud.gy.mo(8);
                        View view3 = view;
                        if (view3 instanceof com.bytedance.sdk.openadsdk.core.mo.mml) {
                            ((com.bytedance.sdk.openadsdk.core.mo.mml) view3).setImageResource(ljh.mml(TTRewardVideoActivity.this.ud.om, "tt_close_btn"));
                        }
                        TTRewardVideoActivity.this.ud.cx.sendEmptyMessageDelayed(600, 5000L);
                        if (!com.bytedance.sdk.openadsdk.core.model.ljh.lnr(TTRewardVideoActivity.this.ud.ud)) {
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.core.model.ljh.lnr(TTRewardVideoActivity.this.ud.ud) && zExu) {
                            return;
                        }
                    }
                    TTRewardVideoActivity.this.ud.hkc.jyq();
                    TTRewardVideoActivity.this.ud.hzv.rq();
                    TTRewardVideoActivity.this.ud.vu.mo();
                    if (vu.mml(TTRewardVideoActivity.this.ud.ud)) {
                        TTRewardVideoActivity.this.lnr(true, true);
                    } else {
                        TTRewardVideoActivity.this.finish();
                    }
                }
            };
            view.setOnClickListener(onClickListener);
            view.setTag(view.getId(), onClickListener);
        }
        this.ud.fco.qdl(new com.bytedance.sdk.openadsdk.component.reward.top.ud() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void mml(View view2) {
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void qdl(View view2) {
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                tTRewardVideoActivity.lnr(vu.lnr(tTRewardVideoActivity.ud.ud), false);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void qdl(View view2, String str) {
                com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm;
                com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
                if (TTRewardVideoActivity.this.lnr != null && TTRewardVideoActivity.this.lnr.mml() != null) {
                    TTRewardVideoActivity.this.lnr.mml().qdl(TTRewardVideoActivity.this.ud.gt);
                }
                TTRewardVideoActivity.this.ud.gt = !TTRewardVideoActivity.this.ud.gt;
                StringBuilder sb = new StringBuilder("will set is Mute ");
                sb.append(TTRewardVideoActivity.this.ud.gt);
                sb.append(" mLastVolume=");
                sb.append(TTRewardVideoActivity.this.ud.ekw.qdl());
                TTRewardVideoActivity.this.ud.bch.qdl(TTRewardVideoActivity.this.ud.gt, str);
                if (!vu.jtx(TTRewardVideoActivity.this.ud.ud) || TTRewardVideoActivity.this.ud.to.get()) {
                    TTRewardVideoActivity.this.ud.hkc.mzz(TTRewardVideoActivity.this.ud.gt);
                    TTRewardVideoActivity.this.ud.xmv.ud(TTRewardVideoActivity.this.ud.gt);
                    if (TTRewardVideoActivity.this.ud.ud == null || (mmlVarZm = TTRewardVideoActivity.this.ud.ud.zm()) == null || (mmlVarQdl = mmlVarZm.qdl()) == null) {
                        return;
                    }
                    if (TTRewardVideoActivity.this.ud.gt) {
                        mmlVarQdl.jpc(TTRewardVideoActivity.this.ud.bch.fs());
                    } else {
                        mmlVarQdl.tvp(TTRewardVideoActivity.this.ud.bch.fs());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void ud(View view2) {
                TTRewardVideoActivity.this.ud.kdv.qdl(TTRewardVideoActivity.this.lnr);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void lnr(View view2) {
                View view3 = view;
                if (view3 != null) {
                    view3.performClick();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lnr(final boolean z, boolean z2) {
        if (!z2 && this.koa && this.ud.to.get() && vu.jpc(this.ud.ud)) {
            this.ud.xmv.tvp();
            return;
        }
        if (!yt.mml().jpc(String.valueOf(this.ud.mo))) {
            if (!z2 && this.ud.to.get() && vu.jpc(this.ud.ud)) {
                this.ud.xmv.tvp();
                return;
            } else if (z) {
                finish();
                return;
            } else {
                rc();
                return;
            }
        }
        if (this.xmv.get()) {
            if (this.ud.to.get() && vu.jpc(this.ud.ud)) {
                this.ud.xmv.tvp();
                return;
            } else if (z) {
                finish();
                return;
            } else {
                rc();
                return;
            }
        }
        if (vu.jpc(this.ud.ud) && this.ud.hkc.jpc().getVisibility() == 0) {
            this.ud.xmv.tvp();
            return;
        }
        this.ud.aaj.set(true);
        this.ud.bch.jyq();
        if (z) {
            this.ud.xmv.mo();
        }
        final com.bytedance.sdk.openadsdk.core.widget.ud udVar = new com.bytedance.sdk.openadsdk.core.widget.ud(this);
        this.lnr.exu = udVar;
        if (z) {
            this.lnr.exu.qdl(exc).ud(oth).lnr(aaj);
        } else {
            this.lnr.exu.qdl(jl).ud(jyq).lnr(aaj);
        }
        this.lnr.exu.qdl(new ud.InterfaceC0259ud() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.core.widget.ud.InterfaceC0259ud
            public void qdl() {
                TTRewardVideoActivity.this.ud.bch.aaj();
                if (z) {
                    TTRewardVideoActivity.this.ud.xmv.qdl(1000);
                }
                udVar.dismiss();
                TTRewardVideoActivity.this.ud.aaj.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ud.InterfaceC0259ud
            public void ud() {
                udVar.dismiss();
                TTRewardVideoActivity.this.koa = true;
                TTRewardVideoActivity.this.ud.aaj.set(false);
                TTRewardVideoActivity.this.ud.xmv.ud(Integer.MAX_VALUE);
                if (!z || !vu.mo(TTRewardVideoActivity.this.ud.ud)) {
                    TTRewardVideoActivity.this.rc();
                } else if (vu.jpc(TTRewardVideoActivity.this.ud.ud)) {
                    TTRewardVideoActivity.this.ud.xmv.tvp();
                } else {
                    TTRewardVideoActivity.this.ud.vu.mo();
                    TTRewardVideoActivity.this.finish();
                }
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void rc() {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.rc():void");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void qdl(Intent intent) {
        super.qdl(intent);
        this.ljh = intent.getStringExtra("media_extra");
        this.bch = intent.getStringExtra(AccessToken.USER_ID_KEY);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public FrameLayout xmv() {
        return this.ud.gy.mo();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void qdl(long j, long j2) {
        int i = (int) (j / 1000);
        int iQg = this.ud.ud.qg();
        boolean z = iQg >= 0;
        lnr(j, j2);
        if (this.mo > 0) {
            this.ud.fco.mml(true);
            if (z && i >= iQg) {
                this.ud.qdl(true);
                this.ud.fco.qdl(String.valueOf(this.mo), TTAdDislikeToast.getSkipText());
                this.ud.fco.mzz(true);
                return;
            }
            this.ud.fco.qdl(String.valueOf(this.mo), null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void ud(boolean z, boolean z2) {
        this.bjy = (int) (System.currentTimeMillis() / 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void uw() {
        this.jtx = (int) (System.currentTimeMillis() / 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void mrf() {
        kdv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kdv() {
        aaj.qdl("BVA", "invoke callback onAdClicked, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            qdl("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.qdl.mzz.qdl qdlVar = this.yt;
        if (qdlVar != null) {
            qdlVar.onAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(final boolean z, final int i, final String str, final int i2, final String str2, final int i3) {
        aaj.qdl("BVA", "invoke callback onRewardVerify: " + z + ", " + i + ", " + str + ", " + i2 + ", " + str2 + "; " + this);
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            qdl("onRewardVerify", z, i, str, i2, str2);
            rq.qdl(this.ud.ud, z, i3);
        } else {
            fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    if (TTRewardVideoActivity.this.yt != null) {
                        TTRewardVideoActivity.this.yt.qdl(z, i, str, i2, str2);
                        rq.qdl(TTRewardVideoActivity.this.ud.ud, z, i3);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void jpc() {
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            qdl("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.qdl.mzz.qdl qdlVar = this.yt;
            if (qdlVar != null) {
                qdlVar.qdl();
            }
        }
        if (oth()) {
            this.ud.bqt.exu();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void jl() {
        vu();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void bch() {
        vu();
    }

    protected void vu() {
        lnr(0);
    }

    protected void lnr(final int i) {
        if (this.xmv.get() || this.koa) {
            return;
        }
        this.xmv.set(true);
        if (this.ud.gg != null) {
            this.ud.gg.lnr();
        }
        if (yt.mml().jtx(String.valueOf(this.ud.mo))) {
            qdl(true, this.ud.ud.lte(), this.ud.ud.mlb(), 0, "", i);
        } else {
            yt.lnr().qdl(ekw(), new oth.ud() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.8
                @Override // com.bytedance.sdk.openadsdk.core.oth.ud
                public void qdl(int i2, String str) {
                    TTRewardVideoActivity.this.qdl(false, 0, "", i2, str, i);
                }

                @Override // com.bytedance.sdk.openadsdk.core.oth.ud
                public void qdl(ljh.ud udVar) {
                    boolean z = udVar.ud;
                    TTRewardVideoActivity.this.qdl(udVar.ud, udVar.lnr.qdl(), udVar.lnr.ud(), 0, "", i);
                }
            });
        }
    }

    private JSONObject ekw() {
        JSONObject jSONObject = new JSONObject();
        int iXmv = (int) this.ud.bch.xmv();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("reward_name", this.ud.ud.mlb());
            jSONObject.put("reward_amount", this.ud.ud.lte());
            jSONObject.put("network", jl.lnr(getApplicationContext()));
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            int iJle = this.ud.ud.jle();
            String strMml = "unKnow";
            if (iJle == 2) {
                strMml = gy.ud();
            } else if (iJle == 1) {
                strMml = gy.mml();
            }
            jSONObject.put("user_agent", strMml);
            JSONObject jSONObjectUzn = this.ud.ud.uzn();
            jSONObjectUzn.put("gaid", com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().ud());
            jSONObject.put("extra", jSONObjectUzn);
            jSONObject.put("media_extra", this.ljh);
            jSONObject.put("video_duration", this.ud.ud.tdy().mo());
            jSONObject.put("play_start_ts", this.bjy);
            jSONObject.put("play_end_ts", this.jtx);
            jSONObject.put(TypedValues.TransitionType.S_DURATION, iXmv);
            jSONObject.put(AccessToken.USER_ID_KEY, this.bch);
            jSONObject.put("trans_id", uw.qdl().replace("-", ""));
            return jSONObject;
        } catch (Throwable th) {
            aaj.qdl("TTAD.RVA", "", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void car() {
        kdv();
        this.ud.ud.cor();
        this.ud.ud.lnr(true);
        if (com.bytedance.sdk.openadsdk.core.model.ljh.mzz(this.ud.ud)) {
            com.bytedance.sdk.openadsdk.mml.lnr.ud(this.ud.ud, this.ud.mzz, this.ud.ud.wb());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void ud(int i) {
        if (i == 10000) {
            vu();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        hzv();
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            qdl("recycleRes");
        }
        qdl(isFinishing(), isChangingConfigurations());
        this.yt = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        if (this.ud != null) {
            com.bytedance.sdk.openadsdk.mo.ud.qdl().qdl("videoForceBreak", this.ud.ud);
        }
        hzv();
        super.finish();
    }

    private void hzv() {
        if (com.bytedance.sdk.openadsdk.jyq.qdl.jpc() && isChangingConfigurations()) {
            aaj.qdl("BVA", "reward callback close is invoke by config change.");
            return;
        }
        if (!this.wd) {
            this.wd = true;
            aaj.qdl("BVA", "invoke callback onAdClose, ");
            if (this.ud != null && this.ud.gg != null) {
                this.ud.gg.mml();
            }
            if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                qdl("onAdClose");
                return;
            }
            com.bytedance.sdk.openadsdk.qdl.mzz.qdl qdlVar = this.yt;
            if (qdlVar != null) {
                qdlVar.ud();
                return;
            }
            return;
        }
        aaj.qdl("BVA", "invoke callback onAdClose has already been called ");
    }

    protected void ud(long j, long j2) {
        if (j2 <= 0) {
            return;
        }
        if (this.bqt == -1) {
            this.bqt = Math.min(100, this.ud.ud.ijp());
        }
        if (((j / 1000.0f) / j2) * 100.0f >= this.bqt) {
            vu();
        }
    }

    public void lnr(long j, long j2) {
        boolean z = false;
        if (this.ud != null) {
            if (this.ud.ud.ijp() >= 0 && this.ud.ud.up() >= 0) {
                z = true;
            }
            if (z) {
                j2 = this.ud.ud.up();
            }
        }
        long j3 = j + (((long) this.ud.xi) * 1000);
        if (z) {
            ud(j3, j2);
            return;
        }
        if (this.bqt == -1) {
            this.bqt = yt.mml().xmv(String.valueOf(this.ud.mo)).mo;
        }
        if (j2 <= 0) {
            return;
        }
        if (j2 >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS && j3 >= 27000) {
            vu();
        } else if ((j3 * 100) / j2 >= this.bqt) {
            vu();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void ud(boolean z) {
        if (z) {
            vu();
            return;
        }
        if ((1.0d - (((double) this.mo) / this.ud.bch.fco())) * 100.0d >= yt.mml().xmv(String.valueOf(this.ud.mo)).mo) {
            vu();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void gy() {
        lnr(2);
    }
}
