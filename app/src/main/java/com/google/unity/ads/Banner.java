package com.google.unity.ads;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes5.dex */
public class Banner {
    protected BaseAdView adView;
    protected boolean hidden;
    private int mHorizontalOffset;
    private View.OnLayoutChangeListener mLayoutChangeListener;
    private int mPositionCode;
    private int mVerticalOffset;
    protected UnityAdListener unityListener;
    protected Activity unityPlayerActivity;

    protected static class Insets {
        int top = 0;
        int bottom = 0;
        int left = 0;
        int right = 0;

        protected Insets() {
        }
    }

    protected Banner() {
    }

    public Banner(Activity activity, UnityAdListener listener) {
        this.unityPlayerActivity = activity;
        this.unityListener = listener;
    }

    public void create(final String publisherId, final AdSize adSize, final int positionCode) {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.1
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.createAdView(publisherId, adSize);
                this.this$0.mHorizontalOffset = 0;
                this.this$0.mVerticalOffset = 0;
                this.this$0.mPositionCode = positionCode;
                this.this$0.hidden = false;
            }
        });
    }

    public void create(final String publisherId, final AdSize adSize, final int positionX, final int positionY) {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.2
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.createAdView(publisherId, adSize);
                this.this$0.mPositionCode = -1;
                this.this$0.mHorizontalOffset = positionX;
                this.this$0.mVerticalOffset = positionY;
                this.this$0.hidden = false;
            }
        });
    }

    protected void createAdView(final String publisherId, final AdSize adSize) {
        AdView adView = new AdView(this.unityPlayerActivity);
        this.adView = adView;
        adView.setBackgroundColor(0);
        this.adView.setAdUnitId(publisherId);
        this.adView.setAdSize(adSize);
        this.adView.setVisibility(8);
        this.adView.setDescendantFocusability(393216);
        this.unityPlayerActivity.addContentView(this.adView, getLayoutParams());
        this.adView.setAdListener(new AdListener(this) { // from class: com.google.unity.ads.Banner.3
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                if (this.this$0.unityListener != null) {
                    if (!this.this$0.hidden) {
                        this.this$0.show();
                    }
                    new Thread(new Runnable(this) { // from class: com.google.unity.ads.Banner.3.1
                        final /* synthetic */ AnonymousClass3 this$1;

                        {
                            Objects.requireNonNull(this);
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (this.this$1.this$0.unityListener != null) {
                                this.this$1.this$0.unityListener.onAdLoaded();
                            }
                        }
                    }).start();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(final LoadAdError error) {
                if (this.this$0.unityListener != null) {
                    new Thread(new Runnable(this) { // from class: com.google.unity.ads.Banner.3.2
                        final /* synthetic */ AnonymousClass3 this$1;

                        {
                            Objects.requireNonNull(this);
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (this.this$1.this$0.unityListener != null) {
                                this.this$1.this$0.unityListener.onAdFailedToLoad(error);
                            }
                        }
                    }).start();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
                if (this.this$0.unityListener != null) {
                    new Thread(new Runnable(this) { // from class: com.google.unity.ads.Banner.3.3
                        final /* synthetic */ AnonymousClass3 this$1;

                        {
                            Objects.requireNonNull(this);
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (this.this$1.this$0.unityListener != null) {
                                this.this$1.this$0.unityListener.onAdOpened();
                            }
                        }
                    }).start();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                if (this.this$0.unityListener != null) {
                    new Thread(new Runnable(this) { // from class: com.google.unity.ads.Banner.3.4
                        final /* synthetic */ AnonymousClass3 this$1;

                        {
                            Objects.requireNonNull(this);
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (this.this$1.this$0.unityListener != null) {
                                this.this$1.this$0.unityListener.onAdClosed();
                            }
                        }
                    }).start();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdImpression() {
                if (this.this$0.unityListener != null) {
                    new Thread(new Runnable(this) { // from class: com.google.unity.ads.Banner.3.5
                        final /* synthetic */ AnonymousClass3 this$1;

                        {
                            Objects.requireNonNull(this);
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (this.this$1.this$0.unityListener != null) {
                                this.this$1.this$0.unityListener.onAdImpression();
                            }
                        }
                    }).start();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClicked() {
                if (this.this$0.unityListener != null) {
                    new Thread(new Runnable(this) { // from class: com.google.unity.ads.Banner.3.6
                        final /* synthetic */ AnonymousClass3 this$1;

                        {
                            Objects.requireNonNull(this);
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (this.this$1.this$0.unityListener != null) {
                                this.this$1.this$0.unityListener.onAdClicked();
                            }
                        }
                    }).start();
                }
            }
        });
        this.adView.setOnPaidEventListener(new OnPaidEventListener(this) { // from class: com.google.unity.ads.Banner.4
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            @Override // com.google.android.gms.ads.OnPaidEventListener
            public void onPaidEvent(final AdValue adValue) {
                if (this.this$0.unityListener != null) {
                    new Thread(new Runnable(this) { // from class: com.google.unity.ads.Banner.4.1
                        final /* synthetic */ AnonymousClass4 this$1;

                        {
                            Objects.requireNonNull(this);
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (this.this$1.this$0.unityListener != null) {
                                this.this$1.this$0.unityListener.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
                            }
                        }
                    }).start();
                }
            }
        });
        setLayoutChangeListener();
    }

    protected void setLayoutChangeListener() {
        this.mLayoutChangeListener = new View.OnLayoutChangeListener(this) { // from class: com.google.unity.ads.Banner.5
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if ((left == oldLeft && right == oldRight && bottom == oldBottom && top == oldTop) || this.this$0.hidden) {
                    return;
                }
                this.this$0.updatePosition();
            }
        };
        this.unityPlayerActivity.getWindow().getDecorView().getRootView().addOnLayoutChangeListener(this.mLayoutChangeListener);
    }

    public void loadAd(final AdRequest request) {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.6
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling loadAd() on Android");
                this.this$0.adView.loadAd(request);
            }
        });
    }

    public void show() {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.7
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling show() on Android");
                this.this$0.hidden = false;
                this.this$0.adView.setVisibility(0);
                this.this$0.updatePosition();
                this.this$0.adView.resume();
            }
        });
    }

    public void hide() {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.8
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling hide() on Android");
                this.this$0.hidden = true;
                this.this$0.adView.setVisibility(8);
                this.this$0.adView.pause();
            }
        });
    }

    public void destroy() {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.9
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(PluginUtils.LOGTAG, "Calling destroy() on Android");
                if (this.this$0.adView != null) {
                    this.this$0.adView.destroy();
                    ViewParent parent = this.this$0.adView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.this$0.adView);
                    }
                }
            }
        });
        this.unityPlayerActivity.getWindow().getDecorView().getRootView().removeOnLayoutChangeListener(this.mLayoutChangeListener);
    }

    public String getAdUnitId() {
        BaseAdView baseAdView = this.adView;
        if (baseAdView == null) {
            return null;
        }
        return baseAdView.getAdUnitId();
    }

    public float getHeightInPixels() {
        this.unityPlayerActivity.runOnUiThread(new FutureTask(new Callable<Integer>(this) { // from class: com.google.unity.ads.Banner.10
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                return Integer.valueOf(this.this$0.adView.getAdSize().getHeightInPixels(this.this$0.unityPlayerActivity));
            }
        }));
        try {
            return ((Integer) r2.get()).intValue();
        } catch (InterruptedException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Failed to get ad view height: %s", e.getLocalizedMessage()));
            return -1.0f;
        } catch (ExecutionException e2) {
            Log.e(PluginUtils.LOGTAG, String.format("Failed to get ad view height: %s", e2.getLocalizedMessage()));
            return -1.0f;
        }
    }

    public float getWidthInPixels() {
        this.unityPlayerActivity.runOnUiThread(new FutureTask(new Callable<Integer>(this) { // from class: com.google.unity.ads.Banner.11
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                return Integer.valueOf(this.this$0.adView.getAdSize().getWidthInPixels(this.this$0.unityPlayerActivity));
            }
        }));
        try {
            return ((Integer) r2.get()).intValue();
        } catch (InterruptedException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Failed to get ad view width: %s", e.getLocalizedMessage()));
            return -1.0f;
        } catch (ExecutionException e2) {
            Log.e(PluginUtils.LOGTAG, String.format("Failed to get ad view width: %s", e2.getLocalizedMessage()));
            return -1.0f;
        }
    }

    public void setPosition(final int positionCode) {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.12
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.mPositionCode = positionCode;
                this.this$0.updatePosition();
            }
        });
    }

    public void setPosition(final int positionX, final int positionY) {
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.13
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.mPositionCode = -1;
                this.this$0.mHorizontalOffset = positionX;
                this.this$0.mVerticalOffset = positionY;
                this.this$0.updatePosition();
            }
        });
    }

    public boolean isCollapsible() {
        BaseAdView baseAdView = this.adView;
        if (baseAdView == null) {
            return false;
        }
        return baseAdView.isCollapsible();
    }

    public long getPlacementId() {
        BaseAdView baseAdView = this.adView;
        if (baseAdView == null) {
            return 0L;
        }
        return baseAdView.getPlacementId();
    }

    public void setPlacementId(long placementId) {
        BaseAdView baseAdView = this.adView;
        if (baseAdView == null) {
            return;
        }
        baseAdView.setPlacementId(placementId);
    }

    public boolean isVisible() {
        BaseAdView baseAdView = this.adView;
        return baseAdView != null && baseAdView.getVisibility() == 0;
    }

    protected FrameLayout.LayoutParams getLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = PluginUtils.getLayoutGravityForPositionCode(this.mPositionCode);
        Insets safeInsets = getSafeInsets();
        int i = safeInsets.left;
        int i2 = safeInsets.top;
        layoutParams.bottomMargin = safeInsets.bottom;
        layoutParams.rightMargin = safeInsets.right;
        if (this.mPositionCode == -1) {
            int iConvertDpToPixel = (int) PluginUtils.convertDpToPixel(this.mHorizontalOffset);
            if (iConvertDpToPixel >= i) {
                i = iConvertDpToPixel;
            }
            int iConvertDpToPixel2 = (int) PluginUtils.convertDpToPixel(this.mVerticalOffset);
            if (iConvertDpToPixel2 >= i2) {
                i2 = iConvertDpToPixel2;
            }
            layoutParams.leftMargin = i;
            layoutParams.topMargin = i2;
        } else {
            layoutParams.leftMargin = i;
            int i3 = this.mPositionCode;
            if (i3 == 0 || i3 == 2 || i3 == 3) {
                layoutParams.topMargin = i2;
            }
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePosition() {
        if (this.adView == null || this.hidden) {
            return;
        }
        this.unityPlayerActivity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.Banner.14
            final /* synthetic */ Banner this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.adView.setLayoutParams(this.this$0.getLayoutParams());
            }
        });
    }

    private Insets getSafeInsets() {
        Window window;
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        Insets insets = new Insets();
        if (Build.VERSION.SDK_INT < 28 || (window = this.unityPlayerActivity.getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
            return insets;
        }
        insets.top = displayCutout.getSafeInsetTop();
        insets.left = displayCutout.getSafeInsetLeft();
        insets.bottom = displayCutout.getSafeInsetBottom();
        insets.right = displayCutout.getSafeInsetRight();
        return insets;
    }

    public ResponseInfo getResponseInfo() {
        BaseAdView baseAdView = this.adView;
        if (baseAdView == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to get response info before it was ready. Returning null.");
            return null;
        }
        return baseAdView.getResponseInfo();
    }
}
