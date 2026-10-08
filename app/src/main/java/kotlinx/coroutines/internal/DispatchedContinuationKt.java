package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0000¢\u0006\u0002\u0010\u000b\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a+\u0010\u000e\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a\u0012\u0010\u0014\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0000\u001a;\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED", "safeDispatch", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Lkotlin/coroutines/CoroutineContext;", "runnable", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "safeIsDispatchNeeded", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "yieldUndispatched", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "executeUnconfined", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DispatchedContinuationKt {
    private static final Symbol UNDEFINED = new Symbol("UNDEFINED");
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");

    public static final void safeDispatch(CoroutineDispatcher coroutineDispatcher, CoroutineContext coroutineContext, Runnable runnable) {
        try {
            coroutineDispatcher.mo9003dispatch(coroutineContext, runnable);
        } catch (Throwable th) {
            throw new DispatchException(th, coroutineDispatcher, coroutineContext);
        }
    }

    public static final boolean safeIsDispatchNeeded(CoroutineDispatcher coroutineDispatcher, CoroutineContext coroutineContext) throws DispatchException {
        try {
            return coroutineDispatcher.isDispatchNeeded(coroutineContext);
        } catch (Throwable th) {
            throw new DispatchException(th, coroutineDispatcher, coroutineContext);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f A[Catch: all -> 0x00b6, DONT_GENERATE, TryCatch #0 {all -> 0x00b6, blocks: (B:11:0x0048, B:13:0x0058, B:15:0x005e, B:26:0x00a2, B:16:0x007a, B:18:0x008a, B:23:0x0099, B:25:0x009f, B:31:0x00ac, B:34:0x00b5, B:33:0x00b2, B:21:0x0090), top: B:43:0x0048, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> void resumeCancellableWith(kotlin.coroutines.Continuation<? super T> r7, java.lang.Object r8) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r0 == 0) goto Lc3
            kotlinx.coroutines.internal.DispatchedContinuation r7 = (kotlinx.coroutines.internal.DispatchedContinuation) r7
            java.lang.Object r0 = kotlinx.coroutines.CompletionStateKt.toState(r8)
            kotlinx.coroutines.CoroutineDispatcher r1 = r7.dispatcher
            kotlin.coroutines.CoroutineContext r2 = r7.get$context()
            boolean r1 = safeIsDispatchNeeded(r1, r2)
            r2 = 1
            if (r1 == 0) goto L28
            r7._state = r0
            r7.resumeMode = r2
            kotlinx.coroutines.CoroutineDispatcher r8 = r7.dispatcher
            kotlin.coroutines.CoroutineContext r0 = r7.get$context()
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            safeDispatch(r8, r0, r7)
            goto Lc6
        L28:
            kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            kotlinx.coroutines.ThreadLocalEventLoop r1 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r1 = r1.getEventLoop$kotlinx_coroutines_core()
            boolean r3 = r1.isUnconfinedLoopActive()
            if (r3 == 0) goto L42
            r7._state = r0
            r7.resumeMode = r2
            kotlinx.coroutines.DispatchedTask r7 = (kotlinx.coroutines.DispatchedTask) r7
            r1.dispatchUnconfined(r7)
            goto Lc6
        L42:
            r3 = r7
            kotlinx.coroutines.DispatchedTask r3 = (kotlinx.coroutines.DispatchedTask) r3
            r1.incrementUseCount(r2)
            kotlin.coroutines.CoroutineContext r4 = r7.get$context()     // Catch: java.lang.Throwable -> Lb6
            kotlinx.coroutines.Job$Key r5 = kotlinx.coroutines.Job.INSTANCE     // Catch: java.lang.Throwable -> Lb6
            kotlin.coroutines.CoroutineContext$Key r5 = (kotlin.coroutines.CoroutineContext.Key) r5     // Catch: java.lang.Throwable -> Lb6
            kotlin.coroutines.CoroutineContext$Element r4 = r4.get(r5)     // Catch: java.lang.Throwable -> Lb6
            kotlinx.coroutines.Job r4 = (kotlinx.coroutines.Job) r4     // Catch: java.lang.Throwable -> Lb6
            if (r4 == 0) goto L7a
            boolean r5 = r4.isActive()     // Catch: java.lang.Throwable -> Lb6
            if (r5 != 0) goto L7a
            java.util.concurrent.CancellationException r8 = r4.getCancellationException()     // Catch: java.lang.Throwable -> Lb6
            r4 = r8
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch: java.lang.Throwable -> Lb6
            r7.cancelCompletedResult$kotlinx_coroutines_core(r0, r4)     // Catch: java.lang.Throwable -> Lb6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.lang.Throwable -> Lb6
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Lb6
            java.lang.Throwable r8 = (java.lang.Throwable) r8     // Catch: java.lang.Throwable -> Lb6
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)     // Catch: java.lang.Throwable -> Lb6
            java.lang.Object r8 = kotlin.Result.m7415constructorimpl(r8)     // Catch: java.lang.Throwable -> Lb6
            r7.resumeWith(r8)     // Catch: java.lang.Throwable -> Lb6
            goto La2
        L7a:
            kotlin.coroutines.Continuation<T> r0 = r7.continuation     // Catch: java.lang.Throwable -> Lb6
            java.lang.Object r4 = r7.countOrElement     // Catch: java.lang.Throwable -> Lb6
            kotlin.coroutines.CoroutineContext r5 = r0.get$context()     // Catch: java.lang.Throwable -> Lb6
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(r5, r4)     // Catch: java.lang.Throwable -> Lb6
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS     // Catch: java.lang.Throwable -> Lb6
            if (r4 == r6) goto L8f
            kotlinx.coroutines.UndispatchedCoroutine r0 = kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(r0, r5, r4)     // Catch: java.lang.Throwable -> Lb6
            goto L90
        L8f:
            r0 = 0
        L90:
            kotlin.coroutines.Continuation<T> r7 = r7.continuation     // Catch: java.lang.Throwable -> La9
            r7.resumeWith(r8)     // Catch: java.lang.Throwable -> La9
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La9
            if (r0 == 0) goto L9f
            boolean r7 = r0.clearThreadContext()     // Catch: java.lang.Throwable -> Lb6
            if (r7 == 0) goto La2
        L9f:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r5, r4)     // Catch: java.lang.Throwable -> Lb6
        La2:
            boolean r7 = r1.processUnconfinedEvent()     // Catch: java.lang.Throwable -> Lb6
            if (r7 != 0) goto La2
            goto Lba
        La9:
            r7 = move-exception
            if (r0 == 0) goto Lb2
            boolean r8 = r0.clearThreadContext()     // Catch: java.lang.Throwable -> Lb6
            if (r8 == 0) goto Lb5
        Lb2:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r5, r4)     // Catch: java.lang.Throwable -> Lb6
        Lb5:
            throw r7     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            r7 = move-exception
            r3.handleFatalException$kotlinx_coroutines_core(r7)     // Catch: java.lang.Throwable -> Lbe
        Lba:
            r1.decrementUseCount(r2)
            goto Lc6
        Lbe:
            r7 = move-exception
            r1.decrementUseCount(r2)
            throw r7
        Lc3:
            r7.resumeWith(r8)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.DispatchedContinuationKt.resumeCancellableWith(kotlin.coroutines.Continuation, java.lang.Object):void");
    }

    public static final boolean yieldUndispatched(DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Unit unit = Unit.INSTANCE;
        DebugKt.getASSERTIONS_ENABLED();
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = unit;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        DispatchedContinuation<? super Unit> dispatchedContinuation2 = dispatchedContinuation;
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } finally {
            try {
            } finally {
            }
        }
        return false;
    }

    private static final boolean executeUnconfined(DispatchedContinuation<?> dispatchedContinuation, Object obj, int i, boolean z, Function0<Unit> function0) {
        if (DebugKt.getASSERTIONS_ENABLED() && i == -1) {
            throw new AssertionError();
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (z && eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = obj;
            dispatchedContinuation.resumeMode = i;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        DispatchedContinuation<?> dispatchedContinuation2 = dispatchedContinuation;
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
        } catch (Throwable th) {
            try {
                dispatchedContinuation2.handleFatalException$kotlinx_coroutines_core(th);
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        return false;
    }

    static /* synthetic */ boolean executeUnconfined$default(DispatchedContinuation dispatchedContinuation, Object obj, int i, boolean z, Function0 function0, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if (DebugKt.getASSERTIONS_ENABLED() && i == -1) {
            throw new AssertionError();
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (z && eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = obj;
            dispatchedContinuation.resumeMode = i;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        DispatchedContinuation dispatchedContinuation2 = dispatchedContinuation;
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
        } catch (Throwable th) {
            try {
                dispatchedContinuation2.handleFatalException$kotlinx_coroutines_core(th);
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        return false;
    }
}
