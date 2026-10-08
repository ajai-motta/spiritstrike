package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.webkit.WebViewCompat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class K {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2287a;

    public K(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2287a = context;
    }

    public final Object a() {
        PackageInfo currentWebViewPackage = WebViewCompat.getCurrentWebViewPackage(this.f2287a);
        if (currentWebViewPackage == null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m7415constructorimpl(ResultKt.createFailure(new Exception("No current WebView package exists")));
        }
        int applicationEnabledSetting = this.f2287a.getPackageManager().getApplicationEnabledSetting(currentWebViewPackage.packageName);
        if (applicationEnabledSetting == 2) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7415constructorimpl(ResultKt.createFailure(new Exception("WebView component is disabled by system")));
        }
        if (applicationEnabledSetting == 3) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m7415constructorimpl(ResultKt.createFailure(new Exception("WebView component is disabled by user")));
        }
        if (applicationEnabledSetting != 4) {
            Result.Companion companion4 = Result.INSTANCE;
            return Result.m7415constructorimpl(Unit.INSTANCE);
        }
        Result.Companion companion5 = Result.INSTANCE;
        return Result.m7415constructorimpl(ResultKt.createFailure(new Exception("WebView component is disabled until used")));
    }
}
