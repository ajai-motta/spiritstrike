package com.moloco.sdk.internal.mediators;

import com.adxcorp.util.ADXLogUtil;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static final long a(String str) {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != 76100) {
                if (iHashCode != 63085501) {
                    if (iHashCode == 347625656 && str.equals("LevelPlay")) {
                        return DurationKt.toDuration(8, DurationUnit.SECONDS);
                    }
                } else if (str.equals(ADXLogUtil.PLATFORM_ADMOB)) {
                    return DurationKt.toDuration(8, DurationUnit.SECONDS);
                }
            } else if (str.equals("MAX")) {
                return DurationKt.toDuration(8, DurationUnit.SECONDS);
            }
        }
        return DurationKt.toDuration(60, DurationUnit.SECONDS);
    }

    public static final long b(String str) {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != 76100) {
                if (iHashCode != 63085501) {
                    if (iHashCode == 347625656 && str.equals("LevelPlay")) {
                        return DurationKt.toDuration(26, DurationUnit.SECONDS);
                    }
                } else if (str.equals(ADXLogUtil.PLATFORM_ADMOB)) {
                    return DurationKt.toDuration(26, DurationUnit.SECONDS);
                }
            } else if (str.equals("MAX")) {
                return DurationKt.toDuration(26, DurationUnit.SECONDS);
            }
        }
        return DurationKt.toDuration(60, DurationUnit.SECONDS);
    }

    public static final long c(String str) {
        return Intrinsics.areEqual(str, "MAX") ? DurationKt.toDuration(8, DurationUnit.SECONDS) : Intrinsics.areEqual(str, ADXLogUtil.PLATFORM_ADMOB) ? DurationKt.toDuration(58, DurationUnit.SECONDS) : DurationKt.toDuration(60, DurationUnit.SECONDS);
    }
}
