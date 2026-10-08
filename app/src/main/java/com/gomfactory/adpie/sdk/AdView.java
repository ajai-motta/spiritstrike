package com.gomfactory.adpie.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.gomfactory.adpie.sdk.common.AdData;
import com.gomfactory.adpie.sdk.common.AdResponse;
import com.gomfactory.adpie.sdk.common.Constants;
import com.gomfactory.adpie.sdk.common.DataKeys;
import com.gomfactory.adpie.sdk.controller.AdController;
import com.gomfactory.adpie.sdk.event.AdEventListener;
import com.gomfactory.adpie.sdk.pref.Preference;
import com.gomfactory.adpie.sdk.ui.AdContentView;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.AnimationUtil;
import com.gomfactory.adpie.sdk.util.DisplayUtil;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes3.dex */
public class AdView extends FrameLayout {
    public static final String TAG = "AdView";
    private AdController mAdController;
    private AdEventListener mAdEventListener;
    private AdLandingListener mAdLandingListener;
    private AdListener mAdListener;
    private Thread mAdThread;
    private AdViewState mAdViewState;
    private int mAnimationType;
    private Context mContext;
    private final Handler mHandler;
    private HashMap<String, String> mHashMap;
    private boolean mInRecyclerView;
    private boolean mIsAttachedToWindow;
    private boolean mIsAvailableNextAdRequest;
    private boolean mIsEnableAutoBgColor;
    private boolean mIsInForeground;
    private boolean mIsInitialized;
    private boolean mIsLoading;
    private boolean mIsScaleUp;
    private boolean mIsShowingAdContent;
    private boolean mIsSkipLandingUrl;
    private int mNetworkErrorIdx;
    private AdContentView mNextAdContentView;
    private OnPaidEventListener mOnPaidEventListener;
    private AdContentView mPreAdContentView;
    private AdData mReadyAdData;
    private long mRefreshTime;
    private Timer mReloadTimer;
    private long mResponseInterval;
    private int mScaleOrientation;
    private BroadcastReceiver mScreenStateReceiver;
    private int mServerAdHeight;
    private int mServerAdWidth;
    private String mSlotId;
    private TargetingData mTargetingData;

    public interface AdLandingListener {
        void onAdClicked(String str);
    }

    public interface AdListener {
        void onAdClicked();

        void onAdFailedToLoad(int i);

        void onAdLoaded();
    }

    public interface OnPaidEventListener {
        void onPaidEvent(double d);
    }

    public AdView(Context context) {
        this(context, null, 0);
    }

    public AdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRefreshTime = 10000L;
        this.mReadyAdData = null;
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

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.mOnPaidEventListener = onPaidEventListener;
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
                    AdPieLog.e(TAG, e);
                    return;
                }
            }
            return;
        }
        setBackgroundColor(Color.parseColor("#EAEAEA"));
        TextView textView = new TextView(this.mContext);
        textView.setTextColor(Color.parseColor("#82D580"));
        textView.setTextSize(20.0f);
        textView.setText("AdPie Banner");
        textView.setGravity(17);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        AdPieLog.d(TAG, this.mSlotId + ":::init");
        if (isInEditMode()) {
            return;
        }
        addEventListener();
        this.mAdController = new AdController(this.mContext, this.mAdEventListener);
        this.mIsInitialized = true;
        this.mNetworkErrorIdx = 0;
        this.mIsAvailableNextAdRequest = false;
        this.mIsShowingAdContent = false;
        this.mAdViewState = AdViewState.RESUME;
    }

    private void addEventListener() {
        this.mAdEventListener = new AdEventListener() { // from class: com.gomfactory.adpie.sdk.AdView.1
            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdDismissed() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdShown() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdCompleted() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdError() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdPaused() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdSkipped() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdStarted() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdStopped() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void receivedResponse(AdResponse adResponse) {
                AdPieLog.d(AdView.TAG, AdView.this.mSlotId + ":::receivedResponse");
                if (adResponse != null) {
                    try {
                        int result = adResponse.getResult();
                        AdView.this.mResponseInterval = adResponse.getInterval();
                        Preference.putLong(AdView.this.mContext, DataKeys.getKeyWithSlot("RESPONSE_INTERVAL", AdView.this.mSlotId), AdView.this.mResponseInterval);
                        if (result != 0) {
                            if (result == 204) {
                                if (AdView.this.mAdEventListener != null) {
                                    AdView.this.mAdEventListener.notifyAdFailedToLoad(100);
                                    return;
                                }
                                return;
                            } else {
                                if (AdView.this.mAdEventListener != null) {
                                    AdView.this.mAdEventListener.notifyAdFailedToLoad(101);
                                    return;
                                }
                                return;
                            }
                        }
                        if (adResponse.getCount() != 1) {
                            if (AdView.this.mAdEventListener != null) {
                                AdView.this.mAdEventListener.notifyAdFailedToLoad(100);
                                return;
                            }
                            return;
                        }
                        AdData adData = adResponse.getAdData();
                        if (adData == null) {
                            if (AdView.this.mAdEventListener != null) {
                                AdView.this.mAdEventListener.notifyAdFailedToLoad(100);
                                return;
                            }
                            return;
                        }
                        if (adData.getIcType() == 11) {
                            AdPieLog.d(AdView.TAG, AdView.this.mSlotId + " - isAttachedToWindow : " + AdView.this.mIsAttachedToWindow + ", isInForeground : " + AdView.this.mIsInForeground + ", CheckView : " + adData.getCheckView());
                            if ((!AdView.this.mIsAttachedToWindow || !AdView.this.mIsInForeground) && adData.getCheckView() == 1) {
                                AdView.this.mReadyAdData = adData;
                                if (AdView.this.mAdEventListener != null) {
                                    AdView.this.mAdEventListener.notifyAdLoaded(new Object[0]);
                                    return;
                                }
                                return;
                            }
                            AdView.this.mReadyAdData = null;
                            AdView.this.showAdContent(adData, true);
                            return;
                        }
                        AdPieLog.i(AdView.TAG, "'" + adData.getIcType() + "' inventory and contentType are not matched.");
                        if (AdView.this.mAdEventListener != null) {
                            AdView.this.mAdEventListener.notifyAdFailedToLoad(108);
                        }
                    } catch (Exception e) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.e(AdView.TAG, e);
                        }
                        if (AdView.this.mAdEventListener != null) {
                            AdView.this.mAdEventListener.notifyAdFailedToLoad(104);
                        }
                    }
                }
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdLoaded(Object... objArr) {
                AdView.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(AdView.TAG, AdView.this.mSlotId + ":::notifyAdLoaded");
                        AdView.this.mIsAvailableNextAdRequest = true;
                        AdView.this.mNetworkErrorIdx = 0;
                        AdView.this.setRefreshTime(AdView.this.mResponseInterval);
                        AdView.this.mIsLoading = false;
                        if (AdView.this.mAdListener != null) {
                            AdView.this.mAdListener.onAdLoaded();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdFailedToLoad(final int i) {
                AdView.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(AdView.TAG, AdView.this.mSlotId + ":::notifyAdFailedToLoad:::" + i);
                        AdView.this.mIsAvailableNextAdRequest = true;
                        if (i == 102) {
                            AdView.this.networkError();
                        } else {
                            AdView.this.mNetworkErrorIdx = 0;
                            AdView.this.setRefreshTime(AdView.this.mResponseInterval);
                        }
                        if (i != 106) {
                            AdView.this.mIsLoading = false;
                        }
                        if (AdView.this.mAdListener != null) {
                            AdView.this.mAdListener.onAdFailedToLoad(i);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdClicked() {
                AdView.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdView.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(AdView.TAG, AdView.this.mSlotId + ":::notifyAdClicked");
                        if (AdView.this.mAdListener != null) {
                            AdView.this.mAdListener.onAdClicked();
                        }
                    }
                });
            }
        };
    }

    private void removeEventListener() {
        this.mAdEventListener = null;
    }

    public void load() {
        try {
            if (this.mIsLoading) {
                AdPieLog.d(TAG, "AdPie (" + this.mSlotId + ") is already loading an ad. Wait for previous load to finish.");
                AdEventListener adEventListener = this.mAdEventListener;
                if (adEventListener != null) {
                    adEventListener.notifyAdFailedToLoad(106);
                    return;
                }
                return;
            }
            this.mIsLoading = true;
            Thread thread = this.mAdThread;
            if (thread != null) {
                thread.interrupt();
                this.mAdThread = null;
            }
            Thread thread2 = new Thread(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdView.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AdPieLog.d(AdView.TAG, AdView.this.mSlotId + ":::load");
                        if (!TextUtils.isEmpty(AdView.this.mSlotId)) {
                            AdView adView = AdView.this;
                            adView.mResponseInterval = Preference.getLongValue(adView.mContext, DataKeys.getKeyWithSlot("RESPONSE_INTERVAL", AdView.this.mSlotId), 0L);
                        }
                        if (!AdView.this.mIsInitialized) {
                            AdView.this.init();
                        }
                        AdView.this.mAdController.setSlotID(AdView.this.mSlotId);
                        AdView.this.mAdController.setTargetingData(AdView.this.mTargetingData);
                        AdView.this.mAdController.loadAd(AdView.this.mHashMap);
                    } catch (Exception e) {
                        AdPieLog.e(AdView.TAG, e);
                        if (AdView.this.mAdEventListener != null) {
                            AdView.this.mAdEventListener.notifyAdFailedToLoad(104);
                        }
                    }
                }
            });
            this.mAdThread = thread2;
            thread2.start();
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
            AdEventListener adEventListener2 = this.mAdEventListener;
            if (adEventListener2 != null) {
                adEventListener2.notifyAdFailedToLoad(104);
            }
        }
    }

    public void load(TargetingData targetingData) {
        this.mTargetingData = targetingData;
        load();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pause() {
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, this.mSlotId + ":::pause");
        }
        this.mAdViewState = AdViewState.PAUSE;
        stopReloadTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resume() {
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, this.mSlotId + ":::resume");
        }
        if (this.mAdViewState.isPause()) {
            this.mAdViewState = AdViewState.RESUME;
            stopReloadTimer();
            startReloadTimer();
        }
    }

    private void release() {
        removeAllViews();
        pause();
        AdContentView adContentView = this.mPreAdContentView;
        if (adContentView != null) {
            adContentView.onDestroy();
            this.mPreAdContentView = null;
        }
        AdContentView adContentView2 = this.mNextAdContentView;
        if (adContentView2 != null) {
            adContentView2.onDestroy();
            this.mNextAdContentView = null;
        }
        AdController adController = this.mAdController;
        if (adController != null) {
            adController.destroy();
            this.mAdController = null;
        }
        removeEventListener();
        this.mIsInitialized = false;
        Thread thread = this.mAdThread;
        if (thread != null) {
            thread.interrupt();
            this.mAdThread = null;
        }
        HashMap<String, String> map = this.mHashMap;
        if (map != null) {
            map.clear();
            this.mHashMap = null;
        }
    }

    public void destroy() {
        AdPieLog.d(TAG, this.mSlotId + ":::destroy");
        release();
    }

    public void setExtraParameter(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals("floorPrice")) {
            return;
        }
        if (this.mHashMap == null) {
            this.mHashMap = new HashMap<>();
        }
        this.mHashMap.put("bidfloor", str2);
        this.mHashMap.put("bidfloorcur", "USD");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AdPieLog.d(TAG, this.mSlotId + ":::onAttachedToWindow");
        this.mIsAttachedToWindow = true;
        registerBroadcastReceiver();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AdPieLog.d(TAG, this.mSlotId + ":::onDetachedFromWindow");
        this.mIsAttachedToWindow = false;
        unregisterBroadcastReceiver();
        if (!this.mInRecyclerView) {
            release();
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAdContent(final AdData adData, final boolean z) {
        AdEventListener adEventListener;
        AdEventListener adEventListener2;
        AdEventListener adEventListener3;
        String str = TAG;
        AdPieLog.d(str, this.mSlotId + ":::showAdContent(" + z + ") - start");
        this.mServerAdWidth = adData.getContentWidth();
        this.mServerAdHeight = adData.getContentHeight();
        this.mAnimationType = adData.getAnimationType();
        final int icType = adData.getIcType();
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(str, "mServerAdWidth : " + DisplayUtil.dpToPx(this.mContext, this.mServerAdWidth) + "(px), " + this.mServerAdWidth + "(dp), mServerAdHeight : " + DisplayUtil.dpToPx(this.mContext, this.mServerAdHeight) + "(px), " + this.mServerAdHeight + "(dp)");
        }
        if (AdPieSDK.getInstance().getNetworkConnectionType() == 0) {
            if (!z || (adEventListener3 = this.mAdEventListener) == null) {
                return;
            }
            adEventListener3.notifyAdFailedToLoad(103);
            return;
        }
        if (!this.mIsShowingAdContent) {
            this.mIsShowingAdContent = true;
            if (getContext() == null) {
                if (!z || (adEventListener2 = this.mAdEventListener) == null) {
                    return;
                }
                adEventListener2.notifyAdFailedToLoad(107);
                return;
            }
            AdContentView adContentView = new AdContentView(getContext(), new AdContentView.AdContentEventListener() { // from class: com.gomfactory.adpie.sdk.AdView.3
                private boolean isViewLoaded;

                @Override // com.gomfactory.adpie.sdk.ui.AdContentView.AdContentEventListener
                public void onViewLoaded(AdContentView adContentView2) {
                    AdPieLog.d(AdView.TAG, AdView.this.mSlotId + ":::onViewLoaded");
                    AdView.this.mIsShowingAdContent = false;
                    if (this.isViewLoaded) {
                        return;
                    }
                    this.isViewLoaded = true;
                    if (z && AdView.this.mAdEventListener != null) {
                        AdView.this.mAdEventListener.notifyAdLoaded(new Object[0]);
                    }
                    if (z && AdView.this.mOnPaidEventListener != null) {
                        AdView.this.mOnPaidEventListener.onPaidEvent(adData.getEcpm());
                    }
                    try {
                        if (AdView.this.mPreAdContentView != null) {
                            AdView.this.mPreAdContentView.setVisibility(8);
                            AdView adView = AdView.this;
                            adView.removeView(adView.mPreAdContentView);
                            AdView.this.mPreAdContentView.onDestroy();
                            AdView.this.mPreAdContentView = null;
                        }
                        AdView adView2 = AdView.this;
                        adView2.mPreAdContentView = adView2.mNextAdContentView;
                        AdView.this.mNextAdContentView = adContentView2;
                        if (icType == 11) {
                            if (AdView.this.mIsScaleUp || !AdView.this.mIsEnableAutoBgColor) {
                                if (AdView.this.mNextAdContentView != null) {
                                    AdView.this.mNextAdContentView.setVisibility(0);
                                }
                                AdView.this.animateView();
                                return;
                            } else {
                                if (AdView.this.mNextAdContentView != null) {
                                    AdView.this.mNextAdContentView.setVisibility(4);
                                }
                                AdView.this.mHandler.postDelayed(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdView.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AdView.this.mNextAdContentView != null) {
                                            AdView.this.mNextAdContentView.drawBackgroundColor(z);
                                            AdView.this.mNextAdContentView.setVisibility(0);
                                        }
                                        AdView.this.animateView();
                                    }
                                }, 350L);
                                return;
                            }
                        }
                        if (AdView.this.mNextAdContentView != null) {
                            AdView.this.mNextAdContentView.setVisibility(0);
                        }
                        AdView.this.animateView();
                    } catch (Exception e) {
                        AdPieLog.e(AdView.TAG, e);
                    }
                }

                @Override // com.gomfactory.adpie.sdk.ui.AdContentView.AdContentEventListener
                public void onViewLoadTimeout(AdContentView adContentView2) {
                    AdPieLog.d(AdView.TAG, AdView.this.mSlotId + ":::onViewLoadTimeout");
                    AdView.this.mIsShowingAdContent = false;
                    if (adContentView2 != null) {
                        try {
                            AdView.this.removeView(adContentView2);
                            adContentView2.onDestroy();
                        } catch (Exception e) {
                            AdPieLog.e(AdView.TAG, e);
                        }
                    }
                    if (!z || AdView.this.mAdEventListener == null) {
                        return;
                    }
                    AdView.this.mAdEventListener.notifyAdFailedToLoad(107);
                }

                @Override // com.gomfactory.adpie.sdk.ui.AdContentView.AdContentEventListener
                public void onViewClicked() {
                    AdPieLog.d(AdView.TAG, AdView.this.mSlotId + ":::onViewClicked");
                    if (AdView.this.mAdEventListener != null) {
                        AdView.this.mAdEventListener.notifyAdClicked();
                    }
                }

                @Override // com.gomfactory.adpie.sdk.ui.AdContentView.AdContentEventListener
                public void onViewClicked(final String str2) {
                    AdPieLog.d(AdView.TAG, AdView.this.mSlotId + ":::onViewClicked");
                    if (AdView.this.mAdLandingListener != null) {
                        AdView.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdView.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AdPieLog.d(AdView.TAG, AdView.this.mSlotId + ":::notifyAdClicked->" + str2);
                                if (AdView.this.mAdLandingListener != null) {
                                    AdView.this.mAdLandingListener.onAdClicked(str2);
                                }
                            }
                        });
                    }
                }
            });
            adContentView.setVisibility(8);
            addView(adContentView);
            adContentView.setSkipLandingUrl(this.mIsSkipLandingUrl);
            adContentView.setAdData(adData);
            adContentView.showContent();
            AdPieLog.d(str, this.mSlotId + ":::showAdContent(" + z + ") - end");
            return;
        }
        AdPieLog.d(str, "Previous ad content is showing.");
        if (!z || (adEventListener = this.mAdEventListener) == null) {
            return;
        }
        adEventListener.notifyAdFailedToLoad(107);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNextAd() {
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "Preparing to load next ads.");
        }
        this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdView.4
            @Override // java.lang.Runnable
            public void run() {
                AdView.this.load();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void networkError() {
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "networkError");
        }
        stopReloadTimer();
        int i = this.mNetworkErrorIdx;
        if (i < 0 || i > Constants.NETWORK_INTERVAL.length - 1) {
            this.mNetworkErrorIdx = 0;
        }
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "NetworkErrorIdx : " + this.mNetworkErrorIdx);
        }
        int[] iArr = Constants.NETWORK_INTERVAL;
        int i2 = this.mNetworkErrorIdx;
        long j = iArr[i2];
        this.mNetworkErrorIdx = i2 + 1;
        AdPieLog.d(TAG, "networkError setRefreshTime : " + j);
        this.mRefreshTime = j;
        startReloadTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRefreshTime(long j) {
        if (j > 0 && j < 10000) {
            this.mRefreshTime = 10000L;
        } else if (j > 300000) {
            this.mRefreshTime = 300000L;
        } else {
            this.mRefreshTime = j;
        }
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "setRefreshTime : " + j + " -> " + this.mRefreshTime);
        }
        if (this.mAdViewState.isPause()) {
            stopReloadTimer();
        } else {
            stopReloadTimer();
            startReloadTimer();
        }
    }

    private void startReloadTimer() {
        if (this.mIsAvailableNextAdRequest) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "startReloadTimer (mResponseInterval : " + this.mResponseInterval + ", mRefreshTime : " + this.mRefreshTime + ")");
            }
            if (this.mResponseInterval == 0 || this.mRefreshTime < 10000) {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, "AdView refresh is disable.");
                }
            } else if (!this.mIsAttachedToWindow) {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, "AdView not yet attached to window.");
                }
            } else {
                if (this.mReloadTimer == null) {
                    this.mReloadTimer = new Timer();
                }
                this.mReloadTimer.schedule(new ReloadTask(), this.mRefreshTime);
            }
        }
    }

    private void stopReloadTimer() {
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "stopReloadTimer");
        }
        Timer timer = this.mReloadTimer;
        if (timer == null) {
            return;
        }
        timer.cancel();
        this.mReloadTimer = null;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (this.mAdController == null) {
            return;
        }
        if (i == 0) {
            this.mIsInForeground = true;
            AdData adData = this.mReadyAdData;
            if (adData != null) {
                showAdContent(adData, false);
                this.mReadyAdData = null;
                this.mNetworkErrorIdx = 0;
                setRefreshTime(this.mResponseInterval);
            }
            resume();
        } else {
            this.mIsInForeground = false;
            pause();
        }
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            String str = TAG;
            StringBuilder sb = new StringBuilder("AdView onWindowVisibilityChanged(");
            sb.append(i);
            sb.append("): ");
            sb.append(i == 0 ? "VISIBLE" : "INVISIBLE");
            AdPieLog.d(str, sb.toString());
        }
    }

    private boolean isDeviceInteractive() {
        try {
            return ((PowerManager) this.mContext.getSystemService("power")).isInteractive();
        } catch (Exception e) {
            if (!AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                return true;
            }
            AdPieLog.e(TAG, e);
            return true;
        }
    }

    private void registerBroadcastReceiver() {
        try {
            this.mScreenStateReceiver = new BroadcastReceiver() { // from class: com.gomfactory.adpie.sdk.AdView.5
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(AdView.TAG, "Intent.ACTION_SCREEN_OFF : " + AdView.this.mIsInForeground);
                        }
                        if (AdView.this.mIsInForeground) {
                            AdView.this.pause();
                            return;
                        }
                        return;
                    }
                    if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(AdView.TAG, "Intent.ACTION_SCREEN_ON : " + AdView.this.mIsInForeground);
                        }
                        if (AdView.this.mIsInForeground) {
                            AdView.this.resume();
                            return;
                        }
                        return;
                    }
                    if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(AdView.TAG, "Intent.ACTION_USER_PRESENT : " + AdView.this.mIsInForeground);
                        }
                        if (AdView.this.mIsInForeground) {
                            AdView.this.resume();
                        }
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.mContext.registerReceiver(this.mScreenStateReceiver, intentFilter);
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }

    private void unregisterBroadcastReceiver() {
        try {
            this.mContext.unregisterReceiver(this.mScreenStateReceiver);
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateView() {
        if (this.mNextAdContentView != null) {
            Animation.AnimationListener animationListener = new Animation.AnimationListener() { // from class: com.gomfactory.adpie.sdk.AdView.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (AdView.this.mPreAdContentView != null) {
                        AdView.this.mPreAdContentView.clearAnimation();
                        AdView adView = AdView.this;
                        if (adView == null) {
                            return;
                        }
                        adView.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.AdView.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (AdView.this.mPreAdContentView != null) {
                                        AdView.this.mPreAdContentView.setVisibility(8);
                                        AdView.this.removeView(AdView.this.mPreAdContentView);
                                        AdView.this.mPreAdContentView.onDestroy();
                                        AdView.this.mPreAdContentView = null;
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        });
                    }
                }
            };
            Animation showAnimation = AnimationUtil.getShowAnimation(this.mAnimationType, this.mNextAdContentView);
            showAnimation.setAnimationListener(animationListener);
            this.mNextAdContentView.startAnimation(showAnimation);
        }
        AdContentView adContentView = this.mPreAdContentView;
        if (adContentView != null) {
            this.mPreAdContentView.startAnimation(AnimationUtil.getHideAnimation(this.mAnimationType, adContentView));
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void layoutScale(View view, float f) {
        try {
            int i = this.mContext.getResources().getConfiguration().orientation;
            int i2 = this.mScaleOrientation;
            float f2 = ((i2 != 1 || i == 1) && (i2 != 2 || i == 2)) ? 0.0f : 1.0f;
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "orientation : " + i + ", scale orientation : " + this.mScaleOrientation);
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
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "scale : " + f + ", width : " + i3 + ", height : " + i4);
            }
            if (f <= 1.0f) {
                AdPieLog.d(TAG, "It can't scale up AdView.");
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
            AdPieLog.e(TAG, e);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            if (this.mIsScaleUp) {
                int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), i);
                int defaultSize2 = getDefaultSize(getSuggestedMinimumHeight(), i2);
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, "onMeasure - width : " + defaultSize + ", height : " + defaultSize2);
                }
                float f = this.mServerAdWidth * this.mContext.getResources().getDisplayMetrics().density;
                float f2 = this.mServerAdHeight * this.mContext.getResources().getDisplayMetrics().density;
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, "onMeasure - adWidthPx : " + f + ", adHeightPx : " + f2);
                }
                if (f > 0.0f && f2 > 0.0f) {
                    float f3 = defaultSize / f;
                    float f4 = defaultSize2 / f2;
                    float fMin = Math.min(f3, f4);
                    if (fMin == 0.0f && defaultSize2 == 0) {
                        fMin = f3;
                    }
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(TAG, "onMeasure - widthRatio : " + f3 + ", heightRatio : " + f4 + ", ratio : " + fMin);
                    }
                    if (!Float.isInfinite(fMin) && !Float.isNaN(fMin)) {
                        for (int i3 = 0; i3 < getChildCount(); i3++) {
                            layoutScale(getChildAt(i3), fMin);
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
        super.onMeasure(i, i2);
    }

    private enum AdViewState {
        PAUSE,
        RESUME;

        boolean isPause() {
            return this == PAUSE;
        }
    }

    class ReloadTask extends TimerTask {
        ReloadTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AdView adView = AdView.this;
            if (adView != null) {
                adView.loadNextAd();
            }
        }
    }
}
