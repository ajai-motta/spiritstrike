package com.adxcorp.ads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.common.BCustomEventListener;
import com.adxcorp.ads.common.BannerCustomEvent;
import com.adxcorp.ads.common.CustomEvent;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.NewsFeed;
import com.adxcorp.ads.common.OnPaidEventListener;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.common.Constants;
import com.adxcorp.ads.mediation.common.DataKeys;
import com.adxcorp.ads.mediation.controller.AdController;
import com.adxcorp.ads.mediation.event.AdEventListener;
import com.adxcorp.ads.mediation.pref.Preference;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.util.ADXLogUtil;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class BannerAd extends FrameLayout {
    private static final String TAG = "BannerAd";
    private AdController mAdController;
    private AdEventListener mAdEventListener;
    private AdViewState mAdViewState;
    private String mAdxUnitId;
    private AdConstants.BANNER_AD_SIZE mBannerAdSize;
    private BannerListener mBannerListener;
    protected final Context mContext;
    private BannerCustomEvent mCustomEvent;
    private boolean mInRecyclerView;
    private String mInventoryType;
    private boolean mIsAttachedToWindow;
    protected boolean mIsAvailableNextAdRequest;
    protected boolean mIsDestroyed;
    private boolean mIsDisableAutoRefresh;
    private boolean mIsInForeground;
    protected boolean mIsNewsBanner;
    private boolean mIsPauseAutoRefresh;
    private long mLoadedTime;
    protected int mNetworkErrorIdx;
    protected NewsFeed mNewsFeed;
    protected BannerCustomEvent mNextAdContentView;
    private OnPaidEventListener mOnPaidEventListener;
    private long mRefreshTime;
    private Timer mReloadTimer;
    protected long mResponseInterval;
    private BroadcastReceiver mScreenStateReceiver;

    public interface AdLandingListener {
        void onAdClicked(String str);
    }

    public interface BannerListener {
        void onAdClicked();

        void onAdError(int i);

        void onAdLoaded();
    }

    public BannerAd(Context context, String str, AdConstants.BANNER_AD_SIZE banner_ad_size) {
        super(context);
        this.mInventoryType = ReportUtil.INVENTORY_TYPE_BANNER;
        this.mRefreshTime = 10000L;
        this.mAdEventListener = new AdEventListener() { // from class: com.adxcorp.ads.BannerAd.5
            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void onMediationLoaded(CustomEvent customEvent) {
                ADXLogUtil.d(BannerAd.TAG, BannerAd.this.mAdxUnitId + ":::onAdLoaded:::");
                if (customEvent != null && customEvent.getMediationData() != null) {
                    MediationSettings mediationSettings = customEvent.getMediationData().getMediationSettings();
                    if (mediationSettings != null) {
                        BannerAd.this.mResponseInterval = mediationSettings.getBannerRefreshInterval();
                        Preference.putLong(BannerAd.this.mContext, DataKeys.getKeyWithSlot("RESPONSE_INTERVAL", BannerAd.this.mAdxUnitId), BannerAd.this.mResponseInterval);
                    }
                    BannerAd.this.mNewsFeed = customEvent.getMediationData().getNewsFeed();
                }
                if (BannerAd.this.mIsDestroyed) {
                    return;
                }
                if (BannerAd.this.mIsNewsBanner) {
                    if (BannerAd.this.mNewsFeed == null) {
                        ADXLogUtil.d(BannerAd.TAG, "NewsFeed data is null!");
                        if (BannerAd.this.mBannerListener != null) {
                            BannerAd.this.mBannerListener.onAdError(108);
                            return;
                        }
                        return;
                    }
                    if (TextUtils.isEmpty(BannerAd.this.mNewsFeed.getTitle()) || TextUtils.isEmpty(BannerAd.this.mNewsFeed.getLink())) {
                        ADXLogUtil.d(BannerAd.TAG, "NewsFeed title or link is null!");
                        if (BannerAd.this.mBannerListener != null) {
                            BannerAd.this.mBannerListener.onAdError(108);
                            return;
                        }
                        return;
                    }
                }
                BannerAd.this.mCustomEvent = (BannerCustomEvent) customEvent;
                BannerAd bannerAd = BannerAd.this;
                bannerAd.addCustomEventView(bannerAd.mCustomEvent);
                if (BannerAd.this.mBannerListener != null) {
                    BannerAd.this.mBannerListener.onAdLoaded();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void onAdFailedToLoad(int i) {
                ADXLogUtil.d(BannerAd.TAG, BannerAd.this.mAdxUnitId + ":::onAdError:::" + i);
                if (i == 102) {
                    BannerAd.this.networkError();
                } else {
                    BannerAd.this.mNetworkErrorIdx = 0;
                    if (!TextUtils.isEmpty(BannerAd.this.mAdxUnitId) && BannerAd.this.mResponseInterval == 0) {
                        BannerAd bannerAd = BannerAd.this;
                        bannerAd.mResponseInterval = Preference.getLongValue(bannerAd.mContext, DataKeys.getKeyWithSlot("RESPONSE_INTERVAL", BannerAd.this.mAdxUnitId), 0L);
                    }
                    BannerAd.this.mIsAvailableNextAdRequest = true;
                    BannerAd bannerAd2 = BannerAd.this;
                    bannerAd2.setRefreshTime(bannerAd2.mResponseInterval);
                }
                if (BannerAd.this.mBannerListener != null) {
                    BannerAd.this.mBannerListener.onAdError(i);
                }
            }
        };
        this.mContext = context;
        this.mAdxUnitId = str;
        this.mBannerAdSize = banner_ad_size;
        init();
    }

    public BannerAd(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerAd(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInventoryType = ReportUtil.INVENTORY_TYPE_BANNER;
        this.mRefreshTime = 10000L;
        this.mAdEventListener = new AdEventListener() { // from class: com.adxcorp.ads.BannerAd.5
            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void onMediationLoaded(CustomEvent customEvent) {
                ADXLogUtil.d(BannerAd.TAG, BannerAd.this.mAdxUnitId + ":::onAdLoaded:::");
                if (customEvent != null && customEvent.getMediationData() != null) {
                    MediationSettings mediationSettings = customEvent.getMediationData().getMediationSettings();
                    if (mediationSettings != null) {
                        BannerAd.this.mResponseInterval = mediationSettings.getBannerRefreshInterval();
                        Preference.putLong(BannerAd.this.mContext, DataKeys.getKeyWithSlot("RESPONSE_INTERVAL", BannerAd.this.mAdxUnitId), BannerAd.this.mResponseInterval);
                    }
                    BannerAd.this.mNewsFeed = customEvent.getMediationData().getNewsFeed();
                }
                if (BannerAd.this.mIsDestroyed) {
                    return;
                }
                if (BannerAd.this.mIsNewsBanner) {
                    if (BannerAd.this.mNewsFeed == null) {
                        ADXLogUtil.d(BannerAd.TAG, "NewsFeed data is null!");
                        if (BannerAd.this.mBannerListener != null) {
                            BannerAd.this.mBannerListener.onAdError(108);
                            return;
                        }
                        return;
                    }
                    if (TextUtils.isEmpty(BannerAd.this.mNewsFeed.getTitle()) || TextUtils.isEmpty(BannerAd.this.mNewsFeed.getLink())) {
                        ADXLogUtil.d(BannerAd.TAG, "NewsFeed title or link is null!");
                        if (BannerAd.this.mBannerListener != null) {
                            BannerAd.this.mBannerListener.onAdError(108);
                            return;
                        }
                        return;
                    }
                }
                BannerAd.this.mCustomEvent = (BannerCustomEvent) customEvent;
                BannerAd bannerAd = BannerAd.this;
                bannerAd.addCustomEventView(bannerAd.mCustomEvent);
                if (BannerAd.this.mBannerListener != null) {
                    BannerAd.this.mBannerListener.onAdLoaded();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.AdEventListener
            public void onAdFailedToLoad(int i2) {
                ADXLogUtil.d(BannerAd.TAG, BannerAd.this.mAdxUnitId + ":::onAdError:::" + i2);
                if (i2 == 102) {
                    BannerAd.this.networkError();
                } else {
                    BannerAd.this.mNetworkErrorIdx = 0;
                    if (!TextUtils.isEmpty(BannerAd.this.mAdxUnitId) && BannerAd.this.mResponseInterval == 0) {
                        BannerAd bannerAd = BannerAd.this;
                        bannerAd.mResponseInterval = Preference.getLongValue(bannerAd.mContext, DataKeys.getKeyWithSlot("RESPONSE_INTERVAL", BannerAd.this.mAdxUnitId), 0L);
                    }
                    BannerAd.this.mIsAvailableNextAdRequest = true;
                    BannerAd bannerAd2 = BannerAd.this;
                    bannerAd2.setRefreshTime(bannerAd2.mResponseInterval);
                }
                if (BannerAd.this.mBannerListener != null) {
                    BannerAd.this.mBannerListener.onAdError(i2);
                }
            }
        };
        this.mContext = context;
        parsingAttribute(attributeSet);
        init();
    }

    public void setBannerListener(BannerListener bannerListener) {
        this.mBannerListener = bannerListener;
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.mOnPaidEventListener = onPaidEventListener;
    }

    public void setInRecyclerView(boolean z) {
        this.mInRecyclerView = z;
    }

    public void disableAutoRefresh() {
        this.mIsDisableAutoRefresh = true;
    }

    public void resumeAutoRefresh() {
        ADXLogUtil.d(TAG, "call resumeAutoRefresh()");
        this.mIsPauseAutoRefresh = false;
        stopReloadTimer();
        startReloadTimer();
    }

    public void pauseAutoRefresh() {
        ADXLogUtil.d(TAG, "call pauseAutoRefresh()");
        this.mIsPauseAutoRefresh = true;
        stopReloadTimer();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parsingAttribute(android.util.AttributeSet r8) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adxcorp.ads.BannerAd.parsingAttribute(android.util.AttributeSet):void");
    }

    private void init() {
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::init");
        if (isInEditMode()) {
            return;
        }
        this.mNetworkErrorIdx = 0;
        this.mIsAvailableNextAdRequest = false;
        this.mAdViewState = AdViewState.RESUME;
    }

    private void removeEventListener() {
        this.mAdEventListener = null;
        this.mOnPaidEventListener = null;
    }

    public void loadAd() {
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::loadAd:::");
        if (this.mIsDestroyed) {
            return;
        }
        this.mLoadedTime = new Date().getTime();
        if (!TextUtils.isEmpty(this.mAdxUnitId)) {
            this.mResponseInterval = Preference.getLongValue(this.mContext, DataKeys.getKeyWithSlot("RESPONSE_INTERVAL", this.mAdxUnitId), 0L);
        }
        if (this.mAdController == null) {
            this.mAdController = new AdController(this.mContext, this.mInventoryType, this.mAdEventListener);
        }
        this.mAdController.setBannerAdSize(this.mBannerAdSize);
        this.mAdController.setSlotID(this.mAdxUnitId);
        this.mAdController.loadAd(new BCustomEventListener() { // from class: com.adxcorp.ads.BannerAd.1
            @Override // com.adxcorp.ads.common.CustomEventListener
            public void onAdLoaded() {
                ADXLogUtil.d(BannerAd.TAG, "Something wrong. onAdLoaded callback should to not firing");
            }

            @Override // com.adxcorp.ads.common.CustomEventListener
            public void onAdError() {
                ADXLogUtil.d(BannerAd.TAG, "Something wrong. onAdError callback should to not firing");
            }

            @Override // com.adxcorp.ads.common.CustomEventListener
            public void onAdClicked() {
                ADXLogUtil.d(BannerAd.TAG, BannerAd.this.mAdxUnitId + ":::onAdClicked:::");
                if (BannerAd.this.mCustomEvent != null) {
                    if (BannerAd.this.mCustomEvent.getCustomEvent() != null) {
                        ReportUtil.sendMetric(BannerAd.this.mCustomEvent.getCustomEvent().getMediationData(), BannerAd.this.mInventoryType, "click");
                    } else {
                        ReportUtil.sendMetric(BannerAd.this.mCustomEvent.getMediationData(), BannerAd.this.mInventoryType, "click");
                    }
                }
                if (BannerAd.this.mBannerListener != null) {
                    BannerAd.this.mBannerListener.onAdClicked();
                }
            }

            @Override // com.adxcorp.ads.common.CustomEventListener
            public void onAdImpression() {
                ADXLogUtil.d(BannerAd.TAG, BannerAd.this.mAdxUnitId + ":::onAdImpression:::");
                if (BannerAd.this.mCustomEvent != null) {
                    if (BannerAd.this.mCustomEvent.getCustomEvent() != null) {
                        ReportUtil.sendMetric(BannerAd.this.mCustomEvent.getCustomEvent().getMediationData(), BannerAd.this.mInventoryType, "impression");
                    } else {
                        ReportUtil.sendMetric(BannerAd.this.mCustomEvent.getMediationData(), BannerAd.this.mInventoryType, "impression");
                    }
                }
            }

            @Override // com.adxcorp.ads.common.CustomEventListener
            public void onPaidEvent(double d) {
                ADXLogUtil.d(BannerAd.TAG, BannerAd.this.mAdxUnitId + ":::onPaidEvent:::" + d);
                if (BannerAd.this.mCustomEvent != null) {
                    if (BannerAd.this.mCustomEvent.getCustomEvent() != null) {
                        ReportUtil.sendPaidMetric(BannerAd.this.mCustomEvent.getCustomEvent().getMediationData(), BannerAd.this.mInventoryType, d);
                    } else {
                        ReportUtil.sendPaidMetric(BannerAd.this.mCustomEvent.getMediationData(), BannerAd.this.mInventoryType, d);
                    }
                }
                if (BannerAd.this.mOnPaidEventListener != null) {
                    BannerAd.this.mOnPaidEventListener.onPaidEvent(d);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pause() {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, this.mAdxUnitId + ":::pause");
        }
        this.mAdViewState = AdViewState.PAUSE;
        stopReloadTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resume() {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, this.mAdxUnitId + ":::resume");
        }
        AdViewState adViewState = this.mAdViewState;
        if (adViewState == null || !adViewState.isPause()) {
            return;
        }
        this.mAdViewState = AdViewState.RESUME;
        if (this.mLoadedTime > 0 && new Date().getTime() - this.mLoadedTime >= this.mRefreshTime) {
            loadAd();
        }
        stopReloadTimer();
        startReloadTimer();
    }

    private void release() {
        removeAllViews();
        pause();
        destroyCustomEvent(this.mNextAdContentView);
        this.mNextAdContentView = null;
        AdController adController = this.mAdController;
        if (adController != null) {
            adController.destroy();
            this.mAdController = null;
        }
        removeEventListener();
    }

    public void destroy() {
        this.mIsDestroyed = true;
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::destroy");
        try {
            release();
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::onAttachedToWindow");
        this.mIsAttachedToWindow = true;
        registerBroadcastReceiver();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::onDetachedFromWindow");
        this.mIsAttachedToWindow = false;
        unregisterBroadcastReceiver();
        if (!this.mInRecyclerView) {
            try {
                release();
            } catch (Exception e) {
                ADXLogUtil.e(TAG, e);
            }
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNextAd() {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "Preparing to load next ads.");
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.adxcorp.ads.BannerAd.2
            @Override // java.lang.Runnable
            public void run() {
                BannerAd.this.loadAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void networkError() {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "networkError");
        }
        stopReloadTimer();
        int i = this.mNetworkErrorIdx;
        if (i < 0 || i > Constants.NETWORK_INTERVAL.length - 1) {
            this.mNetworkErrorIdx = 0;
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "NetworkErrorIdx : " + this.mNetworkErrorIdx);
        }
        int[] iArr = Constants.NETWORK_INTERVAL;
        int i2 = this.mNetworkErrorIdx;
        long j = iArr[i2];
        this.mNetworkErrorIdx = i2 + 1;
        ADXLogUtil.d(TAG, "networkError setRefreshTime : " + j);
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
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "setRefreshTime : " + j + " -> " + this.mRefreshTime);
        }
        if (this.mAdViewState.isPause()) {
            stopReloadTimer();
        } else {
            stopReloadTimer();
            startReloadTimer();
        }
    }

    private void startReloadTimer() {
        String str = TAG;
        ADXLogUtil.d(str, "mIsDisableAutoRefresh : " + this.mIsDisableAutoRefresh + ", mIsPauseAutoRefresh : " + this.mIsPauseAutoRefresh + ", mIsAvailableNextAdRequest : " + this.mIsAvailableNextAdRequest);
        if (this.mIsDisableAutoRefresh || this.mIsPauseAutoRefresh || !this.mIsAvailableNextAdRequest) {
            return;
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(str, "startReloadTimer (mResponseInterval : " + this.mResponseInterval + ", mRefreshTime : " + this.mRefreshTime + ")");
        }
        if (this.mResponseInterval == 0 || this.mRefreshTime < 10000) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(str, "AdView refresh is disable.");
            }
        } else if (!this.mIsAttachedToWindow) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(str, "AdView not yet attached to window.");
            }
        } else {
            if (this.mReloadTimer == null) {
                this.mReloadTimer = new Timer();
            }
            this.mReloadTimer.schedule(new ReloadTask(), this.mRefreshTime);
        }
    }

    private void stopReloadTimer() {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "stopReloadTimer");
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
        if (i == 0) {
            this.mIsInForeground = true;
            resume();
        } else {
            this.mIsInForeground = false;
            pause();
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            String str = TAG;
            StringBuilder sb = new StringBuilder("AdView onWindowVisibilityChanged(");
            sb.append(i);
            sb.append("): ");
            sb.append(i == 0 ? "VISIBLE" : "INVISIBLE");
            ADXLogUtil.d(str, sb.toString());
        }
    }

    private boolean isDeviceInteractive() {
        try {
            return ((PowerManager) this.mContext.getSystemService("power")).isInteractive();
        } catch (Exception e) {
            if (!MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                return true;
            }
            ADXLogUtil.e(TAG, e);
            return true;
        }
    }

    private void registerBroadcastReceiver() {
        try {
            this.mScreenStateReceiver = new BroadcastReceiver() { // from class: com.adxcorp.ads.BannerAd.3
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(BannerAd.TAG, "Intent.ACTION_SCREEN_OFF : " + BannerAd.this.mIsInForeground);
                        }
                        if (BannerAd.this.mIsInForeground) {
                            BannerAd.this.pause();
                            return;
                        }
                        return;
                    }
                    if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(BannerAd.TAG, "Intent.ACTION_SCREEN_ON : " + BannerAd.this.mIsInForeground);
                        }
                        if (BannerAd.this.mIsInForeground) {
                            BannerAd.this.resume();
                            return;
                        }
                        return;
                    }
                    if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(BannerAd.TAG, "Intent.ACTION_USER_PRESENT : " + BannerAd.this.mIsInForeground);
                        }
                        if (BannerAd.this.mIsInForeground) {
                            BannerAd.this.resume();
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
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    private void unregisterBroadcastReceiver() {
        try {
            this.mContext.unregisterReceiver(this.mScreenStateReceiver);
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    protected void addCustomEventView(BannerCustomEvent bannerCustomEvent) {
        try {
            addView(bannerCustomEvent.getAdView());
            BannerCustomEvent bannerCustomEvent2 = this.mNextAdContentView;
            if (bannerCustomEvent2 != null) {
                bannerCustomEvent2.setVisibility(8);
                removeView(bannerCustomEvent2.getAdView());
                destroyCustomEvent(bannerCustomEvent2);
            }
            this.mNextAdContentView = bannerCustomEvent;
            if (bannerCustomEvent != null) {
                bannerCustomEvent.setVisibility(0);
                this.mNextAdContentView.impression();
            }
            this.mIsAvailableNextAdRequest = true;
            this.mNetworkErrorIdx = 0;
            setRefreshTime(this.mResponseInterval);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            BannerAd bannerAd = BannerAd.this;
            if (bannerAd != null) {
                bannerAd.loadNextAd();
            }
        }
    }

    protected void destroyCustomEvent(final BannerCustomEvent bannerCustomEvent) {
        try {
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new Runnable() { // from class: com.adxcorp.ads.BannerAd.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            BannerCustomEvent bannerCustomEvent2 = bannerCustomEvent;
                            if (bannerCustomEvent2 != null) {
                                bannerCustomEvent2.destroy();
                            }
                        } catch (Exception e) {
                            ADXLogUtil.e(BannerAd.TAG, e);
                        }
                    }
                });
            } else if (bannerCustomEvent != null) {
                bannerCustomEvent.destroy();
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }
}
