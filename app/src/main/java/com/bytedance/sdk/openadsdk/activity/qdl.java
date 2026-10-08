package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.animation.core.AnimationConstants;
import com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.koa;
import com.bytedance.sdk.openadsdk.activity.ud;
import com.bytedance.sdk.openadsdk.component.reward.qdl.mzz;
import com.bytedance.sdk.openadsdk.core.exu.mml.qdl;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.mml.ud;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.bjy;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class qdl extends jpc implements koa.qdl, mzz.qdl {
    private int aaj;
    private boolean bch;
    private boolean bqt;
    private Bundle jyq;
    private CountDownTimer koa;
    private boolean ljh;
    protected int lnr;
    protected boolean mml;
    protected boolean mzz;
    private int oth;
    protected final koa qdl;
    protected com.bytedance.sdk.openadsdk.component.reward.ud.ud ud;
    private long uw;
    private boolean vu;
    private long xmv;

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void jl() {
    }

    public abstract FrameLayout jpc();

    protected abstract void mzz();

    protected abstract void ud();

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void ud(boolean z) {
    }

    public qdl(ud udVar, ljh ljhVar, int i, int i2, boolean z) {
        super(udVar, ljhVar, i, i2, z);
        this.qdl = new koa(Looper.getMainLooper(), this);
        this.aaj = 1;
        this.oth = 0;
        this.ljh = false;
        this.mml = false;
        dk();
    }

    private void dk() {
        this.bqt = vu.lnr(this.mo) && this.mo.qur();
        aaj.qdl("TTAD.AdScene", "current scene is isOnlyPlayable -> " + this.bqt);
        if (this.bqt) {
            this.xmv = ((long) this.mo.icv()) * 1000;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public final void qdl(Activity activity, Bundle bundle) {
        this.jyq = bundle;
        super.qdl(activity, bundle);
        qdl(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public final com.bytedance.sdk.openadsdk.component.reward.view.tvp qdl() {
        return this.tvp.ax;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void qdl(Activity activity, ud.mzz mzzVar) {
        try {
            this.aaj = this.mo.jb();
            qdl(activity, this.mo, this.jyq);
            if (this.tvp.ra && this.mo.qur()) {
                this.tvp.gt = mzzVar.mml;
            }
            if (this.tvp.ra && this.to > 0) {
                this.tvp.gt = mzzVar.mml;
            }
            ijp();
            zy();
            if (com.bytedance.sdk.openadsdk.core.model.aaj.mzz(this.mo)) {
                lte();
            }
        } catch (Throwable th) {
            aaj.qdl("TTAD.AdScene", "onCreate: ", th);
            com.bytedance.sdk.openadsdk.bjy.lnr.ud();
            wak();
        }
    }

    private void qdl(Activity activity, ljh ljhVar, Bundle bundle) {
        this.tvp = new com.bytedance.sdk.openadsdk.component.reward.qdl.qdl(activity, this.qdl, ljhVar, this, 1, this.wd.ud(), this.tvp);
        this.tvp.ra = this.wd.mzz();
        this.tvp.qk = this.exu;
        this.tvp.blf = this.tvp.ra && com.bytedance.sdk.openadsdk.core.model.aaj.mzz(ljhVar);
        this.tvp.tqd = this.wd.lnr();
        this.tvp.fzn = this.wd.oth();
        this.tvp.lq = this;
        this.tvp.ekw = this.wd.aaj();
        Intent intent = activity.getIntent();
        com.bytedance.sdk.openadsdk.component.reward.qdl.ud.qdl(this.tvp, intent, bundle);
        if (intent != null) {
            com.bytedance.sdk.openadsdk.component.reward.qdl.ud.qdl(intent, this.tvp);
            ljhVar.qdl(intent.getLongExtra("start_show_time", 0L));
        }
        if (bundle != null && this.tvp.mlb) {
            ud();
        }
        this.ud = com.bytedance.sdk.openadsdk.component.reward.ud.mo.qdl(this.tvp);
        this.tvp.en = this.ud;
        this.tvp.mrf.qdl(this);
        if (this.tvp.ra) {
            this.tvp.bch.qdl(new qdl.InterfaceC0231qdl() { // from class: com.bytedance.sdk.openadsdk.activity.qdl.1
                @Override // com.bytedance.sdk.openadsdk.core.exu.mml.qdl.InterfaceC0231qdl
                public void qdl(int i) {
                    if (qdl.this.wd == null) {
                        return;
                    }
                    qdl.this.wd.ud(qdl.this, i);
                }
            });
            if (!this.wd.bch()) {
                this.wd.oth().setShowSound(ljh.mzz(ljhVar));
            }
        }
        bjy.qdl(this.tvp);
        Objects.toString(this.ud);
    }

    private void ijp() {
        this.tvp.ax.qdl(this.ud);
        this.ud.qdl(this, this.qdl);
        this.ud.rq();
    }

    private void zy() {
        this.ud.xmv();
        this.lnr = (int) this.tvp.bch.fco();
        if (this.tvp.ra) {
            qdl(this.tvp.vu.mzz());
            qdl(this.tvp.vu.mml());
        }
        mzz();
        kab();
    }

    private void qdl(com.bytedance.sdk.openadsdk.core.lnr.ud udVar) {
        if (udVar != null) {
            HashMap map = new HashMap();
            try {
                int i = this.rq + 1;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_show_order", i);
                map.put("pag_json_data", jSONObject.toString());
            } catch (Throwable unused) {
            }
            udVar.qdl(map);
        }
    }

    private boolean en() {
        if (this.tvp.to.get() && this.tvp.wd) {
            return false;
        }
        if (this.mo.mo()) {
            return this.tvp.to.get();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void qdl(Activity activity) {
        super.qdl(activity);
        if (this.tvp == null) {
            return;
        }
        this.tvp.koa.qdl();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void lnr() {
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar;
        super.lnr();
        if (this.tvp == null || (udVar = this.ud) == null) {
            return;
        }
        udVar.yt();
        this.tvp.irn = true;
        if (en()) {
            this.tvp.fco.qdl(this.tvp.ud.tvf());
        }
        this.tvp.gy.bjy();
        this.tvp.hkc.yt();
        this.tvp.xmv.mzz();
        if (this.ud.ud()) {
            this.tvp.bch.qdl(this.ud);
            if (this.tvp.bch.cx()) {
                qdl(this.tvp.bch.rdp(), true);
            } else if (this.tvp.bch.wd() && this.wd.bch()) {
                ax();
            } else {
                this.tvp.bch.qdl(false, this, this.oth != 0);
            }
        }
        this.oth++;
        nz();
        if (this.tvp.bqt != null) {
            this.tvp.bqt.wd();
        }
        this.tvp.koa.qdl(this.qdl);
        if (this.wd.bch()) {
            this.tvp.bqt.qdl(0, false);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.bqt) {
            long j = this.uw;
            if (j != 0 && jCurrentTimeMillis - j > this.xmv) {
                aaj.qdl("TTAD.AdScene", "onResume: Exceed playable_duration_time, switch to next ad");
                cx().qdl(this, qdl(8));
                return;
            }
            if (j != 0) {
                this.xmv -= jCurrentTimeMillis - j;
            }
            aaj.qdl("TTAD.AdScene", "onResume: The playable display time has not yet arrived, continue the countdown -> remainingTime = " + this.xmv);
            qdl(this.xmv);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.sdk.openadsdk.activity.qdl$2] */
    private void qdl(long j) {
        this.koa = new CountDownTimer(j, 1000L) { // from class: com.bytedance.sdk.openadsdk.activity.qdl.2
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                qdl.this.xmv = j2;
                aaj.qdl("TTAD.AdScene", "onTick: remainingTime = " + qdl.this.xmv);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                aaj.qdl("TTAD.AdScene", "onFinish: remainingTime = " + qdl.this.xmv);
                ud udVarCx = qdl.this.cx();
                qdl qdlVar = qdl.this;
                udVarCx.qdl(qdlVar, qdlVar.qdl(8));
            }
        }.start();
    }

    private void nz() {
        if (this.mo.mo() && !this.ljh) {
            this.ljh = true;
            qdl().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.qdl.3
                @Override // java.lang.Runnable
                public void run() {
                    float[] fArrQdl;
                    if (!qdl.this.wd.bch()) {
                        fArrQdl = qdl.this.tvp.koa.qdl(qdl.this.aaj);
                    } else {
                        fArrQdl = new float[]{ax.lnr(qdl.this.tvp.ag, qdl.this.tvp.ax.getWidth()), ax.lnr(qdl.this.tvp.ag, qdl.this.tvp.ax.getHeight())};
                    }
                    if (qdl.this.tvp.rc.qdl()) {
                        qdl.this.tvp.rc.qdl(qdl.this.mo);
                    } else {
                        qdl.this.tvp.rc.qdl(fArrQdl);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void mml() {
        super.mml();
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar = this.ud;
        if (udVar == null) {
            return;
        }
        udVar.aaj();
    }

    private void kab() {
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar;
        if (this.mo.mo() || (udVar = this.ud) == null) {
            return;
        }
        udVar.qdl(this.tvp.gy.mo());
        this.ud.uw();
    }

    public final void qdl(boolean z, int i) {
        qdl(z, false, i);
    }

    public final void qdl(boolean z, boolean z2, int i) {
        this.tvp.mrf.qdl(z, z2, false, this.tvp.en, i);
    }

    @Override // com.bytedance.sdk.component.utils.koa.qdl
    public void qdl(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar = this.ud;
        if (udVar == null) {
            return;
        }
        udVar.qdl(message);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void mo() {
        aaj.qdl("TTAD.AdScene", "onPlayableLoadingDismiss()---" + this.to);
        if (this.wd != null) {
            this.wd.qdl(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void qdl(boolean z) {
        aaj.qdl("TTAD.AdScene", "onPlayableHappenInteraction()---" + this.to + " isHappenInteraction:" + z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void qdl(String str, JSONObject jSONObject) {
        if (str == null || !"skipToNextAd".equals(str) || this.wd == null) {
            return;
        }
        this.wd.ud(this, qdl(7));
    }

    protected final void wd() {
        Message message = new Message();
        message.what = 400;
        if (this.mo.mq()) {
            ud(10000);
        }
        this.qdl.sendMessageDelayed(message, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public boolean qdl(long j, boolean z) {
        if (this.tvp == null) {
            return false;
        }
        this.tvp.bqt.ud(false);
        this.mzz = false;
        com.bytedance.sdk.openadsdk.mml.wd wdVar = to();
        if (jpc() == null) {
            return false;
        }
        this.tvp.bch.qdl(jpc(), wdVar);
        Map<String, Object> mapTvp = this.mo.mo() ? tvp() : null;
        lnr.qdl qdlVar = new lnr.qdl() { // from class: com.bytedance.sdk.openadsdk.activity.qdl.4
            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.qdl
            public void qdl(long j2, int i) {
                aaj.qdl("TTAD.AdScene", "onComplete() called with: totalPlayTime = [" + j2 + "], percent = [" + i + "], mVideoHasCompleted=" + qdl.this.mzz);
                if (qdl.this.mzz) {
                    return;
                }
                qdl.this.mzz = true;
                boolean zMo = qdl.this.mo.mo();
                qdl.this.qdl.removeMessages(AnimationConstants.DefaultDurationMillis);
                qdl.this.exc();
                qdl.this.tvp.bch.qdl(j2, j2);
                if (zMo) {
                    qdl.this.tvp.bqt.ud(true);
                } else {
                    qdl.this.tvp.exc.set(true);
                }
                if (qdl.this.tvp.ud.taz() == 36 && qdl.this.tvp.lnr) {
                    qdl.this.tvp.uw.lnr().lnr(qdl.this.tvp.ud);
                    bjy.ud();
                }
                if (!zMo && qdl.this.tvp.ud.hrh()) {
                    qdl.this.tvp.ud.om(1);
                    qdl.this.tvp.gy.yt();
                }
                if (qdl.this.tvp.ud.taz() == 21 && !qdl.this.tvp.ud.bjy()) {
                    qdl.this.tvp.ud.mml(true);
                    qdl.this.tvp.gy.yt();
                }
                ud.mzz mzzVarQdl = qdl.this.qdl(5);
                mzzVarQdl.mzz = true;
                qdl.this.wd.qdl(qdl.this, mzzVarQdl);
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.qdl
            public void ud(long j2, int i) {
                aaj.qdl("TTAD.AdScene", "onError() called with: totalPlayTime = [" + j2 + "], percent = [" + i + "]");
                qdl.this.qdl.removeMessages(AnimationConstants.DefaultDurationMillis);
                if (qdl.this.tvp.gy.bjy != null) {
                    qdl.this.tvp.gy.bjy.to();
                }
                if (qdl.this.tvp.bch.mo()) {
                    qdl.this.wd();
                    return;
                }
                qdl.this.tvp.bch.exc();
                if (qdl.this.mo.mo()) {
                    qdl.this.tvp.bqt.qdl(true);
                }
                ud udVar = qdl.this.wd;
                qdl qdlVar2 = qdl.this;
                udVar.qdl(qdlVar2, qdlVar2.qdl(3));
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.qdl
            public void qdl() {
                aaj.qdl("TTAD.AdScene", "onTimeOut() called with: ");
                qdl.this.qdl.removeMessages(AnimationConstants.DefaultDurationMillis);
                qdl.this.exc();
                ud udVar = qdl.this.wd;
                qdl qdlVar2 = qdl.this;
                udVar.qdl(qdlVar2, qdlVar2.qdl(6));
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.qdl
            public void qdl(long j2, long j3) {
                if (!qdl.this.tvp.irn && qdl.this.tvp.bch.mo()) {
                    qdl.this.tvp.bch.ud(true);
                }
                if (qdl.this.tvp.to.get()) {
                    return;
                }
                qdl.this.qdl.removeMessages(AnimationConstants.DefaultDurationMillis);
                if (j2 != qdl.this.tvp.bch.exu()) {
                    qdl.this.exc();
                }
                if (qdl.this.tvp.bch.mo()) {
                    qdl.this.tvp.bch.qdl(j2, j3);
                    int i = (int) (j2 / 1000);
                    if ((qdl.this.tvp.aaj.get() || qdl.this.tvp.rq.get()) && qdl.this.tvp.bch.mo()) {
                        qdl.this.tvp.bch.jyq();
                    }
                    if (qdl.this.tvp.mml) {
                        qdl.this.tvp.gy.mzz(i);
                    }
                    if (qdl.this.mo.mo() && qdl.this.tvp.bqt != null && qdl.this.tvp.bqt.qdl() != null) {
                        qdl.this.tvp.bqt.qdl().setTime(String.valueOf(qdl.this.lnr), i, 0, false);
                        qdl.this.tvp.bqt.qdl().qdl(j2, j3);
                    }
                    qdl.this.qdl((j2 * 1.0f) / j3);
                    qdl.this.tvp.qdl(true);
                }
            }
        };
        this.tvp.bch.qdl(qdlVar);
        if (!this.mo.mo() && this.tvp.gy.bjy != null) {
            this.tvp.gy.bjy.qdl(qdlVar);
        }
        return this.tvp.bch.qdl(j, z, mapTvp, this.ud);
    }

    public Map<String, Object> tvp() {
        HashMap map = new HashMap();
        if (this.tvp != null && this.tvp.bqt != null && this.mo != null && this.mo.dk() == 2) {
            map.put("dynamic_show_type", Integer.valueOf(this.tvp.bqt.rq()));
            JSONObject jSONObjectQdl = this.tvp.bqt.qdl((JSONObject) null);
            if (jSONObjectQdl != null) {
                Iterator<String> itKeys = jSONObjectQdl.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        map.put(next, jSONObjectQdl.get(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return map;
    }

    public com.bytedance.sdk.openadsdk.mml.wd to() {
        if (this.mo.mo()) {
            if (this.tvp != null && this.tvp.bqt != null && this.tvp.bqt.qdl() != null) {
                return this.tvp.bqt.qdl().getAdShowTime();
            }
            com.bytedance.sdk.openadsdk.mml.wd wdVar = new com.bytedance.sdk.openadsdk.mml.wd();
            wdVar.qdl(System.currentTimeMillis(), 1.0f);
            return wdVar;
        }
        com.bytedance.sdk.openadsdk.mml.wd wdVar2 = new com.bytedance.sdk.openadsdk.mml.wd();
        wdVar2.qdl(System.currentTimeMillis(), 1.0f);
        return wdVar2;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc, com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void rq() {
        super.rq();
        if (this.mo.mo()) {
            this.tvp.bqt.exu();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void fs() {
        if (this.wd == null) {
            return;
        }
        this.wd.ud(this, qdl(10));
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public final void exu() {
        super.exu();
        if (this.tvp == null || com.bytedance.sdk.component.utils.ud.qdl(yh())) {
            return;
        }
        this.tvp.hkc.xmv();
        com.bytedance.sdk.openadsdk.utils.mml.qdl(yh(), this.tvp.ud);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void rdp() {
        super.rdp();
        if (this.bqt) {
            this.uw = System.currentTimeMillis();
            aaj.qdl("TTAD.AdScene", "onPause: remainingTime = " + this.xmv);
            CountDownTimer countDownTimer = this.koa;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar = this.ud;
        if (udVar == null) {
            return;
        }
        udVar.exc();
        if (this.tvp.bqt != null) {
            this.tvp.bqt.jpc();
        }
        if (this.wd.bch()) {
            this.tvp.bqt.qdl(8, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public final void bjy() {
        this.tvp.bch.mrf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public final View jtx() {
        return this.tvp.bch.gy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public final void yt() {
        if (!this.tvp.rdp.getAndSet(true) || vu.lnr(this.tvp.ud)) {
            this.tvp.vu.qdl();
        }
    }

    protected final void exc() {
        this.qdl.removeMessages(400);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void aaj() {
        super.aaj();
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar = this.ud;
        if (udVar == null) {
            return;
        }
        udVar.ud(this.exc);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.mzz.qdl
    public void qdl(boolean z, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar, int i) {
        qdl(z, z2, z3, i);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void jyq() {
        super.jyq();
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar = this.ud;
        if (udVar != null) {
            udVar.oth();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void qdl(jpc jpcVar, jpc jpcVar2, ud.mzz mzzVar) {
        super.qdl(jpcVar, jpcVar2, mzzVar);
        if (jpcVar == this && (jpcVar2 instanceof mzz)) {
            if (mzzVar.ud == 3) {
                this.tvp.bch.qdl(!this.tvp.bch.hzv() ? 1 : 0, 2);
            } else if (mzzVar.ud == 6) {
                this.tvp.bch.qdl(!this.tvp.bch.hzv() ? 1 : 0, !this.tvp.bch.hzv() ? 1 : 0);
            } else if (mzzVar.ud == 5 && !ljh.mzz(this.tvp.ud) && mzzVar.mzz) {
                this.tvp.bch.qdl("skip", true);
            }
            this.tvp.fco.qdl(false);
            this.tvp.fco.mml(false);
        }
    }

    public void qdl(float f) {
        if (this.wd == null) {
            return;
        }
        this.wd.qdl(f);
        if (this.bch || this.mo.taz() == 43 || f < this.mo.ag() / 100.0f) {
            return;
        }
        jpc jpcVarLjh = this.wd.ljh();
        if (jpcVarLjh instanceof qdl) {
            ((qdl) jpcVarLjh).oth();
        }
    }

    public void oth() {
        if (!this.bch) {
            this.bch = true;
            zlt();
        } else {
            aaj.qdl("TTAD.AdScene", "tryPreloadNextAdVideo: Already tried preloading the video");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public boolean ljh() {
        return this.tvp != null && this.tvp.bch.kdv();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    protected String bch() {
        return this.tvp.wak;
    }

    protected ud.mzz qdl(int i) {
        ud.mzz mzzVar = new ud.mzz(i, this.tvp);
        mzzVar.mml = this.tvp.gt;
        return mzzVar;
    }

    public void uw() {
        this.wd.qdl(this, qdl(ud.C0269ud.ud));
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void lnr(boolean z) {
        if (this.tvp == null || this.tvp.vu == null) {
            return;
        }
        this.tvp.vu.ud(z);
        this.tvp.vu.lnr(z);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public com.bytedance.sdk.openadsdk.component.reward.qdl.qdl xmv() {
        return this.tvp;
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void mml(boolean z) {
        if (this.wd != null) {
            this.wd.qdl(this, z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public boolean bqt() {
        return this.tvp.bqt.tvp();
    }

    public void koa() {
        this.tvp.vu.qdl();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void qdl(Map<String, Object> map, float f, float f2) {
        super.qdl(map, f, f2);
        this.wd.qdl(map, this, f, f2);
    }

    public void vu() {
        nz();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void rc() {
        com.bytedance.sdk.openadsdk.component.reward.view.mml mmlVarQdl;
        super.rc();
        if (this.tvp == null || (mmlVarQdl = this.tvp.bqt.qdl()) == null || !mmlVarQdl.ljh()) {
            return;
        }
        koa();
    }

    public void kdv() {
        if (this.tvp == null) {
            return;
        }
        this.tvp.bch.bjy();
    }

    public void ekw() {
        if (this.tvp != null && this.tvp.bch.tvp()) {
            this.tvp.bch.aaj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void hkc() {
        this.mml = true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void qdl(ljh ljhVar, int i, int i2) {
        super.qdl(ljhVar, i, i2);
        dk();
        this.ljh = false;
        this.vu = true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public boolean hzv() {
        return this.mo.ra() == 10 && !bqt();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public boolean fco() {
        return this.tvp.bqt.to() && !bqt();
    }
}
