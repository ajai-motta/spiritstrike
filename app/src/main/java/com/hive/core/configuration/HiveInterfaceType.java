package com.hive.core.configuration;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: HiveInterfaceType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/hive/core/configuration/HiveInterfaceType;", "", "<init>", "(Ljava/lang/String;I)V", "C2S", "V1", "V4", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveInterfaceType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HiveInterfaceType[] $VALUES;
    public static final HiveInterfaceType C2S = new HiveInterfaceType("C2S", 0);
    public static final HiveInterfaceType V1 = new HiveInterfaceType("V1", 1);
    public static final HiveInterfaceType V4 = new HiveInterfaceType("V4", 2);

    private static final /* synthetic */ HiveInterfaceType[] $values() {
        return new HiveInterfaceType[]{C2S, V1, V4};
    }

    public static EnumEntries<HiveInterfaceType> getEntries() {
        return $ENTRIES;
    }

    private HiveInterfaceType(String str, int i) {
    }

    static {
        HiveInterfaceType[] hiveInterfaceTypeArr$values = $values();
        $VALUES = hiveInterfaceTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(hiveInterfaceTypeArr$values);
    }

    public static HiveInterfaceType valueOf(String str) {
        return (HiveInterfaceType) Enum.valueOf(HiveInterfaceType.class, str);
    }

    public static HiveInterfaceType[] values() {
        return (HiveInterfaceType[]) $VALUES.clone();
    }
}
