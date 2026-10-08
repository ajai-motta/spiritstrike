package com.gomfactory.adpie.sdk.nativeads.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.view.View;
import com.gomfactory.adpie.sdk.util.AsyncTaskUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class VideoThumbnail {
    private Bitmap mBitmap;
    private long mTimeUs;
    private String mUrl;
    private View mView;

    public VideoThumbnail(View view, String str) {
        this.mTimeUs = -1L;
        this.mView = view;
        this.mUrl = str;
    }

    public VideoThumbnail(View view, String str, long j) {
        this.mView = view;
        this.mUrl = str;
        this.mTimeUs = j;
    }

    public void execute() {
        new AsyncTaskUtil() { // from class: com.gomfactory.adpie.sdk.nativeads.util.VideoThumbnail.1
            @Override // com.gomfactory.adpie.sdk.util.AsyncTaskUtil
            public void doInBackground() throws Throwable {
                MediaMetadataRetriever mediaMetadataRetriever;
                Throwable th;
                MediaMetadataRetriever mediaMetadataRetriever2 = null;
                try {
                    try {
                        mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(VideoThumbnail.this.mUrl, new HashMap());
                            if (VideoThumbnail.this.mTimeUs > -1) {
                                VideoThumbnail videoThumbnail = VideoThumbnail.this;
                                videoThumbnail.mBitmap = mediaMetadataRetriever.getFrameAtTime(videoThumbnail.mTimeUs * 1000, 3);
                            } else {
                                VideoThumbnail.this.mBitmap = mediaMetadataRetriever.getFrameAtTime();
                            }
                            mediaMetadataRetriever.release();
                        } catch (Exception unused) {
                            mediaMetadataRetriever2 = mediaMetadataRetriever;
                            if (mediaMetadataRetriever2 == null) {
                            } else {
                                mediaMetadataRetriever2.release();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (mediaMetadataRetriever != null) {
                                try {
                                    mediaMetadataRetriever.release();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception unused3) {
                    } catch (Throwable th3) {
                        mediaMetadataRetriever = null;
                        th = th3;
                    }
                } catch (Exception unused4) {
                }
            }

            @Override // com.gomfactory.adpie.sdk.util.AsyncTaskUtil
            public void doInUiThread() {
                if (VideoThumbnail.this.mView != null) {
                    if (VideoThumbnail.this.mBitmap == null) {
                        VideoThumbnail.this.mView.setBackground(null);
                    } else {
                        VideoThumbnail.this.mView.setBackground(new BitmapDrawable(VideoThumbnail.this.mView.getResources(), VideoThumbnail.this.mBitmap));
                    }
                }
            }
        }.execute();
    }
}
