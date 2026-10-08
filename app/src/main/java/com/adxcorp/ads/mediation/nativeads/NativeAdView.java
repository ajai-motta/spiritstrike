package com.adxcorp.ads.mediation.nativeads;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.event.InhouseAdEventListener;
import com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper;
import com.adxcorp.ads.mediation.util.ClickThroughUtil;
import com.adxcorp.ads.mediation.util.DisplayUtil;
import com.adxcorp.ads.mediation.util.HttpUtil;
import com.adxcorp.ads.mediation.util.MemUtil;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.util.ADXLogUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class NativeAdView extends FrameLayout {
    public static final String TAG = "NativeAdView";
    private InhouseAdEventListener mAdEventListener;
    private ViewGroup mAdView;
    private int mAdViewHeight;
    private int mAdViewWidth;
    private Context mContext;
    private Button mCtaButton;
    private TextView mDescTextView;
    private ImageView mIconImageView;
    private boolean mIsNotifyImpression;
    private boolean mIsRequiredIconImage;
    private boolean mIsRequiredMainImage;
    private boolean mIsRequiredMainVideo;
    private boolean mIsResourceLoaded;
    private boolean mIsSetOptOut;
    private boolean mIsValidLayout;
    private MainAdView mMainAdView;
    private NativeAdData mNativeAdData;
    private NativeAdViewBinder mNativeAdViewBinder;
    private ImageView mOptOutImageView;
    private RatingBar mRatingBar;
    private TextView mTitleTextView;

    public interface ResourceLoadEventListener {
        void onError();

        void onSuccess();
    }

    public NativeAdView(Context context, NativeAdViewBinder nativeAdViewBinder) {
        this(context, nativeAdViewBinder, null);
    }

    public NativeAdView(Context context, NativeAdViewBinder nativeAdViewBinder, InhouseAdEventListener inhouseAdEventListener) {
        super(context);
        this.mTitleTextView = null;
        this.mIconImageView = null;
        this.mRatingBar = null;
        this.mDescTextView = null;
        this.mMainAdView = null;
        this.mCtaButton = null;
        this.mOptOutImageView = null;
        this.mIsValidLayout = false;
        this.mAdViewWidth = 0;
        this.mAdViewHeight = 0;
        this.mContext = context;
        this.mAdEventListener = inhouseAdEventListener;
        initLayout(nativeAdViewBinder);
    }

    private void initLayout(NativeAdViewBinder nativeAdViewBinder) {
        this.mNativeAdViewBinder = nativeAdViewBinder;
        try {
            if (nativeAdViewBinder != null) {
                ViewGroup viewGroup = (ViewGroup) inflate(this.mContext, nativeAdViewBinder.getLayoutId(), null);
                this.mAdView = viewGroup;
                if (viewGroup != null) {
                    this.mTitleTextView = (TextView) viewGroup.findViewById(nativeAdViewBinder.getTitleId());
                    this.mIconImageView = (ImageView) this.mAdView.findViewById(nativeAdViewBinder.getIconImageId());
                    this.mRatingBar = (RatingBar) this.mAdView.findViewById(nativeAdViewBinder.getRatingbarId());
                    this.mDescTextView = (TextView) this.mAdView.findViewById(nativeAdViewBinder.getDescriptionId());
                    this.mMainAdView = (MainAdView) this.mAdView.findViewById(nativeAdViewBinder.getMainId());
                    this.mCtaButton = (Button) this.mAdView.findViewById(nativeAdViewBinder.getCallToActionId());
                    this.mOptOutImageView = (ImageView) this.mAdView.findViewById(nativeAdViewBinder.getOptOutId());
                    this.mAdView.setVisibility(8);
                    removeAllViews();
                    addView(this.mAdView);
                    this.mAdViewWidth = this.mAdView.getWidth();
                    this.mAdViewHeight = this.mAdView.getHeight();
                }
            } else {
                int iDpToPx = DisplayUtil.dpToPx(this.mContext, 5);
                int iDpToPx2 = DisplayUtil.dpToPx(this.mContext, 10);
                int iDpToPx3 = DisplayUtil.dpToPx(this.mContext, 30);
                this.mAdView = new LinearLayout(this.mContext);
                this.mAdView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                LinearLayout linearLayout = new LinearLayout(this.mContext);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout.setOrientation(1);
                this.mAdView.addView(linearLayout);
                LinearLayout linearLayout2 = new LinearLayout(this.mContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                linearLayout2.setOrientation(0);
                linearLayout2.setLayoutParams(layoutParams);
                linearLayout.addView(linearLayout2);
                ImageView imageView = new ImageView(this.mContext);
                this.mIconImageView = imageView;
                imageView.setId(DisplayUtil.generateViewId());
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 50), DisplayUtil.dpToPx(this.mContext, 50));
                layoutParams2.setMargins(0, iDpToPx, iDpToPx2, iDpToPx);
                this.mIconImageView.setLayoutParams(layoutParams2);
                linearLayout2.addView(this.mIconImageView);
                this.mTitleTextView = new TextView(this.mContext);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.setMargins(0, iDpToPx, iDpToPx3, iDpToPx);
                layoutParams3.gravity = 16;
                this.mTitleTextView.setTextColor(-16777216);
                this.mTitleTextView.setLayoutParams(layoutParams3);
                this.mTitleTextView.setTextSize(1, 16.0f);
                this.mTitleTextView.setMaxLines(2);
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                linearLayout2.addView(this.mTitleTextView);
                this.mDescTextView = new TextView(this.mContext);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.setMargins(0, iDpToPx, 0, iDpToPx);
                this.mDescTextView.setTextColor(-16777216);
                this.mDescTextView.setLayoutParams(layoutParams4);
                this.mDescTextView.setTextSize(1, 14.0f);
                this.mDescTextView.setMaxLines(3);
                this.mDescTextView.setEllipsize(TextUtils.TruncateAt.END);
                linearLayout.addView(this.mDescTextView);
                MainAdView mainAdView = new MainAdView(this.mContext);
                this.mMainAdView = mainAdView;
                mainAdView.setBackgroundColor(Color.parseColor("#F5F5F5"));
                this.mMainAdView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout.addView(this.mMainAdView);
                this.mCtaButton = new Button(this.mContext);
                this.mCtaButton.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.mCtaButton.setTextColor(-1);
                this.mCtaButton.setBackgroundColor(Color.parseColor("#039be5"));
                this.mCtaButton.setTextSize(1, 14.0f);
                linearLayout.addView(this.mCtaButton);
                this.mAdView.setVisibility(8);
                removeAllViews();
                addView(this.mAdView);
            }
            ImageView imageView2 = this.mOptOutImageView;
            if (imageView2 == null) {
                ImageView imageView3 = new ImageView(this.mContext);
                this.mOptOutImageView = imageView3;
                imageView3.setAdjustViewBounds(true);
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 14), DisplayUtil.dpToPx(this.mContext, 14));
                layoutParams5.gravity = 5;
                layoutParams5.topMargin = this.mAdView.getPaddingTop() + DisplayUtil.dpToPx(this.mContext, 5);
                layoutParams5.rightMargin = this.mAdView.getPaddingRight() + DisplayUtil.dpToPx(this.mContext, 5);
                this.mOptOutImageView.setLayoutParams(layoutParams5);
                addView(this.mOptOutImageView);
                return;
            }
            imageView2.setAdjustViewBounds(true);
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    public int fillAd(NativeAdData nativeAdData) {
        int i;
        int i2;
        try {
            this.mNativeAdData = nativeAdData;
            if (this.mAdView != null) {
                if (this.mTitleTextView != null) {
                    if (!TextUtils.isEmpty(nativeAdData.getTitle())) {
                        this.mTitleTextView.setVisibility(0);
                        this.mTitleTextView.setText(this.mNativeAdData.getTitle());
                        this.mTitleTextView.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdView.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                NativeAdView.this.clickEvent(view);
                            }
                        });
                    } else {
                        this.mTitleTextView.setVisibility(8);
                    }
                }
                if (this.mIconImageView != null) {
                    if (!TextUtils.isEmpty(this.mNativeAdData.getIconImageUrl())) {
                        this.mIconImageView.setVisibility(0);
                        this.mIconImageView.setAdjustViewBounds(true);
                        this.mIconImageView.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                NativeAdView.this.clickEvent(view);
                            }
                        });
                    } else {
                        this.mIconImageView.setVisibility(8);
                    }
                }
                if (this.mRatingBar != null) {
                    try {
                        double rating = this.mNativeAdData.getRating();
                        if (rating > 0.0d && rating <= 5.0d) {
                            this.mRatingBar.setVisibility(0);
                            this.mRatingBar.setNumStars(5);
                            this.mRatingBar.setRating((float) rating);
                            this.mRatingBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdView.3
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (motionEvent.getAction() == 1) {
                                        NativeAdView.this.clickEvent(view);
                                    }
                                    return true;
                                }
                            });
                        } else {
                            this.mRatingBar.setVisibility(8);
                        }
                    } catch (Exception unused) {
                        this.mRatingBar.setVisibility(8);
                    }
                }
                if (this.mDescTextView != null) {
                    if (!TextUtils.isEmpty(this.mNativeAdData.getDescription())) {
                        this.mDescTextView.setVisibility(0);
                        this.mDescTextView.setText(this.mNativeAdData.getDescription());
                        this.mDescTextView.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdView.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                NativeAdView.this.clickEvent(view);
                            }
                        });
                    } else {
                        this.mDescTextView.setVisibility(8);
                    }
                }
                if (this.mMainAdView != null) {
                    if (!TextUtils.isEmpty(this.mNativeAdData.getMainImageUrl())) {
                        this.mMainAdView.init(this.mNativeAdData.getMainWidth(), this.mNativeAdData.getMainHeight());
                        this.mMainAdView.setVisibility(0);
                        this.mMainAdView.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdView.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                NativeAdView.this.clickEvent(view);
                            }
                        });
                    } else if (this.mNativeAdData.getVideoAdData() != null) {
                        this.mMainAdView.init(this.mNativeAdData.getMainWidth(), this.mNativeAdData.getMainHeight(), this.mNativeAdData.getVideoAdData(), this.mAdEventListener);
                        this.mMainAdView.setVisibility(0);
                        this.mMainAdView.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdView.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                            }
                        });
                    } else {
                        this.mMainAdView.setVisibility(8);
                    }
                }
                if (this.mCtaButton != null) {
                    if (!TextUtils.isEmpty(this.mNativeAdData.getCallToAction())) {
                        this.mCtaButton.setVisibility(0);
                        this.mCtaButton.setText(this.mNativeAdData.getCallToAction());
                        this.mCtaButton.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdView.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                NativeAdView.this.clickEvent(view);
                            }
                        });
                    } else {
                        this.mCtaButton.setVisibility(8);
                    }
                }
                ImageView imageView = this.mOptOutImageView;
                if (imageView != null) {
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdView.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!ClickThroughUtil.isValidClick()) {
                                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                                    ADXLogUtil.d(NativeAdView.TAG, ":::clickEvent::: OptOut : " + NativeAdView.this.mNativeAdData.getOptoutLink() + " -> block");
                                    return;
                                }
                                return;
                            }
                            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                                ADXLogUtil.d(NativeAdView.TAG, ":::clickEvent::: OptOut : " + NativeAdView.this.mNativeAdData.getOptoutLink());
                            }
                            ClickThroughUtil.goToBrowser(NativeAdView.this.mContext, NativeAdView.this.mNativeAdData.getOptoutLink());
                        }
                    });
                }
                int[] assetTypes = this.mNativeAdData.getAssetTypes();
                i = -23;
                if (assetTypes != null) {
                    i2 = 0;
                    for (int i3 : assetTypes) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                this.mIsRequiredIconImage = true;
                                if (this.mIconImageView == null) {
                                    ADXLogUtil.i(TAG, "It's invalid layout. Icon ImageView cannot be null.");
                                    i2 = -12;
                                } else if (TextUtils.isEmpty(this.mNativeAdData.getIconImageUrl())) {
                                    ADXLogUtil.i(TAG, "Invalid server data received. Icon data is empty.");
                                    i2 = -22;
                                }
                            } else if (i3 != 3) {
                                if (i3 == 4) {
                                    if (this.mDescTextView == null) {
                                        ADXLogUtil.i(TAG, "It's invalid layout. Description TextView cannot be null.");
                                        i2 = -14;
                                    } else if (TextUtils.isEmpty(this.mNativeAdData.getDescription())) {
                                        ADXLogUtil.i(TAG, "Invalid server data received. Description data is empty.");
                                        i2 = -24;
                                    }
                                }
                            } else if (this.mNativeAdData.getIcType() == 31) {
                                this.mIsRequiredMainImage = true;
                                if (this.mMainAdView == null) {
                                    ADXLogUtil.i(TAG, "It's invalid layout. NativeMainView cannot be null.");
                                    i2 = -13;
                                } else if (TextUtils.isEmpty(this.mNativeAdData.getMainImageUrl())) {
                                    ADXLogUtil.i(TAG, "Invalid server data received. Main data is empty.");
                                    i2 = -23;
                                }
                            } else if (this.mNativeAdData.getIcType() == 32) {
                                this.mIsRequiredMainVideo = true;
                                if (this.mMainAdView == null) {
                                    ADXLogUtil.i(TAG, "It's invalid layout. NativeMainView cannot be null.");
                                    i2 = -13;
                                }
                            }
                        } else if (this.mTitleTextView == null) {
                            ADXLogUtil.i(TAG, "It's invalid layout. Title TextView cannot be null.");
                            i2 = -11;
                        } else if (TextUtils.isEmpty(this.mNativeAdData.getTitle())) {
                            ADXLogUtil.i(TAG, "Invalid server data received. Title data is empty.");
                            i2 = -21;
                        }
                    }
                } else {
                    i2 = 0;
                }
                if (this.mNativeAdData.getIcType() != 32 || this.mIsRequiredMainVideo) {
                    i = i2;
                } else {
                    ADXLogUtil.i(TAG, "The main asset type can not be found.");
                }
                if (this.mNativeAdData.getOnlyClickCTA() == 1) {
                    if (this.mCtaButton == null) {
                        ADXLogUtil.i(TAG, "It's invalid layout. CTA Button cannot be null.");
                        i = 16;
                    } else if (TextUtils.isEmpty(this.mNativeAdData.getDescription())) {
                        ADXLogUtil.i(TAG, "Invalid server data received. CTA data is empty.");
                        i = -26;
                    }
                }
            } else {
                i = -10;
            }
            boolean z = i == 0;
            this.mIsValidLayout = z;
            if (z) {
                this.mAdView.setVisibility(0);
                return i;
            }
            ADXLogUtil.i(TAG, "It's invalid layout. If it is not a server error, check your layout XML or NativeAdViewBinder object.");
            this.mAdView.setVisibility(8);
            return i;
        } catch (OutOfMemoryError e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                String str = TAG;
                ADXLogUtil.d(str, "[oom] free memory : " + MemUtil.megabytesFree() + "(MB), total memory : " + MemUtil.megabytesAvailable() + "(MB)");
                ADXLogUtil.e(str, new Exception(e));
                MemUtil.printMemoryLog();
            }
            MemUtil.setMemoryError(true);
            return -99;
        }
    }

    public NativeAdData getNativeAdData() {
        return this.mNativeAdData;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(TAG, "dispatchDraw - (current) width : " + this.mAdViewWidth + ", height : " + this.mAdViewHeight);
            }
            ViewGroup viewGroup = this.mAdView;
            if (viewGroup != null && (this.mAdViewWidth != viewGroup.getWidth() || this.mAdViewHeight != this.mAdView.getHeight())) {
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(TAG, "dispatchDraw - (new) width : " + this.mAdView.getWidth() + ", height : " + this.mAdView.getHeight());
                }
                this.mAdViewWidth = this.mAdView.getWidth();
                this.mAdViewHeight = this.mAdView.getHeight();
            }
            impressionEvent();
            setupOptOut();
            super.dispatchDraw(canvas);
        } catch (Exception e) {
            ADXLogUtil.d(TAG, "dispatchDraw Exception (title : " + this.mNativeAdData.getTitle() + ", description : " + this.mNativeAdData.getDescription() + ", icon : " + this.mNativeAdData.getIconImageUrl() + ", main : " + this.mNativeAdData.getMainImageUrl() + ")");
            e.printStackTrace();
        }
    }

    private void impressionEvent() {
        try {
            if (this.mIsNotifyImpression) {
                return;
            }
            if (!this.mIsValidLayout) {
                ADXLogUtil.i(TAG, "It's invalid layout. If it is not a server error, check your layout XML or NativeAdViewBinder object.");
            }
            if (this.mNativeAdData != null) {
                this.mIsNotifyImpression = true;
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    String str = TAG;
                    ADXLogUtil.d(str, "impressionEvent");
                    if (this.mAdView != null) {
                        ADXLogUtil.d(str, "mAdView.getVisibility() : " + String.format("%s", Integer.valueOf(this.mAdView.getVisibility())));
                    }
                }
                ReportUtil.sendReport("NATIVE_IMPRESSION_TAG", this.mNativeAdData.getTrackingImpUrls());
                InhouseAdEventListener inhouseAdEventListener = this.mAdEventListener;
                if (inhouseAdEventListener != null) {
                    inhouseAdEventListener.notifyAdShown();
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickEvent(View view) {
        try {
            if (!this.mIsValidLayout) {
                ADXLogUtil.i(TAG, "It's invalid layout. If it is not a server error, check your layout XML or NativeAdViewBinder object.");
            }
            NativeAdData nativeAdData = this.mNativeAdData;
            if (nativeAdData != null) {
                boolean z = true;
                if (nativeAdData.getOnlyClickCTA() != 1 || view.equals(this.mCtaButton)) {
                    String link = this.mNativeAdData.getLink();
                    if (this.mNativeAdData.getWebviewLanding() != 1) {
                        z = false;
                    }
                    if (!ClickThroughUtil.isValidClick()) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(TAG, ":::clickEvent::: " + link + " -> block");
                            return;
                        }
                        return;
                    }
                    if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                        ADXLogUtil.d(TAG, ":::clickEvent::: " + link + " -> isWebViewLanding : " + z);
                    }
                    if (z) {
                        HttpUtil.getFinalURL(link, new Handler(Looper.getMainLooper()) { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdView.9
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 100) {
                                    return;
                                }
                                try {
                                    if (ClickThroughUtil.goToWebView(NativeAdView.this.mContext, (String) message.obj)) {
                                        ReportUtil.sendReport("NATIVE_CLICK_TAG", NativeAdView.this.mNativeAdData.getTrackingClkUrls());
                                        if (NativeAdView.this.mAdEventListener != null) {
                                            NativeAdView.this.mAdEventListener.notifyAdClicked();
                                        }
                                    } else if (ClickThroughUtil.goToBrowser(NativeAdView.this.mContext, (String) message.obj)) {
                                        ReportUtil.sendReport("NATIVE_CLICK_TAG", NativeAdView.this.mNativeAdData.getTrackingClkUrls());
                                        if (NativeAdView.this.mAdEventListener != null) {
                                            NativeAdView.this.mAdEventListener.notifyAdClicked();
                                        }
                                    }
                                } catch (Exception e) {
                                    ADXLogUtil.e(NativeAdView.TAG, e);
                                }
                            }
                        });
                        return;
                    }
                    if (ClickThroughUtil.goToBrowser(this.mContext, link)) {
                        ReportUtil.sendReport("NATIVE_CLICK_TAG", this.mNativeAdData.getTrackingClkUrls());
                        InhouseAdEventListener inhouseAdEventListener = this.mAdEventListener;
                        if (inhouseAdEventListener != null) {
                            inhouseAdEventListener.notifyAdClicked();
                        }
                    }
                }
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    public void destroy() {
        removeAllViews();
    }

    public ImageView getIconImageView() {
        return this.mIconImageView;
    }

    public ImageView getMainImageView() {
        MainAdView mainAdView = this.mMainAdView;
        if (mainAdView != null) {
            return mainAdView.getImageView();
        }
        return null;
    }

    public ImageView getOptOutImageView() {
        return this.mOptOutImageView;
    }

    public void downloadResource() {
        downloadResource(null);
    }

    public void downloadResource(final ResourceLoadEventListener resourceLoadEventListener) {
        try {
            HashMap<String, ImageView> map = new HashMap<>();
            String str = TAG;
            ADXLogUtil.d(str, ":::downloadResource:::icon url : " + this.mNativeAdData.getIconImageUrl());
            ADXLogUtil.d(str, ":::downloadResource:::icon ImageView : " + this.mIconImageView);
            ADXLogUtil.d(str, ":::downloadResource:::mIsRequiredIconImage : " + this.mIsRequiredIconImage);
            if (!TextUtils.isEmpty(this.mNativeAdData.getIconImageUrl()) && this.mIconImageView != null) {
                map.put(this.mNativeAdData.getIconImageUrl(), this.mIconImageView);
            } else if (this.mIsRequiredIconImage) {
                resourceLoadError(resourceLoadEventListener, map);
                return;
            }
            MainAdView mainAdView = this.mMainAdView;
            if (mainAdView != null) {
                ImageView imageView = mainAdView.getImageView();
                ADXLogUtil.d(str, ":::downloadResource:::main url : " + this.mNativeAdData.getMainImageUrl());
                ADXLogUtil.d(str, ":::downloadResource:::main ImageView : " + imageView);
                ADXLogUtil.d(str, ":::downloadResource:::mIsRequiredMainImage : " + this.mIsRequiredMainImage);
                if (!TextUtils.isEmpty(this.mNativeAdData.getMainImageUrl()) && imageView != null) {
                    map.put(this.mNativeAdData.getMainImageUrl(), imageView);
                } else if (this.mIsRequiredMainImage) {
                    resourceLoadError(resourceLoadEventListener, map);
                    return;
                }
            } else if (this.mIsRequiredMainImage) {
                resourceLoadError(resourceLoadEventListener, map);
                return;
            }
            ADXLogUtil.d(str, ":::downloadResource:::count : " + map.size());
            if (map.size() == 0) {
                resourceLoadSuccess(resourceLoadEventListener, map);
            } else {
                new NativeAdImageHelper(this.mContext).load(map, new NativeAdImageHelper.ImageLoadEventListener() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdView.10
                    @Override // com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.ImageLoadEventListener
                    public void onSuccess() {
                        ADXLogUtil.d(NativeAdView.TAG, ":::downloadResource:::onSuccess");
                        NativeAdView.this.resourceLoadSuccess(resourceLoadEventListener, null);
                    }

                    @Override // com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.ImageLoadEventListener
                    public void onError() {
                        ADXLogUtil.d(NativeAdView.TAG, ":::downloadResource:::onError");
                        NativeAdView.this.resourceLoadError(resourceLoadEventListener, null);
                    }
                });
            }
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
            resourceLoadError(resourceLoadEventListener, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resourceLoadError(ResourceLoadEventListener resourceLoadEventListener, HashMap map) {
        try {
            this.mIsResourceLoaded = false;
            if (resourceLoadEventListener != null) {
                resourceLoadEventListener.onError();
            }
            if (map != null) {
                map.clear();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resourceLoadSuccess(ResourceLoadEventListener resourceLoadEventListener, HashMap map) {
        try {
            this.mIsResourceLoaded = true;
            if (resourceLoadEventListener != null) {
                resourceLoadEventListener.onSuccess();
            }
            if (map != null) {
                map.clear();
            }
        } catch (Exception unused) {
        }
    }

    public boolean isResourceLoaded() {
        return this.mIsResourceLoaded;
    }

    public NativeAdView copy() {
        try {
            NativeAdView nativeAdView = new NativeAdView(this.mContext, this.mNativeAdViewBinder, this.mAdEventListener);
            int iFillAd = nativeAdView.fillAd(getNativeAdData());
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(TAG, ":::copy:::fillAdResult : " + iFillAd);
            }
            if (iFillAd != 0) {
                return null;
            }
            if (nativeAdView.getMainImageView() != null && getMainImageView() != null) {
                nativeAdView.getMainImageView().setImageDrawable(getMainImageView().getDrawable());
            }
            if (nativeAdView.getIconImageView() != null && getIconImageView() != null) {
                nativeAdView.getIconImageView().setImageDrawable(getIconImageView().getDrawable());
            }
            return nativeAdView;
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            return null;
        }
    }

    public void setupOptOut() {
        try {
            if (this.mIsSetOptOut) {
                return;
            }
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(TAG, ":::setupOptOut::: image : " + this.mNativeAdData.getOptoutImageUrl() + ", link : " + this.mNativeAdData.getOptoutLink());
            }
            if (this.mOptOutImageView == null) {
                return;
            }
            this.mIsSetOptOut = true;
            final String optoutImageUrl = this.mNativeAdData.getOptoutImageUrl();
            if (!TextUtils.isEmpty(optoutImageUrl)) {
                this.mOptOutImageView.setImageBitmap(null);
                NativeAdImageHelper nativeAdImageHelper = new NativeAdImageHelper(this.mContext);
                HashMap<String, ImageView> map = new HashMap<>();
                map.put(optoutImageUrl, this.mOptOutImageView);
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(TAG, ":::setupOptOut::: load - " + optoutImageUrl);
                }
                nativeAdImageHelper.load(map, new NativeAdImageHelper.ImageLoadEventListener() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdView.11
                    @Override // com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.ImageLoadEventListener
                    public void onSuccess() {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(NativeAdView.TAG, ":::setupOptOut:::onSuccess - " + optoutImageUrl);
                        }
                        NativeAdView.this.mOptOutImageView.setVisibility(0);
                    }

                    @Override // com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.ImageLoadEventListener
                    public void onError() {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(NativeAdView.TAG, ":::setupOptOut:::onError - " + optoutImageUrl);
                        }
                        NativeAdView.this.mOptOutImageView.setVisibility(8);
                    }
                });
                return;
            }
            this.mOptOutImageView.setImageBitmap(null);
            this.mOptOutImageView.setVisibility(8);
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            ImageView imageView = this.mOptOutImageView;
            if (imageView != null) {
                imageView.setImageBitmap(null);
            }
            this.mOptOutImageView.setVisibility(8);
        }
    }

    public boolean isVideoAd() {
        NativeAdData nativeAdData = this.mNativeAdData;
        return nativeAdData != null && nativeAdData.getIcType() == 32;
    }
}
