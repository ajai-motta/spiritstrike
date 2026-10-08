package com.fyber.inneractive.sdk.player.exoplayer2;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1277a;
    public static final UUID b;

    static {
        f1277a = z.f1480a < 23 ? 1020 : 6396;
        b = new UUID(0L, 0L);
        new UUID(1186680826959645954L, -5988876978535335093L);
        new UUID(-1301668207276963122L, -6645017420763422227L);
        new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long a(long j) {
        return j == C.TIME_UNSET ? C.TIME_UNSET : j / 1000;
    }
}
