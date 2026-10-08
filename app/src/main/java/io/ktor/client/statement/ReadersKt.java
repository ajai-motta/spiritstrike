package io.ktor.client.statement;

import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Readers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0087@¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0000H\u0086@¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "", "count", "", "readBytes", "(Lio/ktor/client/statement/HttpResponse;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRawBytes", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "discardRemaining", "ktor-client-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ReadersKt {

    /* JADX INFO: renamed from: io.ktor.client.statement.ReadersKt$readBytes$1, reason: invalid class name */
    /* JADX INFO: compiled from: Readers.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", i = {}, l = {17}, m = "readBytes", n = {}, s = {})
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
            return ReadersKt.readBytes(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.ReadersKt$readBytes$3, reason: invalid class name */
    /* JADX INFO: compiled from: Readers.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", i = {}, l = {53}, m = "readBytes", n = {}, s = {})
    static final class AnonymousClass3 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadersKt.readBytes(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.ReadersKt$readRawBytes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Readers.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", i = {}, l = {35}, m = "readRawBytes", n = {}, s = {})
    static final class C32951 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C32951(Continuation<? super C32951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadersKt.readRawBytes(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readBytes(io.ktor.client.statement.HttpResponse r8, int r9, kotlin.coroutines.Continuation<? super byte[]> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.ktor.client.statement.ReadersKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.client.statement.ReadersKt$readBytes$1 r0 = (io.ktor.client.statement.ReadersKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.client.statement.ReadersKt$readBytes$1 r0 = new io.ktor.client.statement.ReadersKt$readBytes$1
            r0.<init>(r10)
        L19:
            r5 = r0
            java.lang.Object r10 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r8 = r5.L$0
            byte[] r8 = (byte[]) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L51
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r10)
            byte[] r9 = new byte[r9]
            io.ktor.utils.io.ByteReadChannel r1 = r8.getRawContent()
            r5.L$0 = r9
            r5.label = r2
            r3 = 0
            r4 = 0
            r6 = 6
            r7 = 0
            r2 = r9
            java.lang.Object r8 = io.ktor.utils.io.ByteReadChannelOperationsKt.readFully$default(r1, r2, r3, r4, r5, r6, r7)
            if (r8 != r0) goto L50
            return r0
        L50:
            r8 = r9
        L51:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.ReadersKt.readBytes(io.ktor.client.statement.HttpResponse, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readRawBytes(io.ktor.client.statement.HttpResponse r4, kotlin.coroutines.Continuation<? super byte[]> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.client.statement.ReadersKt.C32951
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.client.statement.ReadersKt$readRawBytes$1 r0 = (io.ktor.client.statement.ReadersKt.C32951) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.client.statement.ReadersKt$readRawBytes$1 r0 = new io.ktor.client.statement.ReadersKt$readRawBytes$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L42
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            io.ktor.utils.io.ByteReadChannel r4 = r4.getRawContent()
            r0.label = r3
            java.lang.Object r5 = io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(r4, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlinx.io.Source r5 = (kotlinx.io.Source) r5
            byte[] r4 = kotlinx.io.SourcesKt.readByteArray(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.ReadersKt.readRawBytes(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @kotlin.Deprecated(message = "This method was renamed to readRawBytes() to reflect what it does.", replaceWith = @kotlin.ReplaceWith(expression = "readRawBytes()", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readBytes(io.ktor.client.statement.HttpResponse r4, kotlin.coroutines.Continuation<? super byte[]> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.client.statement.ReadersKt.AnonymousClass3
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.client.statement.ReadersKt$readBytes$3 r0 = (io.ktor.client.statement.ReadersKt.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.client.statement.ReadersKt$readBytes$3 r0 = new io.ktor.client.statement.ReadersKt$readBytes$3
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L42
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            io.ktor.utils.io.ByteReadChannel r4 = r4.getRawContent()
            r0.label = r3
            java.lang.Object r5 = io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(r4, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            kotlinx.io.Source r5 = (kotlinx.io.Source) r5
            byte[] r4 = kotlinx.io.SourcesKt.readByteArray(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.ReadersKt.readBytes(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object discardRemaining(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        Object objDiscard$default = ByteReadChannelOperationsKt.discard$default(httpResponse.getRawContent(), 0L, continuation, 1, null);
        return objDiscard$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDiscard$default : Unit.INSTANCE;
    }
}
