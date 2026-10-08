package com.hive.iapv4.market.google;

import com.android.billingclient.api.Purchase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PlayStoreHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.iapv4.market.google.PlayStoreHelper$awaitFindPurchase$2$1", f = "PlayStoreHelper.kt", i = {}, l = {419, 430}, m = "invokeSuspend", n = {}, s = {})
final class PlayStoreHelper$awaitFindPurchase$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<Purchase> $cont;
    final /* synthetic */ String $productId;
    final /* synthetic */ String $productType;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PlayStoreHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PlayStoreHelper$awaitFindPurchase$2$1(PlayStoreHelper playStoreHelper, CancellableContinuation<? super Purchase> cancellableContinuation, String str, String str2, Continuation<? super PlayStoreHelper$awaitFindPurchase$2$1> continuation) {
        super(2, continuation);
        this.this$0 = playStoreHelper;
        this.$cont = cancellableContinuation;
        this.$productType = str;
        this.$productId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayStoreHelper$awaitFindPurchase$2$1(this.this$0, this.$cont, this.$productType, this.$productId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayStoreHelper$awaitFindPurchase$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009a A[Catch: all -> 0x001c, TryCatch #0 {all -> 0x001c, blocks: (B:7:0x0017, B:33:0x0090, B:35:0x009a, B:36:0x00a0, B:38:0x00a6, B:40:0x00af, B:42:0x00b5, B:44:0x00be, B:48:0x00c6, B:50:0x00ca, B:52:0x00e6, B:53:0x00f1, B:55:0x00f4, B:29:0x007f), top: B:65:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.market.google.PlayStoreHelper$awaitFindPurchase$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
