package com.hive.core.configuration;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: HiveTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/hive/core/configuration/HiveTheme;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HiveLight", "HiveDark", "lowerCaseValue", "getLowerCaseValue", k.M, "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveTheme {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HiveTheme[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String value;
    public static final HiveTheme HiveLight = new HiveTheme("HiveLight", 0, "hiveLight");
    public static final HiveTheme HiveDark = new HiveTheme("HiveDark", 1, "hiveDark");

    private static final /* synthetic */ HiveTheme[] $values() {
        return new HiveTheme[]{HiveLight, HiveDark};
    }

    public static EnumEntries<HiveTheme> getEntries() {
        return $ENTRIES;
    }

    private HiveTheme(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        HiveTheme[] hiveThemeArr$values = $values();
        $VALUES = hiveThemeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(hiveThemeArr$values);
        INSTANCE = new Companion(null);
    }

    public final String getLowerCaseValue() {
        String str = this.value;
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX INFO: compiled from: HiveTheme.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/core/configuration/HiveTheme$Companion;", "", "<init>", "()V", "getEnum", "Lcom/hive/core/configuration/HiveTheme;", "value", "", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HiveTheme getEnum(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            for (HiveTheme hiveTheme : HiveTheme.values()) {
                if (Intrinsics.areEqual(hiveTheme.getValue(), value)) {
                    return hiveTheme;
                }
            }
            return HiveTheme.HiveLight;
        }
    }

    public static HiveTheme valueOf(String str) {
        return (HiveTheme) Enum.valueOf(HiveTheme.class, str);
    }

    public static HiveTheme[] values() {
        return (HiveTheme[]) $VALUES.clone();
    }
}
