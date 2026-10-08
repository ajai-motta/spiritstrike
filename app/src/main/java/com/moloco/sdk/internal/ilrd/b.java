package com.moloco.sdk.internal.ilrd;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.moloco.sdk.Init;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.internal.services.InterfaceC3003d;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static final a c = new a(null);
    public static final int d = 8;
    public static final String e = "IlrdInitializer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2076a;
    public e b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2076a = context;
    }

    public final e a() {
        return this.b;
    }

    public final Object b(Init.SDKInitResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (this.b != null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m7415constructorimpl(Unit.INSTANCE);
        }
        Init.SDKInitResponse.ILRDConfig iLRDConfigA = a(response);
        if (iLRDConfigA == null) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7415constructorimpl(ResultKt.createFailure(new Exception("No ILRD configuration found")));
        }
        List<Init.SDKInitResponse.SupportedNetworks> supportedNetworksList = iLRDConfigA.getSupportedNetworksList();
        if (!iLRDConfigA.getEnabled()) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m7415constructorimpl(ResultKt.createFailure(new Exception("Publisher has not opted into ILRD collection")));
        }
        if (supportedNetworksList.isEmpty()) {
            Result.Companion companion4 = Result.INSTANCE;
            return Result.m7415constructorimpl(ResultKt.createFailure(new Exception("No ILRD supported networks available")));
        }
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        IlrdEventsRepository ilrdEventsRepositoryA = a(CoroutineScope, iLRDConfigA, response);
        Intrinsics.checkNotNull(supportedNetworksList);
        a(CoroutineScope, ilrdEventsRepositoryA, supportedNetworksList);
        Result.Companion companion5 = Result.INSTANCE;
        return Result.m7415constructorimpl(Unit.INSTANCE);
    }

    public final Init.SDKInitResponse.ILRDConfig a(Init.SDKInitResponse sDKInitResponse) {
        if (sDKInitResponse.hasIlrdConfig()) {
            return sDKInitResponse.getIlrdConfig();
        }
        return null;
    }

    public final IlrdEventsRepository a(CoroutineScope coroutineScope, Init.SDKInitResponse.ILRDConfig iLRDConfig, Init.SDKInitResponse sDKInitResponse) {
        String rawImpUrl = iLRDConfig.getRawImpUrl();
        Intrinsics.checkNotNullExpressionValue(rawImpUrl, "getRawImpUrl(...)");
        i iVarC = a.i.f2427a.c();
        Duration.Companion companion = Duration.INSTANCE;
        int sessionExp = iLRDConfig.getSessionExp();
        DurationUnit durationUnit = DurationUnit.SECONDS;
        long duration = DurationKt.toDuration(sessionExp, durationUnit);
        int maxBatchSize = iLRDConfig.getMaxBatchSize();
        long duration2 = DurationKt.toDuration(iLRDConfig.getUploadInterval(), durationUnit);
        long duration3 = DurationKt.toDuration(iLRDConfig.getMaxSessionLen(), durationUnit);
        a.h hVar = a.h.f2426a;
        I iH = hVar.h();
        Lifecycle lifecycle = ProcessLifecycleOwner.INSTANCE.get().getLifecycle();
        InterfaceC3003d interfaceC3003dD = hVar.d();
        String publisherId = sDKInitResponse.getPublisherId();
        Intrinsics.checkNotNullExpressionValue(publisherId, "getPublisherId(...)");
        String appId = sDKInitResponse.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "getAppId(...)");
        return new IlrdEventsRepository(coroutineScope, rawImpUrl, iVarC, duration, maxBatchSize, duration2, duration3, iH, lifecycle, interfaceC3003dD, publisherId, appId, a.j.f2428a.b(), null, null, null, 57344, null);
    }

    public final e a(CoroutineScope coroutineScope, IlrdEventsRepository ilrdEventsRepository, List<? extends Init.SDKInitResponse.SupportedNetworks> list) {
        e eVar = new e(coroutineScope, this.f2076a, ilrdEventsRepository, list);
        this.b = eVar;
        eVar.c();
        return eVar;
    }
}
