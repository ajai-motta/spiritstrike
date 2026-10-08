package com.hive.iapv4;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.IAPV4;
import com.hive.ResultAPI;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.iapv4.IapV4Impl;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.iapv4.Product;
import com.hive.standalone.HiveLifecycle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseMarketAPI.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020%H&J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020%H\u0016J,\u0010'\u001a\u00020\u001b2\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010)j\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`*2\u0006\u0010\"\u001a\u00020%H\u0016J*\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\u0006\u0010.\u001a\u00020/2\u0006\u0010\"\u001a\u000200H&J\u0018\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u0002032\u0006\u0010\"\u001a\u000200H\u0016J\u0010\u00104\u001a\u00020\u001b2\u0006\u0010\"\u001a\u000205H&J\u0010\u00106\u001a\u00020\u001b2\u0006\u0010\"\u001a\u000205H\u0016J\u0018\u00107\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010\"\u001a\u000208H&J(\u00109\u001a\u00020\u001b2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u000f0)j\b\u0012\u0004\u0012\u00020\u000f`*2\u0006\u0010\"\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020<H\u0016J(\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020/2\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u001b\u0018\u00010AH\u0016J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010F\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020DH\u0016J*\u0010G\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020D2\u0006\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020/2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010,\u001a\u00020\u000fJ>\u0010L\u001a\u00020\u001b\"\b\b\u0000\u0010M*\u00020N2\u0006\u0010O\u001a\u00020\u000f2\u001a\u0010P\u001a\u0016\u0012\u0004\u0012\u0002HM\u0018\u00010)j\n\u0012\u0004\u0012\u0002HM\u0018\u0001`*2\u0006\u0010\"\u001a\u00020%H\u0004J>\u0010Q\u001a\u00020\u001b\"\b\b\u0000\u0010M*\u00020N2\u0006\u0010O\u001a\u00020\u000f2\u001a\u0010P\u001a\u0016\u0012\u0004\u0012\u0002HM\u0018\u00010)j\n\u0012\u0004\u0012\u0002HM\u0018\u0001`*2\u0006\u0010\"\u001a\u00020%H\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR.\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\fR\u0011\u0010\u0018\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006R"}, d2 = {"Lcom/hive/iapv4/BaseMarketAPI;", "", "<init>", "()V", "market", "Lcom/hive/iapv4/IapV4Impl$IAPV4Market;", "getMarket", "()Lcom/hive/iapv4/IapV4Impl$IAPV4Market;", "setMarket", "(Lcom/hive/iapv4/IapV4Impl$IAPV4Market;)V", "isMarketValueInitialized", "", "()Z", "consumableProductList", "Ljava/util/HashMap;", "", "Lcom/hive/IAPV4$IAPV4Product;", "Lkotlin/collections/HashMap;", "subscriptionProductList", "value", "isInitialized", "setInitialized", "(Z)V", "isGetConsumableProductList", "isGetSubscriptionProductList", "interworkIapUpdatedListener", "Lkotlin/Function0;", "", "getInterworkIapUpdatedListener", "()Lkotlin/jvm/functions/Function0;", "marketUserId", "getMarketUserId", "()Ljava/lang/String;", "marketConnect", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/IAPV4$IAPV4MarketInfoListener;", "getProductInfo", "Lcom/hive/IAPV4$IAPV4ProductInfoListener;", "getSubscriptionProductInfo", "getMarketProductInfo", "marketPidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "purchase", "marketPid", "iapPayload", "quantity", "", "Lcom/hive/IAPV4$IAPV4PurchaseListener;", "purchaseSubscription", "param", "Lcom/hive/IAPV4$IAPV4PurchaseParam;", "restore", "Lcom/hive/IAPV4$IAPV4RestoreListener;", "restoreSubscription", "transactionFinish", "Lcom/hive/IAPV4$IAPV4TransactionFinishListener;", "transactionMultiFinish", "Lcom/hive/IAPV4$IAPV4TransactionMultiFinishListener;", "getBalanceInfo", "Lcom/hive/IAPV4$IAPV4BalanceInfoListener;", "showMarketSelection", "showCharge", "showInAppMessages", "categoryId", "Lkotlin/Function1;", "onResume", "activity", "Landroid/app/Activity;", "onPause", "onDestroy", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "internalProductInfo", "T", "Lcom/hive/iapv4/MarketProduct;", "subLogTag", "baseStoreProducts", "internalSubscriptionProductInfo", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseMarketAPI {
    private HashMap<String, IAPV4.IAPV4Product> consumableProductList;
    private final Function0<Unit> interworkIapUpdatedListener = new Function0() { // from class: com.hive.iapv4.BaseMarketAPI$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BaseMarketAPI.interworkIapUpdatedListener$lambda$0();
        }
    };
    private boolean isInitialized;
    public IapV4Impl.IAPV4Market market;
    private final String marketUserId;
    private HashMap<String, IAPV4.IAPV4Product> subscriptionProductList;

    public abstract void getProductInfo(IAPV4.IAPV4ProductInfoListener listener);

    public abstract void marketConnect(IAPV4.IAPV4MarketInfoListener listener);

    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public abstract void purchase(String marketPid, String iapPayload, int quantity, IAPV4.IAPV4PurchaseListener listener);

    public abstract void restore(IAPV4.IAPV4RestoreListener listener);

    public abstract void transactionFinish(String marketPid, IAPV4.IAPV4TransactionFinishListener listener);

    public final IapV4Impl.IAPV4Market getMarket() {
        IapV4Impl.IAPV4Market iAPV4Market = this.market;
        if (iAPV4Market != null) {
            return iAPV4Market;
        }
        Intrinsics.throwUninitializedPropertyAccessException("market");
        return null;
    }

    public final void setMarket(IapV4Impl.IAPV4Market iAPV4Market) {
        Intrinsics.checkNotNullParameter(iAPV4Market, "<set-?>");
        this.market = iAPV4Market;
    }

    public final boolean isMarketValueInitialized() {
        return this.market != null;
    }

    /* JADX INFO: renamed from: isInitialized, reason: from getter */
    public final boolean getIsInitialized() {
        return this.isInitialized;
    }

    protected final void setInitialized(boolean z) {
        this.isInitialized = z;
    }

    public final boolean isGetConsumableProductList() {
        HashMap<String, IAPV4.IAPV4Product> map = this.consumableProductList;
        return map != null && (map.isEmpty() ^ true);
    }

    public final boolean isGetSubscriptionProductList() {
        HashMap<String, IAPV4.IAPV4Product> map = this.subscriptionProductList;
        return map != null && (map.isEmpty() ^ true);
    }

    public final Function0<Unit> getInterworkIapUpdatedListener() {
        return this.interworkIapUpdatedListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit interworkIapUpdatedListener$lambda$0() {
        HiveLifecycle.INSTANCE.onProcessUri("interwork://hive/iapupdated");
        return Unit.INSTANCE;
    }

    public String getMarketUserId() {
        return this.marketUserId;
    }

    public void getSubscriptionProductInfo(IAPV4.IAPV4ProductInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(null, "[HiveIAP] NotSupportMarket getSubscriptionProductInfo");
        listener.onIAPV4ProductInfo(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), null, 0);
    }

    public void getMarketProductInfo(ArrayList<String> marketPidList, IAPV4.IAPV4ProductInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(null, "[HiveIAP] NotSupportMarket getMarketProductInfo");
        listener.onIAPV4ProductInfo(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), null, 0);
    }

    public void purchaseSubscription(IAPV4.IAPV4PurchaseParam param, IAPV4.IAPV4PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(null, "[HiveIAP] NotSupportMarket purchaseSubscription");
        listener.onIAPV4Purchase(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), null);
    }

    public void restoreSubscription(IAPV4.IAPV4RestoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(null, "[HiveIAP] NotSupportMarket restoreSubscription");
        listener.onIAPV4Restore(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), null);
    }

    public void transactionMultiFinish(ArrayList<String> marketPidList, IAPV4.IAPV4TransactionMultiFinishListener listener) {
        Intrinsics.checkNotNullParameter(marketPidList, "marketPidList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(null, "[HiveIAP] NotSupportMarket transactionMultiFinish");
        ArrayList<ResultAPI> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = marketPidList;
        if (!arrayList2.isEmpty()) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"));
            }
        } else {
            arrayList.add(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"));
        }
        listener.onIAPV4TransactionMultiFinish(arrayList, marketPidList);
    }

    public void getBalanceInfo(IAPV4.IAPV4BalanceInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(null, "[HiveIAP] NotSupportMarket balance");
        listener.onIAPV4Balance(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), 0);
    }

    public void showMarketSelection(IAPV4.IAPV4MarketInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(null, "[HiveIAP] NotSupportMarket showPayment");
        listener.onIAPV4MarketInfo(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), null);
    }

    public void showCharge(IAPV4.IAPV4BalanceInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(null, "[HiveIAP] NotSupportMarket showCharge");
        listener.onIAPV4Balance(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showInAppMessages$default(BaseMarketAPI baseMarketAPI, int i, Function1 function1, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInAppMessages");
        }
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        baseMarketAPI.showInAppMessages(i, function1);
    }

    public void showInAppMessages(int categoryId, Function1<? super Integer, Unit> listener) {
        LoggerImpl.INSTANCE.w(null, "[HiveIAP] NotSupportMarket showInAppMessages");
        if (listener != null) {
            listener.invoke(-96);
        }
    }

    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.isInitialized = false;
    }

    public final IAPV4.IAPV4Product getProductInfo(String marketPid) {
        HashMap<String, IAPV4.IAPV4Product> map;
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        LoggerImpl.INSTANCE.d("[HiveIAP] getProductInfo (marketPid) :" + marketPid);
        if (!isGetConsumableProductList() && !isGetSubscriptionProductList()) {
            LoggerImpl.INSTANCE.w(null, "[HiveIAP] getProductInfo error : product list is null. plz first getProductInfo()");
            return null;
        }
        IAPV4.IAPV4Product iAPV4Product = (!isGetConsumableProductList() || (map = this.consumableProductList) == null) ? null : map.get(marketPid);
        if (iAPV4Product != null) {
            return iAPV4Product;
        }
        if (isGetSubscriptionProductList()) {
            HashMap<String, IAPV4.IAPV4Product> map2 = this.subscriptionProductList;
            iAPV4Product = map2 != null ? map2.get(marketPid) : null;
        }
        if (iAPV4Product != null) {
            return iAPV4Product;
        }
        LoggerImpl.INSTANCE.w("[HiveIAP] getProductInfo error : product list is null. plz first getProductInfo()");
        return null;
    }

    protected final <T extends MarketProduct> void internalProductInfo(final String subLogTag, final ArrayList<T> baseStoreProducts, final IAPV4.IAPV4ProductInfoListener listener) throws JSONException {
        Intrinsics.checkNotNullParameter(subLogTag, "subLogTag");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] internal " + subLogTag + " productInfo");
        final Handler handler = new Handler(Looper.getMainLooper());
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (baseStoreProducts != null) {
            try {
                Iterator<T> it = baseStoreProducts.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    T next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    jSONArray.put(next.toJSONObject());
                }
            } catch (JSONException e) {
                LoggerImpl.INSTANCE.w("[HiveIAP] " + subLogTag + " productInfo Error : " + e);
                handler.post(new Runnable() { // from class: com.hive.iapv4.BaseMarketAPI$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseMarketAPI.internalProductInfo$lambda$1(listener, subLogTag, e);
                    }
                });
                return;
            }
        }
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_market_product_list, jSONArray);
        IapV4Network.INSTANCE.product$hive_iapv4_base_release("consumable", jSONObject, new Function3() { // from class: com.hive.iapv4.BaseMarketAPI$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BaseMarketAPI.internalProductInfo$lambda$5(subLogTag, this, handler, baseStoreProducts, listener, (ResultAPI) obj, (Product) obj2, (ArrayList) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalProductInfo$lambda$1(IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener, String str, JSONException jSONException) {
        iAPV4ProductInfoListener.onIAPV4ProductInfo(new ResultAPI(-1, ResultAPI.Code.IAPV4ProductInfoJsonException, "[HiveIAP] " + str + " productInfo Error : " + jSONException), null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit internalProductInfo$lambda$5(java.lang.String r5, com.hive.iapv4.BaseMarketAPI r6, android.os.Handler r7, java.util.ArrayList r8, final com.hive.IAPV4.IAPV4ProductInfoListener r9, final com.hive.ResultAPI r10, com.hive.protocol.iapv4.Product r11, java.util.ArrayList r12) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.BaseMarketAPI.internalProductInfo$lambda$5(java.lang.String, com.hive.iapv4.BaseMarketAPI, android.os.Handler, java.util.ArrayList, com.hive.IAPV4$IAPV4ProductInfoListener, com.hive.ResultAPI, com.hive.protocol.iapv4.Product, java.util.ArrayList):kotlin.Unit");
    }

    protected final <T extends MarketProduct> void internalSubscriptionProductInfo(final String subLogTag, final ArrayList<T> baseStoreProducts, final IAPV4.IAPV4ProductInfoListener listener) throws JSONException {
        Intrinsics.checkNotNullParameter(subLogTag, "subLogTag");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] internal " + subLogTag + " productInfo");
        final Handler handler = new Handler(Looper.getMainLooper());
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (baseStoreProducts != null) {
            try {
                Iterator<T> it = baseStoreProducts.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    T next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    jSONArray.put(next.toJSONObject());
                }
            } catch (JSONException e) {
                LoggerImpl.INSTANCE.w("[HiveIAP] " + subLogTag + " productInfo Error : " + e);
                handler.post(new Runnable() { // from class: com.hive.iapv4.BaseMarketAPI$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseMarketAPI.internalSubscriptionProductInfo$lambda$6(listener, subLogTag, e);
                    }
                });
                return;
            }
        }
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_market_product_list, jSONArray);
        IapV4Network.INSTANCE.product$hive_iapv4_base_release(FirebaseAnalytics.Param.SUBSCRIPTION, jSONObject, new Function3() { // from class: com.hive.iapv4.BaseMarketAPI$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BaseMarketAPI.internalSubscriptionProductInfo$lambda$10(subLogTag, this, handler, baseStoreProducts, listener, (ResultAPI) obj, (Product) obj2, (ArrayList) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalSubscriptionProductInfo$lambda$6(IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener, String str, JSONException jSONException) {
        iAPV4ProductInfoListener.onIAPV4ProductInfo(new ResultAPI(-1, ResultAPI.Code.IAPV4ProductInfoJsonException, "[HiveIAP] " + str + " productInfo Error : " + jSONException), null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit internalSubscriptionProductInfo$lambda$10(java.lang.String r5, com.hive.iapv4.BaseMarketAPI r6, android.os.Handler r7, java.util.ArrayList r8, final com.hive.IAPV4.IAPV4ProductInfoListener r9, final com.hive.ResultAPI r10, com.hive.protocol.iapv4.Product r11, java.util.ArrayList r12) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.BaseMarketAPI.internalSubscriptionProductInfo$lambda$10(java.lang.String, com.hive.iapv4.BaseMarketAPI, android.os.Handler, java.util.ArrayList, com.hive.IAPV4$IAPV4ProductInfoListener, com.hive.ResultAPI, com.hive.protocol.iapv4.Product, java.util.ArrayList):kotlin.Unit");
    }
}
