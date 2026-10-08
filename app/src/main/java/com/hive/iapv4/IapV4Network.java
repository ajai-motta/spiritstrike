package com.hive.iapv4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.applovin.sdk.AppLovinEventTypes;
import com.hive.Analytics;
import com.hive.IAPV4;
import com.hive.ResultAPI;
import com.hive.analytics.AnalyticsImpl;
import com.hive.base.Android;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Configuration;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.HiveKeys;
import com.hive.core.OauthToken;
import com.hive.core.configuration.HiveZoneType;
import com.hive.iapv4.IapV4Impl;
import com.hive.iapv4.IapV4NetworkCache;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.iapv4.FinalizePurchase;
import com.hive.protocol.iapv4.IapV4;
import com.hive.protocol.iapv4.Market;
import com.hive.protocol.iapv4.Product;
import com.hive.protocol.iapv4.Purchase;
import com.hive.protocol.iapv4.RestorePurchase;
import com.hive.protocol.iapv4.Signature;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IapV4Network.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001AB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002J\u008d\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2v\u0010\u000b\u001ar\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0007\u0012'\u0012%\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0014¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\b0\fH\u0000¢\u0006\u0002\b\u0016J\u0080\u0001\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192_\u0010\u000b\u001a[\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012'\u0012%\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u0014¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u001aH\u0000¢\u0006\u0002\b\u001eJ.\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0081@¢\u0006\u0004\b&\u0010'J\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020*0)H\u0087@¢\u0006\u0002\u0010+J*\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020-0)2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nH\u0087@¢\u0006\u0002\u00100J=\u00101\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00192#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\b02J'\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0000¢\u0006\u0002\b:J\u001c\u0010;\u001a\u0006\u0012\u0002\b\u00030<*\u0006\u0012\u0002\b\u00030<2\u0006\u0010!\u001a\u00020\"H\u0002J3\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020?2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u001104¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\b02H\u0002¨\u0006B"}, d2 = {"Lcom/hive/iapv4/IapV4Network;", "", "<init>", "()V", "toResultAPI", "Lcom/hive/ResultAPI;", "Lcom/hive/protocol/iapv4/IapV4$IapV4Response;", "market", "", "pidType", "", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "resultApi", "Lcom/hive/protocol/iapv4/Market;", "Ljava/util/ArrayList;", "Lcom/hive/iapv4/IapV4Impl$IAPV4Market;", "marketList", "Lkotlin/collections/ArrayList;", "marketSelectUrl", "market$hive_iapv4_base_release", AppLovinEventTypes.USER_VIEWED_PRODUCT, "marketProductInfo", "Lorg/json/JSONObject;", "Lkotlin/Function3;", "Lcom/hive/protocol/iapv4/Product;", "Lcom/hive/IAPV4$IAPV4Product;", "productList", "product$hive_iapv4_base_release", "purchase", "Lcom/hive/protocol/iapv4/Purchase;", "requestCmd", "Lcom/hive/iapv4/IapV4Network$REQUEST_NETWORK_API;", "jsonObj", "iapV4Receipt", "Lcom/hive/IAPV4$IAPV4Receipt;", "purchase$hive_iapv4_base_release", "(Lcom/hive/iapv4/IapV4Network$REQUEST_NETWORK_API;Lorg/json/JSONObject;Lcom/hive/IAPV4$IAPV4Receipt;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restorePurchase", "Lkotlin/Pair;", "Lcom/hive/protocol/iapv4/RestorePurchase$RestorePurchaseResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finalizePurchase", "Lcom/hive/protocol/iapv4/FinalizePurchase$FinalizePurchaseResponse;", "marketPid", "orderId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", InAppPurchaseMetaData.KEY_SIGNATURE, "Lkotlin/Function1;", "sendAnalyticsRevenue", "", "iapV4Result", "", "detailCode", "analyticsRevenue", "Lcom/hive/Analytics$AnalyticsRevenue;", "sendAnalyticsRevenue$hive_iapv4_base_release", "setBasePostBody", "Lcom/hive/protocol/Protocol;", "checkGoogleService", "context", "Landroid/content/Context;", "isAvailable", "REQUEST_NETWORK_API", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IapV4Network {
    public static final IapV4Network INSTANCE = new IapV4Network();

    private IapV4Network() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: IapV4Network.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/hive/iapv4/IapV4Network$REQUEST_NETWORK_API;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REQUEST_MARKET", "REQUEST_PRODUCT", "REQUEST_PRE_PURCHASE", "REQUEST_PURCHASE", "REQUEST_POST_PURCHASE", "REQUEST_RESTORE_PURCHASE", "REQUEST_FINALIZE_PURCHASE", "REQUEST_SIGNATURE", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class REQUEST_NETWORK_API {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ REQUEST_NETWORK_API[] $VALUES;
        private final String value;
        public static final REQUEST_NETWORK_API REQUEST_MARKET = new REQUEST_NETWORK_API("REQUEST_MARKET", 0, "market");
        public static final REQUEST_NETWORK_API REQUEST_PRODUCT = new REQUEST_NETWORK_API("REQUEST_PRODUCT", 1, AppLovinEventTypes.USER_VIEWED_PRODUCT);
        public static final REQUEST_NETWORK_API REQUEST_PRE_PURCHASE = new REQUEST_NETWORK_API("REQUEST_PRE_PURCHASE", 2, "pre-purchase");
        public static final REQUEST_NETWORK_API REQUEST_PURCHASE = new REQUEST_NETWORK_API("REQUEST_PURCHASE", 3, "purchase");
        public static final REQUEST_NETWORK_API REQUEST_POST_PURCHASE = new REQUEST_NETWORK_API("REQUEST_POST_PURCHASE", 4, "post-purchase");
        public static final REQUEST_NETWORK_API REQUEST_RESTORE_PURCHASE = new REQUEST_NETWORK_API("REQUEST_RESTORE_PURCHASE", 5, "restore_purchase");
        public static final REQUEST_NETWORK_API REQUEST_FINALIZE_PURCHASE = new REQUEST_NETWORK_API("REQUEST_FINALIZE_PURCHASE", 6, "finalize_purchase");
        public static final REQUEST_NETWORK_API REQUEST_SIGNATURE = new REQUEST_NETWORK_API("REQUEST_SIGNATURE", 7, InAppPurchaseMetaData.KEY_SIGNATURE);

        private static final /* synthetic */ REQUEST_NETWORK_API[] $values() {
            return new REQUEST_NETWORK_API[]{REQUEST_MARKET, REQUEST_PRODUCT, REQUEST_PRE_PURCHASE, REQUEST_PURCHASE, REQUEST_POST_PURCHASE, REQUEST_RESTORE_PURCHASE, REQUEST_FINALIZE_PURCHASE, REQUEST_SIGNATURE};
        }

        public static EnumEntries<REQUEST_NETWORK_API> getEntries() {
            return $ENTRIES;
        }

        private REQUEST_NETWORK_API(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            REQUEST_NETWORK_API[] request_network_apiArr$values = $values();
            $VALUES = request_network_apiArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(request_network_apiArr$values);
        }

        public static REQUEST_NETWORK_API valueOf(String str) {
            return (REQUEST_NETWORK_API) Enum.valueOf(REQUEST_NETWORK_API.class, str);
        }

        public static REQUEST_NETWORK_API[] values() {
            return (REQUEST_NETWORK_API[]) $VALUES.clone();
        }
    }

    private final ResultAPI toResultAPI(IapV4.IapV4Response iapV4Response) {
        int iapV4Result = iapV4Response.getIapV4Result();
        if (iapV4Result == -1) {
            return new ResultAPI(-5, ResultAPI.Code.IAPV4NetworkError, iapV4Response.getResult().getMessage() + "(HttpStatus:" + iapV4Response.getHttpStatusCode() + ')');
        }
        if (iapV4Result == 0) {
            return new ResultAPI(0, ResultAPI.Code.Success, iapV4Response.getIapV4ResultMsg() + '(' + iapV4Response.getIapV4Result() + ')');
        }
        if (iapV4Result == 1000006) {
            return new ResultAPI(-8, ResultAPI.Code.IAPV4ServerResponseError, iapV4Response.getIapV4ResultMsg() + '(' + iapV4Response.getIapV4Result() + ')');
        }
        if (iapV4Result == 1000537) {
            return new ResultAPI(0, ResultAPI.Code.Success, iapV4Response.getIapV4ResultMsg() + '(' + iapV4Response.getIapV4Result() + ')');
        }
        if (iapV4Result == 1000802) {
            return new ResultAPI(-8, ResultAPI.Code.IAPV4ServerResponseError, iapV4Response.getIapV4ResultMsg() + '(' + iapV4Response.getIapV4Result() + ')');
        }
        return new ResultAPI(-8, ResultAPI.Code.IAPV4ServerResponseError, iapV4Response.getIapV4ResultMsg() + '(' + iapV4Response.getIapV4Result() + ')');
    }

    public final void market$hive_iapv4_base_release(final String pidType, final Function4<? super ResultAPI, ? super Market, ? super ArrayList<IapV4Impl.IAPV4Market>, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(pidType, "pidType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        final Protocol protocol = new Protocol(new Function0<Market>() { // from class: com.hive.iapv4.IapV4Network$market$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.iapv4.Market] */
            @Override // kotlin.jvm.functions.Function0
            public final Market invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Market.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        final Handler handler = new Handler(Looper.getMainLooper());
        Context initContext = HiveCoreInitializer.INSTANCE.getInitContext();
        final int iNextInt = new Random().nextInt(DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE);
        checkGoogleService(initContext, new Function1() { // from class: com.hive.iapv4.IapV4Network$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IapV4Network.market$lambda$7(iNextInt, pidType, protocol, handler, callback, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit market$lambda$7(int i, String str, Protocol protocol, final Handler handler, final Function4 function4, boolean z) {
        LoggerImpl.INSTANCE.i("[HiveIAPNetwork] [" + i + "] internalRequestNetwork");
        final IapV4NetworkCache.CachedSpec cachedSpec = new IapV4NetworkCache.CachedSpec(null, 0, null, str, 7, null);
        JSONArray cachedMarketUpdateDate = IapV4NetworkCache.INSTANCE.getCachedMarketUpdateDate(cachedSpec);
        INSTANCE.setBasePostBody(protocol, REQUEST_NETWORK_API.REQUEST_MARKET);
        protocol.setParam(HiveKeys.KEY_market_pid_type, str);
        protocol.setParam(HiveKeys.KEY_google_service_available, Boolean.valueOf(z));
        protocol.setParam(HiveKeys.KEY_ios_service_available, (Object) false);
        if (cachedMarketUpdateDate != null) {
            protocol.setParam(HiveKeys.KEY_cache_date, cachedMarketUpdateDate);
        }
        protocol.request(new Function1() { // from class: com.hive.iapv4.IapV4Network$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IapV4Network.market$lambda$7$lambda$6(handler, cachedSpec, function4, (Market) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v11, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v11, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v8, types: [T, com.hive.ResultAPI] */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, com.hive.ResultAPI] */
    public static final Unit market$lambda$7$lambda$6(Handler handler, IapV4NetworkCache.CachedSpec cachedSpec, final Function4 function4, final Market it) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(it, "it");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        if (it.getResponse().isSuccess()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                JSONArray jSONArrayCompareMarketList = IapV4NetworkCache.INSTANCE.compareMarketList(cachedSpec, it.getResponse().getContentJSONObject().optJSONArray("market_list"));
                if (jSONArrayCompareMarketList != null) {
                    ?? arrayList = new ArrayList();
                    int length = jSONArrayCompareMarketList.length();
                    for (int i = 0; i < length; i++) {
                        String string = jSONArrayCompareMarketList.getJSONObject(i).toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        IapV4Impl.IAPV4Market iAPV4Market = new IapV4Impl.IAPV4Market(string);
                        if (iAPV4Market.getIapType() == IAPV4.IAPV4Type.ONESTORE) {
                            String strOptString = it.getResponse().getContentJSONObject().optString("onestore_license_key");
                            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                            iAPV4Market.setLicenseKey(strOptString);
                        }
                        arrayList.add(iAPV4Market);
                    }
                    objectRef2.element = arrayList;
                } else {
                    objectRef.element = new ResultAPI(-8, ResultAPI.Code.IAPV4EmptyMarketList, "market list is empty");
                }
                objectRef3.element = it.getResponse().getContentJSONObject().optString("market_select_url");
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                String str = "create ResponseMarket Exception: " + thM7418exceptionOrNullimpl + ", \noriginal: " + it.getResponse();
                LoggerImpl.INSTANCE.wL(str);
                objectRef.element = new ResultAPI(-5, ResultAPI.Code.IAPV4ResponseError, str);
                LoggerImpl.INSTANCE.wR("create ResponseMarket Exception: " + thM7418exceptionOrNullimpl);
            }
        }
        handler.post(new Runnable() { // from class: com.hive.iapv4.IapV4Network$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                IapV4Network.market$lambda$7$lambda$6$lambda$5(function4, objectRef, it, objectRef2, objectRef3);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void market$lambda$7$lambda$6$lambda$5(Function4 function4, Ref.ObjectRef objectRef, Market market, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
        ResultAPI resultAPI = (ResultAPI) objectRef.element;
        if (resultAPI == null) {
            resultAPI = INSTANCE.toResultAPI(market.getResponse());
        }
        function4.invoke(resultAPI, market, objectRef2.element, objectRef3.element);
    }

    public final void product$hive_iapv4_base_release(String pidType, JSONObject marketProductInfo, final Function3<? super ResultAPI, ? super Product, ? super ArrayList<IAPV4.IAPV4Product>, Unit> callback) throws JSONException {
        Intrinsics.checkNotNullParameter(pidType, "pidType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<Product>() { // from class: com.hive.iapv4.IapV4Network$product$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.iapv4.Product] */
            @Override // kotlin.jvm.functions.Function0
            public final Product invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Product.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        final Handler handler = new Handler(Looper.getMainLooper());
        int iNextInt = new Random().nextInt(DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE);
        LoggerImpl.INSTANCE.d("[HiveIAPNetwork] [" + iNextInt + "] internalRequestNetwork");
        final IapV4NetworkCache.CachedSpec cachedSpec = new IapV4NetworkCache.CachedSpec(null, 0, null, pidType, 7, null);
        IapV4NetworkCache.INSTANCE.compareMarketProducts(cachedSpec, marketProductInfo);
        String cachedProductUpdateDate = IapV4NetworkCache.INSTANCE.getCachedProductUpdateDate(cachedSpec);
        setBasePostBody(protocol, REQUEST_NETWORK_API.REQUEST_PRODUCT);
        protocol.setParam(HiveKeys.KEY_market_pid_type, pidType);
        if (cachedProductUpdateDate != null) {
            protocol.setParam(HiveKeys.KEY_update_date, cachedProductUpdateDate);
        }
        if (marketProductInfo != null) {
            Iterator<String> itKeys = marketProductInfo.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next);
                protocol.setParam(next, marketProductInfo.opt(next));
            }
        }
        protocol.request(new Function1() { // from class: com.hive.iapv4.IapV4Network$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IapV4Network.product$lambda$14(cachedSpec, handler, callback, (Product) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3, types: [T, com.hive.ResultAPI] */
    /* JADX WARN: Type inference failed for: r11v4, types: [T, com.hive.ResultAPI] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, com.hive.ResultAPI] */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.util.ArrayList] */
    public static final Unit product$lambda$14(IapV4NetworkCache.CachedSpec cachedSpec, Handler handler, final Function3 function3, final Product it) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(it, "it");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        if (it.getResponse().isSuccess()) {
            try {
                JSONArray jSONArrayOptJSONArray = it.getResponse().getContentJSONObject().optJSONArray("product_list");
                String strOptString = it.getResponse().getContentJSONObject().optString("update_date");
                IapV4NetworkCache iapV4NetworkCache = IapV4NetworkCache.INSTANCE;
                Intrinsics.checkNotNull(strOptString);
                JSONArray jSONArrayCompareProductProducts = iapV4NetworkCache.compareProductProducts(cachedSpec, jSONArrayOptJSONArray, strOptString);
                if (jSONArrayCompareProductProducts != null) {
                    int length = jSONArrayCompareProductProducts.length();
                    objectRef2.element = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            String string = jSONArrayCompareProductProducts.getJSONObject(i).toString();
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            objM7415constructorimpl = Result.m7415constructorimpl(new IAPV4.IAPV4Product(string));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                        }
                        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                        if (thM7418exceptionOrNullimpl != null) {
                            LoggerImpl.INSTANCE.e("create IAPV4Product Exception: " + thM7418exceptionOrNullimpl);
                        }
                        if (Result.m7422isSuccessimpl(objM7415constructorimpl)) {
                            ((ArrayList) objectRef2.element).add((IAPV4.IAPV4Product) objM7415constructorimpl);
                        }
                    }
                    if (((ArrayList) objectRef2.element).isEmpty()) {
                        IapV4NetworkCache.INSTANCE.removeCachedProducts(cachedSpec);
                        objectRef.element = new ResultAPI(-8, ResultAPI.Code.IAPV4EmptyProductList, "product info is empty");
                    }
                } else {
                    objectRef.element = new ResultAPI(-8, ResultAPI.Code.IAPV4EmptyProductList, "merged Products info is empty");
                }
            } catch (Exception e) {
                String str = "create ResponseProduct Exception: " + e + ", \noriginal: " + it.getResponse();
                LoggerImpl.INSTANCE.wL(str);
                objectRef.element = new ResultAPI(-5, ResultAPI.Code.IAPV4ResponseError, str);
                LoggerImpl.INSTANCE.wR("create ResponseProduct Exception: " + e);
            }
        }
        handler.post(new Runnable() { // from class: com.hive.iapv4.IapV4Network$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                IapV4Network.product$lambda$14$lambda$13(function3, objectRef, it, objectRef2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void product$lambda$14$lambda$13(Function3 function3, Ref.ObjectRef objectRef, Product product, Ref.ObjectRef objectRef2) {
        ResultAPI resultAPI = (ResultAPI) objectRef.element;
        if (resultAPI == null) {
            resultAPI = INSTANCE.toResultAPI(product.getResponse());
        }
        function3.invoke(resultAPI, product, objectRef2.element);
    }

    public static /* synthetic */ Object purchase$hive_iapv4_base_release$default(IapV4Network iapV4Network, REQUEST_NETWORK_API request_network_api, JSONObject jSONObject, IAPV4.IAPV4Receipt iAPV4Receipt, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            iAPV4Receipt = null;
        }
        return iapV4Network.purchase$hive_iapv4_base_release(request_network_api, jSONObject, iAPV4Receipt, continuation);
    }

    public final Object purchase$hive_iapv4_base_release(REQUEST_NETWORK_API request_network_api, JSONObject jSONObject, IAPV4.IAPV4Receipt iAPV4Receipt, Continuation<? super Purchase> continuation) throws JSONException {
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<Purchase>() { // from class: com.hive.iapv4.IapV4Network$purchase$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.iapv4.Purchase] */
            @Override // kotlin.jvm.functions.Function0
            public final Purchase invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Purchase.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        setBasePostBody(protocol, request_network_api);
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next);
                protocol.setParam(next, jSONObject.opt(next));
            }
        }
        Purchase purchase = (Purchase) protocol.request();
        Analytics.AnalyticsRevenue analyticsRevenueCreateAnalyticsRevenue$hive_iapv4_base_release = (iAPV4Receipt == null || request_network_api != REQUEST_NETWORK_API.REQUEST_POST_PURCHASE) ? null : IapV4Impl.INSTANCE.createAnalyticsRevenue$hive_iapv4_base_release(iAPV4Receipt);
        if (!sendAnalyticsRevenue$hive_iapv4_base_release(purchase.getResponse().getIapV4Result(), purchase.getResponse().getDetailCode(), analyticsRevenueCreateAnalyticsRevenue$hive_iapv4_base_release) && request_network_api != REQUEST_NETWORK_API.REQUEST_PRE_PURCHASE) {
            try {
                Boxing.boxBoolean(IapV4LogSender.INSTANCE.offer(purchase.getCoreRequest().getUrl(), new String(purchase.getCoreRequest().getBody(), Charsets.UTF_8), analyticsRevenueCreateAnalyticsRevenue$hive_iapv4_base_release));
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("[HiveIAPNetwork] " + request_network_api + " Exception: " + e);
            }
        }
        return purchase;
    }

    public final Object restorePurchase(Continuation<? super Pair<ResultAPI, RestorePurchase.RestorePurchaseResponse>> continuation) {
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<RestorePurchase>() { // from class: com.hive.iapv4.IapV4Network$restorePurchase$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.iapv4.RestorePurchase] */
            @Override // kotlin.jvm.functions.Function0
            public final RestorePurchase invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = RestorePurchase.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        setBasePostBody(protocol, REQUEST_NETWORK_API.REQUEST_RESTORE_PURCHASE);
        protocol.setParam(HiveKeys.KEY_is_sandbox, Boxing.boxBoolean(Configuration.INSTANCE.getZone() != HiveZoneType.REAL));
        RestorePurchase.RestorePurchaseResponse response = ((RestorePurchase) protocol.request()).getResponse();
        return new Pair(toResultAPI(response), response);
    }

    public final Object finalizePurchase(String str, String str2, Continuation<? super Pair<ResultAPI, FinalizePurchase.FinalizePurchaseResponse>> continuation) {
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion = Result.INSTANCE;
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_market_pid, str);
            Result.m7415constructorimpl(CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_order_id, str2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Protocol.Companion companion3 = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<FinalizePurchase>() { // from class: com.hive.iapv4.IapV4Network$finalizePurchase$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.iapv4.FinalizePurchase] */
            @Override // kotlin.jvm.functions.Function0
            public final FinalizePurchase invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = FinalizePurchase.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        setBasePostBody(protocol, REQUEST_NETWORK_API.REQUEST_FINALIZE_PURCHASE);
        protocol.setParam(HiveKeys.KEY_hiveiap_receipt, jSONObject);
        protocol.setParam(HiveKeys.KEY_is_sandbox, Boxing.boxBoolean(Configuration.INSTANCE.getZone() != HiveZoneType.REAL));
        FinalizePurchase.FinalizePurchaseResponse response = ((FinalizePurchase) protocol.request()).getResponse();
        return new Pair(toResultAPI(response), response);
    }

    public final void signature(REQUEST_NETWORK_API requestCmd, JSONObject jsonObj, final Function1<? super String, Unit> callback) throws JSONException {
        Intrinsics.checkNotNullParameter(requestCmd, "requestCmd");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<Signature>() { // from class: com.hive.iapv4.IapV4Network$signature$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.iapv4.Signature] */
            @Override // kotlin.jvm.functions.Function0
            public final Signature invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Signature.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        final Handler handler = new Handler(Looper.getMainLooper());
        setBasePostBody(protocol, requestCmd);
        if (jsonObj != null) {
            Iterator<String> itKeys = jsonObj.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next);
                protocol.setParam(next, jsonObj.opt(next));
            }
        }
        protocol.request(new Function1() { // from class: com.hive.iapv4.IapV4Network$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IapV4Network.signature$lambda$20(handler, callback, (Signature) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.String] */
    public static final Unit signature$lambda$20(Handler handler, final Function1 function1, Signature it) {
        Intrinsics.checkNotNullParameter(it, "it");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (it.getResponse().isSuccess()) {
            try {
                objectRef.element = it.getResponse().getContentJSONObject().optString(InAppPurchaseMetaData.KEY_SIGNATURE);
            } catch (Exception e) {
                LoggerImpl.INSTANCE.wL("create ResponseSignature Exception: " + e + ", \noriginal: " + it.getResponse());
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                StringBuilder sb = new StringBuilder("create ResponseSignature Exception: ");
                sb.append(e);
                loggerImpl.wR(sb.toString());
            }
        }
        handler.post(new Runnable() { // from class: com.hive.iapv4.IapV4Network$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                IapV4Network.signature$lambda$20$lambda$19(function1, objectRef);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void signature$lambda$20$lambda$19(Function1 function1, Ref.ObjectRef objectRef) {
        function1.invoke(objectRef.element);
    }

    public final boolean sendAnalyticsRevenue$hive_iapv4_base_release(int iapV4Result, int detailCode, Analytics.AnalyticsRevenue analyticsRevenue) {
        LoggerImpl.INSTANCE.dL("[HiveIAPNetwork] sendAnalyticsRevenue: iapV4Result: " + iapV4Result + ", detailCode: " + detailCode + ", \n                                       " + analyticsRevenue);
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        StringBuilder sb = new StringBuilder("[HiveIAPNetwork] sendAnalyticsRevenue: iapV4Result: ");
        sb.append(iapV4Result);
        sb.append(", detailCode: ");
        sb.append(detailCode);
        sb.append(", analyticsRevenue: ");
        sb.append(analyticsRevenue != null);
        loggerImpl.dR(sb.toString());
        if (iapV4Result != 0) {
            if (iapV4Result != 1000503 && iapV4Result != 1000512) {
                return false;
            }
        } else if (analyticsRevenue != null && detailCode < 2000000) {
            AnalyticsImpl.INSTANCE.sendRevenueEvent(analyticsRevenue);
            LoggerImpl.INSTANCE.d("[HiveIAPNetwork] sendAnalyticsRevenue: sent analytics revenue event.");
        } else {
            LoggerImpl.INSTANCE.d("[HiveIAPNetwork] sendAnalyticsRevenue: skip analytics revenue event.");
        }
        return true;
    }

    private final Protocol<?> setBasePostBody(Protocol<?> protocol, REQUEST_NETWORK_API request_network_api) {
        String uid;
        LoggerImpl.INSTANCE.d("[HiveIAPNetwork] basePostBody");
        String did = HiveLifecycle.INSTANCE.getAccount().getDid();
        HiveLifecycle.HiveAccount account = HiveLifecycle.INSTANCE.getAccount();
        protocol.setParam(HiveKeys.KEY_api, request_network_api.getValue());
        protocol.setParam(HiveKeys.KEY_market_id, IapV4Impl.INSTANCE.getSelectedMarket() == 0 ? JSONObject.NULL : Integer.valueOf(IapV4Impl.INSTANCE.getSelectedMarket()));
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_appversion, Android.INSTANCE.getAppVersion());
        protocol.setParam(HiveKeys.KEY_app_version_display, Android.INSTANCE.getAppVersion());
        protocol.setParam(HiveKeys.KEY_did, did);
        protocol.setParam(HiveKeys.KEY_country, Android.INSTANCE.getCountry());
        protocol.setParam(HiveKeys.KEY_vid_type, account.getVidType());
        protocol.setParam(HiveKeys.KEY_vid, account.getVid());
        String vid = account.getVid();
        if ((vid == null || StringsKt.isBlank(vid)) && (uid = account.getUid()) != null && (!StringsKt.isBlank(uid))) {
            protocol.setParam(HiveKeys.KEY_vid, account.getUid());
        }
        protocol.setParam(HiveKeys.KEY_uid, account.getUid());
        protocol.setParam(HiveKeys.KEY_vid_sessionkey, account.getVidSession());
        protocol.setParam(HiveKeys.KEY_uid_sessionkey, account.getUidSession());
        protocol.setParam(HiveKeys.KEY_device_model, Android.INSTANCE.getDeviceModel());
        protocol.setParam(HiveKeys.KEY_os_version, Android.INSTANCE.getOSVersion());
        protocol.setParam(HiveKeys.KEY_os_api_level, Integer.valueOf(Android.INSTANCE.getOSVersionCode()));
        protocol.setParam(HiveKeys.KEY_api_ver, (Object) 2);
        OauthToken oauthToken = account.getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        return protocol;
    }

    private final void checkGoogleService(final Context context, final Function1<? super Boolean, Unit> callback) {
        LoggerImpl.INSTANCE.i("[HiveIAPNetwork] checkGoogleService");
        new Thread(new Runnable() { // from class: com.hive.iapv4.IapV4Network$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                IapV4Network.checkGoogleService$lambda$23(context, callback);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkGoogleService$lambda$23(Context context, Function1 function1) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            boolean zIsGooglePlayServicesAvailable$default = Android.isGooglePlayServicesAvailable$default(Android.INSTANCE, context, false, 0, 6, null);
            Boolean boolValueOf = Boolean.valueOf(zIsGooglePlayServicesAvailable$default);
            boolValueOf.getClass();
            LoggerImpl.INSTANCE.i("[HiveIAPNetwork] CheckGoogleService, isGooglePlayServicesAvailable: " + zIsGooglePlayServicesAvailable$default);
            function1.invoke(boolValueOf);
        } catch (PackageManager.NameNotFoundException unused) {
            LoggerImpl.INSTANCE.w("[HiveIAPNetwork] CheckGoogleService, Device does not have package com.android.vending");
            function1.invoke(false);
        }
    }
}
