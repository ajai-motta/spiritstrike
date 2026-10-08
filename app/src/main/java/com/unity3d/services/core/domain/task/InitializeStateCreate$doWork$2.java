package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InitializeStateCreate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateCreate$doWork$2", f = "InitializeStateCreate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InitializeStateCreate$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateCreate.Params $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateCreate$doWork$2(InitializeStateCreate.Params params, Continuation<? super InitializeStateCreate$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateCreate$doWork$2(this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((InitializeStateCreate$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM7415constructorimpl;
        Configuration config;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        InitializeStateCreate.Params params = this.$params;
        try {
            Result.Companion companion = Result.INSTANCE;
            DeviceLog.debug("Unity Ads init: creating webapp");
            config = params.getConfig();
            config.setWebViewData(params.getWebViewData());
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        try {
            ErrorState errorStateCreate = WebViewApp.create(config, false);
            if (errorStateCreate != null) {
                String webAppFailureMessage = "Unity Ads WebApp creation failed";
                if (WebViewApp.getCurrentApp().getWebAppFailureMessage() != null) {
                    webAppFailureMessage = WebViewApp.getCurrentApp().getWebAppFailureMessage();
                }
                DeviceLog.error(webAppFailureMessage);
                throw new InitializationException(errorStateCreate, new Exception(webAppFailureMessage), config);
            }
            objM7415constructorimpl = Result.m7415constructorimpl(config);
            if (Result.m7422isSuccessimpl(objM7415constructorimpl)) {
                Result.Companion companion3 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(objM7415constructorimpl);
            } else {
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl != null) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(thM7418exceptionOrNullimpl));
                }
            }
            return Result.m7414boximpl(objM7415constructorimpl);
        } catch (IllegalThreadStateException e2) {
            DeviceLog.exception("Illegal Thread", e2);
            throw new InitializationException(ErrorState.CreateWebApp, e2, config);
        }
    }
}
