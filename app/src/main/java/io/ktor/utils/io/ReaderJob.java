package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ByteReadChannelOperations.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0087@¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/utils/io/ChannelJob;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/coroutines/Job;)V", "", "flushAndClose", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "getChannel", "()Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "ktor-io"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReaderJob implements ChannelJob {
    private final ByteWriteChannel channel;
    private final Job job;

    /* JADX INFO: renamed from: io.ktor.utils.io.ReaderJob$flushAndClose$1, reason: invalid class name */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ReaderJob", f = "ByteReadChannelOperations.kt", i = {}, l = {311, 313}, m = "flushAndClose", n = {}, s = {})
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
            return ReaderJob.this.flushAndClose(this);
        }
    }

    public ReaderJob(ByteWriteChannel channel, Job job) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(job, "job");
        this.channel = channel;
        this.job = job;
    }

    public final ByteWriteChannel getChannel() {
        return this.channel;
    }

    @Override // io.ktor.utils.io.ChannelJob
    public Job getJob() {
        return this.job;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object flushAndClose(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ReaderJob.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ReaderJob$flushAndClose$1 r0 = (io.ktor.utils.io.ReaderJob.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ReaderJob$flushAndClose$1 r0 = new io.ktor.utils.io.ReaderJob$flushAndClose$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r7)
            goto L7c
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L36:
            java.lang.Object r2 = r0.L$0
            java.util.Iterator r2 = (java.util.Iterator) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L55
        L3e:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.Job r7 = r6.getJob()
            kotlinx.coroutines.JobKt.cancelChildren$default(r7, r5, r4, r5)
            kotlinx.coroutines.Job r7 = r6.getJob()
            kotlin.sequences.Sequence r7 = r7.getChildren()
            java.util.Iterator r7 = r7.iterator()
            r2 = r7
        L55:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L6f
            java.lang.Object r7 = r2.next()
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r7, r5, r4, r5)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.join(r0)
            if (r7 != r1) goto L55
            return r1
        L6f:
            io.ktor.utils.io.ByteWriteChannel r7 = r6.channel
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = r7.flushAndClose(r0)
            if (r7 != r1) goto L7c
            return r1
        L7c:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReaderJob.flushAndClose(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
