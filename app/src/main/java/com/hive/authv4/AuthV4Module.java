package com.hive.authv4;

import com.hive.AuthV4;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.HiveModuleName;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/hive/authv4/AuthV4Module;", "Lcom/hive/module/HiveModule;", "getProviderModuleInstance", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AuthV4Module extends HiveModule {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\bJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\bJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/hive/authv4/AuthV4Module$Companion;", "", "<init>", "()V", "getProvider", "Lcom/hive/authv4/AuthV4Module;", "hiveModuleName", "", "getProvider$hive_service_release", "hiveModule", "Lcom/hive/module/HiveModule;", "providerType", "Lcom/hive/AuthV4$ProviderType;", "getHiveModuleNameFromAuthV4ProviderType", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AuthV4.ProviderType.values().length];
                try {
                    iArr[AuthV4.ProviderType.GUEST.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AuthV4.ProviderType.HIVE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AuthV4.ProviderType.FACEBOOK.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AuthV4.ProviderType.GOOGLE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AuthV4.ProviderType.QQ.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AuthV4.ProviderType.VK.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AuthV4.ProviderType.WECHAT.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[AuthV4.ProviderType.APPLE.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[AuthV4.ProviderType.SIGNIN_APPLE.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[AuthV4.ProviderType.LINE.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[AuthV4.ProviderType.WEVERSE.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[AuthV4.ProviderType.GOOGLE_PLAY_GAMES.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[AuthV4.ProviderType.HUAWEI.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[AuthV4.ProviderType.STEAM.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[AuthV4.ProviderType.X.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr[AuthV4.ProviderType.CUSTOM.ordinal()] = 16;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr[AuthV4.ProviderType.AUTO.ordinal()] = 17;
                } catch (NoSuchFieldError unused17) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        private final String getHiveModuleNameFromAuthV4ProviderType(AuthV4.ProviderType providerType) {
            switch (WhenMappings.$EnumSwitchMapping$0[providerType.ordinal()]) {
                case 2:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_Hive_Membership();
                case 3:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_Facebook();
                case 4:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_Google_SignIn();
                case 5:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_Qq();
                case 6:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_Vk();
                case 7:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_WeChat();
                case 8:
                default:
                    return null;
                case 9:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_Apple_SignIn();
                case 10:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_Line();
                case 11:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_Weverse();
                case 12:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_Google_PlayGames();
                case 13:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_Huawei();
                case 14:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_Steam();
                case 15:
                    return HiveModuleName.INSTANCE.getAuthV4_Provider_X();
            }
        }

        public final AuthV4Module getProvider$hive_service_release(String hiveModuleName) {
            Intrinsics.checkNotNullParameter(hiveModuleName, "hiveModuleName");
            HiveModule hiveModule = HiveModuleManager.INSTANCE.getHiveModule(hiveModuleName);
            if (hiveModule instanceof AuthV4Module) {
                return (AuthV4Module) hiveModule;
            }
            return null;
        }

        public final AuthV4Module getProvider$hive_service_release(HiveModule hiveModule) {
            Intrinsics.checkNotNullParameter(hiveModule, "hiveModule");
            return getProvider$hive_service_release(hiveModule.getHiveModuleName());
        }

        public final AuthV4Module getProvider$hive_service_release(AuthV4.ProviderType providerType) {
            Intrinsics.checkNotNullParameter(providerType, "providerType");
            String hiveModuleNameFromAuthV4ProviderType = getHiveModuleNameFromAuthV4ProviderType(providerType);
            if (hiveModuleNameFromAuthV4ProviderType != null) {
                return $$INSTANCE.getProvider$hive_service_release(hiveModuleNameFromAuthV4ProviderType);
            }
            return null;
        }
    }

    AuthV4ProviderAdapter getProviderModuleInstance();
}
