package com.google.ads.mediation.applovin;

import android.content.Context;
import android.os.Bundle;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAppOpenAd;
import com.google.ads.mediation.applovin.AppLovinInitializer;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppLovinWaterfallAppOpenAd.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/google/ads/mediation/applovin/AppLovinWaterfallAppOpenAd;", "Lcom/google/android/gms/ads/mediation/MediationAppOpenAd;", "Lcom/applovin/mediation/MaxAdListener;", "loadCallback", "Lcom/google/android/gms/ads/mediation/MediationAdLoadCallback;", "Lcom/google/android/gms/ads/mediation/MediationAppOpenAdCallback;", "appLovinInitializer", "Lcom/google/ads/mediation/applovin/AppLovinInitializer;", "appLovinAdFactory", "Lcom/google/ads/mediation/applovin/AppLovinAdFactory;", "<init>", "(Lcom/google/android/gms/ads/mediation/MediationAdLoadCallback;Lcom/google/ads/mediation/applovin/AppLovinInitializer;Lcom/google/ads/mediation/applovin/AppLovinAdFactory;)V", "appLovinAppOpenAd", "Lcom/applovin/mediation/ads/MaxAppOpenAd;", "appOpenAdCallback", "loadAd", "", "appOpenAdConfiguration", "Lcom/google/android/gms/ads/mediation/MediationAppOpenAdConfiguration;", "showAd", "context", "Landroid/content/Context;", "onAdLoaded", "ad", "Lcom/applovin/mediation/MaxAd;", "onAdLoadFailed", "p0", "", "appLovinError", "Lcom/applovin/mediation/MaxError;", "onAdDisplayed", "onAdHidden", "onAdClicked", "onAdDisplayFailed", "adx-library-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLovinWaterfallAppOpenAd implements MediationAppOpenAd, MaxAdListener {
    private final AppLovinAdFactory appLovinAdFactory;
    private MaxAppOpenAd appLovinAppOpenAd;
    private final AppLovinInitializer appLovinInitializer;
    private MediationAppOpenAdCallback appOpenAdCallback;
    private final MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> loadCallback;

    public AppLovinWaterfallAppOpenAd(MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> loadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory) {
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        Intrinsics.checkNotNullParameter(appLovinInitializer, "appLovinInitializer");
        Intrinsics.checkNotNullParameter(appLovinAdFactory, "appLovinAdFactory");
        this.loadCallback = loadCallback;
        this.appLovinInitializer = appLovinInitializer;
        this.appLovinAdFactory = appLovinAdFactory;
    }

    public final void loadAd(MediationAppOpenAdConfiguration appOpenAdConfiguration) {
        Intrinsics.checkNotNullParameter(appOpenAdConfiguration, "appOpenAdConfiguration");
        Bundle serverParameters = appOpenAdConfiguration.getServerParameters();
        Intrinsics.checkNotNullExpressionValue(serverParameters, "getServerParameters(...)");
        String string = serverParameters.getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
        String str = string;
        if (str == null || str.length() == 0) {
            this.loadCallback.onFailure(new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.ERROR_DOMAIN));
            return;
        }
        final String string2 = serverParameters.getString(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID);
        String str2 = string2;
        if (str2 == null || str2.length() == 0) {
            this.loadCallback.onFailure(new AdError(113, "Ad Unit ID is missing.", AppLovinMediationAdapter.ERROR_DOMAIN));
        } else {
            this.appLovinInitializer.initialize(appOpenAdConfiguration.getContext(), string, new AppLovinInitializer.OnInitializeSuccessListener() { // from class: com.google.ads.mediation.applovin.AppLovinWaterfallAppOpenAd$$ExternalSyntheticLambda0
                @Override // com.google.ads.mediation.applovin.AppLovinInitializer.OnInitializeSuccessListener
                public final void onInitializeSuccess() {
                    AppLovinWaterfallAppOpenAd.loadAd$lambda$0(this.f$0, string2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadAd$lambda$0(AppLovinWaterfallAppOpenAd appLovinWaterfallAppOpenAd, String str) {
        MaxAppOpenAd maxAppOpenAdCreateMaxAppOpenAd = appLovinWaterfallAppOpenAd.appLovinAdFactory.createMaxAppOpenAd(str);
        appLovinWaterfallAppOpenAd.appLovinAppOpenAd = maxAppOpenAdCreateMaxAppOpenAd;
        if (maxAppOpenAdCreateMaxAppOpenAd != null) {
            maxAppOpenAdCreateMaxAppOpenAd.setListener(appLovinWaterfallAppOpenAd);
        }
        MaxAppOpenAd maxAppOpenAd = appLovinWaterfallAppOpenAd.appLovinAppOpenAd;
        if (maxAppOpenAd != null) {
            maxAppOpenAd.loadAd();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAppOpenAd
    public void showAd(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MaxAppOpenAd maxAppOpenAd = this.appLovinAppOpenAd;
        if (maxAppOpenAd != null) {
            if (maxAppOpenAd != null && maxAppOpenAd.isReady()) {
                MaxAppOpenAd maxAppOpenAd2 = this.appLovinAppOpenAd;
                if (maxAppOpenAd2 != null) {
                    maxAppOpenAd2.showAd();
                    return;
                }
                return;
            }
            MediationAppOpenAdCallback mediationAppOpenAdCallback = this.appOpenAdCallback;
            if (mediationAppOpenAdCallback != null) {
                mediationAppOpenAdCallback.onAdFailedToShow(new AdError(106, "Ad is not ready to be displayed", AppLovinMediationAdapter.ERROR_DOMAIN));
            }
        }
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoaded(MaxAd ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.appOpenAdCallback = this.loadCallback.onSuccess(this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoadFailed(String p0, MaxError appLovinError) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(appLovinError, "appLovinError");
        this.loadCallback.onFailure(new AdError(appLovinError.getCode(), appLovinError.getMessage(), AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN));
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayed(MaxAd ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.appOpenAdCallback;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.onAdOpened();
        }
        MediationAppOpenAdCallback mediationAppOpenAdCallback2 = this.appOpenAdCallback;
        if (mediationAppOpenAdCallback2 != null) {
            mediationAppOpenAdCallback2.reportAdImpression();
        }
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdHidden(MaxAd ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.appOpenAdCallback;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.onAdClosed();
        }
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdClicked(MaxAd ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.appOpenAdCallback;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.reportAdClicked();
        }
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayFailed(MaxAd ad, MaxError appLovinError) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(appLovinError, "appLovinError");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.appOpenAdCallback;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.onAdFailedToShow(new AdError(appLovinError.getCode(), appLovinError.getMessage(), AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN));
        }
    }
}
