package io.ktor.client.request;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: buildersWithUrl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a7\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\f\u0010\n\u001a7\u0010\r\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\r\u0010\n\u001a7\u0010\u000e\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u000e\u0010\n\u001a7\u0010\u000f\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u000f\u0010\n\u001a7\u0010\u0010\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0010\u0010\n\u001a7\u0010\u0011\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0011\u0010\n\u001a7\u0010\u0012\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0012\u0010\n\u001a7\u0010\u0013\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0013\u0010\n\u001a7\u0010\u0014\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0014\u0010\n\u001a7\u0010\u0015\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0015\u0010\n\u001a7\u0010\u0016\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0016\u0010\n\u001a7\u0010\u0017\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0017\u0010\n\u001a7\u0010\u0018\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H¢\u0006\u0004\b\u0018\u0010\n\u001a\u0019\u0010\u0002\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/http/Url;", "url", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lio/ktor/client/statement/HttpResponse;", "get", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Url;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpStatement;", "prepareGet", "post", "preparePost", "put", "preparePut", "patch", "preparePatch", "options", "prepareOptions", TtmlNode.TAG_HEAD, "prepareHead", "delete", "prepareDelete", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/Url;)V", "ktor-client-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BuildersWithUrlKt {
    public static /* synthetic */ Object get$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.get.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static /* synthetic */ Object prepareGet$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.prepareGet.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object post$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.post.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static /* synthetic */ Object preparePost$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.preparePost.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object put$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.put.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static /* synthetic */ Object preparePut$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.preparePut.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object patch$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.patch.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static /* synthetic */ Object preparePatch$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.preparePatch.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object options$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.options.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static /* synthetic */ Object prepareOptions$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.prepareOptions.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object head$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.head.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static /* synthetic */ Object prepareHead$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.prepareHead.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object delete$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.delete.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static /* synthetic */ Object prepareDelete$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersWithUrlKt.prepareDelete.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, Url url) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
    }

    public static final Object get(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object get$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static final Object prepareGet(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareGet$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object post(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object post$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static final Object preparePost(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePost$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object put(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object put$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static final Object preparePut(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePut$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object patch(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object patch$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static final Object preparePatch(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePatch$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object options(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object options$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static final Object prepareOptions(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareOptions$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object head(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object head$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static final Object prepareHead(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareHead$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object delete(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object delete$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object objExecute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return objExecute;
    }

    public static final Object prepareDelete(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareDelete$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }
}
