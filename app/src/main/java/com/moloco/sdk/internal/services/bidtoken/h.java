package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.MolocoBidTokenListener;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes6.dex */
public interface h {
    Object a(MetricsRecorder metricsRecorder, MediationInfo mediationInfo, MolocoBidTokenListener molocoBidTokenListener, Continuation<? super Unit> continuation);
}
