package com.adxcorp.ads.nativeads;

import android.text.TextUtils;
import android.view.View;
import com.adxcorp.ads.nativeads.event.NativeAdClickListener;
import com.adxcorp.ads.nativeads.event.NativeAdImpressionListener;
import com.adxcorp.util.ADXLogUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SimpleNativeAd extends BaseNativeAd implements NativeAdImpressionListener, NativeAdClickListener {
    private static final int DEFAULT_IMPRESSION_MIN_PERCENTAGE_VIEWED = 50;
    private static final int DEFAULT_IMPRESSION_MIN_TIME_VIEWED_MS = 0;
    private String mCallToAction;
    private String mClickDestinationUrl;
    private String mIconImageUrl;
    private boolean mImpressionRecorded;
    private String mMainImageUrl;
    private String mPrivacyInformationIconClickThroughUrl;
    private String mPrivacyInformationIconImageUrl;
    private String mText;
    private String mTitle;
    private final String TAG = "SimpleNativeAd";
    private int mImpressionMinTimeViewed = 0;
    private int mImpressionMinPercentageViewed = 50;
    private Integer mImpressionMinVisiblePx = null;
    private final Map<String, Object> mExtras = new HashMap();

    @Override // com.adxcorp.ads.nativeads.BaseNativeAd
    public void clear(View view) {
    }

    @Override // com.adxcorp.ads.nativeads.event.NativeAdClickListener
    public void handleClick(View view) {
    }

    @Override // com.adxcorp.ads.nativeads.BaseNativeAd
    public void prepare(View view) {
    }

    @Override // com.adxcorp.ads.nativeads.event.NativeAdImpressionListener
    public void recordImpression(View view) {
    }

    public final String getTitle() {
        return this.mTitle;
    }

    public final void setTitle(String str) {
        this.mTitle = str;
    }

    public final String getText() {
        return this.mText;
    }

    public final void setText(String str) {
        this.mText = str;
    }

    public final String getMainImageUrl() {
        return this.mMainImageUrl;
    }

    public final void setMainImageUrl(String str) {
        this.mMainImageUrl = str;
    }

    public final String getIconImageUrl() {
        return this.mIconImageUrl;
    }

    public final void setIconImageUrl(String str) {
        this.mIconImageUrl = str;
    }

    public final String getCallToAction() {
        return this.mCallToAction;
    }

    public final void setCallToAction(String str) {
        this.mCallToAction = str;
    }

    public final String getPrivacyInformationIconClickThroughUrl() {
        return this.mPrivacyInformationIconClickThroughUrl;
    }

    public final void setPrivacyInformationIconClickThroughUrl(String str) {
        this.mPrivacyInformationIconClickThroughUrl = str;
    }

    public String getPrivacyInformationIconImageUrl() {
        return this.mPrivacyInformationIconImageUrl;
    }

    public final void setPrivacyInformationIconImageUrl(String str) {
        this.mPrivacyInformationIconImageUrl = str;
    }

    public final Object getExtra(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mExtras.get(str);
    }

    public final Map<String, Object> getExtras() {
        return new HashMap(this.mExtras);
    }

    public final String getClickDestinationUrl() {
        return this.mClickDestinationUrl;
    }

    public final void setClickDestinationUrl(String str) {
        this.mClickDestinationUrl = str;
    }

    public final void addExtra(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mExtras.put(str, obj);
    }

    @Override // com.adxcorp.ads.nativeads.BaseNativeAd
    public void destroy() {
        invalidate();
    }

    @Override // com.adxcorp.ads.nativeads.event.NativeAdImpressionListener
    public final int getImpressionMinPercentageViewed() {
        return this.mImpressionMinPercentageViewed;
    }

    public final void setImpressionMinPercentageViewed(int i) {
        if (i >= 0 && i <= 100) {
            this.mImpressionMinPercentageViewed = i;
            return;
        }
        ADXLogUtil.d(this.TAG, "Ignoring impressionMinTimeViewed that's not a percent [0, 100]: " + i);
    }

    @Override // com.adxcorp.ads.nativeads.event.NativeAdImpressionListener
    public final int getImpressionMinTimeViewed() {
        return this.mImpressionMinTimeViewed;
    }

    public final void setImpressionMinTimeViewed(int i) {
        if (i > 0) {
            this.mImpressionMinTimeViewed = i;
            return;
        }
        ADXLogUtil.d(this.TAG, "Ignoring non-positive impressionMinTimeViewed: " + i);
    }

    @Override // com.adxcorp.ads.nativeads.event.NativeAdImpressionListener
    public final Integer getImpressionMinVisiblePx() {
        return this.mImpressionMinVisiblePx;
    }

    public final void setImpressionMinVisiblePx(Integer num) {
        if (num != null && num.intValue() > 0) {
            this.mImpressionMinVisiblePx = num;
            return;
        }
        ADXLogUtil.d(this.TAG, "Ignoring null or non-positive impressionMinVisiblePx: " + num);
    }

    @Override // com.adxcorp.ads.nativeads.event.NativeAdImpressionListener
    public final boolean isImpressionRecorded() {
        return this.mImpressionRecorded;
    }

    @Override // com.adxcorp.ads.nativeads.event.NativeAdImpressionListener
    public final void setImpressionRecorded() {
        this.mImpressionRecorded = true;
    }
}
