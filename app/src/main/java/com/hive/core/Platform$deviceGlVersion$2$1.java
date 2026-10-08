package com.hive.core;

import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.core.Platform$deviceGlVersion$2$1", f = "Platform.kt", i = {0}, l = {279}, m = "invokeSuspend", n = {"glEsVersion"}, s = {"L$0"})
final class Platform$deviceGlVersion$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    Object L$0;
    int label;

    Platform$deviceGlVersion$2$1(Continuation<? super Platform$deviceGlVersion$2$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Platform$deviceGlVersion$2$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((Platform$deviceGlVersion$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        ConfigurationInfo deviceConfigurationInfo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ActivityManager activityManager = (ActivityManager) ContextCompat.getSystemService(HiveCoreInitializer.INSTANCE.getInitContext(), ActivityManager.class);
            String glEsVersion = (activityManager == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) ? null : deviceConfigurationInfo.getGlEsVersion();
            this.L$0 = glEsVersion;
            this.label = 1;
            Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new Platform$deviceGlVersion$2$1$renderer$1(null), this);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = glEsVersion;
            obj = objWithContext;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return ((String) obj) + str;
    }
}
