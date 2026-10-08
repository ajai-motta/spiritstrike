package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class r implements q {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2389a;

    public r(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2389a = context;
    }

    @Override // com.moloco.sdk.internal.services.q
    public int a() {
        Intent intentRegisterReceiver = this.f2389a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return intentRegisterReceiver.getIntExtra("status", 1);
        }
        return 1;
    }

    @Override // com.moloco.sdk.internal.services.q
    public int b() {
        Intent intentRegisterReceiver = this.f2389a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return intentRegisterReceiver.getIntExtra("scale", -1);
        }
        return -1;
    }

    @Override // com.moloco.sdk.internal.services.q
    public boolean c() {
        Object systemService = this.f2389a.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isPowerSaveMode();
    }
}
