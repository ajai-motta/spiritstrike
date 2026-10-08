package io.ktor.client.plugins.sse;

import androidx.core.app.NotificationCompat;
import io.ktor.client.call.HttpClientCall;
import io.ktor.sse.TypedServerSentEvent;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ClientSSESession.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR(\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00160\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/sse/ClientSSESessionWithDeserialization;", "Lio/ktor/client/plugins/sse/SSESessionWithDeserialization;", "Lio/ktor/client/call/HttpClientCall;", NotificationCompat.CATEGORY_CALL, "delegate", "<init>", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/client/plugins/sse/SSESessionWithDeserialization;)V", "Lio/ktor/client/call/HttpClientCall;", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/Function2;", "Lio/ktor/util/reflect/TypeInfo;", "", "", "getDeserializer", "()Lkotlin/jvm/functions/Function2;", "deserializer", "Lkotlinx/coroutines/flow/Flow;", "Lio/ktor/sse/TypedServerSentEvent;", "getIncoming", "()Lkotlinx/coroutines/flow/Flow;", "incoming", "ktor-client-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClientSSESessionWithDeserialization implements SSESessionWithDeserialization {
    private final /* synthetic */ SSESessionWithDeserialization $$delegate_0;
    private final HttpClientCall call;

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // io.ktor.client.plugins.sse.SSESessionWithDeserialization
    public Function2<TypeInfo, String, Object> getDeserializer() {
        return this.$$delegate_0.getDeserializer();
    }

    @Override // io.ktor.client.plugins.sse.SSESessionWithDeserialization
    public Flow<TypedServerSentEvent<String>> getIncoming() {
        return this.$$delegate_0.getIncoming();
    }

    public ClientSSESessionWithDeserialization(HttpClientCall call, SSESessionWithDeserialization delegate) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.$$delegate_0 = delegate;
        this.call = call;
    }

    public final HttpClientCall getCall() {
        return this.call;
    }
}
