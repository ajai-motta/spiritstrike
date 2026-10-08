package com.unity3d.services.store.gpbl.bridges.billingclient.v4;

import android.content.Context;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBridgeCommon;
import com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBuilderBridgeCommon;
import com.unity3d.services.store.gpbl.proxies.PurchasesResponseListenerProxy;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class BillingClientBridge extends BillingClientBridgeCommon {
    private static final String queryPurchasesAsyncMethodName = "queryPurchasesAsync";

    public BillingClientBridge(Object obj) throws ClassNotFoundException {
        super(obj, new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.billingclient.v4.BillingClientBridge.1
            {
                put("queryPurchasesAsync", new Class[]{String.class, PurchasesResponseListenerProxy.getProxyListenerClass()});
            }
        });
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient
    public void queryPurchasesAsync(String str, PurchasesResponseListenerProxy purchasesResponseListenerProxy) throws ClassNotFoundException {
        callVoidMethod("queryPurchasesAsync", this._billingClientInternalInstance, str, purchasesResponseListenerProxy.getProxyInstance());
    }

    public static boolean isAvailable() {
        try {
            getClassForBridge().getMethod("queryPurchasesAsync", String.class, PurchasesResponseListenerProxy.getProxyListenerClass());
            return true;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    public static BuilderBridge newBuilder(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return new BuilderBridge(callNonVoidStaticMethod(InAppPurchaseConstants.METHOD_NEW_BUILDER, context));
    }

    public static class BuilderBridge extends BillingClientBuilderBridgeCommon {
        public BuilderBridge(Object obj) throws ClassNotFoundException {
            super(obj);
        }

        @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClientBuilderBridge
        public BillingClientBridgeCommon build() throws ClassNotFoundException {
            return new BillingClientBridge(callNonVoidMethod(InAppPurchaseConstants.METHOD_BUILD, this._billingClientBuilderInternalInstance, new Object[0]));
        }
    }
}
