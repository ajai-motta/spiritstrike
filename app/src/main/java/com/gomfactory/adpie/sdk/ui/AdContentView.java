package com.gomfactory.adpie.sdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.common.AdData;
import com.gomfactory.adpie.sdk.ui.webview.AdWebView;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.ClickThroughUtil;
import com.gomfactory.adpie.sdk.util.DisplayUtil;
import com.gomfactory.adpie.sdk.util.HttpUtil;
import com.gomfactory.adpie.sdk.util.ReportUtil;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class AdContentView extends RelativeLayout {
    public static final String TAG = "AdContentView";
    private AdContentEventListener mAdContentEventListener;
    private AdWebView mAdWebView;
    private Context mContext;
    private String mHtmlData;
    private int mIcType;
    private boolean mIsSkipLandingUrl;
    private boolean mIsWebViewLanding;
    private ArrayList<String> mTrackingClkUrls;
    private ArrayList<String> mTrackingImpUrls;

    public interface AdContentEventListener {
        void onViewClicked();

        void onViewClicked(String str);

        void onViewLoadTimeout(AdContentView adContentView);

        void onViewLoaded(AdContentView adContentView);
    }

    public AdContentView(Context context, AdContentEventListener adContentEventListener) {
        super(context);
        this.mContext = context;
        this.mAdContentEventListener = adContentEventListener;
        init();
    }

    private void init() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mAdWebView = new AdWebView(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2));
        layoutParams.addRule(15);
        layoutParams.addRule(14);
        this.mAdWebView.setLayoutParams(layoutParams);
        addView(this.mAdWebView);
        this.mAdWebView.setWebViewEventListener(new AdWebView.WebViewEventListener() { // from class: com.gomfactory.adpie.sdk.ui.AdContentView.1
            @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewEventListener
            public void onPageFinished() {
                ReportUtil.sendReport("WEBVIEW_IMPRESSION_TAG", (ArrayList<String>) AdContentView.this.mTrackingImpUrls);
                if (AdContentView.this.mAdContentEventListener != null) {
                    AdContentView.this.mAdContentEventListener.onViewLoaded(AdContentView.this);
                }
            }

            @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewEventListener
            public void onPageDelayed() {
                if (AdContentView.this.mAdWebView != null) {
                    AdContentView.this.mAdWebView.setWebViewEventListener(null);
                    AdContentView.this.mAdWebView.destroy();
                    AdContentView.this.mAdWebView = null;
                }
                if (AdContentView.this.mAdContentEventListener != null) {
                    AdContentView.this.mAdContentEventListener.onViewLoadTimeout(AdContentView.this);
                }
            }

            @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewEventListener
            public void onUserClick(final String str) {
                if (!ClickThroughUtil.isValidClick()) {
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(AdContentView.TAG, ":::clickEvent::: " + str + " -> block");
                        return;
                    }
                    return;
                }
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(AdContentView.TAG, ":::clickEvent::: " + str + " -> isSkipLandingUrl : " + AdContentView.this.mIsSkipLandingUrl + ", isWebViewLanding : " + AdContentView.this.mIsWebViewLanding);
                }
                if (!AdContentView.this.mIsSkipLandingUrl) {
                    try {
                        if (!AdContentView.this.mIsWebViewLanding) {
                            if (ClickThroughUtil.goToBrowser(AdContentView.this.mContext, str) && !str.contains("newspub.kr")) {
                                ReportUtil.sendReport("WEBVIEW_CLICK_TAG", (ArrayList<String>) AdContentView.this.mTrackingClkUrls);
                            }
                        } else {
                            HttpUtil.getFinalURL(str, new Handler(Looper.getMainLooper()) { // from class: com.gomfactory.adpie.sdk.ui.AdContentView.1.1
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    if (message.what != 100) {
                                        return;
                                    }
                                    try {
                                        if (!ClickThroughUtil.goToWebView(AdContentView.this.mContext, (String) message.obj)) {
                                            if (ClickThroughUtil.goToBrowser(AdContentView.this.mContext, (String) message.obj) && !str.contains("newspub.kr")) {
                                                ReportUtil.sendReport("WEBVIEW_CLICK_TAG", (ArrayList<String>) AdContentView.this.mTrackingClkUrls);
                                            }
                                        } else if (!str.contains("newspub.kr")) {
                                            ReportUtil.sendReport("WEBVIEW_CLICK_TAG", (ArrayList<String>) AdContentView.this.mTrackingClkUrls);
                                        }
                                    } catch (Exception e) {
                                        AdPieLog.e(AdContentView.TAG, e);
                                    }
                                }
                            });
                        }
                    } catch (Exception e) {
                        AdPieLog.e(AdContentView.TAG, e);
                    }
                    if (AdContentView.this.mAdContentEventListener != null) {
                        AdContentView.this.mAdContentEventListener.onViewClicked();
                        return;
                    }
                    return;
                }
                ReportUtil.sendReport("WEBVIEW_CLICK_TAG", (ArrayList<String>) AdContentView.this.mTrackingClkUrls);
                if (AdContentView.this.mAdContentEventListener != null) {
                    AdContentView.this.mAdContentEventListener.onViewClicked(str);
                }
            }
        });
    }

    public void showContent() {
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, this.mHtmlData);
        }
        if (this.mAdWebView != null && !TextUtils.isEmpty(this.mHtmlData)) {
            if (this.mIcType == 11) {
                this.mAdWebView.loadData(this.mHtmlData, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                return;
            } else {
                this.mAdWebView.loadData(this.mHtmlData, 0L);
                return;
            }
        }
        AdContentEventListener adContentEventListener = this.mAdContentEventListener;
        if (adContentEventListener != null) {
            adContentEventListener.onViewLoadTimeout(this);
        }
    }

    public void setAdData(AdData adData) {
        try {
            this.mIcType = adData.getIcType();
            this.mHtmlData = adData.getAdm();
            this.mIsWebViewLanding = adData.getWebviewLanding() == 1;
            this.mTrackingImpUrls = adData.getTrackingImpUrls();
            this.mTrackingClkUrls = adData.getTrackingClkUrls();
            String bgColor = adData.getBgColor();
            if (!TextUtils.isEmpty(bgColor)) {
                try {
                    setBackgroundColor(Color.parseColor(bgColor));
                } catch (Exception unused) {
                }
            }
            int position = adData.getPosition();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(new ViewGroup.LayoutParams(DisplayUtil.dpToPx(this.mContext, adData.getContentWidth()), DisplayUtil.dpToPx(this.mContext, adData.getContentHeight())));
            if (position == 1) {
                layoutParams.addRule(14);
                layoutParams.addRule(10);
            } else if (position != 2 && position == 3) {
                layoutParams.addRule(14);
                layoutParams.addRule(12);
            } else {
                layoutParams.addRule(13);
            }
            this.mAdWebView.setLayoutParams(layoutParams);
            this.mAdWebView.setMonitoring(adData.getMonitoring());
            this.mAdWebView.setWebviewLoadingSkip(adData.getWebviewLoadingSkip());
        } catch (Exception unused2) {
        }
    }

    public void setScale(float f) {
        try {
            this.mAdWebView.setScaleX(f);
            this.mAdWebView.setScaleY(f);
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }

    public void setSkipLandingUrl(boolean z) {
        this.mIsSkipLandingUrl = z;
    }

    public void onPause() {
        if (this.mAdWebView != null) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "AdWebView onPause");
            }
            this.mAdWebView.onPause();
        }
    }

    public void onResume() {
        if (this.mAdWebView != null) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "AdWebView onResume");
            }
            this.mAdWebView.onResume();
        }
    }

    public void onDestroy() {
        removeAllViews();
        if (this.mAdWebView != null) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "AdWebView onDestroy");
            }
            this.mAdWebView.setWebViewEventListener(null);
            this.mAdWebView.destroy();
            this.mAdWebView = null;
        }
    }

    public void drawBackgroundColor(boolean z) {
        AdContentEventListener adContentEventListener;
        try {
            this.mAdWebView.buildDrawingCache();
            Bitmap drawingCache = this.mAdWebView.getDrawingCache();
            String str = TAG;
            AdPieLog.d(str, "drawingCache : " + drawingCache);
            if (drawingCache != null) {
                int pixel = drawingCache.getPixel(1, 1);
                AdPieLog.d(str, "pixel : " + pixel);
                if (pixel != 0) {
                    setBackgroundColor(pixel);
                    setClickable(false);
                }
            }
            if (!z || (adContentEventListener = this.mAdContentEventListener) == null) {
                return;
            }
            adContentEventListener.onViewLoaded(this);
        } catch (Exception unused) {
        }
    }
}
