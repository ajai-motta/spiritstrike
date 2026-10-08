package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.ContentEncoder;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CompressedContent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0011\u001a\u00020\u0010\"\b\b\u0000\u0010\n*\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010-\u001a\u0004\u0018\u00010*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u0004\u0018\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lio/ktor/http/content/CompressedWriteChannelResponse;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "original", "Lio/ktor/util/ContentEncoder;", "encoder", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lio/ktor/http/content/OutgoingContent$WriteChannelContent;Lio/ktor/util/ContentEncoder;Lkotlin/coroutines/CoroutineContext;)V", "", "T", "Lio/ktor/util/AttributeKey;", "key", "getProperty", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "value", "", "setProperty", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "writeTo", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "getOriginal", "()Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lio/ktor/util/ContentEncoder;", "getEncoder", "()Lio/ktor/util/ContentEncoder;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lio/ktor/http/Headers;", "headers$delegate", "Lkotlin/Lazy;", "getHeaders", "()Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class CompressedWriteChannelResponse extends OutgoingContent.WriteChannelContent {
    private final CoroutineContext coroutineContext;
    private final ContentEncoder encoder;

    /* JADX INFO: renamed from: headers$delegate, reason: from kotlin metadata */
    private final Lazy headers;
    private final OutgoingContent.WriteChannelContent original;

    public final OutgoingContent.WriteChannelContent getOriginal() {
        return this.original;
    }

    public final ContentEncoder getEncoder() {
        return this.encoder;
    }

    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public CompressedWriteChannelResponse(OutgoingContent.WriteChannelContent original, ContentEncoder encoder, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.original = original;
        this.encoder = encoder;
        this.coroutineContext = coroutineContext;
        this.headers = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: io.ktor.http.content.CompressedWriteChannelResponse$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CompressedWriteChannelResponse.headers_delegate$lambda$2(this.f$0);
            }
        });
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Headers getHeaders() {
        return (Headers) this.headers.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final io.ktor.http.Headers headers_delegate$lambda$2(io.ktor.http.content.CompressedWriteChannelResponse r10) {
        /*
            io.ktor.http.Headers$Companion r0 = io.ktor.http.Headers.INSTANCE
            io.ktor.http.HeadersBuilder r0 = new io.ktor.http.HeadersBuilder
            r1 = 1
            r2 = 0
            r3 = 0
            r0.<init>(r3, r1, r2)
            r4 = r0
            io.ktor.util.StringValuesBuilder r4 = (io.ktor.util.StringValuesBuilder) r4
            io.ktor.http.content.OutgoingContent$WriteChannelContent r1 = r10.original
            io.ktor.http.Headers r1 = r1.getHeaders()
            r5 = r1
            io.ktor.util.StringValues r5 = (io.ktor.util.StringValues) r5
            io.ktor.http.content.CompressedWriteChannelResponse$$ExternalSyntheticLambda0 r7 = new io.ktor.http.content.CompressedWriteChannelResponse$$ExternalSyntheticLambda0
            r7.<init>()
            r8 = 2
            r9 = 0
            r6 = 0
            io.ktor.util.StringValuesKt.appendFiltered$default(r4, r5, r6, r7, r8, r9)
            io.ktor.http.HttpHeaders r1 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r1 = r1.getContentEncoding()
            io.ktor.util.ContentEncoder r2 = r10.encoder
            java.lang.String r2 = r2.getName()
            r0.append(r1, r2)
            io.ktor.http.HttpHeaders r1 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r1 = r1.getVary()
            io.ktor.http.content.OutgoingContent$WriteChannelContent r10 = r10.original
            io.ktor.http.Headers r10 = r10.getHeaders()
            io.ktor.http.HttpHeaders r2 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r2 = r2.getVary()
            java.lang.String r10 = r10.get(r2)
            if (r10 == 0) goto L65
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            java.lang.String r10 = ", "
            r2.append(r10)
            io.ktor.http.HttpHeaders r10 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r10 = r10.getAcceptEncoding()
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            if (r10 == 0) goto L65
            goto L6b
        L65:
            io.ktor.http.HttpHeaders r10 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r10 = r10.getAcceptEncoding()
        L6b:
            r0.append(r1, r10)
            io.ktor.http.Headers r10 = r0.build()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.content.CompressedWriteChannelResponse.headers_delegate$lambda$2(io.ktor.http.content.CompressedWriteChannelResponse):io.ktor.http.Headers");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean headers_delegate$lambda$2$lambda$1$lambda$0(String name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return !StringsKt.equals(name, HttpHeaders.INSTANCE.getContentLength(), true);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.original.getContentType();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public HttpStatusCode getStatus() {
        return this.original.getStatus();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        Long contentLength = this.original.getContentLength();
        if (contentLength == null) {
            return null;
        }
        Long lPredictCompressedLength = this.encoder.predictCompressedLength(contentLength.longValue());
        if (lPredictCompressedLength == null || lPredictCompressedLength.longValue() < 0) {
            return null;
        }
        return lPredictCompressedLength;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public <T> T getProperty(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.original.getProperty(key);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public <T> void setProperty(AttributeKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.original.setProperty(key, value);
    }

    /* JADX INFO: renamed from: io.ktor.http.content.CompressedWriteChannelResponse$writeTo$2, reason: invalid class name */
    /* JADX INFO: compiled from: CompressedContent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.content.CompressedWriteChannelResponse$writeTo$2", f = "CompressedContent.kt", i = {0}, l = {94}, m = "invokeSuspend", n = {"$this$use$iv"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteWriteChannel $channel;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ByteWriteChannel byteWriteChannel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$channel = byteWriteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = CompressedWriteChannelResponse.this.new AnonymousClass2(this.$channel, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ByteWriteChannel byteWriteChannel;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byteWriteChannel = (ByteWriteChannel) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    ByteWriteChannelKt.close(byteWriteChannel);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ByteWriteChannelOperationsKt.close(byteWriteChannel, th);
                        throw th;
                    } catch (Throwable th3) {
                        ByteWriteChannelKt.close(byteWriteChannel);
                        throw th3;
                    }
                }
            }
            ResultKt.throwOnFailure(obj);
            ByteWriteChannel byteWriteChannelEncode = CompressedWriteChannelResponse.this.getEncoder().encode(this.$channel, ((CoroutineScope) this.L$0).getCoroutineContext());
            try {
                OutgoingContent.WriteChannelContent original = CompressedWriteChannelResponse.this.getOriginal();
                this.L$0 = byteWriteChannelEncode;
                this.label = 1;
                if (original.writeTo(byteWriteChannelEncode, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteWriteChannel = byteWriteChannelEncode;
                ByteWriteChannelKt.close(byteWriteChannel);
                return Unit.INSTANCE;
            } catch (Throwable th4) {
                byteWriteChannel = byteWriteChannelEncode;
                th = th4;
                ByteWriteChannelOperationsKt.close(byteWriteChannel, th);
                throw th;
            }
        }
    }

    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    public Object writeTo(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.coroutineContext, new AnonymousClass2(byteWriteChannel, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
