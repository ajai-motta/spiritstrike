package com.hive.core;

import com.adxcorp.util.ADXLogUtil;
import com.applovin.sdk.AppLovinErrorCodes;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import com.hive.ResultAPI;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/hive/core/Result;", "", "code", "Lcom/hive/core/Result$Code;", "<init>", "(Lcom/hive/core/Result$Code;)V", "message", "", "(Lcom/hive/core/Result$Code;Ljava/lang/String;)V", "getCode", "()Lcom/hive/core/Result$Code;", "setCode", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "isSuccess", "", "isFailure", InAppPurchaseConstants.METHOD_TO_STRING, "component1", "copy", "equals", "other", "hashCode", "", "Code", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Result {
    private Code code;
    private String message;

    public Result() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Result copy$default(Result result, Code code, int i, Object obj) {
        if ((i & 1) != 0) {
            code = result.code;
        }
        return result.copy(code);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Code getCode() {
        return this.code;
    }

    public final Result copy(Code code) {
        Intrinsics.checkNotNullParameter(code, "code");
        return new Result(code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Result) && this.code == ((Result) other).code;
    }

    public int hashCode() {
        return this.code.hashCode();
    }

    public Result(Code code) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.code = code;
        this.message = code.name();
    }

    public /* synthetic */ Result(Code code, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Code.Success : code);
    }

    public final Code getCode() {
        return this.code;
    }

    public final void setCode(Code code) {
        Intrinsics.checkNotNullParameter(code, "<set-?>");
        this.code = code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Result(com.hive.core.Result.Code r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "code"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r1.<init>(r2)
            if (r3 == 0) goto L19
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            r0 = r0 ^ 1
            if (r0 == 0) goto L16
            goto L17
        L16:
            r3 = 0
        L17:
            if (r3 != 0) goto L1d
        L19:
            java.lang.String r3 = r2.name()
        L1d:
            r1.message = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.core.Result.<init>(com.hive.core.Result$Code, java.lang.String):void");
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Result.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/hive/core/Result$Code;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", ADXLogUtil.EVENT_LOAD_SUCCESS, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "InvalidParameters", "DecryptionFailed", "Canceled", AndroidInitializeBoldSDK.MSG_TIMEOUT, "NotConnected", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Code {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Code[] $VALUES;
        private final int value;
        public static final Code Success = new Code(ADXLogUtil.EVENT_LOAD_SUCCESS, 0, 0);
        public static final Code Failed = new Code(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, 1, -100);
        public static final Code InvalidParameters = new Code("InvalidParameters", 2, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
        public static final Code DecryptionFailed = new Code("DecryptionFailed", 3, -102);
        public static final Code Canceled = new Code("Canceled", 4, AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES);
        public static final Code Timeout = new Code(AndroidInitializeBoldSDK.MSG_TIMEOUT, 5, AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
        public static final Code NotConnected = new Code("NotConnected", 6, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        public static final Code Unknown = new Code(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, 7, -9999);

        private static final /* synthetic */ Code[] $values() {
            return new Code[]{Success, Failed, InvalidParameters, DecryptionFailed, Canceled, Timeout, NotConnected, Unknown};
        }

        public static EnumEntries<Code> getEntries() {
            return $ENTRIES;
        }

        private Code(String str, int i, int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            Code[] codeArr$values = $values();
            $VALUES = codeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(codeArr$values);
        }

        public static Code valueOf(String str) {
            return (Code) Enum.valueOf(Code.class, str);
        }

        public static Code[] values() {
            return (Code[]) $VALUES.clone();
        }
    }

    public final boolean isSuccess() {
        return this.code.getValue() >= 0;
    }

    public final boolean isFailure() {
        return !isSuccess();
    }

    public String toString() {
        return "Result(code=" + this.code + ", message=" + this.message + ')';
    }
}
