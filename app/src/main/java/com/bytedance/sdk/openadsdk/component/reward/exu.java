package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.bqt;
import com.bytedance.sdk.component.utils.jl;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
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
public class exu {
    private static volatile exu qdl;
    private final AtomicBoolean lnr = new AtomicBoolean(false);
    private final List<ud> mml = Collections.synchronizedList(new ArrayList());
    private final bqt.qdl mo = new bqt.qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.exu.2
        @Override // com.bytedance.sdk.component.utils.bqt.qdl
        public void qdl(Context context, Intent intent, boolean z, int i) {
            if (z) {
                if (exu.this.mzz == null) {
                    exu exuVar = exu.this;
                    exuVar.mzz = new com.bytedance.sdk.openadsdk.component.reward.ud("net connect task", exuVar.mml);
                }
                com.bytedance.sdk.component.utils.tvp.qdl().post(exu.this.mzz);
            }
        }
    };
    private com.bytedance.sdk.component.jpc.jpc mzz;
    private final Context ud;

    public static exu qdl(Context context) {
        if (qdl == null) {
            synchronized (exu.class) {
                if (qdl == null) {
                    qdl = new exu(context);
                }
            }
        }
        return qdl;
    }

    private exu(Context context) {
        this.ud = context == null ? yt.qdl() : context.getApplicationContext();
        ud();
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
        bqtVar.ud = 2;
        if (yt.mml().fs(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            bqtVar.tvp = 2;
        }
        yt.lnr().qdl(adSlot, bqtVar, 7, (aaj) new jyq() { // from class: com.bytedance.sdk.openadsdk.component.reward.exu.1
            boolean qdl = false;

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.aaj
            public String qdl() {
                return fs.qdl(exu.this.ud).qdl(adSlot.getCodeId(), false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.aaj
            public boolean qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
                boolean zQdl = fs.qdl(exu.this.ud).qdl(qdlVar);
                this.qdl = zQdl;
                return zQdl;
            }

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
                if (this.qdl || qdlVar.mml() == null || qdlVar.mml().isEmpty()) {
                    return;
                }
                exu.this.qdl(qdlVar, new bjy(exu.this.ud, qdlVar, adSlot), adSlot, true, (PAGRewardedAdLoadListener) null);
            }
        });
    }

    private void lnr(final AdSlot adSlot) {
        if (fs.qdl(this.ud).ud(adSlot.getCodeId(), false) != null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.bqt bqtVar = new com.bytedance.sdk.openadsdk.core.model.bqt();
        bqtVar.ud = 2;
        if (yt.mml().fs(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            bqtVar.tvp = 2;
        }
        yt.lnr().qdl(adSlot, bqtVar, 7, new oth.qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.exu.3
            @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
                if (qdlVar.mml() == null || qdlVar.mml().isEmpty()) {
                    return;
                }
                exu.this.qdl(qdlVar, new bjy(exu.this.ud, qdlVar, adSlot), adSlot, true, (PAGRewardedAdLoadListener) null);
            }
        });
    }

    public void qdl(String str, ljh ljhVar) {
        fs.qdl(this.ud).qdl(str, ljhVar);
    }

    public void qdl() {
        try {
            fs.qdl(this.ud).qdl();
        } catch (Throwable unused) {
        }
    }

    public void qdl(AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        if (com.bytedance.sdk.openadsdk.utils.ud.qdl()) {
            ud(adSlot, pAGRewardedAdLoadListener);
        } else {
            lnr(adSlot, pAGRewardedAdLoadListener);
        }
    }

    private void ud(final AdSlot adSlot, final PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        if (com.bytedance.sdk.component.utils.bjy.mml()) {
            com.bykv.vk.openvk.qdl.qdl.qdl.wd.ud.qdl(adSlot.getBidAdm());
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.model.bqt bqtVar = new com.bytedance.sdk.openadsdk.core.model.bqt();
        bqtVar.ud = 1;
        if (yt.mml().fs(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            bqtVar.tvp = 2;
        }
        yt.lnr().qdl(adSlot, bqtVar, 7, (aaj) new jyq() { // from class: com.bytedance.sdk.openadsdk.component.reward.exu.4
            boolean qdl = false;

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(int i, String str) {
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
                if (pAGRewardedAdLoadListener2 != null) {
                    pAGRewardedAdLoadListener2.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
                if (qdlVar.mml() != null && !qdlVar.mml().isEmpty()) {
                    bjy bjyVar = new bjy(exu.this.ud, qdlVar, adSlot);
                    if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                        com.bytedance.sdk.openadsdk.aaj.qdl.mml.qdl().qdl(qdlVar.mml().isEmpty() ? null : qdlVar.mml().get(0));
                        com.bytedance.sdk.openadsdk.bjy.lnr.qdl(qdlVar.mo(), System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                    if (pAGRewardedAdLoadListener != null && yt.mml().vu() == 0) {
                        exu.this.qdl(adSlot, qdlVar, pAGRewardedAdLoadListener, bjyVar.qdl(), this.qdl);
                    }
                    exu.this.qdl(qdlVar, bjyVar, adSlot, false, pAGRewardedAdLoadListener);
                    return;
                }
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
                if (pAGRewardedAdLoadListener2 != null) {
                    pAGRewardedAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.jpc.qdl(-3));
                    lnrVar.qdl(-3);
                    lnrVar.lnr(6);
                    com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.aaj
            public String qdl() {
                if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                    return null;
                }
                String strQdl = fs.qdl(exu.this.ud).qdl(adSlot.getCodeId(), true);
                if (TextUtils.isEmpty(strQdl)) {
                    return null;
                }
                return strQdl;
            }

            @Override // com.bytedance.sdk.openadsdk.core.jyq, com.bytedance.sdk.openadsdk.core.aaj
            public boolean qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
                boolean zQdl = fs.qdl(exu.this.ud).qdl(qdlVar);
                this.qdl = zQdl;
                return zQdl;
            }
        });
    }

    private void lnr(AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        com.bytedance.sdk.openadsdk.core.model.qdl qdlVarUd;
        if (TextUtils.isEmpty(adSlot.getBidAdm()) && (qdlVarUd = fs.qdl(this.ud).ud(adSlot.getCodeId(), true)) != null && qdlVarUd.mzz()) {
            qdl(qdlVarUd, adSlot, pAGRewardedAdLoadListener);
        } else {
            mml(adSlot, pAGRewardedAdLoadListener);
        }
    }

    private void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        ljh ljhVarMo = qdlVar.mo();
        for (ljh ljhVar : qdlVar.mml()) {
            if (ljhVar.ji() == null) {
                ljhVar.qdl(adSlot);
            }
        }
        bjy bjyVar = new bjy(this.ud, qdlVar, adSlot);
        if (!vu.lnr(ljhVarMo)) {
            bjyVar.ud();
        }
        if (pAGRewardedAdLoadListener != null) {
            com.bytedance.sdk.openadsdk.core.fs.lnr.mml.qdl(qdlVar);
            if (yt.mml().vu() == 0) {
                qdl(adSlot, qdlVar, pAGRewardedAdLoadListener, (PAGRewardedAd) bjyVar.qdl(), true);
            }
            lnr lnrVar = new lnr(new qdl(this.ud, adSlot, qdlVar, pAGRewardedAdLoadListener, true), qdlVar);
            for (int i = 0; i < qdlVar.mml().size(); i++) {
                qdl(qdlVar.mml().get(i), adSlot, lnrVar, bjyVar);
                if (qdlVar.to()) {
                    break;
                }
            }
        }
        for (final int i2 = 0; i2 < qdlVar.mml().size(); i2++) {
            com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.qdl().qdl(qdlVar.mml().get(i2), new qdl.InterfaceC0228qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.exu.5
                @Override // com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.InterfaceC0228qdl
                public void qdl(boolean z) {
                    com.bytedance.sdk.component.utils.aaj.qdl("RewardVideoLoadManager", "onCachedResponse: i=" + i2 + ", isSuccess=" + z);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(com.bytedance.sdk.openadsdk.core.model.ljh r3, com.bytedance.sdk.openadsdk.AdSlot r4, final com.bytedance.sdk.openadsdk.component.reward.exu.lnr r5, final com.bytedance.sdk.openadsdk.component.reward.bjy r6) {
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
            if (r0 != 0) goto L38
            int r0 = r3.lhl()
            com.bykv.vk.openvk.qdl.qdl.qdl.qdl.ud r0 = com.bytedance.sdk.openadsdk.CacheDirFactory.getICacheDir(r0)
            java.lang.String r0 = r0.qdl()
            com.bytedance.sdk.openadsdk.core.exu.qdl.ud r0 = com.bytedance.sdk.openadsdk.core.model.ljh.qdl(r0, r3)
            java.lang.String r1 = "material_meta"
            r0.qdl(r1, r3)
            java.lang.String r3 = "ad_slot"
            r0.qdl(r3, r4)
            com.bytedance.sdk.openadsdk.component.reward.exu$6 r3 = new com.bytedance.sdk.openadsdk.component.reward.exu$6
            r3.<init>()
            com.bytedance.sdk.openadsdk.core.exu.mzz.qdl.qdl(r0, r3)
            goto L41
        L38:
            if (r1 == 0) goto L41
            com.bytedance.sdk.openadsdk.component.reward.jpc r3 = r6.qdl()
            r5.onAdLoaded(r3)
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.exu.qdl(com.bytedance.sdk.openadsdk.core.model.ljh, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.component.reward.exu$lnr, com.bytedance.sdk.openadsdk.component.reward.bjy):void");
    }

    private void mml(final AdSlot adSlot, final PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        if (com.bytedance.sdk.component.utils.bjy.mml()) {
            com.bykv.vk.openvk.qdl.qdl.qdl.wd.ud.qdl(adSlot.getBidAdm());
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.model.bqt bqtVar = new com.bytedance.sdk.openadsdk.core.model.bqt();
        bqtVar.ud = 1;
        if (yt.mml().fs(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            bqtVar.tvp = 2;
        }
        yt.lnr().qdl(adSlot, bqtVar, 7, new oth.qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.exu.7
            @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(int i, String str) {
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
                if (pAGRewardedAdLoadListener2 != null) {
                    pAGRewardedAdLoadListener2.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
            public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
                if (qdlVar.mml() != null && !qdlVar.mml().isEmpty()) {
                    bjy bjyVar = new bjy(exu.this.ud, qdlVar, adSlot);
                    if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                        com.bytedance.sdk.openadsdk.aaj.qdl.mml.qdl().qdl(qdlVar.mml().isEmpty() ? null : qdlVar.mml().get(0));
                        com.bytedance.sdk.openadsdk.bjy.lnr.qdl(qdlVar.mo(), System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                    if (pAGRewardedAdLoadListener != null && yt.mml().vu() == 0) {
                        exu.this.qdl(adSlot, qdlVar, pAGRewardedAdLoadListener, (PAGRewardedAd) bjyVar.qdl(), false);
                    }
                    exu.this.qdl(qdlVar, bjyVar, adSlot, false, pAGRewardedAdLoadListener);
                    return;
                }
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
                if (pAGRewardedAdLoadListener2 != null) {
                    pAGRewardedAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.jpc.qdl(-3));
                    lnrVar.qdl(-3);
                    lnrVar.lnr(6);
                    com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, bjy bjyVar, AdSlot adSlot, boolean z, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        if (!z) {
            com.bytedance.sdk.openadsdk.exu.qdl.qdl().qdl(qdlVar.mo());
        }
        lnr lnrVar = new lnr(new qdl(this.ud, adSlot, qdlVar, pAGRewardedAdLoadListener, false), qdlVar);
        qdl(qdlVar);
        for (int i = 0; i < qdlVar.mml().size(); i++) {
            ljh ljhVar = qdlVar.mml().get(i);
            int iTaz = ljhVar.taz();
            if (i == 0 && iTaz == 43) {
                ljhVar.tdy().mo(0);
            }
            qdl(qdlVar, ljhVar, bjyVar, adSlot, z, lnrVar);
            if (qdlVar.to() && iTaz != 43) {
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
        for (final int i = 0; i < qdlVar.mml().size(); i++) {
            ljh ljhVar = qdlVar.mml().get(i);
            if (i >= iJtx) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.qdl().qdl(ljhVar, new qdl.InterfaceC0228qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.exu.8
                @Override // com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.InterfaceC0228qdl
                public void qdl(boolean z) {
                    com.bytedance.sdk.component.utils.aaj.qdl("RewardVideoLoadManager", "onCachedResponse: i=" + i + ", isSuccess=" + z);
                }
            });
        }
    }

    private void qdl(final com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, ljh ljhVar, final bjy bjyVar, final AdSlot adSlot, final boolean z, final lnr lnrVar) {
        if (z && !vu.lnr(ljhVar) && yt.mml().xmv(adSlot.getCodeId()).mml == 1 && !jl.mml(this.ud)) {
            qdl(new ud(ljhVar, adSlot, qdlVar));
            return;
        }
        boolean z2 = lnrVar != null && yt.mml().vu() == 1;
        if (vu.lnr(ljhVar)) {
            if (z) {
                fs.qdl(this.ud).qdl(adSlot, qdlVar);
            }
        } else if (ljhVar.tdy() != null) {
            com.bytedance.sdk.openadsdk.core.exu.qdl.ud udVarQdl = ljh.qdl(CacheDirFactory.getICacheDir(ljhVar.lhl()).qdl(), ljhVar);
            udVarQdl.qdl("material_meta", ljhVar);
            udVarQdl.qdl("ad_slot", adSlot);
            com.bytedance.sdk.openadsdk.core.exu.mzz.qdl.qdl(udVarQdl, new com.bykv.vk.openvk.qdl.qdl.qdl.mzz.ud() { // from class: com.bytedance.sdk.openadsdk.component.reward.exu.9
                @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
                public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar2, int i) {
                    bjyVar.ud();
                    if (z) {
                        fs.qdl(exu.this.ud).qdl(adSlot, qdlVar);
                    } else {
                        if (lnrVar == null || yt.mml().vu() != 1) {
                            return;
                        }
                        lnrVar.onAdLoaded(bjyVar.qdl());
                    }
                }

                @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
                public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar2, int i, String str) {
                    if (lnrVar == null || yt.mml().vu() != 1) {
                        return;
                    }
                    lnrVar.onError(i, str);
                }
            });
            return;
        }
        if (z2) {
            lnrVar.onAdLoaded(bjyVar.qdl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, PAGRewardedAdLoadListener pAGRewardedAdLoadListener, PAGRewardedAd pAGRewardedAd, final boolean z) {
        com.bytedance.sdk.openadsdk.core.rdp.ud().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.exu.10
            @Override // java.lang.Runnable
            public void run() {
                int iUd = mzz.ud();
                if (!z) {
                    if (iUd == 2) {
                        fs.qdl(exu.this.ud).qdl(adSlot, qdlVar);
                        exu.this.mml(adSlot);
                        return;
                    }
                    return;
                }
                if (iUd == 2) {
                    exu.this.mml(adSlot);
                } else if (iUd == 1) {
                    fs.qdl(exu.this.ud).qdl(adSlot.getCodeId(), (ljh) null);
                }
            }
        });
        if (pAGRewardedAdLoadListener != null) {
            pAGRewardedAdLoadListener.onAdLoaded(pAGRewardedAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mml(AdSlot adSlot) {
        if (mzz.ud() != 2) {
            return;
        }
        fs.qdl(this.ud).qdl(adSlot.getCodeId());
    }

    private void qdl(ud udVar) {
        if (udVar == null) {
            return;
        }
        if (this.mml.size() > 0) {
            this.mml.remove(0);
        }
        this.mml.add(udVar);
    }

    private void ud() {
        if (this.lnr.get()) {
            return;
        }
        this.lnr.set(true);
        bqt.qdl(this.mo, this.ud);
    }

    private void lnr() {
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
        lnr();
    }

    public static class ud extends com.bytedance.sdk.component.jpc.jpc {
        final com.bytedance.sdk.openadsdk.core.model.qdl lnr;
        final ljh qdl;
        final AdSlot ud;

        ud(ljh ljhVar, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
            super("Reward Task");
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
            com.bytedance.sdk.openadsdk.core.exu.mzz.qdl.qdl(udVarQdl, new com.bykv.vk.openvk.qdl.qdl.qdl.mzz.ud() { // from class: com.bytedance.sdk.openadsdk.component.reward.exu.ud.1
                @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
                public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i, String str) {
                }

                @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
                public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i) {
                    fs.qdl(yt.qdl()).qdl(ud.this.ud, ud.this.lnr);
                }
            });
        }
    }

    private static class qdl implements PAGRewardedAdLoadListener {
        private final com.bytedance.sdk.openadsdk.core.model.qdl lnr;
        private final PAGRewardedAdLoadListener mml;
        private final boolean mzz;
        private final Context qdl;
        private final AdSlot ud;

        public qdl(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, PAGRewardedAdLoadListener pAGRewardedAdLoadListener, boolean z) {
            this.qdl = context;
            this.ud = adSlot;
            this.lnr = qdlVar;
            this.mml = pAGRewardedAdLoadListener;
            this.mzz = z;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.mo
        public void onError(int i, String str) {
            PAGRewardedAdLoadListener pAGRewardedAdLoadListener = this.mml;
            if (pAGRewardedAdLoadListener != null) {
                pAGRewardedAdLoadListener.onError(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
            exu.qdl(this.qdl).qdl(this.ud, this.lnr, this.mml, pAGRewardedAd, this.mzz);
        }
    }

    private static class lnr implements PAGRewardedAdLoadListener {
        private final AtomicInteger lnr;
        private final com.bytedance.sdk.openadsdk.core.model.qdl mml;
        private final PAGRewardedAdLoadListener qdl;
        private final AtomicBoolean ud;

        private lnr(PAGRewardedAdLoadListener pAGRewardedAdLoadListener, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
            this.ud = new AtomicBoolean(false);
            this.qdl = pAGRewardedAdLoadListener;
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
            if (this.lnr.decrementAndGet() > 0 || this.qdl == null || !this.ud.compareAndSet(false, true)) {
                return;
            }
            this.qdl.onError(i, str);
            com.bytedance.sdk.openadsdk.bjy.lnr.qdl("choose_ad_load_error", false, new com.bytedance.sdk.openadsdk.bjy.ud() { // from class: com.bytedance.sdk.openadsdk.component.reward.exu.lnr.1
                @Override // com.bytedance.sdk.openadsdk.bjy.ud
                public com.bytedance.sdk.openadsdk.bjy.qdl.lnr getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", lnr.this.mml.ud());
                    return com.bytedance.sdk.openadsdk.bjy.qdl.mml.ud().qdl("choose_ad_load_error").ud(jSONObject.toString());
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
            this.lnr.decrementAndGet();
            if (this.qdl == null || !this.ud.compareAndSet(false, true)) {
                return;
            }
            this.qdl.onAdLoaded(pAGRewardedAd);
        }
    }
}
