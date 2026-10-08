package com.hive.module.interfaces;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.IAPV4;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&J,\u0010\u000b\u001a\u00020\u00052\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000e2\u0006\u0010\u0006\u001a\u00020\tH&J*\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0014H&J2\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0014H&J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u001bH&J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u001bH&J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u001fH&J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u001fH&J(\u0010!\u001a\u00020\u00052\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000e2\u0006\u0010\u0006\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020%H&J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020%H&J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020(H&J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0003H&J\b\u0010+\u001a\u00020,H&J\n\u0010-\u001a\u0004\u0018\u00010\u0003H&J(\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00132\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0005\u0018\u000100H&J\u001c\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020,2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003H&¨\u00064"}, d2 = {"Lcom/hive/module/interfaces/HiveIapV4;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "marketConnect", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/IAPV4$IAPV4MarketInfoListener;", "getProductInfo", "Lcom/hive/IAPV4$IAPV4ProductInfoListener;", "getSubscriptionProductInfo", "getMarketProductInfo", "marketPidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "purchase", "marketPid", "iapPayload", "quantity", "", "Lcom/hive/IAPV4$IAPV4PurchaseListener;", "purchaseSubscription", "param", "Lcom/hive/IAPV4$IAPV4PurchaseParam;", "voidPurchase", "refundIndex", "restore", "Lcom/hive/IAPV4$IAPV4RestoreListener;", "restoreSubscription", "voidRestore", "transactionFinish", "Lcom/hive/IAPV4$IAPV4TransactionFinishListener;", "voidTransactionFinish", "transactionMultiFinish", "Lcom/hive/IAPV4$IAPV4TransactionMultiFinishListener;", "showMarketSelection", "getBalanceInfo", "Lcom/hive/IAPV4$IAPV4BalanceInfoListener;", "showCharge", "checkPromotePurchase", "Lcom/hive/IAPV4$IAPV4CheckPromotePurchaseListener;", "setPromotePurchaseMarketPid", "marketPID", "getSelectedMarket", "Lcom/hive/IAPV4$IAPV4Type;", "getAccountUuid", "showInAppMessages", "categoryId", "Lkotlin/Function1;", "getMarketSDKVersion", "type", "sdkType", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HiveIapV4 extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(HiveIapV4 hiveIapV4) {
            return HiveModuleName.INSTANCE.getIapV4();
        }

        public static /* synthetic */ String getMarketSDKVersion$default(HiveIapV4 hiveIapV4, IAPV4.IAPV4Type iAPV4Type, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMarketSDKVersion");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return hiveIapV4.getMarketSDKVersion(iAPV4Type, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showInAppMessages$default(HiveIapV4 hiveIapV4, int i, Function1 function1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInAppMessages");
            }
            if ((i2 & 2) != 0) {
                function1 = null;
            }
            hiveIapV4.showInAppMessages(i, function1);
        }
    }

    void checkPromotePurchase(IAPV4.IAPV4CheckPromotePurchaseListener listener);

    String getAccountUuid();

    void getBalanceInfo(IAPV4.IAPV4BalanceInfoListener listener);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void getMarketProductInfo(ArrayList<String> marketPidList, IAPV4.IAPV4ProductInfoListener listener);

    String getMarketSDKVersion(IAPV4.IAPV4Type type, String sdkType);

    void getProductInfo(IAPV4.IAPV4ProductInfoListener listener);

    /* JADX INFO: renamed from: getSelectedMarket */
    IAPV4.IAPV4Type mo5533getSelectedMarket();

    void getSubscriptionProductInfo(IAPV4.IAPV4ProductInfoListener listener);

    void marketConnect(IAPV4.IAPV4MarketInfoListener listener);

    void purchase(String marketPid, String iapPayload, int quantity, IAPV4.IAPV4PurchaseListener listener);

    void purchaseSubscription(IAPV4.IAPV4PurchaseParam param, IAPV4.IAPV4PurchaseListener listener);

    void restore(IAPV4.IAPV4RestoreListener listener);

    void restoreSubscription(IAPV4.IAPV4RestoreListener listener);

    void setPromotePurchaseMarketPid(String marketPID);

    void showCharge(IAPV4.IAPV4BalanceInfoListener listener);

    void showInAppMessages(int categoryId, Function1<? super Integer, Unit> listener);

    void showMarketSelection(IAPV4.IAPV4MarketInfoListener listener);

    void transactionFinish(String marketPid, IAPV4.IAPV4TransactionFinishListener listener);

    void transactionMultiFinish(ArrayList<String> marketPidList, IAPV4.IAPV4TransactionMultiFinishListener listener);

    void voidPurchase(String marketPid, String iapPayload, int quantity, int refundIndex, IAPV4.IAPV4PurchaseListener listener);

    void voidRestore(IAPV4.IAPV4RestoreListener listener);

    void voidTransactionFinish(String marketPid, IAPV4.IAPV4TransactionFinishListener listener);
}
