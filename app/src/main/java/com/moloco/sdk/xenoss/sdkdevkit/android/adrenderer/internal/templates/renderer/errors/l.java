package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class l implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f2655a = new l("UNKNOWN_ERROR", 0);
    public static final l b = new l("WEBVIEW_DATA_WITH_DEFAULT_BASE_URL_ERROR", 1);
    public static final l c = new l("WEBVIEW_RECEIVED_ERROR", 2);
    public static final l d = new l("WEBVIEW_REQUIRED_CONTENT_HTTP_ERROR", 3);
    public static final l e = new l("WEBVIEW_RENDER_PROCESS_GONE_ERROR", 4);
    public static final l f = new l("WEBVIEW_TIMEOUT_ERROR", 5);
    public static final l g = new l("WEBVIEW_NOT_AVAILABLE_ERROR", 6);
    public static final /* synthetic */ l[] h;
    public static final /* synthetic */ EnumEntries i;

    static {
        l[] lVarArrB = b();
        h = lVarArrB;
        i = EnumEntriesKt.enumEntries(lVarArrB);
    }

    public l(String str, int i2) {
    }

    public static final /* synthetic */ l[] b() {
        return new l[]{f2655a, b, c, d, e, f, g};
    }

    public static EnumEntries<l> c() {
        return i;
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) h.clone();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c
    public String a() {
        return name();
    }
}
