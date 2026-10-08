package com.unity3d.services.store.gpbl;

import android.content.Context;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge;
import com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientBuilderFactory;
import com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient;
import com.unity3d.services.store.gpbl.listeners.BillingClientStateListener;
import com.unity3d.services.store.gpbl.listeners.PurchaseHistoryResponseListener;
import com.unity3d.services.store.gpbl.listeners.PurchaseUpdatedResponseListener;
import com.unity3d.services.store.gpbl.listeners.PurchasesResponseListener;
import com.unity3d.services.store.gpbl.listeners.SkuDetailsResponseListener;
import com.unity3d.services.store.gpbl.proxies.BillingClientStateListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchaseHistoryResponseListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchaseUpdatedListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchasesResponseListenerProxy;
import com.unity3d.services.store.gpbl.proxies.SkuDetailsResponseListenerProxy;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class StoreBilling {
    private final IBillingClient _billingClientBridge;

    public StoreBilling(Context context, PurchaseUpdatedResponseListener purchaseUpdatedResponseListener) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        this._billingClientBridge = BillingClientBuilderFactory.getBillingClientBuilder(context).setListener(new PurchaseUpdatedListenerProxy(purchaseUpdatedResponseListener)).enablePendingPurchases().build();
    }

    public void initialize(BillingClientStateListener billingClientStateListener) throws ClassNotFoundException {
        this._billingClientBridge.startConnection(new BillingClientStateListenerProxy(billingClientStateListener));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int isFeatureSupported(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "inapp"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L11
            com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient r2 = r1._billingClientBridge
            boolean r2 = r2.isReady()
            if (r2 == 0) goto L27
            goto L25
        L11:
            java.lang.String r0 = "subs"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L1b
            java.lang.String r2 = "subscriptions"
        L1b:
            com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient r0 = r1._billingClientBridge
            com.unity3d.services.store.gpbl.BillingResultResponseCode r2 = r0.isFeatureSupported(r2)
            com.unity3d.services.store.gpbl.BillingResultResponseCode r0 = com.unity3d.services.store.gpbl.BillingResultResponseCode.OK
            if (r2 != r0) goto L27
        L25:
            r2 = 0
            goto L28
        L27:
            r2 = -1
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.store.gpbl.StoreBilling.isFeatureSupported(java.lang.String):int");
    }

    public void getPurchases(String str, PurchasesResponseListener purchasesResponseListener) throws ClassNotFoundException {
        this._billingClientBridge.queryPurchasesAsync(str, new PurchasesResponseListenerProxy(purchasesResponseListener));
    }

    public void getSkuDetails(String str, List<String> list, SkuDetailsResponseListener skuDetailsResponseListener) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        this._billingClientBridge.querySkuDetailsAsync(SkuDetailsParamsBridge.newBuilder().setSkuList(list).setType(str).build(), new SkuDetailsResponseListenerProxy(skuDetailsResponseListener));
    }

    public void getPurchaseHistory(String str, int i, PurchaseHistoryResponseListener purchaseHistoryResponseListener) throws ClassNotFoundException {
        this._billingClientBridge.queryPurchaseHistoryAsync(str, new PurchaseHistoryResponseListenerProxy(purchaseHistoryResponseListener, i));
    }
}
