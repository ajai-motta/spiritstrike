package com.hive.iapv4.market.google;

import com.android.billingclient.api.AccountIdentifiers;
import com.android.billingclient.api.Purchase;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.hive.IAPV4;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayStoreReceipt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010C\u001a\u00020\tH\u0016J\b\u0010D\u001a\u00020=H\u0016R(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\u001c\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R\u0011\u0010\u001e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0010R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0010R\u0011\u0010*\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0010R\u0011\u0010,\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0010R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u00102\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0010R\u0011\u00104\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0010R\u0014\u00106\u001a\u00020%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0014\u00108\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0010R\u0014\u0010:\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0010R\u0014\u0010<\u001a\u00020=X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R$\u0010@\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012¨\u0006E"}, d2 = {"Lcom/hive/iapv4/market/google/PlayStoreReceipt;", "Lcom/hive/IAPV4$IAPV4Receipt;", AppLovinEventTypes.USER_VIEWED_PRODUCT, "Lcom/hive/IAPV4$IAPV4Product;", "playStoreProduct", "Lcom/hive/iapv4/market/google/PlayStoreProduct;", "playStorePurchase", "Lcom/android/billingclient/api/Purchase;", "iapPayload", "", "isRestore", "", "<init>", "(Lcom/hive/IAPV4$IAPV4Product;Lcom/hive/iapv4/market/google/PlayStoreProduct;Lcom/android/billingclient/api/Purchase;Ljava/lang/String;Z)V", "value", "getIapPayload", "()Ljava/lang/String;", "setIapPayload", "(Ljava/lang/String;)V", "()Z", "purchaseData", "getPurchaseData", InAppPurchaseMetaData.KEY_SIGNATURE, "getSignature", "itemType", "getItemType", "orderId", "getOrderId", "packageName", "getPackageName", "productId", "getProductId", Constants.GP_IAP_PURCHASE_TIME, "", "getPurchaseTime", "()J", "purchaseState", "", "getPurchaseState", "()I", "developerPayload", "getDeveloperPayload", "token", "getToken", "gameCurrency", "getGameCurrency", "gamePrice", "", "getGamePrice", "()D", "obfuscatedAccountId", "getObfuscatedAccountId", "serverId", "getServerId", "quantity", "getQuantity", "hiveiapReceipt", "getHiveiapReceipt", "uniqueId", "getUniqueId", "purchaseLog", "Lorg/json/JSONObject;", "getPurchaseLog", "()Lorg/json/JSONObject;", "bypassInfo", "getBypassInfo", "setBypassInfo", InAppPurchaseConstants.METHOD_TO_STRING, "toJSON", "hive-iapv4-market-google_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayStoreReceipt extends IAPV4.IAPV4Receipt {
    private String bypassInfo;
    private final String developerPayload;
    private final String gameCurrency;
    private final double gamePrice;
    private final String hiveiapReceipt;
    private String iapPayload;
    private final boolean isRestore;
    private final String itemType;
    private final String obfuscatedAccountId;
    private final String orderId;
    private final String packageName;
    private final String productId;
    private final String purchaseData;
    private final JSONObject purchaseLog;
    private final int purchaseState;
    private final long purchaseTime;
    private final int quantity;
    private final String serverId;
    private final String signature;
    private final String token;
    private final String uniqueId;

    public /* synthetic */ PlayStoreReceipt(IAPV4.IAPV4Product iAPV4Product, PlayStoreProduct playStoreProduct, Purchase purchase, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iAPV4Product, playStoreProduct, purchase, (i & 8) != 0 ? null : str, (i & 16) != 0 ? true : z);
    }

    @Override // com.hive.IAPV4.IAPV4Receipt
    public String getIapPayload() {
        return this.iapPayload;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hive.IAPV4.IAPV4Receipt
    public void setIapPayload(String str) {
        this.iapPayload = str;
    }

    @Override // com.hive.IAPV4.IAPV4Receipt
    /* JADX INFO: renamed from: isRestore, reason: from getter */
    public boolean getIsRestore() {
        return this.isRestore;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayStoreReceipt(IAPV4.IAPV4Product product, PlayStoreProduct playStoreProduct, Purchase playStorePurchase, String str, boolean z) {
        String strM7415constructorimpl;
        Object objM7415constructorimpl;
        super(IAPV4.IAPV4Type.GOOGLE_PLAYSTORE, product, 6);
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(playStoreProduct, "playStoreProduct");
        Intrinsics.checkNotNullParameter(playStorePurchase, "playStorePurchase");
        this.iapPayload = str;
        this.isRestore = z;
        String originalJson = playStorePurchase.getOriginalJson();
        Intrinsics.checkNotNullExpressionValue(originalJson, "getOriginalJson(...)");
        this.purchaseData = originalJson;
        String signature = playStorePurchase.getSignature();
        Intrinsics.checkNotNullExpressionValue(signature, "getSignature(...)");
        this.signature = signature;
        this.itemType = playStoreProduct.getType();
        this.orderId = playStorePurchase.getOrderId();
        String packageName = playStorePurchase.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        this.packageName = packageName;
        String str2 = playStorePurchase.getProducts().get(0);
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        this.productId = str2;
        this.purchaseTime = playStorePurchase.getPurchaseTime();
        this.purchaseState = playStorePurchase.getPurchaseState();
        String developerPayload = playStorePurchase.getDeveloperPayload();
        Intrinsics.checkNotNullExpressionValue(developerPayload, "getDeveloperPayload(...)");
        this.developerPayload = developerPayload;
        String purchaseToken = playStorePurchase.getPurchaseToken();
        Intrinsics.checkNotNullExpressionValue(purchaseToken, "getPurchaseToken(...)");
        this.token = purchaseToken;
        this.gameCurrency = product.getCurrency();
        this.gamePrice = product.getPrice();
        AccountIdentifiers accountIdentifiers = playStorePurchase.getAccountIdentifiers();
        String purchaseToken2 = null;
        this.obfuscatedAccountId = accountIdentifiers != null ? accountIdentifiers.getObfuscatedAccountId() : null;
        this.serverId = Configuration.INSTANCE.getServerId();
        this.quantity = playStorePurchase.getQuantity();
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_purchase_data, originalJson);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_signature, signature);
            strM7415constructorimpl = Result.m7415constructorimpl(jSONObject.toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            strM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        this.hiveiapReceipt = (String) (Result.m7421isFailureimpl(strM7415constructorimpl) ? "" : strM7415constructorimpl);
        String orderId = playStorePurchase.getOrderId();
        if (orderId != null && (!StringsKt.isBlank(orderId))) {
            purchaseToken2 = orderId;
        }
        if (purchaseToken2 == null) {
            purchaseToken2 = playStorePurchase.getPurchaseToken();
            Intrinsics.checkNotNullExpressionValue(purchaseToken2, "getPurchaseToken(...)");
        }
        this.uniqueId = purchaseToken2;
        try {
            Result.Companion companion3 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(new JSONObject());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th2));
        }
        this.purchaseLog = (JSONObject) (Result.m7421isFailureimpl(objM7415constructorimpl) ? new JSONObject() : objM7415constructorimpl);
        this.bypassInfo = setBypassInfo();
    }

    public final String getPurchaseData() {
        return this.purchaseData;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getItemType() {
        return this.itemType;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final long getPurchaseTime() {
        return this.purchaseTime;
    }

    public final int getPurchaseState() {
        return this.purchaseState;
    }

    public final String getDeveloperPayload() {
        return this.developerPayload;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getGameCurrency() {
        return this.gameCurrency;
    }

    public final double getGamePrice() {
        return this.gamePrice;
    }

    public final String getObfuscatedAccountId() {
        return this.obfuscatedAccountId;
    }

    public final String getServerId() {
        return this.serverId;
    }

    @Override // com.hive.IAPV4.IAPV4Receipt
    public int getQuantity() {
        return this.quantity;
    }

    @Override // com.hive.IAPV4.IAPV4Receipt
    public String getHiveiapReceipt() {
        return this.hiveiapReceipt;
    }

    @Override // com.hive.IAPV4.IAPV4Receipt
    public String getUniqueId() {
        return this.uniqueId;
    }

    @Override // com.hive.IAPV4.IAPV4Receipt
    public JSONObject getPurchaseLog() {
        return this.purchaseLog;
    }

    @Override // com.hive.IAPV4.IAPV4Receipt
    public String getBypassInfo() {
        return this.bypassInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hive.IAPV4.IAPV4Receipt
    public void setBypassInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bypassInfo = str;
    }

    @Override // com.hive.IAPV4.IAPV4Receipt, com.hive.base.DataModel
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n    purchaseData: " + this.purchaseData);
        sb.append("\n    signature: " + this.signature);
        sb.append("\n");
        sb.append("\n    itemType: " + this.itemType);
        sb.append("\n    orderId: " + this.orderId);
        sb.append("\n    packageName: " + this.packageName);
        sb.append("\n    productId: " + this.productId);
        sb.append("\n    purchaseTime: " + this.purchaseTime);
        sb.append("\n    purchaseState: " + this.purchaseState);
        sb.append("\n    developerPayload: " + this.developerPayload);
        sb.append("\n    token: " + this.token);
        sb.append("\n    gameCurrency: " + this.gameCurrency);
        sb.append("\n    gamePrice: " + this.gamePrice);
        sb.append("\n");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // com.hive.IAPV4.IAPV4Receipt, com.hive.base.DataModel
    public JSONObject toJSON() {
        JSONObject json = super.toJSON();
        CommonIdentifierKt.put(json, HiveKeys.KEY_purchaseData, this.purchaseData);
        CommonIdentifierKt.put(json, HiveKeys.KEY_signature, this.signature);
        CommonIdentifierKt.put(json, HiveKeys.KEY_itemType, this.itemType);
        CommonIdentifierKt.put(json, HiveKeys.KEY_orderId, this.orderId);
        CommonIdentifierKt.put(json, HiveKeys.KEY_packageName, this.packageName);
        CommonIdentifierKt.put(json, HiveKeys.KEY_sku, this.productId);
        CommonIdentifierKt.put(json, HiveKeys.KEY_developerPayload, this.developerPayload);
        CommonIdentifierKt.put(json, HiveKeys.KEY_token, this.token);
        HiveKeys hiveKeys = HiveKeys.KEY_vid;
        String vid = getAccount().getVid();
        if (vid == null) {
            vid = getAccount().getUid();
        }
        CommonIdentifierKt.put(json, hiveKeys, vid);
        CommonIdentifierKt.put(json, HiveKeys.KEY_gameCurrency, this.gameCurrency);
        CommonIdentifierKt.put(json, HiveKeys.KEY_gamePrice, Double.valueOf(this.gamePrice));
        CommonIdentifierKt.put(json, HiveKeys.KEY_serverId, this.serverId);
        return json;
    }
}
