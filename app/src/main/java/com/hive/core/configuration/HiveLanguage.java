package com.hive.core.configuration;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: HiveLanguage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/hive/core/configuration/HiveLanguage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LanguageAR", "LanguageDE", "LanguageEN", "LanguageES", "LanguageFR", "LanguageIN", "LanguageIT", "LanguageJA", "LanguageKO", "LanguagePT", "LanguageRU", "LanguageTH", "LanguageTR", "LanguageVI", "LanguageZHS", "LanguageZHT", k.M, "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveLanguage {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HiveLanguage[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final HiveLanguage LanguageAR = new HiveLanguage("LanguageAR", 0, "ar");
    public static final HiveLanguage LanguageDE = new HiveLanguage("LanguageDE", 1, "de");
    public static final HiveLanguage LanguageEN = new HiveLanguage("LanguageEN", 2, "en");
    public static final HiveLanguage LanguageES = new HiveLanguage("LanguageES", 3, "es");
    public static final HiveLanguage LanguageFR = new HiveLanguage("LanguageFR", 4, "fr");
    public static final HiveLanguage LanguageIN = new HiveLanguage("LanguageIN", 5, ScarConstants.IN_SIGNAL_KEY);
    public static final HiveLanguage LanguageIT = new HiveLanguage("LanguageIT", 6, "it");
    public static final HiveLanguage LanguageJA = new HiveLanguage("LanguageJA", 7, "ja");
    public static final HiveLanguage LanguageKO = new HiveLanguage("LanguageKO", 8, "ko");
    public static final HiveLanguage LanguagePT = new HiveLanguage("LanguagePT", 9, "pt");
    public static final HiveLanguage LanguageRU = new HiveLanguage("LanguageRU", 10, "ru");
    public static final HiveLanguage LanguageTH = new HiveLanguage("LanguageTH", 11, "th");
    public static final HiveLanguage LanguageTR = new HiveLanguage("LanguageTR", 12, "tr");
    public static final HiveLanguage LanguageVI = new HiveLanguage("LanguageVI", 13, "vi");
    public static final HiveLanguage LanguageZHS = new HiveLanguage("LanguageZHS", 14, "zh-hans");
    public static final HiveLanguage LanguageZHT = new HiveLanguage("LanguageZHT", 15, "zh-hant");
    private final String value;

    private static final /* synthetic */ HiveLanguage[] $values() {
        return new HiveLanguage[]{LanguageAR, LanguageDE, LanguageEN, LanguageES, LanguageFR, LanguageIN, LanguageIT, LanguageJA, LanguageKO, LanguagePT, LanguageRU, LanguageTH, LanguageTR, LanguageVI, LanguageZHS, LanguageZHT};
    }

    public static EnumEntries<HiveLanguage> getEntries() {
        return $ENTRIES;
    }

    private HiveLanguage(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        HiveLanguage[] hiveLanguageArr$values = $values();
        $VALUES = hiveLanguageArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(hiveLanguageArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: HiveLanguage.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/core/configuration/HiveLanguage$Companion;", "", "<init>", "()V", "getEnum", "Lcom/hive/core/configuration/HiveLanguage;", "value", "", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HiveLanguage getEnum(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            for (HiveLanguage hiveLanguage : HiveLanguage.values()) {
                if (Intrinsics.areEqual(hiveLanguage.getValue(), value)) {
                    return hiveLanguage;
                }
            }
            return HiveLanguage.LanguageEN;
        }
    }

    public static HiveLanguage valueOf(String str) {
        return (HiveLanguage) Enum.valueOf(HiveLanguage.class, str);
    }

    public static HiveLanguage[] values() {
        return (HiveLanguage[]) $VALUES.clone();
    }
}
