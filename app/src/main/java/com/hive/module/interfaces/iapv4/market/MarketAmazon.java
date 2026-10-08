package com.hive.module.interfaces.iapv4.market;

import android.content.Context;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.core.Configuration;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\b\t\nJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/hive/module/interfaces/iapv4/market/MarketAmazon;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "getMyData", "Lcom/hive/module/interfaces/iapv4/market/MarketAmazon$UserData;", "context", "Landroid/content/Context;", "UserData", "ResponseStatus", "UserStatus", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MarketAmazon extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(MarketAmazon marketAmazon) {
            return HiveModuleName.INSTANCE.getIapV4_Market_Amazon();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/hive/module/interfaces/iapv4/market/MarketAmazon$ResponseStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SUCCESS", "APP_NOT_OWNED", "INTERNAL_TRANSIENT_ERROR", "INTERNAL_ERROR", "FEATURE_NOT_SUPPORTED", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResponseStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ResponseStatus[] $VALUES;
        public static final ResponseStatus SUCCESS = new ResponseStatus("SUCCESS", 0, "SUCCESS");
        public static final ResponseStatus APP_NOT_OWNED = new ResponseStatus("APP_NOT_OWNED", 1, "APP_NOT_OWNED");
        public static final ResponseStatus INTERNAL_TRANSIENT_ERROR = new ResponseStatus("INTERNAL_TRANSIENT_ERROR", 2, "INTERNAL_TRANSIENT_ERROR");
        public static final ResponseStatus INTERNAL_ERROR = new ResponseStatus("INTERNAL_ERROR", 3, "INTERNAL_ERROR");
        public static final ResponseStatus FEATURE_NOT_SUPPORTED = new ResponseStatus("FEATURE_NOT_SUPPORTED", 4, "FEATURE_NOT_SUPPORTED");

        private static final /* synthetic */ ResponseStatus[] $values() {
            return new ResponseStatus[]{SUCCESS, APP_NOT_OWNED, INTERNAL_TRANSIENT_ERROR, INTERNAL_ERROR, FEATURE_NOT_SUPPORTED};
        }

        static {
            ResponseStatus[] responseStatusArr$values = $values();
            $VALUES = responseStatusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(responseStatusArr$values);
        }

        private ResponseStatus(String str, int i, String str2) {
        }

        public static EnumEntries<ResponseStatus> getEntries() {
            return $ENTRIES;
        }

        public static ResponseStatus valueOf(String str) {
            return (ResponseStatus) Enum.valueOf(ResponseStatus.class, str);
        }

        public static ResponseStatus[] values() {
            return (ResponseStatus[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/hive/module/interfaces/iapv4/market/MarketAmazon$UserData;", "", "responseStatus", "", "userStatus", "ageLower", "", "ageUpper", "mostRecentApprovalDate", "userId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getResponseStatus", "()Ljava/lang/String;", "getUserStatus", "getAgeLower", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAgeUpper", "getMostRecentApprovalDate", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/hive/module/interfaces/iapv4/market/MarketAmazon$UserData;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class UserData {
        private final Integer ageLower;
        private final Integer ageUpper;
        private final String mostRecentApprovalDate;
        private final String responseStatus;
        private final String userId;
        private final String userStatus;

        public UserData(String str, String str2, Integer num, Integer num2, String str3, String str4) {
            this.responseStatus = str;
            this.userStatus = str2;
            this.ageLower = num;
            this.ageUpper = num2;
            this.mostRecentApprovalDate = str3;
            this.userId = str4;
        }

        public static /* synthetic */ UserData copy$default(UserData userData, String str, String str2, Integer num, Integer num2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userData.responseStatus;
            }
            if ((i & 2) != 0) {
                str2 = userData.userStatus;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                num = userData.ageLower;
            }
            Integer num3 = num;
            if ((i & 8) != 0) {
                num2 = userData.ageUpper;
            }
            Integer num4 = num2;
            if ((i & 16) != 0) {
                str3 = userData.mostRecentApprovalDate;
            }
            String str6 = str3;
            if ((i & 32) != 0) {
                str4 = userData.userId;
            }
            return userData.copy(str, str5, num3, num4, str6, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getResponseStatus() {
            return this.responseStatus;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUserStatus() {
            return this.userStatus;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getAgeLower() {
            return this.ageLower;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getAgeUpper() {
            return this.ageUpper;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getMostRecentApprovalDate() {
            return this.mostRecentApprovalDate;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        public final UserData copy(String responseStatus, String userStatus, Integer ageLower, Integer ageUpper, String mostRecentApprovalDate, String userId) {
            return new UserData(responseStatus, userStatus, ageLower, ageUpper, mostRecentApprovalDate, userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserData)) {
                return false;
            }
            UserData userData = (UserData) other;
            return Intrinsics.areEqual(this.responseStatus, userData.responseStatus) && Intrinsics.areEqual(this.userStatus, userData.userStatus) && Intrinsics.areEqual(this.ageLower, userData.ageLower) && Intrinsics.areEqual(this.ageUpper, userData.ageUpper) && Intrinsics.areEqual(this.mostRecentApprovalDate, userData.mostRecentApprovalDate) && Intrinsics.areEqual(this.userId, userData.userId);
        }

        public final Integer getAgeLower() {
            return this.ageLower;
        }

        public final Integer getAgeUpper() {
            return this.ageUpper;
        }

        public final String getMostRecentApprovalDate() {
            return this.mostRecentApprovalDate;
        }

        public final String getResponseStatus() {
            return this.responseStatus;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final String getUserStatus() {
            return this.userStatus;
        }

        public int hashCode() {
            String str = this.responseStatus;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.userStatus;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.ageLower;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.ageUpper;
            int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str3 = this.mostRecentApprovalDate;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.userId;
            return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "UserData(responseStatus=" + this.responseStatus + ", userStatus=" + this.userStatus + ", ageLower=" + this.ageLower + ", ageUpper=" + this.ageUpper + ", mostRecentApprovalDate=" + this.mostRecentApprovalDate + ", userId=" + this.userId + ')';
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/hive/module/interfaces/iapv4/market/MarketAmazon$UserStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "VERIFIED", "SUPERVISED", Configuration.HIVE_COUNTRY_DEFAULT, "EMPTY_STRING", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UserStatus[] $VALUES;
        public static final UserStatus VERIFIED = new UserStatus("VERIFIED", 0, "VERIFIED");
        public static final UserStatus SUPERVISED = new UserStatus("SUPERVISED", 1, "SUPERVISED");
        public static final UserStatus UNKNOWN = new UserStatus(Configuration.HIVE_COUNTRY_DEFAULT, 2, Configuration.HIVE_COUNTRY_DEFAULT);
        public static final UserStatus EMPTY_STRING = new UserStatus("EMPTY_STRING", 3, "");

        private static final /* synthetic */ UserStatus[] $values() {
            return new UserStatus[]{VERIFIED, SUPERVISED, UNKNOWN, EMPTY_STRING};
        }

        static {
            UserStatus[] userStatusArr$values = $values();
            $VALUES = userStatusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(userStatusArr$values);
        }

        private UserStatus(String str, int i, String str2) {
        }

        public static EnumEntries<UserStatus> getEntries() {
            return $ENTRIES;
        }

        public static UserStatus valueOf(String str) {
            return (UserStatus) Enum.valueOf(UserStatus.class, str);
        }

        public static UserStatus[] values() {
            return (UserStatus[]) $VALUES.clone();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    UserData getMyData(Context context);
}
