package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.util.o;
import com.fyber.inneractive.sdk.util.s0;
import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends b {
    @Override // com.fyber.inneractive.sdk.response.b
    public final void a(String str, r0 r0Var) {
        f fVar = (f) this.f1610a;
        if (str == null) {
            str = null;
        } else {
            s0 s0Var = s0.c;
            s0Var.getClass();
            int iIndexOf = str.indexOf(38);
            if (iIndexOf >= 0) {
                StringWriter stringWriter = new StringWriter((int) ((((double) str.length()) * 0.1d) + ((double) str.length())));
                try {
                    s0Var.a(stringWriter, str, iIndexOf);
                } catch (IOException unused) {
                }
                str = stringWriter.toString();
            }
        }
        int i = com.fyber.inneractive.sdk.config.k.f959a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.assetResponse");
        if (!TextUtils.isEmpty(property)) {
            String strB = o.b(property);
            if (!TextUtils.isEmpty(strB)) {
                str = strB;
            }
        }
        fVar.N = str;
    }

    @Override // com.fyber.inneractive.sdk.response.b
    public final boolean c() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.response.b
    public final e a() {
        f fVar = new f();
        this.f1610a = fVar;
        return fVar;
    }
}
