package com.applovin.impl.mediation.ads;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.d3;
import com.applovin.impl.e6;
import com.applovin.impl.i;
import com.applovin.impl.j;
import com.applovin.impl.j5;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.o7;
import com.applovin.impl.r3;
import com.applovin.impl.s6;
import com.applovin.impl.sdk.a;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.t1;
import com.applovin.impl.t2;
import com.applovin.impl.y2;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class MaxNativeAdLoaderImpl extends com.applovin.impl.mediation.ads.a implements a.InterfaceC0157a, j.b {
    public static final String KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE = "ad_request_type";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f492a;
    private String b;
    private String c;
    private i d;
    private final Object e;
    private MaxNativeAdListener f;
    private final Map g;
    private final Set h;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaxNativeAd f493a;
        final /* synthetic */ List b;
        final /* synthetic */ ViewGroup c;

        a(MaxNativeAd maxNativeAd, List list, ViewGroup viewGroup) {
            this.f493a = maxNativeAd;
            this.b = list;
            this.c = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f493a.prepareForInteraction(this.b, this.c)) {
                return;
            }
            o.h(MaxNativeAdLoaderImpl.this.tag, "Failed to prepare native ad for interaction...");
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaxNativeAdView f494a;
        final /* synthetic */ d3 b;
        final /* synthetic */ MaxNativeAd c;

        b(MaxNativeAdView maxNativeAdView, d3 d3Var, MaxNativeAd maxNativeAd) {
            this.f494a = maxNativeAdView;
            this.b = d3Var;
            this.c = maxNativeAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar = MaxNativeAdLoaderImpl.this.logger;
            if (o.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "Rendering native ad view: " + this.f494a);
            }
            MaxNativeAdLoaderImpl.this.sdk.y().d(this.b);
            this.f494a.render(this.b, MaxNativeAdLoaderImpl.this.f492a, MaxNativeAdLoaderImpl.this.sdk);
            this.c.setNativeAdView(this.f494a);
            if (this.c.prepareForInteraction(this.f494a.getClickableViews(), this.f494a)) {
                return;
            }
            this.c.prepareViewForInteraction(this.f494a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c implements a.InterfaceC0152a {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            o oVar = MaxNativeAdLoaderImpl.this.logger;
            if (o.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "Native ad loaded");
            }
            d3 d3Var = (d3) maxAd;
            d3Var.g(MaxNativeAdLoaderImpl.this.b);
            d3Var.f(MaxNativeAdLoaderImpl.this.c);
            synchronized (MaxNativeAdLoaderImpl.this.e) {
                MaxNativeAdLoaderImpl.this.h.add(d3Var);
            }
            MaxNativeAdView maxNativeAdViewA = MaxNativeAdLoaderImpl.this.a(d3Var.I());
            if (maxNativeAdViewA == null) {
                o oVar2 = MaxNativeAdLoaderImpl.this.logger;
                if (o.a()) {
                    MaxNativeAdLoaderImpl maxNativeAdLoaderImpl2 = MaxNativeAdLoaderImpl.this;
                    maxNativeAdLoaderImpl2.logger.a(maxNativeAdLoaderImpl2.tag, "No native ad view to render. Returning the native ad to be rendered later.");
                }
                o oVar3 = MaxNativeAdLoaderImpl.this.logger;
                if (o.a()) {
                    MaxNativeAdLoaderImpl maxNativeAdLoaderImpl3 = MaxNativeAdLoaderImpl.this;
                    maxNativeAdLoaderImpl3.logger.a(maxNativeAdLoaderImpl3.tag, "MaxNativeAdListener.onNativeAdLoaded(nativeAdView=null, nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.f);
                }
                t2.a(MaxNativeAdLoaderImpl.this.f, (MaxNativeAdView) null, maxAd, true);
                MaxNativeAdLoaderImpl.this.a(d3Var);
                return;
            }
            a(maxNativeAdViewA);
            MaxNativeAdLoaderImpl.this.a(maxNativeAdViewA, d3Var, d3Var.getNativeAd());
            o oVar4 = MaxNativeAdLoaderImpl.this.logger;
            if (o.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl4 = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl4.logger.a(maxNativeAdLoaderImpl4.tag, "MaxNativeAdListener.onNativeAdLoaded(nativeAdView=" + maxNativeAdViewA + ", nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.f);
            }
            t2.a(MaxNativeAdLoaderImpl.this.f, maxNativeAdViewA, maxAd, true);
            MaxNativeAdLoaderImpl.this.a(d3Var);
            MaxNativeAdLoaderImpl.this.a(maxNativeAdViewA);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            o oVar = MaxNativeAdLoaderImpl.this.logger;
            if (o.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "MaxNativeAdListener.onNativeAdClicked(nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.f);
            }
            t2.a(MaxNativeAdLoaderImpl.this.f, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            MaxNativeAdLoaderImpl.this.a(((MaxErrorImpl) maxError).getLoadTag());
            o oVar = MaxNativeAdLoaderImpl.this.logger;
            if (o.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "MaxNativeAdListener.onNativeAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxNativeAdLoaderImpl.this.f);
            }
            t2.a(MaxNativeAdLoaderImpl.this.f, str, maxError, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(final MaxAd maxAd) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl$c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(maxAd);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            o oVar = MaxNativeAdLoaderImpl.this.logger;
            if (o.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.revenueListener);
            }
            t2.a(MaxNativeAdLoaderImpl.this.revenueListener, maxAd, true);
        }

        /* synthetic */ c(MaxNativeAdLoaderImpl maxNativeAdLoaderImpl, a aVar) {
            this();
        }

        private void a(MaxNativeAdView maxNativeAdView) {
            d3 d3VarB;
            com.applovin.impl.mediation.ads.b adViewTracker = maxNativeAdView.getAdViewTracker();
            if (adViewTracker == null || (d3VarB = adViewTracker.b()) == null) {
                return;
            }
            o oVar = MaxNativeAdLoaderImpl.this.logger;
            if (o.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "Destroying previous ad");
            }
            MaxNativeAdLoaderImpl.this.destroy(d3VarB);
        }
    }

    public MaxNativeAdLoaderImpl(String str, k kVar) {
        super(str, MaxAdFormat.NATIVE, "MaxNativeAdLoader", kVar);
        this.f492a = new c(this, null);
        this.d = i.PUBLISHER_INITIATED;
        this.e = new Object();
        this.g = new HashMap();
        this.h = new HashSet();
        kVar.j().a(this);
        if (o.a()) {
            this.logger.a(this.tag, "Created new MaxNativeAdLoader (" + this + ")");
        }
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        this.f = null;
        this.sdk.j().b(this);
        synchronized (this.e) {
            this.g.clear();
            this.h.clear();
        }
        super.destroy();
    }

    public String getPlacement() {
        return this.b;
    }

    public void handleNativeAdViewRendered(MaxAd maxAd) {
        MaxNativeAd nativeAd = ((d3) maxAd).getNativeAd();
        if (nativeAd == null) {
            if (o.a()) {
                this.logger.b(this.tag, "Failed to handle native ad rendered. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return;
            }
            return;
        }
        com.applovin.impl.mediation.ads.b adViewTracker = nativeAd.getAdViewTracker();
        if (adViewTracker != null) {
            adViewTracker.c();
        } else if (o.a()) {
            this.logger.b(this.tag, "Failed to handle native ad rendered. Could not retrieve tracker. Ad might not have been registered via MaxNativeAdLoader.a(...).");
        }
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        if (o.a()) {
            this.logger.a(this.tag, "Loading native ad for '" + this.adUnitId + "' into '" + maxNativeAdView + "' and notifying " + this.f492a + "...");
        }
        this.extraParameters.put("integration_type", maxNativeAdView != null ? "custom_ad_view" : "no_ad_view");
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        a(lowerCase, maxNativeAdView);
        this.sdk.X().loadAd(this.adUnitId, lowerCase, MaxAdFormat.NATIVE, this.d, this.localExtraParameters, this.extraParameters, k.o(), this.f492a);
    }

    @Override // com.applovin.impl.sdk.a.InterfaceC0157a
    public void onAdExpired(t1 t1Var) {
        if (o.a()) {
            this.logger.a(this.tag, "Ad expired for ad unit id " + getAdUnitId());
        }
        if (o.a()) {
            this.logger.a(this.tag, "MaxNativeAdListener.onNativeAdExpired(nativeAd=" + t1Var + "), listener=" + this.f);
        }
        t2.b(this.f, (MaxAd) t1Var, true);
    }

    @Override // com.applovin.impl.j.b
    public void onCreativeIdGenerated(String str, String str2) {
        d3 d3Var;
        Iterator it = this.h.iterator();
        while (true) {
            if (!it.hasNext()) {
                d3Var = null;
                break;
            } else {
                d3Var = (d3) it.next();
                if (d3Var.O().equalsIgnoreCase(str)) {
                    break;
                }
            }
        }
        if (d3Var != null) {
            d3Var.h(str2);
            t2.b(this.adReviewListener, str2, d3Var);
            synchronized (this.e) {
                this.h.remove(d3Var);
            }
        }
    }

    public void registerClickableViews(List<View> list, ViewGroup viewGroup, MaxAd maxAd) {
        d3 d3Var = (d3) maxAd;
        MaxNativeAd nativeAd = d3Var.getNativeAd();
        if (nativeAd == null) {
            if (o.a()) {
                this.logger.b(this.tag, "Failed to register native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return;
            }
            return;
        }
        d3Var.a(viewGroup);
        this.sdk.y().d(d3Var);
        a((y2) d3Var);
        nativeAd.setClickableViews(list);
        nativeAd.setAdViewTracker(new com.applovin.impl.mediation.ads.b(d3Var, viewGroup, this.f492a, this.sdk));
        a aVar = new a(nativeAd, list, viewGroup);
        if (nativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            AppLovinSdkUtils.runOnUiThread(aVar);
        } else {
            this.sdk.r0().a((j5) new s6(this.sdk, "renderMaxNativeAd", aVar), e6.b.MEDIATION);
        }
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        if (!(maxAd instanceof d3)) {
            o.h(this.tag, "Failed to render native ad. `ad` needs to be of type `MediatedNativeAd` to render.");
            return false;
        }
        if (maxNativeAdView == null) {
            o.h(this.tag, "Failed to render native ad. `adView` to render cannot be null.");
            return false;
        }
        d3 d3Var = (d3) maxAd;
        MaxNativeAd nativeAd = d3Var.getNativeAd();
        if (nativeAd == null) {
            if (o.a()) {
                this.logger.b(this.tag, "Failed to render native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
            }
            return false;
        }
        if (nativeAd.isExpired() && !((Boolean) this.sdk.a(r3.Y7)).booleanValue()) {
            o.h(this.tag, "Cancelled rendering for expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            return false;
        }
        a(maxNativeAdView, d3Var, nativeAd);
        a(maxNativeAdView);
        return true;
    }

    public void setCustomData(String str) {
        o7.b(str, this.tag);
        this.c = str;
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void setLocalExtraParameter(String str, Object obj) {
        super.setLocalExtraParameter(str, obj);
        if (KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE.equalsIgnoreCase(str) && (obj instanceof i)) {
            this.d = (i) obj;
        }
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        if (o.a()) {
            this.logger.a(this.tag, "Setting native ad listener: " + maxNativeAdListener);
        }
        this.f = maxNativeAdListener;
    }

    public void setPlacement(String str) {
        this.b = str;
    }

    public String toString() {
        return "MaxNativeAdLoader{adUnitId='" + this.adUnitId + "', nativeAdListener=" + this.f + ", revenueListener=" + this.revenueListener + AbstractJsonLexerKt.END_OBJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d3 d3Var) {
        if (d3Var.n0().get()) {
            return;
        }
        this.sdk.f().a(d3Var, this);
    }

    private void a(String str, MaxNativeAdView maxNativeAdView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.e) {
            this.g.put(str, maxNativeAdView);
        }
    }

    public void destroy(MaxAd maxAd) {
        com.applovin.impl.mediation.ads.b adViewTracker;
        if (maxAd instanceof d3) {
            d3 d3Var = (d3) maxAd;
            if (d3Var.q0()) {
                if (o.a()) {
                    this.logger.a(this.tag, "Native ad (" + d3Var + ") has already been destroyed");
                    return;
                }
                return;
            }
            synchronized (this.e) {
                this.h.remove(d3Var);
            }
            MaxNativeAdView maxNativeAdViewL0 = d3Var.l0();
            if (maxNativeAdViewL0 != null && (adViewTracker = maxNativeAdViewL0.getAdViewTracker()) != null && maxAd.equals(adViewTracker.b())) {
                maxNativeAdViewL0.recycle();
            }
            MaxNativeAd nativeAd = d3Var.getNativeAd();
            if (nativeAd != null && nativeAd.getAdViewTracker() != null) {
                nativeAd.getAdViewTracker().a();
            }
            this.sdk.f().a(d3Var);
            this.sdk.X().destroyAd(d3Var);
            if (this.sdk.R() != null) {
                this.sdk.R().c(this.adUnitId, d3Var.I());
                return;
            } else {
                this.sdk.Q().c(this.adUnitId, d3Var.I());
                return;
            }
        }
        if (o.a()) {
            this.logger.a(this.tag, "Destroy failed on non-native ad(" + maxAd + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MaxNativeAdView a(String str) {
        MaxNativeAdView maxNativeAdView;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.e) {
            maxNativeAdView = (MaxNativeAdView) this.g.remove(str);
        }
        return maxNativeAdView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxNativeAdView maxNativeAdView, d3 d3Var, MaxNativeAd maxNativeAd) {
        d3Var.a(maxNativeAdView);
        a((y2) d3Var);
        b bVar = new b(maxNativeAdView, d3Var, maxNativeAd);
        if (maxNativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            AppLovinSdkUtils.runOnUiThread(bVar);
        } else {
            this.sdk.r0().a((j5) new s6(this.sdk, "renderMaxNativeAd", bVar), e6.b.MEDIATION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxNativeAdView maxNativeAdView) {
        com.applovin.impl.mediation.ads.b adViewTracker = maxNativeAdView.getAdViewTracker();
        if (adViewTracker == null || !maxNativeAdView.isAttachedToWindow()) {
            return;
        }
        adViewTracker.c();
    }
}
