package com.moloco.sdk.internal.services;

import android.content.Context;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.internal.services.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C2999b implements InterfaceC2998a {
    public static final a b = new a(null);
    public static final int c = 8;
    public static final String d = "AccessibilityInfoService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2293a;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.b$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public C2999b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2293a = context;
    }

    @Override // com.moloco.sdk.internal.services.InterfaceC2998a
    public boolean a() {
        return Settings.Secure.getInt(this.f2293a.getContentResolver(), "reduce_bright_colors_activated") == 1;
    }

    @Override // com.moloco.sdk.internal.services.InterfaceC2998a
    public boolean b() {
        Object systemService = this.f2293a.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        return ((AccessibilityManager) systemService).isEnabled() && Settings.Secure.getInt(this.f2293a.getContentResolver(), "accessibility_large_pointer_icon", 0) == 1;
    }

    @Override // com.moloco.sdk.internal.services.InterfaceC2998a
    public boolean c() {
        try {
            Object systemService = this.f2293a.getSystemService("captioning");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.CaptioningManager");
            return ((CaptioningManager) systemService).isEnabled();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.moloco.sdk.internal.services.InterfaceC2998a
    public float getFontScale() {
        Object systemService = this.f2293a.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        if (((AccessibilityManager) systemService).isEnabled()) {
            return this.f2293a.getResources().getConfiguration().fontScale;
        }
        return 1.0f;
    }
}
