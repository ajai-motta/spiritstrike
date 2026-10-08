package com.adxcorp.ads.mediation.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.nativeads.util.DownloadImage;
import com.adxcorp.ads.mediation.nativeads.util.GlideModuleV4;
import com.adxcorp.ads.mediation.nativeads.util.ImageModuleEventListener;
import com.adxcorp.util.ADXLogUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class NativeAdImageHelper {
    private static final int IMAGE_DOWNLOAD_ASYNCTASK = 0;
    private static final int IMAGE_DOWNLOAD_GLIDE_V4 = 1;
    public static final String TAG = "NativeAdView";
    private Context mContext;
    private int mImageDownloadMode;
    private ImageLoadEventListener mImageLoadEventListener;
    private int resourceErrorCnt;
    private int resourceLoadedCnt;
    private int resourceTotalCnt;

    public interface ImageLoadEventListener {
        void onError();

        void onSuccess();
    }

    public NativeAdImageHelper(Context context) {
        this.mImageDownloadMode = 0;
        this.mContext = context;
        try {
            Class.forName("com.bumptech.glide.module.AppGlideModule");
            this.mImageDownloadMode = 1;
        } catch (ClassNotFoundException unused) {
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "ImageDownloadMode : " + this.mImageDownloadMode);
        }
    }

    public void load(HashMap<String, ImageView> map, ImageLoadEventListener imageLoadEventListener) {
        this.mImageLoadEventListener = imageLoadEventListener;
        this.resourceTotalCnt = 0;
        this.resourceLoadedCnt = 0;
        this.resourceErrorCnt = 0;
        try {
            if (map == null) {
                if (imageLoadEventListener != null) {
                    imageLoadEventListener.onError();
                    return;
                }
                return;
            }
            try {
                for (String str : map.keySet()) {
                    if (str == null) {
                        ImageLoadEventListener imageLoadEventListener2 = this.mImageLoadEventListener;
                        if (imageLoadEventListener2 != null) {
                            imageLoadEventListener2.onError();
                        }
                        if (map != null) {
                            map.clear();
                            return;
                        }
                        return;
                    }
                    ImageView imageView = map.get(str);
                    if (imageView == null) {
                        ImageLoadEventListener imageLoadEventListener3 = this.mImageLoadEventListener;
                        if (imageLoadEventListener3 != null) {
                            imageLoadEventListener3.onError();
                        }
                        if (map != null) {
                            map.clear();
                            return;
                        }
                        return;
                    }
                    loadImage(str, imageView);
                }
                if (map == null) {
                    return;
                }
            } catch (Exception e) {
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.e(TAG, e);
                }
                if (map == null) {
                    return;
                }
            }
            map.clear();
        } catch (Throwable th) {
            if (map != null) {
                map.clear();
            }
            throw th;
        }
    }

    private void loadImage(final String str, final ImageView imageView) {
        this.resourceTotalCnt++;
        try {
            String str2 = TAG;
            ADXLogUtil.d(str2, ":::loadImage:::ImageView width : " + imageView.getWidth() + ", height : " + imageView.getHeight());
            if (imageView.getVisibility() != 0) {
                ADXLogUtil.d(str2, String.format("%s", Integer.valueOf(imageView.getVisibility())) + ", ImageView.getVisibility() != View.VISIBLE");
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        int i = NativeAdImageHelper.this.mImageDownloadMode;
                        if (i == 0) {
                            NativeAdImageHelper.this.loadAsyncImage(imageView, str);
                        } else if (i == 1) {
                            ADXLogUtil.d(NativeAdImageHelper.TAG, ":::loadImage:::Glide (V4) load url : " + str);
                            try {
                                new GlideModuleV4(NativeAdImageHelper.this.mContext, imageView, new ImageModuleEventListener() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.1.1
                                    @Override // com.adxcorp.ads.mediation.nativeads.util.ImageModuleEventListener
                                    public void onLoaded(String str3) {
                                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                                            ADXLogUtil.d(NativeAdImageHelper.TAG, "Glide V4 onLoaded : " + str3);
                                        }
                                        NativeAdImageHelper.this.notifySuccess();
                                    }

                                    @Override // com.adxcorp.ads.mediation.nativeads.util.ImageModuleEventListener
                                    public void onFailedToLoad(String str3) {
                                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                                            ADXLogUtil.d(NativeAdImageHelper.TAG, "Glide V4 onFailedToLoad : " + str3);
                                        }
                                        NativeAdImageHelper.this.loadAsyncImage(imageView, str);
                                    }
                                }).load(str, 3000L);
                            } catch (NoClassDefFoundError unused) {
                            }
                        }
                    } catch (Exception e) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.e(NativeAdImageHelper.TAG, e);
                        }
                        NativeAdImageHelper.this.notifyError();
                    }
                }
            });
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
            notifyError();
        }
    }

    public boolean isResourceReady() {
        int i = this.resourceTotalCnt;
        return i > 0 && this.resourceLoadedCnt == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError() {
        ImageLoadEventListener imageLoadEventListener;
        int i = this.resourceErrorCnt + 1;
        this.resourceErrorCnt = i;
        if (i != 1 || (imageLoadEventListener = this.mImageLoadEventListener) == null) {
            return;
        }
        imageLoadEventListener.onError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySuccess() {
        ImageLoadEventListener imageLoadEventListener;
        this.resourceLoadedCnt++;
        if (!isResourceReady() || (imageLoadEventListener = this.mImageLoadEventListener) == null) {
            return;
        }
        imageLoadEventListener.onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAsyncImage(ImageView imageView, String str) {
        ADXLogUtil.d(TAG, ":::loadImage:::AsyncTask load url : " + str);
        new DownloadImage(imageView, 3000L, str, new ImageModuleEventListener() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.2
            @Override // com.adxcorp.ads.mediation.nativeads.util.ImageModuleEventListener
            public void onLoaded(String str2) {
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(NativeAdImageHelper.TAG, "AsyncTask onLoaded : " + str2);
                }
                NativeAdImageHelper.this.notifySuccess();
            }

            @Override // com.adxcorp.ads.mediation.nativeads.util.ImageModuleEventListener
            public void onFailedToLoad(String str2) {
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(NativeAdImageHelper.TAG, "AsyncTask onFailedToLoad : " + str2);
                }
                NativeAdImageHelper.this.notifyError();
            }
        }).execute();
    }
}
