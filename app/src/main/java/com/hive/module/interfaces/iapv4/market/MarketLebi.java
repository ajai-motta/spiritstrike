package com.hive.module.interfaces.iapv4.market;

import android.app.Activity;
import android.net.Uri;
import android.webkit.WebView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001eJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\bH&J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J(\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0005H&R\u0018\u0010\u0011\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/hive/module/interfaces/iapv4/market/MarketLebi;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "canUseWechatPay", "", "getLebiBlackListUrl", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "purchaseLebiOnWechat", "", "activity", "Landroid/app/Activity;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/module/interfaces/iapv4/market/MarketLebi$OnWXPayListener;", "wechatAppId", "getWechatAppId", "()Ljava/lang/String;", "setWechatAppId", "(Ljava/lang/String;)V", "wechatPaymentKey", "getWechatPaymentKey", "setWechatPaymentKey", "alipayInterceptorWithUrl", "view", "Landroid/webkit/WebView;", "url", "b", "OnWXPayListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MarketLebi extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(MarketLebi marketLebi) {
            return HiveModuleName.INSTANCE.getIapV4_Market_Lebi();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\b"}, d2 = {"Lcom/hive/module/interfaces/iapv4/market/MarketLebi$OnWXPayListener;", "", "onPurchaseSuccess", "", "data", "Lorg/json/JSONObject;", "onPurchaseFail", "onPurchaseCancel", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnWXPayListener {
        void onPurchaseCancel(JSONObject data);

        void onPurchaseFail(JSONObject data);

        void onPurchaseSuccess(JSONObject data);
    }

    boolean alipayInterceptorWithUrl(Activity activity, WebView view, String url, boolean b);

    boolean canUseWechatPay();

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    ArrayList<String> getLebiBlackListUrl();

    String getWechatAppId();

    String getWechatPaymentKey();

    void purchaseLebiOnWechat(Activity activity, Uri uri, OnWXPayListener listener);

    void setWechatAppId(String str);

    void setWechatPaymentKey(String str);
}
