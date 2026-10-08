package io.ktor.utils.io.jvm.nio;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.SegmentKt;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* JADX INFO: compiled from: WriteSuspendSession.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a=\u0010\b\u001a\u00020\u0004*\u00020\u00002'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0087@¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\r\u001a\u00020\u0004*\u00020\u00002\u0014\b\u0004\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0086H¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlin/Function2;", "Lio/ktor/utils/io/jvm/nio/WriteSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "writeSuspendSession", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "", "writeWhile", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class WriteSuspendSessionKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt$writeSuspendSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: WriteSuspendSession.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt", f = "WriteSuspendSession.kt", i = {0}, l = {43, 45, 45}, m = "writeSuspendSession", n = {"$this$writeSuspendSession"}, s = {"L$0"})
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
            return WriteSuspendSessionKt.writeSuspendSession(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt$writeWhile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WriteSuspendSession.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt", f = "WriteSuspendSession.kt", i = {0, 0, 0}, l = {59}, m = "writeWhile", n = {"$this$writeWhile", "block", "done"}, s = {"L$0", "L$1", "L$2"})
    static final class C33611 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C33611(Continuation<? super C33611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WriteSuspendSessionKt.writeWhile(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r7v0, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "writeSuspendSession deprecated, use writeWhile instead", replaceWith = @kotlin.ReplaceWith(expression = "writeWhile { buffer -> }", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object writeSuspendSession(io.ktor.utils.io.ByteWriteChannel r7, kotlin.jvm.functions.Function2<? super io.ktor.utils.io.jvm.nio.WriteSuspendSession, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt$writeSuspendSession$1 r0 = (io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt$writeSuspendSession$1 r0 = new io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt$writeSuspendSession$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L40
            if (r2 == r4) goto L3c
            if (r2 == r3) goto L34
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.L$0
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L79
        L3c:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L67
        L40:
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L6a
            goto L5b
        L48:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.utils.io.jvm.nio.WriteSuspendSession r9 = new io.ktor.utils.io.jvm.nio.WriteSuspendSession     // Catch: java.lang.Throwable -> L6a
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L6a
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L6a
            r0.label = r5     // Catch: java.lang.Throwable -> L6a
            java.lang.Object r8 = r8.invoke(r9, r0)     // Catch: java.lang.Throwable -> L6a
            if (r8 != r1) goto L5b
            return r1
        L5b:
            r8 = 0
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r7 = r7.flush(r0)
            if (r7 != r1) goto L67
            return r1
        L67:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L6a:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r8.flush(r0)
            if (r8 != r1) goto L79
            return r1
        L79:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt.writeSuspendSession(io.ktor.utils.io.ByteWriteChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object writeWhile(io.ktor.utils.io.ByteWriteChannel r10, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, java.lang.Boolean> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt.writeWhile(io.ktor.utils.io.ByteWriteChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object writeWhile$$forInline(ByteWriteChannel byteWriteChannel, Function1<? super ByteBuffer, Boolean> function1, Continuation<? super Unit> continuation) {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        while (!booleanRef.element) {
            UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
            Buffer bufferField = byteWriteChannel.getWriteBuffer().getBufferField();
            Segment segmentWritableSegment = bufferField.writableSegment(1);
            byte[] bArrDataAsByteArray = segmentWritableSegment.dataAsByteArray(false);
            Integer numValueOf = Integer.valueOf(segmentWritableSegment.getLimit());
            int iIntValue = Integer.valueOf(bArrDataAsByteArray.length).intValue();
            int iIntValue2 = numValueOf.intValue();
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrDataAsByteArray, iIntValue2, iIntValue - iIntValue2);
            Intrinsics.checkNotNull(byteBufferWrap);
            booleanRef.element = !function1.invoke(byteBufferWrap).booleanValue();
            int iIntValue3 = Integer.valueOf(byteBufferWrap.position() - iIntValue2).intValue();
            if (iIntValue3 == 1) {
                segmentWritableSegment.writeBackData(bArrDataAsByteArray, iIntValue3);
                segmentWritableSegment.setLimit(segmentWritableSegment.getLimit() + iIntValue3);
                bufferField.setSizeMut(bufferField.getSizeMut() + ((long) iIntValue3));
            } else {
                if (iIntValue3 < 0 || iIntValue3 > segmentWritableSegment.getRemainingCapacity()) {
                    throw new IllegalStateException(("Invalid number of bytes written: " + iIntValue3 + ". Should be in 0.." + segmentWritableSegment.getRemainingCapacity()).toString());
                }
                if (iIntValue3 != 0) {
                    segmentWritableSegment.writeBackData(bArrDataAsByteArray, iIntValue3);
                    segmentWritableSegment.setLimit(segmentWritableSegment.getLimit() + iIntValue3);
                    bufferField.setSizeMut(bufferField.getSizeMut() + ((long) iIntValue3));
                } else if (SegmentKt.isEmpty(segmentWritableSegment)) {
                    bufferField.recycleTail();
                }
            }
            InlineMarker.mark(0);
            byteWriteChannel.flush(continuation);
            InlineMarker.mark(1);
        }
        return Unit.INSTANCE;
    }
}
