package com.hive.iapv4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MarketProduct.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/hive/iapv4/MarketProduct;", "", "<init>", "()V", "marketPid", "", "getMarketPid", "()Ljava/lang/String;", "setMarketPid", "(Ljava/lang/String;)V", "marketCurrency", "getMarketCurrency", "setMarketCurrency", "marketPrice", "", "getMarketPrice", "()D", "setMarketPrice", "(D)V", "marketTitle", "getMarketTitle", "setMarketTitle", "marketDescription", "getMarketDescription", "setMarketDescription", "receipt", "getReceipt", "setReceipt", "toJSONObject", "Lorg/json/JSONObject;", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MarketProduct {
    private double marketPrice;
    private String receipt;
    private String marketPid = "";
    private String marketCurrency = "";
    private String marketTitle = "";
    private String marketDescription = "";

    public abstract JSONObject toJSONObject() throws JSONException;

    public final String getMarketPid() {
        return this.marketPid;
    }

    public final void setMarketPid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.marketPid = str;
    }

    public final String getMarketCurrency() {
        return this.marketCurrency;
    }

    public final void setMarketCurrency(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.marketCurrency = str;
    }

    public final double getMarketPrice() {
        return this.marketPrice;
    }

    public final void setMarketPrice(double d) {
        this.marketPrice = d;
    }

    public final String getMarketTitle() {
        return this.marketTitle;
    }

    public final void setMarketTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.marketTitle = str;
    }

    public final String getMarketDescription() {
        return this.marketDescription;
    }

    public final void setMarketDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.marketDescription = str;
    }

    public final String getReceipt() {
        return this.receipt;
    }

    public final void setReceipt(String str) {
        this.receipt = str;
    }
}
