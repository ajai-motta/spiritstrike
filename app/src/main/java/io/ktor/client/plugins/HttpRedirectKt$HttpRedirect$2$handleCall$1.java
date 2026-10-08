package io.ktor.client.plugins;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: HttpRedirect.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRedirectKt", f = "HttpRedirect.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {97}, m = "HttpRedirect$lambda$2$handleCall", n = {"$this$HttpRedirect_u24lambda_u242_u24handleCall", "context", "client", NotificationCompat.CATEGORY_CALL, "requestBuilder", "originProtocol", "originAuthority", "allowHttpsDowngrade"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"})
final class HttpRedirectKt$HttpRedirect$2$handleCall$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    HttpRedirectKt$HttpRedirect$2$handleCall$1(Continuation<? super HttpRedirectKt$HttpRedirect$2$handleCall$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpRedirectKt.HttpRedirect$lambda$2$handleCall(null, null, null, false, null, this);
    }
}
