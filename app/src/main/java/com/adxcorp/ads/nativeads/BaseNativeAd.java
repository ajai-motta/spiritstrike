package com.adxcorp.ads.nativeads;

import android.view.View;
import com.adxcorp.ads.common.NewsFeed;
import com.adxcorp.ads.common.OnPaidEventListener;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseNativeAd {
    private final String TAG = "BaseNativeAd";
    private boolean mInvalidated = false;
    private NativeEventListener mNativeEventListener;
    private NewsClickListener mNewsClickListener;
    private NewsFeed mNewsFeed;
    private OnPaidEventListener mOnPaidEventListener;

    public interface NativeEventListener {
        void onAdClicked();

        void onAdImpressed();
    }

    public interface NewsClickListener {
        void onNewsClicked();
    }

    public abstract void clear(View view);

    public abstract void destroy();

    public abstract void prepare(View view);

    protected BaseNativeAd() {
    }

    public void setNativeEventListener(NativeEventListener nativeEventListener) {
        this.mNativeEventListener = nativeEventListener;
    }

    public void setNewsClickListener(NewsClickListener newsClickListener) {
        this.mNewsClickListener = newsClickListener;
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.mOnPaidEventListener = onPaidEventListener;
    }

    public void notifyAdImpressed() {
        NativeEventListener nativeEventListener = this.mNativeEventListener;
        if (nativeEventListener != null) {
            nativeEventListener.onAdImpressed();
        }
    }

    public void notifyAdClicked() {
        NativeEventListener nativeEventListener = this.mNativeEventListener;
        if (nativeEventListener != null) {
            nativeEventListener.onAdClicked();
        }
    }

    public void notifyNewsClicked() {
        NewsClickListener newsClickListener = this.mNewsClickListener;
        if (newsClickListener != null) {
            newsClickListener.onNewsClicked();
        }
    }

    public void onPaidEvent(double d) {
        OnPaidEventListener onPaidEventListener = this.mOnPaidEventListener;
        if (onPaidEventListener != null) {
            onPaidEventListener.onPaidEvent(d);
        }
    }

    public void invalidate() {
        this.mInvalidated = true;
    }

    public boolean isInvalidated() {
        return this.mInvalidated;
    }

    public void setNewsFeed(NewsFeed newsFeed) {
        this.mNewsFeed = newsFeed;
    }

    public NewsFeed getNewsFeed() {
        return this.mNewsFeed;
    }
}
