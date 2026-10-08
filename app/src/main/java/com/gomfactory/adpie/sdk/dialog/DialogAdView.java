package com.gomfactory.adpie.sdk.dialog;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.TargetingData;
import com.gomfactory.adpie.sdk.common.AdData;
import com.gomfactory.adpie.sdk.common.AdResponse;
import com.gomfactory.adpie.sdk.controller.AdController;
import com.gomfactory.adpie.sdk.event.AdEventListener;
import com.gomfactory.adpie.sdk.ui.AdContentView;
import com.gomfactory.adpie.sdk.ui.progressbar.SpinningLoaderView;
import com.gomfactory.adpie.sdk.ui.webview.AdWebView;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.DisplayUtil;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: classes3.dex */
public class DialogAdView extends FrameLayout {
    public static final String TAG = "DialogAdView";
    private AdData adData;
    private Thread adThread;
    private boolean initialized;
    private FrameLayout mAdContainer;
    private AdController mAdController;
    private AdEventListener mAdEventListener;
    private AdListener mAdListener;
    private AdWebView mAdWebView;
    private Context mContext;
    private DialogState mDialogState;
    private final Handler mHandler;
    private SpinningLoaderView mProgressbar;
    private String mSlotId;
    private TargetingData mTargetingData;

    public interface AdListener {
        void onAdClicked();

        void onAdFailedToLoad(int i);

        void onAdLoaded();

        void onAdShown();
    }

    public DialogAdView(Context context, String str) {
        super(context);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mContext = context;
        this.mAdListener = null;
        this.mSlotId = str;
        this.mDialogState = DialogState.NOT_READY;
        init();
    }

    public AdListener getAdListener() {
        return this.mAdListener;
    }

    public void setAdListener(AdListener adListener) {
        this.mAdListener = adListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        AdPieLog.d(TAG, this.mSlotId + ":::init");
        addEventListener();
        this.mAdController = new AdController(this.mContext, this.mAdEventListener);
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.mAdContainer = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView(this.mAdContainer);
        this.mProgressbar = new SpinningLoaderView(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 48), DisplayUtil.dpToPx(this.mContext, 48));
        layoutParams.gravity = 17;
        this.mProgressbar.setLayoutParams(layoutParams);
        this.mProgressbar.setVisibility(8);
        addView(this.mProgressbar);
        this.initialized = true;
    }

    private void addEventListener() {
        this.mAdEventListener = new AdEventListener() { // from class: com.gomfactory.adpie.sdk.dialog.DialogAdView.1
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
                AdPieLog.d(DialogAdView.TAG, DialogAdView.this.mSlotId + ":::receivedResponse");
                if (adResponse != null) {
                    try {
                        int result = adResponse.getResult();
                        if (result == 0) {
                            if (adResponse.getCount() != 1) {
                                if (DialogAdView.this.mAdEventListener != null) {
                                    DialogAdView.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            } else {
                                DialogAdView.this.adData = adResponse.getAdData();
                                if (DialogAdView.this.adData != null) {
                                    if (DialogAdView.this.adData.getIcType() == 11) {
                                        String admImageTag = DialogAdView.this.adData.getAdmImageTag();
                                        if (!TextUtils.isEmpty(admImageTag)) {
                                            DialogAdView.this.preloadHtml(admImageTag);
                                        } else {
                                            DialogAdView.this.preloadHtml("");
                                        }
                                    } else {
                                        AdPieLog.i(DialogAdView.TAG, "'" + DialogAdView.this.adData.getIcType() + "' inventory and contentType are not matched.");
                                        if (DialogAdView.this.mAdEventListener != null) {
                                            DialogAdView.this.mAdEventListener.notifyAdFailedToLoad(108);
                                        }
                                    }
                                } else if (DialogAdView.this.mAdEventListener != null) {
                                    DialogAdView.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            }
                        } else if (result == 204) {
                            if (DialogAdView.this.mAdEventListener != null) {
                                DialogAdView.this.mAdEventListener.notifyAdFailedToLoad(100);
                            }
                        } else if (DialogAdView.this.mAdEventListener != null) {
                            DialogAdView.this.mAdEventListener.notifyAdFailedToLoad(101);
                        }
                    } catch (Exception e) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.e(DialogAdView.TAG, e);
                        }
                        notifyAdFailedToLoad(104);
                    }
                }
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdLoaded(Object... objArr) {
                DialogAdView.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.dialog.DialogAdView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(DialogAdView.TAG, DialogAdView.this.mSlotId + ":::notifyAdLoaded");
                        if (DialogAdView.this.mAdListener != null) {
                            DialogAdView.this.mAdListener.onAdLoaded();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdFailedToLoad(final int i) {
                DialogAdView.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.dialog.DialogAdView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(DialogAdView.TAG, DialogAdView.this.mSlotId + ":::notifyAdFailedToLoad:::" + i);
                        DialogAdView.this.mDialogState = DialogState.NOT_READY;
                        DialogAdView.this.adData = null;
                        if (DialogAdView.this.mAdListener != null) {
                            DialogAdView.this.mAdListener.onAdFailedToLoad(i);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdShown() {
                DialogAdView.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.dialog.DialogAdView.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(DialogAdView.TAG, DialogAdView.this.mSlotId + ":::notifyAdShown");
                        DialogAdView.this.mDialogState = DialogState.SHOW;
                        if (DialogAdView.this.mAdListener != null) {
                            DialogAdView.this.mAdListener.onAdShown();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdDismissed() {
                DialogAdView.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.dialog.DialogAdView.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(DialogAdView.TAG, DialogAdView.this.mSlotId + ":::notifyAdDismissed");
                        DialogAdView.this.mDialogState = DialogState.NOT_READY;
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdClicked() {
                DialogAdView.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.dialog.DialogAdView.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(DialogAdView.TAG, DialogAdView.this.mSlotId + ":::notifyAdClicked");
                        if (DialogAdView.this.mAdListener != null) {
                            DialogAdView.this.mAdListener.onAdClicked();
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
            if (this.adThread == null) {
                Thread thread = new Thread(new Runnable() { // from class: com.gomfactory.adpie.sdk.dialog.DialogAdView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(DialogAdView.TAG, DialogAdView.this.mSlotId + ":::load");
                        DialogAdView.this.mDialogState = DialogState.NOT_READY;
                        DialogAdView.this.adData = null;
                        if (!DialogAdView.this.initialized) {
                            DialogAdView.this.init();
                        }
                        try {
                            DialogAdView.this.mAdController.setSlotID(DialogAdView.this.mSlotId);
                            DialogAdView.this.mAdController.setTargetingData(DialogAdView.this.mTargetingData);
                            DialogAdView.this.mAdController.loadAd();
                        } catch (Exception e) {
                            AdPieLog.e(DialogAdView.TAG, e);
                            if (DialogAdView.this.mAdEventListener != null) {
                                DialogAdView.this.mAdEventListener.notifyAdFailedToLoad(104);
                            }
                        }
                        DialogAdView.this.adThread = null;
                    }
                });
                this.adThread = thread;
                thread.start();
            } else {
                AdPieLog.d(TAG, "AdPie (" + this.mSlotId + ") is already loading an ad. Wait for previous load to finish.");
                AdEventListener adEventListener = this.mAdEventListener;
                if (adEventListener != null) {
                    adEventListener.notifyAdFailedToLoad(106);
                }
            }
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
    public void preloadHtml(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mDialogState = DialogState.READY;
            AdEventListener adEventListener = this.mAdEventListener;
            if (adEventListener != null) {
                adEventListener.notifyAdLoaded(new Object[0]);
                return;
            }
            return;
        }
        String str2 = TAG;
        AdPieLog.d(str2, this.mSlotId + ":::preloadHtml - " + str);
        AdWebView adWebView = this.mAdWebView;
        if (adWebView != null) {
            adWebView.setWebViewEventListener(null);
            this.mAdWebView.destroy();
            this.mAdWebView = null;
        }
        AdWebView adWebView2 = new AdWebView(this.mContext);
        this.mAdWebView = adWebView2;
        adWebView2.setWebViewEventListener(new AdWebView.WebViewEventListener() { // from class: com.gomfactory.adpie.sdk.dialog.DialogAdView.3
            @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewEventListener
            public void onUserClick(String str3) {
            }

            @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewEventListener
            public void onPageFinished() {
                DialogAdView.this.mDialogState = DialogState.READY;
                if (DialogAdView.this.mAdEventListener != null) {
                    DialogAdView.this.mAdEventListener.notifyAdLoaded(new Object[0]);
                }
            }

            @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewEventListener
            public void onPageDelayed() {
                DialogAdView.this.mDialogState = DialogState.NOT_READY;
                DialogAdView.this.adData = null;
                if (DialogAdView.this.mAdWebView != null) {
                    DialogAdView.this.mAdWebView.setWebViewEventListener(null);
                    DialogAdView.this.mAdWebView.destroy();
                    DialogAdView.this.mAdWebView = null;
                }
                if (DialogAdView.this.mAdEventListener != null) {
                    DialogAdView.this.mAdEventListener.notifyAdFailedToLoad(107);
                }
            }
        });
        AdPieLog.d(str2, this.mSlotId + ":::AdWebView-loadData");
        this.mAdWebView.loadData(str, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public boolean show() {
        AdData adData;
        String str = TAG;
        AdPieLog.d(str, this.mSlotId + ":::show:::" + AdPieSDK.getInstance().getNetworkConnectionType() + "," + Build.VERSION.SDK_INT);
        try {
            if (AdPieSDK.getInstance().getNetworkConnectionType() != 0) {
                if (this.mDialogState.isReady() && (adData = this.adData) != null) {
                    if (adData.getIcType() == 11) {
                        showAdContent(this.adData);
                        return true;
                    }
                    AdPieLog.i(str, ":::show:::'" + this.adData.getIcType() + "' inventory and contentType are not matched.");
                    return false;
                }
                if (this.adData == null) {
                    AdPieLog.i(str, this.mSlotId + ":::show:::Ads data cannot be null.");
                    return false;
                }
                AdPieLog.i(str, this.mSlotId + ":::show:::InterstitialState is not ready.");
                return false;
            }
            AdPieLog.i(str, this.mSlotId + ":::show:::Check your internet connection.");
            return false;
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
            return false;
        }
    }

    public boolean isLoaded() {
        return this.mDialogState.isReady();
    }

    public void destroy() {
        AdPieLog.d(TAG, this.mSlotId + ":::destroy");
        AdController adController = this.mAdController;
        if (adController != null) {
            adController.destroy();
            this.mAdController = null;
        }
        removeEventListener();
        Thread thread = this.adThread;
        if (thread != null) {
            thread.interrupt();
            this.adThread = null;
        }
        AdWebView adWebView = this.mAdWebView;
        if (adWebView != null) {
            adWebView.setWebViewEventListener(null);
            this.mAdWebView.destroy();
            this.mAdWebView = null;
        }
    }

    private void showAdContent(AdData adData) {
        SpinningLoaderView spinningLoaderView = this.mProgressbar;
        if (spinningLoaderView != null) {
            spinningLoaderView.setVisibility(0);
        }
        String str = TAG;
        AdPieLog.d(str, this.mSlotId + ":::showAdContent - start");
        if (AdPieSDK.getInstance().getNetworkConnectionType() == 0) {
            AdEventListener adEventListener = this.mAdEventListener;
            if (adEventListener != null) {
                adEventListener.notifyAdFailedToLoad(103);
                return;
            }
            return;
        }
        this.mAdContainer.removeAllViews();
        AdContentView adContentView = new AdContentView(this.mContext, new AdContentView.AdContentEventListener() { // from class: com.gomfactory.adpie.sdk.dialog.DialogAdView.4
            private boolean isViewLoaded;

            @Override // com.gomfactory.adpie.sdk.ui.AdContentView.AdContentEventListener
            public void onViewClicked(String str2) {
            }

            @Override // com.gomfactory.adpie.sdk.ui.AdContentView.AdContentEventListener
            public void onViewLoaded(AdContentView adContentView2) {
                AdPieLog.d(DialogAdView.TAG, DialogAdView.this.mSlotId + ":::onViewLoaded");
                if (DialogAdView.this.mProgressbar != null) {
                    DialogAdView.this.mProgressbar.setVisibility(8);
                }
                adContentView2.setVisibility(0);
                if (this.isViewLoaded) {
                    return;
                }
                this.isViewLoaded = true;
                try {
                    if (DialogAdView.this.mAdEventListener != null) {
                        DialogAdView.this.mAdEventListener.notifyAdShown();
                    }
                } catch (Exception e) {
                    AdPieLog.e(DialogAdView.TAG, e);
                    if (DialogAdView.this.mAdEventListener != null) {
                        DialogAdView.this.mAdEventListener.notifyAdFailedToLoad(104);
                    }
                }
            }

            @Override // com.gomfactory.adpie.sdk.ui.AdContentView.AdContentEventListener
            public void onViewLoadTimeout(AdContentView adContentView2) {
                AdPieLog.d(DialogAdView.TAG, DialogAdView.this.mSlotId + ":::onViewLoadTimeout");
                if (DialogAdView.this.mProgressbar != null) {
                    DialogAdView.this.mProgressbar.setVisibility(8);
                }
                if (adContentView2 != null) {
                    try {
                        DialogAdView.this.removeView(adContentView2);
                        adContentView2.onDestroy();
                    } catch (Exception e) {
                        AdPieLog.e(DialogAdView.TAG, e);
                    }
                }
                if (DialogAdView.this.mAdEventListener != null) {
                    DialogAdView.this.mAdEventListener.notifyAdFailedToLoad(107);
                }
            }

            @Override // com.gomfactory.adpie.sdk.ui.AdContentView.AdContentEventListener
            public void onViewClicked() {
                AdPieLog.d(DialogAdView.TAG, DialogAdView.this.mSlotId + ":::onViewClicked");
                if (DialogAdView.this.mAdEventListener != null) {
                    DialogAdView.this.mAdEventListener.notifyAdClicked();
                }
            }
        });
        adContentView.setVisibility(4);
        this.mAdContainer.addView(adContentView);
        adContentView.setAdData(adData);
        adContentView.showContent();
        AdPieLog.d(str, this.mSlotId + ":::showAdContent - end");
    }

    private enum DialogState {
        NOT_READY,
        READY,
        SHOW;

        boolean isReady() {
            return this == READY;
        }
    }
}
