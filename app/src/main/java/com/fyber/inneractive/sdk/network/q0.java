package com.fyber.inneractive.sdk.network;

import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hive.base.Android;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 extends t0 implements o {
    public final InneractiveAdRequest p;
    public HashMap q;
    public StringBuffer r;
    public final com.fyber.inneractive.sdk.serverapi.d s;
    public com.fyber.inneractive.sdk.dv.j t;
    public boolean u;
    public final com.fyber.inneractive.sdk.network.timeouts.request.a v;

    public q0(q qVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.config.global.r rVar) {
        com.fyber.inneractive.sdk.serverapi.c cVar = new com.fyber.inneractive.sdk.serverapi.c(rVar);
        super(qVar, g0.c.a(), rVar);
        this.t = null;
        this.u = false;
        this.o = true;
        this.p = inneractiveAdRequest;
        this.s = cVar;
        if (inneractiveAdRequest != null) {
            String strA = com.fyber.inneractive.sdk.util.n1.a(inneractiveAdRequest.getSpotId());
            String mediationName = inneractiveAdRequest.getMediationName();
            com.fyber.inneractive.sdk.config.global.features.j jVar = (com.fyber.inneractive.sdk.config.global.features.j) rVar.a(com.fyber.inneractive.sdk.config.global.features.j.class);
            this.v = TextUtils.isEmpty(mediationName) ? new com.fyber.inneractive.sdk.network.timeouts.request.b(jVar, strA) : new com.fyber.inneractive.sdk.network.timeouts.request.d(strA, jVar, mediationName);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.o
    public final StringBuffer a() {
        return this.r;
    }

    @Override // com.fyber.inneractive.sdk.network.o
    public final Map b() {
        return this.q;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final void c(long j) {
        super.c(j);
        IAlog.a("%s : NetworkRequestAd : set start connection timestamp", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final void d() {
        super.d();
        IAlog.a("%s : NetworkRequestAd cancel by timeout - resolve request with no fill", IAlog.a(this));
        this.f1217a = true;
        a((Object) null, (Exception) new k1("no fill", 204), false);
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final byte[] f() {
        JSONArray jSONArrayA;
        byte[] bytes = new byte[0];
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            com.fyber.inneractive.sdk.config.global.r rVar = ((com.fyber.inneractive.sdk.serverapi.c) this.s).f1623a;
            if (rVar != null) {
                jSONArrayA = com.fyber.inneractive.sdk.config.global.g.a(rVar.b, true);
                IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", jSONArrayA);
            } else {
                jSONArrayA = null;
            }
            if (jSONArrayA != null && jSONArrayA.length() > 0) {
                jSONObject2.put("experiments", jSONArrayA);
                jSONObject.put("sdk_experiments", jSONObject2);
            }
            UnitDisplayType unitDisplayTypeA = com.fyber.inneractive.sdk.serverapi.b.a(this.p.getSpotId());
            IAConfigManager iAConfigManager = IAConfigManager.O;
            JSONArray jSONArrayA2 = iAConfigManager.x.a(unitDisplayTypeA);
            if (jSONArrayA2 != null && jSONArrayA2.length() > 0) {
                jSONObject.put("user_sessions", jSONArrayA2);
            }
            int iA = iAConfigManager.u.b.a("dv_enabled_v3", 0, 0);
            if (unitDisplayTypeA != null && iA == 1) {
                com.fyber.inneractive.sdk.dv.j jVarA = iAConfigManager.G.a(unitDisplayTypeA);
                this.t = jVarA;
                if (jVarA != null) {
                    jSONObject.put("gdem_signal", jVarA.f1001a.getQuery());
                }
            }
            com.fyber.inneractive.sdk.topics.b bVar = iAConfigManager.F;
            if (bVar != null && IAConfigManager.f()) {
                Object objB = bVar.b();
                if (objB != null) {
                    jSONObject.put("topics", objB);
                }
                Object objA = bVar.a();
                if (objA != null) {
                    jSONObject.put("encrypted_topics", objA);
                }
            }
            String string = jSONObject.toString();
            bytes = string.getBytes(StandardCharsets.UTF_8);
            IAlog.a("request json body - %s", string);
            IAlog.d("request json body - %s", string);
            return bytes;
        } catch (Exception unused) {
            IAlog.a("Failed building body for ad request!", new Object[0]);
            return bytes;
        }
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final int g() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final int j() {
        return q();
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final Map l() {
        int i = com.fyber.inneractive.sdk.config.k.f959a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.response");
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("mockadnetworkresponseid", property);
        IAlog.a("NetworkRequestAd: Adding mock response header - %s", property);
        return map;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final m0 m() {
        return m0.POST;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final g1 o() {
        return g1.HIGH;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final l1 p() {
        com.fyber.inneractive.sdk.network.timeouts.request.a aVar = this.v;
        return new l1(aVar.i, aVar.h);
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final String r() {
        String str;
        String str2;
        String str3;
        int i = com.fyber.inneractive.sdk.config.k.f959a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        if (TextUtils.isEmpty(property)) {
            str = "https://" + IAConfigManager.O.i.e;
        } else if (Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(property).matches()) {
            str = "https://" + property + "/simpleM2M/clientRequestEnhancedXmlAd";
        } else {
            str = "https://" + property + ".inner-active.mobi/simpleM2M/clientRequestEnhancedXmlAd";
        }
        InneractiveAdRequest inneractiveAdRequest = this.p;
        com.fyber.inneractive.sdk.serverapi.d dVar = this.s;
        r0 r0Var = new r0(inneractiveAdRequest, dVar);
        r0Var.f1215a = new HashMap();
        r0Var.a("fromSDK", Boolean.toString(true));
        r0Var.a("po", System.getProperty("ia.testEnvironmentConfiguration.number"));
        boolean z = (com.fyber.inneractive.sdk.util.s.a() ^ true) || IAConfigManager.O.q;
        String str4 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        r0Var.a("secure", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        r0Var.a("spotid", inneractiveAdRequest.getSpotId());
        String property2 = System.getProperty("ia.testEnvironmentConfiguration.chosenUnitId");
        if (property2 == null) {
            property2 = inneractiveAdRequest.getSelectedUnitConfig() == null ? null : ((com.fyber.inneractive.sdk.config.r0) inneractiveAdRequest.getSelectedUnitConfig()).f970a;
        }
        r0Var.a("uid", property2);
        IAConfigManager iAConfigManager = IAConfigManager.O;
        if (TextUtils.isEmpty(iAConfigManager.n)) {
            r0Var.a("med", iAConfigManager.l);
        } else {
            r0Var.a("med", iAConfigManager.l + "_" + iAConfigManager.n);
        }
        dVar.getClass();
        r0Var.a(InneractiveMediationDefs.GENDER_FEMALE, Integer.toString(372));
        com.fyber.inneractive.sdk.serverapi.c cVar = (com.fyber.inneractive.sdk.serverapi.c) dVar;
        List list = com.fyber.inneractive.sdk.serverapi.c.d;
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf((Integer) it.next()));
            }
            r0Var.a("protocols", com.fyber.inneractive.sdk.util.o.a(arrayList));
        }
        List list2 = com.fyber.inneractive.sdk.serverapi.c.c;
        if (!list2.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(String.valueOf((Integer) it2.next()));
            }
            r0Var.a("api", com.fyber.inneractive.sdk.util.o.a(arrayList2));
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            r0Var.a("zip", iAConfigManager.j.getZipCode());
        }
        r0Var.a("a", Integer.toString(iAConfigManager.j.getAge()));
        InneractiveUserConfig.Gender gender = iAConfigManager.j.getGender();
        if (InneractiveUserConfig.Gender.MALE.equals(gender)) {
            r0Var.a("g", InneractiveMediationDefs.GENDER_MALE);
        } else if (InneractiveUserConfig.Gender.FEMALE.equals(gender)) {
            r0Var.a("g", InneractiveMediationDefs.GENDER_FEMALE);
        }
        r0Var.a("t", Long.toString(System.currentTimeMillis()));
        StringBuilder sb = new StringBuilder("2.2.0-Android-8.4.0");
        if (!TextUtils.isEmpty(InneractiveAdManager.getDevPlatform())) {
            sb.append('-');
            sb.append(InneractiveAdManager.getDevPlatform());
        }
        r0Var.a("v", sb.toString());
        Boolean boolD = iAConfigManager.D.d();
        if (boolD != null) {
            r0Var.a("gdpr_privacy_consent", boolD.booleanValue() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        com.fyber.inneractive.sdk.config.g gVar = iAConfigManager.D;
        if (gVar != null) {
            Boolean bool = com.fyber.inneractive.sdk.util.o.f1662a == null ? null : gVar.i;
            if (bool != null) {
                if (bool.booleanValue()) {
                    str4 = "1";
                }
                r0Var.a("lgpd_consent", str4);
            }
            Boolean bool2 = iAConfigManager.D.j;
            if (bool2 != null && bool2.booleanValue()) {
                r0Var.a("coppaApplies", "1");
            }
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            String property3 = System.getProperty("ia.testEnvironmentConfiguration.device");
            com.fyber.inneractive.sdk.config.v vVar = com.fyber.inneractive.sdk.config.u.f982a.b;
            String str5 = (vVar == null || !vVar.c) ? "aaid" : "amazonId";
            if (TextUtils.isEmpty(property3)) {
                com.fyber.inneractive.sdk.config.v vVar2 = com.fyber.inneractive.sdk.config.u.f982a.b;
                property3 = vVar2 != null ? vVar2.f984a : null;
            }
            r0Var.a(str5, property3);
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            com.fyber.inneractive.sdk.config.v vVar3 = com.fyber.inneractive.sdk.config.u.f982a.b;
            r0Var.a("dnt", Boolean.toString(vVar3 != null ? vVar3.b : false));
        }
        r0Var.a("dml", com.fyber.inneractive.sdk.util.k.j());
        int iC = com.fyber.inneractive.sdk.util.o.c(com.fyber.inneractive.sdk.util.o.e());
        int iC2 = com.fyber.inneractive.sdk.util.o.c(com.fyber.inneractive.sdk.util.o.d());
        if (iC > 0 && iC2 > 0) {
            r0Var.a("w", Integer.toString(iC));
            r0Var.a("h", Integer.toString(iC2));
        }
        int iC3 = com.fyber.inneractive.sdk.util.o.c();
        r0Var.a("o", iC3 == 1 ? TtmlNode.TAG_P : iC3 == 2 ? "l" : "u");
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            r0Var.a("ciso", com.fyber.inneractive.sdk.util.k.i());
            String str6 = cVar.b;
            r0Var.a(Android.HW_IDS_MCC, str6 == null ? "" : str6.substring(0, Math.min(3, str6.length())));
            String str7 = cVar.b;
            r0Var.a(Android.HW_IDS_MNC, str7 == null ? "" : str7.substring(Math.min(3, str7.length())));
            com.fyber.inneractive.sdk.util.z0 z0VarA = com.fyber.inneractive.sdk.util.z0.a();
            IAlog.a("ExchangeRequestParamsProvider: getNetwork : type: %s value: %s", z0VarA, z0VarA.b());
            r0Var.a("nt", z0VarA.b());
            r0Var.a("crn", cVar.a());
        }
        r0Var.a("os", "Android");
        r0Var.a("lng", iAConfigManager.o);
        ArrayList arrayList3 = iAConfigManager.p;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            r0Var.a("in_lng", com.fyber.inneractive.sdk.util.o.a(arrayList3));
        }
        r0Var.a("bid", com.fyber.inneractive.sdk.util.o.f1662a.getPackageName());
        r0Var.a("appv", com.fyber.inneractive.sdk.util.k.l());
        com.fyber.inneractive.sdk.config.g gVar2 = iAConfigManager.D;
        if (gVar2.d == null) {
            gVar2.e = gVar2.h();
        }
        if (com.fyber.inneractive.sdk.util.o.f1662a == null) {
            str2 = null;
        } else {
            str2 = gVar2.d;
            if (str2 == null) {
                str2 = gVar2.e;
            }
        }
        r0Var.a("gdpr_consent_data", str2);
        com.fyber.inneractive.sdk.config.g gVar3 = iAConfigManager.D;
        if (com.fyber.inneractive.sdk.util.o.f1662a == null) {
            gVar3.getClass();
            str3 = null;
        } else {
            str3 = gVar3.h;
        }
        r0Var.a("us_privacy", str3);
        r0Var.a("mute_video", Boolean.toString(iAConfigManager.k));
        r0Var.a(com.moloco.sdk.acm.b.c, Build.VERSION.RELEASE);
        com.fyber.inneractive.sdk.ignite.l lVar = iAConfigManager.E.p;
        r0Var.a("ignitep", lVar != null ? lVar.f840a.d() : null);
        com.fyber.inneractive.sdk.ignite.l lVar2 = iAConfigManager.E.p;
        r0Var.a("ignitev", lVar2 != null ? lVar2.f840a.i() : null);
        HashMap map = new HashMap();
        cVar.a(inneractiveAdRequest.getSpotId(), map);
        for (Map.Entry entry : map.entrySet()) {
            r0Var.a((String) entry.getKey(), (String) entry.getValue());
        }
        if (InneractiveAdManager.isCurrentUserAChild()) {
            r0Var.a("childMode", "1");
        }
        com.fyber.inneractive.sdk.ignite.l lVar3 = IAConfigManager.O.E.p;
        r0Var.a("odt", lVar3 != null ? lVar3.getOdt() : "");
        String strA = com.fyber.inneractive.sdk.util.f1.a(str, r0Var.f1215a);
        if (!this.u) {
            IAlog.d("%s %s", "AD_REQUEST", strA);
            this.u = true;
        }
        return strA;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final int s() {
        return this.v.f;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final boolean u() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    @Override // com.fyber.inneractive.sdk.network.t0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fyber.inneractive.sdk.network.o0 a(com.fyber.inneractive.sdk.network.l r6, java.util.Map r7, int r8) throws com.fyber.inneractive.sdk.network.n0 {
        /*
            r5 = this;
            r8 = 0
            if (r7 == 0) goto L3e
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Set r1 = r7.keySet()
            java.util.Iterator r1 = r1.iterator()
        L10:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L3c
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L10
            java.lang.Object r3 = r7.get(r2)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L10
            int r4 = r3.size()
            if (r4 <= 0) goto L10
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r2 = r2.toLowerCase(r4)
            java.lang.Object r3 = r3.get(r8)
            java.lang.String r3 = (java.lang.String) r3
            r0.put(r2, r3)
            goto L10
        L3c:
            r5.q = r0
        L3e:
            r7 = 0
            if (r6 != 0) goto L43
            r6 = r7
            goto L45
        L43:
            java.io.InputStream r6 = r6.c
        L45:
            long r0 = java.lang.System.currentTimeMillis()
            super.d(r0)
            java.lang.String r0 = com.fyber.inneractive.sdk.util.IAlog.a(r5)
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r8] = r0
            java.lang.String r0 = "%s : NetworkRequestAd : set start read timestamp"
            com.fyber.inneractive.sdk.util.IAlog.a(r0, r1)
            if (r6 == 0) goto L6c
            java.lang.StringBuffer r6 = com.fyber.inneractive.sdk.util.v.b(r6)     // Catch: java.lang.Exception -> L61
            goto L6a
        L61:
            r6 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r1 = "failed create response builder in network request ad"
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r6, r0)
            r6 = r7
        L6a:
            r5.r = r6
        L6c:
            long r0 = java.lang.System.currentTimeMillis()
            r5.b(r0)
            com.fyber.inneractive.sdk.network.o0 r6 = new com.fyber.inneractive.sdk.network.o0
            r6.<init>()
            java.util.HashMap r0 = r5.q     // Catch: java.lang.Exception -> Lab
            if (r0 == 0) goto L99
            com.fyber.inneractive.sdk.network.n r1 = com.fyber.inneractive.sdk.network.n.RETURNED_AD_TYPE     // Catch: java.lang.Exception -> Lab
            java.lang.String r1 = r1.key     // Catch: java.lang.Exception -> Lab
            java.util.Locale r2 = java.util.Locale.US     // Catch: java.lang.Exception -> Lab
            java.lang.String r1 = r1.toLowerCase(r2)     // Catch: java.lang.Exception -> Lab
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> Lab
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> Lab
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> Lab
            if (r1 != 0) goto L99
            boolean r1 = android.text.TextUtils.isDigitsOnly(r0)     // Catch: java.lang.Exception -> Lab
            if (r1 == 0) goto L99
            goto L9a
        L99:
            r0 = r7
        L9a:
            if (r0 == 0) goto La1
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> Lab
            goto La2
        La1:
            r0 = 6
        La2:
            com.fyber.inneractive.sdk.dv.j r1 = r5.t     // Catch: java.lang.Exception -> Lab
            com.fyber.inneractive.sdk.response.e r7 = r5.a(r0, r5, r7, r1)     // Catch: java.lang.Exception -> Lab
            r6.f1211a = r7     // Catch: java.lang.Exception -> Lab
            return r6
        Lab:
            r6 = move-exception
            long r0 = java.lang.System.currentTimeMillis()
            r5.b(r0)
            java.lang.Object[] r7 = new java.lang.Object[r8]
            java.lang.String r8 = "failed parse ad network request"
            com.fyber.inneractive.sdk.util.IAlog.a(r8, r6, r7)
            com.fyber.inneractive.sdk.network.n0 r7 = new com.fyber.inneractive.sdk.network.n0
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.q0.a(com.fyber.inneractive.sdk.network.l, java.util.Map, int):com.fyber.inneractive.sdk.network.o0");
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final void b(long j) {
        super.b(j);
        IAlog.a("%s : NetworkRequestAd : set end read timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(q()));
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final l a(String str) {
        IAlog.a("%s: NetworkRequestAd Ad request execution started, timeouts(connection: %d read: %d)", IAlog.a(this), Integer.valueOf(p().f1207a), Integer.valueOf(p().b));
        return super.a(str);
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final void a(long j) {
        super.a(j);
        IAlog.a("%s : NetworkRequestAd : set end connection timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(q()));
    }
}
