package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c6 extends j5 {
    private final String g;
    private final List h;
    private final k3 i;
    private final Map j;
    private final Map k;
    private final Map l;
    private final MaxError m;

    public c6(String str, List list, Map map, Map map2, MaxError maxError, k3 k3Var, com.applovin.impl.sdk.k kVar, boolean z) {
        super("TaskFireMediationPostbacks", kVar);
        this.g = str + "_urls";
        this.h = list;
        this.j = o7.a(map, kVar);
        this.k = map2 == null ? new HashMap() : map2;
        this.m = maxError != null ? maxError : new MaxErrorImpl(-1);
        this.i = k3Var;
        HashMap map3 = new HashMap(7);
        map3.put("AppLovin-Event-Type", str);
        if (z && k3Var != null) {
            map3.put("AppLovin-Ad-Network-Name", k3Var.c());
        }
        if (k3Var instanceof y2) {
            y2 y2Var = (y2) k3Var;
            map3.put("AppLovin-Ad-Unit-Id", y2Var.getAdUnitId());
            map3.put("AppLovin-Ad-Format", y2Var.getFormat().getLabel());
            if (z) {
                map3.put("AppLovin-Third-Party-Ad-Placement-Id", y2Var.P());
            }
        }
        if (maxError != null) {
            map3.put("AppLovin-Error-Code", String.valueOf(maxError.getCode()));
            map3.put("AppLovin-Error-Message", maxError.getMessage());
        }
        this.l = map3;
    }

    private void a(String str, Map map) {
        b().f0().e(com.applovin.impl.sdk.network.d.b().d(str).c("POST").a(this.l).a(false).c(map).c(((Boolean) this.f428a.a(r3.E8)).booleanValue()).a());
    }

    private String b(String str, Map map) {
        for (String str2 : map.keySet()) {
            str = str.replace(str2, StringUtils.emptyIfNull((String) map.get(str2)));
        }
        return str;
    }

    private Map e() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) this.f428a.a(r3.A7)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    private List f() {
        List list = this.h;
        if (list != null) {
            return list;
        }
        k3 k3Var = this.i;
        if (k3Var != null) {
            return k3Var.b(this.g);
        }
        return null;
    }

    private h g() {
        k3 k3Var = this.i;
        if (k3Var instanceof y2) {
            return ((y2) k3Var).L().f();
        }
        if (k3Var instanceof e5) {
            return ((e5) k3Var).u().f();
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVarG;
        List listF = f();
        if (CollectionUtils.isEmpty(listF)) {
            return;
        }
        Map mapE = e();
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            Uri uri = Uri.parse(a(b((String) it.next(), this.j), this.m));
            Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
            HashMap map = new HashMap(this.k);
            for (String str : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(str);
                if (mapE.containsKey(queryParameter)) {
                    k3 k3Var = this.i;
                    if (k3Var != null) {
                        map.put(str, k3Var.a((String) mapE.get(queryParameter)));
                    }
                } else {
                    builderClearQuery.appendQueryParameter(str, queryParameter);
                }
            }
            map.putAll(this.f428a.A().e());
            if (((Boolean) this.f428a.a(r3.x8)).booleanValue() && (hVarG = g()) != null) {
                map.put("arn_info", hVarG.e());
            }
            a(builderClearQuery.build().toString(), map);
        }
    }

    private String a(String str, MaxError maxError) {
        int mediatedNetworkErrorCode;
        String mediatedNetworkErrorMessage;
        if (!(maxError instanceof MaxAdapterError)) {
            mediatedNetworkErrorCode = 0;
            mediatedNetworkErrorMessage = "";
        } else {
            MaxAdapterError maxAdapterError = (MaxAdapterError) maxError;
            mediatedNetworkErrorCode = maxAdapterError.getMediatedNetworkErrorCode();
            mediatedNetworkErrorMessage = maxAdapterError.getMediatedNetworkErrorMessage();
        }
        return str.replace("{ERROR_CODE}", String.valueOf(maxError.getCode())).replace("{ERROR_MESSAGE}", StringUtils.encodeUriString(maxError.getMessage())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(mediatedNetworkErrorCode)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", StringUtils.encodeUriString(mediatedNetworkErrorMessage));
    }
}
