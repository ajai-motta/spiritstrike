package com.gomfactory.adpie.sdk.nativeads.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.AsyncTaskUtil;
import com.gomfactory.adpie.sdk.util.MemUtil;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadImage {
    public static final String TAG = "DownloadImage";
    private Bitmap mBitmap;
    private Handler mHandler;
    private ImageModuleEventListener mImageModuleEventListener;
    private ImageView mImageView;
    private boolean mIsFinished;
    private long mTimeout;
    private String mUrl;

    public DownloadImage(ImageView imageView, long j, String str, ImageModuleEventListener imageModuleEventListener) {
        this.mImageView = imageView;
        this.mImageModuleEventListener = imageModuleEventListener;
        this.mTimeout = j;
        this.mUrl = str;
    }

    public void execute() {
        new AsyncTaskUtil() { // from class: com.gomfactory.adpie.sdk.nativeads.util.DownloadImage.1
            @Override // com.gomfactory.adpie.sdk.util.AsyncTaskUtil
            public void doInBackground() {
                if (DownloadImage.this.mTimeout > 0) {
                    DownloadImage.this.mHandler = new Handler(Looper.getMainLooper());
                    DownloadImage.this.mHandler.postDelayed(new Runnable() { // from class: com.gomfactory.adpie.sdk.nativeads.util.DownloadImage.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DownloadImage.this.mIsFinished) {
                                return;
                            }
                            DownloadImage.this.mIsFinished = true;
                            if (DownloadImage.this.mImageModuleEventListener != null) {
                                DownloadImage.this.mImageModuleEventListener.onFailedToLoad("Image loading time is delayed.");
                            }
                        }
                    }, DownloadImage.this.mTimeout);
                }
                try {
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(DownloadImage.TAG, "free memory : " + MemUtil.megabytesFree() + "(MB), total memory : " + MemUtil.megabytesAvailable() + "(MB)");
                    }
                    URL url = new URL(DownloadImage.this.mUrl);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(url.openStream(), null, options);
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(DownloadImage.TAG, "options.outWidth : " + options.outWidth + ", options.outHeight : " + options.outHeight);
                    }
                    if (options.outWidth > 1000) {
                        options.inSampleSize = 2;
                    } else {
                        options.inSampleSize = 1;
                    }
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(DownloadImage.TAG, "inSampleSize : " + options.inSampleSize);
                    }
                    options.inJustDecodeBounds = false;
                    DownloadImage.this.mBitmap = BitmapFactory.decodeStream(url.openStream(), null, options);
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(DownloadImage.TAG, "#free memory : " + MemUtil.megabytesFree() + "(MB), total memory : " + MemUtil.megabytesAvailable() + "(MB)");
                    }
                } catch (Exception e) {
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(DownloadImage.TAG, e);
                    }
                } catch (OutOfMemoryError e2) {
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(DownloadImage.TAG, "[oom] free memory : " + MemUtil.megabytesFree() + "(MB), total memory : " + MemUtil.megabytesAvailable() + "(MB)");
                        AdPieLog.e(DownloadImage.TAG, new Exception(e2));
                        MemUtil.printMemoryLog();
                    }
                    MemUtil.setMemoryError(true);
                }
            }

            @Override // com.gomfactory.adpie.sdk.util.AsyncTaskUtil
            public void doInUiThread() {
                if (DownloadImage.this.mIsFinished) {
                    return;
                }
                DownloadImage.this.mIsFinished = true;
                try {
                    if (DownloadImage.this.mBitmap == null) {
                        if (DownloadImage.this.mImageModuleEventListener != null) {
                            DownloadImage.this.mImageModuleEventListener.onFailedToLoad("");
                            return;
                        }
                        return;
                    }
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(DownloadImage.TAG, "Bitmap size : " + DownloadImage.this.mBitmap.getByteCount() + ", url : " + DownloadImage.this.mUrl);
                    }
                    if (DownloadImage.this.mBitmap.getByteCount() > 5242880) {
                        if (DownloadImage.this.mImageModuleEventListener != null) {
                            DownloadImage.this.mImageModuleEventListener.onFailedToLoad("Bitmap size exceeded 5 MB.");
                        }
                    } else {
                        DownloadImage.this.mImageView.setImageBitmap(DownloadImage.this.mBitmap);
                        if (DownloadImage.this.mImageModuleEventListener != null) {
                            DownloadImage.this.mImageModuleEventListener.onLoaded("");
                        }
                    }
                } catch (Exception e) {
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.e(DownloadImage.TAG, e);
                    }
                    if (DownloadImage.this.mImageModuleEventListener != null) {
                        DownloadImage.this.mImageModuleEventListener.onFailedToLoad("");
                    }
                }
            }
        }.execute();
    }
}
