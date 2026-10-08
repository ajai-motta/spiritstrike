package com.hive.iapv4;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Analytics;
import com.hive.HiveActivity;
import com.hive.IAPV4;
import com.hive.ResultAPI;
import com.hive.analytics.AnalyticsImpl;
import com.hive.analytics.provider.AnalyticsProviderAdapter;
import com.hive.base.Android;
import com.hive.base.DataModel;
import com.hive.base.Property;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.HiveTime;
import com.hive.core.Logger;
import com.hive.iapv4.IapV4Impl;
import com.hive.iapv4.IapV4Network;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModuleName;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.HiveIapV4;
import com.hive.protocol.iapv4.Market;
import com.hive.protocol.iapv4.Purchase;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IapV4Impl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005lmnopB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J,\u0010\u001b\u001a\u00020\u00152\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u001e2\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J*\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020#H\u0016J2\u0010'\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020#H\u0016J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020*H\u0016J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020*H\u0016J\u0018\u0010-\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020.H\u0016J(\u00100\u001a\u00020\u00152\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001dj\b\u0012\u0004\u0012\u00020\b`\u001e2\u0006\u0010\u0016\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u00103\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u000204H\u0016J\u0010\u00106\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020\bH\u0016J\u0017\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=H\u0000¢\u0006\u0002\b>Je\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020D2\u0012\u0010E\u001a\n\u0012\u0006\b\u0001\u0012\u00020=0F\"\u00020=2*\b\u0002\u0010G\u001a$\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020=\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020=\u0018\u0001`\u001e\u0012\u0004\u0012\u00020\u0015\u0018\u00010HH\u0002¢\u0006\u0002\u0010IJ\"\u0010J\u001a\u00020\u00152\u0006\u0010K\u001a\u00020A2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010\u0016\u001a\u0004\u0018\u00010#J4\u0010L\u001a\u00020\u00152\u0006\u0010K\u001a\u00020A2\u001a\u0010M\u001a\u0016\u0012\u0004\u0012\u00020=\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020=\u0018\u0001`\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010*J*\u0010N\u001a\u00020\u00152\u0006\u0010K\u001a\u00020A2\u0006\u0010 \u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010\u0016\u001a\u0004\u0018\u00010.J\\\u0010O\u001a\u00020\u00152\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020A0\u001dj\b\u0012\u0004\u0012\u00020A`\u001e2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001dj\b\u0012\u0004\u0012\u00020\b`\u001e2\u001a\u0010M\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010=0\u001dj\n\u0012\u0006\u0012\u0004\u0018\u00010=`\u001e2\b\u0010\u0016\u001a\u0004\u0018\u000101J\u000e\u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00020SJ\u000e\u0010T\u001a\u00020\u00152\u0006\u0010R\u001a\u00020SJ\u000e\u0010U\u001a\u00020\u00152\u0006\u0010R\u001a\u00020SJ\u000e\u0010V\u001a\u00020\u00152\u0006\u0010R\u001a\u00020SJ(\u0010W\u001a\u00020\u00152\u0006\u0010R\u001a\u00020S2\u0006\u0010X\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\u0010Z\u001a\u0004\u0018\u00010[J\u0012\u0010\\\u001a\u0004\u0018\u00010\b2\u0006\u0010]\u001a\u00020^H\u0002J\b\u0010\u000f\u001a\u00020_H\u0016J\n\u0010`\u001a\u0004\u0018\u00010\bH\u0016J&\u0010a\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\r2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015\u0018\u00010HH\u0016J\u001a\u0010c\u001a\u00020\b2\u0006\u0010d\u001a\u00020_2\b\u0010e\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010f\u001a\u00020A2\u0006\u0010g\u001a\u00020\b2\b\u0010h\u001a\u0004\u0018\u00010iH\u0002J\u0014\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0kH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/hive/iapv4/IapV4Impl;", "Lcom/hive/module/interfaces/HiveIapV4;", "<init>", "()V", "markets", "Landroid/util/SparseArray;", "Lcom/hive/iapv4/BaseMarketAPI;", "marketSelectUrl", "", "promotePurchaseMarketPid", "isPause", "", "value", "", "selectedMarket", "getSelectedMarket", "()I", "isInitialized", "isMarketConnecting", "isShowPayment", "marketConnect", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/IAPV4$IAPV4MarketInfoListener;", "getProductInfo", "Lcom/hive/IAPV4$IAPV4ProductInfoListener;", "getSubscriptionProductInfo", "getMarketProductInfo", "marketPidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "purchase", "marketPid", "iapPayload", "quantity", "Lcom/hive/IAPV4$IAPV4PurchaseListener;", "purchaseSubscription", "param", "Lcom/hive/IAPV4$IAPV4PurchaseParam;", "voidPurchase", "refundIndex", "restore", "Lcom/hive/IAPV4$IAPV4RestoreListener;", "restoreSubscription", "voidRestore", "transactionFinish", "Lcom/hive/IAPV4$IAPV4TransactionFinishListener;", "voidTransactionFinish", "transactionMultiFinish", "Lcom/hive/IAPV4$IAPV4TransactionMultiFinishListener;", "showMarketSelection", "getBalanceInfo", "Lcom/hive/IAPV4$IAPV4BalanceInfoListener;", "showCharge", "checkPromotePurchase", "Lcom/hive/IAPV4$IAPV4CheckPromotePurchaseListener;", "setPromotePurchaseMarketPid", "marketPID", "createAnalyticsRevenue", "Lcom/hive/Analytics$AnalyticsRevenue;", "iapv4Receipt", "Lcom/hive/IAPV4$IAPV4Receipt;", "createAnalyticsRevenue$hive_iapv4_base_release", "sendPurchaseLog", "resultApi", "Lcom/hive/ResultAPI;", "isRestore", "api", "Lcom/hive/iapv4/IapV4Network$REQUEST_NETWORK_API;", "iapv4Receipts", "", "callback", "Lkotlin/Function1;", "(Lcom/hive/ResultAPI;ZLcom/hive/iapv4/IapV4Network$REQUEST_NETWORK_API;[Lcom/hive/IAPV4$IAPV4Receipt;Lkotlin/jvm/functions/Function1;)V", "onPurchaseFinish", "result", "onRestoreFinish", "iapv4ReceiptList", "onTransactionFinish", "onTransactionMultiFinish", "resultList", "onStart", "activity", "Landroid/app/Activity;", "onResume", "onPause", "onDestroy", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "getObfuscatedAccountId", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "Lcom/hive/IAPV4$IAPV4Type;", "getAccountUuid", "showInAppMessages", "categoryId", "getMarketSDKVersion", "type", "sdkType", "checkParams", "apiName", "o", "", "getVersionInfo", "", "InnerPurchaseListener", "InnerRestoreListener", "InnerTransactionFinishListener", "IAPV4Market", "TransactionInfo", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IapV4Impl implements HiveIapV4 {
    private static boolean isInitialized;
    private static boolean isMarketConnecting;
    private static boolean isPause;
    private static boolean isShowPayment;
    private static String marketSelectUrl;
    private static String promotePurchaseMarketPid;
    private static int selectedMarket;
    public static final IapV4Impl INSTANCE = new IapV4Impl();
    private static SparseArray<BaseMarketAPI> markets = new SparseArray<>();

    private IapV4Impl() {
    }

    @Override // com.hive.module.interfaces.HiveIapV4, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return HiveIapV4.DefaultImpls.getHiveModuleName(this);
    }

    static {
        LoggerImpl.INSTANCE.d("[HiveIAP] create HiveIAP");
        for (IAPV4.IAPV4Type iAPV4Type : IAPV4.IAPV4Type.values()) {
            markets.put(iAPV4Type.getValue(), NotSupportMarket.INSTANCE);
        }
        HiveActivity.registerHiveActivityLifecycleListeners(new OnActivityLifecycle() { // from class: com.hive.iapv4.IapV4Impl.1
            @Override // com.hive.ui.OnActivityLifecycle
            public void onStart(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                IapV4Impl.INSTANCE.onStart(activity);
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onResume(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                IapV4Impl.INSTANCE.onResume(activity);
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onPause(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                IapV4Impl.INSTANCE.onPause(activity);
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                IapV4Impl.INSTANCE.onDestroy(activity);
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                IapV4Impl.INSTANCE.onActivityResult(activity, requestCode, resultCode, data);
            }
        });
        HiveLifecycle.registerHiveLifecycleListeners(new HiveLifecycle.HiveLifecycleListener() { // from class: com.hive.iapv4.IapV4Impl.2
            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onAgreement() {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onAgreement(this);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onInitializeFinished() {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onInitializeFinished(this);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onNetworkAvailable(boolean z) {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onNetworkAvailable(this, z);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onProcessUri(String str) {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onProcessUri(this, str);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onSetupFinished() {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onSetupFinished(this);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onSignIn(HiveLifecycle.HiveAccount hiveAccount) {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onSignIn(this, hiveAccount);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onSignOut() {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onSignOut(this);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onReset() {
                TransactionInfo.INSTANCE.reset();
                IapV4LogSender.INSTANCE.reset();
            }
        });
    }

    public final int getSelectedMarket() {
        return selectedMarket;
    }

    /* JADX INFO: compiled from: IapV4Impl.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/hive/iapv4/IapV4Impl$InnerPurchaseListener;", "Lcom/hive/IAPV4$IAPV4PurchaseListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/hive/IAPV4$IAPV4PurchaseListener;)V", "getListener", "()Lcom/hive/IAPV4$IAPV4PurchaseListener;", "marketPid", "", "getMarketPid", "()Ljava/lang/String;", "setMarketPid", "(Ljava/lang/String;)V", "isVoid", "", "()Z", "setVoid", "(Z)V", "refundIndex", "", "getRefundIndex", "()I", "setRefundIndex", "(I)V", "onIAPV4Purchase", "", "result", "Lcom/hive/ResultAPI;", "iapV4Receipt", "Lcom/hive/IAPV4$IAPV4Receipt;", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InnerPurchaseListener implements IAPV4.IAPV4PurchaseListener {
        private boolean isVoid;
        private final IAPV4.IAPV4PurchaseListener listener;
        private String marketPid;
        private int refundIndex;

        public InnerPurchaseListener(IAPV4.IAPV4PurchaseListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
            this.marketPid = "";
        }

        public final IAPV4.IAPV4PurchaseListener getListener() {
            return this.listener;
        }

        public final String getMarketPid() {
            return this.marketPid;
        }

        public final void setMarketPid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.marketPid = str;
        }

        /* JADX INFO: renamed from: isVoid, reason: from getter */
        public final boolean getIsVoid() {
            return this.isVoid;
        }

        public final void setVoid(boolean z) {
            this.isVoid = z;
        }

        public final int getRefundIndex() {
            return this.refundIndex;
        }

        public final void setRefundIndex(int i) {
            this.refundIndex = i;
        }

        @Override // com.hive.IAPV4.IAPV4PurchaseListener
        public void onIAPV4Purchase(ResultAPI result, IAPV4.IAPV4Receipt iapV4Receipt) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.listener.onIAPV4Purchase(result, iapV4Receipt);
        }
    }

    /* JADX INFO: compiled from: IapV4Impl.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J,\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/hive/iapv4/IapV4Impl$InnerRestoreListener;", "Lcom/hive/IAPV4$IAPV4RestoreListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/hive/IAPV4$IAPV4RestoreListener;)V", "getListener", "()Lcom/hive/IAPV4$IAPV4RestoreListener;", "isVoid", "", "()Z", "setVoid", "(Z)V", "onIAPV4Restore", "", "result", "Lcom/hive/ResultAPI;", "iapv4ReceiptList", "Ljava/util/ArrayList;", "Lcom/hive/IAPV4$IAPV4Receipt;", "Lkotlin/collections/ArrayList;", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InnerRestoreListener implements IAPV4.IAPV4RestoreListener {
        private boolean isVoid;
        private final IAPV4.IAPV4RestoreListener listener;

        public InnerRestoreListener(IAPV4.IAPV4RestoreListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
        }

        public final IAPV4.IAPV4RestoreListener getListener() {
            return this.listener;
        }

        /* JADX INFO: renamed from: isVoid, reason: from getter */
        public final boolean getIsVoid() {
            return this.isVoid;
        }

        public final void setVoid(boolean z) {
            this.isVoid = z;
        }

        @Override // com.hive.IAPV4.IAPV4RestoreListener
        public void onIAPV4Restore(ResultAPI result, ArrayList<IAPV4.IAPV4Receipt> iapv4ReceiptList) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.listener.onIAPV4Restore(result, iapv4ReceiptList);
        }
    }

    /* JADX INFO: compiled from: IapV4Impl.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/hive/iapv4/IapV4Impl$InnerTransactionFinishListener;", "Lcom/hive/IAPV4$IAPV4TransactionFinishListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/hive/IAPV4$IAPV4TransactionFinishListener;)V", "getListener", "()Lcom/hive/IAPV4$IAPV4TransactionFinishListener;", "isVoid", "", "()Z", "setVoid", "(Z)V", "onIAPV4TransactionFinish", "", "result", "Lcom/hive/ResultAPI;", "marketPid", "", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InnerTransactionFinishListener implements IAPV4.IAPV4TransactionFinishListener {
        private boolean isVoid;
        private final IAPV4.IAPV4TransactionFinishListener listener;

        public InnerTransactionFinishListener(IAPV4.IAPV4TransactionFinishListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
        }

        public final IAPV4.IAPV4TransactionFinishListener getListener() {
            return this.listener;
        }

        /* JADX INFO: renamed from: isVoid, reason: from getter */
        public final boolean getIsVoid() {
            return this.isVoid;
        }

        public final void setVoid(boolean z) {
            this.isVoid = z;
        }

        @Override // com.hive.IAPV4.IAPV4TransactionFinishListener
        public void onIAPV4TransactionFinish(ResultAPI result, String marketPid) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(marketPid, "marketPid");
            this.listener.onIAPV4TransactionFinish(result, marketPid);
        }
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public void marketConnect(final IAPV4.IAPV4MarketInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] initialize");
        final Handler handler = new Handler(Looper.getMainLooper());
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            isInitialized = false;
            handler.post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    IapV4Impl.marketConnect$lambda$0(listener);
                }
            });
        } else if (isMarketConnecting) {
            handler.post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    IapV4Impl.marketConnect$lambda$1(listener);
                }
            });
        } else {
            isMarketConnecting = true;
            IapV4Network.INSTANCE.market$hive_iapv4_base_release(TtmlNode.COMBINE_ALL, new Function4() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return IapV4Impl.marketConnect$lambda$5(handler, listener, (ResultAPI) obj, (Market) obj2, (ArrayList) obj3, (String) obj4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void marketConnect$lambda$0(IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener) {
        LoggerImpl.INSTANCE.e("[HiveIAP] initialize : need auth initialize");
        iAPV4MarketInfoListener.onIAPV4MarketInfo(new ResultAPI(-7, ResultAPI.Code.IAPV4NotInitialize, "[HiveIAP] initialize : need auth initialize"), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void marketConnect$lambda$1(IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener) {
        LoggerImpl.INSTANCE.e("[HiveIAP] initialize : Already market connect in progress");
        iAPV4MarketInfoListener.onIAPV4MarketInfo(new ResultAPI(-3, ResultAPI.Code.IAPV4InProgressMarketConnect, "[HiveIAP] initialize : Already market connect in progress"), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit marketConnect$lambda$5(Handler handler, final IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener, final ResultAPI marketResultApi, Market requestMarketApi, ArrayList arrayList, String str) {
        int iIntValue;
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(marketResultApi, "marketResultApi");
        Intrinsics.checkNotNullParameter(requestMarketApi, "requestMarketApi");
        LoggerImpl.INSTANCE.d("[HiveIAP] onRequestNetworkTaskListener REQUEST_MARKET");
        isMarketConnecting = false;
        if (requestMarketApi.getResponse().isSuccess() && arrayList != null) {
            if (arrayList.size() == 1) {
                LoggerImpl.INSTANCE.i("[HiveIAP] Market list length: 1");
                selectedMarket = ((IAPV4Market) arrayList.get(0)).getIapType().getValue();
            } else {
                String value = Property.INSTANCE.getINSTANCE().getValue(IapV4Keys.SELECTED_MARKET_PROPERTY);
                if (value == null || !(!StringsKt.isBlank(value))) {
                    iIntValue = 0;
                } else {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM7415constructorimpl = Result.m7415constructorimpl(Integer.valueOf(Integer.parseInt(value)));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                    }
                    if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
                        objM7415constructorimpl = 0;
                    }
                    iIntValue = ((Number) objM7415constructorimpl).intValue();
                }
                Iterator it = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    if (((IAPV4Market) next).getIapType().getValue() == iIntValue) {
                        selectedMarket = iIntValue;
                        LoggerImpl.INSTANCE.d("[HiveIAP] match with selected market property.");
                        break;
                    }
                    selectedMarket = 0;
                }
                if (selectedMarket == 0) {
                    LoggerImpl.INSTANCE.d("[HiveIAP] mismatch between response market ids and selected market property.");
                }
            }
            LoggerImpl.INSTANCE.i("[HiveIAP] selectedMarket: " + selectedMarket);
            marketSelectUrl = str;
            LoggerImpl.INSTANCE.d("[HiveIAP] marketSelectUrl: " + marketSelectUrl);
            IapV4Impl$marketConnect$3$innerMarketListener$1 iapV4Impl$marketConnect$3$innerMarketListener$1 = new IapV4Impl$marketConnect$3$innerMarketListener$1(iAPV4MarketInfoListener, arrayList, handler);
            if (arrayList.isEmpty()) {
                isInitialized = false;
                handler.post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        IapV4Impl.marketConnect$lambda$5$lambda$3(iAPV4MarketInfoListener);
                    }
                });
            } else {
                Iterator it2 = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    IAPV4Market iAPV4Market = (IAPV4Market) next2;
                    LoggerImpl.INSTANCE.dL("[HiveIAP] Market: " + iAPV4Market);
                    LoggerImpl.INSTANCE.dR("[HiveIAP] Market: " + iAPV4Market.getIapType());
                    BaseMarketAPI marketModuleInstance = null;
                    if (iAPV4Market.getIapType() == IAPV4.IAPV4Type.ONESTORE && iAPV4Market.getReceiptLevel() == 4) {
                        IapV4Module market$hive_iapv4_base_release = IapV4Module.INSTANCE.getMarket$hive_iapv4_base_release(HiveModuleName.INSTANCE.getIapV4_Market_OneStoreV4());
                        if (market$hive_iapv4_base_release != null) {
                            marketModuleInstance = market$hive_iapv4_base_release.getMarketModuleInstance();
                        }
                    } else {
                        IapV4Module market$hive_iapv4_base_release2 = IapV4Module.INSTANCE.getMarket$hive_iapv4_base_release(iAPV4Market.getIapType());
                        if (market$hive_iapv4_base_release2 != null) {
                            marketModuleInstance = market$hive_iapv4_base_release2.getMarketModuleInstance();
                        }
                    }
                    if (marketModuleInstance != null) {
                        marketModuleInstance.setMarket(iAPV4Market);
                        markets.put(iAPV4Market.getIapType().getValue(), marketModuleInstance);
                        marketModuleInstance.marketConnect(iapV4Impl$marketConnect$3$innerMarketListener$1);
                    } else {
                        LoggerImpl.INSTANCE.e("[HiveIAP] initialize " + iAPV4Market.getIapType().getDisplayName() + " : no library corresponding to the market data received.");
                        markets.put(iAPV4Market.getIapType().getValue(), NotSupportMarket.INSTANCE);
                        ArrayList<IAPV4.IAPV4Type> arrayList2 = new ArrayList<>();
                        arrayList2.add(iAPV4Market.getIapType());
                        iapV4Impl$marketConnect$3$innerMarketListener$1.onIAPV4MarketInfo(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "[HiveIAP] " + iAPV4Market.getIapType().getDisplayName() + " library missing."), arrayList2);
                    }
                }
            }
        } else {
            isInitialized = false;
            handler.post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    IapV4Impl.marketConnect$lambda$5$lambda$4(marketResultApi, iAPV4MarketInfoListener);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void marketConnect$lambda$5$lambda$3(IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener) {
        LoggerImpl.INSTANCE.e("[HiveIAP] initialize : No response market data in IAP Server.");
        iAPV4MarketInfoListener.onIAPV4MarketInfo(new ResultAPI(-8, ResultAPI.Code.IAPV4FailMarketConnect, "[HiveIAP] initialize : No response market data in IAP Server."), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void marketConnect$lambda$5$lambda$4(ResultAPI resultAPI, IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener) {
        LoggerImpl.INSTANCE.w("[HiveIAP] onMarketListener: ResponseMarket instance error " + resultAPI);
        iAPV4MarketInfoListener.onIAPV4MarketInfo(resultAPI, null);
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public void getProductInfo(IAPV4.IAPV4ProductInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] getProductInfo");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C29111(listener, new Handler(Looper.getMainLooper()), null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.iapv4.IapV4Impl$getProductInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IapV4Impl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.IapV4Impl$getProductInfo$1", f = "IapV4Impl.kt", i = {}, l = {1621, 313}, m = "invokeSuspend", n = {}, s = {})
    static final class C29111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Handler $handler;
        final /* synthetic */ IAPV4.IAPV4ProductInfoListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29111(IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener, Handler handler, Continuation<? super C29111> continuation) {
            super(2, continuation);
            this.$listener = iAPV4ProductInfoListener;
            this.$handler = handler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29111(this.$listener, this.$handler, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r7)
                goto L83
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1a:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L5f
            L1e:
                kotlin.ResultKt.throwOnFailure(r7)
                boolean r7 = com.hive.iapv4.IapV4Impl.access$isInitialized$p()
                if (r7 != 0) goto L86
                com.hive.logger.LoggerImpl r7 = com.hive.logger.LoggerImpl.INSTANCE
                java.lang.String r1 = "[HiveIAP] getProductInfo need market initialize. Try to internal marketConnect."
                r7.w(r1)
                r6.label = r3
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                kotlinx.coroutines.CancellableContinuationImpl r1 = new kotlinx.coroutines.CancellableContinuationImpl
                kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r7)
                r1.<init>(r4, r3)
                r1.initCancellability()
                r3 = r1
                kotlinx.coroutines.CancellableContinuation r3 = (kotlinx.coroutines.CancellableContinuation) r3
                com.hive.iapv4.IapV4Impl r4 = com.hive.iapv4.IapV4Impl.INSTANCE
                com.hive.iapv4.IapV4Impl$getProductInfo$1$marketConnectResult$1$1 r5 = new com.hive.iapv4.IapV4Impl$getProductInfo$1$marketConnectResult$1$1
                r5.<init>()
                com.hive.IAPV4$IAPV4MarketInfoListener r5 = (com.hive.IAPV4.IAPV4MarketInfoListener) r5
                r4.marketConnect(r5)
                java.lang.Object r1 = r1.getResult()
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r1 != r3) goto L5b
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r7)
            L5b:
                if (r1 != r0) goto L5e
                return r0
            L5e:
                r7 = r1
            L5f:
                com.hive.ResultAPI r7 = (com.hive.ResultAPI) r7
                boolean r7 = r7.isFailure()
                if (r7 == 0) goto L86
                kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
                com.hive.iapv4.IapV4Impl$getProductInfo$1$1 r1 = new com.hive.iapv4.IapV4Impl$getProductInfo$1$1
                com.hive.IAPV4$IAPV4ProductInfoListener r3 = r6.$listener
                r4 = 0
                r1.<init>(r3, r4)
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                r3 = r6
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r6.label = r2
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r3)
                if (r7 != r0) goto L83
                return r0
            L83:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            L86:
                com.hive.iapv4.IapV4Impl r7 = com.hive.iapv4.IapV4Impl.INSTANCE
                int r7 = r7.getSelectedMarket()
                if (r7 != 0) goto La8
                com.hive.logger.LoggerImpl r7 = com.hive.logger.LoggerImpl.INSTANCE
                java.lang.String r0 = "[HiveIAP] no selected market"
                r7.d(r0)
                com.hive.iapv4.IapV4Impl r7 = com.hive.iapv4.IapV4Impl.INSTANCE
                com.hive.iapv4.IapV4Impl$getProductInfo$1$2 r0 = new com.hive.iapv4.IapV4Impl$getProductInfo$1$2
                android.os.Handler r1 = r6.$handler
                com.hive.IAPV4$IAPV4ProductInfoListener r2 = r6.$listener
                r0.<init>(r1, r2)
                com.hive.IAPV4$IAPV4MarketInfoListener r0 = (com.hive.IAPV4.IAPV4MarketInfoListener) r0
                r7.showMarketSelection(r0)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            La8:
                android.util.SparseArray r7 = com.hive.iapv4.IapV4Impl.access$getMarkets$p()
                com.hive.iapv4.IapV4Impl r0 = com.hive.iapv4.IapV4Impl.INSTANCE
                int r0 = r0.getSelectedMarket()
                java.lang.Object r7 = r7.get(r0)
                com.hive.iapv4.BaseMarketAPI r7 = (com.hive.iapv4.BaseMarketAPI) r7
                com.hive.IAPV4$IAPV4ProductInfoListener r0 = r6.$listener
                r7.getProductInfo(r0)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.IapV4Impl.C29111.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.hive.iapv4.IapV4Impl$getProductInfo$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: IapV4Impl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.iapv4.IapV4Impl$getProductInfo$1$1", f = "IapV4Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C03561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ IAPV4.IAPV4ProductInfoListener $listener;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03561(IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener, Continuation<? super C03561> continuation) {
                super(2, continuation);
                this.$listener = iAPV4ProductInfoListener;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03561(this.$listener, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$listener.onIAPV4ProductInfo(new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] getProductInfo need market initialize"), null, 0);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.hive.iapv4.IapV4Impl$getProductInfo$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: IapV4Impl.kt */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u0016¨\u0006\n"}, d2 = {"com/hive/iapv4/IapV4Impl$getProductInfo$1$2", "Lcom/hive/IAPV4$IAPV4MarketInfoListener;", "onIAPV4MarketInfo", "", "result", "Lcom/hive/ResultAPI;", "iapV4TypeList", "Ljava/util/ArrayList;", "Lcom/hive/IAPV4$IAPV4Type;", "Lkotlin/collections/ArrayList;", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class AnonymousClass2 implements IAPV4.IAPV4MarketInfoListener {
            final /* synthetic */ Handler $handler;
            final /* synthetic */ IAPV4.IAPV4ProductInfoListener $listener;

            AnonymousClass2(Handler handler, IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener) {
                this.$handler = handler;
                this.$listener = iAPV4ProductInfoListener;
            }

            @Override // com.hive.IAPV4.IAPV4MarketInfoListener
            public void onIAPV4MarketInfo(final ResultAPI result, ArrayList<IAPV4.IAPV4Type> iapV4TypeList) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.isSuccess()) {
                    Handler handler = this.$handler;
                    final IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener = this.$listener;
                    handler.post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$getProductInfo$1$2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            IapV4Impl.C29111.AnonymousClass2.onIAPV4MarketInfo$lambda$0(iAPV4ProductInfoListener);
                        }
                    });
                } else {
                    LoggerImpl.INSTANCE.e("[HiveIAP] getProductInfo showMarketSelection failed");
                    Handler handler2 = this.$handler;
                    final IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener2 = this.$listener;
                    handler2.post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$getProductInfo$1$2$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            iAPV4ProductInfoListener2.onIAPV4ProductInfo(result, null, 0);
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void onIAPV4MarketInfo$lambda$0(IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener) {
                ((BaseMarketAPI) IapV4Impl.markets.get(IapV4Impl.INSTANCE.getSelectedMarket())).getProductInfo(iAPV4ProductInfoListener);
            }
        }
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public void getSubscriptionProductInfo(IAPV4.IAPV4ProductInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] getSubscriptionProductInfo");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C29121(listener, new Handler(Looper.getMainLooper()), null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IapV4Impl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1", f = "IapV4Impl.kt", i = {}, l = {1621, 372}, m = "invokeSuspend", n = {}, s = {})
    static final class C29121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Handler $handler;
        final /* synthetic */ IAPV4.IAPV4ProductInfoListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29121(IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener, Handler handler, Continuation<? super C29121> continuation) {
            super(2, continuation);
            this.$listener = iAPV4ProductInfoListener;
            this.$handler = handler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29121(this.$listener, this.$handler, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r7)
                goto L83
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1a:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L5f
            L1e:
                kotlin.ResultKt.throwOnFailure(r7)
                boolean r7 = com.hive.iapv4.IapV4Impl.access$isInitialized$p()
                if (r7 != 0) goto L86
                com.hive.logger.LoggerImpl r7 = com.hive.logger.LoggerImpl.INSTANCE
                java.lang.String r1 = "[HiveIAP] getSubscriptionProductInfo need market initialize. Try to internal marketConnect."
                r7.w(r1)
                r6.label = r3
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                kotlinx.coroutines.CancellableContinuationImpl r1 = new kotlinx.coroutines.CancellableContinuationImpl
                kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r7)
                r1.<init>(r4, r3)
                r1.initCancellability()
                r3 = r1
                kotlinx.coroutines.CancellableContinuation r3 = (kotlinx.coroutines.CancellableContinuation) r3
                com.hive.iapv4.IapV4Impl r4 = com.hive.iapv4.IapV4Impl.INSTANCE
                com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1$marketConnectResult$1$1 r5 = new com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1$marketConnectResult$1$1
                r5.<init>()
                com.hive.IAPV4$IAPV4MarketInfoListener r5 = (com.hive.IAPV4.IAPV4MarketInfoListener) r5
                r4.marketConnect(r5)
                java.lang.Object r1 = r1.getResult()
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r1 != r3) goto L5b
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r7)
            L5b:
                if (r1 != r0) goto L5e
                return r0
            L5e:
                r7 = r1
            L5f:
                com.hive.ResultAPI r7 = (com.hive.ResultAPI) r7
                boolean r7 = r7.isFailure()
                if (r7 == 0) goto L86
                kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
                com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1$1 r1 = new com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1$1
                com.hive.IAPV4$IAPV4ProductInfoListener r3 = r6.$listener
                r4 = 0
                r1.<init>(r3, r4)
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                r3 = r6
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r6.label = r2
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r3)
                if (r7 != r0) goto L83
                return r0
            L83:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            L86:
                com.hive.iapv4.IapV4Impl r7 = com.hive.iapv4.IapV4Impl.INSTANCE
                int r7 = r7.getSelectedMarket()
                if (r7 != 0) goto La8
                com.hive.logger.LoggerImpl r7 = com.hive.logger.LoggerImpl.INSTANCE
                java.lang.String r0 = "[HiveIAP] no selected market"
                r7.d(r0)
                com.hive.iapv4.IapV4Impl r7 = com.hive.iapv4.IapV4Impl.INSTANCE
                com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1$2 r0 = new com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1$2
                android.os.Handler r1 = r6.$handler
                com.hive.IAPV4$IAPV4ProductInfoListener r2 = r6.$listener
                r0.<init>(r1, r2)
                com.hive.IAPV4$IAPV4MarketInfoListener r0 = (com.hive.IAPV4.IAPV4MarketInfoListener) r0
                r7.showMarketSelection(r0)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            La8:
                android.util.SparseArray r7 = com.hive.iapv4.IapV4Impl.access$getMarkets$p()
                com.hive.iapv4.IapV4Impl r0 = com.hive.iapv4.IapV4Impl.INSTANCE
                int r0 = r0.getSelectedMarket()
                java.lang.Object r7 = r7.get(r0)
                com.hive.iapv4.BaseMarketAPI r7 = (com.hive.iapv4.BaseMarketAPI) r7
                com.hive.IAPV4$IAPV4ProductInfoListener r0 = r6.$listener
                r7.getSubscriptionProductInfo(r0)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.IapV4Impl.C29121.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: IapV4Impl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1$1", f = "IapV4Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C03571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ IAPV4.IAPV4ProductInfoListener $listener;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03571(IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener, Continuation<? super C03571> continuation) {
                super(2, continuation);
                this.$listener = iAPV4ProductInfoListener;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03571(this.$listener, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$listener.onIAPV4ProductInfo(new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] getSubscriptionProductInfo need market initialize"), null, 0);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: IapV4Impl.kt */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u0016¨\u0006\n"}, d2 = {"com/hive/iapv4/IapV4Impl$getSubscriptionProductInfo$1$2", "Lcom/hive/IAPV4$IAPV4MarketInfoListener;", "onIAPV4MarketInfo", "", "result", "Lcom/hive/ResultAPI;", "iapV4TypeList", "Ljava/util/ArrayList;", "Lcom/hive/IAPV4$IAPV4Type;", "Lkotlin/collections/ArrayList;", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class AnonymousClass2 implements IAPV4.IAPV4MarketInfoListener {
            final /* synthetic */ Handler $handler;
            final /* synthetic */ IAPV4.IAPV4ProductInfoListener $listener;

            AnonymousClass2(Handler handler, IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener) {
                this.$handler = handler;
                this.$listener = iAPV4ProductInfoListener;
            }

            @Override // com.hive.IAPV4.IAPV4MarketInfoListener
            public void onIAPV4MarketInfo(final ResultAPI result, ArrayList<IAPV4.IAPV4Type> iapV4TypeList) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.isSuccess()) {
                    Handler handler = this.$handler;
                    final IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener = this.$listener;
                    handler.post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1$2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            IapV4Impl.C29121.AnonymousClass2.onIAPV4MarketInfo$lambda$0(iAPV4ProductInfoListener);
                        }
                    });
                } else {
                    LoggerImpl.INSTANCE.e("[HiveIAP] getSubscriptionProductInfo showMarketSelection failed");
                    Handler handler2 = this.$handler;
                    final IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener2 = this.$listener;
                    handler2.post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$getSubscriptionProductInfo$1$2$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            iAPV4ProductInfoListener2.onIAPV4ProductInfo(result, null, 0);
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void onIAPV4MarketInfo$lambda$0(IAPV4.IAPV4ProductInfoListener iAPV4ProductInfoListener) {
                ((BaseMarketAPI) IapV4Impl.markets.get(IapV4Impl.INSTANCE.getSelectedMarket())).getSubscriptionProductInfo(iAPV4ProductInfoListener);
            }
        }
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public void getMarketProductInfo(ArrayList<String> marketPidList, IAPV4.IAPV4ProductInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.w(null, "[HiveIAP] NotSupportMarket getMarketProductInfo");
        listener.onIAPV4ProductInfo(new ResultAPI(-2, ResultAPI.Code.IAPV4NotSupportedMarket, "[HiveIAP] HIVEIAP_NOT_SUPPORTED"), null, 0);
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public synchronized void purchase(String marketPid, String iapPayload, int quantity, IAPV4.IAPV4PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.dL("[HiveIAP] purchase marketPid: " + marketPid + ", iapPayload: " + iapPayload);
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        StringBuilder sb = new StringBuilder("[HiveIAP] purchase marketPid: ");
        sb.append(marketPid);
        loggerImpl.dR(sb.toString());
        ResultAPI resultAPICheckParams = checkParams("purchase", listener);
        if (resultAPICheckParams.isFailure()) {
            onPurchaseFinish(resultAPICheckParams, null, listener);
            return;
        }
        if (StringsKt.isBlank(marketPid)) {
            LoggerImpl.INSTANCE.e("[HiveIAP] purchase marketPid is empty");
            onPurchaseFinish(new ResultAPI(-1, ResultAPI.Code.IAPV4EmptyParamMarketPID, "[HiveIAP] purchase need marketPid"), null, listener);
            return;
        }
        if (selectedMarket == 0) {
            LoggerImpl.INSTANCE.w("[HiveIAP] purchase no selected market");
            onPurchaseFinish(new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] purchase need initialize, getProductInfo or showPayment API"), null, listener);
            return;
        }
        if (quantity <= 0 || (quantity != 1 && ((!(listener instanceof InnerPurchaseListener) || !((InnerPurchaseListener) listener).getIsVoid()) && selectedMarket != IAPV4.IAPV4Type.HIVESTORE.getValue() && selectedMarket != IAPV4.IAPV4Type.XIAOMI_APPSTORE.getValue()))) {
            LoggerImpl.INSTANCE.w("[HiveIAP] This market(" + IAPV4.IAPV4Type.INSTANCE.findDisplayName(selectedMarket) + ") does not support multiple quantity(" + quantity + ") purchases.");
            onPurchaseFinish(new ResultAPI(-1, ResultAPI.Code.IAPV4MarketNotSupportedAPI, "[HiveIAP] This market(" + IAPV4.IAPV4Type.INSTANCE.findDisplayName(selectedMarket) + ") does not support multiple quantity(" + quantity + ") purchases."), null, listener);
            return;
        }
        IAPV4.IAPV4Product productInfo = markets.get(selectedMarket).getProductInfo(marketPid);
        if (productInfo == null) {
            LoggerImpl.INSTANCE.e("[HiveIAP] purchase check error: need product info for marketPid: " + marketPid);
            onPurchaseFinish(new ResultAPI(-1, ResultAPI.Code.IAPV4ProductNotExist, "[HiveIAP] purchase check error: need product info for marketPid: " + marketPid), null, listener);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_market_pid, marketPid);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_price, Double.valueOf(productInfo.getPrice()));
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_currency, productInfo.getCurrency());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_request_time_ms, Long.valueOf(HiveTime.INSTANCE.getHiveTimeTimestamp().getTime()));
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_account_uuid, HiveLifecycle.INSTANCE.getAccount().getAccountUuid());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_iap_payload, iapPayload);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_quantity, Integer.valueOf(quantity));
            String marketUserId = markets.get(selectedMarket).getMarketUserId();
            if (marketUserId != null) {
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_userId, marketUserId);
            }
            if (!TransactionInfo.INSTANCE.isContains(selectedMarket, marketPid)) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C29132(jSONObject, marketPid, iapPayload, quantity, listener, productInfo, null), 3, null);
                return;
            }
            LoggerImpl.INSTANCE.d("[HiveIAP] purchase transaction market id: " + IAPV4.IAPV4Type.INSTANCE.findValue(selectedMarket));
            onPurchaseFinish(new ResultAPI(-10, ResultAPI.Code.IAPV4NeedRestore, "[HiveIAP] purchase need restore, market id: " + IAPV4.IAPV4Type.INSTANCE.findValue(selectedMarket)), null, listener);
        } catch (JSONException unused) {
            LoggerImpl.INSTANCE.e("[HiveIAP] purchase marketPid error");
            onPurchaseFinish(new ResultAPI(-1, ResultAPI.Code.IAPV4PurchaseParamJsonException, "[HiveIAP] purchase marketPid error: " + marketPid), null, listener);
        }
    }

    /* JADX INFO: renamed from: com.hive.iapv4.IapV4Impl$purchase$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IapV4Impl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.IapV4Impl$purchase$2", f = "IapV4Impl.kt", i = {}, l = {489}, m = "invokeSuspend", n = {}, s = {})
    static final class C29132 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IAPV4.IAPV4Product $gameProduct;
        final /* synthetic */ String $iapPayload;
        final /* synthetic */ JSONObject $jsonPrePurchaseData;
        final /* synthetic */ IAPV4.IAPV4PurchaseListener $listener;
        final /* synthetic */ String $marketPid;
        final /* synthetic */ int $quantity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29132(JSONObject jSONObject, String str, String str2, int i, IAPV4.IAPV4PurchaseListener iAPV4PurchaseListener, IAPV4.IAPV4Product iAPV4Product, Continuation<? super C29132> continuation) {
            super(2, continuation);
            this.$jsonPrePurchaseData = jSONObject;
            this.$marketPid = str;
            this.$iapPayload = str2;
            this.$quantity = i;
            this.$listener = iAPV4PurchaseListener;
            this.$gameProduct = iAPV4Product;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29132(this.$jsonPrePurchaseData, this.$marketPid, this.$iapPayload, this.$quantity, this.$listener, this.$gameProduct, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29132) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objPurchase$hive_iapv4_base_release$default;
            InnerPurchaseListener innerPurchaseListener;
            Object objM7415constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objPurchase$hive_iapv4_base_release$default = IapV4Network.purchase$hive_iapv4_base_release$default(IapV4Network.INSTANCE, IapV4Network.REQUEST_NETWORK_API.REQUEST_PRE_PURCHASE, this.$jsonPrePurchaseData, null, this, 4, null);
                if (objPurchase$hive_iapv4_base_release$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objPurchase$hive_iapv4_base_release$default = obj;
            }
            Purchase purchase = (Purchase) objPurchase$hive_iapv4_base_release$default;
            if (purchase.getResponse().isSuccess()) {
                BaseMarketAPI baseMarketAPI = (BaseMarketAPI) IapV4Impl.markets.get(IapV4Impl.INSTANCE.getSelectedMarket());
                String str = this.$marketPid;
                String str2 = this.$iapPayload;
                int i2 = this.$quantity;
                IAPV4.IAPV4PurchaseListener iAPV4PurchaseListener = this.$listener;
                if (iAPV4PurchaseListener instanceof InnerPurchaseListener) {
                    innerPurchaseListener = (InnerPurchaseListener) iAPV4PurchaseListener;
                } else {
                    InnerPurchaseListener innerPurchaseListener2 = new InnerPurchaseListener(iAPV4PurchaseListener);
                    innerPurchaseListener2.setMarketPid(this.$marketPid);
                    Unit unit = Unit.INSTANCE;
                    innerPurchaseListener = innerPurchaseListener2;
                }
                baseMarketAPI.purchase(str, str2, i2, innerPurchaseListener);
                IAPV4.IAPV4Product iAPV4Product = this.$gameProduct;
                int i3 = this.$quantity;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Analytics.AnalyticsRevenue analyticsRevenue = new Analytics.AnalyticsRevenue(null, null, null, null, 0L, null, null, 0, null, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
                    analyticsRevenue.setProductType(iAPV4Product.getProductType());
                    analyticsRevenue.setCurrency(iAPV4Product.getCurrency());
                    analyticsRevenue.setTitle(iAPV4Product.getTitle());
                    analyticsRevenue.setPid(iAPV4Product.getMarketPid());
                    analyticsRevenue.setPrice(NumberFormat.getInstance().format(iAPV4Product.getPrice()));
                    analyticsRevenue.setItemCount(i3);
                    AnalyticsImpl.INSTANCE.sendStandardRevenueEvent(AnalyticsProviderAdapter.StandardEventType.PURCHASE_START, analyticsRevenue);
                    objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl != null) {
                    LoggerImpl.INSTANCE.d("[HiveIAP] Purchase sendStandardRevenueEvent exception : " + thM7418exceptionOrNullimpl);
                }
                Result.m7414boximpl(objM7415constructorimpl);
            } else {
                String str3 = "[HiveIAP] Purchase pre-purchase response failed(" + purchase.getResponse().getIapV4Result() + "): " + purchase.getResponse().getIapV4ResultMsg();
                LoggerImpl.INSTANCE.w(str3);
                IapV4Impl.INSTANCE.onPurchaseFinish(new ResultAPI(-8, ResultAPI.Code.IAPV4ResponseError, str3), null, this.$listener);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public synchronized void purchaseSubscription(IAPV4.IAPV4PurchaseParam param, IAPV4.IAPV4PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.dL("[HiveIAP] purchaseSubscription: " + param);
        LoggerImpl.INSTANCE.dR("[HiveIAP] purchaseSubscription");
        String marketPid = param.getMarketPid();
        ResultAPI resultAPICheckParams = checkParams("purchaseSubscriptionUpdate", listener);
        if (resultAPICheckParams.isFailure()) {
            onPurchaseFinish(resultAPICheckParams, null, listener);
            return;
        }
        if (StringsKt.isBlank(marketPid)) {
            LoggerImpl.INSTANCE.e("[HiveIAP] purchaseSubscriptionUpdate marketPid is empty");
            onPurchaseFinish(new ResultAPI(-1, ResultAPI.Code.IAPV4EmptyParamMarketPID, "[HiveIAP] purchase need marketPid"), null, listener);
            return;
        }
        int i = selectedMarket;
        if (i == 0) {
            LoggerImpl.INSTANCE.w("[HiveIAP] purchaseSubscriptionUpdate no selected market");
            onPurchaseFinish(new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] purchase need initialize, getProductInfo or showPayment API"), null, listener);
            return;
        }
        IAPV4.IAPV4Product productInfo = markets.get(i).getProductInfo(marketPid);
        if (productInfo == null) {
            LoggerImpl.INSTANCE.e("[HiveIAP] purchaseSubscriptionUpdate check error: need product info for marketPid: " + marketPid);
            onPurchaseFinish(new ResultAPI(-1, ResultAPI.Code.IAPV4ProductNotExist, "[HiveIAP] purchase check error: need product info for marketPid: " + marketPid), null, listener);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_market_pid, marketPid);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_price, Double.valueOf(productInfo.getPrice()));
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_currency, productInfo.getCurrency());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_request_time_ms, Long.valueOf(HiveTime.INSTANCE.getHiveTimeTimestamp().getTime()));
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_account_uuid, HiveLifecycle.INSTANCE.getAccount().getAccountUuid());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_iap_payload, param.getIapPayload());
            String marketUserId = markets.get(selectedMarket).getMarketUserId();
            if (marketUserId != null) {
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_userId, marketUserId);
            }
            if (!TransactionInfo.INSTANCE.isContains(selectedMarket, marketPid)) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C29142(jSONObject, param, listener, marketPid, productInfo, null), 3, null);
                return;
            }
            LoggerImpl.INSTANCE.d("[HiveIAP] purchaseSubscriptionUpdate transaction market id: " + IAPV4.IAPV4Type.INSTANCE.findValue(selectedMarket));
            onPurchaseFinish(new ResultAPI(-10, ResultAPI.Code.IAPV4NeedRestore, "[HiveIAP] purchase need restore, market id: " + IAPV4.IAPV4Type.INSTANCE.findValue(selectedMarket)), null, listener);
        } catch (JSONException unused) {
            LoggerImpl.INSTANCE.e("[HiveIAP] purchaseSubscriptionUpdate marketPid error");
            onPurchaseFinish(new ResultAPI(-1, ResultAPI.Code.IAPV4PurchaseParamJsonException, "[HiveIAP] purchase marketPid error: " + marketPid), null, listener);
        }
    }

    /* JADX INFO: renamed from: com.hive.iapv4.IapV4Impl$purchaseSubscription$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IapV4Impl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.IapV4Impl$purchaseSubscription$2", f = "IapV4Impl.kt", i = {}, l = {587}, m = "invokeSuspend", n = {}, s = {})
    static final class C29142 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IAPV4.IAPV4Product $gameProduct;
        final /* synthetic */ JSONObject $jsonPrePurchaseData;
        final /* synthetic */ IAPV4.IAPV4PurchaseListener $listener;
        final /* synthetic */ String $marketPid;
        final /* synthetic */ IAPV4.IAPV4PurchaseParam $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29142(JSONObject jSONObject, IAPV4.IAPV4PurchaseParam iAPV4PurchaseParam, IAPV4.IAPV4PurchaseListener iAPV4PurchaseListener, String str, IAPV4.IAPV4Product iAPV4Product, Continuation<? super C29142> continuation) {
            super(2, continuation);
            this.$jsonPrePurchaseData = jSONObject;
            this.$param = iAPV4PurchaseParam;
            this.$listener = iAPV4PurchaseListener;
            this.$marketPid = str;
            this.$gameProduct = iAPV4Product;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29142(this.$jsonPrePurchaseData, this.$param, this.$listener, this.$marketPid, this.$gameProduct, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29142) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objPurchase$hive_iapv4_base_release$default;
            InnerPurchaseListener innerPurchaseListener;
            Object objM7415constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objPurchase$hive_iapv4_base_release$default = IapV4Network.purchase$hive_iapv4_base_release$default(IapV4Network.INSTANCE, IapV4Network.REQUEST_NETWORK_API.REQUEST_PRE_PURCHASE, this.$jsonPrePurchaseData, null, this, 4, null);
                if (objPurchase$hive_iapv4_base_release$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objPurchase$hive_iapv4_base_release$default = obj;
            }
            Purchase purchase = (Purchase) objPurchase$hive_iapv4_base_release$default;
            if (purchase.getResponse().isSuccess()) {
                BaseMarketAPI baseMarketAPI = (BaseMarketAPI) IapV4Impl.markets.get(IapV4Impl.INSTANCE.getSelectedMarket());
                IAPV4.IAPV4PurchaseParam iAPV4PurchaseParam = this.$param;
                IAPV4.IAPV4PurchaseListener iAPV4PurchaseListener = this.$listener;
                if (iAPV4PurchaseListener instanceof InnerPurchaseListener) {
                    innerPurchaseListener = (InnerPurchaseListener) iAPV4PurchaseListener;
                } else {
                    InnerPurchaseListener innerPurchaseListener2 = new InnerPurchaseListener(iAPV4PurchaseListener);
                    innerPurchaseListener2.setMarketPid(this.$marketPid);
                    Unit unit = Unit.INSTANCE;
                    innerPurchaseListener = innerPurchaseListener2;
                }
                baseMarketAPI.purchaseSubscription(iAPV4PurchaseParam, innerPurchaseListener);
                IAPV4.IAPV4Product iAPV4Product = this.$gameProduct;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Analytics.AnalyticsRevenue analyticsRevenue = new Analytics.AnalyticsRevenue(null, null, null, null, 0L, null, null, 0, null, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
                    analyticsRevenue.setProductType(iAPV4Product.getProductType());
                    analyticsRevenue.setCurrency(iAPV4Product.getCurrency());
                    analyticsRevenue.setTitle(iAPV4Product.getTitle());
                    analyticsRevenue.setPid(iAPV4Product.getMarketPid());
                    analyticsRevenue.setPrice(NumberFormat.getInstance().format(iAPV4Product.getPrice()));
                    AnalyticsImpl.INSTANCE.sendStandardRevenueEvent(AnalyticsProviderAdapter.StandardEventType.PURCHASE_START, analyticsRevenue);
                    objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                IAPV4.IAPV4Product iAPV4Product2 = this.$gameProduct;
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl != null) {
                    LoggerImpl.INSTANCE.d("[HiveIAP] PurchaseSubscription sendStandardRevenueEvent exception : " + thM7418exceptionOrNullimpl + ", gameProduct price : " + iAPV4Product2.getPrice());
                }
                Result.m7414boximpl(objM7415constructorimpl);
            } else {
                String str = "[HiveIAP] PurchaseSubscription pre-purchase response failed(" + purchase.getResponse().getIapV4Result() + "): " + purchase.getResponse().getIapV4ResultMsg();
                LoggerImpl.INSTANCE.w(str);
                IapV4Impl.INSTANCE.onPurchaseFinish(new ResultAPI(-8, ResultAPI.Code.IAPV4ResponseError, str), null, this.$listener);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public synchronized void voidPurchase(String marketPid, String iapPayload, int quantity, int refundIndex, IAPV4.IAPV4PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.dL("[HiveIAP] voidPurchase marketPid: " + marketPid + ", iapPayload: " + iapPayload + ", refundIndex: " + refundIndex);
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        StringBuilder sb = new StringBuilder("[HiveIAP] voidPurchase marketPid: ");
        sb.append(marketPid);
        sb.append(", refundIndex: ");
        sb.append(refundIndex);
        loggerImpl.dR(sb.toString());
        InnerPurchaseListener innerPurchaseListener = new InnerPurchaseListener(listener);
        innerPurchaseListener.setMarketPid(marketPid);
        innerPurchaseListener.setVoid(true);
        innerPurchaseListener.setRefundIndex(refundIndex);
        Unit unit = Unit.INSTANCE;
        purchase(marketPid, iapPayload, quantity, innerPurchaseListener);
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public synchronized void restore(final IAPV4.IAPV4RestoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] restore");
        ResultAPI resultAPICheckParams = checkParams("restore", listener);
        if (resultAPICheckParams.isFailure()) {
            onRestoreFinish(resultAPICheckParams, null, listener);
            return;
        }
        int i = selectedMarket;
        if (i == 0) {
            LoggerImpl.INSTANCE.w("[HiveIAP] restore no selected market");
            onRestoreFinish(new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] restore need initialize, getProductInfo or showPayment API"), null, listener);
        } else if (!markets.get(i).isGetConsumableProductList()) {
            LoggerImpl.INSTANCE.w("[HiveIAP] restore product list is empty. try internal getProductInfo().");
            markets.get(selectedMarket).getProductInfo(new IAPV4.IAPV4ProductInfoListener() { // from class: com.hive.iapv4.IapV4Impl.restore.1
                @Override // com.hive.IAPV4.IAPV4ProductInfoListener
                public void onIAPV4ProductInfo(ResultAPI result, ArrayList<IAPV4.IAPV4Product> iapV4ProductList, int balance) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (result.isSuccess()) {
                        LoggerImpl.INSTANCE.w("[HiveIAP] restore internal getProductInfo() success. try restore.");
                        ((BaseMarketAPI) IapV4Impl.markets.get(IapV4Impl.INSTANCE.getSelectedMarket())).restore(listener);
                        return;
                    }
                    LoggerImpl.INSTANCE.w("[HiveIAP] restore product list is empty. plz try getProductInfo() first. : " + result);
                    IapV4Impl.INSTANCE.onRestoreFinish(new ResultAPI(-8, ResultAPI.Code.IAPV4EmptyProductList, "[HiveIAP] restore product list is empty. plz try getProductInfo() first. : " + result), null, listener);
                }
            });
        } else {
            markets.get(selectedMarket).restore(listener);
        }
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public synchronized void restoreSubscription(final IAPV4.IAPV4RestoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] restoreSubscription");
        ResultAPI resultAPICheckParams = checkParams("restoreSubscription", listener);
        if (resultAPICheckParams.isFailure()) {
            onRestoreFinish(resultAPICheckParams, null, listener);
            return;
        }
        int i = selectedMarket;
        if (i == 0) {
            LoggerImpl.INSTANCE.w("[HiveIAP] restoreSubscription no selected market");
            onRestoreFinish(new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] restore need initialize, getProductInfo or showPayment API"), null, listener);
        } else if (!markets.get(i).isGetSubscriptionProductList()) {
            LoggerImpl.INSTANCE.w("[HiveIAP] restoreSubscription product list is empty. try internal getProductInfo().");
            markets.get(selectedMarket).getSubscriptionProductInfo(new IAPV4.IAPV4ProductInfoListener() { // from class: com.hive.iapv4.IapV4Impl.restoreSubscription.1
                @Override // com.hive.IAPV4.IAPV4ProductInfoListener
                public void onIAPV4ProductInfo(ResultAPI result, ArrayList<IAPV4.IAPV4Product> iapV4ProductList, int balance) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (result.isSuccess()) {
                        LoggerImpl.INSTANCE.w("[HiveIAP] restoreSubscription internal getProductInfo() success. try restore.");
                        ((BaseMarketAPI) IapV4Impl.markets.get(IapV4Impl.INSTANCE.getSelectedMarket())).restore(listener);
                        return;
                    }
                    LoggerImpl.INSTANCE.w("[HiveIAP] restoreSubscription product list is empty. plz try getProductInfo() first. : " + result);
                    IapV4Impl.INSTANCE.onRestoreFinish(new ResultAPI(-8, ResultAPI.Code.IAPV4EmptyProductList, "[HiveIAP] restore product list is empty. plz try getProductInfo() first. : " + result), null, listener);
                }
            });
        } else {
            markets.get(selectedMarket).restoreSubscription(listener);
        }
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public synchronized void voidRestore(IAPV4.IAPV4RestoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] voidRestore");
        InnerRestoreListener innerRestoreListener = new InnerRestoreListener(listener);
        innerRestoreListener.setVoid(true);
        restore(innerRestoreListener);
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public synchronized void transactionFinish(String marketPid, IAPV4.IAPV4TransactionFinishListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] transactionFinish marketPid: " + marketPid);
        ResultAPI resultAPICheckParams = checkParams("transactionFinish", listener);
        if (resultAPICheckParams.isFailure()) {
            listener.onIAPV4TransactionFinish(resultAPICheckParams, marketPid);
            return;
        }
        if (StringsKt.isBlank(marketPid)) {
            LoggerImpl.INSTANCE.e("[HiveIAP] transactionFinish marketPid is empty");
            listener.onIAPV4TransactionFinish(new ResultAPI(-1, ResultAPI.Code.IAPV4FinishMarketPidEmpty, "[HiveIAP] transactionFinish need marketPid"), marketPid);
            return;
        }
        int i = selectedMarket;
        if (i == 0) {
            LoggerImpl.INSTANCE.w("[HiveIAP] transactionFinish no selected market");
            listener.onIAPV4TransactionFinish(new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] transactionFinish need initialize, productInfo or showPayment API"), marketPid);
        } else {
            markets.get(i).transactionFinish(marketPid, listener);
        }
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public synchronized void voidTransactionFinish(String marketPid, IAPV4.IAPV4TransactionFinishListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] voidTransactionFinish marketPid: " + marketPid);
        InnerTransactionFinishListener innerTransactionFinishListener = new InnerTransactionFinishListener(listener);
        innerTransactionFinishListener.setVoid(true);
        Unit unit = Unit.INSTANCE;
        transactionFinish(marketPid, innerTransactionFinishListener);
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public synchronized void transactionMultiFinish(final ArrayList<String> marketPidList, final IAPV4.IAPV4TransactionMultiFinishListener listener) {
        Intrinsics.checkNotNullParameter(marketPidList, "marketPidList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] transactionMultiFinish");
        ResultAPI resultAPICheckParams = checkParams("transactionMultiFinish", listener);
        if (resultAPICheckParams.isFailure()) {
            ArrayList<ResultAPI> arrayList = new ArrayList<>();
            Iterator<String> it = marketPidList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                String next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                String str = next;
                arrayList.add(resultAPICheckParams);
            }
            listener.onIAPV4TransactionMultiFinish(arrayList, marketPidList);
            return;
        }
        if (marketPidList.isEmpty()) {
            LoggerImpl.INSTANCE.e("[HiveIAP] transactionMultiFinish marketPid is empty");
            ArrayList<ResultAPI> arrayList2 = new ArrayList<>();
            arrayList2.add(new ResultAPI(-1, ResultAPI.Code.IAPV4FinishMarketPidEmpty, "[HiveIAP] transactionMultiFinish need marketPid"));
            listener.onIAPV4TransactionMultiFinish(arrayList2, marketPidList);
            return;
        }
        if (selectedMarket == 0) {
            LoggerImpl.INSTANCE.w("[HiveIAP] transactionMultiFinish no selected market");
            ArrayList<ResultAPI> arrayList3 = new ArrayList<>();
            arrayList3.add(new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] transactionMultiFinish need initialize, productInfo or showPayment API"));
            listener.onIAPV4TransactionMultiFinish(arrayList3, marketPidList);
        } else {
            Android.INSTANCE.executeAsync(new CallableC29181(marketPidList, listener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    IapV4Impl.transactionMultiFinish$lambda$11(marketPidList, listener);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.hive.iapv4.IapV4Impl$transactionMultiFinish$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IapV4Impl.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0010"}, d2 = {"com/hive/iapv4/IapV4Impl$transactionMultiFinish$1", "Ljava/util/concurrent/Callable;", "Ljava/lang/Void;", "resultAPIList", "Ljava/util/ArrayList;", "Lcom/hive/ResultAPI;", "Lkotlin/collections/ArrayList;", "getResultAPIList", "()Ljava/util/ArrayList;", "setResultAPIList", "(Ljava/util/ArrayList;)V", "resultMarketPidList", "", "getResultMarketPidList", "setResultMarketPidList", NotificationCompat.CATEGORY_CALL, "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CallableC29181 implements Callable<Void> {
        final /* synthetic */ IAPV4.IAPV4TransactionMultiFinishListener $listener;
        final /* synthetic */ ArrayList<String> $marketPidList;
        private ArrayList<ResultAPI> resultAPIList = new ArrayList<>();
        private ArrayList<String> resultMarketPidList = new ArrayList<>();

        CallableC29181(ArrayList<String> arrayList, IAPV4.IAPV4TransactionMultiFinishListener iAPV4TransactionMultiFinishListener) {
            this.$marketPidList = arrayList;
            this.$listener = iAPV4TransactionMultiFinishListener;
        }

        public final ArrayList<ResultAPI> getResultAPIList() {
            return this.resultAPIList;
        }

        public final void setResultAPIList(ArrayList<ResultAPI> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.resultAPIList = arrayList;
        }

        public final ArrayList<String> getResultMarketPidList() {
            return this.resultMarketPidList;
        }

        public final void setResultMarketPidList(ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.resultMarketPidList = arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            Iterator<String> it = this.$marketPidList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                String next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                ((BaseMarketAPI) IapV4Impl.markets.get(IapV4Impl.INSTANCE.getSelectedMarket())).transactionFinish(next, new IAPV4.IAPV4TransactionFinishListener() { // from class: com.hive.iapv4.IapV4Impl$transactionMultiFinish$1$call$1
                    @Override // com.hive.IAPV4.IAPV4TransactionFinishListener
                    public void onIAPV4TransactionFinish(ResultAPI result, String marketPid) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
                        this.this$0.getResultAPIList().add(result);
                        this.this$0.getResultMarketPidList().add(marketPid);
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await();
                    Unit unit = Unit.INSTANCE;
                } catch (Exception unused) {
                    Boolean.valueOf(this.resultAPIList.add(new ResultAPI(-8, ResultAPI.Code.IAPV4ResponseError)));
                }
            }
            this.$listener.onIAPV4TransactionMultiFinish(this.resultAPIList, this.resultMarketPidList);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void transactionMultiFinish$lambda$11(ArrayList arrayList, IAPV4.IAPV4TransactionMultiFinishListener iAPV4TransactionMultiFinishListener) {
        ArrayList<ResultAPI> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            arrayList2.add(new ResultAPI(-4, ResultAPI.Code.IAPV4ResponseError));
        }
        iAPV4TransactionMultiFinishListener.onIAPV4TransactionMultiFinish(arrayList2, arrayList);
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public void showMarketSelection(final IAPV4.IAPV4MarketInfoListener listener) {
        String str;
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] showMarketSelection");
        final String str2 = marketSelectUrl;
        if (!isInitialized) {
            LoggerImpl.INSTANCE.e("[HiveIAP] showMarketSelection need initialize");
            listener.onIAPV4MarketInfo(new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] showMarketSelection need initialize"), null);
            return;
        }
        if (selectedMarket != 0 && ((str = str2) == null || StringsKt.isBlank(str))) {
            LoggerImpl.INSTANCE.i("[HiveIAP] showMarketSelection auto selected: " + selectedMarket);
            ArrayList<IAPV4.IAPV4Type> arrayList = new ArrayList<>();
            arrayList.add(IAPV4.IAPV4Type.INSTANCE.findValue(selectedMarket));
            listener.onIAPV4MarketInfo(new ResultAPI(0, ResultAPI.Code.Success, "success"), arrayList);
            return;
        }
        String str3 = str2;
        if (str3 == null || StringsKt.isBlank(str3)) {
            listener.onIAPV4MarketInfo(new ResultAPI(-8, ResultAPI.Code.IAPV4EmptyMarketURL, "Market selection URL is empty or null"), null);
            return;
        }
        if (isShowPayment) {
            listener.onIAPV4MarketInfo(new ResultAPI(-3, ResultAPI.Code.IAPV4InProgressMarketSelect, "ShowPayment is already in progress"), null);
            return;
        }
        isShowPayment = true;
        String gameLanguage = Configuration.INSTANCE.getGameLanguage();
        String language = Android.INSTANCE.getLanguage();
        JSONObject jSONObject = new JSONObject();
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_game_language;
            String str4 = gameLanguage;
            if (StringsKt.isBlank(str4)) {
                str4 = "";
            }
            CommonIdentifierKt.put(jSONObject, hiveKeys, str4);
            HiveKeys hiveKeys2 = HiveKeys.KEY_language;
            String str5 = language;
            if (str5 == null || StringsKt.isBlank(str5)) {
                language = "";
            }
            CommonIdentifierKt.put(jSONObject, hiveKeys2, language);
        } catch (JSONException e) {
            LoggerImpl.INSTANCE.w("[HiveIAP] showPayment create param failed, json exception. : " + e);
        }
        final String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                IapV4Impl.showMarketSelection$lambda$14(str2, string, handler, listener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMarketSelection$lambda$14(String str, String str2, Handler handler, IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener) {
        Intent intent = new Intent();
        intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new IapV4Impl$showMarketSelection$3$1(str, str2, handler, iAPV4MarketInfoListener));
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public void getBalanceInfo(IAPV4.IAPV4BalanceInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] getBalanceInfo");
        ResultAPI resultAPICheckParams = checkParams("balance", listener);
        if (resultAPICheckParams.isFailure()) {
            listener.onIAPV4Balance(resultAPICheckParams, 0);
            return;
        }
        int i = selectedMarket;
        if (i == 0) {
            LoggerImpl.INSTANCE.w("[HiveIAP] balance no selected market");
            listener.onIAPV4Balance(new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] getBalanceInfo need initialize, getProductInfo or showPayment API"), 0);
        } else {
            markets.get(i).getBalanceInfo(listener);
        }
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public void showCharge(IAPV4.IAPV4BalanceInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] showCharge");
        ResultAPI resultAPICheckParams = checkParams("showCharge", listener);
        if (resultAPICheckParams.isFailure()) {
            listener.onIAPV4Balance(resultAPICheckParams, 0);
            return;
        }
        int i = selectedMarket;
        if (i == 0) {
            LoggerImpl.INSTANCE.w("[HiveIAP] showCharge no selected market");
            listener.onIAPV4Balance(new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] showCharge need initialize, getProductInfo or showPayment API"), 0);
        } else {
            markets.get(i).showCharge(listener);
        }
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public void checkPromotePurchase(IAPV4.IAPV4CheckPromotePurchaseListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] checkPromotePurchase");
        ResultAPI resultAPICheckParams = checkParams("checkPromotePurchase", listener);
        if (resultAPICheckParams.isFailure()) {
            listener.onIAPV4CheckPromotePurchase(resultAPICheckParams, null);
            return;
        }
        if (selectedMarket == 0) {
            LoggerImpl.INSTANCE.w("[HiveIAP] purchase no selected market");
            listener.onIAPV4CheckPromotePurchase(new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] purchase need initialize, getProductInfo or showPayment API"), null);
            return;
        }
        String str = promotePurchaseMarketPid;
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            listener.onIAPV4CheckPromotePurchase(new ResultAPI(10, ResultAPI.Code.IAPV4PromoteMarketPidEmpty, "[HIVEIAP] Promote purchase MarketPid is empty or null"), null);
        } else {
            listener.onIAPV4CheckPromotePurchase(new ResultAPI(), str);
            promotePurchaseMarketPid = null;
        }
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public void setPromotePurchaseMarketPid(String marketPID) {
        Intrinsics.checkNotNullParameter(marketPID, "marketPID");
        LoggerImpl.INSTANCE.w("[HiveIAP] SetPromotePurchaseMarketpid : " + marketPID);
        promotePurchaseMarketPid = marketPID;
    }

    public final Analytics.AnalyticsRevenue createAnalyticsRevenue$hive_iapv4_base_release(IAPV4.IAPV4Receipt iapv4Receipt) {
        Intrinsics.checkNotNullParameter(iapv4Receipt, "iapv4Receipt");
        if (selectedMarket == 0) {
            LoggerImpl.INSTANCE.e("[HiveIAP] sendIapAnalyticsLog no selected market");
            return null;
        }
        Analytics.AnalyticsRevenue analyticsRevenue = new Analytics.AnalyticsRevenue(null, null, null, null, 0L, null, null, 0, null, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
        analyticsRevenue.setAmountMicros(((long) iapv4Receipt.getProduct().getPrice()) * ((long) 1000000));
        analyticsRevenue.setCurrency(iapv4Receipt.getProduct().getCurrency());
        analyticsRevenue.setDescription(iapv4Receipt.getProduct().getDescription());
        analyticsRevenue.setPrice(NumberFormat.getInstance().format(iapv4Receipt.getProduct().getPrice()));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%s %s", Arrays.copyOf(new Object[]{analyticsRevenue.getCurrency(), analyticsRevenue.getPrice()}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        analyticsRevenue.setFormattedString(str);
        analyticsRevenue.setItemCount(iapv4Receipt.getQuantity());
        analyticsRevenue.setPid(iapv4Receipt.getProduct().getMarketPid());
        analyticsRevenue.setTitle(iapv4Receipt.getProduct().getTitle());
        analyticsRevenue.setRefId(iapv4Receipt.getUniqueId());
        analyticsRevenue.setProductType(iapv4Receipt.getProduct().getProductType());
        return analyticsRevenue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void sendPurchaseLog$default(IapV4Impl iapV4Impl, ResultAPI resultAPI, boolean z, IapV4Network.REQUEST_NETWORK_API request_network_api, IAPV4.IAPV4Receipt[] iAPV4ReceiptArr, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = null;
        }
        iapV4Impl.sendPurchaseLog(resultAPI, z, request_network_api, iAPV4ReceiptArr, function1);
    }

    private final void sendPurchaseLog(ResultAPI resultApi, boolean isRestore, IapV4Network.REQUEST_NETWORK_API api, IAPV4.IAPV4Receipt[] iapv4Receipts, Function1<? super ArrayList<IAPV4.IAPV4Receipt>, Unit> callback) {
        LoggerImpl.INSTANCE.d("[HiveIAP] sendPurchaseLog");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C29171(iapv4Receipts, api, isRestore, resultApi, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.iapv4.IapV4Impl$sendPurchaseLog$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IapV4Impl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.IapV4Impl$sendPurchaseLog$1", f = "IapV4Impl.kt", i = {}, l = {1133}, m = "invokeSuspend", n = {}, s = {})
    static final class C29171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IapV4Network.REQUEST_NETWORK_API $api;
        final /* synthetic */ Function1<ArrayList<IAPV4.IAPV4Receipt>, Unit> $callback;
        final /* synthetic */ IAPV4.IAPV4Receipt[] $iapv4Receipts;
        final /* synthetic */ boolean $isRestore;
        final /* synthetic */ ResultAPI $resultApi;
        int I$0;
        int I$1;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C29171(IAPV4.IAPV4Receipt[] iAPV4ReceiptArr, IapV4Network.REQUEST_NETWORK_API request_network_api, boolean z, ResultAPI resultAPI, Function1<? super ArrayList<IAPV4.IAPV4Receipt>, Unit> function1, Continuation<? super C29171> continuation) {
            super(2, continuation);
            this.$iapv4Receipts = iAPV4ReceiptArr;
            this.$api = request_network_api;
            this.$isRestore = z;
            this.$resultApi = resultAPI;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29171(this.$iapv4Receipts, this.$api, this.$isRestore, this.$resultApi, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x017f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0179 -> B:42:0x017c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 406
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.IapV4Impl.C29171.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void onPurchaseFinish(final ResultAPI result, final IAPV4.IAPV4Receipt iapv4Receipt, final IAPV4.IAPV4PurchaseListener listener) {
        Object objM7415constructorimpl;
        Unit unit;
        Intrinsics.checkNotNullParameter(result, "result");
        LoggerImpl.INSTANCE.dL("[HiveIAP] onPurchaseFinish \nResultAPI: " + result + "\nIAPV4Receipt: " + iapv4Receipt);
        LoggerImpl.INSTANCE.dR("[HiveIAP] onPurchaseFinish \nResultAPI: " + result + "\nIAPV4Receipt: ");
        if (result.isSuccess() && iapv4Receipt != null) {
            sendPurchaseLog(result, false, IapV4Network.REQUEST_NETWORK_API.REQUEST_PURCHASE, new IAPV4.IAPV4Receipt[]{iapv4Receipt}, new Function1() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return IapV4Impl.onPurchaseFinish$lambda$18(listener, result, iapv4Receipt, (ArrayList) obj);
                }
            });
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                IapV4Impl.onPurchaseFinish$lambda$19(listener, result, iapv4Receipt);
            }
        });
        if (listener == null || !(listener instanceof InnerPurchaseListener) || ((InnerPurchaseListener) listener).getMarketPid().length() <= 0) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            IAPV4.IAPV4Product productInfo = markets.get(selectedMarket).getProductInfo(((InnerPurchaseListener) listener).getMarketPid());
            if (productInfo != null) {
                Analytics.AnalyticsRevenue analyticsRevenue = new Analytics.AnalyticsRevenue(null, null, null, null, 0L, null, null, 0, null, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
                analyticsRevenue.setProductType(productInfo.getProductType());
                analyticsRevenue.setPid(productInfo.getMarketPid());
                analyticsRevenue.setTitle(productInfo.getTitle());
                analyticsRevenue.setCurrency(productInfo.getCurrency());
                analyticsRevenue.setPrice(NumberFormat.getInstance().format(productInfo.getPrice()));
                AnalyticsImpl.INSTANCE.sendStandardRevenueEvent(AnalyticsProviderAdapter.StandardEventType.PURCHASE_CANCELED, analyticsRevenue);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            objM7415constructorimpl = Result.m7415constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.d("[HiveIAP] onPurchaseFinish sendStandardRevenueEvent exception : " + thM7418exceptionOrNullimpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onPurchaseFinish$lambda$18(final IAPV4.IAPV4PurchaseListener iAPV4PurchaseListener, final ResultAPI resultAPI, final IAPV4.IAPV4Receipt iAPV4Receipt, ArrayList arrayList) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                IapV4Impl.onPurchaseFinish$lambda$18$lambda$17(iAPV4PurchaseListener, resultAPI, iAPV4Receipt);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPurchaseFinish$lambda$18$lambda$17(IAPV4.IAPV4PurchaseListener iAPV4PurchaseListener, ResultAPI resultAPI, IAPV4.IAPV4Receipt iAPV4Receipt) {
        if (iAPV4PurchaseListener != null) {
            iAPV4PurchaseListener.onIAPV4Purchase(resultAPI, iAPV4Receipt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPurchaseFinish$lambda$19(IAPV4.IAPV4PurchaseListener iAPV4PurchaseListener, ResultAPI resultAPI, IAPV4.IAPV4Receipt iAPV4Receipt) {
        if (iAPV4PurchaseListener != null) {
            iAPV4PurchaseListener.onIAPV4Purchase(resultAPI, iAPV4Receipt);
        }
    }

    public final void onRestoreFinish(final ResultAPI result, final ArrayList<IAPV4.IAPV4Receipt> iapv4ReceiptList, final IAPV4.IAPV4RestoreListener listener) {
        Intrinsics.checkNotNullParameter(result, "result");
        LoggerImpl.INSTANCE.d("[HiveIAP] onRestoreFinish: " + result);
        if (result.isSuccess() && iapv4ReceiptList != null) {
            IapV4Network.REQUEST_NETWORK_API request_network_api = IapV4Network.REQUEST_NETWORK_API.REQUEST_PURCHASE;
            IAPV4.IAPV4Receipt[] iAPV4ReceiptArr = (IAPV4.IAPV4Receipt[]) iapv4ReceiptList.toArray(new IAPV4.IAPV4Receipt[0]);
            sendPurchaseLog(result, true, request_network_api, (IAPV4.IAPV4Receipt[]) Arrays.copyOf(iAPV4ReceiptArr, iAPV4ReceiptArr.length), new Function1() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return IapV4Impl.onRestoreFinish$lambda$26(listener, result, (ArrayList) obj);
                }
            });
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                IapV4Impl.onRestoreFinish$lambda$27(listener, result, iapv4ReceiptList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRestoreFinish$lambda$26(final IAPV4.IAPV4RestoreListener iAPV4RestoreListener, final ResultAPI resultAPI, final ArrayList arrayList) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                IapV4Impl.onRestoreFinish$lambda$26$lambda$25(iAPV4RestoreListener, resultAPI, arrayList);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRestoreFinish$lambda$26$lambda$25(IAPV4.IAPV4RestoreListener iAPV4RestoreListener, ResultAPI resultAPI, ArrayList arrayList) {
        if (iAPV4RestoreListener != null) {
            iAPV4RestoreListener.onIAPV4Restore(resultAPI, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRestoreFinish$lambda$27(IAPV4.IAPV4RestoreListener iAPV4RestoreListener, ResultAPI resultAPI, ArrayList arrayList) {
        if (iAPV4RestoreListener != null) {
            iAPV4RestoreListener.onIAPV4Restore(resultAPI, arrayList);
        }
    }

    public final void onTransactionFinish(final ResultAPI result, final String marketPid, IAPV4.IAPV4Receipt iapv4Receipt, final IAPV4.IAPV4TransactionFinishListener listener) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        LoggerImpl.INSTANCE.d("[HiveIAP] onTransactionFinish : " + result + "\nmarketPid : " + marketPid + "\niapv4Receipt : " + iapv4Receipt);
        if (iapv4Receipt != null) {
            sendPurchaseLog$default(this, result, false, IapV4Network.REQUEST_NETWORK_API.REQUEST_POST_PURCHASE, new IAPV4.IAPV4Receipt[]{iapv4Receipt}, null, 16, null);
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                IapV4Impl.onTransactionFinish$lambda$28(listener, result, marketPid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTransactionFinish$lambda$28(IAPV4.IAPV4TransactionFinishListener iAPV4TransactionFinishListener, ResultAPI resultAPI, String str) {
        if (iAPV4TransactionFinishListener != null) {
            iAPV4TransactionFinishListener.onIAPV4TransactionFinish(resultAPI, str);
        }
    }

    public final void onTransactionMultiFinish(final ArrayList<ResultAPI> resultList, final ArrayList<String> marketPidList, ArrayList<IAPV4.IAPV4Receipt> iapv4ReceiptList, final IAPV4.IAPV4TransactionMultiFinishListener listener) {
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        Intrinsics.checkNotNullParameter(marketPidList, "marketPidList");
        Intrinsics.checkNotNullParameter(iapv4ReceiptList, "iapv4ReceiptList");
        LoggerImpl.INSTANCE.d("[HiveIAP] onTransactionMultiFinish");
        int size = resultList.size();
        for (int i = 0; i < size; i++) {
            try {
                ResultAPI resultAPI = resultList.get(i);
                Intrinsics.checkNotNullExpressionValue(resultAPI, "get(...)");
                ResultAPI resultAPI2 = resultAPI;
                String str = marketPidList.get(i);
                Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                String str2 = str;
                IAPV4.IAPV4Receipt iAPV4Receipt = iapv4ReceiptList.get(i);
                LoggerImpl.INSTANCE.dL("[HiveIAP] onTransactionMultiFinish [" + i + "] : \nresult : " + resultAPI2 + "\nmarketPid : " + str2 + "\niapv4Receipt : " + iAPV4Receipt);
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                StringBuilder sb = new StringBuilder();
                sb.append("\n[HiveIAP] onTransactionMultiFinish [");
                sb.append(i);
                sb.append("] : \nresult : ");
                sb.append(resultAPI2);
                sb.append("\nmarketPid : ");
                sb.append(str2);
                loggerImpl.dR(sb.toString());
                if (iAPV4Receipt != null) {
                    sendPurchaseLog$default(this, resultAPI2, false, IapV4Network.REQUEST_NETWORK_API.REQUEST_POST_PURCHASE, new IAPV4.IAPV4Receipt[]{iAPV4Receipt}, null, 16, null);
                }
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("[HiveIAP] onTransactionMultiFinish exception : " + e);
                e.printStackTrace();
            }
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.iapv4.IapV4Impl$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                IapV4Impl.onTransactionMultiFinish$lambda$29(listener, resultList, marketPidList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTransactionMultiFinish$lambda$29(IAPV4.IAPV4TransactionMultiFinishListener iAPV4TransactionMultiFinishListener, ArrayList arrayList, ArrayList arrayList2) {
        if (iAPV4TransactionMultiFinishListener != null) {
            iAPV4TransactionMultiFinishListener.onIAPV4TransactionMultiFinish(arrayList, arrayList2);
        }
    }

    public final void onStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (isInitialized) {
            IapV4LogSender.INSTANCE.doWork();
        }
    }

    public final void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        isPause = false;
        if (isInitialized) {
            LoggerImpl.INSTANCE.d("[HiveIAP] resume");
            int size = markets.size();
            for (int i = 0; i < size; i++) {
                BaseMarketAPI baseMarketAPIValueAt = markets.valueAt(i);
                if (baseMarketAPIValueAt != null) {
                    baseMarketAPIValueAt.onResume(activity);
                }
            }
        }
    }

    public final void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        isPause = true;
        if (isInitialized) {
            LoggerImpl.INSTANCE.d("[HiveIAP] pause");
            int size = markets.size();
            for (int i = 0; i < size; i++) {
                BaseMarketAPI baseMarketAPIValueAt = markets.valueAt(i);
                if (baseMarketAPIValueAt != null) {
                    baseMarketAPIValueAt.onPause(activity);
                }
            }
        }
    }

    public final void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoggerImpl.INSTANCE.d("[HiveIAP] destroy");
        int size = markets.size();
        for (int i = 0; i < size; i++) {
            BaseMarketAPI baseMarketAPIValueAt = markets.valueAt(i);
            if (baseMarketAPIValueAt != null) {
                baseMarketAPIValueAt.onDestroy(activity);
            }
        }
        selectedMarket = 0;
        isInitialized = false;
    }

    public final void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoggerImpl.INSTANCE.d("[HiveIAP] onActivityResult");
        int size = markets.size();
        for (int i = 0; i < size; i++) {
            BaseMarketAPI baseMarketAPIValueAt = markets.valueAt(i);
            if (baseMarketAPIValueAt != null) {
                baseMarketAPIValueAt.onActivityResult(activity, requestCode, resultCode, data);
            }
        }
    }

    private final String getObfuscatedAccountId(HiveLifecycle.HiveAccount account) {
        String accountUuid = account.getAccountUuid();
        LoggerImpl.INSTANCE.dL("[HiveIAP] getObfuscatedAccountId: " + accountUuid);
        LoggerImpl.INSTANCE.dR("[HiveIAP] getObfuscatedAccountId");
        return accountUuid;
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    /* JADX INFO: renamed from: getSelectedMarket, reason: collision with other method in class */
    public IAPV4.IAPV4Type mo5533getSelectedMarket() {
        return IAPV4.IAPV4Type.INSTANCE.findValue(selectedMarket);
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public String getAccountUuid() {
        return getObfuscatedAccountId(HiveLifecycle.INSTANCE.getAccount());
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public void showInAppMessages(int categoryId, Function1<? super Integer, Unit> listener) {
        LoggerImpl.INSTANCE.d("[HiveIAP] showInAppMessages");
        IapV4Module market$hive_iapv4_base_release = IapV4Module.INSTANCE.getMarket$hive_iapv4_base_release(IAPV4.IAPV4Type.GOOGLE_PLAYSTORE);
        BaseMarketAPI marketModuleInstance = market$hive_iapv4_base_release != null ? market$hive_iapv4_base_release.getMarketModuleInstance() : null;
        if (selectedMarket == IAPV4.IAPV4Type.GOOGLE_PLAYSTORE.getValue() && marketModuleInstance != null) {
            marketModuleInstance.showInAppMessages(categoryId, listener);
            return;
        }
        LoggerImpl.INSTANCE.w("[HiveIAP] showInAppMessages - no selected PlayStore");
        if (listener != null) {
            listener.invoke(-98);
        }
    }

    @Override // com.hive.module.interfaces.HiveIapV4
    public String getMarketSDKVersion(IAPV4.IAPV4Type type, String sdkType) {
        Intrinsics.checkNotNullParameter(type, "type");
        return "not imported";
    }

    private final ResultAPI checkParams(String apiName, Object o) {
        String uid;
        BaseMarketAPI baseMarketAPI;
        LoggerImpl.INSTANCE.d("[HiveIAP] checkParams: " + apiName);
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            LoggerImpl.INSTANCE.e("[HiveIAP] " + apiName + " need auth initialize");
            return new ResultAPI(-7, ResultAPI.Code.IAPV4NotInitialize, "[HiveIAP] " + apiName + " need auth initialize");
        }
        if (!isInitialized) {
            LoggerImpl.INSTANCE.e("[HiveIAP] " + apiName + " need market initialize");
            return new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] " + apiName + " need market initialize");
        }
        HiveLifecycle.HiveAccount account = HiveLifecycle.INSTANCE.getAccount();
        String vid = account.getVid();
        if ((vid == null || StringsKt.isBlank(vid)) && ((uid = account.getUid()) == null || StringsKt.isBlank(uid))) {
            Logger.INSTANCE.e("[HiveIAP] " + apiName + " need login");
            return new ResultAPI(-9, ResultAPI.Code.IAPV4NeedSignIn, "[HiveIAP] " + apiName + " need login");
        }
        int i = selectedMarket;
        if (i != 0 && ((baseMarketAPI = markets.get(i)) == null || !baseMarketAPI.getIsInitialized())) {
            LoggerImpl.INSTANCE.e("[HiveIAP] " + apiName + " need market initialize");
            return new ResultAPI(-8, ResultAPI.Code.IAPV4NeedMarketConnect, "[HiveIAP] " + apiName + " need market initialize");
        }
        return new ResultAPI(0, ResultAPI.Code.Success, "[HiveIAP] success");
    }

    /* JADX INFO: compiled from: IapV4Impl.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0011j\b\u0012\u0004\u0012\u00020\u0003`\u00122\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005R*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0011j\b\u0012\u0004\u0012\u00020\u0003`\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0011j\b\u0012\u0004\u0012\u00020\u0003`\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0005R\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0005R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lcom/hive/iapv4/IapV4Impl$IAPV4Market;", "", "jsonMarketInfo", "", "<init>", "(Ljava/lang/String;)V", "iapType", "Lcom/hive/IAPV4$IAPV4Type;", "getIapType", "()Lcom/hive/IAPV4$IAPV4Type;", "setIapType", "(Lcom/hive/IAPV4$IAPV4Type;)V", "marketAppId", "getMarketAppId", "()Ljava/lang/String;", "setMarketAppId", "marketPidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMarketPidList", "()Ljava/util/ArrayList;", "setMarketPidList", "(Ljava/util/ArrayList;)V", "marketSubscriptionPidList", "getMarketSubscriptionPidList", "setMarketSubscriptionPidList", "originalJson", InAppPurchaseConstants.METHOD_GET_ORIGINAL_JSON, "setOriginalJson", "licenseKey", "getLicenseKey", "setLicenseKey", "receiptLevel", "", "getReceiptLevel", "()I", "setReceiptLevel", "(I)V", "createMarketPidList", "array", "Lorg/json/JSONArray;", "toJson", "Lorg/json/JSONObject;", InAppPurchaseConstants.METHOD_TO_STRING, "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IAPV4Market {
        private IAPV4.IAPV4Type iapType;
        private String licenseKey;
        private String marketAppId;
        private ArrayList<String> marketPidList;
        private ArrayList<String> marketSubscriptionPidList;
        private String originalJson;
        private int receiptLevel;

        public IAPV4Market(String jsonMarketInfo) throws JSONException {
            Intrinsics.checkNotNullParameter(jsonMarketInfo, "jsonMarketInfo");
            this.marketSubscriptionPidList = new ArrayList<>();
            this.originalJson = jsonMarketInfo;
            this.licenseKey = "";
            if (StringsKt.isBlank(jsonMarketInfo)) {
                throw new JSONException("jsonMarketInfo is null");
            }
            JSONObject jSONObject = new JSONObject(this.originalJson);
            this.iapType = IAPV4.IAPV4Type.INSTANCE.findValue(jSONObject.getInt("market_id"));
            String strOptString = jSONObject.optString("market_app_id");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.marketAppId = strOptString;
            this.receiptLevel = jSONObject.optInt("receipt_level", 0);
            this.marketPidList = createMarketPidList(jSONObject.optJSONArray("market_pid_list"));
            this.marketSubscriptionPidList = createMarketPidList(jSONObject.optJSONArray("market_subs_pid_list"));
            if (this.marketPidList.isEmpty() && this.marketSubscriptionPidList.isEmpty()) {
                throw new JSONException("Invalid market pid list");
            }
        }

        public final IAPV4.IAPV4Type getIapType() {
            return this.iapType;
        }

        public final void setIapType(IAPV4.IAPV4Type iAPV4Type) {
            Intrinsics.checkNotNullParameter(iAPV4Type, "<set-?>");
            this.iapType = iAPV4Type;
        }

        public final String getMarketAppId() {
            return this.marketAppId;
        }

        public final void setMarketAppId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.marketAppId = str;
        }

        public final ArrayList<String> getMarketPidList() {
            return this.marketPidList;
        }

        public final void setMarketPidList(ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.marketPidList = arrayList;
        }

        public final ArrayList<String> getMarketSubscriptionPidList() {
            return this.marketSubscriptionPidList;
        }

        public final void setMarketSubscriptionPidList(ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.marketSubscriptionPidList = arrayList;
        }

        public final String getOriginalJson() {
            return this.originalJson;
        }

        public final void setOriginalJson(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.originalJson = str;
        }

        public final String getLicenseKey() {
            return this.licenseKey;
        }

        public final void setLicenseKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.licenseKey = str;
        }

        public final int getReceiptLevel() {
            return this.receiptLevel;
        }

        public final void setReceiptLevel(int i) {
            this.receiptLevel = i;
        }

        private final ArrayList<String> createMarketPidList(JSONArray array) {
            if (array == null) {
                return new ArrayList<>();
            }
            int length = array.length();
            ArrayList<String> arrayList = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(array.getString(i));
            }
            return arrayList;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("marketId", this.iapType);
                jSONObject.put("marketAppId", this.marketAppId);
                jSONObject.put("marketPidList", this.marketPidList);
                jSONObject.put("marketSubscriptionPidList", this.marketSubscriptionPidList);
                jSONObject.put("originalJson", this.originalJson);
                jSONObject.put("licenseKey", this.licenseKey);
                jSONObject.put("receiptLevel", this.receiptLevel);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("IAPMarket ");
            stringBuffer.append(toJson().toString());
            stringBuffer.append("\n");
            String string = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    /* JADX INFO: compiled from: IapV4Impl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/hive/iapv4/IapV4Impl$TransactionInfo;", "Lcom/hive/base/DataModel;", "<init>", "()V", "Transaction", k.M, "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TransactionInfo extends DataModel {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private static ArrayList<Transaction> transactions;

        /* JADX INFO: compiled from: IapV4Impl.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020\u0006H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010¨\u0006&"}, d2 = {"Lcom/hive/iapv4/IapV4Impl$TransactionInfo$Transaction;", "Lcom/hive/base/DataModel;", "Ljava/io/Serializable;", "marketId", "", "marketPid", "", "<init>", "(ILjava/lang/String;)V", "getMarketId", "()I", "setMarketId", "(I)V", "getMarketPid", "()Ljava/lang/String;", "setMarketPid", "(Ljava/lang/String;)V", "serverId", "getServerId", "setServerId", "iapPayload", "getIapPayload", "setIapPayload", "purchaseVid", "getPurchaseVid", "setPurchaseVid", "receipt", "getReceipt", "setReceipt", InAppPurchaseMetaData.KEY_SIGNATURE, "getSignature", "setSignature", "equals", "", "other", "", InAppPurchaseConstants.METHOD_TO_STRING, k.M, "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Transaction extends DataModel implements Serializable {
            private static final long serialVersionUID = 324897349;
            private String iapPayload;
            private int marketId;
            private String marketPid;
            private String purchaseVid;
            private String receipt;
            private String serverId;
            private String signature;

            public Transaction(int i, String marketPid) {
                Intrinsics.checkNotNullParameter(marketPid, "marketPid");
                this.marketId = i;
                this.marketPid = marketPid;
            }

            public final int getMarketId() {
                return this.marketId;
            }

            public final String getMarketPid() {
                return this.marketPid;
            }

            public final void setMarketId(int i) {
                this.marketId = i;
            }

            public final void setMarketPid(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.marketPid = str;
            }

            public final String getServerId() {
                return this.serverId;
            }

            public final void setServerId(String str) {
                this.serverId = str;
            }

            public final String getIapPayload() {
                return this.iapPayload;
            }

            public final void setIapPayload(String str) {
                this.iapPayload = str;
            }

            public final String getPurchaseVid() {
                return this.purchaseVid;
            }

            public final void setPurchaseVid(String str) {
                this.purchaseVid = str;
            }

            public final String getReceipt() {
                return this.receipt;
            }

            public final void setReceipt(String str) {
                this.receipt = str;
            }

            public final String getSignature() {
                return this.signature;
            }

            public final void setSignature(String str) {
                this.signature = str;
            }

            public boolean equals(Object other) {
                if (!(other instanceof Transaction)) {
                    return false;
                }
                Transaction transaction = (Transaction) other;
                return this.marketId == transaction.marketId && Intrinsics.areEqual(this.marketPid, transaction.marketPid);
            }

            @Override // com.hive.base.DataModel
            public String toString() {
                return "\nmarketId : " + this.marketId + "\nmarketPid : " + this.marketPid + "\nserverId : " + this.serverId + "\niapPayload : " + this.iapPayload + "\npurchaseVid : " + this.purchaseVid + "\n\nreceipt : " + this.receipt + "\nsignature : " + this.signature + '\n';
            }
        }

        /* JADX INFO: compiled from: IapV4Impl.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\u000eJ\n\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/hive/iapv4/IapV4Impl$TransactionInfo$Companion;", "", "<init>", "()V", "transactions", "Ljava/util/ArrayList;", "Lcom/hive/iapv4/IapV4Impl$TransactionInfo$Transaction;", "Lkotlin/collections/ArrayList;", "get", "marketId", "", "marketPid", "", ProductAction.ACTION_ADD, "", "transaction", "isContains", "", ProductAction.ACTION_REMOVE, "reset", "save", "load", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ArrayList<Transaction> get() {
                if (TransactionInfo.transactions.isEmpty()) {
                    load();
                }
                return TransactionInfo.transactions;
            }

            public final Transaction get(int marketId, String marketPid) {
                Intrinsics.checkNotNullParameter(marketPid, "marketPid");
                Transaction transaction = new Transaction(marketId, marketPid);
                if (TransactionInfo.transactions.isEmpty()) {
                    load();
                }
                int iIndexOf = TransactionInfo.transactions.indexOf(transaction);
                if (iIndexOf < 0) {
                    return null;
                }
                return (Transaction) TransactionInfo.transactions.get(iIndexOf);
            }

            public final void add(Transaction transaction) {
                Intrinsics.checkNotNullParameter(transaction, "transaction");
                if (TransactionInfo.transactions.isEmpty()) {
                    load();
                }
                TransactionInfo.transactions.add(transaction);
                save();
            }

            public final boolean isContains(int marketId, String marketPid) {
                Intrinsics.checkNotNullParameter(marketPid, "marketPid");
                Transaction transaction = new Transaction(marketId, marketPid);
                if (TransactionInfo.transactions.isEmpty()) {
                    load();
                }
                return TransactionInfo.transactions.contains(transaction);
            }

            public final void remove(Transaction transaction) {
                Intrinsics.checkNotNullParameter(transaction, "transaction");
                if (TransactionInfo.transactions.isEmpty()) {
                    load();
                }
                if (TransactionInfo.transactions.remove(transaction)) {
                    save();
                }
            }

            public final void remove(int marketId, String marketPid) {
                Intrinsics.checkNotNullParameter(marketPid, "marketPid");
                Transaction transaction = new Transaction(marketId, marketPid);
                if (TransactionInfo.transactions.isEmpty()) {
                    load();
                }
                if (TransactionInfo.transactions.remove(transaction)) {
                    save();
                }
            }

            public final void reset() {
                TransactionInfo.transactions.clear();
                TransactionInfo.transactions = new ArrayList();
                save();
            }

            private final String save() {
                String strSerialize = Android.INSTANCE.serialize(TransactionInfo.transactions);
                if (strSerialize != null && (!StringsKt.isBlank(strSerialize))) {
                    Property.setValue$default(Property.INSTANCE.getINSTANCE(), IapV4Keys.PURCHASE_TRANSACTION_INFO_PROPERTY, strSerialize, null, 4, null);
                    Property.INSTANCE.getINSTANCE().writeProperties();
                }
                return strSerialize;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final ArrayList<Transaction> load() {
                String value = Property.INSTANCE.getINSTANCE().getValue(IapV4Keys.PURCHASE_TRANSACTION_INFO_PROPERTY);
                String str = value;
                if (str == null || StringsKt.isBlank(str)) {
                    TransactionInfo.transactions = new ArrayList();
                } else {
                    try {
                        Object objDeserialize = Android.INSTANCE.deserialize(value);
                        Intrinsics.checkNotNull(objDeserialize, "null cannot be cast to non-null type java.util.ArrayList<com.hive.iapv4.IapV4Impl.TransactionInfo.Transaction>");
                        TransactionInfo.transactions = (ArrayList) objDeserialize;
                    } catch (Exception e) {
                        LoggerImpl.INSTANCE.w("[HiveIAP] Transaction load failed. " + e);
                        TransactionInfo.transactions = new ArrayList();
                    }
                }
                return TransactionInfo.transactions;
            }
        }

        static {
            Companion companion = new Companion(null);
            INSTANCE = companion;
            transactions = companion.load();
        }
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Iapv4(), "26.2.0");
        return map;
    }
}
