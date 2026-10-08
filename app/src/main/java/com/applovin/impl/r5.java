package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.e6;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r5 extends j5 {
    private final com.applovin.impl.sdk.network.e g;
    private final AppLovinPostbackListener h;
    private final e6.b i;

    class a implements AppLovinPostbackListener {
        a() {
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackFailure(String str, int i) {
            r5.this.e();
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackSuccess(String str) {
            if (r5.this.h != null) {
                r5.this.h.onPostbackSuccess(r5.this.g.f());
            }
        }
    }

    public r5(com.applovin.impl.sdk.network.e eVar, e6.b bVar, com.applovin.impl.sdk.k kVar, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", kVar);
        if (eVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        this.g = eVar;
        this.h = appLovinPostbackListener;
        this.i = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        b bVar = new b(this.g, b());
        bVar.a(this.i);
        b().r0().a(bVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (StringUtils.isValidString(this.g.f())) {
            if (this.g.u()) {
                b().y0().a(this.g, new a());
                return;
            } else {
                e();
                return;
            }
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d(this.b, "Requested URL is not valid; nothing to do...");
        }
        AppLovinPostbackListener appLovinPostbackListener = this.h;
        if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(this.g.f(), AppLovinErrorCodes.INVALID_URL);
        }
    }

    class b extends m6 {
        final String m;

        b(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
            this.m = r5.this.g.f();
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, Object obj, int i) {
            if (obj instanceof String) {
                for (String str2 : this.f428a.c(y4.n0)) {
                    if (str2.startsWith(str2)) {
                        String str3 = (String) obj;
                        if (TextUtils.isEmpty(str3)) {
                            continue;
                        } else {
                            try {
                                JSONObject jSONObject = new JSONObject(str3);
                                r0.c(jSONObject, this.f428a);
                                r0.b(jSONObject, this.f428a);
                                r0.a(jSONObject, this.f428a);
                                break;
                            } catch (JSONException unused) {
                                continue;
                            }
                        }
                    }
                }
            }
            if (r5.this.h != null) {
                r5.this.h.onPostbackSuccess(this.m);
            }
            if (r5.this.g.t()) {
                this.f428a.t().a(r5.this.g.s(), this.m, i, obj, null, true);
            }
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, Object obj) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to dispatch postback. Error code: " + i + " URL: " + this.m);
            }
            if (r5.this.h != null) {
                r5.this.h.onPostbackFailure(this.m, i);
            }
            if (r5.this.g.t()) {
                this.f428a.t().a(r5.this.g.s(), this.m, i, obj, str2, false);
            }
        }
    }
}
