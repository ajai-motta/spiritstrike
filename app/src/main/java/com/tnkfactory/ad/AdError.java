package com.tnkfactory.ad;

import com.tnkfactory.ad.pub.d;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006!"}, d2 = {"Lcom/tnkfactory/ad/AdError;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_ERROR", "FAIL_NO_AD", "FAIL_NO_IMAGE", "FAIL_TIMEOUT", "FAIL_CANCELED", "FAIL_SHOW_BEFORE_LOAD", "FAIL_AD_FRAME", "FAIL_DUP_LOAD", "FAIL_DUP_SHOW", "FAIL_BANNER_HEIGHT_50DP", "FAIL_BANNER_HEIGHT_100DP", "FAIL_NO_PLACEMENT_ID", "FAIL_INCORRECT_PLACEMENT", "FAIL_SCREEN_ORIENTATION", "FAIL_INVALID_STATE", "FAIL_BANNER_ON_PAUSE", "FAIL_TEST_DEVICE_NOT_REGISTERED", "FAIL_FINISHED_ACTIVITY", "FAIL_AD_TYPE_INCORRECT", "FAIL_MUST_SET_REWARD_VIDEO_LISTENER", "FAIL_SYSTEM", "message", "", "getMessage", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AdError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AdError[] $VALUES;
    private final int value;
    public static final AdError NO_ERROR = new AdError("NO_ERROR", 0, 0);
    public static final AdError FAIL_NO_AD = new AdError("FAIL_NO_AD", 1, -1);
    public static final AdError FAIL_NO_IMAGE = new AdError("FAIL_NO_IMAGE", 2, -2);
    public static final AdError FAIL_TIMEOUT = new AdError("FAIL_TIMEOUT", 3, -3);
    public static final AdError FAIL_CANCELED = new AdError("FAIL_CANCELED", 4, -4);
    public static final AdError FAIL_SHOW_BEFORE_LOAD = new AdError("FAIL_SHOW_BEFORE_LOAD", 5, -5);
    public static final AdError FAIL_AD_FRAME = new AdError("FAIL_AD_FRAME", 6, -6);
    public static final AdError FAIL_DUP_LOAD = new AdError("FAIL_DUP_LOAD", 7, -7);
    public static final AdError FAIL_DUP_SHOW = new AdError("FAIL_DUP_SHOW", 8, -8);
    public static final AdError FAIL_BANNER_HEIGHT_50DP = new AdError("FAIL_BANNER_HEIGHT_50DP", 9, -21);
    public static final AdError FAIL_BANNER_HEIGHT_100DP = new AdError("FAIL_BANNER_HEIGHT_100DP", 10, -22);
    public static final AdError FAIL_NO_PLACEMENT_ID = new AdError("FAIL_NO_PLACEMENT_ID", 11, -23);
    public static final AdError FAIL_INCORRECT_PLACEMENT = new AdError("FAIL_INCORRECT_PLACEMENT", 12, -24);
    public static final AdError FAIL_SCREEN_ORIENTATION = new AdError("FAIL_SCREEN_ORIENTATION", 13, -25);
    public static final AdError FAIL_INVALID_STATE = new AdError("FAIL_INVALID_STATE", 14, -26);
    public static final AdError FAIL_BANNER_ON_PAUSE = new AdError("FAIL_BANNER_ON_PAUSE", 15, -27);
    public static final AdError FAIL_TEST_DEVICE_NOT_REGISTERED = new AdError("FAIL_TEST_DEVICE_NOT_REGISTERED", 16, -28);
    public static final AdError FAIL_FINISHED_ACTIVITY = new AdError("FAIL_FINISHED_ACTIVITY", 17, -29);
    public static final AdError FAIL_AD_TYPE_INCORRECT = new AdError("FAIL_AD_TYPE_INCORRECT", 18, -30);
    public static final AdError FAIL_MUST_SET_REWARD_VIDEO_LISTENER = new AdError("FAIL_MUST_SET_REWARD_VIDEO_LISTENER", 19, -31);
    public static final AdError FAIL_SYSTEM = new AdError("FAIL_SYSTEM", 20, -99);

    private static final /* synthetic */ AdError[] $values() {
        return new AdError[]{NO_ERROR, FAIL_NO_AD, FAIL_NO_IMAGE, FAIL_TIMEOUT, FAIL_CANCELED, FAIL_SHOW_BEFORE_LOAD, FAIL_AD_FRAME, FAIL_DUP_LOAD, FAIL_DUP_SHOW, FAIL_BANNER_HEIGHT_50DP, FAIL_BANNER_HEIGHT_100DP, FAIL_NO_PLACEMENT_ID, FAIL_INCORRECT_PLACEMENT, FAIL_SCREEN_ORIENTATION, FAIL_INVALID_STATE, FAIL_BANNER_ON_PAUSE, FAIL_TEST_DEVICE_NOT_REGISTERED, FAIL_FINISHED_ACTIVITY, FAIL_AD_TYPE_INCORRECT, FAIL_MUST_SET_REWARD_VIDEO_LISTENER, FAIL_SYSTEM};
    }

    static {
        AdError[] adErrorArr$values = $values();
        $VALUES = adErrorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(adErrorArr$values);
    }

    private AdError(String str, int i, int i2) {
        this.value = i2;
    }

    public static EnumEntries<AdError> getEntries() {
        return $ENTRIES;
    }

    public static AdError valueOf(String str) {
        return (AdError) Enum.valueOf(AdError.class, str);
    }

    public static AdError[] values() {
        return (AdError[]) $VALUES.clone();
    }

    public final String getMessage() {
        switch (d.f3119a[ordinal()]) {
            case 1:
                return "Success.";
            case 2:
                return "No ad available.";
            case 3:
                return "Ad creative not available.";
            case 4:
                return "Ad arrived too late.";
            case 5:
                return "Ad requested too frequently.";
            case 6:
                return "Ad show called before ad is loaded.";
            case 7:
                return "Cannot build ad layout.";
            case 8:
                return "Ad load called while in loading or showing state.";
            case 9:
                return "Ad show called while ad is showing";
            case 10:
                return "Height of banner is too small(<50dp).";
            case 11:
                return "Height of banner is too small(<100dp).";
            case 12:
                return "Placement ID is not specified.";
            case 13:
                return "Publisher Id or Placement Id is not registered.";
            case 14:
                return "Ad orientation is not matched with screen.";
            case 15:
                return "AdItem is not initialized or destroyed.";
            case 16:
                return "Test device not registered.";
            case 17:
                return "Trying to display using finished Activity.";
            case 18:
            default:
                return "System error.";
        }
    }

    public final int getValue() {
        return this.value;
    }
}
