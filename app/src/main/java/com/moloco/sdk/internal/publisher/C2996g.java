package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C2996g {
    public static final x a(AdLoad.Listener listener, TimerEvent acmLoadTimerEvent, AdFormatType adFormatType, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(acmLoadTimerEvent, "acmLoadTimerEvent");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        return new C2995f(listener, com.moloco.sdk.internal.y.b(), acmLoadTimerEvent, adFormatType, metricsRecorder);
    }
}
