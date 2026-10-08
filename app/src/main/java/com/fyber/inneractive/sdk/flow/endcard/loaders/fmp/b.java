package com.fyber.inneractive.sdk.flow.endcard.loaders.fmp;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.endcard.o;
import com.fyber.inneractive.sdk.flow.endcard.p;
import com.fyber.inneractive.sdk.flow.x0;
import com.fyber.inneractive.sdk.network.f0;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.response.g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.v;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f1056a;
    public final o b;
    public final com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a c;
    public final String d;

    public b(o oVar, com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a aVar, String str) {
        this.b = oVar;
        this.f1056a = (p) oVar.f();
        this.c = aVar;
        this.d = str;
    }

    @Override // com.fyber.inneractive.sdk.network.f0
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        if (str != null && exc == null) {
            IAlog.c("%s loaded FMP End-Card icon %s", "IconCallback", this.d);
            p pVar = this.f1056a;
            pVar.k = str;
            pVar.b(this.c);
            return;
        }
        if (TextUtils.isEmpty(this.f1056a.k)) {
            o oVar = this.b;
            IAlog.a("%s sending FMP_COMPANION_FAILED_LOADING event", "IconCallback");
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
            Boolean boolValueOf = Boolean.valueOf(z);
            try {
                jSONObject.put("loaded_from_cache", boolValueOf);
            } catch (Exception unused3) {
                IAlog.f("Got exception adding param to json object: %s, %s", "loaded_from_cache", boolValueOf);
            }
            x0 x0Var = oVar.c;
            t tVar = t.FMP_COMPANION_FAILED_LOADING;
            InneractiveAdRequest inneractiveAdRequest = x0Var.c;
            g gVar = x0Var.d;
            JSONArray jSONArray = x0Var.f;
            w wVar = new w(gVar);
            wVar.b = tVar;
            wVar.f1220a = inneractiveAdRequest;
            wVar.d = jSONArray;
            wVar.f.put(jSONObject);
            wVar.a((String) null);
        }
    }
}
