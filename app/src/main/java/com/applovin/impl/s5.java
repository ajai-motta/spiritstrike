package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.network.a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v4;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import io.ktor.http.ContentDisposition;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s5 extends j5 {
    protected final u g;
    private final String h;

    public s5(u uVar, String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
        this.g = uVar;
        this.h = kVar.b();
    }

    private Map g() {
        HashMap map = new HashMap(3);
        map.put("AppLovin-Zone-Id", this.g.e());
        if (this.g.f() != null) {
            map.put("AppLovin-Ad-Size", this.g.f().getLabel());
        }
        if (this.g.g() != null) {
            map.put("AppLovin-Ad-Type", this.g.g().getLabel());
        }
        return map;
    }

    protected abstract j5 a(JSONObject jSONObject);

    protected void a(int i, String str) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Unable to fetch " + this.g + " ad: server returned " + i);
        }
        this.f428a.g().a(d2.y, this.g, new AppLovinError(i, str));
    }

    protected void b(JSONObject jSONObject) {
        r0.c(jSONObject, this.f428a);
        r0.b(jSONObject, this.f428a);
        r0.a(jSONObject, this.f428a);
        u.a(jSONObject);
        this.f428a.r0().a(a(jSONObject));
    }

    protected abstract String e();

    protected abstract String f();

    protected Map h() {
        HashMap map = new HashMap(4);
        map.put(AppLovinUtils.ServerParameterKeys.ZONE_ID, this.g.e());
        if (this.g.f() != null) {
            map.put(ContentDisposition.Parameters.Size, this.g.f().getLabel());
        }
        if (this.g.g() != null) {
            map.put("require", this.g.g().getLabel());
        }
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        v4.a aVarA;
        Map map;
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Fetching next ad of zone: " + this.g);
        }
        if (((Boolean) this.f428a.a(y4.Y3)).booleanValue() && o7.j() && com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "User is connected to a VPN");
        }
        o7.a(this.f428a, this.b);
        this.f428a.g().a(d2.w, this.g, (AppLovinError) null);
        try {
            JSONObject andResetCustomPostBody = this.f428a.k().getAndResetCustomPostBody();
            String str = "POST";
            if (((Boolean) this.f428a.a(y4.m3)).booleanValue()) {
                aVarA = v4.a.a(((Integer) this.f428a.a(y4.t5)).intValue());
                JSONObject jSONObject = new JSONObject(this.f428a.A().a(h(), false, true));
                map = new HashMap();
                if (!((Boolean) this.f428a.a(y4.E5)).booleanValue() && !((Boolean) this.f428a.a(y4.A5)).booleanValue()) {
                    map.put("rid", UUID.randomUUID().toString());
                }
                if (!((Boolean) this.f428a.a(y4.l5)).booleanValue()) {
                    map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f428a.j0());
                }
                JsonUtils.putAll(jSONObject, andResetCustomPostBody);
                andResetCustomPostBody = jSONObject;
            } else {
                v4.a aVarA2 = v4.a.a(((Integer) this.f428a.a(y4.u5)).intValue());
                Map mapA = o7.a(this.f428a.A().a(h(), false, false));
                if (!((Boolean) this.f428a.a(y4.N6)).booleanValue()) {
                    mapA.remove("video_decoders");
                }
                if (andResetCustomPostBody == null) {
                    str = "GET";
                    andResetCustomPostBody = null;
                }
                aVarA = aVarA2;
                map = mapA;
            }
            if (o7.h(a()) || o7.j(a())) {
                map.putAll(this.f428a.k().getAndResetCustomQueryParams());
            }
            if (StringUtils.isValidString(this.h)) {
                map.put("sts", this.h);
            }
            a.C0161a c0161aF = com.applovin.impl.sdk.network.a.a(this.f428a).b(f()).a(e()).b(map).c(str).a(g()).a((Object) new JSONObject()).a(((Integer) this.f428a.a(y4.b3)).intValue()).c(((Boolean) this.f428a.a(y4.c3)).booleanValue()).d(((Boolean) this.f428a.a(y4.d3)).booleanValue()).c(((Integer) this.f428a.a(y4.a3)).intValue()).a(aVarA).f(true);
            if (andResetCustomPostBody != null) {
                c0161aF.a(andResetCustomPostBody);
                c0161aF.b(((Boolean) this.f428a.a(y4.O5)).booleanValue());
            }
            a aVar = new a(c0161aF.a(), this.f428a);
            aVar.c(y4.q0);
            aVar.b(y4.r0);
            this.f428a.r0().a(aVar);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to fetch ad for zone id: " + this.g, th);
            }
            a(0, th.getMessage());
        }
    }

    class a extends m6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            if (i == 200) {
                JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.l.a());
                JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.l.b());
                HashMap map = new HashMap(5);
                CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
                CollectionUtils.putStringIfValid("code", String.valueOf(i), map);
                CollectionUtils.putStringIfValid("ad_zone_id", s5.this.g.e(), map);
                CollectionUtils.putStringIfValid("latency_ms", String.valueOf(this.l.a()), map);
                CollectionUtils.putStringIfValid("response_size", String.valueOf(this.l.b()), map);
                this.f428a.g().d(d2.x, map);
                s5.this.b(jSONObject);
                return;
            }
            s5.this.a(i, MaxAdapterError.NO_FILL.getErrorMessage());
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            s5.this.a(i, str2);
            this.f428a.D().a("fetchAd", str, i, str2);
        }
    }
}
