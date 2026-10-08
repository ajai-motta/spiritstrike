package com.hive.core.configuration;

import com.adjust.sdk.AdjustConfig;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: HiveZoneType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/core/configuration/HiveZoneType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REAL", "SANDBOX", "TEST", "DEV", k.M, "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveZoneType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HiveZoneType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String value;
    public static final HiveZoneType REAL = new HiveZoneType("REAL", 0, "real");
    public static final HiveZoneType SANDBOX = new HiveZoneType("SANDBOX", 1, AdjustConfig.ENVIRONMENT_SANDBOX);
    public static final HiveZoneType TEST = new HiveZoneType("TEST", 2, "test");
    public static final HiveZoneType DEV = new HiveZoneType("DEV", 3, "dev");

    private static final /* synthetic */ HiveZoneType[] $values() {
        return new HiveZoneType[]{REAL, SANDBOX, TEST, DEV};
    }

    public static EnumEntries<HiveZoneType> getEntries() {
        return $ENTRIES;
    }

    private HiveZoneType(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        HiveZoneType[] hiveZoneTypeArr$values = $values();
        $VALUES = hiveZoneTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(hiveZoneTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: HiveZoneType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/core/configuration/HiveZoneType$Companion;", "", "<init>", "()V", "getEnum", "Lcom/hive/core/configuration/HiveZoneType;", "value", "", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HiveZoneType getEnum(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            for (HiveZoneType hiveZoneType : HiveZoneType.values()) {
                if (Intrinsics.areEqual(value, hiveZoneType.getValue())) {
                    return hiveZoneType;
                }
            }
            return HiveZoneType.REAL;
        }
    }

    public static HiveZoneType valueOf(String str) {
        return (HiveZoneType) Enum.valueOf(HiveZoneType.class, str);
    }

    public static HiveZoneType[] values() {
        return (HiveZoneType[]) $VALUES.clone();
    }
}
