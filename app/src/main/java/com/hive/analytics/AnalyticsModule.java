package com.hive.analytics;

import com.hive.analytics.provider.AnalyticsProviderAdapter;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.HiveModuleName;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/hive/analytics/AnalyticsModule;", "Lcom/hive/module/HiveModule;", "getProviderModuleInstance", "Lcom/hive/analytics/provider/AnalyticsProviderAdapter;", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AnalyticsModule extends HiveModule {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\bJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\bJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/hive/analytics/AnalyticsModule$Companion;", "", "<init>", "()V", "getProvider", "Lcom/hive/analytics/AnalyticsModule;", "hiveModuleName", "", "getProvider$hive_service_release", "hiveModule", "Lcom/hive/module/HiveModule;", "providerType", "Lcom/hive/analytics/provider/AnalyticsProviderAdapter$AnalyticsProviderType;", "getHiveModuleNameFromAnalyticsProviderType", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnalyticsProviderAdapter.AnalyticsProviderType.values().length];
                try {
                    iArr[AnalyticsProviderAdapter.AnalyticsProviderType.ADJUST.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnalyticsProviderAdapter.AnalyticsProviderType.APPSFLYER.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnalyticsProviderAdapter.AnalyticsProviderType.FIREBASE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnalyticsProviderAdapter.AnalyticsProviderType.SINGULAR.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnalyticsProviderAdapter.AnalyticsProviderType.AIRBRIDGE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        private final String getHiveModuleNameFromAnalyticsProviderType(AnalyticsProviderAdapter.AnalyticsProviderType providerType) {
            int i = WhenMappings.$EnumSwitchMapping$0[providerType.ordinal()];
            if (i == 1) {
                return HiveModuleName.INSTANCE.getAnalytics_Provider_Adjust();
            }
            if (i == 2) {
                return HiveModuleName.INSTANCE.getAnalytics_Provider_AppsFlyer();
            }
            if (i == 3) {
                return HiveModuleName.INSTANCE.getAnalytics_Provider_Firebase();
            }
            if (i == 4) {
                return HiveModuleName.INSTANCE.getAnalytics_Provider_Singular();
            }
            if (i != 5) {
                return null;
            }
            return HiveModuleName.INSTANCE.getAnalytics_Provider_Airbridge();
        }

        public final AnalyticsModule getProvider$hive_service_release(String hiveModuleName) {
            Intrinsics.checkNotNullParameter(hiveModuleName, "hiveModuleName");
            HiveModule hiveModule = HiveModuleManager.INSTANCE.getHiveModule(hiveModuleName);
            if (hiveModule instanceof AnalyticsModule) {
                return (AnalyticsModule) hiveModule;
            }
            return null;
        }

        public final AnalyticsModule getProvider$hive_service_release(HiveModule hiveModule) {
            Intrinsics.checkNotNullParameter(hiveModule, "hiveModule");
            return getProvider$hive_service_release(hiveModule.getHiveModuleName());
        }

        public final AnalyticsModule getProvider$hive_service_release(AnalyticsProviderAdapter.AnalyticsProviderType providerType) {
            Intrinsics.checkNotNullParameter(providerType, "providerType");
            String hiveModuleNameFromAnalyticsProviderType = getHiveModuleNameFromAnalyticsProviderType(providerType);
            if (hiveModuleNameFromAnalyticsProviderType != null) {
                return $$INSTANCE.getProvider$hive_service_release(hiveModuleNameFromAnalyticsProviderType);
            }
            return null;
        }
    }

    AnalyticsProviderAdapter getProviderModuleInstance();
}
