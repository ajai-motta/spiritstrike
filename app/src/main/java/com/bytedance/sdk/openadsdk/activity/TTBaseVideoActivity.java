package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.animation.core.AnimationConstants;
import com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.koa;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.component.reward.exu;
import com.bytedance.sdk.openadsdk.component.reward.qdl.rq;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.rc;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.core.mrf;
import com.bytedance.sdk.openadsdk.core.rdp;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.mml.ud;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.bjy;
import com.bytedance.sdk.openadsdk.utils.bqt;
import com.bytedance.sdk.openadsdk.utils.kdv;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TTBaseVideoActivity extends TTBaseActivity implements koa.qdl, com.bytedance.sdk.openadsdk.core.exu.mml.ud {
    private final AtomicBoolean aaj;
    private final AtomicBoolean bjy;
    private int exc;
    protected boolean exu;
    protected boolean fs;
    private final rq.ud jl;
    private boolean jtx;
    protected com.bytedance.sdk.openadsdk.component.reward.ud.ud lnr;
    final koa mml;
    int mo;
    protected IListenerManager mzz;
    public final String qdl;
    protected boolean rdp;
    int rq;
    protected kdv to;
    com.bytedance.sdk.openadsdk.component.reward.qdl.qdl ud;
    boolean wd;
    private int yt;

    public abstract boolean aaj();

    protected void bch() {
    }

    protected abstract void exc();

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void jl() {
    }

    protected abstract void jpc();

    public abstract boolean jyq();

    public Map<String, Object> koa() {
        return null;
    }

    protected abstract void mml();

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void mml(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void mo() {
    }

    public boolean oth() {
        return false;
    }

    protected abstract void qdl(long j, long j2);

    protected void qdl(Intent intent) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void qdl(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected boolean qdl() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void sy() {
    }

    protected void to() {
    }

    protected void ud(boolean z, boolean z2) {
    }

    protected void uw() {
    }

    public abstract FrameLayout xmv();

    public TTBaseVideoActivity() {
        this.qdl = aaj() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.bjy = new AtomicBoolean(false);
        this.mml = new koa(Looper.getMainLooper(), this);
        this.jtx = false;
        this.yt = 0;
        this.rq = 1;
        this.jl = new rq.ud();
        this.fs = false;
        this.exc = -1;
        this.aaj = new AtomicBoolean(false);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean z;
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar;
        super.onCreate(bundle);
        if (bundle != null) {
            z = bundle.getBoolean("enable_new_arch", false);
        } else {
            z = getIntent() != null && getIntent().getBooleanExtra("enable_new_arch", false);
        }
        this.exu = z;
        aaj.qdl("BVA", "onCreate enableIvRvNewArch->" + this.exu + ",activity ->");
        yt.ud(getApplicationContext());
        if (!rdp.mzz()) {
            finish();
            return;
        }
        ljh ljhVarQdl = com.bytedance.sdk.openadsdk.component.reward.qdl.ud.qdl(getIntent(), bundle, this);
        if (ljhVarQdl == null) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.utils.ud.qdl(ljhVarQdl);
        this.rdp = com.bytedance.sdk.openadsdk.jyq.qdl.qdl("adapt_decor_size", 0) == 1;
        aaj.qdl("BVA", "activity onCreate isAdaptDecorSize =" + this.rdp);
        ljhVarQdl.fco(String.valueOf(hashCode()));
        this.rq = ljhVarQdl.jb();
        qdl(ljhVarQdl, bundle);
        if (bundle != null) {
            if (ljhVarQdl.hkc()) {
                this.aaj.set(true);
            }
            if (ljhVarQdl.gy() && (qdlVar = this.ud) != null) {
                qdlVar.exu.set(true);
            }
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar2 = this.ud;
            if (qdlVar2 != null) {
                qdlVar2.vu.wd();
            }
        }
        try {
            lnr();
            vu();
        } catch (Throwable th) {
            aaj.qdl("TTAD.BVA", "onCreate: ", th);
            com.bytedance.sdk.openadsdk.bjy.lnr.ud();
            finish();
        }
    }

    private void qdl(ljh ljhVar, Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = new com.bytedance.sdk.openadsdk.component.reward.qdl.qdl(this, this.mml, ljhVar, this, 0, this.rdp);
        this.ud = qdlVar;
        com.bytedance.sdk.openadsdk.component.reward.qdl.ud.qdl(qdlVar, getIntent(), bundle);
        Intent intent = getIntent();
        if (intent != null) {
            qdl(intent);
            ljhVar.qdl(intent.getLongExtra("start_show_time", 0L));
        }
        if (bundle != null && this.ud.mlb) {
            mml();
        }
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVarQdl = com.bytedance.sdk.openadsdk.component.reward.ud.mo.qdl(this.ud);
        this.lnr = udVarQdl;
        this.ud.en = udVarQdl;
        bjy.qdl(this.ud);
        Objects.toString(this.lnr);
    }

    protected void lnr() {
        setContentView(this.ud.ax);
        this.ud.ax.qdl(this.lnr);
        this.lnr.qdl(this, this.mml);
        this.lnr.rq();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = this.ud;
        if (qdlVar == null || qdlVar.ud == null) {
            return;
        }
        ljh ljhVar = this.ud.ud;
        if (this.jpc && !ljhVar.nln() && !TextUtils.isEmpty(ljh.qdl(this, ljhVar))) {
            finish();
        }
        if (ljhVar.nln()) {
            ljhVar.fs(false);
        }
    }

    private void vu() {
        com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
        this.lnr.xmv();
        this.mo = (int) this.ud.bch.fco();
        exc();
        wd();
        com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = this.ud.ud.zm();
        if (mmlVarZm == null || (mmlVarQdl = mmlVarZm.qdl()) == null) {
            return;
        }
        mmlVarQdl.qdl(0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void qdl(Bundle bundle) {
        if (!this.exu || com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            return;
        }
        if (bundle != null) {
            this.tvp = bundle.getString("single_process_listener_key");
        } else if (getIntent() != null) {
            this.tvp = getIntent().getStringExtra("single_process_listener_key");
        } else {
            this.tvp = "";
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = this.ud;
        if (qdlVar == null || qdlVar.vu == null) {
            return;
        }
        this.ud.vu.ud(z);
        this.ud.vu.lnr(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void yt() {
        if (!this.ud.rdp.getAndSet(true) || vu.lnr(this.ud.ud)) {
            this.ud.vu.qdl();
        }
    }

    public void mzz() {
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar = this.lnr;
        if (udVar == null) {
            return;
        }
        udVar.exu();
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void fs() {
        mzz();
    }

    public void qdl(boolean z, int i) {
        qdl(z, false, i);
    }

    public void qdl(boolean z, boolean z2, int i) {
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar = this.lnr;
        if (udVar == null) {
            return;
        }
        udVar.qdl(z, z2, false, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void bjy() {
        this.ud.bch.mrf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public View jtx() {
        return this.ud.bch.gy();
    }

    protected void wd() {
        if (vu.lnr(this.ud.ud)) {
            qdl(false, ud.C0269ud.lnr);
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar = this.lnr;
        if (udVar != null) {
            udVar.qdl(this.ud.gy.mo());
            this.lnr.uw();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        aaj.qdl("BVA", "onStart mMetaIndex =" + this.exc + " this =" + this);
        if (this.exc >= 0) {
            com.bytedance.sdk.openadsdk.core.koa.qdl().lnr(this.exc);
            this.exc = -1;
        }
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = this.ud;
        if (qdlVar == null) {
            return;
        }
        qdlVar.hkc.xmv();
        com.bytedance.sdk.openadsdk.utils.mml.qdl(this, this.ud.ud);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar;
        super.onResume();
        aaj.qdl("BVA", "onResume ".concat(String.valueOf(this)));
        if (this.ud == null || (udVar = this.lnr) == null) {
            return;
        }
        udVar.yt();
        this.ud.irn = true;
        this.jl.qdl(this, this.ud.zlt, this.ud.taz, this.rdp);
        if (kdv()) {
            this.ud.fco.qdl(this.ud.ud.tvf());
        }
        this.ud.gy.bjy();
        this.ud.hkc.yt();
        this.ud.xmv.mzz();
        if (this.lnr.ud()) {
            this.ud.bch.qdl(this.lnr);
            this.ud.bch.qdl(false, this, this.yt != 0);
        }
        this.yt++;
        tvp();
        if (this.ud.bqt != null) {
            this.ud.bqt.wd();
        }
        this.ud.koa.qdl(this.mml);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        aaj.qdl("BVA", "onPause ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar = this.lnr;
        if (udVar == null) {
            return;
        }
        udVar.exc();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        aaj.qdl("BVA", "onStop ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar = this.lnr;
        if (udVar == null) {
            return;
        }
        udVar.aaj();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        aaj.qdl("BVA", "onDestroy ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = this.ud;
        if (qdlVar == null || this.lnr == null) {
            return;
        }
        if (qdlVar.dk > 0 && this.ud.exu.get()) {
            com.bytedance.sdk.openadsdk.mml.lnr.qdl(String.valueOf(SystemClock.elapsedRealtime() - this.ud.dk), this.ud.ud, this.qdl, this.ud.bch.mzz());
            this.ud.dk = 0L;
        }
        this.ud.kdv.ud();
        this.mml.removeCallbacksAndMessages(null);
        this.lnr.jyq();
        com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(this.ud.ud);
        com.bytedance.sdk.openadsdk.bch.qdl.lnr.ud(this.ud.ud);
        AdSlot adSlotJi = this.ud.ud.ji();
        if (!this.ud.bch.kdv() && adSlotJi != null && TextUtils.isEmpty(adSlotJi.getBidAdm()) && !this.ud.ud.ilu()) {
            rdp.ud().post(new qdl(aaj(), adSlotJi));
        }
        bjy.qdl();
        kdv kdvVar = this.to;
        if (kdvVar != null) {
            kdvVar.mzz();
            this.to = null;
        }
        this.jl.qdl(this);
        mrf.qdl().qdl(String.valueOf(hashCode()));
    }

    public void qdl(boolean z, boolean z2) {
        if (!this.exu || TextUtils.isEmpty(this.tvp)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.koa.qdl().qdl(this.tvp, z, z2);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = this.ud;
        if (qdlVar == null) {
            super.onSaveInstanceState(bundle);
            return;
        }
        if (qdlVar.exu.get()) {
            this.ud.ud.wd(true);
        }
        if (this.aaj.get()) {
            this.ud.ud.ekw();
        }
        if (!TextUtils.isEmpty(this.tvp)) {
            bundle.putString("single_process_listener_key", this.tvp);
        }
        bundle.putBoolean("enable_new_arch", this.exu);
        ljh ljhVar = this.ud.ud;
        int iQdl = ljhVar != null ? com.bytedance.sdk.openadsdk.core.koa.qdl().qdl(ljhVar) : -1;
        this.exc = iQdl;
        com.bytedance.sdk.openadsdk.component.reward.qdl.ud.qdl(this.ud, bundle, iQdl);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        rc();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected void ud() {
        rc();
    }

    private void rc() {
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar;
        if (this.ud == null || (udVar = this.lnr) == null) {
            super.onBackPressed();
        } else {
            udVar.oth();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = this.ud;
        if (qdlVar == null) {
            return;
        }
        qdlVar.koa.qdl();
    }

    @Override // com.bytedance.sdk.component.utils.koa.qdl
    public void qdl(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar = this.lnr;
        if (udVar == null) {
            return;
        }
        udVar.qdl(message);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public final void rq() {
        if (this.aaj.compareAndSet(false, true)) {
            aaj.qdl("BVA", "invoke callback onShow, ".concat(String.valueOf(this)));
            jpc();
        }
    }

    protected IListenerManager qdl(int i) {
        if (this.mzz == null) {
            this.mzz = com.bytedance.sdk.openadsdk.multipro.aidl.qdl.qdl.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.qdl.qdl().qdl(i));
        }
        return this.mzz;
    }

    protected void tvp() {
        if (oth() && !this.jtx) {
            this.jtx = true;
            getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    TTBaseVideoActivity.this.ud.rc.qdl(TTBaseVideoActivity.this.ud.koa.qdl(TTBaseVideoActivity.this.rq));
                    TTBaseVideoActivity.this.to();
                }
            });
        }
    }

    protected void exu() {
        Message message = new Message();
        message.what = 400;
        if (aaj()) {
            ud(10000);
        }
        this.mml.sendMessageDelayed(message, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    protected void rdp() {
        this.mml.removeMessages(400);
    }

    private boolean kdv() {
        if (this.ud.to.get() && this.ud.wd) {
            return false;
        }
        if ((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) {
            return this.ud.to.get();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.ud == null) {
            return;
        }
        if (bqt.mzz()) {
            ax.ud((Activity) this);
        }
        if (!vu.mzz(this.ud.ud) || this.ud.xmv.mml(com.bytedance.sdk.openadsdk.component.reward.qdl.jpc.ud)) {
            return;
        }
        ApmHelper.reportCustomError("invalid finish", "playable", new RuntimeException());
    }

    protected void ljh() {
        rc rcVarEu;
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = this.ud;
        if (qdlVar == null || qdlVar.ud == null || (rcVarEu = this.ud.ud.eu()) == null) {
            return;
        }
        if (rcVarEu.ud() == 1 || rcVarEu.ud() == 2) {
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar2 = this.ud;
            this.to = new kdv(qdlVar2, qdlVar2.ud);
            if (this.ud.bch != null) {
                this.ud.bch.qdl(this.to);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public List<ljh> tid() {
        return this.ud.ud.gxp();
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void hkc() {
        this.fs = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public boolean qdl(long j, boolean z) {
        if (this.ud == null) {
            return false;
        }
        this.bjy.set(false);
        com.bytedance.sdk.openadsdk.mml.wd wdVarMzz = this.ud.mzz();
        FrameLayout frameLayoutXmv = xmv();
        if (frameLayoutXmv == null) {
            return false;
        }
        this.ud.bch.qdl(frameLayoutXmv, wdVarMzz);
        Map<String, Object> mapKoa = koa();
        lnr.qdl qdlVar = new lnr.qdl() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.2
            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.qdl
            public void qdl(long j2, int i) {
                aaj.qdl("TTAD.BVA", "onComplete() called with: totalPlayTime = [" + j2 + "], percent = [" + i + "], mVideoHasCompleted=" + TTBaseVideoActivity.this.bjy.get());
                if (TTBaseVideoActivity.this.bjy.getAndSet(true)) {
                    return;
                }
                TTBaseVideoActivity.this.bjy.set(true);
                TTBaseVideoActivity.this.mml.removeMessages(AnimationConstants.DefaultDurationMillis);
                TTBaseVideoActivity.this.rdp();
                TTBaseVideoActivity.this.bch();
                TTBaseVideoActivity.this.ud.bch.qdl(j2, j2);
                boolean zOth = TTBaseVideoActivity.this.oth();
                if (zOth) {
                    TTBaseVideoActivity.this.ud.bqt.ud(true);
                } else {
                    TTBaseVideoActivity.this.ud.exc.set(true);
                }
                TTBaseVideoActivity.this.uw();
                if (TTBaseVideoActivity.this.ud.ud.taz() == 36 && TTBaseVideoActivity.this.ud.lnr) {
                    TTBaseVideoActivity.this.ud.uw.lnr().lnr(TTBaseVideoActivity.this.ud.ud);
                    bjy.ud();
                }
                if (!zOth && TTBaseVideoActivity.this.ud.ud.hrh()) {
                    TTBaseVideoActivity.this.ud.ud.om(1);
                    TTBaseVideoActivity.this.ud.gy.yt();
                }
                if (TTBaseVideoActivity.this.ud.ud.taz() == 21 && !TTBaseVideoActivity.this.ud.ud.bjy()) {
                    TTBaseVideoActivity.this.ud.ud.mml(true);
                    TTBaseVideoActivity.this.ud.gy.yt();
                }
                if (TTBaseVideoActivity.this.fs && TTBaseVideoActivity.this.ud.bqt.fs()) {
                    return;
                }
                if (!TTBaseVideoActivity.this.oth()) {
                    if (com.bytedance.sdk.openadsdk.core.model.aaj.mml(TTBaseVideoActivity.this.ud.ud) || com.bytedance.sdk.openadsdk.core.model.aaj.ud(TTBaseVideoActivity.this.ud.ud) || com.bytedance.sdk.openadsdk.core.model.aaj.wd(TTBaseVideoActivity.this.ud.ud)) {
                        TTBaseVideoActivity.this.qdl(false, 5);
                        if (!com.bytedance.sdk.openadsdk.core.model.aaj.ud(TTBaseVideoActivity.this.ud.ud) || TTBaseVideoActivity.this.ud.kab == null) {
                            return;
                        }
                        TTBaseVideoActivity.this.ud.kab.qdl(0L);
                        return;
                    }
                    if (com.bytedance.sdk.openadsdk.core.model.aaj.qdl(TTBaseVideoActivity.this.ud.ud) && !TTBaseVideoActivity.this.ud.jtx.get()) {
                        TTBaseVideoActivity.this.ud.qdl(true);
                        TTBaseVideoActivity.this.ud.fco.mzz(true);
                        return;
                    }
                }
                if (TTBaseVideoActivity.this.ud.lnr) {
                    if (TTBaseVideoActivity.this.ud.ud.yh()) {
                        if (zOth) {
                            if (TTBaseVideoActivity.this.ud.bqt.rq() == 1) {
                                TTBaseVideoActivity.this.ud.fco.lnr();
                                return;
                            }
                            return;
                        }
                        TTBaseVideoActivity.this.ud.fco.lnr();
                        return;
                    }
                    TTBaseVideoActivity.this.qdl(false, 5);
                    if (!zOth && com.bytedance.sdk.openadsdk.core.model.aaj.ud(TTBaseVideoActivity.this.ud.ud) && TTBaseVideoActivity.this.ud.kab != null) {
                        TTBaseVideoActivity.this.ud.kab.qdl(0L);
                    }
                    if (ljh.mzz(TTBaseVideoActivity.this.ud.ud)) {
                        return;
                    }
                    TTBaseVideoActivity.this.ud.bch.qdl("skip", true);
                    return;
                }
                TTBaseVideoActivity.this.bqt();
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.qdl
            public void ud(long j2, int i) {
                TTBaseVideoActivity.this.mml.removeMessages(AnimationConstants.DefaultDurationMillis);
                if (TTBaseVideoActivity.this.ud.gy != null && TTBaseVideoActivity.this.ud.gy.bjy != null) {
                    TTBaseVideoActivity.this.ud.gy.bjy.to();
                }
                if (TTBaseVideoActivity.this.ud.bch.mo()) {
                    TTBaseVideoActivity.this.exu();
                    return;
                }
                TTBaseVideoActivity.this.ud.bch.exc();
                TTBaseVideoActivity.this.bch();
                if (TTBaseVideoActivity.this.ud.ud.mo()) {
                    TTBaseVideoActivity.this.ud.bqt.qdl(true);
                }
                if (TTBaseVideoActivity.this.ud.lnr) {
                    TTBaseVideoActivity.this.qdl(false, true, 3);
                    TTBaseVideoActivity.this.ud.bch.qdl(1 ^ (TTBaseVideoActivity.this.ud.bch.hzv() ? 1 : 0), 2);
                } else {
                    TTBaseVideoActivity.this.finish();
                }
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.qdl
            public void qdl() {
                TTBaseVideoActivity.this.mml.removeMessages(AnimationConstants.DefaultDurationMillis);
                TTBaseVideoActivity.this.rdp();
                TTBaseVideoActivity.this.bch();
                if (TTBaseVideoActivity.this.ud.lnr) {
                    TTBaseVideoActivity.this.qdl(false, true, 6);
                } else {
                    TTBaseVideoActivity.this.finish();
                }
                TTBaseVideoActivity.this.ud.bch.qdl(!TTBaseVideoActivity.this.ud.bch.hzv() ? 1 : 0, 1 ^ (TTBaseVideoActivity.this.ud.bch.hzv() ? 1 : 0));
                TTBaseVideoActivity.this.ud.bch.exc();
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.qdl
            public void qdl(long j2, long j3) {
                if (!TTBaseVideoActivity.this.ud.irn && TTBaseVideoActivity.this.ud.bch.mo()) {
                    TTBaseVideoActivity.this.ud.bch.jyq();
                }
                if (TTBaseVideoActivity.this.ud.to.get()) {
                    return;
                }
                TTBaseVideoActivity.this.mml.removeMessages(AnimationConstants.DefaultDurationMillis);
                if (j2 != TTBaseVideoActivity.this.ud.bch.exu()) {
                    TTBaseVideoActivity.this.rdp();
                }
                if (!TTBaseVideoActivity.this.oth() || TTBaseVideoActivity.this.ud.bch.mo()) {
                    TTBaseVideoActivity.this.ud.bch.qdl(j2, j3);
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    long j4 = j2 / 1000;
                    tTBaseVideoActivity.mo = (int) (tTBaseVideoActivity.ud.bch.fco() - j4);
                    int i = (int) j4;
                    if ((TTBaseVideoActivity.this.ud.aaj.get() || TTBaseVideoActivity.this.ud.rq.get()) && TTBaseVideoActivity.this.ud.bch.mo()) {
                        TTBaseVideoActivity.this.ud.bch.jyq();
                    }
                    if (TTBaseVideoActivity.this.aaj()) {
                        TTBaseVideoActivity.this.ud.gy.mzz(i);
                    }
                    if (TTBaseVideoActivity.this.jyq()) {
                        if (TTBaseVideoActivity.this.ud.bch.mml()) {
                            if (TTBaseVideoActivity.this.to != null) {
                                TTBaseVideoActivity.this.to.qdl(j2);
                                return;
                            }
                            return;
                        } else {
                            if (TTBaseVideoActivity.this.to == null || !TTBaseVideoActivity.this.to.qdl()) {
                                TTBaseVideoActivity.this.qdl(j2, j3);
                                return;
                            }
                            return;
                        }
                    }
                    TTBaseVideoActivity.this.qdl(j2, j3);
                }
            }
        };
        this.ud.bch.qdl(qdlVar);
        if (!this.ud.ud.mo() && this.ud.gy != null && this.ud.gy.bjy != null) {
            this.ud.gy.bjy.qdl(qdlVar);
        }
        boolean zQdl = this.ud.bch.qdl(j, z, mapKoa, this.lnr);
        ud(zQdl, z);
        return zQdl;
    }

    public void bqt() {
        if (this.ud.ud.yh()) {
            if (this.ud.ud.mo()) {
                if (this.ud.bqt.rq() == 1) {
                    this.ud.fco.lnr();
                    return;
                }
                return;
            }
            this.ud.fco.lnr();
            return;
        }
        if (!ljh.mzz(this.ud.ud)) {
            this.ud.bch.qdl("skip", true);
        }
        finish();
    }

    private static class qdl implements Runnable {
        boolean qdl;
        AdSlot ud;

        qdl(boolean z, AdSlot adSlot) {
            this.qdl = z;
            this.ud = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.qdl) {
                exu.qdl(yt.qdl()).qdl(this.ud);
            } else {
                com.bytedance.sdk.openadsdk.component.reward.mzz.qdl(yt.qdl()).qdl(this.ud);
            }
        }
    }
}
