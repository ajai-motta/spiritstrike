package com.hive.userengagement;

import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.runtime.ComposerKt;
import com.adxcorp.ads.mediation.common.Constants;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.userengagement.ConsumeCoupon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/hive/userengagement/UserEngagementCoupon;", "", "couponCode", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/userengagement/UserEngagementCoupon$CouponListener;", "<init>", "(Ljava/lang/String;Lcom/hive/userengagement/UserEngagementCoupon$CouponListener;)V", "consume", "", "additionalInfo", "PlatformType", "CouponConsumeResult", "CouponListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserEngagementCoupon {
    private final String couponCode;
    private final CouponListener listener;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/hive/userengagement/UserEngagementCoupon$CouponConsumeResult;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", ADXLogUtil.EVENT_LOAD_SUCCESS, "InvalidParameter", "HashError", "AccountLimit", "GroupLimit", "MissingAppID", "InvalidCoupon", "CouponLength", "NoMatching", "Unregistered", "Using", "Used", "QuantitiesExcess", "Expiration", "AUSystemError", "ExistingUserOnly", "NewbieOnly", "TargetNotFound", "DiscontinuedCoupon", "ExpiredCoupon", "AllPaymentFailed", "SomePaymentFailed", "DBError", NativeProtocol.ERROR_NETWORK_ERROR, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CouponConsumeResult {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CouponConsumeResult[] $VALUES;
        private final int value;
        public static final CouponConsumeResult Success = new CouponConsumeResult(ADXLogUtil.EVENT_LOAD_SUCCESS, 0, 100);
        public static final CouponConsumeResult InvalidParameter = new CouponConsumeResult("InvalidParameter", 1, 200);
        public static final CouponConsumeResult HashError = new CouponConsumeResult("HashError", 2, ComposerKt.providerKey);
        public static final CouponConsumeResult AccountLimit = new CouponConsumeResult("AccountLimit", 3, ComposerKt.compositionLocalMapKey);
        public static final CouponConsumeResult GroupLimit = new CouponConsumeResult("GroupLimit", 4, ComposerKt.providerValuesKey);
        public static final CouponConsumeResult MissingAppID = new CouponConsumeResult("MissingAppID", 5, 204);
        public static final CouponConsumeResult InvalidCoupon = new CouponConsumeResult("InvalidCoupon", 6, Constants.NEXT_STEP);
        public static final CouponConsumeResult CouponLength = new CouponConsumeResult("CouponLength", 7, AnimationConstants.DefaultDurationMillis);
        public static final CouponConsumeResult NoMatching = new CouponConsumeResult("NoMatching", 8, 301);
        public static final CouponConsumeResult Unregistered = new CouponConsumeResult("Unregistered", 9, 302);
        public static final CouponConsumeResult Using = new CouponConsumeResult("Using", 10, 303);
        public static final CouponConsumeResult Used = new CouponConsumeResult("Used", 11, 304);
        public static final CouponConsumeResult QuantitiesExcess = new CouponConsumeResult("QuantitiesExcess", 12, 305);
        public static final CouponConsumeResult Expiration = new CouponConsumeResult("Expiration", 13, 306);
        public static final CouponConsumeResult AUSystemError = new CouponConsumeResult("AUSystemError", 14, 307);
        public static final CouponConsumeResult ExistingUserOnly = new CouponConsumeResult("ExistingUserOnly", 15, 308);
        public static final CouponConsumeResult NewbieOnly = new CouponConsumeResult("NewbieOnly", 16, 309);
        public static final CouponConsumeResult TargetNotFound = new CouponConsumeResult("TargetNotFound", 17, 310);
        public static final CouponConsumeResult DiscontinuedCoupon = new CouponConsumeResult("DiscontinuedCoupon", 18, 311);
        public static final CouponConsumeResult ExpiredCoupon = new CouponConsumeResult("ExpiredCoupon", 19, 312);
        public static final CouponConsumeResult AllPaymentFailed = new CouponConsumeResult("AllPaymentFailed", 20, 400);
        public static final CouponConsumeResult SomePaymentFailed = new CouponConsumeResult("SomePaymentFailed", 21, 401);
        public static final CouponConsumeResult DBError = new CouponConsumeResult("DBError", 22, 500);
        public static final CouponConsumeResult NetworkError = new CouponConsumeResult(NativeProtocol.ERROR_NETWORK_ERROR, 23, 501);

        private static final /* synthetic */ CouponConsumeResult[] $values() {
            return new CouponConsumeResult[]{Success, InvalidParameter, HashError, AccountLimit, GroupLimit, MissingAppID, InvalidCoupon, CouponLength, NoMatching, Unregistered, Using, Used, QuantitiesExcess, Expiration, AUSystemError, ExistingUserOnly, NewbieOnly, TargetNotFound, DiscontinuedCoupon, ExpiredCoupon, AllPaymentFailed, SomePaymentFailed, DBError, NetworkError};
        }

        static {
            CouponConsumeResult[] couponConsumeResultArr$values = $values();
            $VALUES = couponConsumeResultArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(couponConsumeResultArr$values);
        }

        private CouponConsumeResult(String str, int i, int i2) {
            this.value = i2;
        }

        public static EnumEntries<CouponConsumeResult> getEntries() {
            return $ENTRIES;
        }

        public static CouponConsumeResult valueOf(String str) {
            return (CouponConsumeResult) Enum.valueOf(CouponConsumeResult.class, str);
        }

        public static CouponConsumeResult[] values() {
            return (CouponConsumeResult[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/hive/userengagement/UserEngagementCoupon$CouponListener;", "", "onCouponConsume", "", "result", "Lcom/hive/ResultAPI;", "resultCode", "", "resultMessage", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface CouponListener {
        void onCouponConsume(ResultAPI result, int resultCode, String resultMessage);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/hive/userengagement/UserEngagementCoupon$PlatformType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NONE", "K", "H", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PlatformType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PlatformType[] $VALUES;
        private final String value;
        public static final PlatformType NONE = new PlatformType("NONE", 0, "");
        public static final PlatformType K = new PlatformType("K", 1, "k");
        public static final PlatformType H = new PlatformType("H", 2, "h");

        private static final /* synthetic */ PlatformType[] $values() {
            return new PlatformType[]{NONE, K, H};
        }

        static {
            PlatformType[] platformTypeArr$values = $values();
            $VALUES = platformTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(platformTypeArr$values);
        }

        private PlatformType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<PlatformType> getEntries() {
            return $ENTRIES;
        }

        public static PlatformType valueOf(String str) {
            return (PlatformType) Enum.valueOf(PlatformType.class, str);
        }

        public static PlatformType[] values() {
            return (PlatformType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    public UserEngagementCoupon(String couponCode, CouponListener couponListener) {
        Intrinsics.checkNotNullParameter(couponCode, "couponCode");
        this.couponCode = couponCode;
        this.listener = couponListener;
    }

    public static /* synthetic */ void consume$default(UserEngagementCoupon userEngagementCoupon, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        userEngagementCoupon.consume(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit consume$lambda$0(UserEngagementCoupon userEngagementCoupon, ConsumeCoupon consumeCoupon) {
        Intrinsics.checkNotNullParameter(consumeCoupon, "consumeCoupon");
        if (consumeCoupon.getResponse().getResult().isFailure()) {
            LoggerImpl.INSTANCE.w("[Coupon::consume] request failed");
            ResultAPI resultAPI = new ResultAPI(-5, ResultAPI.Code.UserEngagementResponseFail, "request failed : " + consumeCoupon);
            CouponListener couponListener = userEngagementCoupon.listener;
            if (couponListener != null) {
                couponListener.onCouponConsume(resultAPI, CouponConsumeResult.NetworkError.getValue(), "Network error");
            }
        } else {
            CouponListener couponListener2 = userEngagementCoupon.listener;
            if (couponListener2 != null) {
                couponListener2.onCouponConsume(new ResultAPI(), consumeCoupon.getResponse().getCode(), consumeCoupon.getResponse().getMsg());
            }
        }
        return Unit.INSTANCE;
    }

    public final void consume(String additionalInfo) {
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        UserEngagementNetwork.INSTANCE.consumeCoupon(this.couponCode, additionalInfo, new Function1() { // from class: com.hive.userengagement.UserEngagementCoupon$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserEngagementCoupon.consume$lambda$0(this.f$0, (ConsumeCoupon) obj);
            }
        });
    }
}
