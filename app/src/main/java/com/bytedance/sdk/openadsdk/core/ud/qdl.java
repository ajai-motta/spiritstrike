package com.bytedance.sdk.openadsdk.core.ud;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.oth;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.yt.lnr;
import com.bytedance.sdk.openadsdk.yt.mml;

/* JADX INFO: loaded from: classes3.dex */
public class qdl implements oth.qdl {
    private final boolean lnr;
    private final oth.qdl qdl;
    private final AdSlot ud;

    public qdl(oth.qdl qdlVar, AdSlot adSlot, boolean z) {
        this.qdl = qdlVar;
        this.ud = adSlot;
        this.lnr = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
    public void qdl(final int i, final String str) {
        AdSlot adSlot;
        if (this.qdl != null) {
            if (fco.mo() || ((adSlot = this.ud) != null && adSlot.getDurationSlotType() != 5 && com.bytedance.sdk.openadsdk.jyq.qdl.qdl("getads_callback_async", 0) == 1)) {
                this.qdl.qdl(i, str);
            } else {
                fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ud.qdl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        qdl.this.qdl.qdl(i, str);
                    }
                });
            }
            if (!this.lnr || this.ud == null) {
                return;
            }
            lnr.lnr(new mml() { // from class: com.bytedance.sdk.openadsdk.core.ud.qdl.2
                @Override // com.bytedance.sdk.openadsdk.yt.mml
                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                    qdlVar.ud("load_ad");
                    qdlVar.lnr(qdl.this.ud.getCodeId());
                    qdlVar.mml(gy.lnr(qdl.this.ud.getDurationSlotType()));
                    qdlVar.qdl(BuildConfig.VERSION_NAME);
                    qdlVar.wd(gy.qdl(qdl.this.ud).toString());
                    return qdlVar;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.oth.qdl
    public void qdl(final com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, final com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
        AdSlot adSlot;
        if (this.qdl != null) {
            if (fco.mo() || ((adSlot = this.ud) != null && adSlot.getDurationSlotType() != 5 && com.bytedance.sdk.openadsdk.jyq.qdl.qdl("getads_callback_async", 0) == 1)) {
                this.qdl.qdl(qdlVar, lnrVar);
            } else {
                fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ud.qdl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        qdl.this.qdl.qdl(qdlVar, lnrVar);
                    }
                });
            }
            if (!this.lnr || this.ud == null) {
                return;
            }
            lnr.ud(new mml() { // from class: com.bytedance.sdk.openadsdk.core.ud.qdl.4
                @Override // com.bytedance.sdk.openadsdk.yt.mml
                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar2 = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                    qdlVar2.ud("load_ad");
                    qdlVar2.lnr(qdl.this.ud.getCodeId());
                    qdlVar2.mml(gy.lnr(qdl.this.ud.getDurationSlotType()));
                    qdlVar2.qdl(BuildConfig.VERSION_NAME);
                    qdlVar2.wd(gy.qdl(qdl.this.ud).toString());
                    return qdlVar2;
                }
            });
        }
    }
}
