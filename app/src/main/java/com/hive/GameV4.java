package com.hive;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/hive/GameV4;", "", "<init>", "()V", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "ProviderType", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GameV4 {
    public static final GameV4 INSTANCE = new GameV4();
    private static final String TAG;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \n2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/hive/GameV4$ProviderType;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GOOGLE", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProviderType implements Serializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ProviderType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ProviderType GOOGLE = new ProviderType("GOOGLE", 0, "GOOGLE");
        private static final HashMap<String, ProviderType> map;
        private final String value;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0007R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/hive/GameV4$ProviderType$Companion;", "", "<init>", "()V", "map", "Ljava/util/HashMap;", "", "Lcom/hive/GameV4$ProviderType;", "Lkotlin/collections/HashMap;", "getProviderType", "key", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final ProviderType getProviderType(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return (ProviderType) ProviderType.map.get(key);
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ ProviderType[] $values() {
            return new ProviderType[]{GOOGLE};
        }

        static {
            ProviderType[] providerTypeArr$values = $values();
            $VALUES = providerTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(providerTypeArr$values);
            INSTANCE = new Companion(null);
            map = new HashMap<>();
            for (ProviderType providerType : values()) {
                map.put(providerType.value, providerType);
            }
        }

        private ProviderType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<ProviderType> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        public static final ProviderType getProviderType(String str) {
            return INSTANCE.getProviderType(str);
        }

        public static ProviderType valueOf(String str) {
            return (ProviderType) Enum.valueOf(ProviderType.class, str);
        }

        public static ProviderType[] values() {
            return (ProviderType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("GameV4", "getSimpleName(...)");
        TAG = "GameV4";
    }

    private GameV4() {
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }
}
