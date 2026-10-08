package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f1118a;

    public v(w wVar) {
        this.f1118a = wVar;
    }

    public final void a(com.fyber.inneractive.sdk.network.u uVar, com.fyber.inneractive.sdk.ignite.m mVar) {
        w wVar = this.f1118a;
        InneractiveAdRequest inneractiveAdRequest = wVar.f1126a;
        com.fyber.inneractive.sdk.response.e eVar = wVar.b;
        com.fyber.inneractive.sdk.config.global.r rVar = wVar.c;
        JSONArray jSONArrayB = rVar != null ? rVar.b() : null;
        com.fyber.inneractive.sdk.network.w wVar2 = new com.fyber.inneractive.sdk.network.w(eVar);
        wVar2.c = uVar;
        wVar2.f1220a = inneractiveAdRequest;
        wVar2.d = jSONArrayB;
        JSONObject jSONObject = new JSONObject();
        String strA = mVar.a();
        try {
            jSONObject.put("ignitem", strA);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "ignitem", strA);
        }
        wVar2.f.put(jSONObject);
        wVar2.a((String) null);
    }

    public final void a(com.fyber.inneractive.sdk.network.t tVar, String str, String str2, com.fyber.inneractive.sdk.ignite.m mVar) {
        w wVar = this.f1118a;
        InneractiveAdRequest inneractiveAdRequest = wVar.f1126a;
        com.fyber.inneractive.sdk.response.e eVar = wVar.b;
        com.fyber.inneractive.sdk.config.global.r rVar = wVar.c;
        JSONArray jSONArrayB = rVar != null ? rVar.b() : null;
        com.fyber.inneractive.sdk.network.w wVar2 = new com.fyber.inneractive.sdk.network.w(eVar);
        wVar2.b = tVar;
        wVar2.f1220a = inneractiveAdRequest;
        wVar2.d = jSONArrayB;
        JSONObject jSONObject = new JSONObject();
        if (mVar != null) {
            String strA = mVar.a();
            try {
                jSONObject.put("ignitem", strA);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "ignitem", strA);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.put("message", str);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "message", str);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, str2);
            } catch (Exception unused3) {
                IAlog.f("Got exception adding param to json object: %s, %s", NativeProtocol.BRIDGE_ARG_ERROR_CODE, str2);
            }
        }
        wVar2.f.put(jSONObject);
        wVar2.a((String) null);
    }
}
