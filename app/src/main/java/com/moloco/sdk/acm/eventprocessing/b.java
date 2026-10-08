package com.moloco.sdk.acm.eventprocessing;

import com.moloco.sdk.MetricsRequest;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements com.moloco.sdk.acm.eventprocessing.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f1984a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1985a;

        static {
            int[] iArr = new int[com.moloco.sdk.acm.db.c.values().length];
            try {
                iArr[com.moloco.sdk.acm.db.c.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.moloco.sdk.acm.db.c.f1971a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f1985a = iArr;
        }
    }

    public b(f dataAgeChecker) {
        Intrinsics.checkNotNullParameter(dataAgeChecker, "dataAgeChecker");
        this.f1984a = dataAgeChecker;
    }

    @Override // com.moloco.sdk.acm.eventprocessing.a
    public com.moloco.sdk.acm.http.d a(List<com.moloco.sdk.acm.db.b> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.moloco.sdk.acm.db.b bVar : events) {
            if (!this.f1984a.a(bVar)) {
                int i = a.f1985a[bVar.h().ordinal()];
                if (i == 1) {
                    MetricsRequest.PostMetricsRequest.CountEvent.Builder builderAddAllTags = MetricsRequest.PostMetricsRequest.CountEvent.newBuilder().setName(bVar.j()).addAllTags(bVar.k());
                    Long lG = bVar.g();
                    if (lG != null) {
                        builderAddAllTags.setCount((int) lG.longValue());
                    }
                    MetricsRequest.PostMetricsRequest.CountEvent countEventBuild = builderAddAllTags.build();
                    Intrinsics.checkNotNullExpressionValue(countEventBuild, "build(...)");
                    arrayList2.add(countEventBuild);
                } else {
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    MetricsRequest.PostMetricsRequest.TimerEvent.Builder builderAddAllTags2 = MetricsRequest.PostMetricsRequest.TimerEvent.newBuilder().setName(bVar.j()).addAllTags(bVar.k());
                    Long lG2 = bVar.g();
                    if (lG2 != null) {
                        builderAddAllTags2.setElapsedTimeMillis(lG2.longValue());
                    }
                    MetricsRequest.PostMetricsRequest.TimerEvent timerEventBuild = builderAddAllTags2.build();
                    Intrinsics.checkNotNullExpressionValue(timerEventBuild, "build(...)");
                    arrayList.add(timerEventBuild);
                }
            }
        }
        return new com.moloco.sdk.acm.http.d(arrayList2, arrayList);
    }
}
