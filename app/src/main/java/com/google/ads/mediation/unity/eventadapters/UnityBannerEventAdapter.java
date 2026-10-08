package com.google.ads.mediation.unity.eventadapters;

import com.google.ads.mediation.unity.UnityAdsAdapterUtils;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;

/* JADX INFO: loaded from: classes8.dex */
public class UnityBannerEventAdapter implements IUnityEventAdapter {
    final MediationBannerAdapter adapter;
    final MediationBannerListener listener;

    public UnityBannerEventAdapter(MediationBannerListener mediationBannerListener, MediationBannerAdapter mediationBannerAdapter) {
        this.listener = mediationBannerListener;
        this.adapter = mediationBannerAdapter;
    }

    @Override // com.google.ads.mediation.unity.eventadapters.IUnityEventAdapter
    public void sendAdEvent(UnityAdsAdapterUtils.AdEvent adEvent) {
        if (this.listener == null) {
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$google$ads$mediation$unity$UnityAdsAdapterUtils$AdEvent[adEvent.ordinal()];
        if (i == 1) {
            this.listener.onAdLoaded(this.adapter);
            return;
        }
        if (i == 2) {
            this.listener.onAdOpened(this.adapter);
            return;
        }
        if (i == 3) {
            this.listener.onAdClicked(this.adapter);
        } else if (i == 4) {
            this.listener.onAdClosed(this.adapter);
        } else {
            if (i != 5) {
                return;
            }
            this.listener.onAdLeftApplication(this.adapter);
        }
    }

    /* JADX INFO: renamed from: com.google.ads.mediation.unity.eventadapters.UnityBannerEventAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$ads$mediation$unity$UnityAdsAdapterUtils$AdEvent;

        static {
            int[] iArr = new int[UnityAdsAdapterUtils.AdEvent.values().length];
            $SwitchMap$com$google$ads$mediation$unity$UnityAdsAdapterUtils$AdEvent = iArr;
            try {
                iArr[UnityAdsAdapterUtils.AdEvent.LOADED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$ads$mediation$unity$UnityAdsAdapterUtils$AdEvent[UnityAdsAdapterUtils.AdEvent.OPENED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$ads$mediation$unity$UnityAdsAdapterUtils$AdEvent[UnityAdsAdapterUtils.AdEvent.CLICKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$ads$mediation$unity$UnityAdsAdapterUtils$AdEvent[UnityAdsAdapterUtils.AdEvent.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$ads$mediation$unity$UnityAdsAdapterUtils$AdEvent[UnityAdsAdapterUtils.AdEvent.LEFT_APPLICATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
