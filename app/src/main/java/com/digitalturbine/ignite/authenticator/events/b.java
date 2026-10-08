package com.digitalturbine.ignite.authenticator.events;

import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final b b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f852a;

    public static void a(d dVar, Exception exc) {
        a(dVar, com.digitalturbine.ignite.authenticator.utils.events.a.a(exc, null));
    }

    public static void a(d dVar, Object... objArr) {
        com.digitalturbine.ignite.authenticator.logger.a.a("%s : dispatching event", "IgniteEventDispatcher");
        if (b.f852a != null) {
            t tVarA = t.a(dVar);
            if (tVarA == null) {
                IAlog.f("%s : One DT Error: %s is missing in IAReportError map", "IgniteEventDispatcherWrapper", dVar);
            } else {
                new w(tVarA).a(objArr).a((String) null);
            }
        }
    }
}
