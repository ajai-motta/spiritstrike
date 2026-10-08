package com.fyber.marketplace.fairbid.impl;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.config.u;
import com.fyber.inneractive.sdk.config.v;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.z0;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements MarketplaceAuctionParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1731a = new HashMap();
    public final HashMap b = new HashMap();
    public final com.fyber.inneractive.sdk.serverapi.d c;
    public String d;

    public g(com.fyber.inneractive.sdk.serverapi.c cVar) {
        this.c = cVar;
    }

    public static JSONObject a(HashMap map, f... fVarArr) {
        JSONObject jSONObject = new JSONObject();
        for (f fVar : fVarArr) {
            String str = (String) map.get(fVar.marketPlaceParam);
            if (!TextUtils.isEmpty(str)) {
                try {
                    Object objA = a(fVar.type, str);
                    if (objA != null) {
                        jSONObject.put(fVar.fairBidParam, objA);
                    }
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getAdvertisingId() {
        v vVar = u.f982a.b;
        if (vVar != null && vVar.c) {
            return null;
        }
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        int i = com.fyber.inneractive.sdk.config.k.f959a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.device");
        if (TextUtils.isEmpty(property)) {
            v vVar2 = u.f982a.b;
            if (vVar2 == null) {
                return null;
            }
            property = vVar2.f984a;
        }
        return property;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getAmazonAdvertisingId() {
        v vVar = u.f982a.b;
        if (vVar == null || !vVar.c) {
            return null;
        }
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        int i = com.fyber.inneractive.sdk.config.k.f959a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.device");
        if (TextUtils.isEmpty(property)) {
            v vVar2 = u.f982a.b;
            if (vVar2 == null) {
                return null;
            }
            property = vVar2.f984a;
        }
        return property;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getAppVersion() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return com.fyber.inneractive.sdk.util.k.l();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getBundleId() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return com.fyber.inneractive.sdk.util.o.f1662a.getPackageName();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getCarrier() {
        return ((com.fyber.inneractive.sdk.serverapi.c) this.c).a();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getDeviceModel() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return com.fyber.inneractive.sdk.util.k.j();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final r getFeatureProvider(String str) {
        return (r) this.f1731a.get(str);
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final int getHeight() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return com.fyber.inneractive.sdk.util.o.c(com.fyber.inneractive.sdk.util.o.d());
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getHorizontalAccuracy() {
        return null;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final List getInputLanguages() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return IAConfigManager.O.p;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getLanguage() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return IAConfigManager.O.o;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getLatitudeLongitude() {
        return null;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final JSONObject getMarketplaceEntry() {
        HashMap map = new HashMap();
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).a(this.d, map);
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            String str = f.KEY_COUNTRY_CODE.marketPlaceParam;
            ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
            map.put(str, com.fyber.inneractive.sdk.util.k.i());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("client_params", a(map, f.KEY_TIME_OF_DAY));
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("device_params", a(map, f.KEY_AVAILABLE_DISK_SPACE, f.KEY_DO_NOT_DISTURB, f.KEY_AIRPLANE_MODE, f.KEY_ANDROID_LEVEL, f.KEY_IS_MUTED, f.KEY_HEADSET, f.KEY_BATTERY_CONNECTED, f.KEY_BATTERY_LEVEL, f.KEY_BLUETOOTH_CONNECTED, f.KEY_LOW_POWER_MODE, f.KEY_COUNTRY_CODE, f.KEY_DARK_MODE, f.KEY_TOTAL_DISK_SPACE, f.KEY_MEDIA_MUTED, f.KEY_AD_SERVICES_VERSION));
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("content_params", a(map, f.KEY_LAST_BUNDLE_SHOWED, f.KEY_LAST_DOMAIN_SHOWED));
        } catch (Exception unused3) {
        }
        r rVarA = r.a();
        this.f1731a.put(this.d, rVarA);
        rVarA.a(false, this.d);
        JSONArray jSONArrayA = com.fyber.inneractive.sdk.config.global.g.a(rVarA.b, true);
        IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", jSONArrayA);
        if (jSONArrayA != null && jSONArrayA.length() > 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("experiments", jSONArrayA);
            } catch (Exception unused4) {
            }
            try {
                jSONObject.put("sdk_experiments", jSONObject2);
            } catch (Exception unused5) {
            }
        }
        com.fyber.inneractive.sdk.serverapi.d dVar = this.c;
        String str2 = this.d;
        ((com.fyber.inneractive.sdk.serverapi.c) dVar).getClass();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.dv.j jVarA = iAConfigManager.G.a(com.fyber.inneractive.sdk.serverapi.b.a(str2));
        String str3 = this.d;
        if (jVarA != null) {
            this.b.put(str3, jVarA);
            try {
                jSONObject.put("gdem_signal", jVarA.f1001a.getQuery());
            } catch (JSONException unused6) {
            }
        }
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        StringBuilder sb = new StringBuilder("2.2.0-Android-8.4.0");
        if (!TextUtils.isEmpty(InneractiveAdManager.getDevPlatform())) {
            sb.append('-');
            sb.append(InneractiveAdManager.getDevPlatform());
        }
        try {
            jSONObject.put("version", sb.toString());
        } catch (JSONException unused7) {
        }
        com.fyber.inneractive.sdk.ignite.h hVar = iAConfigManager.E;
        if (hVar != null) {
            com.fyber.inneractive.sdk.ignite.l lVar = hVar.p;
            String strI = lVar != null ? lVar.f840a.i() : null;
            com.fyber.inneractive.sdk.ignite.l lVar2 = hVar.p;
            String strD = lVar2 != null ? lVar2.f840a.d() : null;
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(strI) && !TextUtils.isEmpty(strD)) {
                try {
                    jSONObject3.put("version", strI);
                } catch (JSONException unused8) {
                }
                try {
                    jSONObject3.put("package_name", strD);
                } catch (JSONException unused9) {
                }
                try {
                    jSONObject.put("ignite_params", jSONObject3);
                } catch (Exception unused10) {
                }
            }
        }
        IAConfigManager.b();
        com.fyber.inneractive.sdk.topics.b bVar = iAConfigManager.F;
        if (bVar.i.get() && IAConfigManager.f()) {
            JSONArray jSONArrayB = bVar.b();
            if (jSONArrayB != null) {
                try {
                    jSONObject.put("topics", jSONArrayB);
                } catch (Exception unused11) {
                }
            }
            JSONArray jSONArrayA2 = bVar.a();
            if (jSONArrayA2 != null) {
                try {
                    jSONObject.put("encrypted_topics", jSONArrayA2);
                } catch (Exception unused12) {
                }
            }
        }
        IAlog.a("getMarketplaceEntry:Json object - %s", jSONObject.toString());
        return jSONObject;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getMobileCountryCode() {
        String str = ((com.fyber.inneractive.sdk.serverapi.c) this.c).b;
        return str == null ? "" : str.substring(0, Math.min(3, str.length()));
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getMobileNetworkCode() {
        String str = ((com.fyber.inneractive.sdk.serverapi.c) this.c).b;
        return str == null ? "" : str.substring(Math.min(3, str.length()));
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getNetwork() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        z0 z0VarA = z0.a();
        IAlog.a("ExchangeRequestParamsProvider: getNetwork : type: %s value: %s", z0VarA, z0VarA.b());
        return z0VarA.b();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final List getSupportedApis() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return com.fyber.inneractive.sdk.serverapi.c.c;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final List getSupportedProtocols() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return com.fyber.inneractive.sdk.serverapi.c.d;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final int getSupportedTypesBitwise() {
        this.c.getClass();
        return 372;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getTimeAccuracy() {
        return null;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getVerticalAccuracy() {
        return null;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final int getWidth() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return com.fyber.inneractive.sdk.util.o.c(com.fyber.inneractive.sdk.util.o.e());
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final com.fyber.inneractive.sdk.dv.j getWrapperQueryInfo(String str) {
        com.fyber.inneractive.sdk.dv.j jVar = (com.fyber.inneractive.sdk.dv.j) this.b.get(this.d);
        this.b.remove(this.d);
        return jVar;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final boolean hasAmazonAdvertisingId() {
        v vVar = u.f982a.b;
        if (vVar != null) {
            return vVar.c;
        }
        return false;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final Boolean isLimitTrackingEnabled() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        v vVar = u.f982a.b;
        return Boolean.valueOf(vVar != null ? vVar.b : false);
    }

    public static Object a(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = obj.toString();
        if (TextUtils.equals(string, Integer.class.toString())) {
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        if (TextUtils.equals(string, String.class.toString())) {
            return str;
        }
        if (TextUtils.equals(string, Boolean.class.toString())) {
            if (str.equalsIgnoreCase("1")) {
                return Boolean.TRUE;
            }
            if (str.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                return Boolean.FALSE;
            }
        }
        return null;
    }
}
