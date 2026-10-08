package com.bytedance.sdk.openadsdk.core.exu.ud;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.jpc.jpc;
import com.bytedance.sdk.component.utils.koa;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.exu.ud.mo;
import com.bytedance.sdk.openadsdk.core.lnr.qdl;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.settings.rq;
import com.bytedance.sdk.openadsdk.core.widget.aaj;
import com.bytedance.sdk.openadsdk.core.widget.exc;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.utils.jtx;
import com.facebook.internal.NativeProtocol;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mzz implements com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud<ljh>, com.bykv.vk.openvk.qdl.qdl.qdl.mo.qdl, koa.qdl, qdl.InterfaceC0238qdl, aaj.ud, exc.qdl {
    int aaj;
    int bch;
    TextView bjy;
    aaj bqt;
    com.bytedance.sdk.openadsdk.core.lnr.qdl ekw;
    int exc;
    com.bytedance.sdk.openadsdk.core.widget.qdl exu;
    private mo.qdl fco;
    View fs;
    private final String gy;
    com.bytedance.sdk.openadsdk.core.lnr.qdl hkc;
    boolean hzv;
    int jl;
    ImageView jpc;
    TextView jtx;
    boolean jyq;
    com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr kdv;
    qdl koa;
    int ljh;
    ViewGroup lnr;
    com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud mml;
    View mo;
    private long mrf;
    ImageView mzz;
    boolean oth;
    protected final int qdl;
    com.bytedance.sdk.openadsdk.exc.qdl.qdl.mo rc;
    TextView rdp;
    ImageView rq;
    View to;
    View tvp;
    protected final int ud;
    ljh uw;
    boolean vu;
    View wd;
    Context xmv;
    int yt;

    public void lnr(boolean z) {
    }

    public void mo() {
    }

    public void mzz() {
    }

    public void qdl(int i) {
    }

    public void qdl(long j) {
    }

    public void qdl(long j, long j2) {
    }

    public void qdl(Message message) {
    }

    public void qdl(View view, boolean z) {
    }

    public void qdl(ViewGroup viewGroup) {
    }

    public void qdl(String str) {
    }

    public boolean to() {
        return false;
    }

    public void ud(ViewGroup viewGroup) {
    }

    public void ud(boolean z) {
    }

    public boolean ud(int i) {
        return false;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud
    public /* bridge */ /* synthetic */ void qdl(ljh ljhVar, WeakReference weakReference, boolean z) {
        qdl(ljhVar, (WeakReference<Context>) weakReference, z);
    }

    public mzz(Context context, ViewGroup viewGroup, boolean z, int i, ljh ljhVar, com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar, boolean z2) {
        this.qdl = 228;
        this.ud = 160;
        this.jyq = true;
        this.vu = true;
        this.hzv = true;
        this.gy = Build.MODEL;
        if (this instanceof mml) {
            return;
        }
        this.xmv = yt.qdl().getApplicationContext();
        mml(z2);
        this.lnr = viewGroup;
        this.jyq = z;
        this.bch = i;
        this.kdv = lnrVar;
        this.uw = ljhVar;
        mml(8);
        qdl(context, this.lnr);
        mml();
        fs();
    }

    public mzz(Context context, ViewGroup viewGroup, boolean z, int i, ljh ljhVar, com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar) {
        this(context, viewGroup, z, i, ljhVar, lnrVar, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void fs() {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.exu.ud.mzz.fs():void");
    }

    private boolean uw() {
        return ljh.mzz(this.uw) && (!com.bytedance.sdk.openadsdk.core.rq.mml.qdl(this.uw.ra()) ? this.uw.xdk() == null : this.uw.kr() == null) && this.uw.kab() == 1;
    }

    public void qdl(mo.qdl qdlVar) {
        this.fco = qdlVar;
    }

    public void qdl(PAGNativeAd pAGNativeAd) {
        com.bytedance.sdk.openadsdk.core.lnr.qdl qdlVar = this.ekw;
        if (qdlVar != null) {
            qdlVar.qdl(pAGNativeAd);
        }
        com.bytedance.sdk.openadsdk.core.lnr.qdl qdlVar2 = this.hkc;
        if (qdlVar2 != null) {
            qdlVar2.qdl(pAGNativeAd);
        }
    }

    public com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud exu() {
        return this.mml;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void qdl(Context context, View view) {
        View lnrVar;
        System.currentTimeMillis();
        ljh ljhVar = this.uw;
        if ((ljhVar == null || ((!ljhVar.xa() && !this.uw.oy()) || rq.lnr().kr())) && view != null) {
            view.setKeepScreenOn(true);
        }
        com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar2 = this.kdv;
        if (lnrVar2 != null && lnrVar2.bjy()) {
            lnrVar = new com.bykv.vk.openvk.qdl.qdl.qdl.mo.mml(this.xmv);
        } else {
            lnrVar = new com.bykv.vk.openvk.qdl.qdl.qdl.mo.lnr(this.xmv);
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(lnrVar, 0, layoutParams);
        }
        ax.qdl(lnrVar, 8);
        this.mml = (com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud) lnrVar;
        this.mzz = (ImageView) view.findViewById(jtx.hd);
        this.mo = view.findViewById(jtx.gsp);
        this.wd = view.findViewById(jtx.hr);
        this.jpc = (ImageView) view.findViewById(jtx.ygv);
        this.tvp = view.findViewById(jtx.syy);
        System.currentTimeMillis();
    }

    void qdl(View view, Context context) {
        View view2;
        if (view == null || context == null || (view2 = this.tvp) == null || view2.getParent() == null || this.to != null) {
            return;
        }
        this.to = this.tvp;
        this.rq = (ImageView) view.findViewById(jtx.ca);
        this.fs = view.findViewById(jtx.tdy);
        this.exu = (com.bytedance.sdk.openadsdk.core.widget.qdl) view.findViewById(jtx.ax);
        this.rdp = (TextView) view.findViewById(jtx.ag);
        this.bjy = (TextView) view.findViewById(jtx.wc);
        this.jtx = (TextView) view.findViewById(jtx.om);
    }

    void rdp() {
        if (this.koa == null || this.bqt != null) {
            return;
        }
        System.currentTimeMillis();
        aaj aajVar = new aaj();
        this.bqt = aajVar;
        aajVar.qdl(this.xmv, this.lnr);
        this.bqt.qdl(this.koa, this);
        System.currentTimeMillis();
    }

    public boolean qdl(int i, com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud udVar, boolean z) {
        aaj aajVar = this.bqt;
        return aajVar == null || aajVar.qdl(i, udVar, z);
    }

    public void bjy() {
        aaj aajVar = this.bqt;
        if (aajVar != null) {
            aajVar.qdl(false);
        }
    }

    public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.mml.qdl qdlVar) {
        if (qdlVar instanceof qdl) {
            this.koa = (qdl) qdlVar;
            rdp();
        }
    }

    boolean jtx() {
        return this.koa != null;
    }

    void mml() {
        this.mml.qdl(this);
        this.mzz.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.mzz.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (mzz.this.jtx()) {
                    if (mzz.this.jtx == null || mzz.this.jtx.getVisibility() != 0) {
                        mzz.this.koa.qdl(mzz.this, view);
                    }
                }
            }
        });
    }

    public void lnr(int i) {
        ax.qdl((View) this.lnr, 0);
        com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud udVar = this.mml;
        if (udVar != null) {
            udVar.setVisibility(i);
        }
    }

    public void mml(boolean z) {
        this.vu = z;
        if (z) {
            com.bytedance.sdk.openadsdk.core.lnr.qdl qdlVar = this.ekw;
            if (qdlVar != null) {
                qdlVar.qdl(true);
            }
            com.bytedance.sdk.openadsdk.core.lnr.qdl qdlVar2 = this.hkc;
            if (qdlVar2 != null) {
                qdlVar2.qdl(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.lnr.qdl qdlVar3 = this.ekw;
        if (qdlVar3 != null) {
            qdlVar3.qdl(false);
        }
        com.bytedance.sdk.openadsdk.core.lnr.qdl qdlVar4 = this.hkc;
        if (qdlVar4 != null) {
            qdlVar4.qdl(false);
        }
    }

    public void qdl(int i, int i2) {
        if (i == -1) {
            i = ax.lnr(this.xmv);
        }
        if (i <= 0) {
            return;
        }
        this.yt = i;
        if (jyq() || to() || (this.bch & 8) == 8) {
            this.jl = i2;
        } else {
            this.jl = mzz(i);
        }
        ud(this.yt, this.jl);
    }

    public void ud(boolean z, boolean z2) {
        ImageView imageView = this.mzz;
        if (imageView != null) {
            if (z) {
                imageView.setImageDrawable(com.bytedance.sdk.openadsdk.utils.rq.qdl(this.xmv, "tt_play_movebar_textpage"));
            } else {
                imageView.setImageDrawable(com.bytedance.sdk.openadsdk.utils.rq.qdl(this.xmv, "tt_stop_movebar_textpage"));
            }
        }
    }

    public void ud(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.lnr.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.lnr.setLayoutParams(layoutParams);
    }

    private int mzz(int i) {
        if (this.exc <= 0 || this.aaj <= 0) {
            return 0;
        }
        int iUd = ax.ud(this.xmv, 228.0f);
        int iUd2 = ax.ud(this.xmv, 160.0f);
        int i2 = (int) (this.aaj * ((i * 1.0f) / this.exc));
        return i2 > iUd ? iUd : i2 < iUd2 ? iUd2 : i2;
    }

    public void lnr(int i, int i2) {
        this.exc = i;
        this.aaj = i2;
    }

    public void lnr(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.lnr.getParent() == null) {
            viewGroup.addView(this.lnr);
        }
        mml(0);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud
    public View lnr() {
        return this.lnr;
    }

    public void wd() {
        ljh ljhVar;
        ax.mo(this.mo);
        ax.mo(this.wd);
        if (this.jpc != null && (ljhVar = this.uw) != null && ljhVar.tdy() != null && this.uw.tdy().to() != null) {
            ax.mo(this.jpc);
            com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.uw.tdy().to(), this.uw.tdy().lnr(), this.uw.tdy().ud(), this.jpc, this.uw);
        }
        if (this.mzz.getVisibility() == 0) {
            ax.qdl((View) this.mzz, 8);
        }
    }

    public void yt() {
        ax.mo(this.mo);
        ax.mo(this.wd);
        if (this.mzz.getVisibility() == 0) {
            ax.qdl((View) this.mzz, 8);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud
    public void qdl() {
        qdl(false, this.jyq);
        exc();
    }

    public void jl() {
        ax.qdl((View) this.lnr, 0);
        com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud udVar = this.mml;
        if (udVar != null) {
            ax.qdl(udVar.getView(), 0);
        }
    }

    void exc() {
        try {
            ax.qdl(this.to, 8);
            ax.qdl((View) this.rq, 8);
            ax.qdl(this.fs, 8);
            ax.qdl((View) this.exu, 8);
            ax.qdl((View) this.rdp, 8);
            ax.qdl((View) this.bjy, 8);
            ax.qdl((View) this.jtx, 8);
        } catch (Exception unused) {
        }
    }

    public void aaj() {
        ImageView imageView = this.rq;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        com.bytedance.sdk.openadsdk.core.widget.qdl qdlVar = this.exu;
        if (qdlVar != null) {
            qdlVar.setImageBitmap(null);
        }
    }

    private void mo(int i) {
        ax.qdl(this.fs, i);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud
    public void qdl(boolean z) {
        this.hzv = z;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:92:0x021b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void qdl(final com.bytedance.sdk.openadsdk.core.model.ljh r7, java.lang.ref.WeakReference<android.content.Context> r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.exu.ud.mzz.qdl(com.bytedance.sdk.openadsdk.core.model.ljh, java.lang.ref.WeakReference, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(final int i, final String str, final ljh ljhVar) {
        com.bytedance.sdk.openadsdk.mml.lnr.qdl(new jpc("load_vast_icon_fail") { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.mzz.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i);
                    jSONObject.put("description", i + ":" + str);
                    jSONObject.put("url", mzz.this.uw.hcs().qdl());
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.mml.lnr.ud(mzz.this.uw, mzz.this.uw != null ? gy.lnr(ljhVar.vz()) : null, "load_vast_icon_fail", jSONObject);
            }
        });
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud
    public void ud() {
        ax.mzz(this.mo);
        ax.mzz(this.wd);
        ImageView imageView = this.jpc;
        if (imageView != null) {
            ax.mzz(imageView);
        }
    }

    public void jpc() {
        ax.mzz(this.mo);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mo.qdl
    public void qdl(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.mml.getHolder()) {
            return;
        }
        this.oth = true;
        if (jtx()) {
            this.koa.qdl(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mo.qdl
    public void qdl(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder != this.mml.getHolder()) {
            return;
        }
        jtx();
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mo.qdl
    public void ud(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.mml.getHolder()) {
            return;
        }
        this.oth = false;
        if (jtx()) {
            this.koa.ud(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mo.qdl
    public void qdl(SurfaceTexture surfaceTexture, int i, int i2) {
        this.oth = true;
        if (jtx()) {
            this.koa.qdl(this, surfaceTexture);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mo.qdl
    public boolean qdl(SurfaceTexture surfaceTexture) {
        this.oth = false;
        if (!jtx()) {
            return true;
        }
        this.koa.ud(this, surfaceTexture);
        return true;
    }

    public void tvp() {
        mml(8);
        if (bch()) {
            this.mml.setVisibility(8);
        }
        ImageView imageView = this.jpc;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        mml(8);
        ax.qdl(this.to, 8);
        ax.qdl((View) this.rq, 8);
        ax.qdl(this.fs, 8);
        ax.qdl((View) this.exu, 8);
        ax.qdl((View) this.rdp, 8);
        ax.qdl((View) this.bjy, 8);
        aaj aajVar = this.bqt;
        if (aajVar != null) {
            aajVar.qdl(true);
        }
    }

    public boolean jyq() {
        return this.jyq;
    }

    public void qdl(boolean z, boolean z2, boolean z3) {
        ax.qdl((View) this.mzz, (!z || this.mo.getVisibility() == 0) ? 8 : 0);
    }

    public void qdl(boolean z, boolean z2) {
        ax.qdl((View) this.mzz, 8);
    }

    public void rq() {
        qdl(true, false);
    }

    public boolean oth() {
        return this.oth;
    }

    public void mml(int i) {
        this.ljh = i;
        ax.qdl((View) this.lnr, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.exc.qdl
    public boolean ljh() {
        aaj aajVar = this.bqt;
        return aajVar != null && aajVar.qdl();
    }

    boolean bch() {
        return (this.bch & 4) != 4 || this.jyq;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud
    public void qdl(Drawable drawable) {
        ViewGroup viewGroup = this.lnr;
        if (viewGroup != null) {
            viewGroup.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lnr.qdl.InterfaceC0238qdl
    public long getVideoProgress() {
        if (this.mrf <= 0) {
            ljh ljhVar = this.uw;
            if (ljhVar != null && ljhVar.tdy() != null) {
                this.mrf = (long) (this.uw.tdy().mo() * 1000.0d);
            }
            com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.kdv;
            if (lnrVar != null) {
                this.mrf = lnrVar.tvp();
            }
        }
        return this.mrf;
    }
}
