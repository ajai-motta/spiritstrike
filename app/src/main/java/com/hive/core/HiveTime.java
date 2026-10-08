package com.hive.core;

import android.os.SystemClock;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveTime.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0006\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/hive/core/HiveTime;", "", "<init>", "()V", "baseTimeInterval", "", "userTimestamp", "Ljava/sql/Timestamp;", "isSetBaseTime", "", "()Z", "elapsedTimeFromOriginNetworkTime", "setBaseTime", "", "timestamp", "getHiveTime", "Ljava/util/Date;", "hiveCurrentTimestampTime", "getHiveTimeTimestamp", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveTime {
    public static final HiveTime INSTANCE = new HiveTime();
    private static long baseTimeInterval;
    private static Timestamp userTimestamp;

    private HiveTime() {
    }

    public final boolean isSetBaseTime() {
        return baseTimeInterval != 0;
    }

    private final long elapsedTimeFromOriginNetworkTime() {
        return SystemClock.elapsedRealtime() - baseTimeInterval;
    }

    public final void setBaseTime(Timestamp timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        baseTimeInterval = SystemClock.elapsedRealtime();
        userTimestamp = timestamp;
    }

    public final Date getHiveTime() {
        return new Date(hiveCurrentTimestampTime());
    }

    private final long hiveCurrentTimestampTime() {
        Timestamp timestamp = userTimestamp;
        if (timestamp != null) {
            return timestamp.getTime() + INSTANCE.elapsedTimeFromOriginNetworkTime();
        }
        return Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.US).getTimeInMillis();
    }

    public final Timestamp getHiveTimeTimestamp() {
        return new Timestamp(hiveCurrentTimestampTime());
    }
}
