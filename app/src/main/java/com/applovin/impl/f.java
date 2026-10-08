package com.applovin.impl;

import com.applovin.impl.d2;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f extends e2 {
    public f(com.applovin.impl.sdk.k kVar) {
        super(kVar, d2.b.AD);
    }

    public void a(d2 d2Var, com.applovin.impl.sdk.ad.b bVar) {
        a(d2Var, bVar, new HashMap());
    }

    public void a(d2 d2Var, com.applovin.impl.sdk.ad.b bVar, Map map) {
        a(d2Var, bVar != null ? bVar.getAdZone() : null, bVar, null, map);
    }

    public void a(d2 d2Var, u uVar, AppLovinError appLovinError) {
        a(d2Var, uVar, null, appLovinError, new HashMap());
    }

    private void a(d2 d2Var, u uVar, com.applovin.impl.sdk.ad.b bVar, AppLovinError appLovinError, Map map) {
        if (((Boolean) this.f363a.a(y4.J)).booleanValue() && this.f363a.H0()) {
            return;
        }
        if (bVar != null) {
            map.putAll(f2.a((AppLovinAdImpl) bVar));
        } else if (uVar != null) {
            CollectionUtils.putStringIfValid("ad_zone_id", uVar.e(), map);
            MaxAdFormat maxAdFormatD = uVar.d();
            if (maxAdFormatD != null) {
                CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, maxAdFormatD.getLabel(), map);
            }
        }
        AppLovinAdSize appLovinAdSizeA = a(uVar, bVar);
        if (appLovinAdSizeA != null) {
            CollectionUtils.putStringIfValid("ad_size", appLovinAdSizeA.getLabel(), map);
        }
        if (appLovinError != null) {
            CollectionUtils.putStringIfValid(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, appLovinError.getMessage(), map);
            CollectionUtils.putStringIfValid(NativeProtocol.BRIDGE_ARG_ERROR_CODE, String.valueOf(appLovinError.getCode()), map);
        }
        d(d2Var, map);
    }

    private AppLovinAdSize a(u uVar, com.applovin.impl.sdk.ad.b bVar) {
        AppLovinAdSize appLovinAdSizeF = uVar != null ? uVar.f() : null;
        if (appLovinAdSizeF != null) {
            return appLovinAdSizeF;
        }
        if (bVar != null) {
            return bVar.getSize();
        }
        return null;
    }
}
