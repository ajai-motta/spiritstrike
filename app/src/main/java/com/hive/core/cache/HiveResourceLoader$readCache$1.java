package com.hive.core.cache;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HiveResourceLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.core.cache.HiveResourceLoader$readCache$1", f = "HiveResourceLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HiveResourceLoader$readCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $hashUrl;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HiveResourceLoader$readCache$1(String str, Continuation<? super HiveResourceLoader$readCache$1> continuation) {
        super(2, continuation);
        this.$hashUrl = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HiveResourceLoader$readCache$1(this.$hashUrl, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HiveResourceLoader$readCache$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ConcurrentHashMap concurrentHashMap = HiveResourceLoader.diskCacheAccessCount;
            String str = this.$hashUrl;
            Integer num = (Integer) HiveResourceLoader.diskCacheAccessCount.get(this.$hashUrl);
            concurrentHashMap.put(str, Boxing.boxInt(num != null ? 1 + num.intValue() : 1));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
