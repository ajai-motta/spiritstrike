package com.adxcorp.ads.mediation;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.NewsFeed;
import com.adxcorp.ads.mediation.common.AdData;
import com.adxcorp.ads.mediation.common.AdResponse;
import com.adxcorp.ads.mediation.controller.AdController;
import com.adxcorp.ads.mediation.event.InhouseAdEventListener;
import com.adxcorp.ads.mediation.ui.AdContentView;
import com.adxcorp.ads.mediation.util.DisplayUtil;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MAdView extends FrameLayout {
    public static final String TAG = "MAdView";
    private AdController mAdController;
    private AdLandingListener mAdLandingListener;
    private AdListener mAdListener;
    private Context mContext;
    private final Handler mHandler;
    private boolean mInRecyclerView;
    private InhouseAdEventListener mInhouseAdEventListener;
    private boolean mIsEnableAutoBgColor;
    private boolean mIsInitialized;
    private boolean mIsScaleUp;
    private boolean mIsShowingAdContent;
    private boolean mIsSkipLandingUrl;
    private AdContentView mNextAdContentView;
    private int mScaleOrientation;
    private int mServerAdHeight;
    private int mServerAdWidth;
    private String mSlotId;

    public interface AdLandingListener {
        void onAdClicked(String str);
    }

    public interface AdListener {
        void onAdClicked();

        void onAdFailedToLoad(int i);

        void onAdLoaded();

        void onMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings, NewsFeed newsFeed);
    }

    public MAdView(Context context) {
        this(context, null, 0);
    }

    public MAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mContext = context;
        parsingAttribute(attributeSet);
        init();
    }

    public String getSlotId() {
        return this.mSlotId;
    }

    public void setSlotId(String str) {
        this.mSlotId = str;
    }

    public void setAdListener(AdListener adListener) {
        this.mAdListener = adListener;
    }

    public void setScaleUp(boolean z) {
        this.mIsScaleUp = z;
        this.mScaleOrientation = 1;
    }

    public void setScaleUp(boolean z, int i) {
        this.mIsScaleUp = z;
        this.mScaleOrientation = i;
    }

    public void setAutoBgColor(boolean z) {
        this.mIsEnableAutoBgColor = z;
    }

    public void setInRecyclerView(boolean z) {
        this.mInRecyclerView = z;
    }

    public void setLandingEnabled(boolean z) {
        this.mIsSkipLandingUrl = !z;
    }

    public void setAdLandingListener(AdLandingListener adLandingListener) {
        this.mAdLandingListener = adLandingListener;
    }

    private void parsingAttribute(AttributeSet attributeSet) {
        setBackgroundColor(0);
        if (!isInEditMode()) {
            if (attributeSet != null) {
                try {
                    this.mSlotId = attributeSet.getAttributeValue(null, "slotID");
                    return;
                } catch (Exception e) {
                    ADXLogUtil.e(TAG, e);
                    return;
                }
            }
            return;
        }
        setBackgroundColor(Color.parseColor("#EAEAEA"));
        TextView textView = new TextView(this.mContext);
        textView.setTextColor(Color.parseColor("#82D580"));
        textView.setTextSize(20.0f);
        textView.setText("AD(X) Banner");
        textView.setGravity(17);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(textView);
    }

    private void init() {
        ADXLogUtil.d(TAG, this.mSlotId + ":::init");
        if (isInEditMode()) {
            return;
        }
        addEventListener();
        this.mAdController = new AdController(this.mContext, this.mInhouseAdEventListener);
        this.mIsInitialized = true;
        this.mIsShowingAdContent = false;
    }

    private void addEventListener() {
        this.mInhouseAdEventListener = new InhouseAdEventListener() { // from class: com.adxcorp.ads.mediation.MAdView.1
            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdDismissed() {
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdShown() {
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdCompleted() {
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdError() {
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdPaused() {
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdSkipped() {
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdStarted() {
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdStopped() {
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void receivedResponse(AdResponse adResponse) {
                ADXLogUtil.d(MAdView.TAG, MAdView.this.mSlotId + ":::receivedResponse");
                if (adResponse != null) {
                    try {
                        int result = adResponse.getResult();
                        if (result == 0) {
                            if (adResponse.getCount() != 1) {
                                if (MAdView.this.mInhouseAdEventListener != null) {
                                    MAdView.this.mInhouseAdEventListener.notifyAdFailedToLoad(100);
                                }
                            } else {
                                AdData adData = adResponse.getAdData();
                                if (adData == null) {
                                    if (MAdView.this.mInhouseAdEventListener != null) {
                                        MAdView.this.mInhouseAdEventListener.notifyAdFailedToLoad(100);
                                    }
                                } else if (adData.getIcType() == 11) {
                                    MAdView.this.showAdContent(adData);
                                } else {
                                    ADXLogUtil.i(MAdView.TAG, "'" + adData.getIcType() + "' inventory and contentType are not matched.");
                                    if (MAdView.this.mInhouseAdEventListener != null) {
                                        MAdView.this.mInhouseAdEventListener.notifyAdFailedToLoad(108);
                                    }
                                }
                            }
                        } else if (result == 204) {
                            if (MAdView.this.mInhouseAdEventListener != null) {
                                MAdView.this.mInhouseAdEventListener.notifyAdFailedToLoad(100);
                            }
                        } else if (MAdView.this.mInhouseAdEventListener != null) {
                            MAdView.this.mInhouseAdEventListener.notifyAdFailedToLoad(101);
                        }
                    } catch (Exception e) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.e(MAdView.TAG, e);
                        }
                        if (MAdView.this.mInhouseAdEventListener != null) {
                            MAdView.this.mInhouseAdEventListener.notifyAdFailedToLoad(104);
                        }
                    }
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings, NewsFeed newsFeed) {
                ADXLogUtil.d(MAdView.TAG, MAdView.this.mSlotId + ":::notifyMediationLoaded");
                if (MAdView.this.mAdListener != null) {
                    MAdView.this.mAdListener.onMediationLoaded(arrayList, mediationSettings, newsFeed);
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdLoaded(Object... objArr) {
                ADXLogUtil.d(MAdView.TAG, MAdView.this.mSlotId + ":::notifyAdLoaded");
                if (MAdView.this.mAdListener != null) {
                    MAdView.this.mAdListener.onAdLoaded();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdFailedToLoad(int i) {
                ADXLogUtil.d(MAdView.TAG, MAdView.this.mSlotId + ":::notifyAdFailedToLoad:::" + i);
                if (MAdView.this.mAdListener != null) {
                    MAdView.this.mAdListener.onAdFailedToLoad(i);
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdClicked() {
                ADXLogUtil.d(MAdView.TAG, MAdView.this.mSlotId + ":::notifyAdClicked");
                if (MAdView.this.mAdListener != null) {
                    MAdView.this.mAdListener.onAdClicked();
                }
            }
        };
    }

    private void removeEventListener() {
        this.mInhouseAdEventListener = null;
    }

    private void release() {
        removeAllViews();
        AdContentView adContentView = this.mNextAdContentView;
        if (adContentView != null) {
            adContentView.onDestroy();
            this.mNextAdContentView = null;
        }
        AdController adController = this.mAdController;
        if (adController != null) {
            adController.destroy();
            this.mAdController = null;
        }
        removeEventListener();
        this.mIsInitialized = false;
    }

    public void destroy() {
        ADXLogUtil.d(TAG, this.mSlotId + ":::destroy");
        release();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ADXLogUtil.d(TAG, this.mSlotId + ":::onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ADXLogUtil.d(TAG, this.mSlotId + ":::onDetachedFromWindow");
        if (!this.mInRecyclerView) {
            release();
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAdContent(AdData adData) {
        String str = TAG;
        ADXLogUtil.d(str, this.mSlotId + ":::showAdContent - start");
        this.mServerAdWidth = adData.getContentWidth();
        this.mServerAdHeight = adData.getContentHeight();
        final int icType = adData.getIcType();
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(str, "mServerAdWidth : " + DisplayUtil.dpToPx(this.mContext, this.mServerAdWidth) + "(px), " + this.mServerAdWidth + "(dp), mServerAdHeight : " + DisplayUtil.dpToPx(this.mContext, this.mServerAdHeight) + "(px), " + this.mServerAdHeight + "(dp)");
        }
        if (MediationSDK.getInstance().getNetworkConnectionType() == 0) {
            InhouseAdEventListener inhouseAdEventListener = this.mInhouseAdEventListener;
            if (inhouseAdEventListener != null) {
                inhouseAdEventListener.notifyAdFailedToLoad(103);
                return;
            }
            return;
        }
        if (!this.mIsShowingAdContent) {
            this.mIsShowingAdContent = true;
            if (getContext() == null) {
                InhouseAdEventListener inhouseAdEventListener2 = this.mInhouseAdEventListener;
                if (inhouseAdEventListener2 != null) {
                    inhouseAdEventListener2.notifyAdFailedToLoad(107);
                    return;
                }
                return;
            }
            AdContentView adContentView = new AdContentView(getContext(), new AdContentView.AdContentEventListener() { // from class: com.adxcorp.ads.mediation.MAdView.2
                private boolean isViewLoaded;

                @Override // com.adxcorp.ads.mediation.ui.AdContentView.AdContentEventListener
                public void onViewLoaded(AdContentView adContentView2) {
                    ADXLogUtil.d(MAdView.TAG, MAdView.this.mSlotId + ":::onViewLoaded");
                    MAdView.this.mIsShowingAdContent = false;
                    if (this.isViewLoaded) {
                        return;
                    }
                    this.isViewLoaded = true;
                    MAdView.this.mNextAdContentView = adContentView2;
                    if (MAdView.this.mInhouseAdEventListener != null) {
                        MAdView.this.mInhouseAdEventListener.notifyAdLoaded(new Object[0]);
                    }
                    try {
                        if (icType == 11) {
                            if (MAdView.this.mIsScaleUp || !MAdView.this.mIsEnableAutoBgColor) {
                                if (MAdView.this.mNextAdContentView != null) {
                                    MAdView.this.mNextAdContentView.setVisibility(0);
                                    return;
                                }
                                return;
                            } else {
                                if (MAdView.this.mNextAdContentView != null) {
                                    MAdView.this.mNextAdContentView.setVisibility(4);
                                }
                                MAdView.this.mHandler.postDelayed(new Runnable() { // from class: com.adxcorp.ads.mediation.MAdView.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (MAdView.this.mNextAdContentView != null) {
                                            MAdView.this.mNextAdContentView.drawBackgroundColor();
                                            MAdView.this.mNextAdContentView.setVisibility(0);
                                        }
                                    }
                                }, 350L);
                                return;
                            }
                        }
                        if (MAdView.this.mNextAdContentView != null) {
                            MAdView.this.mNextAdContentView.setVisibility(0);
                        }
                    } catch (Exception e) {
                        ADXLogUtil.e(MAdView.TAG, e);
                    }
                }

                @Override // com.adxcorp.ads.mediation.ui.AdContentView.AdContentEventListener
                public void onViewLoadTimeout(AdContentView adContentView2) {
                    ADXLogUtil.d(MAdView.TAG, MAdView.this.mSlotId + ":::onViewLoadTimeout");
                    MAdView.this.mIsShowingAdContent = false;
                    if (adContentView2 != null) {
                        try {
                            MAdView.this.removeView(adContentView2);
                            adContentView2.onDestroy();
                        } catch (Exception e) {
                            ADXLogUtil.e(MAdView.TAG, e);
                        }
                    }
                    if (MAdView.this.mInhouseAdEventListener != null) {
                        MAdView.this.mInhouseAdEventListener.notifyAdFailedToLoad(107);
                    }
                }

                @Override // com.adxcorp.ads.mediation.ui.AdContentView.AdContentEventListener
                public void onViewClicked() {
                    ADXLogUtil.d(MAdView.TAG, MAdView.this.mSlotId + ":::onViewClicked");
                    if (MAdView.this.mInhouseAdEventListener != null) {
                        MAdView.this.mInhouseAdEventListener.notifyAdClicked();
                    }
                }

                @Override // com.adxcorp.ads.mediation.ui.AdContentView.AdContentEventListener
                public void onViewClicked(String str2) {
                    ADXLogUtil.d(MAdView.TAG, MAdView.this.mSlotId + ":::onViewClicked");
                    if (MAdView.this.mAdLandingListener != null) {
                        ADXLogUtil.d(MAdView.TAG, MAdView.this.mSlotId + ":::notifyAdClicked->" + str2);
                        if (MAdView.this.mAdLandingListener != null) {
                            MAdView.this.mAdLandingListener.onAdClicked(str2);
                        }
                    }
                }
            });
            adContentView.setVisibility(8);
            adContentView.setSkipLandingUrl(this.mIsSkipLandingUrl);
            adContentView.setAdData(adData);
            adContentView.showContent();
            ADXLogUtil.d(str, this.mSlotId + ":::showAdContent - end");
            return;
        }
        ADXLogUtil.d(str, "Previous ad content is showing.");
        InhouseAdEventListener inhouseAdEventListener3 = this.mInhouseAdEventListener;
        if (inhouseAdEventListener3 != null) {
            inhouseAdEventListener3.notifyAdFailedToLoad(107);
        }
    }

    private void layoutScale(View view, float f) {
        try {
            int i = this.mContext.getResources().getConfiguration().orientation;
            int i2 = this.mScaleOrientation;
            float f2 = ((i2 != 1 || i == 1) && (i2 != 2 || i == 2)) ? 0.0f : 1.0f;
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(TAG, "orientation : " + i + ", scale orientation : " + this.mScaleOrientation);
            }
            if (f2 == 1.0f) {
                f = f2;
            } else if (Float.isInfinite(f) || Float.isNaN(f) || f <= 1.0f) {
                f = 1.0f;
            } else if (f > 2.0f) {
                f = 2.0f;
            }
            int i3 = (int) (this.mServerAdWidth * this.mContext.getResources().getDisplayMetrics().density * f);
            int i4 = (int) (this.mServerAdHeight * this.mContext.getResources().getDisplayMetrics().density * f);
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(TAG, "scale : " + f + ", width : " + i3 + ", height : " + i4);
            }
            if (f <= 1.0f) {
                ADXLogUtil.d(TAG, "It can't scale up AdView.");
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            view.setScaleX(f);
            view.setScaleY(f);
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            if (this.mIsScaleUp) {
                int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), i);
                int defaultSize2 = getDefaultSize(getSuggestedMinimumHeight(), i2);
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(TAG, "onMeasure - width : " + defaultSize + ", height : " + defaultSize2);
                }
                float f = this.mServerAdWidth * this.mContext.getResources().getDisplayMetrics().density;
                float f2 = this.mServerAdHeight * this.mContext.getResources().getDisplayMetrics().density;
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(TAG, "onMeasure - adWidthPx : " + f + ", adHeightPx : " + f2);
                }
                if (f > 0.0f && f2 > 0.0f) {
                    float f3 = defaultSize / f;
                    float f4 = defaultSize2 / f2;
                    float fMin = Math.min(f3, f4);
                    if (fMin == 0.0f && defaultSize2 == 0) {
                        fMin = f3;
                    }
                    if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                        ADXLogUtil.d(TAG, "onMeasure - widthRatio : " + f3 + ", heightRatio : " + f4 + ", ratio : " + fMin);
                    }
                    if (!Float.isInfinite(fMin) && !Float.isNaN(fMin)) {
                        for (int i3 = 0; i3 < getChildCount(); i3++) {
                            layoutScale(getChildAt(i3), fMin);
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
        super.onMeasure(i, i2);
    }

    public void parsingBidResponse(MediationData mediationData) {
        AdController adController = this.mAdController;
        if (adController == null) {
            ADXLogUtil.d(TAG, "AdController cannot be null.");
            InhouseAdEventListener inhouseAdEventListener = this.mInhouseAdEventListener;
            if (inhouseAdEventListener != null) {
                inhouseAdEventListener.notifyAdFailedToLoad(104);
                return;
            }
            return;
        }
        if (mediationData == null) {
            ADXLogUtil.d(TAG, "Mediation data cannot be null.");
            InhouseAdEventListener inhouseAdEventListener2 = this.mInhouseAdEventListener;
            if (inhouseAdEventListener2 != null) {
                inhouseAdEventListener2.notifyAdFailedToLoad(108);
                return;
            }
            return;
        }
        adController.parsingBidResponse(mediationData);
    }

    public View getAdContentView() {
        return this.mNextAdContentView;
    }
}
