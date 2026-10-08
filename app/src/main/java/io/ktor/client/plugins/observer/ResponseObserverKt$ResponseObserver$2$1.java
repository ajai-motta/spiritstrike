package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.observer.AfterReceiveHook;
import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ResponseObserver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/observer/AfterReceiveHook$Context;", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1", f = "ResponseObserver.kt", i = {0, 0, 1, 1, 3, 3, 3}, l = {69, 69, 72, 82, 87}, m = "invokeSuspend", n = {"$this$on", "response", "$this$on", "response", "$this$on", "newResponse", "sideResponse"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2"})
final class ResponseObserverKt$ResponseObserver$2$1 extends SuspendLambda implements Function3<AfterReceiveHook.Context, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<HttpClientCall, Boolean> $filter;
    final /* synthetic */ Function2<HttpResponse, Continuation<? super Unit>, Object> $responseHandler;
    final /* synthetic */ ClientPluginBuilder<ResponseObserverConfig> $this_createClientPlugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ResponseObserverKt$ResponseObserver$2$1(Function1<? super HttpClientCall, Boolean> function1, ClientPluginBuilder<ResponseObserverConfig> clientPluginBuilder, Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ResponseObserverKt$ResponseObserver$2$1> continuation) {
        super(3, continuation);
        this.$filter = function1;
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$responseHandler = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel invokeSuspend$lambda$0(ByteReadChannel byteReadChannel, HttpResponse httpResponse) {
        return byteReadChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel invokeSuspend$lambda$1(ByteReadChannel byteReadChannel, HttpResponse httpResponse) {
        return byteReadChannel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(AfterReceiveHook.Context context, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        ResponseObserverKt$ResponseObserver$2$1 responseObserverKt$ResponseObserver$2$1 = new ResponseObserverKt$ResponseObserver$2$1(this.$filter, this.$this_createClientPlugin, this.$responseHandler, continuation);
        responseObserverKt$ResponseObserver$2$1.L$0 = context;
        responseObserverKt$ResponseObserver$2$1.L$1 = httpResponse;
        return responseObserverKt$ResponseObserver$2$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0145 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r16) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ResponseObserver.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$1", f = "ResponseObserver.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        final /* synthetic */ HttpResponse $response;
        final /* synthetic */ Function2<HttpResponse, Continuation<? super Unit>, Object> $responseHandler;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function2, HttpResponse httpResponse, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$responseHandler = function2;
            this.$response = httpResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$responseHandler, this.$response, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM7415constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<HttpResponse, Continuation<? super Unit>, Object> function2 = this.$responseHandler;
                    HttpResponse httpResponse = this.$response;
                    Result.Companion companion = Result.INSTANCE;
                    this.label = 1;
                    if (function2.invoke(httpResponse, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            return Result.m7414boximpl(objM7415constructorimpl);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: ResponseObserver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$2", f = "ResponseObserver.kt", i = {0}, l = {83, 84}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<HttpResponse, Continuation<? super Unit>, Object> $responseHandler;
        final /* synthetic */ HttpResponse $sideResponse;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function2, HttpResponse httpResponse, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$responseHandler = function2;
            this.$sideResponse = httpResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$responseHandler, this.$sideResponse, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                } catch (Throwable th) {
                    Result.Companion companion = Result.INSTANCE;
                    Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7415constructorimpl(ResultKt.createFailure(th2));
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Function2<HttpResponse, Continuation<? super Unit>, Object> function2 = this.$responseHandler;
                HttpResponse httpResponse = this.$sideResponse;
                Result.Companion companion3 = Result.INSTANCE;
                this.L$0 = coroutineScope;
                this.label = 1;
                if (function2.invoke(httpResponse, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    Result.m7415constructorimpl(Boxing.boxLong(((Number) obj).longValue()));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.m7415constructorimpl(Unit.INSTANCE);
            HttpResponse httpResponse2 = this.$sideResponse;
            Result.Companion companion4 = Result.INSTANCE;
            ByteReadChannel rawContent = httpResponse2.getRawContent();
            this.L$0 = null;
            this.label = 2;
            obj = ByteReadChannelOperationsKt.discard$default(rawContent, 0L, this, 1, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            Result.m7415constructorimpl(Boxing.boxLong(((Number) obj).longValue()));
            return Unit.INSTANCE;
        }
    }
}
