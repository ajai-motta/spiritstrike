package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Writing.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a&\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Ljava/io/OutputStream;", "out", "", "limit", "copyTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/io/OutputStream;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class WritingKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: Writing.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.WritingKt", f = "Writing.kt", i = {0, 0, 0}, l = {25}, m = "copyTo", n = {"$this$copyTo", "out", "result"}, s = {"L$0", "L$1", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WritingKt.copyTo(null, null, 0L, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0053 -> B:25:0x006c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0066 -> B:24:0x0069). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r10, java.io.OutputStream r11, long r12, kotlin.coroutines.Continuation<? super java.lang.Long> r14) throws java.lang.Throwable {
        /*
            boolean r0 = r14 instanceof io.ktor.utils.io.jvm.javaio.WritingKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r14
            io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1 r0 = (io.ktor.utils.io.jvm.javaio.WritingKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1 r0 = new io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1
            r0.<init>(r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            long r10 = r0.J$0
            java.lang.Object r12 = r0.L$1
            java.io.OutputStream r12 = (java.io.OutputStream) r12
            java.lang.Object r13 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r13 = (io.ktor.utils.io.ByteReadChannel) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L69
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            kotlin.ResultKt.throwOnFailure(r14)
            r4 = 0
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 < 0) goto L90
        L45:
            boolean r12 = r10.isClosedForRead()
            if (r12 != 0) goto L8b
            kotlinx.io.Source r12 = r10.getReadBuffer()
            boolean r12 = r12.exhausted()
            if (r12 == 0) goto L6c
            r0.L$0 = r10
            r0.L$1 = r11
            r0.J$0 = r4
            r0.label = r3
            r12 = 0
            r13 = 0
            java.lang.Object r12 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r10, r12, r0, r3, r13)
            if (r12 != r1) goto L66
            return r1
        L66:
            r13 = r10
            r12 = r11
            r10 = r4
        L69:
            r4 = r10
            r11 = r12
            r10 = r13
        L6c:
            kotlinx.io.Source r12 = r10.getReadBuffer()
            kotlinx.io.Buffer r12 = r12.getBufferField()
            long r12 = r12.getSizeMut()
            long r12 = r12 + r4
            kotlinx.io.Source r14 = r10.getReadBuffer()
            kotlinx.io.Buffer r4 = r14.getBufferField()
            r8 = 2
            r9 = 0
            r6 = 0
            r5 = r11
            kotlinx.io.BuffersJvmKt.readTo$default(r4, r5, r6, r8, r9)
            r4 = r12
            goto L45
        L8b:
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            return r10
        L90:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Limit shouldn't be negative: "
            r10.<init>(r11)
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.WritingKt.copyTo(io.ktor.utils.io.ByteReadChannel, java.io.OutputStream, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, OutputStream outputStream, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, outputStream, j, continuation);
    }
}
