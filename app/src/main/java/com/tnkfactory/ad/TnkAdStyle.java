package com.tnkfactory.ad;

import com.tnkfactory.ad.pub.b0;

/* JADX INFO: loaded from: classes6.dex */
public class TnkAdStyle extends b0 {
    public static InterstitialStyle AdInterstitial = new InterstitialStyle();

    public static class InterstitialStyle extends b0 {
        public void setActionButtonLabel(String str) {
            b0.adStyle.set(b0.ENC_ACTION_BUTTON_LABEL, str);
        }

        public void setCloseButtonLabel(String str) {
            b0.adStyle.set(b0.ENC_CLOSE_BUTTON_LABEL, str);
        }

        public void setExitButtonLabel(String str) {
            b0.adStyle.set(b0.ENC_EXIT_BUTTON_LABEL, str);
        }

        public void setFrameTitle(String str) {
            b0.adStyle.set(b0.ENC_FRAME_TITLE, str);
        }

        public void useTestMode(String str) {
            b0.adStyle.set(b0.ENC_USE_WINDOW_MODE, str);
        }
    }
}
