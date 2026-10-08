package com.hive;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.logger.LoggerImpl;
import com.hive.socialv4.SocialV4Impl;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0014\u0015\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/hive/SocialV4;", "", "<init>", "()V", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "showCommunity", "", "providerType", "Lcom/hive/SocialV4$ProviderType;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/SocialV4$SocialV4ShowCommunityListener;", "viewType", "Lcom/hive/SocialV4$ViewType;", "url", "sharePhoto", "Lcom/hive/SocialV4$SocialV4SharePhotoListener;", "ProviderType", "ViewType", "SocialV4ShowCommunityListener", "SocialV4SharePhotoListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialV4 {
    public static final SocialV4 INSTANCE = new SocialV4();
    private static final String TAG;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0015\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0017"}, d2 = {"Lcom/hive/SocialV4$ProviderType;", "", "value", "", "description", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getDescription", "()Ljava/lang/String;", "HIVE", "FACEBOOK", "GOOGLE", "QQ", "HUAWEI", "OPPO", "VIVO", "XIAOMI", "GOOGLE_PLAY_GAMES", "stringValue", "getStringValue", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProviderType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ProviderType[] $VALUES;
        private final String description;
        private final int value;
        public static final ProviderType HIVE = new ProviderType("HIVE", 0, 1, "HIVE");
        public static final ProviderType FACEBOOK = new ProviderType("FACEBOOK", 1, 2, "FACEBOOK");
        public static final ProviderType GOOGLE = new ProviderType("GOOGLE", 2, 3, "GOOGLE");
        public static final ProviderType QQ = new ProviderType("QQ", 3, 4, "QQ");
        public static final ProviderType HUAWEI = new ProviderType("HUAWEI", 4, 13, "HUAWEI");
        public static final ProviderType OPPO = new ProviderType("OPPO", 5, 14, "OPPO");
        public static final ProviderType VIVO = new ProviderType("VIVO", 6, 15, "VIVO");
        public static final ProviderType XIAOMI = new ProviderType("XIAOMI", 7, 16, "XIAOMI");
        public static final ProviderType GOOGLE_PLAY_GAMES = new ProviderType("GOOGLE_PLAY_GAMES", 8, 17, "GOOGLE_PLAY_GAMES");

        private static final /* synthetic */ ProviderType[] $values() {
            return new ProviderType[]{HIVE, FACEBOOK, GOOGLE, QQ, HUAWEI, OPPO, VIVO, XIAOMI, GOOGLE_PLAY_GAMES};
        }

        static {
            ProviderType[] providerTypeArr$values = $values();
            $VALUES = providerTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(providerTypeArr$values);
        }

        private ProviderType(String str, int i, int i2, String str2) {
            this.value = i2;
            this.description = str2;
        }

        public static EnumEntries<ProviderType> getEntries() {
            return $ENTRIES;
        }

        public static ProviderType valueOf(String str) {
            return (ProviderType) Enum.valueOf(ProviderType.class, str);
        }

        public static ProviderType[] values() {
            return (ProviderType[]) $VALUES.clone();
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getStringValue() {
            return String.valueOf(this.value);
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/SocialV4$SocialV4SharePhotoListener;", "", "onShare", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SocialV4SharePhotoListener {
        void onShare(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/SocialV4$SocialV4ShowCommunityListener;", "", "onShowCommunity", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SocialV4ShowCommunityListener {
        void onShowCommunity(ResultAPI result);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/SocialV4$ViewType;", "", "<init>", "(Ljava/lang/String;I)V", "FullScreen", "Frame", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ViewType[] $VALUES;
        public static final ViewType FullScreen = new ViewType("FullScreen", 0);
        public static final ViewType Frame = new ViewType("Frame", 1);

        private static final /* synthetic */ ViewType[] $values() {
            return new ViewType[]{FullScreen, Frame};
        }

        static {
            ViewType[] viewTypeArr$values = $values();
            $VALUES = viewTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(viewTypeArr$values);
        }

        private ViewType(String str, int i) {
        }

        public static EnumEntries<ViewType> getEntries() {
            return $ENTRIES;
        }

        public static ViewType valueOf(String str) {
            return (ViewType) Enum.valueOf(ViewType.class, str);
        }

        public static ViewType[] values() {
            return (ViewType[]) $VALUES.clone();
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("SocialV4", "getSimpleName(...)");
        TAG = "SocialV4";
    }

    private SocialV4() {
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    public final void sharePhoto(ProviderType providerType, SocialV4SharePhotoListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("ProviderType = %s, listener = %s", Arrays.copyOf(new Object[]{providerType.getStringValue(), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialV4Impl.INSTANCE.sharePhoto(providerType, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public final void showCommunity(ProviderType providerType, SocialV4ShowCommunityListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("ProviderType = %s, listener = %s", Arrays.copyOf(new Object[]{providerType.getStringValue(), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialV4Impl.INSTANCE.showCommunity(providerType, ViewType.FullScreen, null, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public final void showCommunity(ProviderType providerType, ViewType viewType, SocialV4ShowCommunityListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("ProviderType = %s, viewType = %s, listener = %s", Arrays.copyOf(new Object[]{providerType.getStringValue(), viewType, listener}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialV4Impl.INSTANCE.showCommunity(providerType, viewType, null, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public final void showCommunity(ProviderType providerType, String url, SocialV4ShowCommunityListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("ProviderType = %s, listener = %s", Arrays.copyOf(new Object[]{providerType.getStringValue(), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialV4Impl.INSTANCE.showCommunity(providerType, ViewType.FullScreen, url, listener);
        loggerImpl.apiReturnLog(str2, "");
    }
}
