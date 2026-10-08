package com.moloco.sdk.internal.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.moloco.sdk.internal.services.A;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class C implements B {
    public static final int c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2273a;
    public final y b;

    public C(Context context, y deviceInfoService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deviceInfoService, "deviceInfoService");
        this.f2273a = context;
        this.b = deviceInfoService;
    }

    @Override // com.moloco.sdk.internal.services.B
    public boolean a() {
        Object systemService = this.f2273a.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (Build.VERSION.SDK_INT >= 24) {
            return a(connectivityManager);
        }
        return false;
    }

    @Override // com.moloco.sdk.internal.services.B
    public Integer b() {
        Object systemService = this.f2273a.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String networkOperator = ((TelephonyManager) systemService).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() == 0) {
            return null;
        }
        String strSubstring = networkOperator.substring(3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return Integer.valueOf(Integer.parseInt(strSubstring));
    }

    @Override // com.moloco.sdk.internal.services.B
    public A c() {
        NetworkCapabilities networkCapabilities;
        Object systemService = this.f2273a.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (connectivityManager.getActiveNetwork() != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
            return networkCapabilities.hasTransport(1) ? A.c.b : networkCapabilities.hasTransport(0) ? new A.a(this.b.invoke().u()) : A.b.b;
        }
        return A.b.b;
    }

    @Override // com.moloco.sdk.internal.services.B
    public Integer d() {
        Object systemService = this.f2273a.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String networkOperator = ((TelephonyManager) systemService).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() == 0) {
            return null;
        }
        String strSubstring = networkOperator.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return Integer.valueOf(Integer.parseInt(strSubstring));
    }

    @Override // com.moloco.sdk.internal.services.B
    @Deprecated(message = "Use networkInfo()", replaceWith = @ReplaceWith(expression = "networkInfo()", imports = {}))
    public A invoke() {
        return c();
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        return connectivityManager.getRestrictBackgroundStatus() == 3;
    }
}
