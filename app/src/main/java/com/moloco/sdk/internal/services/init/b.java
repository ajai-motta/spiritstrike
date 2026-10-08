package com.moloco.sdk.internal.services.init;

import com.facebook.internal.AnalyticsEvents;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2360a = new b("RequestTimeout", 0);
    public static final b b = new b("UnknownHostHttpError", 1);
    public static final b c = new b("HttpSocketError", 2);
    public static final b d = new b("HttpSslError", 3);
    public static final b e = new b("PersistentHttpUnavailableError", 4);
    public static final b f = new b(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, 5);
    public static final /* synthetic */ b[] g;
    public static final /* synthetic */ EnumEntries h;

    static {
        b[] bVarArrA = a();
        g = bVarArrA;
        h = EnumEntriesKt.enumEntries(bVarArrA);
    }

    public b(String str, int i) {
    }

    public static final /* synthetic */ b[] a() {
        return new b[]{f2360a, b, c, d, e, f};
    }

    public static EnumEntries<b> b() {
        return h;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) g.clone();
    }
}
