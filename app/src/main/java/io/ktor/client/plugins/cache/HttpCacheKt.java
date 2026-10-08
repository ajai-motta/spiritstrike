package io.ktor.client.plugins.cache;

import androidx.webkit.ProxyConfig;
import io.ktor.client.engine.UtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLProtocol;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* JADX INFO: compiled from: HttpCache.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aU\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00050\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f\"\u001e\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "content", "Lkotlin/Function1;", "", "headerExtractor", "", "allHeadersExtractor", "mergedHeadersLookup", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "Lio/ktor/http/URLProtocol;", "", "canStore", "(Lio/ktor/http/URLProtocol;)Z", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "getLOGGER", "()Lorg/slf4j/Logger;", "ktor-client-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HttpCacheKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpCache");

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    public static final Function1<String, String> mergedHeadersLookup(final OutgoingContent content, final Function1<? super String, String> headerExtractor, final Function1<? super String, ? extends List<String>> allHeadersExtractor) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(headerExtractor, "headerExtractor");
        Intrinsics.checkNotNullParameter(allHeadersExtractor, "allHeadersExtractor");
        return new Function1() { // from class: io.ktor.client.plugins.cache.HttpCacheKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HttpCacheKt.mergedHeadersLookup$lambda$0(content, headerExtractor, allHeadersExtractor, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String mergedHeadersLookup$lambda$0(OutgoingContent outgoingContent, Function1 function1, Function1 function12, String header) {
        String string;
        Intrinsics.checkNotNullParameter(header, "header");
        if (Intrinsics.areEqual(header, HttpHeaders.INSTANCE.getContentLength())) {
            Long contentLength = outgoingContent.getContentLength();
            if (contentLength == null || (string = contentLength.toString()) == null) {
                return "";
            }
        } else {
            if (!Intrinsics.areEqual(header, HttpHeaders.INSTANCE.getContentType())) {
                if (Intrinsics.areEqual(header, HttpHeaders.INSTANCE.getUserAgent())) {
                    String str = outgoingContent.getHeaders().get(HttpHeaders.INSTANCE.getUserAgent());
                    if (str != null) {
                        return str;
                    }
                    String str2 = (String) function1.invoke(HttpHeaders.INSTANCE.getUserAgent());
                    return str2 == null ? UtilsKt.getKTOR_DEFAULT_USER_AGENT() : str2;
                }
                List<String> all = outgoingContent.getHeaders().getAll(header);
                if (all == null && (all = (List) function12.invoke(header)) == null) {
                    all = CollectionsKt.emptyList();
                }
                return CollectionsKt.joinToString$default(all, ";", null, null, 0, null, null, 62, null);
            }
            ContentType contentType = outgoingContent.getContentType();
            if (contentType == null || (string = contentType.toString()) == null) {
                return "";
            }
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean canStore(URLProtocol uRLProtocol) {
        return Intrinsics.areEqual(uRLProtocol.getName(), ProxyConfig.MATCH_HTTP) || Intrinsics.areEqual(uRLProtocol.getName(), "https");
    }
}
