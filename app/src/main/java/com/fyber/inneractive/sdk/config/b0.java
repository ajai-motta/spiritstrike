package com.fyber.inneractive.sdk.config;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.network.i1;
import com.fyber.inneractive.sdk.network.k1;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements com.fyber.inneractive.sdk.network.f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f928a;

    public b0(IAConfigManager iAConfigManager) {
        this.f928a = iAConfigManager;
    }

    @Override // com.fyber.inneractive.sdk.network.f0
    public final void a(Object obj, Exception exc, boolean z) {
        int i;
        h0 h0Var = (h0) obj;
        if (h0Var != null) {
            if (z) {
                IAConfigManager iAConfigManager = this.f928a;
                IAConfigManager iAConfigManager2 = IAConfigManager.O;
                iAConfigManager.getClass();
                iAConfigManager.e = h0Var.c;
                iAConfigManager.d = h0Var.b;
                iAConfigManager.f925a = h0Var.d;
                iAConfigManager.b = h0Var.e;
            } else {
                IAConfigManager.P = System.currentTimeMillis();
                IAConfigManager iAConfigManager3 = this.f928a;
                iAConfigManager3.getClass();
                IAlog.a("Got new remote configuration from server:", new Object[0]);
                iAConfigManager3.e = h0Var.c;
                iAConfigManager3.d = h0Var.b;
                iAConfigManager3.f925a = h0Var.d;
                iAConfigManager3.b = h0Var.e;
            }
        } else if (exc instanceof com.fyber.inneractive.sdk.network.g) {
            IAConfigManager.P = System.currentTimeMillis();
        }
        if (z) {
            return;
        }
        IAConfigManager iAConfigManager4 = this.f928a;
        IAConfigManager iAConfigManager5 = IAConfigManager.O;
        if (iAConfigManager5.e != null) {
            iAConfigManager4.a(null);
        } else {
            iAConfigManager4.getClass();
            if ((exc instanceof InvalidAppIdException) || (exc instanceof FileNotFoundException) || (!(exc instanceof k1) ? !TextUtils.isEmpty(iAConfigManager4.c.trim()) : (i = ((k1) exc).f1204a) < 400 || i >= 500)) {
                iAConfigManager4.a(new InvalidAppIdException());
            } else if (exc instanceof com.fyber.inneractive.sdk.network.b) {
                iAConfigManager4.a(exc);
            } else {
                iAConfigManager4.a(new i0());
            }
        }
        if (iAConfigManager5.e != null) {
            IAConfigManager iAConfigManager6 = this.f928a;
            if (iAConfigManager6.C == null) {
                iAConfigManager6.C = new com.fyber.inneractive.sdk.network.v0(new e0(iAConfigManager6), iAConfigManager6.f, new com.fyber.inneractive.sdk.config.global.m());
            }
            i1 i1Var = iAConfigManager6.C.f;
            if (i1Var == i1.RUNNING || i1Var == i1.QUEUED) {
                return;
            }
            iAConfigManager5.s.a(iAConfigManager6.C);
        }
    }
}
