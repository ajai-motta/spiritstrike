package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.e6;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.k f428a;
    protected final String b;
    protected final com.applovin.impl.sdk.o c;
    private final Context d;
    private String e;
    private boolean f;

    public j5(String str, com.applovin.impl.sdk.k kVar) {
        this(str, kVar, false, null);
    }

    public Context a() {
        return this.d;
    }

    public com.applovin.impl.sdk.k b() {
        return this.f428a;
    }

    public String c() {
        return this.b;
    }

    public boolean d() {
        return this.f;
    }

    public j5(String str, com.applovin.impl.sdk.k kVar, boolean z) {
        this(str, kVar, z, null);
    }

    public void a(String str) {
        this.e = str;
    }

    public ScheduledFuture b(final Thread thread, final long j) {
        if (j <= 0) {
            return null;
        }
        return this.f428a.r0().b(new s6(this.f428a, "timeout:" + this.b, new Runnable() { // from class: com.applovin.impl.j5$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(thread, j);
            }
        }), e6.b.TIMEOUT, j);
    }

    public j5(String str, com.applovin.impl.sdk.k kVar, String str2) {
        this(str, kVar, false, str2);
    }

    public void a(boolean z) {
        this.f = z;
    }

    public j5(String str, com.applovin.impl.sdk.k kVar, boolean z, String str2) {
        this.b = str;
        this.f428a = kVar;
        this.c = kVar.O();
        this.d = com.applovin.impl.sdk.k.o();
        this.f = z;
        this.e = str2;
    }

    public void a(Throwable th) {
        Map map = CollectionUtils.map("source", this.b);
        map.put("top_main_method", th.toString());
        map.put("details", StringUtils.emptyIfNull(this.e));
        this.f428a.D().d(d2.X0, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Thread thread, long j) {
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("name", thread.getState().name());
        if (StringUtils.isValidString(this.e)) {
            mapHashMap.put("details", this.e);
        }
        this.f428a.D().a(d2.Y0, this.b, mapHashMap);
        if (com.applovin.impl.sdk.o.a()) {
            this.c.k(this.b, "Task has been executing for over " + TimeUnit.MILLISECONDS.toSeconds(j) + " seconds");
        }
    }
}
