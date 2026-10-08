package io.ktor.utils.io;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ByteChannel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001GB\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u0012\u0010\u000fJ\u0019\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019JH\u0010!\u001a\u00020\u000b\"\n\b\u0000\u0010\u001b\u0018\u0001*\u00020\u001a2\u001a\b\u0004\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001d\u0012\u0004\u0012\u00028\u00000\u001c2\u000e\b\u0004\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001fH\u0082H¢\u0006\u0004\b!\u0010\"J\u001c\u0010$\u001a\u00020\u000b\"\n\b\u0000\u0010#\u0018\u0001*\u00020\u001aH\u0082\b¢\u0006\u0004\b$\u0010\rJ\u0019\u0010%\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b%\u0010\u0016J4\u0010'\u001a\u00020\u000b\"\n\b\u0000\u0010\u001b\u0018\u0001*\u00020\u001a2\u0006\u0010&\u001a\u00028\u00002\u000e\b\u0004\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001fH\u0082\b¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001e\u00103\u001a\u000601j\u0002`28\u0002X\u0082\u0004¢\u0006\f\n\u0004\b3\u00104\u0012\u0004\b5\u0010\rR\u0014\u00106\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010.R\u0014\u00107\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010.R\u001a\u0010<\u001a\u0002088VX\u0097\u0004¢\u0006\f\u0012\u0004\b;\u0010\r\u001a\u0004\b9\u0010:R\u001a\u0010A\u001a\u00020=8VX\u0097\u0004¢\u0006\f\u0012\u0004\b@\u0010\r\u001a\u0004\b>\u0010?R\u0016\u0010D\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010+R\u0014\u0010F\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010+¨\u0006H"}, d2 = {"Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/BufferedByteWriteChannel;", "", "autoFlush", "<init>", "(Z)V", "", "min", "awaitContent", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "moveFlushToReadBuffer", "()V", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flushWriteBuffer", "close", "flushAndClose", "", "cause", "cancel", "(Ljava/lang/Throwable;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "TaskType", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "createTask", "Lkotlin/Function0;", "shouldSleep", "sleepWhile", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Expected", "resumeSlot", "closeSlot", "slot", "trySuspend", "(Lio/ktor/utils/io/ByteChannel$Slot$Task;Lkotlin/jvm/functions/Function0;)V", "Z", "getAutoFlush", "()Z", "Lkotlinx/io/Buffer;", "flushBuffer", "Lkotlinx/io/Buffer;", "flushBufferSize", "I", "", "Lio/ktor/utils/io/locks/SynchronizedObject;", "flushBufferMutex", "Ljava/lang/Object;", "getFlushBufferMutex$annotations", "_readBuffer", "_writeBuffer", "Lkotlinx/io/Source;", "getReadBuffer", "()Lkotlinx/io/Source;", "getReadBuffer$annotations", "readBuffer", "Lkotlinx/io/Sink;", "getWriteBuffer", "()Lkotlinx/io/Sink;", "getWriteBuffer$annotations", "writeBuffer", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForWrite", "isClosedForRead", "Slot", "ktor-io"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ByteChannel implements ByteReadChannel, BufferedByteWriteChannel {
    volatile /* synthetic */ Object _closedCause;
    private final Buffer _readBuffer;
    private final Buffer _writeBuffer;
    private final boolean autoFlush;
    private final Buffer flushBuffer;
    private final Object flushBufferMutex;
    private volatile int flushBufferSize;
    volatile /* synthetic */ Object suspensionSlot;
    static final /* synthetic */ AtomicReferenceFieldUpdater suspensionSlot$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannel.class, Object.class, "suspensionSlot");
    static final /* synthetic */ AtomicReferenceFieldUpdater _closedCause$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannel.class, Object.class, "_closedCause");

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannel$awaitContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: ByteChannel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannel", f = "ByteChannel.kt", i = {0, 0}, l = {284}, m = "awaitContent", n = {"this_$iv", "min"}, s = {"L$0", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return ByteChannel.this.awaitContent(0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannel$flush$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannel", f = "ByteChannel.kt", i = {0}, l = {284}, m = "flush", n = {"this_$iv"}, s = {"L$0"})
    static final class C33261 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33261(Continuation<? super C33261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannel.this.flush(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannel$flushAndClose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannel", f = "ByteChannel.kt", i = {}, l = {128}, m = "flushAndClose", n = {}, s = {})
    static final class C33271 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C33271(Continuation<? super C33271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannel.this.flushAndClose(this);
        }
    }

    public ByteChannel() {
        this(false, 1, null);
    }

    private static /* synthetic */ void getFlushBufferMutex$annotations() {
    }

    public static /* synthetic */ void getReadBuffer$annotations() {
    }

    public static /* synthetic */ void getWriteBuffer$annotations() {
    }

    public ByteChannel(boolean z) {
        this.autoFlush = z;
        this.flushBuffer = new Buffer();
        this.flushBufferMutex = new Object();
        this.suspensionSlot = Slot.Empty.INSTANCE;
        this._readBuffer = new Buffer();
        this._writeBuffer = new Buffer();
        this._closedCause = null;
    }

    public /* synthetic */ ByteChannel(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean getAutoFlush() {
        return this.autoFlush;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Source getReadBuffer() throws Throwable {
        CloseToken closeToken = (CloseToken) this._closedCause;
        if (closeToken != null) {
            closeToken.throwOrNull(ByteChannel$readBuffer$1.INSTANCE);
        }
        if (this._readBuffer.exhausted()) {
            moveFlushToReadBuffer();
        }
        return this._readBuffer;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Sink getWriteBuffer() throws ClosedWriteChannelException {
        CloseToken closeToken;
        if (isClosedForWrite() && ((closeToken = (CloseToken) this._closedCause) == null || closeToken.throwOrNull(ByteChannel$writeBuffer$1.INSTANCE) == null)) {
            throw new ClosedWriteChannelException(null, 1, null);
        }
        return this._writeBuffer;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public Throwable getClosedCause() {
        CloseToken closeToken = (CloseToken) this._closedCause;
        if (closeToken != null) {
            return CloseToken.wrapCause$default(closeToken, null, 1, null);
        }
        return null;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return this._closedCause != null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean isClosedForRead() {
        return getClosedCause() != null || (isClosedForWrite() && this.flushBufferSize == 0 && this._readBuffer.exhausted());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object awaitContent(int r13, kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannel.awaitContent(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void moveFlushToReadBuffer() {
        synchronized (this.flushBufferMutex) {
            this.flushBuffer.transferTo(this._readBuffer);
            this.flushBufferSize = 0;
            Unit unit = Unit.INSTANCE;
        }
        Slot slot = (Slot) this.suspensionSlot;
        if ((slot instanceof Slot.Write) && AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, slot, Slot.Empty.INSTANCE)) {
            ((Slot.Task) slot).resume();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object flush(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannel.flush(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.BufferedByteWriteChannel
    public void flushWriteBuffer() {
        if (this._writeBuffer.exhausted()) {
            return;
        }
        synchronized (this.flushBufferMutex) {
            int sizeMut = (int) this._writeBuffer.getSizeMut();
            this.flushBuffer.transferFrom(this._writeBuffer);
            this.flushBufferSize += sizeMut;
            Unit unit = Unit.INSTANCE;
        }
        Slot slot = (Slot) this.suspensionSlot;
        if ((slot instanceof Slot.Read) && AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, slot, Slot.Empty.INSTANCE)) {
            ((Slot.Task) slot).resume();
        }
    }

    @Override // io.ktor.utils.io.BufferedByteWriteChannel
    public void close() {
        flushWriteBuffer();
        if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_closedCause$FU, this, null, CloseTokenKt.getCLOSED())) {
            closeSlot(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object flushAndClose(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteChannel.C33271
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ByteChannel$flushAndClose$1 r0 = (io.ktor.utils.io.ByteChannel.C33271) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ByteChannel$flushAndClose$1 r0 = new io.ktor.utils.io.ByteChannel$flushAndClose$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L49
            goto L43
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result$Companion r5 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L49
            r5 = r4
            io.ktor.utils.io.ByteChannel r5 = (io.ktor.utils.io.ByteChannel) r5     // Catch: java.lang.Throwable -> L49
            r0.label = r3     // Catch: java.lang.Throwable -> L49
            java.lang.Object r5 = r4.flush(r0)     // Catch: java.lang.Throwable -> L49
            if (r5 != r1) goto L43
            return r1
        L43:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L49
            kotlin.Result.m7415constructorimpl(r5)     // Catch: java.lang.Throwable -> L49
            goto L53
        L49:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            kotlin.Result.m7415constructorimpl(r5)
        L53:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = io.ktor.utils.io.ByteChannel._closedCause$FU
            io.ktor.utils.io.CloseToken r0 = io.ktor.utils.io.CloseTokenKt.getCLOSED()
            r1 = 0
            boolean r5 = androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(r5, r4, r1, r0)
            if (r5 != 0) goto L63
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L63:
            r4.closeSlot(r1)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannel.flushAndClose(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public void cancel(Throwable cause) {
        if (this._closedCause != null) {
            return;
        }
        CloseToken closeToken = new CloseToken(cause);
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_closedCause$FU, this, null, closeToken);
        closeSlot(CloseToken.wrapCause$default(closeToken, null, 1, null));
    }

    public String toString() {
        return "ByteChannel[" + hashCode() + AbstractJsonLexerKt.END_LIST;
    }

    private final /* synthetic */ <TaskType extends Slot.Task> Object sleepWhile(Function1<? super Continuation<? super Unit>, ? extends TaskType> function1, Function0<Boolean> function0, Continuation<? super Unit> continuation) {
        while (function0.invoke().booleanValue()) {
            InlineMarker.mark(0);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            TaskType tasktypeInvoke = function1.invoke(cancellableContinuationImpl);
            Slot slot = (Slot) this.suspensionSlot;
            boolean z = slot instanceof Slot.Closed;
            if (!z && !AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, slot, tasktypeInvoke)) {
                tasktypeInvoke.resume();
                Unit unit = Unit.INSTANCE;
            } else {
                Intrinsics.reifiedOperationMarker(3, "TaskType");
                boolean z2 = slot instanceof Slot.Task;
                if (z2) {
                    Slot.Task task = (Slot.Task) slot;
                    task.resume(new ConcurrentIOException(tasktypeInvoke.taskName(), task.getCreated()));
                } else if (z2) {
                    ((Slot.Task) slot).resume();
                } else if (z) {
                    tasktypeInvoke.resume(((Slot.Closed) slot).getCause());
                    Unit unit2 = Unit.INSTANCE;
                } else if (!Intrinsics.areEqual(slot, Slot.Empty.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!function0.invoke().booleanValue()) {
                    Slot slot2 = (Slot) this.suspensionSlot;
                    Intrinsics.reifiedOperationMarker(3, "TaskType");
                    if ((slot2 instanceof Slot.Task) && AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, slot2, Slot.Empty.INSTANCE)) {
                        ((Slot.Task) slot2).resume();
                    }
                }
            }
            Unit unit3 = Unit.INSTANCE;
            if (cancellableContinuationImpl.getResult() == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            InlineMarker.mark(1);
        }
        return Unit.INSTANCE;
    }

    private final /* synthetic */ <Expected extends Slot.Task> void resumeSlot() {
        Slot slot = (Slot) this.suspensionSlot;
        Intrinsics.reifiedOperationMarker(3, "Expected");
        if ((slot instanceof Slot.Task) && AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, slot, Slot.Empty.INSTANCE)) {
            ((Slot.Task) slot).resume();
        }
    }

    private final void closeSlot(Throwable cause) {
        Slot slot = (Slot) suspensionSlot$FU.getAndSet(this, cause != null ? new Slot.Closed(cause) : Slot.INSTANCE.getCLOSED());
        if (slot instanceof Slot.Task) {
            ((Slot.Task) slot).resume(cause);
        }
    }

    private final /* synthetic */ <TaskType extends Slot.Task> void trySuspend(TaskType slot, Function0<Boolean> shouldSleep) {
        Slot slot2 = (Slot) this.suspensionSlot;
        boolean z = slot2 instanceof Slot.Closed;
        if (!z && !AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, slot2, slot)) {
            slot.resume();
            return;
        }
        Intrinsics.reifiedOperationMarker(3, "TaskType");
        boolean z2 = slot2 instanceof Slot.Task;
        if (z2) {
            Slot.Task task = (Slot.Task) slot2;
            task.resume(new ConcurrentIOException(slot.taskName(), task.getCreated()));
        } else if (z2) {
            ((Slot.Task) slot2).resume();
        } else if (z) {
            slot.resume(((Slot.Closed) slot2).getCause());
            return;
        } else if (!Intrinsics.areEqual(slot2, Slot.Empty.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        if (shouldSleep.invoke().booleanValue()) {
            return;
        }
        Slot slot3 = (Slot) this.suspensionSlot;
        Intrinsics.reifiedOperationMarker(3, "TaskType");
        if ((slot3 instanceof Slot.Task) && AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(suspensionSlot$FU, this, slot3, Slot.Empty.INSTANCE)) {
            ((Slot.Task) slot3).resume();
        }
    }

    /* JADX INFO: compiled from: ByteChannel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u0000 \u00022\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot;", "", k.M, "Empty", ADXLogUtil.EVENT_CLOSED, "Task", "Read", "Write", "Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "Lio/ktor/utils/io/ByteChannel$Slot$Empty;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "ktor-io"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private interface Slot {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannel$Slot$-CC, reason: invalid class name */
        /* JADX INFO: compiled from: ByteChannel.kt */
        public final /* synthetic */ class CC {
            static {
                Companion companion = Slot.INSTANCE;
            }

            public static Closed getCLOSED() {
                return Slot.INSTANCE.getCLOSED();
            }

            /* JADX INFO: renamed from: getRESUME-d1pmJ48, reason: not valid java name */
            public static Object m7378getRESUMEd1pmJ48() {
                return Slot.INSTANCE.m7380getRESUMEd1pmJ48();
            }
        }

        /* JADX INFO: compiled from: ByteChannel.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Companion;", "", "<init>", "()V", "Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "CLOSED", "Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "getCLOSED", "()Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "getCLOSED$annotations", "Lkotlin/Result;", "", "RESUME", "Ljava/lang/Object;", "getRESUME-d1pmJ48", "()Ljava/lang/Object;", "getRESUME-d1pmJ48$annotations", "ktor-io"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final Closed CLOSED = new Closed(null);
            private static final Object RESUME;

            @JvmStatic
            public static /* synthetic */ void getCLOSED$annotations() {
            }

            @JvmStatic
            /* JADX INFO: renamed from: getRESUME-d1pmJ48$annotations, reason: not valid java name */
            public static /* synthetic */ void m7379getRESUMEd1pmJ48$annotations() {
            }

            private Companion() {
            }

            public final Closed getCLOSED() {
                return CLOSED;
            }

            static {
                Result.Companion companion = Result.INSTANCE;
                RESUME = Result.m7415constructorimpl(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: getRESUME-d1pmJ48, reason: not valid java name */
            public final Object m7380getRESUMEd1pmJ48() {
                return RESUME;
            }
        }

        /* JADX INFO: compiled from: ByteChannel.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Empty;", "Lio/ktor/utils/io/ByteChannel$Slot;", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "ktor-io"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Empty implements Slot {
            public static final Empty INSTANCE = new Empty();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Empty)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -231472095;
            }

            public String toString() {
                return "Empty";
            }

            private Empty() {
            }
        }

        /* JADX INFO: compiled from: ByteChannel.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "Lio/ktor/utils/io/ByteChannel$Slot;", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "component1", "()Ljava/lang/Throwable;", "copy", "(Ljava/lang/Throwable;)Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getCause", "ktor-io"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Closed implements Slot {
            private final Throwable cause;

            public static /* synthetic */ Closed copy$default(Closed closed, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = closed.cause;
                }
                return closed.copy(th);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Throwable getCause() {
                return this.cause;
            }

            public final Closed copy(Throwable cause) {
                return new Closed(cause);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Closed) && Intrinsics.areEqual(this.cause, ((Closed) other).cause);
            }

            public int hashCode() {
                Throwable th = this.cause;
                if (th == null) {
                    return 0;
                }
                return th.hashCode();
            }

            public String toString() {
                return "Closed(cause=" + this.cause + ')';
            }

            public Closed(Throwable th) {
                this.cause = th;
            }

            public final Throwable getCause() {
                return this.cause;
            }
        }

        /* JADX INFO: compiled from: ByteChannel.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0006\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u0012\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Task;", "Lio/ktor/utils/io/ByteChannel$Slot;", "", "taskName", "()Ljava/lang/String;", "", "resume", "()V", "", "throwable", "(Ljava/lang/Throwable;)V", "getCreated", "()Ljava/lang/Throwable;", "created", "Lkotlin/coroutines/Continuation;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "continuation", "Lio/ktor/utils/io/ByteChannel$Slot$Read;", "Lio/ktor/utils/io/ByteChannel$Slot$Write;", "ktor-io"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public interface Task extends Slot {
            Continuation<Unit> getContinuation();

            Throwable getCreated();

            void resume();

            void resume(Throwable throwable);

            String taskName();

            /* JADX INFO: compiled from: ByteChannel.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public static final class DefaultImpls {
                public static void resume(Task task) {
                    task.getContinuation().resumeWith(Slot.INSTANCE.m7380getRESUMEd1pmJ48());
                }

                public static /* synthetic */ void resume$default(Task task, Throwable th, int i, Object obj) {
                    if (obj != null) {
                        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resume");
                    }
                    if ((i & 1) != 0) {
                        th = null;
                    }
                    task.resume(th);
                }

                public static void resume(Task task, Throwable th) {
                    Object objM7380getRESUMEd1pmJ48;
                    Continuation<Unit> continuation = task.getContinuation();
                    if (th != null) {
                        Result.Companion companion = Result.INSTANCE;
                        objM7380getRESUMEd1pmJ48 = Result.m7415constructorimpl(ResultKt.createFailure(th));
                    } else {
                        objM7380getRESUMEd1pmJ48 = Slot.INSTANCE.m7380getRESUMEd1pmJ48();
                    }
                    continuation.resumeWith(objM7380getRESUMEd1pmJ48);
                }
            }
        }

        /* JADX INFO: compiled from: ByteChannel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Read;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "Lkotlin/coroutines/Continuation;", "", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "", "taskName", "()Ljava/lang/String;", "Lkotlin/coroutines/Continuation;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "", "created", "Ljava/lang/Throwable;", "getCreated", "()Ljava/lang/Throwable;", "setCreated", "(Ljava/lang/Throwable;)V", "ktor-io"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Read implements Task {
            private final Continuation<Unit> continuation;
            private Throwable created;

            /* JADX WARN: Multi-variable type inference failed */
            public Read(Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "continuation");
                this.continuation = continuation;
                if (ByteChannel_jvmKt.getDEVELOPMENT_MODE()) {
                    StringBuilder sb = new StringBuilder("ReadTask 0x");
                    String string = Integer.toString(getContinuation().hashCode(), CharsKt.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    sb.append(string);
                    Throwable th = new Throwable(sb.toString());
                    kotlin.ExceptionsKt.stackTraceToString(th);
                    setCreated(th);
                }
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Continuation<Unit> getContinuation() {
                return this.continuation;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public void resume() {
                Task.DefaultImpls.resume(this);
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public void resume(Throwable th) {
                Task.DefaultImpls.resume(this, th);
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Throwable getCreated() {
                return this.created;
            }

            public void setCreated(Throwable th) {
                this.created = th;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public String taskName() {
                return "read";
            }
        }

        /* JADX INFO: compiled from: ByteChannel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Write;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "Lkotlin/coroutines/Continuation;", "", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "", "taskName", "()Ljava/lang/String;", "Lkotlin/coroutines/Continuation;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "", "created", "Ljava/lang/Throwable;", "getCreated", "()Ljava/lang/Throwable;", "setCreated", "(Ljava/lang/Throwable;)V", "ktor-io"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Write implements Task {
            private final Continuation<Unit> continuation;
            private Throwable created;

            /* JADX WARN: Multi-variable type inference failed */
            public Write(Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "continuation");
                this.continuation = continuation;
                if (ByteChannel_jvmKt.getDEVELOPMENT_MODE()) {
                    StringBuilder sb = new StringBuilder("WriteTask 0x");
                    String string = Integer.toString(getContinuation().hashCode(), CharsKt.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    sb.append(string);
                    Throwable th = new Throwable(sb.toString());
                    kotlin.ExceptionsKt.stackTraceToString(th);
                    setCreated(th);
                }
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Continuation<Unit> getContinuation() {
                return this.continuation;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public void resume() {
                Task.DefaultImpls.resume(this);
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public void resume(Throwable th) {
                Task.DefaultImpls.resume(this, th);
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Throwable getCreated() {
                return this.created;
            }

            public void setCreated(Throwable th) {
                this.created = th;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public String taskName() {
                return "write";
            }
        }
    }
}
