package com.adxcorp.ads.news;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.adxcorp.ads.BannerAd;
import com.adxcorp.ads.NewsViewBinder;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.common.BannerCustomEvent;
import com.adxcorp.ads.mediation.util.ClickThroughUtil;

/* JADX INFO: loaded from: classes2.dex */
public class NewsAd extends BannerAd {
    private static final String TAG = "NewsAd";
    private ViewGroup mAdContainer;
    private NewsClickListener mNewsClickListener;
    private NewsViewBinder mNewsViewBinder;

    public interface NewsClickListener {
        void onNewsClicked();
    }

    public NewsAd(Context context, String str, AdConstants.BANNER_AD_SIZE banner_ad_size, NewsViewBinder newsViewBinder, ViewGroup viewGroup) {
        super(context, str, banner_ad_size);
        this.mNewsViewBinder = newsViewBinder;
        this.mAdContainer = viewGroup;
        this.mIsNewsBanner = true;
    }

    @Override // com.adxcorp.ads.BannerAd
    protected void addCustomEventView(BannerCustomEvent bannerCustomEvent) {
        try {
            BannerCustomEvent bannerCustomEvent2 = this.mNextAdContentView;
            if (bannerCustomEvent2 != null) {
                destroyCustomEvent(bannerCustomEvent2);
            }
            ViewGroup viewGroup = (ViewGroup) inflate(this.mContext, this.mNewsViewBinder.getLayoutId(), null);
            this.mAdContainer.removeAllViews();
            this.mAdContainer.addView(viewGroup);
            ((ViewGroup) viewGroup.findViewById(this.mNewsViewBinder.getBannerId())).addView(bannerCustomEvent.getAdView());
            TextView textView = (TextView) viewGroup.findViewById(this.mNewsViewBinder.getNewsTitleId());
            if (textView != null) {
                textView.setText(this.mNewsFeed.getTitle());
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.news.NewsAd.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            ClickThroughUtil.goToBrowser(NewsAd.this.mContext, NewsAd.this.mNewsFeed.getLink());
                            if (NewsAd.this.mNewsClickListener != null) {
                                NewsAd.this.mNewsClickListener.onNewsClicked();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            View viewFindViewById = viewGroup.findViewById(this.mNewsViewBinder.getNewsIconId());
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.news.NewsAd.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            ClickThroughUtil.goToBrowser(NewsAd.this.mContext, NewsAd.this.mNewsFeed.getLink());
                            if (NewsAd.this.mNewsClickListener != null) {
                                NewsAd.this.mNewsClickListener.onNewsClicked();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            this.mNextAdContentView = bannerCustomEvent;
            if (this.mNextAdContentView != null) {
                this.mNextAdContentView.impression();
            }
            this.mIsAvailableNextAdRequest = false;
            this.mNetworkErrorIdx = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.adxcorp.ads.BannerAd
    protected void destroyCustomEvent(BannerCustomEvent bannerCustomEvent) {
        super.destroyCustomEvent(bannerCustomEvent);
    }

    public void setNewsClickListener(NewsClickListener newsClickListener) {
        this.mNewsClickListener = newsClickListener;
    }
}
