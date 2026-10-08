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
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\b\t\nJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/hive/module/interfaces/iapv4/market/MarketSamsung;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "getMyData", "Lcom/hive/module/interfaces/iapv4/market/MarketSamsung$UserData;", "context", "Landroid/content/Context;", "UserData", "ResponseStatus", "UserStatus", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MarketSamsung extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(MarketSamsung marketSamsung) {
            return HiveModuleName.INSTANCE.getIapV4_Market_Samsung();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/hive/module/interfaces/iapv4/market/MarketSamsung$ResponseStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "SUCCESS", "FAILURE", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResponseStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ResponseStatus[] $VALUES;
        public static final ResponseStatus SUCCESS = new ResponseStatus("SUCCESS", 0, 0);
        public static final ResponseStatus FAILURE = new ResponseStatus("FAILURE", 1, 1);

        private static final /* synthetic */ ResponseStatus[] $values() {
            return new ResponseStatus[]{SUCCESS, FAILURE};
        }

        static {
            ResponseStatus[] responseStatusArr$values = $values();
            $VALUES = responseStatusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(responseStatusArr$values);
        }

        private ResponseStatus(String str, int i, int i2) {
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003JT\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006#"}, d2 = {"Lcom/hive/module/interfaces/iapv4/market/MarketSamsung$UserData;", "", "responseStatus", "", "userStatus", "", "ageLower", "ageUpper", "approvalDate", "installId", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getResponseStatus", "()I", "getUserStatus", "()Ljava/lang/String;", "getAgeLower", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAgeUpper", "getApprovalDate", "getInstallId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/hive/module/interfaces/iapv4/market/MarketSamsung$UserData;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class UserData {
        private final Integer ageLower;
        private final Integer ageUpper;
        private final String approvalDate;
        private final String installId;
        private final int responseStatus;
        private final String userStatus;

        public UserData(int i, String str, Integer num, Integer num2, String str2, String str3) {
            this.responseStatus = i;
            this.userStatus = str;
            this.ageLower = num;
            this.ageUpper = num2;
            this.approvalDate = str2;
            this.installId = str3;
        }

        public static /* synthetic */ UserData copy$default(UserData userData, int i, String str, Integer num, Integer num2, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = userData.responseStatus;
            }
            if ((i2 & 2) != 0) {
                str = userData.userStatus;
            }
            String str4 = str;
            if ((i2 & 4) != 0) {
                num = userData.ageLower;
            }
            Integer num3 = num;
            if ((i2 & 8) != 0) {
                num2 = userData.ageUpper;
            }
            Integer num4 = num2;
            if ((i2 & 16) != 0) {
                str2 = userData.approvalDate;
            }
            String str5 = str2;
            if ((i2 & 32) != 0) {
                str3 = userData.installId;
            }
            return userData.copy(i, str4, num3, num4, str5, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getResponseStatus() {
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
        public final String getApprovalDate() {
            return this.approvalDate;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getInstallId() {
            return this.installId;
        }

        public final UserData copy(int responseStatus, String userStatus, Integer ageLower, Integer ageUpper, String approvalDate, String installId) {
            return new UserData(responseStatus, userStatus, ageLower, ageUpper, approvalDate, installId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserData)) {
                return false;
            }
            UserData userData = (UserData) other;
            return this.responseStatus == userData.responseStatus && Intrinsics.areEqual(this.userStatus, userData.userStatus) && Intrinsics.areEqual(this.ageLower, userData.ageLower) && Intrinsics.areEqual(this.ageUpper, userData.ageUpper) && Intrinsics.areEqual(this.approvalDate, userData.approvalDate) && Intrinsics.areEqual(this.installId, userData.installId);
        }

        public final Integer getAgeLower() {
            return this.ageLower;
        }

        public final Integer getAgeUpper() {
            return this.ageUpper;
        }

        public final String getApprovalDate() {
            return this.approvalDate;
        }

        public final String getInstallId() {
            return this.installId;
        }

        public final int getResponseStatus() {
            return this.responseStatus;
        }

        public final String getUserStatus() {
            return this.userStatus;
        }

        public int hashCode() {
            int i = this.responseStatus * 31;
            String str = this.userStatus;
            int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.ageLower;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.ageUpper;
            int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str2 = this.approvalDate;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.installId;
            return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "UserData(responseStatus=" + this.responseStatus + ", userStatus=" + this.userStatus + ", ageLower=" + this.ageLower + ", ageUpper=" + this.ageUpper + ", approvalDate=" + this.approvalDate + ", installId=" + this.installId + ')';
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/hive/module/interfaces/iapv4/market/MarketSamsung$UserStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "VERIFIED", "SUPERVISED", "SUPERVISED_APPROVAL_DENIED", "SUPERVISED_APPROVAL_PENDING", Configuration.HIVE_COUNTRY_DEFAULT, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UserStatus[] $VALUES;
        public static final UserStatus VERIFIED = new UserStatus("VERIFIED", 0, "VERIFIED");
        public static final UserStatus SUPERVISED = new UserStatus("SUPERVISED", 1, "SUPERVISED");
        public static final UserStatus SUPERVISED_APPROVAL_DENIED = new UserStatus("SUPERVISED_APPROVAL_DENIED", 2, "SUPERVISED_APPROVAL_DENIED");
        public static final UserStatus SUPERVISED_APPROVAL_PENDING = new UserStatus("SUPERVISED_APPROVAL_PENDING", 3, "SUPERVISED_APPROVAL_PENDING");
        public static final UserStatus UNKNOWN = new UserStatus(Configuration.HIVE_COUNTRY_DEFAULT, 4, Configuration.HIVE_COUNTRY_DEFAULT);

        private static final /* synthetic */ UserStatus[] $values() {
            return new UserStatus[]{VERIFIED, SUPERVISED, SUPERVISED_APPROVAL_DENIED, SUPERVISED_APPROVAL_PENDING, UNKNOWN};
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
