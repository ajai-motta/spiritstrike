package com.hive.iapv4;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.base.CacheProperty;
import com.hive.base.Property;
import com.hive.core.Configuration;
import com.hive.core.ExtentionsKt;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: IapV4NetworkCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012J\"\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/hive/iapv4/IapV4NetworkCache;", "", "<init>", "()V", "CACHED_MARKETS", "", "CACHED_MARKET_PRODUCTS", "CACHED_PRODUCT_PRODUCTS", "CACHED_PRODUCT_UPDATE_DATE", "iapv4CacheFileName", "iapv4CacheProperty", "Lcom/hive/base/CacheProperty;", "getCachedMarkets", "Lorg/json/JSONArray;", "cachedSpec", "Lcom/hive/iapv4/IapV4NetworkCache$CachedSpec;", "getCachedMarketUpdateDate", "getCachedMarketProducts", "Lorg/json/JSONObject;", "getCachedProductProducts", "getCachedProductUpdateDate", "compareMarketList", "responseMarketJsonArray", "removeCachedProducts", "", "compareMarketProducts", "marketProductInfo", "compareProductProducts", "responseProducts", "responseUpdateDate", "CachedSpec", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IapV4NetworkCache {
    private static final String CACHED_MARKETS = "iapv4.cached_markets";
    private static final String CACHED_MARKET_PRODUCTS = "iapv4.cached_market_products";
    private static final String CACHED_PRODUCT_PRODUCTS = "iapv4.cached_product_products";
    private static final String CACHED_PRODUCT_UPDATE_DATE = "iapv4.cached_product_update_date";
    public static final IapV4NetworkCache INSTANCE = new IapV4NetworkCache();
    private static final String iapv4CacheFileName = "hiveiapv4cache.dat";
    private static CacheProperty iapv4CacheProperty = new CacheProperty(iapv4CacheFileName);

    private IapV4NetworkCache() {
    }

    /* JADX INFO: compiled from: IapV4NetworkCache.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003J.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/hive/iapv4/IapV4NetworkCache$CachedSpec;", "", "appId", "", "marketId", "", "hiveCountry", "pidType", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getMarketId", "()I", "getHiveCountry", "getPidType", "toSpecString", "name", "copy", InAppPurchaseConstants.METHOD_TO_STRING, "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CachedSpec {
        private final String appId;
        private final String hiveCountry;
        private final int marketId;
        private final String pidType;

        public CachedSpec(String appId, int i, String hiveCountry, String pidType) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(hiveCountry, "hiveCountry");
            Intrinsics.checkNotNullParameter(pidType, "pidType");
            this.appId = appId;
            this.marketId = i;
            this.hiveCountry = hiveCountry;
            this.pidType = pidType;
            LoggerImpl.INSTANCE.dL("[HiveIAPV4NetworkCache] create CachedSpec: " + this);
            LoggerImpl.INSTANCE.dR("[HiveIAPV4NetworkCache] create CachedSpec");
        }

        public /* synthetic */ CachedSpec(String str, int i, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? Configuration.INSTANCE.getAppId() : str, (i2 & 2) != 0 ? IapV4Impl.INSTANCE.getSelectedMarket() : i, (i2 & 4) != 0 ? Configuration.INSTANCE.getHiveCountry() : str2, str3);
        }

        public final String getAppId() {
            return this.appId;
        }

        public final int getMarketId() {
            return this.marketId;
        }

        public final String getHiveCountry() {
            return this.hiveCountry;
        }

        public final String getPidType() {
            return this.pidType;
        }

        public final String toSpecString(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (Intrinsics.areEqual(name, IapV4NetworkCache.CACHED_MARKETS)) {
                return "iapv4.cached_markets_" + this.appId + '_' + this.hiveCountry + '_' + this.pidType;
            }
            return name + '_' + this.appId + '_' + this.marketId + '_' + this.hiveCountry + '_' + this.pidType;
        }

        public static /* synthetic */ CachedSpec copy$default(CachedSpec cachedSpec, String str, int i, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = cachedSpec.appId;
            }
            if ((i2 & 2) != 0) {
                i = cachedSpec.marketId;
            }
            if ((i2 & 4) != 0) {
                str2 = cachedSpec.hiveCountry;
            }
            if ((i2 & 8) != 0) {
                str3 = cachedSpec.pidType;
            }
            return cachedSpec.copy(str, i, str2, str3);
        }

        public final CachedSpec copy(String appId, int marketId, String hiveCountry, String pidType) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(hiveCountry, "hiveCountry");
            Intrinsics.checkNotNullParameter(pidType, "pidType");
            return new CachedSpec(appId, marketId, hiveCountry, pidType);
        }

        public String toString() {
            return this.appId + '_' + this.marketId + '_' + this.hiveCountry + '_' + this.pidType;
        }
    }

    public final JSONArray getCachedMarkets(CachedSpec cachedSpec) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(cachedSpec, "cachedSpec");
        String specString = cachedSpec.toSpecString(CACHED_MARKETS);
        String value = iapv4CacheProperty.getValue(specString);
        if (value == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(new JSONArray(value));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[HiveIAPV4NetworkCache] getCachedMarkets exception: " + thM7418exceptionOrNullimpl);
            iapv4CacheProperty.removeValue(specString);
            iapv4CacheProperty.writeProperties();
        }
        JSONArray jSONArray = (JSONArray) (Result.m7421isFailureimpl(objM7415constructorimpl) ? null : objM7415constructorimpl);
        LoggerImpl.INSTANCE.d("[HiveIAPV4NetworkCache] getCachedMarkets: " + jSONArray);
        return jSONArray;
    }

    public final JSONArray getCachedMarketUpdateDate(CachedSpec cachedSpec) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(cachedSpec, "cachedSpec");
        try {
            Result.Companion companion = Result.INSTANCE;
            IapV4NetworkCache iapV4NetworkCache = this;
            JSONArray cachedMarkets = getCachedMarkets(cachedSpec);
            if (cachedMarkets != null) {
                int length = cachedMarkets.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = cachedMarkets.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        jSONObjectOptJSONObject.remove("market_pid_list");
                        jSONObjectOptJSONObject.remove("market_subs_pid_list");
                    }
                }
            } else {
                cachedMarkets = null;
            }
            objM7415constructorimpl = Result.m7415constructorimpl(cachedMarkets);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[HiveIAPV4NetworkCache] getCachedMarketUpdateDate  exception: " + thM7418exceptionOrNullimpl);
        }
        JSONArray jSONArray = (JSONArray) (Result.m7421isFailureimpl(objM7415constructorimpl) ? null : objM7415constructorimpl);
        LoggerImpl.INSTANCE.d("[HiveIAPV4NetworkCache] getCachedMarketUpdateDate: " + jSONArray);
        return jSONArray;
    }

    public final JSONObject getCachedMarketProducts(CachedSpec cachedSpec) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(cachedSpec, "cachedSpec");
        String specString = cachedSpec.toSpecString(CACHED_MARKET_PRODUCTS);
        String value = iapv4CacheProperty.getValue(specString);
        if (value == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(new JSONObject(value));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[HiveIAPV4NetworkCache] getCachedMarketProducts exception: " + thM7418exceptionOrNullimpl);
            iapv4CacheProperty.removeValue(specString);
            iapv4CacheProperty.writeProperties();
        }
        JSONObject jSONObject = (JSONObject) (Result.m7421isFailureimpl(objM7415constructorimpl) ? null : objM7415constructorimpl);
        LoggerImpl.INSTANCE.d("[HiveIAPV4NetworkCache] getCachedMarketProducts: " + jSONObject);
        return jSONObject;
    }

    public final JSONArray getCachedProductProducts(CachedSpec cachedSpec) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(cachedSpec, "cachedSpec");
        String specString = cachedSpec.toSpecString(CACHED_PRODUCT_PRODUCTS);
        String value = iapv4CacheProperty.getValue(specString);
        if (value == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(new JSONArray(value));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[HiveIAPV4NetworkCache] getCachedProductProducts exception: " + thM7418exceptionOrNullimpl);
            iapv4CacheProperty.removeValue(specString);
            iapv4CacheProperty.writeProperties();
        }
        JSONArray jSONArray = (JSONArray) (Result.m7421isFailureimpl(objM7415constructorimpl) ? null : objM7415constructorimpl);
        LoggerImpl.INSTANCE.d("[HiveIAPV4NetworkCache] getCachedProductProducts: " + jSONArray);
        return jSONArray;
    }

    public final String getCachedProductUpdateDate(CachedSpec cachedSpec) {
        Intrinsics.checkNotNullParameter(cachedSpec, "cachedSpec");
        String value = iapv4CacheProperty.getValue(cachedSpec.toSpecString(CACHED_PRODUCT_UPDATE_DATE));
        LoggerImpl.INSTANCE.d("[HiveIAPV4NetworkCache] getCachedProductUpdateDate: " + value);
        return value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONArray compareMarketList(com.hive.iapv4.IapV4NetworkCache.CachedSpec r21, org.json.JSONArray r22) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.IapV4NetworkCache.compareMarketList(com.hive.iapv4.IapV4NetworkCache$CachedSpec, org.json.JSONArray):org.json.JSONArray");
    }

    public final void removeCachedProducts(CachedSpec cachedSpec) {
        Intrinsics.checkNotNullParameter(cachedSpec, "cachedSpec");
        LoggerImpl.INSTANCE.d("[HiveIAPV4NetworkCache] removeCachedProducts");
        iapv4CacheProperty.removeValue(cachedSpec.toSpecString(CACHED_MARKET_PRODUCTS));
        iapv4CacheProperty.removeValue(cachedSpec.toSpecString(CACHED_PRODUCT_PRODUCTS));
        iapv4CacheProperty.removeValue(cachedSpec.toSpecString(CACHED_PRODUCT_UPDATE_DATE));
        iapv4CacheProperty.writeProperties();
    }

    public final void compareMarketProducts(CachedSpec cachedSpec, JSONObject marketProductInfo) {
        Intrinsics.checkNotNullParameter(cachedSpec, "cachedSpec");
        LoggerImpl.INSTANCE.d("[HiveIAPV4NetworkCache] compareMarketProducts \nmarketProductInfo: " + marketProductInfo + '\n');
        if (marketProductInfo == null) {
            removeCachedProducts(cachedSpec);
            return;
        }
        boolean zSimilar = ExtentionsKt.similar(marketProductInfo, getCachedMarketProducts(cachedSpec));
        LoggerImpl.INSTANCE.d("[HiveIAPV4NetworkCache] compareMarketProducts isSimilar: " + zSimilar);
        if (!zSimilar) {
            removeCachedProducts(cachedSpec);
        }
        Property.setValue$default(iapv4CacheProperty, cachedSpec.toSpecString(CACHED_MARKET_PRODUCTS), marketProductInfo.toString(), null, 4, null);
        iapv4CacheProperty.writeProperties();
    }

    public final JSONArray compareProductProducts(CachedSpec cachedSpec, JSONArray responseProducts, String responseUpdateDate) {
        Intrinsics.checkNotNullParameter(cachedSpec, "cachedSpec");
        Intrinsics.checkNotNullParameter(responseUpdateDate, "responseUpdateDate");
        LoggerImpl.INSTANCE.d("[HiveIAPV4NetworkCache] compareProductProducts \nresponseProducts: " + responseProducts + "\nresponseUpdateDate: " + responseUpdateDate + '\n');
        JSONArray cachedProductProducts = getCachedProductProducts(cachedSpec);
        String cachedProductUpdateDate = getCachedProductUpdateDate(cachedSpec);
        if ((!StringsKt.isBlank(responseUpdateDate)) && Intrinsics.areEqual(responseUpdateDate, cachedProductUpdateDate) && cachedProductProducts != null) {
            return cachedProductProducts;
        }
        if (responseProducts == null || responseProducts.length() <= 0) {
            return responseProducts;
        }
        Property.setValue$default(iapv4CacheProperty, cachedSpec.toSpecString(CACHED_PRODUCT_PRODUCTS), responseProducts.toString(), null, 4, null);
        Property.setValue$default(iapv4CacheProperty, cachedSpec.toSpecString(CACHED_PRODUCT_UPDATE_DATE), responseUpdateDate, null, 4, null);
        iapv4CacheProperty.writeProperties();
        return responseProducts;
    }
}
