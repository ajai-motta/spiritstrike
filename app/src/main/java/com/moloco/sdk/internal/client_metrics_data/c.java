package com.moloco.sdk.internal.client_metrics_data;

import com.facebook.login.LoginLogger;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2034a = new c("success", 0);
    public static final c b = new c(LoginLogger.EVENT_EXTRAS_FAILURE, 1);
    public static final /* synthetic */ c[] c;
    public static final /* synthetic */ EnumEntries d;

    static {
        c[] cVarArrA = a();
        c = cVarArrA;
        d = EnumEntriesKt.enumEntries(cVarArrA);
    }

    public c(String str, int i) {
    }

    public static final /* synthetic */ c[] a() {
        return new c[]{f2034a, b};
    }

    public static EnumEntries<c> b() {
        return d;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) c.clone();
    }
}
