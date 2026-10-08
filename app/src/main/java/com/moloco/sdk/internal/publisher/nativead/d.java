package com.moloco.sdk.internal.publisher.nativead;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.h;
import com.moloco.sdk.internal.ortb.model.x;
import com.moloco.sdk.internal.publisher.A;
import com.moloco.sdk.internal.publisher.j;
import com.moloco.sdk.internal.publisher.nativead.model.b;
import com.moloco.sdk.internal.publisher.y;
import com.moloco.sdk.internal.services.InterfaceC3005f;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static final int l = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2213a;
    public final com.moloco.sdk.internal.ortb.model.c b;
    public final com.moloco.sdk.internal.publisher.nativead.model.b c;
    public final InterfaceC3005f d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a e;
    public final AdFormatType f;
    public final i g;
    public final r h;
    public final MetricsRecorder i;
    public final y j;
    public final a k;

    public d(String adUnitId, com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.internal.publisher.nativead.model.b ortbResponse, InterfaceC3005f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, AdFormatType adFormatType, i persistentHttpRequest, r externalLinkHandler, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(ortbResponse, "ortbResponse");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f2213a = adUnitId;
        this.b = bid;
        this.c = ortbResponse;
        this.d = appLifecycleTrackerService;
        this.e = customUserEventBuilderService;
        this.f = adFormatType;
        this.g = persistentHttpRequest;
        this.h = externalLinkHandler;
        this.i = metricsRecorder;
        this.j = a();
        this.k = b();
    }

    public final y a() {
        final com.moloco.sdk.internal.ortb.model.c cVar = this.b;
        InterfaceC3005f interfaceC3005f = this.d;
        com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = this.e;
        Function0 function0 = new Function0() { // from class: com.moloco.sdk.internal.publisher.nativead.d$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d.a(cVar);
            }
        };
        Function0 function02 = new Function0() { // from class: com.moloco.sdk.internal.publisher.nativead.d$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d.a(this.f$0);
            }
        };
        AdFormatType adFormatType = this.f;
        MetricsRecorder metricsRecorder = this.i;
        return A.a(null, interfaceC3005f, aVar, function0, function02, (TypedValues.MotionType.TYPE_DRAW_PATH & 32) != 0 ? com.moloco.sdk.internal.y.b() : null, (TypedValues.MotionType.TYPE_DRAW_PATH & 64) != 0 ? h.a() : null, adFormatType, metricsRecorder, (TypedValues.MotionType.TYPE_DRAW_PATH & 512) != 0 ? new com.moloco.sdk.internal.client_metrics_data.a(metricsRecorder) : null);
    }

    public final a b() {
        com.moloco.sdk.internal.publisher.nativead.model.b bVar = this.c;
        return new a(bVar.c(), bVar.b(), this.g);
    }

    public final void c() {
        b.c cVarD = this.c.d();
        if (cVarD != null) {
            this.k.a(cVarD.a());
            this.h.a(cVarD.c());
        }
        this.j.onAdClicked(MolocoAdKt.createAdInfo$default(this.f2213a, null, null, 6, null));
    }

    public final void d() {
        this.k.a();
        this.j.onAdShowSuccess(MolocoAdKt.createAdInfo$default(this.f2213a, null, null, 6, null));
    }

    public static final x a(com.moloco.sdk.internal.ortb.model.c cVar) {
        return cVar.getExt().getSdkEvents();
    }

    public static final j a(d dVar) {
        String burl = dVar.b.getBurl();
        if (burl != null) {
            return new j(burl, Float.valueOf(dVar.b.getPrice()));
        }
        return null;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f2214a;
        public List<b.C0401b> b;
        public final i c;
        public final Set<String> d;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.d$a$a, reason: collision with other inner class name */
        public static final class C0398a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0398a f2215a = new C0398a();
            public static final int b = 1;
            public static final int c = 0;
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f2216a = new b();
            public static final int b = 1;
            public static final int c = 0;
        }

        public a(List<String> list, List<b.C0401b> list2, i persistentHttpRequest) {
            Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
            this.f2214a = list;
            this.b = list2;
            this.c = persistentHttpRequest;
            this.d = new LinkedHashSet();
        }

        public final void a() {
            List<String> list = this.f2214a;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    this.c.a((String) it.next());
                }
            }
            this.f2214a = null;
            List<b.C0401b> list2 = this.b;
            if (list2 != null) {
                for (b.C0401b c0401b : list2) {
                    if (c0401b.c() != null && c0401b.a() == 1 && c0401b.b() == 1) {
                        this.c.a(c0401b.c());
                    }
                }
            }
            this.b = null;
        }

        public final void a(List<String> urls) {
            Intrinsics.checkNotNullParameter(urls, "urls");
            for (String str : urls) {
                if (!this.d.contains(str)) {
                    this.c.a(str);
                    this.d.add(str);
                }
            }
        }
    }
}
