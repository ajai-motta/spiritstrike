package com.bytedance.sdk.openadsdk.core.fs;

import android.util.Pair;
import android.view.View;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class wd {
    protected String lnr;
    protected VastProperties mml;
    private final AdEvents mo;
    private final AdSession mzz;
    private boolean wd = false;
    protected boolean qdl = false;
    protected int ud = 0;

    void qdl(float f, boolean z) {
    }

    public void qdl(boolean z) {
    }

    public void qdl(boolean z, float f) {
    }

    void ud(int i) {
    }

    public wd(AdSession adSession, AdEvents adEvents, View view) {
        this.mzz = adSession;
        this.mo = adEvents;
        this.lnr = adSession.getAdSessionId();
        qdl(view);
    }

    void qdl(View view) {
        AdSession adSession;
        if (view == null || (adSession = this.mzz) == null) {
            return;
        }
        adSession.registerAdView(view);
    }

    public void qdl(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        AdSession adSession = this.mzz;
        if (adSession != null) {
            adSession.addFriendlyObstruction(view, friendlyObstructionPurpose, null);
        }
    }

    boolean qdl() {
        return this.qdl;
    }

    public void qdl(int i) {
        int i2;
        if (this.mzz == null || this.mo == null || !mzz.lnr()) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4 || (i2 = this.ud) == 0 || i2 == 4) {
                        return;
                    }
                    this.mzz.finish();
                    this.qdl = false;
                } else {
                    if (this.wd) {
                        return;
                    }
                    int i3 = this.ud;
                    if (i3 != 1 && i3 != 2) {
                        return;
                    }
                    this.mo.impressionOccurred();
                    this.wd = true;
                }
            } else {
                if (this.ud != 0) {
                    return;
                }
                this.mzz.start();
                if (this.mml == null) {
                    this.mml = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
                }
                this.mo.loaded(this.mml);
                this.qdl = true;
                this.mml = null;
            }
        } else {
            if (this.ud != 0) {
                return;
            }
            this.mzz.start();
            this.mo.loaded();
            this.qdl = true;
        }
        this.ud = i;
    }

    void ud() {
        qdl(1);
    }

    void lnr() {
        qdl(4);
    }

    public void mml() {
        qdl(3);
    }

    public void qdl(Set<Pair<View, FriendlyObstructionPurpose>> set) {
        for (Pair<View, FriendlyObstructionPurpose> pair : set) {
            qdl((View) pair.first, (FriendlyObstructionPurpose) pair.second);
        }
    }
}
