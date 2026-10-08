package com.bytedance.sdk.openadsdk.api.banner;

import android.content.Context;
import androidx.compose.animation.core.AnimationConstants;
import com.bytedance.sdk.openadsdk.utils.lnr;

/* JADX INFO: loaded from: classes3.dex */
public final class PAGBannerSize {
    private int lnr = 1;
    private int mml;
    private int qdl;
    private int ud;
    public static final PAGBannerSize BANNER_W_320_H_50 = new PAGBannerSize(320, 50);
    public static final PAGBannerSize BANNER_W_300_H_250 = new PAGBannerSize(AnimationConstants.DefaultDurationMillis, 250);
    public static final PAGBannerSize BANNER_W_728_H_90 = new PAGBannerSize(728, 90);

    public PAGBannerSize(int i, int i2) {
        this.qdl = i;
        this.ud = i2;
    }

    public int getWidth() {
        return this.qdl;
    }

    public int getHeight() {
        return this.ud;
    }

    public int getType() {
        return this.lnr;
    }

    public int getMaxHeight() {
        return this.mml;
    }

    public static PAGBannerSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(Context context, int i) {
        int iQdl = lnr.qdl(context, i, 0);
        if (iQdl == lnr.qdl) {
            return new PAGBannerSize(-1, -1);
        }
        PAGBannerSize pAGBannerSize = new PAGBannerSize(i, iQdl);
        pAGBannerSize.lnr = 2;
        return pAGBannerSize;
    }

    public static PAGBannerSize getCurrentOrientationInlineAdaptiveBannerAdSize(Context context, int i) {
        int iQdl = lnr.qdl(context, 0);
        if (iQdl == lnr.qdl) {
            return new PAGBannerSize(-1, -1);
        }
        PAGBannerSize pAGBannerSize = new PAGBannerSize(i, 0);
        pAGBannerSize.mml = iQdl;
        pAGBannerSize.lnr = 3;
        return pAGBannerSize;
    }

    public static PAGBannerSize getInlineAdaptiveBannerAdSize(int i, int i2) {
        PAGBannerSize pAGBannerSize = new PAGBannerSize(i, 0);
        pAGBannerSize.mml = i2;
        pAGBannerSize.lnr = 3;
        return pAGBannerSize;
    }
}
