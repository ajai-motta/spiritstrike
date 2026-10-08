package io.ktor.http;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lio/ktor/http/RangeUnits;", "", "", "unitToken", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getUnitToken", "()Ljava/lang/String;", "Bytes", "None", "ktor-http"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RangeUnits {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RangeUnits[] $VALUES;
    public static final RangeUnits Bytes = new RangeUnits("Bytes", 0, "bytes");
    public static final RangeUnits None = new RangeUnits("None", 1, "none");
    private final String unitToken;

    private static final /* synthetic */ RangeUnits[] $values() {
        return new RangeUnits[]{Bytes, None};
    }

    public static EnumEntries<RangeUnits> getEntries() {
        return $ENTRIES;
    }

    private RangeUnits(String str, int i, String str2) {
        this.unitToken = str2;
    }

    public final String getUnitToken() {
        return this.unitToken;
    }

    static {
        RangeUnits[] rangeUnitsArr$values = $values();
        $VALUES = rangeUnitsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(rangeUnitsArr$values);
    }

    public static RangeUnits valueOf(String str) {
        return (RangeUnits) Enum.valueOf(RangeUnits.class, str);
    }

    public static RangeUnits[] values() {
        return (RangeUnits[]) $VALUES.clone();
    }
}
