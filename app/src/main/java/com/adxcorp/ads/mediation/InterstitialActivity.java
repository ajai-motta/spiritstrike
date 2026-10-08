package com.adxcorp.ads.mediation;

import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import com.adxcorp.ads.mediation.ui.AdContentView;
import com.adxcorp.ads.mediation.ui.InterstitialBaseActivity;
import com.adxcorp.ads.mediation.ui.progressbar.CircularProgressBar;
import com.adxcorp.ads.mediation.ui.progressbar.SpinningLoaderView;
import com.adxcorp.ads.mediation.util.DisplayUtil;
import com.adxcorp.util.ADXLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialActivity extends InterstitialBaseActivity {
    public static final String TAG = "InterstitialActivity";
    private AdContentView mAdContentView;
    private CircularProgressBar mCircularProgressBar;
    private ImageView mCloseButton;
    private long mCloseButtonDelay;
    private int mCloseButtonPosition;
    private FrameLayout mContainer;
    private int mDuration;
    private int mProgress;
    private SpinningLoaderView mProgressBar;
    private TextView mTimerTextView;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private float mScale = 1.0f;
    private boolean mIsBlockBackButton = true;
    private Runnable updateTimeRunnable = new Runnable() { // from class: com.adxcorp.ads.mediation.InterstitialActivity.1
        @Override // java.lang.Runnable
        public void run() {
            InterstitialActivity.access$012(InterstitialActivity.this, 1);
            if (InterstitialActivity.this.mCircularProgressBar != null) {
                InterstitialActivity.this.mCircularProgressBar.setProgress(InterstitialActivity.this.mProgress);
                InterstitialActivity.this.mCircularProgressBar.setVisibility(0);
            }
            if (InterstitialActivity.this.mTimerTextView != null) {
                int i = InterstitialActivity.this.mDuration - InterstitialActivity.this.mProgress;
                InterstitialActivity.this.mTimerTextView.setText(i + "");
                InterstitialActivity.this.mTimerTextView.setVisibility(0);
            }
            if (InterstitialActivity.this.mProgress >= InterstitialActivity.this.mDuration) {
                if (InterstitialActivity.this.mCircularProgressBar != null) {
                    InterstitialActivity.this.mCircularProgressBar.setVisibility(8);
                }
                if (InterstitialActivity.this.mTimerTextView != null) {
                    InterstitialActivity.this.mTimerTextView.setVisibility(8);
                }
                if (InterstitialActivity.this.mCloseButton != null) {
                    InterstitialActivity.this.mCloseButton.setVisibility(0);
                    return;
                }
                return;
            }
            if (InterstitialActivity.this.mHandler != null) {
                InterstitialActivity.this.mHandler.postDelayed(InterstitialActivity.this.updateTimeRunnable, 1000L);
            }
        }
    };

    static /* synthetic */ int access$012(InterstitialActivity interstitialActivity, int i) {
        int i2 = interstitialActivity.mProgress + i;
        interstitialActivity.mProgress = i2;
        return i2;
    }

    @Override // com.adxcorp.ads.mediation.ui.InterstitialBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (this.mAdData.getOrientation() == 2) {
                setRequestedOrientation(6);
            } else {
                setRequestedOrientation(1);
            }
            setupContainer();
            setupAdView();
            setupCloseButton();
            setupCircleProgressBar();
            setupProgressBar();
            this.mContainer.setVisibility(0);
            this.mCloseButtonPosition = 2;
            if (DisplayUtil.isTarget36AndLargeScreen(this) && Build.VERSION.SDK_INT >= 36) {
                scaleAdViewLV16();
                changeCloseBtnPositionLV16();
            } else {
                scaleAdView();
                changeCloseBtnPosition();
            }
            this.mAdContentView.setAdData(this.mAdData);
            this.mAdContentView.showContent();
            long closeButtonDelay = this.mAdData.getCloseButtonDelay();
            this.mCloseButtonDelay = closeButtonDelay;
            if (closeButtonDelay >= 3000 && closeButtonDelay <= 60000) {
                this.mDuration = (int) (closeButtonDelay / 1000);
                CircularProgressBar circularProgressBar = this.mCircularProgressBar;
                if (circularProgressBar != null) {
                    circularProgressBar.setVisibility(0);
                    this.mCircularProgressBar.setProgressMax(this.mDuration);
                    this.mCircularProgressBar.setProgress(0.0f);
                    TextView textView = this.mTimerTextView;
                    if (textView != null) {
                        textView.setText(this.mDuration + "");
                        this.mTimerTextView.setVisibility(0);
                    }
                    this.mHandler.postDelayed(this.updateTimeRunnable, 1000L);
                } else {
                    ImageView imageView = this.mCloseButton;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                }
            } else if (closeButtonDelay > 0 && closeButtonDelay < 3000) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.adxcorp.ads.mediation.InterstitialActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InterstitialActivity.this.mCloseButton != null) {
                            InterstitialActivity.this.mCloseButton.setVisibility(0);
                        }
                    }
                }, this.mCloseButtonDelay);
            } else {
                ImageView imageView2 = this.mCloseButton;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            finish();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.adxcorp.ads.mediation.InterstitialActivity.3
            @Override // java.lang.Runnable
            public void run() {
                InterstitialActivity.this.mIsBlockBackButton = false;
            }
        }, 1000L);
        addBackKeyCallback();
    }

    @Override // com.adxcorp.ads.mediation.ui.InterstitialBaseActivity, android.app.Activity
    protected void onPause() {
        AdContentView adContentView = this.mAdContentView;
        if (adContentView != null) {
            adContentView.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        AdContentView adContentView = this.mAdContentView;
        if (adContentView != null) {
            adContentView.onResume();
        }
    }

    @Override // com.adxcorp.ads.mediation.ui.InterstitialBaseActivity, android.app.Activity
    protected void onDestroy() {
        SpinningLoaderView spinningLoaderView = this.mProgressBar;
        if (spinningLoaderView != null) {
            spinningLoaderView.setVisibility(8);
            this.mProgressBar = null;
        }
        AdContentView adContentView = this.mAdContentView;
        if (adContentView != null) {
            adContentView.setVisibility(8);
            this.mAdContentView.onDestroy();
            this.mAdContentView = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mAdData.getBackButtonEnabled() == 0 || this.mIsBlockBackButton) {
                return true;
            }
            ImageView imageView = this.mCloseButton;
            if (imageView == null || imageView.getVisibility() == 0) {
                finish();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void setupContainer() {
        FrameLayout frameLayout = new FrameLayout(this);
        this.mContainer = frameLayout;
        frameLayout.setVisibility(4);
        this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addContentView(this.mContainer, new ViewGroup.LayoutParams(-1, -1));
    }

    private void setupAdView() {
        AdContentView adContentView = new AdContentView(this, new AdContentView.AdContentEventListener() { // from class: com.adxcorp.ads.mediation.InterstitialActivity.4
            private boolean isViewLoaded;

            @Override // com.adxcorp.ads.mediation.ui.AdContentView.AdContentEventListener
            public void onViewClicked(String str) {
            }

            @Override // com.adxcorp.ads.mediation.ui.AdContentView.AdContentEventListener
            public void onViewLoaded(AdContentView adContentView2) {
                ADXLogUtil.d(InterstitialActivity.TAG, InterstitialActivity.this.mSlotId + ":::onViewLoaded");
                if (InterstitialActivity.this.mProgressBar != null) {
                    InterstitialActivity.this.mProgressBar.setVisibility(8);
                }
                if (!this.isViewLoaded) {
                    this.isViewLoaded = true;
                    InterstitialActivity.this.notifyShown();
                }
                if (adContentView2 != null) {
                    adContentView2.setVisibility(0);
                }
            }

            @Override // com.adxcorp.ads.mediation.ui.AdContentView.AdContentEventListener
            public void onViewLoadTimeout(AdContentView adContentView2) {
                ADXLogUtil.d(InterstitialActivity.TAG, InterstitialActivity.this.mSlotId + ":::onViewLoadTimeout");
                InterstitialActivity.this.finish();
            }

            @Override // com.adxcorp.ads.mediation.ui.AdContentView.AdContentEventListener
            public void onViewClicked() {
                ADXLogUtil.d(InterstitialActivity.TAG, InterstitialActivity.this.mSlotId + ":::onViewClicked");
                InterstitialActivity.this.notifyClick();
            }
        });
        this.mAdContentView = adContentView;
        adContentView.setVisibility(0);
        this.mContainer.addView(this.mAdContentView);
    }

    private void setupProgressBar() {
        this.mProgressBar = new SpinningLoaderView(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dpToPx(this, 48), DisplayUtil.dpToPx(this, 48));
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setVisibility(0);
        this.mContainer.addView(this.mProgressBar, 0);
    }

    private void setupCloseButton() {
        this.mCloseButton = new ImageView(this);
        try {
            byte[] bArrDecode = Base64.decode("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", 0);
            this.mCloseButton.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
        this.mContainer.addView(this.mCloseButton);
        this.mCloseButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.adxcorp.ads.mediation.InterstitialActivity.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterstitialActivity.this.finish();
                return true;
            }
        });
        this.mCloseButton.setVisibility(8);
    }

    private void setupCircleProgressBar() {
        CircularProgressBar circularProgressBar = new CircularProgressBar(this, null);
        this.mCircularProgressBar = circularProgressBar;
        circularProgressBar.setCircleBackgroundColor(-16777216);
        this.mCircularProgressBar.setProgressBarColor(Color.parseColor("#B344C8E5"));
        this.mCircularProgressBar.setBackgroundProgressBarColor(-7829368);
        this.mCircularProgressBar.setProgressBarWidth(5.0f);
        this.mCircularProgressBar.setBackgroundProgressBarWidth(3.0f);
        this.mCircularProgressBar.setRoundBorder(true);
        this.mCircularProgressBar.setStartAngle(0.0f);
        this.mCircularProgressBar.setProgressDirection(CircularProgressBar.ProgressDirection.TO_RIGHT);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dpToPx(this, 32), DisplayUtil.dpToPx(this, 32));
        layoutParams.gravity = 5;
        int iDpToPx = DisplayUtil.dpToPx(this, 13);
        layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        this.mCircularProgressBar.setLayoutParams(layoutParams);
        this.mCircularProgressBar.setVisibility(8);
        this.mContainer.addView(this.mCircularProgressBar);
        TextView textView = new TextView(this);
        this.mTimerTextView = textView;
        textView.setLayoutParams(layoutParams);
        this.mTimerTextView.setTextColor(Color.parseColor("#FFFFFF"));
        this.mTimerTextView.setTextSize(DisplayUtil.dpToPx(this, 4));
        this.mTimerTextView.setGravity(17);
        this.mTimerTextView.setVisibility(8);
        this.mContainer.addView(this.mTimerTextView);
    }

    private void scaleAdView() {
        float fMin = Math.min(DisplayUtil.getDeviceWidth(this), DisplayUtil.getDeviceHeight(this));
        float fMax = Math.max(DisplayUtil.getDeviceWidth(this), DisplayUtil.getDeviceHeight(this));
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "device width : " + fMin + ", height : " + fMax);
        }
        float contentWidth = this.mAdData.getContentWidth() * getResources().getDisplayMetrics().density;
        float contentHeight = this.mAdData.getContentHeight() * getResources().getDisplayMetrics().density;
        int i = this.mCloseButtonPosition;
        if (i == 0 || i == 1) {
            fMax -= DisplayUtil.dpToPx(this, 72);
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            String str = TAG;
            ADXLogUtil.d(str, "adViewWidth : " + fMin + ", adViewHeight : " + fMax);
            ADXLogUtil.d(str, "adWidthPx : " + contentWidth + ", adHeightPx : " + contentHeight);
        }
        if (contentWidth > 0.0f && contentHeight > 0.0f) {
            float f = fMin / contentWidth;
            float f2 = fMax / contentHeight;
            float fMin2 = Math.min(f, f2);
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(TAG, "widthRatio : " + f + ", heightRatio : " + f2 + ", ratio : " + fMin2);
            }
            if (Float.isInfinite(fMin2) || Float.isNaN(fMin2) || fMin2 <= 1.0f) {
                this.mScale = 1.0f;
            } else if (fMin2 > 3.0f) {
                this.mScale = 3.0f;
            } else {
                this.mScale = fMin2;
            }
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "scale : " + this.mScale);
        }
        this.mAdContentView.setScale(this.mScale);
    }

    private void scaleAdViewLV16() {
        float currentWidth = DisplayUtil.getCurrentWidth(this);
        float currentHeight = DisplayUtil.getCurrentHeight(this);
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "device width : " + currentWidth + ", height : " + currentHeight);
        }
        float contentWidth = this.mAdData.getContentWidth() * getResources().getDisplayMetrics().density;
        float contentHeight = this.mAdData.getContentHeight() * getResources().getDisplayMetrics().density;
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            String str = TAG;
            ADXLogUtil.d(str, "adViewWidth : " + currentWidth + ", adViewHeight : " + currentHeight);
            ADXLogUtil.d(str, "adWidthPx : " + contentWidth + ", adHeightPx : " + contentHeight);
        }
        if (contentWidth > 0.0f && contentHeight > 0.0f) {
            float f = currentWidth / contentWidth;
            float f2 = currentHeight / contentHeight;
            float fMin = Math.min(f, f2);
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(TAG, "widthRatio : " + f + ", heightRatio : " + f2 + ", ratio : " + fMin);
            }
            if (Float.isInfinite(fMin) || Float.isNaN(fMin) || fMin <= 1.0f) {
                this.mScale = 1.0f;
            } else if (fMin > 3.0f) {
                this.mScale = 3.0f;
            } else {
                this.mScale = fMin;
            }
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "scale : " + this.mScale);
        }
        this.mAdContentView.setScale(this.mScale);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void changeCloseBtnPosition() {
        /*
            r8 = this;
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = 28
            int r2 = com.adxcorp.ads.mediation.util.DisplayUtil.dpToPx(r8, r1)
            int r1 = com.adxcorp.ads.mediation.util.DisplayUtil.dpToPx(r8, r1)
            r0.<init>(r2, r1)
            int r1 = r8.mCloseButtonPosition
            r2 = 1
            r3 = 2
            r4 = 3
            if (r1 == 0) goto L20
            if (r1 == r2) goto L1d
            if (r1 == r3) goto L20
            if (r1 == r4) goto L1d
            goto L23
        L1d:
            r0.gravity = r4
            goto L23
        L20:
            r1 = 5
            r0.gravity = r1
        L23:
            int r1 = r8.mCloseButtonPosition
            if (r1 == 0) goto L8f
            if (r1 == r2) goto L8f
            if (r1 == r3) goto L2e
            if (r1 == r4) goto L2e
            goto L98
        L2e:
            int r1 = com.adxcorp.ads.mediation.util.DisplayUtil.getDeviceWidth(r8)
            int r2 = com.adxcorp.ads.mediation.util.DisplayUtil.getDeviceHeight(r8)
            int r1 = java.lang.Math.min(r1, r2)
            float r1 = (float) r1
            int r2 = com.adxcorp.ads.mediation.util.DisplayUtil.getDeviceWidth(r8)
            int r5 = com.adxcorp.ads.mediation.util.DisplayUtil.getDeviceHeight(r8)
            int r2 = java.lang.Math.max(r2, r5)
            float r2 = (float) r2
            com.adxcorp.ads.mediation.common.AdData r5 = r8.mAdData
            int r5 = r5.getContentWidth()
            float r5 = (float) r5
            android.content.res.Resources r6 = r8.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            float r6 = r6.density
            float r5 = r5 * r6
            float r6 = r8.mScale
            float r5 = r5 * r6
            com.adxcorp.ads.mediation.common.AdData r6 = r8.mAdData
            int r6 = r6.getContentHeight()
            float r6 = (float) r6
            android.content.res.Resources r7 = r8.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            float r7 = r7.density
            float r6 = r6 * r7
            float r7 = r8.mScale
            float r6 = r6 * r7
            float r1 = r1 - r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r5
            int r1 = (int) r1
            float r2 = r2 - r6
            float r2 = r2 / r5
            int r2 = (int) r2
            r5 = 0
            if (r1 >= 0) goto L7e
            r1 = r5
        L7e:
            if (r2 >= 0) goto L81
            r2 = r5
        L81:
            int r6 = r8.mCloseButtonPosition
            if (r6 != r3) goto L89
            r0.setMargins(r5, r2, r1, r5)
            goto L98
        L89:
            if (r6 != r4) goto L98
            r0.setMargins(r1, r2, r5, r5)
            goto L98
        L8f:
            r1 = 15
            int r1 = com.adxcorp.ads.mediation.util.DisplayUtil.dpToPx(r8, r1)
            r0.setMargins(r1, r1, r1, r1)
        L98:
            android.widget.ImageView r1 = r8.mCloseButton
            r1.setLayoutParams(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adxcorp.ads.mediation.InterstitialActivity.changeCloseBtnPosition():void");
    }

    private void changeCloseBtnPositionLV16() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dpToPx(this, 28), DisplayUtil.dpToPx(this, 28));
        layoutParams.gravity = 5;
        float currentWidth = DisplayUtil.getCurrentWidth(this);
        float currentHeight = DisplayUtil.getCurrentHeight(this);
        int contentWidth = (int) ((currentWidth - ((this.mAdData.getContentWidth() * getResources().getDisplayMetrics().density) * this.mScale)) / 2.0f);
        int contentHeight = (int) ((currentHeight - ((this.mAdData.getContentHeight() * getResources().getDisplayMetrics().density) * this.mScale)) / 2.0f);
        if (contentWidth < 0) {
            contentWidth = 0;
        }
        if (contentHeight < 0) {
            contentHeight = 0;
        }
        layoutParams.setMargins(0, contentHeight, contentWidth, 0);
        this.mCloseButton.setLayoutParams(layoutParams);
    }

    private void addBackKeyCallback() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, new OnBackInvokedCallback() { // from class: com.adxcorp.ads.mediation.InterstitialActivity$$ExternalSyntheticLambda0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    this.f$0.m4344xd0f62626();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$addBackKeyCallback$0$com-adxcorp-ads-mediation-InterstitialActivity, reason: not valid java name */
    /* synthetic */ void m4344xd0f62626() {
        if (this.mAdData.getBackButtonEnabled() == 0 || this.mIsBlockBackButton) {
            return;
        }
        ImageView imageView = this.mCloseButton;
        if (imageView != null) {
            if (imageView.getVisibility() == 0) {
                finish();
                return;
            }
            return;
        }
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!DisplayUtil.isTarget36AndLargeScreen(this) || Build.VERSION.SDK_INT < 36) {
            return;
        }
        scaleAdViewLV16();
        changeCloseBtnPositionLV16();
    }
}
