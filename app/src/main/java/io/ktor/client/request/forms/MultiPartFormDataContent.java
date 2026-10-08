package io.ktor.client.request.forms;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import io.ktor.client.request.forms.PreparedPart;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* JADX INFO: compiled from: FormDataContent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R(\u0010#\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lio/ktor/client/request/forms/MultiPartFormDataContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "", "Lio/ktor/http/content/PartData;", "parts", "", "boundary", "Lio/ktor/http/ContentType;", "contentType", "<init>", "(Ljava/util/List;Ljava/lang/String;Lio/ktor/http/ContentType;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "writeTo", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/String;", "getBoundary", "()Ljava/lang/String;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "", "BOUNDARY_BYTES", "[B", "LAST_BOUNDARY_BYTES", "", "BODY_OVERHEAD_SIZE", "I", "PART_OVERHEAD_SIZE", "Lio/ktor/client/request/forms/PreparedPart;", "rawParts", "Ljava/util/List;", "", "value", "contentLength", "Ljava/lang/Long;", "getContentLength", "()Ljava/lang/Long;", "ktor-client-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiPartFormDataContent extends OutgoingContent.WriteChannelContent {
    private final int BODY_OVERHEAD_SIZE;
    private final byte[] BOUNDARY_BYTES;
    private final byte[] LAST_BOUNDARY_BYTES;
    private final int PART_OVERHEAD_SIZE;
    private final String boundary;
    private Long contentLength;
    private final ContentType contentType;
    private final List<PreparedPart> rawParts;

    /* JADX INFO: renamed from: io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormDataContent.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.request.forms.MultiPartFormDataContent", f = "FormDataContent.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5, 6}, l = {124, 125, 126, 131, TsExtractor.TS_STREAM_TYPE_E_AC3, 139, 142, 146, 146, 146}, m = "writeTo", n = {"channel", "part", "channel", "part", "channel", "part", "channel", "channel", "channel", "channel"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2", "L$0", "L$0", "L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiPartFormDataContent.this.writeTo(null, this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MultiPartFormDataContent(List list, String str, ContentType contentType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        str = (i & 2) != 0 ? FormDataContentKt.generateBoundary() : str;
        this(list, str, (i & 4) != 0 ? ContentType.MultiPart.INSTANCE.getFormData().withParameter("boundary", str) : contentType);
    }

    public final String getBoundary() {
        return this.boundary;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    public MultiPartFormDataContent(List<? extends PartData> parts, String boundary, ContentType contentType) {
        PreparedPart channelPart;
        Intrinsics.checkNotNullParameter(parts, "parts");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.boundary = boundary;
        this.contentType = contentType;
        Long l = null;
        byte[] byteArray$default = StringsKt.toByteArray$default("--" + boundary + ServerSentEventKt.END_OF_LINE, null, 1, null);
        this.BOUNDARY_BYTES = byteArray$default;
        byte[] byteArray$default2 = StringsKt.toByteArray$default("--" + boundary + "--\r\n", null, 1, null);
        this.LAST_BOUNDARY_BYTES = byteArray$default2;
        this.BODY_OVERHEAD_SIZE = byteArray$default2.length;
        this.PART_OVERHEAD_SIZE = (FormDataContentKt.RN_BYTES.length * 2) + byteArray$default.length;
        List<? extends PartData> list = parts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (PartData partData : list) {
            Sink sinkBytePacketBuilder = BytePacketBuilderKt.BytePacketBuilder();
            for (Map.Entry<String, List<String>> entry : partData.getHeaders().entries()) {
                StringsKt.writeText$default(sinkBytePacketBuilder, entry.getKey() + ": " + CollectionsKt.joinToString$default(entry.getValue(), "; ", null, null, 0, null, null, 62, null), 0, 0, (Charset) null, 14, (Object) null);
                BytePacketBuilderKt.writeFully$default(sinkBytePacketBuilder, FormDataContentKt.RN_BYTES, 0, 0, 6, null);
            }
            String str = partData.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
            Long lValueOf = str != null ? Long.valueOf(Long.parseLong(str)) : null;
            if (partData instanceof PartData.FileItem) {
                byte[] byteArray = SourcesKt.readByteArray(BytePacketBuilderKt.build(sinkBytePacketBuilder));
                channelPart = new PreparedPart.ChannelPart(byteArray, ((PartData.FileItem) partData).getProvider(), lValueOf != null ? Long.valueOf(lValueOf.longValue() + ((long) this.PART_OVERHEAD_SIZE) + ((long) byteArray.length)) : null);
            } else if (partData instanceof PartData.BinaryItem) {
                byte[] byteArray2 = SourcesKt.readByteArray(BytePacketBuilderKt.build(sinkBytePacketBuilder));
                channelPart = new PreparedPart.InputPart(byteArray2, ((PartData.BinaryItem) partData).getProvider(), lValueOf != null ? Long.valueOf(lValueOf.longValue() + ((long) this.PART_OVERHEAD_SIZE) + ((long) byteArray2.length)) : null);
            } else if (!(partData instanceof PartData.FormItem)) {
                if (!(partData instanceof PartData.BinaryChannelItem)) {
                    throw new NoWhenBranchMatchedException();
                }
                byte[] byteArray3 = SourcesKt.readByteArray(BytePacketBuilderKt.build(sinkBytePacketBuilder));
                channelPart = new PreparedPart.ChannelPart(byteArray3, ((PartData.BinaryChannelItem) partData).getProvider(), lValueOf != null ? Long.valueOf(lValueOf.longValue() + ((long) this.PART_OVERHEAD_SIZE) + ((long) byteArray3.length)) : null);
            } else {
                Buffer buffer = new Buffer();
                StringsKt.writeText$default(buffer, ((PartData.FormItem) partData).getValue(), 0, 0, (Charset) null, 14, (Object) null);
                final byte[] byteArray4 = SourcesKt.readByteArray(buffer);
                Function0 function0 = new Function0() { // from class: io.ktor.client.request.forms.MultiPartFormDataContent$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MultiPartFormDataContent.rawParts$lambda$3$lambda$2(byteArray4);
                    }
                };
                if (lValueOf == null) {
                    StringsKt.writeText$default(sinkBytePacketBuilder, HttpHeaders.INSTANCE.getContentLength() + ": " + byteArray4.length, 0, 0, (Charset) null, 14, (Object) null);
                    BytePacketBuilderKt.writeFully$default(sinkBytePacketBuilder, FormDataContentKt.RN_BYTES, 0, 0, 6, null);
                }
                channelPart = new PreparedPart.InputPart(SourcesKt.readByteArray(BytePacketBuilderKt.build(sinkBytePacketBuilder)), function0, Long.valueOf(byteArray4.length + this.PART_OVERHEAD_SIZE + r4.length));
            }
            arrayList.add(channelPart);
        }
        ArrayList arrayList2 = arrayList;
        this.rawParts = arrayList2;
        Long lValueOf2 = 0L;
        Iterator it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                l = lValueOf2;
                break;
            }
            Long size = ((PreparedPart) it.next()).getSize();
            if (size == null) {
                break;
            } else {
                lValueOf2 = lValueOf2 != null ? Long.valueOf(lValueOf2.longValue() + size.longValue()) : null;
            }
        }
        this.contentLength = l != null ? Long.valueOf(l.longValue() + ((long) this.BODY_OVERHEAD_SIZE)) : l;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return this.contentLength;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3 A[Catch: all -> 0x01b6, TryCatch #4 {all -> 0x01b6, blocks: (B:15:0x003f, B:43:0x00bd, B:45:0x00c3, B:48:0x00e1, B:51:0x00fb, B:76:0x0170, B:82:0x0193, B:42:0x00b7), top: B:101:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0114 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011c A[Catch: all -> 0x00b0, TRY_LEAVE, TryCatch #0 {all -> 0x00b0, blocks: (B:55:0x0117, B:57:0x011c, B:63:0x013e, B:69:0x014b, B:71:0x014f, B:80:0x018d, B:81:0x0192, B:67:0x0147, B:68:0x014a, B:31:0x0084, B:34:0x0096, B:37:0x00a9, B:58:0x0128, B:62:0x013c, B:26:0x0070, B:65:0x0145), top: B:101:0x0022, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014b A[Catch: all -> 0x00b0, TryCatch #0 {all -> 0x00b0, blocks: (B:55:0x0117, B:57:0x011c, B:63:0x013e, B:69:0x014b, B:71:0x014f, B:80:0x018d, B:81:0x0192, B:67:0x0147, B:68:0x014a, B:31:0x0084, B:34:0x0096, B:37:0x00a9, B:58:0x0128, B:62:0x013c, B:26:0x0070, B:65:0x0145), top: B:101:0x0022, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0189 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0193 A[Catch: all -> 0x01b6, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x01b6, blocks: (B:15:0x003f, B:43:0x00bd, B:45:0x00c3, B:48:0x00e1, B:51:0x00fb, B:76:0x0170, B:82:0x0193, B:42:0x00b7), top: B:101:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ca A[RETURN] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r14v0, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v39, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v42, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v45 */
    /* JADX WARN: Type inference failed for: r14v46, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r14v53 */
    /* JADX WARN: Type inference failed for: r14v54 */
    /* JADX WARN: Type inference failed for: r14v55 */
    /* JADX WARN: Type inference failed for: r14v56 */
    /* JADX WARN: Type inference failed for: r14v57 */
    /* JADX WARN: Type inference failed for: r14v58 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v10, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v18, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r4v20, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v8, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r5v3, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x018a -> B:43:0x00bd). Please report as a decompilation issue!!! */
    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeTo(io.ktor.utils.io.ByteWriteChannel r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.forms.MultiPartFormDataContent.writeTo(io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Source rawParts$lambda$3$lambda$2(byte[] bArr) {
        Buffer buffer = new Buffer();
        BytePacketBuilderKt.writeFully$default(buffer, bArr, 0, 0, 6, null);
        return buffer;
    }
}
