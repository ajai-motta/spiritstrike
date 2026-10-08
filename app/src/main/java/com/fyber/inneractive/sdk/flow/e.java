package com.fyber.inneractive.sdk.flow;

import android.app.Application;
import android.content.SharedPreferences;
import com.facebook.internal.NativeProtocol;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInfrastructureError f1041a;
    public final /* synthetic */ f b;

    public e(f fVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
        this.b = fVar;
        this.f1041a = inneractiveInfrastructureError;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String string;
        com.fyber.inneractive.sdk.response.e eVar = this.b.b;
        if (eVar == null || (str = eVar.h) == null) {
            return;
        }
        Map map = eVar.r;
        if (map == null && eVar.s == null) {
            return;
        }
        com.fyber.inneractive.sdk.config.o oVar = IAConfigManager.O.u.b;
        String strA = oVar.a("max_failed_creatives_interval_hours", f.e);
        String strA2 = oVar.a("max_failed_creatives_per_interval", f.f);
        int iA = com.fyber.inneractive.sdk.util.v.a(strA, 24);
        int iA2 = com.fyber.inneractive.sdk.util.v.a(strA2, 1);
        Application application = com.fyber.inneractive.sdk.util.o.f1662a;
        if (application != null) {
            SharedPreferences sharedPreferences = application.getSharedPreferences("IAConfigPrefs", 0);
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray = new JSONArray(sharedPreferences.getString("lt", "[]"));
            } catch (JSONException unused) {
            }
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            if (oVar.a(false, this.b.f1152a) && !com.fyber.inneractive.sdk.metrics.a.a(iA, iA2, jSONArray, copyOnWriteArrayList)) {
                copyOnWriteArrayList.add(Long.valueOf(System.currentTimeMillis()));
                if (map != null) {
                    try {
                        string = new JSONObject(map).toString();
                    } catch (Throwable unused2) {
                        string = "";
                    }
                } else {
                    string = this.b.b.s;
                }
                f fVar = this.b;
                InneractiveAdRequest inneractiveAdRequest = fVar.c;
                com.fyber.inneractive.sdk.response.e eVar2 = fVar.b;
                InneractiveInfrastructureError inneractiveInfrastructureError = this.f1041a;
                JSONArray jSONArray2 = fVar.d;
                com.fyber.inneractive.sdk.network.t tVar = com.fyber.inneractive.sdk.network.t.IA_AD_FAILURE_DATA;
                com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(eVar2);
                wVar.b = tVar;
                wVar.f1220a = inneractiveAdRequest;
                wVar.d = jSONArray2;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("raw_response", str);
                } catch (Exception unused3) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "raw_response", str);
                }
                try {
                    jSONObject.put("headers", string);
                } catch (Exception unused4) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "headers", string);
                }
                String strDescription = inneractiveInfrastructureError.description();
                try {
                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, strDescription);
                } catch (Exception unused5) {
                    IAlog.f("Got exception adding param to json object: %s, %s", NativeProtocol.BRIDGE_ARG_ERROR_CODE, strDescription);
                }
                wVar.f.put(jSONObject);
                wVar.a((String) null);
            }
            sharedPreferences.edit().putString("lt", new JSONArray((Collection) copyOnWriteArrayList).toString()).apply();
        }
    }
}
