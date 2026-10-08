package com.fyber.inneractive.sdk.flow.nativead;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.fyber.inneractive.sdk.flow.nativead.mainasset.c {
    public static final String m = IAlog.a(f.class);
    public static final Object n = new Object();
    public final com.fyber.inneractive.sdk.response.nativead.i c;
    public t0 e;
    public d f;
    public final InneractiveAdRequest h;
    public final com.fyber.inneractive.sdk.config.global.r i;
    public final String j;
    public final com.fyber.inneractive.sdk.response.nativead.j k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f1073a = new CopyOnWriteArrayList();
    public final AtomicBoolean b = new AtomicBoolean(false);
    public final ArrayList d = new ArrayList();
    public final AtomicBoolean g = new AtomicBoolean(false);
    public final e l = new e(this);

    public f(com.fyber.inneractive.sdk.config.global.r rVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.nativead.j jVar, com.fyber.inneractive.sdk.response.nativead.i iVar, d dVar, String str) {
        this.i = rVar;
        this.k = jVar;
        this.h = inneractiveAdRequest;
        this.c = iVar;
        this.f = dVar;
        this.j = str;
    }

    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError, String str) {
        IAlog.f("%sonMainAssetLoadFailed: %s", m, str != null ? "Failed to load native main media with message ".concat(str) : "Failed to load native main media");
        for (c cVar : this.f1073a) {
            if (cVar.a()) {
                cVar.destroy();
            }
        }
        String strDescription = inneractiveInfrastructureError.description();
        if (this.g.compareAndSet(false, true)) {
            InneractiveInfrastructureError inneractiveInfrastructureError2 = new InneractiveInfrastructureError(InneractiveErrorCode.NATIVE_AD_FAILED_TO_LOAD, com.fyber.inneractive.sdk.flow.i.NATIVE_AD_EMPTY_CONTENT);
            inneractiveInfrastructureError2.setCause(new com.fyber.inneractive.sdk.flow.nativead.mainasset.a(strDescription));
            d dVar = this.f;
            dVar.getClass();
            com.fyber.inneractive.sdk.util.r.f1668a.execute(new com.fyber.inneractive.sdk.flow.e(new com.fyber.inneractive.sdk.flow.f(dVar.b, dVar.f1066a, "send_failed_native_creatives", dVar.g.b()), inneractiveInfrastructureError2));
            dVar.b(inneractiveInfrastructureError2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 742
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.nativead.f.a():void");
    }
}
