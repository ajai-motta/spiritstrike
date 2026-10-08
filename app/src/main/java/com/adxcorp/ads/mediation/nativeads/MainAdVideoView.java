package com.adxcorp.ads.mediation.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.common.Constants;
import com.adxcorp.ads.mediation.event.InhouseAdEventListener;
import com.adxcorp.ads.mediation.nativeads.util.VideoThumbnail;
import com.adxcorp.ads.mediation.ui.progressbar.SpinningLoaderView;
import com.adxcorp.ads.mediation.util.ClickThroughUtil;
import com.adxcorp.ads.mediation.util.DisplayUtil;
import com.adxcorp.ads.mediation.util.HttpUtil;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.ads.mediation.videoads.VideoAdData;
import com.adxcorp.util.ADXLogUtil;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class MainAdVideoView extends FrameLayout implements TextureView.SurfaceTextureListener {
    public static final String TAG = "MainAdVideoView";
    private Runnable checkVideoPrepared;
    private boolean isSentComplete;
    private boolean isSentFirst;
    private boolean isSentImpression;
    private boolean isSentSecond;
    private boolean isSentStart;
    private boolean isSentThird;
    private Button mAdButton;
    private InhouseAdEventListener mAdEventListener;
    private View mBackgroundView;
    private RelativeLayout mContainer;
    private Context mContext;
    private int mFirstQuartile;
    private boolean mIsAutoPlay;
    private boolean mIsClickableVideo;
    private boolean mIsPrepared;
    private boolean mIsPreparing;
    private boolean mIsReady;
    private boolean mIsVisible;
    private boolean mIsVolumeOn;
    private boolean mIsWebViewLanding;
    private String mLink;
    private MediaPlayer mMediaPlayer;
    private ImageView mPauseImageView;
    private ImageView mPlayImageView;
    private RelativeLayout mPlayStateContainer;
    private SpinningLoaderView mProgressBar;
    private RelativeLayout mReadyStateContainer;
    private ImageView mRestartImageView;
    private int mSecondQuartile;
    private NoSkipSeekBar mSeekbar;
    private SurfaceTexture mSurfaceTexture;
    private TextureView mTextureView;
    private int mThirdQuartile;
    private String mUrl;
    private VideoAdData mVideoAdData;
    private int mVideoCurPosSec;
    private int mVideoDuration;
    private int mVideoHeight;
    private int mVideoWidth;
    private ImageView mVolumeImage;
    private Bitmap mVolumeOffBitmap;
    private Bitmap mVolumeOnBitmap;
    private Runnable videoPlayTrackerRunnable;

    private void adjustAspectRatio(int i, int i2) {
    }

    public MainAdVideoView(Context context) {
        super(context);
        this.videoPlayTrackerRunnable = new Runnable() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    if (MainAdVideoView.this.mMediaPlayer != null && MainAdVideoView.this.mMediaPlayer.isPlaying()) {
                        MainAdVideoView.this.setVisibleContainer(false, true);
                        MainAdVideoView mainAdVideoView = MainAdVideoView.this;
                        mainAdVideoView.mVideoCurPosSec = mainAdVideoView.mMediaPlayer.getCurrentPosition() / 1000;
                        ADXLogUtil.d(MainAdVideoView.TAG, "video current position  : " + MainAdVideoView.this.mVideoCurPosSec);
                        if (MainAdVideoView.this.mVideoCurPosSec > 0 && MainAdVideoView.this.mVideoAdData != null) {
                            if (MainAdVideoView.this.mVideoCurPosSec != MainAdVideoView.this.mFirstQuartile || MainAdVideoView.this.isSentFirst) {
                                if (MainAdVideoView.this.mVideoCurPosSec != MainAdVideoView.this.mSecondQuartile || MainAdVideoView.this.isSentSecond) {
                                    if (MainAdVideoView.this.mVideoCurPosSec == MainAdVideoView.this.mThirdQuartile && !MainAdVideoView.this.isSentThird) {
                                        MainAdVideoView.this.isSentThird = true;
                                        ReportUtil.sendReport("VIDEO_THIRD_QUARTILE", MainAdVideoView.this.mVideoAdData.getTrackingThirdQuartileUrls());
                                    }
                                } else {
                                    MainAdVideoView.this.isSentSecond = true;
                                    ReportUtil.sendReport("VIDEO_MID_POINT", MainAdVideoView.this.mVideoAdData.getTrackingMidpointUrls());
                                }
                            } else {
                                MainAdVideoView.this.isSentFirst = true;
                                ReportUtil.sendReport("VIDEO_FIRST_QUARTILE", MainAdVideoView.this.mVideoAdData.getTrackingFirstQuartileUrls());
                            }
                        }
                        if (MainAdVideoView.this.mSeekbar != null && MainAdVideoView.this.mMediaPlayer != null) {
                            MainAdVideoView.this.mSeekbar.setProgress(MainAdVideoView.this.mMediaPlayer.getCurrentPosition());
                        }
                        MainAdVideoView mainAdVideoView2 = MainAdVideoView.this;
                        mainAdVideoView2.postDelayed(mainAdVideoView2.videoPlayTrackerRunnable, 500L);
                        return;
                    }
                    String str2 = MainAdVideoView.TAG;
                    StringBuilder sb = new StringBuilder("::: videoview : ");
                    if (MainAdVideoView.this.mMediaPlayer != null) {
                        str = "isPlaying - " + MainAdVideoView.this.mMediaPlayer.isPlaying();
                    } else {
                        str = AbstractJsonLexerKt.NULL;
                    }
                    sb.append(str);
                    ADXLogUtil.d(str2, sb.toString());
                } catch (Exception e) {
                    ADXLogUtil.e(MainAdVideoView.TAG, e);
                }
            }
        };
        this.checkVideoPrepared = new Runnable() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                if (MainAdVideoView.this.mIsPrepared) {
                    return;
                }
                MainAdVideoView.this.notifyError();
                MainAdVideoView.this.stopVideo();
            }
        };
        this.mContext = context;
        if (this.mTextureView == null) {
            this.mTextureView = new TextureView(this.mContext);
            this.mTextureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mTextureView.setSurfaceTextureListener(this);
            addView(this.mTextureView, 0);
        }
        initLayout();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        ADXLogUtil.d(TAG, "onSurfaceTextureAvailable");
        this.mSurfaceTexture = surfaceTexture;
        this.mIsReady = true;
        setVisibleContainer(true, false);
        if (getBackground() == null) {
            new VideoThumbnail(this, this.mUrl).execute();
        }
        if (!this.isSentImpression) {
            this.isSentImpression = true;
            ReportUtil.sendReport("VIDEO_IMPRESSION", this.mVideoAdData.getTrackingImpUrls());
        }
        if (this.mIsAutoPlay) {
            startVideo();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        ADXLogUtil.d(TAG, "onSurfaceTextureSizeChanged");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        ADXLogUtil.d(TAG, "onSurfaceTextureDestroyed");
        this.mIsReady = false;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            notifyStopped();
        }
        stopVideo();
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        ADXLogUtil.d(TAG, "onSurfaceTextureUpdated");
    }

    public void pauseVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            ImageView imageView = this.mRestartImageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            fadeOutAndHideImage(this.mPauseImageView);
            notifyPaused();
        }
    }

    public void restartVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            removeCallbacks(this.videoPlayTrackerRunnable);
            post(this.videoPlayTrackerRunnable);
            ImageView imageView = this.mPauseImageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            fadeOutAndHideImage(this.mRestartImageView);
            notifyStarted();
        }
    }

    public void stopVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        setVisibleContainer(true, false);
        SpinningLoaderView spinningLoaderView = this.mProgressBar;
        if (spinningLoaderView != null) {
            spinningLoaderView.setVisibility(8);
        }
        ImageView imageView = this.mPauseImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.mRestartImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        removeCallbacks(this.checkVideoPrepared);
        removeCallbacks(this.videoPlayTrackerRunnable);
        this.mIsPreparing = false;
    }

    public void startVideo() {
        ADXLogUtil.d(TAG, ":::start::: isReady : " + this.mIsReady + ", isLoading : " + this.mIsPreparing);
        if (!this.mIsReady || this.mIsPreparing) {
            return;
        }
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                stopVideo();
                this.mIsPreparing = true;
                this.mMediaPlayer = createMediaPlayer();
                this.mMediaPlayer.setSurface(new Surface(this.mSurfaceTexture));
                this.mMediaPlayer.setDataSource(this.mUrl);
                this.mMediaPlayer.prepareAsync();
                this.mIsPrepared = false;
                postDelayed(this.checkVideoPrepared, Constants.VIDEO_PLAY_TIMEOUT);
                setVisibleContainer(false, false);
            }
        } catch (Exception e) {
            this.mIsPreparing = false;
            ADXLogUtil.e(TAG, e);
            notifyError();
            stopVideo();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        String str = TAG;
        StringBuilder sb = new StringBuilder("onWindowVisibilityChanged(");
        sb.append(i);
        sb.append("): ");
        sb.append(i == 0 ? "VISIBLE" : "INVISIBLE");
        ADXLogUtil.d(str, sb.toString());
        if (i == 0) {
            if (!this.mIsVisible) {
                initLayout();
            }
            this.mIsVisible = true;
        } else {
            this.mIsVisible = false;
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                notifyStopped();
            }
            stopVideo();
        }
    }

    private MediaPlayer createMediaPlayer() {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build());
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.3
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer2) {
                    ADXLogUtil.d(MainAdVideoView.TAG, "onPrepared");
                    MainAdVideoView.this.mIsPrepared = true;
                    MainAdVideoView.this.mIsPreparing = false;
                    MainAdVideoView mainAdVideoView = MainAdVideoView.this;
                    mainAdVideoView.removeCallbacks(mainAdVideoView.checkVideoPrepared);
                    int videoWidth = mediaPlayer2.getVideoWidth();
                    int videoHeight = mediaPlayer2.getVideoHeight();
                    if (videoWidth <= 0 || videoHeight <= 0) {
                        return;
                    }
                    MainAdVideoView.this.mVideoWidth = videoWidth;
                    MainAdVideoView.this.mVideoHeight = videoHeight;
                    ADXLogUtil.d(MainAdVideoView.TAG, "videoWidth : " + videoWidth + ", videoHeight : " + videoHeight + ", videoProportion : " + (videoWidth / videoHeight));
                    int duration = mediaPlayer2.getDuration();
                    String str = MainAdVideoView.TAG;
                    StringBuilder sb = new StringBuilder("finalTime : ");
                    sb.append(duration);
                    ADXLogUtil.d(str, sb.toString());
                    long j = (long) duration;
                    ADXLogUtil.d(MainAdVideoView.TAG, String.format("onPrepared - %d:%d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))));
                    MainAdVideoView.this.mVideoDuration = duration / 1000;
                    MainAdVideoView mainAdVideoView2 = MainAdVideoView.this;
                    mainAdVideoView2.mFirstQuartile = mainAdVideoView2.mVideoDuration / 4;
                    MainAdVideoView mainAdVideoView3 = MainAdVideoView.this;
                    mainAdVideoView3.mSecondQuartile = mainAdVideoView3.mVideoDuration / 2;
                    MainAdVideoView mainAdVideoView4 = MainAdVideoView.this;
                    mainAdVideoView4.mThirdQuartile = (mainAdVideoView4.mVideoDuration * 3) / 4;
                    if (MainAdVideoView.this.mSeekbar != null) {
                        MainAdVideoView.this.mSeekbar.setMax(duration);
                    }
                    MainAdVideoView.this.mute();
                    MainAdVideoView.this.mIsVolumeOn = false;
                    MainAdVideoView.this.setVolumeImage();
                    if (MainAdVideoView.this.mVolumeImage != null) {
                        MainAdVideoView.this.mVolumeImage.setImageBitmap(MainAdVideoView.this.mVolumeOffBitmap);
                        MainAdVideoView.this.mVolumeImage.setVisibility(0);
                    }
                    mediaPlayer2.start();
                    MainAdVideoView.this.setVisibleContainer(false, true);
                    MainAdVideoView mainAdVideoView5 = MainAdVideoView.this;
                    mainAdVideoView5.removeCallbacks(mainAdVideoView5.videoPlayTrackerRunnable);
                    MainAdVideoView mainAdVideoView6 = MainAdVideoView.this;
                    mainAdVideoView6.post(mainAdVideoView6.videoPlayTrackerRunnable);
                    MainAdVideoView.this.notifyStarted();
                    if (MainAdVideoView.this.isSentStart) {
                        return;
                    }
                    MainAdVideoView.this.isSentStart = true;
                    ReportUtil.sendReport("VIDEO_START", MainAdVideoView.this.mVideoAdData.getTrackingStartUrls());
                }
            });
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.4
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                    ADXLogUtil.d(MainAdVideoView.TAG, "onError");
                    MainAdVideoView.this.setVisibleContainer(true, false);
                    MainAdVideoView.this.notifyError();
                    MainAdVideoView.this.stopVideo();
                    return false;
                }
            });
            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.5
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                    if (i == 701) {
                        ADXLogUtil.d(MainAdVideoView.TAG, "MediaPlayer Buffering Start");
                        if (MainAdVideoView.this.mProgressBar != null) {
                            MainAdVideoView.this.mProgressBar.setVisibility(0);
                        }
                    } else if (i == 702) {
                        ADXLogUtil.d(MainAdVideoView.TAG, "MediaPlayer Buffering End");
                        if (MainAdVideoView.this.mProgressBar != null) {
                            MainAdVideoView.this.mProgressBar.setVisibility(8);
                        }
                    }
                    return false;
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.6
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer2) {
                    ADXLogUtil.d(MainAdVideoView.TAG, "onCompletion - current position : " + MainAdVideoView.this.mVideoCurPosSec + ", duration : " + MainAdVideoView.this.mVideoDuration);
                    MainAdVideoView.this.setVisibleContainer(true, false);
                    MainAdVideoView.this.notifyCompleted();
                    if (MainAdVideoView.this.isSentComplete) {
                        return;
                    }
                    MainAdVideoView.this.isSentComplete = true;
                    ReportUtil.sendReport("VIDEO_COMPLETE", MainAdVideoView.this.mVideoAdData.getTrackingCompleteUrls());
                }
            });
            return mediaPlayer;
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
            return null;
        }
    }

    private void initLayout() {
        try {
            if (this.mContext == null) {
                return;
            }
            TextureView textureView = this.mTextureView;
            if (textureView != null) {
                removeView(textureView);
                this.mTextureView = null;
            }
            if (this.mTextureView == null) {
                TextureView textureView2 = new TextureView(this.mContext);
                this.mTextureView = textureView2;
                textureView2.setOpaque(false);
                this.mTextureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.mTextureView.setSurfaceTextureListener(this);
                addView(this.mTextureView, 0);
            }
            if (this.mContainer == null) {
                this.mContainer = new RelativeLayout(this.mContext);
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                addView(this.mContainer);
                setupReadyStateContainer();
                setupPlayStateContainer();
            }
            if (this.mProgressBar == null) {
                this.mProgressBar = new SpinningLoaderView(this.mContext);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 48), DisplayUtil.dpToPx(this.mContext, 48));
                layoutParams.gravity = 17;
                this.mProgressBar.setLayoutParams(layoutParams);
                addView(this.mProgressBar);
            }
            setVisibleContainer(true, false);
        } catch (Exception unused) {
        }
    }

    private void setupReadyStateContainer() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        this.mReadyStateContainer = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.mReadyStateContainer.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainAdVideoView.this.startVideo();
            }
        });
        addView(this.mReadyStateContainer);
        setupBackgroundView();
        setupPlayIcon();
    }

    private void setupBackgroundView() {
        try {
            if (this.mBackgroundView == null) {
                this.mBackgroundView = new View(this.mContext);
                this.mBackgroundView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.mBackgroundView.setBackgroundColor(Color.parseColor("#66000000"));
                this.mReadyStateContainer.addView(this.mBackgroundView);
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    private void setupPlayIcon() {
        try {
            if (this.mPlayImageView == null) {
                this.mPlayImageView = new ImageView(this.mContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 80), DisplayUtil.dpToPx(this.mContext, 80));
                layoutParams.addRule(13);
                this.mPlayImageView.setLayoutParams(layoutParams);
                try {
                    byte[] bArrDecode = Base64.decode("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", 0);
                    this.mPlayImageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                } catch (Exception e) {
                    ADXLogUtil.e(TAG, e);
                }
                this.mPlayImageView.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MainAdVideoView.this.startVideo();
                    }
                });
                this.mReadyStateContainer.addView(this.mPlayImageView);
            }
        } catch (Exception unused) {
        }
    }

    private void setupPlayStateContainer() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        this.mPlayStateContainer = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.mPlayStateContainer.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MainAdVideoView.this.mMediaPlayer != null) {
                    if (MainAdVideoView.this.mMediaPlayer.isPlaying()) {
                        MainAdVideoView.this.pauseVideo();
                    } else {
                        MainAdVideoView.this.restartVideo();
                    }
                }
            }
        });
        addView(this.mPlayStateContainer);
        setupVolumeButton();
        setupPauseIcon();
        setupRestartIcon();
        setupSeekBar();
        setupClickButton();
    }

    private void setupPauseIcon() {
        try {
            if (this.mPauseImageView == null) {
                this.mPauseImageView = new ImageView(this.mContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 80), DisplayUtil.dpToPx(this.mContext, 80));
                layoutParams.addRule(13);
                this.mPauseImageView.setLayoutParams(layoutParams);
                try {
                    byte[] bArrDecode = Base64.decode("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", 0);
                    this.mPauseImageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                } catch (Exception e) {
                    ADXLogUtil.e(TAG, e);
                }
                this.mPlayStateContainer.addView(this.mPauseImageView);
            }
            this.mPauseImageView.setVisibility(8);
        } catch (Exception unused) {
        }
    }

    private void setupRestartIcon() {
        try {
            if (this.mRestartImageView == null) {
                this.mRestartImageView = new ImageView(this.mContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 80), DisplayUtil.dpToPx(this.mContext, 80));
                layoutParams.addRule(13);
                this.mRestartImageView.setLayoutParams(layoutParams);
                try {
                    byte[] bArrDecode = Base64.decode("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", 0);
                    this.mRestartImageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                } catch (Exception e) {
                    ADXLogUtil.e(TAG, e);
                }
                this.mPlayStateContainer.addView(this.mRestartImageView);
            }
            this.mRestartImageView.setVisibility(8);
        } catch (Exception e2) {
            ADXLogUtil.e(TAG, e2);
        }
    }

    private void setupVolumeButton() {
        try {
            if (this.mVolumeImage == null) {
                this.mVolumeImage = new ImageView(this.mContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 24), DisplayUtil.dpToPx(this.mContext, 24));
                layoutParams.addRule(9);
                layoutParams.addRule(12);
                int iDpToPx = DisplayUtil.dpToPx(this.mContext, 14);
                layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
                this.mVolumeImage.setLayoutParams(layoutParams);
                this.mVolumeImage.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MainAdVideoView.this.setVolumeImage();
                        if (MainAdVideoView.this.mIsVolumeOn) {
                            if (MainAdVideoView.this.mute()) {
                                MainAdVideoView.this.mIsVolumeOn = false;
                                MainAdVideoView.this.mVolumeImage.setImageBitmap(MainAdVideoView.this.mVolumeOffBitmap);
                                return;
                            }
                            return;
                        }
                        if (MainAdVideoView.this.unmute()) {
                            MainAdVideoView.this.mIsVolumeOn = true;
                            MainAdVideoView.this.mVolumeImage.setImageBitmap(MainAdVideoView.this.mVolumeOnBitmap);
                        }
                    }
                });
                this.mPlayStateContainer.addView(this.mVolumeImage);
            }
            this.mIsVolumeOn = false;
            setVolumeImage();
            this.mVolumeImage.setImageBitmap(this.mVolumeOffBitmap);
            this.mVolumeImage.setVisibility(8);
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    private void setupSeekBar() {
        try {
            if (this.mSeekbar == null) {
                this.mSeekbar = new NoSkipSeekBar(this.mContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, DisplayUtil.dpToPx(this.mContext, 4));
                layoutParams.addRule(12);
                this.mSeekbar.setLayoutParams(layoutParams);
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f}, null, null));
                shapeDrawable.setIntrinsicHeight(0);
                shapeDrawable.setIntrinsicWidth(0);
                this.mSeekbar.setThumb(shapeDrawable);
                this.mSeekbar.getProgressDrawable().setColorFilter(Color.parseColor("#FF4081"), PorterDuff.Mode.SRC_IN);
                this.mSeekbar.getThumb().setColorFilter(Color.parseColor("#FF4081"), PorterDuff.Mode.SRC_IN);
                this.mPlayStateContainer.addView(this.mSeekbar);
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    private void setupClickButton() {
        try {
            if (this.mAdButton == null) {
                Button button = new Button(this.mContext);
                this.mAdButton = button;
                button.setBackgroundColor(Integer.MIN_VALUE);
                this.mAdButton.setTextColor(-1);
                this.mAdButton.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ClickThroughUtil.isValidClick()) {
                            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                                ADXLogUtil.d(MainAdVideoView.TAG, ":::clickEvent::: " + MainAdVideoView.this.mLink + " -> block");
                                return;
                            }
                            return;
                        }
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(MainAdVideoView.TAG, ":::clickEvent::: " + MainAdVideoView.this.mLink + " -> isWebViewLanding : " + MainAdVideoView.this.mIsWebViewLanding);
                        }
                        if (MainAdVideoView.this.mIsWebViewLanding) {
                            HttpUtil.getFinalURL(MainAdVideoView.this.mLink, new Handler(Looper.getMainLooper()) { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.11.1
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    if (message.what != 100) {
                                        return;
                                    }
                                    try {
                                        if (ClickThroughUtil.goToWebView(MainAdVideoView.this.mContext, (String) message.obj)) {
                                            MainAdVideoView.this.notifyClick();
                                            if (MainAdVideoView.this.mVideoAdData != null) {
                                                ReportUtil.sendReport("VIDEO_CLICK", MainAdVideoView.this.mVideoAdData.getTrackingClkUrls());
                                            }
                                        } else if (ClickThroughUtil.goToBrowser(MainAdVideoView.this.mContext, (String) message.obj)) {
                                            MainAdVideoView.this.notifyClick();
                                            if (MainAdVideoView.this.mVideoAdData != null) {
                                                ReportUtil.sendReport("VIDEO_CLICK", MainAdVideoView.this.mVideoAdData.getTrackingClkUrls());
                                            }
                                        }
                                    } catch (Exception e) {
                                        ADXLogUtil.e(MainAdVideoView.TAG, e);
                                    }
                                }
                            });
                        } else if (ClickThroughUtil.goToBrowser(MainAdVideoView.this.mContext, MainAdVideoView.this.mLink)) {
                            MainAdVideoView.this.notifyClick();
                            if (MainAdVideoView.this.mVideoAdData != null) {
                                ReportUtil.sendReport("VIDEO_CLICK", MainAdVideoView.this.mVideoAdData.getTrackingClkUrls());
                            }
                        }
                    }
                });
                this.mAdButton.setTextSize(2, 9.0f);
                this.mAdButton.setMinimumHeight(0);
                this.mAdButton.setMinimumWidth(0);
                this.mAdButton.setMaxEms(10);
                this.mAdButton.setMaxLines(1);
                this.mAdButton.setSingleLine();
                this.mAdButton.setWidth(DisplayUtil.dpToPx(this.mContext, 60));
                this.mAdButton.setHeight(DisplayUtil.dpToPx(this.mContext, 32));
                this.mAdButton.setAllCaps(false);
                this.mAdButton.setEllipsize(TextUtils.TruncateAt.END);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                int iDpToPx = DisplayUtil.dpToPx(this.mContext, 10);
                layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
                this.mAdButton.setLayoutParams(layoutParams);
                this.mAdButton.setVisibility(8);
                this.mPlayStateContainer.addView(this.mAdButton, layoutParams);
            }
            if (this.mIsClickableVideo) {
                Button button2 = this.mAdButton;
                if (button2 != null) {
                    button2.setVisibility(0);
                    VideoAdData videoAdData = this.mVideoAdData;
                    if (videoAdData != null && !TextUtils.isEmpty(videoAdData.getLinkText())) {
                        this.mAdButton.setText(this.mVideoAdData.getLinkText());
                        return;
                    }
                    this.mAdButton.setText("자세히 보기");
                    return;
                }
                return;
            }
            Button button3 = this.mAdButton;
            if (button3 != null) {
                button3.setVisibility(8);
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisibleContainer(boolean z, boolean z2) {
        if (!z && !z2) {
            SpinningLoaderView spinningLoaderView = this.mProgressBar;
            if (spinningLoaderView != null) {
                spinningLoaderView.setVisibility(0);
            }
        } else {
            SpinningLoaderView spinningLoaderView2 = this.mProgressBar;
            if (spinningLoaderView2 != null) {
                spinningLoaderView2.setVisibility(8);
            }
        }
        RelativeLayout relativeLayout = this.mReadyStateContainer;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z ? 0 : 8);
        }
        RelativeLayout relativeLayout2 = this.mPlayStateContainer;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(z2 ? 0 : 8);
        }
    }

    public void setVideoAdData(VideoAdData videoAdData, InhouseAdEventListener inhouseAdEventListener) {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "setVideoAdData");
        }
        resetData();
        this.mVideoAdData = videoAdData;
        this.mAdEventListener = inhouseAdEventListener;
        this.mIsAutoPlay = videoAdData.isAutoPlay();
        this.mUrl = videoAdData.getVideoContent();
        this.mLink = this.mVideoAdData.getLink();
        this.mIsWebViewLanding = this.mVideoAdData.getWebviewLanding() == 1;
        boolean z = !TextUtils.isEmpty(this.mLink);
        this.mIsClickableVideo = z;
        if (z) {
            Button button = this.mAdButton;
            if (button != null) {
                button.setVisibility(0);
                VideoAdData videoAdData2 = this.mVideoAdData;
                if (videoAdData2 == null || TextUtils.isEmpty(videoAdData2.getLinkText())) {
                    this.mAdButton.setText("자세히 보기");
                    return;
                } else {
                    this.mAdButton.setText(this.mVideoAdData.getLinkText());
                    return;
                }
            }
            return;
        }
        Button button2 = this.mAdButton;
        if (button2 != null) {
            button2.setVisibility(8);
        }
    }

    public void setVolumeImage() {
        try {
            if (this.mVolumeOffBitmap == null) {
                byte[] bArrDecode = Base64.decode("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", 0);
                this.mVolumeOffBitmap = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            }
            if (this.mVolumeOnBitmap == null) {
                byte[] bArrDecode2 = Base64.decode("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ygcffCBfffVVIwISo2ZLx3F6geASBpCEiG5qpJMOAOPSSy9tOGOrVq0MGI844gijQwJGp8sHqmPYTJk6VY7v2lVmzJghn332WSMCktobumAgsgM3saoWkHyf2op7AsE9518CaHC+JZZYQlZbbTXZdttt5fDDD5c999xTlluOhPgmzukev//+u0yZMkU6d+4ss2fPlo8/jrZYjznx4WXgWRlVB0jepZ00PT6xuAP5wKoFJLSnXd5DOcdaxemz4bhz2Ow111xTOnbsaMC4ySabmN97AVFvagA5dap07tRJZs2aJZ98EsoDstAcFYjosbibmJvqpxk1nOhMwtlBdO8NFL2pFpBtROQfIsK/dTvYeDggm77++uvLkUceaQC5+uqrG6OmHBghCoCcOnWqdOnSRWbOnCmffvppzVxMXxDuvfLKK8u6664rP/74o7zzzjvm3r/88ksWXUz4vPax/c0DuQirBWTd+x4BHPoiVvSuu+5qdMXtt9/eRGKchku5t1FF9gknnCDvv/++fP755wakYYfqsMxpxx13NPPaeOONjUvp+eeflyeffNI8hwgRwMzYoK85pSyBJlYNIOGKH2RssZFOB44IILGcjzrqKKMDwiGJwFTiis6JKCC79+gh06dNqxmQqAgtWrSQgw46SPr06SNt2rQxc2LMnTtXnnjiCbnmmmsMt8QZn0HxjZMcF2HFcGI1gKTzBApqXQ7AiBUNmAAikRc2XmPV1SzaWNlTphi3z7QaAanccY011pDhw4dL+/bt/zAn5gsIx4x5VPr3v8ioCD/99FPWOCX9zAknVmywHxSQJN8SmSEsVHcDrrjSSisZQKIvdurUyYQDEdHVcEYlDIB84403FgDyiy++CC2y4YRLLbWUseyvvfZao8cydF5qYQPKhx9+WE4//XTDNRHdGRLfd9sq1IoHgwYFJK2W36k3JAJENhwDBrdO9+7djVgk8sLfwg4ASfjwpJNOMo7xWnRIXE7otKgQAwcONLqs1wCY33//vTzyyCNy6qmnGn0yY+KbcDOMrazLISggudm39dR2Ga6DbvbNN9/IDjvsIGeccYbstttuBpxhuKITJABy4qRJckK3bvLRRx/V5BjnxQCU7dq1M+FI5ZB+oMTyRqcklo7Lif/zycCgzOGxSvMIAki6qL5STw3p4TLojKussopss802hqOof7ESwYL8HUBOmDjRRHRmz5pl3D5hBy8HLw9RofPPP1+OOeYY83+/l0Z9k1jffB9DB18l3DLlgZuBsDMsnmZVniMIIGmJMt4mXaa8ptoer/oYm7n77rsbMYgbBb9eEP9i0Kdj5Y6fMEFOPPFEA8haQ4fosswP7oiVDSgBqFOXdM4NUDIHso1OPvlk+fDDD40+ibGT8uBUWt4M3xruIICkZQZt2BDbuR1wFTYVbtGnb1/p2qWLMVzUpVOrmHYSBjC8Pn68sdRnzphhdMhaw3vqksLwOv7446Vnr16yeqtWnrF05oL1zTweeOAB8+JxvSYOp7iJOMlpw4LF7ZkFVAmQnMbKUcDdUlxEzY8GiOiLiFJSwsjSwcnsx2FqfaBm+8DNcFjXYmU756Kpb+iUOOzRe+GaXgkeCspv58+XgQMGyPXXc+amGGMnxUEnPAoC4ZCemcuVAEm99VAROS7FRdT0aMQdVip+vLPPPttY0XCZMP7FoBMBkGPHjZNTTjlF3p0+Xb788suybh+4F/NErFaK6DBvTQ6GAyOSEd9eHF658oQJE4w+SziTZ6ToOH/TdsPDQA4FSFJarrUB8qD7kanvIaoBIJvXu3dvE/EIGgIMuxADyLFjmwD57ru+gNS5ffvtt0aVgPPhciJDqNLAb8r1l112mRx44IG+hg4Ax5PA94YOHWqek2JZBSlpZIvRXzI0IG8XkQMqESirfycMiCsH7njsscfKMsvErworIPv27SvvvfeeJyABH2oEeh0RIZJ+lYPxwqDbkm3up3uqGrLeeuvJiBEjZOutt/Y1zFBVXn31VfOCvPXWW0Zs87sUBqeD7VvC06SwgNyhdCzEyylMfIFjWvP9yhkdumnu6AXzxsUDCM8880xjDCQGyHHjpFfPniZBFx3SCSzAxjxIkMDlRDgQtQKgvPTSS3LWWWcZQwhgkm3uJ8a5B+KetDh0Y7irX34m94MG9957rxHZKYpt6m34zPDCVSUdkgTL0UkCUpNiVc8j+sCGBLWC3UmriGi4ERwSPSpJQPbo3t04p51Wtuq0WPiDBw827ifmx1DQ4re89dZb5Y477jDiG5HuBUpowvpat25tALnffvsZgHrRCt2RrKBevXoZkFMtWavlHxIX15Q8Npf5NTotB0j+hjEzMuSDq77MGTsmerLFFlsYzhEUjDyQN/+1116Tl19uYuyIazYcroNfkPvFPdSo6X7SSQZQ+CF18KIx8CVecMEFxgeqBpYTIADoscceM+FCEjWItniBEtHNS0ZK2tVXX23EP8NNM64laoTl/9RTT6XplyS5m7yIaV5Z5OUASdUS5ygPi3sD9f4aP8YSppqvbdu2C7iHk4M45+MmPDoZGzNgAAcGiNksdDUASX5iUoCkyIvYuJtDYiHz4l3Uv78cc/TRZn7uNSgwAeXTTz9tIi5kDSHSvbgaIOfFA7y4g9Rqd9KJ66DNnXfeKeecc47RIUnCSGHQdgc3oufDywGSxvWJVbljMULInXbaSS6++GLZfPPNq+KMSlg4CaLwoos4vUIMANl0RDb+xyQBiXgkSuLUIQEk6+zXr5/hkl6A1LUAIqIrD4weLRf062fu4wUiFdNIldtvv904/L24JCB8bexYOe7YY41/NMV2L5vZzrsLBdnLAZKQYTTFIAFeQ7gjnAORQmKAirZqxLVyATgk4lABCfeAQ5LnmBggX39d+vbpY6xsp2NcXzzS3Jgj8fRybijWhLV95ZVXyrBhw4zLBjeOe+CL5G833nijHHbYYeZldt+Xe6HPwknRURHj6KcpjD9ZZveu+9nlAMkZMzQgjX2oDgUBEU9EIPyU83KTUUAOGTLE3EdFtrp9jjvuuMQA+TqA7NvX+CGdgFRDhMKxQYMGyV577eUpYp1cEuCgFx999NEmnY3hdtvAaeF4BxxwgNx8882exptTbCMxuAdgT2HgvfnKcsk/PL4cILcu+YzGJTFZBST/KiAxRKrhjswTgiOySed3AxK9CT9kUhyS5Io+vXvLdI9IjVraGG3MCzUFieDHKVkX+iMtW9CNAZ4XkHBxkdVDZGazzTYzHNB5T+4DCMeMGWPArWHEStGhGDBA276xIvJeNRwyFUCiW4XlkBAWncsNSDb73HPPFTgkIjPuAWAABTqkXyxbu6YRcSGKRAIEScJeoFRDZtKkSca5ja9S9UvnWhD/6JjDhg+XLp07ewKS72MgcZ9nnmk6fjKFfEmiNbhBiNwE5pCcwEXf6NiHU2QDSNLww4hsBSQ6JPdRkY2Vzf/RIfk57mESdCdONG4malz80s/g1ujOABgPAHFpLZ1wzxEAojted911xouAxQw3dFrdqCb8fu+995ZRo0YZaeBOvOD/1IljOOLnVO4bN01c9z9VREZVC8ijReS2JCYaJSBVZCsg4Y5ERnAcUyetTug41wUgJ02ebFqp4Ics1yiA+aD/Aa5DDz1ULr/8chNG9HIF8cI999xzRoIQAnTXYqtPEoDjuySs6AVIDJmrrrrKeCNSAmRPEXnAyzleTofcQ0SeinPj9N5RAhKR7eSQCkjcQAASzhv3MEVeU6aY55GgW6lzBUBC/wMoGDpwSq8XB/DQlgWD5MEHHzTqiVvcYizh+8T5vccee3iKbazxm266yfh6mWsK7p8etj/UQm7FcoDky/Hvno0qqJsiCpHt1iER0wCSasJEAGl7+8Ahg3auYF6EAfkX3Y6SCq88R0TyJZdcYrgbgARQTrFNfiSgveGGG4wa4MUh4bSjR482VZEa1kzYsKHPDyGzhVLYywEyUHOgKLhNlByStx+3D0aM6pBwSUQ2jugkABm2cwU5m3PmzDH+RhJBGF4hQLLA8auiDgBKJ5jIbiJOjcvpiiuu8M2TfPHFFw0nRvTDIVMomcW6bAxAkveHO0UBiTiEQ2LJaseHKF4kv3tosymSK6ppFIBRgiuG7J3bbrvN8+WB42FlE0DApaQN9nUuvHwkpODiIi3Nz5VE3TigJW/TS/THSR97b+qMF+ovU1ccUl0hFNSjZykgEYVwyDQASdVf0BIGdElEMGFTOBjgcopcFc3UfMPd3nzzTeOPdHI3LGvEOqAmjOj1AnIfOCOun1deeSWtUllP7NUVIOFMiOy8cki4GWvYYIMNTJFYi+bNPQEJd+vVC0BO9QUkCSo038c48tIjAbMCsuCQLnlQ6JBNBIGboc9ttdVWpquZH4fE6U45Bic9uDkkLiRENlk/xKv9OCTZ6SQHk0meUjOBqnVI2qc1tdiKeUQJSK9ITR6sbEhMJhCRFhKJUTv89N1nn33WgIkokLtdirqPMIqwtP10SI21A25EfsLRGgxmakmqyvYhvHNvzFhcYElG6fbJmx9SaaxW9t/+/nc58ICmMia3lQ0HpaUKsXoyvwGT0+1D+BCdlb+TTeTlYOf7+Cm1TFd9kUnstX3GCbYL80LZZOV0SFrx3prEJKPkkHmL1Ch9MbzQH7fccksZdf/90qplS98oCwYaaWZeFYTqGCcRF7HtlWABqO+66y5jGGnSr1fib4x738uWxsxyP6McII8SESoOYx9RAtIdqdGM8SzGspWwGB74R9H9Hn/8cRNhUZo4iQ9oyK/EB0kmuZfuxykRRIawnun86wVIrHDEOXmnmiEV+yb/8QEHlk6OnVA6yePDagCZWMVhVPmQecr20Y3ghcF4QfwSYSIBBIB6JdeyPkKGJJ/gQHdXD6Jzai9y3E1eXS0AII5zYtk8L6UkXc44ol/U9GoAyRkjE5N4c9yAhOD1nA+pNNXWf3AsMsI1o90rDxQgYfCQfEEkB73Pne2NQQOXxd9K7qQeHeK8H/cBzIj9e+5pOt0lhfYqoQBJ8xuyemMfUSbosrlZzhhXYmo+JFWHhDnJ9PHrTan6HYVj6H3jx483nM0d7qMuGzfQzbfcIkf66I88H6c4URoyhxgJW9g88i8iQvlCVQm6FAsn0r8takBmuaaG3dCuE/SmJKSJruclphW8KmbJhSQ+rf93cwoAjaFD6ttGbdv6GjQPPfSQyRjXM24STqxg2puIyOdePccrlcEm0m/DKbLhFnRYCCuyVfw5qw4Jp2Wl6lDPwFlnnXXkisGDZdf27cue8gD40BVx0yDSaVyFuHaDCD0UjkllJfqhVxKJ5j5ioZOgy0ippoaqw6nVxrKpyyYg3D92mU2emz2SA4JiEZPaH2YASLiIEhwwZqkuW6spARdWrjYK8FsrwHu/VNhFGeyjjz7q2Q2XFxruyFrvu+8+05rFbV1zfwBJWS5Ode7Fy4HOmfCgLpvDEzgiZKGMskockhyuC5OYMBwRUcb50zh199lnn1DlBk5AsgFYsVnqXKF9Kfv377+g+ZWfEaPlBqgglBtgxHi1ZuaFg3aUv8IdtTG++77aeIC8UMohoFXC/kegNLyUC3mpdflUBUgu3lFE/pkEIHmGujo4DJ1YLf44iOv0ybktRidB+Rt+SJIrsEYZzs4VWejto4DkpSOjXHsYOWmsa8IVNGToUBk+bJhx1XgZH+rmob8PvkUa9/v5MLGmMfhozcd3uGcKg5OEAeRCBg1zqdRsCuUTWZ/Y0IYB2pNHRQ9cTovsIaZm9rBJKOf8Tlvc8fYTPmNwnyx1P9MiMxpD4erBV6gvogKRtaDbkRXOYUmIVT9upgc+YaWjpqDqeMWv0TtJxkAlIn0NuqXUku+qUo4ECqynB6cSIDlXhOqwvRJDpOWU2iXWr/OX33zYVGdaPxyWD4YSelti3c/GjjWuFXd/SMDGfCh5xfCi2aizEpL5k9SLHo2eh7PbrwcPLy8dKyjmuvTSS2XnnXf2TchAcnCGDYnLVEGm1P2M4ygOsad6hGpYuortfsaRxLkcbD5xYir1kgakXwdd7RWOpQ1oOaWLFwWuSMs8ymcBIi+ls3OaewMQ93BI1oUXQV9i9/eQJrT4w5ih/AGJkoKrh2nR8YxDFOZ4ZfoEEdmknw0usVeC4bkbcCPACCjZMG3uFPdCgvQYV/UCIwVuCZgQqQzmC2jLdSdTXyZGIKUKdMHwO9oEiUF7QqoMeQZSJyVxzWlwSFs4paePu5LIpu4BK7upQCWHA3EIJ4HrwI0ogqrl2LggJAh6CoPODYBwDdwOHTBI2Szr4GWjAnH//ff3PVQeTohOzfdwrKd8MCddcze2RxX/6kXLSoDkmk2tpd0iyGZk7TtwSfxzFN9jZcMlCbGFPVgzyPqqPadGDTkvh7fzeaxFa7jxX3JWDeuh1KGc64jMH0pi0We1dDbIOmL4TsWzs4MAEiBOKemSa8UwwURuCfiw0Nlwip9ITMW1pNEMr82sZWJRn+RldKtmzcx8+XCGNxnhrMUvgIBxxIcabeLfpLWx/hTi1k5SgiH6/9V0khc3pC0f7flyO+AsGg3iODncH0Q0tKNtlKCM8qxDJxj5mQRejKUOHTos8NG6N0XdRxhJRK3wyWq+ZYobSMkrjZWopfE9vSkIh2QNNJ76vwB+yxTXW/nRcEo+uErgLESDiG7Quk5dL1EAM8rTYFkVYAJkvEi04+MIEObrJ6a5Bic4PkztcIGbJyXLWjdmVXucXNk+0kEByQFKqbRarQyz6r8Bt6T2BH0Kg4dw214dOsjyLaJRk6M8L5sXCJcQpQkUfu2yyy6+1rRyRoykESNHyiWDBhnQBq0Lr56SVV3RdPJ8ROdlcyNOhafRZF0MNgpOyeYBTtxChxxyyIKzXmrhlKbZ1BtvmN45OLlrAYQeMo+vEo5HIZjXUDBiUdNIigRcXEu4jlKIV7unSBy3qce2SNlsjqAckhvRSd3zsJs8IxRjByscFwpJB/T+1lNiw64LQNIOTwFJQ6ew4hLRzBwxYOgNrrFwL70RMFKRSDSG68qdBBZ2bSGvW9/6HSuemVcNIJlLYg2oQi481GWIRTYa0UiMGZ8lR5KEPUNbm01179FDpk+bZjqMhQUkcwCQhAXhkGut1eTsUA6u3A8dkUpCwpHoj0RjUjyty70PHO6NQfPvA3t8dqpaQP7VxrZDbXyWLyJUhz4JdyO+TDvmTTfdNHQnXzgkvj+K+WsBJDTjRSGag65Ld1ztLqxJJohljozj77h5MgZGjiN+wh7cXhEC1QJyNVv4pQpqxQfk6QtwIz6Ib458Q3xTXoBFXk10B25IqxLSy4L2hyxHJwBIOJHm+MSteVHQfxk0JyVpgjpsTurSo/gyQnfCgx1EZLLfQUnueVYLSK7/XxG5KyMLjnwacB30L0JzNH3C39exY0cjwoP2Pdd2fJ07dTKAqRQKDLII5kQqHSIbQNLQFC8BrfkoeaW0IWNgZFm0baZb7sdB1mhUkaBfdHwPfxJp6LuEuDYXl2huJbobIGjXrp3J7oZD6bEi5axw1SHhZjQVRYzWOnie1l0zL3Re1AvtgBvk8Pda5xDi+jtKZTu9LXcMZH+EASRtnkeUaiJoil/XQwEAt4QrIcLhlojLcoBUK5vwHscT+53CEIZ4Gs9WZ7lWDmbAteNezkxbXUhDqcDFgmEAyYNvtAdzhqFprq5RzgRHwrCg7yLGCj97lQqwOHWMc/im+2i5qBbvtrKjum+E96FEgcQcwBj4zMywgFzZtsGgmUBDDJzMWOHocnSGIJWNDCI4k7tkQAGJpV6rYzzHxKXdHmJ6oZZ75dYUFpDck1PhT84xwaqeunabwOIl7YusITils+RU66hpBApocfvglgnrh6x6ktm4YKDNowVfVTWbqAWQZG10FpFrs0GDZGaB+0cLx/bdd1/TiUxP31I9jhQvivFJhMBhncIJB8kQw/8pJHbjl6q6FU8tgGQ61NzQEqOhBiIa3ySimWRfuohtt912JnbM7+i9Q8SEXjwZdMXEvVcb4R4N6gh3T6ZWQHI/qsjui3uVWbs/oMSBTpgOqxvre43WrWXe3LkmGRZXD6WrGQrfJUHCy6zERG8MxaiiACTB1ddFBP9kQw0sXYCpBVuIc3RFgKh14w1EEGpkOtnjCBdq1RyUDlEAknt0sa6goM+tu+/hrNZjPVIsM02Trs+WwsodbQOp78JOJApA8mw6Qz0iIv8VdiLFdbmmAADcxjaQCuxz9FpxVIDk3jhBXxARul0Uo7EogD8anyMunqr8jnEYNXrP5tZZ3rKx9qLhVwsIcYKz/zV3r4qSQ7Iza5bE9pO2GLzhd6oBCEB5NIcj0Es0kpqrqAHJHqxrdYkG2I+GXyJ+aGLVnPoW2pBxUjEOQHJ/jqEiF64Y9UsBWuoRIsTdAyAjGXEBkhQ1uu+eH8ksi5tkjQL/KPme/6fUeHRpr8b1tUw2LkAyJ6ztMbYLby1zLK7NFgUwXFqXuCOndHxTTa5jkGXECUieTwfeSUmdKhtkwcV3aqYA7j0iMbRDqcnF4zWTuAHJM9Ez6LpfjPxTgNaMfBDVsRzfkAQgSUWiNxChpWLklwIcV000ruqk22qWnAQgmQ/PIc40TmzyAAADzElEQVRZWN7V7E52vjugVOg/SESWDVLsX8u0kwIkc6RzwSW2Cq2WORfXJkuBcaXOd+3jsKjT0iGdz8XypoR2z2RpWjwtJAXGisiudAS0kZjA1YMhnxeqLjvss/Q6QIli3FD1OLUSLYXrMUb5AEaiMJE5v8utJUmR7ZwH4hvHKtyyGNmjwHF2b7Cm59loTCKzTAuQLI6APOUPTaeIFyMrFLi+5NI53WbwcBxaoI4TUU0+TUCyBlxCQ0sH6Rxvf45qXcV9qqcAIplD1f9kKwbhjImCkSmnDUglG2eXwCk3r56OxRURUIATm+iO/JE1XkiYoEl94iMrgGThlEH0y+upYYnvXHQPpJMddCefkejLD1HHp6uZapYAybxpPsAxdhxfW4z4KfBw6bRfmtCS7U2iRCKWdLllZQ2QqlcCzOmlw77rsjFq/DgL9AQK8jh/CBBSmJW4vug1yywCUufJcQPv20whjJ9iREMB9EPanODlgK4YL5kZWQYkRCJ2+mfbsZd20sUITwGMFNw56IxfWtpmCowsLeuAZI4ckUzNL470s8PvR0NfSYPZiSJyu6UClYI11U/HRc08AFLXjojhrOXH4iJGHd73lJLRMrXUeP5lm9xCtncmgai0zxMglaNz/huVjRPqEEBRLokzzoc46qVjSaiNcsJ5Edl+xhhB/6dLHHN7W98RNW3yeD+4H2UFGIT8jDun6h6NaS48bxzSTStAibL+iiV+2zSJmeKzcWpz1MOW1nLGuQ1t+DdXI++AVGJj+JDWRkpbX2tB5mojQk52pLWYKUtFT0RHxDMRSdF+yDnVdFm9ANKpE28hIuiZpE7VqwHU3zb2etVGtziDGkkRewJtTWgLcHG9AdK5ZNp84N6ghpgCs3qI+qAvv2VLUGnqhajOLTf0Mw4C4DbXX9HOXMRqKZ14KCerIaKCKkL3D84FwpmN6wtDBYd27rlhowLSuW5EOeEyxBtdNdhwdC64TdotqUn9QmJhFWMp0x6Z86XRC8mEwm0TawlqFl7UehbZ5ehLCQUDkb5cCZzb2so6AIp1CmiptNsqpk2i6wMlwYCNn0lwuNVyQECozT95WbCUU8lNjGntZW/bqIB0EgUxCB0QgfwMN1Krnf41iHw++PVISsApzyDTvdzoZsHOdXNs8iv3ZaA+fGoNEv4OKAEdwNSsm4YBoZOIBSAXhhQ0cadiwanQ3fg9HJQBYPD98TuABlcF1Oh+SlcMKUDOd/g+Roj+rD5Cr+elwZwy8cwCkJnYhmISSoECkAUWMkWBApCZ2o5iMgUgCwxkigL/D0oCSaQo5KjmAAAAAElFTkSuQmCC", 0);
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

    private void fadeOutAndHideImage(final ImageView imageView) {
        if (imageView != null) {
            imageView.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            alphaAnimation.setDuration(1000L);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.adxcorp.ads.mediation.nativeads.MainAdVideoView.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageView imageView2 = imageView;
                    if (imageView2 != null) {
                        imageView2.setVisibility(8);
                    }
                }
            });
            imageView.setAnimation(alphaAnimation);
        }
    }

    private void resetData() {
        this.mUrl = null;
        this.mIsClickableVideo = false;
        this.mLink = null;
        this.mVideoDuration = 0;
        this.mVideoCurPosSec = 0;
        this.mFirstQuartile = 0;
        this.mSecondQuartile = 0;
        this.mThirdQuartile = 0;
        this.isSentStart = false;
        this.isSentComplete = false;
        this.isSentFirst = false;
        this.isSentSecond = false;
        this.isSentThird = false;
        this.mIsPrepared = false;
        this.mIsPreparing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyClick() {
        InhouseAdEventListener inhouseAdEventListener = this.mAdEventListener;
        if (inhouseAdEventListener != null) {
            inhouseAdEventListener.notifyAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyStarted() {
        InhouseAdEventListener inhouseAdEventListener = this.mAdEventListener;
        if (inhouseAdEventListener != null) {
            inhouseAdEventListener.notifyVideoAdStarted();
        }
    }

    private void notifyPaused() {
        InhouseAdEventListener inhouseAdEventListener = this.mAdEventListener;
        if (inhouseAdEventListener != null) {
            inhouseAdEventListener.notifyVideoAdPaused();
        }
    }

    private void notifyStopped() {
        InhouseAdEventListener inhouseAdEventListener = this.mAdEventListener;
        if (inhouseAdEventListener != null) {
            inhouseAdEventListener.notifyVideoAdStopped();
        }
    }

    private void notifySkipped() {
        InhouseAdEventListener inhouseAdEventListener = this.mAdEventListener;
        if (inhouseAdEventListener != null) {
            inhouseAdEventListener.notifyVideoAdSkipped();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError() {
        InhouseAdEventListener inhouseAdEventListener = this.mAdEventListener;
        if (inhouseAdEventListener != null) {
            inhouseAdEventListener.notifyVideoAdError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCompleted() {
        InhouseAdEventListener inhouseAdEventListener = this.mAdEventListener;
        if (inhouseAdEventListener != null) {
            inhouseAdEventListener.notifyVideoAdCompleted();
        }
    }

    public int getVideoWidth() {
        Drawable background;
        if (this.mVideoWidth == 0 && (background = getBackground()) != null) {
            return background.getIntrinsicWidth();
        }
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        Drawable background;
        if (this.mVideoHeight == 0 && (background = getBackground()) != null) {
            return background.getIntrinsicHeight();
        }
        return this.mVideoHeight;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ADXLogUtil.d(TAG, "onAttachedToWindow");
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ADXLogUtil.d(TAG, "onDetachedFromWindow");
        super.onDetachedFromWindow();
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
