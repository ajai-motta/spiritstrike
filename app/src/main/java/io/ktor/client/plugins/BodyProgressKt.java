package io.ktor.client.plugins;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.ktor.client.call.DelegatedCallKt;
import io.ktor.client.content.ProgressListener;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: BodyProgress.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0006*\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\b\"\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f\"\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/content/ProgressListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "withObservableDownload", "(Lio/ktor/client/statement/HttpResponse;Lio/ktor/client/content/ProgressListener;)Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "onDownload", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/content/ProgressListener;)V", "onUpload", "Lio/ktor/util/AttributeKey;", "UploadProgressListenerAttributeKey", "Lio/ktor/util/AttributeKey;", "DownloadProgressListenerAttributeKey", "Lio/ktor/client/plugins/api/ClientPlugin;", "BodyProgress", "Lio/ktor/client/plugins/api/ClientPlugin;", "getBodyProgress", "()Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BodyProgressKt {
    private static final ClientPlugin<Unit> BodyProgress;
    private static final AttributeKey<ProgressListener> DownloadProgressListenerAttributeKey;
    private static final AttributeKey<ProgressListener> UploadProgressListenerAttributeKey;

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel withObservableDownload$lambda$1(ByteReadChannel byteReadChannel, HttpResponse replaceResponse) {
        Intrinsics.checkNotNullParameter(replaceResponse, "$this$replaceResponse");
        return byteReadChannel;
    }

    public static final ClientPlugin<Unit> getBodyProgress() {
        return BodyProgress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BodyProgress$lambda$0(ClientPluginBuilder createClientPlugin) {
        Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
        createClientPlugin.on(AfterRenderHook.INSTANCE, new BodyProgressKt$BodyProgress$1$1(null));
        createClientPlugin.on(AfterReceiveHook.INSTANCE, new BodyProgressKt$BodyProgress$1$2(null));
        return Unit.INSTANCE;
    }

    public static final HttpResponse withObservableDownload(HttpResponse httpResponse, ProgressListener listener) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final ByteReadChannel byteReadChannelObservable = ByteChannelUtilsKt.observable(httpResponse.getRawContent(), httpResponse.getCoroutineContext(), HttpMessagePropertiesKt.contentLength(httpResponse), listener);
        return DelegatedCallKt.replaceResponse$default(httpResponse.getCall(), null, new Function1() { // from class: io.ktor.client.plugins.BodyProgressKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BodyProgressKt.withObservableDownload$lambda$1(byteReadChannelObservable, (HttpResponse) obj);
            }
        }, 1, null).getResponse();
    }

    public static final void onDownload(HttpRequestBuilder httpRequestBuilder, ProgressListener progressListener) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        if (progressListener == null) {
            httpRequestBuilder.getAttributes().remove(DownloadProgressListenerAttributeKey);
        } else {
            httpRequestBuilder.getAttributes().put(DownloadProgressListenerAttributeKey, progressListener);
        }
    }

    public static final void onUpload(HttpRequestBuilder httpRequestBuilder, ProgressListener progressListener) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        if (progressListener == null) {
            httpRequestBuilder.getAttributes().remove(UploadProgressListenerAttributeKey);
        } else {
            httpRequestBuilder.getAttributes().put(UploadProgressListenerAttributeKey, progressListener);
        }
    }

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ProgressListener.class);
        KType kTypeTypeOf2 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(ProgressListener.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        UploadProgressListenerAttributeKey = new AttributeKey<>("UploadProgressListenerAttributeKey", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ProgressListener.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(ProgressListener.class);
        } catch (Throwable unused2) {
        }
        DownloadProgressListenerAttributeKey = new AttributeKey<>("DownloadProgressListenerAttributeKey", new TypeInfo(orCreateKotlinClass2, kTypeTypeOf2));
        BodyProgress = CreatePluginUtilsKt.createClientPlugin("BodyProgress", new Function1() { // from class: io.ktor.client.plugins.BodyProgressKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BodyProgressKt.BodyProgress$lambda$0((ClientPluginBuilder) obj);
            }
        });
    }
}
