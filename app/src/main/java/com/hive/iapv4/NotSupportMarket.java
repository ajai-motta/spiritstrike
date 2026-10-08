package com.hive.iapv4;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.IAPV4;
import com.hive.ResultAPI;
import com.hive.logger.LoggerImpl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotSupportMarket.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016J*\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u00020\u00052\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0017j\b\u0012\u0004\u0012\u00020\f`\u00182\u0006\u0010\u0006\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u001bH\u0016¨\u0006\u001e"}, d2 = {"Lcom/hive/iapv4/NotSupportMarket;", "Lcom/hive/iapv4/BaseMarketAPI;", "<init>", "()V", "marketConnect", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/IAPV4$IAPV4MarketInfoListener;", "getProductInfo", "Lcom/hive/IAPV4$IAPV4ProductInfoListener;", "purchase", "marketPid", "", "iapPayload", "quantity", "", "Lcom/hive/IAPV4$IAPV4PurchaseListener;", "restore", "Lcom/hive/IAPV4$IAPV4RestoreListener;", "transactionFinish", "Lcom/hive/IAPV4$IAPV4TransactionFinishListener;", "transactionMultiFinish", "marketPidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/hive/IAPV4$IAPV4TransactionMultiFinishListener;", "getBalanceInfo", "Lcom/hive/IAPV4$IAPV4BalanceInfoListener;", "showMarketSelection", "showCharge", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotSupportMarket extends BaseMarketAPI {
    public static final NotSupportMarket INSTANCE = new NotSupportMarket();

    private NotSupportMarket() {
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void marketConnect(IAPV4.IAPV4MarketInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w("[HiveIAP] NotSupportMarket initialize");
        listener.onIAPV4MarketInfo(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), null);
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void getProductInfo(IAPV4.IAPV4ProductInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w("[HiveIAP] NotSupportMarket shopInfo");
        listener.onIAPV4ProductInfo(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), null, 0);
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void purchase(String marketPid, String iapPayload, int quantity, IAPV4.IAPV4PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w("[HiveIAP] NotSupportMarket purchase");
        listener.onIAPV4Purchase(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), null);
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void restore(IAPV4.IAPV4RestoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w("[HiveIAP] NotSupportMarket restore");
        listener.onIAPV4Restore(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), null);
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void transactionFinish(String marketPid, IAPV4.IAPV4TransactionFinishListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w("[HiveIAP] NotSupportMarket transactionFinish");
        listener.onIAPV4TransactionFinish(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), marketPid);
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void transactionMultiFinish(ArrayList<String> marketPidList, IAPV4.IAPV4TransactionMultiFinishListener listener) {
        Intrinsics.checkNotNullParameter(marketPidList, "marketPidList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w("[HiveIAP] NotSupportMarket transactionMultiFinish");
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

    @Override // com.hive.iapv4.BaseMarketAPI
    public void getBalanceInfo(IAPV4.IAPV4BalanceInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w("[HiveIAP] NotSupportMarket balance");
        listener.onIAPV4Balance(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), 0);
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void showMarketSelection(IAPV4.IAPV4MarketInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w("[HiveIAP] NotSupportMarket showPayment");
        listener.onIAPV4MarketInfo(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), null);
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void showCharge(IAPV4.IAPV4BalanceInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w("[HiveIAP] NotSupportMarket showCharge");
        listener.onIAPV4Balance(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), 0);
    }
}
