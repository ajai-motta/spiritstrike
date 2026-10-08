package com.bytedance.sdk.openadsdk.core.tvp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.tvp.mzz;
import com.bytedance.sdk.openadsdk.core.vu;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.google.android.material.badge.BadgeDrawable;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    private ScheduledFuture<?> jpc;
    private qdl lnr;
    private com.bytedance.sdk.component.adexpress.ud.bjy mml;
    private int mo;
    private aaj mzz;
    com.bytedance.sdk.openadsdk.core.model.ljh qdl;
    private int tvp;
    private final Context ud;
    private int wd;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.tvp.lnr$lnr, reason: collision with other inner class name */
    interface InterfaceC0258lnr {
        void qdl();

        void qdl(int i, int i2);

        void qdl(String str);

        void ud(String str);
    }

    public lnr(Context context, aaj aajVar, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, String str) {
        this.qdl = ljhVar;
        this.ud = context;
        this.mzz = aajVar;
        qdl(aajVar);
        this.lnr = new qdl(context, ljhVar, this.mo, this.wd, str, this.tvp);
    }

    private void qdl(aaj aajVar) {
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.qdl;
        if (ljhVar != null && ljhVar.au()) {
            this.mo = -1;
            this.wd = -1;
            return;
        }
        jl jlVarQdl = com.bytedance.sdk.openadsdk.core.mml.ud.qdl(aajVar.getExpectExpressWidth(), aajVar.getExpectExpressHeight());
        this.tvp = jlVarQdl.qdl;
        if (aajVar.getExpectExpressWidth() > 0 && aajVar.getExpectExpressHeight() > 0) {
            this.mo = ax.ud(this.ud, aajVar.getExpectExpressWidth());
            this.wd = ax.ud(this.ud, aajVar.getExpectExpressHeight());
        } else {
            int iLnr = ax.lnr(this.ud);
            this.mo = iLnr;
            this.wd = Float.valueOf(iLnr / jlVarQdl.ud).intValue();
        }
        int i = this.mo;
        if (i <= 0 || i <= ax.lnr(this.ud)) {
            return;
        }
        this.mo = ax.lnr(this.ud);
        this.wd = Float.valueOf(this.wd * (ax.lnr(this.ud) / this.mo)).intValue();
    }

    public void qdl(com.bytedance.sdk.component.adexpress.ud.bjy bjyVar) {
        this.mml = bjyVar;
    }

    public void qdl() {
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.qdl;
        if (ljhVar != null && ljhVar.au()) {
            this.jpc = fco.qdl().schedule(new ud(this.lnr.fs), com.bytedance.sdk.openadsdk.core.yt.mml().fco(), TimeUnit.MILLISECONDS);
        }
        qdl qdlVar = this.lnr;
        if (qdlVar != null) {
            qdlVar.qdl(new com.bytedance.sdk.component.adexpress.ud.wd() { // from class: com.bytedance.sdk.openadsdk.core.tvp.lnr.1
                @Override // com.bytedance.sdk.component.adexpress.ud.wd
                public void qdl(View view, com.bytedance.sdk.component.adexpress.ud.rdp rdpVar) {
                    if (lnr.this.mzz == null || view == null) {
                        if (lnr.this.mml != null) {
                            lnr.this.mml.a_(106);
                        }
                    } else if (lnr.this.mml != null) {
                        lnr.this.mml.qdl(lnr.this.lnr, rdpVar);
                    }
                    lnr.this.lnr();
                }

                @Override // com.bytedance.sdk.component.adexpress.ud.wd
                public void qdl(int i, String str) {
                    if (lnr.this.mml != null) {
                        lnr.this.mml.a_(106);
                    }
                    lnr.this.lnr();
                }
            });
            View viewMzz = this.lnr.mzz();
            this.mzz.removeView(viewMzz);
            if (viewMzz.getParent() != null) {
                ((ViewGroup) viewMzz.getParent()).removeView(viewMzz);
            }
            this.mzz.addView(viewMzz, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        com.bytedance.sdk.component.adexpress.ud.bjy bjyVar = this.mml;
        if (bjyVar != null) {
            bjyVar.a_(106);
        }
    }

    public void ud() {
        qdl qdlVar = this.lnr;
        if (qdlVar != null) {
            qdlVar.mml();
            this.lnr = null;
        }
        lnr();
        this.mml = null;
        this.mzz = null;
    }

    public void qdl(vu vuVar) {
        qdl qdlVar = this.lnr;
        if (qdlVar != null) {
            qdlVar.qdl(vuVar);
        }
    }

    public void qdl(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        qdl qdlVar = this.lnr;
        if (qdlVar != null) {
            qdlVar.qdl(tTDislikeDialogAbstract);
        }
    }

    public void qdl(String str) {
        qdl qdlVar = this.lnr;
        if (qdlVar != null) {
            qdlVar.qdl(str);
        }
    }

    public void qdl(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        qdl qdlVar = this.lnr;
        if (qdlVar != null) {
            qdlVar.qdl(pAGExpressAdWrapperListener);
        }
    }

    public static class qdl implements com.bytedance.sdk.component.adexpress.ud.mml<View>, mzz.ud {
        private PAGExpressAdWrapperListener bjy;
        private int exu;
        private mzz fs;
        private FrameLayout jpc;
        private TTDislikeDialogAbstract lnr;
        private String mml;
        private final int mo;
        private final Context mzz;
        AtomicBoolean qdl = new AtomicBoolean(false);
        private com.bytedance.sdk.component.adexpress.ud.wd rdp;
        private String rq;
        private final int to;
        private com.bytedance.sdk.openadsdk.core.model.ljh tvp;
        private com.bytedance.sdk.openadsdk.lnr.lnr ud;
        private final int wd;

        @Override // com.bytedance.sdk.component.adexpress.ud.mml
        public int lnr() {
            return 5;
        }

        public qdl(Context context, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, int i, int i2, String str, int i3) {
            this.rq = str;
            if (ljhVar != null && ljhVar.au()) {
                this.rq = "fullscreen_interstitial_ad";
            }
            this.mzz = context;
            this.mo = i;
            this.wd = i2;
            this.tvp = ljhVar;
            this.to = ax.ud(context, 3.0f);
            this.exu = i3;
            mo();
        }

        private void mo() {
            FrameLayout frameLayout = new FrameLayout(this.mzz);
            this.jpc = frameLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.mo, this.wd);
            }
            layoutParams.width = this.mo;
            layoutParams.height = this.wd;
            layoutParams.gravity = 17;
            this.jpc.setLayoutParams(layoutParams);
            mzz mzzVarJpc = jpc();
            this.jpc.addView(mzzVarJpc);
            View viewWd = wd();
            this.jpc.addView(viewWd);
            com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.tvp;
            if (ljhVar != null && ljhVar.au()) {
                mzzVarJpc.setBackgroundColor(-16777216);
                mzzVarJpc.qdl(((Activity) this.mzz).findViewById(com.bytedance.sdk.openadsdk.utils.jtx.tvf), FriendlyObstructionPurpose.OTHER);
            }
            mzzVarJpc.qdl(viewWd, FriendlyObstructionPurpose.OTHER);
            Context context = this.mzz;
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            View viewFindViewById = ((Activity) context).findViewById(com.bytedance.sdk.openadsdk.utils.jtx.uj);
            if (viewFindViewById != null) {
                mzzVarJpc.qdl(viewFindViewById, FriendlyObstructionPurpose.OTHER);
            }
            View viewFindViewById2 = ((Activity) this.mzz).findViewById(com.bytedance.sdk.openadsdk.utils.jtx.fc);
            if (viewFindViewById2 != null) {
                mzzVarJpc.qdl(viewFindViewById2, FriendlyObstructionPurpose.OTHER);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.ud.mml
        public void qdl(com.bytedance.sdk.component.adexpress.ud.wd wdVar) {
            com.bytedance.sdk.openadsdk.core.model.ljh ljhVar;
            if (this.qdl.get()) {
                return;
            }
            if (this.mzz == null || (ljhVar = this.tvp) == null) {
                wdVar.qdl(106, "material null");
                return;
            }
            this.rdp = wdVar;
            if (TextUtils.isEmpty(ljhVar.fk())) {
                wdVar.qdl(106, "dsp data is null");
            } else {
                this.fs.aaj();
            }
        }

        private View wd() {
            PAGLogoView pAGLogoViewCreatePAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.mzz, this.tvp);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.tvp;
            if (ljhVar != null && ljhVar.au()) {
                layoutParams.leftMargin = ax.ud(this.mzz, 20.0f);
                layoutParams.bottomMargin = ax.ud(this.mzz, 20.0f);
                layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            } else {
                layoutParams.topMargin = this.to;
                layoutParams.leftMargin = this.to;
            }
            pAGLogoViewCreatePAGLogoViewByMaterial.setLayoutParams(layoutParams);
            pAGLogoViewCreatePAGLogoViewByMaterial.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.tvp.lnr.qdl.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebsiteActivity.qdl(qdl.this.mzz, qdl.this.tvp, qdl.this.rq);
                }
            });
            return pAGLogoViewCreatePAGLogoViewByMaterial;
        }

        private mzz jpc() {
            mzz mzzVarUd = mml.qdl().ud();
            this.fs = mzzVarUd;
            if (mzzVarUd == null) {
                this.fs = new mzz(this.mzz);
            }
            mml.qdl().lnr(this.fs);
            this.fs.qdl(this.tvp, this, this.rq);
            this.fs.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this.fs;
        }

        @Override // com.bytedance.sdk.component.adexpress.ud.mml
        public View mzz() {
            return this.jpc;
        }

        public void mml() {
            this.jpc = null;
            this.ud = null;
            this.lnr = null;
            this.rdp = null;
            this.tvp = null;
            mzz mzzVar = this.fs;
            if (mzzVar != null) {
                mzzVar.jtx();
                mml.qdl().qdl(this.fs);
            }
            this.qdl.set(true);
        }

        public void qdl(vu vuVar) {
            if (vuVar instanceof com.bytedance.sdk.openadsdk.lnr.lnr) {
                this.ud = (com.bytedance.sdk.openadsdk.lnr.lnr) vuVar;
            }
        }

        public void qdl(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
            com.bytedance.sdk.openadsdk.core.model.ljh ljhVar;
            if (tTDislikeDialogAbstract != null && (ljhVar = this.tvp) != null) {
                tTDislikeDialogAbstract.setMaterialMeta(ljhVar.ir(), this.tvp.fc());
            }
            this.lnr = tTDislikeDialogAbstract;
        }

        public void qdl(String str) {
            this.mml = str;
        }

        @Override // com.bytedance.sdk.openadsdk.core.tvp.mzz.ud
        public View qdl() {
            FrameLayout frameLayout = this.jpc;
            if (frameLayout == null) {
                return null;
            }
            return (View) frameLayout.getParent();
        }

        @Override // com.bytedance.sdk.openadsdk.core.tvp.mzz.ud
        public void qdl(View view, int i) {
            PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.bjy;
            if (pAGExpressAdWrapperListener != null) {
                pAGExpressAdWrapperListener.onAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.tvp.mzz.ud
        public void ud() {
            if (this.rdp != null) {
                com.bytedance.sdk.component.adexpress.ud.rdp rdpVar = new com.bytedance.sdk.component.adexpress.ud.rdp();
                rdpVar.qdl(true);
                rdpVar.qdl(ax.lnr(this.mzz, this.mo));
                rdpVar.ud(ax.lnr(this.mzz, this.wd));
                this.rdp.qdl(this.jpc, rdpVar);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.tvp.mzz.ud
        public void qdl(int i, int i2) {
            com.bytedance.sdk.component.adexpress.ud.wd wdVar = this.rdp;
            if (wdVar != null) {
                wdVar.qdl(i, "render fail");
            }
        }

        public void qdl(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
            this.bjy = pAGExpressAdWrapperListener;
        }
    }

    private static class ud implements Runnable {
        InterfaceC0258lnr qdl;

        public ud(InterfaceC0258lnr interfaceC0258lnr) {
            this.qdl = interfaceC0258lnr;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC0258lnr interfaceC0258lnr = this.qdl;
            if (interfaceC0258lnr != null) {
                interfaceC0258lnr.qdl(107, 107);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lnr() {
        try {
            ScheduledFuture<?> scheduledFuture = this.jpc;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.jpc.cancel(false);
            this.jpc = null;
        } catch (Throwable unused) {
        }
    }
}
