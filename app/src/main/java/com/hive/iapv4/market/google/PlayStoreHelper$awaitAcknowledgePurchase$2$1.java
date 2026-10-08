package com.hive.iapv4.market.google;

import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PlayStoreHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.iapv4.market.google.PlayStoreHelper$awaitAcknowledgePurchase$2$1", f = "PlayStoreHelper.kt", i = {}, l = {393}, m = "invokeSuspend", n = {}, s = {})
final class PlayStoreHelper$awaitAcknowledgePurchase$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<Pair<BillingResult, ? extends Purchase>> $cont;
    final /* synthetic */ String $productId;
    int label;
    final /* synthetic */ PlayStoreHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PlayStoreHelper$awaitAcknowledgePurchase$2$1(PlayStoreHelper playStoreHelper, String str, CancellableContinuation<? super Pair<BillingResult, ? extends Purchase>> cancellableContinuation, Continuation<? super PlayStoreHelper$awaitAcknowledgePurchase$2$1> continuation) {
        super(2, continuation);
        this.this$0 = playStoreHelper;
        this.$productId = str;
        this.$cont = cancellableContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayStoreHelper$awaitAcknowledgePurchase$2$1(this.this$0, this.$productId, this.$cont, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayStoreHelper$awaitAcknowledgePurchase$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.awaitFindPurchase(this.$productId, "subs", this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        final Purchase purchase = (Purchase) obj;
        if (purchase != null) {
            PlayStoreHelper playStoreHelper = this.this$0;
            final CancellableContinuation<Pair<BillingResult, ? extends Purchase>> cancellableContinuation = this.$cont;
            AcknowledgePurchaseParams acknowledgePurchaseParamsBuild = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build();
            Intrinsics.checkNotNullExpressionValue(acknowledgePurchaseParamsBuild, "build(...)");
            playStoreHelper.getBillingClient().acknowledgePurchase(acknowledgePurchaseParamsBuild, new AcknowledgePurchaseResponseListener() { // from class: com.hive.iapv4.market.google.PlayStoreHelper$awaitAcknowledgePurchase$2$1$1$1
                @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
                public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                    Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                    LoggerImpl.INSTANCE.i("[HiveIAP] PlayStoreHelper awaitAcknowledgePurchase Result: " + billingResult.getResponseCode() + " (" + billingResult.getDebugMessage() + ')');
                    if (cancellableContinuation.isActive()) {
                        CancellableContinuation<Pair<BillingResult, ? extends Purchase>> cancellableContinuation2 = cancellableContinuation;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation2.resumeWith(Result.m7415constructorimpl(new Pair(billingResult, purchase)));
                    }
                }
            });
        } else {
            String str = this.$productId;
            CancellableContinuation<Pair<BillingResult, ? extends Purchase>> cancellableContinuation2 = this.$cont;
            BillingResult billingResultBuild = BillingResult.newBuilder().setResponseCode(8).setDebugMessage("PlayStoreHelper awaitAcknowledgePurchase item not owned: " + str).build();
            Intrinsics.checkNotNullExpressionValue(billingResultBuild, "build(...)");
            if (cancellableContinuation2.isActive()) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m7415constructorimpl(new Pair(billingResultBuild, null)));
            }
        }
        return Unit.INSTANCE;
    }
}
