package com.bytedance.sdk.openadsdk.core.fs;

import android.view.View;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.media.InteractionType;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import com.iab.omid.library.bytedance2.adsession.media.PlayerState;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;

/* JADX INFO: loaded from: classes3.dex */
public class tvp extends wd {
    private boolean mo;
    private final MediaEvents mzz;

    public tvp(AdSession adSession, AdEvents adEvents, View view, MediaEvents mediaEvents) {
        super(adSession, adEvents, view);
        this.mzz = mediaEvents;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fs.wd
    public void qdl(boolean z, float f) {
        if (z) {
            this.mml = VastProperties.createVastPropertiesForSkippableMedia(f, true, Position.STANDALONE);
        } else {
            this.mml = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        }
        qdl(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.fs.wd
    public void qdl(float f, boolean z) {
        if (qdl()) {
            this.mzz.start(f, z ? 0.0f : 1.0f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.fs.wd
    public void qdl(boolean z) {
        this.mo = z;
        ud(12);
    }

    @Override // com.bytedance.sdk.openadsdk.core.fs.wd
    public void ud(int i) {
        if (qdl()) {
            switch (i) {
                case 0:
                    this.mzz.pause();
                    break;
                case 1:
                    this.mzz.resume();
                    break;
                case 2:
                case 14:
                    this.mzz.skipped();
                    break;
                case 4:
                    this.mzz.bufferStart();
                    break;
                case 5:
                    this.mzz.bufferFinish();
                    break;
                case 6:
                    this.mzz.firstQuartile();
                    break;
                case 7:
                    this.mzz.midpoint();
                    break;
                case 8:
                    this.mzz.thirdQuartile();
                    break;
                case 9:
                    this.mzz.complete();
                    break;
                case 10:
                    this.mzz.playerStateChange(PlayerState.FULLSCREEN);
                    break;
                case 11:
                    this.mzz.playerStateChange(PlayerState.NORMAL);
                    break;
                case 12:
                    this.mzz.volumeChange(this.mo ? 0.0f : 1.0f);
                    break;
                case 13:
                    this.mzz.adUserInteraction(InteractionType.CLICK);
                    break;
            }
        }
    }
}
