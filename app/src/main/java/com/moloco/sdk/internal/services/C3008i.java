package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import androidx.core.content.ContextCompat;
import com.moloco.sdk.R;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.internal.services.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3008i implements y {
    public static final int c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2358a;
    public final Lazy b;

    public C3008i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2358a = context;
        this.b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.services.i$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(C3008i.a(this.f$0));
            }
        });
    }

    public static final boolean a(C3008i c3008i) {
        return c3008i.f2358a.getResources().getBoolean(R.bool.isTablet);
    }

    @Override // com.moloco.sdk.internal.services.y
    public x b() {
        String networkOperatorName;
        String str = Build.MANUFACTURER;
        String str2 = str == null ? "" : str;
        String str3 = Build.MODEL;
        String str4 = str3 == null ? "" : str3;
        String str5 = Build.HARDWARE;
        String str6 = str5 == null ? "" : str5;
        boolean zE = e();
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        int i = Build.VERSION.SDK_INT;
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        TelephonyManager telephonyManager = (TelephonyManager) ContextCompat.getSystemService(this.f2358a, TelephonyManager.class);
        if (telephonyManager == null || (networkOperatorName = telephonyManager.getNetworkOperatorName()) == null) {
            networkOperatorName = "";
        }
        float f = Resources.getSystem().getDisplayMetrics().density;
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        String str7 = str5 == null ? "" : str5;
        String str8 = Build.BRAND;
        return new x(str2, str4, str6, zE, "android", RELEASE, i, language, networkOperatorName, f, jCurrentTimeMillis, str7, str8 == null ? "" : str8);
    }

    @Override // com.moloco.sdk.internal.services.y
    public String c() {
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return language;
    }

    @Override // com.moloco.sdk.internal.services.y
    public String d() {
        Object systemService = this.f2358a.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) systemService).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype != null) {
            return currentInputMethodSubtype.getLocale();
        }
        return null;
    }

    public final boolean e() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    @Override // com.moloco.sdk.internal.services.y
    @Deprecated(message = "Use invoke() instead", replaceWith = @ReplaceWith(expression = "deviceInfo", imports = {}))
    public x invoke() {
        return b();
    }

    @Override // com.moloco.sdk.internal.services.y
    public Boolean a() {
        try {
            Object systemService = this.f2358a.getSystemService("sensor");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
            return Boolean.valueOf(((SensorManager) systemService).getDefaultSensor(4) != null);
        } catch (Exception unused) {
            return null;
        }
    }
}
