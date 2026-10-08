package com.adxcorp.ads.unity;

import android.widget.PopupWindow;
import androidx.compose.animation.core.AnimationConstants;
import com.adxcorp.ads.BannerAd;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.common.OnPaidEventListener;
import com.adxcorp.ads.mediation.util.DisplayUtil;
import com.unity3d.player.UnityPlayer;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class UnityBannerAd {
    private static final int POSITION_BOTTOM = 1;
    private static final int POSITION_BOTTOM_LEFT = 4;
    private static final int POSITION_BOTTOM_RIGHT = 5;
    private static final int POSITION_CENTER = 6;
    private static final int POSITION_TOP = 0;
    private static final int POSITION_TOP_LEFT = 2;
    private static final int POSITION_TOP_RIGHT = 3;
    private BannerAd mBannerAd;
    private PopupWindow mPopupWindow;

    public UnityBannerAd(final String str, final int i, final int i2, final BannerAd.BannerListener bannerListener) {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityBannerAd.1
            @Override // java.lang.Runnable
            public void run() {
                AdConstants.BANNER_AD_SIZE banner_ad_size;
                int i3;
                int i4;
                int i5 = i;
                if (i5 != 1) {
                    i3 = 320;
                    if (i5 == 2) {
                        banner_ad_size = AdConstants.BANNER_AD_SIZE.AD_SIZE_320x100;
                        i4 = 100;
                    } else if (i5 == 3) {
                        banner_ad_size = AdConstants.BANNER_AD_SIZE.AD_SIZE_300x250;
                        i3 = AnimationConstants.DefaultDurationMillis;
                        i4 = 250;
                    } else {
                        banner_ad_size = AdConstants.BANNER_AD_SIZE.AD_SIZE_320x50;
                        i4 = 50;
                    }
                } else {
                    banner_ad_size = AdConstants.BANNER_AD_SIZE.AD_SIZE_728x90;
                    i3 = 728;
                    i4 = 90;
                }
                UnityBannerAd.this.mBannerAd = new BannerAd(UnityPlayer.currentActivity, str, banner_ad_size);
                UnityBannerAd.this.mBannerAd.setBannerListener(bannerListener);
                UnityBannerAd.this.mPopupWindow = new PopupWindow(UnityBannerAd.this.mBannerAd, DisplayUtil.dpToPx(UnityPlayer.currentActivity, i3), DisplayUtil.dpToPx(UnityPlayer.currentActivity, i4));
                UnityBannerAd.this.mPopupWindow.getContentView().setSystemUiVisibility(UnityPlayer.currentActivity.getWindow().getAttributes().flags);
                UnityBannerAd unityBannerAd = UnityBannerAd.this;
                unityBannerAd.setPopUpWindowLayoutType(unityBannerAd.mPopupWindow, 1002);
                UnityBannerAd.this.showPopUpWindow(i2);
            }
        });
    }

    public void loadAd() {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityBannerAd.2
            @Override // java.lang.Runnable
            public void run() {
                if (UnityBannerAd.this.mBannerAd != null) {
                    UnityBannerAd.this.mBannerAd.loadAd();
                }
            }
        });
    }

    public void destroy() {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityBannerAd.3
            @Override // java.lang.Runnable
            public void run() {
                if (UnityBannerAd.this.mBannerAd != null) {
                    UnityBannerAd.this.mBannerAd.destroy();
                    UnityBannerAd.this.mBannerAd = null;
                }
                if (UnityBannerAd.this.mPopupWindow != null) {
                    UnityBannerAd.this.mPopupWindow.dismiss();
                    UnityBannerAd.this.mPopupWindow = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPopUpWindowLayoutType(PopupWindow popupWindow, int i) {
        try {
            Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(popupWindow, Integer.valueOf(i));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopUpWindow(int i) {
        switch (i) {
            case 1:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 80, 0, 0);
                break;
            case 2:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 51, 0, 0);
                break;
            case 3:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 53, 0, 0);
                break;
            case 4:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 83, 0, 0);
                break;
            case 5:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 85, 0, 0);
                break;
            case 6:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 17, 0, 0);
                break;
            default:
                this.mPopupWindow.showAtLocation(this.mBannerAd, 48, 0, 0);
                break;
        }
    }

    public void setOnPaidEventListener(final OnPaidEventListener onPaidEventListener) {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityBannerAd.4
            @Override // java.lang.Runnable
            public void run() {
                if (UnityBannerAd.this.mBannerAd != null) {
                    UnityBannerAd.this.mBannerAd.setOnPaidEventListener(onPaidEventListener);
                }
            }
        });
    }
}
