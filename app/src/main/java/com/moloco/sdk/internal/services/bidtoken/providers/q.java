package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class q implements j<p> {
    public static final a d = new a(null);
    public static final int e = 8;
    public static final String f = "IlrdSignalProvider";
    public final Function0<com.moloco.sdk.internal.ilrd.e> b;
    public p c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public q(Function0<com.moloco.sdk.internal.ilrd.e> _ilrdService) {
        Intrinsics.checkNotNullParameter(_ilrdService, "_ilrdService");
        this.b = _ilrdService;
        this.c = f();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.c = f();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        p pVarF = f();
        boolean z = !Intrinsics.areEqual(pVarF, this.c);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, f, "[Ilrd] needsRefresh: " + z + ", with current: " + pVarF + ", cached: " + this.c, false, 4, null);
        return z;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return f;
    }

    public final p e() {
        return new p("", -1L, -1L, -1, -1, -1, -1, -1);
    }

    public final p f() {
        p pVarB;
        try {
            com.moloco.sdk.internal.ilrd.e eVarInvoke = this.b.invoke();
            return (eVarInvoke == null || (pVarB = eVarInvoke.b()) == null) ? e() : pVarB;
        } catch (Exception e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, f, "Error retrieving ILRD signal", e2, false, 8, null);
            return e();
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public p d() {
        return this.c;
    }
}
