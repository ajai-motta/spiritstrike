package com.moloco.sdk.internal.services.bidtoken;

import com.hive.ResultAPI;
import com.hive.core.Configuration;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.moloco.sdk.internal.services.bidtoken.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class EnumC3001b {
    public static final EnumC3001b b = new EnumC3001b(Configuration.HIVE_COUNTRY_DEFAULT, 0, -100);
    public static final EnumC3001b c = new EnumC3001b("HTTP_REQUEST_TIMEOUT", 1, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
    public static final EnumC3001b d = new EnumC3001b("UNKNOWN_HOST", 2, -102);
    public static final /* synthetic */ EnumC3001b[] e;
    public static final /* synthetic */ EnumEntries f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2296a;

    static {
        EnumC3001b[] enumC3001bArrA = a();
        e = enumC3001bArrA;
        f = EnumEntriesKt.enumEntries(enumC3001bArrA);
    }

    public EnumC3001b(String str, int i, int i2) {
        this.f2296a = i2;
    }

    public static final /* synthetic */ EnumC3001b[] a() {
        return new EnumC3001b[]{b, c, d};
    }

    public static EnumEntries<EnumC3001b> b() {
        return f;
    }

    public static EnumC3001b valueOf(String str) {
        return (EnumC3001b) Enum.valueOf(EnumC3001b.class, str);
    }

    public static EnumC3001b[] values() {
        return (EnumC3001b[]) e.clone();
    }

    public final int c() {
        return this.f2296a;
    }
}
