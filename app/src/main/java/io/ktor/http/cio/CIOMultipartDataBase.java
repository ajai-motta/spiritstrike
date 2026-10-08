package io.ktor.http.cio;

import android.support.v4.media.session.PlaybackStateCompat;
import io.ktor.http.cio.MultipartEvent;
import io.ktor.http.content.MultiPartData;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: compiled from: CIOMultipartDataBase.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0004\b\u0011\u0010\u0010J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lio/ktor/http/cio/CIOMultipartDataBase;", "Lio/ktor/http/content/MultiPartData;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "", "contentType", "", "contentLength", "formFieldLimit", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/CharSequence;Ljava/lang/Long;J)V", "Lio/ktor/http/content/PartData;", "readPart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readPartSuspend", "Lio/ktor/http/cio/MultipartEvent;", "event", "eventToData", "(Lio/ktor/http/cio/MultipartEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/cio/MultipartEvent$MultipartPart;", "part", "partToData", "(Lio/ktor/http/cio/MultipartEvent$MultipartPart;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "previousPart", "Lio/ktor/http/content/PartData;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "events", "Lkotlinx/coroutines/channels/ReceiveChannel;", "ktor-http-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CIOMultipartDataBase implements MultiPartData, CoroutineScope {
    private final CoroutineContext coroutineContext;
    private final ReceiveChannel<MultipartEvent> events;
    private PartData previousPart;

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$eventToData$1, reason: invalid class name */
    /* JADX INFO: compiled from: CIOMultipartDataBase.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", i = {0}, l = {62}, m = "eventToData", n = {"event"}, s = {"L$0"})
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
            return CIOMultipartDataBase.this.eventToData(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$partToData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CIOMultipartDataBase.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", i = {0, 1, 1}, l = {75, 82}, m = "partToData", n = {"part", "part", "headers"}, s = {"L$0", "L$0", "L$1"})
    static final class C32991 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C32991(Continuation<? super C32991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.partToData(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$readPart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CIOMultipartDataBase.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", i = {}, l = {39, 45}, m = "readPart", n = {}, s = {})
    static final class C33001 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C33001(Continuation<? super C33001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.readPart(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CIOMultipartDataBase.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", i = {}, l = {51, 52}, m = "readPartSuspend", n = {}, s = {})
    static final class C33011 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C33011(Continuation<? super C33011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.readPartSuspend(this);
        }
    }

    public CIOMultipartDataBase(CoroutineContext coroutineContext, ByteReadChannel channel, CharSequence contentType, Long l, long j) {
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.coroutineContext = coroutineContext;
        this.events = MultipartKt.parseMultipart(this, channel, contentType, l, j);
    }

    public /* synthetic */ CIOMultipartDataBase(CoroutineContext coroutineContext, ByteReadChannel byteReadChannel, CharSequence charSequence, Long l, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineContext, byteReadChannel, charSequence, l, (i & 16) != 0 ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : j);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0067 -> B:30:0x006a). Please report as a decompilation issue!!! */
    @Override // io.ktor.http.content.MultiPartData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object readPart(kotlin.coroutines.Continuation<? super io.ktor.http.content.PartData> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.http.cio.CIOMultipartDataBase.C33001
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.http.cio.CIOMultipartDataBase$readPart$1 r0 = (io.ktor.http.cio.CIOMultipartDataBase.C33001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.http.cio.CIOMultipartDataBase$readPart$1 r0 = new io.ktor.http.cio.CIOMultipartDataBase$readPart$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L60
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L6a
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.http.content.PartData r6 = r5.previousPart
            if (r6 == 0) goto L49
            kotlin.jvm.functions.Function0 r6 = r6.getDispose()
            if (r6 == 0) goto L49
            r6.invoke()
        L49:
            kotlinx.coroutines.channels.ReceiveChannel<io.ktor.http.cio.MultipartEvent> r6 = r5.events
            java.lang.Object r6 = r6.mo8944tryReceivePtdJZtk()
            java.lang.Object r6 = kotlinx.coroutines.channels.ChannelResult.m8956getOrNullimpl(r6)
            io.ktor.http.cio.MultipartEvent r6 = (io.ktor.http.cio.MultipartEvent) r6
            if (r6 != 0) goto L61
            r0.label = r3
            java.lang.Object r6 = r5.readPartSuspend(r0)
            if (r6 != r1) goto L60
            return r1
        L60:
            return r6
        L61:
            r0.label = r4
            java.lang.Object r6 = r5.eventToData(r6, r0)
            if (r6 != r1) goto L6a
            return r1
        L6a:
            io.ktor.http.content.PartData r6 = (io.ktor.http.content.PartData) r6
            if (r6 == 0) goto L49
            r5.previousPart = r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.CIOMultipartDataBase.readPart(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x004f -> B:25:0x0052). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object readPartSuspend(kotlin.coroutines.Continuation<? super io.ktor.http.content.PartData> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.http.cio.CIOMultipartDataBase.C33011
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1 r0 = (io.ktor.http.cio.CIOMultipartDataBase.C33011) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1 r0 = new io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L57
            goto L52
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L57
            goto L47
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
        L3c:
            kotlinx.coroutines.channels.ReceiveChannel<io.ktor.http.cio.MultipartEvent> r6 = r5.events     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L57
            r0.label = r4     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L57
            java.lang.Object r6 = r6.receive(r0)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L57
            if (r6 != r1) goto L47
            return r1
        L47:
            io.ktor.http.cio.MultipartEvent r6 = (io.ktor.http.cio.MultipartEvent) r6     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L57
            r0.label = r3     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L57
            java.lang.Object r6 = r5.eventToData(r6, r0)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L57
            if (r6 != r1) goto L52
            return r1
        L52:
            io.ktor.http.content.PartData r6 = (io.ktor.http.content.PartData) r6     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L57
            if (r6 == 0) goto L3c
            return r6
        L57:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.CIOMultipartDataBase.readPartSuspend(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object eventToData(io.ktor.http.cio.MultipartEvent r5, kotlin.coroutines.Continuation<? super io.ktor.http.content.PartData> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.http.cio.CIOMultipartDataBase.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.http.cio.CIOMultipartDataBase$eventToData$1 r0 = (io.ktor.http.cio.CIOMultipartDataBase.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.http.cio.CIOMultipartDataBase$eventToData$1 r0 = new io.ktor.http.cio.CIOMultipartDataBase$eventToData$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            io.ktor.http.cio.MultipartEvent r5 = (io.ktor.http.cio.MultipartEvent) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L53
            goto L4b
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5 instanceof io.ktor.http.cio.MultipartEvent.MultipartPart     // Catch: java.lang.Throwable -> L53
            if (r6 == 0) goto L4e
            r6 = r5
            io.ktor.http.cio.MultipartEvent$MultipartPart r6 = (io.ktor.http.cio.MultipartEvent.MultipartPart) r6     // Catch: java.lang.Throwable -> L53
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L53
            r0.label = r3     // Catch: java.lang.Throwable -> L53
            java.lang.Object r6 = r4.partToData(r6, r0)     // Catch: java.lang.Throwable -> L53
            if (r6 != r1) goto L4b
            return r1
        L4b:
            io.ktor.http.content.PartData r6 = (io.ktor.http.content.PartData) r6     // Catch: java.lang.Throwable -> L53
            goto L52
        L4e:
            r5.release()     // Catch: java.lang.Throwable -> L53
            r6 = 0
        L52:
            return r6
        L53:
            r6 = move-exception
            r5.release()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.CIOMultipartDataBase.eventToData(io.ktor.http.cio.MultipartEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object partToData(final io.ktor.http.cio.MultipartEvent.MultipartPart r8, kotlin.coroutines.Continuation<? super io.ktor.http.content.PartData> r9) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.CIOMultipartDataBase.partToData(io.ktor.http.cio.MultipartEvent$MultipartPart, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit partToData$lambda$4$lambda$3(MultipartEvent.MultipartPart multipartPart) throws InterruptedException {
        multipartPart.release();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit partToData$lambda$6(MultipartEvent.MultipartPart multipartPart) throws InterruptedException {
        multipartPart.release();
        return Unit.INSTANCE;
    }
}
