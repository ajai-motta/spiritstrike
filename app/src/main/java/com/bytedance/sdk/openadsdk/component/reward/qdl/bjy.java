package com.bytedance.sdk.openadsdk.component.reward.qdl;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.animation.core.AnimationConstants;
import com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.exu.mml.qdl;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.bjy;
import com.bytedance.sdk.openadsdk.utils.gy;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class bjy {
    private String aaj;
    private boolean bch;
    private boolean bjy;
    private long exc;
    private boolean exu;
    private long fs;
    private long jl;
    private final ljh jpc;
    private final qdl ljh;
    boolean lnr;
    final boolean mml;
    com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr mo;
    private boolean oth;
    private com.bytedance.sdk.openadsdk.mml.wd rc;
    private boolean rdp;
    private long rq;
    private final String to;
    private FrameLayout tvp;
    private qdl.InterfaceC0231qdl vu;
    private final Activity wd;
    protected boolean qdl = false;
    boolean ud = false;
    protected boolean mzz = false;
    private long jtx = -1;
    private int yt = -1;
    private boolean uw = false;
    private int xmv = 0;
    private float bqt = 1.0f;
    private boolean koa = false;
    private HashSet<String> jyq = new HashSet<>();

    public long qdl() {
        return this.jtx;
    }

    public void qdl(long j) {
        this.jtx = j;
    }

    public long ud() {
        return this.jl;
    }

    public boolean lnr() {
        return this.uw;
    }

    public boolean mml() {
        int i;
        return this.koa ? this.uw && this.xmv == 1 : this.uw && ((i = this.xmv) == 2 || i == 1);
    }

    public com.bytedance.sdk.openadsdk.mml.wd mzz() {
        return this.rc;
    }

    public bjy(qdl qdlVar) {
        this.ljh = qdlVar;
        this.wd = qdlVar.ag;
        this.jpc = qdlVar.ud;
        this.mml = qdlVar.mml;
        this.to = qdlVar.mzz;
    }

    public void qdl(FrameLayout frameLayout, com.bytedance.sdk.openadsdk.mml.wd wdVar) {
        if (this.oth) {
            return;
        }
        this.oth = true;
        this.tvp = frameLayout;
        if (this.jpc.eu() != null) {
            this.xmv = this.jpc.eu().ud();
            this.bqt = this.jpc.eu().qdl();
        }
        this.rc = wdVar;
        if (ljh.mzz(this.jpc)) {
            this.koa = true;
            this.mo = new com.bytedance.sdk.openadsdk.core.exu.mml.qdl(this.wd, this.tvp, this.jpc, wdVar);
            mml(this.bch);
            qdl.InterfaceC0231qdl interfaceC0231qdl = this.vu;
            if (interfaceC0231qdl != null) {
                ((com.bytedance.sdk.openadsdk.core.exu.mml.qdl) this.mo).qdl(interfaceC0231qdl);
            }
            ((com.bytedance.sdk.openadsdk.core.exu.mml.qdl) this.mo).mo(this.bjy);
            return;
        }
        this.koa = false;
        com.bytedance.sdk.openadsdk.component.reward.lnr lnrVar = new com.bytedance.sdk.openadsdk.component.reward.lnr(this.jpc, wdVar);
        this.mo = lnrVar;
        qdl.InterfaceC0231qdl interfaceC0231qdl2 = this.vu;
        if (interfaceC0231qdl2 != null) {
            lnrVar.qdl(interfaceC0231qdl2);
        }
    }

    public void qdl(com.bytedance.sdk.openadsdk.mml.wd wdVar) {
        this.rc = wdVar;
    }

    public boolean mo() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        return (lnrVar == null || lnrVar.rq() == null || !this.mo.rq().mo()) ? false : true;
    }

    public boolean wd() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        return lnrVar != null && lnrVar.exu();
    }

    public com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl jpc() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar == null) {
            return null;
        }
        if (lnrVar instanceof com.bytedance.sdk.openadsdk.component.reward.lnr) {
            return ((com.bytedance.sdk.openadsdk.component.reward.lnr) lnrVar).yt();
        }
        return lnrVar.fs();
    }

    public boolean tvp() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        return (lnrVar == null || lnrVar.rq() == null || !this.mo.rq().wd()) ? false : true;
    }

    public boolean to() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        return lnrVar != null && lnrVar.rdp();
    }

    public void qdl(long j, long j2) {
        this.fs = j;
        ud(j, j2);
    }

    private void ud(long j, long j2) {
        int iAbs = (int) Math.abs(((long) this.yt) - j);
        int i = this.yt;
        if (i < 0 || iAbs > 500 || i > j2 || iAbs >= 500 || this.jyq.contains(this.aaj)) {
            return;
        }
        if (this.yt > j) {
            com.bytedance.sdk.openadsdk.core.rdp.lnr().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.bjy.1
                @Override // java.lang.Runnable
                public void run() {
                    bjy.this.hkc();
                    bjy.this.ljh.bqt.qdl(bjy.this.yt, bjy.this.aaj);
                }
            }, iAbs);
        } else {
            hkc();
            this.ljh.bqt.qdl(this.yt, this.aaj);
        }
        this.jyq.add(this.aaj);
    }

    public void qdl(int i, String str) {
        this.yt = i;
        this.aaj = str;
    }

    public boolean rq() {
        return this.qdl;
    }

    public long fs() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            return lnrVar.mo();
        }
        return this.rq;
    }

    public long exu() {
        return this.fs;
    }

    public long rdp() {
        return this.rq;
    }

    public void ud(long j) {
        this.rq = j;
    }

    public void qdl(boolean z) {
        this.qdl = z;
    }

    public void bjy() {
        try {
            if (mo()) {
                this.mo.ud();
            }
        } catch (Throwable th) {
            aaj.lnr("RewardFullVideoPlayerManager onPause throw Exception :" + th.getMessage(), new Object[0]);
        }
    }

    public void qdl(int i, int i2) {
        if (this.mo != null) {
            bjy.qdl qdlVar = new bjy.qdl();
            qdlVar.lnr(jtx());
            qdlVar.mml(uw());
            qdlVar.ud(fs());
            qdlVar.qdl(i);
            qdlVar.ud(i2);
            com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.mml(this.mo.fs(), qdlVar);
        }
    }

    public long jtx() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            return lnrVar.wd();
        }
        return 0L;
    }

    public com.bykv.vk.openvk.qdl.qdl.qdl.qdl yt() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            return lnrVar.rq();
        }
        return null;
    }

    private void yh() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar == null || lnrVar.rq() == null) {
            return;
        }
        this.rq = this.mo.mo();
        if (this.mo.rq().lnr() || !this.mo.rq().ud()) {
            this.mo.ud();
            this.mo.mml();
            this.qdl = true;
        }
    }

    public void jl() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar == null) {
            return;
        }
        lnrVar.mml();
        this.mo = null;
    }

    public void exc() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            lnrVar.mzz();
        }
    }

    public void aaj() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            lnrVar.lnr();
        }
    }

    public void ud(boolean z) {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            lnrVar.ud();
            this.rdp = z;
        }
    }

    public void jyq() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            lnrVar.ud();
        }
    }

    public void qdl(lnr.qdl qdlVar) {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            lnrVar.qdl(qdlVar);
        }
    }

    public void qdl(boolean z, String str) {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            lnrVar.qdl(z, str);
        }
    }

    public long oth() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            return lnrVar.tvp();
        }
        return 0L;
    }

    public int ljh() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            return lnrVar.to();
        }
        return 0;
    }

    public int bch() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            return lnrVar.jpc();
        }
        return 0;
    }

    public long uw() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            return lnrVar.tvp() + this.mo.wd();
        }
        return 0L;
    }

    public void qdl(String str, boolean z) {
        if (this.mo != null) {
            long jFs = fs();
            if (this.jpc.yh()) {
                jFs = this.ljh.lnr();
            }
            long j = jFs;
            JSONObject jSONObjectQdl = gy.qdl(this.jpc, this.mo.wd(), this.mo.rq());
            try {
                jSONObjectQdl.put("auto_click", z);
                if (!z) {
                    com.bytedance.sdk.openadsdk.mml.lnr.qdl(jSONObjectQdl, this.ljh.mml ? this.ljh.ud.qg() : this.ljh.ud.ws(), (int) j);
                }
            } catch (Exception unused) {
            }
            com.bytedance.sdk.openadsdk.mml.lnr.qdl(this.jpc, this.to, str, j, ljh(), jSONObjectQdl, this.rc);
            uw();
            ljh();
        }
        ax();
    }

    public long xmv() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            return lnrVar.tvp();
        }
        return 0L;
    }

    public boolean bqt() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            if (lnrVar.rq() != null) {
                com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVarRq = this.mo.rq();
                if (qdlVarRq.wd() || qdlVarRq.jpc()) {
                    com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar2 = this.mo;
                    if (lnrVar2 instanceof com.bytedance.sdk.openadsdk.core.exu.mml.qdl) {
                        ((com.bytedance.sdk.openadsdk.core.exu.mml.qdl) lnrVar2).mrf();
                    }
                    return true;
                }
            } else if (rq()) {
                qdl(false);
                com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar3 = this.mo;
                if (lnrVar3 instanceof com.bytedance.sdk.openadsdk.core.exu.mml.qdl) {
                    ((com.bytedance.sdk.openadsdk.core.exu.mml.qdl) lnrVar3).mrf();
                }
                return true;
            }
        }
        return false;
    }

    public boolean koa() {
        return this.mo != null;
    }

    public boolean vu() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        return lnrVar != null && lnrVar.rq() == null;
    }

    public boolean qdl(long j, boolean z, Map<String, Object> map, com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar) {
        boolean zQdl;
        boolean z2 = false;
        if (!koa()) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.core.model.aaj.mml(this.ljh.ud) || com.bytedance.sdk.openadsdk.core.model.aaj.wd(this.ljh.ud)) {
            return true;
        }
        if (!z || !vu()) {
            qdl(udVar);
        }
        try {
            zQdl = qdl(j, this.ljh.gt);
            try {
                this.exu = false;
            } catch (Exception e) {
                e = e;
                z2 = zQdl;
                Log.e("TTAD.RFVideoPlayerMag", "playVideo: ", e);
                zQdl = z2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (zQdl && !z) {
            this.ljh.vu.qdl(map);
        }
        return zQdl;
    }

    public void qdl(com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar) {
        if (this.ljh.to.get() || !this.ljh.irn || vu.lnr(this.ljh.ud)) {
            return;
        }
        if ((!ljh.mzz(this.ljh.ud) && com.bytedance.sdk.openadsdk.core.yt.mml().exu(String.valueOf(this.ljh.mo)) == 1 && this.ljh.bqt.mml()) || com.bytedance.sdk.openadsdk.core.model.aaj.mml(this.ljh.ud) || com.bytedance.sdk.openadsdk.core.model.aaj.wd(this.ljh.ud) || this.mzz || !udVar.mo()) {
            return;
        }
        this.ljh.cx.removeMessages(AnimationConstants.DefaultDurationMillis);
        Message messageObtain = Message.obtain();
        messageObtain.what = AnimationConstants.DefaultDurationMillis;
        this.ljh.cx.sendMessageDelayed(messageObtain, 5000L);
    }

    public void rc() {
        int i = this.xmv;
        if (i == 1 || i == 2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("switch", 0);
                qdl(jSONObject);
            } catch (Throwable th) {
                aaj.qdl("TTAD.RFVideoPlayerMag", "onStopPlaySpeed: ", th);
            }
        }
    }

    public boolean qdl(JSONObject jSONObject) {
        int i;
        if (this.mo == null || jSONObject == null || ((i = this.xmv) != 1 && i != 2)) {
            this.uw = false;
            return false;
        }
        int iOptInt = jSONObject.optInt("switch", 0);
        float fOptDouble = (float) jSONObject.optDouble("speed", 0.0d);
        this.bqt = fOptDouble;
        if (fOptDouble <= 0.0f && this.ljh.ud.eu() != null) {
            this.bqt = this.ljh.ud.eu().qdl();
        }
        if (iOptInt == 0) {
            this.bqt = 1.0f;
            if (this.uw) {
                long jCurrentTimeMillis = this.jl + (System.currentTimeMillis() - this.exc);
                this.jl = jCurrentTimeMillis;
                com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
                if (lnrVar != null) {
                    lnrVar.qdl(jCurrentTimeMillis);
                }
                if (this.ljh.wc != null) {
                    this.ljh.wc.mml(false);
                }
            }
        } else if (iOptInt == 1 && !this.uw) {
            this.exc = System.currentTimeMillis();
            if (this.ljh.wc != null) {
                this.ljh.wc.mml(true);
            }
        }
        this.uw = iOptInt == 1;
        if (this.xmv == 1) {
            return true;
        }
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar2 = this.mo;
        if (lnrVar2 == null) {
            return false;
        }
        return lnrVar2.qdl(this.bqt);
    }

    private boolean qdl(long j, boolean z) {
        if (this.mo == null || this.jpc.tdy() == null) {
            return false;
        }
        String strQdl = CacheDirFactory.getICacheDir(this.jpc.lhl()).qdl();
        File file = new File(strQdl, this.jpc.tdy().rdp());
        if (file.exists() && file.length() > 0) {
            this.ud = true;
        }
        com.bytedance.sdk.openadsdk.core.exu.qdl.ud udVarQdl = ljh.qdl(strQdl, this.jpc);
        udVarQdl.ud(this.jpc.yre());
        udVarQdl.ud(this.tvp.getWidth());
        udVarQdl.lnr(this.tvp.getHeight());
        udVarQdl.lnr(this.jpc.ir());
        udVarQdl.qdl(j);
        udVarQdl.qdl(z);
        return this.mo.qdl(udVarQdl);
    }

    public void lnr(boolean z) {
        this.lnr = z;
    }

    public boolean kdv() {
        return this.lnr;
    }

    public void ekw() {
        this.uw = false;
        jl();
    }

    public void hkc() {
        try {
            if (mo()) {
                this.mzz = true;
                jyq();
            }
        } catch (Exception e) {
            aaj.lnr("TTAD.RFVideoPlayerMag", "onPause throw Exception :" + e.getMessage());
        }
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.exu.mml.ud udVar) {
        try {
            this.mzz = false;
            if (rq()) {
                yh();
                ud(udVar);
            } else if (tvp()) {
                aaj();
            }
        } catch (Throwable th) {
            aaj.lnr("TTAD.RFVideoPlayerMag", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void qdl(boolean z, com.bytedance.sdk.openadsdk.core.exu.mml.ud udVar, boolean z2) {
        if (this.rdp || !(!z2 || z || this.mzz)) {
            if (tvp()) {
                aaj();
                Log.i("TTAD.RFVideoPlayerMag", "resumeOrRestartVideo: continue play");
            } else {
                yh();
                ud(udVar);
                Log.i("TTAD.RFVideoPlayerMag", "resumeOrRestartVideo: recreate video player & exec play");
            }
            this.rdp = false;
        }
    }

    public boolean hzv() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar == null || lnrVar.rq() == null) {
            return false;
        }
        return this.mo.rq().qdl();
    }

    protected void ud(com.bytedance.sdk.openadsdk.core.exu.mml.ud udVar) {
        if (!bqt() || udVar == null) {
            return;
        }
        udVar.qdl(rdp(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double fco() {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.core.model.ljh r0 = r5.jpc
            com.bytedance.sdk.openadsdk.core.model.jyq r0 = r0.aaj()
            com.bytedance.sdk.openadsdk.core.model.ljh r1 = r5.jpc
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.aaj.mml(r1)
            if (r1 == 0) goto L16
            if (r0 == 0) goto L16
            long r0 = r0.ud()
        L14:
            double r0 = (double) r0
            goto L3b
        L16:
            com.bytedance.sdk.openadsdk.core.model.ljh r1 = r5.jpc
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.aaj.wd(r1)
            if (r1 == 0) goto L25
            if (r0 == 0) goto L25
            long r0 = r0.mml()
            goto L14
        L25:
            com.bytedance.sdk.openadsdk.core.model.ljh r0 = r5.jpc
            com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud r0 = r0.tdy()
            if (r0 == 0) goto L39
            double r1 = r0.mo()
            int r0 = r0.oth()
            double r3 = (double) r0
            double r0 = r1 * r3
            goto L3b
        L39:
            r0 = 0
        L3b:
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r2 = r5.ljh
            com.bytedance.sdk.openadsdk.component.reward.rq r2 = r2.gg
            if (r2 == 0) goto L49
            com.bytedance.sdk.openadsdk.component.reward.qdl.qdl r2 = r5.ljh
            com.bytedance.sdk.openadsdk.component.reward.rq r2 = r2.gg
            long r3 = (long) r0
            r2.qdl(r3)
        L49:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.qdl.bjy.fco():double");
    }

    public void mrf() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar instanceof com.bytedance.sdk.openadsdk.core.exu.mml.qdl) {
            ((com.bytedance.sdk.openadsdk.core.exu.mml.qdl) lnrVar).fco();
        }
    }

    public View gy() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar instanceof com.bytedance.sdk.openadsdk.core.exu.mml.qdl) {
            return (View) ((com.bytedance.sdk.openadsdk.core.exu.mml.qdl) lnrVar).gy();
        }
        return null;
    }

    public void ax() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar instanceof com.bytedance.sdk.openadsdk.core.exu.mml.qdl) {
            ((com.bytedance.sdk.openadsdk.core.exu.mml.qdl) lnrVar).ax();
        }
    }

    public void ag() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar instanceof com.bytedance.sdk.openadsdk.core.exu.mml.qdl) {
            ((com.bytedance.sdk.openadsdk.core.exu.mml.qdl) lnrVar).ag();
        }
    }

    public void mml(boolean z) {
        this.bch = z;
        if (this.mo instanceof com.bytedance.sdk.openadsdk.core.exu.mml.qdl) {
            if (z) {
                ((com.bytedance.sdk.openadsdk.core.exu.mml.qdl) this.mo).ud(this.jpc.tdy().oth());
            } else {
                this.jpc.tdy().to(1);
                ((com.bytedance.sdk.openadsdk.core.exu.mml.qdl) this.mo).ud(1);
            }
        }
    }

    public void qdl(qdl.InterfaceC0231qdl interfaceC0231qdl) {
        this.vu = interfaceC0231qdl;
    }

    public void wc() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar != null) {
            lnrVar.qdl();
        }
    }

    public void om() {
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar == null || lnrVar.rq() == null) {
            return;
        }
        this.rq = this.mo.mo();
        exc();
        qdl(true);
        this.exu = true;
    }

    public boolean cx() {
        return this.exu;
    }

    public void mzz(boolean z) {
        this.bjy = z;
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.mo;
        if (lnrVar instanceof com.bytedance.sdk.openadsdk.core.exu.mml.qdl) {
            ((com.bytedance.sdk.openadsdk.core.exu.mml.qdl) lnrVar).mo(z);
        }
    }
}
