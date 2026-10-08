package com.gomfactory.adpie.sdk.nativeads.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.hive.ResultAPI;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class GlideModuleV4 {
    public static final String TAG = "GlideModuleV4";
    private Context mContext;
    private Handler mHandler;
    private ImageModuleEventListener mImageModuleEventListener;
    private ImageView mImageView;
    private boolean mIsFinished;

    public GlideModuleV4(Context context, ImageView imageView, ImageModuleEventListener imageModuleEventListener) {
        this.mContext = context;
        this.mImageView = imageView;
        this.mImageModuleEventListener = imageModuleEventListener;
    }

    public void load(String str, long j) {
        if (j > 0) {
            try {
                Handler handler = new Handler(Looper.getMainLooper());
                this.mHandler = handler;
                handler.postDelayed(new Runnable() { // from class: com.gomfactory.adpie.sdk.nativeads.util.GlideModuleV4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GlideModuleV4.this.mIsFinished) {
                            return;
                        }
                        GlideModuleV4.this.mIsFinished = true;
                        if (GlideModuleV4.this.mImageModuleEventListener != null) {
                            GlideModuleV4.this.mImageModuleEventListener.onFailedToLoad("Image loading time is delayed.");
                        }
                    }
                }, j);
            } catch (Throwable th) {
                ImageModuleEventListener imageModuleEventListener = this.mImageModuleEventListener;
                if (imageModuleEventListener != null) {
                    imageModuleEventListener.onFailedToLoad("exception : " + th.getMessage());
                    return;
                }
                return;
            }
        }
        Glide.with(this.mContext).load(str).listener(new RequestListener() { // from class: com.gomfactory.adpie.sdk.nativeads.util.GlideModuleV4.2
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
                if (!GlideModuleV4.this.mIsFinished) {
                    GlideModuleV4.this.mIsFinished = true;
                    if (GlideModuleV4.this.mImageModuleEventListener != null) {
                        GlideModuleV4.this.mImageModuleEventListener.onFailedToLoad(String.format(Locale.ROOT, ":::loadImage:::Glide onLoadFailed(%s, %s, %s, %s)", glideException, obj, target, Boolean.valueOf(z)));
                    }
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Object obj, Object obj2, Target target, DataSource dataSource, boolean z) {
                if (!GlideModuleV4.this.mIsFinished) {
                    GlideModuleV4.this.mIsFinished = true;
                    if (GlideModuleV4.this.mImageModuleEventListener != null) {
                        GlideModuleV4.this.mImageModuleEventListener.onLoaded(String.format(Locale.ROOT, ":::loadImage:::Glide onResourceReady(%s, %s, %s, %s, %s)", obj, obj2, target, dataSource, Boolean.valueOf(z)));
                    }
                }
                return false;
            }
        }).apply((BaseRequestOptions<?>) new RequestOptions().override(ResultAPI.PeppermintErrCode.HUB_E_INVALID_URL)).into(this.mImageView);
    }
}
