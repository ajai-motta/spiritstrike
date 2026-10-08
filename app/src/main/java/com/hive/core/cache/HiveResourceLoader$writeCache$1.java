package com.hive.core.cache;

import com.hive.core.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HiveResourceLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.core.cache.HiveResourceLoader$writeCache$1", f = "HiveResourceLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HiveResourceLoader$writeCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ String $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HiveResourceLoader$writeCache$1(String str, byte[] bArr, Continuation<? super HiveResourceLoader$writeCache$1> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$data = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HiveResourceLoader$writeCache$1(this.$url, this.$data, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HiveResourceLoader$writeCache$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if ((!StringsKt.isBlank(this.$url)) && this.$data != null) {
            String strMakeToSHA256 = HiveResourceLoader.INSTANCE.makeToSHA256(this.$url);
            String str = strMakeToSHA256;
            if (str != null && !StringsKt.isBlank(str)) {
                HiveResourceLoader.INSTANCE.writeMemoryCache(strMakeToSHA256, this.$data);
                HiveResourceLoader.INSTANCE.writeDiskCache(this.$url, strMakeToSHA256, this.$data);
            } else {
                Logger.INSTANCE.w("[HiveResourceLoader] writeDiskCache invalid hash string: " + strMakeToSHA256);
            }
        }
        return Unit.INSTANCE;
    }
}
