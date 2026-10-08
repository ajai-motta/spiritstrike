package com.hive.core.configuration;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: HiveOrientation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/hive/core/configuration/HiveOrientation;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNDEFINED", "ALL", "PORTRAIT", "LANDSCAPE", "SYSTEM", k.M, "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveOrientation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HiveOrientation[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String value;
    public static final HiveOrientation UNDEFINED = new HiveOrientation("UNDEFINED", 0, "UNDEFINED");
    public static final HiveOrientation ALL = new HiveOrientation("ALL", 1, "ALL");
    public static final HiveOrientation PORTRAIT = new HiveOrientation("PORTRAIT", 2, "PORTRAIT");
    public static final HiveOrientation LANDSCAPE = new HiveOrientation("LANDSCAPE", 3, "LANDSCAPE");
    public static final HiveOrientation SYSTEM = new HiveOrientation("SYSTEM", 4, "SYSTEM");

    private static final /* synthetic */ HiveOrientation[] $values() {
        return new HiveOrientation[]{UNDEFINED, ALL, PORTRAIT, LANDSCAPE, SYSTEM};
    }

    public static EnumEntries<HiveOrientation> getEntries() {
        return $ENTRIES;
    }

    private HiveOrientation(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        HiveOrientation[] hiveOrientationArr$values = $values();
        $VALUES = hiveOrientationArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(hiveOrientationArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: HiveOrientation.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/core/configuration/HiveOrientation$Companion;", "", "<init>", "()V", "getEnum", "Lcom/hive/core/configuration/HiveOrientation;", "value", "", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HiveOrientation getEnum(String value) {
            Object objM7415constructorimpl;
            Intrinsics.checkNotNullParameter(value, "value");
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = value.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            try {
                Result.Companion companion = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(HiveOrientation.valueOf(upperCase));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            HiveOrientation hiveOrientation = HiveOrientation.UNDEFINED;
            if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
                objM7415constructorimpl = hiveOrientation;
            }
            return (HiveOrientation) objM7415constructorimpl;
        }
    }

    public static HiveOrientation valueOf(String str) {
        return (HiveOrientation) Enum.valueOf(HiveOrientation.class, str);
    }

    public static HiveOrientation[] values() {
        return (HiveOrientation[]) $VALUES.clone();
    }
}
