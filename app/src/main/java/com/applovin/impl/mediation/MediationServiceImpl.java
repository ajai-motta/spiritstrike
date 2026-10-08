package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.a3;
import com.applovin.impl.a5;
import com.applovin.impl.c3;
import com.applovin.impl.c5;
import com.applovin.impl.c6;
import com.applovin.impl.d2;
import com.applovin.impl.d5;
import com.applovin.impl.e5;
import com.applovin.impl.e6;
import com.applovin.impl.f2;
import com.applovin.impl.h3;
import com.applovin.impl.i;
import com.applovin.impl.j5;
import com.applovin.impl.j6;
import com.applovin.impl.k3;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.o6;
import com.applovin.impl.o7;
import com.applovin.impl.r3;
import com.applovin.impl.s3;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.g;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t2;
import com.applovin.impl.t3;
import com.applovin.impl.t4;
import com.applovin.impl.v6;
import com.applovin.impl.w3;
import com.applovin.impl.y2;
import com.applovin.impl.y4;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f483a;
    private final o b;
    private final c5 c;
    private final AtomicReference d = new AtomicReference();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f484a;

        static {
            int[] iArr = new int[MaxAdapter.InitializationStatus.values().length];
            f484a = iArr;
            try {
                iArr[MaxAdapter.InitializationStatus.DOES_NOT_APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f484a[MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f484a[MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f484a[MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f484a[MaxAdapter.InitializationStatus.NOT_INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f484a[MaxAdapter.InitializationStatus.INITIALIZING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class b implements MaxAdListener, MaxRewardedAdListener, MaxAdViewAdListener, MaxAdRevenueListener, a.InterfaceC0152a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final y2 f485a;
        private a.InterfaceC0152a b;

        public b(y2 y2Var, a.InterfaceC0152a interfaceC0152a) {
            this.f485a = y2Var;
            this.b = interfaceC0152a;
        }

        public void a(a.InterfaceC0152a interfaceC0152a) {
            this.b = interfaceC0152a;
        }

        public void b(MaxAd maxAd, Bundle bundle) {
            this.f485a.a(bundle);
            t2.b(this.b, maxAd);
        }

        public void c(MaxAd maxAd, Bundle bundle) {
            this.f485a.a(bundle);
            o unused = MediationServiceImpl.this.b;
            if (o.a()) {
                MediationServiceImpl.this.b.a("MediationService", "Scheduling impression for ad via callback...");
            }
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.f485a, this.b);
            if (!((Boolean) MediationServiceImpl.this.f483a.a(r3.B8)).booleanValue() || this.f485a.u().compareAndSet(false, true)) {
                MediationServiceImpl.this.f483a.l().a(this.f485a, g.c.SHOW);
                MediationServiceImpl.this.f483a.t().b(this.f485a, "DID_DISPLAY");
                if (maxAd.getFormat().isFullscreenAd()) {
                    MediationServiceImpl.this.f483a.H().a(this.f485a);
                }
                t2.c(this.b, maxAd);
            }
        }

        public void d(MaxAd maxAd, Bundle bundle) {
            this.f485a.a(bundle);
            t2.d(this.b, maxAd);
        }

        public void e(final MaxAd maxAd, Bundle bundle) {
            this.f485a.a(bundle);
            MediationServiceImpl.this.f483a.l().a(this.f485a, g.c.HIDE);
            MediationServiceImpl.this.a(this.f485a);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(maxAd);
                }
            }, maxAd instanceof c3 ? ((c3) maxAd).e0() : 0L);
        }

        public void f(MaxAd maxAd, Bundle bundle) {
            this.f485a.a(bundle);
            this.f485a.X();
            MediationServiceImpl.this.f483a.l().a(this.f485a, g.c.LOAD);
            MediationServiceImpl.this.b(this.f485a);
            t2.f(this.b, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            a(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            b(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            a(maxAd, maxError, (Bundle) null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            c(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            d(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            e(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            this.f485a.X();
            MediationServiceImpl.this.b(this.f485a, maxError, this.b);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            f(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            a(maxAd, maxReward, (Bundle) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.f483a.H().b(maxAd);
            }
            t2.e(this.b, maxAd);
        }

        public void a(MaxAd maxAd, Bundle bundle) {
            this.f485a.a(bundle);
            MediationServiceImpl.this.f483a.l().a(this.f485a, g.c.CLICK);
            MediationServiceImpl.this.a(this.f485a, this.b);
            t2.a((MaxAdListener) this.b, maxAd);
        }

        public void a(MaxAd maxAd, MaxError maxError, Bundle bundle) {
            this.f485a.a(bundle);
            MediationServiceImpl.this.a(this.f485a, maxError, this.b);
            if (maxAd.getFormat() == MaxAdFormat.REWARDED && (maxAd instanceof c3)) {
                ((c3) maxAd).c0();
            }
        }

        public void a(MaxAd maxAd, MaxReward maxReward, Bundle bundle) {
            this.f485a.a(bundle);
            t2.a(this.b, maxAd, maxReward);
            MediationServiceImpl.this.f483a.r0().a((j5) new o6((c3) maxAd, MediationServiceImpl.this.f483a), e6.b.OTHER);
        }
    }

    public MediationServiceImpl(k kVar) {
        this.f483a = kVar;
        this.b = kVar.O();
        this.c = new c5(kVar);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    public void collectSignal(final e5 e5Var, Context context, final d5.a aVar) {
        if (e5Var == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        a3 a3VarU = e5Var.u();
        final String strB = a3VarU.b();
        final MaxAdFormat maxAdFormatA = a3VarU.a();
        d5 d5VarB = this.c.b(e5Var, strB, maxAdFormatA);
        if (d5VarB != null) {
            aVar.a(d5.a(d5VarB));
            return;
        }
        final h hVarA = this.f483a.T().a(e5Var, e5Var.A());
        if (hVarA == null) {
            aVar.a(d5.a(e5Var, new MaxErrorImpl("Could not load adapter")));
            return;
        }
        final t4 t4Var = new t4("SignalCollection:" + e5Var.c());
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        Executor executor = t4.i;
        t4Var.a(executor, new t4.b() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda0
            @Override // com.applovin.impl.t4.b
            public final void a(boolean z, Object obj, Object obj2) {
                this.f$0.a(jElapsedRealtime, hVarA, strB, e5Var, maxAdFormatA, aVar, z, (String) obj, (MaxError) obj2);
            }
        });
        j6.a(e5Var.m(), t4Var, new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT, "The adapter (" + e5Var.c() + ") timed out collecting signal"), "MediationService", this.f483a);
        final Activity activityV0 = context instanceof Activity ? (Activity) context : this.f483a.v0();
        final MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(e5Var, strB, maxAdFormatA);
        if (e5Var.w()) {
            t4 t4VarA = this.f483a.S().a(e5Var, activityV0);
            t4VarA.a(executor, new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(t4Var, hVarA, maxAdapterParametersImplA, e5Var, activityV0);
                }
            });
            t4VarA.a(executor, new t4.a() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda2
                @Override // com.applovin.impl.t4.a
                public final void a(Object obj) {
                    this.f$0.a(hVarA, t4Var, (String) obj);
                }
            });
            return;
        }
        if (e5Var.x()) {
            t4 t4VarA2 = this.f483a.S().a(e5Var, activityV0);
            if (t4VarA2.d() && !e5Var.z()) {
                if (o.a()) {
                    this.b.b("MediationService", "Skip collecting signal for failed-initialized adapter: " + hVarA.g());
                }
                t4Var.a(new MaxErrorImpl("Could not initialize adapter: " + ((String) t4VarA2.a())));
                return;
            }
        }
        if (o.a()) {
            this.b.a("MediationService", "Collecting signal for adapter: " + hVarA.g());
        }
        hVarA.a(maxAdapterParametersImplA, e5Var, activityV0, t4Var);
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof y2) {
            if (o.a()) {
                this.b.d("MediationService", "Destroying " + maxAd);
            }
            y2 y2Var = (y2) maxAd;
            h hVarA = y2Var.A();
            if (hVarA != null) {
                hVarA.a();
                y2Var.t();
            }
            this.f483a.j().c(y2Var.O());
            this.f483a.l().a(y2Var, g.c.DESTROY);
        }
    }

    public JSONObject getAndResetCustomPostBodyData() {
        return (JSONObject) this.d.getAndSet(null);
    }

    public void loadAd(String str, String str2, MaxAdFormat maxAdFormat, i iVar, Map<String, Object> map, Map<String, Object> map2, Context context, a.InterfaceC0152a interfaceC0152a) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No Ad Unit ID specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (interfaceC0152a == null) {
            throw new IllegalArgumentException("No listener specified");
        }
        if (TextUtils.isEmpty(this.f483a.V())) {
            o.h("AppLovinSdk", "Mediation provider is null. Please set the mediation provider in the AppLovinSdkInitializationConfiguration.Builder when initializing the AppLovinSDK.");
        }
        if (!this.f483a.C0()) {
            o.j("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        List<String> adUnitIds = this.f483a.J() != null ? this.f483a.J().getAdUnitIds() : null;
        boolean zStartsWith = str.startsWith("test_mode");
        if (adUnitIds != null && adUnitIds.size() > 0 && !adUnitIds.contains(str) && !zStartsWith) {
            if (o7.c(this.f483a)) {
                String str3 = "Ad Unit ID " + str + " has not been initialized. When you use selective init, any ad units that you do not explicitly specify are excluded from serving ads for the current session. For more information visit our docs: https://support.axon.ai/en/max/android/overview/advanced-settings#selective-init";
                if (((Boolean) this.f483a.a(y4.C6)).booleanValue()) {
                    throw new RuntimeException(str3);
                }
                if (o.a()) {
                    this.b.b("MediationService", str3);
                }
            }
            this.f483a.D().a(d2.S0, "uninitialized_ad_unit_id", CollectionUtils.hashMap(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, str), "uninitialized_ad_unit_id" + str);
        }
        this.f483a.c();
        if (str.length() != 16 && !zStartsWith && !this.f483a.j0().startsWith("05TMD")) {
            o.h("MediationService", "Ad unit ID provided for " + maxAdFormat.getLabel() + " is invalid (" + str + "). Expected length: 16 characters.\n\nStack trace:\n" + Log.getStackTraceString(new Throwable()));
        }
        if (this.f483a.a(maxAdFormat)) {
            o.h("MediationService", "Ad load failed due to disabled ad format " + maxAdFormat.getLabel());
            t2.a(interfaceC0152a, str, new MaxErrorImpl(-1, "Disabled ad format " + maxAdFormat.getLabel()));
            return;
        }
        this.f483a.W0();
        t2.a((MaxAdRequestListener) interfaceC0152a, str, true);
        if (this.f483a.R() != null) {
            this.f483a.R().a(str, str2, maxAdFormat, iVar, map, map2, context, interfaceC0152a);
        } else {
            this.f483a.Q().a(str, str2, maxAdFormat, iVar, map, map2, context, interfaceC0152a);
        }
    }

    public void loadThirdPartyMediatedAd(final String str, final y2 y2Var, final Activity activity, final a.InterfaceC0152a interfaceC0152a) {
        t4 t4VarA;
        if (y2Var == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (o.a()) {
            this.b.a("MediationService", "Loading " + y2Var + "...");
        }
        this.f483a.P().a(d2.j0, y2Var);
        this.f483a.l().a(y2Var, g.c.LOADING);
        this.f483a.t().b(y2Var, "WILL_LOAD");
        final h hVarA = this.f483a.T().a(y2Var);
        if (hVarA == null) {
            String str2 = "Failed to load " + y2Var + ": adapter not loaded";
            o.h("MediationService", str2);
            b(y2Var, new MaxErrorImpl(-5001, str2), interfaceC0152a);
            return;
        }
        final MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(y2Var);
        if (y2Var.V()) {
            t4VarA = this.f483a.S().a(y2Var, activity);
        } else {
            if (y2Var.W()) {
                this.f483a.S().a(y2Var, activity);
            }
            t4VarA = null;
        }
        t4 t4Var = t4VarA;
        final y2 y2VarA = y2Var.a(hVarA);
        hVarA.a(str, y2VarA);
        y2VarA.Y();
        if (t4Var == null) {
            hVarA.a(str, maxAdapterParametersImplA, y2VarA, activity, new b(y2VarA, interfaceC0152a));
            return;
        }
        Executor executor = t4.i;
        t4Var.a(executor, new t4.a() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda5
            @Override // com.applovin.impl.t4.a
            public final void a(Object obj) {
                this.f$0.a(y2Var, interfaceC0152a, (String) obj);
            }
        });
        t4Var.a(executor, new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(hVarA, str, maxAdapterParametersImplA, y2VarA, activity, interfaceC0152a);
            }
        });
    }

    public void maybeFireAppKilledWhilePlayingMediatedAdPostback() {
        String str = (String) this.f483a.b(a5.R);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObjectJsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(str, new JSONObject());
        if (a(JsonUtils.getLong(jSONObjectJsonObjectFromJsonString, "timestamp_ms", 0L))) {
            Long l = (Long) this.f483a.b(a5.S);
            String string = l != null ? l.toString() : "";
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONObjectJsonObjectFromJsonString, "ad_info");
            Map mapTryToStringMap = jSONObject != null ? JsonUtils.tryToStringMap(jSONObject) : new HashMap(1);
            CollectionUtils.putStringIfValid("duration_ms", string, mapTryToStringMap);
            this.f483a.D().d(d2.H0, mapTryToStringMap);
            List list = JsonUtils.getList(jSONObjectJsonObjectFromJsonString, "app_killed_urls", Collections.emptyList());
            if (CollectionUtils.isEmpty(list)) {
                if (o.a()) {
                    this.b.k("MediationService", "Unable to track app killed during mediated ad from previous run. Missing app killed tracking URLs.");
                }
            } else {
                JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObjectJsonObjectFromJsonString, "user_info");
                Map<String, String> mapTryToStringMap2 = jSONObject2 != null ? JsonUtils.tryToStringMap(jSONObject2) : w3.c(this.f483a);
                mapTryToStringMap2.put("{IMP_DURATION_MS}", string);
                a("mappk", list, mapTryToStringMap2, null, null, null, true);
            }
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object objA = this.f483a.H().a();
            if (objA instanceof y2) {
                a((MaxError) MaxAdapterError.WEBVIEW_ERROR, (y2) objA, true);
            }
        }
    }

    public void processAdDisplayErrorPostbackForUserError(MaxError maxError, y2 y2Var) {
        a(maxError, y2Var, false);
    }

    public void processAdapterInitializationPostback(k3 k3Var, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap map = new HashMap(2);
        map.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        map.put("{INIT_TIME_MS}", String.valueOf(j));
        a("minit", map, new MaxErrorImpl(str), k3Var);
        Map mapA = f2.a(k3Var);
        CollectionUtils.putStringIfValid("adapter_init_status", String.valueOf(initializationStatus.getCode()), mapA);
        CollectionUtils.putStringIfValid(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str, mapA);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j), mapA);
        switch (a.f484a[initializationStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.f483a.P().d(d2.c0, mapA);
                break;
            case 4:
                this.f483a.P().d(d2.d0, mapA);
                break;
            case 5:
            case 6:
                this.f483a.O();
                if (o.a()) {
                    this.f483a.O().k("MediationService", "Adapter init postback called while the adapter is not fully initialized.");
                }
                this.f483a.D().a(d2.d, "adapterNotInitializedForPostback", mapA);
                break;
        }
    }

    public void processCallbackAdImpressionPostback(y2 y2Var, a.InterfaceC0152a interfaceC0152a) {
        if (y2Var.M().endsWith("cimp")) {
            this.f483a.t().b(y2Var);
            t2.a((MaxAdRevenueListener) interfaceC0152a, (MaxAd) y2Var);
        }
        HashMap map = new HashMap(2);
        if (y2Var instanceof c3) {
            map.put("{PREVIOUS_FAILED_NETWORK_NAME}", StringUtils.emptyIfNull(((c3) y2Var).n0()));
        }
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f483a.x0().e());
        if (!((Boolean) this.f483a.a(y4.M3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mcimp", map, y2Var);
        this.f483a.P().a(d2.o0, y2Var);
    }

    public void processRawAdImpression(y2 y2Var, a.InterfaceC0152a interfaceC0152a) {
        this.f483a.t().b(y2Var, "WILL_DISPLAY");
        if (y2Var.M().endsWith("mimp")) {
            this.f483a.t().b(y2Var);
            t2.a((MaxAdRevenueListener) interfaceC0152a, (MaxAd) y2Var);
        }
        if (((Boolean) this.f483a.a(y4.N4)).booleanValue()) {
            this.f483a.Y().a(s3.g, t3.a(y2Var), Long.valueOf(System.currentTimeMillis() - this.f483a.K()));
        }
        HashMap map = new HashMap(3);
        if (y2Var instanceof c3) {
            c3 c3Var = (c3) y2Var;
            map.put("{TIME_TO_SHOW_MS}", String.valueOf(c3Var.i0()));
            map.put("{PREVIOUS_FAILED_NETWORK_NAME}", StringUtils.emptyIfNull(c3Var.n0()));
        }
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f483a.x0().e());
        if (!((Boolean) this.f483a.a(y4.M3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mimp", map, y2Var);
        this.f483a.P().a(d2.n0, y2Var);
    }

    public void processViewabilityAdImpressionPostback(h3 h3Var, long j, a.InterfaceC0152a interfaceC0152a) {
        if (h3Var.M().endsWith("vimp")) {
            this.f483a.t().b(h3Var);
            t2.a((MaxAdRevenueListener) interfaceC0152a, (MaxAd) h3Var);
        }
        HashMap map = new HashMap(3);
        map.put("{VIEWABILITY_FLAGS}", String.valueOf(j));
        map.put("{USED_VIEWABILITY_TIMER}", String.valueOf(h3Var.j0()));
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f483a.x0().e());
        if (!((Boolean) this.f483a.a(y4.M3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mvimp", map, h3Var);
        this.f483a.P().a(d2.p0, h3Var);
    }

    public void processWaterfallInfoPostback(MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl, MaxError maxError, long j, long j2) {
        a3 requestParameters = maxAdWaterfallInfoImpl.getRequestParameters();
        String strB = requestParameters.b();
        MaxAdFormat maxAdFormatA = requestParameters.a();
        HashMap map = new HashMap();
        CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, maxAdFormatA.getLabel(), map);
        CollectionUtils.putStringIfValid(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, strB, map);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j2), map);
        CollectionUtils.putStringIfValid("ad_event_id", maxAdWaterfallInfoImpl.getEventId(), map);
        if (maxError != null) {
            map.putAll(f2.a(maxError));
        }
        this.f483a.P().d(d2.m0, map);
        if (CollectionUtils.isEmpty(maxAdWaterfallInfoImpl.getPostbackUrls())) {
            return;
        }
        HashMap map2 = new HashMap(8);
        CollectionUtils.putStringIfValid("mcode", maxAdWaterfallInfoImpl.getMCode(), map2);
        CollectionUtils.putStringIfValid(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, strB, map2);
        CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, maxAdFormatA.getLabel(), map2);
        CollectionUtils.putStringIfValid("name", maxAdWaterfallInfoImpl.getName(), map2);
        CollectionUtils.putLongIfValid("request_latency_ms", Long.valueOf(j2), map2);
        CollectionUtils.putLongIfValid("request_start_timestamp_ms", Long.valueOf(j), map2);
        CollectionUtils.putLongIfValid("wf_latency_ms", Long.valueOf(maxAdWaterfallInfoImpl.getLatencyMillis()), map2);
        map2.put("arn_info", requestParameters.f().e());
        List<MaxNetworkResponseInfo> networkResponses = maxAdWaterfallInfoImpl.getNetworkResponses();
        ArrayList arrayList = new ArrayList(networkResponses.size());
        for (MaxNetworkResponseInfo maxNetworkResponseInfo : networkResponses) {
            MaxMediatedNetworkInfo mediatedNetwork = maxNetworkResponseInfo.getMediatedNetwork();
            HashMap map3 = new HashMap(5);
            CollectionUtils.putStringIfValid("bcode", ((MaxNetworkResponseInfoImpl) maxNetworkResponseInfo).getBCode(), map3);
            map3.put("name", mediatedNetwork.getName());
            CollectionUtils.putLongIfValid("latency_ms", Long.valueOf(maxNetworkResponseInfo.getLatencyMillis()), map3);
            map3.put("load_state", Integer.valueOf(maxNetworkResponseInfo.getAdLoadState().ordinal()));
            MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxNetworkResponseInfo.getError();
            if (maxErrorImpl != null) {
                HashMap map4 = new HashMap(4);
                map4.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, Integer.valueOf(maxErrorImpl.getCode()));
                map4.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, maxErrorImpl.getMessage());
                map4.put("third_party_sdk_error_code", Integer.valueOf(maxErrorImpl.getMediatedNetworkErrorCode()));
                map4.put("third_party_sdk_error_message", maxErrorImpl.getMediatedNetworkErrorMessage());
                map3.put("error_info", map4);
            }
            arrayList.add(map3);
        }
        map2.put("ads_info", arrayList);
        a("mwf_info", maxAdWaterfallInfoImpl.getPostbackUrls(), Collections.EMPTY_MAP, map2, null, null, false);
    }

    public void setCustomPostBodyData(JSONObject jSONObject) {
        this.d.set(jSONObject);
    }

    public void showFullscreenAd(final c3 c3Var, final Activity activity, Map<String, Object> map, Map<String, Object> map2, final a.InterfaceC0152a interfaceC0152a) {
        if (c3Var == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity == null && MaxAdFormat.APP_OPEN != c3Var.getFormat()) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.f483a.H().a(true);
        final h hVarB = b(c3Var);
        long jK0 = c3Var.k0();
        if (((Boolean) this.f483a.a(r3.k8)).booleanValue() && this.f483a.R() == null && this.f483a.Q().a((MaxAd) c3Var)) {
            this.f483a.Q().a(c3Var.getAdUnitId(), (String) null, c3Var.getFormat(), i.SEQUENTIAL_OR_PRECACHE, map, map2, activity, (a.InterfaceC0152a) null);
        }
        if (o.a()) {
            this.b.d("MediationService", "Showing ad " + c3Var.getAdUnitId() + " with delay of " + jK0 + "ms...");
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(c3Var, hVarB, activity, interfaceC0152a);
            }
        }, jK0);
    }

    private h b(c3 c3Var) {
        h hVarA = c3Var.A();
        if (hVarA != null) {
            return hVarA;
        }
        this.f483a.H().a(false);
        if (o.a()) {
            this.b.k("MediationService", "Failed to show " + c3Var + ": adapter not found");
        }
        o.h("MediationService", "There may be an integration problem with the adapter for Ad Unit ID '" + c3Var.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        throw new IllegalStateException("Could not find adapter for provided ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(c3 c3Var, h hVar, Activity activity, a.InterfaceC0152a interfaceC0152a) {
        a(c3Var);
        hVar.b(c3Var, activity);
        a(c3Var, interfaceC0152a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(c3 c3Var, h hVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, a.InterfaceC0152a interfaceC0152a) {
        a(c3Var);
        hVar.a(c3Var, viewGroup, lifecycle, activity);
        a(c3Var, interfaceC0152a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(y2 y2Var, MaxError maxError, MaxAdListener maxAdListener) {
        a(maxError, y2Var);
        destroyAd(y2Var);
        t2.a(maxAdListener, y2Var.getAdUnitId(), maxError);
    }

    private void a(c3 c3Var) {
        if (c3Var.getFormat() == MaxAdFormat.REWARDED) {
            this.f483a.r0().a((j5) new v6(c3Var, this.f483a), e6.b.OTHER);
        }
    }

    private void a(c3 c3Var, a.InterfaceC0152a interfaceC0152a) {
        this.f483a.H().a(false);
        a(c3Var, (MaxAdListener) interfaceC0152a);
        if (o.a()) {
            this.b.a("MediationService", "Scheduling impression for ad manually...");
        }
        processRawAdImpression(c3Var, interfaceC0152a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(y2 y2Var) {
        this.f483a.t().b(y2Var, "DID_LOAD");
        if (y2Var.M().endsWith("load")) {
            this.f483a.t().b(y2Var);
        }
        HashMap map = new HashMap(3);
        long jF = y2Var.F();
        map.put("{LOAD_TIME_MS}", String.valueOf(jF));
        if (y2Var.getFormat().isFullscreenAd()) {
            n.a aVarB = this.f483a.H().b(y2Var.getAdUnitId());
            map.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(aVarB.a()));
            map.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(aVarB.b()));
        }
        a("load", map, y2Var);
        Map mapA = f2.a(y2Var);
        mapA.put("duration_ms", String.valueOf(jF));
        this.f483a.P().d(d2.k0, mapA);
    }

    public void showFullscreenAd(final c3 c3Var, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity, Map<String, Object> map, Map<String, Object> map2, final a.InterfaceC0152a interfaceC0152a) {
        if (c3Var == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity != null) {
            this.f483a.H().a(true);
            final h hVarB = b(c3Var);
            long jK0 = c3Var.k0();
            if (((Boolean) this.f483a.a(r3.k8)).booleanValue() && this.f483a.R() == null && this.f483a.Q().a((MaxAd) c3Var)) {
                this.f483a.Q().a(c3Var.getAdUnitId(), (String) null, c3Var.getFormat(), i.SEQUENTIAL_OR_PRECACHE, map, map2, activity, (a.InterfaceC0152a) null);
            }
            if (o.a()) {
                this.b.d("MediationService", "Showing ad " + c3Var.getAdUnitId() + " with delay of " + jK0 + "ms...");
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(c3Var, hVarB, viewGroup, lifecycle, activity, interfaceC0152a);
                }
            }, jK0);
            return;
        }
        throw new IllegalArgumentException("No activity specified");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(y2 y2Var, a.InterfaceC0152a interfaceC0152a, String str) {
        String str2 = "Failed to load " + y2Var + ": adapter init failed with error: " + str;
        if (o.a()) {
            this.b.k("MediationService", str2);
        }
        b(y2Var, new MaxErrorImpl(MaxAdapterError.NOT_INITIALIZED.getErrorCode(), "Adapter initialization failed"), interfaceC0152a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, String str, MaxAdapterParametersImpl maxAdapterParametersImpl, y2 y2Var, Activity activity, a.InterfaceC0152a interfaceC0152a) {
        hVar.a(str, maxAdapterParametersImpl, y2Var, activity, new b(y2Var, interfaceC0152a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j, h hVar, String str, e5 e5Var, MaxAdFormat maxAdFormat, d5.a aVar, boolean z, String str2, MaxError maxError) {
        d5 d5VarA;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (z) {
            if (o.a()) {
                this.b.a("MediationService", "Signal collection successful from: " + hVar.g() + " for Ad Unit ID: " + str + " with signal: \"" + str2 + "\"");
            }
            d5VarA = d5.a(e5Var, hVar, str2, j, jElapsedRealtime);
            this.c.a(d5VarA, e5Var, str, maxAdFormat);
            HashMap map = new HashMap();
            CollectionUtils.putStringIfValid("network_name", e5Var.c(), map);
            CollectionUtils.putStringIfValid("adapter_class", e5Var.b(), map);
            CollectionUtils.putStringIfValid("adapter_version", hVar.b(), map);
            CollectionUtils.putStringIfValid("duration_ms", String.valueOf(jElapsedRealtime), map);
            CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, String.valueOf(maxAdFormat.getLabel()), map);
            CollectionUtils.putStringIfValid(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, str, map);
            this.f483a.P().d(d2.e0, map);
        } else {
            if (o.a()) {
                this.b.b("MediationService", "Signal collection failed from: " + hVar.g() + " for Ad Unit ID: " + str + " with error message: \"" + maxError.getMessage() + "\"");
            }
            d5VarA = d5.a(e5Var, hVar, maxError, j, jElapsedRealtime);
            a(d5VarA, e5Var, hVar);
        }
        aVar.a(d5VarA);
        hVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(t4 t4Var, h hVar, MaxAdapterParametersImpl maxAdapterParametersImpl, e5 e5Var, Activity activity) {
        if (t4Var.c()) {
            return;
        }
        if (o.a()) {
            this.b.a("MediationService", "Collecting signal for now-initialized adapter: " + hVar.g());
        }
        hVar.a(maxAdapterParametersImpl, e5Var, activity, t4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, t4 t4Var, String str) {
        if (o.a()) {
            this.b.b("MediationService", "Skip collecting signal for failed-initialized adapter: " + hVar.g());
        }
        t4Var.a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_NOT_INITIALIZED, "Could not initialize adapter: " + str));
    }

    private void a(final c3 c3Var, final MaxAdListener maxAdListener) {
        final Long l = (Long) this.f483a.a(r3.Z7);
        if (l.longValue() <= 0) {
            return;
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(c3Var, l, maxAdListener);
            }
        }, l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(c3 c3Var, Long l, MaxAdListener maxAdListener) {
        if (c3Var.u().get()) {
            return;
        }
        String str = "Ad (" + c3Var.k() + ") has not been displayed after " + l + "ms. Failing ad display...";
        o.h("MediationService", str);
        a(c3Var, new MaxErrorImpl(-1, str), maxAdListener);
        this.f483a.H().b(c3Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y2 y2Var, MaxError maxError, MaxAdListener maxAdListener) {
        this.f483a.l().a(y2Var, g.c.SHOW_ERROR);
        this.f483a.t().b(y2Var, "DID_FAIL_DISPLAY");
        a(maxError, y2Var, true);
        if (y2Var.u().compareAndSet(false, true)) {
            t2.a(maxAdListener, y2Var, maxError);
        }
    }

    private void a(MaxError maxError, y2 y2Var) {
        HashMap map = new HashMap(3);
        long jF = y2Var.F();
        map.put("{LOAD_TIME_MS}", String.valueOf(jF));
        if (y2Var.getFormat().isFullscreenAd()) {
            n.a aVarB = this.f483a.H().b(y2Var.getAdUnitId());
            map.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(aVarB.a()));
            map.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(aVarB.b()));
        }
        a("mlerr", map, maxError, y2Var);
        Map mapA = f2.a(y2Var);
        mapA.putAll(f2.a(maxError));
        mapA.put("duration_ms", String.valueOf(jF));
        this.f483a.P().d(d2.l0, mapA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y2 y2Var) {
        this.f483a.t().b(y2Var, "DID_HIDE");
        HashMap map = new HashMap(1);
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f483a.x0().e());
        if (!((Boolean) this.f483a.a(y4.M3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mclose", map, y2Var);
        this.f483a.P().a(d2.r0, y2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y2 y2Var, a.InterfaceC0152a interfaceC0152a) {
        this.f483a.t().b(y2Var, "DID_CLICKED");
        this.f483a.t().b(y2Var, "DID_CLICK");
        if (y2Var.M().endsWith("click")) {
            this.f483a.t().b(y2Var);
            t2.a((MaxAdRevenueListener) interfaceC0152a, (MaxAd) y2Var);
        }
        HashMap map = new HashMap(1);
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f483a.x0().e());
        if (!((Boolean) this.f483a.a(y4.M3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mclick", map, y2Var);
    }

    private void a(MaxError maxError, y2 y2Var, boolean z) {
        HashMap map = new HashMap(1);
        if (y2Var instanceof c3) {
            map.put("{PREVIOUS_FAILED_NETWORK_NAME}", StringUtils.emptyIfNull(((c3) y2Var).n0()));
        }
        a("mierr", map, maxError, y2Var, z);
        if (!z || y2Var == null) {
            return;
        }
        this.f483a.P().a(d2.q0, y2Var, maxError);
    }

    private void a(d5 d5Var, e5 e5Var, h hVar) {
        long jB = d5Var.b();
        HashMap map = new HashMap(3);
        map.put("{LOAD_TIME_MS}", String.valueOf(jB));
        CollectionUtils.putStringIfValid("{ADAPTER_VERSION}", hVar.b(), map);
        CollectionUtils.putStringIfValid("{SDK_VERSION}", hVar.i(), map);
        a("serr", map, d5Var.c(), e5Var);
        Map mapA = f2.a(d5Var.c());
        CollectionUtils.putStringIfValid("network_name", e5Var.c(), mapA);
        CollectionUtils.putStringIfValid("adapter_class", e5Var.b(), mapA);
        CollectionUtils.putStringIfValid("adapter_version", hVar.b(), mapA);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(jB), mapA);
        this.f483a.P().d(d2.f0, mapA);
    }

    private void a(String str, Map map, k3 k3Var) {
        a(str, map, (MaxError) null, k3Var);
    }

    private void a(String str, Map map, MaxError maxError, k3 k3Var) {
        a(str, map, maxError, k3Var, true);
    }

    private void a(String str, Map map, MaxError maxError, k3 k3Var, boolean z) {
        String strEmptyIfNull;
        Map map2 = CollectionUtils.map(map);
        String strEmptyIfNull2 = "";
        map2.put("{PLACEMENT}", z ? StringUtils.emptyIfNull(k3Var.getPlacement()) : "");
        if (!z) {
            strEmptyIfNull = "";
        } else {
            strEmptyIfNull = StringUtils.emptyIfNull(k3Var.e());
        }
        map2.put("{CUSTOM_DATA}", strEmptyIfNull);
        if (k3Var instanceof y2) {
            y2 y2Var = (y2) k3Var;
            if (z) {
                strEmptyIfNull2 = StringUtils.emptyIfNull(y2Var.getCreativeId());
            }
            map2.put("{CREATIVE_ID}", strEmptyIfNull2);
        }
        a(str, null, map2, null, maxError, k3Var, z);
    }

    private void a(String str, List list, Map map, Map map2, MaxError maxError, k3 k3Var, boolean z) {
        this.f483a.r0().a((j5) new c6(str, list, map, map2, maxError, k3Var, this.f483a, z), e6.b.OTHER);
    }

    private boolean a(long j) {
        return System.currentTimeMillis() - j <= ((Long) this.f483a.a(y4.J2)).longValue();
    }
}
