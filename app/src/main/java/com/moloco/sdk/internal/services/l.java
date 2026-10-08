package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.pm.PackageInfo;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class l implements InterfaceC3010k {
    public static final int c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2385a;
    public C3009j b;

    public l(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2385a = context;
    }

    @Override // com.moloco.sdk.internal.services.InterfaceC3010k
    public C3009j invoke() {
        Object objM7415constructorimpl;
        C3009j c3009j = this.b;
        if (c3009j != null) {
            return c3009j;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context = this.f2385a;
            String string = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
            PackageInfo packageInfoA = m.a(this.f2385a);
            String packageName = packageInfoA.packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            String versionName = packageInfoA.versionName;
            Intrinsics.checkNotNullExpressionValue(versionName, "versionName");
            C3009j c3009j2 = new C3009j(string, packageName, versionName);
            this.b = c3009j2;
            objM7415constructorimpl = Result.m7415constructorimpl(c3009j2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = null;
        }
        C3009j c3009j3 = (C3009j) objM7415constructorimpl;
        return c3009j3 == null ? new C3009j("", "", "") : c3009j3;
    }
}
