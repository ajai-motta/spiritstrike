package com.hive;

import android.util.Base64;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.hive.base.Android;
import com.hive.base.DataModel;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HiveIapV4;
import com.hive.module.interfaces.iapv4.market.MarketLebi;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.Resource;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001:\fFGHIJKLMNOPQB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0007J,\u0010\u0016\u001a\u00020\u00102\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00192\u0006\u0010\u0011\u001a\u00020\u0014H\u0007J\"\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u001dH\u0007J*\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u001dH\u0007J,\u0010 \u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u001dH\u0007J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u001dH\u0007J2\u0010%\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u001dH\u0007J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020(H\u0007J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020(H\u0007J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020(H\u0007J\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020,H\u0007J\u0018\u0010-\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020,H\u0007J(\u0010.\u001a\u00020\u00102\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0018j\b\u0012\u0004\u0012\u00020\u0005`\u00192\u0006\u0010\u0011\u001a\u00020/H\u0007J\u0010\u00100\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u00101\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u000202H\u0007J\u0010\u00103\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u000202H\u0007J\u0010\u00104\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u000205H\u0007J\u0010\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0005H\u0007J\b\u00108\u001a\u000209H\u0007J\n\u0010:\u001a\u0004\u0018\u00010\u0005H\u0007J(\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u001f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0010\u0018\u00010=H\u0007J\u0012\u0010>\u001a\u00020\u00102\b\u0010?\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010@\u001a\u00020\u0005H\u0007J\u0012\u0010A\u001a\u00020\u00102\b\u0010B\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010C\u001a\u00020\u0005H\u0007J\u0012\u0010D\u001a\u00020\u00102\b\u0010E\u001a\u0004\u0018\u00010\u0005H\u0007R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006R"}, d2 = {"Lcom/hive/IAPV4;", "", "<init>", "()V", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "hiveIapV4", "Lcom/hive/module/interfaces/HiveIapV4;", "getHiveIapV4", "()Lcom/hive/module/interfaces/HiveIapV4;", "hiveIapV4$delegate", "Lkotlin/Lazy;", "marketConnect", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/IAPV4$IAPV4MarketInfoListener;", "getProductInfo", "Lcom/hive/IAPV4$IAPV4ProductInfoListener;", "getSubscriptionProductInfo", "getMarketProductInfo", "marketPidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "purchase", "marketPid", "iapPayload", "Lcom/hive/IAPV4$IAPV4PurchaseListener;", "quantity", "", "purchaseSubscriptionUpdate", "oldMarketPid", "purchaseSubscription", "param", "Lcom/hive/IAPV4$IAPV4PurchaseParam;", "voidPurchase", "refundIndex", "restore", "Lcom/hive/IAPV4$IAPV4RestoreListener;", "restoreSubscription", "voidRestore", "transactionFinish", "Lcom/hive/IAPV4$IAPV4TransactionFinishListener;", "voidTransactionFinish", "transactionMultiFinish", "Lcom/hive/IAPV4$IAPV4TransactionMultiFinishListener;", "showMarketSelection", "getBalanceInfo", "Lcom/hive/IAPV4$IAPV4BalanceInfoListener;", "showCharge", "checkPromotePurchase", "Lcom/hive/IAPV4$IAPV4CheckPromotePurchaseListener;", "setPromotePurchaseMarketPid", "marketPID", "getSelectedMarket", "Lcom/hive/IAPV4$IAPV4Type;", "getAccountUuid", "showInAppMessages", "categoryId", "Lkotlin/Function1;", "setUid", "uid", "getWechatAppId", "setWechatAppId", "wechatAppId", "getWechatPaymentKey", "setWechatPaymentKey", "wechatPaymentKey", "IAPV4MarketInfoListener", "IAPV4ProductInfoListener", "IAPV4PurchaseListener", "IAPV4RestoreListener", "IAPV4TransactionFinishListener", "IAPV4TransactionMultiFinishListener", "IAPV4BalanceInfoListener", "IAPV4CheckPromotePurchaseListener", "IAPV4Type", "IAPV4Product", "IAPV4Receipt", "IAPV4PurchaseParam", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IAPV4 {
    public static final IAPV4 INSTANCE = new IAPV4();
    private static final String TAG;

    /* JADX INFO: renamed from: hiveIapV4$delegate, reason: from kotlin metadata */
    private static final Lazy hiveIapV4;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/IAPV4$IAPV4BalanceInfoListener;", "", "onIAPV4Balance", "", "result", "Lcom/hive/ResultAPI;", "balance", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IAPV4BalanceInfoListener {
        void onIAPV4Balance(ResultAPI result, int balance);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/IAPV4$IAPV4CheckPromotePurchaseListener;", "", "onIAPV4CheckPromotePurchase", "", "result", "Lcom/hive/ResultAPI;", "marketPid", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IAPV4CheckPromotePurchaseListener {
        void onIAPV4CheckPromotePurchase(ResultAPI result, String marketPid);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/IAPV4$IAPV4MarketInfoListener;", "", "onIAPV4MarketInfo", "", "result", "Lcom/hive/ResultAPI;", "iapV4TypeList", "Ljava/util/ArrayList;", "Lcom/hive/IAPV4$IAPV4Type;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IAPV4MarketInfoListener {
        void onIAPV4MarketInfo(ResultAPI result, ArrayList<IAPV4Type> iapV4TypeList);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/hive/IAPV4$IAPV4ProductInfoListener;", "", "onIAPV4ProductInfo", "", "result", "Lcom/hive/ResultAPI;", "iapV4ProductList", "Ljava/util/ArrayList;", "Lcom/hive/IAPV4$IAPV4Product;", "Lkotlin/collections/ArrayList;", "balance", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IAPV4ProductInfoListener {
        void onIAPV4ProductInfo(ResultAPI result, ArrayList<IAPV4Product> iapV4ProductList, int balance);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/IAPV4$IAPV4PurchaseListener;", "", "onIAPV4Purchase", "", "result", "Lcom/hive/ResultAPI;", "iapV4Receipt", "Lcom/hive/IAPV4$IAPV4Receipt;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IAPV4PurchaseListener {
        void onIAPV4Purchase(ResultAPI result, IAPV4Receipt iapV4Receipt);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0010B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u0003J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/hive/IAPV4$IAPV4PurchaseParam;", "", "marketPid", "", "oldMarketPid", "iapPayload", "offerToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMarketPid", "()Ljava/lang/String;", "getOldMarketPid", "getIapPayload", "getOfferToken", "toJson", InAppPurchaseConstants.METHOD_TO_STRING, "Builder", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IAPV4PurchaseParam {
        private final String iapPayload;
        private final String marketPid;
        private final String offerToken;
        private final String oldMarketPid;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0017R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\"\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/hive/IAPV4$IAPV4PurchaseParam$Builder;", "", "<init>", "()V", "value", "", "marketPid", "getMarketPid", "()Ljava/lang/String;", "oldMarketPid", "getOldMarketPid", "iapPayload", "getIapPayload", "offerToken", "getOfferToken", "setMarketPid", TtmlNode.TAG_P, "setOldMarketPid", "setIapPayload", "setOfferToken", "setFromJson", "source", InAppPurchaseConstants.METHOD_BUILD, "Lcom/hive/IAPV4$IAPV4PurchaseParam;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Builder {
            private String iapPayload;
            private String marketPid = "";
            private String offerToken;
            private String oldMarketPid;

            public final IAPV4PurchaseParam build() {
                return new IAPV4PurchaseParam(this.marketPid, this.oldMarketPid, this.iapPayload, this.offerToken, null);
            }

            public final String getIapPayload() {
                return this.iapPayload;
            }

            public final String getMarketPid() {
                return this.marketPid;
            }

            public final String getOfferToken() {
                return this.offerToken;
            }

            public final String getOldMarketPid() {
                return this.oldMarketPid;
            }

            public final Builder setFromJson(String source) {
                Intrinsics.checkNotNullParameter(source, "source");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONObject jSONObject = new JSONObject(source);
                    String strOptString = jSONObject.optString("marketPid");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.marketPid = strOptString;
                    this.oldMarketPid = jSONObject.optString("oldMarketPid");
                    this.iapPayload = jSONObject.optString("iapPayload");
                    this.offerToken = jSONObject.optString("offerToken");
                    Result.m7415constructorimpl(Unit.INSTANCE);
                    return this;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m7415constructorimpl(ResultKt.createFailure(th));
                    return this;
                }
            }

            public final Builder setIapPayload(String p) {
                this.iapPayload = p;
                return this;
            }

            public final Builder setMarketPid(String p) {
                Intrinsics.checkNotNullParameter(p, "p");
                this.marketPid = p;
                return this;
            }

            public final Builder setOfferToken(String p) {
                this.offerToken = p;
                return this;
            }

            public final Builder setOldMarketPid(String p) {
                this.oldMarketPid = p;
                return this;
            }
        }

        public /* synthetic */ IAPV4PurchaseParam(String str, String str2, String str3, String str4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4);
        }

        public final String getIapPayload() {
            return this.iapPayload;
        }

        public final String getMarketPid() {
            return this.marketPid;
        }

        public final String getOfferToken() {
            return this.offerToken;
        }

        public final String getOldMarketPid() {
            return this.oldMarketPid;
        }

        public final String toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("marketPid", this.marketPid);
            String str = this.oldMarketPid;
            if (str == null) {
                str = "";
            }
            jSONObject.put("oldMarketPid", str);
            String str2 = this.iapPayload;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("iapPayload", str2);
            String str3 = this.offerToken;
            jSONObject.put("offerToken", str3 != null ? str3 : "");
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public String toString() {
            return "[PurchaseParam]\n    marketPid: " + this.marketPid + "\n    oldMarketPid: " + this.oldMarketPid + "\n    iapPayload: " + this.iapPayload + "\n    offerToken: " + this.offerToken + '\n';
        }

        private IAPV4PurchaseParam(String str, String str2, String str3, String str4) {
            this.marketPid = str;
            this.oldMarketPid = str2;
            this.iapPayload = str3;
            this.offerToken = str4;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010+\u001a\u00020,J\b\u0010*\u001a\u00020\u0013H\u0004J\b\u0010-\u001a\u00020\u0013H\u0016J\b\u0010.\u001a\u00020%H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0016R\u0012\u0010\"\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0016R\u0012\u0010$\u001a\u00020%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@dX¦\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018¨\u0006/"}, d2 = {"Lcom/hive/IAPV4$IAPV4Receipt;", "Lcom/hive/base/DataModel;", "type", "Lcom/hive/IAPV4$IAPV4Type;", AppLovinEventTypes.USER_VIEWED_PRODUCT, "Lcom/hive/IAPV4$IAPV4Product;", "receiptLevel", "", "<init>", "(Lcom/hive/IAPV4$IAPV4Type;Lcom/hive/IAPV4$IAPV4Product;I)V", "getType", "()Lcom/hive/IAPV4$IAPV4Type;", "getProduct", "()Lcom/hive/IAPV4$IAPV4Product;", "getReceiptLevel", "()I", "quantity", "getQuantity", "value", "", "iapPayload", "getIapPayload", "()Ljava/lang/String;", "setIapPayload", "(Ljava/lang/String;)V", "isRestore", "", "()Z", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "getAccount", "()Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "hiveiapReceipt", "getHiveiapReceipt", "uniqueId", "getUniqueId", "purchaseLog", "Lorg/json/JSONObject;", "getPurchaseLog", "()Lorg/json/JSONObject;", "bypassInfo", "getBypassInfo", "setBypassInfo", "getRevenue", "", InAppPurchaseConstants.METHOD_TO_STRING, "toJSON", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class IAPV4Receipt extends DataModel {
        private final HiveLifecycle.HiveAccount account;
        private String iapPayload;
        private final boolean isRestore;
        private final IAPV4Product product;
        private final int quantity;
        private final int receiptLevel;
        private final IAPV4Type type;

        public IAPV4Receipt(IAPV4Type type, IAPV4Product product, int i) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(product, "product");
            this.type = type;
            this.product = product;
            this.receiptLevel = i;
            this.quantity = 1;
            this.isRestore = true;
            this.account = HiveLifecycle.INSTANCE.getAccount();
        }

        public HiveLifecycle.HiveAccount getAccount() {
            return this.account;
        }

        public abstract String getBypassInfo();

        public abstract String getHiveiapReceipt();

        public String getIapPayload() {
            return this.iapPayload;
        }

        public final IAPV4Product getProduct() {
            return this.product;
        }

        public abstract JSONObject getPurchaseLog();

        public int getQuantity() {
            return this.quantity;
        }

        public final int getReceiptLevel() {
            return this.receiptLevel;
        }

        public final double getRevenue() {
            return this.product.getPrice() * ((double) getQuantity());
        }

        public final IAPV4Type getType() {
            return this.type;
        }

        public abstract String getUniqueId();

        /* JADX INFO: renamed from: isRestore, reason: from getter */
        public boolean getIsRestore() {
            return this.isRestore;
        }

        public final String setBypassInfo() {
            Object objM7415constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_market_id, Integer.valueOf(this.type.getValue()));
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                com.hive.core.Configuration configuration = com.hive.core.Configuration.INSTANCE;
                CommonIdentifierKt.put(jSONObject, hiveKeys, configuration.getAppId());
                HiveKeys hiveKeys2 = HiveKeys.KEY_appversion;
                Android android2 = Android.INSTANCE;
                CommonIdentifierKt.put(jSONObject, hiveKeys2, android2.getAppVersion());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_app_version_display, android2.getAppVersion());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_did, getAccount().getDid());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_hive_country, configuration.getHiveCountry());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_country, android2.getCountry());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_language, android2.getLanguage());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_game_language, configuration.getGameLanguage());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_vid, getAccount().getVid());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_vid_type, getAccount().getVidType());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_uid, getAccount().getUid());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_server_id, configuration.getServerId());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_device_model, android2.getDeviceModel());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_os_version, android2.getOSVersion());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_os_api_level, Integer.valueOf(android2.getOSVersionCode()));
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_sdk_version, configuration.getSdkVersion());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_price, Double.valueOf(this.product.getPrice()));
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_original_price, Double.valueOf(this.product.getOriginalPrice()));
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_currency, this.product.getCurrency());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_market_pid, this.product.getMarketPid());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_hiveiap_receipt, getHiveiapReceipt());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_receipt_level, Integer.valueOf(this.receiptLevel));
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_hive_timezone, configuration.getTimezone());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_analytics_id, configuration.getAnalyticsId());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_quantity, Integer.valueOf(getQuantity()));
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_iap_payload, getIapPayload());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_account_uuid, getAccount().getAccountUuid());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_request_type, Integer.valueOf(getIsRestore() ? 2 : 1));
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_product_type, this.product.getProductType());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_revenue, Double.valueOf(getRevenue()));
                objM7415constructorimpl = Result.m7415constructorimpl(jSONObject);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            JSONObject jSONObject2 = new JSONObject();
            if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
                objM7415constructorimpl = jSONObject2;
            }
            String string = ((JSONObject) objM7415constructorimpl).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            return strEncodeToString;
        }

        public abstract void setBypassInfo(String str);

        public void setIapPayload(String str) {
            this.iapPayload = str;
        }

        @Override // com.hive.base.DataModel
        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.type.name());
                jSONObject.put(AppLovinEventTypes.USER_VIEWED_PRODUCT, this.product.toJSON());
                jSONObject.put("quantity", getQuantity());
                jSONObject.put(AnalyticsProviderAdjust.EventKeys.revenue, getRevenue());
                jSONObject.put("iapPayload", getIapPayload());
                jSONObject.put("hiveiapReceipt", getHiveiapReceipt());
                jSONObject.put("bypassInfo", getBypassInfo());
                return jSONObject;
            } catch (Exception e) {
                e.printStackTrace();
                return jSONObject;
            }
        }

        @Override // com.hive.base.DataModel
        public String toString() {
            return "[IAPV4Receipt " + this.type + "]\n    type: " + this.type + "\n    product: " + this.product + "\n    quantity: " + getQuantity() + "\n    revenue: " + getRevenue() + "\n    iapPayload: " + getIapPayload() + "\n    hiveiapReceipt: " + getHiveiapReceipt() + '\n';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/IAPV4$IAPV4RestoreListener;", "", "onIAPV4Restore", "", "result", "Lcom/hive/ResultAPI;", "iapv4ReceiptList", "Ljava/util/ArrayList;", "Lcom/hive/IAPV4$IAPV4Receipt;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IAPV4RestoreListener {
        void onIAPV4Restore(ResultAPI result, ArrayList<IAPV4Receipt> iapv4ReceiptList);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/IAPV4$IAPV4TransactionFinishListener;", "", "onIAPV4TransactionFinish", "", "result", "Lcom/hive/ResultAPI;", "marketPid", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IAPV4TransactionFinishListener {
        void onIAPV4TransactionFinish(ResultAPI result, String marketPid);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007H&¨\u0006\n"}, d2 = {"Lcom/hive/IAPV4$IAPV4TransactionMultiFinishListener;", "", "onIAPV4TransactionMultiFinish", "", "resultList", "Ljava/util/ArrayList;", "Lcom/hive/ResultAPI;", "Lkotlin/collections/ArrayList;", "marketPidList", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IAPV4TransactionMultiFinishListener {
        void onIAPV4TransactionMultiFinish(ArrayList<ResultAPI> resultList, ArrayList<String> marketPidList);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001 B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001f\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001ej\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006!"}, d2 = {"Lcom/hive/IAPV4$IAPV4Type;", "", "value", "", "displayName", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "NOT_SELECTED", "APPLE_APPSTORE", "GOOGLE_PLAYSTORE", "HIVE_LEBI", "ONESTORE", "AMAZON_APPSTORE", "SAMSUNG_GALAXYSTORE", "HUAWEI_APPGALLERY", "FUNTAP", "OPPO_APPMARKET", "VIVO_APPSTORE", "TENCENT_MYAPP", "XIAOMI_APPSTORE", "HUAWEI_APPGALLERY_CHINA", "FACEBOOK_CLOUD_GAME", "HIVESTORE", "STEAM", "NOWGG", "stringValue", "getStringValue", "()Ljava/lang/String;", "getDisplayName", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IAPV4Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ IAPV4Type[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String displayName;
        private final int value;
        public static final IAPV4Type NOT_SELECTED = new IAPV4Type("NOT_SELECTED", 0, 0, "Unknown Store");
        public static final IAPV4Type APPLE_APPSTORE = new IAPV4Type("APPLE_APPSTORE", 1, 1, "Apple App Store");
        public static final IAPV4Type GOOGLE_PLAYSTORE = new IAPV4Type("GOOGLE_PLAYSTORE", 2, 2, "Google Play Store");
        public static final IAPV4Type HIVE_LEBI = new IAPV4Type("HIVE_LEBI", 3, 3, "Hive Lebi");
        public static final IAPV4Type ONESTORE = new IAPV4Type("ONESTORE", 4, 4, "OneStore");
        public static final IAPV4Type AMAZON_APPSTORE = new IAPV4Type("AMAZON_APPSTORE", 5, 5, "Amazon App Store");
        public static final IAPV4Type SAMSUNG_GALAXYSTORE = new IAPV4Type("SAMSUNG_GALAXYSTORE", 6, 6, "Samsung Galaxy Store");
        public static final IAPV4Type HUAWEI_APPGALLERY = new IAPV4Type("HUAWEI_APPGALLERY", 7, 7, "Huawei App Gallery");
        public static final IAPV4Type FUNTAP = new IAPV4Type("FUNTAP", 8, 8, "Funtap");
        public static final IAPV4Type OPPO_APPMARKET = new IAPV4Type("OPPO_APPMARKET", 9, 9, "OPPO App Market");
        public static final IAPV4Type VIVO_APPSTORE = new IAPV4Type("VIVO_APPSTORE", 10, 10, "VIVO App Store");
        public static final IAPV4Type TENCENT_MYAPP = new IAPV4Type("TENCENT_MYAPP", 11, 11, "Tencent Myapp");
        public static final IAPV4Type XIAOMI_APPSTORE = new IAPV4Type("XIAOMI_APPSTORE", 12, 12, "Xiaomi App Store");
        public static final IAPV4Type HUAWEI_APPGALLERY_CHINA = new IAPV4Type("HUAWEI_APPGALLERY_CHINA", 13, 13, "Huawei App Gallery China");

        @Deprecated(message = "24.2.0")
        public static final IAPV4Type FACEBOOK_CLOUD_GAME = new IAPV4Type("FACEBOOK_CLOUD_GAME", 14, 14, "Facebook Cloud Game");
        public static final IAPV4Type HIVESTORE = new IAPV4Type("HIVESTORE", 15, 15, "PG Payment");
        public static final IAPV4Type STEAM = new IAPV4Type("STEAM", 16, 16, "Steam");
        public static final IAPV4Type NOWGG = new IAPV4Type("NOWGG", 17, 17, "Now.gg");

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lcom/hive/IAPV4$IAPV4Type$Companion;", "", "<init>", "()V", "findValue", "Lcom/hive/IAPV4$IAPV4Type;", "marketId", "", "findDisplayName", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final String findDisplayName(int marketId) {
                return findValue(marketId).getDisplayName();
            }

            @JvmStatic
            public final IAPV4Type findValue(int marketId) {
                IAPV4Type iAPV4Type;
                IAPV4Type[] iAPV4TypeArrValues = IAPV4Type.values();
                int length = iAPV4TypeArrValues.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        iAPV4Type = null;
                        break;
                    }
                    iAPV4Type = iAPV4TypeArrValues[i];
                    if (iAPV4Type.getValue() == marketId) {
                        break;
                    }
                    i++;
                }
                return iAPV4Type == null ? IAPV4Type.NOT_SELECTED : iAPV4Type;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ IAPV4Type[] $values() {
            return new IAPV4Type[]{NOT_SELECTED, APPLE_APPSTORE, GOOGLE_PLAYSTORE, HIVE_LEBI, ONESTORE, AMAZON_APPSTORE, SAMSUNG_GALAXYSTORE, HUAWEI_APPGALLERY, FUNTAP, OPPO_APPMARKET, VIVO_APPSTORE, TENCENT_MYAPP, XIAOMI_APPSTORE, HUAWEI_APPGALLERY_CHINA, FACEBOOK_CLOUD_GAME, HIVESTORE, STEAM, NOWGG};
        }

        static {
            IAPV4Type[] iAPV4TypeArr$values = $values();
            $VALUES = iAPV4TypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(iAPV4TypeArr$values);
            INSTANCE = new Companion(null);
        }

        private IAPV4Type(String str, int i, int i2, String str2) {
            this.value = i2;
            this.displayName = str2;
        }

        @JvmStatic
        public static final IAPV4Type findValue(int i) {
            return INSTANCE.findValue(i);
        }

        public static EnumEntries<IAPV4Type> getEntries() {
            return $ENTRIES;
        }

        public static IAPV4Type valueOf(String str) {
            return (IAPV4Type) Enum.valueOf(IAPV4Type.class, str);
        }

        public static IAPV4Type[] values() {
            return (IAPV4Type[]) $VALUES.clone();
        }

        public final String getDisplayName() {
            if (this.value != 15) {
                return this.displayName;
            }
            String string = Resource.INSTANCE.getString("hive_iapv4_pg_payment");
            return string == null ? this.displayName : string;
        }

        public final String getStringValue() {
            return String.valueOf(this.value);
        }

        public final int getValue() {
            return this.value;
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("IAPV4", "getSimpleName(...)");
        TAG = "IAPV4";
        hiveIapV4 = LazyKt.lazy(new Function0() { // from class: com.hive.IAPV4$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IAPV4.hiveIapV4_delegate$lambda$0();
            }
        });
    }

    private IAPV4() {
    }

    @JvmStatic
    public static final void checkPromotePurchase(IAPV4CheckPromotePurchaseListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.checkPromotePurchase(listener);
        } else {
            listener.onIAPV4CheckPromotePurchase(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final String getAccountUuid() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        IAPV4 iapv4 = INSTANCE;
        if (iapv4.getHiveIapV4() == null) {
            loggerImpl.w("IapV4 Library Missing.");
            return null;
        }
        HiveIapV4 hiveIapV42 = iapv4.getHiveIapV4();
        String accountUuid = hiveIapV42 != null ? hiveIapV42.getAccountUuid() : null;
        loggerImpl.apiReturnLog(str, "getAccountUuid : " + accountUuid);
        return accountUuid;
    }

    @JvmStatic
    public static final void getBalanceInfo(IAPV4BalanceInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.getBalanceInfo(listener);
        } else {
            listener.onIAPV4Balance(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), 0);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    private final HiveIapV4 getHiveIapV4() {
        return (HiveIapV4) hiveIapV4.getValue();
    }

    @JvmStatic
    public static final void getMarketProductInfo(ArrayList<String> marketPidList, IAPV4ProductInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.getMarketProductInfo(marketPidList, listener);
        } else {
            listener.onIAPV4ProductInfo(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null, 0);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getProductInfo(IAPV4ProductInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.getProductInfo(listener);
        } else {
            listener.onIAPV4ProductInfo(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null, 0);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final IAPV4Type getSelectedMarket() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        IAPV4Type iAPV4TypeMo5533getSelectedMarket = hiveIapV42 != null ? hiveIapV42.mo5533getSelectedMarket() : null;
        if (iAPV4TypeMo5533getSelectedMarket == null) {
            loggerImpl.w("IapV4 Library Missing.");
            iAPV4TypeMo5533getSelectedMarket = IAPV4Type.NOT_SELECTED;
        }
        loggerImpl.apiReturnLog(str, "getSelectedMarket : " + iAPV4TypeMo5533getSelectedMarket);
        return iAPV4TypeMo5533getSelectedMarket;
    }

    @JvmStatic
    public static final void getSubscriptionProductInfo(IAPV4ProductInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.getSubscriptionProductInfo(listener);
        } else {
            listener.onIAPV4ProductInfo(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null, 0);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    @JvmStatic
    public static final String getWechatAppId() {
        String wechatAppId;
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = MarketLebi.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof MarketLebi)) {
            hiveModule = null;
        }
        MarketLebi marketLebi = (MarketLebi) (hiveModule instanceof MarketLebi ? hiveModule : null);
        if (marketLebi != null && (wechatAppId = marketLebi.getWechatAppId()) != null) {
            return wechatAppId;
        }
        LoggerImpl.INSTANCE.w("MarketLebi Library Missing.");
        return "";
    }

    @JvmStatic
    public static final String getWechatPaymentKey() {
        String wechatPaymentKey;
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = MarketLebi.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof MarketLebi)) {
            hiveModule = null;
        }
        MarketLebi marketLebi = (MarketLebi) (hiveModule instanceof MarketLebi ? hiveModule : null);
        if (marketLebi != null && (wechatPaymentKey = marketLebi.getWechatPaymentKey()) != null) {
            return wechatPaymentKey;
        }
        LoggerImpl.INSTANCE.w("MarketLebi Library Missing.");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HiveIapV4 hiveIapV4_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HiveIapV4.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HiveIapV4)) {
            hiveModule = null;
        }
        return (HiveIapV4) (hiveModule instanceof HiveIapV4 ? hiveModule : null);
    }

    @JvmStatic
    public static final void marketConnect(IAPV4MarketInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.marketConnect(listener);
        } else {
            listener.onIAPV4MarketInfo(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void purchase(String marketPid, String iapPayload, IAPV4PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("marketPid = %s, iapPayload = %s, listener = %s", Arrays.copyOf(new Object[]{marketPid, iapPayload, listener}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.purchase(marketPid, iapPayload, 1, listener);
        } else {
            listener.onIAPV4Purchase(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void purchaseSubscription(IAPV4PurchaseParam param, IAPV4PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String strValueOf = String.valueOf(param);
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, strValueOf);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.purchaseSubscription(param, listener);
        } else {
            listener.onIAPV4Purchase(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null);
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void purchaseSubscriptionUpdate(String marketPid, String oldMarketPid, String iapPayload, IAPV4PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("marketPid = %s, iapPayload = %s, listener = %s", Arrays.copyOf(new Object[]{marketPid, iapPayload != null ? Integer.valueOf(iapPayload.length()) : "", listener}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        IAPV4PurchaseParam iAPV4PurchaseParamBuild = new IAPV4PurchaseParam.Builder().setMarketPid(marketPid).setOldMarketPid(oldMarketPid).setIapPayload(iapPayload).build();
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.purchaseSubscription(iAPV4PurchaseParamBuild, listener);
        } else {
            listener.onIAPV4Purchase(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void restore(IAPV4RestoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.restore(listener);
        } else {
            listener.onIAPV4Restore(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void restoreSubscription(IAPV4RestoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.restoreSubscription(listener);
        } else {
            listener.onIAPV4Restore(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void setPromotePurchaseMarketPid(String marketPID) {
        Intrinsics.checkNotNullParameter(marketPID, "marketPID");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "marketPID : " + marketPID);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.setPromotePurchaseMarketPid(marketPID);
        } else {
            loggerImpl.w("IapV4 Library Missing.");
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void setUid(String uid) {
        HiveLifecycle.INSTANCE.getAccount().setUid(uid);
    }

    @JvmStatic
    public static final void setWechatAppId(String wechatAppId) {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = MarketLebi.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof MarketLebi)) {
            hiveModule = null;
        }
        MarketLebi marketLebi = (MarketLebi) (hiveModule instanceof MarketLebi ? hiveModule : null);
        if (marketLebi == null) {
            LoggerImpl.INSTANCE.w("MarketLebi Library Missing.");
            return;
        }
        if (wechatAppId == null) {
            wechatAppId = "";
        }
        marketLebi.setWechatAppId(wechatAppId);
    }

    @JvmStatic
    public static final void setWechatPaymentKey(String wechatPaymentKey) {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = MarketLebi.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof MarketLebi)) {
            hiveModule = null;
        }
        MarketLebi marketLebi = (MarketLebi) (hiveModule instanceof MarketLebi ? hiveModule : null);
        if (marketLebi == null) {
            LoggerImpl.INSTANCE.w("MarketLebi Library Missing.");
            return;
        }
        if (wechatPaymentKey == null) {
            wechatPaymentKey = "";
        }
        marketLebi.setWechatPaymentKey(wechatPaymentKey);
    }

    @JvmStatic
    public static final void showCharge(IAPV4BalanceInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.showCharge(listener);
        } else {
            listener.onIAPV4Balance(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), 0);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showInAppMessages(int categoryId, Function1<? super Integer, Unit> listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.showInAppMessages(categoryId, listener);
        } else {
            loggerImpl.w("IapV4 Library Missing.");
            if (listener != null) {
                listener.invoke(-97);
            }
        }
        loggerImpl.apiReturnLog(str, "");
    }

    public static /* synthetic */ void showInAppMessages$default(int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        showInAppMessages(i, function1);
    }

    @JvmStatic
    public static final void showMarketSelection(IAPV4MarketInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.showMarketSelection(listener);
        } else {
            listener.onIAPV4MarketInfo(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void transactionFinish(String marketPid, IAPV4TransactionFinishListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("marketPid = %s listener = %s", Arrays.copyOf(new Object[]{marketPid, listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.transactionFinish(marketPid, listener);
        } else {
            listener.onIAPV4TransactionFinish(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), marketPid);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void transactionMultiFinish(ArrayList<String> marketPidList, IAPV4TransactionMultiFinishListener listener) {
        Intrinsics.checkNotNullParameter(marketPidList, "marketPidList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl.INSTANCE.apiCalledLog(TAG, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.transactionMultiFinish(marketPidList, listener);
        } else {
            ArrayList<ResultAPI> arrayList = new ArrayList<>();
            if (marketPidList.isEmpty()) {
                arrayList.add(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"));
            } else {
                int size = marketPidList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"));
                }
            }
            listener.onIAPV4TransactionMultiFinish(arrayList, marketPidList);
        }
        LoggerImpl.INSTANCE.apiReturnLog(TAG, "");
    }

    @JvmStatic
    public static final void voidPurchase(String marketPid, String iapPayload, int quantity, int refundIndex, IAPV4PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "marketPid = " + marketPid + ", iapPayload = " + iapPayload + ", quantity = " + quantity + ", refundIndex = " + refundIndex);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.voidPurchase(marketPid, iapPayload, quantity, refundIndex, listener);
        } else {
            listener.onIAPV4Purchase(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null);
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void voidRestore(IAPV4RestoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.voidRestore(listener);
        } else {
            listener.onIAPV4Restore(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void voidTransactionFinish(String marketPid, IAPV4TransactionFinishListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("marketPid = %s listener = %s", Arrays.copyOf(new Object[]{marketPid, listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.voidTransactionFinish(marketPid, listener);
        } else {
            listener.onIAPV4TransactionFinish(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), marketPid);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void purchase(String marketPid, String iapPayload, int quantity, IAPV4PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "marketPid = " + marketPid + ", iapPayload = " + iapPayload + ", quantity = " + quantity);
        HiveIapV4 hiveIapV42 = INSTANCE.getHiveIapV4();
        if (hiveIapV42 != null) {
            hiveIapV42.purchase(marketPid, iapPayload, quantity, listener);
        } else {
            listener.onIAPV4Purchase(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4"), null);
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b'\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003BI\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0010J\b\u00106\u001a\u00020\u0005H\u0016J\b\u00107\u001a\u000208H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0010R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0010R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0010R\u001a\u0010$\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0010R\u001a\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0010R\u001a\u0010*\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u001a\u0010-\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0010R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/hive/IAPV4$IAPV4Product;", "Lcom/hive/base/DataModel;", "<init>", "()V", "productType", "", "marketPid", "currency", "price", "", "displayPrice", "title", "description", "originalJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "jsonProductInfo", "(Ljava/lang/String;)V", "getProductType", "()Ljava/lang/String;", InAppPurchaseConstants.METHOD_SET_PRODUCT_TYPE, "getMarketPid", "setMarketPid", "getCurrency", "setCurrency", "getPrice", "()D", "setPrice", "(D)V", "getDisplayPrice", "setDisplayPrice", "getTitle", "setTitle", "getDescription", "setDescription", InAppPurchaseConstants.METHOD_GET_ORIGINAL_JSON, "setOriginalJson", "originalMarketJson", "getOriginalMarketJson", "setOriginalMarketJson", "displayOriginalPrice", "getDisplayOriginalPrice", "setDisplayOriginalPrice", "originalPrice", "getOriginalPrice", "setOriginalPrice", "iconURL", "getIconURL", "setIconURL", "coinsReward", "", "getCoinsReward", "()I", "setCoinsReward", "(I)V", InAppPurchaseConstants.METHOD_TO_STRING, "toJSON", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IAPV4Product extends DataModel {
        private int coinsReward;
        private String currency;
        private String description;
        private String displayOriginalPrice;
        private String displayPrice;
        private String iconURL;
        private String marketPid;
        private String originalJson;
        private String originalMarketJson;
        private double originalPrice;
        private double price;
        private String productType;
        private String title;

        public IAPV4Product() {
            this.productType = "";
            this.marketPid = "";
            this.currency = "";
            this.displayPrice = "";
            this.title = "";
            this.description = "";
            this.originalJson = "";
            this.originalMarketJson = "";
            this.displayOriginalPrice = "";
            this.iconURL = "";
        }

        public final int getCoinsReward() {
            return this.coinsReward;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getDisplayOriginalPrice() {
            return this.displayOriginalPrice;
        }

        public final String getDisplayPrice() {
            return this.displayPrice;
        }

        public final String getIconURL() {
            return this.iconURL;
        }

        public final String getMarketPid() {
            return this.marketPid;
        }

        public final String getOriginalJson() {
            return this.originalJson;
        }

        public final String getOriginalMarketJson() {
            return this.originalMarketJson;
        }

        public final double getOriginalPrice() {
            return this.originalPrice;
        }

        public final double getPrice() {
            return this.price;
        }

        public final String getProductType() {
            return this.productType;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setCoinsReward(int i) {
            this.coinsReward = i;
        }

        public final void setCurrency(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.currency = str;
        }

        public final void setDescription(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.description = str;
        }

        public final void setDisplayOriginalPrice(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.displayOriginalPrice = str;
        }

        public final void setDisplayPrice(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.displayPrice = str;
        }

        public final void setIconURL(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.iconURL = str;
        }

        public final void setMarketPid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.marketPid = str;
        }

        public final void setOriginalJson(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.originalJson = str;
        }

        public final void setOriginalMarketJson(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.originalMarketJson = str;
        }

        public final void setOriginalPrice(double d) {
            this.originalPrice = d;
        }

        public final void setPrice(double d) {
            this.price = d;
        }

        public final void setProductType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.productType = str;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        @Override // com.hive.base.DataModel
        public JSONObject toJSON() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("productType", this.productType);
            jSONObject.put("marketPid", this.marketPid);
            jSONObject.put("currency", this.currency);
            if (!Double.isNaN(this.price)) {
                jSONObject.put("price", this.price);
            }
            jSONObject.put("displayPrice", this.displayPrice);
            jSONObject.put("title", this.title);
            jSONObject.put("productDescription", this.description);
            jSONObject.put("originalJson", this.originalJson);
            jSONObject.put("originalMarketJson", this.originalMarketJson);
            jSONObject.put("displayOriginalPrice", this.displayOriginalPrice);
            if (!Double.isNaN(this.originalPrice)) {
                jSONObject.put("originalPrice", this.originalPrice);
            }
            jSONObject.put("iconURL", this.iconURL);
            jSONObject.put("coinsReward", this.coinsReward);
            return jSONObject;
        }

        @Override // com.hive.base.DataModel
        public String toString() {
            StringBuilder sb = new StringBuilder("[IAPV4Product]");
            sb.append("\n    productType: " + this.productType);
            sb.append("\n    marketPid: " + this.marketPid);
            sb.append("\n    currency: " + this.currency);
            sb.append("\n    price: " + this.price);
            sb.append("\n    displayPrice: " + this.displayPrice);
            sb.append("\n    title: " + this.title);
            sb.append("\n    description: " + this.description);
            sb.append("\n    display_original_price: " + this.displayOriginalPrice);
            sb.append("\n    original_price: " + this.originalPrice);
            sb.append("\n    iconURL: " + this.iconURL);
            sb.append("\n    coinsReward: " + this.coinsReward);
            sb.append("\n    originalMarketJson: " + this.originalMarketJson);
            sb.append("\n");
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public IAPV4Product(String productType, String marketPid, String currency, double d, String displayPrice, String title, String description, String originalJson) {
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(marketPid, "marketPid");
            Intrinsics.checkNotNullParameter(currency, "currency");
            Intrinsics.checkNotNullParameter(displayPrice, "displayPrice");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(originalJson, "originalJson");
            this.originalMarketJson = "";
            this.displayOriginalPrice = "";
            this.iconURL = "";
            this.productType = productType;
            this.marketPid = marketPid;
            this.currency = currency;
            this.price = d;
            this.displayPrice = displayPrice;
            this.title = title;
            this.description = description;
            this.originalJson = originalJson;
        }

        public IAPV4Product(String jsonProductInfo) throws JSONException {
            Intrinsics.checkNotNullParameter(jsonProductInfo, "jsonProductInfo");
            this.productType = "";
            this.marketPid = "";
            this.currency = "";
            this.displayPrice = "";
            this.title = "";
            this.description = "";
            this.originalJson = "";
            this.originalMarketJson = "";
            this.displayOriginalPrice = "";
            this.iconURL = "";
            if (!StringsKt.isBlank(jsonProductInfo)) {
                this.originalJson = jsonProductInfo;
                JSONObject jSONObject = new JSONObject(this.originalJson);
                String strOptString = jSONObject.optString("product_type");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                this.productType = strOptString;
                String strOptString2 = jSONObject.optString("market_pid");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                this.marketPid = strOptString2;
                String strOptString3 = jSONObject.optString("currency");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                this.currency = strOptString3;
                this.price = jSONObject.optDouble("price", 0.0d);
                String strOptString4 = jSONObject.optString("display_price");
                Intrinsics.checkNotNull(strOptString4);
                if (!StringsKt.isBlank(strOptString4)) {
                    Intrinsics.checkNotNullExpressionValue(strOptString4, "also(...)");
                    this.displayPrice = strOptString4;
                    String strOptString5 = jSONObject.optString("title");
                    Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                    this.title = strOptString5;
                    String strOptString6 = jSONObject.optString("description");
                    Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                    this.description = strOptString6;
                    String strOptString7 = jSONObject.optString("display_original_price");
                    Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                    this.displayOriginalPrice = strOptString7;
                    this.originalPrice = jSONObject.optDouble("original_price", 0.0d);
                    String strOptString8 = jSONObject.optString("iconUrl");
                    Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                    this.iconURL = strOptString8;
                    this.coinsReward = jSONObject.optInt("coins_reward");
                    return;
                }
                throw new JSONException("jsonProductInfo (" + this.marketPid + ") display_price is empty.");
            }
            throw new JSONException("jsonProductInfo is null");
        }
    }
}
