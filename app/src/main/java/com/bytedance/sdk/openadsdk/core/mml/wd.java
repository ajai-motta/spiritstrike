package com.bytedance.sdk.openadsdk.core.mml;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.rc;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class wd extends PAGBannerAd {
    private int jpc;
    protected AdSlot lnr;
    private boolean mml;
    private mzz mo;
    private boolean mzz;
    protected Context qdl;
    private List<com.bytedance.sdk.openadsdk.core.mml.qdl> rq;
    private final AtomicBoolean to = new AtomicBoolean(false);
    private int tvp;
    protected ljh ud;
    private boolean wd;

    public interface qdl {
        void qdl();
    }

    public wd(Context context, ljh ljhVar, AdSlot adSlot) {
        this.jpc = 0;
        this.tvp = 0;
        this.qdl = context;
        this.ud = ljhVar;
        this.lnr = adSlot;
        this.jpc = (int) adSlot.getExpressViewAcceptedWidth();
        this.tvp = (int) this.lnr.getExpressViewAcceptedHeight();
        qdl(this.ud);
        ud(ljhVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(com.bytedance.sdk.openadsdk.core.model.ljh r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L1d
            com.bytedance.sdk.openadsdk.core.model.qdl r2 = r2.mml()
            if (r2 == 0) goto L1d
            boolean r0 = r2.to()
            if (r0 == 0) goto L1a
            java.util.List r2 = r2.mml()
            int r2 = r2.size()
            r0 = 1
            if (r2 <= r0) goto L1a
            goto L1b
        L1a:
            r0 = 0
        L1b:
            r1.wd = r0
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.mml.wd.qdl(com.bytedance.sdk.openadsdk.core.model.ljh):void");
    }

    public boolean qdl() {
        return this.wd;
    }

    private void ud(ljh ljhVar) {
        com.bytedance.sdk.openadsdk.core.model.qdl qdlVarMml;
        if (ljhVar == null || (qdlVarMml = ljhVar.mml()) == null) {
            return;
        }
        this.rq = new ArrayList();
        int size = qdlVarMml.mml().size();
        if (this.wd) {
            this.mo = new mzz(qdlVarMml.wd(), this.qdl, this.jpc, this.tvp);
            for (int i = 0; i < size; i++) {
                this.lnr.setExpressViewAccepted(((this.jpc - ax.lnr(this.qdl, qdlVarMml.wd().mzz())) - ax.lnr(this.qdl, qdlVarMml.wd().mo())) - (ax.lnr(this.qdl, qdlVarMml.wd().wd()) * 2), this.tvp);
                ljh ljhVar2 = qdlVarMml.mml().get(i);
                if (i != 0) {
                    qdl(i, ljhVar2);
                }
                com.bytedance.sdk.openadsdk.core.mml.qdl qdlVar = new com.bytedance.sdk.openadsdk.core.mml.qdl(this.qdl, ljhVar2, this.lnr, this, true);
                qdlVar.qdl(i);
                this.rq.add(qdlVar);
            }
            this.mo.qdl(this.rq);
            return;
        }
        this.rq.add(new com.bytedance.sdk.openadsdk.core.mml.qdl(this.qdl, ljhVar, this.lnr, this, false));
    }

    private void qdl(int i, ljh ljhVar) {
        if (i != 0) {
            if (!TextUtils.isEmpty(ljhVar.tqd())) {
                ljhVar.rdp(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            Map<String, Object> mapDsy = ljhVar.dsy();
            if (mapDsy == null || !mapDsy.containsKey("price")) {
                return;
            }
            mapDsy.put("price", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.mml) {
            return;
        }
        rc.qdl(this.ud, d);
        this.mml = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.mzz) {
            return;
        }
        rc.qdl(this.ud, d, str, str2);
        this.mzz = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        ljh ljhVar = this.ud;
        if (ljhVar != null) {
            return ljhVar.dsy();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        ljh ljhVar = this.ud;
        if (ljhVar == null || ljhVar.dsy() == null) {
            return null;
        }
        try {
            return this.ud.dsy().get(str);
        } catch (Throwable th) {
            aaj.lnr("PAGBannerAdImpl", th.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void setAdInteractionCallback(final PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback) {
        List<com.bytedance.sdk.openadsdk.core.mml.qdl> list = this.rq;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.rq.size(); i++) {
            this.rq.get(i).qdl(new PAGBannerAdInteractionCallback() { // from class: com.bytedance.sdk.openadsdk.core.mml.wd.1
                @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback, com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdShowed() {
                    PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback2;
                    if (!wd.this.to.compareAndSet(false, true) || (pAGBannerAdInteractionCallback2 = pAGBannerAdInteractionCallback) == null) {
                        return;
                    }
                    pAGBannerAdInteractionCallback2.onAdShowed();
                }

                @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback, com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdClicked() {
                    PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback2 = pAGBannerAdInteractionCallback;
                    if (pAGBannerAdInteractionCallback2 != null) {
                        pAGBannerAdInteractionCallback2.onAdClicked();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback, com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdDismissed() {
                    PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback2 = pAGBannerAdInteractionCallback;
                    if (pAGBannerAdInteractionCallback2 != null) {
                        pAGBannerAdInteractionCallback2.onAdDismissed();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback
                public void onAdShowFailed(PAGErrorModel pAGErrorModel) {
                    PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback2 = pAGBannerAdInteractionCallback;
                    if (pAGBannerAdInteractionCallback2 != null) {
                        pAGBannerAdInteractionCallback2.onAdShowFailed(pAGErrorModel);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void setAdInteractionListener(final PAGBannerAdInteractionListener pAGBannerAdInteractionListener) {
        List<com.bytedance.sdk.openadsdk.core.mml.qdl> list = this.rq;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.rq.size(); i++) {
            this.rq.get(i).qdl(new PAGBannerAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.mml.wd.2
                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdShowed() {
                    PAGBannerAdInteractionListener pAGBannerAdInteractionListener2;
                    if (!wd.this.to.compareAndSet(false, true) || (pAGBannerAdInteractionListener2 = pAGBannerAdInteractionListener) == null) {
                        return;
                    }
                    pAGBannerAdInteractionListener2.onAdShowed();
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdClicked() {
                    PAGBannerAdInteractionListener pAGBannerAdInteractionListener2 = pAGBannerAdInteractionListener;
                    if (pAGBannerAdInteractionListener2 != null) {
                        pAGBannerAdInteractionListener2.onAdClicked();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdDismissed() {
                    PAGBannerAdInteractionListener pAGBannerAdInteractionListener2 = pAGBannerAdInteractionListener;
                    if (pAGBannerAdInteractionListener2 != null) {
                        pAGBannerAdInteractionListener2.onAdDismissed();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public View getBannerView() {
        try {
            List<com.bytedance.sdk.openadsdk.core.mml.qdl> list = this.rq;
            if (list != null && !list.isEmpty()) {
                if (this.wd) {
                    return this.mo.ud();
                }
                return this.rq.get(0).qdl();
            }
        } catch (Throwable unused) {
        }
        return new View(this.qdl);
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public PAGBannerSize getBannerSize() {
        if (this.lnr != null) {
            return new PAGBannerSize(this.jpc, this.tvp);
        }
        return new PAGBannerSize(0, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void destroy() {
        try {
            List<com.bytedance.sdk.openadsdk.core.mml.qdl> list = this.rq;
            if (list == null || list.isEmpty()) {
                return;
            }
            if (this.wd) {
                this.mo.qdl();
            } else {
                this.rq.get(0).wd();
            }
        } catch (Throwable unused) {
        }
    }
}
