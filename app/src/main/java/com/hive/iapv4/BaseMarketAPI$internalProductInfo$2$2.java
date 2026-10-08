package com.hive.iapv4;

import android.os.Handler;
import com.hive.IAPV4;
import com.hive.ResultAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseMarketAPI.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/hive/iapv4/BaseMarketAPI$internalProductInfo$2$2", "Lcom/hive/IAPV4$IAPV4BalanceInfoListener;", "onIAPV4Balance", "", "result", "Lcom/hive/ResultAPI;", "balance", "", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseMarketAPI$internalProductInfo$2$2 implements IAPV4.IAPV4BalanceInfoListener {
    final /* synthetic */ Handler $handler;
    final /* synthetic */ IAPV4.IAPV4ProductInfoListener $listener;
    final /* synthetic */ ArrayList<IAPV4.IAPV4Product> $productList;
    final /* synthetic */ ResultAPI $resultApi;

    BaseMarketAPI$internalProductInfo$2$2(Handler handler, IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener, ResultAPI resultAPI, ArrayList<IAPV4.IAPV4Product> arrayList) {
        this.$handler = handler;
        this.$listener = iAPV4ProductInfoListener;
        this.$resultApi = resultAPI;
        this.$productList = arrayList;
    }

    @Override // com.hive.IAPV4.IAPV4BalanceInfoListener
    public void onIAPV4Balance(ResultAPI result, final int balance) {
        Intrinsics.checkNotNullParameter(result, "result");
        Handler handler = this.$handler;
        final IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener = this.$listener;
        final ResultAPI resultAPI = this.$resultApi;
        final ArrayList<IAPV4.IAPV4Product> arrayList = this.$productList;
        handler.post(new Runnable() { // from class: com.hive.iapv4.BaseMarketAPI$internalProductInfo$2$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                iAPV4ProductInfoListener.onIAPV4ProductInfo(resultAPI, arrayList, balance);
            }
        });
    }
}
