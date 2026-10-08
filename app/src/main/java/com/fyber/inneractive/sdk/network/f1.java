package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.bidder.adm.AdmParametersOuterClass$AdmParameters;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class f1 extends t0 {
    public final String p;
    public final com.fyber.inneractive.sdk.bidder.adm.y q;
    public int r;
    public final com.fyber.inneractive.sdk.response.e s;
    public final com.fyber.inneractive.sdk.config.global.r t;
    public final com.fyber.inneractive.sdk.network.timeouts.request.a u;

    public f1(com.fyber.inneractive.sdk.bidder.adm.v vVar, String str, com.fyber.inneractive.sdk.bidder.adm.y yVar, com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.response.e eVar) {
        UnitDisplayType unitDisplayType;
        super(vVar, g0.c.a(), rVar);
        this.r = 0;
        this.o = true;
        this.p = str;
        this.q = yVar;
        this.s = eVar;
        this.t = rVar;
        UnitDisplayType unitDisplayType2 = UnitDisplayType.BANNER;
        String strName = unitDisplayType2.name();
        Locale locale = Locale.US;
        String lowerCase = strName.toLowerCase(locale);
        if (eVar == null || (unitDisplayType = eVar.p) == null) {
            AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = yVar.f885a;
            if (admParametersOuterClass$AdmParameters != null) {
                lowerCase = com.fyber.inneractive.sdk.util.n1.a(String.valueOf(admParametersOuterClass$AdmParameters.getSpotId()));
            }
        } else {
            lowerCase = (unitDisplayType == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.REWARDED || unitDisplayType == UnitDisplayType.NATIVE) ? unitDisplayType.name().toLowerCase(locale) : unitDisplayType2.name().toLowerCase(locale);
        }
        String str2 = IAConfigManager.O.l;
        com.fyber.inneractive.sdk.config.global.features.j jVar = (com.fyber.inneractive.sdk.config.global.features.j) rVar.a(com.fyber.inneractive.sdk.config.global.features.j.class);
        this.u = TextUtils.isEmpty(str2) ? new com.fyber.inneractive.sdk.network.timeouts.request.b(jVar, lowerCase) : new com.fyber.inneractive.sdk.network.timeouts.request.c(lowerCase, jVar, str2);
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final o0 a(l lVar, Map map, int i) throws n0, t1 {
        o0 o0Var = new o0();
        try {
            InputStream inputStream = lVar.c;
            if (inputStream != null) {
                d(System.currentTimeMillis());
                StringBuffer stringBufferB = com.fyber.inneractive.sdk.util.v.b(inputStream);
                b(System.currentTimeMillis());
                String string = stringBufferB.toString();
                AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.q.f885a;
                int iA = admParametersOuterClass$AdmParameters != null ? admParametersOuterClass$AdmParameters.getAdType().a() : com.fyber.inneractive.sdk.bidder.adm.c.OTHER.a();
                com.fyber.inneractive.sdk.bidder.adm.y yVar = this.q;
                yVar.c = string;
                com.fyber.inneractive.sdk.response.e eVarA = a(iA, null, yVar, null);
                eVarA.h = string;
                o0Var.f1211a = eVarA;
            }
            return o0Var;
        } catch (b e) {
            e = e;
            IAlog.a("failed parse adm network request but will re-try", e, new Object[0]);
            b(System.currentTimeMillis());
            throw new t1(e);
        } catch (com.fyber.inneractive.sdk.response.nativead.a e2) {
            b(System.currentTimeMillis());
            throw new n0(e2.getMessage(), e2);
        } catch (SocketTimeoutException e3) {
            e = e3;
            IAlog.a("failed parse adm network request but will re-try", e, new Object[0]);
            b(System.currentTimeMillis());
            throw new t1(e);
        } catch (UnknownHostException e4) {
            e = e4;
            IAlog.a("failed parse adm network request but will re-try", e, new Object[0]);
            b(System.currentTimeMillis());
            throw new t1(e);
        } catch (Exception e5) {
            b(System.currentTimeMillis());
            IAlog.a("failed parse adm network request", e5, new Object[0]);
            throw new n0(e5);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final void b(long j) {
        super.b(j);
        IAlog.a("%s : NetworkRequestMarkup : set end read timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(super.q()));
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final void c(long j) {
        super.c(j);
        IAlog.a("%s : NetworkRequestMarkup : set start connection timestamp", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final void d() {
        super.d();
        IAlog.a("%s : NetworkRequestMarkup cancel by timeout at retry: %d", IAlog.a(this), Integer.valueOf(this.r));
        l0 l0Var = IAConfigManager.O.s;
        this.f1217a = true;
        f1 f1Var = new f1(this);
        if ((l0Var instanceof l0) && l0Var.c(f1Var)) {
            return;
        }
        IAlog.a("%s : NetworkRequestMarkup won't retry - resolve request with `Bidding ad request passed allowed time` at retry: %d", IAlog.a(this), Integer.valueOf(this.r));
        a((Object) null, new Exception("Bidding ad request passed allowed time"), false);
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final int g() {
        return this.u.c();
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final int j() {
        int iQ = super.q();
        com.fyber.inneractive.sdk.network.timeouts.request.a aVar = this.u;
        return ((aVar.c() + aVar.f) * this.r) + iQ;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final com.fyber.inneractive.sdk.config.global.r k() {
        return this.t;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final m0 m() {
        return m0.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final g1 o() {
        return g1.HIGH;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final l1 p() {
        com.fyber.inneractive.sdk.network.timeouts.request.a aVar = this.u;
        return new l1(aVar.i, aVar.h);
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final int q() {
        throw null;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final String r() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final int s() {
        return this.u.f;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final boolean u() {
        if (this.f1217a) {
            return false;
        }
        int i = this.r + 1;
        this.r = i;
        if (i > this.u.b()) {
            IAlog.a("%s : NetworkRequestMarkup Should enable retry - FALSE, current retry: %d total retries: %d, request id: %s", IAlog.a(this), Integer.valueOf(this.r - 1), Integer.valueOf(this.u.b()), this.g);
            return false;
        }
        IAlog.a("%s : NetworkRequestMarkup Should enable retry - TRUE, current retry: %d total retries: %d, request id: %s", IAlog.a(this), Integer.valueOf(this.r - 1), Integer.valueOf(this.u.b()), this.g);
        this.u.a(this.r);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final void d(long j) {
        super.d(j);
        IAlog.a("%s : NetworkRequestMarkup : set start read timestamp", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final l a(String str) {
        IAlog.a("%s : NetworkRequestMarkup Ad request execution started, retry number: %d, timeouts(connection: %d read: %d)", IAlog.a(this), Integer.valueOf(this.r), Integer.valueOf(p().f1207a), Integer.valueOf(p().b));
        return super.a(str);
    }

    public f1(f1 f1Var) {
        super(f1Var);
        this.r = 0;
        this.o = true;
        this.p = f1Var.p;
        this.q = f1Var.q;
        this.s = f1Var.s;
        this.t = f1Var.t;
        this.u = f1Var.u;
        this.r = f1Var.r;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final void a(long j) {
        super.a(j);
        IAlog.a("%s : NetworkRequestMarkup : set end connection timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(super.q()));
    }
}
