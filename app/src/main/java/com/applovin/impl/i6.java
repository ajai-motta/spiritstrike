package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i6 extends j5 {
    private final AppLovinAdLoadListener g;
    private final a h;

    private static final class a extends t7 {
        a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.k kVar) {
            super(jSONObject, jSONObject2, kVar);
        }

        void a(q8 q8Var) {
            if (q8Var == null) {
                throw new IllegalArgumentException("No aggregated vast response specified");
            }
            this.b.add(q8Var);
        }
    }

    private static final class b extends i6 {
        private final String i;

        b(String str, t7 t7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
            super(t7Var, appLovinAdLoadListener, kVar);
            this.i = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            q8 q8VarB = b(this.i);
            if (q8VarB != null) {
                a(q8VarB);
                return;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to process XML: " + this.i);
            }
            c(this.i);
            a(u7.XML_PARSING);
        }
    }

    private static final class c extends i6 {
        private final JSONObject i;

        c(t7 t7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
            super(t7Var, appLovinAdLoadListener, kVar);
            this.i = t7Var.b();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Processing SDK JSON response...");
            }
            String string = JsonUtils.getString(this.i, "xml", null);
            if (!StringUtils.isValidString(string)) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "No VAST response received.");
                }
                a(u7.NO_WRAPPER_RESPONSE);
                return;
            }
            if (string.length() >= ((Integer) this.f428a.a(y4.Q4)).intValue()) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "VAST response is over max length");
                }
                a(u7.XML_PARSING);
                return;
            }
            q8 q8VarB = b(string);
            if (q8VarB != null) {
                a(q8VarB);
                return;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to process XML: " + string);
            }
            c(string);
            a(u7.XML_PARSING);
        }
    }

    private static final class d extends i6 {
        private final q8 i;

        d(q8 q8Var, t7 t7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
            super(t7Var, appLovinAdLoadListener, kVar);
            if (q8Var == null) {
                throw new IllegalArgumentException("No response specified.");
            }
            if (t7Var == null) {
                throw new IllegalArgumentException("No context specified.");
            }
            if (appLovinAdLoadListener == null) {
                throw new IllegalArgumentException("No callback specified.");
            }
            this.i = q8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Processing VAST Wrapper response...");
            }
            a(this.i);
        }
    }

    i6(t7 t7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super("TaskProcessVastResponse", kVar);
        if (t7Var == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        this.g = appLovinAdLoadListener;
        this.h = (a) t7Var;
    }

    public static i6 a(JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        return new c(new a(jSONObject, jSONObject2, kVar), appLovinAdLoadListener, kVar);
    }

    protected q8 b(String str) {
        try {
            return r8.a(str, this.f428a);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to process VAST response", th);
            }
            a(u7.XML_PARSING);
            this.f428a.D().a(this.b, th);
            return null;
        }
    }

    protected void c(String str) {
        if (str == null) {
            return;
        }
        Iterator<String> it = StringUtils.getRegexMatches(StringUtils.match(str, (String) this.f428a.a(y4.j5)), 1).iterator();
        while (it.hasNext()) {
            q8 q8VarB = b("<VAST>" + it.next() + "</VAST>");
            if (q8VarB != null) {
                this.h.a(q8VarB);
            }
        }
    }

    public static i6 a(String str, JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        return new b(str, new a(jSONObject, jSONObject2, kVar), appLovinAdLoadListener, kVar);
    }

    public static i6 a(q8 q8Var, t7 t7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        return new d(q8Var, t7Var, appLovinAdLoadListener, kVar);
    }

    void a(q8 q8Var) {
        int iD = this.h.d();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finished parsing XML at depth " + iD);
        }
        this.h.a(q8Var);
        if (b8.b(q8Var)) {
            int iIntValue = ((Integer) this.f428a.a(y4.R4)).intValue();
            if (iD < iIntValue) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "VAST response is wrapper. Resolving...");
                }
                this.f428a.r0().a(new q6(this.h, this.g, this.f428a));
                return;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Reached beyond max wrapper depth of " + iIntValue);
            }
            a(u7.WRAPPER_LIMIT_REACHED);
            return;
        }
        if (b8.a(q8Var)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "VAST response is inline. Rendering ad...");
            }
            this.f428a.r0().a(new l6(this.h, this.g, this.f428a));
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "VAST response is an error");
        }
        a(u7.NO_WRAPPER_RESPONSE);
    }

    void a(u7 u7Var) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Failed to process VAST response due to VAST error code " + u7Var);
        }
        b8.a(this.h, this.g, u7Var, -6, this.f428a);
    }
}
