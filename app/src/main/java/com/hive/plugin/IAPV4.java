package com.hive.plugin;

import com.hive.HiveActivity;
import com.hive.IAPV4;
import com.hive.ResultAPI;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class IAPV4 {
    private ICallEngine callEngine;

    public IAPV4(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String marketConnect(final String str, final JSONObject jSONObject) {
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.marketConnect(new IAPV4.IAPV4MarketInfoListener() { // from class: com.hive.plugin.IAPV4.1
            @Override // com.hive.IAPV4.IAPV4MarketInfoListener
            public void onIAPV4MarketInfo(ResultAPI resultAPI, ArrayList<IAPV4.IAPV4Type> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                try {
                    Iterator<IAPV4.IAPV4Type> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().name());
                    }
                    jSONObjectCreateResponse.put("iapV4TypeList", jSONArray);
                } catch (Exception unused) {
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getProductInfo(final String str, final JSONObject jSONObject) {
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.getProductInfo(new IAPV4.IAPV4ProductInfoListener() { // from class: com.hive.plugin.IAPV4.2
            @Override // com.hive.IAPV4.IAPV4ProductInfoListener
            public void onIAPV4ProductInfo(ResultAPI resultAPI, ArrayList<IAPV4.IAPV4Product> arrayList, int i) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                try {
                    Iterator<IAPV4.IAPV4Product> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJSON());
                    }
                    jSONObjectCreateResponse.put("iapV4ProductList", jSONArray);
                    jSONObjectCreateResponse.put("balance", i);
                } catch (Exception unused) {
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getSubscriptionProductInfo(final String str, final JSONObject jSONObject) {
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.getSubscriptionProductInfo(new IAPV4.IAPV4ProductInfoListener() { // from class: com.hive.plugin.IAPV4.3
            @Override // com.hive.IAPV4.IAPV4ProductInfoListener
            public void onIAPV4ProductInfo(ResultAPI resultAPI, ArrayList<IAPV4.IAPV4Product> arrayList, int i) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                try {
                    Iterator<IAPV4.IAPV4Product> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJSON());
                    }
                    jSONObjectCreateResponse.put("iapV4ProductList", jSONArray);
                    jSONObjectCreateResponse.put("balance", i);
                } catch (Exception unused) {
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getMarketProductInfo(final String str, final JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("marketPidList");
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        } catch (JSONException unused) {
        }
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.getMarketProductInfo(arrayList, new IAPV4.IAPV4ProductInfoListener() { // from class: com.hive.plugin.IAPV4.4
            @Override // com.hive.IAPV4.IAPV4ProductInfoListener
            public void onIAPV4ProductInfo(ResultAPI resultAPI, ArrayList<IAPV4.IAPV4Product> arrayList2, int i2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray2 = new JSONArray();
                try {
                    Iterator<IAPV4.IAPV4Product> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next().toJSON());
                    }
                    jSONObjectCreateResponse.put("iapV4ProductList", jSONArray2);
                    jSONObjectCreateResponse.put("balance", i2);
                } catch (Exception unused2) {
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String purchase(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("marketPid");
        String strOptString2 = jSONObject.optString("iapPayload");
        int iOptInt = jSONObject.optInt("quantity", 1);
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.purchase(strOptString, strOptString2, iOptInt, new IAPV4.IAPV4PurchaseListener() { // from class: com.hive.plugin.IAPV4.5
            @Override // com.hive.IAPV4.IAPV4PurchaseListener
            public void onIAPV4Purchase(ResultAPI resultAPI, IAPV4.IAPV4Receipt iAPV4Receipt) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                if (iAPV4Receipt != null) {
                    try {
                        jSONObjectCreateResponse.put("iapV4Receipt", iAPV4Receipt.toJSON());
                    } catch (JSONException unused) {
                    }
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String purchaseSubscriptionUpdate(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("marketPid");
        String strOptString2 = jSONObject.optString("oldMarketPid");
        String strOptString3 = jSONObject.optString("iapPayload");
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.purchaseSubscriptionUpdate(strOptString, strOptString2, strOptString3, new IAPV4.IAPV4PurchaseListener() { // from class: com.hive.plugin.IAPV4.6
            @Override // com.hive.IAPV4.IAPV4PurchaseListener
            public void onIAPV4Purchase(ResultAPI resultAPI, IAPV4.IAPV4Receipt iAPV4Receipt) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                if (iAPV4Receipt != null) {
                    try {
                        jSONObjectCreateResponse.put("iapV4Receipt", iAPV4Receipt.toJSON());
                    } catch (JSONException unused) {
                    }
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String purchaseSubscription(final String str, final JSONObject jSONObject) {
        IAPV4.IAPV4PurchaseParam iAPV4PurchaseParamBuild = new IAPV4.IAPV4PurchaseParam.Builder().setFromJson(jSONObject.optString("param")).build();
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.purchaseSubscription(iAPV4PurchaseParamBuild, new IAPV4.IAPV4PurchaseListener() { // from class: com.hive.plugin.IAPV4.7
            @Override // com.hive.IAPV4.IAPV4PurchaseListener
            public void onIAPV4Purchase(ResultAPI resultAPI, IAPV4.IAPV4Receipt iAPV4Receipt) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                if (iAPV4Receipt != null) {
                    try {
                        jSONObjectCreateResponse.put("iapV4Receipt", iAPV4Receipt.toJSON());
                    } catch (JSONException unused) {
                    }
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String restore(final String str, final JSONObject jSONObject) {
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.restore(new IAPV4.IAPV4RestoreListener() { // from class: com.hive.plugin.IAPV4.8
            @Override // com.hive.IAPV4.IAPV4RestoreListener
            public void onIAPV4Restore(ResultAPI resultAPI, ArrayList<IAPV4.IAPV4Receipt> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                try {
                    for (IAPV4.IAPV4Receipt iAPV4Receipt : arrayList) {
                        if (iAPV4Receipt != null) {
                            jSONArray.put(iAPV4Receipt.toJSON());
                        }
                    }
                    jSONObjectCreateResponse.put("iapv4ReceiptList", jSONArray);
                } catch (Exception unused) {
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String restoreSubscription(final String str, final JSONObject jSONObject) {
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.restoreSubscription(new IAPV4.IAPV4RestoreListener() { // from class: com.hive.plugin.IAPV4.9
            @Override // com.hive.IAPV4.IAPV4RestoreListener
            public void onIAPV4Restore(ResultAPI resultAPI, ArrayList<IAPV4.IAPV4Receipt> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                try {
                    for (IAPV4.IAPV4Receipt iAPV4Receipt : arrayList) {
                        if (iAPV4Receipt != null) {
                            jSONArray.put(iAPV4Receipt.toJSON());
                        }
                    }
                    jSONObjectCreateResponse.put("iapv4ReceiptList", jSONArray);
                } catch (Exception unused) {
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String transactionFinish(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("marketPid");
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.transactionFinish(strOptString, new IAPV4.IAPV4TransactionFinishListener() { // from class: com.hive.plugin.IAPV4.10
            @Override // com.hive.IAPV4.IAPV4TransactionFinishListener
            public void onIAPV4TransactionFinish(ResultAPI resultAPI, String str2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("marketPid", str2);
                } catch (JSONException unused) {
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String transactionMultiFinish(final String str, final JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("marketPidList");
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        } catch (JSONException unused) {
        }
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.transactionMultiFinish(arrayList, new IAPV4.IAPV4TransactionMultiFinishListener() { // from class: com.hive.plugin.IAPV4.11
            @Override // com.hive.IAPV4.IAPV4TransactionMultiFinishListener
            public void onIAPV4TransactionMultiFinish(ArrayList<ResultAPI> arrayList2, ArrayList<String> arrayList3) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
                try {
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<ResultAPI> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next().toJson());
                    }
                    jSONObjectCreateResponse.put("resultList", jSONArray2);
                    JSONArray jSONArray3 = new JSONArray();
                    Iterator<String> it2 = arrayList3.iterator();
                    while (it2.hasNext()) {
                        jSONArray3.put(it2.next());
                    }
                    jSONObjectCreateResponse.put("marketPidList", jSONArray3);
                } catch (Exception unused2) {
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String showMarketSelection(final String str, final JSONObject jSONObject) {
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.showMarketSelection(new IAPV4.IAPV4MarketInfoListener() { // from class: com.hive.plugin.IAPV4.12
            @Override // com.hive.IAPV4.IAPV4MarketInfoListener
            public void onIAPV4MarketInfo(ResultAPI resultAPI, ArrayList<IAPV4.IAPV4Type> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                try {
                    Iterator<IAPV4.IAPV4Type> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().name());
                    }
                    jSONObjectCreateResponse.put("iapV4TypeList", jSONArray);
                } catch (Exception unused) {
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getBalanceInfo(final String str, final JSONObject jSONObject) {
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.getBalanceInfo(new IAPV4.IAPV4BalanceInfoListener() { // from class: com.hive.plugin.IAPV4.13
            @Override // com.hive.IAPV4.IAPV4BalanceInfoListener
            public void onIAPV4Balance(ResultAPI resultAPI, int i) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("balance", i);
                } catch (JSONException unused) {
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String showCharge(final String str, final JSONObject jSONObject) {
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.showCharge(new IAPV4.IAPV4BalanceInfoListener() { // from class: com.hive.plugin.IAPV4.14
            @Override // com.hive.IAPV4.IAPV4BalanceInfoListener
            public void onIAPV4Balance(ResultAPI resultAPI, int i) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("balance", i);
                } catch (JSONException unused) {
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String checkPromotePurchase(final String str, final JSONObject jSONObject) {
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.checkPromotePurchase(new IAPV4.IAPV4CheckPromotePurchaseListener() { // from class: com.hive.plugin.IAPV4.15
            @Override // com.hive.IAPV4.IAPV4CheckPromotePurchaseListener
            public void onIAPV4CheckPromotePurchase(ResultAPI resultAPI, String str2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("marketPid", str2);
                } catch (JSONException unused) {
                }
                IAPV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getSelectedMarket(String str, JSONObject jSONObject) {
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        IAPV4.IAPV4Type selectedMarket = com.hive.IAPV4.getSelectedMarket();
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        if (selectedMarket != null) {
            try {
                jSONObjectCreateResponse.put("iapv4Type", selectedMarket.name());
            } catch (Exception unused) {
            }
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getAccountUuid(String str, JSONObject jSONObject) {
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        String accountUuid = com.hive.IAPV4.getAccountUuid();
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        if (accountUuid != null) {
            try {
                jSONObjectCreateResponse.put("accountUuid", accountUuid);
            } catch (Exception unused) {
            }
        }
        return jSONObjectCreateResponse.toString();
    }

    public String showInAppMessages(final String str, final JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("categoryId", 3);
        com.hive.IAPV4 iapv4 = com.hive.IAPV4.INSTANCE;
        com.hive.IAPV4.showInAppMessages(iOptInt, new Function1() { // from class: com.hive.plugin.IAPV4$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.m5563lambda$showInAppMessages$0$comhivepluginIAPV4(jSONObject, str, (Integer) obj);
            }
        });
        return "";
    }

    /* JADX INFO: renamed from: lambda$showInAppMessages$0$com-hive-plugin-IAPV4, reason: not valid java name */
    /* synthetic */ Unit m5563lambda$showInAppMessages$0$comhivepluginIAPV4(JSONObject jSONObject, String str, Integer num) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("responseCode", num);
        } catch (JSONException unused) {
        }
        this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
        return null;
    }

    public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
        if ("getSelectedMarket".equals(str)) {
            return getSelectedMarket(str2, jSONObject);
        }
        if ("getAccountUuid".equals(str)) {
            return getAccountUuid(str2, jSONObject);
        }
        HiveActivity hiveActivity = HiveActivity.INSTANCE;
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger logger = com.hive.Logger.INSTANCE;
            com.hive.Logger.e("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.IAPV4.16
            @Override // java.lang.Runnable
            public void run() {
                if ("marketConnect".equals(str)) {
                    IAPV4.this.marketConnect(str2, jSONObject);
                    return;
                }
                if ("getProductInfo".equals(str)) {
                    IAPV4.this.getProductInfo(str2, jSONObject);
                    return;
                }
                if ("purchase".equals(str)) {
                    IAPV4.this.purchase(str2, jSONObject);
                    return;
                }
                if ("restore".equals(str)) {
                    IAPV4.this.restore(str2, jSONObject);
                    return;
                }
                if ("getSubscriptionProductInfo".equals(str)) {
                    IAPV4.this.getSubscriptionProductInfo(str2, jSONObject);
                    return;
                }
                if ("purchaseSubscriptionUpdate".equals(str)) {
                    IAPV4.this.purchaseSubscriptionUpdate(str2, jSONObject);
                    return;
                }
                if ("purchaseSubscription".equals(str)) {
                    IAPV4.this.purchaseSubscription(str2, jSONObject);
                    return;
                }
                if ("restoreSubscription".equals(str)) {
                    IAPV4.this.restoreSubscription(str2, jSONObject);
                    return;
                }
                if ("getMarketProductInfo".equals(str)) {
                    IAPV4.this.getMarketProductInfo(str2, jSONObject);
                    return;
                }
                if ("transactionFinish".equals(str)) {
                    IAPV4.this.transactionFinish(str2, jSONObject);
                    return;
                }
                if ("transactionMultiFinish".equals(str)) {
                    IAPV4.this.transactionMultiFinish(str2, jSONObject);
                    return;
                }
                if ("showMarketSelection".equals(str)) {
                    IAPV4.this.showMarketSelection(str2, jSONObject);
                    return;
                }
                if ("getBalanceInfo".equals(str)) {
                    IAPV4.this.getBalanceInfo(str2, jSONObject);
                    return;
                }
                if ("showCharge".equals(str)) {
                    IAPV4.this.showCharge(str2, jSONObject);
                } else if ("checkPromotePurchase".equals(str)) {
                    IAPV4.this.checkPromotePurchase(str2, jSONObject);
                } else if ("showInAppMessages".equals(str)) {
                    IAPV4.this.showInAppMessages(str2, jSONObject);
                }
            }
        });
        return "";
    }
}
