package com.hive.iapv4.market.google;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.runtime.ComposerKt;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.InAppMessageParams;
import com.android.billingclient.api.InAppMessageResponseListener;
import com.android.billingclient.api.InAppMessageResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.iapv4.market.google.PlayStoreHelper;
import com.hive.logger.LoggerImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: PlayStoreHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001?B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\b\u0010\u0017\u001a\u00020\nH\u0002J\u000e\u0010\u0018\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0019J.\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` H\u0086@¢\u0006\u0002\u0010!J.\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` H\u0086@¢\u0006\u0002\u0010!J6\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010$\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010%Jn\u0010&\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010\u001f2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\u001f28\u0010,\u001a4\u0012\u0013\u0012\u00110.¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0015\u0012\u0013\u0018\u00010*¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00060-J,\u00103\u001a\u0018\u0012\u0004\u0012\u00020.\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010\u001b042\u0006\u0010$\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u00105J$\u00106\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010*042\u0006\u00107\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u00105J$\u00108\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010*042\u0006\u00107\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u00105J \u00109\u001a\u0004\u0018\u00010*2\u0006\u00107\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010:J&\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020=2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u0006\u0018\u00010>R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/hive/iapv4/market/google/PlayStoreHelper;", "", "activity", "Landroid/app/Activity;", "iapUpdatedListener", "Lkotlin/Function0;", "", "<init>", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function0;)V", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "ioDispatcher", "Lkotlin/coroutines/CoroutineContext;", "mainDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "isConnected", "", "isPause", "purchaseListener", "Lcom/hive/iapv4/market/google/PlayStoreHelper$PurchaseFlowListener;", "onResume", "onPause", "onDestroy", "getBillingClient", "awaitStartConnection", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitQueryConsumableProductDetails", "", "Lcom/android/billingclient/api/ProductDetails;", "productList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitQuerySubsProductDetails", InAppPurchaseConstants.METHOD_QUERY_PRODUCT_DETAILS_ASYNC, "productType", "(Ljava/util/ArrayList;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchaseFlow", "productDetails", "offerToken", "oldPurchase", "Lcom/android/billingclient/api/Purchase;", "obfuscatedAccountId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lcom/android/billingclient/api/BillingResult;", "Lkotlin/ParameterName;", "name", "billingResult", "purchase", InAppPurchaseConstants.METHOD_QUERY_PURCHASES_ASYNC, "Lkotlin/Pair;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitConsumePurchase", "productId", "awaitAcknowledgePurchase", "awaitFindPurchase", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showInAppMessages", "categoryId", "", "Lkotlin/Function1;", "PurchaseFlowListener", "hive-iapv4-market-google_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayStoreHelper {
    private final Activity activity;
    private BillingClient billingClient;
    private final Function0<Unit> iapUpdatedListener;
    private final CoroutineContext ioDispatcher;
    private boolean isConnected;
    private boolean isPause;
    private final MainCoroutineDispatcher mainDispatcher;
    private PurchaseFlowListener purchaseListener;

    /* JADX INFO: renamed from: com.hive.iapv4.market.google.PlayStoreHelper$queryProductDetailsAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlayStoreHelper.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.market.google.PlayStoreHelper", f = "PlayStoreHelper.kt", i = {0, 0, 1, 1}, l = {ComposerKt.referenceKey, 532}, m = InAppPurchaseConstants.METHOD_QUERY_PRODUCT_DETAILS_ASYNC, n = {"productList", "productType", "productList", "productType"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C29231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C29231(Continuation<? super C29231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayStoreHelper.this.queryProductDetailsAsync(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.hive.iapv4.market.google.PlayStoreHelper$queryPurchasesAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlayStoreHelper.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.market.google.PlayStoreHelper", f = "PlayStoreHelper.kt", i = {0, 1}, l = {332, 532}, m = InAppPurchaseConstants.METHOD_QUERY_PURCHASES_ASYNC, n = {"productType", "productType"}, s = {"L$0", "L$0"})
    static final class C29241 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29241(Continuation<? super C29241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayStoreHelper.this.queryPurchasesAsync(null, this);
        }
    }

    public PlayStoreHelper(Activity activity, Function0<Unit> iapUpdatedListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(iapUpdatedListener, "iapUpdatedListener");
        this.activity = activity;
        this.iapUpdatedListener = iapUpdatedListener;
        this.ioDispatcher = Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
        this.mainDispatcher = Dispatchers.getMain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PlayStoreHelper.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00128\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014RC\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/hive/iapv4/market/google/PlayStoreHelper$PurchaseFlowListener;", "", "productDetail", "Lcom/android/billingclient/api/ProductDetails;", "obfuscatedAccountId", "", "outerListener", "Lkotlin/Function2;", "Lcom/android/billingclient/api/BillingResult;", "Lkotlin/ParameterName;", "name", "billingResult", "Lcom/android/billingclient/api/Purchase;", "purchase", "", "<init>", "(Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getProductDetail", "()Lcom/android/billingclient/api/ProductDetails;", "getObfuscatedAccountId", "()Ljava/lang/String;", "getOuterListener", "()Lkotlin/jvm/functions/Function2;", "hive-iapv4-market-google_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class PurchaseFlowListener {
        private final String obfuscatedAccountId;
        private final Function2<BillingResult, Purchase, Unit> outerListener;
        private final ProductDetails productDetail;

        /* JADX WARN: Multi-variable type inference failed */
        public PurchaseFlowListener(ProductDetails productDetail, String str, Function2<? super BillingResult, ? super Purchase, Unit> outerListener) {
            Intrinsics.checkNotNullParameter(productDetail, "productDetail");
            Intrinsics.checkNotNullParameter(outerListener, "outerListener");
            this.productDetail = productDetail;
            this.obfuscatedAccountId = str;
            this.outerListener = outerListener;
        }

        public final ProductDetails getProductDetail() {
            return this.productDetail;
        }

        public final String getObfuscatedAccountId() {
            return this.obfuscatedAccountId;
        }

        public final Function2<BillingResult, Purchase, Unit> getOuterListener() {
            return this.outerListener;
        }
    }

    public final void onResume() {
        this.isPause = false;
        if (this.purchaseListener != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.hive.iapv4.market.google.PlayStoreHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PlayStoreHelper.onResume$lambda$1(this.f$0);
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$1(PlayStoreHelper playStoreHelper) {
        PurchaseFlowListener purchaseFlowListener;
        if (playStoreHelper.isPause || (purchaseFlowListener = playStoreHelper.purchaseListener) == null || purchaseFlowListener == null) {
            return;
        }
        BillingResult billingResultBuild = BillingResult.newBuilder().setResponseCode(6).setDebugMessage("PlayStoreHelper onResume purchase failed, timeout").build();
        Intrinsics.checkNotNullExpressionValue(billingResultBuild, "build(...)");
        LoggerImpl.INSTANCE.w("[HiveIAP] PlayStoreHelper onResume purchase failed, timeout");
        purchaseFlowListener.getOuterListener().invoke(billingResultBuild, null);
        playStoreHelper.purchaseListener = null;
    }

    public final void onPause() {
        this.isPause = true;
    }

    /* JADX INFO: renamed from: com.hive.iapv4.market.google.PlayStoreHelper$onDestroy$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlayStoreHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.market.google.PlayStoreHelper$onDestroy$1", f = "PlayStoreHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlayStoreHelper.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BillingClient billingClient = PlayStoreHelper.this.billingClient;
                if (billingClient != null) {
                    billingClient.endConnection();
                }
                PlayStoreHelper.this.billingClient = null;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void onDestroy() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.mainDispatcher), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingClient getBillingClient() {
        BillingClient billingClient = this.billingClient;
        Integer numValueOf = billingClient != null ? Integer.valueOf(billingClient.getConnectionState()) : null;
        if ((numValueOf != null && numValueOf.intValue() == 3) || (numValueOf != null && numValueOf.intValue() == 0)) {
            this.billingClient = null;
        }
        BillingClient billingClient2 = this.billingClient;
        if (billingClient2 != null) {
            return billingClient2;
        }
        BillingClient billingClientBuild = BillingClient.newBuilder(this.activity).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).enableAutoServiceReconnection().setListener(new PurchasesUpdatedListener() { // from class: com.hive.iapv4.market.google.PlayStoreHelper$$ExternalSyntheticLambda1
            @Override // com.android.billingclient.api.PurchasesUpdatedListener
            public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                PlayStoreHelper.getBillingClient$lambda$3$lambda$2(this.f$0, billingResult, list);
            }
        }).build();
        Intrinsics.checkNotNullExpressionValue(billingClientBuild, "build(...)");
        this.billingClient = billingClientBuild;
        return billingClientBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBillingClient$lambda$3$lambda$2(PlayStoreHelper playStoreHelper, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(playStoreHelper.ioDispatcher), null, null, new PlayStoreHelper$getBillingClient$1$client$1$1(billingResult, playStoreHelper, list, null), 3, null);
    }

    public final Object awaitQueryConsumableProductDetails(ArrayList<String> arrayList, Continuation<? super List<ProductDetails>> continuation) {
        return queryProductDetailsAsync(arrayList, "inapp", continuation);
    }

    public final Object awaitQuerySubsProductDetails(ArrayList<String> arrayList, Continuation<? super List<ProductDetails>> continuation) {
        return queryProductDetailsAsync(arrayList, "subs", continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(2:12|46)(2:13|14))(1:15))(13:16|(2:20|(1:22))|27|(2:30|28)|49|31|47|32|36|(2:38|(1:40))|41|(1:43)|(1:45)(1:46))|23|(2:25|26)|27|(1:28)|49|31|47|32|36|(0)|41|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ff, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0100, code lost:
    
        r10 = kotlin.Result.INSTANCE;
        r9 = kotlin.Result.m7415constructorimpl(kotlin.ResultKt.createFailure(r9));
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00be A[LOOP:0: B:28:0x00b6->B:30:0x00be, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0143 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0144 A[PHI: r11
  0x0144: PHI (r11v12 java.lang.Object) = (r11v8 java.lang.Object), (r11v1 java.lang.Object) binds: [B:44:0x0141, B:12:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object queryProductDetailsAsync(java.util.ArrayList<java.lang.String> r9, java.lang.String r10, kotlin.coroutines.Continuation<? super java.util.List<com.android.billingclient.api.ProductDetails>> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.market.google.PlayStoreHelper.queryProductDetailsAsync(java.util.ArrayList, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void purchaseFlow(Activity activity, ProductDetails productDetails, String offerToken, Purchase oldPurchase, String obfuscatedAccountId, Function2<? super BillingResult, ? super Purchase, Unit> listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.iL("[HiveIAP] PlayStoreHelper purchaseFlow: " + productDetails + "\n    offerToken: " + offerToken + "\n    oldPurchase: " + oldPurchase);
        LoggerImpl.INSTANCE.iR("[HiveIAP] PlayStoreHelper purchaseFlow");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new C29221(listener, productDetails, offerToken, oldPurchase, obfuscatedAccountId, activity, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.iapv4.market.google.PlayStoreHelper$purchaseFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlayStoreHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.market.google.PlayStoreHelper$purchaseFlow$1", f = "PlayStoreHelper.kt", i = {}, l = {262, 304}, m = "invokeSuspend", n = {}, s = {})
    static final class C29221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Function2<BillingResult, Purchase, Unit> $listener;
        final /* synthetic */ String $obfuscatedAccountId;
        final /* synthetic */ String $offerToken;
        final /* synthetic */ Purchase $oldPurchase;
        final /* synthetic */ ProductDetails $productDetails;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C29221(Function2<? super BillingResult, ? super Purchase, Unit> function2, ProductDetails productDetails, String str, Purchase purchase, String str2, Activity activity, Continuation<? super C29221> continuation) {
            super(2, continuation);
            this.$listener = function2;
            this.$productDetails = productDetails;
            this.$offerToken = str;
            this.$oldPurchase = purchase;
            this.$obfuscatedAccountId = str2;
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlayStoreHelper.this.new C29221(this.$listener, this.$productDetails, this.$offerToken, this.$oldPurchase, this.$obfuscatedAccountId, this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x011f A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 291
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.market.google.PlayStoreHelper.C29221.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.hive.iapv4.market.google.PlayStoreHelper$purchaseFlow$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PlayStoreHelper.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.iapv4.market.google.PlayStoreHelper$purchaseFlow$1$1", f = "PlayStoreHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C03581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Activity $activity;
            final /* synthetic */ BillingFlowParams $flowParams;
            final /* synthetic */ Function2<BillingResult, Purchase, Unit> $listener;
            final /* synthetic */ String $obfuscatedAccountId;
            final /* synthetic */ ProductDetails $productDetails;
            int label;
            final /* synthetic */ PlayStoreHelper this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C03581(PlayStoreHelper playStoreHelper, Activity activity, BillingFlowParams billingFlowParams, ProductDetails productDetails, String str, Function2<? super BillingResult, ? super Purchase, Unit> function2, Continuation<? super C03581> continuation) {
                super(2, continuation);
                this.this$0 = playStoreHelper;
                this.$activity = activity;
                this.$flowParams = billingFlowParams;
                this.$productDetails = productDetails;
                this.$obfuscatedAccountId = str;
                this.$listener = function2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03581(this.this$0, this.$activity, this.$flowParams, this.$productDetails, this.$obfuscatedAccountId, this.$listener, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objM7415constructorimpl;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                PlayStoreHelper playStoreHelper = this.this$0;
                Activity activity = this.$activity;
                BillingFlowParams billingFlowParams = this.$flowParams;
                ProductDetails productDetails = this.$productDetails;
                String str = this.$obfuscatedAccountId;
                Function2<BillingResult, Purchase, Unit> function2 = this.$listener;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    BillingResult billingResultLaunchBillingFlow = playStoreHelper.getBillingClient().launchBillingFlow(activity, billingFlowParams);
                    LoggerImpl.INSTANCE.d("HiveIAP] PlayStoreHelper purchaseFlow launchBillingFlow Result: " + billingResultLaunchBillingFlow.getResponseCode() + " (" + billingResultLaunchBillingFlow.getDebugMessage() + ')');
                    if (billingResultLaunchBillingFlow.getResponseCode() == 0) {
                        playStoreHelper.purchaseListener = new PurchaseFlowListener(productDetails, str, function2);
                    } else {
                        Intrinsics.checkNotNull(billingResultLaunchBillingFlow);
                        function2.invoke(billingResultLaunchBillingFlow, null);
                    }
                    objM7415constructorimpl = Result.m7415constructorimpl(billingResultLaunchBillingFlow);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Function2<BillingResult, Purchase, Unit> function22 = this.$listener;
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl != null) {
                    LoggerImpl.INSTANCE.e("[HiveIAP] PlayStoreHelper purchaseFlow launchBillingFlow exception: " + thM7418exceptionOrNullimpl);
                    BillingResult billingResultBuild = BillingResult.newBuilder().setResponseCode(3).setDebugMessage("PlayStoreHelper purchaseFlow launchBillingFlow exception").build();
                    Intrinsics.checkNotNullExpressionValue(billingResultBuild, "build(...)");
                    function22.invoke(billingResultBuild, null);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc A[PHI: r7
  0x00cc: PHI (r7v17 java.lang.Object) = (r7v8 java.lang.Object), (r7v1 java.lang.Object) binds: [B:30:0x00c9, B:12:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object queryPurchasesAsync(java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Pair<com.android.billingclient.api.BillingResult, ? extends java.util.List<? extends com.android.billingclient.api.Purchase>>> r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.market.google.PlayStoreHelper.queryPurchasesAsync(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showInAppMessages$default(PlayStoreHelper playStoreHelper, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        playStoreHelper.showInAppMessages(i, function1);
    }

    public final void showInAppMessages(int categoryId, Function1<? super Integer, Unit> listener) {
        String strValueOf;
        if (categoryId == 2) {
            strValueOf = "TRANSACTIONAL";
        } else if (categoryId == 3) {
            strValueOf = "PROMOTIONAL";
        } else {
            strValueOf = String.valueOf(categoryId);
        }
        LoggerImpl.INSTANCE.d("[HiveIAP] PlayStoreHelper showInAppMessages(" + strValueOf + ')');
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.mainDispatcher), null, null, new C29251(categoryId, this, listener, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.iapv4.market.google.PlayStoreHelper$showInAppMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlayStoreHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.market.google.PlayStoreHelper$showInAppMessages$1", f = "PlayStoreHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C29251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $categoryId;
        final /* synthetic */ Function1<Integer, Unit> $listener;
        int label;
        final /* synthetic */ PlayStoreHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C29251(int i, PlayStoreHelper playStoreHelper, Function1<? super Integer, Unit> function1, Continuation<? super C29251> continuation) {
            super(2, continuation);
            this.$categoryId = i;
            this.this$0 = playStoreHelper;
            this.$listener = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29251(this.$categoryId, this.this$0, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            InAppMessageParams inAppMessageParamsBuild = InAppMessageParams.newBuilder().addInAppMessageCategoryToShow(this.$categoryId).build();
            Intrinsics.checkNotNullExpressionValue(inAppMessageParamsBuild, "build(...)");
            BillingClient billingClient = this.this$0.getBillingClient();
            Activity activity = this.this$0.activity;
            final PlayStoreHelper playStoreHelper = this.this$0;
            final Function1<Integer, Unit> function1 = this.$listener;
            BillingResult billingResultShowInAppMessages = billingClient.showInAppMessages(activity, inAppMessageParamsBuild, new InAppMessageResponseListener() { // from class: com.hive.iapv4.market.google.PlayStoreHelper$showInAppMessages$1$$ExternalSyntheticLambda0
                @Override // com.android.billingclient.api.InAppMessageResponseListener
                public final void onInAppMessageResponse(InAppMessageResult inAppMessageResult) {
                    PlayStoreHelper.C29251.invokeSuspend$lambda$0(playStoreHelper, function1, inAppMessageResult);
                }
            });
            Intrinsics.checkNotNullExpressionValue(billingResultShowInAppMessages, "showInAppMessages(...)");
            int responseCode = billingResultShowInAppMessages.getResponseCode();
            if (responseCode == -2) {
                LoggerImpl.INSTANCE.d("[HiveIAP] PlayStoreHelper showInAppMessages FEATURE_NOT_SUPPORTED");
                Function1<Integer, Unit> function12 = this.$listener;
                if (function12 != null) {
                    function12.invoke(Boxing.boxInt(-2));
                }
            } else if (responseCode == -1) {
                LoggerImpl.INSTANCE.d("[HiveIAP] PlayStoreHelper showInAppMessages SERVICE_DISCONNECTED");
                Function1<Integer, Unit> function13 = this.$listener;
                if (function13 != null) {
                    function13.invoke(Boxing.boxInt(-1));
                }
            } else if (responseCode != 0) {
                LoggerImpl.INSTANCE.d("[HiveIAP] PlayStoreHelper showInAppMessages BillingResponseCode Error(" + billingResultShowInAppMessages.getResponseCode() + ')');
                Function1<Integer, Unit> function14 = this.$listener;
                if (function14 != null) {
                    function14.invoke(Boxing.boxInt(-99));
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(PlayStoreHelper playStoreHelper, Function1 function1, InAppMessageResult inAppMessageResult) {
            int responseCode = inAppMessageResult.getResponseCode();
            if (responseCode == 0) {
                LoggerImpl.INSTANCE.d("[HiveIAP] PlayStoreHelper showInAppMessages NO_ACTION_NEEDED");
            } else if (responseCode == 1) {
                LoggerImpl.INSTANCE.d("[HiveIAP] PlayStoreHelper showInAppMessages SUBSCRIPTION_STATUS_UPDATED");
                playStoreHelper.iapUpdatedListener.invoke();
            } else if (responseCode == 2) {
                LoggerImpl.INSTANCE.d("[HiveIAP] PlayStoreHelper showInAppMessages NAVIGATE_TO_DEV_APP_STORE");
            } else {
                LoggerImpl.INSTANCE.d("[HiveIAP] PlayStoreHelper showInAppMessages " + inAppMessageResult.getResponseCode());
            }
            if (function1 != null) {
                function1.invoke(Integer.valueOf(inAppMessageResult.getResponseCode()));
            }
        }
    }

    public final Object awaitStartConnection(Continuation<? super Boolean> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        LoggerImpl.INSTANCE.i("[HiveIAP] PlayStoreHelper awaitStartConnection");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.mainDispatcher), null, null, new PlayStoreHelper$awaitStartConnection$2$1(this, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object awaitConsumePurchase(String str, Continuation<? super Pair<BillingResult, ? extends Purchase>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        LoggerImpl.INSTANCE.i("[HiveIAP] PlayStoreHelper awaitConsumePurchase: " + str);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new PlayStoreHelper$awaitConsumePurchase$2$1(this, str, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object awaitAcknowledgePurchase(String str, Continuation<? super Pair<BillingResult, ? extends Purchase>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        LoggerImpl.INSTANCE.i("[HiveIAP] PlayStoreHelper awaitAcknowledgePurchase: " + str);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new PlayStoreHelper$awaitAcknowledgePurchase$2$1(this, str, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitFindPurchase(String str, String str2, Continuation<? super Purchase> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        LoggerImpl.INSTANCE.d("[HiveIAP] PlayStoreHelper awaitFindPurchase: " + str);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new PlayStoreHelper$awaitFindPurchase$2$1(this, cancellableContinuationImpl, str2, str, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
