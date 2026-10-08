package com.fyber.inneractive.sdk.dv.handler;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.dv.j;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.network.x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends a {
    public static final List e = Arrays.asList(UnitDisplayType.INTERSTITIAL, UnitDisplayType.REWARDED, UnitDisplayType.BANNER);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f996a = new HashMap();
    public boolean b = false;
    public final Object c = new Object();
    public int d = 0;

    public static AdRequest a(e eVar) throws IllegalAccessException, InvocationTargetException {
        eVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_3");
        AdRequest.Builder builder = new AdRequest.Builder();
        try {
            Class<?> cls = Class.forName("com.google.android.gms.ads.AbstractAdRequestBuilder");
            Object objInvoke = cls.getMethod("setRequestAgent", String.class).invoke(builder, "FyberMarketplace-v8.4.0");
            if (objInvoke != null) {
                builder = (AdRequest.Builder) objInvoke;
            }
            Object objInvoke2 = cls.getMethod("addNetworkExtrasBundle", Class.class, Bundle.class).invoke(builder, AdMobAdapter.class, bundle);
            if (objInvoke2 != null) {
                builder = (AdRequest.Builder) objInvoke2;
            }
        } catch (ClassNotFoundException unused) {
            builder.setRequestAgent("FyberMarketplace-v8.4.0").addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        }
        return builder.build();
    }

    public static String b() {
        try {
            try {
                Object objInvoke = Class.forName("com.google.android.gms.ads.MobileAds").getMethod(MobileAdsBridge.versionMethodName, null).invoke(null, null);
                if (objInvoke != null) {
                    return objInvoke.toString();
                }
            } catch (NoSuchMethodException unused) {
                return MobileAds.getVersionString();
            }
        } catch (Throwable unused2) {
        }
        return "na";
    }

    @Override // com.fyber.inneractive.sdk.dv.handler.a
    public final void a() {
        AdFormat adFormat;
        Iterator it = e.iterator();
        while (it.hasNext()) {
            int i = d.f995a[((UnitDisplayType) it.next()).ordinal()];
            if (i == 1 || i == 2) {
                adFormat = AdFormat.BANNER;
            } else if (i != 3) {
                adFormat = AdFormat.INTERSTITIAL;
            } else {
                adFormat = AdFormat.REWARDED;
            }
            r.f1668a.execute(new c(this, adFormat));
        }
    }

    @Override // com.fyber.inneractive.sdk.dv.handler.a
    public final j a(UnitDisplayType unitDisplayType) {
        AdFormat adFormat;
        j jVar;
        int i = d.f995a[unitDisplayType.ordinal()];
        if (i == 1 || i == 2) {
            adFormat = AdFormat.BANNER;
        } else if (i != 3) {
            adFormat = AdFormat.INTERSTITIAL;
        } else {
            adFormat = AdFormat.REWARDED;
        }
        QueryInfo queryInfo = (QueryInfo) this.f996a.get(adFormat);
        if (queryInfo != null) {
            synchronized (this.c) {
                this.f996a.remove(adFormat);
            }
            jVar = new j(queryInfo);
        } else {
            jVar = null;
        }
        IAlog.a("DVHanlder - get query: %s", jVar);
        r.f1668a.execute(new c(this, adFormat));
        return jVar;
    }

    public static void a(String str, com.fyber.inneractive.sdk.dv.enums.a aVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, String str2) {
        IAlog.a("Firing Event 1001 -Phase - " + aVar.name() + "  Fetch error DV - msg  " + str2, new Object[0]);
        w wVar = new w(t.DV_ERROR_PHASE, inneractiveAdRequest, eVar);
        wVar.f.put(new x().a(str, "spot_id").a(aVar.name().toLowerCase(Locale.US), TypedValues.CycleType.S_WAVE_PHASE).a(b(), "version").a(str2, "message").f1221a);
        wVar.a((String) null);
    }
}
