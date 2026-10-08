package com.adxcorp.ads.mediation.nativeads;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.event.InhouseAdEventListener;
import com.adxcorp.ads.mediation.videoads.VideoAdData;
import com.adxcorp.util.ADXLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class MainAdView extends FrameLayout {
    private static final int IMAGE_VIEW_MODE = 0;
    public static final String TAG = "MainAdView";
    private static final int VIDEO_VIEW_MODE = 1;
    private Context mContext;
    private ImageView mImageView;
    private VideoAdData mVideoAdData;
    private MainAdVideoView mVideoView;
    private int mViewMode;
    private int spaceHeight;
    private int spaceWidth;

    public MainAdView(Context context) {
        super(context);
        this.spaceWidth = 0;
        this.spaceHeight = 0;
        this.mViewMode = 0;
        this.mContext = context;
        parsingAttribute(null);
    }

    public MainAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.spaceWidth = 0;
        this.spaceHeight = 0;
        this.mViewMode = 0;
        this.mContext = context;
        parsingAttribute(attributeSet);
    }

    public MainAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.spaceWidth = 0;
        this.spaceHeight = 0;
        this.mViewMode = 0;
        this.mContext = context;
        parsingAttribute(attributeSet);
    }

    public MainAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.spaceWidth = 0;
        this.spaceHeight = 0;
        this.mViewMode = 0;
        this.mContext = context;
        parsingAttribute(attributeSet);
    }

    private void parsingAttribute(AttributeSet attributeSet) {
        setBackgroundColor(0);
        this.mViewMode = 0;
        if (isInEditMode()) {
            setBackgroundColor(Color.parseColor("#EAEAEA"));
            TextView textView = new TextView(this.mContext);
            textView.setTextColor(Color.parseColor("#82D580"));
            textView.setTextSize(20.0f);
            textView.setText("AD(X) NativeMainView");
            textView.setGravity(17);
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(textView);
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        ImageView imageView = new ImageView(this.mContext);
        this.mImageView = imageView;
        imageView.setLayoutParams(layoutParams);
        addView(this.mImageView);
        this.mImageView.setAdjustViewBounds(true);
        this.mImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mVideoView = new MainAdVideoView(this.mContext);
        layoutParams.width = 100;
        layoutParams.height = 100;
        this.mVideoView.setLayoutParams(layoutParams);
        addView(this.mVideoView);
    }

    public void init(int i, int i2) {
        try {
            this.mViewMode = 0;
            this.spaceWidth = i;
            this.spaceHeight = i2;
            privateLog("space width : " + this.spaceWidth + ", space height : " + this.spaceHeight);
            privateLog("layout width : " + getLayoutParams().width + ", layout height : " + getLayoutParams().height);
            MainAdVideoView mainAdVideoView = this.mVideoView;
            if (mainAdVideoView != null) {
                mainAdVideoView.setVisibility(8);
            }
            ImageView imageView = this.mImageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    public void init(int i, int i2, VideoAdData videoAdData, InhouseAdEventListener inhouseAdEventListener) {
        try {
            this.mViewMode = 1;
            if (this.mVideoAdData != videoAdData) {
                this.mVideoView.setVideoAdData(videoAdData, inhouseAdEventListener);
            }
            this.mVideoAdData = videoAdData;
            if (i > 0 && i2 > 0) {
                this.spaceWidth = i;
                this.spaceHeight = i2;
            } else {
                this.spaceWidth = 16;
                this.spaceHeight = 9;
            }
            privateLog("space width : " + this.spaceWidth + ", space height : " + this.spaceHeight);
            privateLog("layout width : " + getLayoutParams().width + ", layout height : " + getLayoutParams().height);
            ImageView imageView = this.mImageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            MainAdVideoView mainAdVideoView = this.mVideoView;
            if (mainAdVideoView != null) {
                mainAdVideoView.setVisibility(0);
            }
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    public ImageView getImageView() {
        return this.mImageView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ae, code lost:
    
        if (r1 > 0) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adxcorp.ads.mediation.nativeads.MainAdView.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ADXLogUtil.d(TAG, "onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ADXLogUtil.d(TAG, "onDetachedFromWindow");
    }

    private void privateLog(String str) {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mViewMode == 0 ? "[IMAGE] " : "[VIDEO] ");
            sb.append(str);
            ADXLogUtil.d(str2, sb.toString());
        }
    }
}
