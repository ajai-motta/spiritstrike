package com.adxcorp.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.adxcorp.ads.BannerAd;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.news.NewsAd;

/* JADX INFO: loaded from: classes2.dex */
public class NewsBannerAd {
    private NewsAd mNewsAd;
    private NewsBannerListener mNewsBannerListener;

    public interface NewsBannerListener {
        void onAdClicked();

        void onAdError(int i);

        void onAdLoaded();

        void onNewsClicked();
    }

    public NewsBannerAd(Context context, String str, AdConstants.BANNER_AD_SIZE banner_ad_size, NewsViewBinder newsViewBinder, ViewGroup viewGroup) {
        NewsAd newsAd = new NewsAd(context, str, banner_ad_size, newsViewBinder, viewGroup);
        this.mNewsAd = newsAd;
        newsAd.setBannerListener(new BannerAd.BannerListener() { // from class: com.adxcorp.ads.NewsBannerAd.1
            @Override // com.adxcorp.ads.BannerAd.BannerListener
            public void onAdLoaded() {
                if (NewsBannerAd.this.mNewsBannerListener != null) {
                    NewsBannerAd.this.mNewsBannerListener.onAdLoaded();
                }
            }

            @Override // com.adxcorp.ads.BannerAd.BannerListener
            public void onAdError(int i) {
                if (NewsBannerAd.this.mNewsBannerListener != null) {
                    NewsBannerAd.this.mNewsBannerListener.onAdError(i);
                }
            }

            @Override // com.adxcorp.ads.BannerAd.BannerListener
            public void onAdClicked() {
                if (NewsBannerAd.this.mNewsBannerListener != null) {
                    NewsBannerAd.this.mNewsBannerListener.onAdClicked();
                }
            }
        });
        this.mNewsAd.setNewsClickListener(new NewsAd.NewsClickListener() { // from class: com.adxcorp.ads.NewsBannerAd.2
            @Override // com.adxcorp.ads.news.NewsAd.NewsClickListener
            public void onNewsClicked() {
                if (NewsBannerAd.this.mNewsBannerListener != null) {
                    NewsBannerAd.this.mNewsBannerListener.onNewsClicked();
                }
            }
        });
    }

    public void setNewsBannerListener(NewsBannerListener newsBannerListener) {
        this.mNewsBannerListener = newsBannerListener;
    }

    public void loadAd() {
        NewsAd newsAd = this.mNewsAd;
        if (newsAd != null) {
            newsAd.loadAd();
        }
    }

    public void destroy() {
        NewsAd newsAd = this.mNewsAd;
        if (newsAd != null) {
            newsAd.destroy();
            this.mNewsAd = null;
        }
    }
}
