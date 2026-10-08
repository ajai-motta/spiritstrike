package com.hive.iapv4.market.google;

import android.app.Activity;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.applovin.sdk.AppLovinEventTypes;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.HiveActivity;
import com.hive.IAPV4;
import com.hive.ResultAPI;
import com.hive.iapv4.BaseMarketAPI;
import com.hive.iapv4.IapV4Impl;
import com.hive.iapv4.market.google.PlayStore;
import com.hive.logger.LoggerImpl;
import com.hive.standalone.HiveLifecycle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: PlayStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001fH\u0016J*\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u00132\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020+H\u0016J\u0018\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020+H\u0002J\u0018\u0010/\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u000200H\u0016J4\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u0002042\b\u0010!\u001a\u0004\u0018\u0001052\b\u0010#\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020&H\u0002J&\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020%2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0016\u0018\u000108H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/hive/iapv4/market/google/PlayStore;", "Lcom/hive/iapv4/BaseMarketAPI;", "<init>", "()V", "ioDispatcher", "Lkotlin/coroutines/CoroutineContext;", "mainDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "isPurchasing", "", "isRestoring", "playStoreHelper", "Lcom/hive/iapv4/market/google/PlayStoreHelper;", "getPlayStoreHelper", "()Lcom/hive/iapv4/market/google/PlayStoreHelper;", "playStoreHelper$delegate", "Lkotlin/Lazy;", "playStoreProducts", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/hive/iapv4/market/google/PlayStoreProduct;", "onResume", "", "activity", "Landroid/app/Activity;", "onPause", "onDestroy", "marketConnect", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/IAPV4$IAPV4MarketInfoListener;", "getProductInfo", "Lcom/hive/IAPV4$IAPV4ProductInfoListener;", "getSubscriptionProductInfo", "purchase", "marketPid", "iapPayload", "quantity", "", "Lcom/hive/IAPV4$IAPV4PurchaseListener;", "purchaseSubscription", "param", "Lcom/hive/IAPV4$IAPV4PurchaseParam;", "restore", "Lcom/hive/IAPV4$IAPV4RestoreListener;", "restoreSubscription", "internalRestore", "productType", "transactionFinish", "Lcom/hive/IAPV4$IAPV4TransactionFinishListener;", "finishPurchase", "playStoreProduct", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "Lcom/android/billingclient/api/Purchase;", "showInAppMessages", "categoryId", "Lkotlin/Function1;", "hive-iapv4-market-google_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayStore extends BaseMarketAPI {
    private static boolean isPurchasing;
    private static boolean isRestoring;
    public static final PlayStore INSTANCE = new PlayStore();
    private static final CoroutineContext ioDispatcher = Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
    private static final MainCoroutineDispatcher mainDispatcher = Dispatchers.getMain();

    /* JADX INFO: renamed from: playStoreHelper$delegate, reason: from kotlin metadata */
    private static final Lazy playStoreHelper = LazyKt.lazy(new Function0() { // from class: com.hive.iapv4.market.google.PlayStore$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PlayStore.playStoreHelper_delegate$lambda$0();
        }
    });
    private static final ConcurrentHashMap<String, PlayStoreProduct> playStoreProducts = new ConcurrentHashMap<>();

    private PlayStore() {
    }

    static {
        LoggerImpl.INSTANCE.d("[HiveIAP] create PlayStore");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlayStoreHelper getPlayStoreHelper() {
        return (PlayStoreHelper) playStoreHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayStoreHelper playStoreHelper_delegate$lambda$0() {
        return new PlayStoreHelper(HiveActivity.INSTANCE.getRecentActivity(), INSTANCE.getInterworkIapUpdatedListener());
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onResume(activity);
        LoggerImpl.INSTANCE.d("[HiveIAP] PlayStore resume");
        getPlayStoreHelper().onResume();
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoggerImpl.INSTANCE.d("[HiveIAP] PlayStore pause");
        getPlayStoreHelper().onPause();
        super.onPause(activity);
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoggerImpl.INSTANCE.d("[HiveIAP] PlayStore destroy");
        setInitialized(false);
        isPurchasing = false;
        isRestoring = false;
        getPlayStoreHelper().onDestroy();
        super.onDestroy(activity);
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void marketConnect(IAPV4.IAPV4MarketInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[HiveIAP] PlayStore marketConnect");
        ArrayList<IAPV4.IAPV4Type> arrayList = new ArrayList<>();
        arrayList.add(IAPV4.IAPV4Type.GOOGLE_PLAYSTORE);
        if (getMarket().getMarketPidList().isEmpty() && getMarket().getMarketSubscriptionPidList().isEmpty()) {
            LoggerImpl.INSTANCE.e("[HiveIAP] PlayStore pids is nothing.");
            setInitialized(false);
            listener.onIAPV4MarketInfo(new ResultAPI(-5, ResultAPI.Code.IAPV4FailMarketConnect, "[HiveIAP] PlayStore pids is nothing"), arrayList);
            return;
        }
        Iterator<String> it = getMarket().getMarketPidList().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            String next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            LoggerImpl.INSTANCE.i("[HiveIAP] PlayStore pid : " + next);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ioDispatcher), new PlayStore$marketConnect$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE), null, new C29192(listener, arrayList, null), 2, null);
    }

    /* JADX INFO: renamed from: com.hive.iapv4.market.google.PlayStore$marketConnect$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlayStore.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.market.google.PlayStore$marketConnect$2", f = "PlayStore.kt", i = {}, l = {86, 95, 118, TsExtractor.TS_STREAM_TYPE_E_AC3, 158, TTAdConstant.IMAGE_MODE_VERTICAL_IMG_173, 181}, m = "invokeSuspend", n = {}, s = {})
    static final class C29192 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<IAPV4.IAPV4Type> $iapTypeList;
        final /* synthetic */ IAPV4.IAPV4MarketInfoListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29192(IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener, ArrayList<IAPV4.IAPV4Type> arrayList, Continuation<? super C29192> continuation) {
            super(2, continuation);
            this.$listener = iAPV4MarketInfoListener;
            this.$iapTypeList = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29192(this.$listener, this.$iapTypeList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29192) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x01b2  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x025d  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x02eb  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0315  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 840
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.market.google.PlayStore.C29192.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.hive.iapv4.market.google.PlayStore$marketConnect$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: PlayStore.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.iapv4.market.google.PlayStore$marketConnect$2$5", f = "PlayStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ArrayList<IAPV4.IAPV4Type> $iapTypeList;
            final /* synthetic */ IAPV4.IAPV4MarketInfoListener $listener;
            final /* synthetic */ String $logMsg;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener, String str, ArrayList<IAPV4.IAPV4Type> arrayList, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$listener = iAPV4MarketInfoListener;
                this.$logMsg = str;
                this.$iapTypeList = arrayList;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass5(this.$listener, this.$logMsg, this.$iapTypeList, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$listener.onIAPV4MarketInfo(new ResultAPI(-8, ResultAPI.Code.IAPV4PlayStoreQueryInventoryFail, this.$logMsg), this.$iapTypeList);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.hive.iapv4.market.google.PlayStore$marketConnect$2$6, reason: invalid class name */
        /* JADX INFO: compiled from: PlayStore.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.iapv4.market.google.PlayStore$marketConnect$2$6", f = "PlayStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ArrayList<IAPV4.IAPV4Type> $iapTypeList;
            final /* synthetic */ IAPV4.IAPV4MarketInfoListener $listener;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener, ArrayList<IAPV4.IAPV4Type> arrayList, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.$listener = iAPV4MarketInfoListener;
                this.$iapTypeList = arrayList;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass6(this.$listener, this.$iapTypeList, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$listener.onIAPV4MarketInfo(new ResultAPI(0, ResultAPI.Code.Success, "[HiveIAP] PlayStore success"), this.$iapTypeList);
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void getProductInfo(IAPV4.IAPV4ProductInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[HiveIAP] PlayStore productInfo");
        ConcurrentHashMap<String, PlayStoreProduct> concurrentHashMap = playStoreProducts;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, PlayStoreProduct>> it = concurrentHashMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, PlayStoreProduct> next = it.next();
            ProductDetails productDetails = next.getValue().getProductDetails();
            if (Intrinsics.areEqual(productDetails != null ? productDetails.getProductType() : null, "inapp")) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        if (linkedHashMap.isEmpty()) {
            LoggerImpl.INSTANCE.w("[HiveIAP] PlayStore getProductInfo product detail is empty.");
            listener.onIAPV4ProductInfo(new ResultAPI(-8, ResultAPI.Code.IAPV4PlayStoreQueryInventoryFail, "[HiveIAP] PlayStore getProductInfo product detail is empty."), null, 0);
        } else {
            internalProductInfo("PlayStore", new ArrayList(linkedHashMap.values()), listener);
        }
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void getSubscriptionProductInfo(final IAPV4.IAPV4ProductInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[HiveIAP] PlayStore getSubscriptionProductInfo");
        ConcurrentHashMap<String, PlayStoreProduct> concurrentHashMap = playStoreProducts;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, PlayStoreProduct>> it = concurrentHashMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, PlayStoreProduct> next = it.next();
            ProductDetails productDetails = next.getValue().getProductDetails();
            if (Intrinsics.areEqual(productDetails != null ? productDetails.getProductType() : null, "subs")) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        if (linkedHashMap.isEmpty()) {
            LoggerImpl.INSTANCE.w("[HiveIAP] PlayStore getSubscriptionProductInfo product detail is empty.");
            listener.onIAPV4ProductInfo(new ResultAPI(-8, ResultAPI.Code.IAPV4PlayStoreQueryInventoryFail, "[HiveIAP] PlayStore getSubscriptionProductInfo product detail is empty."), null, 0);
        } else {
            internalSubscriptionProductInfo("PlayStore", new ArrayList(linkedHashMap.values()), new IAPV4.IAPV4ProductInfoListener() { // from class: com.hive.iapv4.market.google.PlayStore.getSubscriptionProductInfo.1
                @Override // com.hive.IAPV4.IAPV4ProductInfoListener
                public void onIAPV4ProductInfo(ResultAPI result, ArrayList<IAPV4.IAPV4Product> iapV4ProductList, int balance) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (result.isSuccess()) {
                        PlayStoreHelper.showInAppMessages$default(PlayStore.INSTANCE.getPlayStoreHelper(), 2, null, 2, null);
                    }
                    listener.onIAPV4ProductInfo(result, iapV4ProductList, balance);
                }
            });
        }
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public synchronized void purchase(String marketPid, final String iapPayload, int quantity, final IAPV4.IAPV4PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[HiveIAP] PlayStore purchase: " + marketPid);
        if (isPurchasing) {
            LoggerImpl.INSTANCE.e("[HiveIAP] PlayStore purchase error: now Purchasing!");
            IapV4Impl.INSTANCE.onPurchaseFinish(new ResultAPI(-3, ResultAPI.Code.IAPV4InProgressPurchasing, "[HiveIAP] PlayStore purchase error: now Purchasing!"), null, listener);
            return;
        }
        if (isRestoring) {
            LoggerImpl.INSTANCE.e("[HiveIAP] PlayStore purchase error: now Restoring!");
            IapV4Impl.INSTANCE.onPurchaseFinish(new ResultAPI(-3, ResultAPI.Code.IAPV4InProgressRestoring, "[HiveIAP] PlayStore purchase error: now Restoring!"), null, listener);
            return;
        }
        IAPV4.IAPV4Product productInfo = getProductInfo(marketPid);
        final PlayStoreProduct playStoreProduct = playStoreProducts.get(marketPid);
        ProductDetails productDetails = playStoreProduct != null ? playStoreProduct.getProductDetails() : null;
        if (!StringsKt.isBlank(marketPid) && productInfo != null && productDetails != null) {
            LoggerImpl.INSTANCE.i("[HiveIAP] PlayStore Purchasing: " + marketPid);
            isPurchasing = true;
            getPlayStoreHelper().purchaseFlow(HiveActivity.INSTANCE.getRecentActivity(), productDetails, null, null, HiveLifecycle.INSTANCE.getAccount().getAccountUuid(), new Function2() { // from class: com.hive.iapv4.market.google.PlayStore$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlayStore.purchase$lambda$4(playStoreProduct, iapPayload, listener, (BillingResult) obj, (Purchase) obj2);
                }
            });
            return;
        }
        LoggerImpl.INSTANCE.w("[HiveIAP] PlayStore purchase error: need product info for market pid: " + marketPid);
        IapV4Impl.INSTANCE.onPurchaseFinish(new ResultAPI(-1, ResultAPI.Code.IAPV4EmptyParamMarketPID, "[HiveIAP] PlayStore purchase error: need product info for market pid"), null, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchase$lambda$4(PlayStoreProduct playStoreProduct, String str, IAPV4.IAPV4PurchaseListener iAPV4PurchaseListener, BillingResult billingResult, Purchase purchase) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        INSTANCE.finishPurchase(playStoreProduct, billingResult, purchase, str, iAPV4PurchaseListener);
        return Unit.INSTANCE;
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public synchronized void purchaseSubscription(IAPV4.IAPV4PurchaseParam param, IAPV4.IAPV4PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.iL("[HiveIAP] PlayStore purchaseSubscription: " + param);
        LoggerImpl.INSTANCE.iR("[HiveIAP] PlayStore purchaseSubscription");
        if (isPurchasing) {
            LoggerImpl.INSTANCE.e("[HiveIAP] PlayStore purchaseSubscriptionUpdate error: now Purchasing!");
            IapV4Impl.INSTANCE.onPurchaseFinish(new ResultAPI(-3, ResultAPI.Code.IAPV4InProgressPurchasing, "[HiveIAP] PlayStore purchaseSubscriptionUpdate error: now Purchasing!"), null, listener);
        } else if (!isRestoring) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ioDispatcher), new PlayStore$purchaseSubscription$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE), null, new C29202(param, listener, null), 2, null);
        } else {
            LoggerImpl.INSTANCE.e("[HiveIAP] PlayStore purchaseSubscriptionUpdate error: now Restoring!");
            IapV4Impl.INSTANCE.onPurchaseFinish(new ResultAPI(-3, ResultAPI.Code.IAPV4InProgressRestoring, "[HiveIAP] PlayStore purchaseSubscriptionUpdate error: now Restoring!"), null, listener);
        }
    }

    /* JADX INFO: renamed from: com.hive.iapv4.market.google.PlayStore$purchaseSubscription$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlayStore.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.market.google.PlayStore$purchaseSubscription$2", f = "PlayStore.kt", i = {0, 0, 0}, l = {308}, m = "invokeSuspend", n = {"gameProduct", "marketProduct", "productDetails"}, s = {"L$0", "L$1", "L$2"})
    static final class C29202 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IAPV4.IAPV4PurchaseListener $listener;
        final /* synthetic */ IAPV4.IAPV4PurchaseParam $param;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29202(IAPV4.IAPV4PurchaseParam iAPV4PurchaseParam, IAPV4.IAPV4PurchaseListener iAPV4PurchaseListener, Continuation<? super C29202> continuation) {
            super(2, continuation);
            this.$param = iAPV4PurchaseParam;
            this.$listener = iAPV4PurchaseListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29202(this.$param, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29202) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IAPV4.IAPV4Product productInfo;
            final PlayStoreProduct playStoreProduct;
            ProductDetails productDetails;
            Purchase purchase;
            Object next;
            List<String> products;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                productInfo = PlayStore.INSTANCE.getProductInfo(this.$param.getMarketPid());
                playStoreProduct = (PlayStoreProduct) PlayStore.playStoreProducts.get(this.$param.getMarketPid());
                ProductDetails productDetails2 = playStoreProduct != null ? playStoreProduct.getProductDetails() : null;
                this.L$0 = productInfo;
                this.L$1 = playStoreProduct;
                this.L$2 = productDetails2;
                this.label = 1;
                Object objQueryPurchasesAsync = PlayStore.INSTANCE.getPlayStoreHelper().queryPurchasesAsync("subs", this);
                if (objQueryPurchasesAsync == coroutine_suspended) {
                    return coroutine_suspended;
                }
                productDetails = productDetails2;
                obj = objQueryPurchasesAsync;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ProductDetails productDetails3 = (ProductDetails) this.L$2;
                playStoreProduct = (PlayStoreProduct) this.L$1;
                productInfo = (IAPV4.IAPV4Product) this.L$0;
                ResultKt.throwOnFailure(obj);
                productDetails = productDetails3;
            }
            List list = (List) ((Pair) obj).getSecond();
            if (list != null) {
                IAPV4.IAPV4PurchaseParam iAPV4PurchaseParam = this.$param;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    Purchase purchase2 = (Purchase) next;
                    if (Intrinsics.areEqual((purchase2 == null || (products = purchase2.getProducts()) == null) ? null : products.get(0), iAPV4PurchaseParam.getOldMarketPid())) {
                        break;
                    }
                }
                purchase = (Purchase) next;
            } else {
                purchase = null;
            }
            if (StringsKt.isBlank(this.$param.getMarketPid()) || productInfo == null || productDetails == null) {
                LoggerImpl.INSTANCE.w("[HiveIAP] PlayStore purchaseSubscriptionUpdate error: need product info for market pid: " + this.$param + ".marketPid");
                IapV4Impl.INSTANCE.onPurchaseFinish(new ResultAPI(-1, ResultAPI.Code.IAPV4EmptyParamMarketPID, "[HiveIAP] PlayStore purchaseSubscriptionUpdate error: need product info for market pid"), null, this.$listener);
            } else {
                LoggerImpl.INSTANCE.i("[HiveIAP] PlayStore purchaseSubscriptionUpdate");
                PlayStore playStore = PlayStore.INSTANCE;
                PlayStore.isPurchasing = true;
                PlayStoreHelper playStoreHelper = PlayStore.INSTANCE.getPlayStoreHelper();
                Activity recentActivity = HiveActivity.INSTANCE.getRecentActivity();
                String offerToken = this.$param.getOfferToken();
                String accountUuid = HiveLifecycle.INSTANCE.getAccount().getAccountUuid();
                final IAPV4.IAPV4PurchaseParam iAPV4PurchaseParam2 = this.$param;
                final IAPV4.IAPV4PurchaseListener iAPV4PurchaseListener = this.$listener;
                playStoreHelper.purchaseFlow(recentActivity, productDetails, offerToken, purchase, accountUuid, new Function2() { // from class: com.hive.iapv4.market.google.PlayStore$purchaseSubscription$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return PlayStore.C29202.invokeSuspend$lambda$1(playStoreProduct, iAPV4PurchaseParam2, iAPV4PurchaseListener, (BillingResult) obj2, (Purchase) obj3);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(PlayStoreProduct playStoreProduct, IAPV4.IAPV4PurchaseParam iAPV4PurchaseParam, IAPV4.IAPV4PurchaseListener iAPV4PurchaseListener, BillingResult billingResult, Purchase purchase) {
            PlayStore.INSTANCE.finishPurchase(playStoreProduct, billingResult, purchase, iAPV4PurchaseParam.getIapPayload(), iAPV4PurchaseListener);
            return Unit.INSTANCE;
        }
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public synchronized void restore(IAPV4.IAPV4RestoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        internalRestore("inapp", listener);
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public synchronized void restoreSubscription(IAPV4.IAPV4RestoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        internalRestore("subs", listener);
    }

    private final void internalRestore(String productType, IAPV4.IAPV4RestoreListener listener) {
        LoggerImpl.INSTANCE.i("[HiveIAP] PlayStore " + productType + " restore");
        if (isPurchasing) {
            LoggerImpl.INSTANCE.e("[HiveIAP] PlayStore " + productType + " restore error: now Purchasing!");
            IapV4Impl.INSTANCE.onRestoreFinish(new ResultAPI(-3, ResultAPI.Code.IAPV4InProgressPurchasing, "[HiveIAP] PlayStore restoreSubscription error: now Purchasing!"), null, listener);
            return;
        }
        if (isRestoring) {
            LoggerImpl.INSTANCE.e("[HiveIAP] PlayStore " + productType + " restore error: now Restoring!");
            IapV4Impl.INSTANCE.onRestoreFinish(new ResultAPI(-3, ResultAPI.Code.IAPV4InProgressRestoring, "[HiveIAP] PlayStore restoreSubscription error: now Restoring!"), null, listener);
            return;
        }
        isRestoring = true;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ioDispatcher), new PlayStore$internalRestore$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, productType), null, new AnonymousClass2(productType, listener, null), 2, null);
    }

    /* JADX INFO: renamed from: com.hive.iapv4.market.google.PlayStore$internalRestore$2, reason: invalid class name */
    /* JADX INFO: compiled from: PlayStore.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.market.google.PlayStore$internalRestore$2", f = "PlayStore.kt", i = {}, l = {362}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IAPV4.IAPV4RestoreListener $listener;
        final /* synthetic */ String $productType;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, IAPV4.IAPV4RestoreListener iAPV4RestoreListener, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$productType = str;
            this.$listener = iAPV4RestoreListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$productType, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM7415constructorimpl;
            String str;
            Object objQueryPurchasesAsync;
            IAPV4.IAPV4RestoreListener iAPV4RestoreListener;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    str = this.$productType;
                    IAPV4.IAPV4RestoreListener iAPV4RestoreListener2 = this.$listener;
                    Result.Companion companion = Result.INSTANCE;
                    PlayStoreHelper playStoreHelper = PlayStore.INSTANCE.getPlayStoreHelper();
                    this.L$0 = str;
                    this.L$1 = iAPV4RestoreListener2;
                    this.label = 1;
                    objQueryPurchasesAsync = playStoreHelper.queryPurchasesAsync(str, this);
                    if (objQueryPurchasesAsync == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    iAPV4RestoreListener = iAPV4RestoreListener2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    iAPV4RestoreListener = (IAPV4.IAPV4RestoreListener) this.L$1;
                    str = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objQueryPurchasesAsync = obj;
                }
                Pair pair = (Pair) objQueryPurchasesAsync;
                List<Purchase> list = (List) pair.getSecond();
                if (((BillingResult) pair.getFirst()).getResponseCode() == 0 && list != null) {
                    LoggerImpl.INSTANCE.d("[HiveIAP] PlayStore " + str + " restore query was successful.");
                    ArrayList<IAPV4.IAPV4Receipt> arrayList = new ArrayList<>();
                    for (Purchase purchase : list) {
                        if (purchase != null && purchase.getPurchaseState() == 1) {
                            PlayStoreProduct playStoreProduct = (PlayStoreProduct) PlayStore.playStoreProducts.get(purchase.getProducts().get(0));
                            PlayStore playStore = PlayStore.INSTANCE;
                            String str2 = purchase.getProducts().get(0);
                            Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
                            IAPV4.IAPV4Product productInfo = playStore.getProductInfo(str2);
                            if (playStoreProduct != null && productInfo != null) {
                                Boxing.boxBoolean(arrayList.add(new PlayStoreReceipt(productInfo, playStoreProduct, purchase, null, true)));
                            } else {
                                LoggerImpl.INSTANCE.e("[HiveIAP] PlayStore " + str + " restored but unknown product: (" + purchase.getProducts().get(0) + ')');
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        LoggerImpl.INSTANCE.i("[HiveIAP] PlayStore " + str + " restore not owned.");
                        PlayStore playStore2 = PlayStore.INSTANCE;
                        PlayStore.isRestoring = false;
                        IapV4Impl.INSTANCE.onRestoreFinish(new ResultAPI(10, ResultAPI.Code.IAPV4NothingToRestore, "[HiveIAP] PlayStore " + str + " restore not owned"), null, iAPV4RestoreListener);
                    } else {
                        LoggerImpl.INSTANCE.i("[HiveIAP] PlayStore " + str + " restore owned. : " + arrayList.size());
                        PlayStore playStore3 = PlayStore.INSTANCE;
                        PlayStore.isRestoring = false;
                        IapV4Impl.INSTANCE.onRestoreFinish(new ResultAPI(), arrayList, iAPV4RestoreListener);
                    }
                } else {
                    String str3 = "[HiveIAP] PlayStore " + str + " restore queryPurchases failed: " + ((BillingResult) pair.getFirst()).getResponseCode() + " (" + ((BillingResult) pair.getFirst()).getDebugMessage() + ')';
                    LoggerImpl.INSTANCE.w(str3);
                    PlayStore playStore4 = PlayStore.INSTANCE;
                    PlayStore.isRestoring = false;
                    IapV4Impl.INSTANCE.onRestoreFinish(new ResultAPI(-8, ResultAPI.Code.IAPV4FailToRestore, str3), null, iAPV4RestoreListener);
                }
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            String str4 = this.$productType;
            IAPV4.IAPV4RestoreListener iAPV4RestoreListener3 = this.$listener;
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                String str5 = "[HiveIAP] PlayStore " + str4 + " restore queryPurchases exception: " + thM7418exceptionOrNullimpl;
                LoggerImpl.INSTANCE.w(str5);
                PlayStore playStore5 = PlayStore.INSTANCE;
                PlayStore.isRestoring = false;
                IapV4Impl.INSTANCE.onRestoreFinish(new ResultAPI(-8, ResultAPI.Code.IAPV4FailToRestore, str5), null, iAPV4RestoreListener3);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public synchronized void transactionFinish(String marketPid, IAPV4.IAPV4TransactionFinishListener listener) {
        Intrinsics.checkNotNullParameter(marketPid, "marketPid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[HiveIAP] PlayStore transactionFinish : " + marketPid);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ioDispatcher), new PlayStore$transactionFinish$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE), null, new C29212(marketPid, listener, null), 2, null);
    }

    /* JADX INFO: renamed from: com.hive.iapv4.market.google.PlayStore$transactionFinish$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlayStore.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.market.google.PlayStore$transactionFinish$2", f = "PlayStore.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {442, 444}, m = "invokeSuspend", n = {"playStoreProduct", AppLovinEventTypes.USER_VIEWED_PRODUCT, "responseCode", "receiptGoogle", "playStoreProduct", AppLovinEventTypes.USER_VIEWED_PRODUCT, "responseCode", "receiptGoogle"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    static final class C29212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IAPV4.IAPV4TransactionFinishListener $listener;
        final /* synthetic */ String $marketPid;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29212(String str, IAPV4.IAPV4TransactionFinishListener iAPV4TransactionFinishListener, Continuation<? super C29212> continuation) {
            super(2, continuation);
            this.$marketPid = str;
            this.$listener = iAPV4TransactionFinishListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29212(this.$marketPid, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29212) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0129  */
        /* JADX WARN: Type inference failed for: r10v0, types: [T, com.hive.iapv4.market.google.PlayStoreReceipt] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 329
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.market.google.PlayStore.C29212.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void finishPurchase(com.hive.iapv4.market.google.PlayStoreProduct r10, com.android.billingclient.api.BillingResult r11, com.android.billingclient.api.Purchase r12, java.lang.String r13, com.hive.IAPV4.IAPV4PurchaseListener r14) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.market.google.PlayStore.finishPurchase(com.hive.iapv4.market.google.PlayStoreProduct, com.android.billingclient.api.BillingResult, com.android.billingclient.api.Purchase, java.lang.String, com.hive.IAPV4$IAPV4PurchaseListener):void");
    }

    @Override // com.hive.iapv4.BaseMarketAPI
    public void showInAppMessages(int categoryId, Function1<? super Integer, Unit> listener) {
        LoggerImpl.INSTANCE.i("[HiveIAP] PlayStore showInAppMessages(" + categoryId + ')');
        getPlayStoreHelper().showInAppMessages(categoryId, listener);
    }
}
