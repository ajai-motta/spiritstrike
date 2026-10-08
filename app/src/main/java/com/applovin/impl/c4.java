package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f338a;
    private final List b;
    private final int c;
    private Long d;
    private final Map e = new HashMap();
    private final Deque f = new ArrayDeque();

    public c4(com.applovin.impl.sdk.k kVar) {
        this.f338a = (String) kVar.a(y4.z4);
        this.b = kVar.c(y4.A4);
        this.c = ((Integer) kVar.a(y4.B4)).intValue();
    }

    public Long a() {
        return this.d;
    }

    public Deque b() {
        return this.f;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str) || this.c <= 0) {
            return;
        }
        Map map = (Map) this.e.remove(str);
        if (CollectionUtils.isEmpty(map)) {
            return;
        }
        HashMap map2 = new HashMap();
        map2.put("cc_ms", Long.valueOf(System.currentTimeMillis()));
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            if (!CollectionUtils.isEmpty(list)) {
                Iterator it = list.iterator();
                long jLongValue = 0;
                while (it.hasNext()) {
                    jLongValue += ((Long) it.next()).longValue();
                }
                map2.put((String) entry.getKey(), Long.valueOf(jLongValue / ((long) list.size())));
            }
        }
        if (this.f.size() == this.c) {
            this.f.pollLast();
        }
        this.f.addFirst(map2);
    }

    public void b(long j, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (!CollectionUtils.isEmpty(this.b) && this.c > 0) {
            Iterator it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str3 = (String) it.next();
                if (StringUtils.isValidString(str3) && str.endsWith(str3)) {
                    a(j, str3, str2);
                    break;
                }
            }
        }
        if (StringUtils.isValidString(this.f338a) && str.endsWith(this.f338a)) {
            this.d = Long.valueOf(j);
        }
    }

    private void a(long j, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Map map = (Map) this.e.get(str2);
        if (map == null) {
            map = new HashMap();
            this.e.put(str2, map);
        }
        List arrayList = (List) map.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(str, arrayList);
        }
        arrayList.add(Long.valueOf(j));
    }
}
