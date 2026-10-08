package io.ktor.network.util;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0011J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001aR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/ktor/network/util/Timeout;", "", "", "name", "", "timeoutMs", "Lkotlin/Function0;", "clock", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "onTimeout", "<init>", "(Ljava/lang/String;JLkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", TtmlNode.START, "()V", "stop", "finish", "Lkotlinx/coroutines/Job;", "initTimeoutJob", "()Lkotlinx/coroutines/Job;", "Ljava/lang/String;", "J", "Lkotlin/jvm/functions/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/jvm/functions/Function1;", "workerJob", "Lkotlinx/coroutines/Job;", "ktor-network"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Timeout {
    private final Function0<Long> clock;
    volatile /* synthetic */ int isStarted;
    volatile /* synthetic */ long lastActivityTime;
    private final String name;
    private final Function1<Continuation<? super Unit>, Object> onTimeout;
    private final CoroutineScope scope;
    private final long timeoutMs;
    private Job workerJob;

    /* JADX WARN: Multi-variable type inference failed */
    public Timeout(String name, long j, Function0<Long> clock, CoroutineScope scope, Function1<? super Continuation<? super Unit>, ? extends Object> onTimeout) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onTimeout, "onTimeout");
        this.name = name;
        this.timeoutMs = j;
        this.clock = clock;
        this.scope = scope;
        this.onTimeout = onTimeout;
        this.lastActivityTime = 0L;
        this.isStarted = 0;
        this.workerJob = initTimeoutJob();
    }

    public final void start() {
        this.lastActivityTime = this.clock.invoke().longValue();
        this.isStarted = 1;
    }

    public final void stop() {
        this.isStarted = 0;
    }

    public final void finish() {
        Job job = this.workerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX INFO: renamed from: io.ktor.network.util.Timeout$initTimeoutJob$1, reason: invalid class name */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.util.Timeout$initTimeoutJob$1", f = "Utils.kt", i = {}, l = {55, 57, 58}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Timeout.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0083 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L26
                if (r1 == r4) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L90
                goto L90
            L16:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1e:
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L90
                goto L75
            L22:
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L90
                goto L29
            L26:
                kotlin.ResultKt.throwOnFailure(r10)
            L29:
                io.ktor.network.util.Timeout r10 = io.ktor.network.util.Timeout.this     // Catch: java.lang.Throwable -> L90
                int r10 = r10.isStarted     // Catch: java.lang.Throwable -> L90
                if (r10 != 0) goto L41
                io.ktor.network.util.Timeout r10 = io.ktor.network.util.Timeout.this     // Catch: java.lang.Throwable -> L90
                kotlin.jvm.functions.Function0 r1 = io.ktor.network.util.Timeout.access$getClock$p(r10)     // Catch: java.lang.Throwable -> L90
                java.lang.Object r1 = r1.invoke()     // Catch: java.lang.Throwable -> L90
                java.lang.Number r1 = (java.lang.Number) r1     // Catch: java.lang.Throwable -> L90
                long r5 = r1.longValue()     // Catch: java.lang.Throwable -> L90
                r10.lastActivityTime = r5     // Catch: java.lang.Throwable -> L90
            L41:
                io.ktor.network.util.Timeout r10 = io.ktor.network.util.Timeout.this     // Catch: java.lang.Throwable -> L90
                long r5 = r10.lastActivityTime     // Catch: java.lang.Throwable -> L90
                io.ktor.network.util.Timeout r10 = io.ktor.network.util.Timeout.this     // Catch: java.lang.Throwable -> L90
                long r7 = io.ktor.network.util.Timeout.access$getTimeoutMs$p(r10)     // Catch: java.lang.Throwable -> L90
                long r5 = r5 + r7
                io.ktor.network.util.Timeout r10 = io.ktor.network.util.Timeout.this     // Catch: java.lang.Throwable -> L90
                kotlin.jvm.functions.Function0 r10 = io.ktor.network.util.Timeout.access$getClock$p(r10)     // Catch: java.lang.Throwable -> L90
                java.lang.Object r10 = r10.invoke()     // Catch: java.lang.Throwable -> L90
                java.lang.Number r10 = (java.lang.Number) r10     // Catch: java.lang.Throwable -> L90
                long r7 = r10.longValue()     // Catch: java.lang.Throwable -> L90
                long r5 = r5 - r7
                r7 = 0
                int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r10 > 0) goto L84
                io.ktor.network.util.Timeout r10 = io.ktor.network.util.Timeout.this     // Catch: java.lang.Throwable -> L90
                int r10 = r10.isStarted     // Catch: java.lang.Throwable -> L90
                if (r10 == 0) goto L84
                r10 = r9
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch: java.lang.Throwable -> L90
                r9.label = r3     // Catch: java.lang.Throwable -> L90
                java.lang.Object r10 = kotlinx.coroutines.YieldKt.yield(r10)     // Catch: java.lang.Throwable -> L90
                if (r10 != r0) goto L75
                return r0
            L75:
                io.ktor.network.util.Timeout r10 = io.ktor.network.util.Timeout.this     // Catch: java.lang.Throwable -> L90
                kotlin.jvm.functions.Function1 r10 = io.ktor.network.util.Timeout.access$getOnTimeout$p(r10)     // Catch: java.lang.Throwable -> L90
                r9.label = r2     // Catch: java.lang.Throwable -> L90
                java.lang.Object r10 = r10.invoke(r9)     // Catch: java.lang.Throwable -> L90
                if (r10 != r0) goto L90
                return r0
            L84:
                r10 = r9
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch: java.lang.Throwable -> L90
                r9.label = r4     // Catch: java.lang.Throwable -> L90
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r5, r10)     // Catch: java.lang.Throwable -> L90
                if (r10 != r0) goto L29
                return r0
            L90:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.util.Timeout.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Job initTimeoutJob() {
        if (this.timeoutMs == Long.MAX_VALUE) {
            return null;
        }
        CoroutineScope coroutineScope = this.scope;
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, coroutineScope.getCoroutineContext().plus(new CoroutineName("Timeout " + this.name)), null, new AnonymousClass1(null), 2, null);
    }
}
