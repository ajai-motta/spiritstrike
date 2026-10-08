package com.fyber.inneractive.sdk.flow;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1127a;
    public final t0 b;
    public final InneractiveAdRequest c;
    public final com.fyber.inneractive.sdk.response.g d;
    public final com.fyber.inneractive.sdk.model.vast.b e;
    public final JSONArray f;
    public final com.fyber.inneractive.sdk.config.global.features.u g;

    public x0(Context context, t0 t0Var) {
        com.fyber.inneractive.sdk.config.global.features.u uVar;
        JSONArray jSONArrayB;
        com.fyber.inneractive.sdk.config.global.r rVar = t0Var.c;
        InneractiveAdRequest inneractiveAdRequest = t0Var.f1126a;
        com.fyber.inneractive.sdk.response.g gVar = (com.fyber.inneractive.sdk.response.g) t0Var.b;
        com.fyber.inneractive.sdk.model.vast.b bVar = gVar.O;
        if (rVar != null) {
            uVar = (com.fyber.inneractive.sdk.config.global.features.u) rVar.a(com.fyber.inneractive.sdk.config.global.features.u.class);
            jSONArrayB = rVar.b();
        } else {
            uVar = null;
            jSONArrayB = null;
        }
        this.f1127a = context;
        this.b = t0Var;
        this.c = inneractiveAdRequest;
        this.d = gVar;
        this.e = bVar;
        this.g = uVar;
        this.f = jSONArrayB;
    }
}
