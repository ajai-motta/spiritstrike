package io.ktor.client.call;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SavedCall.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "save", "(Lio/ktor/client/call/HttpClientCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SavedCallKt {

    /* JADX INFO: renamed from: io.ktor.client.call.SavedCallKt$save$1, reason: invalid class name */
    /* JADX INFO: compiled from: SavedCall.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.call.SavedCallKt", f = "SavedCall.kt", i = {0}, l = {36}, m = "save", n = {"$this$save"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SavedCallKt.save(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object save(io.ktor.client.call.HttpClientCall r4, kotlin.coroutines.Continuation<? super io.ktor.client.call.HttpClientCall> r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.client.call.SavedCallKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.client.call.SavedCallKt$save$1 r0 = (io.ktor.client.call.SavedCallKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.client.call.SavedCallKt$save$1 r0 = new io.ktor.client.call.SavedCallKt$save$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.client.call.HttpClientCall r4 = (io.ktor.client.call.HttpClientCall) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4c
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            io.ktor.client.statement.HttpResponse r5 = r4.getResponse()
            io.ktor.utils.io.ByteReadChannel r5 = r5.getRawContent()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(r5, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            kotlinx.io.Source r5 = (kotlinx.io.Source) r5
            byte[] r5 = kotlinx.io.SourcesKt.readByteArray(r5)
            io.ktor.client.call.SavedHttpCall r0 = new io.ktor.client.call.SavedHttpCall
            io.ktor.client.HttpClient r1 = r4.getClient()
            io.ktor.client.request.HttpRequest r2 = r4.getRequest()
            io.ktor.client.statement.HttpResponse r4 = r4.getResponse()
            r0.<init>(r1, r2, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.call.SavedCallKt.save(io.ktor.client.call.HttpClientCall, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
