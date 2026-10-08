package com.fyber.inneractive.sdk.flow.endcard.loaders.fmp;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.endcard.o;
import com.fyber.inneractive.sdk.flow.endcard.p;
import com.fyber.inneractive.sdk.flow.x0;
import com.fyber.inneractive.sdk.network.f0;
import com.fyber.inneractive.sdk.network.g;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.v;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a f1057a;
    public final o b;

    public c(o oVar, com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a aVar) {
        this.b = oVar;
        this.f1057a = aVar;
    }

    @Override // com.fyber.inneractive.sdk.network.f0
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        if (str != null && exc == null) {
            ((p) this.b.f()).e = str.concat("<style>body {margin: 0px; background-color: rgba(0, 0, 0, 0.0);}</style>");
            ((p) this.b.f()).l = z;
            ((p) this.b.f()).b(this.f1057a);
            return;
        }
        if (exc == null || (exc instanceof g) || z) {
            return;
        }
        o oVar = this.b;
        IAlog.a("%s sending FMP_COMPANION_FAILED_LOADING event", "TemplateCallback");
        JSONObject jSONObject = new JSONObject();
        String strA = v.a(exc);
        if (!TextUtils.isEmpty(strA)) {
            try {
                jSONObject.put("error", strA);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "error", strA);
            }
        }
        String strN = oVar.n();
        if (!TextUtils.isEmpty(strN)) {
            try {
                jSONObject.put("version", strN);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "version", strN);
            }
        }
        Boolean bool = Boolean.FALSE;
        try {
            jSONObject.put("loaded_from_cache", bool);
        } catch (Exception unused3) {
            IAlog.f("Got exception adding param to json object: %s, %s", "loaded_from_cache", bool);
        }
        x0 x0Var = oVar.c;
        t tVar = t.FMP_COMPANION_FAILED_LOADING;
        InneractiveAdRequest inneractiveAdRequest = x0Var.c;
        com.fyber.inneractive.sdk.response.g gVar = x0Var.d;
        JSONArray jSONArray = x0Var.f;
        w wVar = new w(gVar);
        wVar.b = tVar;
        wVar.f1220a = inneractiveAdRequest;
        wVar.d = jSONArray;
        wVar.f.put(jSONObject);
        wVar.a((String) null);
    }
}
