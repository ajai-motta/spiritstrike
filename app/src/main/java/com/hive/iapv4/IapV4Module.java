package com.hive.iapv4;

import com.hive.IAPV4;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.HiveModuleName;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IapV4Module.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/hive/iapv4/IapV4Module;", "Lcom/hive/module/HiveModule;", "getMarketModuleInstance", "Lcom/hive/iapv4/BaseMarketAPI;", k.M, "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IapV4Module extends HiveModule {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    BaseMarketAPI getMarketModuleInstance();

    /* JADX INFO: compiled from: IapV4Module.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\bJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\bJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/hive/iapv4/IapV4Module$Companion;", "", "<init>", "()V", "getMarket", "Lcom/hive/iapv4/IapV4Module;", "hiveModuleName", "", "getMarket$hive_iapv4_base_release", "hiveModule", "Lcom/hive/module/HiveModule;", "iapV4Type", "Lcom/hive/IAPV4$IAPV4Type;", "getHiveModuleNameFromIapV4Type", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: compiled from: IapV4Module.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[IAPV4.IAPV4Type.values().length];
                try {
                    iArr[IAPV4.IAPV4Type.NOT_SELECTED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.APPLE_APPSTORE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.GOOGLE_PLAYSTORE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.HIVE_LEBI.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.ONESTORE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.AMAZON_APPSTORE.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.SAMSUNG_GALAXYSTORE.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.HUAWEI_APPGALLERY.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.FUNTAP.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.OPPO_APPMARKET.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.VIVO_APPSTORE.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.TENCENT_MYAPP.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.XIAOMI_APPSTORE.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.HUAWEI_APPGALLERY_CHINA.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.FACEBOOK_CLOUD_GAME.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.HIVESTORE.ordinal()] = 16;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.STEAM.ordinal()] = 17;
                } catch (NoSuchFieldError unused17) {
                }
                try {
                    iArr[IAPV4.IAPV4Type.NOWGG.ordinal()] = 18;
                } catch (NoSuchFieldError unused18) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public final IapV4Module getMarket$hive_iapv4_base_release(String hiveModuleName) {
            Intrinsics.checkNotNullParameter(hiveModuleName, "hiveModuleName");
            HiveModule hiveModule = HiveModuleManager.INSTANCE.getHiveModule(hiveModuleName);
            if (hiveModule instanceof IapV4Module) {
                return (IapV4Module) hiveModule;
            }
            return null;
        }

        public final IapV4Module getMarket$hive_iapv4_base_release(HiveModule hiveModule) {
            Intrinsics.checkNotNullParameter(hiveModule, "hiveModule");
            return getMarket$hive_iapv4_base_release(hiveModule.getHiveModuleName());
        }

        public final IapV4Module getMarket$hive_iapv4_base_release(IAPV4.IAPV4Type iapV4Type) {
            Intrinsics.checkNotNullParameter(iapV4Type, "iapV4Type");
            String hiveModuleNameFromIapV4Type = getHiveModuleNameFromIapV4Type(iapV4Type);
            if (hiveModuleNameFromIapV4Type != null) {
                return $$INSTANCE.getMarket$hive_iapv4_base_release(hiveModuleNameFromIapV4Type);
            }
            return null;
        }

        private final String getHiveModuleNameFromIapV4Type(IAPV4.IAPV4Type iapV4Type) {
            switch (WhenMappings.$EnumSwitchMapping$0[iapV4Type.ordinal()]) {
                case 1:
                case 2:
                case 9:
                case 12:
                case 17:
                case 18:
                default:
                    return null;
                case 3:
                    return HiveModuleName.INSTANCE.getIapV4_Market_Google();
                case 4:
                    return HiveModuleName.INSTANCE.getIapV4_Market_Lebi();
                case 5:
                    return HiveModuleName.INSTANCE.getIapV4_Market_OneStore();
                case 6:
                    return HiveModuleName.INSTANCE.getIapV4_Market_Amazon();
                case 7:
                    return HiveModuleName.INSTANCE.getIapV4_Market_Samsung();
                case 8:
                    return HiveModuleName.INSTANCE.getIapV4_Market_Huawei();
                case 10:
                    return HiveModuleName.INSTANCE.getIapV4_Market_Oppo();
                case 11:
                    return HiveModuleName.INSTANCE.getIapV4_Market_Vivo();
                case 13:
                    return HiveModuleName.INSTANCE.getIapV4_Market_Xiaomi();
                case 14:
                    return HiveModuleName.INSTANCE.getIapV4_Market_Huawei();
                case 15:
                    return HiveModuleName.INSTANCE.getIapV4_Market_Facebook_CloudGame();
                case 16:
                    return HiveModuleName.INSTANCE.getIapV4_Market_HiveStore();
            }
        }
    }
}
