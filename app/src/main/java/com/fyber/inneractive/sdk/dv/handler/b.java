package com.fyber.inneractive.sdk.dv.handler;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.network.x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends QueryInfoGenerationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f993a;

    public b(c cVar) {
        this.f993a = cVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        c cVar = this.f993a;
        e eVar = cVar.b;
        if (eVar.b) {
            return;
        }
        AdFormat adFormat = cVar.f994a;
        eVar.getClass();
        IAlog.a("Firing Event 1000 - Fetch error DV - msg  " + str, new Object[0]);
        w wVar = new w(t.FETCH_TOKEN_DV_ERROR, (InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null);
        wVar.f.put(new x().a(str, "message").a(e.b(), "version").a(adFormat.name(), "adFormat").a(Integer.valueOf(eVar.d), "success_count").f1221a);
        wVar.a((String) null);
        this.f993a.b.b = true;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        IAlog.a("DVHanlder - %s - put query: %s", this.f993a.f994a.toString(), queryInfo.getQuery());
        synchronized (this.f993a.b.c) {
            c cVar = this.f993a;
            e eVar = cVar.b;
            eVar.d++;
            eVar.f996a.put(cVar.f994a, queryInfo);
        }
    }
}
