package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers;

import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static final a d = new a(null);
    public static final int e = 8;
    public static final String f = "CompositeEventHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> f2661a;
    public final MetricsRecorder b;
    public final Lazy c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Set<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> eventHandlers, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(eventHandlers, "eventHandlers");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f2661a = eventHandlers;
        this.b = metricsRecorder;
        this.c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.d$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d.a(this.f$0);
            }
        });
    }

    public final Map<String, List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a>> a() {
        return (Map) this.c.getValue();
    }

    public static final Map a(d dVar) {
        Set<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> set = dVar.f2661a;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a) it.next()).a());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            String str = (String) obj;
            Set<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> set2 = dVar.f2661a;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : set2) {
                if (((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a) obj2).a().contains(str)) {
                    arrayList2.add(obj2);
                }
            }
            linkedHashMap.put(obj, arrayList2);
        }
        return linkedHashMap;
    }

    public final void a(String event) throws JSONException {
        TimerEvent timerEvent;
        String str;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a aVar;
        TimerEvent timerEvent2;
        Intrinsics.checkNotNullParameter(event, "event");
        TimerEvent timerEventStartTimerEvent = this.b.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.s.c());
        JSONObject jSONObject = new JSONObject(event);
        String string = jSONObject.getString("event");
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.debug$default(molocoLogger, f, "Event received: " + string, false, 4, null);
        List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> list = a().get(string);
        if (list != null && !list.isEmpty()) {
            if (list.size() > 1) {
                timerEvent = timerEventStartTimerEvent;
                str = LoginLogger.EVENT_EXTRAS_FAILURE;
                MolocoLogger.warn$default(molocoLogger, f, "Found multiple event handlers for event: " + string + ", using first one", null, false, 12, null);
                MetricsRecorder metricsRecorder = this.b;
                CountEvent countEventWithTag = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.L.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), str);
                Intrinsics.checkNotNull(string);
                metricsRecorder.recordCountEvent(countEventWithTag.withTag("event", string));
            } else {
                timerEvent = timerEventStartTimerEvent;
                str = LoginLogger.EVENT_EXTRAS_FAILURE;
            }
            TimerEvent timerEventStartTimerEvent2 = this.b.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.t.c());
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a aVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a) CollectionsKt.first((List) list);
            try {
                aVar2.a(jSONObject);
                aVar = aVar2;
                try {
                    MolocoLogger.debug$default(molocoLogger, f, "Event handled: " + string, false, 4, null);
                    MetricsRecorder metricsRecorder2 = this.b;
                    Intrinsics.checkNotNull(string);
                    TimerEvent timerEventWithTag = timerEventStartTimerEvent2.withTag("event", string).withTag("handler", aVar.b());
                    com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.d;
                    metricsRecorder2.recordTimerEvent(timerEventWithTag.withTag(dVar.c(), "success"));
                    this.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.K.c()).withTag(dVar.c(), "success").withTag("handler", aVar.b()).withTag("event", string));
                    timerEvent2 = timerEvent;
                    try {
                        this.b.recordTimerEvent(timerEvent2.withTag(dVar.c(), "success").withTag("handler", aVar.b()).withTag("event", string));
                    } catch (Exception e2) {
                        e = e2;
                        MolocoLogger.warn$default(MolocoLogger.INSTANCE, f, "Event handling failed: " + string, e, false, 8, null);
                        MetricsRecorder metricsRecorder3 = this.b;
                        Intrinsics.checkNotNull(string);
                        TimerEvent timerEventWithTag2 = timerEventStartTimerEvent2.withTag("event", string).withTag("handler", aVar.b());
                        com.moloco.sdk.internal.client_metrics_data.d dVar2 = com.moloco.sdk.internal.client_metrics_data.d.b;
                        String strC = dVar2.c();
                        String simpleName = e.getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                        TimerEvent timerEventWithTag3 = timerEventWithTag2.withTag(strC, simpleName);
                        com.moloco.sdk.internal.client_metrics_data.d dVar3 = com.moloco.sdk.internal.client_metrics_data.d.d;
                        metricsRecorder3.recordTimerEvent(timerEventWithTag3.withTag(dVar3.c(), str));
                        MetricsRecorder metricsRecorder4 = this.b;
                        CountEvent countEventWithTag2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.K.c()).withTag(dVar3.c(), str);
                        String strC2 = dVar2.c();
                        String simpleName2 = e.getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
                        metricsRecorder4.recordCountEvent(countEventWithTag2.withTag(strC2, simpleName2).withTag("handler", aVar.b()).withTag("event", string));
                        MetricsRecorder metricsRecorder5 = this.b;
                        TimerEvent timerEventWithTag4 = timerEvent2.withTag(dVar3.c(), str);
                        String strC3 = dVar2.c();
                        String simpleName3 = e.getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(simpleName3, "getSimpleName(...)");
                        metricsRecorder5.recordTimerEvent(timerEventWithTag4.withTag(strC3, simpleName3).withTag("handler", aVar.b()).withTag("event", string));
                    }
                } catch (Exception e3) {
                    e = e3;
                    timerEvent2 = timerEvent;
                    MolocoLogger.warn$default(MolocoLogger.INSTANCE, f, "Event handling failed: " + string, e, false, 8, null);
                    MetricsRecorder metricsRecorder32 = this.b;
                    Intrinsics.checkNotNull(string);
                    TimerEvent timerEventWithTag22 = timerEventStartTimerEvent2.withTag("event", string).withTag("handler", aVar.b());
                    com.moloco.sdk.internal.client_metrics_data.d dVar22 = com.moloco.sdk.internal.client_metrics_data.d.b;
                    String strC4 = dVar22.c();
                    String simpleName4 = e.getClass().getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName4, "getSimpleName(...)");
                    TimerEvent timerEventWithTag32 = timerEventWithTag22.withTag(strC4, simpleName4);
                    com.moloco.sdk.internal.client_metrics_data.d dVar32 = com.moloco.sdk.internal.client_metrics_data.d.d;
                    metricsRecorder32.recordTimerEvent(timerEventWithTag32.withTag(dVar32.c(), str));
                    MetricsRecorder metricsRecorder42 = this.b;
                    CountEvent countEventWithTag22 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.K.c()).withTag(dVar32.c(), str);
                    String strC22 = dVar22.c();
                    String simpleName22 = e.getClass().getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName22, "getSimpleName(...)");
                    metricsRecorder42.recordCountEvent(countEventWithTag22.withTag(strC22, simpleName22).withTag("handler", aVar.b()).withTag("event", string));
                    MetricsRecorder metricsRecorder52 = this.b;
                    TimerEvent timerEventWithTag42 = timerEvent2.withTag(dVar32.c(), str);
                    String strC32 = dVar22.c();
                    String simpleName32 = e.getClass().getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName32, "getSimpleName(...)");
                    metricsRecorder52.recordTimerEvent(timerEventWithTag42.withTag(strC32, simpleName32).withTag("handler", aVar.b()).withTag("event", string));
                }
            } catch (Exception e4) {
                e = e4;
                aVar = aVar2;
            }
        } else {
            MolocoLogger.error$default(molocoLogger, f, "Event not handled: " + string, null, false, 12, null);
            MetricsRecorder metricsRecorder6 = this.b;
            CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.K.c());
            com.moloco.sdk.internal.client_metrics_data.d dVar4 = com.moloco.sdk.internal.client_metrics_data.d.d;
            CountEvent countEventWithTag3 = countEvent.withTag(dVar4.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.d dVar5 = com.moloco.sdk.internal.client_metrics_data.d.b;
            CountEvent countEventWithTag4 = countEventWithTag3.withTag(dVar5.c(), "no_handler");
            Intrinsics.checkNotNull(string);
            metricsRecorder6.recordCountEvent(countEventWithTag4.withTag("event", string));
            this.b.recordTimerEvent(timerEventStartTimerEvent.withTag(dVar4.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(dVar5.c(), "no_handler").withTag("event", string));
        }
    }
}
