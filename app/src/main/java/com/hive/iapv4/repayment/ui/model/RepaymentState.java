package com.hive.iapv4.repayment.ui.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: RepaymentState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/hive/iapv4/repayment/ui/model/RepaymentState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "Require", "Complete", "Impossible", "hive-iapv4-repayment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RepaymentState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RepaymentState[] $VALUES;
    public static final RepaymentState Require = new RepaymentState("Require", 0, 1);
    public static final RepaymentState Complete = new RepaymentState("Complete", 1, 2);
    public static final RepaymentState Impossible = new RepaymentState("Impossible", 2, 9);

    private static final /* synthetic */ RepaymentState[] $values() {
        return new RepaymentState[]{Require, Complete, Impossible};
    }

    public static EnumEntries<RepaymentState> getEntries() {
        return $ENTRIES;
    }

    private RepaymentState(String str, int i, int i2) {
    }

    static {
        RepaymentState[] repaymentStateArr$values = $values();
        $VALUES = repaymentStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(repaymentStateArr$values);
    }

    public static RepaymentState valueOf(String str) {
        return (RepaymentState) Enum.valueOf(RepaymentState.class, str);
    }

    public static RepaymentState[] values() {
        return (RepaymentState[]) $VALUES.clone();
    }
}
