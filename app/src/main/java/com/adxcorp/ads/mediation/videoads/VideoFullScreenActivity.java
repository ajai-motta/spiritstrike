package com.adxcorp.ads.mediation.videoads;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import android.window.OnBackInvokedCallback;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.common.AdData;
import com.adxcorp.ads.mediation.common.Constants;
import com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper;
import com.adxcorp.ads.mediation.nativeads.util.VideoThumbnail;
import com.adxcorp.ads.mediation.ui.AdContentView;
import com.adxcorp.ads.mediation.ui.InterstitialBaseActivity;
import com.adxcorp.ads.mediation.ui.progressbar.CircularProgressBar;
import com.adxcorp.ads.mediation.ui.progressbar.SpinningLoaderView;
import com.adxcorp.ads.mediation.util.ClickThroughUtil;
import com.adxcorp.ads.mediation.util.DisplayUtil;
import com.adxcorp.ads.mediation.util.HttpUtil;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.util.ADXLogUtil;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class VideoFullScreenActivity extends InterstitialBaseActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
    public static final String TAG = "VideoFullScreenActivity";
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    private boolean isSentClick;
    private boolean isSentComplete;
    private boolean isSentEndCardClick;
    private boolean isSentEndCardImpression;
    private boolean isSentFirst;
    private boolean isSentImpression;
    private boolean isSentSecond;
    private boolean isSentStart;
    private boolean isSentThird;
    private boolean isUserNotification;
    private Button mAdButton;
    private CircularProgressBar mCircularProgressBar;
    private ImageView mCloseButton;
    private ImageView mCloseButton2;
    private RelativeLayout mContainer;
    private RelativeLayout mEndCardContainer;
    private AdContentView mEndCardContentView;
    private EndCardData mEndCardData;
    private int mFirstQuartile;
    private boolean mIsClickableVideo;
    private boolean mIsLoadedEndCardImage;
    private boolean mIsPrepared;
    private boolean mIsVolumeOn;
    private boolean mIsWebViewLanding;
    private String mLink;
    private MediaPlayer mMediaPlayer;
    private ImageView mOptOutImageView;
    private SpinningLoaderView mProgressBar;
    private int mSecondQuartile;
    private NoSkipSeekBar mSeekbar;
    private int mSkipOffsetSec;
    private int mStopPosition;
    private int mThirdQuartile;
    private TextView mTimerTextView;
    private VideoAdData mVideoAdData;
    private float mVideoCurPosSec;
    private int mVideoDuration;
    private VideoView mVideoView;
    private ImageView mVolumeImage;
    private Bitmap mVolumeOffBitmap;
    private Bitmap mVolumeOnBitmap;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable checkVideoPrepared = new Runnable() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoFullScreenActivity.this.mIsPrepared) {
                return;
            }
            ADXLogUtil.d(VideoFullScreenActivity.TAG, "video play timeout!");
            VideoFullScreenActivity.this.isUserNotification = true;
            VideoFullScreenActivity.this.notifyVideoError();
            VideoFullScreenActivity.this.finish();
        }
    };
    private Runnable showCloseButton = new Runnable() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.2
        @Override // java.lang.Runnable
        public void run() {
            if (VideoFullScreenActivity.this.mCircularProgressBar != null) {
                VideoFullScreenActivity.this.mCircularProgressBar.setVisibility(8);
            }
            if (VideoFullScreenActivity.this.mTimerTextView != null) {
                VideoFullScreenActivity.this.mTimerTextView.setVisibility(8);
            }
            if (VideoFullScreenActivity.this.mCloseButton != null) {
                if (VideoFullScreenActivity.this.mEndCardData != null && VideoFullScreenActivity.this.mEndCardContainer != null && VideoFullScreenActivity.this.mIsLoadedEndCardImage && VideoFullScreenActivity.this.mCloseButton.getVisibility() == 8) {
                    try {
                        byte[] bArrDecode = Base64.decode("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", 0);
                        VideoFullScreenActivity.this.mCloseButton.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                    } catch (Exception e) {
                        ADXLogUtil.e(VideoFullScreenActivity.TAG, e);
                    }
                }
                VideoFullScreenActivity.this.mCloseButton.setVisibility(0);
            }
        }
    };
    private Runnable updateTimeRunnable = new Runnable() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.3
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (VideoFullScreenActivity.this.mVideoView != null) {
                    VideoFullScreenActivity.this.mVideoCurPosSec = r0.mVideoView.getCurrentPosition() / 1000.0f;
                }
                if (VideoFullScreenActivity.this.mSeekbar != null) {
                    VideoFullScreenActivity.this.mSeekbar.setProgress(VideoFullScreenActivity.this.mVideoView.getCurrentPosition());
                }
                if (VideoFullScreenActivity.this.isSentComplete) {
                    if (VideoFullScreenActivity.this.mCircularProgressBar != null) {
                        VideoFullScreenActivity.this.mCircularProgressBar.setVisibility(8);
                    }
                    if (VideoFullScreenActivity.this.mTimerTextView != null) {
                        VideoFullScreenActivity.this.mTimerTextView.setVisibility(8);
                    }
                    if (VideoFullScreenActivity.this.mCloseButton == null || VideoFullScreenActivity.this.mCloseButton.getVisibility() == 0 || VideoFullScreenActivity.this.mHandler == null) {
                        return;
                    }
                    VideoFullScreenActivity.this.mHandler.post(VideoFullScreenActivity.this.showCloseButton);
                    return;
                }
                if (VideoFullScreenActivity.this.mSkipOffsetSec <= 0) {
                    if (VideoFullScreenActivity.this.mSkipOffsetSec == 0) {
                        if (VideoFullScreenActivity.this.mCloseButton == null || VideoFullScreenActivity.this.mCloseButton.getVisibility() == 0 || VideoFullScreenActivity.this.mHandler == null) {
                            return;
                        }
                        VideoFullScreenActivity.this.mHandler.post(VideoFullScreenActivity.this.showCloseButton);
                        return;
                    }
                    if (VideoFullScreenActivity.this.mCircularProgressBar != null) {
                        VideoFullScreenActivity.this.mCircularProgressBar.setProgressMax(VideoFullScreenActivity.this.mVideoDuration);
                        VideoFullScreenActivity.this.mCircularProgressBar.setProgressWithAnimation(VideoFullScreenActivity.this.mVideoCurPosSec + 0.5f, 500L, null, 0L);
                        VideoFullScreenActivity.this.mCircularProgressBar.setVisibility(0);
                    }
                    if (VideoFullScreenActivity.this.mTimerTextView != null) {
                        int i = VideoFullScreenActivity.this.mVideoDuration - ((int) VideoFullScreenActivity.this.mVideoCurPosSec);
                        VideoFullScreenActivity.this.mTimerTextView.setText(i + "");
                        VideoFullScreenActivity.this.mTimerTextView.setVisibility(0);
                        return;
                    }
                    return;
                }
                if (VideoFullScreenActivity.this.mSkipOffsetSec - VideoFullScreenActivity.this.mVideoCurPosSec > 0.0f) {
                    if (VideoFullScreenActivity.this.mCircularProgressBar != null) {
                        VideoFullScreenActivity.this.mCircularProgressBar.setProgressMax(VideoFullScreenActivity.this.mSkipOffsetSec);
                        VideoFullScreenActivity.this.mCircularProgressBar.setProgressWithAnimation(VideoFullScreenActivity.this.mVideoCurPosSec + 0.5f, 500L, null, 0L);
                        VideoFullScreenActivity.this.mCircularProgressBar.setVisibility(0);
                    }
                    if (VideoFullScreenActivity.this.mTimerTextView != null) {
                        int i2 = VideoFullScreenActivity.this.mSkipOffsetSec - ((int) VideoFullScreenActivity.this.mVideoCurPosSec);
                        VideoFullScreenActivity.this.mTimerTextView.setText(i2 + "");
                        VideoFullScreenActivity.this.mTimerTextView.setVisibility(0);
                    }
                    if (VideoFullScreenActivity.this.mCloseButton != null) {
                        VideoFullScreenActivity.this.mCloseButton.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (VideoFullScreenActivity.this.mCircularProgressBar != null) {
                    VideoFullScreenActivity.this.mCircularProgressBar.setVisibility(8);
                }
                if (VideoFullScreenActivity.this.mTimerTextView != null) {
                    VideoFullScreenActivity.this.mTimerTextView.setVisibility(8);
                }
                if (VideoFullScreenActivity.this.mCloseButton == null || VideoFullScreenActivity.this.mCloseButton.getVisibility() == 0 || VideoFullScreenActivity.this.mHandler == null) {
                    return;
                }
                VideoFullScreenActivity.this.mHandler.post(VideoFullScreenActivity.this.showCloseButton);
            } catch (Exception e) {
                ADXLogUtil.e(VideoFullScreenActivity.TAG, e);
            }
        }
    };
    private Runnable videoPlayTrackerRunnable = new Runnable() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.4
        @Override // java.lang.Runnable
        public void run() {
            String str;
            try {
                if (VideoFullScreenActivity.this.mVideoView != null) {
                    ADXLogUtil.d(VideoFullScreenActivity.TAG, "videoPlayTrackerRunnable : " + VideoFullScreenActivity.this.mVideoView.getCurrentPosition() + ", isPlaying : " + VideoFullScreenActivity.this.mVideoView.isPlaying());
                }
                if (VideoFullScreenActivity.this.mVideoView != null && VideoFullScreenActivity.this.mVideoView.isPlaying()) {
                    int currentPosition = VideoFullScreenActivity.this.mVideoView.getCurrentPosition() / 1000;
                    ADXLogUtil.d(VideoFullScreenActivity.TAG, "video current position  : " + currentPosition);
                    if (currentPosition > 0) {
                        if (currentPosition != VideoFullScreenActivity.this.mFirstQuartile || VideoFullScreenActivity.this.isSentFirst) {
                            if (currentPosition != VideoFullScreenActivity.this.mSecondQuartile || VideoFullScreenActivity.this.isSentSecond) {
                                if (currentPosition == VideoFullScreenActivity.this.mThirdQuartile && !VideoFullScreenActivity.this.isSentThird) {
                                    VideoFullScreenActivity.this.isSentThird = true;
                                    ReportUtil.sendReport("VIDEO_THIRD_QUARTILE", VideoFullScreenActivity.this.mVideoAdData.getTrackingThirdQuartileUrls());
                                }
                            } else {
                                VideoFullScreenActivity.this.isSentSecond = true;
                                ReportUtil.sendReport("VIDEO_MID_POINT", VideoFullScreenActivity.this.mVideoAdData.getTrackingMidpointUrls());
                            }
                        } else {
                            VideoFullScreenActivity.this.isSentFirst = true;
                            ReportUtil.sendReport("VIDEO_FIRST_QUARTILE", VideoFullScreenActivity.this.mVideoAdData.getTrackingFirstQuartileUrls());
                        }
                    }
                    if (VideoFullScreenActivity.this.mHandler != null) {
                        VideoFullScreenActivity.this.mHandler.post(VideoFullScreenActivity.this.updateTimeRunnable);
                        VideoFullScreenActivity.this.mHandler.postDelayed(VideoFullScreenActivity.this.videoPlayTrackerRunnable, 500L);
                        return;
                    }
                    return;
                }
                String str2 = VideoFullScreenActivity.TAG;
                StringBuilder sb = new StringBuilder("::: videoview : ");
                if (VideoFullScreenActivity.this.mVideoView != null) {
                    str = "isPlaying - " + VideoFullScreenActivity.this.mVideoView.isPlaying();
                } else {
                    str = AbstractJsonLexerKt.NULL;
                }
                sb.append(str);
                ADXLogUtil.d(str2, sb.toString());
            } catch (Exception e) {
                ADXLogUtil.e(VideoFullScreenActivity.TAG, e);
            }
        }
    };

    @Override // com.adxcorp.ads.mediation.ui.InterstitialBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            VideoAdData videoAdData = (VideoAdData) this.mAdData;
            this.mVideoAdData = videoAdData;
            if (videoAdData.getOrientation() == 1) {
                setRequestedOrientation(1);
            } else if (this.mVideoAdData.getOrientation() == 2) {
                setRequestedOrientation(6);
            }
            int skipOffset = this.mVideoAdData.getSkipOffset();
            this.mSkipOffsetSec = skipOffset;
            if (skipOffset > 0 && skipOffset < 3) {
                this.mSkipOffsetSec = 3;
            }
            this.mLink = this.mVideoAdData.getLink();
            this.mIsWebViewLanding = this.mVideoAdData.getWebviewLanding() == 1;
            this.mIsClickableVideo = !TextUtils.isEmpty(this.mLink);
            setupContainer();
            setupVideoView();
            setupSeekBar();
            setupClickButton();
            setupCloseButton();
            setupCircleProgressBar();
            setupVolumeButton();
            setupProgressBar();
            setupOptOut();
            SpinningLoaderView spinningLoaderView = this.mProgressBar;
            if (spinningLoaderView != null) {
                spinningLoaderView.setVisibility(0);
            }
            this.mVideoView.setVideoURI(Uri.parse(this.mVideoAdData.getVideoContent()));
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.postDelayed(this.checkVideoPrepared, Constants.VIDEO_PLAY_TIMEOUT);
            }
            this.mVideoView.requestFocus();
            notifyShown();
            if (!this.isSentImpression) {
                this.isSentImpression = true;
                ReportUtil.sendReport("VIDEO_IMPRESSION", this.mVideoAdData.getTrackingImpUrls());
            }
            ArrayList<EndCardData> endCardData = this.mVideoAdData.getEndCardData();
            if (endCardData != null && !endCardData.isEmpty()) {
                this.mEndCardData = endCardData.get(0);
                setupEndCard();
            }
            addBackKeyCallback();
            if (Build.VERSION.SDK_INT >= 30) {
                getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.5
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
                        int i = insets.top;
                        int iMax = Math.max(insets.bottom, Math.max(insets.right, insets.left));
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(VideoFullScreenActivity.TAG, "Insets StatusBar=" + i + " NavBar=" + iMax);
                        }
                        VideoFullScreenActivity videoFullScreenActivity = VideoFullScreenActivity.this;
                        videoFullScreenActivity.setupViewMargin(videoFullScreenActivity.mOptOutImageView, 10, iMax);
                        VideoFullScreenActivity videoFullScreenActivity2 = VideoFullScreenActivity.this;
                        videoFullScreenActivity2.setupViewMargin(videoFullScreenActivity2.mCircularProgressBar, 13, iMax);
                        VideoFullScreenActivity videoFullScreenActivity3 = VideoFullScreenActivity.this;
                        videoFullScreenActivity3.setupViewMargin(videoFullScreenActivity3.mCloseButton, 15, iMax);
                        VideoFullScreenActivity videoFullScreenActivity4 = VideoFullScreenActivity.this;
                        videoFullScreenActivity4.setupViewMargin(videoFullScreenActivity4.mCloseButton2, 15, iMax);
                        return windowInsets;
                    }
                });
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            this.isUserNotification = true;
            notifyVideoError();
            finish();
        }
    }

    private void setupContainer() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.mContainer = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#000000"));
        setContentView(this.mContainer, new RelativeLayout.LayoutParams(-1, -1));
        if (this.mIsClickableVideo) {
            this.mContainer.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoFullScreenActivity.this.clickLink();
                }
            });
        }
    }

    private void setupVideoView() {
        VideoView videoView = new VideoView(this);
        this.mVideoView = videoView;
        videoView.setId(generateViewId());
        this.mVideoView.setZOrderMediaOverlay(true);
        this.mVideoView.setKeepScreenOn(true);
        this.mVideoView.setOnPreparedListener(this);
        this.mVideoView.setOnCompletionListener(this);
        this.mVideoView.setOnErrorListener(this);
        this.mVideoView.setOnInfoListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.mContainer.addView(this.mVideoView, layoutParams);
    }

    private void setupSeekBar() {
        NoSkipSeekBar noSkipSeekBar = new NoSkipSeekBar(this);
        this.mSeekbar = noSkipSeekBar;
        noSkipSeekBar.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, DisplayUtil.dpToPx(this, 4));
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, DisplayUtil.dpToPx(this, 20));
        this.mSeekbar.setLayoutParams(layoutParams);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f}, null, null));
        shapeDrawable.setIntrinsicHeight(0);
        shapeDrawable.setIntrinsicWidth(0);
        this.mSeekbar.setThumb(shapeDrawable);
        this.mContainer.addView(this.mSeekbar);
        try {
            this.mSeekbar.getProgressDrawable().setColorFilter(Color.parseColor("#FF4081"), PorterDuff.Mode.SRC_IN);
            this.mSeekbar.getThumb().setColorFilter(Color.parseColor("#FF4081"), PorterDuff.Mode.SRC_IN);
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
        this.mSeekbar.setVisibility(4);
    }

    private void setupClickButton() {
        if (this.mIsClickableVideo) {
            Button button = new Button(this);
            this.mAdButton = button;
            button.setBackgroundColor(Integer.MIN_VALUE);
            this.mAdButton.setTextColor(-1);
            this.mAdButton.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoFullScreenActivity.this.clickLink();
                }
            });
            if (TextUtils.isEmpty(this.mVideoAdData.getLinkText())) {
                this.mAdButton.setText("자세히 보기");
            } else {
                this.mAdButton.setText(this.mVideoAdData.getLinkText());
            }
            this.mAdButton.setTextSize(2, 12.0f);
            this.mAdButton.setMinimumHeight(0);
            this.mAdButton.setMinimumWidth(0);
            this.mAdButton.setMaxEms(10);
            this.mAdButton.setMaxLines(1);
            this.mAdButton.setSingleLine();
            this.mAdButton.setHeight(DisplayUtil.dpToPx(this, 32));
            this.mAdButton.setAllCaps(false);
            this.mAdButton.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(8, this.mSeekbar.getId());
            layoutParams.addRule(7, this.mSeekbar.getId());
            int iDpToPx = DisplayUtil.dpToPx(this, 10);
            layoutParams.setMargins(0, 0, DisplayUtil.dpToPx(this, 20), iDpToPx);
            this.mAdButton.setLayoutParams(layoutParams);
            this.mAdButton.setPadding(iDpToPx, 0, iDpToPx, 0);
            this.mAdButton.setVisibility(8);
            this.mContainer.addView(this.mAdButton, layoutParams);
        }
    }

    private void setupCloseButton() {
        this.mCloseButton = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this, 28), DisplayUtil.dpToPx(this, 28));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int iDpToPx = DisplayUtil.dpToPx(this, 15);
        layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        this.mCloseButton.setLayoutParams(layoutParams);
        try {
            byte[] bArrDecode = Base64.decode("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", 0);
            this.mCloseButton.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
        this.mCloseButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (VideoFullScreenActivity.this.mEndCardData == null || VideoFullScreenActivity.this.mEndCardContainer == null || !VideoFullScreenActivity.this.mIsLoadedEndCardImage) {
                    VideoFullScreenActivity.this.isUserNotification = true;
                    if (!VideoFullScreenActivity.this.isSentComplete) {
                        VideoFullScreenActivity.this.notifyVideoSkipped();
                    }
                    VideoFullScreenActivity.this.finish();
                } else {
                    VideoFullScreenActivity.this.showEndCard();
                }
                return true;
            }
        });
        this.mCloseButton.setVisibility(8);
        this.mContainer.addView(this.mCloseButton);
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this, 32), DisplayUtil.dpToPx(this, 32));
        layoutParams.addRule(11);
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

    private void setupProgressBar() {
        this.mProgressBar = new SpinningLoaderView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this, 48), DisplayUtil.dpToPx(this, 48));
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setVisibility(8);
        this.mContainer.addView(this.mProgressBar);
    }

    private void setupVolumeButton() {
        this.mVolumeImage = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this, 28), DisplayUtil.dpToPx(this, 28));
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        int iDpToPx = DisplayUtil.dpToPx(this, 15);
        layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        this.mVolumeImage.setLayoutParams(layoutParams);
        this.mVolumeImage.setVisibility(8);
        this.mVolumeImage.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoFullScreenActivity.this.setVolumeImage();
                if (VideoFullScreenActivity.this.mIsVolumeOn) {
                    if (VideoFullScreenActivity.this.mute()) {
                        VideoFullScreenActivity.this.mIsVolumeOn = false;
                        VideoFullScreenActivity.this.mVolumeImage.setImageBitmap(VideoFullScreenActivity.this.mVolumeOffBitmap);
                        return;
                    }
                    return;
                }
                if (VideoFullScreenActivity.this.unmute()) {
                    VideoFullScreenActivity.this.mIsVolumeOn = true;
                    VideoFullScreenActivity.this.mVolumeImage.setImageBitmap(VideoFullScreenActivity.this.mVolumeOnBitmap);
                }
            }
        });
        setVolumeImage();
        this.mVolumeImage.setImageBitmap(this.mVolumeOffBitmap);
        this.mContainer.addView(this.mVolumeImage);
    }

    private void setupOptOut() {
        this.mOptOutImageView = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this, 20), DisplayUtil.dpToPx(this, 20));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        int iDpToPx = DisplayUtil.dpToPx(this, 10);
        layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        this.mOptOutImageView.setLayoutParams(layoutParams);
        final String optoutImageUrl = this.mVideoAdData.getOptoutImageUrl();
        if (!TextUtils.isEmpty(optoutImageUrl)) {
            this.mOptOutImageView.setImageBitmap(null);
            NativeAdImageHelper nativeAdImageHelper = new NativeAdImageHelper(this);
            HashMap<String, ImageView> map = new HashMap<>();
            map.put(optoutImageUrl, this.mOptOutImageView);
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(TAG, ":::setupOptOut::: load - " + optoutImageUrl);
            }
            nativeAdImageHelper.load(map, new NativeAdImageHelper.ImageLoadEventListener() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.10
                @Override // com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.ImageLoadEventListener
                public void onSuccess() {
                    if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                        ADXLogUtil.d(VideoFullScreenActivity.TAG, ":::setupOptOut:::onSuccess - " + optoutImageUrl);
                    }
                    VideoFullScreenActivity.this.mOptOutImageView.setVisibility(0);
                }

                @Override // com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.ImageLoadEventListener
                public void onError() {
                    if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                        ADXLogUtil.d(VideoFullScreenActivity.TAG, ":::setupOptOut:::onError - " + optoutImageUrl);
                    }
                    VideoFullScreenActivity.this.mOptOutImageView.setVisibility(8);
                }
            });
        } else {
            this.mOptOutImageView.setImageBitmap(null);
            this.mOptOutImageView.setVisibility(8);
        }
        this.mOptOutImageView.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ClickThroughUtil.isValidClick()) {
                    if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                        ADXLogUtil.d(VideoFullScreenActivity.TAG, ":::clickEvent::: OptOut : " + VideoFullScreenActivity.this.mVideoAdData.getOptoutLink() + " -> block");
                        return;
                    }
                    return;
                }
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(VideoFullScreenActivity.TAG, ":::clickEvent::: OptOut : " + VideoFullScreenActivity.this.mVideoAdData.getOptoutLink());
                }
                VideoFullScreenActivity videoFullScreenActivity = VideoFullScreenActivity.this;
                ClickThroughUtil.goToBrowser(videoFullScreenActivity, videoFullScreenActivity.mVideoAdData.getOptoutLink());
            }
        });
        this.mContainer.addView(this.mOptOutImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupViewMargin(View view, int i, int i2) {
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            int iDpToPx = DisplayUtil.dpToPx(this, i);
            int i3 = getResources().getConfiguration().orientation;
            if (i3 == 2) {
                layoutParams.setMargins(iDpToPx, iDpToPx, i2 + iDpToPx, iDpToPx);
            } else if (i3 == 1) {
                layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, i2 + iDpToPx);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    private void setupCloseButton2() {
        this.mCloseButton2 = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this, 28), DisplayUtil.dpToPx(this, 28));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int iDpToPx = DisplayUtil.dpToPx(this, 15);
        layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        this.mCloseButton2.setLayoutParams(layoutParams);
        try {
            byte[] bArrDecode = Base64.decode("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", 0);
            this.mCloseButton2.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
        this.mCloseButton2.setOnTouchListener(new View.OnTouchListener() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoFullScreenActivity.this.isUserNotification = true;
                if (!VideoFullScreenActivity.this.isSentComplete) {
                    VideoFullScreenActivity.this.notifyVideoSkipped();
                }
                VideoFullScreenActivity.this.finish();
                return true;
            }
        });
        this.mCloseButton2.setVisibility(8);
        this.mEndCardContainer.addView(this.mCloseButton2);
    }

    private void setupEndCard() {
        if (this.mEndCardData == null) {
            return;
        }
        this.mEndCardContainer = new RelativeLayout(this);
        if (this.mEndCardData.getResourceType() == 0) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.mEndCardContainer.addView(imageView);
            final String resource = this.mEndCardData.getResource();
            if (!TextUtils.isEmpty(resource)) {
                imageView.setImageBitmap(null);
                NativeAdImageHelper nativeAdImageHelper = new NativeAdImageHelper(this);
                HashMap<String, ImageView> map = new HashMap<>();
                map.put(resource, imageView);
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(TAG, ":::setupEndCard::: load - " + resource);
                }
                nativeAdImageHelper.load(map, new NativeAdImageHelper.ImageLoadEventListener() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.13
                    @Override // com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.ImageLoadEventListener
                    public void onSuccess() {
                        VideoFullScreenActivity.this.mIsLoadedEndCardImage = true;
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(VideoFullScreenActivity.TAG, ":::setupEndCard:::onSuccess - " + resource);
                        }
                    }

                    @Override // com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.ImageLoadEventListener
                    public void onError() {
                        VideoFullScreenActivity.this.mIsLoadedEndCardImage = false;
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(VideoFullScreenActivity.TAG, ":::setupEndCard:::onError - " + resource);
                        }
                    }
                });
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoFullScreenActivity.this.clickEndCard();
                }
            });
        } else {
            if (this.mEndCardData.getResourceType() != 1) {
                return;
            }
            this.mEndCardContentView = new AdContentView(this, new AdContentView.AdContentEventListener() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.15
                @Override // com.adxcorp.ads.mediation.ui.AdContentView.AdContentEventListener
                public void onViewClicked(String str) {
                }

                @Override // com.adxcorp.ads.mediation.ui.AdContentView.AdContentEventListener
                public void onViewLoadTimeout(AdContentView adContentView) {
                }

                @Override // com.adxcorp.ads.mediation.ui.AdContentView.AdContentEventListener
                public void onViewLoaded(AdContentView adContentView) {
                }

                @Override // com.adxcorp.ads.mediation.ui.AdContentView.AdContentEventListener
                public void onViewClicked() {
                    VideoFullScreenActivity.this.notifyClick();
                    if (VideoFullScreenActivity.this.mVideoAdData != null && !VideoFullScreenActivity.this.isSentClick) {
                        VideoFullScreenActivity.this.isSentClick = true;
                        ReportUtil.sendReport("VIDEO_CLICK", VideoFullScreenActivity.this.mVideoAdData.getTrackingClkUrls());
                    }
                    if (VideoFullScreenActivity.this.mEndCardData == null || VideoFullScreenActivity.this.isSentEndCardClick) {
                        return;
                    }
                    VideoFullScreenActivity.this.isSentEndCardClick = true;
                    ReportUtil.sendReport("VIDEO_ENDCARD_CLICK", VideoFullScreenActivity.this.mEndCardData.getClickTracking());
                }
            });
            AdData adData = new AdData();
            adData.setAdm(this.mEndCardData.getResource());
            this.mEndCardContentView.setAdData(adData);
            this.mEndCardContentView.showContent();
            this.mEndCardContainer.addView(this.mEndCardContentView);
        }
        setupCloseButton2();
        this.mEndCardContainer.setVisibility(4);
        this.mContainer.addView(this.mEndCardContainer, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEndCard() {
        try {
            this.mContainer.removeAllViews();
            this.mContainer.addView(this.mEndCardContainer);
            this.mEndCardContainer.setVisibility(0);
            this.mCloseButton2.setVisibility(0);
            EndCardData endCardData = this.mEndCardData;
            if (endCardData == null || this.isSentEndCardImpression) {
                return;
            }
            this.isSentEndCardImpression = true;
            ReportUtil.sendReport("VIDEO_ENDCARD_IMPRESSION", endCardData.getCreativeView());
        } catch (Exception e) {
            e.printStackTrace();
            this.isUserNotification = true;
            if (!this.isSentComplete) {
                notifyVideoSkipped();
            }
            finish();
        }
    }

    @Override // com.adxcorp.ads.mediation.ui.InterstitialBaseActivity, android.app.Activity
    protected void onPause() {
        VideoView videoView;
        if (!isFinishing()) {
            VideoView videoView2 = this.mVideoView;
            if (videoView2 != null) {
                try {
                    this.mStopPosition = videoView2.getCurrentPosition();
                    this.mVideoView.pause();
                } catch (Exception unused) {
                }
                notifyVideoPaused();
            }
        } else if (!this.isUserNotification && (videoView = this.mVideoView) != null && videoView.isPlaying()) {
            notifyVideoStopped();
        }
        AdContentView adContentView = this.mEndCardContentView;
        if (adContentView != null) {
            adContentView.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        VideoView videoView = this.mVideoView;
        if (videoView != null) {
            videoView.resume();
        }
        AdContentView adContentView = this.mEndCardContentView;
        if (adContentView != null) {
            adContentView.onResume();
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        try {
            String str = TAG;
            ADXLogUtil.d(str, "onPrepared - position : " + this.mVideoView.getCurrentPosition() + ", stopPosition : " + this.mStopPosition);
            this.mIsPrepared = true;
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(this.checkVideoPrepared);
            }
            this.mMediaPlayer = mediaPlayer;
            int duration = mediaPlayer.getDuration();
            NoSkipSeekBar noSkipSeekBar = this.mSeekbar;
            if (noSkipSeekBar != null) {
                noSkipSeekBar.setMax(duration);
            }
            long j = duration;
            ADXLogUtil.d(str, String.format("onPrepared - %d:%d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))));
            int i = duration / 1000;
            this.mVideoDuration = i;
            if (this.mSkipOffsetSec > i) {
                this.mSkipOffsetSec = i;
            }
            this.mFirstQuartile = i / 4;
            this.mSecondQuartile = i / 2;
            this.mThirdQuartile = (i * 3) / 4;
            mediaPlayer.setOnVideoSizeChangedListener(this);
            mediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.16
                @Override // android.media.MediaPlayer.OnSeekCompleteListener
                public void onSeekComplete(MediaPlayer mediaPlayer2) {
                    ADXLogUtil.d(VideoFullScreenActivity.TAG, "onSeekComplete");
                    mediaPlayer2.start();
                    if (VideoFullScreenActivity.this.mProgressBar != null) {
                        VideoFullScreenActivity.this.mProgressBar.setVisibility(8);
                    }
                    if (VideoFullScreenActivity.this.mVolumeImage != null) {
                        VideoFullScreenActivity.this.mVolumeImage.setVisibility(0);
                    }
                    if (!VideoFullScreenActivity.this.mIsVolumeOn) {
                        VideoFullScreenActivity.this.mute();
                    }
                    if (VideoFullScreenActivity.this.mHandler != null) {
                        VideoFullScreenActivity.this.mHandler.removeCallbacks(VideoFullScreenActivity.this.videoPlayTrackerRunnable);
                        VideoFullScreenActivity.this.mHandler.post(VideoFullScreenActivity.this.videoPlayTrackerRunnable);
                    }
                    if (VideoFullScreenActivity.this.isSentStart) {
                        return;
                    }
                    VideoFullScreenActivity.this.isSentStart = true;
                    VideoFullScreenActivity.this.notifyVideoStarted();
                    ReportUtil.sendReport("VIDEO_START", VideoFullScreenActivity.this.mVideoAdData.getTrackingStartUrls());
                }
            });
            if (this.isSentComplete) {
                new VideoThumbnail(this.mVideoView, this.mVideoAdData.getVideoContent(), j).execute();
            } else if (Build.VERSION.SDK_INT >= 26) {
                this.mMediaPlayer.seekTo(this.mStopPosition, 3);
            } else {
                this.mMediaPlayer.seekTo(this.mStopPosition);
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            this.isUserNotification = true;
            notifyVideoError();
            finish();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        ADXLogUtil.d(TAG, "onError - what : " + i + ", extra : " + i2);
        this.isUserNotification = true;
        notifyVideoError();
        finish();
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 701) {
            ADXLogUtil.d(TAG, "MediaPlayer Buffering Start");
            SpinningLoaderView spinningLoaderView = this.mProgressBar;
            if (spinningLoaderView != null) {
                spinningLoaderView.setVisibility(0);
            }
        } else if (i == 702) {
            ADXLogUtil.d(TAG, "MediaPlayer Buffering End");
            SpinningLoaderView spinningLoaderView2 = this.mProgressBar;
            if (spinningLoaderView2 != null) {
                spinningLoaderView2.setVisibility(8);
            }
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Handler handler;
        ADXLogUtil.d(TAG, "onCompletion - video current position : " + this.mVideoCurPosSec + ", duration : " + this.mVideoDuration);
        NoSkipSeekBar noSkipSeekBar = this.mSeekbar;
        if (noSkipSeekBar != null) {
            noSkipSeekBar.setProgress(noSkipSeekBar.getMax());
        }
        CircularProgressBar circularProgressBar = this.mCircularProgressBar;
        if (circularProgressBar != null) {
            circularProgressBar.setVisibility(8);
        }
        TextView textView = this.mTimerTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.mCloseButton;
        if (imageView != null && imageView.getVisibility() != 0 && (handler = this.mHandler) != null) {
            handler.post(this.showCloseButton);
        }
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.videoPlayTrackerRunnable);
        }
        VideoView videoView = this.mVideoView;
        if (videoView != null) {
            videoView.stopPlayback();
        }
        this.isUserNotification = true;
        notifyVideoCompleted();
        if (this.isSentComplete) {
            return;
        }
        this.isSentComplete = true;
        ReportUtil.sendReport("VIDEO_COMPLETE", this.mVideoAdData.getTrackingCompleteUrls());
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        String str;
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("onVideoSizeChanged - video size : ");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        sb.append(", Container size : ");
        sb.append(this.mContainer.getWidth());
        sb.append("x");
        sb.append(this.mContainer.getHeight());
        if (this.mVideoView != null) {
            str = ", VideoView size : " + this.mVideoView.getWidth() + "x" + this.mVideoView.getHeight();
        } else {
            str = "";
        }
        sb.append(str);
        ADXLogUtil.d(str2, sb.toString());
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            return;
        }
        int i = configuration.orientation;
    }

    @Override // com.adxcorp.ads.mediation.ui.InterstitialBaseActivity, android.app.Activity
    protected void onDestroy() {
        try {
            SpinningLoaderView spinningLoaderView = this.mProgressBar;
            if (spinningLoaderView != null) {
                spinningLoaderView.setVisibility(8);
                this.mProgressBar = null;
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(this.checkVideoPrepared);
                this.mHandler.removeCallbacks(this.videoPlayTrackerRunnable);
                this.mHandler.removeCallbacks(this.updateTimeRunnable);
            }
            VideoView videoView = this.mVideoView;
            if (videoView != null) {
                videoView.stopPlayback();
                this.mVideoView = null;
            }
            AdContentView adContentView = this.mEndCardContentView;
            if (adContentView != null) {
                adContentView.setVisibility(8);
                this.mEndCardContentView.onDestroy();
                this.mEndCardContentView = null;
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mVideoAdData.getBackButtonEnabled() == 0) {
                return true;
            }
            ImageView imageView = this.mCloseButton;
            if (imageView != null) {
                if (imageView.getVisibility() == 0) {
                    if (this.mEndCardData == null || this.mEndCardContainer == null) {
                        this.isUserNotification = true;
                        if (!this.isSentComplete) {
                            notifyVideoSkipped();
                        }
                        finish();
                    }
                } else {
                    ImageView imageView2 = this.mCloseButton2;
                    if (imageView2 != null && imageView2.getVisibility() == 0) {
                        this.isUserNotification = true;
                        if (!this.isSentComplete) {
                            notifyVideoSkipped();
                        }
                        finish();
                    }
                }
            } else {
                this.isUserNotification = true;
                if (!this.isSentComplete) {
                    notifyVideoSkipped();
                }
                finish();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void setVolumeImage() {
        try {
            if (this.mVolumeOffBitmap == null) {
                byte[] bArrDecode = Base64.decode("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", 0);
                this.mVolumeOffBitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            }
            if (this.mVolumeOnBitmap == null) {
                byte[] bArrDecode2 = Base64.decode("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ygcffCBfffVVIwISo2ZLx3F6geASBpCEiG5qpJMOAOPSSy9tOGOrVq0MGI844gijQwJGp8sHqmPYTJk6VY7v2lVmzJghn332WSMCktobumAgsgM3saoWkHyf2op7AsE9518CaHC+JZZYQlZbbTXZdttt5fDDD5c999xTlluOhPgmzukev//+u0yZMkU6d+4ss2fPlo8/jrZYjznx4WXgWRlVB0jepZ00PT6xuAP5wKoFJLSnXd5DOcdaxemz4bhz2Ow111xTOnbsaMC4ySabmN97AVFvagA5dap07tRJZs2aJZ98EsoDstAcFYjosbibmJvqpxk1nOhMwtlBdO8NFL2pFpBtROQfIsK/dTvYeDggm77++uvLkUceaQC5+uqrG6OmHBghCoCcOnWqdOnSRWbOnCmffvppzVxMXxDuvfLKK8u6664rP/74o7zzzjvm3r/88ksWXUz4vPax/c0DuQirBWTd+x4BHPoiVvSuu+5qdMXtt9/eRGKchku5t1FF9gknnCDvv/++fP755wakYYfqsMxpxx13NPPaeOONjUvp+eeflyeffNI8hwgRwMzYoK85pSyBJlYNIOGKH2RssZFOB44IILGcjzrqKKMDwiGJwFTiis6JKCC79+gh06dNqxmQqAgtWrSQgw46SPr06SNt2rQxc2LMnTtXnnjiCbnmmmsMt8QZn0HxjZMcF2HFcGI1gKTzBApqXQ7AiBUNmAAikRc2XmPV1SzaWNlTphi3z7QaAanccY011pDhw4dL+/bt/zAn5gsIx4x5VPr3v8ioCD/99FPWOCX9zAknVmywHxSQJN8SmSEsVHcDrrjSSisZQKIvdurUyYQDEdHVcEYlDIB84403FgDyiy++CC2y4YRLLbWUseyvvfZao8cydF5qYQPKhx9+WE4//XTDNRHdGRLfd9sq1IoHgwYFJK2W36k3JAJENhwDBrdO9+7djVgk8sLfwg4ASfjwpJNOMo7xWnRIXE7otKgQAwcONLqs1wCY33//vTzyyCNy6qmnGn0yY+KbcDOMrazLISggudm39dR2Ga6DbvbNN9/IDjvsIGeccYbstttuBpxhuKITJABy4qRJckK3bvLRRx/V5BjnxQCU7dq1M+FI5ZB+oMTyRqcklo7Lif/zycCgzOGxSvMIAki6qL5STw3p4TLojKussopss802hqOof7ESwYL8HUBO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", 0);
                this.mVolumeOnBitmap = BitmapFactory.decodeByteArray(bArrDecode2, 0, bArrDecode2.length);
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    public boolean mute() {
        return setVolume(0);
    }

    public boolean unmute() {
        return setVolume(100);
    }

    private boolean setVolume(int i) {
        try {
            if (this.mMediaPlayer == null) {
                return false;
            }
            int i2 = 100 - i;
            float fLog = (float) (1.0d - ((i2 > 0 ? Math.log(i2) : 0.0d) / Math.log(100.0d)));
            this.mMediaPlayer.setVolume(fLog, fLog);
            return true;
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            return false;
        }
    }

    private int generateViewId() {
        return View.generateViewId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickLink() {
        if (!ClickThroughUtil.isValidClick()) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(TAG, ":::clickEvent::: " + this.mLink + " -> block");
                return;
            }
            return;
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, ":::clickEvent::: " + this.mLink + " -> isWebViewLanding : " + this.mIsWebViewLanding);
        }
        if (this.mIsWebViewLanding) {
            HttpUtil.getFinalURL(this.mLink, new Handler(Looper.getMainLooper()) { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.17
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what != 100) {
                        return;
                    }
                    try {
                        if (ClickThroughUtil.goToWebView(VideoFullScreenActivity.this, (String) message.obj)) {
                            VideoFullScreenActivity.this.notifyClick();
                            if (VideoFullScreenActivity.this.mVideoAdData != null && !VideoFullScreenActivity.this.isSentClick) {
                                VideoFullScreenActivity.this.isSentClick = true;
                                ReportUtil.sendReport("VIDEO_CLICK", VideoFullScreenActivity.this.mVideoAdData.getTrackingClkUrls());
                            }
                        } else if (ClickThroughUtil.goToBrowser(VideoFullScreenActivity.this, (String) message.obj)) {
                            VideoFullScreenActivity.this.notifyClick();
                            if (VideoFullScreenActivity.this.mVideoAdData != null && !VideoFullScreenActivity.this.isSentClick) {
                                VideoFullScreenActivity.this.isSentClick = true;
                                ReportUtil.sendReport("VIDEO_CLICK", VideoFullScreenActivity.this.mVideoAdData.getTrackingClkUrls());
                            }
                        }
                    } catch (Exception e) {
                        ADXLogUtil.e(VideoFullScreenActivity.TAG, e);
                    }
                }
            });
            return;
        }
        if (ClickThroughUtil.goToBrowser(this, this.mLink)) {
            notifyClick();
            VideoAdData videoAdData = this.mVideoAdData;
            if (videoAdData == null || this.isSentClick) {
                return;
            }
            this.isSentClick = true;
            ReportUtil.sendReport("VIDEO_CLICK", videoAdData.getTrackingClkUrls());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickEndCard() {
        String clickThrough = this.mEndCardData.getClickThrough();
        if (!ClickThroughUtil.isValidClick()) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(TAG, ":::clickEvent::: " + clickThrough + " -> block");
                return;
            }
            return;
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, ":::clickEvent::: " + clickThrough + " -> isWebViewLanding : " + this.mIsWebViewLanding);
        }
        if (this.mIsWebViewLanding) {
            HttpUtil.getFinalURL(clickThrough, new Handler(Looper.getMainLooper()) { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity.18
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what != 100) {
                        return;
                    }
                    try {
                        if (ClickThroughUtil.goToWebView(VideoFullScreenActivity.this, (String) message.obj)) {
                            VideoFullScreenActivity.this.notifyClick();
                            if (VideoFullScreenActivity.this.mVideoAdData != null && !VideoFullScreenActivity.this.isSentClick) {
                                VideoFullScreenActivity.this.isSentClick = true;
                                ReportUtil.sendReport("VIDEO_CLICK", VideoFullScreenActivity.this.mVideoAdData.getTrackingClkUrls());
                            }
                            if (VideoFullScreenActivity.this.mEndCardData == null || VideoFullScreenActivity.this.isSentEndCardClick) {
                                return;
                            }
                            VideoFullScreenActivity.this.isSentEndCardClick = true;
                            ReportUtil.sendReport("VIDEO_ENDCARD_CLICK", VideoFullScreenActivity.this.mEndCardData.getClickTracking());
                            return;
                        }
                        if (ClickThroughUtil.goToBrowser(VideoFullScreenActivity.this, (String) message.obj)) {
                            VideoFullScreenActivity.this.notifyClick();
                            if (VideoFullScreenActivity.this.mVideoAdData != null && !VideoFullScreenActivity.this.isSentClick) {
                                VideoFullScreenActivity.this.isSentClick = true;
                                ReportUtil.sendReport("VIDEO_CLICK", VideoFullScreenActivity.this.mVideoAdData.getTrackingClkUrls());
                            }
                            if (VideoFullScreenActivity.this.mEndCardData == null || VideoFullScreenActivity.this.isSentEndCardClick) {
                                return;
                            }
                            VideoFullScreenActivity.this.isSentEndCardClick = true;
                            ReportUtil.sendReport("VIDEO_ENDCARD_CLICK", VideoFullScreenActivity.this.mEndCardData.getClickTracking());
                        }
                    } catch (Exception e) {
                        ADXLogUtil.e(VideoFullScreenActivity.TAG, e);
                    }
                }
            });
            return;
        }
        if (ClickThroughUtil.goToBrowser(this, clickThrough)) {
            notifyClick();
            VideoAdData videoAdData = this.mVideoAdData;
            if (videoAdData != null && !this.isSentClick) {
                this.isSentClick = true;
                ReportUtil.sendReport("VIDEO_CLICK", videoAdData.getTrackingClkUrls());
            }
            EndCardData endCardData = this.mEndCardData;
            if (endCardData == null || this.isSentEndCardClick) {
                return;
            }
            this.isSentEndCardClick = true;
            ReportUtil.sendReport("VIDEO_ENDCARD_CLICK", endCardData.getClickTracking());
        }
    }

    private void addBackKeyCallback() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, new OnBackInvokedCallback() { // from class: com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity$$ExternalSyntheticLambda0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    this.f$0.m4352x3357c778();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$addBackKeyCallback$0$com-adxcorp-ads-mediation-videoads-VideoFullScreenActivity, reason: not valid java name */
    /* synthetic */ void m4352x3357c778() {
        if (this.mVideoAdData.getBackButtonEnabled() == 0) {
            return;
        }
        ImageView imageView = this.mCloseButton;
        if (imageView != null) {
            if (imageView.getVisibility() == 0) {
                if (this.mEndCardData == null || this.mEndCardContainer == null) {
                    this.isUserNotification = true;
                    if (!this.isSentComplete) {
                        notifyVideoSkipped();
                    }
                    finish();
                    return;
                }
                return;
            }
            ImageView imageView2 = this.mCloseButton2;
            if (imageView2 == null || imageView2.getVisibility() != 0) {
                return;
            }
            this.isUserNotification = true;
            if (!this.isSentComplete) {
                notifyVideoSkipped();
            }
            finish();
            return;
        }
        this.isUserNotification = true;
        if (!this.isSentComplete) {
            notifyVideoSkipped();
        }
        finish();
    }

    public class NoSkipSeekBar extends SeekBar {
        @Override // android.widget.AbsSeekBar, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        public NoSkipSeekBar(Context context) {
            super(context);
        }

        public NoSkipSeekBar(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public NoSkipSeekBar(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }
}
