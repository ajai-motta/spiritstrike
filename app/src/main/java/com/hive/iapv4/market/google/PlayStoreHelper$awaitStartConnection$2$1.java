package com.hive.iapv4.market.google;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PlayStoreHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.iapv4.market.google.PlayStoreHelper$awaitStartConnection$2$1", f = "PlayStoreHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PlayStoreHelper$awaitStartConnection$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<Boolean> $cont;
    int label;
    final /* synthetic */ PlayStoreHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PlayStoreHelper$awaitStartConnection$2$1(PlayStoreHelper playStoreHelper, CancellableContinuation<? super Boolean> cancellableContinuation, Continuation<? super PlayStoreHelper$awaitStartConnection$2$1> continuation) {
        super(2, continuation);
        this.this$0 = playStoreHelper;
        this.$cont = cancellableContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayStoreHelper$awaitStartConnection$2$1(this.this$0, this.$cont, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayStoreHelper$awaitStartConnection$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM7415constructorimpl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final PlayStoreHelper playStoreHelper = this.this$0;
        final CancellableContinuation<Boolean> cancellableContinuation = this.$cont;
        try {
            Result.Companion companion = Result.INSTANCE;
            playStoreHelper.getBillingClient().startConnection(new BillingClientStateListener() { // from class: com.hive.iapv4.market.google.PlayStoreHelper$awaitStartConnection$2$1$1$1
                @Override // com.android.billingclient.api.BillingClientStateListener
                public void onBillingSetupFinished(BillingResult billingResult) {
                    Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                    LoggerImpl.INSTANCE.d("[HiveIAP] PlayStoreHelper setup Result: " + billingResult.getResponseCode() + " (" + billingResult.getDebugMessage() + ')');
                    if (billingResult.getResponseCode() != 0) {
                        LoggerImpl.INSTANCE.e("[HiveIAP] PlayStoreHelper connecting failed");
                        playStoreHelper.isConnected = false;
                        BillingClient billingClient = playStoreHelper.billingClient;
                        if (billingClient != null) {
                            billingClient.endConnection();
                        }
                        playStoreHelper.billingClient = null;
                        if (cancellableContinuation.isActive()) {
                            CancellableContinuation<Boolean> cancellableContinuation2 = cancellableContinuation;
                            Result.Companion companion2 = Result.INSTANCE;
                            cancellableContinuation2.resumeWith(Result.m7415constructorimpl(false));
                            return;
                        }
                        return;
                    }
                    boolean z = playStoreHelper.getBillingClient().isFeatureSupported(BillingClient.FeatureType.PRODUCT_DETAILS).getResponseCode() == 0;
                    boolean z2 = playStoreHelper.getBillingClient().isFeatureSupported(BillingClient.FeatureType.SUBSCRIPTIONS).getResponseCode() == 0;
                    boolean z3 = playStoreHelper.getBillingClient().isFeatureSupported(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE).getResponseCode() == 0;
                    boolean z4 = playStoreHelper.getBillingClient().isFeatureSupported(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION).getResponseCode() == 0;
                    boolean z5 = playStoreHelper.getBillingClient().isFeatureSupported(BillingClient.FeatureType.IN_APP_MESSAGING).getResponseCode() == 0;
                    LoggerImpl.INSTANCE.d("[HiveIAP] PlayStoreHelper isSupported?\n    PRODUCT_DETAILS : " + z + "\n    SUBSCRIPTIONS : " + z2 + "\n    SUBSCRIPTIONS_UPDATE : " + z3 + "\n    PRICE_CHANGE_CONFIRMATION : " + z4 + "\n    IN_APP_MESSAGING : " + z5 + '\n');
                    playStoreHelper.isConnected = true;
                    if (cancellableContinuation.isActive()) {
                        CancellableContinuation<Boolean> cancellableContinuation3 = cancellableContinuation;
                        Result.Companion companion3 = Result.INSTANCE;
                        cancellableContinuation3.resumeWith(Result.m7415constructorimpl(true));
                    }
                }

                @Override // com.android.billingclient.api.BillingClientStateListener
                public void onBillingServiceDisconnected() {
                    LoggerImpl.INSTANCE.w("[HiveIAP] PlayStoreHelper onBillingServiceDisconnected");
                    playStoreHelper.isConnected = false;
                    BillingClient billingClient = playStoreHelper.billingClient;
                    if (billingClient != null) {
                        billingClient.endConnection();
                    }
                    playStoreHelper.billingClient = null;
                    if (cancellableContinuation.isActive()) {
                        CancellableContinuation<Boolean> cancellableContinuation2 = cancellableContinuation;
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation2.resumeWith(Result.m7415constructorimpl(false));
                    }
                }
            });
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        PlayStoreHelper playStoreHelper2 = this.this$0;
        CancellableContinuation<Boolean> cancellableContinuation2 = this.$cont;
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.e("[HiveIAP] PlayStoreHelper connecting exception : " + thM7418exceptionOrNullimpl);
            playStoreHelper2.isConnected = false;
            BillingClient billingClient = playStoreHelper2.billingClient;
            if (billingClient != null) {
                billingClient.endConnection();
            }
            playStoreHelper2.billingClient = null;
            if (cancellableContinuation2.isActive()) {
                Result.Companion companion3 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m7415constructorimpl(Boxing.boxBoolean(false)));
            }
        }
        return Unit.INSTANCE;
    }
}
