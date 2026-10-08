package com.moloco.sdk.internal.client_metrics_data;

import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.AdFormatType;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static final C0378a c = new C0378a(null);
    public static final int d = 8;
    public static final String e = "AcmClickDeduper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MetricsRecorder f2032a;
    public AtomicBoolean b;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.client_metrics_data.a$a, reason: collision with other inner class name */
    public static final class C0378a {
        public /* synthetic */ C0378a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public C0378a() {
        }
    }

    public a(MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f2032a = metricsRecorder;
        this.b = new AtomicBoolean(false);
    }

    public final void a() {
        this.b.set(false);
    }

    public final void a(AdFormatType adType) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        if (this.b.compareAndSet(false, true)) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, e, "Deduped click logged", null, false, 12, null);
            MetricsRecorder metricsRecorder = this.f2032a;
            CountEvent countEvent = new CountEvent(b.E.c());
            String strC = d.c.c();
            String lowerCase = adType.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            metricsRecorder.recordCountEvent(countEvent.withTag(strC, lowerCase));
        }
        this.b.set(true);
    }
}
