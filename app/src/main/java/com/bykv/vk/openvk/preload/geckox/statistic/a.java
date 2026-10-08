package com.bykv.vk.openvk.preload.geckox.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Long, a> f827a = new HashMap();
    private final Map<String, com.bykv.vk.openvk.preload.geckox.statistic.model.a> b = new HashMap();

    a() {
    }

    static a a(long j) {
        a aVar;
        Map<Long, a> map = f827a;
        synchronized (map) {
            aVar = map.get(Long.valueOf(j));
            if (aVar == null) {
                aVar = new a();
                map.put(Long.valueOf(j), aVar);
            }
        }
        return aVar;
    }

    final com.bykv.vk.openvk.preload.geckox.statistic.model.a a(String str) {
        com.bykv.vk.openvk.preload.geckox.statistic.model.a aVar;
        synchronized (this.b) {
            aVar = this.b.get(str);
            if (aVar == null) {
                aVar = new com.bykv.vk.openvk.preload.geckox.statistic.model.a();
                this.b.put(str, aVar);
            }
        }
        return aVar;
    }

    final List<com.bykv.vk.openvk.preload.geckox.statistic.model.a> a() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList(this.b.values());
        }
        return arrayList;
    }
}
