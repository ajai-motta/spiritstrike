package io.ktor.client.plugins.sse;

import com.google.common.net.HttpHeaders;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.sse.ServerSentEvent;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: DefaultClientSSESession.kt */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "It should be marked with `@InternalAPI`, please use `ClientSSESession` instead")
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\u0004H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\u0004H\u0082@¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u001b\u001a\u00020\u000b*\u00060\u0017j\u0002`\u00182\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u0019*\u00060\u0017j\u0002`\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010 \u001a\u00020\u001f*\u00020\u0013H\u0002¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020\u001f*\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010!J\u0013\u0010#\u001a\u00020\u001f*\u00020\u0013H\u0002¢\u0006\u0004\b#\u0010!R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010.R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010.R\u0014\u00104\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0013098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u0013098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lio/ktor/client/plugins/sse/DefaultClientSSESession;", "Lio/ktor/client/plugins/sse/SSESession;", "Lio/ktor/client/plugins/sse/SSEClientContent;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lio/ktor/client/plugins/sse/SSEClientContent;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;)V", "(Lio/ktor/client/plugins/sse/SSEClientContent;Lio/ktor/utils/io/ByteReadChannel;)V", "", "doReconnection", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestBuilder;", "getRequestForReconnection", "()Lio/ktor/client/request/HttpRequestBuilder;", "close", "()V", "Lio/ktor/sse/ServerSentEvent;", "tryParseEvent", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseEvent", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "comment", "appendComment", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "toText", "(Ljava/lang/StringBuilder;)Ljava/lang/String;", "", "isEmpty", "(Lio/ktor/sse/ServerSentEvent;)Z", "isCommentsEvent", "isRetryEvent", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "lastEventId", "Ljava/lang/String;", "", "reconnectionTimeMillis", "J", "showCommentEvents", "Z", "showRetryEvents", "", "maxReconnectionAttempts", "I", "needToReconnect", "initialRequest", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/HttpClient;", "clientForReconnection", "Lio/ktor/client/HttpClient;", "Lkotlinx/coroutines/flow/Flow;", "_incoming", "Lkotlinx/coroutines/flow/Flow;", "getIncoming", "()Lkotlinx/coroutines/flow/Flow;", "incoming", "ktor-client-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultClientSSESession implements SSESession {
    private Flow<ServerSentEvent> _incoming;
    private final HttpClient clientForReconnection;
    private final CoroutineContext coroutineContext;
    private final HttpRequestBuilder initialRequest;
    private ByteReadChannel input;
    private String lastEventId;
    private final int maxReconnectionAttempts;
    private boolean needToReconnect;
    private long reconnectionTimeMillis;
    private final boolean showCommentEvents;
    private final boolean showRetryEvents;

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.DefaultClientSSESession$parseEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultClientSSESession.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession", f = "DefaultClientSSESession.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {161, 163, 212}, m = "parseEvent", n = {"$this$parseEvent", "data", "comments", "curRetry", "lastEventId", "wasData", "wasComments", "$this$parseEvent", "data", "comments", "curRetry", "lastEventId", "wasData", "wasComments", "$this$parseEvent", "data", "comments", "eventType", "curRetry", "lastEventId", "wasData", "wasComments"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultClientSSESession.this.parseEvent(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.DefaultClientSSESession$tryParseEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultClientSSESession.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession", f = "DefaultClientSSESession.kt", i = {}, l = {145}, m = "tryParseEvent", n = {}, s = {})
    static final class C32561 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C32561(Continuation<? super C32561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultClientSSESession.this.tryParseEvent(null, this);
        }
    }

    public DefaultClientSSESession(SSEClientContent content, ByteReadChannel input, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.input = input;
        this.coroutineContext = coroutineContext;
        this.reconnectionTimeMillis = Duration.m8790getInWholeMillisecondsimpl(content.getReconnectionTime());
        this.showCommentEvents = content.getShowCommentEvents();
        this.showRetryEvents = content.getShowRetryEvents();
        int maxReconnectionAttempts = content.getMaxReconnectionAttempts();
        this.maxReconnectionAttempts = maxReconnectionAttempts;
        this.needToReconnect = maxReconnectionAttempts > 0;
        HttpRequestBuilder initialRequest = content.getInitialRequest();
        this.initialRequest = initialRequest;
        this.clientForReconnection = (HttpClient) initialRequest.getAttributes().get(SSEKt.getSSEClientForReconnectionAttr());
        this._incoming = FlowKt.onCompletion(FlowKt.m8973catch(FlowKt.flow(new DefaultClientSSESession$_incoming$1(this, null)), new DefaultClientSSESession$_incoming$2(this, null)), new DefaultClientSSESession$_incoming$3(this, null));
        JobKt.getJob(getCoroutineContext()).invokeOnCompletion(new Function1() { // from class: io.ktor.client.plugins.sse.DefaultClientSSESession$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DefaultClientSSESession._init_$lambda$0(this.f$0, (Throwable) obj);
            }
        });
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultClientSSESession(SSEClientContent content, ByteReadChannel input) {
        this(content, input, content.getCallContext().plus(JobKt__JobKt.Job$default((Job) null, 1, (Object) null)).plus(new CoroutineName("DefaultClientSSESession")));
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(input, "input");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(DefaultClientSSESession defaultClientSSESession, Throwable th) {
        defaultClientSSESession.close();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.DefaultClientSSESession$doReconnection$2, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultClientSSESession.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession$doReconnection$2", f = "DefaultClientSSESession.kt", i = {0, 1, 1}, l = {95, 102}, m = "invokeSuspend", n = {"retries", "retries", "reconnectionRequest"}, s = {"L$0", "L$0", "L$1"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DefaultClientSSESession.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0076 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:7:0x0016, B:28:0x00c1, B:30:0x00d1, B:31:0x00e9, B:33:0x00fc, B:34:0x0102, B:19:0x0044, B:22:0x0064, B:24:0x0076, B:25:0x00ab, B:12:0x0028), top: B:48:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00c0 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d1 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:7:0x0016, B:28:0x00c1, B:30:0x00d1, B:31:0x00e9, B:33:0x00fc, B:34:0x0102, B:19:0x0044, B:22:0x0064, B:24:0x0076, B:25:0x00ab, B:12:0x0028), top: B:48:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00fc A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:7:0x0016, B:28:0x00c1, B:30:0x00d1, B:31:0x00e9, B:33:0x00fc, B:34:0x0102, B:19:0x0044, B:22:0x0064, B:24:0x0076, B:25:0x00ab, B:12:0x0028), top: B:48:0x0008 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00be -> B:28:0x00c1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 364
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.DefaultClientSSESession.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doReconnection(Continuation<? super Unit> continuation) {
        Object objWithContext = kotlinx.coroutines.BuildersKt.withContext(getCoroutineContext(), new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HttpRequestBuilder getRequestForReconnection() {
        HttpRequestBuilder httpRequestBuilderTakeFrom = new HttpRequestBuilder().takeFrom(this.initialRequest);
        httpRequestBuilderTakeFrom.getAttributes().remove(BuildersKt.getSseRequestAttr());
        httpRequestBuilderTakeFrom.getAttributes().put(SSEKt.getSSEReconnectionRequestAttr(), true);
        String str = this.lastEventId;
        if (str != null) {
            httpRequestBuilderTakeFrom.getHeaders().append(HttpHeaders.LAST_EVENT_ID, str);
        }
        return httpRequestBuilderTakeFrom;
    }

    @Override // io.ktor.client.plugins.sse.SSESession
    public Flow<ServerSentEvent> getIncoming() {
        return this._incoming;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void close() {
        JobKt__JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        ByteReadChannelKt.cancel(this.input);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object tryParseEvent(io.ktor.utils.io.ByteReadChannel r5, kotlin.coroutines.Continuation<? super io.ktor.sse.ServerSentEvent> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.sse.DefaultClientSSESession.C32561
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.plugins.sse.DefaultClientSSESession$tryParseEvent$1 r0 = (io.ktor.client.plugins.sse.DefaultClientSSESession.C32561) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.plugins.sse.DefaultClientSSESession$tryParseEvent$1 r0 = new io.ktor.client.plugins.sse.DefaultClientSSESession$tryParseEvent$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: io.ktor.utils.io.ClosedByteChannelException -> L41
            goto L3e
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3     // Catch: io.ktor.utils.io.ClosedByteChannelException -> L41
            java.lang.Object r6 = r4.parseEvent(r5, r0)     // Catch: io.ktor.utils.io.ClosedByteChannelException -> L41
            if (r6 != r1) goto L3e
            return r1
        L3e:
            io.ktor.sse.ServerSentEvent r6 = (io.ktor.sse.ServerSentEvent) r6     // Catch: io.ktor.utils.io.ClosedByteChannelException -> L41
            goto L42
        L41:
            r6 = 0
        L42:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.DefaultClientSSESession.tryParseEvent(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0212 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x021d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021e  */
    /* JADX WARN: Type inference failed for: r2v15, types: [T, java.lang.Long] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f1 -> B:31:0x00f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x0213 -> B:87:0x0219). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parseEvent(io.ktor.utils.io.ByteReadChannel r25, kotlin.coroutines.Continuation<? super io.ktor.sse.ServerSentEvent> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 549
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.DefaultClientSSESession.parseEvent(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void appendComment(StringBuilder sb, String str) {
        sb.append(StringsKt.removePrefix(StringsKt.removePrefix(str, (CharSequence) ":"), (CharSequence) ServerSentEventKt.SPACE));
        sb.append(ServerSentEventKt.END_OF_LINE);
    }

    private final String toText(StringBuilder sb) {
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.removeSuffix(string, (CharSequence) ServerSentEventKt.END_OF_LINE);
    }

    private final boolean isEmpty(ServerSentEvent serverSentEvent) {
        return serverSentEvent.getData() == null && serverSentEvent.getId() == null && serverSentEvent.getEvent() == null && serverSentEvent.getRetry() == null && serverSentEvent.getComments() == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCommentsEvent(ServerSentEvent serverSentEvent) {
        return serverSentEvent.getData() == null && serverSentEvent.getEvent() == null && serverSentEvent.getId() == null && serverSentEvent.getRetry() == null && serverSentEvent.getComments() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRetryEvent(ServerSentEvent serverSentEvent) {
        return serverSentEvent.getData() == null && serverSentEvent.getEvent() == null && serverSentEvent.getId() == null && serverSentEvent.getComments() == null && serverSentEvent.getRetry() != null;
    }
}
