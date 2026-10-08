package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p7 extends com.applovin.impl.sdk.ad.b implements q4 {
    private final String n;
    private final String o;
    private final y7 p;
    private final long q;
    private final c8 r;
    private final s7 s;
    private final String t;
    private final r7 u;
    private final l4 v;
    private final Set w;
    private final Set x;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f560a;
        private JSONObject b;
        private com.applovin.impl.sdk.k c;
        private long d;
        private String e;
        private String f;
        private y7 g;
        private c8 h;
        private s7 i;
        private r7 j;
        private Set k;
        private Set l;

        public b b(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.b = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No full ad response specified.");
        }

        public b b(String str) {
            this.e = str;
            return this;
        }

        public b b(Set set) {
            this.k = set;
            return this;
        }

        public b a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f560a = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No ad object specified.");
        }

        public b a(com.applovin.impl.sdk.k kVar) {
            if (kVar != null) {
                this.c = kVar;
                return this;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }

        public b a(String str) {
            this.f = str;
            return this;
        }

        public b a(y7 y7Var) {
            this.g = y7Var;
            return this;
        }

        public b a(c8 c8Var) {
            this.h = c8Var;
            return this;
        }

        public b a(s7 s7Var) {
            this.i = s7Var;
            return this;
        }

        public b a(r7 r7Var) {
            this.j = r7Var;
            return this;
        }

        public b a(Set set) {
            this.l = set;
            return this;
        }

        public b a(long j) {
            this.d = j;
            return this;
        }

        public p7 a() {
            return new p7(this);
        }
    }

    public enum c {
        COMPANION_AD,
        VIDEO
    }

    public enum d {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        INDUSTRY_ICON_IMPRESSION,
        INDUSTRY_ICON_CLICK,
        ERROR
    }

    private Set h1() {
        s7 s7Var = this.s;
        return s7Var != null ? s7Var.b() : Collections.emptySet();
    }

    private String k1() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    private Set o1() {
        c8 c8Var = this.r;
        return c8Var != null ? c8Var.b() : Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List s(i5 i5Var) {
        return o7.a(i5Var.a("vimp_urls", new JSONObject()), getClCode(), null, k1(), J(), N0(), this.sdk);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public List A() {
        List listA;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.p7$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.s((i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = o7.a(getJsonObjectFromAdObject("vimp_urls", new JSONObject()), getClCode(), null, k1(), J(), N0(), this.sdk);
        }
        return listA;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean B0() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE) && f1() != null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean C0() {
        return getBooleanFromAdObject("vast_is_streaming", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public void E0() {
    }

    @Override // com.applovin.impl.sdk.ad.b
    public String I() {
        return this.t;
    }

    public Set a(d dVar, String str) {
        return a(dVar, new String[]{str});
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri c0() {
        return f1();
    }

    public void d(String str) {
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            i5Var.b("html_template", str);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html_template", str);
        }
    }

    public r7 e1() {
        return this.u;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p7) || !super.equals(obj)) {
            return false;
        }
        p7 p7Var = (p7) obj;
        String str = this.n;
        if (str == null ? p7Var.n != null : !str.equals(p7Var.n)) {
            return false;
        }
        String str2 = this.o;
        if (str2 == null ? p7Var.o != null : !str2.equals(p7Var.o)) {
            return false;
        }
        y7 y7Var = this.p;
        if (y7Var == null ? p7Var.p != null : !y7Var.equals(p7Var.p)) {
            return false;
        }
        c8 c8Var = this.r;
        if (c8Var == null ? p7Var.r != null : !c8Var.equals(p7Var.r)) {
            return false;
        }
        s7 s7Var = this.s;
        if (s7Var == null ? p7Var.s != null : !s7Var.equals(p7Var.s)) {
            return false;
        }
        r7 r7Var = this.u;
        if (r7Var == null ? p7Var.u != null : !r7Var.equals(p7Var.u)) {
            return false;
        }
        Set set = this.w;
        if (set == null ? p7Var.w != null : !set.equals(p7Var.w)) {
            return false;
        }
        Set set2 = this.x;
        Set set3 = p7Var.x;
        return set2 != null ? set2.equals(set3) : set3 == null;
    }

    public Uri f1() {
        c8 c8Var = this.r;
        if (c8Var != null) {
            return c8Var.c();
        }
        return null;
    }

    public s7 g1() {
        return this.s;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getCreatedAtMillis() {
        return this.q;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        return this.fullResponse;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean hasVideoUrl() {
        List listG;
        c8 c8Var = this.r;
        return (c8Var == null || (listG = c8Var.g()) == null || listG.size() <= 0) ? false : true;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.n;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.o;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        y7 y7Var = this.p;
        int iHashCode4 = (iHashCode3 + (y7Var != null ? y7Var.hashCode() : 0)) * 31;
        c8 c8Var = this.r;
        int iHashCode5 = (iHashCode4 + (c8Var != null ? c8Var.hashCode() : 0)) * 31;
        s7 s7Var = this.s;
        int iHashCode6 = (iHashCode5 + (s7Var != null ? s7Var.hashCode() : 0)) * 31;
        r7 r7Var = this.u;
        int iHashCode7 = (iHashCode6 + (r7Var != null ? r7Var.hashCode() : 0)) * 31;
        Set set = this.w;
        int iHashCode8 = (iHashCode7 + (set != null ? set.hashCode() : 0)) * 31;
        Set set2 = this.x;
        return iHashCode8 + (set2 != null ? set2.hashCode() : 0);
    }

    public String i1() {
        return getStringFromAdObject("html_template", "");
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.e4
    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", Boolean.TRUE) && this.u != null;
    }

    public c j1() {
        return "companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad")) ? c.COMPANION_AD : c.VIDEO;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri l0() {
        d8 d8VarQ1 = q1();
        if (d8VarQ1 != null) {
            return d8VarQ1.e();
        }
        return null;
    }

    public v7 l1() {
        c8 c8Var = this.r;
        if (c8Var != null) {
            return c8Var.f();
        }
        return null;
    }

    public long m1() {
        return getLongFromAdObject("real_close_delay", 0L);
    }

    public y7 n1() {
        return this.p;
    }

    public c8 p1() {
        return this.r;
    }

    public d8 q1() {
        Long lF = r0.f(this.sdk);
        return this.r.a(lF != null ? lF.longValue() : 0L);
    }

    public boolean r1() {
        return l1() != null;
    }

    public boolean s1() {
        return getBooleanFromAdObject("vast_immediate_ad_load", Boolean.TRUE);
    }

    public void t1() {
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            i5Var.c("vast_is_streaming");
            return;
        }
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public String toString() {
        return "VastAd{title='" + this.n + "', adDescription='" + this.o + "', systemInfo=" + this.p + ", videoCreative=" + this.r + ", companionAd=" + this.s + ", adVerifications=" + this.u + ", impressionTrackers=" + this.w + ", errorTrackers=" + this.x + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean u1() {
        return getBooleanFromAdObject("cache_companion_ad", Boolean.TRUE);
    }

    public boolean v1() {
        return getBooleanFromAdObject("cache_video", Boolean.TRUE);
    }

    public boolean w1() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", Boolean.FALSE);
    }

    public boolean x1() {
        return getBooleanFromAdObject("iopms", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean y0() {
        return getBooleanFromFullResponse("is_persisted_ad", false);
    }

    public boolean y1() {
        return getBooleanFromAdObject("iopmsfsr", Boolean.TRUE);
    }

    private p7(b bVar) {
        super(bVar.f560a, bVar.b, bVar.c);
        this.n = bVar.e;
        this.p = bVar.g;
        this.o = bVar.f;
        this.r = bVar.h;
        this.s = bVar.i;
        this.u = bVar.j;
        this.w = bVar.k;
        this.x = bVar.l;
        this.v = new l4(this);
        Uri uriL0 = l0();
        if (uriL0 != null) {
            this.t = uriL0.toString();
        } else {
            this.t = "";
        }
        this.q = bVar.d;
    }

    public Set a(d dVar, String[] strArr) {
        this.sdk.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.sdk.O().a("VastAd", "Retrieving trackers of type '" + dVar + "' and events '" + Arrays.toString(strArr) + "'...");
        }
        if (dVar == d.IMPRESSION) {
            return this.w;
        }
        if (dVar == d.VIDEO_CLICK) {
            return o1();
        }
        if (dVar == d.COMPANION_CLICK) {
            return h1();
        }
        if (dVar == d.VIDEO) {
            return a(c.VIDEO, strArr);
        }
        if (dVar == d.COMPANION) {
            return a(c.COMPANION_AD, strArr);
        }
        if (dVar == d.INDUSTRY_ICON_CLICK) {
            return l1().b();
        }
        if (dVar == d.INDUSTRY_ICON_IMPRESSION) {
            return l1().f();
        }
        if (dVar == d.ERROR) {
            return this.x;
        }
        this.sdk.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.sdk.O().b("VastAd", "Failed to retrieve trackers of invalid type '" + dVar + "' and events '" + Arrays.toString(strArr) + "'");
        }
        return Collections.emptySet();
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.e4
    public l4 getAdEventTracker() {
        return this.v;
    }

    private Set a(c cVar, String[] strArr) {
        Map mapD;
        s7 s7Var;
        c8 c8Var;
        if (strArr != null && strArr.length > 0) {
            if (cVar == c.VIDEO && (c8Var = this.r) != null) {
                mapD = c8Var.e();
            } else {
                mapD = (cVar != c.COMPANION_AD || (s7Var = this.s) == null) ? null : s7Var.d();
            }
            HashSet hashSet = new HashSet();
            if (mapD != null && !mapD.isEmpty()) {
                for (String str : strArr) {
                    if (mapD.containsKey(str)) {
                        hashSet.addAll((Collection) mapD.get(str));
                    }
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    public static p7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "full_response", (JSONObject) null);
        if (jSONObject2 == null) {
            return null;
        }
        bVar.b = jSONObject2;
        JSONObject jSONObject3 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject2, "ads", new JSONArray()), 0, (JSONObject) null);
        if (jSONObject3 == null) {
            return null;
        }
        bVar.f560a = jSONObject3;
        bVar.c = kVar;
        bVar.d = JsonUtils.getLong(jSONObject, "created_at_millis", 0L);
        bVar.e = JsonUtils.getString(jSONObject, "title", "");
        bVar.f = JsonUtils.getString(jSONObject, "ad_description", "");
        bVar.g = y7.a(JsonUtils.getJSONObject(jSONObject, "system_info", (JSONObject) null), kVar);
        bVar.h = c8.a(JsonUtils.getJSONObject(jSONObject, "video_creative", (JSONObject) null), kVar);
        bVar.i = s7.a(JsonUtils.getJSONObject(jSONObject, "companion_ad", (JSONObject) null), kVar);
        bVar.j = r7.a(JsonUtils.getJSONObject(jSONObject, "ad_verifications", (JSONObject) null), kVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "impression_trackers", new JSONArray());
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            z7 z7VarA = z7.a(JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), kVar);
            if (z7VarA != null) {
                hashSet.add(z7VarA);
            }
        }
        bVar.k = hashSet;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "error_trackers", new JSONArray());
        HashSet hashSet2 = new HashSet();
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            z7 z7VarA2 = z7.a(JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null), kVar);
            if (z7VarA2 != null) {
                hashSet2.add(z7VarA2);
            }
        }
        bVar.l = hashSet2;
        p7 p7Var = new p7(bVar);
        JSONObject jSONObject4 = JsonUtils.getJSONObject(jSONObject, "cached_ad_html_resources_urls", new JSONObject());
        Iterator<String> itKeys = jSONObject4.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String string = JsonUtils.getString(jSONObject4, next, null);
            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                p7Var.a(next, string);
            }
        }
        return p7Var;
    }

    @Override // com.applovin.impl.q4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putLong(jSONObject, "created_at_millis", this.q);
        JsonUtils.putString(jSONObject, "title", this.n);
        JsonUtils.putString(jSONObject, "ad_description", this.o);
        y7 y7Var = this.p;
        if (y7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "system_info", y7Var.a());
        }
        c8 c8Var = this.r;
        if (c8Var != null) {
            JsonUtils.putJSONObject(jSONObject, "video_creative", c8Var.a());
        }
        s7 s7Var = this.s;
        if (s7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "companion_ad", s7Var.a());
        }
        r7 r7Var = this.u;
        if (r7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "ad_verifications", r7Var.a());
        }
        if (this.w != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                jSONArray.put(((z7) it.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "impression_trackers", jSONArray);
        }
        if (this.x != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = this.x.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(((z7) it2.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "error_trackers", jSONArray2);
        }
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry entry : l().entrySet()) {
            JsonUtils.putString(jSONObject2, (String) entry.getKey(), (String) entry.getValue());
        }
        JsonUtils.putJSONObject(jSONObject, "cached_ad_html_resources_urls", jSONObject2);
        i5 i5Var = this.synchronizedFullResponse;
        if (i5Var != null) {
            JsonUtils.putJSONObject(jSONObject, "full_response", i5Var.a());
        } else {
            synchronized (this.fullResponseLock) {
                JsonUtils.putJSONObject(jSONObject, "full_response", this.fullResponse);
            }
        }
        return jSONObject;
    }
}
