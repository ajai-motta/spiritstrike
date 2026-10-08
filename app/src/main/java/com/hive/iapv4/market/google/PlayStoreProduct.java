package com.hive.iapv4.market.google;

import com.android.billingclient.api.ProductDetails;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.iapv4.MarketProduct;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayStoreProduct.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010'\u001a\u00020\u0003H\u0002J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016R$\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005R$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0005R$\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u0005R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u0005R$\u0010\u001d\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u0005R$\u0010 \u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u0005R(\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\b¨\u0006+"}, d2 = {"Lcom/hive/iapv4/market/google/PlayStoreProduct;", "Lcom/hive/iapv4/MarketProduct;", FirebaseAnalytics.Param.PRODUCT_ID, "", "<init>", "(Ljava/lang/String;)V", "details", "Lcom/android/billingclient/api/ProductDetails;", "(Lcom/android/billingclient/api/ProductDetails;)V", "value", "productId", "getProductId", "()Ljava/lang/String;", "setProductId$hive_iapv4_market_google_release", "type", "getType", "setType$hive_iapv4_market_google_release", "price", "getPrice", "setPrice$hive_iapv4_market_google_release", "", Constants.GP_IAP_PRICE_AMOUNT_MICROS_V5V7, "getPriceAmountMicros", "()J", "setPriceAmountMicros$hive_iapv4_market_google_release", "(J)V", Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7, "getPriceCurrencyCode", "setPriceCurrencyCode$hive_iapv4_market_google_release", "title", "getTitle", "setTitle$hive_iapv4_market_google_release", "description", "getDescription", "setDescription$hive_iapv4_market_google_release", "productDetails", "getProductDetails", "()Lcom/android/billingclient/api/ProductDetails;", "setProductDetails$hive_iapv4_market_google_release", "getOriginalMarketJson", "toJSONObject", "Lorg/json/JSONObject;", InAppPurchaseConstants.METHOD_TO_STRING, "hive-iapv4-market-google_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayStoreProduct extends MarketProduct {
    private String description;
    private String price;
    private long priceAmountMicros;
    private String priceCurrencyCode;
    private ProductDetails productDetails;
    private String productId;
    private String title;
    private String type;

    public final String getProductId() {
        return this.productId;
    }

    public final void setProductId$hive_iapv4_market_google_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.productId = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType$hive_iapv4_market_google_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final String getPrice() {
        return this.price;
    }

    public final void setPrice$hive_iapv4_market_google_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.price = str;
    }

    public final long getPriceAmountMicros() {
        return this.priceAmountMicros;
    }

    public final void setPriceAmountMicros$hive_iapv4_market_google_release(long j) {
        this.priceAmountMicros = j;
    }

    public final String getPriceCurrencyCode() {
        return this.priceCurrencyCode;
    }

    public final void setPriceCurrencyCode$hive_iapv4_market_google_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.priceCurrencyCode = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle$hive_iapv4_market_google_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription$hive_iapv4_market_google_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    public final void setProductDetails$hive_iapv4_market_google_release(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public PlayStoreProduct(String product_id) {
        Intrinsics.checkNotNullParameter(product_id, "product_id");
        this.productId = product_id;
        this.type = "";
        this.price = "";
        this.priceAmountMicros = 0L;
        this.priceCurrencyCode = "";
        this.title = "";
        this.description = "";
        setMarketPid(product_id);
        setMarketCurrency(this.priceCurrencyCode);
        setMarketPrice(this.priceAmountMicros);
        setMarketTitle(this.title);
        setMarketDescription(this.description);
    }

    public PlayStoreProduct(ProductDetails details) {
        String priceCurrencyCode;
        String formattedPrice;
        String priceCurrencyCode2;
        String formattedPrice2;
        ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails;
        ProductDetails.PricingPhases pricingPhases;
        List<ProductDetails.PricingPhase> pricingPhaseList;
        Intrinsics.checkNotNullParameter(details, "details");
        this.productDetails = details;
        String productId = details.getProductId();
        Intrinsics.checkNotNullExpressionValue(productId, "getProductId(...)");
        this.productId = productId;
        String productType = details.getProductType();
        Intrinsics.checkNotNullExpressionValue(productType, "getProductType(...)");
        this.type = productType;
        String productType2 = details.getProductType();
        String str = "";
        if (productType2.hashCode() == 3541555 && productType2.equals("subs")) {
            List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails2 = details.getSubscriptionOfferDetails();
            ProductDetails.PricingPhase pricingPhase = (subscriptionOfferDetails2 == null || (subscriptionOfferDetails = subscriptionOfferDetails2.get(0)) == null || (pricingPhases = subscriptionOfferDetails.getPricingPhases()) == null || (pricingPhaseList = pricingPhases.getPricingPhaseList()) == null) ? null : pricingPhaseList.get(0);
            this.price = (pricingPhase == null || (formattedPrice2 = pricingPhase.getFormattedPrice()) == null) ? "" : formattedPrice2;
            this.priceAmountMicros = pricingPhase != null ? pricingPhase.getPriceAmountMicros() : 0L;
            if (pricingPhase != null && (priceCurrencyCode2 = pricingPhase.getPriceCurrencyCode()) != null) {
                str = priceCurrencyCode2;
            }
            this.priceCurrencyCode = str;
        } else {
            ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = details.getOneTimePurchaseOfferDetails();
            this.price = (oneTimePurchaseOfferDetails == null || (formattedPrice = oneTimePurchaseOfferDetails.getFormattedPrice()) == null) ? "" : formattedPrice;
            this.priceAmountMicros = oneTimePurchaseOfferDetails != null ? oneTimePurchaseOfferDetails.getPriceAmountMicros() : 0L;
            if (oneTimePurchaseOfferDetails != null && (priceCurrencyCode = oneTimePurchaseOfferDetails.getPriceCurrencyCode()) != null) {
                str = priceCurrencyCode;
            }
            this.priceCurrencyCode = str;
        }
        String name = details.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        this.title = name;
        String description = details.getDescription();
        Intrinsics.checkNotNullExpressionValue(description, "getDescription(...)");
        this.description = description;
        setMarketPid(this.productId);
        setMarketCurrency(this.priceCurrencyCode);
        setMarketPrice(this.priceAmountMicros / 1000000.0d);
        setMarketTitle(this.title);
        setMarketDescription(this.description);
    }

    private final String getOriginalMarketJson() {
        return StringsKt.substringBefore$default(StringsKt.substringAfter$default(String.valueOf(this.productDetails), "ProductDetails{jsonString='", (String) null, 2, (Object) null), "', parsedJson=", (String) null, 2, (Object) null);
    }

    @Override // com.hive.iapv4.MarketProduct
    public JSONObject toJSONObject() throws JSONException {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(new JSONObject(getOriginalMarketJson()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        JSONObject jSONObject = new JSONObject();
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = jSONObject;
        }
        JSONObject jSONObject2 = (JSONObject) objM7415constructorimpl;
        jSONObject2.put(FirebaseAnalytics.Param.PRODUCT_ID, this.productId);
        jSONObject2.put("type", this.type);
        jSONObject2.put("price", this.price);
        jSONObject2.put(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V2V4, this.priceAmountMicros);
        jSONObject2.put(Constants.GP_IAP_PRICE_CURRENCY_CODE_V2V4, this.priceCurrencyCode);
        jSONObject2.put("title", this.title);
        jSONObject2.put("description", this.description);
        return jSONObject2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlayStoreProduct Info\n product_id: ");
        sb.append(this.productId);
        sb.append("\n type: ");
        sb.append(this.type);
        sb.append("\n price: ");
        sb.append(this.price);
        sb.append("\n price_amount_micros: ");
        sb.append(this.priceAmountMicros);
        sb.append("\n price_currency_code: ");
        sb.append(this.priceCurrencyCode);
        sb.append("\n title: ");
        sb.append(this.title);
        sb.append("\n name: ");
        ProductDetails productDetails = this.productDetails;
        sb.append(productDetails != null ? productDetails.getName() : null);
        sb.append("\n description: ");
        sb.append(this.description);
        sb.append("\n productDetails: ");
        sb.append(getOriginalMarketJson());
        return sb.toString();
    }
}
