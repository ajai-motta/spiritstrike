package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.bqt;
import com.bytedance.sdk.component.utils.jl;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.core.aaj;
import com.bytedance.sdk.openadsdk.core.exu.lnr.qdl;
import com.bytedance.sdk.openadsdk.core.jyq;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.uw;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.core.oth;
import com.bytedance.sdk.openadsdk.core.yt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mzz {
    private static volatile mzz qdl;
    private final AtomicBoolean lnr = new AtomicBoolean(false);
    private final List<lnr> mml = Collections.synchronizedList(new ArrayList());
    private final bqt.qdl mo = new bqt.qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.mzz.2
        @Override // com.bytedance.sdk.component.utils.bqt.qdl
        public void qdl(Context context, Intent intent, boolean z, int i) {
            if (z) {
                if (mzz.this.mzz == null) {
                    mzz mzzVar = mzz.this;
                    mzzVar.mzz = new com.bytedance.sdk.openadsdk.component.reward.ud("fsv net connect task", mzzVar.mml);
                }
                com.bytedance.sdk.component.utils.tvp.qdl().post(mzz.this.mzz);
            }
        }
    };
    private com.bytedance.sdk.component.jpc.jpc mzz;
    private final Context ud;

    public static mzz qdl(Context context) {
        if (qdl == null) {
            synchronized (mzz.class) {
                if (qdl == null) {
                    qdl = new mzz(context);
                }
            }
        }
        return qdl;
    }

    private mzz(Context context) {
        this.ud = context == null ? yt.qdl() : context.getApplicationContext();
        lnr();
    }

    public void qdl() {
        try {
            mml.qdl(this.ud).qdl();
        } catch (Throwable unused) {
        }
    }

    public void qdl(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getCodeId()) || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.utils.ud.qdl()) {
            ud(adSlot);
        } else {
            lnr(adSlot);
        }
    }

    private void ud(final AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.core.model.bqt bqtVar = new com.bytedance.sdk.openadsdk.core.model.bqt();
        bqtVar.lnr = 2;
        if (yt.mml().fs(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            bqtVar.tvp = 2;
        }
        yt.lnr().qdl(adSlot, bqtVar, 8, (aaj) new jyq() { // from class: com.bytedance.sdk.openadsdk.component.reward.mzz.1
            boolean qdl = false;

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.aaj
            public String qdl() {
                return mml.qdl(mzz.this.ud).qdl(adSlot.getCodeId(), false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.aaj
            public boolean qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
                boolean zQdl = mml.qdl(mzz.this.ud).qdl(qdlVar);
                this.qdl = zQdl;
                return zQdl;
            }

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
                if (this.qdl || qdlVar.mml() == null || qdlVar.mml().isEmpty()) {
                    return;
                }
                mzz.this.qdl(qdlVar, new rdp(mzz.this.ud, qdlVar), adSlot, true, (PAGInterstitialAdLoadListener) null);
            }
        });
    }

    private void lnr(final AdSlot adSlot) {
        if (mml.qdl(this.ud).ud(adSlot.getCodeId(), false) != null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.bqt bqtVar = new com.bytedance.sdk.openadsdk.core.model.bqt();
        bqtVar.lnr = 2;
        if (yt.mml().fs(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            bqtVar.tvp = 2;
        }
        yt.lnr().qdl(adSlot, bqtVar, 8, new oth.qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.mzz.3
            @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
                if (qdlVar.mml() == null || qdlVar.mml().isEmpty()) {
                    return;
                }
                mzz.this.qdl(qdlVar, new rdp(mzz.this.ud, qdlVar), adSlot, true, (PAGInterstitialAdLoadListener) null);
            }
        });
    }

    public void qdl(AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        if (com.bytedance.sdk.openadsdk.utils.ud.qdl()) {
            ud(adSlot, pAGInterstitialAdLoadListener);
        } else {
            lnr(adSlot, pAGInterstitialAdLoadListener);
        }
    }

    private void ud(final AdSlot adSlot, final PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.model.bqt bqtVar = new com.bytedance.sdk.openadsdk.core.model.bqt();
        bqtVar.lnr = 1;
        if (yt.mml().fs(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            bqtVar.tvp = 2;
        }
        yt.lnr().qdl(adSlot, bqtVar, 8, (aaj) new jyq() { // from class: com.bytedance.sdk.openadsdk.component.reward.mzz.4
            boolean qdl = false;

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(int i, String str) {
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener;
                if (pAGInterstitialAdLoadListener2 != null) {
                    pAGInterstitialAdLoadListener2.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
                if (qdlVar.mml() != null && !qdlVar.mml().isEmpty()) {
                    rdp rdpVar = new rdp(mzz.this.ud, qdlVar);
                    if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                        com.bytedance.sdk.openadsdk.aaj.qdl.mml.qdl().qdl(qdlVar.mml().isEmpty() ? null : qdlVar.mml().get(0));
                        com.bytedance.sdk.openadsdk.bjy.lnr.qdl(qdlVar.mo(), System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                    if (pAGInterstitialAdLoadListener != null && yt.mml().vu() == 0) {
                        mzz.this.qdl(adSlot, qdlVar, pAGInterstitialAdLoadListener, rdpVar.qdl(), this.qdl);
                    }
                    mzz.this.qdl(qdlVar, rdpVar, adSlot, false, pAGInterstitialAdLoadListener);
                    return;
                }
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener;
                if (pAGInterstitialAdLoadListener2 != null) {
                    pAGInterstitialAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.jpc.qdl(-3));
                    lnrVar.qdl(-3);
                    lnrVar.lnr(5);
                    com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.aaj
            public String qdl() {
                if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                    return null;
                }
                String strQdl = mml.qdl(mzz.this.ud).qdl(adSlot.getCodeId(), true);
                if (TextUtils.isEmpty(strQdl)) {
                    return null;
                }
                return strQdl;
            }

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.aaj
            public boolean qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
                boolean zQdl = mml.qdl(mzz.this.ud).qdl(qdlVar);
                this.qdl = zQdl;
                return zQdl;
            }
        });
    }

    private void lnr(AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        com.bytedance.sdk.openadsdk.core.model.qdl qdlVarUd;
        if (TextUtils.isEmpty(adSlot.getBidAdm()) && (qdlVarUd = mml.qdl(this.ud).ud(adSlot.getCodeId(), true)) != null && qdlVarUd.mzz()) {
            qdl(adSlot, qdlVarUd, pAGInterstitialAdLoadListener);
        } else {
            mml(adSlot, pAGInterstitialAdLoadListener);
        }
    }

    private void qdl(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        ljh ljhVarMo = qdlVar.mo();
        for (ljh ljhVar : qdlVar.mml()) {
            if (ljhVar.ji() == null) {
                ljhVar.qdl(adSlot);
            }
        }
        rdp rdpVar = new rdp(this.ud, qdlVar);
        if (!vu.lnr(ljhVarMo)) {
            rdpVar.ud();
        }
        if (pAGInterstitialAdLoadListener != null) {
            com.bytedance.sdk.openadsdk.core.fs.lnr.mml.qdl(qdlVar);
            if (yt.mml().vu() == 0) {
                qdl(adSlot, qdlVar, pAGInterstitialAdLoadListener, (PAGInterstitialAd) rdpVar.qdl(), true);
            }
            ud udVar = new ud(new qdl(this.ud, adSlot, qdlVar, pAGInterstitialAdLoadListener, true), qdlVar);
            for (int i = 0; i < qdlVar.mml().size(); i++) {
                qdl(qdlVar.mml().get(i), adSlot, udVar, rdpVar);
                if (qdlVar.to()) {
                    break;
                }
            }
        }
        for (int i2 = 0; i2 < qdlVar.mml().size(); i2++) {
            com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.qdl().qdl(qdlVar.mml().get(i2), new qdl.InterfaceC0228qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.mzz.5
                @Override // com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.InterfaceC0228qdl
                public void qdl(boolean z) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, PAGInterstitialAd pAGInterstitialAd, final boolean z) {
        com.bytedance.sdk.openadsdk.core.rdp.ud().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.mzz.6
            @Override // java.lang.Runnable
            public void run() {
                int iUd = mzz.ud();
                if (!z) {
                    if (iUd == 2) {
                        mml.qdl(mzz.this.ud).qdl(adSlot, qdlVar);
                        mzz.this.mml(adSlot);
                        return;
                    }
                    return;
                }
                if (iUd == 2) {
                    mzz.this.mml(adSlot);
                } else if (iUd == 1) {
                    mml.qdl(mzz.this.ud).qdl(adSlot.getCodeId(), (ljh) null);
                }
            }
        });
        if (pAGInterstitialAdLoadListener != null) {
            pAGInterstitialAdLoadListener.onAdLoaded(pAGInterstitialAd);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(com.bytedance.sdk.openadsdk.core.model.ljh r3, com.bytedance.sdk.openadsdk.AdSlot r4, final com.bytedance.sdk.openadsdk.component.reward.mzz.ud r5, final com.bytedance.sdk.openadsdk.component.reward.rdp r6) {
        /*
            r2 = this;
            if (r5 == 0) goto Le
            com.bytedance.sdk.openadsdk.core.settings.rq r0 = com.bytedance.sdk.openadsdk.core.yt.mml()
            int r0 = r0.vu()
            r1 = 1
            if (r0 != r1) goto Le
            goto Lf
        Le:
            r1 = 0
        Lf:
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.vu.lnr(r3)
            if (r0 != 0) goto L3e
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.ljh.mzz(r3)
            if (r0 == 0) goto L3e
            int r0 = r3.lhl()
            com.bykv.vk.openvk.qdl.qdl.qdl.qdl.ud r0 = com.bytedance.sdk.openadsdk.CacheDirFactory.getICacheDir(r0)
            java.lang.String r0 = r0.qdl()
            com.bytedance.sdk.openadsdk.core.exu.qdl.ud r0 = com.bytedance.sdk.openadsdk.core.model.ljh.qdl(r0, r3)
            java.lang.String r1 = "material_meta"
            r0.qdl(r1, r3)
            java.lang.String r3 = "ad_slot"
            r0.qdl(r3, r4)
            com.bytedance.sdk.openadsdk.component.reward.mzz$7 r3 = new com.bytedance.sdk.openadsdk.component.reward.mzz$7
            r3.<init>()
            com.bytedance.sdk.openadsdk.core.exu.mzz.qdl.qdl(r0, r3)
            goto L47
        L3e:
            if (r1 == 0) goto L47
            com.bytedance.sdk.openadsdk.component.reward.mo r3 = r6.qdl()
            r5.onAdLoaded(r3)
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.mzz.qdl(com.bytedance.sdk.openadsdk.core.model.ljh, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.component.reward.mzz$ud, com.bytedance.sdk.openadsdk.component.reward.rdp):void");
    }

    private void mml(final AdSlot adSlot, final PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.model.bqt bqtVar = new com.bytedance.sdk.openadsdk.core.model.bqt();
        bqtVar.lnr = 1;
        if (yt.mml().fs(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            bqtVar.tvp = 2;
        }
        yt.lnr().qdl(adSlot, bqtVar, 8, new oth.qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.mzz.8
            @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(int i, String str) {
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener;
                if (pAGInterstitialAdLoadListener2 != null) {
                    pAGInterstitialAdLoadListener2.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
                if (qdlVar.mml() != null && !qdlVar.mml().isEmpty()) {
                    rdp rdpVar = new rdp(mzz.this.ud, qdlVar);
                    if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                        com.bytedance.sdk.openadsdk.aaj.qdl.mml.qdl().qdl(qdlVar.mml().isEmpty() ? null : qdlVar.mml().get(0));
                        com.bytedance.sdk.openadsdk.bjy.lnr.qdl(qdlVar.mo(), System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                    if (pAGInterstitialAdLoadListener != null && yt.mml().vu() == 0) {
                        mzz.this.qdl(adSlot, qdlVar, pAGInterstitialAdLoadListener, (PAGInterstitialAd) rdpVar.qdl(), false);
                    }
                    mzz.this.qdl(qdlVar, rdpVar, adSlot, false, pAGInterstitialAdLoadListener);
                    return;
                }
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener;
                if (pAGInterstitialAdLoadListener2 != null) {
                    pAGInterstitialAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.jpc.qdl(-3));
                    lnrVar.qdl(-3);
                    lnrVar.lnr(5);
                    com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, rdp rdpVar, AdSlot adSlot, boolean z, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        if (!z) {
            com.bytedance.sdk.openadsdk.exu.qdl.qdl().qdl(qdlVar.mo());
        }
        ud udVar = new ud(new qdl(this.ud, adSlot, qdlVar, pAGInterstitialAdLoadListener, false), qdlVar);
        qdl(qdlVar);
        for (int i = 0; i < qdlVar.mml().size(); i++) {
            ljh ljhVar = qdlVar.mml().get(i);
            int iTaz = ljhVar.taz();
            if (i == 0 && iTaz == 43) {
                ljhVar.tdy().mo(0);
            }
            qdl(qdlVar, ljhVar, rdpVar, adSlot, z, udVar);
            if (qdlVar.to() && ljhVar.taz() != 43) {
                return;
            }
        }
    }

    private void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
        uw uwVarFs = qdlVar.fs();
        int iJtx = qdlVar.to() ? 10 : 1;
        if (uwVarFs != null) {
            iJtx = uwVarFs.jtx();
        }
        for (final int i = 0; i < qdlVar.mml().size() && i < iJtx; i++) {
            com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.qdl().qdl(qdlVar.mml().get(i), new qdl.InterfaceC0228qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.mzz.9
                @Override // com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.InterfaceC0228qdl
                public void qdl(boolean z) {
                    com.bytedance.sdk.component.utils.aaj.qdl("ScreenVideoLoadM", "onCachedResponse: i=" + i + ", isSuccess=" + z);
                }
            });
        }
    }

    private void qdl(final com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, ljh ljhVar, final rdp rdpVar, final AdSlot adSlot, final boolean z, final ud udVar) {
        if (z && !vu.lnr(ljhVar) && ljh.mzz(ljhVar) && yt.mml().xmv(adSlot.getCodeId()).mml == 1 && !jl.mml(this.ud)) {
            qdl(new lnr(ljhVar, adSlot, qdlVar));
            return;
        }
        boolean z2 = udVar != null && yt.mml().vu() == 1;
        if (vu.lnr(ljhVar)) {
            if (z) {
                mml.qdl(this.ud).qdl(adSlot, qdlVar);
            }
        } else if (ljh.mzz(ljhVar)) {
            if (ljhVar.tdy() != null) {
                com.bytedance.sdk.openadsdk.core.exu.qdl.ud udVarQdl = ljh.qdl(CacheDirFactory.getICacheDir(ljhVar.lhl()).qdl(), ljhVar);
                udVarQdl.qdl("material_meta", ljhVar);
                udVarQdl.qdl("ad_slot", adSlot);
                com.bytedance.sdk.openadsdk.core.exu.mzz.qdl.qdl(udVarQdl, new com.bykv.vk.openvk.qdl.qdl.qdl.mzz.ud() { // from class: com.bytedance.sdk.openadsdk.component.reward.mzz.10
                    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
                    public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i) {
                        rdpVar.ud();
                        if (z) {
                            mml.qdl(mzz.this.ud).qdl(adSlot, qdlVar);
                        } else {
                            if (udVar == null || yt.mml().vu() != 1) {
                                return;
                            }
                            udVar.onAdLoaded(rdpVar.qdl());
                        }
                    }

                    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
                    public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i, String str) {
                        if (udVar == null || yt.mml().vu() != 1) {
                            return;
                        }
                        udVar.onError(i, str);
                    }
                });
                return;
            }
        } else if (z) {
            mml.qdl(this.ud).qdl(adSlot, qdlVar);
        }
        if (z2) {
            udVar.onAdLoaded(rdpVar.qdl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mml(AdSlot adSlot) {
        if (ud() != 2) {
            return;
        }
        mml.qdl(this.ud).qdl(adSlot.getCodeId());
    }

    private void qdl(lnr lnrVar) {
        if (lnrVar == null) {
            return;
        }
        if (this.mml.size() > 0) {
            this.mml.remove(0);
        }
        this.mml.add(lnrVar);
    }

    private void lnr() {
        if (this.lnr.get()) {
            return;
        }
        this.lnr.set(true);
        bqt.qdl(this.mo, this.ud);
    }

    private void mml() {
        if (this.lnr.get()) {
            this.lnr.set(false);
            try {
                bqt.qdl(this.mo);
            } catch (Exception unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mzz != null) {
            try {
                com.bytedance.sdk.component.utils.tvp.qdl().removeCallbacks(this.mzz);
            } catch (Exception unused) {
            }
            this.mzz = null;
        }
        mml();
    }

    private static class lnr extends com.bytedance.sdk.component.jpc.jpc {
        final com.bytedance.sdk.openadsdk.core.model.qdl lnr;
        final ljh qdl;
        final AdSlot ud;

        lnr(ljh ljhVar, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
            super("Fullscreen Task");
            this.qdl = ljhVar;
            this.ud = adSlot;
            this.lnr = qdlVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ljh ljhVar = this.qdl;
            if (ljhVar == null || ljhVar.tdy() == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.exu.qdl.ud udVarQdl = ljh.qdl(CacheDirFactory.getICacheDir(this.qdl.lhl()).qdl(), this.qdl);
            udVarQdl.qdl("material_meta", this.qdl);
            udVarQdl.qdl("ad_slot", this.ud);
            com.bytedance.sdk.openadsdk.core.exu.mzz.qdl.qdl(udVarQdl, new com.bykv.vk.openvk.qdl.qdl.qdl.mzz.ud() { // from class: com.bytedance.sdk.openadsdk.component.reward.mzz.lnr.1
                @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
                public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i, String str) {
                }

                @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
                public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i) {
                    mml.qdl(yt.qdl()).qdl(lnr.this.ud, lnr.this.lnr);
                }
            });
        }
    }

    private static class qdl implements PAGInterstitialAdLoadListener {
        private final com.bytedance.sdk.openadsdk.core.model.qdl lnr;
        private final PAGInterstitialAdLoadListener mml;
        private final boolean mzz;
        private final Context qdl;
        private final AdSlot ud;

        public qdl(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, boolean z) {
            this.qdl = context;
            this.ud = adSlot;
            this.lnr = qdlVar;
            this.mml = pAGInterstitialAdLoadListener;
            this.mzz = z;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.mo
        public void onError(int i, String str) {
            PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener = this.mml;
            if (pAGInterstitialAdLoadListener != null) {
                pAGInterstitialAdLoadListener.onError(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            mzz.qdl(this.qdl).qdl(this.ud, this.lnr, this.mml, pAGInterstitialAd, this.mzz);
        }
    }

    private static class ud implements PAGInterstitialAdLoadListener {
        private final AtomicInteger lnr;
        private final com.bytedance.sdk.openadsdk.core.model.qdl mml;
        private final PAGInterstitialAdLoadListener qdl;
        private final AtomicBoolean ud;

        private ud(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
            this.ud = new AtomicBoolean(false);
            this.qdl = pAGInterstitialAdLoadListener;
            this.mml = qdlVar;
            this.lnr = new AtomicInteger(qdl());
        }

        private int qdl() {
            if (!this.mml.mzz()) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < this.mml.mml().size(); i2++) {
                ljh ljhVar = this.mml.mml().get(i2);
                if (ljhVar != null && !vu.lnr(ljhVar) && ljhVar.tdy() != null) {
                    i++;
                }
            }
            return i;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.mo
        public void onError(int i, String str) {
            if (this.lnr.decrementAndGet() > 0 || !this.ud.compareAndSet(false, true)) {
                return;
            }
            this.qdl.onError(i, str);
            com.bytedance.sdk.openadsdk.bjy.lnr.qdl("choose_ad_load_error", false, new com.bytedance.sdk.openadsdk.bjy.ud() { // from class: com.bytedance.sdk.openadsdk.component.reward.mzz.ud.1
                @Override // com.bytedance.sdk.openadsdk.bjy.ud
                public com.bytedance.sdk.openadsdk.bjy.qdl.lnr getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", ud.this.mml.ud());
                    return com.bytedance.sdk.openadsdk.bjy.qdl.mml.ud().qdl("choose_ad_load_error").ud(jSONObject.toString());
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            this.lnr.decrementAndGet();
            if (this.qdl == null || !this.ud.compareAndSet(false, true)) {
                return;
            }
            this.qdl.onAdLoaded(pAGInterstitialAd);
        }
    }

    public void qdl(String str, ljh ljhVar) {
        mml.qdl(this.ud).qdl(str, ljhVar);
    }

    public static int ud() {
        return com.bytedance.sdk.openadsdk.jyq.qdl.qdl("ivrv_load_ad_cache_strategy", 0);
    }
}
