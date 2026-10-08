package com.fyber.inneractive.sdk.flow.endcard.loaders.companion;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.endcard.v;
import com.fyber.inneractive.sdk.flow.endcard.w;
import com.fyber.inneractive.sdk.flow.x0;
import com.fyber.inneractive.sdk.model.vast.k;
import com.fyber.inneractive.sdk.network.d1;
import com.fyber.inneractive.sdk.network.f0;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.response.g;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f1054a;
    public final com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a b;
    public final v c;
    public final /* synthetic */ e d;

    public d(e eVar, v vVar, com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a aVar) {
        this.d = eVar;
        this.c = vVar;
        this.f1054a = (w) vVar.f();
        this.b = aVar;
    }

    @Override // com.fyber.inneractive.sdk.network.f0
    public final void a(Object obj, Exception exc, boolean z) {
        boolean zEqualsIgnoreCase;
        Bitmap bitmap;
        d1 d1Var = (d1) obj;
        if (exc == null && d1Var != null && d1Var.b == null && (bitmap = d1Var.f1196a) != null) {
            w wVar = this.f1054a;
            Bitmap bitmap2 = wVar.c;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            wVar.c = bitmap;
            wVar.d.setImageBitmap(bitmap);
            e eVar = this.d;
            v vVar = this.c;
            eVar.getClass();
            JSONObject jSONObject = new JSONObject();
            String string = vVar.g.a().toString();
            try {
                jSONObject.put("companion_data", string);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "companion_data", string);
            }
            x0 x0Var = vVar.c;
            u uVar = u.VAST_COMPANION_LOADED;
            InneractiveAdRequest inneractiveAdRequest = x0Var.c;
            g gVar = x0Var.d;
            JSONArray jSONArray = x0Var.f;
            com.fyber.inneractive.sdk.network.w wVar2 = new com.fyber.inneractive.sdk.network.w(gVar);
            wVar2.c = uVar;
            wVar2.f1220a = inneractiveAdRequest;
            wVar2.d = jSONArray;
            wVar2.f.put(jSONObject);
            wVar2.a((String) null);
            this.b.a();
            return;
        }
        String str = d1Var != null ? d1Var.b : null;
        e eVar2 = this.d;
        v vVar2 = this.c;
        eVar2.getClass();
        IAlog.a("%s sending VAST_COMPANION_FAILED_LOADING event", "StaticCompanionEndCardLoader");
        JSONObject jSONObject2 = new JSONObject();
        String strA = TextUtils.isEmpty(str) ? com.fyber.inneractive.sdk.util.v.a(exc) : str;
        if (!TextUtils.isEmpty(strA)) {
            try {
                jSONObject2.put("reason", strA);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "reason", strA);
            }
        }
        JSONObject jSONObjectA = vVar2.g.a();
        try {
            jSONObject2.put("companion_data", jSONObjectA);
        } catch (Exception unused3) {
            IAlog.f("Got exception adding param to json object: %s, %s", "companion_data", jSONObjectA);
        }
        x0 x0Var2 = vVar2.c;
        t tVar = t.VAST_COMPANION_FAILED_LOADING;
        InneractiveAdRequest inneractiveAdRequest2 = x0Var2.c;
        g gVar2 = x0Var2.d;
        JSONArray jSONArray2 = x0Var2.f;
        com.fyber.inneractive.sdk.network.w wVar3 = new com.fyber.inneractive.sdk.network.w(gVar2);
        wVar3.b = tVar;
        wVar3.f1220a = inneractiveAdRequest2;
        wVar3.d = jSONArray2;
        wVar3.f.put(jSONObject2);
        wVar3.a((String) null);
        this.b.a(str);
        v vVar3 = this.c;
        String str2 = vVar3.g.f;
        k kVar = vVar3.h;
        if (!TextUtils.isEmpty(str2)) {
            String strSubstring = str2.substring(str2.lastIndexOf(46) + 1);
            if (kVar.extension.equalsIgnoreCase(strSubstring)) {
                return;
            }
            k kVar2 = k.Jpeg;
            if (kVar == kVar2) {
                zEqualsIgnoreCase = k.Jpg.extension.equalsIgnoreCase(strSubstring);
            } else if (kVar == k.Jpg) {
                zEqualsIgnoreCase = kVar2.extension.equalsIgnoreCase(strSubstring);
            }
            if (zEqualsIgnoreCase) {
                return;
            }
        }
        x0 x0Var3 = this.c.c;
        t tVar2 = t.VAST_COMPANION_INCOMPATIBLE_MIMETYPE;
        InneractiveAdRequest inneractiveAdRequest3 = x0Var3.c;
        g gVar3 = x0Var3.d;
        JSONArray jSONArray3 = x0Var3.f;
        com.fyber.inneractive.sdk.network.w wVar4 = new com.fyber.inneractive.sdk.network.w(gVar3);
        wVar4.b = tVar2;
        wVar4.f1220a = inneractiveAdRequest3;
        wVar4.d = jSONArray3;
        wVar4.a((String) null);
    }
}
