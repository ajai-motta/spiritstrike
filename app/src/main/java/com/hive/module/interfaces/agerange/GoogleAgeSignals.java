package com.hive.module.interfaces.agerange;

import android.content.Context;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.core.Configuration;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\rJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/hive/module/interfaces/agerange/GoogleAgeSignals;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "checkAgeSignals", "Lkotlin/Pair;", "", "Lcom/hive/module/interfaces/agerange/GoogleAgeSignals$AgeSignalsResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readableAgeSignalsErrorCode", "ageSignalsErrorCode", "AgeSignalsResult", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GoogleAgeSignals extends HiveModule {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\tJ\b\u0010\u001e\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/hive/module/interfaces/agerange/GoogleAgeSignals$AgeSignalsResult;", "", "userStatus", "", "ageLower", "ageUpper", "mostRecentApprovalDate", "Ljava/util/Date;", "installId", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Date;Ljava/lang/String;)V", "getUserStatus", "()Ljava/lang/Integer;", "setUserStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAgeLower", "setAgeLower", "getAgeUpper", "setAgeUpper", "getMostRecentApprovalDate", "()Ljava/util/Date;", "setMostRecentApprovalDate", "(Ljava/util/Date;)V", "getInstallId", "()Ljava/lang/String;", "setInstallId", "(Ljava/lang/String;)V", "readableUserStatus", InAppPurchaseConstants.METHOD_TO_STRING, "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Date;Ljava/lang/String;)Lcom/hive/module/interfaces/agerange/GoogleAgeSignals$AgeSignalsResult;", "equals", "", "other", "hashCode", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class AgeSignalsResult {
        private Integer ageLower;
        private Integer ageUpper;
        private String installId;
        private Date mostRecentApprovalDate;
        private Integer userStatus;

        public AgeSignalsResult(Integer num, Integer num2, Integer num3, Date date, String str) {
            this.userStatus = num;
            this.ageLower = num2;
            this.ageUpper = num3;
            this.mostRecentApprovalDate = date;
            this.installId = str;
        }

        public static /* synthetic */ AgeSignalsResult copy$default(AgeSignalsResult ageSignalsResult, Integer num, Integer num2, Integer num3, Date date, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = ageSignalsResult.userStatus;
            }
            if ((i & 2) != 0) {
                num2 = ageSignalsResult.ageLower;
            }
            Integer num4 = num2;
            if ((i & 4) != 0) {
                num3 = ageSignalsResult.ageUpper;
            }
            Integer num5 = num3;
            if ((i & 8) != 0) {
                date = ageSignalsResult.mostRecentApprovalDate;
            }
            Date date2 = date;
            if ((i & 16) != 0) {
                str = ageSignalsResult.installId;
            }
            return ageSignalsResult.copy(num, num4, num5, date2, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getUserStatus() {
            return this.userStatus;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getAgeLower() {
            return this.ageLower;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getAgeUpper() {
            return this.ageUpper;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Date getMostRecentApprovalDate() {
            return this.mostRecentApprovalDate;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getInstallId() {
            return this.installId;
        }

        public final AgeSignalsResult copy(Integer userStatus, Integer ageLower, Integer ageUpper, Date mostRecentApprovalDate, String installId) {
            return new AgeSignalsResult(userStatus, ageLower, ageUpper, mostRecentApprovalDate, installId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AgeSignalsResult)) {
                return false;
            }
            AgeSignalsResult ageSignalsResult = (AgeSignalsResult) other;
            return Intrinsics.areEqual(this.userStatus, ageSignalsResult.userStatus) && Intrinsics.areEqual(this.ageLower, ageSignalsResult.ageLower) && Intrinsics.areEqual(this.ageUpper, ageSignalsResult.ageUpper) && Intrinsics.areEqual(this.mostRecentApprovalDate, ageSignalsResult.mostRecentApprovalDate) && Intrinsics.areEqual(this.installId, ageSignalsResult.installId);
        }

        public final Integer getAgeLower() {
            return this.ageLower;
        }

        public final Integer getAgeUpper() {
            return this.ageUpper;
        }

        public final String getInstallId() {
            return this.installId;
        }

        public final Date getMostRecentApprovalDate() {
            return this.mostRecentApprovalDate;
        }

        public final Integer getUserStatus() {
            return this.userStatus;
        }

        public int hashCode() {
            Integer num = this.userStatus;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.ageLower;
            int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.ageUpper;
            int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Date date = this.mostRecentApprovalDate;
            int iHashCode4 = (iHashCode3 + (date == null ? 0 : date.hashCode())) * 31;
            String str = this.installId;
            return iHashCode4 + (str != null ? str.hashCode() : 0);
        }

        public final String readableUserStatus() {
            Integer num = this.userStatus;
            return (num != null && num.intValue() == 0) ? "VERIFIED" : (num != null && num.intValue() == 1) ? "SUPERVISED" : (num != null && num.intValue() == 2) ? "SUPERVISED_APPROVAL_PENDING" : (num != null && num.intValue() == 3) ? "SUPERVISED_APPROVAL_DENIED" : (num != null && num.intValue() == 4) ? Configuration.HIVE_COUNTRY_DEFAULT : String.valueOf(this.userStatus);
        }

        public final void setAgeLower(Integer num) {
            this.ageLower = num;
        }

        public final void setAgeUpper(Integer num) {
            this.ageUpper = num;
        }

        public final void setInstallId(String str) {
            this.installId = str;
        }

        public final void setMostRecentApprovalDate(Date date) {
            this.mostRecentApprovalDate = date;
        }

        public final void setUserStatus(Integer num) {
            this.userStatus = num;
        }

        public String toString() {
            return "AgeSignalsResult(userStatus=" + readableUserStatus() + '(' + this.userStatus + "), ageLower=" + this.ageLower + ", ageUpper=" + this.ageUpper + ", mostRecentApprovalDate=" + this.mostRecentApprovalDate;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(GoogleAgeSignals googleAgeSignals) {
            return HiveModuleName.INSTANCE.getAgeRange_Google_AgeSignals();
        }

        public static String readableAgeSignalsErrorCode(GoogleAgeSignals googleAgeSignals, int i) {
            if (i == -100) {
                return "INTERNAL_ERROR";
            }
            switch (i) {
                case -9:
                    return "APP_NOT_OWNED";
                case -8:
                    return "CLIENT_TRANSIENT_ERROR";
                case -7:
                    return "PLAY_SERVICES_VERSION_OUTDATED";
                case -6:
                    return "PLAY_STORE_VERSION_OUTDATED";
                case -5:
                    return "CANNOT_BIND_TO_SERVICE";
                case -4:
                    return "PLAY_SERVICES_NOT_FOUND";
                case -3:
                    return "NETWORK_ERROR";
                case -2:
                    return "PLAY_STORE_NOT_FOUND";
                case -1:
                    return "API_NOT_AVAILABLE";
                case 0:
                    return "NO_ERROR";
                default:
                    return String.valueOf(i);
            }
        }
    }

    Object checkAgeSignals(Context context, Continuation<? super Pair<Integer, AgeSignalsResult>> continuation);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    String readableAgeSignalsErrorCode(int ageSignalsErrorCode);
}
