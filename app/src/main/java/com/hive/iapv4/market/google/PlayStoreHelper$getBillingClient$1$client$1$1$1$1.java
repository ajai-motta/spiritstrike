package com.hive.iapv4.market.google;

import com.android.billingclient.api.AccountIdentifiers;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.hive.iapv4.market.google.PlayStoreHelper;
import com.hive.logger.LoggerImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PlayStoreHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.iapv4.market.google.PlayStoreHelper$getBillingClient$1$client$1$1$1$1", f = "PlayStoreHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PlayStoreHelper$getBillingClient$1$client$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BillingResult $billingResult;
    final /* synthetic */ PlayStoreHelper.PurchaseFlowListener $it;
    final /* synthetic */ List<Purchase> $purchases;
    final /* synthetic */ int $responseCode;
    int label;
    final /* synthetic */ PlayStoreHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayStoreHelper$getBillingClient$1$client$1$1$1$1(int i, List<Purchase> list, PlayStoreHelper.PurchaseFlowListener purchaseFlowListener, BillingResult billingResult, PlayStoreHelper playStoreHelper, Continuation<? super PlayStoreHelper$getBillingClient$1$client$1$1$1$1> continuation) {
        super(2, continuation);
        this.$responseCode = i;
        this.$purchases = list;
        this.$it = purchaseFlowListener;
        this.$billingResult = billingResult;
        this.this$0 = playStoreHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayStoreHelper$getBillingClient$1$client$1$1$1$1(this.$responseCode, this.$purchases, this.$it, this.$billingResult, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayStoreHelper$getBillingClient$1$client$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<Purchase> list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$responseCode == 0 && (list = this.$purchases) != null) {
            for (Purchase purchase : list) {
                LoggerImpl.INSTANCE.dL("[HiveIAP] PlayStoreHelper Billing State Updated " + purchase);
                LoggerImpl.INSTANCE.dR("[HiveIAP] PlayStoreHelper Billing State Updated ");
                String productId = this.$it.getProductDetail().getProductId();
                List<String> products = purchase.getProducts();
                Intrinsics.checkNotNullExpressionValue(products, "getProducts(...)");
                if (Intrinsics.areEqual(productId, CollectionsKt.first((List) products))) {
                    String obfuscatedAccountId = this.$it.getObfuscatedAccountId();
                    AccountIdentifiers accountIdentifiers = purchase.getAccountIdentifiers();
                    if (Intrinsics.areEqual(obfuscatedAccountId, accountIdentifiers != null ? accountIdentifiers.getObfuscatedAccountId() : null)) {
                        Function2<BillingResult, Purchase, Unit> outerListener = this.$it.getOuterListener();
                        BillingResult billingResult = this.$billingResult;
                        Intrinsics.checkNotNull(billingResult);
                        outerListener.invoke(billingResult, CollectionsKt.first((List) this.$purchases));
                        this.this$0.purchaseListener = null;
                        return Unit.INSTANCE;
                    }
                }
            }
            LoggerImpl.INSTANCE.iL("[HiveIAP] PlayStoreHelper PurchaseUpdated queued interwork://iap/iapupdated : " + this.$purchases + " \nbut now Purchasing!");
            LoggerImpl.INSTANCE.iR("[HiveIAP] PlayStoreHelper PurchaseUpdated queued interwork://iap/iapupdated \nbut now Purchasing!");
            this.this$0.iapUpdatedListener.invoke();
        } else {
            Function2<BillingResult, Purchase, Unit> outerListener2 = this.$it.getOuterListener();
            BillingResult billingResult2 = this.$billingResult;
            Intrinsics.checkNotNull(billingResult2);
            outerListener2.invoke(billingResult2, null);
            this.this$0.purchaseListener = null;
        }
        return Unit.INSTANCE;
    }
}
