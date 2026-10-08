package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f1610a;
    public String b;
    public j c;
    public boolean d = true;

    public abstract e a();

    public final e a(String str) throws Exception {
        this.d = str != null;
        e eVar = this.f1610a;
        eVar.getClass();
        eVar.c = System.currentTimeMillis();
        this.c.a(this);
        String strA = this.c.a();
        this.f1610a.h = strA;
        r0 r0VarA = com.fyber.inneractive.sdk.config.a.a(this.b);
        IAlog.a("%sGot unit config for unitId: %s from config manager", IAlog.a(this), this.b);
        IAlog.a("%s%s", IAlog.a(this), r0VarA);
        if (this.d) {
            a(str, r0VarA);
        } else if (b()) {
            h hVar = new h(strA);
            if (hVar.f1612a) {
                String str2 = hVar.b;
                if (str2 == null || TextUtils.isEmpty(str2.trim())) {
                    throw new Exception("empty ad content detected. failing fast.");
                }
                a(str2, r0VarA);
            }
        } else {
            a(strA, r0VarA);
        }
        return this.f1610a;
    }

    public abstract void a(String str, r0 r0Var);

    public boolean b() {
        return !(this instanceof com.fyber.inneractive.sdk.dv.h);
    }

    public boolean c() {
        return this instanceof com.fyber.inneractive.sdk.dv.h;
    }
}
