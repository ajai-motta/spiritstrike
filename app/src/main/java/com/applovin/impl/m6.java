package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.e6;
import com.applovin.impl.q0;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m6 extends j5 implements q0.e {
    private final com.applovin.impl.sdk.network.a g;
    private final q0.e h;
    private e6.b i;
    private y4 j;
    private y4 k;
    protected q0.b l;

    public m6(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
        this(aVar, kVar, false);
    }

    public abstract void a(String str, int i, String str2, Object obj);

    public abstract void a(String str, Object obj, int i);

    @Override // java.lang.Runnable
    public void run() {
        q0 q0VarW = b().w();
        if (!b().F0() && !b().C0()) {
            com.applovin.impl.sdk.o.h("AppLovinSdk", "AppLovin SDK is disabled");
            a(this.g.f(), -22, null, null);
        } else if (!StringUtils.isValidString(this.g.f()) || this.g.f().length() < 4) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Task has an invalid or null request endpoint.");
            }
            a(this.g.f(), AppLovinErrorCodes.INVALID_URL, null, null);
        } else {
            if (TextUtils.isEmpty(this.g.h())) {
                this.g.b(this.g.b() != null ? "POST" : "GET");
            }
            q0VarW.a(this.g, this.l, this.h);
        }
    }

    public m6(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, boolean z) {
        super("TaskRepeatRequest", kVar, z);
        this.i = e6.b.OTHER;
        if (aVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        a(aVar.f());
        this.g = aVar;
        this.l = new q0.b();
        this.h = new a(kVar);
    }

    public void b(y4 y4Var) {
        this.k = y4Var;
    }

    public void c(y4 y4Var) {
        this.j = y4Var;
    }

    public void a(e6.b bVar) {
        this.i = bVar;
    }

    class a implements q0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.k f470a;

        a(com.applovin.impl.sdk.k kVar) {
            this.f470a = kVar;
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, Object obj, int i) {
            m6.this.g.a(0);
            m6.this.a(str, obj, i);
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, int i, String str2, Object obj) {
            long millis;
            boolean z = false;
            boolean z2 = i < 200 || i >= 500;
            boolean z3 = i == 429;
            boolean z4 = i != -1009 || m6.this.g.q();
            boolean z5 = (i == -900 || i == -1000) ? false : true;
            if (z4 && z5 && (z2 || z3 || m6.this.g.p())) {
                String strA = m6.this.g.a();
                if (m6.this.g.j() <= 0) {
                    if (strA != null && strA.equals(m6.this.g.f())) {
                        m6 m6Var = m6.this;
                        m6Var.a(m6Var.k);
                    } else {
                        m6 m6Var2 = m6.this;
                        m6Var2.a(m6Var2.j);
                    }
                    m6 m6Var3 = m6.this;
                    m6Var3.a(m6Var3.g.f(), i, str2, obj);
                    return;
                }
                com.applovin.impl.sdk.o oVar = m6.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    m6 m6Var4 = m6.this;
                    m6Var4.c.k(m6Var4.b, "Unable to send request due to server failure (code " + i + "). " + m6.this.g.j() + " attempts left, retrying in " + TimeUnit.MILLISECONDS.toSeconds(m6.this.g.k()) + " seconds...");
                }
                int iJ = m6.this.g.j() - 1;
                m6.this.g.a(iJ);
                if (iJ == 0) {
                    m6 m6Var5 = m6.this;
                    m6Var5.a(m6Var5.j);
                    if (StringUtils.isValidString(strA) && strA.length() >= 4) {
                        com.applovin.impl.sdk.o oVar2 = m6.this.c;
                        if (com.applovin.impl.sdk.o.a()) {
                            m6 m6Var6 = m6.this;
                            m6Var6.c.d(m6Var6.b, "Switching to backup endpoint " + strA);
                        }
                        m6.this.g.a(strA);
                        z = true;
                    }
                }
                if (((Boolean) this.f470a.a(y4.l3)).booleanValue() && z) {
                    millis = 0;
                } else {
                    millis = m6.this.g.n() ? TimeUnit.SECONDS.toMillis((long) Math.pow(2.0d, m6.this.g.c())) : m6.this.g.k();
                }
                e6 e6VarR0 = this.f470a.r0();
                m6 m6Var7 = m6.this;
                e6VarR0.a(m6Var7, m6Var7.i, millis);
                return;
            }
            m6 m6Var8 = m6.this;
            m6Var8.a(m6Var8.g.f(), i, str2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y4 y4Var) {
        if (y4Var != null) {
            b().p0().a(y4Var, y4Var.a());
        }
    }
}
