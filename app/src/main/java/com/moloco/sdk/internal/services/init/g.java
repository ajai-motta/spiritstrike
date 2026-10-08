package com.moloco.sdk.internal.services.init;

import android.content.SharedPreferences;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2367a = a.f2368a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f2368a = new a();

        public final g a(SharedPreferences sharedPreferences) {
            Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
            return new h(sharedPreferences, com.moloco.sdk.internal.scheduling.b.a().getIo());
        }
    }

    Object a(com.moloco.sdk.internal.services.init.a aVar, MetricsRecorder metricsRecorder, Init.SDKInitResponse sDKInitResponse, Continuation<? super Unit> continuation);

    Object a(com.moloco.sdk.internal.services.init.a aVar, MetricsRecorder metricsRecorder, Continuation<? super Init.SDKInitResponse> continuation);

    Object a(Continuation<? super Unit> continuation);

    Object b(com.moloco.sdk.internal.services.init.a aVar, MetricsRecorder metricsRecorder, Continuation<? super Unit> continuation);
}
