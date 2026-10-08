package com.google.ads.mediation.fyber;

import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.OnFyberMarketplaceInitializedListener;
import com.google.android.gms.ads.AdError;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DTExchangeErrorCodes.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/google/ads/mediation/fyber/DTExchangeErrorCodes;", "", "<init>", "()V", "ERROR_DOMAIN", "", "ERROR_INVALID_SERVER_PARAMETERS", "", "ERROR_BANNER_SIZE_MISMATCH", "ERROR_WRONG_CONTROLLER_TYPE", "ERROR_AD_NOT_READY", "ERROR_CONTEXT_NOT_ACTIVITY_INSTANCE", "getAdError", "Lcom/google/android/gms/ads/AdError;", "initStatus", "Lcom/fyber/inneractive/sdk/external/OnFyberMarketplaceInitializedListener$FyberInitStatus;", "inneractiveErrorCode", "Lcom/fyber/inneractive/sdk/external/InneractiveErrorCode;", "adx-library-fyber_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DTExchangeErrorCodes {
    public static final int ERROR_AD_NOT_READY = 106;
    public static final int ERROR_BANNER_SIZE_MISMATCH = 103;
    public static final int ERROR_CONTEXT_NOT_ACTIVITY_INSTANCE = 107;
    public static final String ERROR_DOMAIN = "com.google.ads.mediation.dtexchange";
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    public static final int ERROR_WRONG_CONTROLLER_TYPE = 105;
    public static final DTExchangeErrorCodes INSTANCE = new DTExchangeErrorCodes();

    /* JADX INFO: compiled from: DTExchangeErrorCodes.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[OnFyberMarketplaceInitializedListener.FyberInitStatus.values().length];
            try {
                iArr[OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OnFyberMarketplaceInitializedListener.FyberInitStatus.FAILED_NO_KITS_DETECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OnFyberMarketplaceInitializedListener.FyberInitStatus.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OnFyberMarketplaceInitializedListener.FyberInitStatus.INVALID_APP_ID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[InneractiveErrorCode.values().length];
            try {
                iArr2[InneractiveErrorCode.CONNECTION_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[InneractiveErrorCode.CONNECTION_TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[InneractiveErrorCode.NO_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[InneractiveErrorCode.SERVER_INVALID_RESPONSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[InneractiveErrorCode.SERVER_INTERNAL_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[InneractiveErrorCode.SDK_INTERNAL_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[InneractiveErrorCode.UNSPECIFIED.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[InneractiveErrorCode.LOAD_TIMEOUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[InneractiveErrorCode.INVALID_INPUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[InneractiveErrorCode.SPOT_DISABLED.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[InneractiveErrorCode.UNSUPPORTED_SPOT.ordinal()] = 11;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[InneractiveErrorCode.IN_FLIGHT_TIMEOUT.ordinal()] = 12;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[InneractiveErrorCode.SDK_NOT_INITIALIZED.ordinal()] = 13;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[InneractiveErrorCode.NON_SECURE_CONTENT_DETECTED.ordinal()] = 14;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH.ordinal()] = 15;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[InneractiveErrorCode.NATIVE_ADS_NOT_SUPPORTED_FOR_OS.ordinal()] = 16;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[InneractiveErrorCode.ERROR_CONFIGURATION_NO_SUCH_SPOT.ordinal()] = 17;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[InneractiveErrorCode.SDK_NOT_INITIALIZED_OR_CONFIG_ERROR.ordinal()] = 18;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[InneractiveErrorCode.ERROR_CODE_NATIVE_VIDEO_NOT_SUPPORTED.ordinal()] = 19;
            } catch (NoSuchFieldError unused23) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private DTExchangeErrorCodes() {
    }

    @JvmStatic
    public static final AdError getAdError(OnFyberMarketplaceInitializedListener.FyberInitStatus initStatus) {
        Intrinsics.checkNotNullParameter(initStatus, "initStatus");
        int i = WhenMappings.$EnumSwitchMapping$0[initStatus.ordinal()];
        return new AdError(i != 1 ? i != 2 ? i != 3 ? i != 4 ? 299 : ComposerKt.providerValuesKey : ComposerKt.compositionLocalMapKey : ComposerKt.providerKey : 200, "DT Exchange failed to initialize with reason: " + initStatus, ERROR_DOMAIN);
    }

    @JvmStatic
    public static final AdError getAdError(InneractiveErrorCode inneractiveErrorCode) {
        Intrinsics.checkNotNullParameter(inneractiveErrorCode, "inneractiveErrorCode");
        int i = 399;
        switch (WhenMappings.$EnumSwitchMapping$1[inneractiveErrorCode.ordinal()]) {
            case 1:
                i = AnimationConstants.DefaultDurationMillis;
                break;
            case 2:
                i = 301;
                break;
            case 3:
                i = 302;
                break;
            case 4:
                i = 303;
                break;
            case 5:
                i = 304;
                break;
            case 6:
                i = 305;
                break;
            case 7:
                i = 306;
                break;
            case 8:
                i = 307;
                break;
            case 9:
                i = 308;
                break;
            case 10:
                i = 309;
                break;
            case 11:
                i = 310;
                break;
            case 12:
                i = 311;
                break;
            case 13:
                i = 312;
                break;
            case 14:
                i = 313;
                break;
            case 15:
                i = 314;
                break;
            case 16:
                i = 315;
                break;
            case 17:
                i = TypedValues.AttributesType.TYPE_PATH_ROTATE;
                break;
            case 18:
                i = TypedValues.AttributesType.TYPE_EASING;
                break;
        }
        return new AdError(i, "DT Exchange failed to request ad with reason: " + inneractiveErrorCode, ERROR_DOMAIN);
    }
}
