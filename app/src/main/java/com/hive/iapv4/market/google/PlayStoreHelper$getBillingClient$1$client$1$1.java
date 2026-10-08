package com.hive.iapv4.market.google;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.hive.iapv4.market.google.PlayStoreHelper;
import com.hive.logger.LoggerImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: PlayStoreHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.iapv4.market.google.PlayStoreHelper$getBillingClient$1$client$1$1", f = "PlayStoreHelper.kt", i = {0}, l = {90, 124}, m = "invokeSuspend", n = {"responseCode"}, s = {"I$0"})
final class PlayStoreHelper$getBillingClient$1$client$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BillingResult $billingResult;
    final /* synthetic */ List<Purchase> $purchases;
    int I$0;
    int label;
    final /* synthetic */ PlayStoreHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayStoreHelper$getBillingClient$1$client$1$1(BillingResult billingResult, PlayStoreHelper playStoreHelper, List<Purchase> list, Continuation<? super PlayStoreHelper$getBillingClient$1$client$1$1> continuation) {
        super(2, continuation);
        this.$billingResult = billingResult;
        this.this$0 = playStoreHelper;
        this.$purchases = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayStoreHelper$getBillingClient$1$client$1$1(this.$billingResult, this.this$0, this.$purchases, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayStoreHelper$getBillingClient$1$client$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LoggerImpl.INSTANCE.i("[HiveIAP] PlayStoreHelper billingResult: " + this.$billingResult.getResponseCode() + " (" + this.$billingResult.getDebugMessage() + ')');
            int responseCode = this.$billingResult.getResponseCode();
            PlayStoreHelper.PurchaseFlowListener purchaseFlowListener = this.this$0.purchaseListener;
            if (purchaseFlowListener != null) {
                PlayStoreHelper playStoreHelper = this.this$0;
                List<Purchase> list = this.$purchases;
                BillingResult billingResult = this.$billingResult;
                MainCoroutineDispatcher mainCoroutineDispatcher = playStoreHelper.mainDispatcher;
                PlayStoreHelper$getBillingClient$1$client$1$1$1$1 playStoreHelper$getBillingClient$1$client$1$1$1$1 = new PlayStoreHelper$getBillingClient$1$client$1$1$1$1(responseCode, list, purchaseFlowListener, billingResult, playStoreHelper, null);
                this.I$0 = responseCode;
                this.label = 1;
                if (BuildersKt.withContext(mainCoroutineDispatcher, playStoreHelper$getBillingClient$1$client$1$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                List<Purchase> list2 = this.$purchases;
                PlayStoreHelper playStoreHelper2 = this.this$0;
                if (responseCode == 0 && list2 != null) {
                    for (Purchase purchase : list2) {
                        LoggerImpl.INSTANCE.iL("[HiveIAP] PlayStoreHelper PurchaseUpdated queued interwork://iap/iapupdated : " + purchase);
                        LoggerImpl.INSTANCE.iR("[HiveIAP] PlayStoreHelper PurchaseUpdated queued interwork://iap/iapupdated");
                    }
                }
                MainCoroutineDispatcher mainCoroutineDispatcher2 = playStoreHelper2.mainDispatcher;
                PlayStoreHelper$getBillingClient$1$client$1$1$2$1 playStoreHelper$getBillingClient$1$client$1$1$2$1 = new PlayStoreHelper$getBillingClient$1$client$1$1$2$1(playStoreHelper2, null);
                this.label = 2;
                if (BuildersKt.withContext(mainCoroutineDispatcher2, playStoreHelper$getBillingClient$1$client$1$1$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
