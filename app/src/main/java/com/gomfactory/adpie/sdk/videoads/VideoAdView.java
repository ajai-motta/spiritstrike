package com.gomfactory.adpie.sdk.videoads;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.event.AdEventListener;
import com.gomfactory.adpie.sdk.ui.progressbar.CircularProgressBar;
import com.gomfactory.adpie.sdk.ui.progressbar.SpinningLoaderView;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.ClickThroughUtil;
import com.gomfactory.adpie.sdk.util.DisplayUtil;
import com.gomfactory.adpie.sdk.util.HttpUtil;
import com.gomfactory.adpie.sdk.util.ReportUtil;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class VideoAdView extends RelativeLayout implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnVideoSizeChangedListener {
    public static final String TAG = "VideoAdView";
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    private Runnable checkVideoPrepared;
    private boolean isSentComplete;
    private boolean isSentFirst;
    private boolean isSentImpression;
    private boolean isSentSecond;
    private boolean isSentStart;
    private boolean isSentThird;
    private Button mAdButton;
    private AdEventListener mAdEventListener;
    private CircularProgressBar mCircularProgressBar;
    private Context mContext;
    private int mFirstQuartile;
    private boolean mIsClickableVideo;
    private boolean mIsPrepared;
    private boolean mIsWebViewLanding;
    private String mLink;
    private MediaPlayer mMediaPlayer;
    private SpinningLoaderView mProgressBar;
    private int mSecondQuartile;
    private NoSkipSeekBar mSeekbar;
    private Button mSkipButton;
    private int mSkipOffsetSec;
    private int mThirdQuartile;
    private TextView mTimerTextView;
    private VideoAdData mVideoAdData;
    private float mVideoCurPosSec;
    private int mVideoDuration;
    private VideoView mVideoView;
    private Runnable showCloseButton;
    private Runnable updateTimeRunnable;
    private Runnable videoPlayTrackerRunnable;

    public VideoAdView(Context context) {
        super(context);
        this.showCloseButton = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.1
            @Override // java.lang.Runnable
            public void run() {
                if (VideoAdView.this.mCircularProgressBar != null) {
                    VideoAdView.this.mCircularProgressBar.setVisibility(8);
                }
                if (VideoAdView.this.mTimerTextView != null) {
                    VideoAdView.this.mTimerTextView.setVisibility(8);
                }
                if (VideoAdView.this.mSkipButton != null) {
                    VideoAdView.this.mSkipButton.setVisibility(0);
                }
            }
        };
        this.updateTimeRunnable = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (VideoAdView.this.mVideoView != null) {
                        VideoAdView.this.mVideoCurPosSec = r0.mVideoView.getCurrentPosition() / 1000.0f;
                    }
                    if (VideoAdView.this.mSeekbar != null && VideoAdView.this.mVideoView != null) {
                        VideoAdView.this.mSeekbar.setProgress(VideoAdView.this.mVideoView.getCurrentPosition());
                    }
                    if (VideoAdView.this.mSkipOffsetSec > 0) {
                        if (VideoAdView.this.mSkipOffsetSec - VideoAdView.this.mVideoCurPosSec > 0.0f) {
                            if (VideoAdView.this.mCircularProgressBar != null) {
                                VideoAdView.this.mCircularProgressBar.setProgressWithAnimation(VideoAdView.this.mVideoCurPosSec + 0.5f, 500L, null, 0L);
                                VideoAdView.this.mCircularProgressBar.setVisibility(0);
                            }
                            if (VideoAdView.this.mTimerTextView != null) {
                                int i = VideoAdView.this.mSkipOffsetSec - ((int) VideoAdView.this.mVideoCurPosSec);
                                VideoAdView.this.mTimerTextView.setText(i + "");
                                VideoAdView.this.mTimerTextView.setVisibility(0);
                                return;
                            }
                            return;
                        }
                        if (VideoAdView.this.mSkipButton == null || VideoAdView.this.mSkipButton.getVisibility() == 0) {
                            return;
                        }
                        VideoAdView videoAdView = VideoAdView.this;
                        videoAdView.post(videoAdView.showCloseButton);
                        return;
                    }
                    if (VideoAdView.this.mSkipOffsetSec == 0) {
                        if (VideoAdView.this.mSkipButton == null || VideoAdView.this.mSkipButton.getVisibility() == 0) {
                            return;
                        }
                        VideoAdView videoAdView2 = VideoAdView.this;
                        videoAdView2.post(videoAdView2.showCloseButton);
                        return;
                    }
                    if (VideoAdView.this.mCircularProgressBar != null) {
                        VideoAdView.this.mCircularProgressBar.setProgressWithAnimation(VideoAdView.this.mVideoCurPosSec + 0.5f, 500L, null, 0L);
                        VideoAdView.this.mCircularProgressBar.setVisibility(0);
                    }
                    if (VideoAdView.this.mTimerTextView != null) {
                        int i2 = VideoAdView.this.mVideoDuration - ((int) VideoAdView.this.mVideoCurPosSec);
                        VideoAdView.this.mTimerTextView.setText(i2 + "");
                        VideoAdView.this.mTimerTextView.setVisibility(0);
                    }
                } catch (Exception e) {
                    AdPieLog.e(VideoAdView.TAG, e);
                }
            }
        };
        this.videoPlayTrackerRunnable = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.3
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    if (VideoAdView.this.mVideoView != null && VideoAdView.this.mVideoView.isPlaying()) {
                        int currentPosition = VideoAdView.this.mVideoView.getCurrentPosition() / 1000;
                        AdPieLog.d(VideoAdView.TAG, "video current position  : " + currentPosition);
                        if (currentPosition > 0) {
                            if (currentPosition != VideoAdView.this.mFirstQuartile || VideoAdView.this.isSentFirst) {
                                if (currentPosition != VideoAdView.this.mSecondQuartile || VideoAdView.this.isSentSecond) {
                                    if (currentPosition == VideoAdView.this.mThirdQuartile && !VideoAdView.this.isSentThird) {
                                        VideoAdView.this.isSentThird = true;
                                        ReportUtil.sendReport("VIDEO_THIRD_QUARTILE", VideoAdView.this.mVideoAdData.getTrackingThirdQuartileUrls());
                                    }
                                } else {
                                    VideoAdView.this.isSentSecond = true;
                                    ReportUtil.sendReport("VIDEO_MID_POINT", VideoAdView.this.mVideoAdData.getTrackingMidpointUrls());
                                }
                            } else {
                                VideoAdView.this.isSentFirst = true;
                                ReportUtil.sendReport("VIDEO_FIRST_QUARTILE", VideoAdView.this.mVideoAdData.getTrackingFirstQuartileUrls());
                            }
                        }
                        VideoAdView videoAdView = VideoAdView.this;
                        videoAdView.post(videoAdView.updateTimeRunnable);
                        VideoAdView videoAdView2 = VideoAdView.this;
                        videoAdView2.postDelayed(videoAdView2.videoPlayTrackerRunnable, 500L);
                        return;
                    }
                    String str2 = VideoAdView.TAG;
                    StringBuilder sb = new StringBuilder("::: videoview : ");
                    if (VideoAdView.this.mVideoView != null) {
                        str = "isPlaying - " + VideoAdView.this.mVideoView.isPlaying();
                    } else {
                        str = AbstractJsonLexerKt.NULL;
                    }
                    sb.append(str);
                    AdPieLog.d(str2, sb.toString());
                } catch (Exception e) {
                    AdPieLog.e(VideoAdView.TAG, e);
                }
            }
        };
        this.checkVideoPrepared = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.4
            @Override // java.lang.Runnable
            public void run() {
                if (VideoAdView.this.mIsPrepared) {
                    return;
                }
                VideoAdView.this.notifyError();
                VideoAdView.this.stopVideo();
            }
        };
        this.mContext = context;
    }

    public VideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.showCloseButton = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.1
            @Override // java.lang.Runnable
            public void run() {
                if (VideoAdView.this.mCircularProgressBar != null) {
                    VideoAdView.this.mCircularProgressBar.setVisibility(8);
                }
                if (VideoAdView.this.mTimerTextView != null) {
                    VideoAdView.this.mTimerTextView.setVisibility(8);
                }
                if (VideoAdView.this.mSkipButton != null) {
                    VideoAdView.this.mSkipButton.setVisibility(0);
                }
            }
        };
        this.updateTimeRunnable = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (VideoAdView.this.mVideoView != null) {
                        VideoAdView.this.mVideoCurPosSec = r0.mVideoView.getCurrentPosition() / 1000.0f;
                    }
                    if (VideoAdView.this.mSeekbar != null && VideoAdView.this.mVideoView != null) {
                        VideoAdView.this.mSeekbar.setProgress(VideoAdView.this.mVideoView.getCurrentPosition());
                    }
                    if (VideoAdView.this.mSkipOffsetSec > 0) {
                        if (VideoAdView.this.mSkipOffsetSec - VideoAdView.this.mVideoCurPosSec > 0.0f) {
                            if (VideoAdView.this.mCircularProgressBar != null) {
                                VideoAdView.this.mCircularProgressBar.setProgressWithAnimation(VideoAdView.this.mVideoCurPosSec + 0.5f, 500L, null, 0L);
                                VideoAdView.this.mCircularProgressBar.setVisibility(0);
                            }
                            if (VideoAdView.this.mTimerTextView != null) {
                                int i = VideoAdView.this.mSkipOffsetSec - ((int) VideoAdView.this.mVideoCurPosSec);
                                VideoAdView.this.mTimerTextView.setText(i + "");
                                VideoAdView.this.mTimerTextView.setVisibility(0);
                                return;
                            }
                            return;
                        }
                        if (VideoAdView.this.mSkipButton == null || VideoAdView.this.mSkipButton.getVisibility() == 0) {
                            return;
                        }
                        VideoAdView videoAdView = VideoAdView.this;
                        videoAdView.post(videoAdView.showCloseButton);
                        return;
                    }
                    if (VideoAdView.this.mSkipOffsetSec == 0) {
                        if (VideoAdView.this.mSkipButton == null || VideoAdView.this.mSkipButton.getVisibility() == 0) {
                            return;
                        }
                        VideoAdView videoAdView2 = VideoAdView.this;
                        videoAdView2.post(videoAdView2.showCloseButton);
                        return;
                    }
                    if (VideoAdView.this.mCircularProgressBar != null) {
                        VideoAdView.this.mCircularProgressBar.setProgressWithAnimation(VideoAdView.this.mVideoCurPosSec + 0.5f, 500L, null, 0L);
                        VideoAdView.this.mCircularProgressBar.setVisibility(0);
                    }
                    if (VideoAdView.this.mTimerTextView != null) {
                        int i2 = VideoAdView.this.mVideoDuration - ((int) VideoAdView.this.mVideoCurPosSec);
                        VideoAdView.this.mTimerTextView.setText(i2 + "");
                        VideoAdView.this.mTimerTextView.setVisibility(0);
                    }
                } catch (Exception e) {
                    AdPieLog.e(VideoAdView.TAG, e);
                }
            }
        };
        this.videoPlayTrackerRunnable = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.3
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    if (VideoAdView.this.mVideoView != null && VideoAdView.this.mVideoView.isPlaying()) {
                        int currentPosition = VideoAdView.this.mVideoView.getCurrentPosition() / 1000;
                        AdPieLog.d(VideoAdView.TAG, "video current position  : " + currentPosition);
                        if (currentPosition > 0) {
                            if (currentPosition != VideoAdView.this.mFirstQuartile || VideoAdView.this.isSentFirst) {
                                if (currentPosition != VideoAdView.this.mSecondQuartile || VideoAdView.this.isSentSecond) {
                                    if (currentPosition == VideoAdView.this.mThirdQuartile && !VideoAdView.this.isSentThird) {
                                        VideoAdView.this.isSentThird = true;
                                        ReportUtil.sendReport("VIDEO_THIRD_QUARTILE", VideoAdView.this.mVideoAdData.getTrackingThirdQuartileUrls());
                                    }
                                } else {
                                    VideoAdView.this.isSentSecond = true;
                                    ReportUtil.sendReport("VIDEO_MID_POINT", VideoAdView.this.mVideoAdData.getTrackingMidpointUrls());
                                }
                            } else {
                                VideoAdView.this.isSentFirst = true;
                                ReportUtil.sendReport("VIDEO_FIRST_QUARTILE", VideoAdView.this.mVideoAdData.getTrackingFirstQuartileUrls());
                            }
                        }
                        VideoAdView videoAdView = VideoAdView.this;
                        videoAdView.post(videoAdView.updateTimeRunnable);
                        VideoAdView videoAdView2 = VideoAdView.this;
                        videoAdView2.postDelayed(videoAdView2.videoPlayTrackerRunnable, 500L);
                        return;
                    }
                    String str2 = VideoAdView.TAG;
                    StringBuilder sb = new StringBuilder("::: videoview : ");
                    if (VideoAdView.this.mVideoView != null) {
                        str = "isPlaying - " + VideoAdView.this.mVideoView.isPlaying();
                    } else {
                        str = AbstractJsonLexerKt.NULL;
                    }
                    sb.append(str);
                    AdPieLog.d(str2, sb.toString());
                } catch (Exception e) {
                    AdPieLog.e(VideoAdView.TAG, e);
                }
            }
        };
        this.checkVideoPrepared = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.4
            @Override // java.lang.Runnable
            public void run() {
                if (VideoAdView.this.mIsPrepared) {
                    return;
                }
                VideoAdView.this.notifyError();
                VideoAdView.this.stopVideo();
            }
        };
        this.mContext = context;
    }

    public VideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.showCloseButton = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.1
            @Override // java.lang.Runnable
            public void run() {
                if (VideoAdView.this.mCircularProgressBar != null) {
                    VideoAdView.this.mCircularProgressBar.setVisibility(8);
                }
                if (VideoAdView.this.mTimerTextView != null) {
                    VideoAdView.this.mTimerTextView.setVisibility(8);
                }
                if (VideoAdView.this.mSkipButton != null) {
                    VideoAdView.this.mSkipButton.setVisibility(0);
                }
            }
        };
        this.updateTimeRunnable = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (VideoAdView.this.mVideoView != null) {
                        VideoAdView.this.mVideoCurPosSec = r0.mVideoView.getCurrentPosition() / 1000.0f;
                    }
                    if (VideoAdView.this.mSeekbar != null && VideoAdView.this.mVideoView != null) {
                        VideoAdView.this.mSeekbar.setProgress(VideoAdView.this.mVideoView.getCurrentPosition());
                    }
                    if (VideoAdView.this.mSkipOffsetSec > 0) {
                        if (VideoAdView.this.mSkipOffsetSec - VideoAdView.this.mVideoCurPosSec > 0.0f) {
                            if (VideoAdView.this.mCircularProgressBar != null) {
                                VideoAdView.this.mCircularProgressBar.setProgressWithAnimation(VideoAdView.this.mVideoCurPosSec + 0.5f, 500L, null, 0L);
                                VideoAdView.this.mCircularProgressBar.setVisibility(0);
                            }
                            if (VideoAdView.this.mTimerTextView != null) {
                                int i2 = VideoAdView.this.mSkipOffsetSec - ((int) VideoAdView.this.mVideoCurPosSec);
                                VideoAdView.this.mTimerTextView.setText(i2 + "");
                                VideoAdView.this.mTimerTextView.setVisibility(0);
                                return;
                            }
                            return;
                        }
                        if (VideoAdView.this.mSkipButton == null || VideoAdView.this.mSkipButton.getVisibility() == 0) {
                            return;
                        }
                        VideoAdView videoAdView = VideoAdView.this;
                        videoAdView.post(videoAdView.showCloseButton);
                        return;
                    }
                    if (VideoAdView.this.mSkipOffsetSec == 0) {
                        if (VideoAdView.this.mSkipButton == null || VideoAdView.this.mSkipButton.getVisibility() == 0) {
                            return;
                        }
                        VideoAdView videoAdView2 = VideoAdView.this;
                        videoAdView2.post(videoAdView2.showCloseButton);
                        return;
                    }
                    if (VideoAdView.this.mCircularProgressBar != null) {
                        VideoAdView.this.mCircularProgressBar.setProgressWithAnimation(VideoAdView.this.mVideoCurPosSec + 0.5f, 500L, null, 0L);
                        VideoAdView.this.mCircularProgressBar.setVisibility(0);
                    }
                    if (VideoAdView.this.mTimerTextView != null) {
                        int i22 = VideoAdView.this.mVideoDuration - ((int) VideoAdView.this.mVideoCurPosSec);
                        VideoAdView.this.mTimerTextView.setText(i22 + "");
                        VideoAdView.this.mTimerTextView.setVisibility(0);
                    }
                } catch (Exception e) {
                    AdPieLog.e(VideoAdView.TAG, e);
                }
            }
        };
        this.videoPlayTrackerRunnable = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.3
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    if (VideoAdView.this.mVideoView != null && VideoAdView.this.mVideoView.isPlaying()) {
                        int currentPosition = VideoAdView.this.mVideoView.getCurrentPosition() / 1000;
                        AdPieLog.d(VideoAdView.TAG, "video current position  : " + currentPosition);
                        if (currentPosition > 0) {
                            if (currentPosition != VideoAdView.this.mFirstQuartile || VideoAdView.this.isSentFirst) {
                                if (currentPosition != VideoAdView.this.mSecondQuartile || VideoAdView.this.isSentSecond) {
                                    if (currentPosition == VideoAdView.this.mThirdQuartile && !VideoAdView.this.isSentThird) {
                                        VideoAdView.this.isSentThird = true;
                                        ReportUtil.sendReport("VIDEO_THIRD_QUARTILE", VideoAdView.this.mVideoAdData.getTrackingThirdQuartileUrls());
                                    }
                                } else {
                                    VideoAdView.this.isSentSecond = true;
                                    ReportUtil.sendReport("VIDEO_MID_POINT", VideoAdView.this.mVideoAdData.getTrackingMidpointUrls());
                                }
                            } else {
                                VideoAdView.this.isSentFirst = true;
                                ReportUtil.sendReport("VIDEO_FIRST_QUARTILE", VideoAdView.this.mVideoAdData.getTrackingFirstQuartileUrls());
                            }
                        }
                        VideoAdView videoAdView = VideoAdView.this;
                        videoAdView.post(videoAdView.updateTimeRunnable);
                        VideoAdView videoAdView2 = VideoAdView.this;
                        videoAdView2.postDelayed(videoAdView2.videoPlayTrackerRunnable, 500L);
                        return;
                    }
                    String str2 = VideoAdView.TAG;
                    StringBuilder sb = new StringBuilder("::: videoview : ");
                    if (VideoAdView.this.mVideoView != null) {
                        str = "isPlaying - " + VideoAdView.this.mVideoView.isPlaying();
                    } else {
                        str = AbstractJsonLexerKt.NULL;
                    }
                    sb.append(str);
                    AdPieLog.d(str2, sb.toString());
                } catch (Exception e) {
                    AdPieLog.e(VideoAdView.TAG, e);
                }
            }
        };
        this.checkVideoPrepared = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.4
            @Override // java.lang.Runnable
            public void run() {
                if (VideoAdView.this.mIsPrepared) {
                    return;
                }
                VideoAdView.this.notifyError();
                VideoAdView.this.stopVideo();
            }
        };
        this.mContext = context;
    }

    public VideoAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.showCloseButton = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.1
            @Override // java.lang.Runnable
            public void run() {
                if (VideoAdView.this.mCircularProgressBar != null) {
                    VideoAdView.this.mCircularProgressBar.setVisibility(8);
                }
                if (VideoAdView.this.mTimerTextView != null) {
                    VideoAdView.this.mTimerTextView.setVisibility(8);
                }
                if (VideoAdView.this.mSkipButton != null) {
                    VideoAdView.this.mSkipButton.setVisibility(0);
                }
            }
        };
        this.updateTimeRunnable = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (VideoAdView.this.mVideoView != null) {
                        VideoAdView.this.mVideoCurPosSec = r0.mVideoView.getCurrentPosition() / 1000.0f;
                    }
                    if (VideoAdView.this.mSeekbar != null && VideoAdView.this.mVideoView != null) {
                        VideoAdView.this.mSeekbar.setProgress(VideoAdView.this.mVideoView.getCurrentPosition());
                    }
                    if (VideoAdView.this.mSkipOffsetSec > 0) {
                        if (VideoAdView.this.mSkipOffsetSec - VideoAdView.this.mVideoCurPosSec > 0.0f) {
                            if (VideoAdView.this.mCircularProgressBar != null) {
                                VideoAdView.this.mCircularProgressBar.setProgressWithAnimation(VideoAdView.this.mVideoCurPosSec + 0.5f, 500L, null, 0L);
                                VideoAdView.this.mCircularProgressBar.setVisibility(0);
                            }
                            if (VideoAdView.this.mTimerTextView != null) {
                                int i22 = VideoAdView.this.mSkipOffsetSec - ((int) VideoAdView.this.mVideoCurPosSec);
                                VideoAdView.this.mTimerTextView.setText(i22 + "");
                                VideoAdView.this.mTimerTextView.setVisibility(0);
                                return;
                            }
                            return;
                        }
                        if (VideoAdView.this.mSkipButton == null || VideoAdView.this.mSkipButton.getVisibility() == 0) {
                            return;
                        }
                        VideoAdView videoAdView = VideoAdView.this;
                        videoAdView.post(videoAdView.showCloseButton);
                        return;
                    }
                    if (VideoAdView.this.mSkipOffsetSec == 0) {
                        if (VideoAdView.this.mSkipButton == null || VideoAdView.this.mSkipButton.getVisibility() == 0) {
                            return;
                        }
                        VideoAdView videoAdView2 = VideoAdView.this;
                        videoAdView2.post(videoAdView2.showCloseButton);
                        return;
                    }
                    if (VideoAdView.this.mCircularProgressBar != null) {
                        VideoAdView.this.mCircularProgressBar.setProgressWithAnimation(VideoAdView.this.mVideoCurPosSec + 0.5f, 500L, null, 0L);
                        VideoAdView.this.mCircularProgressBar.setVisibility(0);
                    }
                    if (VideoAdView.this.mTimerTextView != null) {
                        int i222 = VideoAdView.this.mVideoDuration - ((int) VideoAdView.this.mVideoCurPosSec);
                        VideoAdView.this.mTimerTextView.setText(i222 + "");
                        VideoAdView.this.mTimerTextView.setVisibility(0);
                    }
                } catch (Exception e) {
                    AdPieLog.e(VideoAdView.TAG, e);
                }
            }
        };
        this.videoPlayTrackerRunnable = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.3
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    if (VideoAdView.this.mVideoView != null && VideoAdView.this.mVideoView.isPlaying()) {
                        int currentPosition = VideoAdView.this.mVideoView.getCurrentPosition() / 1000;
                        AdPieLog.d(VideoAdView.TAG, "video current position  : " + currentPosition);
                        if (currentPosition > 0) {
                            if (currentPosition != VideoAdView.this.mFirstQuartile || VideoAdView.this.isSentFirst) {
                                if (currentPosition != VideoAdView.this.mSecondQuartile || VideoAdView.this.isSentSecond) {
                                    if (currentPosition == VideoAdView.this.mThirdQuartile && !VideoAdView.this.isSentThird) {
                                        VideoAdView.this.isSentThird = true;
                                        ReportUtil.sendReport("VIDEO_THIRD_QUARTILE", VideoAdView.this.mVideoAdData.getTrackingThirdQuartileUrls());
                                    }
                                } else {
                                    VideoAdView.this.isSentSecond = true;
                                    ReportUtil.sendReport("VIDEO_MID_POINT", VideoAdView.this.mVideoAdData.getTrackingMidpointUrls());
                                }
                            } else {
                                VideoAdView.this.isSentFirst = true;
                                ReportUtil.sendReport("VIDEO_FIRST_QUARTILE", VideoAdView.this.mVideoAdData.getTrackingFirstQuartileUrls());
                            }
                        }
                        VideoAdView videoAdView = VideoAdView.this;
                        videoAdView.post(videoAdView.updateTimeRunnable);
                        VideoAdView videoAdView2 = VideoAdView.this;
                        videoAdView2.postDelayed(videoAdView2.videoPlayTrackerRunnable, 500L);
                        return;
                    }
                    String str2 = VideoAdView.TAG;
                    StringBuilder sb = new StringBuilder("::: videoview : ");
                    if (VideoAdView.this.mVideoView != null) {
                        str = "isPlaying - " + VideoAdView.this.mVideoView.isPlaying();
                    } else {
                        str = AbstractJsonLexerKt.NULL;
                    }
                    sb.append(str);
                    AdPieLog.d(str2, sb.toString());
                } catch (Exception e) {
                    AdPieLog.e(VideoAdView.TAG, e);
                }
            }
        };
        this.checkVideoPrepared = new Runnable() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.4
            @Override // java.lang.Runnable
            public void run() {
                if (VideoAdView.this.mIsPrepared) {
                    return;
                }
                VideoAdView.this.notifyError();
                VideoAdView.this.stopVideo();
            }
        };
        this.mContext = context;
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    private void addAdUnits() {
        try {
            setupContainer();
            setupVideoView();
            setupSeekBar();
            setupClickButton();
            setupSkipButton();
            setupCircleProgressBar();
            setupProgressBar();
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
        }
    }

    private void removeAdUnits() {
        try {
            removeAllViews();
            VideoView videoView = this.mVideoView;
            if (videoView != null) {
                videoView.stopPlayback();
            }
            SpinningLoaderView spinningLoaderView = this.mProgressBar;
            if (spinningLoaderView != null) {
                spinningLoaderView.setVisibility(8);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.mVideoView = null;
            this.mSkipButton = null;
            this.mSeekbar = null;
            this.mAdButton = null;
            this.mCircularProgressBar = null;
            this.mProgressBar = null;
            throw th;
        }
        this.mVideoView = null;
        this.mSkipButton = null;
        this.mSeekbar = null;
        this.mAdButton = null;
        this.mCircularProgressBar = null;
        this.mProgressBar = null;
    }

    private void setupContainer() {
        setBackgroundColor(Color.parseColor("#000000"));
    }

    private void setupVideoView() {
        if (this.mVideoView == null) {
            VideoView videoView = new VideoView(this.mContext);
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
            addView(this.mVideoView, layoutParams);
        }
    }

    private void setupSkipButton() {
        if (this.mSkipButton == null) {
            Button button = new Button(this.mContext);
            this.mSkipButton = button;
            button.setTextColor(-1);
            this.mSkipButton.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoAdView.this.notifySkipped();
                    VideoAdView.this.stopVideo();
                }
            });
            this.mSkipButton.setText("Skip");
            this.mSkipButton.setTextSize(2, 9.0f);
            this.mSkipButton.setMinimumHeight(0);
            this.mSkipButton.setMinimumWidth(0);
            this.mSkipButton.setMaxLines(1);
            this.mSkipButton.setSingleLine();
            this.mSkipButton.setWidth(DisplayUtil.dpToPx(this.mContext, 60));
            this.mSkipButton.setHeight(DisplayUtil.dpToPx(this.mContext, 32));
            this.mSkipButton.setAllCaps(false);
            this.mSkipButton.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, this.mVideoView.getId());
            layoutParams.addRule(8, this.mVideoView.getId());
            int iDpToPx = DisplayUtil.dpToPx(this.mContext, 10);
            layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
            this.mSkipButton.setLayoutParams(layoutParams);
            this.mSkipButton.setVisibility(8);
            addView(this.mSkipButton, layoutParams);
        }
    }

    private void setupSeekBar() {
        if (this.mSeekbar == null) {
            this.mSeekbar = new NoSkipSeekBar(this.mContext);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, DisplayUtil.dpToPx(this.mContext, 4));
            layoutParams.addRule(8, this.mVideoView.getId());
            this.mSeekbar.setLayoutParams(layoutParams);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f}, null, null));
            shapeDrawable.setIntrinsicHeight(0);
            shapeDrawable.setIntrinsicWidth(0);
            this.mSeekbar.setThumb(shapeDrawable);
            addView(this.mSeekbar);
            try {
                this.mSeekbar.getProgressDrawable().setColorFilter(Color.parseColor("#FF4081"), PorterDuff.Mode.SRC_IN);
                this.mSeekbar.getThumb().setColorFilter(Color.parseColor("#FF4081"), PorterDuff.Mode.SRC_IN);
            } catch (Exception unused) {
            }
        }
    }

    private void setupClickButton() {
        if (this.mIsClickableVideo && this.mAdButton == null) {
            Button button = new Button(this.mContext);
            this.mAdButton = button;
            button.setBackgroundColor(Integer.MIN_VALUE);
            this.mAdButton.setTextColor(-1);
            this.mAdButton.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!ClickThroughUtil.isValidClick()) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(VideoAdView.TAG, ":::clickEvent::: " + VideoAdView.this.mLink + " -> block");
                            return;
                        }
                        return;
                    }
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(VideoAdView.TAG, ":::clickEvent::: " + VideoAdView.this.mLink + " -> isWebViewLanding : " + VideoAdView.this.mIsWebViewLanding);
                    }
                    if (VideoAdView.this.mIsWebViewLanding) {
                        HttpUtil.getFinalURL(VideoAdView.this.mLink, new Handler(Looper.getMainLooper()) { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdView.6.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 100) {
                                    return;
                                }
                                try {
                                    if (ClickThroughUtil.goToWebView(VideoAdView.this.mContext, (String) message.obj)) {
                                        VideoAdView.this.notifyClick();
                                        if (VideoAdView.this.mVideoAdData != null) {
                                            ReportUtil.sendReport("VIDEO_CLICK", VideoAdView.this.mVideoAdData.getTrackingClkUrls());
                                        }
                                    } else if (ClickThroughUtil.goToBrowser(VideoAdView.this.mContext, (String) message.obj)) {
                                        VideoAdView.this.notifyClick();
                                        if (VideoAdView.this.mVideoAdData != null) {
                                            ReportUtil.sendReport("VIDEO_CLICK", VideoAdView.this.mVideoAdData.getTrackingClkUrls());
                                        }
                                    }
                                } catch (Exception e) {
                                    AdPieLog.e(VideoAdView.TAG, e);
                                }
                            }
                        });
                    } else if (ClickThroughUtil.goToBrowser(VideoAdView.this.mContext, VideoAdView.this.mLink)) {
                        VideoAdView.this.notifyClick();
                        if (VideoAdView.this.mVideoAdData != null) {
                            ReportUtil.sendReport("VIDEO_CLICK", VideoAdView.this.mVideoAdData.getTrackingClkUrls());
                        }
                    }
                }
            });
            if (TextUtils.isEmpty(this.mVideoAdData.getLinkText())) {
                this.mAdButton.setText("자세히 보기");
            } else {
                this.mAdButton.setText(this.mVideoAdData.getLinkText());
            }
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
            layoutParams.addRule(7, this.mVideoView.getId());
            layoutParams.addRule(8, this.mVideoView.getId());
            int iDpToPx = DisplayUtil.dpToPx(this.mContext, 10);
            layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
            this.mAdButton.setLayoutParams(layoutParams);
            this.mAdButton.setVisibility(0);
            addView(this.mAdButton, layoutParams);
        }
    }

    private void setupCircleProgressBar() {
        if (this.mCircularProgressBar == null) {
            CircularProgressBar circularProgressBar = new CircularProgressBar(this.mContext, null);
            this.mCircularProgressBar = circularProgressBar;
            circularProgressBar.setCircleBackgroundColor(-16777216);
            this.mCircularProgressBar.setProgressBarColor(Color.parseColor("#B344C8E5"));
            this.mCircularProgressBar.setBackgroundProgressBarColor(-7829368);
            this.mCircularProgressBar.setProgressBarWidth(5.0f);
            this.mCircularProgressBar.setBackgroundProgressBarWidth(3.0f);
            this.mCircularProgressBar.setRoundBorder(true);
            this.mCircularProgressBar.setStartAngle(0.0f);
            this.mCircularProgressBar.setProgressDirection(CircularProgressBar.ProgressDirection.TO_RIGHT);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 32), DisplayUtil.dpToPx(this.mContext, 32));
            layoutParams.addRule(5, this.mVideoView.getId());
            layoutParams.addRule(8, this.mVideoView.getId());
            int iDpToPx = DisplayUtil.dpToPx(this.mContext, 10);
            layoutParams.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
            this.mCircularProgressBar.setLayoutParams(layoutParams);
            this.mCircularProgressBar.setVisibility(8);
            addView(this.mCircularProgressBar);
            TextView textView = new TextView(this.mContext);
            this.mTimerTextView = textView;
            textView.setLayoutParams(layoutParams);
            this.mTimerTextView.setTextColor(Color.parseColor("#FFFFFF"));
            this.mTimerTextView.setTextSize(DisplayUtil.dpToPx(this.mContext, 4));
            this.mTimerTextView.setGravity(17);
            this.mTimerTextView.setVisibility(8);
            addView(this.mTimerTextView);
        }
    }

    private void setupProgressBar() {
        if (this.mProgressBar == null) {
            this.mProgressBar = new SpinningLoaderView(this.mContext);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 48), DisplayUtil.dpToPx(this.mContext, 48));
            layoutParams.addRule(15, this.mVideoView.getId());
            layoutParams.addRule(14, this.mVideoView.getId());
            this.mProgressBar.setLayoutParams(layoutParams);
            this.mProgressBar.setVisibility(8);
            addView(this.mProgressBar);
        }
    }

    public void playVideo(AdEventListener adEventListener, VideoAdData videoAdData) {
        stopVideo();
        this.mVideoAdData = videoAdData;
        int skipOffset = videoAdData.getSkipOffset();
        this.mSkipOffsetSec = skipOffset;
        if (skipOffset > 0 && skipOffset < 3) {
            this.mSkipOffsetSec = 3;
        }
        this.mLink = this.mVideoAdData.getLink();
        this.mIsWebViewLanding = this.mVideoAdData.getWebviewLanding() == 1;
        this.mIsClickableVideo = !TextUtils.isEmpty(this.mLink);
        addAdUnits();
        SpinningLoaderView spinningLoaderView = this.mProgressBar;
        if (spinningLoaderView != null) {
            spinningLoaderView.setVisibility(0);
        }
        this.mAdEventListener = adEventListener;
        this.mVideoView.setVisibility(8);
        this.mVideoView.setVisibility(0);
        this.mVideoView.setVideoURI(Uri.parse(this.mVideoAdData.getVideoContent()));
        this.mVideoView.requestFocus();
        this.mIsPrepared = false;
        postDelayed(this.checkVideoPrepared, 5000L);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        try {
            this.mIsPrepared = true;
            removeCallbacks(this.checkVideoPrepared);
            this.mMediaPlayer = mediaPlayer;
            mediaPlayer.setOnVideoSizeChangedListener(this);
            int duration = mediaPlayer.getDuration();
            long j = duration;
            AdPieLog.d(TAG, String.format("onPrepared - %d:%d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))));
            int i = duration / 1000;
            this.mVideoDuration = i;
            if (this.mSkipOffsetSec > i) {
                this.mSkipOffsetSec = i;
            }
            this.mFirstQuartile = i / 4;
            this.mSecondQuartile = i / 2;
            this.mThirdQuartile = (i * 3) / 4;
            SpinningLoaderView spinningLoaderView = this.mProgressBar;
            if (spinningLoaderView != null) {
                spinningLoaderView.setVisibility(8);
            }
            this.mVideoView.start();
            int i2 = this.mSkipOffsetSec;
            if (i2 > 0) {
                CircularProgressBar circularProgressBar = this.mCircularProgressBar;
                if (circularProgressBar != null) {
                    circularProgressBar.setProgressMax(i2);
                    this.mCircularProgressBar.setVisibility(0);
                }
                TextView textView = this.mTimerTextView;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                Button button = this.mSkipButton;
                if (button != null) {
                    button.setVisibility(8);
                }
            } else if (i2 == 0) {
                CircularProgressBar circularProgressBar2 = this.mCircularProgressBar;
                if (circularProgressBar2 != null) {
                    circularProgressBar2.setVisibility(8);
                }
                TextView textView2 = this.mTimerTextView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                Button button2 = this.mSkipButton;
                if (button2 != null) {
                    button2.setVisibility(0);
                }
            } else {
                CircularProgressBar circularProgressBar3 = this.mCircularProgressBar;
                if (circularProgressBar3 != null) {
                    circularProgressBar3.setProgressMax(this.mVideoDuration);
                    this.mCircularProgressBar.setVisibility(0);
                }
                TextView textView3 = this.mTimerTextView;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
            }
            NoSkipSeekBar noSkipSeekBar = this.mSeekbar;
            if (noSkipSeekBar != null) {
                noSkipSeekBar.setMax(duration);
            }
            removeCallbacks(this.videoPlayTrackerRunnable);
            post(this.videoPlayTrackerRunnable);
            notifyStarted();
            if (!this.isSentImpression) {
                this.isSentImpression = true;
                ReportUtil.sendReport("VIDEO_IMPRESSION", this.mVideoAdData.getTrackingImpUrls());
            }
            if (this.isSentStart) {
                return;
            }
            this.isSentStart = true;
            ReportUtil.sendReport("VIDEO_START", this.mVideoAdData.getTrackingStartUrls());
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
            notifyError();
            stopVideo();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        AdPieLog.d(TAG, "onError - what : " + i + ", extra : " + i2);
        notifyError();
        stopVideo();
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 701) {
            AdPieLog.d(TAG, "MediaPlayer Buffering Start");
            SpinningLoaderView spinningLoaderView = this.mProgressBar;
            if (spinningLoaderView != null) {
                spinningLoaderView.setVisibility(0);
            }
        } else if (i == 702) {
            AdPieLog.d(TAG, "MediaPlayer Buffering End");
            SpinningLoaderView spinningLoaderView2 = this.mProgressBar;
            if (spinningLoaderView2 != null) {
                spinningLoaderView2.setVisibility(8);
            }
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        AdPieLog.d(TAG, "onCompletion - current position : " + this.mVideoCurPosSec + ", duration : " + this.mVideoDuration);
        NoSkipSeekBar noSkipSeekBar = this.mSeekbar;
        if (noSkipSeekBar != null) {
            noSkipSeekBar.setProgress(noSkipSeekBar.getMax());
        }
        notifyCompleted();
        if (!this.isSentComplete) {
            this.isSentComplete = true;
            ReportUtil.sendReport("VIDEO_COMPLETE", this.mVideoAdData.getTrackingCompleteUrls());
        }
        stopVideo();
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        String str;
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("onVideoSizeChanged - video size : ");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        sb.append(", VideoAdView size : ");
        sb.append(getWidth());
        sb.append("x");
        sb.append(getHeight());
        if (this.mVideoView != null) {
            str = ", VideoView size : " + this.mVideoView.getWidth() + "x" + this.mVideoView.getHeight();
        } else {
            str = "";
        }
        sb.append(str);
        AdPieLog.d(str2, sb.toString());
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            return;
        }
        int i = configuration.orientation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVideo() {
        try {
            AdPieLog.d(TAG, "stopVideo");
            removeCallbacks(this.checkVideoPrepared);
            removeCallbacks(this.videoPlayTrackerRunnable);
            removeCallbacks(this.updateTimeRunnable);
            removeAdUnits();
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
        }
    }

    public boolean isPlaying() {
        VideoView videoView = this.mVideoView;
        if (videoView != null) {
            return videoView.isPlaying();
        }
        return false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            if (this.mVideoView != null) {
                notifyStopped();
            }
            stopVideo();
        }
        AdPieLog.d(TAG, "onVisibilityChanged : ".concat(i == 0 ? "VISIBLE" : "INVISIBLE"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyClick() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyAdClicked();
        }
    }

    private void notifyStarted() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyVideoAdStarted();
        }
    }

    private void notifyPaused() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyVideoAdPaused();
        }
    }

    private void notifyStopped() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyVideoAdStopped();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySkipped() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyVideoAdSkipped();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyVideoAdError();
        }
    }

    private void notifyCompleted() {
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyVideoAdCompleted();
        }
    }

    public void setVideoAdData(VideoAdData videoAdData) {
        this.mVideoAdData = videoAdData;
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
            AdPieLog.e(TAG, e);
            return false;
        }
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
