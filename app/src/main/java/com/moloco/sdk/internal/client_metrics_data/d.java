package com.moloco.sdk.internal.client_metrics_data;

import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static final d b = new d("Reason", 0, "reason");
    public static final d c = new d("AdType", 1, AppEventsConstants.EVENT_PARAM_AD_TYPE);
    public static final d d = new d("Result", 2, "result");
    public static final d e = new d("Country", 3, UserDataStore.COUNTRY);
    public static final d f = new d("RetryAttempt", 4, ReportUtil.EVENT_TYPE_ATTEMPT);
    public static final d g = new d("Step", 5, "step");
    public static final /* synthetic */ d[] h;
    public static final /* synthetic */ EnumEntries i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2035a;

    static {
        d[] dVarArrA = a();
        h = dVarArrA;
        i = EnumEntriesKt.enumEntries(dVarArrA);
    }

    public d(String str, int i2, String str2) {
        this.f2035a = str2;
    }

    public static final /* synthetic */ d[] a() {
        return new d[]{b, c, d, e, f, g};
    }

    public static EnumEntries<d> b() {
        return i;
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) h.clone();
    }

    public final String c() {
        return this.f2035a;
    }
}
