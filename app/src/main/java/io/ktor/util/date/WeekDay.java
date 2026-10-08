package io.ktor.util.date;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Date.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/util/date/WeekDay;", "", "", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", k.M, "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY", "ktor-utils"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WeekDay {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WeekDay[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String value;
    public static final WeekDay MONDAY = new WeekDay("MONDAY", 0, "Mon");
    public static final WeekDay TUESDAY = new WeekDay("TUESDAY", 1, "Tue");
    public static final WeekDay WEDNESDAY = new WeekDay("WEDNESDAY", 2, "Wed");
    public static final WeekDay THURSDAY = new WeekDay("THURSDAY", 3, "Thu");
    public static final WeekDay FRIDAY = new WeekDay("FRIDAY", 4, "Fri");
    public static final WeekDay SATURDAY = new WeekDay("SATURDAY", 5, "Sat");
    public static final WeekDay SUNDAY = new WeekDay("SUNDAY", 6, "Sun");

    private static final /* synthetic */ WeekDay[] $values() {
        return new WeekDay[]{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};
    }

    public static EnumEntries<WeekDay> getEntries() {
        return $ENTRIES;
    }

    private WeekDay(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        WeekDay[] weekDayArr$values = $values();
        $VALUES = weekDayArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(weekDayArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: Date.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/util/date/WeekDay$Companion;", "", "<init>", "()V", "", MediationMetaData.KEY_ORDINAL, "Lio/ktor/util/date/WeekDay;", "from", "(I)Lio/ktor/util/date/WeekDay;", "", "value", "(Ljava/lang/String;)Lio/ktor/util/date/WeekDay;", "ktor-utils"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WeekDay from(int ordinal) {
            return WeekDay.getEntries().get(ordinal);
        }

        public final WeekDay from(String value) {
            WeekDay next;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<WeekDay> it = WeekDay.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getValue(), value)) {
                    break;
                }
            }
            WeekDay weekDay = next;
            if (weekDay != null) {
                return weekDay;
            }
            throw new IllegalStateException(("Invalid day of week: " + value).toString());
        }
    }

    public static WeekDay valueOf(String str) {
        return (WeekDay) Enum.valueOf(WeekDay.class, str);
    }

    public static WeekDay[] values() {
        return (WeekDay[]) $VALUES.clone();
    }
}
