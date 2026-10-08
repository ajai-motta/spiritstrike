package com.unity3d.services.store.gpbl.bridges;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.unity3d.services.core.reflection.GenericBridge;
import com.unity3d.services.store.gpbl.BillingResultResponseCode;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class BillingResultBridge extends GenericBridge {
    private static final String getResponseCodeMethodName = "getResponseCode";
    private final Object _billingResult;

    public BillingResultBridge(Object obj) {
        super(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.BillingResultBridge.1
            {
                put("getResponseCode", new Class[0]);
            }
        });
        this._billingResult = obj;
    }

    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return InAppPurchaseConstants.CLASSNAME_BILLING_RESULT;
    }

    public BillingResultResponseCode getResponseCode() {
        return BillingResultResponseCode.fromResponseCode(((Integer) callNonVoidMethod("getResponseCode", this._billingResult, new Object[0])).intValue());
    }
}
