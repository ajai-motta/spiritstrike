package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.flow.h0;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class InneractiveAdSpotManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f1011a = new ConcurrentHashMap();

    public static void destroy() {
        ConcurrentHashMap concurrentHashMap = get().f1011a;
        Iterator it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) concurrentHashMap.get((String) it.next());
            if (inneractiveAdSpot != null) {
                inneractiveAdSpot.destroy();
            }
        }
        concurrentHashMap.clear();
    }

    public static InneractiveAdSpotManager get() {
        return e.f1022a;
    }

    public void bindSpot(InneractiveAdSpot inneractiveAdSpot) {
        this.f1011a.put(inneractiveAdSpot.getLocalUniqueId(), inneractiveAdSpot);
    }

    public InneractiveAdSpot createSpot() {
        h0 h0Var = new h0();
        this.f1011a.put(h0Var.f1064a, h0Var);
        return h0Var;
    }

    public InneractiveAdSpot getSpot(String str) {
        return (InneractiveAdSpot) this.f1011a.get(str);
    }

    public void removeSpot(InneractiveAdSpot inneractiveAdSpot) {
        ConcurrentHashMap concurrentHashMap = this.f1011a;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(inneractiveAdSpot.getLocalUniqueId());
        }
    }
}
