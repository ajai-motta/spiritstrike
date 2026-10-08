package com.hive.iapv4;

import android.os.Handler;
import com.hive.IAPV4;
import com.hive.ResultAPI;
import com.hive.iapv4.IapV4Impl;
import com.hive.logger.LoggerImpl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IapV4Impl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\u0016R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"com/hive/iapv4/IapV4Impl$marketConnect$3$innerMarketListener$1", "Lcom/hive/IAPV4$IAPV4MarketInfoListener;", "marketIds", "Ljava/util/ArrayList;", "Lcom/hive/IAPV4$IAPV4Type;", "Lkotlin/collections/ArrayList;", "getMarketIds", "()Ljava/util/ArrayList;", "setMarketIds", "(Ljava/util/ArrayList;)V", "initializedMarketCount", "", "getInitializedMarketCount", "()I", "setInitializedMarketCount", "(I)V", "onIAPV4MarketInfo", "", "result", "Lcom/hive/ResultAPI;", "iapV4TypeList", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IapV4Impl$marketConnect$3$innerMarketListener$1 implements IAPV4.IAPV4MarketInfoListener {
    final /* synthetic */ Handler $handler;
    final /* synthetic */ IAPV4.IAPV4MarketInfoListener $listener;
    final /* synthetic */ ArrayList<IapV4Impl.IAPV4Market> $responseMarketList;
    private int initializedMarketCount;
    private ArrayList<IAPV4.IAPV4Type> marketIds = new ArrayList<>();

    IapV4Impl$marketConnect$3$innerMarketListener$1(IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener, ArrayList<IapV4Impl.IAPV4Market> arrayList, Handler handler) {
        this.$listener = iAPV4MarketInfoListener;
        this.$responseMarketList = arrayList;
        this.$handler = handler;
    }

    public final ArrayList<IAPV4.IAPV4Type> getMarketIds() {
        return this.marketIds;
    }

    public final void setMarketIds(ArrayList<IAPV4.IAPV4Type> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.marketIds = arrayList;
    }

    public final int getInitializedMarketCount() {
        return this.initializedMarketCount;
    }

    public final void setInitializedMarketCount(int i) {
        this.initializedMarketCount = i;
    }

    @Override // com.hive.IAPV4.IAPV4MarketInfoListener
    public synchronized void onIAPV4MarketInfo(ResultAPI result, ArrayList<IAPV4.IAPV4Type> iapV4TypeList) {
        Intrinsics.checkNotNullParameter(result, "result");
        LoggerImpl.INSTANCE.i("[HiveIAP] onMarketListener: " + result + ", market: " + iapV4TypeList);
        this.initializedMarketCount = this.initializedMarketCount + 1;
        if (result.isSuccess() && iapV4TypeList != null) {
            this.marketIds.add(iapV4TypeList.get(0));
        }
        if (result.getErrorCode() == -8 && result.getCode() == ResultAPI.Code.IAPV4OneStoreNeedSignIn) {
            LoggerImpl.INSTANCE.d("[HiveIAP] onMarketListener: initialize response: need Onestore SignIn");
            this.$listener.onIAPV4MarketInfo(new ResultAPI(-8, ResultAPI.Code.IAPV4OneStoreNeedSignIn, "[HiveIAP] ResponseMarket need Onestore login"), null);
        } else if (this.initializedMarketCount == this.$responseMarketList.size()) {
            Handler handler = this.$handler;
            final IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener = this.$listener;
            handler.post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$marketConnect$3$innerMarketListener$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    IapV4Impl$marketConnect$3$innerMarketListener$1.onIAPV4MarketInfo$lambda$0(this.f$0, iAPV4MarketInfoListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onIAPV4MarketInfo$lambda$0(IapV4Impl$marketConnect$3$innerMarketListener$1 iapV4Impl$marketConnect$3$innerMarketListener$1, IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener) {
        ArrayList<IAPV4.IAPV4Type> arrayList = new ArrayList<>(iapV4Impl$marketConnect$3$innerMarketListener$1.marketIds.size());
        int size = iapV4Impl$marketConnect$3$innerMarketListener$1.marketIds.size();
        if (size == 0) {
            IapV4Impl iapV4Impl = IapV4Impl.INSTANCE;
            IapV4Impl.isInitialized = false;
            LoggerImpl.INSTANCE.d("[HiveIAP] onMarketListener: initialize response: market initialize error");
            iAPV4MarketInfoListener.onIAPV4MarketInfo(new ResultAPI(-5, ResultAPI.Code.IAPV4FailMarketConnect, "[HiveIAP] ResponseMarket market initialize error"), null);
            return;
        }
        if (size == 1) {
            IapV4Impl iapV4Impl2 = IapV4Impl.INSTANCE;
            IapV4Impl.selectedMarket = iapV4Impl$marketConnect$3$innerMarketListener$1.marketIds.get(0).getValue();
            arrayList.add(0, iapV4Impl$marketConnect$3$innerMarketListener$1.marketIds.get(0));
            IapV4Impl iapV4Impl3 = IapV4Impl.INSTANCE;
            IapV4Impl.isInitialized = true;
            LoggerImpl.INSTANCE.d("[HiveIAP] onMarketListener: initialize response: success, market: " + IapV4Impl.INSTANCE.getSelectedMarket());
            iAPV4MarketInfoListener.onIAPV4MarketInfo(new ResultAPI(0, ResultAPI.Code.Success, "success"), arrayList);
            IapV4LogSender.INSTANCE.doWork();
            return;
        }
        Iterator<T> it = iapV4Impl$marketConnect$3$innerMarketListener$1.marketIds.iterator();
        int i = 0;
        while (it.hasNext()) {
            arrayList.add(i, (IAPV4.IAPV4Type) it.next());
            i++;
        }
        IapV4Impl iapV4Impl4 = IapV4Impl.INSTANCE;
        IapV4Impl.isInitialized = true;
        LoggerImpl.INSTANCE.d("[HiveIAP] onMarketListener: initialize response: success");
        iAPV4MarketInfoListener.onIAPV4MarketInfo(new ResultAPI(0, ResultAPI.Code.Success, "success"), arrayList);
        IapV4LogSender.INSTANCE.doWork();
    }
}
