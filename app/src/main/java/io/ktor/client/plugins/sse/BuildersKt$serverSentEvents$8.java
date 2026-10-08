package io.ktor.client.plugins.sse;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: builders.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.BuildersKt", f = "builders.kt", i = {0, 1}, l = {648, 650}, m = "serverSentEvents-Mswn-_c", n = {"block", "session"}, s = {"L$0", "L$0"})
final class BuildersKt$serverSentEvents$8 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    BuildersKt$serverSentEvents$8(Continuation<? super BuildersKt$serverSentEvents$8> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BuildersKt.m7245serverSentEventsMswn_c(null, null, null, null, null, null, null, this);
    }
}
