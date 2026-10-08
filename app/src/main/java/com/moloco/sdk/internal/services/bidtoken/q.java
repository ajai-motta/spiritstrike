package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.service_locator.a;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes6.dex */
public interface q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2325a = a.f2326a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f2326a = new a();

        public final q a() {
            return new r(a.h.f2426a.h(), o.f2311a.a(), com.moloco.sdk.internal.services.encryption.a.f2344a.a(), com.moloco.sdk.internal.services.bidtoken.providers.l.f2319a.a());
        }
    }

    Object a(MetricsRecorder metricsRecorder, String str, f fVar, Continuation<? super Result<String>> continuation);
}
