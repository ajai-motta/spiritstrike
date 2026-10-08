package io.ktor.network.selector;

import androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0;
import java.io.Closeable;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.channels.ClosedSendChannelException;

/* JADX INFO: compiled from: ActorSelectorManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\rH\u0082H¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0017\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001c\u0010\u001bJ\u001c\u0010\u001d\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\t0\bH\u0082@¢\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u001f\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\t0\bH\u0082@¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b \u0010\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R&\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0*0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010(R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lio/ktor/network/selector/ActorSelectorManager;", "Lio/ktor/network/selector/SelectorManagerSupport;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "Lio/ktor/network/selector/LockFreeMPSCQueue;", "Lio/ktor/network/selector/Selectable;", "mb", "Ljava/nio/channels/Selector;", "selector", "", "process", "(Lio/ktor/network/selector/LockFreeMPSCQueue;Ljava/nio/channels/Selector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "select", "(Ljava/nio/channels/Selector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectWakeup", "()V", "processInterests", "(Lio/ktor/network/selector/LockFreeMPSCQueue;Ljava/nio/channels/Selector;)V", "selectable", "notifyClosed", "(Lio/ktor/network/selector/Selectable;)V", "publishInterest", "receiveOrNull", "(Lio/ktor/network/selector/LockFreeMPSCQueue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOrNullSuspend", "close", "selectorRef", "Ljava/nio/channels/Selector;", "Ljava/util/concurrent/atomic/AtomicLong;", "wakeup", "Ljava/util/concurrent/atomic/AtomicLong;", "", "inSelect", "Z", "Lio/ktor/network/selector/ActorSelectorManager$ContinuationHolder;", "Lkotlin/coroutines/Continuation;", "continuation", "Lio/ktor/network/selector/ActorSelectorManager$ContinuationHolder;", "closed", "selectionQueue", "Lio/ktor/network/selector/LockFreeMPSCQueue;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "ContinuationHolder", "ktor-network"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActorSelectorManager extends SelectorManagerSupport implements Closeable, CoroutineScope {
    private volatile boolean closed;
    private final ContinuationHolder<Unit, Continuation<Unit>> continuation;
    private final CoroutineContext coroutineContext;
    private volatile boolean inSelect;
    private final LockFreeMPSCQueue<Selectable> selectionQueue;
    private volatile Selector selectorRef;
    private final AtomicLong wakeup;

    /* JADX INFO: renamed from: io.ktor.network.selector.ActorSelectorManager$process$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActorSelectorManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.selector.ActorSelectorManager", f = "ActorSelectorManager.kt", i = {0, 0, 1, 1, 2, 2}, l = {70, 74, 90}, m = "process", n = {"mb", "selector", "mb", "selector", "mb", "selector"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    static final class C33111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33111(Continuation<? super C33111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActorSelectorManager.this.process(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.network.selector.ActorSelectorManager$receiveOrNullSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActorSelectorManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.selector.ActorSelectorManager", f = "ActorSelectorManager.kt", i = {0}, l = {168}, m = "receiveOrNullSuspend", n = {"$this$receiveOrNullSuspend"}, s = {"L$0"})
    static final class C33121 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33121(Continuation<? super C33121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActorSelectorManager.this.receiveOrNullSuspend(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.network.selector.ActorSelectorManager$select$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActorSelectorManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.selector.ActorSelectorManager", f = "ActorSelectorManager.kt", i = {0}, l = {210}, m = "select", n = {"selector"}, s = {"L$0"})
    static final class C33131 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33131(Continuation<? super C33131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActorSelectorManager.this.select(null, this);
        }
    }

    public ActorSelectorManager(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.wakeup = new AtomicLong();
        this.continuation = new ContinuationHolder<>();
        this.selectionQueue = new LockFreeMPSCQueue<>();
        this.coroutineContext = context.plus(new CoroutineName("selector"));
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX INFO: renamed from: io.ktor.network.selector.ActorSelectorManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActorSelectorManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.selector.ActorSelectorManager$1", f = "ActorSelectorManager.kt", i = {0}, l = {44}, m = "invokeSuspend", n = {"currentSelector"}, s = {"L$2"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ActorSelectorManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractSelector abstractSelector;
            ActorSelectorManager actorSelectorManager;
            AbstractSelector abstractSelector2;
            Throwable th;
            AbstractSelector abstractSelector3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AbstractSelector abstractSelectorOpenSelector = ActorSelectorManager.this.getProvider().openSelector();
                    if (abstractSelectorOpenSelector != null) {
                        ActorSelectorManager.this.selectorRef = abstractSelectorOpenSelector;
                        abstractSelector = abstractSelectorOpenSelector;
                        actorSelectorManager = ActorSelectorManager.this;
                        AbstractSelector abstractSelector4 = abstractSelector;
                        try {
                            this.L$0 = abstractSelector;
                            this.L$1 = actorSelectorManager;
                            this.L$2 = abstractSelector4;
                            this.label = 1;
                            if (actorSelectorManager.process(actorSelectorManager.selectionQueue, abstractSelector4, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            abstractSelector2 = abstractSelector4;
                            actorSelectorManager.closed = true;
                            actorSelectorManager.selectionQueue.close();
                            actorSelectorManager.selectorRef = null;
                            abstractSelector3 = abstractSelector2;
                        } catch (Throwable th2) {
                            abstractSelector2 = abstractSelector4;
                            th = th2;
                            actorSelectorManager.closed = true;
                            actorSelectorManager.selectionQueue.close();
                            actorSelectorManager.cancelAllSuspensions(abstractSelector2, th);
                            actorSelectorManager.closed = true;
                            actorSelectorManager.selectionQueue.close();
                            actorSelectorManager.selectorRef = null;
                            abstractSelector3 = abstractSelector2;
                        }
                    } else {
                        throw new IllegalStateException("openSelector() = null".toString());
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    abstractSelector2 = (AbstractSelector) this.L$2;
                    actorSelectorManager = (ActorSelectorManager) this.L$1;
                    abstractSelector = (Closeable) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        actorSelectorManager.closed = true;
                        actorSelectorManager.selectionQueue.close();
                        actorSelectorManager.selectorRef = null;
                        abstractSelector3 = abstractSelector2;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            actorSelectorManager.closed = true;
                            actorSelectorManager.selectionQueue.close();
                            actorSelectorManager.cancelAllSuspensions(abstractSelector2, th);
                            actorSelectorManager.closed = true;
                            actorSelectorManager.selectionQueue.close();
                            actorSelectorManager.selectorRef = null;
                            abstractSelector3 = abstractSelector2;
                        } catch (Throwable th4) {
                            actorSelectorManager.closed = true;
                            actorSelectorManager.selectionQueue.close();
                            actorSelectorManager.selectorRef = null;
                            actorSelectorManager.cancelAllSuspensions(abstractSelector2, (Throwable) null);
                            throw th4;
                        }
                    }
                }
                actorSelectorManager.cancelAllSuspensions(abstractSelector3, (Throwable) null);
                while (true) {
                    Selectable selectable = (Selectable) actorSelectorManager.selectionQueue.removeFirstOrNull();
                    if (selectable != null) {
                        actorSelectorManager.cancelAllSuspensions(selectable, new ClosedSendChannelException("Failed to apply interest: selector closed"));
                    } else {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(abstractSelector, null);
                        return Unit.INSTANCE;
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x008b -> B:19:0x0069). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a5 -> B:19:0x0069). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00b3 -> B:19:0x0069). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00e6 -> B:44:0x00e9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object process(io.ktor.network.selector.LockFreeMPSCQueue<io.ktor.network.selector.Selectable> r10, java.nio.channels.Selector r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.selector.ActorSelectorManager.process(io.ktor.network.selector.LockFreeMPSCQueue, java.nio.channels.Selector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object select(java.nio.channels.Selector r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.network.selector.ActorSelectorManager.C33131
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.network.selector.ActorSelectorManager$select$1 r0 = (io.ktor.network.selector.ActorSelectorManager.C33131) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.network.selector.ActorSelectorManager$select$1 r0 = new io.ktor.network.selector.ActorSelectorManager$select$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            java.nio.channels.Selector r5 = (java.nio.channels.Selector) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            r4.inSelect = r3
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.YieldKt.yield(r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            java.util.concurrent.atomic.AtomicLong r6 = r4.wakeup
            long r0 = r6.get()
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r0 = 0
            if (r6 != 0) goto L5c
            r1 = 500(0x1f4, double:2.47E-321)
            int r5 = r5.select(r1)
            r4.inSelect = r0
            goto L67
        L5c:
            r4.inSelect = r0
            java.util.concurrent.atomic.AtomicLong r6 = r4.wakeup
            r6.set(r2)
            int r5 = r5.selectNow()
        L67:
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.selector.ActorSelectorManager.select(java.nio.channels.Selector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object dispatchIfNeeded(Continuation<? super Unit> continuation) {
        InlineMarker.mark(0);
        YieldKt.yield(continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    private final void selectWakeup() {
        Selector selector;
        if (this.wakeup.incrementAndGet() == 1 && this.inSelect && (selector = this.selectorRef) != null) {
            selector.wakeup();
        }
    }

    private final void processInterests(LockFreeMPSCQueue<Selectable> mb, Selector selector) {
        while (true) {
            Selectable selectableRemoveFirstOrNull = mb.removeFirstOrNull();
            if (selectableRemoveFirstOrNull == null) {
                return;
            } else {
                applyInterest(selector, selectableRemoveFirstOrNull);
            }
        }
    }

    @Override // io.ktor.network.selector.SelectorManager
    public void notifyClosed(Selectable selectable) {
        SelectionKey selectionKeyKeyFor;
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        cancelAllSuspensions(selectable, new ClosedChannelException());
        Selector selector = this.selectorRef;
        if (selector == null || (selectionKeyKeyFor = selectable.getChannel().keyFor(selector)) == null) {
            return;
        }
        selectionKeyKeyFor.cancel();
        selectWakeup();
    }

    @Override // io.ktor.network.selector.SelectorManagerSupport
    protected void publishInterest(Selectable selectable) {
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        try {
            if (this.selectionQueue.addLast(selectable)) {
                this.continuation.resume(Unit.INSTANCE);
                selectWakeup();
            } else {
                if (selectable.getChannel().isOpen()) {
                    throw new ClosedSelectorException();
                }
                throw new ClosedChannelException();
            }
        } catch (Throwable th) {
            cancelAllSuspensions(selectable, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object receiveOrNull(LockFreeMPSCQueue<Selectable> lockFreeMPSCQueue, Continuation<? super Selectable> continuation) {
        Selectable selectableRemoveFirstOrNull = lockFreeMPSCQueue.removeFirstOrNull();
        return selectableRemoveFirstOrNull == null ? receiveOrNullSuspend(lockFreeMPSCQueue, continuation) : selectableRemoveFirstOrNull;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object receiveOrNullSuspend(io.ktor.network.selector.LockFreeMPSCQueue<io.ktor.network.selector.Selectable> r7, kotlin.coroutines.Continuation<? super io.ktor.network.selector.Selectable> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.network.selector.ActorSelectorManager.C33121
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.network.selector.ActorSelectorManager$receiveOrNullSuspend$1 r0 = (io.ktor.network.selector.ActorSelectorManager.C33121) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.network.selector.ActorSelectorManager$receiveOrNullSuspend$1 r0 = new io.ktor.network.selector.ActorSelectorManager$receiveOrNullSuspend$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            io.ktor.network.selector.LockFreeMPSCQueue r7 = (io.ktor.network.selector.LockFreeMPSCQueue) r7
            goto L33
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
        L36:
            java.lang.Object r8 = r7.removeFirstOrNull()
            io.ktor.network.selector.Selectable r8 = (io.ktor.network.selector.Selectable) r8
            if (r8 == 0) goto L3f
            return r8
        L3f:
            boolean r8 = r6.closed
            r2 = 0
            if (r8 == 0) goto L45
            return r2
        L45:
            r0.L$0 = r7
            r0.label = r3
            r8 = r0
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            io.ktor.network.selector.ActorSelectorManager$ContinuationHolder<kotlin.Unit, kotlin.coroutines.Continuation<kotlin.Unit>> r4 = r6.continuation
            boolean r5 = r7.isEmpty()
            if (r5 == 0) goto L85
            boolean r5 = r6.closed
            if (r5 != 0) goto L85
            java.util.concurrent.atomic.AtomicReference r5 = io.ktor.network.selector.ActorSelectorManager.ContinuationHolder.access$getRef$p(r4)
            boolean r5 = androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0.m(r5, r2, r8)
            if (r5 == 0) goto L7d
            boolean r5 = r7.isEmpty()
            if (r5 == 0) goto L6d
            boolean r5 = r6.closed
            if (r5 != 0) goto L6d
            goto L78
        L6d:
            java.util.concurrent.atomic.AtomicReference r4 = io.ktor.network.selector.ActorSelectorManager.ContinuationHolder.access$getRef$p(r4)
            boolean r4 = androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0.m(r4, r8, r2)
            if (r4 == 0) goto L78
            goto L85
        L78:
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            goto L85
        L7d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Continuation is already set"
            r7.<init>(r8)
            throw r7
        L85:
            if (r2 != 0) goto L89
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L89:
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r2 != r4) goto L92
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r8)
        L92:
            if (r2 != r1) goto L36
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.selector.ActorSelectorManager.receiveOrNullSuspend(io.ktor.network.selector.LockFreeMPSCQueue, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        this.selectionQueue.close();
        if (this.continuation.resume(Unit.INSTANCE)) {
            return;
        }
        selectWakeup();
    }

    /* JADX INFO: compiled from: ActorSelectorManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00028\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"Lio/ktor/network/selector/ActorSelectorManager$ContinuationHolder;", "R", "Lkotlin/coroutines/Continuation;", "C", "", "<init>", "()V", "value", "", "resume", "(Ljava/lang/Object;)Z", "continuation", "Lkotlin/Function0;", "condition", "suspendIf", "(Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicReference;", "ref", "Ljava/util/concurrent/atomic/AtomicReference;", "ktor-network"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class ContinuationHolder<R, C extends Continuation<? super R>> {
        private final AtomicReference<C> ref = new AtomicReference<>(null);

        public final boolean resume(R value) {
            C andSet = this.ref.getAndSet(null);
            if (andSet == null) {
                return false;
            }
            Result.Companion companion = Result.INSTANCE;
            andSet.resumeWith(Result.m7415constructorimpl(value));
            return true;
        }

        public final Object suspendIf(C continuation, Function0<Boolean> condition) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            Intrinsics.checkNotNullParameter(condition, "condition");
            if (!condition.invoke().booleanValue()) {
                return null;
            }
            if (!ComplexDouble$$ExternalSyntheticBackport0.m(this.ref, null, continuation)) {
                throw new IllegalStateException("Continuation is already set");
            }
            if (condition.invoke().booleanValue() || !ComplexDouble$$ExternalSyntheticBackport0.m(this.ref, continuation, null)) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            return null;
        }
    }
}
