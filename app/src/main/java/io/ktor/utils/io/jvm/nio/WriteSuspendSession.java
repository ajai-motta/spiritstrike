package io.ktor.utils.io.jvm.nio;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Sink;

/* JADX INFO: compiled from: WriteSuspendSession.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/utils/io/jvm/nio/WriteSuspendSession;", "", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "", "count", "Ljava/nio/ByteBuffer;", "request", "(I)Ljava/nio/ByteBuffer;", "", "tryAwait", "(I)V", "rc", "written", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "getChannel", "()Lio/ktor/utils/io/ByteWriteChannel;", "kotlin.jvm.PlatformType", "byteBuffer", "Ljava/nio/ByteBuffer;", "ktor-io"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WriteSuspendSession {
    private final ByteBuffer byteBuffer;
    private final ByteWriteChannel channel;

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.nio.WriteSuspendSession$written$1, reason: invalid class name */
    /* JADX INFO: compiled from: WriteSuspendSession.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.nio.WriteSuspendSession", f = "WriteSuspendSession.kt", i = {}, l = {30, 32}, m = "written", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WriteSuspendSession.this.written(0, this);
        }
    }

    public WriteSuspendSession(ByteWriteChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.byteBuffer = ByteBuffer.allocate(8192);
    }

    public final ByteWriteChannel getChannel() {
        return this.channel;
    }

    public final ByteBuffer request(int count) {
        return this.byteBuffer;
    }

    public final void tryAwait(int count) {
        Sink writeBuffer = this.channel.getWriteBuffer();
        ByteBuffer byteBuffer = this.byteBuffer;
        Intrinsics.checkNotNullExpressionValue(byteBuffer, "byteBuffer");
        OutputArraysJVMKt.writeByteBuffer(writeBuffer, byteBuffer);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object written(int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r6 = r7 instanceof io.ktor.utils.io.jvm.nio.WriteSuspendSession.AnonymousClass1
            if (r6 == 0) goto L14
            r6 = r7
            io.ktor.utils.io.jvm.nio.WriteSuspendSession$written$1 r6 = (io.ktor.utils.io.jvm.nio.WriteSuspendSession.AnonymousClass1) r6
            int r0 = r6.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L14
            int r7 = r6.label
            int r7 = r7 - r1
            r6.label = r7
            goto L19
        L14:
            io.ktor.utils.io.jvm.nio.WriteSuspendSession$written$1 r6 = new io.ktor.utils.io.jvm.nio.WriteSuspendSession$written$1
            r6.<init>(r7)
        L19:
            java.lang.Object r7 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L39
            if (r1 == r3) goto L35
            if (r1 != r2) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L63
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L53
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            java.nio.ByteBuffer r7 = r5.byteBuffer
            r7.flip()
            io.ktor.utils.io.ByteWriteChannel r7 = r5.channel
            java.nio.ByteBuffer r1 = r5.byteBuffer
            java.lang.String r4 = "byteBuffer"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r6.label = r3
            java.lang.Object r7 = io.ktor.utils.io.ByteWriteChannelOperations_jvmKt.writeFully(r7, r1, r6)
            if (r7 != r0) goto L53
            return r0
        L53:
            java.nio.ByteBuffer r7 = r5.byteBuffer
            r7.clear()
            io.ktor.utils.io.ByteWriteChannel r7 = r5.channel
            r6.label = r2
            java.lang.Object r6 = r7.flush(r6)
            if (r6 != r0) goto L63
            return r0
        L63:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.nio.WriteSuspendSession.written(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
