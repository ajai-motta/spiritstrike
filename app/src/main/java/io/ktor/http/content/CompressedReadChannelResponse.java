package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.ContentEncoder;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CompressedContent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0010*\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0017\u001a\u00020\u0016\"\b\b\u0000\u0010\u0010*\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u0004\u0018\u00010/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00106\u001a\u0004\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lio/ktor/http/content/CompressedReadChannelResponse;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/http/content/OutgoingContent;", "original", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "delegateChannel", "Lio/ktor/util/ContentEncoder;", "encoder", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/jvm/functions/Function0;Lio/ktor/util/ContentEncoder;Lkotlin/coroutines/CoroutineContext;)V", "readFrom", "()Lio/ktor/utils/io/ByteReadChannel;", "", "T", "Lio/ktor/util/AttributeKey;", "key", "getProperty", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "value", "", "setProperty", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/http/content/OutgoingContent;", "getOriginal", "()Lio/ktor/http/content/OutgoingContent;", "Lkotlin/jvm/functions/Function0;", "getDelegateChannel", "()Lkotlin/jvm/functions/Function0;", "Lio/ktor/util/ContentEncoder;", "getEncoder", "()Lio/ktor/util/ContentEncoder;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lio/ktor/http/Headers;", "headers$delegate", "Lkotlin/Lazy;", "getHeaders", "()Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class CompressedReadChannelResponse extends OutgoingContent.ReadChannelContent {
    private final CoroutineContext coroutineContext;
    private final Function0<ByteReadChannel> delegateChannel;
    private final ContentEncoder encoder;

    /* JADX INFO: renamed from: headers$delegate, reason: from kotlin metadata */
    private final Lazy headers;
    private final OutgoingContent original;

    public final OutgoingContent getOriginal() {
        return this.original;
    }

    public final Function0<ByteReadChannel> getDelegateChannel() {
        return this.delegateChannel;
    }

    public final ContentEncoder getEncoder() {
        return this.encoder;
    }

    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompressedReadChannelResponse(OutgoingContent original, Function0<? extends ByteReadChannel> delegateChannel, ContentEncoder encoder, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(delegateChannel, "delegateChannel");
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.original = original;
        this.delegateChannel = delegateChannel;
        this.encoder = encoder;
        this.coroutineContext = coroutineContext;
        this.headers = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: io.ktor.http.content.CompressedReadChannelResponse$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CompressedReadChannelResponse.headers_delegate$lambda$2(this.f$0);
            }
        });
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel readFrom() {
        return this.encoder.encode(this.delegateChannel.invoke(), this.coroutineContext);
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
    public static final io.ktor.http.Headers headers_delegate$lambda$2(io.ktor.http.content.CompressedReadChannelResponse r10) {
        /*
            io.ktor.http.Headers$Companion r0 = io.ktor.http.Headers.INSTANCE
            io.ktor.http.HeadersBuilder r0 = new io.ktor.http.HeadersBuilder
            r1 = 1
            r2 = 0
            r3 = 0
            r0.<init>(r3, r1, r2)
            r4 = r0
            io.ktor.util.StringValuesBuilder r4 = (io.ktor.util.StringValuesBuilder) r4
            io.ktor.http.content.OutgoingContent r1 = r10.original
            io.ktor.http.Headers r1 = r1.getHeaders()
            r5 = r1
            io.ktor.util.StringValues r5 = (io.ktor.util.StringValues) r5
            io.ktor.http.content.CompressedReadChannelResponse$$ExternalSyntheticLambda1 r7 = new io.ktor.http.content.CompressedReadChannelResponse$$ExternalSyntheticLambda1
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
            io.ktor.http.content.OutgoingContent r10 = r10.original
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
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.content.CompressedReadChannelResponse.headers_delegate$lambda$2(io.ktor.http.content.CompressedReadChannelResponse):io.ktor.http.Headers");
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
}
